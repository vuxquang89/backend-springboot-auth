package com.vux.example.RegisterLogin.Service.impl;

import java.util.List;
import java.util.Optional;

import com.vux.example.RegisterLogin.Entity.HubDevice.HubDetailEntity;
import com.vux.example.RegisterLogin.Payload.Response.HubDetailAlarmResponse;
import com.vux.example.RegisterLogin.Payload.Response.HubDetailListResponse;
import com.vux.example.RegisterLogin.Payload.Response.HubDetailResponse;
import com.vux.example.RegisterLogin.Payload.Response.HubDetailUserResponse;

public interface HubDetailServiceImpl {

	public List<HubDetailResponse> getAll();
	
	public List<HubDetailResponse> getAllManager(String username);
	public List<HubDetailListResponse> getAllHubDetailListManager(String username);
	
	public List<HubDetailResponse> findAllWithKeySearch(String keyword);
	public List<HubDetailResponse> findAllWithKeySearch(String keyword, String username);
	public Optional<HubDetailEntity> findById(long hubDetailId);
	public Optional<HubDetailEntity> findByIdAndUsername(long hubDetailId, String username);
	public HubDetailEntity save(HubDetailEntity entity);
	public boolean delete(long hubDetailId);
	public void delete(HubDetailEntity entity);
	
	public List<HubDetailAlarmResponse> getAlarm(String username);
	public Integer getCountAlarm(String usename);
	public List<HubDetailUserResponse> getAllUser();
	public void runProcedureUpdateMaintenanceDate();
}
