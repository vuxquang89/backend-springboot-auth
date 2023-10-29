package com.vux.example.RegisterLogin.Controller;

import java.time.LocalDate;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vux.example.RegisterLogin.Converter.HubDetailConvert;
import com.vux.example.RegisterLogin.Entity.HubDevice.DeviceEntity;
import com.vux.example.RegisterLogin.Entity.HubDevice.HubDetailEntity;
import com.vux.example.RegisterLogin.Entity.HubDevice.HubEntity;
import com.vux.example.RegisterLogin.Entity.HubDevice.MaintenanceHistoryEntity;
import com.vux.example.RegisterLogin.Payload.Request.HubDetailRequest;
import com.vux.example.RegisterLogin.Payload.Response.HubDetailResponse;
import com.vux.example.RegisterLogin.Service.DeviceService;
import com.vux.example.RegisterLogin.Service.HubDetailService;
import com.vux.example.RegisterLogin.Service.HubService;
import com.vux.example.RegisterLogin.Service.MaintenanceHistoryService;

import ch.qos.logback.core.joran.conditional.IfAction;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class HubDetailController {

	@Autowired
	private HubDetailService hubDetailService;
	@Autowired
	private HubService hubService;
	@Autowired
	private DeviceService deviceService;
	@Autowired
	private MaintenanceHistoryService mainHistoryService;
	@Autowired
	private HubDetailConvert hubDetailConvert;
	
	@GetMapping("/hub/detail")
	public ResponseEntity<?> getAll(){
		List<HubDetailResponse> hubDetailResponses = hubDetailService.getAll();
		return ResponseEntity.status(HttpStatus.OK).body(hubDetailResponses);
	}
	
	@PostMapping("/hub/detail")
	public ResponseEntity<?> saveDeviceForHubDetail(@RequestBody HubDetailRequest request){
		HubEntity hubEntity = hubService.findByHubId(request.getHubId());
		DeviceEntity deviceEntity = deviceService.findById(request.getDeviceId()).orElse(null);
		
		if(hubEntity != null && deviceEntity != null) {
			HubDetailEntity hubDetailEntity = hubDetailConvert.toEntity(request);
			hubDetailEntity.setDevice(deviceEntity);
			hubDetailEntity.setHubEntity(hubEntity);
			hubDetailEntity.setLatestMaintenanceTime(LocalDate.now());
			hubDetailEntity = hubDetailService.save(hubDetailEntity);
			
			
			MaintenanceHistoryEntity maintenanceHistoryEntity = new MaintenanceHistoryEntity();
			maintenanceHistoryEntity.setHubDetail(hubDetailEntity);
			maintenanceHistoryEntity.setMaintenanceNote("Thêm mới thiết bị");
			maintenanceHistoryEntity.setMaintenanceTime(LocalDate.now());
			mainHistoryService.save(maintenanceHistoryEntity);
			
			HubDetailResponse response = hubDetailConvert.toResponse(hubDetailEntity);
			return ResponseEntity.status(HttpStatus.OK).body(response);
		}
		
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("NOT");
	}
	
	@DeleteMapping("/hub/detail/{hubDetailId}")
	public ResponseEntity<?> delete(@PathVariable("hubDetailId") Long hubDetailId){
		boolean result = hubDetailService.delete(hubDetailId);
		return ResponseEntity.status(HttpStatus.OK).body(result);
	}
}
