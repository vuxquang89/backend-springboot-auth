package com.vux.example.RegisterLogin.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vux.example.RegisterLogin.Converter.HubDetailConvert;
import com.vux.example.RegisterLogin.Entity.HubDevice.HubDetailEntity;
import com.vux.example.RegisterLogin.Payload.Response.HubDetailAlarmResponse;
import com.vux.example.RegisterLogin.Payload.Response.HubDetailListResponse;
import com.vux.example.RegisterLogin.Payload.Response.HubDetailResponse;
import com.vux.example.RegisterLogin.Payload.Response.HubDetailUserResponse;
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
	public List<HubDetailResponse> getAllManager(String username, String[] roles, String roleName) {
		List<HubDetailEntity> hubDetails = hubDetailRepository.getHubDetails(username);
		
		if(checkRole(roles, roleName)) {
			hubDetails = hubDetailRepository.getHubDetails();
		}
		
		
		List<HubDetailResponse> hubDetailResponses = new ArrayList<HubDetailResponse>();
		for(HubDetailEntity entity : hubDetails) {
			hubDetailResponses.add(hubDetailConvert.toResponse(entity));
		}
		
		return hubDetailResponses;
	}
	
	@Override
	public List<HubDetailListResponse> getAllHubDetailListManager(String username, String[] roles, String roleName) {
		List<HubDetailEntity> hubDetails = hubDetailRepository.getHubDetails(username);
		
		if(checkRole(roles, roleName)) {
			hubDetails = hubDetailRepository.getHubDetails();
		}
		
		List<HubDetailListResponse> hubDetailListResponses = new ArrayList<HubDetailListResponse>();
		for(HubDetailEntity entity : hubDetails) {
			hubDetailListResponses.add(hubDetailConvert.toListResponse(entity));
		}
		return hubDetailListResponses;
	}
	
	
	
	@Override
	public List<HubDetailResponse> findAllWithKeySearch(String keyword) {
		List<HubDetailEntity> hubDetails = hubDetailRepository.findHubDetails(keyword);
		
		List<HubDetailResponse> hubDetailResponses = new ArrayList<HubDetailResponse>();
		for(HubDetailEntity entity : hubDetails) {
			hubDetailResponses.add(hubDetailConvert.toResponse(entity));
		}
		
		return hubDetailResponses;
	}
	
	@Override
	public List<HubDetailResponse> findAllWithKeySearch(String keyword, String username, String[] roles, String roleName) {
		List<HubDetailEntity> hubDetails = hubDetailRepository.findHubDetails(keyword, username);
		
		if(checkRole(roles, roleName)) {
			hubDetails = hubDetailRepository.findHubDetails(keyword);
		}
		
		List<HubDetailResponse> hubDetailResponses = new ArrayList<HubDetailResponse>();
		for(HubDetailEntity entity : hubDetails) {
			hubDetailResponses.add(hubDetailConvert.toResponse(entity));
		}
		
		return hubDetailResponses;
	}
	
	@Override
	public List<HubDetailUserResponse> getAllUser() {
		List<HubDetailEntity> hubDetails = hubDetailRepository.getHubDetails();
		List<HubDetailUserResponse> hubDetailUserResponses = new ArrayList<HubDetailUserResponse>();
		for(HubDetailEntity entity : hubDetails) {
			hubDetailUserResponses.add(hubDetailConvert.toUserResponse(entity));
		}
		return hubDetailUserResponses;
	}
	
	@Override
	public Optional<HubDetailEntity> findById(long hubDetailId) {
		return hubDetailRepository.findById(hubDetailId);
	}
	@Override
	public Optional<HubDetailEntity> findByIdAndUsername(long hubDetailId, String username, String[] roles, String roleName) {
		if(checkRole(roles, roleName)) {
			return hubDetailRepository.findById(hubDetailId);
		}
		return hubDetailRepository.findByIdAndUsername(hubDetailId, username);
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
	
	@Override
	public void delete(HubDetailEntity entity) {
		hubDetailRepository.delete(entity);
	}
	
	@Override
	public void runProcedureUpdateMaintenanceDate() {
//		hubDetailRepository.procedureUpdateMaintenanceDate("update");
		hubDetailRepository.procedureUpdateMaintenanceDate();
	}
	
	@Override
	public List<HubDetailAlarmResponse> getAlarm(String username) {
		List<HubDetailEntity> hubDetails = hubDetailRepository.getHubDetailAlarm(username);
		
		List<HubDetailAlarmResponse> hubDetailResponses = new ArrayList<HubDetailAlarmResponse>();
		for(HubDetailEntity entity : hubDetails) {
			hubDetailResponses.add(hubDetailConvert.toAlarm(entity));
		}
		
		return hubDetailResponses;
	}

	@Override
	public Integer getCountAlarm(String usename) {
		return hubDetailRepository.getHubDetailAlarm(usename).size();
	}

	private boolean checkRole(String[] roles, String roleName) {
		List<String> rolesName = Arrays.asList(roles);
		if(rolesName.contains(roleName)) {
			return true;
		}
		return false;
	}
}
