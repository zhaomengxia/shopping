<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="java.util.Calendar" %>
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
  color:#ffffff;   
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
  color:#cccccc;   
  background:#560E00;   
  font-weight:bold;      
  display:block;   
  width:100px;   
  text-align:center;      
  border: 1px solid #000000;   
  }   
  
ul li.submenu a   
  {   
  color:#000000;   
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
  color:#000000;   
  background:#FFEFC6;   
  font-weight:normal;   
  text-decoration:none;   
  display:block;   
  width:100px;   
  text-align:center;   
  }   
  
 
  
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
<body>

<table border=0 cellpadding=0 cellspacing=0>
  	<tr>
    	<td valign=top width=4 height=4><img height=4 src="images/line_01.gif" width=4></td>
    	<td background=images/line_02.gif height=4></td>
    	<td valign=top width=4 height=4><img height=4 src="images/line_03.gif" width=4></td>
    </tr>
    
   	<tr>
     	<td valign=top width=4 height=4><img height=4 src="images/line_06.gif" width=4></td>
      	<td background=images/line_07.gif></td>
      	<td valign=top width=4 height=4><img height=4 src="images/line_08.gif" width=4></td>
   	</tr>
</table><br>
<table border=0 cellpadding=0 cellspacing=0>
  	<tr>
      	<td valign=top width=4 height=4><img height=4 src="images/line_01.gif" width=4></td>
      	<td background=images/line_02.gif height=4></td>
     	<td valign=top width=4 height=4><img height=4 src="images/line_03.gif" width=4></td>
    </tr>
    <tr>
      	<td background=images/line_04.gif></td>
      	<td>
      		<div id="left_login">
      			<img src="images/vip_logo.PNG" /><br><br>
      			<%
      			String userName = null;
      			if(session.getAttribute("name1") != null)
      				userName = session.getAttribute("name1").toString();
      			if(userName == null){
      			%>
      				<form action="LoginServlet" method="post">
      					<font class="zt1">用户名：</font><input type="text" name="name1" class="input"><br><br>
      					<font class="zt1">密&nbsp;&nbsp;码：</font><input type="password" name="password2" class="input"><br>
          				<a href="reg.jsp"><img src="images/reg_button.gif" border= "0 " /></a>
          				<input name="imageField" type="image" src="images/login_button.gif" />
          			</form>
          		<%
      			}else{      				
      				byte a[]=userName.getBytes("ISO-8859-1");
      	      		userName=new String(a);
      				Calendar cal = Calendar.getInstance();
      				int hour = cal.get(Calendar.HOUR_OF_DAY);
      				if (hour >= 5 && hour < 8) {
      					out.print("<span style='color:red'>早上好!"+userName+"</span>");
      				 }else if (hour >= 8 && hour < 11) {
      					out.print("<span style='color:red'>上午好!"+userName+"</span>");
      				 }else if (hour >= 11 && hour < 13) {
      					out.print("<span style='color:red'>中午好!"+userName+"</span>");
      				 }else if (hour >= 13 && hour < 18) {
      					out.print("<span style='color:red'>下午好!"+userName+"</span>");
      				 }else if (hour >= 18 && hour < 23) {
      					out.print("<span style='color:red'>晚上好!"+userName+"</span>");
      				 }else {
      					out.print("<span style='color:red'>夜深啦!"+userName+"</span>"); 
      				 }      					       				
       			%>
      			<br></br>
      			<form action="ExitServlet" method="post">
      				<input type="submit" name="exit" value="退出">
      			</form>
      				
      			<%
      			}
          		%>
  				
      		</div>
      	</td>
      	<td background=images/line_05.gif>&nbsp;</td>
    </tr>
   
 </table><br>
			
<table border=0 cellpadding=0 cellspacing=0>
  
    <tr>
    	
        		<div id="left_sort">
        			
    				<div id="sort_menu">
    				<ul id="menu">
    				<li><a href="#" class="mainmenu">Menu</a></li>
     					<li class="submenu">
     					<img src="images/sort_menu.gif" />&nbsp;&nbsp;<a class="li_sort" href="SortProductServlet?sortid=1&nowPage=1">计算机类</a>
     					<hr size="1" />
     					<img src="images/sort_menu.gif" />&nbsp;&nbsp;<a class="li_sort" href="SortProductServlet?sortid=2&nowPage=1">文学类</a>
     					<hr size="1" />
   						<img src="images/sort_menu.gif" />&nbsp;&nbsp;<a class="li_sort" href="SortProductServlet?sortid=3&nowPage=1">小说类</a>
   						<hr size="1" />
   						<img src="images/sort_menu.gif" />&nbsp;&nbsp;<a class="li_sort" href="SortProductServlet?sortid=4&nowPage=1">管理类</a>
   						<hr size="1" />
   						<img src="images/sort_menu.gif" />&nbsp;&nbsp;<a class="li_sort" href="SortProductServlet?sortid=5&nowPage=1">文化类</a>
   						<hr size="1" />
   						<img src="images/sort_menu.gif" />&nbsp;&nbsp;<a class="li_sort" href="SortProductServlet?sortid=6&nowPage=1">艺术类</a>
   						<hr size="1" />
   						<img src="images/sort_menu.gif" />&nbsp;&nbsp;<a class="li_sort" href="SortProductServlet?sortid=7&nowPage=1">科学类</a>
   						<hr size="1" />
   						
   						</li>
   						<ul><li><img src="images/sort_menu.gif" />&nbsp;&nbsp;<a class="li_sort" href="SortProductServlet?sortid=1&nowPage=1">计算机类</a>
     					<hr size="1" /></li></ul>
     					<ul><li><img src="images/sort_menu.gif" />&nbsp;&nbsp;<a class="li_sort" href="SortProductServlet?sortid=2&nowPage=1">文学类</a>
     					<hr size="1" /></li></ul>
     					<ul><li> <img src="images/sort_menu.gif" />&nbsp;&nbsp;<a class="li_sort" href="SortProductServlet?sortid=3&nowPage=1">小说类</a>
   						<hr size="1" /></li></ul>
   						<ul><li><img src="images/sort_menu.gif" />&nbsp;&nbsp;<a class="li_sort" href="SortProductServlet?sortid=4&nowPage=1">管理类</a>
   						<hr size="1" /></li></ul>
   						<ul><li>
   						<img src="images/sort_menu.gif" />&nbsp;&nbsp;<a class="li_sort" href="SortProductServlet?sortid=5&nowPage=1">文化类</a>
   						<hr size="1" /></li></ul>
   						<ul><li><img src="images/sort_menu.gif" />&nbsp;&nbsp;<a class="li_sort" href="SortProductServlet?sortid=6&nowPage=1">艺术类</a>
   						<hr size="1" /></li></ul>
   						<ul><li><img src="images/sort_menu.gif" />&nbsp;&nbsp;<a class="li_sort" href="SortProductServlet?sortid=7&nowPage=1">科学类</a>
   						<hr size="1" /></li></ul>
   					
   						
   					</ul>
   					</div>
  				</div>
        	
      	</td>
      	<td background=images/line_05.gif>&nbsp;</td>
    </tr>
   	
</table>