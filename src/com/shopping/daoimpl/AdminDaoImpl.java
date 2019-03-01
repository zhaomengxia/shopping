package com.shopping.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.shopping.dao.BaseDao;
import com.shopping.dao.DBDao;
import com.shopping.dao.AdminDao;
import com.shopping.entity.Admin;

public class AdminDaoImpl extends BaseDao implements AdminDao {
	public BaseDao b;
	@Override
	public ResultSet selectAdmin(Connection conn, Admin admin) throws SQLException {

		String sql = "select * from admin where name=? and password=?";
		conn.prepareStatement(sql);
		Object[] fields = { admin.getName(), admin.getPassword() };
		return super.selectDB(conn, sql, fields);

	}

	@Override
	public int insertAdmin(Admin admin) throws SQLException {
		
		Connection conn=DBDao.getConnection();
		String sql = "insert into admin(name,realname,password,phone,address)values(?,?,?,?,?)";
		Object[] fields = { admin.getName(),admin.getRealname(), admin.getPassword(),admin.getPhone(),admin.getAddress()};
		int result=super.updateDB(conn, sql, fields);
		return result;
	}

	@Override
	public ResultSet selectAllAdmin(Connection conn) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "select * from admin";
		conn.prepareStatement(sql);
		return super.selectDB(conn, sql, null);
	}

	@Override
	public Admin SelectByName(String name) {
		// TODO Auto-generated method stub
		Admin admin=null;
		Connection conn=DBDao.getConnection();
		String sql="select * from admin where name=?";
		Object[] fields={name};
		try {
			ResultSet set=super.selectDB(conn, sql, fields);
			if(set.next()){
				admin=new Admin();
				admin.setId(set.getInt("id"));
				admin.setName(set.getString("name"));
				admin.setPassword(set.getString("password"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			super.closeAll();
		}
		return admin;
	}

	

}
