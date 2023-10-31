package com.vux.example.RegisterLogin.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vux.example.RegisterLogin.Converter.HubDetailConvert;
import com.vux.example.RegisterLogin.Entity.HubDevice.HubDetailEntity;
import com.vux.example.RegisterLogin.Payload.Response.HubDetailResponse;
import com.vux.example.RegisterLogin.Repo.HubDetailRepository;
import com.vux.example.RegisterLogin.Service.impl.HubDetailServiceImpl;

@Service
public class HubDetailService implements HubDetailServiceImpl {
	
	@Autowired
	private HubDetailRepository hubDetailRepository;
	
	@Autowired
	private HubDetailConvert hubDetailConvert;

	@Override
	public List<HubDetailResponse> getAll() {
		List<HubDetailEntity> hubDetails = hubDetailRepository.getHubDetails();
		
		List<HubDetailResponse> hubDetailResponses = new ArrayList<HubDetailResponse>();
		for(HubDetailEntity entity : hubDetails) {
			hubDetailResponses.add(hubDetailConvert.toResponse(entity));
		}
		
		return hubDetailResponses;
	}
	
	@Override
	public Optional<HubDetailEntity> findById(long hubDetailId) {
		return hubDetailRepository.findById(hubDetailId);
	}
	
	@Override
	public HubDetailEntity save(HubDetailEntity entity) {
		return hubDetailRepository.save(entity);
	}
	@Override
	public boolean delete(long hubDetailId) {
		HubDetailEntity entity = hubDetailRepository.findById(hubDetailId).orElse(null);
		
		if(entity != null) {
			hubDetailRepository.delete(entity);
			return true;
		}
		return false;
	}

}