<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc" %>
<html>
<head>
    <title>�������������Ϣ</title>
    <script language="JavaScript" type="text/JavaScript">    
    function closeDialoge(){
    	window.close();
    }    
    </script>
</head>

<body class="list_body">
	<div class="table_container">
		<div class="table_div">
		<table class="table_style">
			<tr class="table_style_head" align="center">
				<td>�������</td>
				<td>��ʾ��Ϣ</td>
			</tr>
			<s:iterator value="nextProcessResults">
				<tr class="table_style_content" align="center" onMouseMove="this.bgColor='F0F5F9'" onMouseOut="this.bgColor='#ffffff'">
					<td><s:property value="orderid"/></td>
					<td><s:property value="message"/></td>
				</tr>
			</s:iterator>
		</table>
		</div>
	</div>
	<table class="table_button_list">
		<tr>
			<td>
				<input type="button" id="close" class="button_4" value=" �ر� " onClick="closeDialoge()"/>
			</td>
		</tr>
	</table>
</body>
</html>
