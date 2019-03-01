<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css" src="${pageContext.request.contextPath }/css/one.css"></style>
<style type="text/css">
a {
	width: 40px;
	margin-left: 30px;
	
}

input {
	margin-right: 80px;
	margin-left: 20px;
}
body{
background-color: olive;
}
h1{
		color: maroon;
		margin-left: 150px;
}
</style>
<script type="text/javascript">
function checklogin() {
		var username = document.getElementById("provider_name").value;
		if (username == "") {
			alert("供应商名字没有输入！");
			return false;
		}
		var provider_add = document.getElementById("provider_add").value;
		if (provider_add == "") {
			alert("地址没有输入！");
			return false;
		}
		var provider_tel=document.getElementById("provider_tel").value;
		if(provider_tel==""){
		alert("请输入联系方式");
		return false;
		}
		var account=document.getElementById("account");
		if(account==""){
		alert("请输入出入账");
		}
		var email=document.getElementById("email");
		if(email==""){
		alert("请输入email");
		}
		
		return true;
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
<body style="background-color: activeborder;">
	<h1>供应商添加</h1>

	<form action="${pageContext.request.contextPath}/Admin/providers/provServlet?p=doadd" method="post">
		<br /><a>供应商名：</a><input id="provider_name" name="provider_name" type="text"  onblur="checkName(this,0)"/><span id="nameError" style="color: red;"></span><br />
		<br /> <a>地址：</a><input id="provider_add" name="provider_add" type="text" /><br />
		<br /> <a>联系方式：</a><input id="provider_tel" name="provider_tel" type="text"  onblur="checkphone(this,3)"/><span id="phone1" style="color: red;"></span><br />
		<br /> <a>出入账：</a><input id="account" name="account" type="text" /><br />
		<br /> <a>email：</a><input id="email" name="email" type="text" onblur="emailF(this,2)" /> <span id="emailError" style="color: red;"></span><br />
		 <br /><input name="add" type="submit" value="添加" onclick="return checklogin()"/>
		<input name="set"type="reset" value="重置" />
	</form>



</body>
</html>