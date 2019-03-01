package com.shopping.servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.shopping.dao.Page;
import com.shopping.entity.Categorys;
import com.shopping.entity.DataGrid;
import com.shopping.entity.DataTables;
import com.shopping.entity.Products;
import com.shopping.entity.Providers;
import com.shopping.serviceimpl.CategoryServiceImpl;
import com.shopping.serviceimpl.ProductServiceImpl;
import com.shopping.serviceimpl.ProviderServiceImpl;

import net.sf.json.JSONArray;

public class proServlet extends HttpServlet {

	// 请求响应执行
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		String p = request.getParameter("p");
		if ("doadd1".equals(p)) {
				doadd1(request, response);
		} else if ("doadd2".equals(p)) {
			doadd2(request, response);
		} else if ("dodel".equals(p)) {
			dodel(request, response);
		} else if ("dodelmany".equals(p)) {
			dodelmany(request, response);
		} else if ("doma".equals(p)) {
			doma(request, response);
		} else if ("doma1".equals(p)) {
			doma1(request, response);
		} else if ("doup1".equals(p)) {
			doup1(request, response);
		} else if ("doup2".equals(p)) {
			doup2(request, response);
		} else if ("searchProduct".equals(p)) {
			searchProduct(request, response);
		} else if ("doselect".equals(p)) {
			doselect(request, response);
		} else if ("search".equals(p)) {
			search(request, response);
		} else if ("searchProduct1".equals(p)) {
			searchProduct1(request, response);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	public void check(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	public void doadd1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

		// 使用Apache文件上传组件步骤
				DiskFileItemFactory factory = new DiskFileItemFactory();

				// 得到了解析器
				ServletFileUpload servletFileUpload = new ServletFileUpload(factory);
				// 判断上传是文件还是表单
				boolean result = servletFileUpload.isMultipartContent(request);
				System.out.print(result);
				Date date = new Date();
				String file_name = null;
				String file_desc = null;
				String unit=null;
				int providerid = 3;
				int categoryid =2;
				Double incomePrice =0.0;
				int count =0;
				Double salesPrice=0.0;
				Double salecount =0.0;
				String productName =null;
				String incomeTime =null;
				String source =null;
				String autoName = new SimpleDateFormat("yyyyMMddHHmmss").format(date);
				System.out.print(autoName);
				String username = String.valueOf(request.getSession().getAttribute("loginuser"));

				if (result) {
					try {
						List<FileItem> fileitems = null;
						fileitems = servletFileUpload.parseRequest(request);
						System.out.println(autoName + "----------------------------------------------" + username);
						for (FileItem fileitem : fileitems) {
							// 相当于表单元素的input里的name属性
							if (fileitem.isFormField()) {
								String fieldname = fileitem.getFieldName();
								String value = fileitem.getString("utf-8");
								
								// 解决代码乱码的问题
								if ("image".equals(fieldname)) {
									file_name = value;
								} else if ("productDesc".equals(fieldname)) {
									file_desc = value;
								}else if ("product_name".equals(fieldname)) {
									productName = value;
								}else if ("income_time".equals(fieldname)) {
									incomeTime = value;
								}else if ("providerID".equals(fieldname)) {
									providerid = Integer.parseInt(value);
								}else if ("categoryID".equals(fieldname)) {
									categoryid = Integer.parseInt(value);
								}else if ("income_price".equals(fieldname)) {
									incomePrice = Double.valueOf(value);
								}else if ("sales_price".equals(fieldname)) {
									salesPrice = Double.valueOf(value);
								}else if ("quantity".equals(fieldname)) {
									count = Integer.parseInt(value);
								}
								
							} else {
								InputStream inputStream = fileitem.getInputStream();
								if (inputStream != null && inputStream.available() > 0) {
									// 得到文件名
									String filename = fileitem.getName();
									int index = filename.lastIndexOf(".");
									String ext = filename.substring(index);
									System.out.print(filename + "   " + ext);
									autoName += ext;

									String path = request.getSession().getServletContext().getRealPath("images");
									System.out.println(path + "89999999999999999999999");
									File file = new File(path, autoName);
									System.out.println(file + "3456789-------------");
									// 得到一个输出流，输出到服务器的磁盘
									FileOutputStream outputStream = new FileOutputStream(file);
									// 一次上传1kb
									byte[] datas = new byte[1024];
									int len = 0;
									while ((len = inputStream.read(datas)) > 0) {
										// 读进多少字节，就写出多少字节
										outputStream.write(datas, 0, len);

									}

									outputStream.flush();
									outputStream.close();

								}
							}
						}

					} catch (FileUploadException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				int mark=0;
				if(null!=request.getParameter("mark")&&!"".equals(request.getParameter("mark"))){
				mark=Integer.parseInt(request.getParameter("mark"));
				}
				
		Products product1 = new Products(productName, incomePrice, providerid, count, salesPrice, categoryid, incomeTime,autoName);

		ProductServiceImpl service = new ProductServiceImpl();
		service.addProduct(product1);
		response.sendRedirect(request.getContextPath() + "/Admin/products/proServlet?p=doma");

	}

	public void doadd2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ProviderServiceImpl prov = new ProviderServiceImpl();

		ArrayList<Providers> provid = prov.selectAllProviders();

		CategoryServiceImpl cate = new CategoryServiceImpl();

		ArrayList<Categorys> categorys = cate.selectAllCate();
		request.setAttribute("provid", provid);
		request.setAttribute("categorys", categorys);
		request.getRequestDispatcher("/Admin/products/productadd.jsp").forward(request, response);

	}

	public void doselect(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ProviderServiceImpl prov = new ProviderServiceImpl();

		ArrayList<Providers> products = prov.selectAllProviders();

		CategoryServiceImpl cate = new CategoryServiceImpl();

		ArrayList<Categorys> categorys = cate.selectAllCate();
		request.setAttribute("products", products);
		request.setAttribute("categorys", categorys);
		request.getRequestDispatcher("/Admin/products/categoryseach.jsp").forward(request, response);

	}

	public void dodel(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");

		int productID = Integer.parseInt(request.getParameter("id"));

		ProductServiceImpl service = new ProductServiceImpl();
		int result = service.deleteByproductID(productID);
		if (result > 0) {
			response.sendRedirect(request.getContextPath() + "/Admin/products/MyJsp.jsp");
		}

	}

	public void dodelmany(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		// int productID=Integer.parseInt(request.getParameter("id"));
		String[] ids = request.getParameterValues("nn");
		ProductServiceImpl service = new ProductServiceImpl();
		Integer[] Ids = new Integer[ids.length];
		for (int i = 0; i < ids.length; i++) {
			Ids[i] = Integer.parseInt(ids[i]);
		}
		int result = service.deletemanyByID(Ids);
		System.out.println(result);
		if (result > 0) {
			response.sendRedirect(request.getContextPath() + "/Admin/products/proServlet?p=doma");
		} else {
			out.print(
					"<script>alert('删除失败,有订单信息存在');location.href='proServlet?p=doma&currentPage=1&PageSize=10';</script>");
		}
		/*
		 * 单条循环删除 if(ids!=null){ for(int i=0;i<ids.length;i++){
		 *  int productID=Integer.parseInt(ids[i]);
		 * result=service.deleteByproductID(productID); } }else{
		 * out.print("<script>alert('删除失败');history:go(-1);</script>"); }
		 * if(result>0){ response.sendRedirect(request.getContextPath()+
		 * "/Admin/products/productdomanager.jsp"); }
		 */

	}

	public void doma3(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		ProductServiceImpl service = new ProductServiceImpl();

		if (request.getParameter("product_name") == null && request.getParameter("provider") == null
				&& request.getParameter("category") == null) {
			doma1(request, response);
		}

		if (request.getParameter("product_name") != null && request.getParameter("provider") != null
				&& request.getParameter("category") != null) {
			/*
			 * int providerID=0; int categoryID=0; String product_name=null;
			 */
			searchProduct(request, response);

		}
		if (!"".equals(request.getParameter("product_name")) && !"".equals(request.getParameter("provider"))
				&& !"".equals(request.getParameter("category"))) {
			if (request.getParameter("currentPage") != null && request.getParameter("PageSize") != null) {
				int currentPage = Integer.parseInt(request.getParameter("currentPage"));
				System.out.println(currentPage);
				int PageSize = Integer.parseInt(request.getParameter("PageSize"));
				System.out.println(PageSize);
				Page<Products> proPage = service.selectAllCate(currentPage, PageSize);
				request.setAttribute("proPage", proPage);
			} else {
				Page<Products> proPage = service.selectAllCate(1, 10);
				request.setAttribute("proPage", proPage);
			}
			ProviderServiceImpl prov = new ProviderServiceImpl();

			ArrayList<Providers> list1 = prov.selectAllProviders();

			CategoryServiceImpl cate = new CategoryServiceImpl();

			ArrayList<Categorys> list2 = cate.selectAllCate();
			request.setAttribute("list1", list1);
			request.setAttribute("list2", list2);
			request.getRequestDispatcher("/Admin/products/productmanager.jsp").forward(request, response);
		}
	}
	public void doma1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductServiceImpl ps=new ProductServiceImpl();
		List<Products> list=ps.selectAllProduct();
		PrintWriter out=response.getWriter();
		JSONArray jsonArr=JSONArray.fromObject(list);
		out.print(jsonArr);
		int currentPage=1;
		String easyPage=request.getParameter("page");
		if(easyPage!=null){
			currentPage=Integer.parseInt(easyPage);
		}
		int PageSize=5;
		String easyRows=request.getParameter("rows");
		if(easyRows!=null){
			PageSize=Integer.parseInt(easyRows);
		}
		Page<Products> page=ps.selectAllCate(currentPage, PageSize);
		
		
		DataGrid gd=new DataGrid();
		
	}

	public void doma(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		ProductServiceImpl service = new ProductServiceImpl();
		if (request.getParameter("currentPage") != null && request.getParameter("PageSize") != null) {
			int currentPage = Integer.parseInt(request.getParameter("currentPage"));
			System.out.println(currentPage);
			int PageSize = Integer.parseInt(request.getParameter("PageSize"));
			System.out.println(PageSize);
			Page<Products> proPage = service.selectAllCate(currentPage, PageSize);
			request.setAttribute("proPage", proPage);
		} else {
			Page<Products> proPage = service.selectAllCate(1, 10);
			request.setAttribute("proPage", proPage);
		}

		ProviderServiceImpl prov = new ProviderServiceImpl();

		ArrayList<Providers> list1 = prov.selectAllProviders();

		CategoryServiceImpl cate = new CategoryServiceImpl();

		ArrayList<Categorys> list2 = cate.selectAllCate();
		request.setAttribute("list1", list1);
		request.setAttribute("list2", list2);

		request.getRequestDispatcher("/Admin/products/productmanager2.jsp").forward(request, response);

	}

	public void doup1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		int productID = Integer.parseInt(request.getParameter("productID"));
		String product_name = request.getParameter("product_name");
		
		//解决get 乱码
		byte[] buf = product_name.getBytes("iso-8859-1");
		product_name = new String(buf, "utf-8");
		
		double income_price = Double.valueOf(request.getParameter("income_price"));
		int providerID = Integer.parseInt(request.getParameter("provider"));
		
		ProviderServiceImpl provider = new ProviderServiceImpl();
		Providers providers = new Providers();
		Products product = new Products();
		providers = provider.selectByID(providerID);

		product.setProvider(providers);
		
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		double sales_price = Double.valueOf(request.getParameter("sales_price"));
		int categoryID = Integer.parseInt(request.getParameter("category"));
		
		Categorys cate = new Categorys();
		CategoryServiceImpl category = new CategoryServiceImpl();
		cate = category.selectByID(categoryID);
		product.setCategory(cate);
		
		String income_time = request.getParameter("income_time");

		// Products product1=new
		// Products(productID,product_name,income_price,providers,quantity,sales_price,cate,time);
		ProductServiceImpl service = new ProductServiceImpl();
		int result = service.updateProduct(productID, product_name, income_price, providers, quantity, sales_price,
				cate, income_time);
		if (result > 0) {
			response.sendRedirect(request.getContextPath() + "/Admin/products/productmanager.jsp");
		} else {
			out.print("<script>alert('修改失败');hitory.go(-1);</script>");
		}

	}

