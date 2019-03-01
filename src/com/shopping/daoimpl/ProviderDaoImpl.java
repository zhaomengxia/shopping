package com.shopping.daoimpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.shopping.dao.BaseDao;
import com.shopping.dao.DBDao;
import com.shopping.dao.Page;
import com.shopping.dao.ProviderDao;
import com.shopping.entity.Categorys;
import com.shopping.entity.Products;
import com.shopping.entity.Providers;
import com.shopping.serviceimpl.CategoryServiceImpl;
import com.shopping.serviceimpl.ProviderServiceImpl;

public class ProviderDaoImpl extends BaseDao implements ProviderDao {

	@Override
	public int addProvider(Connection conn, Providers providers) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "insert into providers(provider_name,provider_add,provider_tel,account,email)values(?,?,?,?,?)";
		Object[] fields = { providers.getProvider_name(), providers.getProvider_add(), providers.getProvider_tel(),
				providers.getAccount(), providers.getEmail() };
		return super.updateDB(conn, sql, fields);

	}

	@Override
	public Page<Providers> selectAll(Connection conn, Providers p, Page<Providers> page) throws SQLException {
		String sql = "select * from providers where 1=1";
		ArrayList list = new ArrayList();
		if (!"".equals(p.getProvider_name()) && p.getProvider_name() != null) {
			sql = sql + "  and provider_name like ?";
			list.add("%" + p.getProvider_name() + "%");

		}
		System.out.print(sql);
		if (p.getProviderID() != 0) {
			sql = sql + "  and providerID=?";
			list.add(p.getProviderID());
		}
		
		sql = sql + " limit ?,?";

		list.add((page.getCurrentPage() - 1) * page.getPageSize());
		list.add(page.getPageSize());
		System.out.println(sql + "-------");
		ArrayList<Providers> list2 = new ArrayList<Providers>();

		ResultSet set = super.selectDB(conn, sql, list.toArray());
		while (set.next()) {
			Providers providers = new Providers();
			int providerID = set.getInt("providerID");
			String provider_name = set.getString("provider_name");
			String provider_add = set.getString("provider_add");
			String provider_tel = set.getString("provider_tel");
			String account = set.getString("account");
			String email = set.getString("email");
			providers = new Providers(providerID, provider_name, provider_add, provider_tel, account, email);
		
			list2.add(providers);

		}
		int totalRecord = getTotalRecord(conn, p);
		page.setList(list2);
		page.setTotal(totalRecord);

		return page;
	}
	public int getTotalRecord(Connection conn, Providers p) {
		int num = 0;
		ResultSet rs = null;
		String sql = "select count(providerID)from providers where 1=1";

		ArrayList list2 = new ArrayList();
		if (!"".equals(p.getProvider_name()) && p.getProvider_name() != null) {
			sql = sql + "  and provider_name like ?";
			list2.add("%" + p.getProvider_name() + "%");

		}
		if (p.getProviderID() != 0) {
			sql = sql + "  and providerID=?";
			list2.add(p.getProviderID());
		}
		
		System.out.println(sql + "-------");

		try {
			rs = super.getTotalRecord(conn, sql, list2.toArray());
			while (rs.next()) {
				num = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return num;

	}

	
	
	@Override
	public int deleteProviderByname(String provider_name) throws SQLException {
		Connection conn = DBDao.getConnection();
		String sql1 = "select pr.providerID,p.providerID from providers pr,products p where pr.providerID=p.providerID and provider_name=?";
		Object[] fields1 = { provider_name };
		ResultSet set = super.selectDB(conn, sql1, fields1);
		int a = 0;
		if(set.next()){
			a=0;
			System.out.println("--------É¾³ýÊ§°Ü----------");
		}
		else{	
		a=1;
		String sql = "delete from providers where provider_name=?";
		Object[] fields = { provider_name };
		super.updateDB(conn, sql, fields);
		System.out.println("------------É¾³ý³É¹¦-------------");
		}
		return a;

	}

	@Override
	public ResultSet selectAllProvider(Connection conn, Page<Providers> page) throws SQLException {
		String sql = "select * from providers limit ?,?";
		Object[] fields = { (page.getCurrentPage() - 1) * page.getPageSize(), page.getPageSize() };
		return super.selectDB(conn, sql, fields);

	}

	@Override
	public ResultSet selectAllProvider(Connection conn) throws SQLException {
		String sql = "select * from providers";

		return super.selectDB(conn, sql, null);
	}

	@Override
	public int totalPage(Connection conn) throws SQLException {
		String sql = "select count(providerID) from providers";

		ResultSet set = super.selectDB(conn, sql, null);
		int total = 0;
		if (set.next()) {
			total = set.getInt(1);
		}
		return total;
	}

	@Override
	public int updateProviders(Providers providers) throws SQLException {
			Connection conn = DBDao.getConnection();
			int t=0;
			
			String sql = "update providers set provider_name=?,provider_add=?,provider_tel=?,account=?,email=? where providerID=?";

			Object[] fields1 = { providers.getProvider_name(), providers.getProvider_add(), providers.getProvider_tel(),
					providers.getAccount(), providers.getEmail(), providers.getProviderID() };
			t=super.updateDB(conn, sql, fields1);
			
			
		return t;
	}

	@Override
	public ResultSet selectByID(int providerID) throws SQLException {
		Providers pro = null;
		String sql = "select * from providers where providerID=?";
		Connection conn = DBDao.getConnection();
		Object[] fields = { providerID };
		ResultSet set = super.selectDB(conn, sql, fields);

		return set;
	}

	@Override
	public ResultSet selectByname(Connection conn, String provider_name) throws SQLException {
		String sql = "select * from providers where provider_name like CONCAT('%',?,'%')";
		Object[] fields = { provider_name };
		ResultSet set = super.selectDB(conn, sql, fields);
		return set;
	}

	@Override
	public int deleteByID(Connection conn, int providerID) throws SQLException {
		String sql = "select pr.productID,ca.categoryID,pr.providerID,pr.categoryID,pro.providerID from products pr,categorys ca,providers pro where pro.providerID=pr.providerID and pro.providerID=?";
		Object[] fields = { providerID };

		ResultSet set = super.selectDB(conn, sql, fields);
		int t = 0;
		if (set.next()) {
			t = 0;
			System.out.println("É¾³ý²»ÁË£¡Íâ¼üÔ¼Êø");
		} else {
			t = 1;
			String sql1 = "delete from providers where providerID=?";
			super.updateDB(conn, sql1, fields);
		}
		return t;
	}

}
