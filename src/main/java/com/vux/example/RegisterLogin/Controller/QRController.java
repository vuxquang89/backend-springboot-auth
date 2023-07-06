package com.vux.example.RegisterLogin.Controller;

import java.io.IOException;
import java.util.ArrayList;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.vux.example.RegisterLogin.Converter.QRConvert;
import com.vux.example.RegisterLogin.Entity.QRImageEntity;
import com.vux.example.RegisterLogin.Entity.QRInfoEntity;
import com.vux.example.RegisterLogin.Exception.BaseException;
import com.vux.example.RegisterLogin.Jwt.JwtTokenUtil;
import com.vux.example.RegisterLogin.Payload.Request.QRInfoRequest;
import com.vux.example.RegisterLogin.Payload.Request.QRItemRequest;
import com.vux.example.RegisterLogin.Payload.Response.QRResponse;
import com.vux.example.RegisterLogin.Payload.Response.ResponseMessage;
import com.vux.example.RegisterLogin.Service.QRImageService;
import com.vux.example.RegisterLogin.Service.QRInfoService;
import com.vux.example.RegisterLogin.Util.FileUploadUtil;
import com.vux.example.RegisterLogin.Util.ThumbnailUtil;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class QRController {
	
	@Autowired
	private QRInfoService qrInfoService;
	
	@Autowired
	private QRImageService qrImageService;
	
	@Autowired
	private QRConvert qrConvert;
	
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	

	@GetMapping("/qr")
	public ResponseEntity<?> getData(HttpServletRequest request){
		String token = jwtTokenUtil.getToken(request);
		String username = jwtTokenUtil.getUserNameFromJwtSubject(token);
		
		System.out.println("get QR Info");
		List<QRInfoEntity> qrInfos = qrInfoService.getAllByUsername(username);
		List<QRResponse> result = new ArrayList<QRResponse>();
		for(QRInfoEntity entity : qrInfos) {
			QRResponse response = qrConvert.toResponse(entity);
			result.add(response);
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(result);
		
	}
	
	@GetMapping("/qr/{id}")
	public ResponseEntity<?> getDataById(
			@PathVariable Long id){
		
		System.out.println("get QR Info by id: " + id);
		QRInfoEntity qrInfoEntity = qrInfoService.getItemById(id).orElseThrow(null);
		QRResponse response = qrConvert.toResponse(qrInfoEntity);
		return ResponseEntity.status(HttpStatus.OK).body(response);
		
	}
	
	@DeleteMapping("/qr")
	public ResponseEntity<?> deleteById(
			@RequestBody QRItemRequest request){
		
		String message = "";
		boolean isDelete = qrInfoService.delete(request.getId(), request.getUri());
		if(isDelete) {
			message = "Delete the file successfully";
			return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
		}
		message = "The file does not exits!";
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseMessage(message));
		
	}
	
	@PostMapping("/qr")
	//public ResponseEntity<?> saveData(@Valid @RequestBody QRInfoRequest qrRequest){
	//public ResponseEntity<?> saveData(@RequestParam("file")MultipartFile file){
	public ResponseEntity<?> saveData(
			@RequestParam("file") MultipartFile file, 
			@ModelAttribute QRInfoRequest qrInfoRequest,
			HttpServletRequest request){	
		
		String token = jwtTokenUtil.getToken(request);
		String username = jwtTokenUtil.getUserNameFromJwtSubject(token);
		
		QRInfoEntity qrInfoEntity = qrConvert.toEntity(qrInfoRequest);
		QRInfoEntity saveQR = qrInfoService.save(qrInfoEntity);
		String message = "";
		if(saveQR != null) {
			
			try {
				if(file.getName() != null) {
					String path = "images/" + username;
					/*
					List<String> fileNames = FileUploadUtil.uploadMultiFile(Arrays.asList(qrInfoRequest.getFiles()), path);
					for(String fileName : fileNames) {
						qrImageService.save(new QRImageEntity(fileName, "upload/"+path, saveQR));
					}
					*/
					String fileNameUpload = StringUtils.cleanPath(file.getOriginalFilename());
					String fileName = FileUploadUtil.uploadFile(path, fileNameUpload, file);
					String fileNameResize = ThumbnailUtil.resize100x160("upload/"+path, fileName);
					qrImageService.save(new QRImageEntity(fileName, fileNameResize, "upload/"+path, saveQR));
					message = "Uploaded the file successfully : " + fileName;
					return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
				}
			}catch (IOException | BaseException e) {
				System.out.println(e);
				message = "Could not upload";
				return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
			}
		}
		message = "Could not upload";
		return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
	}
}
