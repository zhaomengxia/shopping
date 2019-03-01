package com.shopping.serviceimpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletResponse;

import com.shopping.dao.BaseDao;
import com.shopping.dao.CategoryDao;
import com.shopping.dao.ProductDao;
import com.shopping.dao.ProviderDao;
import com.shopping.daoimpl.CategoryDaoImpl;
import com.shopping.daoimpl.ProductDaoImpl;
import com.shopping.daoimpl.ProviderDaoImpl;
import com.shopping.dao.DBDao;
import com.shopping.dao.Page;
import com.shopping.entity.Categorys;
import com.shopping.entity.Products;
import com.shopping.entity.Providers;
import com.shopping.service.ProductService;
import com.shopping.utils.ExcelExportHelper;

public class ProductServiceImpl implements ProductService {
	ProductDaoImpl p;
	ProviderDaoImpl providers;
	CategoryDaoImpl categorys;
	public static final String str = " ";
	public CategoryDaoImpl cat;
	
	public ProductServiceImpl() {
		p = new ProductDaoImpl();
	}

	public void getDate(String str) {
		String regEx = "([a-zA-Z]+)//s+[0-9]{1,2},//s*[0-9]{4}";
		Pattern pattern = Pattern.compile(regEx);
		Matcher matcher = pattern.matcher(str);
		if (!matcher.find()) {
			System.out.println("-------日期格式错误------");
			return;
		}
		System.out.println(matcher.group(1));

	}

	@Override
	public int addProducts(Products... products) {
		// TODO Auto-generated method stub
		Connection conn = DBDao.getConnection();

		int i = 0;
		try {
			conn.setAutoCommit(false);
			int[] result = p.addProduct(conn, products);
			conn.commit();
			conn.setAutoCommit(true);
			if (result.length > 0) {
				i = result.length;
			}
		} catch (SQLException e) {
			try {
				conn.rollback();
				conn.setAutoCommit(true);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} finally {
				p.closeAll();
			}
		}

		return i;
	}

