package com.shopping.service;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.shopping.dao.Page;
import com.shopping.entity.Order_detail;
import com.shopping.entity.Products;


public interface Order_DetailService {
	public int addorderde(Order_detail order);
	public ArrayList<Order_detail> selectAllProduct();
	public Order_detail selectByOrder(String orderID);
	public Page<Order_detail> selectAllCate(int currentPage, int Pagesize);
	public int updateOrderde(int id, String orderID,Products products,int quantity,int discount);
	public int addorderde(Order_detail... order);
	public List<Order_detail> selectByOrderID(String orderID);
	public int deleteByOrderID(String orderID);
	public Page<Order_detail> selectALL(Order_detail order,int currentPage, int Pagesize);
	public int deleteByid(int id);
}
