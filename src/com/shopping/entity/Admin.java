package com.shopping.entity;

public class Admin {
	private int id;
	private String name;
	private String realname;
	private String password;
	private String phone;
	private String address;

	public String getPhone() {
		return phone;
	}

	public Admin(String name, String realname, String password, String phone, String address) {
		super();
		this.name = name;
		this.realname = realname;
		this.password = password;
		this.phone = phone;
		this.address = address;
	}

	public Admin(int id, String name, String realname, String password, String phone, String address) {
		super();
		this.id = id;
		this.name = name;
		this.realname = realname;
		this.password = password;
		this.phone = phone;
		this.address = address;
	}

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Admin() {
		super();
	}

	public Admin(String name, String password) {
		super();
		this.name = name;
		this.password = password;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Admin [id=" + id + ", name=" + name + ", password=" + password + ", phone=" + phone + ", address="
				+ address + "]";
	}

}
