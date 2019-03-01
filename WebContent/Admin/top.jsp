<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title></title>
		<style>
			p{
				color: blue;
				font-family: "微软雅黑";
				position: absolute;
				margin-left: 1000px;
				margin-top: 8px;
				font-size: 30px;
			}
			p:hover{
				color: green;
				font-family: "宋体";
				
			}
			a{
				color: purple;
				text-decoration: none;
				margin-left: 900px;
				font-family: sans-serif;
				font-size: 30px;
			}
			a:hover{
				color: blue;
				/*text-decoration: underline;*/
			}
			body{
				background-color:darkseagreen
				
			}
			.p{
				margin-left: 400px;
				font-size: 20px;
				height: 1px;
				width: 200px;
				margin-top: 20px;
				color: #800080;
			}
			header{
				color: #8B0000;
				font-size: 30px;
				width: 300px;
				margin: auto;
				margin-top: 20px;
				
			}
		</style>
		
		<script>
		
		showTime();
		
		function showTime(){
		
		dd=new Array("日","一","二","三","四","五","六");
		d=new Date();
		//年月日
		time=d.getYear()+"年";
		time+=(d.getMonth()+1)+"月";
		time+=d.getDate()+"日";
		//星期几
		time+="    星期"+dd[d.getDay()]+"   ";
		//时分秒
		time+=addzero(d.getHours())+":";
		time+=addzero(d.getMinutes())+":";
		time+=addzero(d.getSeconds());
		//显示
		window.status=time;
		setTimeout("showTime()",1000);
		
		}
		
		</script>
	</head>
	<body bgcolor="#006699" >
		
	<header>
			电商管理系统	
	</header>
		<div class="main">
		<a href="${pageContext.request.contextPath}/admlogin?p=outlogin">退出系统</a>
		
		</div>
		
	</body>
</html>
