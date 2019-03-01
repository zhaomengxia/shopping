<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.Vector" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
		<%-- <div id="center_column">
				<jsp:include page="center.jsp" />  
			</div>	 --%>
		<div id="center_column">		
			<div class="divBorder">
			<%
				String sortid = request.getParameter("sortid");
			if(sortid==null){
				
			}
			else if(sortid.equals("1")){
				
			}
			else if(sortid.equals("2")){
				
			}
			else if(sortid.equals("3")){
				
			}
			else if(sortid.equals("4")){
				
			}
			else if(sortid.equals("5")){
				
			}
			else{
				
			}
				%>
				<%!
				int pageSize =12; //每页放九张图
				int pageNum; //总页数 
				int nowPage; //当前页
				int firstPosition; //每页的第一个位置
				%>
				<%
				Vector<Vector<String>> sortProduct = (Vector<Vector<String>>)request.getAttribute("sortProduct");
				if(sortProduct == null){
					response.sendRedirect("SortProductServlet");
					return;
				}
				if(sortProduct.size() % pageSize == 0){
					pageNum = sortProduct.size() / pageSize;
				}
				else{
					pageNum = sortProduct.size() / pageSize + 1;
				}
				String nowNum = request.getParameter("nowPage");
				if(nowNum==null){
					nowNum = "1";
				}
				nowPage = Integer.parseInt(nowNum);
				if(nowPage > pageNum || nowPage < 1){
					nowPage = 1;
				}
				firstPosition = (nowPage-1) * pageSize;
				for(int i=firstPosition; i<firstPosition+pageSize; i++){
				  if(i<sortProduct.size()){
					Vector oneProduct=sortProduct.get(i); //获取一条记录
				%>
					<div id='sort_product'>
					
						<p class='gpic'><a href="ShowProDetailServlet?id=<%=oneProduct.get(0) %>"><img width='205' height='154' src="<%=oneProduct.get(3)%>"></a></p> 
						
					
					</div>
				<% 	
				  }
				}
				%>
			
				<div id='page_next' >
					<a class="pageLink" href="SortProductServlet?sortid=<%=sortid %>&nowPage=<%=nowPage-1 %>">上一页</a>&nbsp;
					第<%=nowPage %>页
					<%if(nowPage==pageNum){nowPage=0;} %>
					<a class="pageLink" href="SortProductServlet?sortid=<%=sortid %>&nowPage=<%=nowPage+1 %>">下一页</a>&nbsp;
				</div>  
			</div>
		</div>			
		<div id="footer">
			<jsp:include page="bottom.jsp" />  
		</div>
		
	</div>
</body>
</html>