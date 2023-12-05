package com.vux.example.RegisterLogin.Payload.Response;

public class ImageAfterMaintenanceHistoryResponse {

private Long id;
	
	private String imageName;
	
	private String path;
	private String pathResize;
	
	private String imageNameResize;
	private String service = "server";
	private String typeFile;
	private String status = "after";

	
	public String getPathResize() {
		return pathResize;
	}

	public void setPathResize(String pathResize) {
		this.pathResize = pathResize;
	}

	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}

	public String getTypeFile() {
		return typeFile;
	}

	public void setTypeFile(String typeFile) {
		this.typeFile = typeFile;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getImageNameResize() {
		return imageNameResize;
	}

	public void setImageNameResize(String imageNameResize) {
		this.imageNameResize = imageNameResize;
	}
}
