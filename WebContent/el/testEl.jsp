<%@page import="com.shopping.entity.Admin"%>
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
    
    <title>My JSP 'testEl.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
   <%
   String str="hello,world";
   Admin admin=new Admin("jack","1234");
   Admin admin2=new Admin("rose","12345");
   
   pageContext.setAttribute("str", str);
   request.setAttribute("admin", admin);
   session.setAttribute("admin1", admin.getName());
   application.setAttribute("admin2",admin2 );
   Map map=new HashMap();
   map.put("a", "1");
   map.put("b", "2");
   map.put("c", "3");
   
    %>
  <body>
  ${str}<br/>
  ${admin}<br/>
  ${admin1}<br/>
  ${admin2}<br/>
 <c:forEach items="${map}" var="entry">
 ${entry.key}
 ${entry.value}
 </c:forEach>
  </body>
</html>
