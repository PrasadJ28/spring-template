package com.web.entities;

public class AuthRequest {
	
	 private String username;
	 private String password;
	 
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
		System.out.println("setting username "+username);
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	 
	 
}
