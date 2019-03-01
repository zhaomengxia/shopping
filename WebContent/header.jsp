<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<style type="text/css">
/* CSS For Dropdown Menu Start */  
  ul   
  {   
  list-style:none;   
  padding:0px;   
  margin:0px  
  }   
  
ul li   
  {   
  display:inline;   
  float:left;   
  }   
  
ul li a   
  {   
  
  background:#990E00;   
  margin-right:5px;   
  font-weight:bold;   
  font-size:12px;      
  display:block;   
  width:100px;   
  height:25px;   
  line-height:25px;   
  text-align:center;      
  border: 1px solid #560E00;   
  }   
  
ul li a:hover   
  {   
  
  background:#560E00;   
  font-weight:bold;      
  display:block;   
  width:100px;   
  text-align:center;      
  border: 1px solid #000000;   
  }   
  
ul li.submenu a   
  {   
 
  background:#f6f6f6;   
  border-bottom:1px solid #cccccc;   
  font-weight:normal;   
  text-decoration:none;   
  display:block;   
  width:100px;   
  text-align:center;   
  margin-top:2px;   
  }   
  
ul li.submenu a:hover   
  {   
 
  background:#FFEFC6;   
  font-weight:normal;   
  text-decoration:none;   
  display:block;   
  width:100px;   
  text-align:center;   
  }   
  
ul li.submenu   
  {   
  display:none;   
  }   
  a {text-decoration:none;}
  a:link {color:#000000;text-decoration:none;}     /* 未被访问的链接     */
a:visited {color:#000000}  /* 已被访问过的链接    */
a:hover {text-decoration:underline}    /* 鼠标悬浮在上的链接  */
a:active {color:#000000}   /* 鼠标点中激活链接    */
  
/* CSS For Dropdown Menu End */
</style>

<script language="javascript" src="js/jquery-1.6.js"></script>
<script language="javascript">
$(function(){   
  $('.mainmenu').mouseenter(function(){   
    $('.submenu').stop(false, true).hide();   
  
    var submenu = $(this).parent().next();   
  
    submenu.css({
      position:'absolute',   
      top: $(this).offset().top + $(this).height() + 'px',   
      left: $(this).offset().left + 'px',   
      zIndex:1000   
    });   
  
    submenu.stop().slideDown(300);   
  
    submenu.mouseleave(function(){   
      $(this).slideUp(300);   
    });

  });//mouseenter(function()
});//$(function()
</script>
</head>

<script>
function openWin(url,width,height){
var phxWin=window.open(url,'','width='+width+',height='+height+',left='+(screen.width-width)/2+',top='+(screen.height-height)/2+'');
}
</script>
<body>
	
	<div id="logo">
		<a href="#"><img src="images/logo.png" border= "0 "/></a>
	</div>
	



	<div id="header_right">
		<%
			String userName = null;
      		if(session.getAttribute("name1") != null)
      			userName = session.getAttribute("name1").toString();
      		if(userName == null){
      	%>
		免费<a href="reg.jsp">注册</a>/您好，请先<a href="login.jsp">登录</a>
		<br />
		<a href="loginadmin.jsp">管理员</a>
		<%
      	}else{
      		byte a[]=userName.getBytes("utf-8");
      		userName=new String(a);
      		%>
			<%=userName%>欢迎您！/<a href="ExitServlet">注销</a> 	
		<%	
      	}
      	%>
	
		<br><br>
		
		
		<img src="images/order.png" />&nbsp;<a href="ShowCartServlet">我的购物车</a>
	</div>

	<div id="headermenu">

		<!-- <ul id="menu">
		<li><a href="#" class="mainmenu">点我开始</a></li>
		<li class="submenu"> -->
			<a class="li" href="index.jsp"><img src="images/dh_1.png" border= "0 "/>&nbsp首页</a>
		
		
			<a class="li" href="ShowProductServlet" ><img src="images/dh_3.png" border= "0 "/>&nbsp全部商品</a>
		
		
		
		<!-- 	<a class="li" href="notice.jsp" ><img src="images/dh_2.png" border= "0 "/>&nbsp商店公告</a> -->
			
	
			<a class="li" href="pay.jsp" ><img src="images/dh_4.png" border= "0 "/>&nbsp付款方式</a>
		
		
		
			<a class="li" href="aboutUs.jsp"><img src="images/dh_5.png" border= "0 "/>&nbsp关于我们</a>
       <!--   </li>
		</ul>     -->   
		<!-- <ul id="menu">
		<li><a href="#" class="mainmenu">客户服务</a></li>
		<li class="submenu">
		<a class="li" href="index.jsp"><img src="images/dh_1.png" border= "0 "/>&nbsp帮助中心</a>
		
		
			<a class="li" href="ShowProductServlet" ><img src="images/dh_3.png" border= "0 "/>&nbsp在线客服</a>
		
		
		
			<a class="li" href="notice.jsp" ><img src="images/dh_2.png" border= "0 "/>&nbsp电话客服</a>
			
	
			<a class="li" href="pay.jsp" ><img src="images/dh_4.png" border= "0 "/>&nbsp售后服务</a>
		
		
		
			<a class="li" href="aboutUs.jsp"><img src="images/dh_5.png" border= "0 "/>&nbsp意见建议</a>
         </li>
		</ul>-->       
		<a class="li" href="onlineMessage.jsp" ><img src="images/dh_3.png" border= "0 "/>&nbsp关注我们</a>
		<a class="li" href="ShowCartServlet" ><img src="images/dh_2.png" border= "0 "/>&nbsp我的订单</a>
		 
		

	</div>
	
	<div id="search">
		<form id="form1" name="search" method="post" action="#">
			<a href="find.jsp"><h2>搜索</h2></a>
		</form>
		
		
	</div>
	</body>
	</html>
	