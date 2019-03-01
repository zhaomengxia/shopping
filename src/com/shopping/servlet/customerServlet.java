package com.shopping.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shopping.dao.Page;
import com.shopping.entity.Customers;
import com.shopping.serviceimpl.CustomerServiceImpl;

public class customerServlet extends HttpServlet{

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
		}
		
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	doGet(request, response);
	}
	protected void doadd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		PrintWriter out=response.getWriter();
		
		String customer_name=request.getParameter("customer_name");
		request.setCharacterEncoding("utf-8");
		System.out.println(customer_name);
		String customer_add=request.getParameter("customer_add");
		request.setCharacterEncoding("utf-8");
		System.out.println(customer_add);
		String customer_bir=request.getParameter("customer_bir");
		request.setCharacterEncoding("utf-8");
		
		String customer_tel=request.getParameter("customer_tel");
		request.setCharacterEncoding("utf-8");
		System.out.println(customer_tel);
		if(request.getParameter("customer_name")!=null&&request.getParameter("customer_add")!=null&&request.getParameter("customer_tel")!=null&&request.getParameter("customer_bir")!=null){

		CustomerServiceImpl service=new CustomerServiceImpl();
		int result=service.addcusto(customer_name, customer_add, customer_bir, customer_tel);
		if(result>0){
			response.sendRedirect(request.getContextPath()+"/Admin/customers/customerServlet?p=doma");
		}
		else if(result==0){
			out.print("<script>alert('Ìí¼ÓÊ§°Ü');history.go(-1);</script>");
			
		}
		}else{
		out.print("<script>alert('²»ÄÜÎª¿Õ');history.go(-1);</script>");
		}
	}
	protected void dodel(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		PrintWriter out=response.getWriter();
		int customerID = Integer.parseInt(request.getParameter("id"));
		CustomerServiceImpl service = new CustomerServiceImpl();
		int s = service.deleteCustomer(customerID);
		if (s > 0) {
			response.sendRedirect(request.getContextPath()+"/Admin/customers/customerServlet?p=doma");
		} else {
			out.print("<script>alert('É¾³ýÊ§°Ü');history:go(-1);</script>");
		}
	}
	protected void doma(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CustomerServiceImpl customer=new CustomerServiceImpl();
		if(request.getParameter("currentPage")!=null&&request.getParameter("PageSize")!=null){
		int currentPage =Integer.parseInt(request.getParameter("currentPage"));

		int PageSize=Integer.parseInt(request.getParameter("PageSize"));
		Page<Customers> provPage=customer.selectAllCust(currentPage, PageSize);
		request.setAttribute("provPage", provPage);
		}
		else{
		Page<Customers> provPage=customer.selectAllCust(1, 10);
		request.setAttribute("provPage", provPage);
		}
		
		request.getRequestDispatcher("/Admin/customers/customermanager.jsp").forward(request, response);

		
	}
	protected void doup1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		PrintWriter out=response.getWriter();
		  CustomerServiceImpl service=new CustomerServiceImpl();
		  int customerID=Integer.parseInt(request.getParameter("customerID"));
		  request.setCharacterEncoding("utf-8");
		  String customer_name=request.getParameter("customer_name");
		  request.setCharacterEncoding("utf-8");
		  String customer_add=request.getParameter("customer_add");
		  request.setCharacterEncoding("utf-8");
		  String customer_tel=request.getParameter("customer_tel");
		  request.setCharacterEncoding("utf-8");
		  String customer_bir=request.getParameter("customer_bir");
		  request.setCharacterEncoding("utf-8");
		 
		 int d=service.updateCustomer(customerID, customer_name, customer_add, customer_bir, customer_tel);
		out.print(d); 
	if(d==0){
		 response.sendRedirect(request.getContextPath()+"/Admin/customers/customerServlet?p=doma");
		 }
	}
	protected void doup2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  int customerID=Integer.parseInt(request.getParameter("id"));
		  Customers customer=new Customers();
		  CustomerServiceImpl customers=new CustomerServiceImpl();
		 Customers cus= customers.selectByID(customerID);
		 request.setAttribute("cus", cus);
		 request.getRequestDispatcher("/Admin/customers/update_customer.jsp").forward(request, response);
	}
	
}
