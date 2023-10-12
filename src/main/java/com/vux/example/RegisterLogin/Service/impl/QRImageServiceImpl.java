package com.vux.example.RegisterLogin.Service.impl;

import java.util.List;

import com.vux.example.RegisterLogin.Entity.QRImageEntity;

public interface QRImageServiceImpl {

	public QRImageEntity save(QRImageEntity qrImage);
	public List<QRImageEntity> getQRImageById(long id);
}
