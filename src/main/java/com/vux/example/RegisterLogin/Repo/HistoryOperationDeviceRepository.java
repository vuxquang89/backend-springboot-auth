package com.vux.example.RegisterLogin.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vux.example.RegisterLogin.Entity.HubDevice.HistoryOperationDeviceEntity;

public interface HistoryOperationDeviceRepository extends JpaRepository<HistoryOperationDeviceEntity, Long> {

	public List<HistoryOperationDeviceEntity> findByHubDetailIdOrderByCreatedDateDesc(Long hubDetailId);
}
