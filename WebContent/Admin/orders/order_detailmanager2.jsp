<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'products.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/css/jquery.dataTables.css">

<!-- jQuery -->
<script type="text/javascript" charset="utf8"
	src="${pageContext.request.contextPath }/js/jquery-1.4.min.js"></script>

<!-- DataTables -->
<script type="text/javascript" charset="utf8"
	src="${pageContext.request.contextPath }/js/jquery.dataTables.js"></script>


<!--或者下载到本地，下面有下载地址-->
<!-- DataTables CSS -->
<link rel="stylesheet" type="text/css"
	href="DataTables-1.10.15/media/css/jquery.dataTables.css">


<style type="text/css">
			a{
				color: red;
				text-decoration: none;
			}
			a:hover{
				color: blue;
				
			}
			p{
				color: #800080;
				font-size: 20px;
				
			}
		
			body{
				background-color:activeborder;
			}
		</style>
<script type="text/javascript">

	function selAll1() {
		var cds = document.getElementsByName("nn1");
		for (var i = 0; i < cds.length; i++) {
			//全选
			cds[i].checked = document.getElementById("m1").checked;
		/* //反选
		cds[i].checked=!cds[i].checked; */
		}
	}
	
	
		
</script>


<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.1.1.js"></script>
<script type="text/javascript">

$(document).ready(function(e){
var i=($("table tr").length);

		$("tr:even").css("background-color","aquamarine");
		
		$("tr:odd").css("background-color","#D8D8D8");
	



});
</script>
</head>

  <body>
  <form action="${pageContext.request.contextPath}/Admin/orders/OrderTwoServlet?p=dodelmany2" method="post">	
		<h1>订单详情</h1>
		<table width="900" border="1" align="center" cellpadding="0" cellspacing="0" style="background-color: activecaption;">
			<tr>
				<td width="60" height="26" align="center">全选<input id="m1"
					name="cate" type="checkbox" onclick="selAll1()" /></td>

				<td height="30" width="180" align="center">订单编号</td>
				<td height="30" width="360" align="center">产品名称</td>
				<td height="30" width="180" align="center">数量</td>

				<td height="30" width="180" align="center">折扣</td>
				<td height="30" width="180" align="center">操作</td>
			</tr>


		<c:forEach items="${orders}"  var="order">
				<tr>
					<td width="100" align="center"><input name="nn1" type="checkbox" value="${order.id}"></td>
					<td height="30" width="130" align="center">${order.orderID}</td>
					<td height="30" width="130" align="center">${order.products.product_name}</td>
					<td height="30" width="130" align="center">${order.quantity}</td>
					<td height="30" width="130" align="center">${order.discount}</td>
					<td align="center" height="30" width="280"><a
						href="${pageContext.request.contextPath}/Admin/orders/OrderTwoServlet?p=dodel2&id=${order.id }"
						onclick="return confirm('是否删除？');">删除</a>&nbsp;&nbsp;<a
						href="${pageContext.request.contextPath}/Admin/orders/OrderTwoServlet?p=doupdetails&id1=${order.orderID}">修改</a></td>
				</tr>

		</c:forEach>
	
			
		</table>

	</form>




  </body>
</html>
