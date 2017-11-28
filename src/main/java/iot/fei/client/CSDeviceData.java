package iot.fei.client;

import java.util.List;

public class CSDeviceData {
	String id;

	private List<CSTemperature> temps = null;

	private CSModes modes = null;

	private List<CSPlug> plugs = null;

	public CSDeviceData() {
		super();
	}

	public CSDeviceData(List<CSTemperature> temps, CSModes modes, List<CSPlug> plugs) {
		super();
		this.temps = temps;
		this.modes = modes;
		this.plugs = plugs;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<CSPlug> getPlugs() {
		return plugs;
	}

	public void setPlugs(List<CSPlug> plugs) {
		this.plugs = plugs;
	}

	public List<CSTemperature> getTemps() {
		return temps;
	}

	public void setTemps(List<CSTemperature> temps) {
		this.temps = temps;
	}

	public CSModes getModes() {
		return modes;
	}

	public void setModes(CSModes modes) {
		this.modes = modes;
	}

}
