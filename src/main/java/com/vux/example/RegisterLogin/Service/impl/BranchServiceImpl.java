package com.vux.example.RegisterLogin.Service.impl;

import java.util.List;

import com.vux.example.RegisterLogin.Entity.HubDevice.BranchEntity;
import com.vux.example.RegisterLogin.Payload.Response.BranchResponse;

public interface BranchServiceImpl {

	public List<BranchEntity> getAll();
	public BranchEntity save(BranchEntity entity);
	public boolean delete(String id);
	public BranchResponse findBranchById(String branchId);
	
}
