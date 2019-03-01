<%@page import="com.shopping.serviceimpl.ProviderServiceImpl"%>
<%@page import="com.shopping.entity.Providers"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  <script type="text/javascript" src="${pageContext.request.contextPath}/javascript/My97DatePicker/WdatePicker.js"></script>
    <base href="<%=basePath%>">
    
    <title>My JSP 'providerupdate_cate.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
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


<style type="text/css">
			a{
				color: fuchsia;
				text-decoration: none;
			}
			a:hover{
				color: blue;
				
			}
			p{
				color: #800080;
				font-size: 20px;
				
			}
		
			body{
				background-color:silver;
			}
			
				h1{
			color: maroon;
			margin-left: 150px;
			}
		</style>

  </head>
  
  <body>
 <h1>修改员工信息</h1>
   <form action="${pageContext.request.contextPath}/Admin/customers/customerServlet?p=doup1" method="post">
   <table>
   <tr>
   <td><input type="hidden" name="customerID" value="${cus.customerID }"/></td>
   </tr>
   <tr>

   <td>   名字： <input type="text" name="customer_name" id="customer_name" value="${cus.customer_name}" onblur="checkName(this,0)"/></td>
   </tr>
   <tr>
  
   <td> 地址：<input type="text" name="customer_add" id="customer_add" value="${cus.customer_add }"/></td>
   </tr>
    <tr>

   <td>   生日：<input type="text" name="customer_bir" id="customer_bir" value="${cus.customer_bir}" class="Wdate" onclick="WdatePicker()"/></td>
   </tr>
    <tr>
  
   <td> 联系方式：<input type="text" name="customer_tel" id="customer_tel" value="${cus.customer_tel }" onblur="checkphone(this,3)"/></td>
   </tr>
 
   
   <tr>
   <td>
   <input type="submit" value="修改" onclick="return checklogin()"/> <input type="reset"/>
   </td>
   </tr>
   
   </table>
   </form>
  </body>
</html>
