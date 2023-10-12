package com.vux.example.RegisterLogin.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vux.example.RegisterLogin.Entity.QRImageEntity;
import com.vux.example.RegisterLogin.Repo.QRImageRepository;
import com.vux.example.RegisterLogin.Service.impl.QRImageServiceImpl;

@Service
public class QRImageService implements QRImageServiceImpl{
	
	@Autowired
	private QRImageRepository qrImageRepository;

	@Override
	public QRImageEntity save(QRImageEntity qrImage) {
		return qrImageRepository.save(qrImage);
	}
	
	@Override
	public List<QRImageEntity> getQRImageById(long id) {
		return qrImageRepository.findByQrInfoId(id);
	}
}
