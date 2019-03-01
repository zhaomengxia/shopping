
<%@page import="com.shopping.dao.Page"%>
<%@page import="com.shopping.entity.Products"%>
<%@page import="com.shopping.serviceimpl.ProductServiceImpl"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
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

<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.1.1.js"></script>
<script type="text/javascript">

 $(document).ready(function(e){
var i=($("table tr").length);

		$("tr:even").css("background-color","aquamarine");
		
		$("tr:odd").css("background-color","#D8D8D8");
}); 

$(document).ready(function(){
	$("#m").click(function(){
		$(":checkbox[name='nn']").prop("checked",$("#m").prop("checked"));
	});
});

</script>
<script type="text/javascript">
function search(){

	$("#p").val("search");
	$("frpro").submit();
}
function delmany(){
	if($(":checkbox[name='nn']:checked").length>0){
		if(confirm("是否删除？")){
			$("#p").val("manydel");
			$("#frpro").submit();
		
		}
	
	}else{
	
	alert("必须选中一个");
	}

}
</script>
</head>
<body style="background-color: teal;">
	<h1>产品管理</h1>
	
	<form id="frpro" action="${pageContext.request.contextPath}/Admin/products/proServlet?p=searchProduct&currentPage=1&PageSize=10" method="post">
 	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input  type="text" name="product_name"  value="${p.product_name }" style="margin-left: 120px"/>
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
		<select name="category">
		<option value="0">请选择目录名：</option>
	
		<c:forEach items="${list2}" var="cate">
		
		  <c:if test="${p.categoryID==cate.categoryID }">
		<option value="${cate.categoryID}" selected>${cate.category_name}</option>
		</c:if>
		<c:if test="${p.categoryID!=cate.categoryID }">
		<option value="${cate.categoryID}">${cate.category_name}</option>
		</c:if>
		</c:forEach>
		
		</select>
	<input type="submit" value="搜索" />
	</form>
	<form action="${pageContext.request.contextPath}/Admin/products/proServlet?p=dodelmany" method="post" enctype="multipart/form-data">
	

		<table width="900" border="1" align="center" cellpadding="0"
			cellspacing="0">
			<tr>
				<td width="60" height="26" align="center">全选<input id="m"
					name="cate" type="checkbox" /></td>
				<td height="30" width="180" align="center">名称</td>
				<td height="30" width="180" align="center">进价</td>
				<td height="30" width="180" align="center">供应商</td>
				<td height="30" width="180" align="center">产品数量</td>
				<td height="30" width="180" align="center">产品售价</td>
				<td height="30" width="180" align="center">类别</td>
				<td height="30" width="360" align="center">进货时间</td>
				<td height="30" width="360" align="center">产品图片</td>
				<td height="30" width="360" align="center">操作</td>

			</tr>

			<c:forEach items="${proPage.list}" var="product">
				<tr>
					<td width="100" align="center"><input name="nn" type="checkbox"  value="${product.productID}"></td>
					<td height="30" width="130" align="center">${product.product_name}</td>
					<td height="30" width="130" align="center">${product.income_price}</td>
					<td height="30" width="130" align="center">${product.provider.provider_name }</td>
					<td height="30" width="130" align="center">${product.quantity}</td>
					<td height="30" width="130" align="center">${product.sales_price}</td>
					<td height="30" width="130" align="center">${product.category.category_name}</td>
					<td height="30" width="280" align="center">${product.income_time}</td>
					<td height="30" width="280" align="center"><img width="80" height="80" src="${pageContext.request.contextPath}/uploadfile/${product.filename}"/></td>

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
		
		</c:if> 共${proPage.totalPage}页 &nbsp;&nbsp;&nbsp;&nbsp;
		第${proPage.currentPage}页&nbsp;&nbsp;&nbsp;&nbsp; <c:if
		test="${proPage.currentPage==proPage.totalPage}">
		<a>下一页</a>
		</c:if> 
		<c:if test="${proPage.currentPage!=proPage.totalPage}">
		<a href="${pageContext.request.contextPath}/Admin/products/proServlet?p=doma&currentPage=${proPage.downPage}&PageSize=10&product_name=${p.product_name}&provider=${p.providerID}&category=${p.categoryID}">下一页</a>&nbsp&nbsp&nbsp&nbsp
		</c:if>
		<c:if test="${proPage.currentPage!=proPage.totalPage}">
		<a href="${pageContext.request.contextPath}/Admin/products/proServlet?p=doma&currentPage=${proPage.totalPage}&PageSize=10&product_name=${p.product_name}&provider=${p.providerID}&category=${p.categoryID}">尾页</a>&nbsp&nbsp&nbsp&nbsp
		</c:if> 
		<c:if test="${proPage.currentPage==proPage.totalPage}">
		<a>尾页</a>
		</c:if> 
		<input id="del" name="cate" type="submit" value="删除多条" onclick="return confirm('是否删除？')" />
					
		<a href="${pageContext.request.contextPath}/Admin/products/proServlet?p=doadd2" target="main1">产品添加</a>
				</td>
			</tr>
		</table>
	</form>
	
</body>
</html>