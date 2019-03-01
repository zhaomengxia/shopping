package com.shopping.service;

import java.util.ArrayList;
import java.util.List;

import com.shopping.dao.Page;
import com.shopping.entity.Categorys;

public interface CategoryService {
	public int addcate(String category_name,String category_desc);

	public int deleteCategory(int categoryID);

	public int updateCategory(int id,String category_name,String category_desc);

	public ArrayList<Categorys> selectAllCate();

	public ArrayList<Categorys> selectCategoryByname(String category_name);

	public Page<Categorys> selectAllCate(int currentPage, int Pagesize);

	public Categorys selectByID(int categoryID);
	public List<Categorys> selectcategory();
	public Categorys selectByname(String category_name);
	public Page<Categorys> selectAllCate(Categorys p,int currentPage, int Pagesize);
}
