package com.vux.example.RegisterLogin.Service.impl;

import java.util.Optional;

import com.vux.example.RegisterLogin.Entity.HubDevice.ImageAfterMaintenanceHistory;

public interface ImageAfterMaintenanceHistoryImpl {

	public ImageAfterMaintenanceHistory save(ImageAfterMaintenanceHistory entity);
	public Optional<ImageAfterMaintenanceHistory> findById(Long id);
	public void delete(ImageAfterMaintenanceHistory entity);
}
