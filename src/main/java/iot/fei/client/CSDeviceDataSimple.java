package iot.fei.client;

import java.util.List;

public class CSDeviceDataSimple {
	String id;


	private List<CSPlugSimple> plugs = null;

	public CSDeviceDataSimple() {
		super();
	}

	public CSDeviceDataSimple(List<CSPlugSimple> plugs) {
		super();
		this.plugs = plugs;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<CSPlugSimple> getPlugs() {
		return plugs;
	}

	public void setPlugs(List<CSPlugSimple> plugs) {
		this.plugs = plugs;
	}
}
