<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBliC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>关于我们-淘书吧</title>
<link rel="stylesheet" rev="stylesheet" href="css/global.css" type="text/css" media="all" />
<!-- <link rel="stylesheet" rev="stylesheet" href="css/global.css" type="text/css" media="all" /> -->
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
       			<img style="height: 400px;width: 700px;" src="images/pay.jpg" alt="付款方式" />      			
       			<br />
				<dl class="fore3">
			
			<dd>
				<p align="center" ><a rel="nofollow" target="_blank" href="hdfk.jsp">货到付款</a></p>
				<p align="center" ><a rel="nofollow" target="_blank" href="zxzf.jsp">在线支付</a></p>
				
			
		</dd>

       		</div>
       		
       		<div id="footer">
				<jsp:include page="bottom.jsp" />  
			</div>
	</div>
</body>
</html>
