package com.vux.example.RegisterLogin.Controller;

import java.util.ArrayList;
import java.util.List;

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
import com.vux.example.RegisterLogin.Payload.Request.UserRequest;
import com.vux.example.RegisterLogin.Payload.Response.OptionSelectResponse;
import com.vux.example.RegisterLogin.Payload.Response.UserResponse;
import com.vux.example.RegisterLogin.Payload.Response.UserResponseStatus;
import com.vux.example.RegisterLogin.Service.UserService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private UserConvert userConvert;
	
	@GetMapping("/users")
	public ResponseEntity<?> getAll(){
		List<UserResponse> responses = userService.getAll();
		return ResponseEntity.status(HttpStatus.OK).body(responses);
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
			message = "- Username đã tồn tại ";
		}
		
		if(userService.existsByEmail(request.getEmail())) {
			message += "- Email đã tồn tại ";
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
	
	@GetMapping("/users/role/selectoption/{roleId}")
	public ResponseEntity<?> getUserRoleOptionSelect(@PathVariable("roleId") int roleId){
		List<UserEntity> entities = userService.getUserEntityRole(roleId);
		List<OptionSelectResponse> responses = new ArrayList<>();
		for(UserEntity entity : entities) {
			responses.add(userConvert.toOptionSelect(entity));
		}
		return ResponseEntity.status(HttpStatus.OK).body(responses);
	}
}
