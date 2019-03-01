<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'MyJsp.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/javascript/easyUi/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/javascript/easyUi/themes/icon.css">
<script type="text/javascript" src="${pageContext.request.contextPath }/javascript/easyUi/jquery.min.js" ></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/javascript/easyUi/jquery.easyui.min.js" ></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/javascript/easyUi/locale/easyui-lang-zh_CN.js" ></script>
<script type="text/javascript">
$(document).ready(function(){
			$("#product").datagrid({
   				 url:'${pageContext.request.contextPath}/Admin/products/proServlet?p=doma',
 				 columns:[[
					{field:'product_name',title:'产品名',width:100},
					{field:'income_price',title:'产品进价',width:100},
					{field:'provider',title:'供应商',width:100,
						formatter: function(value,row,index){
							return value.provider_name;
						}
					},
					{field:'quantity',title:'数量',width:100},
					{field:'sales_price',title:'产品售价',width:100},
					{field:'category',title:'产品目录',width:100,
						formatter: function(value,row,index){
							return value.category_name;
						}
					},
					
					{field:'income_time',title:'进货时间',width:100},
					//{field:'price',title:'产品操作',width:100},
   				]]
			});
		});

</script>
</head>
<body>

		<table id="product">
		</table>
</body>
</html>
