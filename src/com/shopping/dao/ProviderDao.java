package com.shopping.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.shopping.entity.Products;
import com.shopping.entity.Providers;

public interface ProviderDao {
	public int addProvider(Connection conn,Providers providers)throws SQLException;
	public int deleteProviderByname(String provider_name)throws SQLException;
	public ResultSet selectAllProvider(Connection conn, Page<Providers> page) throws SQLException;
	public ResultSet selectAllProvider(Connection conn)throws SQLException;
	public int totalPage(Connection conn) throws SQLException;
	public int updateProviders(Providers providers)throws SQLException;
	public ResultSet selectByID(int providerID)throws SQLException;
	public ResultSet selectByname(Connection conn,String provider_name)throws SQLException;
	public int deleteByID(Connection conn, int productID)throws SQLException;
	public Page<Providers>selectAll(Connection conn,Providers p,Page<Providers>page)throws SQLException;
	public int getTotalRecord(Connection conn,Providers p);
}
