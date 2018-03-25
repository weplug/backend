package iot.fei.core.domain;

import java.util.List;

public class GatheredData {
	String deviceId;

	private Float temp = null;

	private List<Float> eConsumption = null;

	private List<PlugState> plugStates = null;

	private Integer version = null;

	public GatheredData() {
		super();
	}

	public GatheredData(String deviceId, Float temp, List<Float> eConsumption, List<PlugState> plugStates) {
		super();
		this.deviceId = deviceId;
		this.temp = temp;
		this.eConsumption = eConsumption;
		this.plugStates = plugStates;
	}

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public Float getTemp() {
		return temp;
	}

	public void setTemp(Float temp) {
		this.temp = temp;
	}

	public List<Float> geteConsumption() {
		return eConsumption;
	}

	public void seteConsumption(List<Float> eConsumption) {
		this.eConsumption = eConsumption;
	}

	public List<PlugState> getPlugStates() {
		return plugStates;
	}

	public void setPlugStates(List<PlugState> plugStates) {
		this.plugStates = plugStates;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}
}
