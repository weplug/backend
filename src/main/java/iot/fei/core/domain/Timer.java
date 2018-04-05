package iot.fei.core.domain;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;
import iot.fei.core.config.LocalTimeConverter;

@Entity
public class Timer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;

	@Column
	@JsonFormat(pattern = "HH:mm:ss")
	@Convert(converter = LocalTimeConverter.class)
	private LocalTime startTime;

	@Column
	@JsonFormat(pattern = "HH:mm:ss")
	@Convert(converter = LocalTimeConverter.class)
	private LocalTime stopTime;

	@Column
	private Integer dayInWeek;

	@Column
	private Boolean repeat;

	@ManyToOne
	@JoinColumn(name = "modes_id")
	private Modes modes;

	public LocalTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalTime startTime) {
		this.startTime = startTime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalTime getStopTime() {
		return stopTime;
	}

	public void setStopTime(LocalTime stopTime) {
		this.stopTime = stopTime;
	}

	public Integer getDayInWeek() {
		return dayInWeek;
	}

	public void setDayInWeek(Integer dayInWeek) {
		this.dayInWeek = dayInWeek;
	}

	public Boolean getRepeat() {
		return repeat;
	}

	public void setRepeat(Boolean repeat) {
		this.repeat = repeat;
	}

	public Modes getModes() {
		return modes;
	}

	public void setModes(Modes modes) {
		this.modes = modes;
	}
}
