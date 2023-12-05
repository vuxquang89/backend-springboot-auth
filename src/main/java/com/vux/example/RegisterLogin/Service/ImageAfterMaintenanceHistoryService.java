package com.vux.example.RegisterLogin.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vux.example.RegisterLogin.Entity.HubDevice.ImageAfterMaintenanceHistory;
import com.vux.example.RegisterLogin.Repo.ImageAfterMaintenanceHistoryRepository;
import com.vux.example.RegisterLogin.Service.impl.ImageAfterMaintenanceHistoryImpl;

@Service
public class ImageAfterMaintenanceHistoryService implements ImageAfterMaintenanceHistoryImpl {

	@Autowired
	private ImageAfterMaintenanceHistoryRepository repository;
	@Override
	public ImageAfterMaintenanceHistory save(ImageAfterMaintenanceHistory entity) {
		return repository.save(entity);
	}
	
	@Override
	public Optional<ImageAfterMaintenanceHistory> findById(Long id) {
		return repository.findById(id);
	}
	
	@Override
	public void delete(ImageAfterMaintenanceHistory entity) {
		repository.delete(entity);
	}
}
