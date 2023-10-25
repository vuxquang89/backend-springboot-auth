package com.vux.example.RegisterLogin.Payload.Response;

import java.util.ArrayList;
import java.util.List;


public class UserResponse {

	private long id;
	private String username;
	private String email;
	private String fullname;
	private String phone;
	private Integer status;
	private List<Integer> roles = new ArrayList<Integer>();
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public List<Integer> getRoles() {
		return roles;
	}
	public void setRoles(List<Integer> roles) {
		this.roles = roles;
	}
	public void addRole(Integer role) {
		this.roles.add(role);
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
}
