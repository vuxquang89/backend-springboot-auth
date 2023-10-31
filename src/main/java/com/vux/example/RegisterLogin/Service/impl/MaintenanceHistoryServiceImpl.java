package com.vux.example.RegisterLogin.Service.impl;

import java.util.List;
import java.util.Optional;

import com.vux.example.RegisterLogin.Entity.HubDevice.MaintenanceHistoryEntity;
import com.vux.example.RegisterLogin.Payload.Response.MaintenanceHistoryResponse;

public interface MaintenanceHistoryServiceImpl {

	public MaintenanceHistoryEntity save(MaintenanceHistoryEntity entity);
	public boolean delete(Long entityId);
	public Optional<MaintenanceHistoryEntity> findById(Long id);
	public List<MaintenanceHistoryResponse> findAll();
	public List<MaintenanceHistoryResponse> findByUsername(String username);
	public List<MaintenanceHistoryResponse> findByHubDetailId(Long hubDetailId);
}
