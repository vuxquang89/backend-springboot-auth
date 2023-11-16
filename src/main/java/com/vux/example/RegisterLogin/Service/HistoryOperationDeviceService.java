package com.vux.example.RegisterLogin.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vux.example.RegisterLogin.Converter.HistoryOperationDeviceConvert;
import com.vux.example.RegisterLogin.Entity.HubDevice.HistoryOperationDeviceEntity;
import com.vux.example.RegisterLogin.Payload.Response.HistoryOperationDeviceResponse;
import com.vux.example.RegisterLogin.Repo.HistoryOperationDeviceRepository;
import com.vux.example.RegisterLogin.Service.impl.HistoryOperationDeviceImpl;

@Service
public class HistoryOperationDeviceService implements HistoryOperationDeviceImpl {
	
	@Autowired
	private HistoryOperationDeviceRepository historyOperationRepository;
	@Autowired
	private HistoryOperationDeviceConvert convert;

	@Override
	public List<HistoryOperationDeviceResponse> findAllByHubDetailId(Long hubDetailId) {
		List<HistoryOperationDeviceEntity> entities = historyOperationRepository.findByHubDetailIdOrderByCreatedDateDesc(hubDetailId);
		List<HistoryOperationDeviceResponse> responses = new ArrayList<HistoryOperationDeviceResponse>();
		for(HistoryOperationDeviceEntity entity : entities) {
			responses.add(convert.toResponse(entity));
		}
		return responses;
	}

	@Override
	public HistoryOperationDeviceEntity save(HistoryOperationDeviceEntity entity) {
		return historyOperationRepository.save(entity);
	}

}
