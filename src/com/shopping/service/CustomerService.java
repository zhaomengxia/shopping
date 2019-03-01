package com.shopping.service;

import java.util.ArrayList;
import java.util.List;

import com.shopping.dao.Page;
import com.shopping.entity.Customers;


public interface CustomerService {
	public int addcusto(String customer_name,String customer_add,String customer_bir,String customer_tel);
	public int deleteCustomer(int customerID);
	public int updateCustomer(int customerID,String customer_name,String customer_add,String customer_bir,String customer_tel);
	public ArrayList<Customers> selectAllCate();
	public ArrayList<Customers> selectCustomerByname(String customer_name);
	public Page<Customers> selectAllCust(int currentPage, int Pagesize);
	public Customers selectByID(int customerID);
	public List<Customers> selectcategory();
}
