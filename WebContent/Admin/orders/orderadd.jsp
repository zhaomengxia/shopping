<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-3.1.1.js"></script>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'products.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/css/jquery.dataTables.css">

<!-- jQuery -->
<script type="text/javascript" charset="utf8"
	src="${pageContext.request.contextPath }/js/jquery-1.4.min.js"></script>

<!-- DataTables -->
<script type="text/javascript" charset="utf8"
	src="${pageContext.request.contextPath }/js/jquery.dataTables.js"></script>


<!--或者下载到本地，下面有下载地址-->
<!-- DataTables CSS -->
<link rel="stylesheet" type="text/css"
	href="DataTables-1.10.15/media/css/jquery.dataTables.css">

<!-- jQuery -->
<script type="text/javascript" charset="utf8" src="DataTables-1.10.15/media/js/jquery.js"></script>

<!-- DataTables -->
<script type="text/javascript" charset="utf8" src="DataTables-1.10.15/media/js/jquery.dataTables.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/javascript/My97DatePicker/WdatePicker.js"></script>
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

	function selAll1() {
		var cds = document.getElementsByName("nn1");
		for (var i = 0; i < cds.length; i++) {
			//全选
			cds[i].checked = document.getElementById("m1").checked;
		/* //反选
		cds[i].checked=!cds[i].checked; */
		}
	}
	
	
	
	
	
	function save(){
	alert("dfg");
	var arr = document.getElementsByName("quantity");
	var bao=document.getElementById("bao");
	alert(bao.value);
				alert(arr);
				var f = false;
				for (var i = 0; i < arr.length; i++) {
					for (var j = i + 1; j < arr.length; j++) {
						if (arr[i].value == arr[j].value) {
							f = true;
							break;

						}


					}

				}
				if (f) {
					alert("有重复，或空值");


				} else {

					alert("---可以添加---");
				}
	
	
	}
	<!--第三步：初始化Datatables-->
	$(document).ready(function() {
		$('#table_id_example').DataTable({
			language : {
				url : '${pageContext.request.contextPath}/json/chinese.json'
			},
			searching : false,
			ordering : false,
			paging : true,
			serverSide : true,
			ajax : {
				url : '${pageContext.request.contextPath}/Admin/products/proServlet',
				type : 'POST',
				dataSrc : 'p=searchProduct1&currentPage=1&PageSize=10'
			},
			columns : [
				{
					data : '${p.product_name}'
				},
				{
					data : '${p.income_price}'
				},
				{
					data : '${p.providerID}'
				},
				{
					data : '${p.quantity}'
				},
				{
					data : '${sales_price}'
				},
				{
					data : '${categoryID}'
				},


				{
					data : '${incme_time}'
				},

			]
		});
	});
	function addRow1() {
		var order11 = document.getElementById("order");
		var newrow = document.createElement("tr");
		
		newrow.innerHTML = "<tr id='order1'><td align='center'><select name='products' id='products'><option value='0'>请选择产品：</option>   <c:forEach items='${products}' var='product'> <option value='${product.productID}' id='product_name'>${product.product_name}</option> </c:forEach></select></td><td align='center'><input  name='quantity' type='number' id='quantity'/></td><td align='center'><input type='checkbox' name='discount' value='1' id='discount'/>是<input type='checkbox' value='0' name='discount' id='discount1'/>否</td><td align='center'><input name='de1'  type='button'  value='删除'  onclick='delerow(this)'/></td></tr>";
		order11.appendChild(newrow);
	}
	function delerow(obj) {
		var orders = document.getElementById("order");
		var oldtr = obj.parentNode.parentNode;
		var i = oldtr.rowIndex;
		if (orders.rows.length > 2) {
			orders.deleteRow(i);

		}

	}
	function editrow(obj) {
		if (obj.value == "确定") {
			var oldtr = obj.parentNode.parentNode;
			var arr = oldtr.cells;
			for (var i = 0; i < arr.length - 1; i++) {

				arr[i].innerHTML = arr[i].firstElementChild.value;

			}
			obj.value = "修改";

		} else if (obj.value == "修改") {
			var oldtr = obj.parentNode.parentNode;
			var arr = oldtr.cells;

			for (var i = 0; i < arr.length - 1; i++) {

				//arr[i].innerHTML="<tr id='order1'><td><input type='text' name='ordate' readonly='readonly' value='"+arr[i].innerHTML+"'/></td></tr>"

				arr[i].innerHTML = "<td><input type='text' value='" + arr[i].innerHTML + "'/></td>";


			}

			obj.value = "确定";

		}



	}

	$(document).click(function(e) {
		var $obj = $(e.target);
		if ($obj.val() == "1") {
			var arr = $obj.parent().children();
			for (var i = 0; i < arr.length; i++) {
				if (arr[i].value == 1) {
					arr[i].checked = true;
				} else {
					arr[i].checked = false;
				}
			}

		} else if ($obj.val() == "0") {

			var arr = $obj.parent().children();
			for (var i = 0; i < arr.length; i++) {

				if (arr[i].value == 0) {

					arr[i].checked = true;
				} else {

					arr[i].checked = false;
				}

			}
			}

			else if($obj.text().val()=="保存订单"){
			alert("pppp");
				var arr = document.getElementsByName("quantity");
				alert(arr);
				var f = false;
				for (var i = 0; i < arr.length; i++) {
					for (var j = i + 1; j < arr.length; j++) {
						if (arr[i].value == arr[j].value) {
							f = true;
							break;

						}


					}

				}
				if (f) {
					alert("有重复，或空值");


				} else {

					alert("---可以添加---");
				}



}
		
	});
	
	
	
	
	
			$("#bao").click(function() {
			alert(pppp);
				var arr = document.getElementsByName("quantity");
				alert(arr);
				var f = false;
				for (var i = 0; i < arr.length; i++) {
					for (var j = i + 1; j < arr.length; j++) {
						if (arr[i].value == arr[j].value) {
							f = true;
							break;

						}


					}

				}
				if (f) {
					alert("有重复，或空值");


				} else {

					alert("---可以添加---");
				}
			});
			
			
 	
			
 function checklogin() {
	
		var arr1 = document.getElementsByName("products");
			var f = false;
			for (var i = 0; i < arr1.length; i++) {
					for (var j = i + 1; j < arr1.length; j++) {
				
						if (arr1[i].value == arr1[j].value) {
							f = true;
							break;

						}


					}

				}
				if (f) {
					alert("有重复，或空值");
					return false;

				} else {

					alert("---可以添加---");
					
				}

		
		
		return true;
	}
 
 
			var passF=null;
			function checkprice(obj,i){
				
				var incomeError1=obj.value;
				passF=checkAll(incomeError1,i);
				if(passF){
				alert("输入合法");
				}else{
					alert("输入不合法");
					
				}
				
			}
				function checkAll(namee,i){
					var arr=[	
					/^\w/,
					/^\d$/,
					/^\w+@[0-9|A-Z|a-z]+\.[A-Z|a-z]{2,3}$/,
					/^[(135|178|187|152|156|181|153|184|159){1}]+[0-9]{8}$/
					];
					return arr[i].test(namee);	
				}
				
		
