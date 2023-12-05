package com.vux.example.RegisterLogin.Repo;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.vux.example.RegisterLogin.Entity.HubDevice.BranchEntity;
import com.vux.example.RegisterLogin.Entity.HubDevice.HubEntity;

public interface HubRepository extends JpaRepository<HubEntity, String>{

	@Transactional
	@Modifying
	@Query(value = "select * from hub h "
			+ "inner join staff_department sd on sd.id = h.staff_department_id "
			+ "	INNER JOIN staff_branch sb on sb.id = h.staff_branch_id "
			+ "	inner join branch b on b.branch_id = h.branch_id "
			+ "	INNER JOIN staff_leader sl on sl.branch_id = b.branch_id"
			+ "	where sd.username = ?1 or sl.username = ?1 or sb.username = ?1"
			+ " ORDER BY h.hub_id ASC;",
			nativeQuery = true)
	public List<HubEntity> findByPersonnelChargeName(String username);
	public List<HubEntity> findBybranchEntity(String branchName);
	public List<HubEntity> findByOrderByBranchEntityAsc();
	public List<HubEntity> findByBranchEntity(BranchEntity entity);
	public Optional<HubEntity> findByHubId(String hubId);
}
