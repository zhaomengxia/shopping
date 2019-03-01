package com.shopping.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.shopping.entity.Admin;

public class BaseDao {
	
	//BaseDao 里写通用的方法
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet set;

	public int[] addMoreData(Connection conn,String sql,Object[][] fields) throws SQLException{
		this.conn=conn;
		ps=conn.prepareStatement(sql);
		if(fields!=null){
		for(int i=0;i<fields.length;i++){
			for(int j=0;j<fields[i].length;j++){
				ps.setObject(j+1, fields[i][j]);
			}
			ps.addBatch();
		}
		}
		return ps.executeBatch();
	}
	public int updateDB(Connection conn, String sql, Object[] fields) throws SQLException {
		this.conn = conn;
		ps = conn.prepareStatement(sql);
		if(fields!=null){
		for (int i = 0; i < fields.length; i++) {
			ps.setObject(i + 1, fields[i]);
		}
		}

		return ps.executeUpdate();
	}
	
	public ResultSet selectDB(Connection conn,String sql,Object[] fields ) throws SQLException{
		this.conn = conn;
		ps = conn.prepareStatement(sql);
		if(fields!=null){
		for (int i = 0; i < fields.length; i++) {
			ps.setObject(i + 1, fields[i]);
		}
		}
		return ps.executeQuery();
	}
	
	public void closeAll(){
		try {
		if(conn!=null){
			
				conn.close();
		}
		else if(ps!=null){
			ps.close();
		}
		else if(set!=null){
			set.close();
		}
		System.out.println("--------------");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
public ResultSet getTotalRecord(Connection conn,String sql)throws SQLException{
	
	this.conn=conn;
	ps=conn.prepareStatement(sql);
	set=ps.executeQuery();
	return set;
	
}
public ResultSet getTotalRecord(Connection conn,String sql,Object[] fields)throws SQLException{
	
	
	this.conn=conn;
	ps=conn.prepareStatement(sql);
	if(fields!=null){
		for(int i=0;i<fields.length;i++){
			ps.setObject(i+1, fields[i]);
		}
	}
	set=ps.executeQuery();
	return set;
}

	
}