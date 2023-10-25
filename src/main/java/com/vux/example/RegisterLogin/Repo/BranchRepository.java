package com.vux.example.RegisterLogin.Repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vux.example.RegisterLogin.Entity.HubDevice.BranchEntity;

public interface BranchRepository extends JpaRepository<BranchEntity, String> {

	public Optional<BranchEntity> findBranchByBranchId(String branchId);
}
