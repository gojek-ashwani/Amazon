package com.gojek.resources;

public class User {

	private String username = null;
	private String password = null;
	
	public User() {
		this.username = "ashwani.gojek@gmail.com";
		this.password = "Raj@gojek19";
	}
	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	public String getUserName() {
		return username;
	}
	public String getPassword() {
		return password;
	}
}
