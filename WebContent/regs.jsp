<%@page import="com.shopping.serviceimpl.EmployServiceImpl"%>
<%@page import="com.shopping.daoimpl.EmployDaoImpl"%>
<%@page import="com.shopping.entity.Employ"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>


<%
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
int f=employs.addEmploy(employ);/* employs.addEmploy(employ); */
if(f==0){
response.sendRedirect(request.getContextPath()+"/login2.jsp");
} 
else{
out.print("<script>alert('注册失败');history.go(1)</script>");
} 
%>

