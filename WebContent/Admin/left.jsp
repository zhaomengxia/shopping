<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
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
		
			body{
				background-color:lightgreen;
			}
		</style>
	</head>
	
	<body bgcolor="#800080">
		<div class="main">	
		<p><a href="${pageContext.request.contextPath}/Admin/categorys/cateDo?p=doma&currentPage=1&PageSize=10" target="main1">产品类别管理</a></p>	
		<p><a href="${pageContext.request.contextPath}/Admin/products/proServlet?p=doma&currentPage=1&PageSize=10" target="main1">产品管理</a></p>
 	<!-- 	<p><a href="products/MyJsp.jsp" target="main1">产品管理easyUI</a></p> -->
 		<p><a href="${pageContext.request.contextPath}/Admin/providers/provServlet?p=doma&currentPage=1&PageSize=10" target="main1">供应商管理</a></p>	
		<p><a href="${pageContext.request.contextPath}/Admin/orders/OrderTwoServlet?p=doma&currentPage=1&PageSize=10" target="main1">订单管理</a></p>	
		<p><a href="${pageContext.request.contextPath}/Admin/customers/customerServlet?p=doma&currentPage=1&PageSize=10" target="main1">客户管理</a></p>
		<p><a href="${pageContext.request.contextPath}/Admin/employees/employServlet?p=doma&currentPage=1&PageSize=10" target="main1">员工管理</a></p>
		<p><a href="${pageContext.request.contextPath}/Admin/products/FileServlet?p=doma" target="main1">文件管理</a></p>
		<p><a href="${pageContext.request.contextPath}/Admin/files/fileupload.jsp" target="main1">文件上传</a></p>
	
	</div>
		
	</body>
	
</html>
