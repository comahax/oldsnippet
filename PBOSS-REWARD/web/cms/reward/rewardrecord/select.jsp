<%@ page language="java" contentType="text/html;charset=GBK"%>
<%
//  contenthead.inc��content.jsp���ļ�ͷ��������JS��CSS�ȵ����ã�����content.jsp������������ļ�ͷ
%>
<%@ include file="/inc/contenthead.inc"%>


<html>
<head>
	<base target="_self">
	<title>����ѡ��</title>
</head>
<body>
			<div class="table_container">
				<table class="top_table">
					<tr>
						<td>
							����ѡ��
						</td>
					</tr>
				</table>
			
			   <select style="width:150px;height:150px" ID="oSelect" name="city">
				  <option value='GZ' ID='200'>����</option>
				  <option value='SZ' ID='755'>����</option>
				  <option value='ZH' ID='756'>�麣</option>
				  <option value='FS' ID='757'>��ɽ</option>
				  <option value='ST' ID='754'>��ͷ</option>
				  <option value='HZ' ID='752'>����</option>
				  <option value='ZJ' ID='759'>տ��</option>
				  <option value='JM' ID='750'>����</option>
				  <option value='ZQ' ID='758'>����</option>
				  <option value='SG' ID='751'>�ع�</option>
				  <option value='MZ' ID='753'>÷��</option>
				  <option value='DG' ID='769'>��ݸ</option>
				  <option value='ZS' ID='760'>��ɽ</option>
				  <option value='MM' ID='668'>ï��</option>
				  <option value='SW' ID='660'>��β</option>
				  <option value='CZ' ID='768'>����</option>
				  <option value='JY' ID='663'>����</option>
				  <option value='YJ' ID='662'>����</option>
				  <option value='QY' ID='763'>��Զ</option>
				  <option value='HY' ID='762'>��Դ</option>
				��<option value='YF' ID='766'>�Ƹ�</option>
			</select>
<br>
		<input type="radio" name="filetype" value="total" checked>����
		<input type="radio" name="filetype" value="net">������
		<br>
			<input type=button class="button_5"  onmouseover="buttonover(this);" 
				onmouseout="buttonout(this);" onfocus="buttonover(this)" 
				onblur="buttonout(this)"  value="ȷ��"
				onclick="getValue()">
				
			<input type=button class="button_5"  onmouseover="buttonover(this);" 
				onmouseout="buttonout(this);" onfocus="buttonover(this)" 
				onblur="buttonout(this)"  value="ȡ��"
				onclick="cancel()">
			</div>
</body>
<SCRIPT>
 function getValue()
 {
 	var ip="";
����var rPort = document.all.filetype;
����for(i=0;i<rPort.length;i++)
����{
     ����if(rPort[i].checked)
       ����ip=rPort[i].value;
����}
 	var code="";
	code=code+"FILETYPE="+ip+"&CITY="+document.all("city").value;
	self.returnValue = code;
	self.close();
 }
 function cancel()
 {
 	self.close();
 }
</SCRIPT>
	
</html>
