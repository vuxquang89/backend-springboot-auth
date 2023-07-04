package com.vux.example.RegisterLogin.Converter;

import org.springframework.stereotype.Component;

import com.vux.example.RegisterLogin.Entity.QRInfoEntity;
import com.vux.example.RegisterLogin.Payload.Request.QRInfoRequest;

@Component
public class QRConvert {

	public QRInfoEntity toEntity(QRInfoRequest request) {
		QRInfoEntity entity = new QRInfoEntity();
		entity.setLat(request.getLat());
		entity.setLng(request.getLng());
		entity.setContent(request.getContent());
		return entity;
	}
}
