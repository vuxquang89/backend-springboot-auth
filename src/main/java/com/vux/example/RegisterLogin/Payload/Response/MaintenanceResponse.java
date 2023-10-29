package com.vux.example.RegisterLogin.Payload.Response;


public class MaintenanceResponse {

	private long maintenanseId;
	private String maintenanceTime;
	private String maintenanceNote;
	public long getMaintenanseId() {
		return maintenanseId;
	}
	public void setMaintenanseId(long maintenanseId) {
		this.maintenanseId = maintenanseId;
	}
	public String getMaintenanceTime() {
		return maintenanceTime;
	}
	public void setMaintenanceTime(String maintenanceTime) {
		this.maintenanceTime = maintenanceTime;
	}
	public String getMaintenanceNote() {
		return maintenanceNote;
	}
	public void setMaintenanceNote(String maintenanceNote) {
		this.maintenanceNote = maintenanceNote;
	}
	
}
