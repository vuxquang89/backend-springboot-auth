package com.vux.example.RegisterLogin.Entity.HubDevice;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "image_after_maintenance_history")
public class ImageAfterMaintenanceHistory {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//tu tang
	private Long id;
	@Column(name = "image_name")
	private String imageName;
	@Column(name = "path")
	private String path;
	@Column(name = "image_name_resize")
	private String imageNameResize;
	@Column(name = "type_file")
	private String typeFile;
	
	@ManyToOne()
	@JoinColumn(name = "maintenance_history_id", nullable=false)
	private MaintenanceHistoryEntity afterMaintenanceHistory;
	
	public ImageAfterMaintenanceHistory() {}
	
	public ImageAfterMaintenanceHistory(String imageName, String path, 
			String imageNameResize, MaintenanceHistoryEntity afterMaintenanceHistory) {
		this.imageName = imageName;
		this.path = path;
		this.imageNameResize = imageNameResize;
		this.afterMaintenanceHistory = afterMaintenanceHistory;		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getTypeFile() {
		return typeFile;
	}

	public void setTypeFile(String typeFile) {
		this.typeFile = typeFile;
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

	public MaintenanceHistoryEntity getAfterMaintenanceHistory() {
		return afterMaintenanceHistory;
	}

	public void setAfterMaintenanceHistory(MaintenanceHistoryEntity afterMaintenanceHistory) {
		this.afterMaintenanceHistory = afterMaintenanceHistory;
	}

}
