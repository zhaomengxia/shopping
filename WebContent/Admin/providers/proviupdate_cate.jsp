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

  </head>
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
		
			
			
			h1{
				color: maroon;
				margin-left: 150px;
			}
		</style>
  
  <script type="text/javascript">
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
  
  
  <body>
 <h1>修改供应商信息</h1>
   <form action="${pageContext.request.contextPath}/Admin/providers/provServlet?p=doup1" method="post">
   <table>
   <tr>
   <td><input type="hidden" name="providerID" value="${pro.providerID }"/></td>
   </tr>
   <tr>

   <td>   供应商名字： <input type="text" name="provider_name" value="${pro.provider_name}" onblur="checkName(this,0)"/></td>
   <td><span id="nameError"></span></td>
   </tr>
   <tr>
  
   <td> 供应商地址：<input type="text" name="provider_add" value="${pro.provider_add }"/></td>
   </tr>
    <tr>
  
   <td> 供应商联系方式：<input type="text" name="provider_tel" value="${pro.provider_tel }" onblur="checkphone(this,3)"/></td>
   <td><span id="phone1"></span></td>
   </tr>
    <tr>

   <td>   出入账：<input type="text" name="account" value="${pro.account}"/></td>
   </tr>
    <tr>
 
   <td>  供应商email：<input type="text" name="email" value="${pro.email}"  onblur="emailF(this,2)"/></td>
   <td><span id="emailError" ></span></td>
   </tr>
   
   <tr>
   <td>
   <input type="submit" value="修改"/> <input type="reset"/>
   </td>
   </tr>
   
   </table>
   </form>
  </body>
</html>
