
<%@page import="com.shopping.dao.Page"%>
<%@page import="com.shopping.entity.Products"%>
<%@page import="com.shopping.serviceimpl.ProductServiceImpl"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>



</head>
<body style="background-color: buttonhighlight;">
	<h1>订单详情</h1>
	
	
 	
		
	<form action="${pageContext.request.contextPath}/Admin/orders/OrderTwoServlet?p=doma&currentPage=1&PageSize=10" method="post">
	
		<table width="900" border="1" align="center" cellpadding="0"
			cellspacing="0">
			<tr>
				<td width="60" height="26" align="center">全选<input id="m"
					name="cate" type="checkbox" onclick="selAll()" /></td>
				<td height="30" width="180" align="center">订单编号</td>
				<td height="30" width="180" align="center">下单日期</td>
				<td height="30" width="180" align="center">客户</td>
				<td height="30" width="180" align="center">业务员</td>
				<td height="30" width="360" align="center">操作</td>

			</tr>

			<c:forEach items="${proPage.list}" var="order">
				<tr>
					<td width="100" align="center"><input name="nn" type="checkbox" value="${order.id}"></td>
					<td height="30" width="130" align="center">${order.orders.orderID}</td>
					<td height="30" width="130" align="center">${order.products.product_name}</td>
					<td height="30" width="130" align="center">${order.provider.provider_name}</td>
					<td height="30" width="130" align="center">${order.quantity}</td>
					<td height="30" width="130" align="center">${order.discount}</td>
					<td align="center" height="30" width="280"><a
						href="${pageContext.request.contextPath}/Admin/orders/OrderTwoServlet?p=dodel&id=${order.id }"
						onclick="return confirm('是否删除？');">删除</a>&nbsp;&nbsp;<a
						href="${pageContext.request.contextPath}/Admin/orders/OrderTwoServlet?p=doup2&id=${order.id}">修改</a></td>
				</tr>

			</c:forEach>

			<tr>
				<td colspan="8" align="center">
				<c:if test="${proPage.currentPage==proPage.firstPage}">
				<a>已是首页</a>
				</c:if> 
				<c:if test="${proPage.currentPage!=proPage.firstPage}">
				<a href="${pageContext.request.contextPath}/Admin/orders/OrderTwoServlet?p=doma&currentPage=${proPage.firstPage}&PageSize=10">首页</a>&nbsp&nbsp&nbsp&nbsp
				</c:if> 
		<c:if test="${proPage.currentPage==proPage.firstPage}">
						<a>上一页</a>
		</c:if> 
		<c:if test="${proPage.currentPage!=proPage.firstPage }">
		<a href="${pageContext.request.contextPath}/Admin/orders/OrderTwoServlet?p=doma&currentPage=${proPage.upPage}&PageSize=10">上一页</a>&nbsp&nbsp&nbsp&nbsp
		
		</c:if> 共${proPage.totalPage}页 &nbsp&nbsp&nbsp&nbsp
		第${proPage.currentPage}页&nbsp&nbsp&nbsp&nbsp <c:if
		test="${proPage.currentPage==proPage.totalPage}">
		<a>下一页</a>
		</c:if> 
		<c:if test="${proPage.currentPage!=proPage.totalPage}">
		<a href="${pageContext.request.contextPath}/Admin/orders/OrderTwoServlet?p=doma?p=doma&currentPage=${proPage.downPage}&PageSize=10">下一页</a>&nbsp&nbsp&nbsp&nbsp
		</c:if> &nbsp&nbsp&nbsp&nbsp
		<c:if test="${proPage.currentPage!=proPage.totalPage}">
		<a href="${pageContext.request.contextPath}/Admin/orders/OrderTwoServlet?p=doma&currentPage=${proPage.totalPage}&PageSize=10">尾页</a>&nbsp&nbsp&nbsp&nbsp
		</c:if> &nbsp&nbsp&nbsp&nbsp
		<c:if test="${proPage.currentPage==proPage.totalPage}">
		<a>尾页</a>
		</c:if> &nbsp&nbsp&nbsp&nbsp
		<input id="del" name="cate" type="submit" value="删除多条" onclick="return confirm('是否删除？')" />
					&nbsp&nbsp&nbsp&nbsp
		<a href="${pageContext.request.contextPath}/Admin/orders/OrderTwoServlet?p=doadd2" target="main1">产品添加</a>
		
				</td>
			</tr>
		</table>
	</form>
	
</body>
</html>