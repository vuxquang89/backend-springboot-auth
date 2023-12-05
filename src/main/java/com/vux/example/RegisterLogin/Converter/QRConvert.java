package com.vux.example.RegisterLogin.Converter;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.vux.example.RegisterLogin.Entity.QRImageEntity;
import com.vux.example.RegisterLogin.Entity.QRInfoEntity;
import com.vux.example.RegisterLogin.Entity.UserEntity;
import com.vux.example.RegisterLogin.Payload.Request.QRInfoRequest;
import com.vux.example.RegisterLogin.Payload.Request.UserChangePasswordRequest;
import com.vux.example.RegisterLogin.Payload.Response.QRImageResponse;
import com.vux.example.RegisterLogin.Payload.Response.QRResponse;
import com.vux.example.RegisterLogin.Payload.Response.UserResponseStatus;
import com.vux.example.RegisterLogin.lib.Password;

@Component
public class QRConvert {

	public QRInfoEntity toEntity(QRInfoRequest request) {
		QRInfoEntity entity = new QRInfoEntity();
		entity.setLat(request.getLat());
		entity.setLng(request.getLng());
		entity.setContent(request.getContent());
		entity.setAddress(request.getAddress());
		entity.setDateUpload(request.getDateTakePic());
		return entity;
	}
	
	public QRResponse toResponse(QRInfoEntity entity) {
		QRResponse response = new QRResponse();
		response.setId(entity.getId());
		response.setLat(entity.getLat());
		response.setLng(entity.getLng());
		response.setContent(entity.getContent());
		response.setAddress(entity.getAddress());
		response.setDateUpload(entity.getDateUpload());
		List<QRImageEntity> imageEntities = entity.getQrImages();
		List<QRImageResponse> imageResponses = new ArrayList<QRImageResponse>();
		for(QRImageEntity image : imageEntities) {
			imageResponses.add(toImageResponse(image));
		}
		response.setQrImages(imageResponses);
		return response;
	}
	
	public QRImageResponse toImageResponse(QRImageEntity entity) {
		QRImageResponse response = new QRImageResponse();
		response.setId(entity.getId());
		response.setUri(entity.getPathName()+"/"+entity.getFileName());
		response.setUriResize(entity.getPathName()+"/"+entity.getFileNameResize());
		return response;
	}
	
	
}
