<%@ page language="java" contentType="text/html;charset=GBK"%>
<%
//  contenthead.inc��content.jsp���ļ�ͷ��������JS��CSS�ȵ����ã�����content.jsp������������ļ�ͷ
%>
<%@ include file="/inc/contenthead.inc"%>


<html>
<head>
	<title>��ѡ��Ҫ�������ֶ�</title>
</head>
<body>
			<div class="table_container">
				<table class="top_table">
					<tr>
						<td>
							ѡ��Ҫ�������ֶ�
						</td>
					</tr>
				</table>
			
			<select style="width:200px;height:250px" ID="oSelect" name="batchButton" size="56" multiple>
				<option value=0>�հ׿����к�</option>
				<option value=1>�ֹ�˾</option>
				<option value=2>������������</option>
				<option value=3>΢����</option>
				<option value=4>��������</option>
				<option value=5>�������</option>
				<option value=6>��������</option>
				<option value=7>�Ǽ�</option>
				<option value=8>״̬</option>
				<option value=9>�հ�SIM������</option>
			</select><br>
			<input type=button class="button_5"  onmouseover="buttonover(this);" 
				onmouseout="buttonout(this);" onfocus="buttonover(this)" 
				onblur="buttonout(this)"  value="ѡ�񲢵���"
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
