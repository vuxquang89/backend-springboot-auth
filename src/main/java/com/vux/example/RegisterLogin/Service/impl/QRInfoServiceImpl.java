package com.vux.example.RegisterLogin.Service.impl;

import java.util.List;

import com.vux.example.RegisterLogin.Entity.QRInfoEntity;

public interface QRInfoServiceImpl {

	public QRInfoEntity save(QRInfoEntity qrInfo);
	public List<QRInfoEntity> getAll();
}
