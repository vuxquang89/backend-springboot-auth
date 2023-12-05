package com.vux.example.RegisterLogin.Converter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.vux.example.RegisterLogin.Entity.HubDevice.ImageAfterMaintenanceHistory;
import com.vux.example.RegisterLogin.Entity.HubDevice.ImageBeforeMaintenanceHistory;
import com.vux.example.RegisterLogin.Entity.HubDevice.MaintenanceHistoryEntity;
import com.vux.example.RegisterLogin.Payload.Request.MaintenanceHistoryRequest;
import com.vux.example.RegisterLogin.Payload.Response.ImageAfterMaintenanceHistoryResponse;
import com.vux.example.RegisterLogin.Payload.Response.MaintenanceHistoryResponse;
import com.vux.example.RegisterLogin.Util.LocalDateConvert;

@Component
public class MaintenanceHistoryConvert {
	
	@Autowired
	private HubDetailConvert hubDetailConvert;
	@Autowired
	private ImageAfterMaintenanceHistoryConvert imageAfterMaintenanceHistoryConvert;
	@Autowired
	private ImageBeforeMaintenanceHistoryConvert imageBeforeMaintenanceHistoryConvert;
	
	public MaintenanceHistoryResponse toResponse(MaintenanceHistoryEntity entity) {
		MaintenanceHistoryResponse response = new MaintenanceHistoryResponse();
		response.setId(entity.getId());
		response.setHubDetailResponse(hubDetailConvert.toResponse(entity.getHubDetail()));
		response.setMaintenanceTime(entity.getMaintenanceTime().toString());
		response.setMaintenanceNote(entity.getMaintenanceNote());
		
		List<ImageAfterMaintenanceHistory> listImageAfterMaintenanceHistories = entity.getImageAfterMaintenanceHistories();
//		List<ImageAfterMaintenanceHistoryResponse> imageAfterMaintenanceHistoryResponses = new ArrayList<>();
		if(listImageAfterMaintenanceHistories != null && 
				listImageAfterMaintenanceHistories.size() > 0) {
			for(ImageAfterMaintenanceHistory after : listImageAfterMaintenanceHistories) {
//				imageAfterMaintenanceHistoryResponses.add(imageAfterMaintenanceHistoryConvert.toResponse(after));
				response.addImageAfterMaintenanceHistoryResponse(imageAfterMaintenanceHistoryConvert.toResponse(after));
			}
			
		}
		
		List<ImageBeforeMaintenanceHistory> listImageBeforeMaintenanceHistories = entity.getImageBeforeMaintenanceHistories();
		if(listImageBeforeMaintenanceHistories != null && 
				listImageBeforeMaintenanceHistories.size() > 0) {
			for(ImageBeforeMaintenanceHistory before : listImageBeforeMaintenanceHistories) {
//				imageAfterMaintenanceHistoryResponses.add(imageAfterMaintenanceHistoryConvert.toResponse(after));
				response.addImageBeforeMaintenanceHistoryResponse(imageBeforeMaintenanceHistoryConvert.toResponse(before));
			}
			
		}
		
		
		
		return response;
	}
	
	
	public MaintenanceHistoryEntity toEntity(MaintenanceHistoryRequest request) {
		MaintenanceHistoryEntity entity = new MaintenanceHistoryEntity();
		String date = LocalDateConvert.stringToDateString(request.getMaintenanceTime());
		entity.setMaintenanceTime(LocalDate.parse(date));
		entity.setMaintenanceNote(request.getMaintenanceNote());
		return entity;
	}
}
