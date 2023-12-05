package com.vux.example.RegisterLogin.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vux.example.RegisterLogin.Converter.StaffLeaderConvert;
import com.vux.example.RegisterLogin.Entity.HubDevice.StaffLeaderEntity;
import com.vux.example.RegisterLogin.Payload.Response.UserResponse;
import com.vux.example.RegisterLogin.Repo.StaffLeaderRepository;
import com.vux.example.RegisterLogin.Service.impl.StaffLeaderImpl;

@Service
public class StaffLeaderService implements StaffLeaderImpl {

	@Autowired
	private StaffLeaderRepository staffLeaderRepository;
	@Autowired
	private StaffLeaderConvert staffLeaderConvert;
	
	@Override
	public List<UserResponse> findAll() {
		List<StaffLeaderEntity> entities = staffLeaderRepository.findAll();
		List<UserResponse> responses = new ArrayList<UserResponse>();
		for(StaffLeaderEntity entity : entities) {
			responses.add(staffLeaderConvert.toUserResponse(entity));
		}
		return responses;
	}
	@Override
	public Optional<StaffLeaderEntity> findById(Long id) {
		return staffLeaderRepository.findById(id);
	}
	@Override
	public StaffLeaderEntity save(StaffLeaderEntity entity) {
		return staffLeaderRepository.save(entity);
	}
}
