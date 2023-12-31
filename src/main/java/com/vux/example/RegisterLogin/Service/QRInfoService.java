package com.vux.example.RegisterLogin.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.vux.example.RegisterLogin.Entity.QRImageEntity;
import com.vux.example.RegisterLogin.Entity.QRInfoEntity;
import com.vux.example.RegisterLogin.Repo.QRInfoRepository;
import com.vux.example.RegisterLogin.Service.impl.QRInfoServiceImpl;

@Service
public class QRInfoService implements QRInfoServiceImpl{

	@Autowired
	private QRInfoRepository qrInfoRepo;
	
	@Autowired
	private QRImageService qrImageService;
	
	@Override
	public List<QRInfoEntity> getAll() {
		return qrInfoRepo.findAll();
	}
	
	@Override
	public List<QRInfoEntity> getAllByUsername(String username) {
		return qrInfoRepo.findByCreatedByOrderByCreatedDateDesc(username);
	}
	
	@Override
	public List<QRInfoEntity> getAllByUsernameWithPage(String username, Pageable pageable) {
		return qrInfoRepo.findByCreatedByOrderByCreatedDateDesc(username, pageable).getContent();
	}
	
	@Override
	public Optional<QRInfoEntity> getItemById(long id) {
		return qrInfoRepo.findById(id);
	}
	
	@Override
	public boolean delete(long id, String uri) {
		
		try {
			List<QRImageEntity> listQRImage = qrImageService.getQRImageById(id);
			for(QRImageEntity qrImage : listQRImage) {
				deleteFile(qrImage.getPathName() + "/" + qrImage.getFileName());
				deleteFile(qrImage.getPathName() + "/" + qrImage.getFileNameResize());
			}
			
			qrInfoRepo.deleteById(id);
			return true;
		}catch (Exception e) {
			System.out.println("Delete Error: " + e.getMessage());
		}
		return false;
	}
	
	@Override
	public QRInfoEntity save(QRInfoEntity qrInfo) {
		return qrInfoRepo.save(qrInfo);
	}
	
	private boolean deleteFile(String uri) {
		try {
			Path root = Paths.get(uri);
			System.out.println(root.getFileName());
			//Path file = root.resolve(filename);
			return Files.deleteIfExists(root);
		}catch (IOException e) {
			throw new RuntimeException("Error: " + e.getMessage());
		}
	}
}
