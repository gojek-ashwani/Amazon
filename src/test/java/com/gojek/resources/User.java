package com.gojek.resources;

public class User {

	private String username = null;
	private String password = null;
	private String name = null;
	
	public User() {
		this.username = "ashwani.gojek@gmail.com";
		this.password = "Raj@gojek19";
		this.name = "Ashwani";
	}
	public User(String name, String username, String password) {
		this.name = name;
		this.username = username;
		this.password = password;
	}
	
	public String getUserName() {
		return username;
	}
	public String getPassword() {
		return password;
	}
	public String getName() {
		return name;
	}
}
