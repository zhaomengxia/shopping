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
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.1.1.js"></script>
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
<body style="background-color: teal;">
	<h1>产品类别管理</h1>
	
	<form action="${pageContext.request.contextPath}/Admin/categorys/cateDo?p=search&currentPage=1&PageSize=10" method="post">
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<a style="margin-left: 40px" >请输入类名：</a><input style="margin-left: 20px" type="text" name="category_name" value="${cates.category_name}"/>
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
		
	<a href="${pageContext.request.contextPath}/Admin/categorys/productmanager.jsp">根据类别搜索产品</a>
		
	<table width="600" border="1" align="center" cellpadding="0" cellspacing="0">
		<tr>
			<!-- <td width="108" height="26" align="center">全选<input id="m"
				name="cate" type="checkbox" onclick="selAll()" /></td> -->
			<td width="120" height="26" align="center">产品类别名称</td>
			<td width="120" height="26" align="center">产品类别描述</td>
			<td width="160" height="26" align="center">产品类别操作</td>
		</tr>
		<c:forEach items="${proPage.list }" var="cate">
		
			<tr>
			
			<td height="30" align="center">${cate.category_name}</td>

			<td height="30" align="center">${cate.category_desc}</td>
			<td height="30" align="center">
			<a href="${pageContext.request.contextPath}/Admin/categorys/cateDo?p=del&idd=${cate.categoryID}"onclick="return confirm('是否删除？');">删除</a>
				<a href="${pageContext.request.contextPath}/Admin/categorys/cateDo?p=doupss&idd=${cate.categoryID}">修改</a></td>

		</tr>
		
		</c:forEach>
		<tr>
		<td colspan="8" align="center">
		<c:if test="${proPage.currentPage==1 }">
		<a>已是首页</a>
		</c:if>
		<c:if test="${proPage.currentPage!=1 }">
		<a href="${pageContext.request.contextPath}/Admin/categorys/cateDo?p=doma&currentPage=1&PageSize=10">首页</a>&nbsp&nbsp&nbsp&nbsp
		</c:if>
		<c:if test="${proPage.currentPage==1}">
		<a>上一页</a>&nbsp&nbsp&nbsp&nbsp
		</c:if>
		<c:if test="${proPage.currentPage!=1}">
		<a href="${pageContext.request.contextPath}/Admin/categorys/cateDo?p=doma&currentPage=${proPage.upPage}&PageSize=10">上一页</a>	&nbsp&nbsp&nbsp&nbsp
		</c:if>
		
		共${proPage.totalPage}页 &nbsp&nbsp&nbsp&nbsp
		第${proPage.nowPage}页&nbsp&nbsp&nbsp&nbsp
		
		<c:if test="${proPage.currentPage==proPage.totalPage}">
		
		<a>下一页</a>
		
		</c:if>
		<c:if test="${proPage.currentPage!=proPage.totalPage}">
		
			<a  href="${pageContext.request.contextPath}/Admin/categorys/cateDo?p=doma&currentPage=${proPage.downPage}&PageSize=10">下一页</a>&nbsp&nbsp&nbsp&nbsp
		
		</c:if>
		<c:if test="${proPage.currentPage!=proPage.totalPage}">
	<a  href="${pageContext.request.contextPath}/Admin/categorys/cateDo?p=doma&currentPage=${proPage.totalPage}&PageSize=10">尾页</a>&nbsp&nbsp&nbsp&nbsp
	</c:if>
	<c:if test="${proPage.currentPage==proPage.totalPage}">
	<a>已是尾页</a>
	</c:if>
		<a href="categoryadd.jsp?" target="main1">产品类别添加</a>	
		&nbsp;&nbsp;&nbsp;&nbsp;
	<a href="${pageContext.request.contextPath}/Admin/categorys/cateDo?p=exportOrder">导出</a> 
		</td>	
		</tr>
	</table>
	</form>
	
</body>
</html>