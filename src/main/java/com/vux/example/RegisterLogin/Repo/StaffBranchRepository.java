package com.vux.example.RegisterLogin.Repo;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.vux.example.RegisterLogin.Entity.HubDevice.StaffBranchEntity;

public interface StaffBranchRepository extends JpaRepository<StaffBranchEntity, Long> {
	
	public Optional<StaffBranchEntity> findByUsername(String username);
	
	@Transactional
	@Modifying
	@Query(value = "select * from staff_branch sb"
			+ "	where sb.branch_id = ?1"
			+ " ORDER BY sb.id ASC;",
			nativeQuery = true)
	public List<StaffBranchEntity> findByBranchId(String branchId);
	
	@Transactional
	@Modifying
	@Query(value = "select * from staff_branch sb"
			+ "	where sb.status = 1 and sb.role_id = ?2 and sb.branch_id = ?1"
			+ " ORDER BY sb.id ASC;",
			nativeQuery = true)
	public List<StaffBranchEntity> findUserOption(String branhcId, Integer roleId);

}
