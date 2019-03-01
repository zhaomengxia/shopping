<%@page import="com.shopping.entity.Categorys"%>
<%@page import="com.shopping.serviceimpl.CategoryServiceImpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
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
function checkName1(){

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
</script>

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

  
  function checkName(){
 var pname=document.getElementById("category_name").value;
$.ajax({

        type: "post",
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
  
  
<style type="text/css">
h1{
	color: maroon;
	margin-left: 150px;
}

</style>
</head>
<body>
<!-- 产品 类别的原有信息显示在输入框中-->
<h1>产品类别修改</h1>
<form  method="post" action="${pageContext.request.contextPath}/Admin/categorys/cateDo?p=doups">
<input name="categoryID" type="hidden" value="${cate.categoryID }"/><br/>
产品类别：<input name="category_name" id="category_name" type="text" value="${cate.category_name }" onblur="checkName()"/><span id="nameerror"></span><br/>
产品描述：<input name="category_desc" type="text" value="${cate.category_desc }"/><br/>
<input name="add" type="submit" value="修改"/>
<input name="set" type="reset" value="重置"/>
</form>
</body>
</html>