package com.vux.example.RegisterLogin.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vux.example.RegisterLogin.Converter.StaffBranchConvert;
import com.vux.example.RegisterLogin.Entity.HubDevice.StaffBranchEntity;
import com.vux.example.RegisterLogin.Payload.Response.UserResponse;
import com.vux.example.RegisterLogin.Repo.StaffBranchRepository;
import com.vux.example.RegisterLogin.Service.impl.StaffBranchImpl;

@Service
public class StaffBranchService implements StaffBranchImpl {

	@Autowired
	private StaffBranchRepository staffBranchRepository;
	@Autowired
	private StaffBranchConvert staffBranchConvert;
	
	@Override
	public Optional<StaffBranchEntity> findById(Long id) {
		return staffBranchRepository.findById(id);
	}
	@Override
	public List<UserResponse> findAll() {
		List<StaffBranchEntity> staffBranchEntities = staffBranchRepository.findAll();
		List<UserResponse> responses = new ArrayList<UserResponse>();
		for(StaffBranchEntity entity : staffBranchEntities) {
			responses.add(staffBranchConvert.toUserResponse(entity));
		}
		return responses;
	}
	
	@Override
	public List<StaffBranchEntity> findUserManagerOption(String branhcId, Integer roleId) {
		List<StaffBranchEntity> branchEntities = staffBranchRepository.findUserOption( branhcId, roleId);
		return branchEntities;
	}
	
	@Override
	public Optional<StaffBranchEntity> findByUsername(String usename) {
		return staffBranchRepository.findByUsername(usename);
	}
	@Override
	public StaffBranchEntity save(StaffBranchEntity entity) {
		return staffBranchRepository.save(entity);
	}
}
