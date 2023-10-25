package com.vux.example.RegisterLogin.Controller;

import java.util.ArrayList;
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

import com.vux.example.RegisterLogin.Converter.DeviceConvert;
import com.vux.example.RegisterLogin.Entity.HubDevice.DeviceEntity;
import com.vux.example.RegisterLogin.Jwt.JwtTokenUtil;
import com.vux.example.RegisterLogin.Payload.Request.DeviceRequest;
import com.vux.example.RegisterLogin.Payload.Response.DeviceResponse;
import com.vux.example.RegisterLogin.Service.DeviceService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class DeviceController {
	
	@Autowired
	private DeviceService deviceService;
	
	@Autowired
	private DeviceConvert deviceConvert;
	
	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@GetMapping("/device")
	public ResponseEntity<?> getData(HttpServletRequest request){
		String token = jwtTokenUtil.getToken(request);
		System.out.println(token);
		List<DeviceEntity> deviceEntities = deviceService.getAll();
		List<DeviceResponse> result = new ArrayList<>();
		for(DeviceEntity entity : deviceEntities) {
			result.add(deviceConvert.toResponse(entity));
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(result);
	}
	
	@PostMapping("/device")
	public ResponseEntity<?> save(
			@RequestBody DeviceRequest deviceRequest,
//			@ModelAttribute DeviceRequest deviceRequest,
			HttpServletRequest request){
		System.out.println("==========>new device"+ deviceRequest.getDeviceName());
		DeviceEntity entity = deviceConvert.toEntity(deviceRequest);
		entity = deviceService.save(entity);
		DeviceResponse response = deviceConvert.toResponse(entity);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	
	@PutMapping("/device/{id}")
	public ResponseEntity<?> edit(
			@PathVariable("id") Long id,
			@RequestBody DeviceRequest deviceRequest,
			HttpServletRequest request){
		DeviceEntity entity = deviceConvert.toEntity(deviceRequest);
		entity.setId(id);
		
		entity= deviceService.save(entity);
		DeviceResponse response = deviceConvert.toResponse(entity);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	
	/**
	 * delete
	 */
	
	@DeleteMapping("/device/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Long id){
		boolean result = deviceService.delete(id);
		if(result)
			return ResponseEntity.status(HttpStatus.OK).body(result);
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(result);
	}
}
