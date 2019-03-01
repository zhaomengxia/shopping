package com.shopping.serviceimpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.shopping.dao.DBDao;
import com.shopping.dao.Page;
import com.shopping.daoimpl.CustomerDaoImpl;
import com.shopping.entity.Customers;
import com.shopping.entity.Providers;
import com.shopping.service.CustomerService;

public class CustomerServiceImpl implements CustomerService {
	CustomerDaoImpl p;

	public CustomerServiceImpl() {
		p = new CustomerDaoImpl();
	}
	@Override
	public Customers selectByID(int customerID) {
		ResultSet set = null;
		Customers customers = null;
		try {
			set = p.selectCustByID(customerID);
			if(set.next()) {
				customerID = set.getInt("customerID");
				String customer_name = set.getString("customer_name");
				String customer_add = set.getString("customer_add");
				String customer_bir = set.getString("customer_bir");
				String customer_tel = set.getString("customer_tel");
				customers=new Customers(customerID,customer_name,customer_add,customer_bir,customer_tel);
				System.out.println(customers);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			p.closeAll();
		}
		return customers;
	}

	



	@Override
	public int addcusto(String customer_name, String customer_add, String customer_bir, String customer_tel) {
		Customers customers = new Customers(customer_name,customer_add,customer_bir,customer_tel);
		
		int y = 0;
		try {

			customers.setCustomer_name(customer_name);
			customers.setCustomer_add(customer_add);
			customers.setCustomer_bir(customer_bir);
			customers.setCustomer_tel(customer_tel);
			y = p.addCustomer(customers);
			if (y > 0) {
				System.out.println("添加成功：");

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return y;
	}

	@Override
	public int deleteCustomer(int customerID) {
		// TODO Auto-generated method stub
		Connection conn = DBDao.getConnection();
		int t = 0;
		
			t = p.deleteCustomerByname(customerID);
			if (t > 0) {
				System.out.println("删除成功！");
			}
		
		return t;
	}

	@Override
	public int updateCustomer(int customerID, String customer_name, String customer_add, String customer_bir,
			String customer_tel) {
		Connection conn=DBDao.getConnection();
		int a=0;
		try {
			Customers customers = new Customers(customerID,customer_name,customer_add,customer_bir,customer_tel);
			customers.setCustomerID(customerID);
			customers.setCustomer_name(customer_name);
			customers.setCustomer_add(customer_add);
			customers.setCustomer_bir(customer_bir);
			customers.setCustomer_tel(customer_tel);
			
			ResultSet set=p.selectCustomerByname(conn, customers.getCustomer_name());
			if(set.next()){
				if(customers.getCustomerID()==customerID){
					a=p.updateCustomer(customers);
					
				}
				else{
					a=0;
				}
			}
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			p.closeAll();
		}
		return a;
	}

	@Override
	public ArrayList<Customers> selectAllCate() {
		Connection conn = DBDao.getConnection();
		ArrayList<Customers> list = new ArrayList<Customers>();

		ResultSet set = null;
		try {

			set = p.selectAllCustomer(conn);
			while (set.next()) {
				int customerID = set.getInt("customerID");
				String customer_name = set.getString("customer_name");
				String customer_add = set.getString("customer_add");
				String customer_bir = set.getString("customer_bir");
				String customer_tel = set.getString("customer_tel");
				list.add(new Customers(customerID,customer_name,customer_add,customer_bir,customer_tel));

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			p.closeAll();
		}

		return list;
	}

	@Override
	public ArrayList<Customers> selectCustomerByname(String customer_name) {
		Connection conn = DBDao.getConnection();
		ResultSet set = null;
		Customers customers = null;
		ArrayList<Customers> list = new ArrayList<Customers>();
		try {
			set = p.selectCustomerByname(conn, customer_name);

			while (set.next()) {
				int customerID = set.getInt("customerID");
				customer_name = set.getString("customer_name");
				String customer_add = set.getString("customer_add");
				String customer_bir = set.getString("customer_bir");
				String customer_tel = set.getString("customer_tel");
				list.add(new Customers(customerID,customer_name,customer_add,customer_bir,customer_tel));


			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			p.closeAll();
		}
		return list;
	}

	@Override
	public Page<Customers> selectAllCust(int currentPage, int PageSize) {
		List<Customers> list = new ArrayList<Customers>();
		Connection conn = DBDao.getConnection();
		Page<Customers> page = new Page<Customers>(currentPage, PageSize);
		ResultSet set = null;
		int total = 0;
		try {
			total = p.totalPage(conn);
			set = p.selectAllCustomer(conn, page);
			while (set.next()) {
				int customerID = set.getInt("customerID");
				String customer_name = set.getString("customer_name");
				String customer_add = set.getString("customer_add");
				String customer_bir = set.getString("customer_bir");
				String customer_tel = set.getString("customer_tel");
				list.add(new Customers(customerID,customer_name,customer_add,customer_bir,customer_tel));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		page.setList(list);
		page.setTotal(total);
		return page;
	}

	

	@Override
	public List<Customers> selectcategory() {
		
		return p.selectCust();
	}

}
