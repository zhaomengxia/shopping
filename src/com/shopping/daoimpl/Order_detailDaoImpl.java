package com.shopping.daoimpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.shopping.dao.BaseDao;
import com.shopping.dao.DBDao;
import com.shopping.dao.Order_DetailsDao;
import com.shopping.dao.Page;
import com.shopping.entity.Categorys;
import com.shopping.entity.Order_detail;
import com.shopping.entity.Products;
import com.shopping.entity.Providers;
import com.shopping.serviceimpl.CategoryServiceImpl;
import com.shopping.serviceimpl.ProductServiceImpl;
import com.shopping.serviceimpl.ProviderServiceImpl;

public class Order_detailDaoImpl extends BaseDao implements Order_DetailsDao{

	@Override
	public int addorder(Order_detail order) throws SQLException {
		String sql="insert into order_detail(orderID,productID,quantity,discount)values(?,?,?,?)";
		Connection conn=DBDao.getConnection();
		Object[] fields={order.getOrderID(),order.getProducts().getProductID(),order.getQuantity(),order.getDiscount()};
		return super.updateDB(conn, sql, fields);
		
	}

	@Override
	public int deleteOrderByID(String orderID) throws SQLException {
		String sql="delete from order_detail where orderID=?";
		Connection conn=DBDao.getConnection();
		Object[] fields={orderID};
		return super.updateDB(conn, sql, fields);
		
	}

	public int deleteByid(int id)throws SQLException{
		Connection conn=DBDao.getConnection();
		String sql="delete from order_detail where id=?";
		Object[] fields={id};
		return super.updateDB(conn, sql, fields);
	}
	
	@Override
	public int updateOrder(Order_detail order) throws SQLException {
		String sql="update order_detail set productID=?,quantity=?,discount=? where orderID=?";
		Connection conn=DBDao.getConnection();
		Object[] fields={order.getProducts().getProductID(),order.getQuantity(),order.getDiscount(),order.getOrderID()};
		return super.updateDB(conn, sql, fields);
		
	}

	@Override
	public ResultSet selectAllOrder(Connection conn) throws SQLException {
	String sql="select * from order_detail";
	return super.selectDB(conn, sql, null);	
	}

	@Override
	public ResultSet selectAllOrder(Connection conn, Page<Order_detail> page) throws SQLException {
			String sql = "select * from order_detail limit ?,?";
			Object[] fields = { (page.getCurrentPage() - 1) * page.getPageSize(), page.getPageSize() };
			return super.selectDB(conn, sql, fields);


	}

	@Override
	public int totalPage(Connection conn) throws SQLException {
		String sql = "select count(id) from order_detail";

		ResultSet set = super.selectDB(conn, sql, null);
		int total = 0;
		if (set.next()) {
			total = set.getInt(1);
		}
		return total;
	}

	@Override
	public ResultSet selectOrderByID(String orderID) throws SQLException {
		String sql="select * from order_detail where orderID=?";
		Connection conn=DBDao.getConnection();
		Object[] fields={orderID};
		ResultSet set=super.selectDB(conn, sql, fields);
		
		return set;
	}

	@Override
	public List<Order_detail> selectOrders() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Order_detail> selectAll(Connection conn, Order_detail p, Page<Order_detail> page) throws SQLException {
		
		
		String sql="select * from order_detail where 1=1";
		
		ArrayList<Order_detail> list=new ArrayList<Order_detail>();
		ArrayList list1=new ArrayList();
		if (!"".equals(p.getOrderID()) && p.getOrderID() != null) {
			sql = sql + "  and orderID =?";
			list1.add(p.getOrderID());

		}
		
		ResultSet set=super.selectDB(conn, sql, list1.toArray());
		while(set.next()){
			String orderID=set.getString("orderID");
			int productID=set.getInt("productID");
			Products products=new Products();
			products.setProductID(productID);
			p.setProducts(products);
			int quantity=set.getInt("quantity");
			int discount=set.getInt("discount");
			list.add(new Order_detail(orderID,products,quantity,discount));	
		}
		int total=getTotalRecord(conn, p);
		page.setTotal(total);
		page.setList(list);
		return page;
		
	}

	@Override
	public int getTotalRecord(Connection conn, Order_detail p) throws SQLException {

		String sql="select * from order_detail where 1=1";
		
		ArrayList<Order_detail> list=new ArrayList<Order_detail>();
		ArrayList list1=new ArrayList();
		if (!"".equals(p.getOrderID()) && p.getOrderID() != null) {
			sql = sql + "  and orderID =?";
			list1.add(p.getOrderID());

		}
		int total=0;
		ResultSet set=super.getTotalRecord(conn, sql, list1.toArray());
		while(set.next()){
			total=set.getInt(total);
		}
		
		
		return total;
		
	}

	@Override
	public int insertOrderDetail(Connection conn, Order_detail[] order) throws SQLException {
		String sql="insert into order_detail(orderID,productID,quantity,discount)values(?,?,?,?)";
		int t=0;
		Object[][] fields=new Object[order.length][];
		for(int i=0;i<fields.length;i++){
			fields[i]=new Object[4];
		}
		for(int j=0;j<order.length;j++){
			fields[j][0]=order[j].getOrderID();
			fields[j][1]=order[j].getProducts().getProductID();
			fields[j][2]=order[j].getQuantity();
			fields[j][3]=order[j].getDiscount();
			
		}
		
		int[] up=super.addMoreData(conn, sql, fields);
		if(up.length>0){
			t=up.length;
		}
		
		return t;
	}

}
