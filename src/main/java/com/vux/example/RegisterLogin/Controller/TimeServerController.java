package com.vux.example.RegisterLogin.Controller;

import java.time.LocalDate;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class TimeServerController {

	@GetMapping("/date/now")
	public ResponseEntity<?> getDateNow(){
		String dateNow = LocalDate.now().toString();
		return ResponseEntity.status(HttpStatus.OK).body(dateNow);
	}
	
}