	public void doup2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 获取？后面传递过来要修改的产品类别id,在productmanager.jsp页面里写有修改链接的地方
		int id = Integer.parseInt(request.getParameter("id"));
		// 调用业务层，根据id得到要修改的产品对象
		ProductServiceImpl service = new ProductServiceImpl();
		Products product = service.selectByID(id);
		// 得到所有供应商的信息
		ProviderServiceImpl service1 = new ProviderServiceImpl();
		ArrayList<Providers> providers = service1.selectAllProviders();
		// 得到所有目录的信息
		CategoryServiceImpl category = new CategoryServiceImpl();
		ArrayList<Categorys> cates = category.selectAllCate();

		request.setAttribute("providers", providers);
		// 产品类别的原有信息显示在输入框中
		request.setAttribute("product", product);
		request.setAttribute("cates", cates);
		request.getRequestDispatcher("/Admin/products/productupdate_cate.jsp").forward(request, response);

	}

	public void searchProduct(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.print("zgdxfcgvhbnkm,.tdfgh");
		int providerID = 0;
		int categoryID = 0;
		int currentPage = 0;
		int PageSize = 0;
		String product_name = null;

		currentPage = Integer.parseInt(request.getParameter("currentPage"));
		
		PageSize = Integer.parseInt(request.getParameter("PageSize"));
		
		product_name = request.getParameter("product_name");
		
		providerID = Integer.parseInt(request.getParameter("provider"));
		categoryID = Integer.parseInt(request.getParameter("category"));

		// 先把三个条件，做成产品搜索对象
		Products p = new Products();
		p.setProduct_name(product_name);
		p.setProviderID(providerID);
		p.setCategoryID(categoryID);
		System.out.print("asdfghsdfgh");

		ProductServiceImpl service = new ProductServiceImpl();
		Page<Products> page = service.selectAllCate(p, currentPage, PageSize);
		// 得到产品的供应商和产品信息
		ProviderServiceImpl ps = new ProviderServiceImpl();
		ArrayList<Providers> list1 = ps.selectAllProviders();
		System.out.println(list1);

		CategoryServiceImpl cs = new CategoryServiceImpl();
		ArrayList<Categorys> list2 = cs.selectAllCate();
	
		request.setAttribute("proPage", page);
		request.setAttribute("p", p);
		request.setAttribute("list1", list1);
		request.setAttribute("list2", list2);
		request.getRequestDispatcher("/Admin/products/productmanager.jsp").forward(request, response);

	}

	public void searchProduct1(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.print("zgdxfcgvhbnkm,.tdfgh");
		int providerID = 0;
		int categoryID = 0;
		int currentPage = 0;
		int PageSize = 0;
		String product_name = null;

		currentPage = Integer.parseInt(request.getParameter("currentPage"));
		
		PageSize = Integer.parseInt(request.getParameter("PageSize"));
		
		product_name = request.getParameter("product_name");
		
		providerID = Integer.parseInt(request.getParameter("provider"));
		categoryID = Integer.parseInt(request.getParameter("category"));

		// 先把三个条件，做成产品搜索对象
		Products p = new Products();
		p.setProduct_name(product_name);
		p.setProviderID(providerID);
		p.setCategoryID(categoryID);
		System.out.print("asdfghsdfgh");

		ProductServiceImpl service = new ProductServiceImpl();
		Page<Products> page = service.selectAllCate(p, currentPage, PageSize);
		// 得到产品的供应商和产品信息
		ProviderServiceImpl ps = new ProviderServiceImpl();
		ArrayList<Providers> list1 = ps.selectAllProviders();
		System.out.println(list1);

		CategoryServiceImpl cs = new CategoryServiceImpl();
		ArrayList<Categorys> list2 = cs.selectAllCate();
		System.out.print(list2);

		request.setAttribute("proPage", page);
		request.setAttribute("p", p);
		request.setAttribute("list1", list1);
		request.setAttribute("list2", list2);
		request.getRequestDispatcher("/Admin/products/products.jsp").forward(request, response);

	}

	public void search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int providerID = 0;
		int categoryID = 0;
		int currentPage = 1;
		int PageSize = 2;
		currentPage = Integer.parseInt(request.getParameter("start"));
		System.out.println(currentPage);

		PageSize = Integer.parseInt(request.getParameter("length"));

		String product_name = request.getParameter("product_name");

		if (product_name == null) {
			product_name = "";
		}
		
		providerID = Integer.parseInt(request.getParameter("provider"));
		categoryID = Integer.parseInt(request.getParameter("category"));

		// 先把三个条件，做成产品搜索对象
		Products p = new Products();
		p.setProduct_name(product_name);
		p.setProviderID(providerID);
		p.setCategoryID(categoryID);
		System.out.print("asdfghsdfgh");

		ProductServiceImpl service = new ProductServiceImpl();
		List<Products> page = service.selectAllCate1(product_name, currentPage, PageSize);

		int count = service.getTotalRecord(p);
	
		DataTables tables = new DataTables();
		tables.setRecordsFiltered(count);
		tables.setRecordsTotal(count);
		tables.setData(page);
		JSONArray arr = JSONArray.fromObject(tables);
	
		// 不能用println(),因为会多出空格
		response.getWriter().print(arr);
	}

}
