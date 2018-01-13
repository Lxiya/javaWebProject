package com.javaWebProject.JavaBean;

public class User {
	private String userName;
	private String password;
	private Integer role;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getRole() {
		return role;
	}

	public void setRole(Integer role) {
		this.role = role;
	}

	public User(String userName, String password, Integer role) {
		super();
		this.userName = userName;
		this.password = password;
		this.role = role;
	}

	public User() {
		super();
	}

}
