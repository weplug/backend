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
import org.springframework.context.annotation.Lazy;

@Entity
public class Temperature {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;

	@Column
	private Float temp = null;

	@Column
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	LocalDateTime time = LocalDateTime.now();

	@ManyToOne
	@JoinColumn(name = "device_id")
	private DeviceData device;

	public Temperature() {
		super();
	}

	public Temperature(Float temp) {
		super();
		this.temp = temp;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public DeviceData getDevice() {
		return device;
	}

	public void setDevice(DeviceData device) {
		this.device = device;
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
