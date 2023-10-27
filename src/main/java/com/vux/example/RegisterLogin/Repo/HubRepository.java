package com.vux.example.RegisterLogin.Repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vux.example.RegisterLogin.Entity.HubDevice.BranchEntity;
import com.vux.example.RegisterLogin.Entity.HubDevice.HubEntity;

public interface HubRepository extends JpaRepository<HubEntity, String>{

	public List<HubEntity> findByPersonnelChargeName(String username);
	public List<HubEntity> findBybranchEntity(String branchName);
	public List<HubEntity> findByOrderByBranchEntityAsc();
	public List<HubEntity> findByBranchEntity(BranchEntity entity);
	public Optional<HubEntity> findByHubId(String hubId);
}
