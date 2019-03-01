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
	
	<h1>订单信息修改</h1>
	<form method="post" action="${pageContext.request.contextPath}/Admin/orders/OrderTwoServlet?p=doup2">
	
	订单编号：<input name="orderID"   value="${orders.orderID }" /><br /> 
		订购日期：<input name="order_date" class="Wdate" onclick="WdatePicker()"  value="${orders.order_date}" /><br /> 
			
			客户： <select name="customers">
			<option value="0">请选择</option>
			<c:forEach items="${customers}" var="p">	
			<c:if test="${p.customerID==(orders.customers.customerID)}">
			<option value="${p.customerID}" selected>${p.customer_name}</option>
			</c:if>
			<c:if test="${(orders.customers.customerID)!=p.customerID}">
			<option value="${p.customerID }">${p.customer_name}</option>
			</c:if>
			</c:forEach>	
		</select></br>
			员工： <select name="employees">
			<option value="0">请选择</option>
			<c:forEach items="${employs}" var="employ">
			<c:if test="${employ.empID==(orders.employ.empID)}">
			<option value="${employ.empID}" selected>${employ.emp_name}</option>
			</c:if>
			<c:if test="${(orders.employ.empID)!=employ.empID}">
			<option value="${employ.empID}">${employ.emp_name}</option>
			</c:if>
			</c:forEach>
		</select></br>
		<input name="add" type="submit" value="修改" /> <input name="set"
			type="reset" value="重置" />
	</form>
</body>
</html>