package iot.fei.client;

public class CSLogIn {
	private String password;

	private String email;

	public CSLogIn() {
		super();
	}

	public CSLogIn(String password, String email) {
		super();
		this.password = password;
		this.email = email;
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
}
