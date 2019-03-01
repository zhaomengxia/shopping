<%@page import="com.shopping.serviceimpl.AdminServiceImpl"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="com.shopping.utils.getDate"%>
<%@page import="java.util.Date"%>
<%@page import="com.shopping.entity.Admin"%>


<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!DOCTYPE html>

<html>
	<head>
		<meta charset="UTF-8">
		<style type="text/css">
		h2{
		color: olive;
		font-style: inherit;
		
		}
		
		
		</style>
		</head>
	<body style="background-color: aqua;">
	
	<h2>当前登录用户数:<a style="color: purple;font-language-override: inherit;  margin: 10px;">${loginCount}</a></h2>
	<h2>欢迎<a style="color: purple;font-language-override: inherit; margin: 10px">${adminName.name}</a>使用</h2>

	</body>
	</html>