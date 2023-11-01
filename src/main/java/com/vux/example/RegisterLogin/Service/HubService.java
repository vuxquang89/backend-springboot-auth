package com.vux.example.RegisterLogin.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vux.example.RegisterLogin.Converter.HubConvert;
import com.vux.example.RegisterLogin.Entity.HubDevice.BranchEntity;
import com.vux.example.RegisterLogin.Entity.HubDevice.HubEntity;
import com.vux.example.RegisterLogin.Payload.Response.HubResponse;
import com.vux.example.RegisterLogin.Repo.HubRepository;
import com.vux.example.RegisterLogin.Service.impl.HubServiceImpl;

@Service
public class HubService implements HubServiceImpl {
	
	@Autowired
	private HubRepository hubRepository;
	@Autowired
	private HubConvert hubConvert;

	@Override
	public List<HubResponse> getAll() {
//		List<HubEntity> entities = hubRepository.findAll();
		List<HubEntity> entities = hubRepository.findByOrderByBranchEntityAsc();
		List<HubResponse> responses = new ArrayList<HubResponse>();
		for(HubEntity entity : entities) {
			responses.add(hubConvert.toResponse(entity));
		}
		return responses;
	}
	
	@Override
	public List<HubResponse> getHubByUser(String username) {
		List<HubEntity> entities = hubRepository.findByPersonnelChargeName(username);
		List<HubResponse> responses = new ArrayList<HubResponse>();
		for(HubEntity entity : entities) {
			responses.add(hubConvert.toResponse(entity));
		}
		return responses;
		
	}
	
	@Override
	public List<HubResponse> findByBranchId(BranchEntity entity) {
	
		List<HubEntity> entities = hubRepository.findByBranchEntity(entity);
		List<HubResponse> responses = new ArrayList<HubResponse>();
		for(HubEntity e : entities) {
			responses.add(hubConvert.toResponse(e));
		}
		return responses;
	}
	@Override
	public HubEntity findByHubId(String hubId) {
		return hubRepository.findByHubId(hubId).orElse(null);
	}
	@Override
	public HubResponse save(HubEntity entity) {
		HubEntity hubSave = hubRepository.save(entity);
		return hubConvert.toResponse(hubSave);
	}
	
	@Override
	public boolean delete(String hubId) {
		HubEntity entity = hubRepository.findById(hubId).orElse(null);
		if(entity != null) {
			hubRepository.delete(entity);
			return true;
		}
		return false;
	}

}
