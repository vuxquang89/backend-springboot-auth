package com.vux.example.RegisterLogin.Service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;

import com.vux.example.RegisterLogin.Entity.QRInfoEntity;

public interface QRInfoServiceImpl {

	public QRInfoEntity save(QRInfoEntity qrInfo);
	public List<QRInfoEntity> getAll();
	public List<QRInfoEntity> getAllByUsername(String username);
	public List<QRInfoEntity> getAllByUsernameWithPage(String username, Pageable pageable);
	
	public Optional<QRInfoEntity> getItemById(long id);
	public boolean delete(long id, String uri);
}
