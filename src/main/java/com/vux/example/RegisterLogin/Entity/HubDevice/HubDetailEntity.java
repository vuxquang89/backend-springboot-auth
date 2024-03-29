package com.vux.example.RegisterLogin.Entity.HubDevice;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.OneToMany;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;

import com.vux.example.RegisterLogin.Entity.BaseEntity;

@Entity
@NamedStoredProcedureQuery(name = "HubDetailEntity.updateMaintenanceDate", 
	procedureName = "PR_UPDATE_MAINTENANCE_DATE", 
	parameters = {@StoredProcedureParameter(mode = ParameterMode.IN, name = "Action", type = String.class)})
@Table(name = "hub_detail")
public class HubDetailEntity extends BaseEntity{

	@ManyToOne
	@JoinColumn(name = "device_id", nullable = false)
	private DeviceEntity device;
	
	@ManyToOne
	@JoinColumn(name = "hub_id", nullable = false)
	private HubEntity hubEntity;
	
	@OneToMany(mappedBy = "hubDetail"
//			,cascade = CascadeType.REMOVE, orphanRemoval = true
			)
	private List<MaintenanceHistoryEntity> maintenanceHistories;
	
	@OneToMany(mappedBy = "hubDetail")
	private List<HistoryOperationDeviceEntity> historyOperationDeviceEntities;
	
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
	
	@Column(name="date_now")
	private LocalDate dateNow;
	
	@Column(name = "date_maintenance")
	private Integer dateMaintenance;//so ngay can bao duong
	@Column(name = "alarm_maintenance")
	private Integer alarmMaintenance;//trang thai thong bao can bao duong
	
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

	public Integer getMaintenanceStatus() {
		return maintenanceStatus;
	}

	public void setMaintenanceStatus(Integer maintenanceStatus) {
		this.maintenanceStatus = maintenanceStatus;
	}

	public DeviceEntity getDevice() {
		return device;
	}

	public void setDevice(DeviceEntity device) {
		this.device = device;
	}

	public HubEntity getHubEntity() {
		return hubEntity;
	}

	public void setHubEntity(HubEntity hubEntity) {
		this.hubEntity = hubEntity;
	}

	public List<MaintenanceHistoryEntity> getMaintenanceHistories() {
		return maintenanceHistories;
	}

	public void setMaintenanceHistories(List<MaintenanceHistoryEntity> maintenanceHistories) {
		this.maintenanceHistories = maintenanceHistories;
	}

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

	public LocalDate getDateNow() {
		return dateNow;
	}

	public void setDateNow(LocalDate dateNow) {
		this.dateNow = dateNow;
	}

	public Integer getDateMaintenance() {
		return dateMaintenance;
	}

	public void setDateMaintenance(Integer dateMaintenance) {
		this.dateMaintenance = dateMaintenance;
	}

	public Integer getAlarmMaintenance() {
		return alarmMaintenance;
	}

	public void setAlarmMaintenance(Integer alarmMaintenance) {
		this.alarmMaintenance = alarmMaintenance;
	}

	public List<HistoryOperationDeviceEntity> getHistoryOperationDeviceEntities() {
		return historyOperationDeviceEntities;
	}

	public void setHistoryOperationDeviceEntities(List<HistoryOperationDeviceEntity> historyOperationDeviceEntities) {
		this.historyOperationDeviceEntities = historyOperationDeviceEntities;
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
	
}
