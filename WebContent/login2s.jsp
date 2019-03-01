<%@page import="com.shopping.entity.Employ"%>
<%@page import="com.shopping.serviceimpl.EmployServiceImpl"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
String name=request.getParameter("name");
String password=request.getParameter("password");
EmployServiceImpl service=new EmployServiceImpl();
Employ emp=new Employ(name,password);
boolean em=service.login(emp);
if(em){
response.sendRedirect("");
}
%>