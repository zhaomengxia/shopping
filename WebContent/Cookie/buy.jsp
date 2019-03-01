<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'buy.jsp' starting page</title>

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
	<%!int num = 1;%>
	<%
 String[] str=request.getParameterValues("bookname");
 for(int i=0;i<str.length;i++){
 Cookie cookie=new Cookie("bookname"+num,str[i]);
 cookie.setPath("/shop");
 cookie.setMaxAge(60*1);
	num++;
 response.addCookie(cookie);
 out.print(str[i]+"      ");
 }
   %>	
<a href="Cookie/res.jsp">购买</a>
	<br>
</body>
</html>
