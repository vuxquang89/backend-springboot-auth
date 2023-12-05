package com.vux.example.RegisterLogin.Converter;

import org.springframework.stereotype.Component;

import com.vux.example.RegisterLogin.Entity.HubDevice.ImageAfterMaintenanceHistory;
import com.vux.example.RegisterLogin.Payload.Response.ImageAfterMaintenanceHistoryResponse;

@Component
public class ImageAfterMaintenanceHistoryConvert {

	public ImageAfterMaintenanceHistoryResponse toResponse(ImageAfterMaintenanceHistory entity) {
		ImageAfterMaintenanceHistoryResponse response = new ImageAfterMaintenanceHistoryResponse();
		response.setId(entity.getId());
		response.setImageName(entity.getImageName());
		response.setImageNameResize(entity.getImageNameResize());
		response.setPath(entity.getPath() +"/" +entity.getImageName() );
		response.setPathResize(entity.getPath() +"/" +entity.getImageNameResize());
		response.setTypeFile(entity.getTypeFile());
		return response;
	}
}
