package com.shopping.daoimpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.shopping.dao.BaseDao;
import com.shopping.dao.CustomerDao;
import com.shopping.dao.DBDao;
import com.shopping.dao.Page;
import com.shopping.entity.Customers;

public class CustomerDaoImpl extends BaseDao implements CustomerDao{

	@Override
	public int addCustomer(Customers customer) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn=DBDao.getConnection();
		String sql="insert into customers(customer_name,customer_add,customer_bir,customer_tel)values(?,?,?,?)";
		Object[] fields={customer.getCustomer_name(),customer.getCustomer_add(),customer.getCustomer_bir(),customer.getCustomer_tel()};
		int a=super.updateDB(conn, sql, fields);
		return a;
	}

	@Override
	public int deleteCustomerByname(int customerID) {
		String sql="delete from customers where customerID=?";
		Connection conn=DBDao.getConnection();
		Object[] fields={customerID};
		int a=0;
		try {
			a=super.updateDB(conn, sql, fields);
			if(a>0){
				System.out.print("É¾³ý³É¹¦£¡");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return a;
	}

	@Override
	public int updateCustomer(Customers customer) throws SQLException {
		String sql="update customers set customer_name=?,customer_add=?,customer_bir=?,customer_tel=? where customerID=?";
		Connection conn=DBDao.getConnection();
		Object[] fields={customer.getCustomer_name(),customer.getCustomer_add(),customer.getCustomer_bir(),customer.getCustomer_tel(),customer.getCustomerID()};
		int a=0;
				a=super.updateDB(conn, sql, fields);
		return a;
	}
	@Override
	public ResultSet selectAllCustomer(Connection conn) throws SQLException {
		String sql="select * from customers";
		ResultSet set=super.selectDB(conn, sql, null);	
		return set;
	}

	@Override
	public ResultSet selectCustomerByname(Connection conn, String customer_name) throws SQLException {
		String sql="select * from customers where customer_name=?";
		Object[] fields={customer_name};
		ResultSet set=super.selectDB(conn, sql, fields);
		return set;
	}

	@Override
	public ResultSet selectAllCustomer(Connection conn, Page<Customers> page) throws SQLException {
		
		String sql="select * from customers limit ?,?";
		Object[] fields={(page.getCurrentPage()-1)*page.getPageSize(),page.getPageSize()};
		ResultSet set=super.selectDB(conn, sql, fields);
		return set;
	}

	@Override
	public int totalPage(Connection conn) throws SQLException {
		String sql="select count(customerID) from customers";
		ResultSet set=super.selectDB(conn, sql, null);
		int r=0;
		if(set.next()){
			r=set.getInt(1);
		}
		return r;
	}

	@Override
	public ResultSet selectCustByID(int customerID) throws SQLException {
		String sql="select * from customers where customerID=?";
		Object[] fields={customerID};
		Connection conn=DBDao.getConnection();
		return super.selectDB(conn, sql, fields);
		
	}

	@Override
	public List<Customers> selectCust() {
		List<Customers> list=new ArrayList<Customers>();
		String sql="select * from customers order by customerID desc";
		Connection conn=DBDao.getConnection();
		try {
			ResultSet set=super.selectDB(conn, sql, null);
			while(set.next()){
				Customers customers=new Customers();
				customers.setCustomerID(set.getInt("customerID"));
				customers.setCustomer_name(set.getString("customer_name"));
				customers.setCustomer_add(set.getString("customer_add"));
				customers.setCustomer_bir(set.getString("customer_bir"));
				customers.setCustomer_tel(set.getString("customer_tel"));
				list.add(customers);
				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

}
