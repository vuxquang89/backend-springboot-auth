package com.vux.example.RegisterLogin.Controller;

import java.time.LocalDate;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vux.example.RegisterLogin.Converter.MaintenanceHistoryConvert;
import com.vux.example.RegisterLogin.Converter.QRConvert;
import com.vux.example.RegisterLogin.Entity.HubDevice.HubDetailEntity;
import com.vux.example.RegisterLogin.Entity.HubDevice.MaintenanceHistoryEntity;
import com.vux.example.RegisterLogin.Jwt.JwtTokenUtil;
import com.vux.example.RegisterLogin.Payload.Request.MaintenanceHistoryRequest;
import com.vux.example.RegisterLogin.Payload.Response.MaintenanceHistoryResponse;
import com.vux.example.RegisterLogin.Payload.Response.MaintenanceHistoryResponseStatus;
import com.vux.example.RegisterLogin.Service.HubDetailService;
import com.vux.example.RegisterLogin.Service.MaintenanceHistoryService;
import com.vux.example.RegisterLogin.Util.LocalDateConvert;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class MaintenanceHistoryController {
	
	@Autowired
	private QRConvert qrConvert;
	
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	@Autowired
	private MaintenanceHistoryConvert maintenanceHistoryConvert;
	@Autowired
	private MaintenanceHistoryService maintenanceHistoryService;
	@Autowired
	private HubDetailService hubDetailService;

	@GetMapping("/hub/device/maintenancehistory")
	public ResponseEntity<?> getAll(){
		
		return ResponseEntity.status(HttpStatus.OK).body("get maintenanceHistory");
	}
	
	@GetMapping("/hub/device/maintenancehistory/{hubDetailId}")
	public ResponseEntity<?> getByDeviceId(@PathVariable("hubDetailId") Long hubDetailId){
		List<MaintenanceHistoryResponse> responses = maintenanceHistoryService.findByHubDetailId(hubDetailId);
		return ResponseEntity.status(HttpStatus.OK).body(responses);
	}
	
	@PutMapping("/hub/device/maintenancehistory/{hubDetailId}")	
	public ResponseEntity<?> edit(@PathVariable("hubDetailId") Long hubDetailId,
			@RequestBody MaintenanceHistoryRequest maintenanceRequest){
		MaintenanceHistoryEntity entity = maintenanceHistoryService.findById(hubDetailId).orElse(null);
		
		MaintenanceHistoryResponseStatus responseStatus = new MaintenanceHistoryResponseStatus();
		responseStatus.setStatus(100);
		if(entity != null) {
			String date = LocalDateConvert.stringToDateString(maintenanceRequest.getMaintenanceTime());
			entity.setMaintenanceNote(maintenanceRequest.getMaintenanceNote());
			entity.setMaintenanceTime(LocalDate.parse(date));
			entity = maintenanceHistoryService.save(entity);
			
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
	public ResponseEntity<?> save(
			@RequestBody MaintenanceHistoryRequest maintenanceHistoryRequest,
			HttpServletRequest request){
		String token = jwtTokenUtil.getToken(request);
		String username = jwtTokenUtil.getUserNameFromJwtSubject(token);
		
		
		HubDetailEntity hubDetailEntity = hubDetailService.findById(maintenanceHistoryRequest.getHubDetailId()).orElse(null);
		if(hubDetailEntity != null) {			
			MaintenanceHistoryEntity entity = maintenanceHistoryConvert.toEntity(maintenanceHistoryRequest);
			entity.setHubDetail(hubDetailEntity);
			entity = maintenanceHistoryService.save(entity);
			
			hubDetailEntity.setLatestMaintenanceTime(entity.getMaintenanceTime());
			hubDetailService.save(hubDetailEntity);
			hubDetailEntity = hubDetailService.findById(hubDetailEntity.getId()).get();
			entity.setHubDetail(hubDetailEntity);
			return ResponseEntity.status(HttpStatus.OK).body(maintenanceHistoryConvert.toResponse(entity));
		}
		
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("NOT");
	}
}
