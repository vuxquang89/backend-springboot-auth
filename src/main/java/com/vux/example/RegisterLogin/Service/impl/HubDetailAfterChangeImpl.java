package com.vux.example.RegisterLogin.Service.impl;

import java.util.List;

import com.vux.example.RegisterLogin.Entity.HubDevice.HubDetailAfterChange;
import com.vux.example.RegisterLogin.Payload.Response.HubDetailAfterChangeResponse;

public interface HubDetailAfterChangeImpl {

	public HubDetailAfterChange save(HubDetailAfterChange entity);
	public List<HubDetailAfterChangeResponse> findByHubDetailId(Long hubDetailId);
}
