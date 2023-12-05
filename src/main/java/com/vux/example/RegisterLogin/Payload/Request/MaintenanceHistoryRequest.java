package com.vux.example.RegisterLogin.Payload.Request;

import org.springframework.web.multipart.MultipartFile;

public class MaintenanceHistoryRequest {

	private long hubDetailId;
	private String maintenanceTime;
	private String maintenanceNote;
	private MultipartFile[] imageBeforeMaintenanceFiles;
	private MultipartFile[] imageAfterMaintenanceFiles;
	
	public MultipartFile[] getImageBeforeMaintenanceFiles() {
		return imageBeforeMaintenanceFiles;
	}
	public void setImageBeforeMaintenanceFiles(MultipartFile[] imageBeforeMaintenanceFiles) {
		this.imageBeforeMaintenanceFiles = imageBeforeMaintenanceFiles;
	}
	public MultipartFile[] getImageAfterMaintenanceFiles() {
		return imageAfterMaintenanceFiles;
	}
	public void setImageAfterMaintenanceFiles(MultipartFile[] imageAfterMaintenanceFiles) {
		this.imageAfterMaintenanceFiles = imageAfterMaintenanceFiles;
	}
	public long getHubDetailId() {
		return hubDetailId;
	}
	public void setHubDetailId(long hubDetailId) {
		this.hubDetailId = hubDetailId;
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
