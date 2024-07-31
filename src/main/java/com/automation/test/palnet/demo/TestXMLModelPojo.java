package com.automation.test.palnet.demo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TestXMLModelPojo {

	@JsonProperty("UserName")
	private String userName;
	
	@JsonProperty("Password")
	private String password;
	
	
	// Alt + Shift + s  -> To GEnerate Setters and Getters
	
	public String getUserName() {
		return userName;
	}
	
	public String getPassword() {
		return password;
	}
}
