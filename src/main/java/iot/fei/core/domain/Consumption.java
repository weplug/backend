package iot.fei.core.domain;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Consumption {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;

	@Column
	private Float consume = null;

	@Column
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	LocalDateTime date = LocalDateTime.now();

	@ManyToOne
	@JoinColumn(name = "plug_id")
	private Plug plug;

	public Consumption() {
		super();
	}

	public Consumption(Float consume) {
		super();
		this.consume = consume;
	}

	public Plug getPlug() {
		return plug;
	}

	public void setPlug(Plug plug) {
		this.plug = plug;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Float getConsume() {
		return consume;
	}

	public void setConsume(Float consume) {
		this.consume = consume;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

}
