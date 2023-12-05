package com.vux.example.RegisterLogin.Payload.Response;


public class StaffBranchResponse {
	
	private Long id;
	private String hubManagerName;
	private String hubManagerPhone;
	private String email;
	private Integer status;
	private String username;
	private Integer roleId;
	private String roleName;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getHubManagerName() {
		return hubManagerName;
	}
	public void setHubManagerName(String hubManagerName) {
		this.hubManagerName = hubManagerName;
	}
	public String getHubManagerPhone() {
		return hubManagerPhone;
	}
	public void setHubManagerPhone(String hubManagerPhone) {
		this.hubManagerPhone = hubManagerPhone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	
}
