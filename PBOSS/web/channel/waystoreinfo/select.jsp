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
			
			<select style="width:200px;height:450px" ID="oSelect" name="batchButton" size="56" multiple>
				<option value=0>��������</option>
				<option value=1>��������</option>
				<option value=2>�����������</option>
				<option value=3>�ϼ���������</option>
				<option value=4>�ϼ���������</option>
				<option value=5>�Ǽ�</option>
				<option value=6>������</option>
				<option value=7>״̬</option>
				<option value=8>���й�˾</option>
				<option value=9>�ֹ�˾</option>
				<option value=10>������������</option>
				<option value=11>΢����</option>
				<option value=12>�Ƿ�ֱ��</option>
				<option value=13>��������</option>
				<option value=14>��������</option>
				<option value=15>ҵ̬����</option>
				<option value=16>������ʼʱ��</option>
				<option value=17>Ӫҵ���</option>
				<option value=18>����������</option>
				<option value=19>���������������ԱID</option>
				<option value=20>�ּ�</option>
				<option value=21>�ɼ�ƽ̨�����ֻ���</option>
				<option value=22>ҵ��Ԥ����</option>
				<option value=23>��ϸ��ַ</option>
				<option value=24>����γ��</option>
				<option value=25>������</option>
				<!-- ���� �Ƿ���Ȩ���� �ĵ���  -->
				<option value=26>�Ƿ���Ȩ����</option>
				<option value=27>ҵ������</option>
				<option value=28>ҵ���绰</option>
				<option value=29>ҵ���̶��绰</option>
				<option value=30>ҵ����������</option>
				<option value=31>�ͻ���ַ</option>
				<option value=32>�ջ���ϵ��</option>
				<option value=33>�ջ���ϵ����</option>
				<option value=34>�ջ���֤������</option>
				<option value=35>ǩԼ����</option>
				<option value=36>��ͬ����</option>
				<option value=37>��ͬЭ������</option>
				<option value=38>ǩ���ͬʱ��</option>
				<option value=39>��ͬЭ����Чʱ��</option>
				<option value=40>��ͬ������</option>
				<option value=41>Ӫҵִ�ձ��</option>
				<option value=42>Ӫҵִ����Ч��</option>
				<option value=43>��֤����</option>
				<option value=44>��֤��Ѻ��״̬</option>
				<option value=45>��֤������</option>
				<option value=46>���֧����������</option>
				<option value=47>���֧�������˺�</option>
				<option value=48>���֧���ʺ�����</option>
				<option value=49>���������֤����</option>
				<option value=50>ǩԼ״̬</option>
				<option value=51>��֤�𽻸���ʽ</option>
				<option value=52>��Ӫ��Χ</option>
				<option value=53>ȫʡ����</option>
				<option value=54>���๺�����������ʺ�</option>
				<option value=55>���๺�������˺�����</option>
				<option value=56>���๺�����ۿ�������</option>
				<option value=57>�����̱���</option>
				<option value=58>�Ƿ����B2Mģʽ</option>
				<option value=59>�˺�����</option>
				<option value=60>���๺���������б�ʶ</option>
				<option value=61>���๺����������״̬</option>
				<option value=62>��������</option>
				<option value=63>�Ǽ��ֲ�</option>
				<option value=64>�Ƿ�TOP����</option>
				<option value=65>��Ȧ����</option>
				<option value=66>�����������</option>
				<option value=67>������Ȧ����</option>
				<option value=68>����������������</option>
				<option value=69>������������ϵ��</option>
				<option value=70>���õȼ�</option>
				<option value=71>˰������</option>
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
