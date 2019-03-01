<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="${pageContext.request.contextPath}/javascript/My97DatePicker/WdatePicker.js"></script>
<title>Insert title here</title>
<style type="text/css">
body {
	background-color: olive;
}
</style>

<script type="text/javascript">
 function checklogin() {
		var username = document.getElementById("customer_name").value;
		if (username == "") {
			alert("客户姓名没有输入！");
			return false;
		}
		var password = document.getElementById("customer_add").value;
		if (password == "") {
			alert("顾客地址没有输入！");
			return false;
		}
		var customer_tel=document.getElementById("customer_tel").value;
		if(customer_tel==""){
		alert("顾客联系方式没有输入");
		return false;
		}
		return true;
	}
 
var xmlHttpRequest;
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
}


function checkphone(phone1,i){
				var phonee=document.getElementById("phone1");

				var phone11=phone1.value;
				phone11=checkAll(phone11, i);
				if(phone11){
					phonee.innerHTML="<font color='#008000'>输入合法</font>";
					}
				else{
					phonee.innerHTML="<font color=#FF0000>输入不合法</font>";
					}

				}
			var emails=null;
			function emailF(emaile,i){
				var emai=document.getElementById("emailError");
				var emails=emaile.value;
				emails=checkAll(emails, i);
				if(emails){
					emai.innerHTML="<font color='#008000'>输入合法</font>";
				}else{
					emai.innerHTML="<font color=#FF0000>输入不合法</font>";
					
				}


				}
			var nameF=null;
			function checkName(namee,i){
					var nameError=document.getElementById("nameError");
					var name1=namee.value;
					nameF=checkAll(name1,i);
					if(nameF){
					nameError.innerHTML="<font color='#008000'>输入合法</font>";
				}else{
					nameError.innerHTML="<font color=#FF0000>输入不合法</font>";
					
				}
					
				}
			
			
			var passF=null;
			function checkpassword(obj,i){
				var passworde=document.getElementById("passwordError");
				var password1=obj.value;
				passF=checkAll(password1,i);
				if(passF){
					passworde.innerHTML="<font color='#008000'>输入合法</font>";
				}else{
					passworde.innerHTML="<font color=#FF0000>输入不合法</font>";
					
				}
				
			}
				function checkAll(namee,i){
					var arr=[	
					/^[\u4e00-\u9fa5]+$/,
					/^[A-Z]{1}[0-9|A-Z|a-z]{7,11}$/,
					/^\w+@[0-9|A-Z|a-z]+\.[A-Z|a-z]{2,3}$/,
					/^[(135|178|187|152|156|181|153|184|159){1}]+[0-9]{8}$/
					];
					return arr[i].test(namee);	
				}


</script>

</head>
<body style="background-color: buttonshadow;">
<input type="button" value="press" onclick="getone()"/>
	<h1>员工信息添加</h1>
	<form action="${pageContext.request.contextPath}/Admin/customers/customerServlet?p=doadd" method="post">
<table>
		<tr><td>姓名：<input id="customer_name" name="customer_name" type="text" onblur="checkName(this,0)" /></td>
		<td><span id="nameError" style="color: red;"></span></td></tr>
		<tr><td> 地址：<input id="customer_add" name="customer_add" type="text" /></td></tr>
		<tr><td> 生日：<input id="customer_bir" name="customer_bir" type="text" class="Wdate"  onclick="WdatePicker()"/></td></tr>
		<tr><td>手机号：<input id="customer_tel" name="customer_tel" type="text" onblur="checkphone(this,3)" /></td>
		<td><span id="phone1" style="color:red;"></span></td></tr>
		
		 <tr> <td><input name="add" type="submit" value="添加"  onclick="return checklogin()"/> <input name="set" type="reset" value="重置" /></td></tr>
	</table>
	</form>
</body>
</html>