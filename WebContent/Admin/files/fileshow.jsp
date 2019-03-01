<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'fileshow.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
   <from action="${pageContext.request.contextPath}/Admin/products/FileServlet?p=doma" method="post" >
 <table width="900" border="1" align="center" cellpadding="0"
			cellspacing="0">
  <tr> <td>ID<td>文件名</td><td>文件描述</td><td>系统文件名</td><td>文件所有者</td><td>操作</td></tr>
   <c:forEach items="${file}" var="list">
   <tr>
   <td>${list.id }</td>
   <td>${list.file_name }</td>
   <td>${list.file_desc }</td>
   <td>${list.file_auto_name }</td>
   <td>${adminName.name}</td>
   <td><a href="${pageContext.request.contextPath}/Admin/products/FileServlet?p=del&id=${list.id}">删除文件</a>
   
  <a href="${pageContext.request.contextPath}/Admin/products/FileServlet?p=download&id=${list.id}">下载文件</a></td>
   
   
   </tr>
   </c:forEach>
   
   </table>
   </from>
  </body>
</html>
