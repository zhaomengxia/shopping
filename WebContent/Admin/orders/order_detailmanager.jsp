<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-3.1.1.js"></script>
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
				background-color:hotpink;
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
  <form action="${pageContext.request.contextPath}/Admin/orders/OrderTwoServlet?p=dodelmany1" method="post">	
		<h1>订单详情</h1>
		<table width="900" border="1" align="center" cellpadding="0" cellspacing="0" style="background-color: olive;">
			<tr>
				<td width="60" height="26" align="center">全选<input id="m1"
					name="cate" type="checkbox" onclick="selAll1()" /></td>

				<td height="30" width="180" align="center">订单编号</td>
				<td height="30" width="360" align="center">产品名称</td>
				<td height="30" width="180" align="center">数量</td>

				<td height="30" width="180" align="center">折扣</td>
				<td height="30" width="180" align="center">操作</td>
			</tr>


			<c:forEach items="${proPage.list}" var="orders">
				<tr>
					<td width="100" align="center"><input name="nn1" type="checkbox" value="${orders.orderID}"></td>
					<td height="30" width="130" align="center">${orders.orderID}</td>
					<td height="30" width="130" align="center">${orders.products.product_name}</td>
					<td height="30" width="130" align="center">${orders.quantity}</td>
					<td height="30" width="130" align="center">${orders.discount}</td>
					<td align="center" height="30" width="280"><a
						href="${pageContext.request.contextPath}/Admin/orders/OrderTwoServlet?p=dodel&id=${orders.orderID }"
						onclick="return confirm('是否删除？');">删除</a>&nbsp;&nbsp;<a
						href="${pageContext.request.contextPath}/Admin/orders/OrderTwoServlet?p=doupdetails&id1=${orders.orderID}">修改</a></td>
				</tr>

			</c:forEach>

			<tr>
				<td colspan="8" align="center"><c:if
						test="${proPage.currentPage==proPage.firstPage}">
						<a>已是首页</a>
					</c:if> <c:if test="${proPage.currentPage!=proPage.firstPage}">
						<a
							href="${pageContext.request.contextPath}/Admin/orders/OrderTwoServlet?p=doma1&currentPage=${proPage.firstPage}&PageSize=10">首页</a>&nbsp&nbsp&nbsp&nbsp
				</c:if> <c:if test="${proPage.currentPage==proPage.firstPage}">
						<a>上一页</a>
					</c:if> <c:if test="${proPage.currentPage!=proPage.firstPage }">
						<a
							href="${pageContext.request.contextPath}/Admin/orders/OrderTwoServlet?p=doma1&currentPage=${proPage.upPage}&PageSize=10">上一页</a>&nbsp&nbsp&nbsp&nbsp
		
		</c:if> 共${proPage.totalPage}页 &nbsp&nbsp&nbsp&nbsp
					第${proPage.currentPage}页&nbsp&nbsp&nbsp&nbsp <c:if
						test="${proPage.currentPage==proPage.totalPage}">
						<a>下一页</a>
					</c:if> <c:if test="${proPage.currentPage!=proPage.totalPage}">
						<a
							href="${pageContext.request.contextPath}/Admin/orders/OrderTwoServlet?p=doma1&currentPage=${proPage.downPage}&PageSize=10">下一页</a>&nbsp&nbsp&nbsp&nbsp
		</c:if> &nbsp&nbsp&nbsp&nbsp <c:if
						test="${proPage.currentPage!=proPage.totalPage}">
						<a
							href="${pageContext.request.contextPath}/Admin/orders/OrderTwoServlet?p=doma1&currentPage=${proPage.totalPage}&PageSize=10">尾页</a>&nbsp&nbsp&nbsp&nbsp
		</c:if> &nbsp&nbsp&nbsp&nbsp <c:if
						test="${proPage.currentPage==proPage.totalPage}">
						<a>尾页</a>
					</c:if> &nbsp&nbsp&nbsp&nbsp <input id="del" name="cate" type="submit"
					value="删除多条" onclick="return confirm('是否删除？')" />
					&nbsp&nbsp&nbsp&nbsp</td>
			</tr>
		</table>

	</form>




  </body>
</html>
