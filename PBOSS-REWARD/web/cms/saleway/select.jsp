<%@ page language="java" contentType="text/html;charset=GBK"%>
<%
//  contenthead.inc��content.jsp���ļ�ͷ��������JS��CSS�ȵ����ã�����content.jsp������������ļ�ͷ
%>
<%@ include file="/inc/contenthead.inc"%>


<html>
<head>
	<title>��ѡ��Ҫ�������ֶ�</title>
	<script>
		var str="��������|��������|�����������|�ϼ���������|�Ǽ�|������|״̬|���й�˾|�ֹ�˾|������������|΢����|�Ƿ�ֱ��|"+
		"��������|��������|ҵ̬����|������ʼʱ��|Ӫҵ���|����������|���������������ԱID|�ּ�|�ɼ�ƽ̨�����ֻ���|"+
		"ҵ��Ԥ����|��ϸ��ַ|����γ��|������|ҵ������|ҵ���绰|ҵ���̶��绰|ҵ����������|�ͻ���ַ|�ջ���ϵ��|"+
		"�ջ���ϵ����|�ջ���֤������|ǩԼ����|��ͬ����|��ͬЭ������|ǩ���ͬʱ��|��ͬЭ����Чʱ��|��ͬ������|"+
		"Ӫҵִ�ձ��|Ӫҵִ����Ч��|��֤����|��֤��Ѻ��״̬|��֤������|���֧����������|���֧�������˺�|"+
		"���֧���ʺ�����|���������֤����|ǩԼ״̬|��֤�𽻸���ʽ|��Ӫ��Χ|ȫʡ����|���๺�����������ʺ�|"+
		"���๺�������˺�����|���๺�����ۿ�������|�����̱���|�Ƿ����B2Mģʽ|���������ʶ";
    </script>
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
			
			<select style="width:150px;height:450px" ID="oSelect" name="batchButton" size="56" multiple>
				<option value=0>��������</option>
				<option value=1>��������</option>
				<option value=2>�����������</option>
				<option value=3>�ϼ���������</option>
				<option value=4>�Ǽ�</option>
				<option value=5>������</option>
				<option value=6>״̬</option>
				<option value=7>���й�˾</option>
				<option value=8>�ֹ�˾</option>
				<option value=9>������������</option>
				<option value=10>΢����</option>
				<option value=11>�Ƿ�ֱ��</option>
				<option value=12>��������</option>
				<option value=13>��������</option>
				<option value=14>ҵ̬����</option>
				<option value=15>������ʼʱ��</option>
				<option value=16>Ӫҵ���</option>
				<option value=17>����������</option>
				<option value=18>���������������ԱID</option>
				<option value=19>�ּ�</option>
				<option value=20>�ɼ�ƽ̨�����ֻ���</option>
				<option value=21>ҵ��Ԥ����</option>
				<option value=22>��ϸ��ַ</option>
				<option value=23>����γ��</option>
				<option value=24>������</option>
				<option value=25>ҵ������</option>
				<option value=26>ҵ���绰</option>
				<option value=27>ҵ���̶��绰</option>
				<option value=28>ҵ����������</option>
				<option value=29>�ͻ���ַ</option>
				<option value=30>�ջ���ϵ��</option>
				<option value=31>�ջ���ϵ����</option>
				<option value=32>�ջ���֤������</option>
				<option value=33>ǩԼ����</option>
				<option value=34>��ͬ����</option>
				<option value=35>��ͬЭ������</option>
				<option value=36>ǩ���ͬʱ��</option>
				<option value=37>��ͬЭ����Чʱ��</option>
				<option value=38>��ͬ������</option>
				<option value=39>Ӫҵִ�ձ��</option>
				<option value=40>Ӫҵִ����Ч��</option>
				<option value=41>��֤����</option>
				<option value=42>��֤��Ѻ��״̬</option>
				<option value=43>��֤������</option>
				<option value=44>���֧����������</option>
				<option value=45>���֧�������˺�</option>
				<option value=46>���֧���ʺ�����</option>
				<option value=47>���������֤����</option>
				<option value=48>ǩԼ״̬</option>
				<option value=49>��֤�𽻸���ʽ</option>
				<option value=50>��Ӫ��Χ</option>
				<option value=51>ȫʡ����</option>
				<option value=52>���๺�����������ʺ�</option>
				<option value=53>���๺�������˺�����</option>
				<option value=54>���๺�����ۿ�������</option>
				<option value=55>�����̱���</option>
				<option value=56>�Ƿ����B2Mģʽ</option>
				<option value=57>���������ʶ</option>
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
