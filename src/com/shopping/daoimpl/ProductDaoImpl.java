package com.shopping.daoimpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.shopping.dao.BaseDao;
import com.shopping.dao.DBDao;
import com.shopping.dao.Page;
import com.shopping.dao.ProductDao;
import com.shopping.entity.Categorys;
import com.shopping.entity.Products;
import com.shopping.entity.Providers;
import com.shopping.serviceimpl.CategoryServiceImpl;
import com.shopping.serviceimpl.ProviderServiceImpl;

public class ProductDaoImpl extends BaseDao implements ProductDao {

	@Override
	public int[] addProduct(Connection conn, Products... products) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "insert into products(product_name,income_price,quantity,sales_price,income_time)values(?,?,?,?,?)";
		Object[][] fields = new Object[products.length][];
		for (int i = 0; i < products.length; i++) {
			fields[i] = new Object[] { products[i].getProduct_name(), products[i].getIncome_price(),
					products[i].getQuantity(), products[i].getSales_price(), products[i].getIncome_time() };
		}
		return super.addMoreData(conn, sql, fields);

	}

	@Override
	public int addProduct(Connection conn, Products products) throws SQLException {
		// TODO Auto-generated method stub
		String sal = "select pr.providerID,c.categoryID,p.providerID,p.categoryID from products p,categorys c,providers pr where ?=pr.providerID and ?=c.categoryID ";
		Object[] fields1 = { products.getProvider().getProviderID(), products.getCategory().getCategoryID() };
		ResultSet set = super.selectDB(conn, sal, fields1);
		int t = 0;
		while (set.next()) {

			t++;
		}
		if (t > 0) {
			String sql = "insert into products(product_name,income_price,providerID,quantity,sales_price,categoryID,income_time,filename)values(?,?,?,?,?,?,?,?)";
			Object[] fields = { products.getProduct_name(), products.getIncome_price(),
					products.getProvider().getProviderID(), products.getQuantity(), products.getSales_price(),
					products.getCategory().getCategoryID(), products.getIncome_time(),products.getFilename()};
			int s = super.updateDB(conn, sql, fields);
			if (t == 0) {
				System.out.println("ÓÐÍâ¼üÔ¼Êø£¡==");
			} else {
				if (s < 1) {
					System.out.println("Ìí¼ÓÊ§°Ü");
					t = -1;
				} else {
					System.out.println("success");
				}

			}

		}
		return t;
	}

	@Override
	public ResultSet selectAllProduct(Connection conn, Page<Products> page) throws SQLException {
		String sql = "select * from products limit ?,?";
		Object[] fields = { (page.getCurrentPage() - 1) * page.getPageSize(), page.getPageSize() };
		return super.selectDB(conn, sql, fields);

	}

	@Override
	public int totalPage(Connection conn) throws SQLException {
		String sql = "select count(productID) from products";
		ResultSet set = super.selectDB(conn, sql, null);
		int total = 0;
		if (set.next()) {
			total = set.getInt(1);
		}

		return total;
	}

	@Override
	public int deleteProductByname(String product_name) throws SQLException {
		Connection conn = DBDao.getConnection();
		String sql = "delete from products where product_name=?";
		Object[] fields = { product_name };
		int t = 0;

		t = super.updateDB(conn, sql, fields);
		if (t > 0) {
			System.out.println("É¾³ý³É¹¦");
		} else {
			System.out.println("É¾³ýÊ§°Ü");
		}
		return t;

	}

	@Override
	public ResultSet selectAllProduct(Connection conn) throws SQLException {
		String sql = "select * from products order by productID desc";
		return super.selectDB(conn, sql, null);

	}

	@Override
	public int updateProduct(Products products) throws SQLException {
		Connection conn = DBDao.getConnection();
		String sql = "update products set product_name=?,income_price=?,providerID=?,quantity=?,sales_price=?,categoryID=?,income_time=? where productID=?";
		Object[] fields1 = { products.getProduct_name(), products.getIncome_price(),
				products.getProvider().getProviderID(), products.getQuantity(), products.getSales_price(),
				products.getCategory().getCategoryID(), products.getIncome_time(), products.getProductID() };
		int t = super.updateDB(conn, sql, fields1);

		return t;

	}

	@Override
	public int deleteProductByID(int productID) throws SQLException {
		Connection conn = DBDao.getConnection();
		int t = 0;
		String sql1 = "delete from products where productID=?";
		Object[] fields = { productID };
		t = super.updateDB(conn, sql1, fields);

		return t;

	}

	@Override
	public ResultSet selectByname(Connection conn, String product_name) throws SQLException {
		String sql = "select * from products where product_name like CONCAT('%',?,'%')";
		Object[] fields = { product_name };
		ResultSet set = super.selectDB(conn, sql, fields);
		return set;

	}

	@Override
	public ResultSet selectByID(Connection conn, int productID) throws SQLException {
		String sql = "select * from products where productID=?";
		Object[] fields = { productID };
		ResultSet set = super.selectDB(conn, sql, fields);
		return set;
	}

	@Override
	public List<Products> selectAllp() {
		List<Products> list = new ArrayList<Products>();
		Connection conn = DBDao.getConnection();
		Products product = new Products();
		String sql = "select * from products order by productID desc";
		Object[] fields = { product.getProductID() };
		try {
			ResultSet set = super.selectDB(conn, sql, fields);
			while (set.next()) {
				product.setProductID(set.getInt("productID"));
				product.setProduct_name(set.getString("product_name"));

				product.setIncome_price(set.getDouble("income_price"));
				Providers provider = new Providers();

				int providerID = set.getInt("providerID");
				ProviderServiceImpl service = new ProviderServiceImpl();
				provider = service.selectByID(providerID);
				product.setProvider(provider);
				product.setQuantity(set.getInt("quantity"));
				product.setSales_price(set.getDouble("sales_price"));
				int categoryID = set.getInt("categoryID");
				Categorys cate = new Categorys();
				CategoryServiceImpl categorys = new CategoryServiceImpl();
				cate = categorys.selectByID(categoryID);
				product.setCategory(cate);
				product.setIncome_time(set.getString("income_time"));
				product.setFilename(set.getString("filename"));
				list.add(product);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			super.closeAll();
		}
		return list;
	}

	@Override
	public int delmanyproByIDs(Integer[] ids) {
		Connection conn = DBDao.getConnection();
		int t = 0;
		String sql = "delete from products where 1=1";
		if (ids != null && ids.length > 0) {
			sql = sql + "  and productID in (";
			for (int i = 0; i < ids.length; i++) {

				if (i == 0) {
					sql = sql + "?";
				} else if (i > 0) {
					sql = sql + ",?";
				}
			}
			sql = sql + ")";
		}
		Products product = new Products();
		try {
			t = super.updateDB(conn, sql, ids);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return t;
	}

	@Override
	public Page<Products> selectAll(Connection conn, Products p, Page<Products> page) throws SQLException {
		String sql = "select * from products where 1=1";
		ArrayList list = new ArrayList();
		if (!"".equals(p.getProduct_name()) && p.getProduct_name() != null) {
			sql = sql + "  and product_name like ?";
			list.add("%" + p.getProduct_name() + "%");

		}
		System.out.print(sql);
		if (p.getProviderID() != 0) {
			sql = sql + "  and providerID=?";
			list.add(p.getProviderID());
		}
		if (p.getCategoryID() != 0) {

			sql = sql + " and categoryID=?";
			list.add(p.getCategoryID());
		}
		sql = sql + " limit ?,?";

		list.add((page.getCurrentPage() - 1) * page.getPageSize());
		list.add(page.getPageSize());
		System.out.println(sql + "-------");
		ArrayList<Products> list2 = new ArrayList<Products>();

		ResultSet rs = super.selectDB(conn, sql, list.toArray());
		while (rs.next()) {
			Products products = new Products();
			products.setProductID(rs.getInt("productID"));
			products.setProduct_name(rs.getString("product_name"));
			products.setIncome_price(rs.getDouble("income_price"));
			int providerID = rs.getInt("providerID");
			ProviderServiceImpl service = new ProviderServiceImpl();
			Providers provider = service.selectByID(providerID);
			products.setProvider(provider);
			products.setQuantity(rs.getInt("quantity"));
			products.setSales_price(rs.getDouble("sales_price"));
			int categoryID = rs.getInt("categoryID");
			CategoryServiceImpl service1 = new CategoryServiceImpl();
			Categorys category = service1.selectByID(categoryID);
			products.setCategory(category);
			String income_time = rs.getString("income_time");
			products.setIncome_time(income_time);
			String filename=rs.getString("filename");
			products.setFilename(filename);
			list2.add(products);

		}
		int totalRecord = getTotalRecord(conn, p);
		page.setList(list2);
		page.setTotal(totalRecord);

		return page;
	}

	@Override
	public List<Products> selectAll1(Connection conn, String product_name, int length, int start) throws SQLException {
		String sql = "select * from products where 1=1";
		Products p = new Products();
		ArrayList list = new ArrayList();

		if (!"".equals(product_name) && product_name != null) {
			sql = sql + "  and product_name like ?";
			list.add("%" + product_name + "%");

		}
		if (p.getProviderID() != 0) {
			sql = sql + "  and providerID=?";
			list.add(p.getProviderID());
		}
		if (p.getCategoryID() != 0) {

			sql = sql + " and categoryID=?";
			list.add(p.getCategoryID());
		}
		sql = sql + " limit ?,?";

		list.add(start);
		list.add(length);
		System.out.println(sql + "-------");
		ArrayList<Products> list2 = new ArrayList<Products>();

		ResultSet rs = super.selectDB(conn, sql, list.toArray());
		while (rs.next()) {
			Products products = new Products();
			products.setProductID(rs.getInt("productID"));
			products.setProduct_name(rs.getString("product_name"));
			products.setIncome_price(rs.getDouble("income_price"));
			int providerID = rs.getInt("providerID");
			ProviderServiceImpl service = new ProviderServiceImpl();
			Providers provider = service.selectByID(providerID);
			products.setProvider(provider);
			products.setQuantity(rs.getInt("quantity"));
			products.setSales_price(rs.getDouble("sales_price"));
			int categoryID = rs.getInt("categoryID");
			CategoryServiceImpl service1 = new CategoryServiceImpl();
			Categorys category = service1.selectByID(categoryID);
			products.setCategory(category);
			String income_time = rs.getString("income_time");
			products.setIncome_time(income_time);
			String filename=rs.getString("filename");
			products.setFilename(filename);
			list2.add(products);

		}

		return list;
	}

	public int getTotalRecord(Connection conn, Products p) {
		int num = 0;
		ResultSet rs = null;
		String sql = "select count(productID)from products where 1=1";

		ArrayList list2 = new ArrayList();
		if (!"".equals(p.getProduct_name()) && p.getProduct_name() != null) {
			sql = sql + "  and product_name like ?";
			list2.add("%" + p.getProduct_name() + "%");

		}
		if (p.getProviderID() != 0) {
			sql = sql + "  and providerID=?";
			list2.add(p.getProviderID());
		}
		if (p.getCategoryID() != 0) {

			sql = sql + " and categoryID=?";
			list2.add(p.getCategoryID());
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
	public ResultSet searchProductByCategoryId(Connection conn, int categoryID) throws SQLException {
		String sql = "select * from products where categoryID=?";
		Object[] fields = { categoryID };
		ResultSet set = null;
		set = super.selectDB(conn, sql, fields);
		return set;
	}
}
