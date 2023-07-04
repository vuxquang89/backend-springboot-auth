package com.vux.example.RegisterLogin.Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vux.example.RegisterLogin.Entity.RoleEntity;
import com.vux.example.RegisterLogin.Entity.UserEntity;
import com.vux.example.RegisterLogin.Jwt.JwtTokenUtil;
import com.vux.example.RegisterLogin.Payload.Request.LoginRequest;
import com.vux.example.RegisterLogin.Payload.Request.RegisterRequest;
import com.vux.example.RegisterLogin.Payload.Response.JwtResponse;
import com.vux.example.RegisterLogin.Service.UserService;
import com.vux.example.RegisterLogin.lib.Password;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class AuthController {
	@Autowired
	private AuthenticationManager authManager;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private JwtTokenUtil jwtUtil;
	

	@PostMapping("/auth/login")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
		System.out.println(loginRequest.getUsername());
		Authentication authentication = authManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
		
		//SecurityContextHolder.getContext().setAuthentication(authentication);
		
		UserEntity user = (UserEntity)authentication.getPrincipal();
		
		String accessToken = jwtUtil.generateAccessToken(user);
		String refreshToken = jwtUtil.generateRefreshToken(user);
		List<String> roles = user.getAuthorities().stream()
		        .map(item -> item.getAuthority())
		        .collect(Collectors.toList());

		return ResponseEntity.ok(new JwtResponse( 
		                         user.getId(), 
		                         user.getUsername(), 
		                         user.getEmail(), 
		                         roles,
		                         accessToken,
		                         refreshToken));		
			
	}
	
	@PostMapping("/auth/register")
	public ResponseEntity<?> register(@Valid @RequestBody RegisterRequest request){
		UserEntity user = new UserEntity();
		user.setEmail(request.getEmail());
		user.setUsername(request.getUsername());
		user.setPassword(Password.encoderPassword(request.getPassword()));
		user.setStatus(1);
		user.addRole(new RoleEntity(2));
		
		UserEntity saveUser = userService.save(user);
		String accessToken = jwtUtil.generateAccessToken(saveUser);
		String refreshToken = jwtUtil.generateRefreshToken(saveUser);
		List<String> roles = new ArrayList<String>();
		//for (RoleEntity role : user.getRoles()) {
		//	roles.add(role.getName().name());
		//}
		//roles.add(user.getRoles().get(0).getName().name());
		/*
		List<String> roles = user.getRoles().stream()
		        .map(item -> item.getName().name())
		        .collect(Collectors.toList());
		*/
		return ResponseEntity.ok(new JwtResponse( 
		                         saveUser.getId(), 
		                         saveUser.getUsername(), 
		                         saveUser.getEmail(), 
		                         roles,
		                         accessToken,
		                         refreshToken));
	}

	@PostMapping("/token/refresh")
	public ResponseEntity<?> refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException{
		String header = request.getHeader("Authorization");
		System.out.println(header);
		if(ObjectUtils.isEmpty(header) || !header.startsWith("Bearer")) {
			throw new RuntimeException("Refresh token is missing");
		}else {
			try {
				String refreshToken = header.split(" ")[1].trim();
				if(jwtUtil.validateToken(refreshToken, response)) {
					String username = jwtUtil.getUserNameFromJwtSubject(refreshToken);
					UserEntity user = userService.findUserByUsername(username).get();
					String accessToken = jwtUtil.generateAccessToken(user);
					
					List<String> roles = new ArrayList<String>();
					//for (RoleEntity role : user.getRoles()) {
					//	roles.add(role.getName().name());
					//}
					
					return ResponseEntity.ok(new JwtResponse( 
	                         user.getId(), 
	                         user.getUsername(), 
	                         user.getEmail(), 
	                         roles,
	                         accessToken,
	                         refreshToken));
					
				}else {
					return ResponseEntity.ok().body("You need to login again!");
				}
				
				
			}catch(Exception ex) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
			}
		}
	}
	
}
