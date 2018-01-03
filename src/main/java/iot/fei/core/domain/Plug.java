package iot.fei.core.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Plug {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;

	@OneToOne(cascade = CascadeType.ALL)
	private Modes modes = null;

	@Column
	@OneToMany(mappedBy = "plug", cascade = CascadeType.ALL)
	private List<Consumption> eConsumption = new ArrayList<Consumption>();

	@Enumerated
	private PlugState plugStates = null;

	@ManyToOne
	@JoinColumn(name = "device_id")
	private DeviceData device;

	public Plug() {
		super();
	}

	// public Plug(Modes modes, List<Consumption> eConsumption, PlugState
	// plugStates, DeviceData device) {
	// super();
	// this.modes = modes;
	// this.eConsumption = eConsumption;
	// this.plugStates = plugStates;
	// this.device = device;
	// }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Modes getModes() {
		return modes;
	}

	public void setModes(Modes modes) {
		this.modes = modes;
	}

	public List<Consumption> geteConsumption() {
		return eConsumption;
	}

	public void seteConsumption(List<Consumption> eConsumption) {
		this.eConsumption = eConsumption;
	}

	public PlugState getPlugStates() {
		return plugStates;
	}

	public void setPlugStates(PlugState plugStates) {
		this.plugStates = plugStates;
	}

	public DeviceData getDevice() {
		return device;
	}

	public void setDevice(DeviceData device) {
		this.device = device;
	}
}
