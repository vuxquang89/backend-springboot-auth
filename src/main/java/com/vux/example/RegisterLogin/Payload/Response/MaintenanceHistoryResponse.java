package com.vux.example.RegisterLogin.Payload.Response;

import java.util.ArrayList;
import java.util.List;


public class MaintenanceHistoryResponse {

	private long id;
	private HubDetailResponse hubDetailResponse;
	private String maintenanceTime;
	private String maintenanceNote;
	private List<ImageAfterMaintenanceHistoryResponse> imageAfterMaintenanceHistoryResponses = new ArrayList<ImageAfterMaintenanceHistoryResponse>();
	private List<ImageBeforeMaintenanceHistoryResponse> imageBeforeMaintenanceHistoryResponses = new ArrayList<ImageBeforeMaintenanceHistoryResponse>();
	
	public List<ImageAfterMaintenanceHistoryResponse> getImageAfterMaintenanceHistoryResponses() {
		return imageAfterMaintenanceHistoryResponses;
	}
	public void setImageAfterMaintenanceHistoryResponses(
			List<ImageAfterMaintenanceHistoryResponse> imageAfterMaintenanceHistoryResponses) {
		this.imageAfterMaintenanceHistoryResponses = imageAfterMaintenanceHistoryResponses;
	}
	public List<ImageBeforeMaintenanceHistoryResponse> getImageBeforeMaintenanceHistoryResponses() {
		return imageBeforeMaintenanceHistoryResponses;
	}
	public void setImageBeforeMaintenanceHistoryResponses(
			List<ImageBeforeMaintenanceHistoryResponse> imageBeforeMaintenanceHistoryResponses) {
		this.imageBeforeMaintenanceHistoryResponses = imageBeforeMaintenanceHistoryResponses;
	}
	public void addImageBeforeMaintenanceHistoryResponse(ImageBeforeMaintenanceHistoryResponse imageBeforeMaintenanceHistoryResponse) {
		this.imageBeforeMaintenanceHistoryResponses.add(imageBeforeMaintenanceHistoryResponse);
	}
	public void addImageAfterMaintenanceHistoryResponse(ImageAfterMaintenanceHistoryResponse imageAfterMaintenanceHistoryResponse) {
		this.imageAfterMaintenanceHistoryResponses.add(imageAfterMaintenanceHistoryResponse);
	}
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
