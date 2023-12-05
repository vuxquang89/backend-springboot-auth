package com.vux.example.RegisterLogin.Service.impl;

import java.util.List;
import java.util.Optional;

import com.vux.example.RegisterLogin.Entity.HubDevice.StaffBranchEntity;
import com.vux.example.RegisterLogin.Payload.Response.UserResponse;

public interface StaffBranchImpl {

	public List<UserResponse> findAll();
	
	public List<StaffBranchEntity> findUserManagerOption(String brancId,Integer roleId);
	public StaffBranchEntity save(StaffBranchEntity entity);
	public Optional<StaffBranchEntity> findById(Long id);
	public Optional<StaffBranchEntity> findByUsername(String usename);
}
