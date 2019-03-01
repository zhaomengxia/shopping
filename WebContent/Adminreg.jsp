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

  </head>
  
  <body style="background-color: silver;">
  <form action="Adminregs.jsp" method="post">
		<table align="center">
			<tr>
				<td align="right">登录名：</td>
				<td><input type="text" id="name2" name="name"
					placeholder="请输入登录名 "></td>
			</tr>
			<tr>
				<td align="right" width="100px">名字：</td>
				<td><input type="text" id="name" name="realname"
					placeholder="请输入真实姓名" ></td>
				<td><span id="nameError" style="color: red;"></span></td>
				<td colspan="5" width="200px"></td>
				<td rowspan="9" colspan="9" align="900px" align="right"></td>
			</tr>
			
			<tr>
				<td align="right">密码：</td>
				<td><input type="password" id="password" name="password"
					placeholder="输入密码" ></td>
				<td><span id="passwordError" style="color: red;"></span></td>
			</tr>
			<tr>
				<td align="right">再次输入密码：</td>
				<td><input type="password" id="password1" name="password1"
					placeholder="再次输入密码" ></td>
				<td><span id="password1Error" style="color: red;"></span></td>
			</tr>
			
			<tr>
				<td align="right">手机号：</td>
				<td><input id="phone" type="text" name="phone" ></td>
				<td><span id="phone1" style="color: red;"></span></td>
			</tr>
			
			<tr>
				<td align="right">住址：</td>
				<td><input id="phone" type="text" name="address" ></td>
				<td><span id="phone1" style="color: red;"></span></td>
			</tr>
		
			<tr>
				<td align="right">
				<td><button>提交</button>
					

					<button type="reset">
						重置
					</button>
				
				</td>
			</tr>
		</table>

	</form>
	<br />
	<br />
	<br />

	<br />
	
</body>
</html>
