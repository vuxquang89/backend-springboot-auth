package com.vux.example.RegisterLogin.Service.impl;

import java.util.Optional;

import com.vux.example.RegisterLogin.Entity.HubDevice.ImageBeforeMaintenanceHistory;

public interface ImageBeforeMaintenanceHistoryImpl {

	public ImageBeforeMaintenanceHistory save(ImageBeforeMaintenanceHistory entity);
	public Optional<ImageBeforeMaintenanceHistory> findById(Long id);
	public void delete(ImageBeforeMaintenanceHistory entity);
}
