package com.vux.example.RegisterLogin.Entity;

import java.util.Set;

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
	
	@OneToMany(mappedBy = "qrInfo", cascade = CascadeType.REMOVE, orphanRemoval = true)
	private Set<QRImageEntity> qrImages;

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

	public Set<QRImageEntity> getQrImages() {
		return qrImages;
	}

	public void setQrImages(Set<QRImageEntity> qrImages) {
		this.qrImages = qrImages;
	}
	
	
}
