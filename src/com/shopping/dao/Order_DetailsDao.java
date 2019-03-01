package com.shopping.dao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import com.shopping.entity.Categorys;
import com.shopping.entity.Order_detail;
import com.shopping.entity.Orders;
public interface Order_DetailsDao {
	public int addorder(Order_detail order) throws SQLException;

	public int deleteOrderByID(String orderID)throws SQLException;

	public int updateOrder(Order_detail order) throws SQLException;

	public ResultSet selectAllOrder(Connection conn) throws SQLException;

	public ResultSet selectAllOrder(Connection conn, Page<Order_detail> page) throws SQLException;

	public int totalPage(Connection conn) throws SQLException;

	public ResultSet selectOrderByID(String orderID) throws SQLException;
	
	public List<Order_detail> selectOrders();
	
	public Page<Order_detail>selectAll(Connection conn,Order_detail p,Page<Order_detail>page)throws SQLException;
	public int getTotalRecord(Connection conn,Order_detail p) throws SQLException;
	
	public int insertOrderDetail(Connection conn,Order_detail[] order)throws SQLException;
	public int deleteByid(int id)throws SQLException;

}
