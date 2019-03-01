<%@page import="java.util.Vector"%>

<%@ page language="java" contentType="text/html; charset=GB2312"
    pageEncoding="GB2312"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB2312">
<title>淘书吧</title>
<link rel="stylesheet" rev="stylesheet" href="css/global.css" type="text/css" media="all" />
</head>
<body>
	
		<div id="page">
			<div id="header">
				<jsp:include page="header.jsp" />      
       		</div>
			<p>
			<font size="3" color="red">欢迎您的光临！</font></p>
			<div id="left_column">
				<jsp:include page="left_column.jsp" />  
			</div>
			<div id="center_column">
				<%-- <%if(session.getAttribute("cart")==null){ %>
					<div id="empty">
						<h3>您的购物车还是空的，</h3>
						<h3>赶紧行动吧！</h3>
					</div>
				<%}else{ %> --%>
				<img src="images/woman_fans.gif" />
				<div id="cart_tb">
						<table>
							<tr>
								<td width="10%"><span style="color:#696969;size:13;font-weight:bold;">序号</span></td>
								<td width="30%"><span style="color:#696969;size:13;font-weight:bold;">商品名称</span></td>
								<td width="18%"><span style="color:#696969;size:13;font-weight:bold;">单价（元）</span></td>
								<td width="18%"><span style="color:#696969;size:13;font-weight:bold;">数量</span></td>
								<td width="20%"><span style="color:#696969;size:13;font-weight:bold;">小计（元）</span></td>
								
								<td width="20%"><span style="color:#696969;size:13;font-weight:bold;">操作</span></td>
								
								
							</tr>
							<tr>
								<td>&nbsp;</td>
							</tr>	
							<%

							
							
								Vector rows=(Vector)request.getAttribute("product");//该用户购物车中的所有商品
								for(int i=0;i<rows.size();i++)
								{
									Vector row=(Vector)rows.get(i);//一条信息
									
								%>
									<tr>
										<td><%=i+1 %></td>   <!-- <td>1</td>序号 -->
										<td><%=row.get(1) %></td>
										<td><%=row.get(2) %></td>
										<td><%=row.get(3) %></td>
										<td><%=row.get(4) %></td>
										<td width="20%"><a href="DelCartServlet?id=<%=row.get(0) %>" onclick="return confirm('是否删除？')">删除</a></td>
										<%-- <td width="20%"><a href="EditCartServlet?id=<%=row.get(0) %>">修改</a></td> --%>
									</tr>															
								<%	
								
									
								}
								
								
							%>						
								
						</table>
						
					</div>
										
					<div id="cart_tt">	
					<%
					Vector rowss=(Vector)request.getAttribute("product");//该用户购物车中的所有商品
					int s=0;
					for(int i=0;i<rowss.size();i++)
					{
						Vector row=(Vector)rowss.get(i);//一条信息
		
						
						int t=Integer.parseInt(row.get(4).toString());
						
						s=s+t;
					%>
						<% 	
					}
					%>
					
						合计总金额：<span id="totalPrice" style="font-size:18px;color:#f60;"><%=s %></span>元
					
								
							
							</div>			
				<div id="cart_lk">
					<a href="product.jsp">继续购物</a> | <a href="pay.jsp">结账</a> | <a href="cart_remove.jsp">清空购物车</a> 
				</div>
			
			</div>
			<div id="footer">
				<jsp:include page="bottom.jsp" />  
			</div>
		</div>
	
</body>
</html>