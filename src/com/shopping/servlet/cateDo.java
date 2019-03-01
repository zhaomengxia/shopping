package com.shopping.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shopping.dao.Page;
import com.shopping.entity.Categorys;
import com.shopping.entity.Products;
import com.shopping.entity.Providers;
import com.shopping.serviceimpl.CategoryServiceImpl;
import com.shopping.serviceimpl.ProductServiceImpl;
import com.shopping.serviceimpl.ProviderServiceImpl;

import net.sf.json.JSONArray;

public class cateDo extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// �������봦��post����
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();

		String action = request.getParameter("p");
		if ("doma1".equals(action)) {
			domana1(request, response);

		} else if ("doma".equals(action)) {
			domana(request, response);

		}

		else if ("doadd".equals(action)) {
			doadd(request, response);
		} else if ("del".equals(action)) {
			dodel(request, response);
		} else if ("doupss".equals(action)) {

			doupss(request, response);
		} else if ("doups".equals(action)) {

			doups(request, response);
		} else if ("checkname".equals(action)) {

			checkname(request, response);
		} else if ("search".equals(action)) {

			search(request, response);
		} else if ("getProduct".equals(action)) {
			getProduct(request, response);
		} else if ("search1".equals(action)) {

			search1(request, response);
		} else if ("searchProduct".equals(action)) {
			searchProduct(request, response);
		}else if("exportOrder".equals(action)){
			exportOrder(request, response);
		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);

	}

	public void doma1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

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

	public void exportOrder(HttpServletRequest request,HttpServletResponse response){	
		ProductServiceImpl service = new ProductServiceImpl();
		service.exportOrder(response);
		
	}
	public void search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int currentPage = Integer.parseInt(request.getParameter("currentPage"));
		System.out.print(currentPage);
		int PageSize = Integer.parseInt(request.getParameter("PageSize"));
		System.out.print(PageSize);
		String category = request.getParameter("category");
		int categoryID = Integer.parseInt(category);
		System.out.print(categoryID);
		String category_name = request.getParameter("category_name");
		System.out.print(category_name);
		CategoryServiceImpl service = new CategoryServiceImpl();
		Categorys cates = new Categorys();
		// �Ȱ���������������Ϊ��������
		cates.setCategory_name(category_name);
		cates.setCategoryID(categoryID);

		ArrayList<Categorys> cate = service.selectAllCate();
		System.out.print(cate);
		Page<Categorys> proPage = service.selectAllCate(cates, currentPage, PageSize);

		System.out.print("-----------------");
		request.setAttribute("cates", cates);
		request.setAttribute("categorys", cate);
		request.setAttribute("proPage", proPage);

		request.getRequestDispatcher("/Admin/categorys/productmanager.jsp").forward(request, response);
	}

	public void checkname(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String name = request.getParameter("name");
		System.out.print(name);
		CategoryServiceImpl service = new CategoryServiceImpl();
		Categorys category = service.selectByname(name);
		System.out.print(category);
		PrintWriter out = response.getWriter();
		if (category.getCategory_name() == null) {
			out.print("false");
			System.out.print("true");
		} else {
			out.print("true");
			System.out.print("false");
		}
		out.flush();
		out.close();

	}

	public void doadd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		
		
		String name = request.getParameter("category_name");
		String desc = request.getParameter("category_desc");
		
		CategoryServiceImpl service = new CategoryServiceImpl();
		int result = service.addcate(name, desc);
		if (result > 0) {
			response.sendRedirect(request.getContextPath() + "/Admin/categorys/cateDo?p=doma");
		} else if (result == 0) {
			out.print("<script>alert('���ʧ��');hitory.go(-1);</script>");

		} else {
			out.print("<script>alert('���ʧ��');hitory.go(-1);</script>");
		}

	}

	public void domana1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CategoryServiceImpl service = new CategoryServiceImpl();
		if (request.getParameter("category_name") == null && request.getParameter("category") == null
				&& request.getParameter("products") == null) {
			domana(request, response);
		}
		if (request.getParameter("category_name") != null) {

			search(request, response);
		} else if (request.getParameter("category") != null && request.getParameter("products") == null
				&& request.getParameter("category_name") == null) {
			search1(request, response);
		}

		if (request.getParameter("currentPage") != null && request.getParameter("PageSize") != null) {
			int currentPage1 = Integer.parseInt(request.getParameter("currentPage"));

			int PageSize1 = Integer.parseInt(request.getParameter("PageSize"));

			Page<Categorys> proPage = service.selectAllCate(currentPage1, PageSize1);
			request.setAttribute("proPage", proPage);
		} else {

			Page<Categorys> proPage = service.selectAllCate(1, 10);
			request.setAttribute("proPage", proPage);
		}
		CategoryServiceImpl cate = new CategoryServiceImpl();
		ArrayList<Categorys> categorys = cate.selectAllCate();
		System.out.print(categorys);
		request.setAttribute("categorys", categorys);

		request.getRequestDispatcher("/Admin/categorys/categorymanager.jsp").forward(request, response);

	}

	public void domana(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CategoryServiceImpl service = new CategoryServiceImpl();
		/*
		 * if(request.getParameter(name))
		 * if(request.getParameter("category_name")!=null){
		 * 
		 * search(request, response); }
		 */

		if (request.getParameter("currentPage") != null && request.getParameter("PageSize") != null) {
			int currentPage1 = Integer.parseInt(request.getParameter("currentPage"));

			int PageSize1 = Integer.parseInt(request.getParameter("PageSize"));

			Page<Categorys> proPage = service.selectAllCate(currentPage1, PageSize1);
			request.setAttribute("proPage", proPage);
		} else {

			Page<Categorys> proPage = service.selectAllCate(1, 10);
			request.setAttribute("proPage", proPage);
		}
		//�������Ŀ¼��Ϣ
		CategoryServiceImpl cate = new CategoryServiceImpl();
		ArrayList<Categorys> categorys = cate.selectAllCate();
		System.out.print(categorys);
		request.setAttribute("categorys", categorys);

		request.getRequestDispatcher("/Admin/categorys/categorymanager.jsp").forward(request, response);

	}

	public void dodel(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		//���categorymanager.jspɾ��ҳ�棬ɾ�����Ӵ���id=?��?
		int categoryID = Integer.parseInt(request.getParameter("idd"));
		out.println(categoryID);
		CategoryServiceImpl service = new CategoryServiceImpl();
		//����service�㣬����idɾ������
		int result = service.deleteCategory(categoryID);
		if (result == 1) {
			response.sendRedirect(request.getContextPath() + "/Admin/categorys/cateDo?p=doma");

		} else if (result == 0) {
			out.print("<script>alert('���в�Ʒ���ڣ�ɾ��ʧ��');history.go(-1);</script>");
		}
	}

	public void doupss(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		//��ã������ֵ
		int id = Integer.parseInt(request.getParameter("idd"));

		CategoryServiceImpl service = new CategoryServiceImpl();
		//����service�㣬����id���Ҷ���
		Categorys cate = service.selectByID(id);
		request.setAttribute("cate", cate);
		request.getRequestDispatcher("/Admin/categorys/update_cate.jsp").forward(request, response);
	}

	public void doups(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		// ��ȡ�ʺź��洫�ݹ�����Ҫ�޸ĵĲ�Ʒ���id
		int id = Integer.parseInt(request.getParameter("categoryID"));

		String name = request.getParameter("category_name");

		String desc = request.getParameter("category_desc");
		Categorys cate = new Categorys();
		// ����ҵ��㣬����id�õ�Ҫ�޸ĵĲ�Ʒ������
		CategoryServiceImpl service = new CategoryServiceImpl();
		int result = service.updateCategory(id, name, desc);
		if (result > 0) {
			response.sendRedirect(request.getContextPath() + "/Admin/categorys/cateDo?p=doma");
		} else if (result == 0) {
			out.print("<script>alert('����������޸�ʧ��');hitory.go(-1);</script>");

		} else {
			out.print("<script>alert('�޸�ʧ��');hitory.go(-1);</script>");
		}

	}

	// ����Ŀ¼id�õ���Ʒ--------
	public void getProduct(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("cid"));
		System.out.print(id);
		ProductServiceImpl service = new ProductServiceImpl();
		List<Products> list = service.searchProductByCategoryId(id);
		System.out.println(list + "bnnnnnnnnnnnnnnnnnnnnnn---------------");
		// product.setCategoryID(id);
		// ��java����ת��JSON���󣬣�ʹ��JSONҪ�ȵ���Ӧ�İ���
		JSONArray arr = JSONArray.fromObject(list);
		System.out.print(arr + "----------------------------------");
		// ������println(),��Ϊ�����ո�
		response.getWriter().print(arr);
	}

	public void search1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int currentPage = Integer.parseInt(request.getParameter("currentPage"));
		System.out.print(currentPage);
		int PageSize = Integer.parseInt(request.getParameter("PageSize"));
		System.out.print(PageSize);
		String category = request.getParameter("category");
		int categoryID = Integer.parseInt(category);
		System.out.print(categoryID);
		String category_name = request.getParameter("category_name");
		System.out.print(category_name);
		CategoryServiceImpl service = new CategoryServiceImpl();
		Categorys cates = new Categorys();
		// �Ȱ���������������Ϊ��������
		cates.setCategory_name(category_name);
		cates.setCategoryID(categoryID);

		ArrayList<Categorys> cate = service.selectAllCate();
		System.out.print(cate);
		//Page<Categorys> proPage = service.selectAllCate(cates, currentPage, PageSize);

		System.out.print("-----------------");
		request.setAttribute("cates", cates);
		request.setAttribute("categorys", cate);
		String product_name = null;
		product_name = request.getParameter("product_name");
		System.out.println("product_name");

		// �Ȱ��������������ɲ�Ʒ��������
		Products p = new Products();
		p.setCategory(cates);
		p.setProduct_name(product_name);
		p.setCategoryID(categoryID);
		System.out.print("asdfghsdfgh");

		ProductServiceImpl service1 = new ProductServiceImpl();
		Page<Products> page = service1.selectAllCate(p, currentPage, PageSize);
		// �õ���Ʒ�Ĺ�Ӧ�̺Ͳ�Ʒ��Ϣ
		request.setAttribute("proPage", page);
		request.setAttribute("p", p);

		request.getRequestDispatcher("/Admin/categorys/productmanager.jsp").forward(request, response);

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
		System.out.println(currentPage);
		PageSize = Integer.parseInt(request.getParameter("PageSize"));
		System.out.println(PageSize);
		product_name = request.getParameter("product_name");
		System.out.println("product_name");
		providerID = Integer.parseInt(request.getParameter("provider"));
		categoryID = Integer.parseInt(request.getParameter("category"));

		// �Ȱ��������������ɲ�Ʒ��������
		Products p = new Products();
		p.setProduct_name(product_name);
		p.setProviderID(providerID);
		p.setCategoryID(categoryID);
		System.out.print("asdfghsdfgh");

		ProductServiceImpl service = new ProductServiceImpl();
		Page<Products> page = service.selectAllCate(p, currentPage, PageSize);
		// �õ���Ʒ�Ĺ�Ӧ�̺Ͳ�Ʒ��Ϣ
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
		request.getRequestDispatcher("/Admin/categorys/productmanager.jsp").forward(request, response);

	}

}
