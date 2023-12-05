package com.vux.example.RegisterLogin.Entity.HubDevice;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;


@Entity
@Table(name = "staff_branch")
public class StaffBranchEntity{
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

	@Column(name = "hub_manager_name",
			nullable = false,
			length = 150)
	@NotBlank(message = "Full name cannot be blank")
	private String hubManagerName;
			
	@Column(name = "hub_manager_phone",
			nullable = false,
			length = 12)
	@NotBlank(message = "Phone cannot be blank")
	@Pattern(regexp = "(\\+84|0)[0-9]{9}")
	private String hubManagerPhone;
			
	@Column(name = "username",
					nullable = false,
					length = 30)
	@NotBlank(message = "Username cannot be blank")
	private String username;
	
	@ManyToOne()
	@JoinColumn(name = "branch_id", nullable=false)
	private BranchEntity branchStaffEntity;
	
	@OneToMany(mappedBy = "staffBranch")
    private List<HubEntity> hubs = new ArrayList<>();
	
	@Column(name = "role_name")
	private String roleName;
	
	@Column(name = "role_id")
	private Integer roleId;
	
	@Column
	private String email;
	
	@Column
	private Integer status;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public BranchEntity getBranchStaffEntity() {
		return branchStaffEntity;
	}

	public void setBranchStaffEntity(BranchEntity branchStaffEntity) {
		this.branchStaffEntity = branchStaffEntity;
	}

	public List<HubEntity> getHubs() {
		return hubs;
	}

	public void setHubs(List<HubEntity> hubs) {
		this.hubs = hubs;
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
	
	
}
