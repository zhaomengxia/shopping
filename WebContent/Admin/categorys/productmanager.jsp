
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
	
	var xmlHttpRequest;
	function getXMLHttpRequest(){
		if(window.XMLHttpRequest){
			return new XMLHttpRequest();
		}else{
			var names = ["msxml","msxml2","msxml3","Microsoft"];
			for(var i=0; i< names.length; i++){
				try{
					var name = names[i]+".XMLHTTP";
					return new ActiveXObject(name);
				}catch(e){
				}
			}
		}
		return null;
	}
	function getone(){
	xmlHttpRequest=getXMLHttpRequest();

	}
function getProductBycateId(){
	document.getElementById("productID").length=1; 
	xmlHttpRequest=getXMLHttpRequest();
	var pname=document.getElementById("category_name").value;

	xmlHttpRequest.open('get',"${pageContext.request.contextPath}/Admin/categorys/cateDo?p=getProduct&cid="+pname,true);
	if(pname!="0"){
	xmlHttpRequest.onreadystatechange = function(){
	if(xmlHttpRequest.readyState==4&&xmlHttpRequest.status==200){
	var cateid=document.getElementById("productID");
	
	var msg=xmlHttpRequest.responseText;
	
	var json=JSON.parse(msg);
	var jsons=json.length;
	alert(jsons);
	for(var i=0;i<json.length;i++){
	
	cateid.add(new Option(json[i].product_name,json[i].productID));
	}
	}

}
//这个时候，才是真正的提交
	xmlHttpRequest.send(null); 
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
			a{
				color: fuchsia;
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
			h1{
				color: maroon;
				margin-left: 150px;
			}
		</style>


</head>
<body style="background-color: activecaption;">
	<h1>产品类别管理</h1>
	<form action="${pageContext.request.contextPath}/Admin/categorys/cateDo?p=search1&currentPage=1&PageSize=10" method="post">
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<%-- <input type="text" name="category_name" value="${cates.category_name}"/><a>类名：</a> --%>
	<select id="category_name" name="category" onchange="getProductBycateId()">
	<option value="0">请选择类名：</option>
	<c:forEach items="${categorys}" var="ca">
	<c:if test="${cates.categoryID==ca.categoryID}">
	<option value="${ca.categoryID}" selected>${ca.category_name}</option>
	</c:if>
	<c:if test="${cates.categoryID!=ca.categoryID}">
	<option value="${ca.categoryID}" >${ca.category_name}</option>
	</c:if>
	</c:forEach>
	</select>
	<select name="products" id="productID"  >
		<option value="0">请选择：</option>
		</select>
	<input type="submit" value="搜索">
	
		<table width="900" border="1" align="center" cellpadding="0" cellspacing="0">
			<tr>
				<td width="60" height="26" align="center">全选<input id="m"
					name="cate" type="checkbox" onclick="selAll()" /></td>
				<td height="30" width="180" align="center">名称</td>
				<td height="30" width="180" align="center">进价</td>
				<td height="30" width="180" align="center">供应商</td>
				<td height="30" width="180" align="center">产品数量</td>
				<td height="30" width="180" align="center">产品售价</td>
				<td height="30" width="180" align="center">类别</td>
				<td height="30" width="360" align="center">进货时间</td>
				<td height="30" width="360" align="center">操作</td>

			</tr>

			<c:forEach items="${proPage.list}" var="product">
				<tr>
					<td width="100" align="center"><input name="nn" type="checkbox" value="${product.productID}"></td>
					<td height="30" width="130" align="center">${product.product_name}</td>
					<td height="30" width="130" align="center">${product.income_price}</td>
					<td height="30" width="130" align="center">${product.provider.provider_name }</td>
					<td height="30" width="130" align="center">${product.quantity}</td>
					<td height="30" width="130" align="center">${product.sales_price}</td>
					<td height="30" width="130" align="center">${product.category.category_name}</td>
					<td height="30" width="280" align="center">${product.income_time}</td>

					<td align="center" height="30" width="280"><a
						href="${pageContext.request.contextPath}/Admin/products/proServlet?p=dodel&id=${product.productID }"
						onclick="return confirm('是否删除？');">删除</a>&nbsp;&nbsp;<a
						href="${pageContext.request.contextPath}/Admin/products/proServlet?p=doup2&id=${product.productID}">修改</a></td>



				</tr>

			</c:forEach>

			<tr>
				<td colspan="8" align="center">
				<c:if test="${proPage.currentPage==proPage.firstPage}">
				<a>已是首页</a>
				</c:if> 
				<c:if test="${proPage.currentPage!=proPage.firstPage}">
				<a href="${pageContext.request.contextPath}/Admin/products/proServlet?p=doma&currentPage=${proPage.firstPage}&PageSize=10&product_name=${p.product_name}&provider=${p.providerID}&category=${p.categoryID}">首页</a>&nbsp&nbsp&nbsp&nbsp
				</c:if> 
		<c:if test="${proPage.currentPage==proPage.firstPage}">
						<a>上一页</a>
		</c:if> 
		<c:if test="${proPage.currentPage!=proPage.firstPage }">
		<a href="${pageContext.request.contextPath}/Admin/products/proServlet?p=doma&currentPage=${proPage.upPage}&PageSize=10&product_name=${p.product_name}&provider=${p.providerID}&category=${p.categoryID}">上一页</a>&nbsp&nbsp&nbsp&nbsp
		
		</c:if> 共${proPage.totalPage}页 &nbsp&nbsp&nbsp&nbsp
		第${proPage.currentPage}页&nbsp&nbsp&nbsp&nbsp <c:if
		test="${proPage.currentPage==proPage.totalPage}">
		<a>下一页</a>
		</c:if> 
		<c:if test="${proPage.currentPage!=proPage.totalPage}">
		<a href="${pageContext.request.contextPath}/Admin/products/proServlet?p=doma&currentPage=${proPage.downPage}&PageSize=10&product_name=${p.product_name}&provider=${p.providerID}&category=${p.categoryID}">下一页</a>&nbsp&nbsp&nbsp&nbsp
		</c:if> &nbsp&nbsp&nbsp&nbsp
		<c:if test="${proPage.currentPage!=proPage.totalPage}">
		<a href="${pageContext.request.contextPath}/Admin/products/proServlet?p=doma&currentPage=${proPage.totalPage}&PageSize=10&product_name=${p.product_name}&provider=${p.providerID}&category=${p.categoryID}">尾页</a>&nbsp&nbsp&nbsp&nbsp
		</c:if> &nbsp&nbsp&nbsp&nbsp
		<c:if test="${proPage.currentPage==proPage.totalPage}">
		<a>尾页</a>
		</c:if> &nbsp&nbsp&nbsp&nbsp
		<input id="del" name="cate" type="submit" value="删除多条" onclick="return confirm('是否删除？')" />
					&nbsp&nbsp&nbsp&nbsp
	<%-- 	<a href="${pageContext.request.contextPath}/Admin/products/proServlet?p=doadd2" target="main1">产品添加</a> --%>
				</td>
			</tr>
		</table>
	</form>
	
</body>
</html>