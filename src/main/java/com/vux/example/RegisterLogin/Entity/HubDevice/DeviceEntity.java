package com.vux.example.RegisterLogin.Entity.HubDevice;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.vux.example.RegisterLogin.Entity.BaseEntity;

@Entity
@Table(name = "device")
public class DeviceEntity extends BaseEntity{

	@Column(name = "device_name")
	private String deviceName;
	
	@OneToMany(mappedBy = "device")
	private List<HubDetailEntity> hubDetails;

	public String getDeviceName() {
		return deviceName;
	}

	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}

	public List<HubDetailEntity> getHubDetails() {
		return hubDetails;
	}

	public void setHubDetails(List<HubDetailEntity> hubDetails) {
		this.hubDetails = hubDetails;
	}
	
	
}
