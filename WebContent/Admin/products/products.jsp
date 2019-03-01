<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/jquery.dataTables.css">
 
<!-- jQuery -->
<script type="text/javascript" charset="utf8" src="${pageContext.request.contextPath }/js/jquery-1.4.min.js"></script>
 
<!-- DataTables -->
<script type="text/javascript" charset="utf8" src="${pageContext.request.contextPath }/js/jquery.dataTables.js"></script>
 
 
<!--或者下载到本地，下面有下载地址-->
<!-- DataTables CSS -->
<link rel="stylesheet" type="text/css" href="DataTables-1.10.15/media/css/jquery.dataTables.css">
 
<!-- jQuery -->
<script type="text/javascript" charset="utf8" src="DataTables-1.10.15/media/js/jquery.js"></script>
 
<!-- DataTables -->
<script type="text/javascript" charset="utf8" src="DataTables-1.10.15/media/js/jquery.dataTables.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/javascript/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript">



<!--第三步：初始化Datatables-->
$(document).ready( function () {
    $('#table_id_example').DataTable({
    language: {
        url: '${pageContext.request.contextPath}/json/chinese.json'
    },
    searching: false,
    ordering:  false,
    paging:true,
     serverSide: true,
      ajax: {
        url: '${pageContext.request.contextPath}/Admin/products/proServlet?p=searchProduct1&currentPage=1&PageSize=10',
        type: 'POST',
        dataSrc:'data'
    },
    columns:[
    {data:'${p.product_name}'},
     {data:'${p.income_price}'},
      {data:'${p.providerID}'},
       {data:'${p.quantity}'},
        {data:'${sales_price}'},
         {data:'${categoryID}'},
         
         
    {data:'${incme_time}'},
    
    ]
    
    
    
    
});
});
</script>
  </head>
  
  <body>
 <!--第二步：添加如下 HTML 代码-->
	
	 <form action="${pageContext.request.contextPath}/Admin/orders/OrderTwoServlet?p=doma" method="post">
订单编号<input type="text" name="product_name" value="${orders.orderID}"/>&nbsp;&nbsp;&nbsp;
	下单日期：<input type="text"  class="Wdate" onclick="WdatePicker()"/>&nbsp;&nbsp;&nbsp;
<select name="customers">
	<option value="0">请选择客户</option>
   <c:forEach items="${customers}" var="customers">
  
   <option value="${customers.customerID}">${customers.customer_name}</option>
  
   </c:forEach>
  
		</select>
	<select name="employees">
   <option value="0">请选择业务员：</option>
   <c:forEach items="${employees}" var="employees">
   <option value="${employees.empID }">${employees.emp_name}</option>
   </c:forEach>
   
   </select>
	<input type="submit" value="搜索"/>
	</form>


<table border="1" cellpadding="0" cellspacing="0" id="order" width="600px">
		
    
     <tr>
       <td width="40px">产品名称： </td>
            <td width="40px">订购数量</td>
            <td>是否折扣</td>
             <td width="200px">操作</td>
        </tr>
   
    
			<tr id="order1">
		<td><select name="products">
        <option value="0">请选择产品：</option>    
        </select></td>
				
				<td><input type="text" name="ordate" readonly="readonly"/></td>
				<td><input type="radio"/>是<input type="radio"/>否</td>
				<td>
					<input name="de1"  type="button" value="删除" onclick="delerow(this)" style="width: 45%;"/>
					<input name="ed1"  type="button" value="确定" onclick="editrow(this)" style="width: 45%;"/>
				</td>
			</tr>
			
			
			
		</table>
		<table>
			<input name="add" type="button" value="添加订单" onclick="addRow1()" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<input name="save" type="submit" value="保存订单"/>
		</table>
		

  </body>
</html>


