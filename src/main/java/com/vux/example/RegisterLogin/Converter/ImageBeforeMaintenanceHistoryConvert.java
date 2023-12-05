package com.vux.example.RegisterLogin.Converter;

import org.springframework.stereotype.Component;

import com.vux.example.RegisterLogin.Entity.HubDevice.ImageBeforeMaintenanceHistory;
import com.vux.example.RegisterLogin.Payload.Response.ImageBeforeMaintenanceHistoryResponse;

@Component
public class ImageBeforeMaintenanceHistoryConvert {

	public ImageBeforeMaintenanceHistoryResponse toResponse(ImageBeforeMaintenanceHistory entity) {
		ImageBeforeMaintenanceHistoryResponse response = new ImageBeforeMaintenanceHistoryResponse();
		response.setId(entity.getId());
		response.setImageName(entity.getImageName());
		response.setImageNameResize(entity.getImageNameResize());
		response.setPath(entity.getPath() +"/" +entity.getImageName() );
		response.setPathResize(entity.getPath() +"/" +entity.getImageNameResize());
		response.setTypeFile(entity.getTypeFile());
		return response;
	}
}
