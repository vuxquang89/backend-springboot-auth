package com.vux.example.RegisterLogin.Converter;

import org.springframework.stereotype.Component;

import com.vux.example.RegisterLogin.Entity.HubDevice.HistoryOperationDeviceEntity;
import com.vux.example.RegisterLogin.Payload.Response.HistoryOperationDeviceResponse;
import com.vux.example.RegisterLogin.Util.DateConvert;

@Component
public class HistoryOperationDeviceConvert {

	public HistoryOperationDeviceResponse toResponse(HistoryOperationDeviceEntity entity) {
		HistoryOperationDeviceResponse response = new HistoryOperationDeviceResponse();
		response.setId(entity.getId());
		response.setModifiedBy(entity.getModifiedBy());
		response.setModifiedDate(DateConvert.convertToLocalDateTimeViaInstant(entity.getModifiedDate()));
		response.setCreateBy(entity.getCreatedBy());
		response.setCreateDate(DateConvert.convertToLocalDateTimeViaInstant(entity.getCreatedDate()));
		response.setAction(entity.getAction());
		response.setContent(entity.getContent());
		response.setHubDetailId(entity.getHubDetail().getId());
		return response;
	}
}
