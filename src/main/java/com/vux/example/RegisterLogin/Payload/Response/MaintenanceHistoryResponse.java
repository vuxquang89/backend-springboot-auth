package com.vux.example.RegisterLogin.Payload.Response;

import java.sql.Date;
import java.time.LocalDate;

public class MaintenanceHistoryResponse {

	private long id;
	private HubDetailResponse hubDetailResponse;
	private String maintenanceTime;
	private String maintenanceNote;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public HubDetailResponse getHubDetailResponse() {
		return hubDetailResponse;
	}
	public void setHubDetailResponse(HubDetailResponse hubDetailResponse) {
		this.hubDetailResponse = hubDetailResponse;
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
