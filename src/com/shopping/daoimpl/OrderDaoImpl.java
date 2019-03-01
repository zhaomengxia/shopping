package com.shopping.daoimpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



import com.shopping.dao.BaseDao;
import com.shopping.dao.DBDao;
import com.shopping.dao.OrderDao;
import com.shopping.dao.Page;
import com.shopping.entity.Categorys;
import com.shopping.entity.Customers;
import com.shopping.entity.Employ;
import com.shopping.entity.Orders;
import com.shopping.entity.Products;
import com.shopping.entity.Providers;
import com.shopping.serviceimpl.CategoryServiceImpl;
import com.shopping.serviceimpl.CustomerServiceImpl;
import com.shopping.serviceimpl.EmployServiceImpl;
import com.shopping.serviceimpl.ProviderServiceImpl;

public class OrderDaoImpl extends BaseDao implements OrderDao {

	@Override
	public int addorder(Orders order) throws SQLException {
		String sql = "insert into orders(orderID,order_date,customerID,empID)values(?,?,?,?)";
		Connection conn = DBDao.getConnection();
		Object[] fields = { order.getOrderID(), order.getOrder_date(), order.getCustomers().getCustomerID(),
				order.getEmploy().getEmpID() };
		return super.updateDB(conn, sql, fields);

	}

	@Override
	public int deleteOrderByID(String orderID) throws SQLException {
		Connection conn = DBDao.getConnection();
		String sql = "select orders.orderID,order_detail.orderID from orders ,order_detail where ?=order_detail.orderID";

		Object[] fields = { orderID };
		ResultSet set = null;
		int t = 0;
		set = super.selectDB(conn, sql, fields);
		if (set.next()) {
			System.out.print("还有订单信息存在，无法删除");
			t = -1;
		} else {
			String sql1 = "delete from orders where orderID=?";
			Object[] field = { orderID };
			t = super.updateDB(conn, sql1, field);
			if (t > 0) {
				System.out.print("删除成功！");
			}
		}
		return t;
	}

	@Override
	public int updateOrder(Orders order) throws SQLException {
		System.out.println(order.getOrderID()+"********************************");
		String sql = "update orders set order_date=?,customerID=?,empID=? where orderID=?";
		Connection conn = DBDao.getConnection();
		Object[] fields = { order.getOrder_date(),order.getCustomers().getCustomerID(),order.getEmploy().getEmpID(), order.getOrderID()};
		return super.updateDB(conn, sql, fields);

	}

	@Override
	public ResultSet selectAllOrder(Connection conn) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultSet selectAllOrder(Connection conn, Page<Orders> page) throws SQLException {
		String sql = "select * from orders limit ?,?";
		Object[] fields = { (page.getCurrentPage() - 1) * page.getPageSize(), page.getPageSize() };
		return super.selectDB(conn, sql, fields);
	}

	@Override
	public int totalPage(Connection conn) throws SQLException {
		String sql = "select count(orderID) from orders";
		ResultSet set = null;
		int a = 0;
		set = super.selectDB(conn, sql, null);
		while (set.next()) {
			a = set.getInt(1);
		}

		return a;
	}

	@Override
	public ResultSet selectOrderByID(String orderID) throws SQLException {
		String sql = "select * from orders where orderID=?";
		Connection conn = DBDao.getConnection();
		Object[] fields = { orderID };
		return super.selectDB(conn, sql, fields);

	}

	@Override
	public ResultSet selectOrders() throws SQLException {
		String sql = "select * from orders";
		Connection conn = DBDao.getConnection();
		
		//订单编号，下单日期，客户，用户
		return super.selectDB(conn, sql, null);
	

	}

	@Override
	public Page<Orders> selectAll(Connection conn, Orders p, Page<Orders> page) throws SQLException {
		String sql = "select * from orders where 1=1";
		ArrayList list2 = new ArrayList();
		if (!"".equals(p.getOrderID()) && p.getOrderID() != null) {
			sql = sql + "  and orderID=?";
			list2.add(p.getOrderID());

		}
		System.out.print(sql);
		
		sql = sql + " limit ?,?";

		list2.add((page.getCurrentPage() - 1) * page.getPageSize());
		list2.add(page.getPageSize());
		System.out.println(sql + "-------");
		ArrayList<Orders> list = new ArrayList<Orders>();
		ResultSet set = super.selectDB(conn, sql, list2.toArray());
		
		while (set.next()) {
			Orders order=new Orders();
			String orderID = set.getString("orderID");
			String order_date = set.getString("order_date");
			int customerID = set.getInt("customerID");

			CustomerServiceImpl customers = new CustomerServiceImpl();
			Customers customer = new Customers();
			customer = customers.selectByID(customerID);
			order.setCustomers(customer);

			int empID = set.getInt("empID");
			EmployServiceImpl employ = new EmployServiceImpl();
			Employ employs = new Employ();
			employs = employ.selectByID(empID);
			order.setEmploy(employs);

			list.add(new Orders(orderID, order_date, customer, employs));

		}
		int total = getTotalRecord(conn, p);
		page.setTotal(total);
		page.setList(list);

		return page;

	}

	@Override
	public int getTotalRecord(Connection conn, Orders p) {
		String sql = "select count(orderID) from orders";
		ResultSet set = null;
		int total = 0;
		try {
			set = super.selectDB(conn, sql, null);
			while (set.next()) {
				total = set.getInt(1);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return total;
	}

	// 根据orderID查找订单，order_date,customerID,empID
	@Override
	public Orders selectByID(String orderID) throws SQLException {
		String sql = "select * from orders where orderID=?";
		Connection conn = DBDao.getConnection();
		Object[] fields = { orderID };
		ResultSet set = null;
		Orders order = null;

		set = super.selectDB(conn, sql, fields);
		if (set.next()) {
			// 订单编号
			orderID = set.getString("orderID");
			// 下单日期
			String order_date = set.getString("order_date");
			// 客户
			int customerID = set.getInt("cuetomerID");
			CustomerServiceImpl customer = new CustomerServiceImpl();
			Customers customers = new Customers();
			customers.setCustomerID(customerID);
			order.setCustomers(customers);
			// 员工
			int empID = set.getInt("empID");
			Employ employ = new Employ();
			employ.setEmpID(empID);
			order.setEmploy(employ);
			order = new Orders(orderID, order_date, customers, employ);
		}
		return order;
	}

}
