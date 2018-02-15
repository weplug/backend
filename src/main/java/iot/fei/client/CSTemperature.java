package iot.fei.client;

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
public class CSTemperature {
	Long id;

	private Float temp = null;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	LocalDateTime time = LocalDateTime.now();

	public CSTemperature() {
		super();
	}

	public CSTemperature(Float temp, LocalDateTime time) {
		super();
		this.temp = temp;
		this.time = time;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Float getTemp() {
		return temp;
	}

	public void setTemp(Float temp) {
		this.temp = temp;
	}

	public LocalDateTime getTime() {
		return time;
	}

	public void setTime(LocalDateTime time) {
		this.time = time;
	}

}
