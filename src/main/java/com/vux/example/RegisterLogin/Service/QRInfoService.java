package com.vux.example.RegisterLogin.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vux.example.RegisterLogin.Entity.QRInfoEntity;
import com.vux.example.RegisterLogin.Repo.QRInfoRepository;
import com.vux.example.RegisterLogin.Service.impl.QRInfoServiceImpl;

@Service
public class QRInfoService implements QRInfoServiceImpl{

	@Autowired
	private QRInfoRepository qrInfoRepo;
	
	@Override
	public List<QRInfoEntity> getAll() {
		return qrInfoRepo.findAll();
	}
	
	@Override
	public QRInfoEntity save(QRInfoEntity qrInfo) {
		return qrInfoRepo.save(qrInfo);
	}
}
