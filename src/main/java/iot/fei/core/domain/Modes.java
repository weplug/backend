package iot.fei.core.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
public class Modes {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;

	@Column
	private Boolean manual = true;

	@OneToOne(cascade = CascadeType.ALL)
	private Timers timers = new Timers();

	@OneToOne(cascade = CascadeType.ALL)
	private ModesLight light = null;

	@Column
	private boolean move_sensor = false;

	@OneToOne
	@PrimaryKeyJoinColumn
	private Plug plug;

	public Modes() {
		super();
	}

	public Modes(Boolean manual, Timers timers, ModesLight light, boolean move_sensor) {
		super();
		this.manual = manual;
		this.timers = timers;
		this.light = light;
		this.move_sensor = move_sensor;
	}

	public Plug getPlug() {
		return plug;
	}

	public void setPlug(Plug plug) {
		this.plug = plug;
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

	public Timers getTimers() {
		return timers;
	}

	public void setTimers(Timers timers) {
		this.timers = timers;
	}

	public ModesLight getLight() {
		return light;
	}

	public void setLight(ModesLight light) {
		this.light = light;
	}
}
