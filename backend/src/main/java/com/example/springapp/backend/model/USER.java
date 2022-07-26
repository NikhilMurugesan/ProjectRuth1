package com.example.springapp.backend.model;

import org.springframework.stereotype.Component;

@Component
public class USER {
	private int id;
	private String name;
	private String emailid;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getemailid() {
		return emailid;
	}

	public void setemailid(String emailid) {
		this.emailid = emailid;
	}

}