package iot.fei.client;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class CSPlug {
	Long id;

	private CSModes modes = null;

	private List<CSConsumption> consumption = null;

	private CSPlugState plugStates = null;

	private Integer plugOrder;

	private String name = "Default";

	private String note = null;


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

	public List<CSConsumption> getConsumption() {
		return consumption;
	}

	public void setConsumption(List<CSConsumption> consumption) {
		this.consumption = consumption;
	}

	public Integer getPlugOrder() {
		return plugOrder;
	}

	public void setPlugOrder(Integer plugOrder) {
		this.plugOrder = plugOrder;
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
