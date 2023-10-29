package com.vux.example.RegisterLogin.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vux.example.RegisterLogin.Converter.MaintenanceHistoryConvert;
import com.vux.example.RegisterLogin.Entity.HubDevice.MaintenanceHistoryEntity;
import com.vux.example.RegisterLogin.Payload.Response.MaintenanceHistoryResponse;
import com.vux.example.RegisterLogin.Repo.MaintenanceHistoryRepository;
import com.vux.example.RegisterLogin.Service.impl.MaintenanceHistoryServiceImpl;

@Service
public class MaintenanceHistoryService implements MaintenanceHistoryServiceImpl {

	@Autowired
	private MaintenanceHistoryRepository repository;
	@Autowired
	private MaintenanceHistoryConvert convert;
	
	@Override
	public MaintenanceHistoryEntity save(MaintenanceHistoryEntity entity) {
		return repository.save(entity);
	}

	@Override
	public boolean delete(Long entityId) {
		MaintenanceHistoryEntity entityDelete = repository.findById(entityId).orElse(null);
		if(entityDelete != null) {
			repository.delete(entityDelete);
			return true;
		}
		return false;
	}

	@Override
	public List<MaintenanceHistoryResponse> findAll() {
		List<MaintenanceHistoryEntity> entities = repository.findAll();
		List<MaintenanceHistoryResponse> responses = new ArrayList<MaintenanceHistoryResponse>();
		for(MaintenanceHistoryEntity entity : entities) {
			responses.add(convert.toResponse(entity));
		}
		return responses;
	}

	@Override
	public List<MaintenanceHistoryResponse> findByUsername(String username) {
		List<MaintenanceHistoryEntity> entities = repository.findByUsername(username);
		List<MaintenanceHistoryResponse> responses = new ArrayList<MaintenanceHistoryResponse>();
		for(MaintenanceHistoryEntity entity : entities) {
			responses.add(convert.toResponse(entity));
		}
		return responses;
	}

}
