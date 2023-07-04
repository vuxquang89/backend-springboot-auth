package com.vux.example.RegisterLogin.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vux.example.RegisterLogin.Converter.QRConvert;
import com.vux.example.RegisterLogin.Entity.QRInfoEntity;
import com.vux.example.RegisterLogin.Payload.Request.QRInfoRequest;
import com.vux.example.RegisterLogin.Service.QRInfoService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class QRController {
	
	@Autowired
	private QRInfoService qrInfoService;
	
	@Autowired
	private QRConvert qrConvert;
	

	@GetMapping("/qr")
	public ResponseEntity<?> getData(){
		System.out.println("get QR Info");
		List<QRInfoEntity> qrInfos = qrInfoService.getAll();
		
		return ResponseEntity.ok(qrInfos);
	}
	
	@PostMapping("/qr")
	public ResponseEntity<?> saveData(@Valid @RequestBody QRInfoRequest qrRequest){
		QRInfoEntity qrInfoEntity = qrConvert.toEntity(qrRequest);
		QRInfoEntity saveQR = qrInfoService.save(qrInfoEntity);
		
		return ResponseEntity.ok(saveQR);
	}
}
