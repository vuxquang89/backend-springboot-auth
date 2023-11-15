package com.vux.example.RegisterLogin.Entity.HubDevice;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.vux.example.RegisterLogin.Entity.BaseEntity;

@Entity
@Table(name = "history_operation")
public class HistoryOperationDeviceEntity extends BaseEntity{

	
	@ManyToOne
	@JoinColumn(name = "hubdetail_id", nullable = false)
	private HubDetailEntity hubDetail;
	
	@Column(name = "content")
	private String content;
	
	@Column(name = "action")
	private String action;

	public HubDetailEntity getHubDetail() {
		return hubDetail;
	}

	public void setHubDetail(HubDetailEntity hubDetail) {
		this.hubDetail = hubDetail;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}
	
}
