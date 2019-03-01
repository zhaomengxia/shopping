package com.shopping.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.shopping.entity.Categorys;
import com.shopping.entity.Orders;

public interface OrderDao {
	public int addorder(Orders order) throws SQLException;
	public Orders selectByID(String orderID)throws SQLException;
	public int deleteOrderByID(String orderID)throws SQLException;

	public int updateOrder(Orders order) throws SQLException;

	public ResultSet selectAllOrder(Connection conn) throws SQLException;

	public ResultSet selectAllOrder(Connection conn, Page<Orders> page) throws SQLException;

	public int totalPage(Connection conn) throws SQLException;

	public ResultSet selectOrderByID(String orderID) throws SQLException;
	
	public ResultSet selectOrders()throws SQLException;
	
	
	public Page<Orders>selectAll(Connection conn,Orders p,Page<Orders>page)throws SQLException;
	public int getTotalRecord(Connection conn,Orders p);
	
	

}
