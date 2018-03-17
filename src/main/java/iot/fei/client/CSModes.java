package iot.fei.client;

import javax.persistence.Entity;
import java.util.List;

@Entity
public class CSModes {
	Long id;

	private Boolean manual = null;

	private List<CSTimer> timers = null;

	private CSModesLight light = null;

	private boolean move_sensor = false;

	public CSModes() {
		super();
	}

	public CSModes(Boolean manual, CSModesLight light, boolean move_sensor) {
		super();
		this.manual = manual;
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

	public List<CSTimer> getTimers() {
		return timers;
	}

	public void setTimers(List<CSTimer> timers) {
		this.timers = timers;
	}

	public void setManual(Boolean manual) {
		this.manual = manual;
	}

	public CSModesLight getLight() {
		return light;
	}

	public void setLight(CSModesLight light) {
		this.light = light;
	}
}
