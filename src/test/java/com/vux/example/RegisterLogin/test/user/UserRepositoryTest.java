package com.vux.example.RegisterLogin.test.user;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.annotation.Rollback;

import com.vux.example.RegisterLogin.Entity.ERole;
import com.vux.example.RegisterLogin.Entity.RoleEntity;
import com.vux.example.RegisterLogin.Entity.UserEntity;
import com.vux.example.RegisterLogin.Repo.UserRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class UserRepositoryTest {

	@Autowired
	UserRepository userRepository;
	
	@Test
	public void getUser() {
		Long id = 1L;
		String username = "vuvu";
		//UserEntity user = userRepository.findById(id).get();
		UserEntity user = userRepository.findByUsername(username).get();
		System.out.println("username : " + user.getUsername());
		
		assertThat(user).isNotNull();
		assertThat(user.getId()).isGreaterThan(0);
	}
	
	@Test
	public void addUser() {
		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String rawPassword = "123456";
		String ancodedPassword = passwordEncoder.encode(rawPassword);
		
		UserEntity customer1 = new UserEntity();
		customer1.setEmail("quangvu@gmail.com");
		customer1.setUsername("vuvu1");
		customer1.setPassword(ancodedPassword);
		List<RoleEntity> roles = new ArrayList<RoleEntity>();
		RoleEntity role = new RoleEntity(1);
		roles.add(role);
		//customer1.addRole(new RoleEntity(ERole.ROLE_USER));
		customer1.addRole(role);
		
		UserEntity customerSave = userRepository.save(customer1);
		
		assertThat(customerSave).isNotNull();
		assertThat(customerSave.getId()).isGreaterThan(0);
	}
	
}
