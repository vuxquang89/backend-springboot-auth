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

import com.vux.example.RegisterLogin.Converter.UserConvert;
import com.vux.example.RegisterLogin.Entity.RoleEntity;
import com.vux.example.RegisterLogin.Entity.UserEntity;
import com.vux.example.RegisterLogin.Entity.HubDevice.BranchEntity;
import com.vux.example.RegisterLogin.Entity.HubDevice.StaffBranchEntity;
import com.vux.example.RegisterLogin.Entity.HubDevice.StaffDepartmentEntity;
import com.vux.example.RegisterLogin.Entity.HubDevice.StaffLeaderEntity;
import com.vux.example.RegisterLogin.Jwt.JwtTokenUtil;
import com.vux.example.RegisterLogin.Payload.Request.UserChangePasswordRequest;
import com.vux.example.RegisterLogin.Payload.Request.UserRequest;
import com.vux.example.RegisterLogin.Payload.Response.OptionSelectResponse;
import com.vux.example.RegisterLogin.Payload.Response.UserResponse;
import com.vux.example.RegisterLogin.Payload.Response.UserResponseStatus;
import com.vux.example.RegisterLogin.Service.StaffBranchService;
import com.vux.example.RegisterLogin.Service.StaffDepartmentService;
import com.vux.example.RegisterLogin.Service.StaffLeaderService;
import com.vux.example.RegisterLogin.Service.UserService;
import com.vux.example.RegisterLogin.lib.Password;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class UserController {
	
	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private UserService userService;
	
	@Autowired
	private UserConvert userConvert;
	
	@Autowired
	private StaffDepartmentService staffDepartmentService;
	@Autowired
	private StaffBranchService staffBranchService;
	@Autowired
	private StaffLeaderService staffLeaderService;
	
	@GetMapping("/users")
	public ResponseEntity<?> getAll(){
		List<UserResponse> responses = userService.getAll();
		return ResponseEntity.status(HttpStatus.OK).body(responses);
	}
	
	/**
	 * get list user department
	 * @return
	 */
	@GetMapping("/admin/users/{userType}")
	public ResponseEntity<?> getAllByUserType(@PathVariable("userType") String userType){
//		List<UserResponse> responses = userService.findByUserType(userType);
		List<UserResponse> responses = new ArrayList<UserResponse>();
		switch (userType) {
		case "leader":
			responses = staffLeaderService.findAll();
			break;
		case "manager":
			responses = staffBranchService.findAll();
			break;
		default:
			responses = staffDepartmentService.findAll();
			break;
		}
		return ResponseEntity.status(HttpStatus.OK).body(responses);
	}
	
	/**
	 * save user
	 * 
	 */
	@PostMapping("/admin/users/{userType}")
	public ResponseEntity<?> saveDepartment(
			@PathVariable("userType") String userType,
			@RequestBody UserRequest request){

		UserResponseStatus responseStatus = new UserResponseStatus();
		responseStatus.setStatus(100);
		
		String message = "";
		if(userService.existsByUsername(request.getUsername())) {
			message = "- Username đã tồn tại \n";
		}
		
		if(userService.existsByEmail(request.getEmail())) {
			message += "- Email đã tồn tại \n";
		}
		
		if(userService.existsByPhone(request.getPhone())) {
			message += "- Sđt đã tồn tại";
		}
		if(message.length() > 0) {
			responseStatus.setStatus(101);
		}else {
			UserEntity entity = userConvert.toEntity(request);
			entity.addRole(new RoleEntity(5));//ROLE_USER
			entity.setStatus(1);
			entity.setUserType(userType);
			entity = userService.save(entity);
			if(entity.getId() != null) {
				switch (userType) {
				case "department":
					StaffDepartmentEntity departmentEntity = userConvert.toDepartmentEntity(entity);
					departmentEntity.setRoleId(5);
					departmentEntity.setRoleName("ROLE_USER");
					staffDepartmentService.save(departmentEntity);
					break;
				case "leader":
					StaffLeaderEntity leaderEntity = userConvert.toLeaderEntity(entity);
					leaderEntity.setBranch(new BranchEntity(request.getBranchId(), request.getBranchName()));
					leaderEntity.setRoleId(5);
					leaderEntity.setRoleName("ROLE_USER");
					staffLeaderService.save(leaderEntity);
					break;
				default://manager
					StaffBranchEntity managerEntity = userConvert.toBranchEntity(entity);
					managerEntity.setBranchStaffEntity(new BranchEntity(request.getBranchId(), request.getBranchName()));
					managerEntity.setRoleId(5);
					managerEntity.setRoleName("ROLE_USER");
					staffBranchService.save(managerEntity);
					break;
				}
				
			}
			responseStatus.addUserResponse(userConvert.toResponse(entity));
		}
		responseStatus.setMessage(message);
		return ResponseEntity.status(HttpStatus.OK).body(responseStatus);
	}
	
	/**
	 * 
	 */
	@PostMapping("/users")
	public ResponseEntity<?> save(@RequestBody UserRequest request){

		UserResponseStatus responseStatus = new UserResponseStatus();
		responseStatus.setStatus(100);
		
		String message = "";
		if(userService.existsByUsername(request.getUsername())) {
			message = "- Username đã tồn tại \n";
		}
		
		if(userService.existsByEmail(request.getEmail())) {
			message += "- Email đã tồn tại \n";
		}
		
		if(userService.existsByPhone(request.getPhone())) {
			message += "- Sdt đã tồn tại";
		}
		if(message.length() > 0) {
			responseStatus.setStatus(101);
		}else {
			UserEntity entity = userConvert.toEntity(request);
			entity.addRole(new RoleEntity(3));
			entity.setStatus(1);
			entity = userService.save(entity);
			responseStatus.addUserResponse(userConvert.toResponse(entity));
		}
		responseStatus.setMessage(message);
		return ResponseEntity.status(HttpStatus.OK).body(responseStatus);
	}
	
	/**
	 * 
	 */
	@GetMapping("/users/{id}")
	public ResponseEntity<?> getUser(@PathVariable("id") Long id){
		UserEntity entity = userService.findUserById(id).get();
		UserResponseStatus responseStatus = new UserResponseStatus();
		responseStatus.setStatus(100);
		
		if(entity.getId() != null) {
			responseStatus.addUserResponse(userConvert.toResponse(entity));
			
		}else {
			responseStatus.setStatus(101);
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(responseStatus);
	}
	
	/**
	 * get user
	 * 
	 */
	@GetMapping("/admin/users/{userType}/{id}")
	public ResponseEntity<?> getUserById(
			@PathVariable("userType") String userType,
			@PathVariable("id") Long id){
		
		UserEntity entity = userService.findUserById(id).get();
		UserResponseStatus responseStatus = new UserResponseStatus();
		responseStatus.setStatus(100);
		
		if(entity.getId() != null) {
			UserResponse userResponse = userConvert.toResponse(entity);
			switch (userType) {
			case "manager":
				StaffBranchEntity branchEntity = staffBranchService.findById(entity.getId()).get();
				userResponse.setBranchId(branchEntity.getBranchStaffEntity().getBranchId());
				userResponse.setBranchName(branchEntity.getBranchStaffEntity().getBranchName());
				break;
			case "leader":
				StaffLeaderEntity leaderEntity = staffLeaderService.findById(entity.getId()).get();
				userResponse.setBranchId(leaderEntity.getBranch().getBranchId());
				userResponse.setBranchName(leaderEntity.getBranch().getBranchName());
				break;
			default://manager
				
				break;
			}
			responseStatus.addUserResponse(userResponse);
		}else {
			responseStatus.setStatus(101);
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(responseStatus);
	}
	
	/**
	 * edit 
	 * @param id
	 * @param request
	 * @return
	 */
	@PutMapping("/admin/users/{userType}/{id}")
	public ResponseEntity<?> editUser(
			@PathVariable("userType") String userType,
			@PathVariable("id") Long id,
			@RequestBody UserRequest request){
		UserEntity entity = userService.findUserById(id).get();
		
		UserResponseStatus responseStatus = new UserResponseStatus();
		responseStatus.setStatus(100);
		String message = "";
		
		if(entity.getId() != null) {
			
			entity = userConvert.toUpdateEntity(entity, request);
			entity = userService.save(entity);
			
			UserResponse userResponse = userConvert.toResponse(entity);
			
			switch (userType) {
			case "manager":
				StaffBranchEntity branchEntity = userConvert.toBranchEntity(entity);
				branchEntity.setBranchStaffEntity(new BranchEntity(request.getBranchId(), request.getBranchName()));
				branchEntity = staffBranchService.save(branchEntity);
				userResponse.setBranchId(branchEntity.getBranchStaffEntity().getBranchId());
				userResponse.setBranchName(branchEntity.getBranchStaffEntity().getBranchName());
				break;
			case "leader":
				StaffLeaderEntity leaderEntity = userConvert.toLeaderEntity(entity);
				leaderEntity.setBranch(new BranchEntity(request.getBranchId(), request.getBranchName()));
				leaderEntity = staffLeaderService.save(leaderEntity);
				userResponse.setBranchId(leaderEntity.getBranch().getBranchId());
				userResponse.setBranchName(leaderEntity.getBranch().getBranchName());
				break;
			default:
				StaffDepartmentEntity departmentEntity = userConvert.toDepartmentEntity(entity);
				staffDepartmentService.save(departmentEntity);
				break;
			}
			
			responseStatus.addUserResponse(userResponse);
			
		}else {
			responseStatus.setStatus(101);
			message = "- Không tồn tại";
		}
		responseStatus.setMessage(message);
		return ResponseEntity.status(HttpStatus.OK).body(responseStatus);
	}
	
	@PutMapping("/users/{id}")
	public ResponseEntity<?> edit(
			@PathVariable("id") Long id,
			@RequestBody UserRequest request){
		UserEntity entity = userService.findUserById(id).get();
		
		UserResponseStatus responseStatus = new UserResponseStatus();
		responseStatus.setStatus(100);
		String message = "";
		
		if(entity.getId() != null) {
			
			entity = userConvert.toUpdateEntity(entity, request);
			entity = userService.save(entity);
			responseStatus.addUserResponse(userConvert.toResponse(entity));
			
		}else {
			responseStatus.setStatus(101);
			message = "- Không tồn tại";
		}
		responseStatus.setMessage(message);
		return ResponseEntity.status(HttpStatus.OK).body(responseStatus);
	}
	
	@DeleteMapping("/users/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Long id){
		boolean result = userService.delete(id);
		if(result)
			return ResponseEntity.status(HttpStatus.OK).body(result);
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(result);
	}
	
	@GetMapping("/users/role/{roleId}")
	public ResponseEntity<?> getUserRole(@PathVariable("roleId") int roleId){
		
		List<UserResponse> responses = userService.getUserRole(roleId);
		return ResponseEntity.status(HttpStatus.OK).body(responses);
	}
	
	@GetMapping("/admin/users/department/selectoption/role/{roleId}")
	public ResponseEntity<?> getUserRoleOptionSelect(@PathVariable("roleId") int roleId){
		List<UserEntity> entities = userService.getUserEntityRole(roleId);
		List<OptionSelectResponse> responses = new ArrayList<>();
		for(UserEntity entity : entities) {
			responses.add(userConvert.toOptionSelect(entity));
		}
		return ResponseEntity.status(HttpStatus.OK).body(responses);
	}
	
	@GetMapping("/admin/users/manager/branch/{branchId}/selectoption/role/{roleId}")
	public ResponseEntity<?> getUserManagerOptionSelect(
			@PathVariable("branchId") String branchId,
			@PathVariable("roleId") int roleId){
		List<StaffBranchEntity> branchEntities = staffBranchService.findUserManagerOption(branchId, roleId);
		List<OptionSelectResponse> responses = new ArrayList<>();
		for(StaffBranchEntity entity : branchEntities) {
			responses.add(userConvert.toManagerOptionSelect(entity));
		}
		return ResponseEntity.status(HttpStatus.OK).body(responses);
	}
	
	/**
	 * Change password
	 * @param userRequest
	 * @param request
	 * @return
	 */
	@PostMapping("/user/password/change")
	public ResponseEntity<?> changePassword(
			@RequestBody UserChangePasswordRequest userRequest,
			HttpServletRequest request
			){
		String token = jwtTokenUtil.getToken(request);
		String username = jwtTokenUtil.getUserNameFromJwtSubject(token);
		
		UserEntity userEntity = userService.findUserByUsername(username).orElse(null);
		UserResponseStatus response = new UserResponseStatus();
		response.setStatus(101);
		if(userEntity != null) {
			if(!Password.checkPassword(userRequest.getPasswordOld(), userEntity.getPassword())) {				
				response.setMessage("Mật khẩu cũ không đúng");
			}else if(userRequest.getPasswordNew().length() < 6) {
				response.setMessage("Mật khẩu mới cần tối thiểu 6 ký tự");
			}else if(userRequest.getPasswordOld().equalsIgnoreCase(userRequest.getPasswordNew())) {
				response.setMessage("Mật khẩu mới trùng với mật khẩu cũ");
			}else {
				userEntity.setPassword(Password.encoderPassword(userRequest.getPasswordNew()));
				userService.save(userEntity);
				
				response.setStatus(100);
				response.setMessage("Đổi mật khẩu thành công");
				
			}
		}else {
			
			response.setMessage("User không tồn tại");
		}
				
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}	
	}

