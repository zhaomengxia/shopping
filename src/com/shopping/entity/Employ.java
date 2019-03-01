package com.shopping.entity;

public class Employ {
	private int empID;
	private String emp_name;
	private String hire_date;
	private double salary;
	private String password;
	private String phone;
	private String interest;
	private String address;
	private String gender;

	
	


	public Employ(int empID, String emp_name, String hire_date, double salary, String password, String phone,
			String interest, String address, String gender) {
		super();
		this.empID = empID;
		this.emp_name = emp_name;
		this.hire_date = hire_date;
		this.salary = salary;
		this.password = password;
		this.phone = phone;
		this.interest = interest;
		this.address = address;
		this.gender = gender;
	}

	public Employ() {
		super();
	}

	public Employ(String emp_name, String password) {
		super();
		this.emp_name = emp_name;
		this.password = password;
	}

	public Employ(String emp_name, String password, String phone, String interest, String address, String gender) {
		super();
		this.emp_name = emp_name;
		this.password = password;
		this.phone = phone;
		this.interest = interest;
		this.address = address;
		this.gender = gender;
	}
	

	public Employ(String emp_name, String hire_date, double salary, String password, String phone, String interest,
			String address, String gender) {
		super();
		this.emp_name = emp_name;
		this.hire_date = hire_date;
		this.salary = salary;
		this.password = password;
		this.phone = phone;
		this.interest = interest;
		this.address = address;
		this.gender = gender;
	}

	

	
	
	public int getEmpID() {
		return empID;
	}

	public void setEmpID(int empID) {
		this.empID = empID;
	}

	public String getEmp_name() {
		return emp_name;
	}

	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}

	public String getHire_date() {
		return hire_date;
	}

	public void setHire_date(String hire_date) {
		this.hire_date = hire_date;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getInterest() {
		return interest;
	}

	public void setInterest(String interest) {
		this.interest = interest;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "Employ [empID=" + empID + ", emp_name=" + emp_name + ", hire_date=" + hire_date + ", salary=" + salary
				+ ", password=" + password + ", phone=" + phone + ", interest=" + interest + ", address=" + address
				+ ", gender=" + gender + "]";
	}

}
