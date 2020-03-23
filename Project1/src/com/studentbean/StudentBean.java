package com.studentbean;

import java.io.Serializable;

public class StudentBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private String address;
	private String email;
	private String qual;

	public StudentBean(int id, String name, String address, String email, String qual) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.email = email;
		this.qual = qual;
	}

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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getQual() {
		return qual;
	}

	public void setQual(String qual) {
		this.qual = qual;
	}
}
