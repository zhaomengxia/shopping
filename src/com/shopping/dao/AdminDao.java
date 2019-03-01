package com.shopping.dao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.shopping.entity.Admin;

public interface AdminDao {
	public Admin SelectByName(String name);
	public ResultSet selectAdmin(Connection conn, Admin admin) throws SQLException;
	public int insertAdmin(Admin admin) throws SQLException;
	public ResultSet selectAllAdmin(Connection conn) throws SQLException;
}

