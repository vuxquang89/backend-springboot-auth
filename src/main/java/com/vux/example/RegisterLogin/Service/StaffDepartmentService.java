package com.vux.example.RegisterLogin.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vux.example.RegisterLogin.Converter.StaffDepartmentConvert;
import com.vux.example.RegisterLogin.Entity.HubDevice.StaffDepartmentEntity;
import com.vux.example.RegisterLogin.Payload.Response.StaffDepartmentResponse;
import com.vux.example.RegisterLogin.Payload.Response.UserResponse;
import com.vux.example.RegisterLogin.Repo.StaffDepartmentRepository;
import com.vux.example.RegisterLogin.Service.impl.StaffDepartmentImpl;

@Service
public class StaffDepartmentService implements StaffDepartmentImpl {
	
	@Autowired
	private StaffDepartmentRepository staffDepartmentRepository;
	@Autowired
	private StaffDepartmentConvert convert;
	
	@Override
	public Optional<StaffDepartmentEntity> findById(Long id) {
		return staffDepartmentRepository.findById(id);
	}

	@Override
	public List<StaffDepartmentResponse> getAll() {
		List<StaffDepartmentEntity> entities = staffDepartmentRepository.findAll();
		List<StaffDepartmentResponse> responses = new ArrayList<StaffDepartmentResponse>();
		for(StaffDepartmentEntity entity : entities) {
			responses.add(convert.toResponse(entity));
		}
		return responses;
	}
	
	@Override
	public List<UserResponse> findAll() {
		List<StaffDepartmentEntity> entities = staffDepartmentRepository.findAll();
		List<UserResponse> responses = new ArrayList<UserResponse>();
		for(StaffDepartmentEntity entity : entities) {
			responses.add(convert.toUserResponse(entity));
		}
		return responses;
	}
	
	@Override
	public StaffDepartmentEntity save(StaffDepartmentEntity entity) {
		return staffDepartmentRepository.save(entity);
	}
}
