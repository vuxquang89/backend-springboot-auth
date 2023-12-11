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

import com.vux.example.RegisterLogin.Converter.BranchConvert;
import com.vux.example.RegisterLogin.Entity.HubDevice.BranchEntity;
import com.vux.example.RegisterLogin.Payload.Request.BranchRequest;
import com.vux.example.RegisterLogin.Payload.Response.BranchResponse;
import com.vux.example.RegisterLogin.Payload.Response.BranchResponseStatus;
import com.vux.example.RegisterLogin.Payload.Response.SelectResponse;
import com.vux.example.RegisterLogin.Service.BranchService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class BranchController {

	@Autowired
	private BranchConvert branchConvert;
	
	@Autowired
	private BranchService branchService;
	
	@GetMapping("/branch")
	public ResponseEntity<?> getData(){
		List<BranchEntity> entities = branchService.getAll();
		
		List<BranchResponse> results = new ArrayList<BranchResponse>();
		for(BranchEntity entity : entities) {
			results.add(branchConvert.toResponse(entity));
		}
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}
	
	@GetMapping("/branch/list")
	public ResponseEntity<?> getManagerBranchList(){
		List<BranchEntity> entities = branchService.getAll();
//		List<BranchEntity> entities = branchService.getBranchAll();
		List<SelectResponse> results = new ArrayList<>();
		for(BranchEntity entity : entities) {
			results.add(branchConvert.toBranchSelect(entity));
		}
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}
	
	
	
	@GetMapping("/admin/branch/list")
	public ResponseEntity<?> getBranchList(){
//		List<BranchEntity> entities = branchService.getAll();
		List<BranchEntity> entities = branchService.getBranchAll();
		List<SelectResponse> results = new ArrayList<>();
		for(BranchEntity entity : entities) {
			results.add(branchConvert.toBranchSelect(entity));
		}
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}
	
	/**
	 * them moi
	 */
	@PostMapping("/branch")
	public ResponseEntity<?> save(@RequestBody BranchRequest request){
		BranchEntity entity = branchConvert.toEntity(request);
		entity = branchService.save(entity);
		BranchResponse response = branchConvert.toResponse(entity);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	
	/**
	 * edit
	 */
	@GetMapping("/branch/{id}")
	public ResponseEntity<?> getDetail(
			@PathVariable("id") String branchId){
		System.out.println("get branch id " + branchId);
		BranchResponse result = branchService.findBranchById(branchId);
		BranchResponseStatus responseStatus = new BranchResponseStatus();
		responseStatus.setResponse(result);
		if(result.getBranchId() != null) {
			responseStatus.setStatus(100);
		}else {
			responseStatus.setStatus(101);
		}
		return ResponseEntity.status(HttpStatus.OK).body(responseStatus);
	}
	
	/**
	 * edit
	 */
	@PutMapping("/branch/{id}")
	public ResponseEntity<?> edit(
			@PathVariable("id") String branchId,
			@RequestBody BranchRequest request){
		System.out.println("get branch id " + branchId);
		BranchEntity entity = branchConvert.toEntity(request);
		entity.setBranchId(branchId);
		entity = branchService.save(entity);
		BranchResponseStatus responseStatus = new BranchResponseStatus();		
		BranchResponse response = branchConvert.toResponse(entity);
		responseStatus.setResponse(response);
		if(response.getBranchId() != null) {
			responseStatus.setStatus(100);
		}else {
			responseStatus.setStatus(101);
		}
		return ResponseEntity.status(HttpStatus.OK).body(responseStatus);
	}
	
	/**
	 * delete
	 */
	@DeleteMapping("/branch/{branchId}")
	public ResponseEntity<?> delete(
			@PathVariable("branchId") String branchId
			){
		boolean result = branchService.delete(branchId);
		if(result)
			return ResponseEntity.status(HttpStatus.OK).body(result);
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(result);
	}
}
