<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'jQuery.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.1.1.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		var content=$("#mydiv").html();//jQuery对象
		//var content=$(document.getElementById("mydiv")).html();//DOM对象
		$("#yourdiv").html(content);//jQurey对象
		//$("#yourdiv")[0].innerHTML=content;//DOM对象
	});
	

</script>
<script type="text/javascript">

$(document).ready(function(){

	$("#btn1").click(function(){
	$("p").append("<b>Appende text</b>");
	
	});
	$("#btn2").click(function(){
		$("ol").append("<li>Appended item</li>");
	});
	

});



</script>
<script type="text/javascript">




</script>
  </head>
  
  <body>
   <div id="mydiv">
   <h1>sdfghj</h1>
   </div>
   <div id="yourdiv">
   </div>
   <p> this is a paragraph.</p>
   <p> This is another paragraph.</p>
   <ol>
   <li>List item 1</li>
   <li>List item 2</li>
   <li> List item 3</li>
   </ol>
   <button id="btn1">追加文本</button>
   <button id="btn2">追加列表项</button>
  </body>
</html>
