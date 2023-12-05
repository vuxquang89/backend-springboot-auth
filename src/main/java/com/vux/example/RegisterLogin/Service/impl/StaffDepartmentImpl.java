package com.vux.example.RegisterLogin.Service.impl;

import java.util.List;
import java.util.Optional;

import com.vux.example.RegisterLogin.Entity.HubDevice.StaffDepartmentEntity;
import com.vux.example.RegisterLogin.Payload.Response.StaffDepartmentResponse;
import com.vux.example.RegisterLogin.Payload.Response.UserResponse;

public interface StaffDepartmentImpl {

	public List<UserResponse> findAll();
	public Optional<StaffDepartmentEntity> findById(Long id);
	public StaffDepartmentEntity save(StaffDepartmentEntity entity);
	public List<StaffDepartmentResponse> getAll();
}
