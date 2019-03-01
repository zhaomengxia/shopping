package com.shopping.service;
import java.util.ArrayList;
import com.shopping.entity.Admin;
import com.shopping.entity.Products;
public interface AdminService {
	public Admin findadmin(String name, String password);
	public ArrayList<Admin> selectAllAdmin();
	public int addAdmin(String name,String realname,String password,String phone,String address);
	public Admin selctByname(String name);
	public boolean login(Admin admin);
}
