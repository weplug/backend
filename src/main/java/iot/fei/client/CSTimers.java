package iot.fei.client;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;

@Entity
public class CSTimers {
	Long id;

	private List<LocalDateTime> plugTimers = null;

	public CSTimers(Long id) {
		super();
		this.id = id;
	}

	public CSTimers(List<LocalDateTime> plugTimers) {
		super();
		this.plugTimers = plugTimers;
	}

	public List<LocalDateTime> getPlugTimers() {
		return plugTimers;
	}

	public void setPlugTimers(List<LocalDateTime> plugTimers) {
		this.plugTimers = plugTimers;
	}

	public CSTimers() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