</script>
</head>

<body style="background-color:silver;">
	
	<!--第二步：添加如下 HTML 代码-->

<h2>下单</h2>
	<form action="${pageContext.request.contextPath}/Admin/orders/OrderTwoServlet?p=doadds1" method="post">
		<table border="1" cellpadding="0" cellspacing="0" id="order" width="600px" align="center" style="background-color: fuchsia;">
		
			<a style="margin-left: 160px; color: black;">订单编号:
			<input type="text" name="orderID" value="${orders.orderID}"  id=""/></a>&nbsp;&nbsp;&nbsp;
			&nbsp;&nbsp;&nbsp;下单日期：
			<input type="order_date" name="order_date" id="order_date" class="Wdate" onclick="WdatePicker()" value="${orders.order_date }" />&nbsp;&nbsp;&nbsp;
			<select name="customers" id="customers">
				<option value="0">请选择客户</option>
				<c:forEach items="${customers}" var="cust">
				<c:if test="${orders.customers.customerID==cust.customerID}">
					<option value="${cust.customerID}" id="customer_name" selected>${cust.customer_name}</option>
					</c:if>
					<c:if test="${orders.customers.customerID!=cust.customerID}">
					<option value="${cust.customerID}" id="customer_name">${cust.customer_name}</option>
					</c:if>
				</c:forEach>
			</select>
			<select name="employees">
				<option value="0">请选择业务员：</option>
				<c:forEach items="${employees}" var="employ">
				<c:if test="${orders.employ.empID==employ.empID}">
					<option value="${employ.empID}" id="emp_name" selected>${employ.emp_name}</option>
					</c:if>
					<c:if test="${orders.employ.empID!=employ.empID}">
					<option value="${employ.empID}" id="emp_name">${employ.emp_name}</option>
					</c:if>
					
				</c:forEach>
			</select>
			<tr>
				<td width="60px" height="30px" align="center">产品名称：</td>
				<td width="40px" height="30px" align="center">订购数量</td>
				<td width="80px" height="30px" align="center">是否折扣</td>
				<td width="40px" height="30px" align="center">操作</td>
			</tr>
			<tr id="order1">
				<td width="35px" height="30px" align="center"><select name="products" id="products" >
						<option value="0">请选择产品：</option>
						<c:forEach items="${products}" var="product">
							<option value="${product.productID}" id="product_name">${product.product_name}</option>
						</c:forEach>
				</select></td>
				<td width="40px" height="30px" align="center"><input type="number" name="quantity" id="quantity" onblur="checkprice(this,1)" /></td>
		
				<br/>
				<td width="30px" height="30px" align="center"><input type="checkbox" name="discount" value="1"  id="discount"/>是
				<input type="checkbox" name="discount" value="0" width="30px" height="30px" align="center" id="discount1"/>否</td>
				<td width="30px" height="30px" align="center">
				<input name="de1" type="button" value="删除" onclick="delerow(this)"  /> 
				<!-- <input name="ed1" type="button" value="确定" onclick="editrow(this)" style="width: 45%;" /></td> -->
			</tr>
		</table>
		<table align="center">
			<input name="add" type="button" value="添加订单" onclick="addRow1()" style="margin-left: 420px"/>&nbsp;&nbsp;&nbsp;
			
			<input name="save" type="submit" id="bao" value="提交订单"  onclick="return  checklogin()"/>
			
		</table>

	</form>
<p style="color: black;"><a href="${pageContext.request.contextPath}/Admin/orders/OrderTwoServlet?p=doma1&currentPage=1&PageSize=10">订单详情</a></p>
</body>
</html>


