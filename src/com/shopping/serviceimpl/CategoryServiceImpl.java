package com.shopping.serviceimpl;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.shopping.dao.BaseDao;
import com.shopping.dao.DBDao;
import com.shopping.dao.Page;
import com.shopping.daoimpl.CategoryDaoImpl;
import com.shopping.entity.Categorys;
import com.shopping.service.CategoryService;

public class CategoryServiceImpl implements CategoryService {
	public CategoryDaoImpl cat;
	public BaseDao b;

	public CategoryServiceImpl() {
		cat = new CategoryDaoImpl();
	}

	public String input() {
		byte[] b = new byte[50];
		try {
			System.in.read(b);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new String(b).trim();
	}

	@Override
	public int addcate(String category_name,String category_desc) {
		// TODO Auto-generated method stub
		int t = 0;
		Connection conn=DBDao.getConnection();
		try {
			Categorys cate1=new Categorys(category_name,category_desc);
			cate1.setCategory_name(category_name);
			cate1.setCategory_desc(category_desc);
			ResultSet cates=cat.selectCategoryByname(conn, cate1.getCategory_name());
			if(cates.next()){
				t=-1;
				System.out.println("类别重名，添加失败。");
				
			}
			else{
				t=cat.addCategory(cate1);
				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			
		}
		return t;
	}

	@Override
	public int deleteCategory(int categoryID) {
		// TODO Auto-generated method stub

		return cat.deleteCategoryByname(categoryID);
	}

	@Override
	public int updateCategory(int id,String category_name,String category_desc) {
		// TODO Auto-generated method stub
				int t = 0;
				Connection conn=DBDao.getConnection();
				try {
					Categorys cate1=new Categorys(id,category_name,category_desc);
					cate1.setCategoryID(id);
					cate1.setCategory_name(category_name);
					cate1.setCategory_desc(category_desc);
					ResultSet cates=cat.selectCategoryByname(conn, cate1.getCategory_name());
					if(cates.next()){
						if(id==cate1.getCategoryID()){
							t=cat.updateCategory(cate1);
						}
						
						else{
							t=0;
							
						}
					}else{
						t=cat.updateCategory(cate1);
					}
					
					
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					
				}
				return t;
	}

	@Override
	public ArrayList<Categorys> selectAllCate() {
		ArrayList<Categorys> list = new ArrayList<Categorys>();
		Connection conn = DBDao.getConnection();
		ResultSet set = null;
		try {
			set = cat.selectAllCategory(conn);
			while (set.next()) {
				int id = set.getInt("categoryID");
				String name = set.getString("category_name");
				String desc = set.getString("category_desc");
				list.add(new Categorys(id, name, desc));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			cat.closeAll();
		}
		return list;
	}

	@Override
	public Page<Categorys> selectAllCate(int currentPage, int PageSize) {
		// TODO Auto-generated method stub
		Page<Categorys> page = new Page<Categorys>(currentPage, PageSize);
		Connection conn = DBDao.getConnection();
		List<Categorys> list = new ArrayList<Categorys>();
		int total = 0;
		try {
			ResultSet set= cat.selectAllCategory(conn, page);
			total = cat.totalPage(conn);
			while (set.next()) {
				Categorys category=new Categorys();
				category.setCategoryID(set.getInt("categoryID"));
				category.setCategory_name(set.getString("category_name"));
				category.setCategory_desc(set.getString("category_desc"));
				list.add(category);	
			}
			
		} catch (SQLException e) {
			System.out.print("--------");
		}
		page.setList(list);

		page.setTotal(total);
		return page;
	}

	@Override
	public ArrayList<Categorys> selectCategoryByname(String name) {
		Connection conn = DBDao.getConnection();
		ResultSet set = null;
		Categorys categorys = null;
		ArrayList<Categorys> list = new ArrayList<Categorys>();
		try {
			set = cat.selectCategoryByname(conn, name);
			if (set.next()) {
				System.out.println("--------您查找的内容如下！--------");
				while (set.next()) {
					int id = set.getInt("categoryID");
					String name1 = set.getString("category_name");
					String desc = set.getString("category_desc");
					list.add(new Categorys(id, name1, desc));
				}

			} else {
				System.out.println("----------您查找的内容不存在----------");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			cat.closeAll();
		}
		return list;
	}

	@Override
	public Categorys selectByID(int categoryID) {
		ResultSet set = null;
		Categorys categorys = null;
		
		try {
			set = cat.selectCateByID(categoryID);
			if (set.next()) {
				int id = set.getInt("categoryID");
				String name1 = set.getString("category_name");
				String desc = set.getString("category_desc");
				categorys = new Categorys(id, name1, desc);
				
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			cat.closeAll();
		}
		return categorys;
	}

	@Override
	public List<Categorys> selectcategory() {
		// TODO Auto-generated method stub
		return cat.selectCate();
	}

	@Override
	public Categorys selectByname(String category_name) {
		return cat.selectCateByname(category_name);
		
	}

	@Override
	public Page<Categorys> selectAllCate(Categorys p, int currentPage, int PageSize) {
		Connection conn=DBDao.getConnection();
		try {
			Page<Categorys> cate=cat.selectAll(conn, p, new Page<Categorys>(currentPage,PageSize));
			return cate;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
