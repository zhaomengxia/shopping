package com.shopping.service;

import java.util.ArrayList;

import com.shopping.dao.Page;
import com.shopping.entity.Providers;

public interface ProviderService {
	public int addPro(String provider_name,String provider_add,String provider_tel,String account,String email);

	public Page<Providers> selectAllProvider(int currentPage, int Pagesize);

	public int delete(String product_name);

	public ArrayList<Providers> selectAllProviders();

	public int updateProviders(int providerID,String provider_name,String provider_add,String provider_tel,String account,String email);

	public Providers selectByID(int providerID);

	public ArrayList<Providers> selectByname(String provider_name);

	public int deleteByID(int providerID);
	public Page<Providers> selectAllCate(Providers p1, int currentPage, int PageSize);
}
