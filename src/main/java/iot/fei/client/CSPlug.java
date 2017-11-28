package iot.fei.client;

import java.util.List;

import javax.persistence.Entity;

@Entity
public class CSPlug {
	Long id;

	private CSModes modes = null;

	private List<CSConsumption> consumption = null;

	private CSPlugState plugStates = null;

	public CSPlug() {
		super();
	}

	public CSPlug(CSModes modes, List<CSConsumption> consumption, CSPlugState plugStates) {
		super();
		this.modes = modes;
		this.consumption = consumption;
		this.plugStates = plugStates;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public CSModes getModes() {
		return modes;
	}

	public void setModes(CSModes modes) {
		this.modes = modes;
	}

	public List<CSConsumption> geteConsumption() {
		return consumption;
	}

	public void seteConsumption(List<CSConsumption> consumption) {
		this.consumption = consumption;
	}

	public CSPlugState getPlugStates() {
		return plugStates;
	}

	public void setPlugStates(CSPlugState plugStates) {
		this.plugStates = plugStates;
	}
}
