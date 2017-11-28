package iot.fei.core.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
public class ModesLight {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;

	@Column
	private Float start = null;

	@Column
	private Float stop = null;

	@OneToOne
	@PrimaryKeyJoinColumn
	private Modes modes;

	public ModesLight() {
		super();
	}

	public ModesLight(Float start, Float stop) {
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
