package com.example.springapp.entity;

import org.springframework.stereotype.Component;

@Component
public class USER {
	private String uid;
	private String displayName;
	private String email;

	public String getuId() {
		return uid;
	}

	public void setuId(String uid) {
		this.uid = uid;
	}

	public String getdisplayName() {
		return displayName;
	}

	public void setdisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getemail() {
		return email;
	}

	public void setemail(String email) {
		this.email = email;
	}

}