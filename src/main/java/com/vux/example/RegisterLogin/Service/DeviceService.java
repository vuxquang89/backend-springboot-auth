package com.vux.example.RegisterLogin.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vux.example.RegisterLogin.Entity.HubDevice.DeviceEntity;
import com.vux.example.RegisterLogin.Repo.DeviceRepository;
import com.vux.example.RegisterLogin.Service.impl.DeviceServiceImpl;

@Service
public class DeviceService implements DeviceServiceImpl {
	
	@Autowired
	private DeviceRepository deviceRepository;

	@Override
	public boolean delete(long id) {
		if(deviceRepository.findById(id) != null) {
			deviceRepository.deleteById(id);
			return true;
		}
		return false;
	}

	@Override
	public List<DeviceEntity> getAll() {
		return deviceRepository.findAll();
	}

	@Override
	public DeviceEntity save(DeviceEntity device) {
		
		return deviceRepository.save(device);
	}
	@Override
	public Optional<DeviceEntity> findById(Long deviceId) {
		return deviceRepository.findById(deviceId);
	}
	
}
