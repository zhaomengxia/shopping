<%@page import="java.util.Vector"%>

<%@ page language="java" contentType="text/html; charset=GB2312"
    pageEncoding="GB2312"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB2312">
<title>�����</title>
<link rel="stylesheet" rev="stylesheet" href="css/global.css" type="text/css" media="all" />
</head>
<body>
	
		<div id="page">
			<div id="header">
				<jsp:include page="header.jsp" />      
       		</div>
			<p>
			<font size="3" color="red">��ӭ���Ĺ��٣�</font></p>
			<div id="left_column">
				<jsp:include page="left_column.jsp" />  
			</div>
			<div id="center_column">
				<%-- <%if(session.getAttribute("cart")==null){ %>
					<div id="empty">
						<h3>���Ĺ��ﳵ���ǿյģ�</h3>
						<h3>�Ͻ��ж��ɣ�</h3>
					</div>
				<%}else{ %> --%>
				<img src="images/woman_fans.gif" />
				<div id="cart_tb">
						<table>
							<tr>
								<td width="10%"><span style="color:#696969;size:13;font-weight:bold;">���</span></td>
								<td width="30%"><span style="color:#696969;size:13;font-weight:bold;">��Ʒ����</span></td>
								<td width="18%"><span style="color:#696969;size:13;font-weight:bold;">���ۣ�Ԫ��</span></td>
								<td width="18%"><span style="color:#696969;size:13;font-weight:bold;">����</span></td>
								<td width="20%"><span style="color:#696969;size:13;font-weight:bold;">С�ƣ�Ԫ��</span></td>
								
								<td width="20%"><span style="color:#696969;size:13;font-weight:bold;">����</span></td>
								
								
							</tr>
							<tr>
								<td>&nbsp;</td>
							</tr>	
							<%

							
							
								Vector rows=(Vector)request.getAttribute("product");//���û����ﳵ�е�������Ʒ
								for(int i=0;i<rows.size();i++)
								{
									Vector row=(Vector)rows.get(i);//һ����Ϣ
									
								%>
									<tr>
										<td><%=i+1 %></td>   <!-- <td>1</td>��� -->
										<td><%=row.get(1) %></td>
										<td><%=row.get(2) %></td>
										<td><%=row.get(3) %></td>
										<td><%=row.get(4) %></td>
										<td width="20%"><a href="DelCartServlet?id=<%=row.get(0) %>" onclick="return confirm('�Ƿ�ɾ����')">ɾ��</a></td>
										<%-- <td width="20%"><a href="EditCartServlet?id=<%=row.get(0) %>">�޸�</a></td> --%>
									</tr>															
								<%	
								
									
								}
								
								
							%>						
								
						</table>
						
					</div>
										
					<div id="cart_tt">	
					<%
					Vector rowss=(Vector)request.getAttribute("product");//���û����ﳵ�е�������Ʒ
					int s=0;
					for(int i=0;i<rowss.size();i++)
					{
						Vector row=(Vector)rowss.get(i);//һ����Ϣ
		
						
						int t=Integer.parseInt(row.get(4).toString());
						
						s=s+t;
					%>
						<% 	
					}
					%>
					
						�ϼ��ܽ�<span id="totalPrice" style="font-size:18px;color:#f60;"><%=s %></span>Ԫ
					
								
							
							</div>			
				<div id="cart_lk">
					<a href="product.jsp">��������</a> | <a href="pay.jsp">����</a> | <a href="cart_remove.jsp">��չ��ﳵ</a> 
				</div>
			
			</div>
			<div id="footer">
				<jsp:include page="bottom.jsp" />  
			</div>
		</div>
	
</body>
</html>