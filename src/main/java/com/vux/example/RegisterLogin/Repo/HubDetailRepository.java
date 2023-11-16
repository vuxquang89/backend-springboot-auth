package com.vux.example.RegisterLogin.Repo;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

import com.vux.example.RegisterLogin.Entity.HubDevice.HubDetailEntity;

@Repository
public interface HubDetailRepository extends JpaRepository<HubDetailEntity, Long>{

	@Transactional
	@Modifying
	@Query(value = "select * from hub_detail hd inner join hub h on h.hub_id = hd.hub_id"
//			+ " inner join dbo.[user] u on u.id = h.user_id"
			+ " inner join users u on u.id = h.user_id"
			+ "	inner join branch b on b.branch_id = h.branch_id where hd.status_delete = 0"
			+ "	order by b.branch_id,hd.hub_id,hd.device_id asc;",
			nativeQuery = true)
	List<HubDetailEntity> getHubDetails();
	
//	@Transactional
//	@Modifying(clearAutomatically = true)
	@Query(value = "select * from hub_detail hd inner join hub h on h.hub_id = hd.hub_id"
			+ " inner join users u on u.id = h.user_id"
			+ "	inner join branch b on b.branch_id = h.branch_id"
			+ "	where hd.id = ?1 and u.username = ?2 and hd.status_delete = 0",
			nativeQuery = true)
	Optional<HubDetailEntity> findByIdAndUsername(long hubDetailId, String username);
	
	@Transactional
	@Modifying
	@Query(value = "select * from hub_detail hd inner join hub h on h.hub_id = hd.hub_id"
//			+ " inner join dbo.[user] u on u.id = h.user_id"
			+ " inner join users u on u.id = h.user_id"
			+ "	inner join branch b on b.branch_id = h.branch_id where u.username = ?1 and hd.status_delete = 0"
			+ "	order by b.branch_id,hd.hub_id,hd.device_id asc;",
			nativeQuery = true)
	List<HubDetailEntity> getHubDetails(String username);
	
	@Transactional
	@Modifying
	@Query(value = "select * from hub_detail hd inner join hub h on h.hub_id = hd.hub_id"
//			+ " inner join dbo.[user] u on u.id = h.user_id"
			+ " inner join users u on u.id = h.user_id"
			+ "	inner join branch b on b.branch_id = h.branch_id where hd.status_delete = 0 and (h.hub_id like %?1% or b.branch_name like %?1% or h.hub_name like %?1%)"
			+ "	order by b.branch_id,hd.hub_id,hd.device_id asc;",
			nativeQuery = true)
	List<HubDetailEntity> findHubDetails(String keyword);
	
	
	@Transactional
	@Modifying
	@Query(value = "select * from hub_detail hd inner join hub h on h.hub_id = hd.hub_id"
//			+ " inner join dbo.[user] u on u.id = h.user_id"
			+ " inner join users u on u.id = h.user_id"
			+ "	inner join branch b on b.branch_id = h.branch_id where u.username = ?2 and hd.status_delete = 0 and (h.hub_id like %?1% or b.branch_name like %?1% or h.hub_name like %?1%)"
			+ "	order by b.branch_id,hd.hub_id,hd.device_id asc;",
			nativeQuery = true)
	List<HubDetailEntity> findHubDetails(String keyword, String username);
	
	
//	@Transactional
//	@Modifying
	@Query(value = "select count(*) from hub_detail hd inner join hub h on h.hub_id = hd.hub_id"
			+ "	inner join users u on u.id = h.user_id"
			+ "	inner join branch b on b.branch_id = h.branch_id where u.username = ?1 and hd.alarm_maintenance = 1 and hd.status_delete = 0;",
			nativeQuery = true)
	Long getHubDetailCountAlarm(String username);
	
	
	@Transactional
	@Modifying
	@Query(value = "select * from hub_detail hd inner join hub h on h.hub_id = hd.hub_id"
//			+ "	inner join dbo.[user] u on u.id = h.user_id"
			+ " inner join users u on u.id = h.user_id"
			+ "	inner join branch b on b.branch_id = h.branch_id where u.username = ?1 and hd.alarm_maintenance = 1 and hd.status_delete = 0;",			
			nativeQuery = true)
	List<HubDetailEntity> getHubDetailAlarm(String username);
	
//	@Transactional
//	@Modifying
//	@Query(value = "select * from hub_detail hd inner join hub h on h.hub_id = hd.hub_id"
//			+ "	inner join dbo.[user] u on u.id = h.user_id"
//			+ "	inner join branch b on b.branch_id = h.branch_id where u.username = ?1 and hd.alarm_maintenance = 1 order by b.branch_id,hd.hub_id,hd.device_id asc;",
//			nativeQuery = true)
//	List<HubDetailEntity> getHubDetailAlarm();
	
//	@Procedure(name = "HubDetailEntity.updateMaintenanceDate")	
//	void procedureUpdateMaintenanceDate(@Param("Action") String action);
	
	@Procedure("procedure_update_maintenance_date")
	void procedureUpdateMaintenanceDate();
	
}
