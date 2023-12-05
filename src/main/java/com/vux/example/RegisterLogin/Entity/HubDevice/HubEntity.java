package com.vux.example.RegisterLogin.Entity.HubDevice;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;


@Entity
@Table(name = "hub")
public class HubEntity {

	@Id
	@Column(name = "hub_id",
			nullable = false,
			length = 20)
	@NotBlank(message = "Hub ID cannot be blank")
	private String hubId;
	
	@Column(name = "hub_name",
			nullable = false,
			length = 100)
	@NotBlank(message = "Hub name cannot be blank")
	private String hubName;
	
	@Column(name = "hub_address",
			nullable = false,
			length = 150)
	@NotBlank(message = "Hub address cannot be blank")
	private String hubAddress;
	
	@Column(name = "hub_city",
			nullable = false,
			length = 100)
	@NotBlank(message = "Hub city cannot be blank")
	private String hubCity;
	
	@ManyToOne
	@JoinColumn(name = "branch_id", nullable=false)
	private BranchEntity branchEntity;
	
	@ManyToOne
	@JoinColumn(name = "staff_branch_id", nullable = false)
	private StaffBranchEntity staffBranch;
	
	@ManyToOne
	@JoinColumn(name = "staff_department_id",nullable = false)
	private StaffDepartmentEntity staffDepartment;
	
	
	@OneToMany(mappedBy = "hubEntity"
//			,cascade = CascadeType.REMOVE, orphanRemoval = true
			)
	private List<HubDetailEntity> hubDetails;
	
	public String getHubId() {
		return hubId;
	}

	public void setHubId(String hubId) {
		this.hubId = hubId;
	}

	public String getHubName() {
		return hubName;
	}

	public void setHubName(String hubName) {
		this.hubName = hubName;
	}

	public String getHubAddress() {
		return hubAddress;
	}

	public void setHubAddress(String hubAddress) {
		this.hubAddress = hubAddress;
	}

	public String getHubCity() {
		return hubCity;
	}

	public void setHubCity(String hubCity) {
		this.hubCity = hubCity;
	}

	
	public BranchEntity getBranchEntity() {
		return branchEntity;
	}

	public void setBranchEntity(BranchEntity branch) {
		this.branchEntity = branch;
	}

	public List<HubDetailEntity> getHubDetails() {
		return hubDetails;
	}

	public void setHubDetails(List<HubDetailEntity> hubDetails) {
		this.hubDetails = hubDetails;
	}

	public StaffBranchEntity getStaffBranch() {
		return staffBranch;
	}

	public void setStaffBranch(StaffBranchEntity staffBranch) {
		this.staffBranch = staffBranch;
	}

	public StaffDepartmentEntity getStaffDepartment() {
		return staffDepartment;
	}

	public void setStaffDepartment(StaffDepartmentEntity staffDepartment) {
		this.staffDepartment = staffDepartment;
	}
	
}
