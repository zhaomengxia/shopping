
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>"> 
    
    <title>My JSP 'showProduct.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="css/main.css">
	

  </head>
  <!-- 要使用eadyUi要先导js.  这些js可以从easyUi的demo里可以找到 -->
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/javascript/easyUi/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/javascript/easyUi/themes/icon.css">
	<script type="text/javascript" src="javascript/easyUi/jquery.min.js" ></script>
	<script type="text/javascript" src="javascript/easyUi/jquery.easyui.min.js" ></script>
	<script type="text/javascript" src="javascript/easyUi/locale/easyui-lang-zh_CN.js" ></script>
	
	  <!--  <tr>
    	<td>产品名称</td><td>产品进价</td><td>供应商ID</td><td>产品数量</td><td>产品售价</td><td>产品目录</td><td>进货时间</td><td>产品操作</td>
    </tr> -->
	<script type="text/javascript">
	$(document).ready(function(){
		//---用ajax得到供应商和目录的数据
				$.ajax({
					url : "admin/products/productServlet",
					type : "post",
					data : "op=getBorth",
					success : function(msg) {
						//--把servlet里传过来的文本值转成json对象-eval里的写法是固定格式---
						var jsonArr = eval("(" + msg + ")");
						//alert(jsonArr); 在servlet里是以数组形式转过来的。
						
						for ( var i = 0; i < jsonArr[0].length; i++) {
							$("#providerID").append(
									"<option value="+jsonArr[0][i].providerID+">"
											+ jsonArr[0][i].provider_name
											+ "</option>");
						}
						
						for ( var i = 0; i < jsonArr[1].length; i++) {
							$("#categoryID").append(
									"<option value="+jsonArr[1][i].categoryID+">"
											+ jsonArr[1][i].category_name
											+ "</option>");
						}
					}
				});
	
	
		$("#product").datagrid({
	    	url:'admin/products/productServlet?op=doShowProduct',
	    	rownumbers:true,
	    	pagination:true,
	    	pageSize:5,
	    	pageList:[5,10,15,20,25,30],
	    	method:'get',
	    	
	    	columns:[[
				{field:'product_name',title:'产品名',width:100},
				{field:'income_price',title:'产品进价',width:100},
				{field:'provider',title:'供应商',width:100,
					formatter: function(value,row,index){
						return value.provider_name;
					}
				},
				{field:'quantity',title:'产品数量',width:100},
				{field:'sales_price',title:'产品售价',width:100},
				{field:'category.category_name',title:'产品目录',width:100,
					formatter: function(value,row,index){
						return row.category.category_name;
					}
				},
				{field:'income_time',title:'进货时间',width:100},
				
				{field:'productID',title:'操作产品',width:100,
					formatter: function(value,row,index){
						return "<a><img src='javascript/easyUi/themes/icons/pencil.png' onClick='editProduct("+value+")' /></a>"+
								"&nbsp;"+
							   "<a><img src='javascript/easyUi/themes/icons/cancel.png' onClick='delProduct("+value+")' /></a>";
					}
				
				}
	    	]]
		});
		//---按搜索时的动作-----
		$("#searchP").click(function(){
			$('#product').datagrid('load', {
			   product_name: $("#product_name").val(),
			   providerID: $("#providerID").val(),
			   categoryID: $("#categoryID").val()
			   
			});
	});
		
		
		
		
	});
	
	function editProduct(id){
		$("#editProduct").dialog({
			title:'产品修改',
			width:600,
			height:300,
			href:'admin/products/productServlet?op=editProduct&productID='+id,
			modal:true,
			buttons:[{
				text:'确定修改',
				handler:function(){
					$("#editProduct").find("#myForm").submit();
				}
			},{
				text:'取消修改',
				handler:function(){
					$("#editProduct").dialog("close");
				}
			}]
			
			
		});
	}
	
	function delProduct(id){
	
		
	}
	
	
	
	
	</script>
  <body class="maincolor">
  	<form id="myform" action="admin/products/ProductServlet">

		产品名称：<input type="text" id="product_name" name="product_name" placeholder="请输入产品名称" />
		供应商名：<select id="providerID" name="providerID">
			<option value="0">选择供应商</option>
		</select> 目录名称：<select id="categoryID" name="categoryID">
			<option value="0">选择产品目录</option>
			
		</select> <input id="searchP" type="button" value="搜索产品" />
		
	</form>
    <table id="product" border="1px solid" cellpadding="0px" cellspacing="0px" >
    </table>
    
    <div id="editProduct"></div>
 
  
  </body>
  
  
  
</html>











