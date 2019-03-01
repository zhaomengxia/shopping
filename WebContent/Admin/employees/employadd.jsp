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
				function salary(){
					var salary=document.getElementById("salary").value;
					var salaryError=document.getElementById("salaryError").value;
				if(salary<0){
				salaryError.innerHTML="<font color='#FF0000'>输入不合法</font>";
				}
				else{
				salaryError.innerHTML="<font color='#008000'>输入合法</font>";
				}
				}
				
			function add(){
				var name=document.getElementById("name").value;
				if(name==""){
					alert("您沒输入名字");
					return false;
				}
			
				
				var password=document.getElementById("password").value;
				if(password==""){
					alert("您沒有输入密码");
					return false;
				}
				var password1=document.getElementById("password1").value;
				if(password1!=password){
					alert("兩次密码不一样")
					return false;
				}
				if(check_name()==false){
					alert("姓氏中不能有数字！");
					return false;
				}
				if (check_interest()==false){
					alert("至少要选中一个爱好！");
					return false;
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
		<script type="text/javascript" src="${pageContext.request.contextPath}/javascript/My97DatePicker/WdatePicker.js"></script>

</head>

<body bgcolor="honeydew">
	<hr>
	<hr />
	<hr />
	<br />
	<br />
	<form action="${pageContext.request.contextPath}/Admin/employees/employServlet?p=doadd" method="post">
		<table>
			<tr>
				<td align="right" width="100px">名字：</td>
				<td><input type="text" id="name" name="name" placeholder="请输入用户名" onblur="checkName(this,0)"></td>
				<td><span id="nameError" style="color: red;"></span></td>
				<td colspan="5" width="200px"></td>
				<td rowspan="9" colspan="9" align="900px" align="right"></td>
			</tr>
			
			<tr>
			 <td><a style="margin-left: 5px">入职时间：</a></td><td><input name="hire_date" type="text" class="Wdate" onclick="WdatePicker()"/></td>
			</tr>
			
			<tr>
			<td align="right">工资</td>
			<td><input type="text" name="salary" id="salary" onblur="salary()"/></td>
			<td><span id="salaryError" style="color: red;"></span></td>
			</tr>
			<tr>
				<td align="right">密码：</td>
				<td><input type="password" id="password" name="password"
					placeholder="输入密码" onblur="checkpassword(this,1)"></td>
				<td><span id="passwordError" style="color: red;"></span></td>
			</tr>
			
			<tr>
				<td align="right">再次输入密码：</td>
				<td><input type="password" id="password1" name="password1"
					placeholder="再次输入密码" onblur="checkpassword1()"></td>
				<td><span id="password1Error" style="color: red;"></span></td>
			</tr>
		<!-- 	<tr>
				<td align="right">电子邮箱：</td>
				<td><input id="email" type="email" name="email" onblur="emailF(this,2)"></td>
				<td><span id="emailError" style="color: red;"></span></td>
			</tr> -->
			<tr>
				<td align="right">手机号：</td>
				<td><input id="phone" type="text" name="phone" onblur="checkphone(this,3)"></td>
				<td><span id="phone1" style="color: red;"></span></td>
			</tr>
			<tr>

				<td align="right">爱好：
				<td><input type="checkbox" name="interest" value="0" />钓鱼 <input
					type="checkbox" name="interest" value="1" />购物 <input
					type="checkbox" name="interest" value="2" />游戏</td>

			</tr>
			<tr>
				<td align="right">住址：</td><!-- <td><select id="provice" onclick="autoCity(this)">
						<option>选择省</option>

						<option>河南省</option>
						<option>浙江省</option>
				</select> <select id="city" onchange="acity(this)">
						<option>选择城市</option>

				</select> <select id="county">
						<option>选择区县</option>
				</select> -->
				
				<td><input type="text" id="address" name="address"/>
				</td>
			</tr>
			<tr>
				<td align="right">性別：</td>
				<td><img src="img/Male.gif"></img>男<input type="radio"
					name="gender" value="man"> &nbsp;&nbsp;<img
					src="img/Female.gif" /></img>女<input type="radio" name="gender"
					value="woman"></td>
				<td></td>

			</tr>
			<tr>
				<td align="right">
				<td><input type="submit" value="提交" onclick="return add()"/>
						
					

					<button type="reset">
						重置
					</button>
					</button></td>
				</td>
			</tr>
		</table>

	</form>
	<br />
	<br />
	<br />

	<br />
	<a href="javascript:history.go(-1);">后退</a>
	<a href="javascript:history.go(1);">前进</a>

</body>
</html>