package com.shopping.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.shopping.entity.Categorys;


public interface CategoryDao {
	public int addCategory(Categorys cate) throws SQLException;

	public int deleteCategoryByname(int categoryID);

	public int updateCategory(Categorys cate) throws SQLException;

	public ResultSet selectAllCategory(Connection conn) throws SQLException;

	public ResultSet selectCategoryByname(Connection conn, String category_name) throws SQLException;

	public ResultSet selectAllCategory(Connection conn, Page<Categorys> page) throws SQLException;

	public int totalPage(Connection conn) throws SQLException;

	public ResultSet selectCateByID(int categoryID) throws SQLException;
	
	public List<Categorys> selectCate();
	public Categorys selectCateByname(String category_name);
	
	public Page<Categorys>selectAll(Connection conn,Categorys p,Page<Categorys>page)throws SQLException;
	public int getTotalRecord(Connection conn,Categorys p);
}
