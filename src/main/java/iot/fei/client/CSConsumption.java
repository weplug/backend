package iot.fei.client;

import java.time.LocalDateTime;

public class CSConsumption {
	Long id;

	private Float consume = null;

	LocalDateTime date = LocalDateTime.now();

	public CSConsumption() {
		super();
	}

	public CSConsumption(Float consume, LocalDateTime date) {
		super();
		this.consume = consume;
		this.date = date;
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
