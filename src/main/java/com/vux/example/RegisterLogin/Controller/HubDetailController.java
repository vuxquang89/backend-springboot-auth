package com.vux.example.RegisterLogin.Controller;

import java.time.LocalDate;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vux.example.RegisterLogin.Converter.HubDetailConvert;
import com.vux.example.RegisterLogin.Entity.HubDevice.DeviceEntity;
import com.vux.example.RegisterLogin.Entity.HubDevice.HistoryOperationDeviceEntity;
import com.vux.example.RegisterLogin.Entity.HubDevice.HubDetailEntity;
import com.vux.example.RegisterLogin.Entity.HubDevice.HubEntity;
import com.vux.example.RegisterLogin.Entity.HubDevice.MaintenanceHistoryEntity;
import com.vux.example.RegisterLogin.Jwt.JwtTokenUtil;
import com.vux.example.RegisterLogin.Payload.Request.HubDetailRequest;
import com.vux.example.RegisterLogin.Payload.Response.HistoryOperationDeviceResponse;
import com.vux.example.RegisterLogin.Payload.Response.HubDetailAlarmResponse;
import com.vux.example.RegisterLogin.Payload.Response.HubDetailResponse;
import com.vux.example.RegisterLogin.Payload.Response.HubDetailResponseStatus;
import com.vux.example.RegisterLogin.Service.DeviceService;
import com.vux.example.RegisterLogin.Service.HistoryOperationDeviceService;
import com.vux.example.RegisterLogin.Service.HubDetailService;
import com.vux.example.RegisterLogin.Service.HubService;
import com.vux.example.RegisterLogin.Service.MaintenanceHistoryService;


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
	private HistoryOperationDeviceService historyOperationDeviceService;
	@Autowired
	private HubDetailConvert hubDetailConvert;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	
	@GetMapping("/hub/detail")
	public ResponseEntity<?> getAll(){
		List<HubDetailResponse> hubDetailResponses = hubDetailService.getAll();
		return ResponseEntity.status(HttpStatus.OK).body(hubDetailResponses);
	}
	
	@GetMapping("/hub/manager/detail")
	public ResponseEntity<?> getMangerAll(HttpServletRequest request){
		String token = jwtTokenUtil.getToken(request);
		String username = jwtTokenUtil.getUserNameFromJwtSubject(token);
		List<HubDetailResponse> hubDetailResponses = hubDetailService.getAllManager(username);
		return ResponseEntity.status(HttpStatus.OK).body(hubDetailResponses);
	}
	
	@GetMapping("/hub/detail/search/{keysearch}")
	public ResponseEntity<?> findSearch(@PathVariable("keysearch") String keyword){
		List<HubDetailResponse> hubDetailResponses = hubDetailService.findAllWithKeySearch(keyword);
		return ResponseEntity.status(HttpStatus.OK).body(hubDetailResponses);
	}
	
	@GetMapping("/hub/manager/detail/search/{keysearch}")
	public ResponseEntity<?> findSearchManager(
			@PathVariable("keysearch") String keyword,
			HttpServletRequest request){
		String token = jwtTokenUtil.getToken(request);
		String username = jwtTokenUtil.getUserNameFromJwtSubject(token);
		
		List<HubDetailResponse> hubDetailResponses = hubDetailService.findAllWithKeySearch(keyword, username);
		return ResponseEntity.status(HttpStatus.OK).body(hubDetailResponses);
	}
	
	@GetMapping("/user/hub/detail")
	public ResponseEntity<?> getAllUser(){
//		List<HubDetailUserResponse> hubDetailUserResponses = hubDetailService.getAllUser();
//		return ResponseEntity.status(HttpStatus.OK).body(hubDetailUserResponses);
		List<HubDetailResponse> hubDetailResponses = hubDetailService.getAll();
		return ResponseEntity.status(HttpStatus.OK).body(hubDetailResponses);
	}
	
	@GetMapping("/hub/detail/{hubDetailId}")
	public ResponseEntity<?> getHubDetailById(@PathVariable("hubDetailId") Long hubDetailId){
		HubDetailEntity entity = hubDetailService.findById(hubDetailId).orElse(null);
		HubDetailResponseStatus responseStatus = new HubDetailResponseStatus();
		responseStatus.setStatus(100);
		if(entity != null) {
			HubDetailResponse response = hubDetailConvert.toResponse(entity);
			responseStatus.setResponse(response);
		}else {
			responseStatus.setStatus(101);
		}
		return ResponseEntity.status(HttpStatus.OK).body(responseStatus);
	}
	
	/**
	 * add new device for hub
	 * @param request
	 * @return
	 */
	@PostMapping("/hub/detail")
	public ResponseEntity<?> saveDeviceForHubDetail(@RequestBody HubDetailRequest request){
		HubEntity hubEntity = hubService.findByHubId(request.getHubId());
		DeviceEntity deviceEntity = deviceService.findById(request.getDeviceId()).orElse(null);
		
		if(hubEntity != null && deviceEntity != null) {
			HubDetailEntity hubDetailEntity = hubDetailConvert.toEntity(request);
			hubDetailEntity.setDevice(deviceEntity);
			hubDetailEntity.setHubEntity(hubEntity);
			hubDetailEntity.setLatestMaintenanceTime(LocalDate.now());
			hubDetailEntity.setDateNow(LocalDate.now());
			hubDetailEntity = hubDetailService.save(hubDetailEntity);
			
			
			MaintenanceHistoryEntity maintenanceHistoryEntity = new MaintenanceHistoryEntity();
			maintenanceHistoryEntity.setHubDetail(hubDetailEntity);
			maintenanceHistoryEntity.setMaintenanceNote("Thêm mới thiết bị");
			maintenanceHistoryEntity.setMaintenanceTime(LocalDate.now());
			mainHistoryService.save(maintenanceHistoryEntity);
			
			HistoryOperationDeviceEntity historyOperationDevice = new HistoryOperationDeviceEntity();
			historyOperationDevice.setAction("THÊM MỚI");
			historyOperationDevice.setContent("Được tạo mới tại hub " + hubEntity.getHubName());
			historyOperationDevice.setHubDetail(hubDetailEntity);
			historyOperationDeviceService.save(historyOperationDevice);
			
			HubDetailResponse response = hubDetailConvert.toResponse(hubDetailEntity);
			return ResponseEntity.status(HttpStatus.OK).body(response);
		}
		
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("NOT");
	}
	
	/**
	 * edit info device
	 * @param hubDetailId
	 * @param request
	 * @return
	 */
	@PutMapping("/hub/detail/{hubDetailId}")
	public ResponseEntity<?> editDeviceForHubDetail(
			@PathVariable("hubDetailId") Long hubDetailId,
			@RequestBody HubDetailRequest request){
		
		HubDetailEntity entity = hubDetailService.findById(hubDetailId).orElse(null);
		
		if(entity != null) {
			entity = hubDetailConvert.toUpdateEntity(entity, request);
			
			entity = hubDetailService.save(entity);
			
			HistoryOperationDeviceEntity historyOperationDevice = new HistoryOperationDeviceEntity();
			historyOperationDevice.setAction("CHỈNH SỬA");
			historyOperationDevice.setContent("Chỉnh sửa thông tin thiết bị");
			historyOperationDevice.setHubDetail(entity);
			historyOperationDeviceService.save(historyOperationDevice);
			
			HubDetailResponse response = hubDetailConvert.toResponse(entity);
			return ResponseEntity.status(HttpStatus.OK).body(response);
		}
		
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("NOT");
	}
	
	@DeleteMapping("/hub/detail/{hubDetailId}")
	public ResponseEntity<?> delete(@PathVariable("hubDetailId") Long hubDetailId){
		//boolean result = hubDetailService.delete(hubDetailId);
		
		HubDetailEntity entity = hubDetailService.findById(hubDetailId).orElse(null);
		boolean result = false;
		if(entity != null) {
			hubDetailService.delete(entity);
			
			HistoryOperationDeviceEntity historyOperationDevice = new HistoryOperationDeviceEntity();
			historyOperationDevice.setAction("XÓA");
			historyOperationDevice.setContent("Xóa thiết bị khỏi hub " + entity.getHubEntity().getHubName());
			historyOperationDevice.setHubDetail(entity);
			historyOperationDeviceService.save(historyOperationDevice);
			
			result = true;
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(result);
	}
	
	/**
	 * switch hub
	 */
	@PutMapping("/hub/detail/switch/{hubDetailId}")
	public ResponseEntity<?> editSwitchHub(
			@PathVariable("hubDetailId") Long hubDetailId,
			@RequestBody HubDetailRequest request){
		
		HubDetailEntity entity = hubDetailService.findById(hubDetailId).orElse(null);
		
		HubEntity hubEntity = hubService.findByHubId(request.getHubId());
		if(entity != null && hubEntity.getHubId() != null) {
		
			String hubNameOld = entity.getHubEntity().getHubName();
			String branchOld = entity.getHubEntity().getBranchEntity().getBranchName();
			
			entity.setHubEntity(hubEntity);
			
			entity = hubDetailService.save(entity);
			
			HistoryOperationDeviceEntity historyOperationDevice = new HistoryOperationDeviceEntity();
			historyOperationDevice.setAction("CHUYỂN THIẾT BỊ");
			historyOperationDevice.setContent("Thiết bị được chuyển từ hub " + hubNameOld + " - " 
							+ branchOld + " sang hub " + entity.getHubEntity().getHubName() + " - " 
							+ entity.getHubEntity().getBranchEntity().getBranchName());
			historyOperationDevice.setHubDetail(entity);
			historyOperationDeviceService.save(historyOperationDevice);
			
			HubDetailResponse response = hubDetailConvert.toResponse(entity);
			return ResponseEntity.status(HttpStatus.OK).body(response);
		}
		
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("NOT");
	}
	
	/**
	 * get alarm
	 */
	@GetMapping("/hub/detail/alarm")
	public ResponseEntity<?> getAlarm(HttpServletRequest request){
		String token = jwtTokenUtil.getToken(request);
		String username = jwtTokenUtil.getUserNameFromJwtSubject(token);
		List<HubDetailAlarmResponse> hubDetailAlarmResponses = hubDetailService.getAlarm(username);
		return ResponseEntity.status(HttpStatus.OK).body(hubDetailAlarmResponses);
	}
	
	/**
	 * 
	 */
	@GetMapping("/hub/detail/device/history/operation/{hubDetailId}")
	public ResponseEntity<?> getHistoryOperation(
			@PathVariable("hubDetailId") Long hubDetailId){
		List<HistoryOperationDeviceResponse> historyOperationDeviceResponses = historyOperationDeviceService.findAllByHubDetailId(hubDetailId);
		return ResponseEntity.status(HttpStatus.OK).body(historyOperationDeviceResponses);
	}
}
