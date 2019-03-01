package com.shopping.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.shopping.dao.Page;
import com.shopping.entity.Categorys;
import com.shopping.entity.Products;
import com.shopping.entity.Providers;

public interface ProductService {
	public int addProducts(Products... product);

	public int addProduct(Products product);

	public int updateProduct(int productID,String product_name, double income_price, Providers provider, int quantity,
			double sales_price, Categorys category, String income_time);

	public Page<Products> selectAllCate(int currentPage, int Pagesize);
	public Page<Products> selectAllCate(Products p,int currentPage, int Pagesize);
	public List<Products> selectAllCate1(String product_name,int currentPage, int Pagesize);
	public int delete(String product_name);

	public ArrayList<Products> selectAllProduct();

	public int deleteByproductID(int productID);

	public ArrayList<Products> selctByname(String product_name);

	public Products selectByID(int productID);
	public void exportOrder(HttpServletResponse response);
	public int deletemanyByID(Integer[] productID);
	public ArrayList<Products> searchProductByCategoryId(int categoryID);
	public int getTotalRecord(Products p);
	
}
