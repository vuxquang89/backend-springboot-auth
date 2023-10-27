package com.vux.example.RegisterLogin.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vux.example.RegisterLogin.Converter.BranchConvert;
import com.vux.example.RegisterLogin.Entity.HubDevice.BranchEntity;
import com.vux.example.RegisterLogin.Payload.Response.BranchResponse;
import com.vux.example.RegisterLogin.Repo.BranchRepository;
import com.vux.example.RegisterLogin.Service.impl.BranchServiceImpl;

@Service
public class BranchService implements BranchServiceImpl {
	
	@Autowired
	private BranchRepository branchRepository;
	
	@Autowired
	private BranchConvert convert;

	@Override
	public List<BranchEntity> getAll() {
		return branchRepository.findAll();
	}
	@Override
	public BranchEntity save(BranchEntity entity) {
		return branchRepository.save(entity);
	}

	@Override
	public boolean delete(String id) {
		if(branchRepository.findById(id) != null) {
			branchRepository.deleteById(id);
			return true;
		}
		return false;
	}

	@Override
	public BranchResponse findBranchById(String branchId) {
		BranchEntity entity = branchRepository.findBranchByBranchId(branchId).orElse(null);
		BranchResponse response = new BranchResponse();
		if(entity != null)
			response = convert.toResponse(entity);
		return response;
	}
	@Override
	public BranchEntity findByBranchId(String branchId) {
		return branchRepository.findBranchByBranchId(branchId).orElse(null);
	}
}
