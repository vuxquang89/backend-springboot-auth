package com.vux.example.RegisterLogin.Service.impl;

import java.util.List;
import java.util.Optional;

import com.vux.example.RegisterLogin.Entity.HubDevice.DeviceEntity;

public interface DeviceServiceImpl {

	public List<DeviceEntity> getAll();
	public boolean delete(long id);
	public DeviceEntity save(DeviceEntity device);
	public Optional<DeviceEntity> findById(Long deviceId);
}
