package com.vux.example.RegisterLogin.Service.impl;

import java.util.List;

import com.vux.example.RegisterLogin.Entity.HubDevice.BranchEntity;
import com.vux.example.RegisterLogin.Entity.HubDevice.HubEntity;
import com.vux.example.RegisterLogin.Payload.Response.HubAdminResponse;
import com.vux.example.RegisterLogin.Payload.Response.HubResponse;

public interface HubServiceImpl {

	public List<HubAdminResponse> getAll();
	public List<HubResponse> getHubByUser(String username);
	public List<HubAdminResponse> findAdminByBranchId(BranchEntity entity);
	public List<HubResponse> findByBranchId(BranchEntity entity);
	public HubEntity findByHubId(String hubId);
	public HubResponse save(HubEntity entity);
	public boolean delete(String hubId);
}
