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
			
			<select style="width:200px;height:350px" ID="oSelect" name="batchButton" size="56" multiple>
				<option value=0>人员编号</option>
				<option value=1>姓名</option>
				<option value=2>出生年月</option>
				<option value=3>性别</option>
				<option value=4>用工状态</option>
				<option value=5>身份证号码</option>
				<option value=6>联系电话</option>
				<option value=7>地市公司</option>
				<option value=8>分公司</option>
				<option value=9>服务销售中心</option>
				<option value=10>渠道编号</option>
				<option value=11>渠道名称</option>
				<option value=12>入职时间</option>
				<option value=13>用工性质</option>
				<option value=14>保证金</option>
				<option value=15>公务机号码</option>
				<option value=16>是否为店主</option>
				<option value=17>网点确认码</option>
				<option value=18>空中选号手机号</option>
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
