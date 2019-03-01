<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Img.jsp' starting page</title>
    
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
   <form name="frmadd" method="post" enctype="multipart/form-data" action="${pageContext.request.contextPath }/admin/doupload">
   	标题：<input name="emailTitle" type="text" />
   	附件：<input name="emailFile" type="file"/>
   	内容：<textarea rows="8" cols="40" name="emailContent"></textarea>
   <input name="btnadd" type="submit" value="添加"/>
   <input name="reset" type="reset" value="重置"/>
   </form>
  </body>
</html>
