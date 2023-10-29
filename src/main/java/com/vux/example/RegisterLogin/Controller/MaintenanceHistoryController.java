package com.vux.example.RegisterLogin.Controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vux.example.RegisterLogin.Converter.MaintenanceHistoryConvert;
import com.vux.example.RegisterLogin.Converter.QRConvert;
import com.vux.example.RegisterLogin.Entity.HubDevice.HubDetailEntity;
import com.vux.example.RegisterLogin.Entity.HubDevice.MaintenanceHistoryEntity;
import com.vux.example.RegisterLogin.Jwt.JwtTokenUtil;
import com.vux.example.RegisterLogin.Payload.Request.MaintenanceHistoryRequest;
import com.vux.example.RegisterLogin.Service.HubDetailService;
import com.vux.example.RegisterLogin.Service.MaintenanceHistoryService;


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

	@GetMapping("/hub/device/maintenancemistory")
	public ResponseEntity<?> getAll(){
		
		return ResponseEntity.status(HttpStatus.OK).body("get maintenanceHistory");
	}
	
	@GetMapping("/hub/device/maintenancemistory/member")
	public ResponseEntity<?> getByUsername(){
		
		return ResponseEntity.status(HttpStatus.OK).body("get maintenanceHistory");
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
			
			hubDetailEntity.setLatestMaintenanceTime(maintenanceHistoryRequest.getMaintenanceTime());
			hubDetailService.save(hubDetailEntity);
			return ResponseEntity.status(HttpStatus.OK).body(maintenanceHistoryConvert.toResponse(entity));
		}
		
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("NOT");
	}
}
