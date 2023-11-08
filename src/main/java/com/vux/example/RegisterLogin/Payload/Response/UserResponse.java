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
	private String statusName;
	private List<Integer> rolesId = new ArrayList<Integer>();
	private List<String> rolesName = new ArrayList<String>();
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
	public String getStatusName() {
		return statusName;
	}
	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}
	public List<Integer> getRolesId() {
		return rolesId;
	}
	public void setRolesId(List<Integer> rolesId) {
		this.rolesId = rolesId;
	}
	public void addRolesId(Integer rolesId) {
		this.rolesId.add(rolesId);
	}
	
	public List<String> getRolesName() {
		return rolesName;
	}
	public void setRolesName(List<String> rolesName) {
		this.rolesName = rolesName;
	}
	public void addRolesName(String rolesName) {
		this.rolesName.add(rolesName);
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
}
