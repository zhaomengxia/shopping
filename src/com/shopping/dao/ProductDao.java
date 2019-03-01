package com.shopping.dao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import com.shopping.entity.Categorys;
import com.shopping.entity.Products;
import com.shopping.entity.Providers;

public interface ProductDao {
	public int[] addProduct(Connection conn, Products... products) throws SQLException;

	public int deleteProductByID(int productID) throws SQLException;

	public int addProduct(Connection conn, Products products) throws SQLException;

	public int updateProduct(Products products) throws SQLException;

	public ResultSet selectAllProduct(Connection conn, Page<Products> page) throws SQLException;

	public ResultSet selectAllProduct(Connection conn) throws SQLException;

	public int totalPage(Connection conn) throws SQLException;

	public int deleteProductByname(String product_name) throws SQLException;

	public ResultSet selectByname(Connection conn, String product_name) throws SQLException;

	public ResultSet selectByID(Connection conn, int productID) throws SQLException;

	public List<Products> selectAllp();

	public int delmanyproByIDs(Integer[] ids);
	public List<Products>selectAll1(Connection conn,String product_name,int length,int start)throws SQLException;
	public Page<Products>selectAll(Connection conn,Products p,Page<Products>page)throws SQLException;
	public int getTotalRecord(Connection conn,Products p);

	public ResultSet searchProductByCategoryId(Connection conn,int categoryID) throws SQLException;
}
