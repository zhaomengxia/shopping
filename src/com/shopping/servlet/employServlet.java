package com.shopping.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shopping.dao.Page;
import com.shopping.daoimpl.EmployDaoImpl;
import com.shopping.entity.Employ;
import com.shopping.entity.Providers;
import com.shopping.serviceimpl.EmployServiceImpl;
import com.shopping.serviceimpl.ProviderServiceImpl;
public class employServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String p=request.getParameter("p");
		if("doadd".equals(p)){
			doadd(request, response);
		}
		else if("doma".equals(p)){
			
			doshow(request, response);
		}else if("doup1".equals(p)){
		
			doup1(request, response);
		}else if("doup2".equals(p)){
			doup2(request, response);
		}else if("dodel".equals(p)){
			dodel(request, response);
		}
		
}


	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
		
	}
	public void doadd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		String name=request.getParameter("name");
		String hire_date=request.getParameter("hire_date");
		double salary=Double.valueOf(request.getParameter("salary"));
		String password=request.getParameter("password");
		String phone=request.getParameter("phone");
		String interest=request.getParameter("interest");
		String address=request.getParameter("address");
		String gender=request.getParameter("gender");
		Employ employ=new Employ(name,hire_date,salary,password,phone,interest,address,gender);
		EmployDaoImpl emp=new EmployDaoImpl();
		EmployServiceImpl employs=new EmployServiceImpl();
		if(name==null&&hire_date==null&&salary==0.0&&password==null&&phone==null&&interest==null&&address==null&&gender==null){
			out.print("<script>alert('你没有输入信息！请输入')</script>");
		}
		
		int f=employs.addEmploy(employ);/* employs.addEmploy(employ); */
		if(f==0){
		response.sendRedirect(request.getContextPath()+"/Admin/employees/employServlet?p=doma");
		} 
		else{
		out.print("<script>alert('注册失败');history.go(1)</script>");
		} 
		
	}
	public void doshow(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		
		EmployServiceImpl employ=new EmployServiceImpl();
		if(request.getParameter("currentPage")!=null&&request.getParameter("PageSize")!=null){
		int currentPage =Integer.parseInt(request.getParameter("currentPage"));

		int PageSize=Integer.parseInt(request.getParameter("PageSize"));
		Page<Employ> provPage=employ.selectAll(currentPage, PageSize);
		request.setAttribute("provPage", provPage);
		}
		else{
		Page<Employ> provPage=employ.selectAll(1, 10);
		request.setAttribute("provPage", provPage);
		}
		
		request.getRequestDispatcher("/Admin/employees/employmanager.jsp").forward(request, response);

		
	}
	
	protected void doup1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		PrintWriter out=response.getWriter();
		  EmployServiceImpl service=new EmployServiceImpl();
		  int empID=Integer.parseInt(request.getParameter("empID"));
		  String emp_name=request.getParameter("emp_name");
			String hire_date=request.getParameter("hire_date");
			double salary=Double.valueOf(request.getParameter("salary"));
			String password=request.getParameter("password");
			String phone=request.getParameter("phone");
			String interest=request.getParameter("interest");
			String address=request.getParameter("address");
			String gender=request.getParameter("gender");
			
			Employ employ=new Employ(empID,emp_name,hire_date,salary,password,phone,interest,address,gender);
			EmployDaoImpl emp=new EmployDaoImpl();
			EmployServiceImpl employs=new EmployServiceImpl();
			int d=employs.updateemploy(empID, emp_name, hire_date, salary, password, phone,interest, address, gender);/* employs.addEmploy(employ); */
	
		
		 response.sendRedirect(request.getContextPath()+"/Admin/employees/employServlet?p=doma");
		
	}
	protected void doup2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  int empID=Integer.parseInt(request.getParameter("id"));
		  Employ employs=new Employ();
		  EmployServiceImpl service=new EmployServiceImpl();
		 Employ employ= service.selectByID(empID);
		 request.setAttribute("employ", employ);
		 request.getRequestDispatcher("/Admin/employees/employupdate_cate.jsp").forward(request, response);
	}
	
	protected void dodel(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		PrintWriter out=response.getWriter();
		int empID = Integer.parseInt(request.getParameter("id"));
		EmployServiceImpl service = new EmployServiceImpl();
		int s = service.deleteEmploy(empID);
		if (s > 0) {
			response.sendRedirect(request.getContextPath()+"/Admin/employees/employServlet?p=doma");
		} else {
			out.print("<script>alert('还有产品存在，删除失败');history:go(-1);</script>");
		}
	}
	
}
