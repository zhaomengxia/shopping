package com.shopping.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.shopping.entity.Customers;

public interface CustomerDao {
	public int addCustomer(Customers customer) throws SQLException;

	public int deleteCustomerByname(int customerID);

	public int updateCustomer(Customers customer) throws SQLException;

	public ResultSet selectAllCustomer(Connection conn) throws SQLException;

	public ResultSet selectCustomerByname(Connection conn, String customer_name) throws SQLException;

	public ResultSet selectAllCustomer(Connection conn, Page<Customers> page) throws SQLException;

	public int totalPage(Connection conn) throws SQLException;

	public ResultSet selectCustByID(int customerID) throws SQLException;
	
	public List<Customers> selectCust();

}
