package com.vux.example.RegisterLogin.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vux.example.RegisterLogin.Entity.QRInfoEntity;

public interface QRInfoRepository extends JpaRepository<QRInfoEntity, Long>{

	public List<QRInfoEntity> findByCreatedBy(String username);
}
