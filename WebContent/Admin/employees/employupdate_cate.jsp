<%@page import="com.shopping.serviceimpl.ProviderServiceImpl"%>
<%@page import="com.shopping.entity.Providers"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<script type="text/javascript" src="${pageContext.request.contextPath}/javascript/My97DatePicker/WdatePicker.js"></script>
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
  </head>
  
  <body>
 
   <form action="${pageContext.request.contextPath}/Admin/employees/employServlet?p=doup1" method="post">
   <table>
   <tr>
   <td><input type="hidden" name="empID" value="${employ.empID }"/></td>
   </tr>
   <tr>

   <td>   员工名字： <input type="text" name="emp_name" value="${employ.emp_name}" onblur="checkName(this,0)"/></td>
   <td><span id="nameError" style="color: red;"></span></td>
   </tr>
   <tr>
  
   <td> 入职时间：<input type="text" name="hire_date" value="${employ.hire_date }" class="Wdate" onclick="WdatePicker()"/></td>
   </tr>
    <tr>
  
   <td> 工资：<input type="text" name="salary" value="${employ.salary}"/></td>
   </tr>
    <tr>

   <td>  密码：<input type="text" name="password" value="${employ.password}" onblur="checkpassword1()"/></td>
   <td><span id="password1Error" style="color: red;"></span></td>
   </tr>
    <tr>
 
   <td>  联系方式：<input type="text" name="phone" value="${employ.phone}"  onblur="checkphone(this,3)"/></td>
   <td><span id="phone1" style="color: red;"></span></td>
   </tr>
   
  
   
     <tr>

   <td>  兴趣：<input type="text" name="interest" value="${employ.interest}"/></td>
   </tr>
    <tr>
 
   <td>  地址：<input type="text" name="address" value="${employ.address}"/></td>
   </tr>
     <tr>
 
   <td>  性别：<input type="text" name="gender"  value="${employ.gender}"/></td>
   </tr>
   
   <tr>
   <td>
   <input type="submit" value="修改"/> <input type="reset" value="重置"/>
   </td>
   </tr>
   
   </table>
   </form>
  </body>
</html>
