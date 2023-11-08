package com.vux.example.RegisterLogin.Entity.HubDevice;

import java.util.List;

import javax.persistence.CascadeType;
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
	
	@Column(name = "background_color")
	private String backgroundColor;
	
	
	@OneToMany(mappedBy = "device"
//			,cascade = CascadeType.REMOVE, orphanRemoval = true
			)
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

	public String getBackgroundColor() {
		return backgroundColor;
	}

	public void setBackgroundColor(String backgroundColor) {
		this.backgroundColor = backgroundColor;
	}
	
	
}
