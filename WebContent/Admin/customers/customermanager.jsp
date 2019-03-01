<%@page import="javax.sound.midi.SysexMessage"%>
<%@page import="com.shopping.daoimpl.CategoryDaoImpl"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.shopping.dao.Page"%>
<%@page import="com.shopping.entity.Categorys"%>
<%@page import="java.util.List"%>
<%@page import="com.shopping.serviceimpl.CategoryServiceImpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function selAll() {
		var cds = document.getElementsByName("nn");
		for (var i = 0; i < cds.length; i++) {
			//全选
			cds[i].checked = document.getElementById("m").checked;
		/* //反选
		cds[i].checked=!cds[i].checked; */
		}
	}
</script>

<style type="text/css">
body{
background-color: silver;
}
h1{
		color: maroon;
		margin-left: 150px;
}
</style>

<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.1.1.js"></script>
<script type="text/javascript">

$(document).ready(function(e){
var i=($("table tr").length);

		$("tr:even").css("background-color","burlywood");
		
		$("tr:odd").css("background-color","#aquamarine");

});
</script>
</head>
<body style="background-color: aquamarine">
<h1>客户管理</h1>

<table width="600" border="1" align="center" cellpadding="0" cellspacing="0">
<tr>
<td width="120" height="26" align="center">客户姓名</td>
<td width="120" height="26" align="center">地址</td>
<td width="120" height="26" align="center">生日</td>
<td width="160" height="26" align="center">联系方式</td>
<td align="center">操作</td>
</tr>


<c:forEach items="${provPage.list }" var="customer">
<tr>
<td height="26" align="center">${customer.customer_name}</td>
<td height="26" align="center">${customer.customer_add}</td>
<td height="26" align="center">${customer.customer_bir}</td>
<td height="26" align="center">${customer.customer_tel}</td>

<td height="40" align="center" width="100"><a href="${pageContext.request.contextPath}/Admin/customers/customerServlet?p=dodel&id=${customer.customerID}" onclick="return confirm('是否删除？');">删除</a>&nbsp/&nbsp<a href="${pageContext.request.contextPath}/Admin/customers/customerServlet?p=doup2&id=${customer.customerID}">修改</a></td>

</tr>

</c:forEach>
<tr>
<td colspan="8" align="center">
<c:if test="${provPage.currentPage==provPage.firstPage}">
<a>已是首页</a>
</c:if>
<c:if test="${provPage.currentPage!=provPage.firstPage}">
<a href="${pageContext.request.contextPath}/Admin/customers/customerServlet?p=doma&currentPage=${provPage.firstPage}&PageSize=10">首页</a>&nbsp&nbsp&nbsp&nbsp
</c:if>
<c:if test="${provPage.currentPage==provPage.firstPage}">
<a>上一页</a>
</c:if>
<c:if test="${provPage.currentPage!=provPage.firstPage}">
<a href="${pageContext.request.contextPath}/Admin/customers/customerServlet?p=doma&currentPage=${provPage.upPage}&PageSize=10">上一页</a>&nbsp&nbsp&nbsp&nbsp
</c:if>
共${provPage.totalPage}页&nbsp&nbsp&nbsp&nbsp
	第${provPage.currentPage}页&nbsp&nbsp&nbsp&nbsp
<c:if test="${provPage.currentPage==provPage.totalPage}">
<a>下一页</a>
</c:if>
<c:if test="${provPage.currentPage!=provPage.totalPage}">
<a href="${pageContext.request.contextPath}/Admin/customers/customerServlet?p=doma&currentPage=${provPage.downPage}&PageSize=10">下一页</a>&nbsp&nbsp&nbsp&nbsp
</c:if>
<c:if test="${provPage.currentPage!=provPage.totalPage}">
<a href="${pageContext.request.contextPath}/Admin/customers/customerServlet?p=doma&currentPage=${provPage.totalPage}&PageSize=10">尾页</a>&nbsp&nbsp&nbsp&nbsp
</c:if>
<c:if test="${provPage.currentPage==provPage.totalPage}">
<a>已是尾页</a>
</c:if>

<a href="${pageContext.request.contextPath}/Admin/customers/customeradd.jsp"  target="main1">添加客户</a>
</td>
</tr>

</table>
</body>
</html>