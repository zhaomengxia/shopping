package com.shopping.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.shopping.entity.Files;

public interface FileDao {
	public int addfile(Files file)throws SQLException;
	public int deleteById(int id)throws SQLException;
	public ResultSet select()throws SQLException;
	public ResultSet findFileById(int id)throws SQLException;	
}
