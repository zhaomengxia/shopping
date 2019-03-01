package com.shopping.daoimpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.shopping.dao.BaseDao;
import com.shopping.dao.CategoryDao;
import com.shopping.dao.DBDao;
import com.shopping.dao.Page;
import com.shopping.entity.Categorys;
import com.shopping.serviceimpl.CategoryServiceImpl;

public class CategoryDaoImpl extends BaseDao implements CategoryDao {

	@Override
	public int addCategory(Categorys cate) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = DBDao.getConnection();
		String sql = "insert into categorys(category_name,category_desc)values(?,?)";
		Object[] fields = { cate.getCategory_name(), cate.getCategory_desc() };
		int result = super.updateDB(conn, sql, fields);
		return result;
	}

	@Override
	public int deleteCategoryByname(int categoryID){
		Connection conn = DBDao.getConnection();
		String sql1 = "select c.categoryID,p.categoryID from categorys c,products p where p.categoryID=c.categoryID and c.categoryID=?";
		Object[] fields1 = { categoryID };
		ResultSet set;
		int a = 0;
		try {
			set = super.selectDB(conn, sql1, fields1);
		if (set.next()) {
			a = 0;
			System.out.println("-----------É¾³ýÊ§°Ü£¬Íâ¼üÔ¼Êø---------");
		} else {
			a = 1;
			String sql = "delete from categorys where categoryID=?";
			Object[] fields = { categoryID };
			super.updateDB(conn, sql, fields);
			System.out.println("É¾³ý³É¹¦");
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return a;

	}

	@Override
	public int updateCategory(Categorys cate) throws SQLException {
		Connection conn = DBDao.getConnection();
		int t = 0;
		String sql = "update categorys set category_name=?,category_desc=? where categoryID=?";
		Object[] fields = { cate.getCategory_name(), cate.getCategory_desc(), cate.getCategoryID() };
		t = super.updateDB(conn, sql, fields);
		return t;

	}

	@Override
	public ResultSet selectAllCategory(Connection conn) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "select * from categorys";
		conn.prepareStatement(sql);
		return super.selectDB(conn, sql, null);

	}

	@Override
	public ResultSet selectCategoryByname(Connection conn, String category_name) throws SQLException {
		String sql = "select * from categorys where category_name like CONCAT('%',?,'%')";
		Object[] fields = { category_name };
		return super.selectDB(conn, sql, fields);

	}

	public Categorys selectCateByname(String category_name){
		String sql="select * from categorys where category_name=?";
		Connection conn=DBDao.getConnection();
		Object[] fields={category_name};
		ResultSet set=null;
		Categorys category=new Categorys();
		try {
			set=super.selectDB(conn, sql, fields);
			if(set.next()){
				category.setCategoryID(set.getInt("categoryID"));
				category.setCategory_name(set.getString("category_name"));
				category.setCategory_desc(set.getString("category_desc"));
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return category;
	}
	@Override
	public ResultSet selectAllCategory(Connection conn, Page<Categorys> page) throws SQLException{
		// TODO Auto-generated method stub
		String sql = "select * from categorys limit ?,?";
		Object[] fields = { (page.getCurrentPage() - 1) * page.getPageSize(), page.getPageSize() };
		
		
		return	super.selectDB(conn, sql, fields);
		
		
	}

	@Override
	public int totalPage(Connection conn) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "select count(categoryID) from categorys";
		ResultSet set = super.selectDB(conn, sql, null);
		int record = 0;
		if (set.next()) {
			record = set.getInt(1);
		}
		return record;
	}

	@Override
	public ResultSet selectCateByID(int categoryID) throws SQLException {
		String sql = "select * from categorys where categoryID=?";
		Connection conn = DBDao.getConnection();
		Object[] fields = { categoryID };
		ResultSet set = super.selectDB(conn, sql, fields);
		return set;

	}
	
	

	@Override
	public List<Categorys> selectCate() {
		List<Categorys> list=new ArrayList<Categorys>();
		Connection conn = DBDao.getConnection();
		String sql = "select * from categorys order by categoryID desc";

		try {
			ResultSet set = super.selectDB(conn, sql, null);
			
			while(set.next()){
				int categoryID=set.getInt("categoryID");
				String category_name=set.getString("category_name");
				String category_desc=set.getString("category_desc");
				
				Categorys category=new Categorys(categoryID,category_name,category_name);
				list.add(category);
				
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			super.closeAll();
		}
		return list;
	}

	@Override
	public Page<Categorys> selectAll(Connection conn, Categorys p, Page<Categorys> page) throws SQLException {
		String sql="select * from categorys where 1=1";
		ArrayList list=new ArrayList();
		
		if(!"".equals(p.getCategory_name())&&p.getCategory_name()!=null){
			sql=sql+"  and category_name like ?";
			list.add("%"+p.getCategory_name()+"%");
			
		}
		sql=sql+"  limit ?,?";
		System.out.print(sql);
		list.add((page.getCurrentPage()-1)*page.getPageSize());
		list.add(page.getPageSize());
		
		
		ResultSet set=super.selectDB(conn, sql, list.toArray());
		ArrayList<Categorys> list2=new ArrayList<Categorys>();
		System.out.print(list2);
		while(set.next()){
			Categorys category=new Categorys();
			category.setCategoryID(set.getInt("categoryID"));
			category.setCategory_name(set.getString("category_name"));
			category.setCategory_desc(set.getString("category_desc"));
			list2.add(category);
			
		}
		page.setList(list2);
		int totalrecord=getTotalRecord(conn, p);
		page.setTotal(totalrecord);;
		
		return page;
	}

	@Override
	public int getTotalRecord(Connection conn, Categorys p) {
		String sql="select * from categorys where 1=1 ";
		ArrayList list=new ArrayList();
	
		ResultSet set=null;
		if(!"".equals(p.getCategory_name())&&p.getCategory_name()!=null){
			sql=sql+"  and category_name like ?";
			list.add("%"+p.getCategory_name()+"%");
			
		}
		int record=0;
		try {
			set=super.getTotalRecord(conn, sql, list.toArray());
			while(set.next()){
				record=set.getInt(1);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return record;
	}

}
