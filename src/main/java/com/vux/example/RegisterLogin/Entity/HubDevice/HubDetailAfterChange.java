package com.vux.example.RegisterLogin.Entity.HubDevice;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.vux.example.RegisterLogin.Entity.BaseEntity;

@Entity
@Table(name = "hub_detail_after_change")
public class HubDetailAfterChange extends BaseEntity{
	
	@Column(name = "user_modified_by")
	private String userModifiedBy;
	
	@Column(name = "user_modified_date")
	private String userModifiedDate;
	
	@Column
	private String trademark;//thuong hieu
	
	@Column(name = "rated_power")
	private String ratedPower;//cong suat dinh muc
	
	@Column(name = "load_during_power_outage")
	private String loadDuringPowerOutage;//phan tram tai khi mat dien
	
	@Column(name = "battery_quantity")
	private String batteryQuantity;//so luong pin
	
	@Column(name = "battery_number")
	private String batteryNumber;//so chuoi battery hien tai
	
	@Column(name = "battery_capacity")
	private String batteryCapacity;//model(dung luong AH)
	
	@Column(name = "production_time")
	private String productionTime;//thoi gian san xuat
	
	@Column(name = "conductor_type")
	private String conductorType;//loai day dan
	
	@Column(name = "cb_power")
	private String cbPower;//CB nguon
	
	@Column
	private String schneider;//cắt lọc sắt
	
	@Column
	private Integer resistor; // dien tro
	
	@Column(name="load_current_per_phase")
    private Integer loadCurrentPerPhase; //dong ta moi pha
	
	@Column(name="series_or_parallel")
    private String seriesOrParallel; //mac noi tiep/song song
	
	@Column(name = "year_install")
	private String yearInstall;//năm lắp đặt hệ thống điện
	
	@Column
	private String number;//số lượng
	
	@Column(name = "current_status")
	private String currentStatus;//hien trang
	
	@Column(name = "latest_maintenance_time")
	private LocalDate latestMaintenanceTime;//ngay bao duong gan nhat
	
	@Column(name = "date_maintenance")
	private Integer dateMaintenance;//so ngay can bao duong
	
	/*
	 * //trạng thái bảo dưỡng=> 
	 * 1: chưa tới thời gian bảo dưỡng
	 * 2: Sắp tới thời gian bảo dưỡng
	 * 3: Tới hạn / quá hạn bảo dưỡng
	 */
	@Column
	private Integer maintenanceStatus;//trang thai bao duong
	
	@Column(name = "order_maintenance")//dat lich bao duong
	private Boolean orderMaintenance;//true : nhan thong bao; false : khong nhan thong bao
	
	@Column(name = "status_delete")//trang thai xoa : 
	private Boolean statusDelete;// true => da xoa, false : dang hoat dong
	
	@Column(name = "device_id")
	private Long deviceId;
	
	@Column(name = "hub_id")
	private String hubId;
	
	@Column(name = "hub_detail_id")
	private Long hubDetailId;
	
	@Column(name = "history_change_id")
	private Long historyChangeId;
	
	@Column(name = "status")//trang thai truoc sau
	private String status;

	public String getTrademark() {
		return trademark;
	}

	public void setTrademark(String trademark) {
		this.trademark = trademark;
	}

	public String getRatedPower() {
		return ratedPower;
	}

	public void setRatedPower(String ratedPower) {
		this.ratedPower = ratedPower;
	}

	public String getLoadDuringPowerOutage() {
		return loadDuringPowerOutage;
	}

	public void setLoadDuringPowerOutage(String loadDuringPowerOutage) {
		this.loadDuringPowerOutage = loadDuringPowerOutage;
	}

	public String getBatteryQuantity() {
		return batteryQuantity;
	}

	public void setBatteryQuantity(String batteryQuantity) {
		this.batteryQuantity = batteryQuantity;
	}

	public String getBatteryNumber() {
		return batteryNumber;
	}

	public void setBatteryNumber(String batteryNumber) {
		this.batteryNumber = batteryNumber;
	}

	public String getBatteryCapacity() {
		return batteryCapacity;
	}

	public void setBatteryCapacity(String batteryCapacity) {
		this.batteryCapacity = batteryCapacity;
	}

	public String getProductionTime() {
		return productionTime;
	}

	public void setProductionTime(String productionTime) {
		this.productionTime = productionTime;
	}

	public String getConductorType() {
		return conductorType;
	}

	public void setConductorType(String conductorType) {
		this.conductorType = conductorType;
	}

	public String getCbPower() {
		return cbPower;
	}

	public void setCbPower(String cbPower) {
		this.cbPower = cbPower;
	}

	public String getSchneider() {
		return schneider;
	}

	public void setSchneider(String schneider) {
		this.schneider = schneider;
	}

	
	public Integer getResistor() {
		return resistor;
	}

	public void setResistor(Integer resistor) {
		this.resistor = resistor;
	}

	public Integer getLoadCurrentPerPhase() {
		return loadCurrentPerPhase;
	}

	public void setLoadCurrentPerPhase(Integer loadCurrentPerPhase) {
		this.loadCurrentPerPhase = loadCurrentPerPhase;
	}

	public String getSeriesOrParallel() {
		return seriesOrParallel;
	}

	public void setSeriesOrParallel(String seriesOrParallel) {
		this.seriesOrParallel = seriesOrParallel;
	}

	public String getYearInstall() {
		return yearInstall;
	}

	public void setYearInstall(String yearInstall) {
		this.yearInstall = yearInstall;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getCurrentStatus() {
		return currentStatus;
	}

	public void setCurrentStatus(String currentStatus) {
		this.currentStatus = currentStatus;
	}

	public LocalDate getLatestMaintenanceTime() {
		return latestMaintenanceTime;
	}

	public void setLatestMaintenanceTime(LocalDate latestMaintenanceTime) {
		this.latestMaintenanceTime = latestMaintenanceTime;
	}

	public Integer getDateMaintenance() {
		return dateMaintenance;
	}

	public void setDateMaintenance(Integer dateMaintenance) {
		this.dateMaintenance = dateMaintenance;
	}

	public Integer getMaintenanceStatus() {
		return maintenanceStatus;
	}

	public void setMaintenanceStatus(Integer maintenanceStatus) {
		this.maintenanceStatus = maintenanceStatus;
	}

	public Boolean getOrderMaintenance() {
		return orderMaintenance;
	}

	public void setOrderMaintenance(Boolean orderMaintenance) {
		this.orderMaintenance = orderMaintenance;
	}

	public Boolean getStatusDelete() {
		return statusDelete;
	}

	public void setStatusDelete(Boolean statusDelete) {
		this.statusDelete = statusDelete;
	}

	public Long getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(Long deviceId) {
		this.deviceId = deviceId;
	}

	public String getHubId() {
		return hubId;
	}

	public void setHubId(String hubId) {
		this.hubId = hubId;
	}

	public Long getHubDetailId() {
		return hubDetailId;
	}

	public void setHubDetailId(Long hubDetailId) {
		this.hubDetailId = hubDetailId;
	}

	public Long getHistoryChangeId() {
		return historyChangeId;
	}

	public void setHistoryChangeId(Long historyChangeId) {
		this.historyChangeId = historyChangeId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getUserModifiedBy() {
		return userModifiedBy;
	}

	public void setUserModifiedBy(String userModifiedBy) {
		this.userModifiedBy = userModifiedBy;
	}

	public String getUserModifiedDate() {
		return userModifiedDate;
	}

	public void setUserModifiedDate(String userModifiedDate) {
		this.userModifiedDate = userModifiedDate;
	}
	
	
}
