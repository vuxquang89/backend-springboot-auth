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
import javax.validation.constraints.Pattern;

import com.vux.example.RegisterLogin.Entity.UserEntity;

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
	
	@Column(name = "hub_manager_name",
			nullable = false,
			length = 150)
	@NotBlank(message = "Hub manager name cannot be blank")
	private String hubManagerName;
	
	@Column(name = "hub_manager_phone",
			nullable = false,
			length = 10)
	@NotBlank(message = "Hub manager phone cannot be blank")
	@Pattern(regexp = "(\\+84|0)[0-9]{9}")
	private String hubManagerPhone;
	
	@ManyToOne
	@JoinColumn(name = "user_id", nullable=false)
	private UserEntity personnelChargeName;
	
	@ManyToOne
	@JoinColumn(name = "branch_id", nullable=false)
	private BranchEntity branchEntity;
	
	@OneToMany(mappedBy = "hubEntity")
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

	public UserEntity getPersonnelChargeName() {
		return personnelChargeName;
	}

	public void setPersonnelChargeName(UserEntity personnelChargeName) {
		this.personnelChargeName = personnelChargeName;
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
	
}
