package com.vux.example.RegisterLogin.Repo;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.vux.example.RegisterLogin.Entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long>{

	Optional<UserEntity> findByUsername(String username);
	Optional<UserEntity> findByEmail(String email);
	
	List<UserEntity> findByUserType(String userType);
	
	
	@Transactional
	@Modifying
//	@Query(value = "select * from dbo.[user] u inner join user_role "
	@Query(value = "select * from users u inner join user_role "
			+ "on u.id = user_role.user_id "
			+ "inner join roles r on r.id = user_role.role_id "
			+ "where r.id = ?1 "
			+ "and u.username != 'admin' and u.status = 1 "
			+ "ORDER BY u.id ASC",
			nativeQuery = true)
	List<UserEntity> findUserManager(int roleId);

	Boolean existsByUsername(String username);

	Boolean existsByEmail(String email);
	Boolean existsByPhone(String phone);
}
