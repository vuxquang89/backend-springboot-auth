package com.vux.example.RegisterLogin.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vux.example.RegisterLogin.Entity.HubDevice.StaffLeaderEntity;

public interface StaffLeaderRepository extends JpaRepository<StaffLeaderEntity, Long> {

}
