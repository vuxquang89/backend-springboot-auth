package com.vux.example.RegisterLogin.Service.impl;

import java.util.List;
import java.util.Optional;

import com.vux.example.RegisterLogin.Entity.HubDevice.HubDetailEntity;
import com.vux.example.RegisterLogin.Payload.Response.HubDetailResponse;

public interface HubDetailServiceImpl {

	public List<HubDetailResponse> getAll();
	public Optional<HubDetailEntity> findById(long hubDetailId);
	public HubDetailEntity save(HubDetailEntity entity);
	public boolean delete(long hubDetailId);
}
