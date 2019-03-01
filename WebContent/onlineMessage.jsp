<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBliC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>关于我们-淘书吧</title>
<link rel="stylesheet" rev="stylesheet" href="css/global.css" type="text/css" media="all" />

</head>
<body>
	<div id="page">
			<div id="header">
				<jsp:include page="header.jsp" />      
       		</div>
       		<p>
			<font size="3" color="red">欢迎您的光临！</font></p>
			<div id="left_column">
				<jsp:include page="left_column.jsp" />  
			</div>
       		<script>
	function Ok_OnClick(event){
		if(document.getElementsByName("textName")[0].value == ""){
		alert("请输入内容");
		return;
	}//getElementById
	var table;
	var tableList = document.getElementsByTagName("TABLE"); 
	for(var i = 0 ; i < tableList.length ; i++) {
		if(tableList[i].name == "tableName") {
		table = tableList[i]
		break;
		}
	} 
	var value = document.getElementsByName("textName")[0].value;
	var index = table.rows.length;
	table.insertRow(index);
	table.rows(index).insertCell(0);
	table.rows(index).cells(0).innerText = value;
	document.getElementsByName("textName")[0].value = "";
} 
</script>
       		<div id="center_column">
       		<img style="padding-top: 50px;" src="images/msg.jpg" alt="在线评论" />      			
				
			<p align="center" style="padding-top: 50px;">
				<font size="3">欢迎您来评论！</font><br /><br />
				<textarea rows="20" name="textName" id="textId" cols="10" style="width: 70%; clip: rect(0pt, 47pt, 18pt, 0pt); font-family: 宋体; font-size: 10pt; font-weight: normal; font-style: normal;text-align: left; vertical-align: middle; text-indent: 0; color: #000000; background-attachment: fixed; background-color: #EEEEEE; border: 1px solid #0xf8f8f8"></textarea> 
 			</p>
 				<br />
 				
 				<p align="center"><input type="button" value="提交" onclick="return Ok_OnClick(window.event);">
         	   </p>
         	   </div> 		
       		<div id="footer">
				<jsp:include page="bottom.jsp" />  
			</div>
		</div>
</body>
</html>

	