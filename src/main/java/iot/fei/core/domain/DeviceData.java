package iot.fei.core.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
// @NamedQuery(name = "DeviceData.findByAccoundId", query = "SELECT p FROM
// Person p WHERE LOWER(p.lastName) = LOWER(?1)")
public class DeviceData {
	@Id
	@Column
	String id;

	@OneToMany(mappedBy = "device", cascade = CascadeType.ALL)
	private List<Plug> plugs = new ArrayList<Plug>();

	@OneToMany(mappedBy = "device", cascade = CascadeType.ALL)
	private List<Temperature> temps = new ArrayList<Temperature>();

	@ManyToOne
	@JoinColumn(name = "account_id")
	private Account account;

	public DeviceData() {
		super();
	}

	public DeviceData(List<Temperature> temps, List<Plug> plugs, Account account) {
		super();
		this.temps = temps;
		this.plugs = plugs;
		this.account = account;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<Plug> getPlugs() {
		return plugs;
	}

	public void setPlugs(List<Plug> plugs) {
		this.plugs = plugs;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public List<Temperature> getTemps() {
		return temps;
	}

	public void setTemps(List<Temperature> temps) {
		this.temps = temps;
	}

}
