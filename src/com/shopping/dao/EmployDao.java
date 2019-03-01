package com.shopping.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.shopping.entity.Customers;
import com.shopping.entity.Employ;

public interface EmployDao {
	public ResultSet selectEmploy(Connection conn, Employ emp) throws SQLException ; 
	public int add(Connection conn,Employ emp)throws SQLException;
	public int delete(int empID) throws SQLException;
	
	public int update(Employ employ) throws SQLException;
	public int update1(String name,String name1) throws SQLException;
	public Employ userLogin(String name,String password) throws SQLException;
	public Employ selectByname(String emp_name);
	public List<Employ> selectEmploy();
	public ResultSet selectByID(int empID) throws SQLException;
	public ResultSet selectAll() throws SQLException;
	public ResultSet selectAllEmploy(Connection conn, Page<Employ> page) throws SQLException;
	public int totalPage(Connection conn) throws SQLException;
}
