
<%@page import="com.shopping.daoimpl.ProviderDaoImpl"%>
<%@page import="com.shopping.dao.Page"%>
<%@page import="com.shopping.entity.Providers"%>
<%@page import="com.shopping.serviceimpl.ProviderServiceImpl"%>
<%@page import="java.util.List"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
function selAll(){
	var cds=document.getElementsByName("nn");
	for(var i=0;i<cds.length;i++){
		//全选
	cds[i].checked=document.getElementById("m").checked;
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
<link rel="stylesheet" type="text/css" href="css/one.css"/>

<style type="text/css">
h1{
		color: maroon;
		margin-left: 150px;
}
</style>
</head>
<body style="background-color: activecaption;">
<h1>供应商管理</h1>
<form action="${pageContext.request.contextPath}/Admin/providers/provServlet?p=searchProduct&currentPage=1&PageSize=10" method="post">
 	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input  type="text" name="provider_name"  value="${p.provider_name }" style="margin-left: 120px"/>&nbsp
		<select name="provider">
		<option value="0">请选择供应商</option>
		 
		 <c:forEach items="${list1}" var="provid">
		 
		 <c:if test="${p.providerID==provid.providerID }">
		 <option value="${provid.providerID}" selected>${provid.provider_name}</option>
		 </c:if>
		  <c:if test="${p.providerID!=provid.providerID }">
		 <option value="${provid.providerID}">${provid.provider_name}</option>
		 </c:if>
		 </c:forEach>
		</select>
	<input type="submit" value="搜索"/>

<table width="700" border="1" align="center" cellpadding="0" cellspacing="0" style="background-color: silver;">
<tr>
<!-- <td width="108" height="26" align="center">全选<input id="m" name="cate" type="checkbox" onclick="selAll()"/></td> -->
<td width="120" height="26" align="center">供应商名</td>
<td width="120" height="26" align="center">地址</td>
<td width="160" height="26" align="center">联系方式</td>
<td width="120" height="26" align="center">出入账</td>
<td width="120" height="26" align="center">email</td>
<td width="120" height="26" align="center">操作</td>
</tr>


<c:forEach items="${provPage.list }" var="provider">
<tr>
<td height="26" align="center">${provider.provider_name}</td>
<td height="26" align="center">${provider.provider_add}</td>
<td height="26" align="center">${provider.provider_tel}</td>
<td height="26" align="center">${provider.account}</td>
<td height="26" align="center">${provider.email}</td>
<td height="40" align="center" width="100"><a href="${pageContext.request.contextPath}/Admin/providers/provServlet?p=dodel&id=${provider.providerID}" onclick="return confirm('是否删除？');">删除</a>&nbsp/&nbsp<a href="${pageContext.request.contextPath}/Admin/providers/provServlet?p=doup2&id=${provider.providerID}">修改</a></td>

</tr>

</c:forEach>
<tr>
<td colspan="8" align="center">
<c:if test="${provPage.currentPage==provPage.firstPage}">
<a>已是首页</a>
</c:if>
<c:if test="${provPage.currentPage!=provPage.firstPage}">
<a href="${pageContext.request.contextPath}/Admin/providers/provServlet?p=doma&currentPage=${provPage.firstPage}&PageSize=10">首页</a>&nbsp&nbsp&nbsp&nbsp
</c:if>
<c:if test="${provPage.currentPage==provPage.firstPage}">
<a>上一页</a>
</c:if>
<c:if test="${provPage.currentPage!=provPage.firstPage}">
<a href="${pageContext.request.contextPath}/Admin/providers/provServlet?p=doma&currentPage=${provPage.upPage}&PageSize=10">上一页</a>&nbsp&nbsp&nbsp&nbsp
</c:if>
共${provPage.totalPage}页&nbsp&nbsp&nbsp&nbsp
	第${provPage.currentPage}页&nbsp&nbsp&nbsp&nbsp
<c:if test="${provPage.currentPage==provPage.totalPage}">
<a>下一页</a>
</c:if>
<c:if test="${provPage.currentPage!=provPage.totalPage}">
<a href="${pageContext.request.contextPath}/Admin/providers/provServlet?p=doma&currentPage=${provPage.downPage}&PageSize=10">下一页</a>&nbsp&nbsp&nbsp&nbsp
</c:if>
<c:if test="${provPage.currentPage!=provPage.totalPage}">
<a href="${pageContext.request.contextPath}/Admin/providers/provServlet?p=doma&currentPage=${provPage.totalPage}&PageSize=10">尾页</a>&nbsp&nbsp&nbsp&nbsp
</c:if>
<c:if test="${provPage.currentPage==provPage.totalPage}">
<a>已是尾页</a>
</c:if>

<a href="${pageContext.request.contextPath}/Admin/providers/provideradd.jsp"  target="main1">供应商添加</a>
</td>
</tr>

</table>
</body>
</html>