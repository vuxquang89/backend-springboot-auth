package com.vux.example.RegisterLogin.Service.impl;

import java.util.List;

import com.vux.example.RegisterLogin.Entity.HubDevice.DeviceEntity;

public interface DeviceServiceImpl {

	public List<DeviceEntity> getAll();
	public boolean delete(long id);
	public DeviceEntity save(DeviceEntity device);
}
