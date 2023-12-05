package com.vux.example.RegisterLogin.Converter;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.vux.example.RegisterLogin.Entity.HubDevice.HubDetailEntity;
import com.vux.example.RegisterLogin.Entity.HubDevice.HubEntity;
import com.vux.example.RegisterLogin.Payload.Request.HubRequest;
import com.vux.example.RegisterLogin.Payload.Response.HubAdminResponse;
import com.vux.example.RegisterLogin.Payload.Response.HubResponse;
import com.vux.example.RegisterLogin.Payload.Response.SelectResponse;

@Component
public class HubConvert {
	
	@Autowired
	private BranchConvert branchConvert;
	@Autowired
	private HubDetailConvert hubDetailConvert;
	@Autowired
	private StaffDepartmentConvert staffDepartmentConvert;
	@Autowired
	private StaffBranchConvert staffBranchConvert;

	public HubAdminResponse toAdminResponse(HubEntity entity) {
		HubAdminResponse response = new HubAdminResponse();
		response.setHubId(entity.getHubId());
		response.setHubAddress(entity.getHubAddress());
		response.setHubCity(entity.getHubCity());
		response.setBranchName(entity.getBranchEntity().getBranchName());
		response.setHubManagerName(entity.getStaffBranch().getHubManagerName());
		response.setHubManagerPhone(entity.getStaffBranch().getHubManagerPhone());
		response.setHubName(entity.getHubName());
		response.setDepartmentName(entity.getStaffDepartment().getFullname());
		response.setDepartmentPhone(entity.getStaffDepartment().getPhone());
		
		return response;
		
	}
	
	public HubResponse toResponse(HubEntity entity) {
		HubResponse response = new HubResponse();
		response.setHubId(entity.getHubId());
		response.setHubName(entity.getHubName());
		response.setHubManagerName(entity.getStaffBranch().getHubManagerName());
		response.setHubManagerPhone(entity.getStaffBranch().getHubManagerPhone());
		response.setHubCity(entity.getHubCity());
		response.setHubAddress(entity.getHubAddress());
		response.setDepartmentResponse(staffDepartmentConvert.toResponse(entity.getStaffDepartment()));
		response.setManagerResponse(staffBranchConvert.toStaffBranchResponse(entity.getStaffBranch()));
		
		response.setBranchResponse(branchConvert.toResponse(entity.getBranchEntity()));
		if(entity.getHubDetails() != null && entity.getHubDetails().size() > 0) {
			for(HubDetailEntity hubDetailEntity : entity.getHubDetails()) {
				response.addHubDetailResponse(hubDetailConvert.toResponse(hubDetailEntity));
			}			
		}
		
		return response;
	}
	
	public HubEntity toEntity(HubRequest request) {
		HubEntity entity = new HubEntity();
		entity.setHubName(request.getHubName());
		entity.setHubAddress(request.getHubAddress());
		entity.setHubCity(request.getHubCity());
		
		return entity;
	}
	
	public HubEntity toUpdateEntity(HubEntity entity, HubRequest request) {
		
		entity.setHubName(request.getHubName());
		entity.setHubAddress(request.getHubAddress());
		entity.setHubCity(request.getHubCity());
//		entity.getStaffBranch().setHubManagerName(request.getHubManagerName());
//		entity.getStaffBranch().setHubManagerPhone(request.getHubManagerPhone());
		return entity;
	}
	
	public SelectResponse toHubSelect(HubEntity entity) {
		SelectResponse branchSelectResponse = new SelectResponse();
		branchSelectResponse.setValue(entity.getHubId());
		branchSelectResponse.setLabel(entity.getHubName());
		return branchSelectResponse;
	}
	public SelectResponse toHubSelect(HubResponse response) {
		SelectResponse branchSelectResponse = new SelectResponse();
		branchSelectResponse.setValue(response.getHubId());
		branchSelectResponse.setLabel(response.getHubName());
		return branchSelectResponse;
	}
}
