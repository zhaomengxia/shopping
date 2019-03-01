<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%-- <%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %> 用core库可能会报异常，用core_rt就行了--%>

<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>



  <script type="text/javascript">
  $(document).ready(function(){
	 $('#myFrom').form({
	    url:"admin/products/productServlet?op=doEditProduct",
	    //----这是提交前检测数据用-----
	    onSubmit: function(){
			if($("form:input[name=product_name]").val()==""){
				$.messager.alert(' 警告！','产品名称不能为空！');
				return false;
			}
			return true;
	    },
	    success:function(data){
			if(data=="修改成功"){
				//---成功后重新加载表格并关闭面板-------
				$('#editProduct').dialog("close");
				//--刷新表格---
				$("#product").datagrid("reload");  
			}else{
				$.messager.alert(' 警告！','产品修改失败！');
			} 
	    }
	});
  });
  </script>
 
  	
  <form id="myForm"  method="post">
  		<!-- 隐藏域传产品的id -->
  		<input type="text" name="productID" value ="${requestScope.p.productID}" hidden />
    <table width="50%" border="1px solid"  cellspacing="0px">
    	<tr>
    		<td>产品名称</td><td><input type="text" name="product_name" value ="${requestScope.p.product_name}" /></td>
    	</tr>
    	<tr>
    		<td>产品进价</td><td><input type="text" name="income_price" value ="${requestScope.p.income_price}"/></td>
    	</tr>
    	<tr>
    		
    		<td>供应商ID</td>
    		<td><!-- <input type="text" name="providerID"> -->
    			<select id="providerID" name="providerID">
    				<option value="0" >请选择供应商</option>
    				
    				<c:forEach items="${requestScope.list}" var="list">
    					<option value="${list.providerID}"  
    						<c:if test="${requestScope.p.provider.providerID == list.providerID}">
			    				selected = "selected"
			    			</c:if>
    					 > ${list.provider_name} </option>
    				</c:forEach>
    				 
    			</select>
    		</td>
    	</tr>
    	<tr>
    		<td>产品数量</td><td><input type="text" name="quantity" value="${requestScope.p.quantity}"/></td>
    	</tr>
    	<tr>
    		<td>产品售价</td><td><input type="text" name="sales_price" value="${requestScope.p.sales_price}" /></td>
    	</tr>
    	<tr>
    		<td>产品目录</td>
    		<td><!-- <input type="text" name="categoryID"> -->
    		<select id="categoryID" name="categoryID">
    				<option>请选产品目录</option>
    				<c:forEach items="${requestScope.list2}" var = "list2">
    					<option value="${list2.categoryID}" 
    						<c:if test="${requestScope.p.category.categoryID == list2.categoryID }">
	    						selected="selected"
	    					</c:if>
    					> ${list2.category_name} </option>
    				</c:forEach>
    		</select>
    		</td>
    	</tr>
    	<tr>
    		<td>进货时间</td><td><input class="Wdate" name="income_time" type="text" value="${requestScope.p.income_time}" onClick="WdatePicker()"></td>
    	</tr>
    	 
    		<!-- 这行注掉，因为可以用easyUI的dialog的按钮 ,然后就相当于showProduct.jsp页面和editProduct.jsp页面整合到一起。
    		editProduct.jsp页面的很多东西都可以删除掉。史留下有用的代码就行。日期插件的js引用也可以写到showProduct.jspj里面。 -->
    	<tr>
    		<td><input type="submit" value="确定" /></td><td><input type="reset" value="重置"></td>
    	</tr> 
    	
    </table>
  </form>
  










