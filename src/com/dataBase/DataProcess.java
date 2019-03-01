package com.dataBase;

//不管连接的数据库是什么，都需要导入java.sql包中的相应的类
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Vector;

public class DataProcess {
	private String url="jdbc:mysql://localhost:3306/homework?useUnicode=true&characterEncoding=UTF-8";
	private String user="root"; 
	private String password="root";
	private Connection conn=null;
	private Statement stm=null;
	private ResultSet rst=null;
	
	//设置分页
	public static final int PAGESIZE=5;
	int pageCount;//总页数
	int curPage=1;
	int rowCount=0;
	int pageCurrent;//当前页数
	
	public Vector<Vector<String>> getData(String sql){
		Vector<Vector<String>> rows=new Vector<Vector<String>>();
		try{
			Class.forName("com.mysql.jdbc.Driver"); 
			conn=DriverManager.getConnection(url, user, password);
			stm=conn.createStatement();
			rst=stm.executeQuery(sql);
			
			Vector<String> row=null;
			ResultSetMetaData rsmd=rst.getMetaData();
			int col=rsmd.getColumnCount();
			while(rst.next()){
				row=new Vector<String>();
				for(int i=0;i<col;i++){
					row.add(rst.getString(i+1));
				}
				
				rows.add(row);
			}
			
			stm.close();
			conn.close();
		}catch(Exception e){
			System.err.print(e);
		}
		
		return rows;
	}
	
	//添加删除更新数据，sql是insert、delete、update语句
	public boolean update(String sql){
		boolean b=false;
		try{
			Class.forName("com.mysql.jdbc.Driver"); //加载数据库驱动
			conn=DriverManager.getConnection(url, user, password);//获取连接
			stm=conn.createStatement();//创建执行sql语句的容器
			stm.executeUpdate(sql); //执行sql语句
			b=true;
			stm.close();
			conn.close();
		}catch(Exception e){
			System.err.print(e);
		}
		return b;
	}

	public Connection connect() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
