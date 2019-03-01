package com.shopping.serviceimpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.shopping.dao.ProviderDao;
import com.shopping.daoimpl.ProviderDaoImpl;
import com.shopping.dao.DBDao;
import com.shopping.dao.Page;
import com.shopping.entity.Products;
import com.shopping.entity.Providers;
import com.shopping.service.ProviderService;
import com.shopping.serviceimpl.ProviderServiceImpl;

public class ProviderServiceImpl implements ProviderService {
	ProviderDaoImpl p;

	public ProviderServiceImpl() {
		p = new ProviderDaoImpl();
	}

	public static void validateEmail(String email) {
		String regex = "[0-9a-zA-Z]+@[0-9a-zA-Z]+//.[0-9a-zA-Z]+";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(email);
		if (matcher.matches()) {
			System.out.print("--合法-");
		} else {
			System.out.println("---非法-");
		}
	}

	@Override
	public int addPro(String provider_name, String provider_add, String provider_tel, String account, String email) {
		Connection conn = DBDao.getConnection();
		Providers providers = new Providers(provider_name,provider_add,provider_tel,account,email);
		
		int y = 0;
		try {

			providers.setProvider_name(provider_name);
			providers.setProvider_add(provider_add);
			providers.setProvider_tel(provider_tel);
			providers.setAccount(account);
			providers.setEmail(email);
			y = p.addProvider(conn, providers);
			if (y > 0) {
				System.out.println("添加成功：");

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return y;
	}

	@Override
	public Page<Providers> selectAllProvider(int currentPage, int PageSize) {
		List<Providers> list = new ArrayList<Providers>();
		Connection conn = DBDao.getConnection();
		Page<Providers> page = new Page<Providers>(currentPage, PageSize);
		ResultSet set = null;
		int total = 0;
		try {
			total = p.totalPage(conn);
			set = p.selectAllProvider(conn, page);
			while (set.next()) {
				int providerID = set.getInt("providerID");
				String provider_name = set.getString("provider_name");
				String provider_add = set.getString("provider_add");
				String provider_tel = set.getString("provider_tel");
				String account = set.getString("account");
				String email = set.getString("email");
				list.add(new Providers(providerID, provider_name, provider_add, provider_tel, account, email));

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
	public int delete(String provider_name) {
		int t = 0;
		try {
			t = p.deleteProviderByname(provider_name);
			if (t > 0) {
				System.out.println("-----删除成功-----");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			p.closeAll();
		}
		return t;
	}

	@Override
	public ArrayList<Providers> selectAllProviders() {
		Connection conn = DBDao.getConnection();
		ArrayList<Providers> list = new ArrayList<Providers>();

		ResultSet set = null;
		try {

			set = p.selectAllProvider(conn);
			while (set.next()) {
				int providerID = set.getInt("providerID");
				String provider_name = set.getString("provider_name");
				String provider_add = set.getString("provider_add");
				String provider_tel = set.getString("provider_tel");
				String account = set.getString("account");
				String email = set.getString("email");
				list.add(new Providers(providerID, provider_name, provider_add, provider_tel, account, email));

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			p.closeAll();
		}

		return list;
	}

	@Override
	public int updateProviders(int providerID,String provider_name, String provider_add, String provider_tel, String account,
			String email) {
		Connection conn=DBDao.getConnection();
		int a=0;
		try {
			Providers providers = new Providers(providerID,provider_name,provider_add,provider_tel,account,email);

			providers.setProviderID(providerID);
			providers.setProvider_name(provider_name);

			providers.setProvider_add(provider_add);

			providers.setProvider_tel(provider_tel);

			providers.setAccount(account);
			providers.setEmail(email);
			
			ResultSet set=p.selectByname(conn, providers.getProvider_name());
			if(set.next()){
				if(providers.getProviderID()==providerID){
					a=p.updateProviders(providers);
					
				}
				else{
				a=-1;
					System.out.println("供应商重名，修改失败！--");
				}
			}
			else{
				a=p.updateProviders(providers);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			p.closeAll();
		}
		return 0;
	}

	@Override
	public Providers selectByID(int providerID) {
		ResultSet set = null;
		Providers providers = null;
		try {
			set = p.selectByID(providerID);
			while (set.next()) {
				providerID = set.getInt("providerID");
				String provider_name = set.getString("provider_name");
				String provider_add = set.getString("provider_add");
				String provider_tel = set.getString("provider_tel");
				String account = set.getString("account");
				String email = set.getString("email");
				providers = new Providers(providerID, provider_name, provider_add, provider_tel, account, email);
				System.out.println(providers);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			p.closeAll();
		}
		return providers;
	}

	@Override
	public Page<Providers> selectAllCate(Providers p1, int currentPage, int PageSize) {
		Connection conn=null;
		conn=DBDao.getConnection();
		Page<Providers> page=null;
		try {
			 page=p.selectAll(conn, p1, new Page<Providers>(currentPage,PageSize));
		return page;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return page;
	}
	
	
	@Override
	public ArrayList<Providers> selectByname(String provider_name) {
		Connection conn = DBDao.getConnection();
		ResultSet set = null;
		Providers providers = null;
		ArrayList<Providers> list = new ArrayList<Providers>();
		try {
			set = p.selectByname(conn, provider_name);
			while (set.next()) {
				int providerID = set.getInt("providerID");
				provider_name = set.getString("provider_name");
				String provider_add = set.getString("provider_add");
				String provider_tel = set.getString("provider_tel");
				String account = set.getString("account");
				String email = set.getString("email");
				list.add(new Providers(providerID, provider_name, provider_add, provider_tel, account, email));

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			p.closeAll();
		}
		return list;
	}

	@Override
	public int deleteByID(int providerID) {
		// TODO Auto-generated method stub
		Connection conn = DBDao.getConnection();
		int t = 0;
		try {
			t = p.deleteByID(conn, providerID);
			if (t > 0) {
				System.out.println("删除成功！");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			p.closeAll();
		}
		return t;
	}

}
