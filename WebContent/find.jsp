<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.dataBase.DataProcess,java.util.Vector" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" rev="stylesheet" href="css/global.css" type="text/css" media="all" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查找</title>
<script type="text/javascript">


</script>
</head>
<body>
<div id="page">
		<div id="header">
			<jsp:include page="header.jsp" />      
       	</div>
		<p>
			<font size="3" color="red">欢迎您的光临！</font></p>	
		<div id="left_column">
			<jsp:include page="left_column.jsp" />  
		</div>
			
		<div id="center_column">		
	<form action="FindMessServlet" method="post">
	<br>
	<br>
	<br>
		<center><input type="text" name="search" style="widows: inherit;width: 300px" value="">
		<input type="submit" style="font-family: fantasy;" value="查找"></center>
	</form>
	<%
	Vector<Vector<String>> book = (Vector<Vector<String>>)request.getAttribute("book");
	
	if(book!=null){
		Vector<String> onebook = (Vector<String>)book.get(0);
	%>
	<br>
	<br>
	<br>
	<br>
		<div id=item_img>
				<img width="300px" height="225px" src="<%=onebook.get(3) %>" /> 
		</div>
		<font size="3">品&nbsp;&nbsp;&nbsp;&nbsp;名：&nbsp;</font><span  style="font-size:15px;font-weight:bold;"><%=onebook.get(0) %></span><br><br>
		<font size="3">原&nbsp;&nbsp;&nbsp;&nbsp;价：&nbsp;</font><span  style="text-decoration: line-through;"><%=onebook.get(2) %>元</span><br><br>
		<font size="3">促&nbsp;&nbsp;&nbsp;&nbsp;销：&nbsp;</font><span  style="font-size:28px;font-weight:bold;color:#B22222;"><%=onebook.get(1) %></span>元<br>
		<font size="3">出&nbsp;版&nbsp;社&nbsp;</font><span  style="font-weight:bold;color:#CC6600;"><%=onebook.get(4) %></span><br><br>
		<font size="3">作&nbsp;&nbsp;&nbsp;&nbsp;者：&nbsp;</font><span  style="font-weight:bold;color:#CC6600;"><%=onebook.get(5) %></span><br><br><br><br><br>
		<a href=ShowCartServlet><img src="images/buy_button.png" />&nbsp;&nbsp;
		<a href=ShowCartServlet><input type="image" src="images/shopping_button.png" name="submit" value="加入购物车"></a></p>
		<font size="3">描&nbsp;&nbsp;&nbsp;&nbsp;述：&nbsp;</font><span  style="font-weight:bold;color:#CC6600;"><%=onebook.get(6) %></span><br><br><br>
		
	<%
	}
	%>
	
</div>
<div id="footer">
			<jsp:include page="bottom.jsp" />  
		</div>
</body>
</html>