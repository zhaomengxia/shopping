
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
<style type="text/css">
h1{
	color: maroon;
	margin-left: 150px;
}
</style>


</head>
<body style="background-color: activecaption;">
<h1>员工管理</h1>

<table width="800" border="1" align="center" cellpadding="0" cellspacing="0" style="background-color: silver;">
<tr>
<!-- <td width="108" height="26" align="center">全选<input id="m" name="cate" type="checkbox" onclick="selAll()"/></td> -->
<td width="100" height="26" align="center">姓名</td>
<td width="100" height="26" align="center">入职日期</td>
<td width="100" height="26" align="center">工资</td>
<td width="100" height="26" align="center">密码</td>
<td width="100" height="26" align="center">联系方式</td>
<td width="100" height="26" align="center">兴趣</td>
<td width="120" height="26" align="center">地址</td>
<td width="70" height="26" align="center">性别</td>
<td width="120" height="26" align="center">操作</td>
</tr>


<c:forEach items="${provPage.list }" var="employ">
<tr>
<td height="20" align="center">${employ.emp_name}</td>
<td height="20" align="center">${employ.hire_date}</td>
<td height="20" align="center">${employ.salary}</td>
<td height="20" align="center">${employ.password}</td>
<td height="20" align="center">${employ.phone}</td>
<td height="20" align="center">${employ.interest}</td>
<td height="20" align="center">${employ.address}</td>
<td height="20" align="center">${employ.gender}</td>
<td height="45" align="center" width="100"><a href="${pageContext.request.contextPath}/Admin/employees/employServlet?p=dodel&id=${employ.empID}" onclick="return confirm('是否删除？');">删除</a>&nbsp/&nbsp<a href="${pageContext.request.contextPath}/Admin/employees/employServlet?p=doup2&id=${employ.empID}">修改</a></td>

</tr>

</c:forEach>
<tr>
<td colspan="8" align="center">
<c:if test="${provPage.currentPage==provPage.firstPage}">
<a>已是首页</a>
</c:if>
<c:if test="${provPage.currentPage!=provPage.firstPage}">
<a href="${pageContext.request.contextPath}/Admin/employees/employServlet?p=doma&currentPage=${provPage.firstPage}&PageSize=10">首页</a>&nbsp&nbsp&nbsp&nbsp
</c:if>
<c:if test="${provPage.currentPage==provPage.firstPage}">
<a>上一页</a>
</c:if>
<c:if test="${provPage.currentPage!=provPage.firstPage}">
<a href="${pageContext.request.contextPath}/Admin/employees/employServlet?p=doma&currentPage=${provPage.upPage}&PageSize=10">上一页</a>&nbsp&nbsp&nbsp&nbsp
</c:if>
共${provPage.totalPage}页&nbsp&nbsp&nbsp&nbsp
	第${provPage.currentPage}页&nbsp&nbsp&nbsp&nbsp
<c:if test="${provPage.currentPage==provPage.totalPage}">
<a>下一页</a>
</c:if>
<c:if test="${provPage.currentPage!=provPage.totalPage}">
<a href="${pageContext.request.contextPath}/Admin/employees/employServlet?p=doma&currentPage=${provPage.downPage}&PageSize=10">下一页</a>&nbsp&nbsp&nbsp&nbsp
</c:if>
<c:if test="${provPage.currentPage!=provPage.totalPage}">
<a href="${pageContext.request.contextPath}/Admin/employees/employServlet?p=doma&currentPage=${provPage.totalPage}&PageSize=10">尾页</a>&nbsp&nbsp&nbsp&nbsp
</c:if>
<c:if test="${provPage.currentPage==provPage.totalPage}">
<a>已是尾页</a>
</c:if>

<a href="${pageContext.request.contextPath}/Admin/employees/employadd.jsp"  target="main1">添加员工</a>
</td>
</tr>

</table>
</body>
</html>