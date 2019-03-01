package com.shopping.serviceimpl;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import com.shopping.dao.DBDao;
import com.shopping.daoimpl.AdminDaoImpl;
import com.shopping.entity.Admin;
import com.shopping.entity.Categorys;
import com.shopping.service.AdminService;
public class AdminServiceImpl implements AdminService {
	public AdminDaoImpl d;
	public CategoryServiceImpl c;

	public AdminServiceImpl() {
		d = new AdminDaoImpl();
	}

	@Override
	public Admin findadmin(String name, String password) {
		// TODO Auto-generated method stub
		Admin admin2 = null;
		ResultSet set = null;
		Connection conn = DBDao.getConnection();
		try {
			Scanner in = new Scanner(System.in);
			set = d.selectAdmin(conn, new Admin(name, password));
			if (set.next()) {
				int id1 = set.getInt("id");
				String name1 = set.getString("name");
				String realname=set.getString("realname");
				String password1 = set.getString("password");
				String phone=set.getString("phone");
				String address=set.getString("address");
				admin2 = new Admin(id1, name1, realname, password1, phone, address);
				System.out.println("µÇÂ¼³É¹¦");
			} else {
				System.out.println("µÇÂ¼Ê§°Ü");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			d.closeAll();
		}

		return admin2;

	}

	@Override
	public ArrayList<Admin> selectAllAdmin() {
		ArrayList<Admin> list = new ArrayList<Admin>();
		Admin admin2 = null;
		ResultSet set = null;
		Connection conn = DBDao.getConnection();
		try {

			set = d.selectAllAdmin(conn);
			while (set.next()) {
				int id1 = set.getInt("id");
				String name1 = set.getString("name");
				String realname=set.getString("realname");
				String password1 = set.getString("password");
				String phone=set.getString("phone");
				String address=set.getString("address");
				
				list.add(new Admin(id1, name1,realname, password1,phone,address));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			d.closeAll();
		}

		return list;
	}

	@Override
	public int addAdmin(String name,String realname,String password,String phone,String address) {
		Admin admin = new Admin(name,realname,password,phone,address);
		int t = 0;
		try {
			
			
			admin.setName(name);
			admin.setRealname(realname);
			admin.setPassword(password);
			admin.setPhone(phone);
			admin.setAddress(address);
			t = d.insertAdmin(admin);

			if(t>0){
				System.out.println("Ìí¼Ó³É¹¦");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			
		}
		return t;
	}

	@Override
	public Admin selctByname(String name) {
		// TODO Auto-generated method stub
		return d.SelectByName(name);
	}

	@Override
	public boolean login(Admin admin) {
		Admin admin1=d.SelectByName(admin.getName());
		if(admin1!=null){
			if(admin1.getPassword().equals(admin.getPassword())){
				System.out.println("µÇÂ¼³É¹¦");
				return true;
				
			}
		}
		
		System.out.println("µÇÂ¼Ê§°Ü");
		return false;
	}
	
}
