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

import com.vux.example.RegisterLogin.Entity.HubDevice.BranchEntity;
import com.vux.example.RegisterLogin.Entity.HubDevice.HubEntity;
import com.vux.example.RegisterLogin.Entity.HubDevice.StaffBranchEntity;
import com.vux.example.RegisterLogin.Entity.HubDevice.StaffDepartmentEntity;
import com.vux.example.RegisterLogin.Jwt.JwtTokenUtil;
import com.vux.example.RegisterLogin.Payload.Request.HubRequest;
import com.vux.example.RegisterLogin.Payload.Response.HubAdminResponse;
import com.vux.example.RegisterLogin.Payload.Response.HubResponse;
import com.vux.example.RegisterLogin.Payload.Response.HubResponseStatus;
import com.vux.example.RegisterLogin.Payload.Response.SelectResponse;
import com.vux.example.RegisterLogin.Service.BranchService;
import com.vux.example.RegisterLogin.Service.HubService;
import com.vux.example.RegisterLogin.Service.StaffBranchService;
import com.vux.example.RegisterLogin.Service.StaffDepartmentService;

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
	private StaffBranchService staffBranchService;
	@Autowired
	private StaffDepartmentService staffDepartmentService;
	;
	
	
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	
	
	
	@GetMapping("/admin/hub")
	public ResponseEntity<?> getAll(){
		List<HubAdminResponse> responses = hubService.getAll();
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
	
	@GetMapping("/admin/hub/branch/{branchId}")
	public ResponseEntity<?> getHubAdminBranch(
			@PathVariable("branchId") String branchId){
		BranchEntity branchEntity = branchService.findByBranchId(branchId);
		List<HubAdminResponse> responses = new ArrayList<HubAdminResponse>();
		if(branchEntity.getBranchId() != null) {
			responses = hubService.findAdminByBranchId(branchEntity);
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
	
	@PutMapping("/admin/hub/{hubId}")
	public ResponseEntity<?> edit(
			@PathVariable("hubId") String hubId,
			@RequestBody HubRequest request){
		HubEntity hubEntity = hubService.findByHubId(hubId);
		BranchEntity branchEntity = branchService.findByBranchId(request.getBranchId());
		StaffBranchEntity staffBranchEntity = staffBranchService.findById(request.getStaffManagerId()).orElse(null);
		StaffDepartmentEntity staffDepartmentEntity = staffDepartmentService.findById(request.getStaffDepartmentId()).orElse(null);
		
		HubResponse response = new HubResponse();
		if(hubEntity.getHubId() != null && staffBranchEntity != null && staffDepartmentEntity != null && branchEntity.getBranchId() != null) {
			hubEntity = hubConvert.toUpdateEntity(hubEntity, request);
			hubEntity.setBranchEntity(branchEntity);
			hubEntity.setStaffBranch(staffBranchEntity);
			hubEntity.setStaffDepartment(staffDepartmentEntity);
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
	
	@PostMapping("/admin/hub")
	public ResponseEntity<?> save(@RequestBody HubRequest request){
		HubEntity entity = hubConvert.toEntity(request);
//		UserEntity userEntity = userService.findUserById(request.getUserId()).orElse(null);
		BranchEntity branchEntity = branchService.findByBranchId(request.getBranchId());
		StaffBranchEntity staffBranchEntity = staffBranchService.findById(request.getStaffManagerId()).orElse(null);
		StaffDepartmentEntity staffDepartmentEntity = staffDepartmentService.findById(request.getStaffDepartmentId()).orElse(null);
		HubResponse response = new HubResponse();
		if(staffBranchEntity != null && staffDepartmentEntity != null && branchEntity.getBranchId() != null) {
			entity.setHubId(request.getHubId());
			entity.setBranchEntity(branchEntity);
			entity.setStaffBranch(staffBranchEntity);
			entity.setStaffDepartment(staffDepartmentEntity);
			response = hubService.save(entity);
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	
	/**
	 * set switch hub to branch
	 * @param request
	 * @return
	 */
	@PostMapping("/admin/hub/switch/branch")
	public ResponseEntity<?> setSwitchHubToBranch(@RequestBody HubRequest request){
		String branchId = request.getBranchId();
		String hubId = request.getHubId();
		HubEntity hubEntity = hubService.findByHubId(hubId);

		HubResponseStatus response = new HubResponseStatus();
		response.setStatus(101);
		
		if(hubEntity.getHubId() != null) {
			BranchEntity branchEntity = branchService.findByBranchId(branchId);
			
			StaffBranchEntity staffBranchEntity = hubEntity.getStaffBranch();
			staffBranchEntity.setBranchStaffEntity(branchEntity);
			StaffBranchEntity staffBranchEntityNew = staffBranchService.save(staffBranchEntity);
			if(staffBranchEntityNew.getId() != null) {
				hubEntity.setBranchEntity(branchEntity);
				response.setHubResponse(hubService.save(hubEntity));
				response.setStatus(100);
			}			
			
		}		
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	
	@DeleteMapping("/admin/hub/{hubId}")
	public ResponseEntity<?> delete(@PathVariable("hubId") String hubId){
		boolean result = hubService.delete(hubId);
		return ResponseEntity.status(HttpStatus.OK).body(result);
	}
	
	
	/**==============leader manage============*/
	
	/**
	 * hub switch manager 
	 * @param request
	 * @return
	 */
	@PostMapping("/leader/hub/switch/manager")
	public ResponseEntity<?> setSwitchHubToManager(@RequestBody HubRequest request){
		Long staffManager = request.getStaffManagerId();
		String hubId = request.getHubId();
		HubEntity hubEntity = hubService.findByHubId(hubId);

		HubResponseStatus response = new HubResponseStatus();
		response.setStatus(101);
		
		if(hubEntity.getHubId() != null) {
			StaffBranchEntity staffBranchEntity = staffBranchService.findById(staffManager).orElse(null);
			hubEntity.setStaffBranch(staffBranchEntity);
			
//			StaffBranchEntity staffBranchEntityNew = staffBranchService.save(staffBranchEntity);
//			HubEntity hub = ;
//			if(hub.getHubId() != null) {
				
				response.setHubResponse(hubService.save(hubEntity));
				response.setStatus(100);
//			}			
			
		}		
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	
	
	/**
	 * leader edit hub
	 * @param hubId
	 * @param request
	 * @return
	 */
	@PutMapping("/leader/hub/{hubId}")
	public ResponseEntity<?> leaderEditHub(
			@PathVariable("hubId") String hubId,
			@RequestBody HubRequest request){
		HubEntity hubEntity = hubService.findByHubId(hubId);		
		StaffBranchEntity staffBranchEntity = staffBranchService.findById(request.getStaffManagerId()).orElse(null);
		
		
		HubResponse response = new HubResponse();
		if(hubEntity.getHubId() != null && staffBranchEntity != null) {
			hubEntity = hubConvert.toUpdateEntity(hubEntity, request);			
			hubEntity.setStaffBranch(staffBranchEntity);			
			response = hubService.save(hubEntity);
		}
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
}
