package com.vux.example.RegisterLogin.Repo;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.vux.example.RegisterLogin.Entity.QRInfoEntity;

public interface QRInfoRepository extends JpaRepository<QRInfoEntity, Long>{

	public List<QRInfoEntity> findByCreatedByOrderByCreatedDateDesc(String username);
	
	public Page<QRInfoEntity> findByCreatedByOrderByCreatedDateDesc(String username, Pageable page);
}
