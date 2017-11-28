package iot.fei.client;

import java.util.List;

public class CSGatheredData {
	Long id;

	String deviceId;

	private Float temp = null;

	private List<Float> eConsumption = null;

	private List<CSPlugState> plugStates = null;

	public CSGatheredData() {
		super();
	}

	public CSGatheredData(String deviceId, Float temp, List<Float> eConsumption, List<CSPlugState> plugStates) {
		super();
		this.deviceId = deviceId;
		this.temp = temp;
		this.eConsumption = eConsumption;
		this.plugStates = plugStates;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public List<CSPlugState> getPlugStates() {
		return plugStates;
	}

	public void setPlugStates(List<CSPlugState> plugStates) {
		this.plugStates = plugStates;
	}

}
