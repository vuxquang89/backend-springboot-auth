package com.vux.example.RegisterLogin.test.qrinfo;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.vux.example.RegisterLogin.Entity.QRImageEntity;
import com.vux.example.RegisterLogin.Entity.QRInfoEntity;
import com.vux.example.RegisterLogin.Repo.QRInfoRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class QRInfoRepositotyTest {
	@Autowired
	private QRInfoRepository respo;

	@Test
	public void getQRInfo() {
		List<QRInfoEntity> qrInfos = respo.findAll();
		
		for(QRInfoEntity qr : qrInfos) {
			System.out.println(qr.getContent());
			Set<QRImageEntity> images = qr.getQrImages();
			List<QRImageEntity> arr = images.stream().collect(Collectors.toList());
			System.out.println("images => ");
			for(QRImageEntity image : arr) {
				System.out.println(image.getFileName());
			}
		}
		
		assertThat(qrInfos).isNotNull();
	}
}
