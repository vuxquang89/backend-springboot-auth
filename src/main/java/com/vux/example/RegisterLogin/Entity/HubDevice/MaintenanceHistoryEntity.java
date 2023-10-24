package com.vux.example.RegisterLogin.Entity.HubDevice;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.vux.example.RegisterLogin.Entity.BaseEntity;

@Entity
@Table(name = "maintenance_history")
public class MaintenanceHistoryEntity extends BaseEntity{

	@ManyToOne
	@JoinColumn(name = "hubdetail_id", nullable = false)
	private HubDetailEntity hubDetail;
	
	@Column(name = "maintenance_time")
	private LocalDateTime maintenanceTime;
	
	@Column(name = "maintenance_note")
	private String maintenanceNote;

	public HubDetailEntity getHubDetail() {
		return hubDetail;
	}

	public void setHubDetail(HubDetailEntity hubDetail) {
		this.hubDetail = hubDetail;
	}

	public LocalDateTime getMaintenanceTime() {
		return maintenanceTime;
	}

	public void setMaintenanceTime(LocalDateTime maintenanceTime) {
		this.maintenanceTime = maintenanceTime;
	}

	public String getMaintenanceNote() {
		return maintenanceNote;
	}

	public void setMaintenanceNote(String maintenanceNote) {
		this.maintenanceNote = maintenanceNote;
	}
	
	
}
