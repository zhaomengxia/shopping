<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>淘书吧</title>
<link rel="stylesheet" rev="stylesheet" href="${pageContext.request.contextPath }/css/global.css" type="text/css" media="all" />
<SCRIPT src="${pageContext.request.contextPath }/js/jquery-1.9.1.min.js" type="text/javascript"></SCRIPT>
 
<BODY>
<div id="page">
			<div id="header">
				<jsp:include page="header.jsp" />  
				     
       		</div>
				<p><font size="3" color="red">欢迎您的光临！</font></p>
			<div id="left_column">
				<jsp:include page="left_column.jsp" />  
			</div>	
			<div id="center_column">
				<jsp:include page="center_column.jsp" />  
			</div>
			
			<div id="footer">
				<jsp:include page="bottom.jsp" />  
			</div>
		</div>	
</body>
</html>