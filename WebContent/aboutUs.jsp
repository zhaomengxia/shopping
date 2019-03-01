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
				<jsp:include page="aboutUs_right.jsp" />      
       		</div>
       		
       		<div id="footer">
				<jsp:include page="bottom.jsp" />  
			</div>
	</div>
</body>
</html>
