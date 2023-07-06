package com.vux.example.RegisterLogin.Payload.Response;

import java.util.ArrayList;
import java.util.List;

public class QRResponse {

	private long id;
	private double lat;
	private double lng;
	private String content;
	private String address;
	private String dateUpload;
	private List<QRImageResponse> qrImages = new ArrayList<QRImageResponse>();

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDateUpload() {
		return dateUpload;
	}

	public void setDateUpload(String dateUpload) {
		this.dateUpload = dateUpload;
	}

	public List<QRImageResponse> getQrImages() {
		return qrImages;
	}

	public void setQrImages(List<QRImageResponse> qrImages) {
		this.qrImages = qrImages;
	}
	
	public void addQrImage(QRImageResponse qrImage) {
		this.qrImages.add(qrImage);
	}
		
	
}
