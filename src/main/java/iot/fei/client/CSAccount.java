package iot.fei.client;

import java.util.List;

public class CSAccount {
	Long id;

	private String name;

	private String surname;

	private String password;

	private String email;

	private List<CSDeviceData> devices;

	public CSAccount() {
		super();
	}

	public CSAccount(Long id, String name, String surname, String password, String email, List<CSDeviceData> devices) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.password = password;
		this.email = email;
		this.devices = devices;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<CSDeviceData> getDevices() {
		return devices;
	}

	public void setDevices(List<CSDeviceData> devices) {
		this.devices = devices;
	}

}
