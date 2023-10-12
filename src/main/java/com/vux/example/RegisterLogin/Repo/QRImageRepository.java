package com.vux.example.RegisterLogin.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vux.example.RegisterLogin.Entity.QRImageEntity;

public interface QRImageRepository extends JpaRepository<QRImageEntity, Long>{

	public List<QRImageEntity> findByQrInfoId(long id);
}
