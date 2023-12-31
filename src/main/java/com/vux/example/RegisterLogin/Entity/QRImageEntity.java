package com.vux.example.RegisterLogin.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "qr_image")
public class QRImageEntity {

	@Id
	@Column()
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "qr_info_id")
	private QRInfoEntity qrInfo;

	@Column(name = "file_name")
	private String fileName;
	
	@Column(name = "file_name_resize")
	private String fileNameResize;
	
	@Column(name = "path_name")
	private String pathName;
	
	public QRImageEntity() {}
	
	public QRImageEntity(String fileName, String fileNameResize, String pathName, QRInfoEntity qrInfo) {
		this.fileName = fileName;
		this.fileNameResize = fileNameResize;
		this.pathName = pathName;
		this.qrInfo = qrInfo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public QRInfoEntity getQrInfo() {
		return qrInfo;
	}

	public void setQrInfo(QRInfoEntity qrInfo) {
		this.qrInfo = qrInfo;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	public String getFileNameResize() {
		return fileNameResize;
	}

	public void setFileNameResize(String fileNameResize) {
		this.fileNameResize = fileNameResize;
	}

	public String getPathName() {
		return pathName;
	}

	public void setPathName(String pathName) {
		this.pathName = pathName;
	}
	
	
}
