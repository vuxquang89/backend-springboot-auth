package com.vux.example.RegisterLogin.Repo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.vux.example.RegisterLogin.Entity.HubDevice.HubDetailEntity;
import com.vux.example.RegisterLogin.Entity.HubDevice.MaintenanceHistoryEntity;

public interface MaintenanceHistoryRepository extends JpaRepository<MaintenanceHistoryEntity, Long> {

	@Transactional
	@Modifying
	@Query(value = "select * from maintenance_history mh inner join hub_detail hd on hd.id = mh.hubdetail_id inner join hub h on h.hub_id = hd.hub_id"
			+ " inner join dbo.[user] u on u.id = h.user_id"
			+ " inner join branch b on b.branch_id = h.branch_id where u.username = ?1 order by mh.maintenance_time,hd.hub_id,hd.device_id,b.branch_id desc;",
			nativeQuery = true)
	List<MaintenanceHistoryEntity> findByUsername(String username);
	
	@Transactional
	@Modifying
	@Query(value = "select * from maintenance_history mh where mh.hubdetail_id = ?1 order by mh.maintenance_time desc;",
			nativeQuery = true)
	List<MaintenanceHistoryEntity> findByHubDetailIdByOrderByMaintenanceTimeDesc(Long hubDetailId);
}
