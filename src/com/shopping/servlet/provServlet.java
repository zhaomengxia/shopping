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

public class provServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String p=request.getParameter("p");
		if("doadd".equals(p)){
			doadd(request, response);
		}else if("dodel".equals(p)){
			dodel(request, response);
		}else if("doma".equals(p)){
			doma(request, response);
		}else if("doup1".equals(p)){
			doup1(request, response);
		}else if("doup2".equals(p)){
			doup2(request, response);
		}else if("search1".equals(p)){
			search1(request, response);
		}else if("search".equals(p)){
			search(request, response);
		}else if("searchProduct".equals(p)){
			searchProduct(request, response);
		}else if("getProduct".equals(p)){
			getProduct(request, response);
		}
		
	}
	//���Ǵ�Ŀ¼servlet���︴�ƹ����ģ���Ϊ��ģ��Ŀ¼������Ŀ¼id���Ҳ�Ʒ��
	public void search1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int currentPage=Integer.parseInt(request.getParameter("currentPage"));
		System.out.print(currentPage);
		int PageSize=Integer.parseInt(request.getParameter("PageSize"));
		System.out.print(PageSize);
		String category=request.getParameter("category");
		int categoryID=Integer.parseInt(category);
		System.out.print(categoryID);
		String category_name=request.getParameter("category_name");
		System.out.print(category_name);
		CategoryServiceImpl service=new CategoryServiceImpl();
		Categorys cates=new Categorys();
		//�Ȱ���������������Ϊ��������
		cates.setCategory_name(category_name);
		cates.setCategoryID(categoryID);
		
		ArrayList<Categorys> cate=service.selectAllCate();
		System.out.print(cate);
		Page<Categorys> proPage=service.selectAllCate(cates, currentPage, PageSize);
		
		System.out.print("-----------------");
		request.setAttribute("cates", cates);
		request.setAttribute("categorys", cate);
		String product_name=null;
		product_name=request.getParameter("product_name");
		System.out.println("product_name");
		

		//�Ȱ��������������ɲ�Ʒ��������
		Products p=new Products();
		p.setCategory(cates);
		p.setProduct_name(product_name);
		p.setCategoryID(categoryID);
		System.out.print("asdfghsdfgh");
		
		ProductServiceImpl service1 =new ProductServiceImpl();
		Page<Products> page=service1.selectAllCate(p, currentPage, PageSize);
		//�õ���Ʒ�Ĺ�Ӧ�̺Ͳ�Ʒ��Ϣ
		request.setAttribute("proPage", page);
		request.setAttribute("p", p);
		
		request.getRequestDispatcher("/Admin/categorys/productmanager.jsp").forward(request, response);
			
		}



	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	doGet(request, response);
	}
	
	//���ݹ�Ӧ��id�õ���Ʒ--------
	public void getProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//�����cid��/Admin/categorys/productmanager.jsp��<script> ��д��json��xmlHttpRequest.open('get',"${pageContext.request.contextPath}/Admin/categorys/cateDo?p=getProduct&cid="+pname,true);</script>������Ժ���д�ù�Ӧ�̵�id���Ҳ�Ʒ�Ļ�����Ҫģ��Ŀ¼ȥ����serarch,serach1Ҳ�Ǵ�Ŀ¼servlet���︴�ƹ����ģ�������������й�ϵ
		int id=Integer.parseInt(request.getParameter("cid"));
		System.out.print(id);
		ProductServiceImpl service=new ProductServiceImpl();
		//�����Ǵ�Ŀ¼servlet���︴�ƹ����ģ��Ժ����Ҫ�����ݹ�Ӧ��ID������Ʒ�Ĺ��ܵĻ�����Ҫ�ڲ�Ʒ��dao,daoImpl,sevice,serviceImpl����д���ݹ�Ӧ��id���Ҳ�Ʒ�ķ������������һ��
		List<Products> list=service.searchProductByCategoryId(id);
		System.out.println(list+"bnnnnnnnnnnnnnnnnnnnnnn---------------");
		//product.setCategoryID(id);
		//��java����ת��JSON���󣬣�ʹ��JSONҪ�ȵ���Ӧ�İ���
		JSONArray arr=JSONArray.fromObject(list);
		System.out.print(arr+"----------------------------------");
		//������println(),��Ϊ�����ո�
		response.getWriter().print(arr);
	}

	public void searchProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		ProviderServiceImpl service=new ProviderServiceImpl();
		Providers p=new Providers();
	
		int providerID=0;
		int currentPage=0;
		int PageSize=0;
		
		String provider_name=request.getParameter("provider_name");
		currentPage=Integer.parseInt(request.getParameter("currentPage"));
		PageSize=Integer.parseInt(request.getParameter("PageSize"));
		providerID=Integer.parseInt(request.getParameter("provider"));	
	
		//�Ȱ����������ɲ�Ʒ��������
		p.setProviderID(providerID);
		p.setProvider_name(provider_name);
		
		//����providerID,provider_name���ң�����ҳ��
		Page<Providers> page=service.selectAllCate(p, currentPage, PageSize);
	
		//�õ���Ʒ�Ĺ�Ӧ����Ϣ
		ProviderServiceImpl ps=new ProviderServiceImpl();
		ArrayList<Providers> list1=ps.selectAllProviders();
	
		
		//��������Ϣ����jsp  /Admin/providers/providermanager.jspҳ��
		request.setAttribute("provPage", page);
		request.setAttribute("p", p);
		request.setAttribute("list1", list1);
		
		request.getRequestDispatcher("/Admin/providers/providermanager.jsp").forward(request, response);
	
	}
	//���Ǵ�Ŀ¼servlet���︴�ƹ����ģ���Ϊ��ģ��Ŀ¼������Ŀ¼id���Ҳ�Ʒ��
	public void search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int currentPage=Integer.parseInt(request.getParameter("currentPage"));
		System.out.print(currentPage);
		int PageSize=Integer.parseInt(request.getParameter("PageSize"));
		System.out.print(PageSize);
		String category=request.getParameter("category");
		int categoryID=Integer.parseInt(category);
		System.out.print(categoryID);
		String category_name=request.getParameter("category_name");
		System.out.print(category_name);
		CategoryServiceImpl service=new CategoryServiceImpl();
		Categorys cates=new Categorys();
		//�Ȱ���������������Ϊ��������
		cates.setCategory_name(category_name);
		cates.setCategoryID(categoryID);
		
		ArrayList<Categorys> cate=service.selectAllCate();
		System.out.print(cate);
		Page<Categorys> proPage=service.selectAllCate(cates, currentPage, PageSize);
		
		System.out.print("-----------------");
		request.setAttribute("cates", cates);
		request.setAttribute("categorys", cate);
		request.setAttribute("proPage", proPage);
		
		request.getRequestDispatcher("/Admin/categorys/productmanager.jsp").forward(request, response);
	}
	
	
	protected void doadd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		PrintWriter out=response.getWriter();
		
		String provider_name=request.getParameter("provider_name");
		request.setCharacterEncoding("utf-8");
		System.out.println(provider_name);
		String provider_add=request.getParameter("provider_add");
		request.setCharacterEncoding("utf-8");
		System.out.println(provider_add);
		String provider_tel=request.getParameter("provider_tel");
		request.setCharacterEncoding("utf-8");
		System.out.println(provider_tel);
		String account=request.getParameter("account");
		request.setCharacterEncoding("utf-8");
		String email=request.getParameter("email");
		if(request.getParameter("provider_name")!=null&&request.getParameter("provider_add")!=null&&request.getParameter("provider_tel")!=null&&request.getParameter("account")!=null&&request.getParameter("email")!=null){

		Providers providers=new Providers(provider_name,provider_add,provider_tel,account,email);
		ProviderServiceImpl service=new ProviderServiceImpl();
		int result=service.addPro(provider_name, provider_add, provider_tel, account, email);
		if(result>0){
			response.sendRedirect(request.getContextPath()+"/Admin/providers/provServlet?p=doma");
		}
		else if(result==0){
			out.print("<script>alert('���ʧ��');history.go(-1);</script>");
			
		}
		}else{
		out.print("<script>alert('����Ϊ��');history.go(-1);</script>");
		}
	}
	protected void dodel(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		PrintWriter out=response.getWriter();
		int providerID = Integer.parseInt(request.getParameter("id"));
		ProviderServiceImpl service = new ProviderServiceImpl();
		int s = service.deleteByID(providerID);
		if (s > 0) {
			response.sendRedirect(request.getContextPath()+"/Admin/providers/provServlet?p=doma");
		} else {
			out.print("<script>alert('���в�Ʒ���ڣ�ɾ��ʧ��');history.href='provServlet?p=doma&currentPage=1&PageSize=10';</script>");
		}
	}
	protected void doma(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProviderServiceImpl provider=new ProviderServiceImpl();
		if(request.getParameter("currentPage")!=null&&request.getParameter("PageSize")!=null){
		int currentPage =Integer.parseInt(request.getParameter("currentPage"));

		int PageSize=Integer.parseInt(request.getParameter("PageSize"));
		Page<Providers> provPage=provider.selectAllProvider(currentPage, PageSize);
		request.setAttribute("provPage", provPage);
		}
		else{
		Page<Providers> provPage=provider.selectAllProvider(1, 10);
		request.setAttribute("provPage", provPage);
		}
		
		ProviderServiceImpl ps=new ProviderServiceImpl();
		ArrayList<Providers> list1=ps.selectAllProviders();
		request.setAttribute("list1", list1);
		
		
		request.getRequestDispatcher("/Admin/providers/providermanager.jsp").forward(request, response);

		
	}
	protected void doup1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		PrintWriter out=response.getWriter();
		  ProviderServiceImpl service=new ProviderServiceImpl();
		  int providerID=Integer.parseInt(request.getParameter("providerID"));
		  request.setCharacterEncoding("utf-8");
		  String provider_name=request.getParameter("provider_name");
		  request.setCharacterEncoding("utf-8");
		  String provider_add=request.getParameter("provider_add");
		  request.setCharacterEncoding("utf-8");
		  String provider_tel=request.getParameter("provider_tel");
		  request.setCharacterEncoding("utf-8");
		  String account=request.getParameter("account");
		  request.setCharacterEncoding("utf-8");
		  String email=request.getParameter("email");
		 int d=service.updateProviders(providerID, provider_name, provider_add, provider_tel, account, email);
		 if(d==0){
		 response.sendRedirect(request.getContextPath()+"/Admin/providers/provServlet?p=doma");
		 }
		 else if(d<0){
		 out.print("<Script>alert('��Ӧ���������޸�ʧ��');history:go(-1);</script>");
		 
		 }
	}
	protected void doup2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  int providerID=Integer.parseInt(request.getParameter("id"));
		  Providers provider=new Providers();
		  ProviderServiceImpl providers=new ProviderServiceImpl();
		 Providers pro= providers.selectByID(providerID);
		 request.setAttribute("pro", pro);
		 request.getRequestDispatcher("/Admin/providers/proviupdate_cate.jsp").forward(request, response);
	}
	
}
