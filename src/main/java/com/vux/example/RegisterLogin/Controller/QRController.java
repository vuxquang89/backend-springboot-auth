package com.vux.example.RegisterLogin.Controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.vux.example.RegisterLogin.Converter.QRConvert;
import com.vux.example.RegisterLogin.Entity.QRImageEntity;
import com.vux.example.RegisterLogin.Entity.QRInfoEntity;
import com.vux.example.RegisterLogin.Jwt.JwtTokenUtil;
import com.vux.example.RegisterLogin.Payload.Request.QRInfoRequest;
import com.vux.example.RegisterLogin.Payload.Response.ResponseMessage;
import com.vux.example.RegisterLogin.Service.QRImageService;
import com.vux.example.RegisterLogin.Service.QRInfoService;
import com.vux.example.RegisterLogin.Util.FileUploadUtil;

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
	public ResponseEntity<?> getData(){
		System.out.println("get QR Info");
		List<QRInfoEntity> qrInfos = qrInfoService.getAll();
		
		return ResponseEntity.ok(qrInfos);
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
					String fileName = FileUploadUtil.uploadFile("upload/"+path, fileNameUpload, file);
					qrImageService.save(new QRImageEntity(fileName, "upload/"+path, saveQR));
					message = "Uploaded the file successfully : " + fileName;
					return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
				}
			}catch (IOException e) {
				System.out.println(e);
				message = "Could not upload";
				return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
			}
		}
		message = "Could not upload";
		return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
	}
}
