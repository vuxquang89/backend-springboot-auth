package com.vux.example.RegisterLogin.Repo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.vux.example.RegisterLogin.Entity.HubDevice.HubDetailEntity;

public interface HubDetailRepository extends JpaRepository<HubDetailEntity, Long>{

	@Transactional
	@Modifying
	@Query(value = "select * from hub_detail hd inner join hub h on h.hub_id = hd.hub_id"
			+ " inner join dbo.[user] u on u.id = h.user_id"
			+ " inner join branch b on b.branch_id = h.branch_id order by hd.hub_id,hd.device_id,b.branch_id asc;",
			nativeQuery = true)
	List<HubDetailEntity> getHubDetails();
}
