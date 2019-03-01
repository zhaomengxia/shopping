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
	//这是从目录servlet那里复制过来的，是为了模仿目录，根据目录id查找产品的
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
		//先把下面两个条件作为搜索对象；
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
		

		//先把三个条件，做成产品搜索对象
		Products p=new Products();
		p.setCategory(cates);
		p.setProduct_name(product_name);
		p.setCategoryID(categoryID);
		System.out.print("asdfghsdfgh");
		
		ProductServiceImpl service1 =new ProductServiceImpl();
		Page<Products> page=service1.selectAllCate(p, currentPage, PageSize);
		//得到产品的供应商和产品信息
		request.setAttribute("proPage", page);
		request.setAttribute("p", p);
		
		request.getRequestDispatcher("/Admin/categorys/productmanager.jsp").forward(request, response);
			
		}



	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	doGet(request, response);
	}
	
	//根据供应商id得到产品--------
	public void getProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//这里的cid是/Admin/categorys/productmanager.jsp中<script> 里写的json的xmlHttpRequest.open('get',"${pageContext.request.contextPath}/Admin/categorys/cateDo?p=getProduct&cid="+pname,true);</script>，如果以后想写用供应商的id查找产品的话，需要模仿目录去做。serarch,serach1也是从目录servlet那里复制过来的，跟做这个功能有关系
		int id=Integer.parseInt(request.getParameter("cid"));
		System.out.print(id);
		ProductServiceImpl service=new ProductServiceImpl();
		//这里是从目录servlet那里复制过来的，以后如果要做根据供应商ID搜索产品的功能的话，需要在产品的dao,daoImpl,sevice,serviceImpl那里写根据供应商id查找产品的方法，在这里改一下
		List<Products> list=service.searchProductByCategoryId(id);
		System.out.println(list+"bnnnnnnnnnnnnnnnnnnnnnn---------------");
		//product.setCategoryID(id);
		//把java对象，转成JSON对象，（使用JSON要先导相应的包）
		JSONArray arr=JSONArray.fromObject(list);
		System.out.print(arr+"----------------------------------");
		//不能用println(),因为会多出空格
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
	
		//先把条件，做成产品搜索对象
		p.setProviderID(providerID);
		p.setProvider_name(provider_name);
		
		//根据providerID,provider_name查找，并分页。
		Page<Providers> page=service.selectAllCate(p, currentPage, PageSize);
	
		//得到产品的供应商信息
		ProviderServiceImpl ps=new ProviderServiceImpl();
		ArrayList<Providers> list1=ps.selectAllProviders();
	
		
		//将下列信息带到jsp  /Admin/providers/providermanager.jsp页面
		request.setAttribute("provPage", page);
		request.setAttribute("p", p);
		request.setAttribute("list1", list1);
		
		request.getRequestDispatcher("/Admin/providers/providermanager.jsp").forward(request, response);
	
	}
	//这是从目录servlet那里复制过来的，是为了模仿目录，根据目录id查找产品的
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
		//先把下面两个条件作为搜索对象；
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
			out.print("<script>alert('添加失败');history.go(-1);</script>");
			
		}
		}else{
		out.print("<script>alert('不能为空');history.go(-1);</script>");
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
			out.print("<script>alert('还有产品存在，删除失败');history.href='provServlet?p=doma&currentPage=1&PageSize=10';</script>");
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
		 out.print("<Script>alert('供应商重名，修改失败');history:go(-1);</script>");
		 
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
