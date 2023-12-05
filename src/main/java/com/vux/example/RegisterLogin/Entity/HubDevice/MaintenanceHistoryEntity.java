package com.vux.example.RegisterLogin.Entity.HubDevice;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
	
	@OneToMany(mappedBy = "afterMaintenanceHistory")
	private List<ImageAfterMaintenanceHistory> imageAfterMaintenanceHistories;
	
	@OneToMany(mappedBy = "beforeMaintenanceHistory")
	private List<ImageBeforeMaintenanceHistory> imageBeforeMaintenanceHistories;
	
	public List<ImageAfterMaintenanceHistory> getImageAfterMaintenanceHistories() {
		return imageAfterMaintenanceHistories;
	}

	public void setImageAfterMaintenanceHistories(List<ImageAfterMaintenanceHistory> imageAfterMaintenanceHistories) {
		this.imageAfterMaintenanceHistories = imageAfterMaintenanceHistories;
	}

	public void addImageAfterMaintenanceHistory(ImageAfterMaintenanceHistory imageAfterMaintenanceHistory) {
		this.imageAfterMaintenanceHistories.add(imageAfterMaintenanceHistory);
	}
	public void addImageBeforeMaintenanceHistory(ImageBeforeMaintenanceHistory imageBeforeMaintenanceHistory) {
		this.imageBeforeMaintenanceHistories.add(imageBeforeMaintenanceHistory);
	}
	
	public List<ImageBeforeMaintenanceHistory> getImageBeforeMaintenanceHistories() {
		return imageBeforeMaintenanceHistories;
	}

	public void setImageBeforeMaintenanceHistories(List<ImageBeforeMaintenanceHistory> imageBeforeMaintenanceHistories) {
		this.imageBeforeMaintenanceHistories = imageBeforeMaintenanceHistories;
	}

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