	@Override
	public int addProduct(Products product) {
		ProductDaoImpl pro=new ProductDaoImpl();
		Connection conn=DBDao.getConnection();
		int t=0;
		try {
			t=pro.addProduct(conn, product);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return t;
	}

	@Override
	public Page<Products> selectAllCate(int currentPage, int PageSize) {

		
		Page<Products> page = new Page<Products>(currentPage, PageSize);
		List<Products> list = new ArrayList<Products>();
		Connection conn = DBDao.getConnection();
		ResultSet set = null;

		int total = 0;
		
				try {
					total = p.totalPage(conn);
					set = p.selectAllProduct(conn, page);
				
					while (set.next()) {
						Products pro=new Products();
						Providers pdi=new Providers();
						Categorys cate=new Categorys();
						pro.setProductID(set.getInt("productID"));
						pro.setProduct_name(set.getString("product_name"));
						pro.setIncome_price(set.getDouble("income_price"));
						int providerID = set.getInt("providerID");
						
						ProviderServiceImpl prov=new ProviderServiceImpl();
						pdi=prov.selectByID(providerID);
						pro.setProvider(pdi);
						pro.setQuantity(set.getInt("quantity"));
						pro.setSales_price(set.getDouble("sales_price"));
						CategoryServiceImpl csi=new CategoryServiceImpl();
						int categoryID = set.getInt("categoryID");
						cate=csi.selectByID(categoryID);
						pro.setCategory(cate);
						pro.setIncome_time(set.getString("income_time"));
						
						list.add(pro);
					}
					if(list!=null){
						
						page.setList(list);
					}
					else{
						System.out.print("为空");
						
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					
				} finally {
					p.closeAll();
				}
				page.setTotal(total);
				return page;	
		
	}

	@Override
	public int delete(String product_name) {
		int t = 0;
		try {
			t = p.deleteProductByname(product_name);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			p.closeAll();
		}
		return 0;
	}

	@Override
	public ArrayList<Products> selectAllProduct() {
		// TODO Auto-generated method stub
		ArrayList<Products> list = new ArrayList<Products>();
		Connection conn = DBDao.getConnection();
		Products products=new Products();
		Providers pdi=new Providers();
		Categorys cate=new Categorys();
		ResultSet set = null;
		try {
			set = p.selectAllProduct(conn);
			while (set.next()) {
				int productID = set.getInt("productID");
				String product_name = set.getString("product_name");
				double income_price = set.getDouble("income_price");
				
				int providerID = set.getInt("providerID");
				ProviderServiceImpl psi=new ProviderServiceImpl();
				Providers provider=new Providers();
				provider=psi.selectByID(providerID);
				
				int quantity = set.getInt("quantity");
				double sales_price = set.getDouble("sales_price");
				int categoryID = set.getInt("categoryID");
				CategoryServiceImpl csi=new CategoryServiceImpl();
				 cate=new Categorys();
				cate=csi.selectByID(categoryID);
				String income_time=set.getString("income_time");
				products = new Products(productID,product_name,income_price,provider,quantity,sales_price,cate,income_time);
			
				list.add(products);
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
	public int deleteByproductID(int productID) {
		int i = 0;
		try {
			i = p.deleteProductByID(productID);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}

	@Override
	public ArrayList<Products> selctByname(String product_name) {
		
		ResultSet set = null;
		Products products = null;
		Connection conn = DBDao.getConnection();
		ArrayList<Products> list = new ArrayList<Products>();
		
		// TODO Auto-generated method stub
		
				Products pro=new Products();
				Providers pdi=new Providers();
				Categorys cate=new Categorys();
				
				try {
					set = p.selectByname(conn, product_name);
				while(set.next()) {
						pro.setProductID(set.getInt("productID"));
						pro.setProduct_name(set.getString("product_name"));
						pro.setIncome_price(set.getDouble("income_price"));
						int providerID = set.getInt("providerID");
						
						ProviderServiceImpl prov=new ProviderServiceImpl();
						pdi=prov.selectByID(providerID);
						pro.setProvider(pdi);
						pro.setQuantity(set.getInt("quantity"));
						pro.setSales_price(set.getDouble("sales_price"));
						CategoryServiceImpl csi=new CategoryServiceImpl();
						int categoryID = set.getInt("categoryID");
						cate=csi.selectByID(categoryID);
						pro.setCategory(cate);
						pro.setIncome_time(set.getString("income_time"));
						
						list.add(pro);
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
	public int updateProduct(int productID,String product_name, double income_price, Providers provider, int quantity,
			double sales_price, Categorys category, String income_time) {
		int a=0;
		Connection conn=DBDao.getConnection();
		try {
			Products product=new Products(productID,product_name,income_price,provider,quantity,sales_price,category,income_time);
			ResultSet set=p.selectByID(conn, productID);
			product.setProductID(productID);
			product.setProduct_name(product_name);
			product.setIncome_price(income_price);
			/*int providerID=set.getInt("providerID");
			ProviderServiceImpl service=new ProviderServiceImpl();
			provider=service.selectByID(providerID);*/
			product.setProvider(provider);
			
			product.setQuantity(quantity);
			product.setSales_price(sales_price);
			/*int categoryID=set.getInt("categoryID");
			CategoryServiceImpl services=new CategoryServiceImpl();
			category=services.selectByID(categoryID);*/
			product.setCategory(category);
			product.setIncome_time(income_time);
			if(set.next()){
				
					a=p.updateProduct(product);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return a;
	}

	@Override
	public Products selectByID(int productID) {
		Connection conn = DBDao.getConnection();
		Products products = null;
		ResultSet set = null;
		try {
			set = p.selectByID(conn, productID);
			while (set.next()) {
				productID = set.getInt("productID");
				String product_name = set.getString("product_name");
				double income_price = set.getDouble("income_price");
				
				int providerID = set.getInt("providerID");
				ProviderServiceImpl psi=new ProviderServiceImpl();
				Providers provider=new Providers();
				provider=psi.selectByID(providerID);
				
				int quantity = set.getInt("quantity");
				double sales_price = set.getDouble("sales_price");
				int categoryID = set.getInt("categoryID");
				CategoryServiceImpl csi=new CategoryServiceImpl();
				Categorys cate=new Categorys();
				cate=csi.selectByID(categoryID);
				String income_time=set.getString("income_time");
				products = new Products(productID,product_name,income_price,provider,quantity,sales_price,cate,income_time);
				System.out.println(products);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			p.closeAll();
		}
		return products;
	}

	@Override
	public int deletemanyByID(Integer[] productID) {
		// TODO Auto-generated method stub
		return p.delmanyproByIDs(productID);
	}

	@Override
	public Page<Products> selectAllCate(Products p1, int currentPage, int PageSize) {
		Connection conn=null;
		conn=DBDao.getConnection();
		Page<Products> page=null;
		try {
			 page=p.selectAll(conn, p1, new Page<Products>(currentPage,PageSize));
		return page;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return page;
	}
	@Override
	public List<Products> selectAllCate1(String product_name, int currentPage, int PageSize) {
		Connection conn=null;
		conn=DBDao.getConnection();
		
		try {
			List<Products> page=p.selectAll1(conn, product_name, currentPage,PageSize);
		return page;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
public ArrayList<Products> searchProductByCategoryId(int categoryID) {
		
		ResultSet set = null;
		Products products = new Products();
		Connection conn = DBDao.getConnection();
		ArrayList<Products> list = new ArrayList<Products>();
		ArrayList<Categorys> list2=new ArrayList<Categorys>();
	
		
				
				Providers pdi=new Providers();
				Categorys cate=new Categorys();
				
				try {
					set = p.searchProductByCategoryId(conn, categoryID);
				while(set.next()) {
					
					int productID = set.getInt("productID");
					String product_name = set.getString("product_name");
					double income_price = set.getDouble("income_price");
					
					int providerID = set.getInt("providerID");
					ProviderServiceImpl psi=new ProviderServiceImpl();
					Providers provider=new Providers();
					provider=psi.selectByID(providerID);
					
					int quantity = set.getInt("quantity");
					double sales_price = set.getDouble("sales_price");
					categoryID = set.getInt("categoryID");
					CategoryServiceImpl csi=new CategoryServiceImpl();
					
					cate=csi.selectByID(categoryID);
					String income_time=set.getString("income_time");
					products = new Products(productID,product_name,income_price,provider,quantity,sales_price,cate,income_time);
					System.out.println(products);
						list.add(products);
						
						
						
						
						
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
public int getTotalRecord(Products p1) {
	// TODO Auto-generated method stub
	Connection conn=DBDao.getConnection();
	return p.getTotalRecord(conn, p1);
}

@Override
public void exportOrder(HttpServletResponse response) {
	// TODO Auto-generated method stub
	String[] header = new String[]{
            "产品目录",
            "产品描述"
                
    };
    String[] properties = new String[]{
            "category_name",
            "category_desc"
            
           
    };
    

    List<Object> list=new ArrayList<Object>();
	Connection conn = DBDao.getConnection();
	ResultSet set = null;
	int  flag=1;
	try {
		set = cat.selectAllCategory(conn);
		while (set.next()) {
			
			int id = set.getInt("categoryID");
			String name = set.getString("category_name");
			String desc = set.getString("category_desc");
			Categorys category=new Categorys(id, name, desc);
			category.setCategoryID(flag);
			flag++;
			Object object=category;
			list.add(object);
		}
		ExcelExportHelper excel=new ExcelExportHelper();
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
		excel.exportExcelAndSave(header, properties, list, str, "订单汇总表-"+format.format(new Date()), response);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} finally {
		cat.closeAll();
	}
	
}



}
