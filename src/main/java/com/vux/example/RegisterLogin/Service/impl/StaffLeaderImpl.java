package com.vux.example.RegisterLogin.Service.impl;

import java.util.List;
import java.util.Optional;

import com.vux.example.RegisterLogin.Entity.HubDevice.StaffLeaderEntity;
import com.vux.example.RegisterLogin.Payload.Response.UserResponse;

public interface StaffLeaderImpl {

	public List<UserResponse> findAll();
	public StaffLeaderEntity save(StaffLeaderEntity entity);
	public Optional<StaffLeaderEntity> findById(Long id);
}
