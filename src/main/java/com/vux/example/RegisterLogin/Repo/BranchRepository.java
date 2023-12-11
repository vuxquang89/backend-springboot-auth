package com.vux.example.RegisterLogin.Repo;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.vux.example.RegisterLogin.Entity.HubDevice.BranchEntity;

public interface BranchRepository extends JpaRepository<BranchEntity, String> {

	public Optional<BranchEntity> findBranchByBranchId(String branchId);
	
	@Transactional
	@Modifying
	@Query(value = "SELECT * FROM branch b INNER JOIN staff_leader sl ON sl.branch_id = b.branch_id;",
			nativeQuery = true)
	public List<BranchEntity> getBranchHaveLeader();
	
	@Transactional
	@Modifying
	@Query(value = "SELECT * FROM branch b WHERE b.branch_id "
			+ "not IN (select br.branch_id FROM branch br INNER JOIN staff_leader sl ON sl.branch_id = br.branch_id);",
			nativeQuery = true)
	public List<BranchEntity> getBranchHaveNotLeader();
	
	
}
