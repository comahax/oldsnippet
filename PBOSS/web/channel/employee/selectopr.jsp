<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc" %>

<html>
	<head>
		<title><s:text name="title"/></title>
		<script language="JavaScript" type="text/JavaScript">       
        
		//���Ӳ���ѡ��
        function addItem() {
			var str = "";
			if($("#s1").val()!=null)
			{
				//���ѡȡ��ֵ����","ƴ�ӳ��ַ������������ظ���ѡ��
				var valStr = "";
				var nameStr = "";
				
				var dataLength = $("#s2").children().length;
				var dataArray = new Array(dataLength);
				$("#s2").children().each(function(i){
					dataArray[i] = this.value;
				});
				
				//�ظ���ʶ
				var hasMul;
				
				//��ȡѡȡֵ�ַ���
				$("#s1").children().each(function(i){
					if(this.selected && this.value!="-1")
				    {
				    	hasMul = false;
				    	for(var j=0; j<dataLength; j++)
				    	{
				    		if(this.value==dataArray[j])
				    		{
				    			hasMul = true;
				    		}
				    	}
				    	
				    	//�����ظ���������ѡ���ַ���
				    	if(!hasMul)
				    	{
				    		valStr = valStr + this.value + ",";
				   			nameStr = nameStr + this.ename + ",";
				    	}
				    }
				});
				
				//����ѡȡֵ����ѡ��
				if(valStr.length>0)
				{
					//ȥ��ĩβ��","
					valStr = valStr.substring(0,valStr.length-1);
					nameStr = nameStr.substring(0,nameStr.length-1);
					
					//��̬����ѡ��
					var valArray = valStr.split(",");
					var nameArray = nameStr.split(",");
					for(var i=0; i<valArray.length; i++)
					{
						str = str + "<option value=\"" + valArray[i] + "\" ename=\"" + nameArray[i] + "\">" +nameArray[i] + "</option>";
					}
					$("#s2").append(str);
				}
			}
			
        }
        
        //����ȫ��ѡ��
        function addAllItem() {
			$("#s1").children().each(function(i){
				$(this).attr("selected",true);
			});
			addItem();
			$("#s1").children().each(function(i){
				$(this).attr("selected",false);
			});
        }
        
        //�Ƴ�����ѡ��
        function outItem() {
			$("#s2").children().each(function(i){
				if(this.selected)
			    {
			    	$(this).remove();
			    }
			});
        }
        
        //�Ƴ�ȫ��ѡ��
        function outAllItem() {
			$("#s2").children().each(function(i){
				$(this).remove();
			});
        }
        
        //����
		function doConfirm() {
			var str = "";
			$("#s2").children().each(function(i){
				str = str + this.value + ",";
			});
			window.returnValue = str;
			window.close();
		}
		
    	</script>
	</head>

	<body>
			<div class="error_text">
				<table class="error_text">
					<s:actionerror /><s:actionmessage/>
				</table>
			</div>
			
			<div class="table_container">
				<div class="table_div">
					<table class="table_style">
						<tr class="table_style_content">
							<td align=left>
								��ѡ��
							</td>
							<td align=left></td>
							<td align=left>
								��ѡ��
							</td>
						</tr>
						<tr class="table_style_content">
							<td align=left>
								<select style="width:200px;height:350px" name="s1" id="s1" size="56" multiple="true" ondblclick="addItem(this);">
									<option value=0 ename="��ԱID">��ԱID</option>
									<option value=1 ename="BOSS����">BOSS����</option>
									<option value=2 ename="����">����</option>
									<option value=3 ename="�Ա�">�Ա�</option>
									<option value=4 ename="�ֻ���">�ֻ���</option>
									<option value=5 ename="���й�˾">���й�˾</option>
									<option value=6 ename="�ֹ�˾">�ֹ�˾</option>
									<option value=7 ename="������������">������������</option>
									<option value=8 ename="΢����">΢����</option>
									<option value=9 ename="������(��������)">������(��������)</option>
									<option value=10 ename="��λ">��λ</option>
									<option value=11 ename="��ְʱ��">��ְʱ��</option>
									<option value=12 ename="�ù�����">�ù�����</option>									
									<option value=13 ename="�ù�״̬">�ù�״̬</option>				
									<option value=14 ename="��������">��������</option>
									<option value=15 ename="�Ļ��̶�">�Ļ��̶�</option>
									<option value=16 ename="����">����</option>
									<option value=17 ename="������ò">������ò</option>
									<option value=18 ename="��ͥ��ַ">��ͥ��ַ</option>
									<option value=19 ename="����֤����">����֤����</option>
									<option value=20 ename="���˵�������">���˵�������</option>
									<option value=21 ename="��˾ר����ϵ��ʽ">��˾ר����ϵ��ʽ</option>
									<option value=22 ename="רҵ">רҵ</option>
									<option value=23 ename="�����ֻ�����">�����ֻ�����</option>
									<option value=24 ename="��ҵԺУ">��ҵԺУ</option>
									<option value=25 ename="��ҵʱ��">��ҵʱ��</option>
									<option value=26 ename="�Ͷ���ϵ">�Ͷ���ϵ</option>
									<option value=27 ename="��λ����">��λ����</option>
									<option value=28 ename="ְ��">ְ��</option>
									<option value=29 ename="���ڲ���">���ڲ���</option>
									<option value=30 ename="�μӹ�������">�μӹ�������</option>
									<option value=31 ename="��������˾">��������˾</option>
									<option value=32 ename="����˾��������">����˾��������</option>
									<option value=33 ename="����״��">����״��</option>
								</select>
							</td>
							<td align=left>
								<br />
								<input type="button" value=">" style="width:50px; height:20px; background-color:#ffffff" onclick="addItem()" />
								<br />
								<input type="button" value=">>" style="width:50px; height:20px; background-color:#ffffff" onclick="addAllItem()" />
								<br />
								<br />
								<input type="button" value="<" style="width:50px; height:20px; background-color:#ffffff" onclick="outItem()" />
								<br />
								<input type="button" value="<<" style="width:50px; height:20px; background-color:#ffffff" onclick="outAllItem()" />
								<br />
							</td>
							<td align="left">
								<select style="width:200px;height:350px" name="s2" id="s2" size="56" multiple="true" ondblclick="outItem(this);">
									<option value=0 ename="��ԱID">��ԱID</option>
									<option value=1 ename="BOSS����">BOSS����</option>
									<option value=2 ename="����">����</option>
									<option value=3 ename="�Ա�">�Ա�</option>
									<option value=4 ename="�ֻ���">�ֻ���</option>
									<option value=5 ename="���й�˾">���й�˾</option>
									<option value=6 ename="�ֹ�˾">�ֹ�˾</option>
									<option value=7 ename="������������">������������</option>
									<option value=9 ename="������(��������)">������(��������)</option>
									<option value=10 ename="��λ">��λ</option>
									<option value=11 ename="��ְʱ��">��ְʱ��</option>
									<option value=12 ename="�ù�����">�ù�����</option>
								</select>
							</td>
						</tr>
						<tr class="table_style_content">
							<td colspan="3" align="center">
								<input type="button" id="btnSave" name="btnSave" class="button_4" onmouseover="buttonover(this);" 
			                           onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
			                           value="ѡ�񵼳�" onclick="doConfirm()"/>
							</td>
					</table>
				</div>
			</div>
	</body>
</html>