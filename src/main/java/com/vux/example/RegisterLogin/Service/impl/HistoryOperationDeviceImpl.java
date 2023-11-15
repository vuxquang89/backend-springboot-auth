package com.vux.example.RegisterLogin.Service.impl;

import java.util.List;

import com.vux.example.RegisterLogin.Entity.HubDevice.HistoryOperationDeviceEntity;
import com.vux.example.RegisterLogin.Payload.Response.HistoryOperationDeviceResponse;

public interface HistoryOperationDeviceImpl {

	public List<HistoryOperationDeviceResponse> findAllByHubDetailId(Long hubDetailId);
	public HistoryOperationDeviceEntity save(HistoryOperationDeviceEntity entity);
}
