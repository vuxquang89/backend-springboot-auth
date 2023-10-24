package com.vux.example.RegisterLogin.Entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.vux.example.RegisterLogin.Entity.HubDevice.HubEntity;


@Entity// Đánh dấu đây là table trong db
@Table(name = "user")
public class UserEntity extends BaseEntity implements UserDetails{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column
	private String username;
	
	@Column
	private String email;

	@Column
	private String password;
	
	@Column
	private String fullname;
	
	@Column
	@Pattern(regexp = "(\\+84|0)[0-9]{9}")
	private String phone;
	
	@ManyToMany
	@JoinTable(name = "user_role", 
				joinColumns = @JoinColumn(name = "user_id"), 
				inverseJoinColumns = @JoinColumn(name = "role_id"))
	private List<RoleEntity> roles = new ArrayList<RoleEntity>();
	
	@Column
	private Integer status;
	
	@OneToMany(mappedBy="personnelChargeName")
	private List<HubEntity> hubs;

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	
	public List<RoleEntity> getRoles() {
		return roles;
	}
	
	public List<String> getRolesToString(){
		List<String> listRoles = new ArrayList<String>();
		for(RoleEntity role:roles) {
			listRoles.add(role.getName());
		}
		return listRoles;
	}

	public void setRoles(List<RoleEntity> roles) {
		this.roles = roles;
	}
	
	public void addRole(RoleEntity role) {
        this.roles.add(role);
    }

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<HubEntity> getHubs() {
		return hubs;
	}

	public void setHubs(List<HubEntity> hubs) {
		this.hubs = hubs;
	}

	/*
	 * phương thức getAuthorities() để trả về danh sách các quyền của người dùng, 
	 * danh sách này sẽ được sử dụng trong quá trình tạo mã thông báo truy cập
	 */
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
		
		for(RoleEntity role : roles) {
			authorities.add(new SimpleGrantedAuthority(role.getName()));
		}
		return authorities;
	}
	
	@Override
	public String getUsername() {
		return username;
	}
	
	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
}
