package com.vux.example.RegisterLogin.Payload.Request;

import java.time.LocalDate;

public class MaintenanceHistoryRequest {

	private long hubDetailId;
	private LocalDate maintenanceTime;
	private String maintenanceNote;
	public long getHubDetailId() {
		return hubDetailId;
	}
	public void setHubDetailId(long hubDetailId) {
		this.hubDetailId = hubDetailId;
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
