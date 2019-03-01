package com.dataBase;

//�������ӵ����ݿ���ʲô������Ҫ����java.sql���е���Ӧ����
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
	
	//���÷�ҳ
	public static final int PAGESIZE=5;
	int pageCount;//��ҳ��
	int curPage=1;
	int rowCount=0;
	int pageCurrent;//��ǰҳ��
	
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
	
	//���ɾ���������ݣ�sql��insert��delete��update���
	public boolean update(String sql){
		boolean b=false;
		try{
			Class.forName("com.mysql.jdbc.Driver"); //�������ݿ�����
			conn=DriverManager.getConnection(url, user, password);//��ȡ����
			stm=conn.createStatement();//����ִ��sql��������
			stm.executeUpdate(sql); //ִ��sql���
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
