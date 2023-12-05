package com.vux.example.RegisterLogin.Entity.HubDevice;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;


@Entity
@Table(name = "staff_department")
public class StaffDepartmentEntity {
	@Id//not null
	private Long id;
	
	@Column(name = "createby")
	@CreatedBy
	private String createdBy;
	
	@Column(name = "createdate")
	@CreatedDate
	private Date createdDate;
	
	@Column(name = "modifiedby")
	@LastModifiedBy //get user login
	private String modifiedBy;
	
	@Column(name = "modifieddate")
	@LastModifiedDate //get from system
	private Date modifiedDate;

	@Column(name = "fullname",
	nullable = false,
	length = 150)
	@NotBlank(message = "Full name cannot be blank")
	private String fullname;
	
	@Column(name = "phone",
	nullable = false,
	length = 12)
	@NotBlank(message = "Phone cannot be blank")
	@Pattern(regexp = "(\\+84|0)[0-9]{9}")
	private String phone;
	
	@Column(name = "email",
			nullable = false,
			length = 50)
	@NotBlank(message = "Email cannot be blank")
	private String email;
	
	@Column(name = "username",
			nullable = false,
			length = 30)
	@NotBlank(message = "Username cannot be blank")
	private String username;
	
	@Column(name = "role_name")
	private String roleName;
	
	@Column(name = "role_id")
	private Integer roleId;
	
	@Column
	private Integer status;
	
	@OneToMany(mappedBy = "staffDepartment")
    private List<HubEntity> hubs = new ArrayList<>();

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
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

	public List<HubEntity> getHubs() {
		return hubs;
	}

	public void setHubs(List<HubEntity> hubs) {
		this.hubs = hubs;
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	
}
