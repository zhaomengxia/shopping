package com.shopping.serviceimpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.shopping.dao.DBDao;
import com.shopping.dao.Page;
import com.shopping.daoimpl.OrderDaoImpl;
import com.shopping.daoimpl.Order_detailDaoImpl;
import com.shopping.entity.Customers;
import com.shopping.entity.Employ;
import com.shopping.entity.Order_detail;
import com.shopping.entity.Orders;
import com.shopping.entity.Products;
import com.shopping.service.OrderService;

public class OrderServiceImpl implements OrderService{
OrderDaoImpl order=new OrderDaoImpl();
	@Override
	public int addorder(Orders order) {
		OrderDaoImpl orders=new OrderDaoImpl();
		int a=0;
		
		try {
			a=orders.addorder(order);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return a;
	}

	@Override
	public int deleteOrderByID(String orderID) {
		int t=0;
		try {
			t=order.deleteOrderByID(orderID);
			if(t>0){
				System.out.print("删除成功");
			}else if(t<0){
				System.out.print("还有订单信息存在，外简约束");
			}else{
				System.out.print("删除失败");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return t;
	}

	
	@Override
	public int updateOrder(String orderID,String order_date,Customers customers,Employ employ) {
		// TODO Auto-generated method stub
		int t=0;
		try {
				Orders order2=new Orders(orderID,order_date,customers,employ);
				order2.setOrderID(orderID);
				order2.setOrder_date(order_date);
				order2.setCustomers(customers);	
				order2.setEmploy(employ);
				t=order.updateOrder(order2);
				if(t>0){
					System.out.print("修改成功");
				}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return t;
	}

	@Override
	public ArrayList<Orders> selectAll() {
		// TODO Auto-generated method stub
		ArrayList<Orders> list=new ArrayList<Orders>();
		ResultSet set=null;
		Orders order1=new Orders();
		
		try {
			set=order.selectOrders();
			
			
			while (set.next()) {
				String orderID=set.getString("orderID");
				String order_date=set.getString("order_date");
				
				int customerID=set.getInt("customerID");
				Customers customer=new Customers();
				customer.setCustomerID(customerID);
				order1.setCustomers(customer);
				
				int empID=set.getInt("empID");
				Employ employ=new Employ();
				employ.setEmpID(empID);
				order1.setEmploy(employ);
				
				list.add(new Orders(orderID,order_date,customer,employ));
				
				
			}
			order.selectOrders();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public ResultSet selectAllOrder(Page<Orders> page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Orders selectOrderByID(String orderID) {
		OrderDaoImpl or=new OrderDaoImpl();
		ResultSet set=null;
		Orders order=null;
		Customers customer=new Customers();
		CustomerServiceImpl service=new CustomerServiceImpl();
		Employ employ=new Employ();
		EmployServiceImpl employs=new EmployServiceImpl();
		
		try {
			order=new Orders();
			set=or.selectOrderByID(orderID);
			if(set.next()){
				order.setOrderID(set.getString("orderID"));
				order.setOrder_date(set.getString("order_date"));
				
				int customerID=set.getInt("customerID");
				customer=service.selectByID(customerID);
				order.setCustomers(customer);
				
				int empID=set.getInt("empID");
				employ=employs.selectByID(empID);
				order.setEmploy(employ);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return order;
	}

	@Override
	public List<Orders> selectOrders() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Orders> selectAll(int currentPage, int PageSize) {
		ArrayList<Orders> list=new ArrayList<Orders>();
		Connection conn=DBDao.getConnection();
		Page<Orders> page=new Page<Orders>(currentPage,PageSize);
		ResultSet set=null;
		//订单编号orderID，order_date，customer,employ
		OrderServiceImpl orde=new OrderServiceImpl();
		Orders order2=new Orders();
		OrderDaoImpl ord1=new OrderDaoImpl();
		CustomerServiceImpl customers=new CustomerServiceImpl();
		Customers customer=new Customers();
		EmployServiceImpl employ=new EmployServiceImpl();
		Employ employs=new Employ();
		int total=0;
		try {
			total=order.totalPage(conn);
			set=order.selectAllOrder(conn, page);
			while(set.next()){
				String orderID=set.getString("orderID");
				
				String order_date=set.getString("order_date");
				
				int customerID=set.getInt("customerID");
				customer=customers.selectByID(customerID);
				order2.setCustomers(customer);
				
				int empID=set.getInt("empID");
				employs=employ.selectByID(empID);
				order2.setEmploy(employs);
				
				
				list.add(new Orders(orderID,order_date,customer,employs));	
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
	public Page<Orders> selectAllCate(Orders p1, int currentPage, int PageSize) {
		Connection conn=null;
		conn=DBDao.getConnection();
		Page<Orders> page=null;
		try {
			 page=order.selectAll(conn, p1, new Page<Orders>(currentPage,PageSize));
		return page;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return page;
	}
	
	
	@Override
	public Page<Orders> selectAll(Orders o, Page<Orders> page) {
		Connection conn=DBDao.getConnection();
		ResultSet set=null;
		Page<Orders> pag=new Page<Orders>((page.getCurrentPage()-1)*page.getPageSize(),page.getPageSize());
		try {
			 pag=order.selectAll(conn, o, page);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return pag;
	}

	
	

}
