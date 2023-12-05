package com.vux.example.RegisterLogin.Controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vux.example.RegisterLogin.Converter.MaintenanceHistoryConvert;
import com.vux.example.RegisterLogin.Entity.HubDevice.HubDetailEntity;
import com.vux.example.RegisterLogin.Entity.HubDevice.ImageAfterMaintenanceHistory;
import com.vux.example.RegisterLogin.Entity.HubDevice.ImageBeforeMaintenanceHistory;
import com.vux.example.RegisterLogin.Entity.HubDevice.MaintenanceHistoryEntity;
import com.vux.example.RegisterLogin.Exception.BaseException;
import com.vux.example.RegisterLogin.Jwt.JwtTokenUtil;
import com.vux.example.RegisterLogin.Payload.Request.MaintenanceHistoryRequest;
import com.vux.example.RegisterLogin.Payload.Response.MaintenanceHistoryResponse;
import com.vux.example.RegisterLogin.Payload.Response.MaintenanceHistoryResponseStatus;
import com.vux.example.RegisterLogin.Service.HubDetailService;
import com.vux.example.RegisterLogin.Service.ImageAfterMaintenanceHistoryService;
import com.vux.example.RegisterLogin.Service.ImageBeforeMaintenanceHistoryService;
import com.vux.example.RegisterLogin.Service.MaintenanceHistoryService;
import com.vux.example.RegisterLogin.Util.DateConvert;
import com.vux.example.RegisterLogin.Util.FileUploadUtil;
import com.vux.example.RegisterLogin.Util.LocalDateConvert;
import com.vux.example.RegisterLogin.Util.ThumbnailUtil;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class MaintenanceHistoryController {
	
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	@Autowired
	private MaintenanceHistoryConvert maintenanceHistoryConvert;
	@Autowired
	private MaintenanceHistoryService maintenanceHistoryService;
	@Autowired
	private HubDetailService hubDetailService;
	
	@Autowired
	private ImageAfterMaintenanceHistoryService imageAfterMaintenanceHistoryService;
	@Autowired
	private ImageBeforeMaintenanceHistoryService imageBeforeMaintenanceHistoryService;
	

	@GetMapping("/hub/device/maintenancehistory")
	public ResponseEntity<?> getAll(){
		
		return ResponseEntity.status(HttpStatus.OK).body("get maintenanceHistory");
	}
	
	@GetMapping("/hub/device/maintenancehistory/{hubDetailId}")
	public ResponseEntity<?> getByDeviceId(@PathVariable("hubDetailId") Long hubDetailId){
		List<MaintenanceHistoryResponse> responses = maintenanceHistoryService.findByHubDetailId(hubDetailId);
		return ResponseEntity.status(HttpStatus.OK).body(responses);
	}
	
	/**
	 * edit maintenance history
	 * @param hubDetailId
	 * @param maintenanceRequest
	 * @return
	 */
	@PutMapping("/hub/device/maintenancehistory/{hubDetailId}")	
	public ResponseEntity<?> edit(
			@PathVariable("hubDetailId") Long hubDetailId,
			@ModelAttribute MaintenanceHistoryRequest maintenanceRequest){
		MaintenanceHistoryEntity entity = maintenanceHistoryService.findById(hubDetailId).orElse(null);
		
		MaintenanceHistoryResponseStatus responseStatus = new MaintenanceHistoryResponseStatus();
		responseStatus.setStatus(100);
		if(entity != null) {
			String date = LocalDateConvert.stringToDateString(maintenanceRequest.getMaintenanceTime());
			entity.setMaintenanceNote(maintenanceRequest.getMaintenanceNote());
			entity.setMaintenanceTime(LocalDate.parse(date));
			entity = maintenanceHistoryService.save(entity);
			
			try {
				String path = "images/hubs/hub_detail_" + hubDetailId + "/maintenance_history/" + entity.getId() + "/" + maintenanceRequest.getMaintenanceTime().replace("/", "-");
				if(maintenanceRequest.getImageBeforeMaintenanceFiles() != null 
						&& maintenanceRequest.getImageBeforeMaintenanceFiles().length > 0) {
					
					
					List<String> fileNames = FileUploadUtil.uploadMultiFile(Arrays.asList(maintenanceRequest.getImageBeforeMaintenanceFiles()), path + "/before");
//					List<ImageBeforeMaintenanceHistory> imgeBefores = new ArrayList<ImageBeforeMaintenanceHistory>();
					for(String fileName : fileNames) {
						String fileNameResize = ThumbnailUtil.resize100x160("upload/"+path+"/before", fileName);
//						qrImageService.save(new QRImageEntity(fileName, fileNameResize, "upload/"+path, saveQR));
						entity.addImageBeforeMaintenanceHistory(imageBeforeMaintenanceHistoryService.save(new ImageBeforeMaintenanceHistory(fileName, "upload/"+path+"/before", fileNameResize, entity)));
						
					}
				}
				
				if(maintenanceRequest.getImageAfterMaintenanceFiles() != null 
						&& maintenanceRequest.getImageAfterMaintenanceFiles().length > 0) {
//					String path = "images/hub_detail_" + maintenanceHistoryRequest.getHubDetailId() + "/maintenance_history/" + entity.getId() + "/" + maintenanceHistoryRequest.getMaintenanceTime();
					
					List<String> fileNames = FileUploadUtil.uploadMultiFile(Arrays.asList(maintenanceRequest.getImageAfterMaintenanceFiles()), path + "/after");
//					List<ImageAfterMaintenanceHistory> imageAfters = new ArrayList<ImageAfterMaintenanceHistory>();
					for(String fileName : fileNames) {
						String fileNameResize = ThumbnailUtil.resize100x160("upload/"+path+"/after", fileName);
						entity.addImageAfterMaintenanceHistory(imageAfterMaintenanceHistoryService.save(new ImageAfterMaintenanceHistory(fileName, "upload/"+path+"/after", fileNameResize, entity)));
					}
				}
				
				
			} catch (IOException | BaseException e) {
				System.out.println("Upload edit errror");
				System.out.println(e);
			}
			
			
			MaintenanceHistoryResponse response = maintenanceHistoryConvert.toResponse(entity);
			responseStatus.setResponse(response);
		}else {
			responseStatus.setStatus(101);
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(responseStatus);
	}
	
	@GetMapping("/hub/device/maintenancemistory/member")
	public ResponseEntity<?> getByUsername(){
		
		return ResponseEntity.status(HttpStatus.OK).body("get maintenanceHistory");
	}
	
	@DeleteMapping("/hub/device/maintenancehistory/{maintenanceId}")
	public ResponseEntity<?> delete(@PathVariable("maintenanceId") Long maintenanceId){
//		MaintenanceHistoryEntity entity = maintenanceHistoryService.findById(maintenanceId).orElse(null);
//		boolean result = false;
//		if(entity != null) {
//			result = maintenanceHistoryService.delete(maintenanceId);
//		}
		boolean result = maintenanceHistoryService.delete(maintenanceId);
		
		return ResponseEntity.status(HttpStatus.OK).body(result);
		
		
	}
	
	@PostMapping("/hub/device/maintenancehistory")
//	@RequestMapping(value = "/hub/device/maintenancehistory" , method = RequestMethod.POST, consumes = { "multipart/form-data" })
	public ResponseEntity<?> save(
//			@RequestParam("files") MultipartFile[] files,
			@ModelAttribute MaintenanceHistoryRequest maintenanceHistoryRequest,
			HttpServletRequest request){
		String token = jwtTokenUtil.getToken(request);
		String username = jwtTokenUtil.getUserNameFromJwtSubject(token);
		
		String dateRequestString = LocalDateConvert.stringToDateString(maintenanceHistoryRequest.getMaintenanceTime());
		maintenanceHistoryRequest.setMaintenanceTime(dateRequestString);
		
		MaintenanceHistoryResponseStatus responseStatus = new MaintenanceHistoryResponseStatus();
		responseStatus.setStatus(101);
		
		if(!DateConvert.isAfter(maintenanceHistoryRequest.getMaintenanceTime())) {//ngay chon nho hon ngay hien tai
			
			HubDetailEntity hubDetailEntity = hubDetailService.findById(maintenanceHistoryRequest.getHubDetailId()).orElse(null);
			
			if(hubDetailEntity != null) {	
				Long countExitsMaintenanceLong = maintenanceHistoryService.countMaintenanceByTime(
						maintenanceHistoryRequest.getHubDetailId(), 
						maintenanceHistoryRequest.getMaintenanceTime());
				
				if(countExitsMaintenanceLong > 0) {
					responseStatus.setMessage("Ngày bảo dưỡng đã tồn tại");
				}else {
					responseStatus.setStatus(100);
					
					MaintenanceHistoryEntity entity = maintenanceHistoryConvert.toEntity(maintenanceHistoryRequest);
					entity.setHubDetail(hubDetailEntity);
					entity = maintenanceHistoryService.save(entity);
					
					hubDetailEntity.setLatestMaintenanceTime(entity.getMaintenanceTime());
					hubDetailService.save(hubDetailEntity);
					hubDetailEntity = hubDetailService.findById(hubDetailEntity.getId()).get();
					entity.setHubDetail(hubDetailEntity);
					
					
					try {
						String path = "images/hubs/hub_detail_" + maintenanceHistoryRequest.getHubDetailId() + "/maintenance_history/" + entity.getId() + "/" + maintenanceHistoryRequest.getMaintenanceTime().replace("/", "-");
						if(maintenanceHistoryRequest.getImageBeforeMaintenanceFiles() != null 
								&& maintenanceHistoryRequest.getImageBeforeMaintenanceFiles().length > 0) {
							
		//					if (!file.getContentType().equals("image/jpeg") && !file.getContentType().equals("image/png")) {
		//					      throw new FileNotSupportedException("only .jpeg and .png images are " + "supported");
		//					    }
							
							List<String> fileNames = FileUploadUtil.uploadMultiFile(Arrays.asList(maintenanceHistoryRequest.getImageBeforeMaintenanceFiles()), path + "/before");
							List<ImageBeforeMaintenanceHistory> imgeBefores = new ArrayList<ImageBeforeMaintenanceHistory>();
							for(String fileName : fileNames) {
								String fileNameResize = ThumbnailUtil.resize100x160("upload/"+path+"/before", fileName);
		//						qrImageService.save(new QRImageEntity(fileName, fileNameResize, "upload/"+path, saveQR));
								imgeBefores.add(imageBeforeMaintenanceHistoryService.save(new ImageBeforeMaintenanceHistory(fileName, "upload/"+path+"/before", fileNameResize, entity)));
								
							}
							entity.setImageBeforeMaintenanceHistories(imgeBefores);
						}
						
						if(maintenanceHistoryRequest.getImageAfterMaintenanceFiles() != null 
								&& maintenanceHistoryRequest.getImageAfterMaintenanceFiles().length > 0) {
		//					String path = "images/hub_detail_" + maintenanceHistoryRequest.getHubDetailId() + "/maintenance_history/" + entity.getId() + "/" + maintenanceHistoryRequest.getMaintenanceTime();
							
							List<String> fileNames = FileUploadUtil.uploadMultiFile(Arrays.asList(maintenanceHistoryRequest.getImageAfterMaintenanceFiles()), path + "/after");
							List<ImageAfterMaintenanceHistory> imageAfters = new ArrayList<ImageAfterMaintenanceHistory>();
							for(String fileName : fileNames) {
								String fileNameResize = ThumbnailUtil.resize100x160("upload/"+path+"/after", fileName);
								imageAfters.add(imageAfterMaintenanceHistoryService.save(new ImageAfterMaintenanceHistory(fileName, "upload/"+path+"/after", fileNameResize, entity)));
							}
							entity.setImageAfterMaintenanceHistories(imageAfters);
						}
						
						
					} catch (IOException | BaseException e) {
						System.out.println("Upload errror");
						System.out.println(e);
					}
					
					responseStatus.setResponse(maintenanceHistoryConvert.toResponse(entity));
					
				}
				
			}else {
				responseStatus.setMessage("Không tồn tại");
			}
		}else {
			responseStatus.setMessage("Ngày bảo dưỡng không được nhỏ hơn ngày hiện tại");
		}
		
		
		return ResponseEntity.status(HttpStatus.OK).body(responseStatus);
		
		
	}
	
	/**
	 * delete image maintenance history
	 * @param status
	 * @param imageHistoryId
	 * @return
	 */
	@DeleteMapping("/hub/device/maintenancehistory/image/{status}/{imageHistoryId}")
	public ResponseEntity<?> deleteImageMaintenanceHistory(
			@PathVariable("status") String status,
			@PathVariable("imageHistoryId") Long imageHistoryId){
		MaintenanceHistoryResponseStatus responseStatus = new MaintenanceHistoryResponseStatus();
		responseStatus.setStatus(101);
		switch (status) {
		case "after":
			ImageAfterMaintenanceHistory imageAfter = imageAfterMaintenanceHistoryService.findById(imageHistoryId).orElse(null);
			if(imageAfter != null) {
				imageAfterMaintenanceHistoryService.delete(imageAfter);
				responseStatus.setStatus(100);
			}
			break;

		case "before":
			ImageBeforeMaintenanceHistory imageBefore = imageBeforeMaintenanceHistoryService.findById(imageHistoryId).orElse(null);
			if(imageBefore != null) {
				imageBeforeMaintenanceHistoryService.delete(imageBefore);
				responseStatus.setStatus(100);
			}
			break;
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(responseStatus);
	}
	
//	@PostMapping("/hub/device/maintenancehistory")
//	public ResponseEntity<?> save(
//			@RequestBody MaintenanceHistoryRequest maintenanceHistoryRequest,
//			HttpServletRequest request){
//		String token = jwtTokenUtil.getToken(request);
//		String username = jwtTokenUtil.getUserNameFromJwtSubject(token);
//		
//		
//		HubDetailEntity hubDetailEntity = hubDetailService.findById(maintenanceHistoryRequest.getHubDetailId()).orElse(null);
//		if(hubDetailEntity != null) {			
//			MaintenanceHistoryEntity entity = maintenanceHistoryConvert.toEntity(maintenanceHistoryRequest);
//			entity.setHubDetail(hubDetailEntity);
//			entity = maintenanceHistoryService.save(entity);
//			
//			hubDetailEntity.setLatestMaintenanceTime(entity.getMaintenanceTime());
//			hubDetailService.save(hubDetailEntity);
//			hubDetailEntity = hubDetailService.findById(hubDetailEntity.getId()).get();
//			entity.setHubDetail(hubDetailEntity);
//			return ResponseEntity.status(HttpStatus.OK).body(maintenanceHistoryConvert.toResponse(entity));
//		}
//		
//		
//		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("NOT");
//	}
}
