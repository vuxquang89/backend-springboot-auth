package com.vux.example.RegisterLogin.Repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vux.example.RegisterLogin.Entity.HubDevice.StaffLeaderEntity;

public interface StaffLeaderRepository extends JpaRepository<StaffLeaderEntity, Long> {

	public Optional<StaffLeaderEntity> findByUsername(String username);
}
