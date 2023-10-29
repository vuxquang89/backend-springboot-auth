package com.vux.example.RegisterLogin.Entity.HubDevice;

import java.time.LocalDate;

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
	private LocalDate maintenanceTime;
	
	@Column(name = "maintenance_note")
	private String maintenanceNote;

	public HubDetailEntity getHubDetail() {
		return hubDetail;
	}

	public void setHubDetail(HubDetailEntity hubDetail) {
		this.hubDetail = hubDetail;
	}

	public LocalDate getMaintenanceTime() {
		return maintenanceTime;
	}

	public void setMaintenanceTime(LocalDate maintenanceTime) {
		this.maintenanceTime = maintenanceTime;
	}

	public String getMaintenanceNote() {
		return maintenanceNote;
	}

	public void setMaintenanceNote(String maintenanceNote) {
		this.maintenanceNote = maintenanceNote;
	}
	
	
}
