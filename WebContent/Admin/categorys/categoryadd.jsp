<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
body {
	background-color: olive;
}
h1{
			color: maroon;
			margin-left: 150px;
}
</style>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-3.1.1.js"></script>
<script type="text/javascript">
/* function checklogin() {
		var username = document.getElementById("category_name").value;
		if (username == "") {
			alert("产品类别没有输入！");
			return false;
		}
		var password = document.getElementById("category_desc").value;
		if (password == "") {
			alert("产品描述没有输入！");
			return false;
		}
		return true;
	}
 */
/* var xmlHttpRequest;
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
	alert(xmlHttpRequest);
	}
function checkName(){

	xmlHttpRequest=getXMLHttpRequest();
	var pname=document.getElementById("category_name").value;
	xmlHttpRequest.open('get',"${pageContext.request.contextPath}/Admin/categorys/cateDo?p=checkname&name="+pname,true);
	if(pname!=""){
	
	xmlHttpRequest.onreadystatechange = function(){
	
	if(xmlHttpRequest.readyState==4&&xmlHttpRequest.status==200){
	var msg=xmlHttpRequest.responseText;
	if(msg=="true"){
       document.getElementById("nameerror").innerHTML="<font color='green'>目录名可以用</font>";	
       }
     else{
       document.getElementById("nameerror").innerHTML="<font color='red'>目录名有重名</font>";
	
	}
	
	}

}
//这个时候，才是真正的提交
	xmlHttpRequest.send(null); 
}
else{
alert("产品类别名字必须输入！");
}
} */
function checkName(){
 var pname=document.getElementById("category_name").value;
$.ajax({

        type: "get",
        url: "${pageContext.request.contextPath}/Admin/categorys/cateDo",
        data:"p=checkname&name="+pname,
        success:function(p){
        if(p=="true"){
       document.getElementById("nameerror").innerHTML="<font color='green'>目录名可以用</font>";	
       }
     else{
       document.getElementById("nameerror").innerHTML="<font color='red'>目录名有重名</font>";
	
	}
               
        }
        
});
}
</script>
</head>
<body style="background-color: buttonshadow;">
<input type="button" value="press" onclick="getone()"/>
	<h1>产品类别添加</h1>
	<form action="${pageContext.request.contextPath}/Admin/categorys/cateDo?p=doadd" method="post">
<table>
		<tr><td>产品类别：<input id="category_name" name="category_name" type="text" onblur="checkName()" /></td>
		<td><span id="nameerror"></span></td></tr>
		
		<tr><td> 产品描述：<input id="category_desc" name="category_desc" type="text" /></td></tr>
		 <tr> <td><input name="add" type="submit" value="添加" /> <input name="set" type="reset" value="重置" /></td></tr>
	</table>
	</form>
</body>
</html>