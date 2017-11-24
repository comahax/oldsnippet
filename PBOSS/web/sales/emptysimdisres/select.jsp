<%@ page language="java" contentType="text/html;charset=GBK"%>
<%
//  contenthead.inc是content.jsp的文件头，声明了JS、CSS等的引用，所有content.jsp必须引用这个文件头
%>
<%@ include file="/inc/contenthead.inc"%>


<html>
<head>
	<title>请选择要导出的字段</title>
</head>
<body>
			<div class="table_container">
				<table class="top_table">
					<tr>
						<td>
							选择要导出的字段
						</td>
					</tr>
				</table>
			
			<select style="width:200px;height:250px" ID="oSelect" name="batchButton" size="56" multiple>
				<option value=0>空白卡序列号</option>
				<option value=1>分公司</option>
				<option value=2>服务销售中心</option>
				<option value=3>微区域</option>
				<option value=4>订单编码</option>
				<option value=5>网点编码</option>
				<option value=6>网点名称</option>
				<option value=7>星级</option>
				<option value=8>状态</option>
				<option value=9>空白SIM卡种类</option>
			</select><br>
			<input type=button class="button_5"  onmouseover="buttonover(this);" 
				onmouseout="buttonout(this);" onfocus="buttonover(this)" 
				onblur="buttonout(this)"  value="选择并导出"
				onclick="getValue()">
			</div>
</body>
<SCRIPT>
	 var form=document.getElementById("oSelect");
	 for(var i=0;i<form.options.length;i++){   
	         form.options[i].selected=true;
	 }   
 function getValue()
 {
 	var code="";
 	for(var i=0;i<form.options.length;i++){   
	        if(form.options[i].selected==true)
	        {
	        	code=code+form.options[i].value+",";
	        }
	 }   
	self.returnValue = code;
	self.close();
 }
</SCRIPT>
	
</html>
