package iot.fei.client;

import javax.persistence.Entity;
import java.util.List;

@Entity
public class CSPlugSimple {
	Long id;

	private CSModes modes = null;

	private CSPlugState plugStates = null;

	private Integer plugOrder;

	public CSPlugSimple() {
		super();
	}

	public CSPlugSimple(CSModes modes, List<CSConsumption> consumption, CSPlugState plugStates) {
		super();
		this.modes = modes;
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

	public CSPlugState getPlugStates() {
		return plugStates;
	}

	public void setPlugStates(CSPlugState plugStates) {
		this.plugStates = plugStates;
	}

	public Integer getPlugOrder() {
		return plugOrder;
	}

	public void setPlugOrder(Integer plugOrder) {
		this.plugOrder = plugOrder;
	}
}
