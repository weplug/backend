package iot.fei.client;

import javax.persistence.Entity;

@Entity
public class CSModesLight {
	Long id;

	private Float start = null;

	private Float stop = null;

	public CSModesLight() {
		super();
	}

	public CSModesLight(Float start, Float stop) {
		super();
		this.start = start;
		this.stop = stop;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Float getStart() {
		return start;
	}

	public void setStart(Float start) {
		this.start = start;
	}

	public Float getStop() {
		return stop;
	}

	public void setStop(Float stop) {
		this.stop = stop;
	}
}
