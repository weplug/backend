package iot.fei.client;

import javax.persistence.Entity;

@Entity
public class CSModes {
	Long id;

	private Boolean manual = null;

	private CSTimers timers = null;

	private CSModesLight light = null;

	private boolean move_sensor = false;

	public CSModes() {
		super();
	}

	public CSModes(Boolean manual, CSTimers timers, CSModesLight light, boolean move_sensor) {
		super();
		this.manual = manual;
		this.timers = timers;
		this.light = light;
		this.move_sensor = move_sensor;
	}

	public boolean isMove_sensor() {
		return move_sensor;
	}

	public void setMove_sensor(boolean move_sensor) {
		this.move_sensor = move_sensor;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Boolean getManual() {
		return manual;
	}

	public void setManual(Boolean manual) {
		this.manual = manual;
	}

	public CSTimers getTimers() {
		return timers;
	}

	public void setTimers(CSTimers timers) {
		this.timers = timers;
	}

	public CSModesLight getLight() {
		return light;
	}

	public void setLight(CSModesLight light) {
		this.light = light;
	}
}
