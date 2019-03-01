<%@page import="com.shopping.entity.Admin" %>
<%@page import="com.shopping.serviceimpl.AdminServiceImpl" %>
<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String name=request.getParameter("name");
String realname=request.getParameter("realname");
String password=request.getParameter("password");
String phone=request.getParameter("phone");
String address=request.getParameter("address");
Admin admin=new Admin(name,realname,password,phone,address);
AdminServiceImpl service=new AdminServiceImpl();
int f=service.addAdmin(name, realname, password, phone, address);
if(f>0){
System.out.print("-------------");
response.sendRedirect(request.getContextPath()+"/login.jsp");
}else{
System.out.print("fair");
}
%>

