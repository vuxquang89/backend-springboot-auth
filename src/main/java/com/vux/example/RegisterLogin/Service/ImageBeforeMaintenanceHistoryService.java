package com.vux.example.RegisterLogin.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vux.example.RegisterLogin.Entity.HubDevice.ImageBeforeMaintenanceHistory;
import com.vux.example.RegisterLogin.Repo.ImageBeforeMaintenanceHistoryRepository;
import com.vux.example.RegisterLogin.Service.impl.ImageBeforeMaintenanceHistoryImpl;

@Service
public class ImageBeforeMaintenanceHistoryService implements ImageBeforeMaintenanceHistoryImpl {

	@Autowired
	private ImageBeforeMaintenanceHistoryRepository repository;
	
	@Override
	public ImageBeforeMaintenanceHistory save(ImageBeforeMaintenanceHistory entity) {
		return repository.save(entity);
	}
	
	@Override
	public Optional<ImageBeforeMaintenanceHistory> findById(Long id) {
		return repository.findById(id);
	}
	@Override
	public void delete(ImageBeforeMaintenanceHistory entity) {
		repository.delete(entity);
	}
}
