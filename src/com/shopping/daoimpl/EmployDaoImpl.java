package com.shopping.daoimpl;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.shopping.dao.BaseDao;
import com.shopping.dao.DBDao;
import com.shopping.dao.EmployDao;
import com.shopping.dao.Page;
import com.shopping.entity.Admin;
import com.shopping.entity.Employ;
import com.shopping.entity.Providers;
public class EmployDaoImpl extends BaseDao implements EmployDao{

	public ResultSet selectEmploy(Connection conn, Employ emp) throws SQLException {

		String sql = "select * from employees where emp_name=? and password=?";
		conn.prepareStatement(sql);
		Object[] fields = { emp.getEmp_name(), emp.getPassword() };
		return super.selectDB(conn, sql, fields);

	}
	public ResultSet selectAll() throws SQLException{
		String sql="select * from employees";
		Connection conn=DBDao.getConnection();
		ResultSet set=null;
		
			 set=super.selectDB(conn, sql, null);
		
		return set;
	}
	
	@Override
	public int add(Connection conn,Employ emp) throws SQLException {
		// TODO Auto-generated method stub
		String sql="insert into employees(emp_name,hire_date,salary,password,phone,interest,address,gender)values(?,?,?,?,?,?,?,?)";
		
		conn.prepareStatement(sql);
		Object[] fields={emp.getEmp_name(),emp.getHire_date(),emp.getSalary(),emp.getPassword(),emp.getPhone(),emp.getInterest(),emp.getAddress(),emp.getGender()};
	    super.updateDB(conn, sql, fields);
		return 0;
	}

	@Override
	public int delete(int empID) throws SQLException {
		String sql="delete from employees where empID=?";
		Employ emp=new Employ();
		Connection conn=DBDao.getConnection();
		Object[] fields={empID};
		int t=super.updateDB(conn, sql, fields);
		return t;
	}
	@Override
	public int update(Employ employ) throws SQLException {
		String sql="update employees set emp_name=?,hire_date=?,salary=?,password=?,phone=?,interest=?,address=?,gender=? where empID=?";
		Connection conn=DBDao.getConnection();
		Object[] fields={employ.getEmp_name(),employ.getHire_date(),employ.getSalary(),employ.getPassword(),employ.getPhone(),employ.getInterest(),employ.getAddress(),employ.getGender(),employ.getEmpID()};
		int t=super.updateDB(conn, sql, fields);
		return t;
	}
	@Override
	public int update1(String name, String name1) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public Employ userLogin(String name, String password) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Employ selectByname(String emp_name){
		Employ employ=null;
		Connection conn=DBDao.getConnection();
		String sql="select * from employees where emp_name=?";
		Object[] fields={emp_name};
		try {
			ResultSet set=super.selectDB(conn, sql, fields);
			if(set.next()){
				employ=new Employ();
				employ.setEmpID(set.getInt("empID"));
				employ.setEmp_name(set.getString("emp_name"));
				employ.setHire_date(set.getString("hire_date"));
				employ.setSalary(set.getDouble("salary"));
				employ.setPassword(set.getString("password"));
				employ.setPhone(set.getString("phone"));
				employ.setInterest(set.getString("interest"));
				employ.setAddress(set.getString("address"));
				employ.setGender(set.getString("gender"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employ;
	}
	@Override
	public ResultSet selectByID(int empID) throws SQLException {
		String sql="select * from employees where empID=?";
		Connection conn=DBDao.getConnection();
		Object[] fields={empID};
		ResultSet set=null;
		
		set=super.selectDB(conn, sql, fields);
		
		return set;
	}
	@Override
	public List<Employ> selectEmploy() {
		String sql="select * from employees";
		Connection conn=DBDao.getConnection();
		ResultSet set=null;
		Employ employ=new Employ();
		ArrayList<Employ> employs=new ArrayList<Employ>();
		try {
			set=super.selectDB(conn, sql, null);
			while(set.next()){
				employ.setEmpID(set.getInt("empID"));
				employ.setEmp_name(set.getString("emp_name"));
				employ.setHire_date(set.getString("hire_date"));
				employ.setSalary(set.getDouble("salary"));
				employ.setPassword(set.getString("password"));
				employ.setPhone(set.getString("phone"));
				employ.setInterest(set.getString("interest"));
				employ.setAddress(set.getString("address"));
				employ.setGender(set.getString("gender"));
				employs.add(employ);
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			super.closeAll();
		}
		return employs;
	}
	
	
	@Override
	public ResultSet selectAllEmploy(Connection conn, Page<Employ> page) throws SQLException {
		String sql = "select * from employees limit ?,?";
		Object[] fields = { (page.getCurrentPage() - 1) * page.getPageSize(), page.getPageSize() };
		return super.selectDB(conn, sql, fields);

	}
	@Override
	public int totalPage(Connection conn) throws SQLException {
		String sql = "select count(empID) from employees";

		ResultSet set = super.selectDB(conn, sql, null);
		int total = 0;
		if (set.next()) {
			total = set.getInt(1);
		}
		return total;
	}
	
	

}
