package com.shopping.serviceimpl;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.shopping.daoimpl.EmployDaoImpl;
import com.shopping.dao.BaseDao;
import com.shopping.dao.DBDao;
import com.shopping.dao.Page;
import com.shopping.entity.Admin;
import com.shopping.entity.Categorys;
import com.shopping.entity.Employ;
import com.shopping.entity.Providers;
import com.shopping.service.EmployService;

public class EmployServiceImpl implements EmployService {
	public EmployDaoImpl e;
	public BaseDao b1;
	public EmployServiceImpl() {
		e=new EmployDaoImpl();
	}

	@Override
	public int addEmploy(Employ emp) {
		// TODO Auto-generated method stub
		Connection conn=DBDao.getConnection();
		EmployDaoImpl emp1=new EmployDaoImpl();
		int t=0;	
		try {
			t=emp1.add(conn, emp);
			if(t==0){
				System.out.println("注册成功");
			}
			else{
				System.out.println("添加失败--");
			}
			
		} catch (SQLException e) {
			System.out.println("该用户已存在！");
		}
		return t;
	}

	@Override
	public int deleteEmploy(int empID) {
		int t=0;
		try {
			t= e.delete(empID);
			if(t>0){
				System.out.print("删除成功");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return t;
	}

	@Override
	public ArrayList<Employ> selectEmploy() {
		ResultSet set=null;
		Employ employ=new Employ();
		Connection conn=DBDao.getConnection();
		ArrayList<Employ> employs=new ArrayList<Employ>();
		try {
			set=e.selectAll();
			while(set.next()){
				int id1 = set.getInt("empID");
				String name1 = set.getString("emp_name");
				String password1 = set.getString("password");
				String hire_date=set.getString("hire_date");
				int salary=set.getInt("salary");
				String phone=set.getString("phone");
				String interest=set.getString("address");
				String address=set.getString("address");
				String gender=set.getString("gender");
				employs.add(new Employ(id1,name1,hire_date,salary,password1,phone,interest,address,gender));
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			e.closeAll();
		}
		return employs;
		
	}

	@Override
	public Employ findEmploy(String name, String password) {
		Employ employ = null;
		ResultSet set = null;
		Connection conn = DBDao.getConnection();
		try {

			set = e.selectEmploy(conn, new Employ(name,password));
			if (set.next()) {
				int id1 = set.getInt("empID");
				String name1 = set.getString("emp_name");
				String password1 = set.getString("password");
				String hire_date=set.getString("hire_date");
				int salary=set.getInt("salary");
				String phone=set.getString("phone");
				String interest=set.getString("address");
				String address=set.getString("address");
				String gender=set.getString("gender");
				employ = new Employ(id1,name1,hire_date,salary,password1,phone,interest,address,gender);
				//System.out.println(employ);
				System.out.println("登录成功");
				System.out.println("");
			} else {
				System.out.println("登录失败");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		} finally {
			e.closeAll();
		}

		return employ;
	}

	@Override
	public boolean login(Employ employ) {
		boolean b=false;
		Employ employ1=e.selectByname(employ.getEmp_name());
		
		if(employ1!=null){
			if(employ1.getPassword().equals(employ.getPassword())){
				System.out.print("登录成功");
				return true;
			}
		}
		
		
		
		return b;
	}

	

	@Override
	public Employ selectByID(int empID) {
		ResultSet set=null;
		Employ employ=new Employ();
		try {
			set=e.selectByID(empID);
			if(set.next()){
				empID = set.getInt("empID");
				String name1 = set.getString("emp_name");
				String password1 = set.getString("password");
				String hire_date=set.getString("hire_date");
				double salary=set.getDouble("salary");
				String phone=set.getString("phone");
				String interest=set.getString("interest");
				String address=set.getString("address");
				String gender=set.getString("gender");
				employ = new Employ(empID,name1,hire_date,salary,password1,phone,interest,address,gender);
				System.out.print(employ);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employ;
	}

	@Override
	public Page<Employ> selectAll(int currentPage, int PageSize) {
		List<Employ> list = new ArrayList<Employ>();
		Connection conn = DBDao.getConnection();
		Page<Employ> page = new Page<Employ>(currentPage, PageSize);
		ResultSet set = null;
		Employ employ=new Employ();
		int total = 0;
		try {
			total = e.totalPage(conn);
			set = e.selectAllEmploy(conn, page);
			while (set.next()) {
				int empID = set.getInt("empID");
				String name1 = set.getString("emp_name");
				String password1 = set.getString("password");
				String hire_date=set.getString("hire_date");
				Double salary=set.getDouble("salary");
				String phone=set.getString("phone");
				String interest=set.getString("interest");
				String address=set.getString("address");
				String gender=set.getString("gender");
				employ = new Employ(empID,name1,hire_date,salary,password1,phone,interest,address,gender);
				System.out.print(employ);
				
				list.add(employ);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		page.setList(list);
		page.setTotal(total);
		return page;
	}
	
	


	@Override
	public int updateemploy(int empID,String emp_name, String hire_date,double salary, String password,String phone, String interest,
			String address,String gender) {
		Connection conn=DBDao.getConnection();
		int a=0;
		Employ employ = new  Employ();
		try {

			employ.setEmpID(empID);
			employ.setEmp_name(emp_name);
			employ.setHire_date(hire_date);
			employ.setSalary(salary);
			employ.setPassword(password);
			employ.setInterest(interest);
			employ.setAddress(address);
			employ.setGender(gender);
			employ=new Employ(empID,emp_name,hire_date,salary,password,phone,interest,address,gender);
			
			a=e.update(employ);
					

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			e.closeAll();
		}
		return 0;
	}

	@Override
	public Employ selectByname(String name) {
		// TODO Auto-generated method stub
		return null;
	}





	

}
