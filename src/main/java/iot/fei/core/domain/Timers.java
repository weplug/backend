package iot.fei.core.domain;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Timers {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;

	@Column
	@ElementCollection
	private List<LocalDateTime> plugTimersStart = null;

	// TODO vymysiet ako tam nechat len den hodinu minutu sekundu
	@Column
	@ElementCollection
	private List<LocalDateTime> plugTimersStop = null;

	@Column
	@ElementCollection
	private List<Boolean> repeat;

	@OneToOne
	@PrimaryKeyJoinColumn
	private Modes modes;

	public Timers(Long id) {
		super();
		this.id = id;
	}

	public Timers(Modes modes) {
		super();
		this.modes = modes;
	}

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public List<LocalDateTime> getPlugTimersStart() {
		return plugTimersStart;
	}

	public void setPlugTimersStart(List<LocalDateTime> plugTimersStart) {
		this.plugTimersStart = plugTimersStart;
	}

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
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

	public Modes getModes() {
		return modes;
	}

	public void setModes(Modes modes) {
		this.modes = modes;
	}

	public Timers() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
