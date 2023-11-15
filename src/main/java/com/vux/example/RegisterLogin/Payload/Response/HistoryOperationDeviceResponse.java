package com.vux.example.RegisterLogin.Payload.Response;

import java.time.LocalDateTime;
import java.util.Date;

public class HistoryOperationDeviceResponse {

	public Long id;
	public String modifiedBy;
	public String modifiedDate;
	public String createBy;
	public String createDate;
	public String content;
	public String action;
	public Long hubDetailId;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getModifiedBy() {
		return modifiedBy;
	}
	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	public String getModifiedDate() {
		return modifiedDate;
	}
	public void setModifiedDate(LocalDateTime modifiedDate) {
		this.modifiedDate = modifiedDate.toString().replace("T", " ");
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
	public Long getHubDetailId() {
		return hubDetailId;
	}
	public void setHubDetailId(Long hubDetailId) {
		this.hubDetailId = hubDetailId;
	}
	public String getCreateBy() {
		return createBy;
	}
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(LocalDateTime createDate) {
		this.createDate = createDate.toString().replace("T", " ");
	}
	
}
