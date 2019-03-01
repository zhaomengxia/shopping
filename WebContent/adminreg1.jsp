<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8" />
<title>我的第一个网页</title>
<style type="text/css">
body {
	background-color: burlywood;
}
</style>
<script language="JavaScript">
			function $(id){
				return document.getElementById(id);
			}
			
				function $_v(id){
				return document.getElementById(id).value;
			}
				function check_name(){
					var name1=$_v("name1");
				for(var i=0;i<name1.length;i++){
					var ch=name1.charAt(i);
					if(ch>=0&&ch<=9){
						return false;
					}
				}
				return true;
				}
				function check_interest(){
					var interest=document.getElementsByName("interest");
					for(var i=0;i<interest.length;i++){
						if(interest[i].checked==ture){
							return ture;
						}
					}
					return false;
				}
				function checkpassword1(){
					if($_v("password").length<6||$_v("password").length>12){
						$("passwordError").innerHTML="密码必须是6到12位";
						return false;
						
					}
					else{
						$("passwordError").innerHTML="";
						return true;
					}
				}
				function checkname(){
					if($_v("name").length<6||$_v("name").length>12){
						$("nameError").innerHTML="账号必须是6到12位";
						return false;
						
					}
					else{
						$("nameError").innerHTML="";
						return true;
					}
				}
				
				function checkname1(){
					if(check_name()==false){
						$("name1Error").innerHTML="姓氏中不能有数字！";
					return false;
				}
					else{
						$("name1Error").innerHTML="";
						return true;
					}
					
				}
				function checkpassword1(){
				var password1=document.getElementById("password1").value;
				var password=document.getElementById("password").value;
				if(password1!=password){
					$("password1Error").innerHTML="两次密码不一样";
					return false;
				}
				else{
					$("password1Error").innerHTML="<font color='#008000'>两次密码一致</font>";
					return true;
				}
				}
				
				
			function add(){
				var name=document.getElementById("name").value;
				if(name==""){
					alert("您沒輸入名字");
				}
				
				var password=document.getElementById("password").value;
				if(password==""){
					alert("您沒有輸入密碼");
				}
				var password1=document.getElementById("password1").value;
				if(password1!=password){
					alert("兩次密碼不一樣")
				}
				if(check_name()==false){
					alert("姓氏中不能有数字！");
					return false;
				}
				if (check_interest()==false){
					alert("至少要选中一个爱好！");
				}
				if($_v("name").length<6||$_v("name").length>12){
						alert("账号必须是6到12位");
						return false;
						
					}
					if($_v("password").length<6||$_v("password").length>12){
						alert("密码必须是6到12位");
						return false;
						
					}
					if($_v("password")!=$_v("password1")){
						alert("两次密码不一致");
						return false;
						
					}
					var index1=$_v("email").indexOf("@");
					var index2=$_v("email").indexOf(".");
					if(index1==-1||index2==-1||index1>index2){
						alert("email输入不合法！");
						return false;
					}
					return true;
			}
			function autoCity(obj){
				var city1=['郑州','周口'];
				
				var city2=['杭州','宁波'];
				var city3=document.getElementById("city");
				city3.options.length=1;
				if(obj.value=='河南省'){
					for(var i=0;i<city1.length;i++){
						var newc=new Option(city1[i]);
						city3.add(newc);
						
					}
				}else if(obj.value=='浙江省'){
					
					for(var i=0;i<city2.length;i++){
					var newc=new Option(city2[i]);
					city3.add(newc);
				}
				
				
			}
			}
			function acity(obj){

				var country1=['西华','淮阳'];
				var country2=['滨江区','下城区','下沙区'];
				var county3=document.getElementById("county");
				county3.options.length=1;
			if(obj.value=="周口"){
				for(var i=0;i<country1.length;i++){
					var newc=new Option(country1[i]);
					county3.add(newc);
					}

				}else if(obj.value=="杭州"){

					for(var i=0;i<country2.length;i++){
						var newc=new Option(country2[i]);
						county3.add(newc);
						}
					
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

<body bgcolor="honeydew">
	<hr>
	<hr />
	<hr />
	<br />
	<br />
	<form action="Adminregs.jsp" method="post">
		<table>
			<tr>
				<td align="right">登录名：</td>
				<td><input type="text" id="name2" name="name"
					placeholder="请输入登录名 "></td>
			</tr>
			<tr>
				<td align="right" width="100px">名字：</td>
				<td><input type="text" id="name" name="realname"
					placeholder="请输入真实姓名" ></td>
				<td><span id="nameError" style="color: red;"></span></td>
				<td colspan="5" width="200px"></td>
				<td rowspan="9" colspan="9" align="900px" align="right"></td>
			</tr>
			
			<tr>
				<td align="right">密码：</td>
				<td><input type="password" id="password" name="password"
					placeholder="输入密码" ></td>
				<td><span id="passwordError" style="color: red;"></span></td>
			</tr>
			<tr>
				<td align="right">再次输入密码：</td>
				<td><input type="password" id="password1" name="password1"
					placeholder="再次输入密码" ></td>
				<td><span id="password1Error" style="color: red;"></span></td>
			</tr>
			
			<tr>
				<td align="right">手机号：</td>
				<td><input id="phone" type="text" name="phone" ></td>
				<td><span id="phone1" style="color: red;"></span></td>
			</tr>
			
			<tr>
				<td align="right">住址：</td>
				<td><input id="phone" type="text" name="address" ></td>
				<td><span id="phone1" style="color: red;"></span></td>
			</tr>
		
			<tr>
				<td align="right">
				<td><button>提交</button>
					

					<button type="reset">
						重置
					</button>
				
				</td>
			</tr>
		</table>

	</form>
	<br />
	<br />
	<br />

	<br />
	
</body>
</html>