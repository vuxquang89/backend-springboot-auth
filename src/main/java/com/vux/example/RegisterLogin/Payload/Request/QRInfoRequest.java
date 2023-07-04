package com.vux.example.RegisterLogin.Payload.Request;

import org.springframework.web.multipart.MultipartFile;

public class QRInfoRequest {

	private long id;
	private double lat;
	private double lng;
	private String content;
	private MultipartFile file;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public double getLat() {
		return lat;
	}
	public void setLat(double lat) {
		this.lat = lat;
	}
	public double getLng() {
		return lng;
	}
	public void setLng(double lng) {
		this.lng = lng;
	}
	public MultipartFile getFile() {
		return file;
	}
	public void setFiles(MultipartFile file) {
		this.file = file;
	}
	
}
