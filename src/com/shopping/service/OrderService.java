package com.shopping.service;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.shopping.dao.Page;
import com.shopping.entity.Customers;
import com.shopping.entity.Employ;
import com.shopping.entity.Orders;

public interface OrderService {

	public int addorder(Orders order);
	public int deleteOrderByID(String orderID);
	
	public int updateOrder(String orderID,String order_date,Customers customer,Employ empploy);

	public ResultSet selectAllOrder(Page<Orders> page);	
	public Orders selectOrderByID(String orderID);
	public List<Orders> selectOrders();
	public Page<Orders>selectAll(int currentPage,int Pagesize);	
	public Page<Orders>selectAll(Orders o,Page<Orders> page);
	
	public ArrayList<Orders> selectAll();
	public Page<Orders> selectAllCate(Orders p1, int currentPage, int PageSize);
}
