package com.vux.example.RegisterLogin.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vux.example.RegisterLogin.Converter.HubDetailAfterChangeConvert;
import com.vux.example.RegisterLogin.Entity.HubDevice.HubDetailAfterChange;
import com.vux.example.RegisterLogin.Payload.Response.HubDetailAfterChangeResponse;
import com.vux.example.RegisterLogin.Repo.HubDetailAfterChangeRepository;
import com.vux.example.RegisterLogin.Service.impl.HubDetailAfterChangeImpl;

@Service
public class HubDetailAfterChangeService implements HubDetailAfterChangeImpl {

	@Autowired
	private HubDetailAfterChangeRepository hubDetailAfterChangeRepository;
	@Autowired
	private HubDetailAfterChangeConvert hubDetailAfterChangeConvert;
	
	@Override
	public HubDetailAfterChange save(HubDetailAfterChange entity) {
		return hubDetailAfterChangeRepository.save(entity);
	}
	
	@Override
	public List<HubDetailAfterChangeResponse> findByHubDetailId(Long hubDetailId) {
		List<HubDetailAfterChange> list = hubDetailAfterChangeRepository.findByHistoryChangeIdOrderByCreatedDateDesc(hubDetailId);
		List<HubDetailAfterChangeResponse> responses = new ArrayList<>();
		for(HubDetailAfterChange entity : list) {
			responses.add(hubDetailAfterChangeConvert.toResponse(entity));
		}
		return responses;
	}
}
