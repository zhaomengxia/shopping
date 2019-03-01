<%@page import="com.shopping.entity.Categorys"%>
<%@page import="com.shopping.entity.Providers"%>
<%@page import="com.shopping.serviceimpl.ProviderServiceImpl"%>
<%@page import="com.shopping.serviceimpl.CategoryServiceImpl"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/javascript/My97DatePicker/WdatePicker.js"></script>
<style type="text/css">
a {
	width: 40px;
	margin-left: 30px;
}

input {
	margin-left: 60px;
}

body {
	background-color: inactiveborder;
}
h1{
			color: olive;
			margin-left: 150px;
}
</style>
<script type="text/javascript">

	function checkphone(phone1, i) {
		var phonee = document.getElementById("phone1");

		var phone11 = phone1.value;
		phone11 = checkAll(phone11, i);
		if (phone11) {
			phonee.innerHTML = "<font color='#008000'>输入合法</font>";
		} else {
			phonee.innerHTML = "<font color=#FF0000>输入不合法</font>";
		}

	}
	var emails = null;
	function emailF(emaile, i) {
		var emai = document.getElementById("emailError");
		var emails = emaile.value;
		emails = checkAll(emails, i);
		if (emails) {
			emai.innerHTML = "<font color='#008000'>输入合法</font>";
		} else {
			emai.innerHTML = "<font color=#FF0000>输入不合法</font>";

		}


	}
	var nameF = null;
	function checkName(namee, i) {
		var nameError = document.getElementById("nameError");
		var name1 = namee.value;
		nameF = checkAll(name1, i);
		if (nameF) {
			nameError.innerHTML = "<font color='#008000'>输入合法</font>";
		} else {
			nameError.innerHTML = "<font color=#FF0000>输入不合法</font>";

		}

	}


	var passF = null;
	function checkprice(obj, i) {
		var incomeError = document.getElementById("incomeError");
		var incomeError1 = obj.value;
		passF = checkAll(incomeError1, i);
		if (passF) {
			incomeError.innerHTML = "<font color='#008000'>输入合法</font>";
		} else {
			incomeError.innerHTML = "<font color=#FF0000>输入不合法</font>";

		}

	}
	function checkAll(namee, i) {
		var arr = [
			/^[\u4e00-\u9fa5]+$/,
			/^[1-9][0-9]$/,
			/^\w+@[0-9|A-Z|a-z]+\.[A-Z|a-z]{2,3}$/,
			/^[(135|178|187|152|156|181|153|184|159){1}]+[0-9]{8}$/
		];
		return arr[i].test(namee);
	}



function add(){
				var product_name=document.getElementById("product_name").value;
				if(product_name==""){
					alert("您沒输入名字");
					return false;
				}
			
				
				var income_price=document.getElementById("income_price").value;
				if(income_price==""){
					alert("您沒有输入进价");
					return false;
				}
				var quantity=document.getElementById("quantity").value;
				if(quantity==""){
					alert("您没有输入数量")
					return false;
				}
				
			
					return true;
}


$(document).ready(function(){
	 $('#myForm').form({
	    url:"Admin/products/proServlet?p=doadd1",
	    //----这是提交前检测数据用-----
	    onSubmit: function(){
			if($("form:input[name=product_name]").val()==""){
				$.messager.alert(' 警告！','产品名称不能为空！');
				return false;
			}
			return true;
	    },	
	    success:function(data){
			if(data=="修改成功"){
				//---成功后重新加载表格并关闭面板-------
				$('#editProduct').dialog("close");
				//--刷新表格---
				$("#product").datagrid("reload");  
			}else{
				$.messager.alert(' 警告！','产品修改失败！');
			} 
	    }
	});
  });


</script>



</head>
<body style="background-color: activeborder;">
	<h1>产品添加</h1>

	<form id="myForm" name="frmadd" method="post" enctype="multipart/form-data" action="${pageContext.request.contextPath}/Admin/products/proServlet?p=doadd1" >

		
		<a>产品名称：</a><input name="product_name" type="text" id="product_name" onblur="checkName(this,0)" />
		<td><span id="nameError" style="color: red;"></span></td>
		<br /> <br /> <a>产品进价：</a><input name="income_price" type="text" id="income_price" onblur="checkprice(this,1)" />
		<td><span id="incomeError" style="color: red;"></span></td>
		<br /> <br /> <a>供应商：</a> <select  name="providerid" id="provider">
			<option value="0">请选择</option>

			<c:forEach items="${provid}" var="provid">
			<option value="${provid.providerID}">${provid.provider_name}</option>
			</c:forEach>
		</select> <br /> <br /> <a>产品数量：</a><input name="quantity" id="quantity"
			type="text" /><br /> <br /> <a>产品售价：</a><input name="sales_price"
			id="sales_price" type="text" /><br /> <br /> <a

			style="margin-left: 16px">产品类别： </a><select name="category"
			id="category">
			<option value="0">请选择</option>

			<c:forEach items="${categorys}" var="cate">
				<option value="${cate.categoryID}">${cate.category_name}</option>

			</c:forEach>

		</select> <br /> <br /> <a style="margin-left: 5px">产品进货时间：</a>
		<input name="income_time" id="income_time" type="text" class="Wdate" onclick="WdatePicker()" /><br /> <br /> 
				<br /> <br /> <a>产品图片：</a><input name="ppic" type="file"/>
				
				
			<input name="add" type="submit" value="添加" onclick="return add()" /> 
			<input name="set" type="reset" value="重置" />
	</form>



	
</body>
</html>