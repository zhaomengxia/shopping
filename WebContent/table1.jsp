<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
		<script type="text/javascript">
			
			function addRow1(){
				var order11=document.getElementById("order");
				var newrow=document.createElement("tr");		
				newrow.innerHTML="<tr id='order1'><td><input type='text' maxlength='10'/></td><td><input type='text'  maxlength='6'/></td><td><input type='text'  maxlength='6'/></td><td><input name='de1'  type='button'  value='删除'  onclick='delerow(this)'  style='width: 45%;'/><input name='ed1'  type='button'  value='确定'  onclick='editrow(this)'  style='width: 45%;'/></td></tr>";
				order11.appendChild(newrow);
				}
			function delerow(obj){
				var orders=document.getElementById("order");
				var oldtr=obj.parentNode.parentNode;
				var i=oldtr.rowIndex;
				if(orders.rows.length>2){
					orders.deleteRow(i);
					
				}

				}
			function editrow(obj){
				if(obj.value=="确定"){
					var oldtr=obj.parentNode.parentNode;
					var arr=oldtr.cells;
					for(var i=0;i<arr.length-1;i++){
						
						arr[i].innerHTML=arr[i].firstElementChild.value;
						
					}
					obj.value="修改";
					
				}
				else if(obj.value=="修改"){
					var oldtr=obj.parentNode.parentNode;
					var arr=oldtr.cells;
				
					for(var i=0;i<arr.length-1;i++){
						
						arr[i].innerHTML="<td><input type='text' value='"+arr[i].innerHTML+"'/></td>";
						
						
					}
					
					obj.value="确定";

					}

				
			
			}
			
		</script>
	</head>
	<body>
		
		<table border="0" cellpadding="0" cellspacing="0" id="order">
			<tr>
				<td>产品名称</td>
				<td>数量</td>
				<td>价格</td>
				<td>操作</td>
			</tr>
			<tr id="order1">
				<td><input type="text" maxlength="10"/></td>
				
				<td><input type="text"  maxlength="6" /></td>
				<td><input type="text" maxlength="6"/></td>
				<td>
					<input name="de1"  type="button" value="删除" onclick="delerow(this)" style="width: 45%;"/>
					<input name="ed1"  type="button" value="确定" onclick="editrow(this)" style="width: 45%;"/>
				</td>
			</tr>
			
			
			
		</table>
		<table>
			<input name="add" type="button" value="添加订单" onclick="addRow1()" />
		
		</table>
		
	</body>
</html>
