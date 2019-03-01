<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Myfirst.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript">

if (top != self) {
		top.location.href = "Myfirst.jsp";
	}  
</script>
		<style type="text/css">
			a{
				color: green;
				text-decoration: none;
				font-size: 28px;
				font-language-override: inherit;
				margin-top: 35px;
				margin-left: 25px
				
			}
			a:hover{
				color: blue;
				
			}
			p{
				color: #800080;
				font-size: 20px;
				
			}
		
		</style>
  </head>
  
  <body>
  <h1>欢迎光临！</h1><a href="${pageContext.request.contextPath}/index.jsp">用户登录首页</a>
  <p align="center"><a href="loginadmin.jsp">管理员请登录</a></p><br/><br/><br/><br/>
 <!--  <a href="Adminreg.jsp" >管理员注册入口</a><br><br> -->
  <a href="login.jsp">用户请登录</a><br/><br/><br/><br/>
  <a href="reg.jsp">用户注册入口</a>
  </body>
</html>
