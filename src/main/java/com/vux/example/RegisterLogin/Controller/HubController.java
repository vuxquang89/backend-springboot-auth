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

import com.vux.example.RegisterLogin.Converter.HubConvert;
import com.vux.example.RegisterLogin.Converter.QRConvert;
import com.vux.example.RegisterLogin.Entity.UserEntity;
import com.vux.example.RegisterLogin.Entity.HubDevice.BranchEntity;
import com.vux.example.RegisterLogin.Entity.HubDevice.HubEntity;
import com.vux.example.RegisterLogin.Jwt.JwtTokenUtil;
import com.vux.example.RegisterLogin.Payload.Request.HubRequest;
import com.vux.example.RegisterLogin.Payload.Response.HubResponse;
import com.vux.example.RegisterLogin.Payload.Response.HubResponseStatus;
import com.vux.example.RegisterLogin.Payload.Response.SelectResponse;
import com.vux.example.RegisterLogin.Service.BranchService;
import com.vux.example.RegisterLogin.Service.HubService;
import com.vux.example.RegisterLogin.Service.UserService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class HubController {

	@Autowired
	private HubService hubService;
	@Autowired
	private HubConvert hubConvert;
	@Autowired
	private BranchService branchService;
	@Autowired
	private UserService userService;
	@Autowired
	private QRConvert qrConvert;
	
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	
	
	
	@GetMapping("/hub")
	public ResponseEntity<?> getAll(){
		List<HubResponse> responses = hubService.getAll();
		return ResponseEntity.status(HttpStatus.OK).body(responses);
	}
	
	@GetMapping("/hub/manager")
	public ResponseEntity<?> getHubByUserAll(HttpServletRequest request){
		String token = jwtTokenUtil.getToken(request);
		String username = jwtTokenUtil.getUserNameFromJwtSubject(token);
		
		List<HubResponse> responses = hubService.getHubByUser(username);
		return ResponseEntity.status(HttpStatus.OK).body(responses);
	}
	
	@GetMapping("/hub/branch/{branchId}")
	public ResponseEntity<?> getHubByBranch(
			@PathVariable("branchId") String branchId){
		BranchEntity branchEntity = branchService.findByBranchId(branchId);
		List<HubResponse> responses = new ArrayList<HubResponse>();
		if(branchEntity.getBranchId() != null) {
			responses = hubService.findByBranchId(branchEntity);
		}
		return ResponseEntity.status(HttpStatus.OK).body(responses);
	}
	
	
	@GetMapping("/hub/list/branch/{branchId}")
	public ResponseEntity<?> getHubByBranchToSelect(
			@PathVariable("branchId") String branchId){
		BranchEntity branchEntity = branchService.findByBranchId(branchId);
		
		List<SelectResponse> selectResponses = new ArrayList<>();
		if(branchEntity.getBranchId() != null) {
			List<HubResponse> hubResponses = hubService.findByBranchId(branchEntity);
			for(HubResponse response : hubResponses) {
				selectResponses.add(hubConvert.toHubSelect(response));
			}
			
		}
		return ResponseEntity.status(HttpStatus.OK).body(selectResponses);
	}
	
	@GetMapping("/hub/{hubId}")
	public ResponseEntity<?> getHub(
			@PathVariable("hubId") String hubId){
		HubEntity entity = hubService.findByHubId(hubId);
		HubResponse result = new HubResponse();
		HubResponseStatus response = new HubResponseStatus();
		if(entity != null) {
			result = hubConvert.toResponse(entity);
			response.setHubResponse(result);
			response.setStatus(100);
		}
		else {
			response.setStatus(101);
		}
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	
	@PutMapping("/hub/{hubId}")
	public ResponseEntity<?> edit(
			@PathVariable("hubId") String hubId,
			@RequestBody HubRequest request){
		HubEntity hubEntity = hubService.findByHubId(hubId);
		UserEntity userEntity = userService.findUserById(request.getUserId()).orElse(null);
		BranchEntity branchEntity = branchService.findByBranchId(request.getBranchId());
		HubResponse response = new HubResponse();
		if(hubEntity != null && userEntity != null && branchEntity.getBranchId() != null) {
			hubEntity = hubConvert.toUpdateEntity(hubEntity, request);
			hubEntity.setBranchEntity(branchEntity);
			hubEntity.setPersonnelChargeName(userEntity);
			response = hubService.save(hubEntity);
		}
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	
	@PostMapping("/hub/{hubId}")
	public ResponseEntity<?> editCellTable(
			@PathVariable("hubId") String hubId,
			@RequestBody HubRequest request){
		HubEntity hubEntity = hubService.findByHubId(hubId);
		
		HubResponse response = new HubResponse();
		if(hubEntity != null) {
			hubEntity = hubConvert.toUpdateEntity(hubEntity, request);			
			response = hubService.save(hubEntity);
		}
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	
	@PostMapping("/hub")
	public ResponseEntity<?> save(@RequestBody HubRequest request){
		HubEntity entity = hubConvert.toEntity(request);
		UserEntity userEntity = userService.findUserById(request.getUserId()).orElse(null);
		BranchEntity branchEntity = branchService.findByBranchId(request.getBranchId());
		HubResponse response = new HubResponse();
		if(userEntity != null && branchEntity.getBranchId() != null) {
			entity.setHubId(request.getHubId());
			entity.setBranchEntity(branchEntity);
			entity.setPersonnelChargeName(userEntity);
			response = hubService.save(entity);
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	
	@DeleteMapping("/hub/{hubId}")
	public ResponseEntity<?> delete(@PathVariable("hubId") String hubId){
		boolean result = hubService.delete(hubId);
		return ResponseEntity.status(HttpStatus.OK).body(result);
	}
}
