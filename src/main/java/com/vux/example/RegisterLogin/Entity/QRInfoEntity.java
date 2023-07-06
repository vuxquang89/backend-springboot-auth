package com.vux.example.RegisterLogin.Entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "qr_info")
public class QRInfoEntity extends BaseEntity{

	@Column
	private double lat;
	@Column
	private double lng;
	@Column
	private String content;
	@Column
	private String address;
	@Column
	private String dateUpload;
	
	@OneToMany(mappedBy = "qrInfo", cascade = CascadeType.REMOVE, orphanRemoval = true)
	private List<QRImageEntity> qrImages = new ArrayList<QRImageEntity>();

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

	public List<QRImageEntity> getQrImages() {
		return qrImages;
	}

	public void setQrImages(List<QRImageEntity> qrImages) {
		this.qrImages = qrImages;
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
	
	
}
