package com.shopping.service;

import java.util.ArrayList;

import com.shopping.dao.Page;
import com.shopping.entity.Admin;
import com.shopping.entity.Employ;
import com.shopping.entity.Providers;

public interface EmployService {
	public ArrayList<Employ> selectEmploy();
	public int addEmploy(Employ emp);
	public int deleteEmploy(int empID);
	// public boolean updateEmploy(String name);
	public Employ findEmploy(String name, String password);
	
	public boolean login(Employ employ);

	public Employ selectByname(String name);
	public Employ selectByID(int empID);
	public Page<Employ> selectAll(int currentPage, int Pagesize);
	
	public int updateemploy(int empID,String emp_name, String hire_date,double salary, String password,String phone, String interest,
			String address,String gender);
}
