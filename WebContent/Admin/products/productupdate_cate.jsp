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
<style type="text/css">
	h1{
			color: maroon;
			margin-left: 150px;
			}
			form{
			
			margin-top: 30px;
			
			}

</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	$(document).ready(function(){
		$("#myForm").form({
		url:'Admin/products/proServlet?p=doup1',
		
		onSubmit:function(){
			if($("from:input[name=product_name]").val()==""){
			
				$.messager.alert('产品名称不能为空！');
				return false;
			}
			return ture;
		
		},
		
		success:function(data){
			if(data=="修改成功"){
				$("#editProduct").dialog("close");
				$("#product").datagrid("reload");
			
			}else{
			
			
			$.messager.alert('修改失败');
			}
		
		
		}
		
		});
		
		
	
	
	
	});
</script>
</head>
<body>
	
	<h1>产品信息修改</h1>
	<form method="get" action="${pageContext.request.contextPath}/Admin/products/proServlet?p=doup1">
	<input type="hidden" value="doup1" name="p"/>
		<input name="productID" type="hidden" value="${product.productID }" /><br /> 
		产品名称：<input name="product_name" type="text" value="${product.product_name }" /><br /> 
			产品进价：<input name="income_price" type="text" value="${product.income_price}" /><br /> 
			供应商： <select name="provider">
			<option value="0">请选择供应商</option>
			<c:forEach items="${providers}" var="p">	
			<c:if test="${p.providerID==(product.provider.providerID)}">
			<option value="${p.providerID}" selected>${p.provider_name}</option>
			</c:if>
			<c:if test="${product.provider.providerID!=p.providerID}">
			<option value="${p.providerID }">${p.provider_name}</option>
			</c:if>
			</c:forEach>
			
		</select> <br /> 产品数量：<input name="quantity" type="text"
			value="${product.quantity}" /><br /> 产品售价：<input
			name="sales_price" type="text" value="${product.sales_price }" /><br />
			产品类别： <select name="category">
			<option value="0">请选择</option>
			<c:forEach items="${cates}" var="cates">
			<c:if test="${product.category.categoryID==cates.categoryID}">
			<option value="${cates.categoryID}" selected>${cates.category_name}</option>
			</c:if>
			<c:if test="${product.category.categoryID!=cates.categoryID}">
			<option value="${cates.categoryID}">${cates.category_name}</option>
			</c:if>
			</c:forEach>
		</select>
		
		
		
		 <br /> 产品进货时间：<input name="income_time" class="Wdate" type="text" value="${product.income_time}" onclick="WdatePicker()" /><br />
		
		
		 <input name="add" type="submit" value="修改" /> <input name="set"
			type="reset" value="重置" /> 
			
			
	</form>
</body>
</html>