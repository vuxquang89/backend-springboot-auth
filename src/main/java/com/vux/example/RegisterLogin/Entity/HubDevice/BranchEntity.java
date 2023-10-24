package com.vux.example.RegisterLogin.Entity.HubDevice;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "branch")
public class BranchEntity{
	
	@Id
	@Column(name = "branch_id",
			nullable = false,
			length = 20)
	@NotBlank(message = "Branch Id cannot be blank")
	private String branchId;

	@Column(name = "branch_name")
	private String branchName;
	
	@Column(name = "deputy_technical_director",
			length = 100)
	private String deputyTechnicalDirector;
	
	@Column(name = "phone_deputy_technical_director",
			length = 10)
	@Pattern(regexp = "(\\+84|0)[0-9]{9}")
	private String phoneDeputyTechnicalDirector;
	
	@OneToMany(mappedBy="branchEntity")
	List<HubEntity> hubs;

	public String getBranchId() {
		return branchId;
	}

	public void setBranchId(String branchId) {
		this.branchId = branchId;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public String getDeputyTechnicalDirector() {
		return deputyTechnicalDirector;
	}

	public void setDeputyTechnicalDirector(String deputyTechnicalDirector) {
		this.deputyTechnicalDirector = deputyTechnicalDirector;
	}

	public String getPhoneDeputyTechnicalDirector() {
		return phoneDeputyTechnicalDirector;
	}

	public void setPhoneDeputyTechnicalDirector(String phoneDeputyTechnicalDirector) {
		this.phoneDeputyTechnicalDirector = phoneDeputyTechnicalDirector;
	}

	public List<HubEntity> getHubs() {
		return hubs;
	}

	public void setHubs(List<HubEntity> hubs) {
		this.hubs = hubs;
	}
	
}
