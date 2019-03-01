<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>用户登录</title>
<script language="JavaScript">
	function checklogin() {
		var username = document.getElementById("name").value;
		if (username == "") {
			alert("账号没有输入！");
			return false;
		}
		var password = document.getElementById("password").value;
		if (password == "") {
			alert("密码没有输入！");
			return false;
		}
		return true;
	}
	if (top != self) {
		top.location.href = "login.jsp";
	}  
</script>
<style type="text/css">
form {
	width: 400px;
	height: 400px;
	margin: auto;
}

table {
	width: 350;
	height: 350;
	margin-top: 20;
}

td {
	font-family: sans-serif;
	font-size: 20px;
	color: inactiveborder;
	font-style: normal;
}
</style>
</head>
<body >
	<%-- <%=session.getId() %> --%>
	<h1>当前用户：${count}</h1>
	<form name="reg" action="${pageContext.request.contextPath}/admlogin?p=login" method="post">
		<table align="center" width="350">

			<tr>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<td align="center" style="width: 200px">用户登录</td>
			</tr>
			管理员登录
			<tr>
				<td width="96">账号：</td>
				<td width="240"><input id="name" name="name" type="text" /></td>
			</tr>
			<tr>
				<td>密码：</td>
				<td><input id="password" name="password" type="password" /></td>
			</tr>
			<tr>

				<td align="center" colspan="2">
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<button onclick="return checklogin()" />提交</button>&nbsp;&nbsp; 
					<button>重置</button> 
				</td>
			</tr>
		</table>

	</form>
</body>
</html>
