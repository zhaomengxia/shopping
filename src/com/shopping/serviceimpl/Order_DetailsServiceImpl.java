package com.shopping.serviceimpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.shopping.dao.DBDao;
import com.shopping.dao.Order_DetailsDao;
import com.shopping.dao.Page;
import com.shopping.daoimpl.OrderDaoImpl;
import com.shopping.daoimpl.Order_detailDaoImpl;
import com.shopping.entity.Order_detail;
import com.shopping.entity.Orders;
import com.shopping.entity.Products;
import com.shopping.service.Order_DetailService;

public class Order_DetailsServiceImpl implements Order_DetailService{

private Order_detailDaoImpl order;
 public Order_DetailsServiceImpl() {
	// TODO Auto-generated constructor stub
	 order=new Order_detailDaoImpl();
}
	@Override
	public int addorderde(Order_detail order) {
		Order_detailDaoImpl orders=new Order_detailDaoImpl();
		int t=0;
		try {
			t=orders.addorder(order);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return t;
	}

	@Override
	public ArrayList<Order_detail> selectAllProduct() {
		Connection conn=DBDao.getConnection();
		ArrayList<Order_detail> order1=new ArrayList<Order_detail>();
		Order_detail order2=new Order_detail();
		Orders ord=new Orders();
		OrderServiceImpl orde=new OrderServiceImpl();
		ResultSet set=null;
		ProductServiceImpl service=new ProductServiceImpl();
		Products products=new Products();
		
		 try {
			set=order.selectAllOrder(conn);
			while(set.next()){
				
				int id=set.getInt("id");
				
				String orderID=set.getString("orderID");
				
			
				int productID=set.getInt("productID");
				products=service.selectByID(productID);
				order2.setProducts(products);
				
				int quantity=set.getInt("quantity");
				int discount=set.getInt("discount");
				order1.add(new Order_detail(id,orderID,products,quantity,discount));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return order1;
	}

	@Override
	public Page<Order_detail> selectAllCate(int currentPage, int PageSize) {
		ArrayList<Order_detail> list=new ArrayList<Order_detail>();
		Connection conn=DBDao.getConnection();
		Page<Order_detail> page=new Page<Order_detail>(currentPage,PageSize);
		ResultSet set=null;
		Orders ord=new Orders();
		OrderServiceImpl orde=new OrderServiceImpl();
		Order_detail order2=new Order_detail();
		Order_detailDaoImpl ord1=new Order_detailDaoImpl();
		Products products=new Products();
		ProductServiceImpl service=new ProductServiceImpl();
		int total=0;
		try {
			total=order.totalPage(conn);
			set=order.selectAllOrder(conn, page);
			while(set.next()){
				int id=set.getInt("id");
				
				String orderID=set.getString("orderID");
				
			
				int productID=set.getInt("productID");
				products=service.selectByID(productID);
				order2.setProducts(products);
				
				int quantity=set.getInt("quantity");
				int discount=set.getInt("discount");
				list.add(new Order_detail(id,orderID,products,quantity,discount));
				
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
	public int addorderde(Order_detail... order1) {
		
		Connection conn=DBDao.getConnection();
		int t=0;
		try {
			conn.setAutoCommit(false);
			t=order.insertOrderDetail(conn, order1);
			conn.commit();
			conn.setAutoCommit(true);
		} catch (SQLException e) {
			try {
				conn.rollback();
				conn.setAutoCommit(true);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			e.printStackTrace();
		}finally{
			order.closeAll();
		}
		return t;
	}
	@Override
	public int deleteByOrderID(String orderID) {
		int t=0;
		try {
			t= order.deleteOrderByID(orderID);
			if(t>0){
				System.out.println("删除成功！");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return t;
	
	}
	
	public Page<Order_detail> selectALL(Order_detail order1,int currentPage,int PageSize){
		
		Page<Order_detail> page1=new Page<Order_detail>((currentPage-1)*PageSize,PageSize);
		Connection conn= DBDao.getConnection();
		
		try {
			order.selectAll(conn, order1, page1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return page1;
	}
	@Override
	public List<Order_detail> selectByOrderID(String orderID) {
		ResultSet set=null;
		Order_detail orders=new Order_detail();
		Order_DetailsServiceImpl service=new Order_DetailsServiceImpl();
		ProductServiceImpl product=new ProductServiceImpl();
		List<Order_detail> list=new ArrayList<Order_detail>();
		try {
			set=order.selectOrderByID(orderID);
			while(set.next()){
				int id=set.getInt("id");
				orderID=set.getString("orderID");
			
				int productID=set.getInt("productID");
				
				Products products=new Products();
				products=product.selectByID(productID);
				orders.setProducts(products);
				
				int quantity=set.getInt("quantity");
				orders.setQuantity(quantity);
				int discount=set.getInt("discount");
				orders.setDiscount(discount);
				orders=new Order_detail(id,orderID,products,quantity,discount);
				list.add(orders);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
	@Override
	public Order_detail selectByOrder(String orderID) {
		ResultSet set=null;
		Order_detail orders=new Order_detail();
		Order_DetailsServiceImpl service=new Order_DetailsServiceImpl();
		ProductServiceImpl product=new ProductServiceImpl();
		List<Order_detail> list=new ArrayList<Order_detail>();
		try {
			set=order.selectOrderByID(orderID);
			while(set.next()){
				int id=set.getInt("id");
				orderID=set.getString("orderID");
			
				int productID=set.getInt("productID");
				
				Products products=new Products();
				products=product.selectByID(productID);
				orders.setProducts(products);
				
				int quantity=set.getInt("quantity");
				orders.setQuantity(quantity);
				int discount=set.getInt("discount");
				orders.setDiscount(discount);
				
				orders=new Order_detail(id,orderID,products,quantity,discount);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return orders;
	}
	
	
	@Override
	public int updateOrderde(int id,String orderID,Products products,int quantity,int discount) {
		
		Order_detail orders=new Order_detail(id,orderID,products,quantity,discount);
		
		Order_detailDaoImpl service=new Order_detailDaoImpl();
		
		int t=0;
		try {
				t=service.updateOrder(orders);
				orders.setId(id);
				orders.setOrderID(orderID);
				orders.setProducts(products);
				orders.setQuantity(quantity);
				orders.setDiscount(discount);
			if(t>0){
				System.out.print("修改成功！");
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return t;
	}
	@Override
	public int deleteByid(int id) {
		// TODO Auto-generated method stub
		int t=0;
		try {
			t=order.deleteByid(id);
			if(t>0){
				System.out.print("删除成功！");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return t;
	}
}
