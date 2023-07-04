package com.vux.example.RegisterLogin.Repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vux.example.RegisterLogin.Entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long>{

	Optional<UserEntity> findByUsername(String username);

	Boolean existsByUsername(String username);

	Boolean existsByEmail(String email);
}
