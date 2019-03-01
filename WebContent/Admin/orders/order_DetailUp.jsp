<%@page import="java.util.ArrayList"%>
<%@page import="com.shopping.entity.Providers"%>
<%@page import="com.shopping.serviceimpl.ProviderServiceImpl"%>
<%@page import="com.shopping.entity.Products"%>
<%@page import="com.shopping.serviceimpl.ProductServiceImpl"%>
<%@page import="com.shopping.entity.Categorys"%>
<%@page import="com.shopping.serviceimpl.CategoryServiceImpl"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/javascript/My97DatePicker/WdatePicker.js"></script>
</head>
<body>
	
	<h1>订单详情信息修改</h1>
	<form method="post" action="${pageContext.request.contextPath}/Admin/orders/OrderTwoServlet?p=doupdetail">
	
	<input name="id" type="hidden" value="${orders.id }"/>
	<input name="orderID"  type="hidden" value="${orders.orderID }" /><br /> 
	
	产品名称：<select name="product_name">
	<option value="0">请选择</option>
	<c:forEach items="${product}" var="products">
	<c:if test="${orders.products.productID==products.productID}">
		<option value="${products.productID}" selected>${products.product_name }</option>
	</c:if>
	
	<c:if test="${orders.products.productID!=products.productID}">
	<option value="${products.productID}">${products.product_name }</option>
	</c:if>
	</c:forEach>
	
	</select><br /> 	
	数量：<input name="quantity"   value="${orders.quantity }" /><br /> 
	折扣：<input name="discount"  value="${orders.discount}" /><br /> 	
		<input name="add" type="submit" value="修改" /> <input name="set"
			type="reset" value="重置" />
	</form>
</body>
</html>