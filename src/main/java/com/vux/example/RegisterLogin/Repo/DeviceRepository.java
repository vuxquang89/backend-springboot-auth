package com.vux.example.RegisterLogin.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vux.example.RegisterLogin.Entity.HubDevice.DeviceEntity;

public interface DeviceRepository extends JpaRepository<DeviceEntity, Long>{

}
