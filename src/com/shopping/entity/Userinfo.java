package com.shopping.entity;

public class Userinfo {
	private int id;
	private int roleid;
	private String userName;
	private String password;
	private String sex;
	private String address;
	private String phone;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getRoleid() {
		return roleid;
	}
	public void setRoleid(int roleid) {
		this.roleid = roleid;
	}
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
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Userinfo(String userName, String password, String sex, String address, String phone) {
		super();
		this.userName = userName;
		this.password = password;
		this.sex = sex;
		this.address = address;
		this.phone = phone;
	}
	

}
