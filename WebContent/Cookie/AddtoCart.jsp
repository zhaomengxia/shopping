<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'AddtoCart.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">
input{
width:40px;
}
</style>
<script type="text/javascript">
function selAll(){
	var cds=document.getElementsByName("bookname");
	for(var i=0;i<cds.length;i++){
		//全选
	cds[i].checked=document.getElementById("m").checked;
		/* //反选
		cds[i].checked=!cds[i].checked; */
	}
}
</script>
  </head>
  
  <body>
  <input type="checkbox" id="m" onclick="selAll()">全选
  <form action="Cookie/buy.jsp">
  <table>
  
  <input type="checkbox" name="bookname"   value="aaa"/>aaa<br/>
   <input type="checkbox" name="bookname"  value="bbb"/>bbb<br/>
    <input type="checkbox" name="bookname"  value="ccc"/>ccc<br/>
     <input type="checkbox" name="bookname"  value="ddd" />ddd<br/>
     <input type="checkbox" name="bookname"  value="eee"/>eee<br/>
     <input type="submit"/>
     <input type="reset"/>
      </table>
      </form>
  
  </body>
</html>
