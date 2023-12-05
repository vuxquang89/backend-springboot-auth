package com.vux.example.RegisterLogin.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vux.example.RegisterLogin.Entity.HubDevice.HubDetailAfterChange;

@Repository
public interface HubDetailAfterChangeRepository extends JpaRepository<HubDetailAfterChange, Long>{
	
	public List<HubDetailAfterChange> findByHistoryChangeIdOrderByCreatedDateDesc(Long hubDetailId);

}
