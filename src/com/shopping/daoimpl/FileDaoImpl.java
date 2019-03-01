package com.shopping.daoimpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.shopping.dao.BaseDao;
import com.shopping.dao.DBDao;
import com.shopping.dao.FileDao;
import com.shopping.entity.Files;

public class FileDaoImpl extends BaseDao implements FileDao{

	@Override
	public int addfile(Files file) throws SQLException {
		String sql="insert into files(file_name,file_desc,file_auto_name,user_name)values(?,?,?,?)";
		Connection conn=DBDao.getConnection();
		Object[] fields={file.getFile_name(),file.getFile_desc(),file.getFile_auto_name(),file.getUser_name()};
		return super.updateDB(conn, sql, fields);
	
	}

	@Override
	public int deleteById(int id) throws SQLException {
		String sql="delete from files where id=?";
		Object[] fields={id};
		Connection conn=DBDao.getConnection();
		return super.updateDB(conn, sql, fields);
		
	}

	@Override
	public ResultSet select() throws SQLException {
		String sql="select * from files";
		Connection conn=DBDao.getConnection();
		
		return super.selectDB(conn, sql, null);
		
	}

	@Override
	public ResultSet findFileById(int id) throws SQLException {
		String sql="select * from files where id=?";
		Object[] fields={id};
		Connection conn=DBDao.getConnection();
		return super.selectDB(conn, sql, fields);
		
	}

}
