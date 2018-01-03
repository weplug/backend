package iot.fei.client;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;

@Entity
public class CSTimers {
	Long id;

	private List<LocalDateTime> plugTimers = null;

	private List<LocalDateTime> plugTimersStart = null;

	private List<LocalDateTime> plugTimersStop = null;

	private List<Boolean> repeat;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<LocalDateTime> getPlugTimers() {
		return plugTimers;
	}

	public void setPlugTimers(List<LocalDateTime> plugTimers) {
		this.plugTimers = plugTimers;
	}

	public List<LocalDateTime> getPlugTimersStart() {
		return plugTimersStart;
	}

	public void setPlugTimersStart(List<LocalDateTime> plugTimersStart) {
		this.plugTimersStart = plugTimersStart;
	}

	public List<LocalDateTime> getPlugTimersStop() {
		return plugTimersStop;
	}

	public void setPlugTimersStop(List<LocalDateTime> plugTimersStop) {
		this.plugTimersStop = plugTimersStop;
	}

	public List<Boolean> getRepeat() {
		return repeat;
	}

	public void setRepeat(List<Boolean> repeat) {
		this.repeat = repeat;
	}
}
