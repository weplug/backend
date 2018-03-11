package iot.fei.client;

import java.util.List;

public class CSDeviceData {
	String id;

	private List<CSTemperature> temps = null;

	private String name = "Default";

	private String note = null;

	private List<CSPlug> plugs = null;

	public CSDeviceData() {
		super();
	}

	public CSDeviceData(List<CSTemperature> temps, List<CSPlug> plugs) {
		super();
		this.temps = temps;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}
}
