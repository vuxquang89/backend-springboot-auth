package com.vux.example.RegisterLogin.Service.impl;

import java.util.List;

import com.vux.example.RegisterLogin.Entity.HubDevice.BranchEntity;
import com.vux.example.RegisterLogin.Entity.HubDevice.HubEntity;
import com.vux.example.RegisterLogin.Payload.Response.HubResponse;

public interface HubServiceImpl {

	public List<HubResponse> getAll();
	public List<HubResponse> getHubByUser(String username);
	public List<HubResponse> findByBranchId(BranchEntity entity);
	public HubEntity findByHubId(String hubId);
	public HubResponse save(HubEntity entity);
	public boolean delete(String hubId);
}
