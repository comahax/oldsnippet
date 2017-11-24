<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/contenthead.inc"%>

<html>
<head>
	<title>�ŵ�������Ϣ����</title>
	<script language="JavaScript" type="text/JavaScript">
		function doReturn() {
   		 	formItem.action ="<%=contextPath%>/channel/waystoreinfo_list.do";
   			formItem.submit();
		}

   	 	function doProcess(){ 
			var fileName = document.getElementById('doc').value;
			if(fileName == ''){
				 var alertstr = '<span class=\'errorkey\'><span style=\'color:#F00; font-size:12px;\'>��ѡ���ϴ����ļ�</span> ';
				errorMessageShow(alertstr);
				return false;
			}
			formItem.submit();
		}
		
		function addDirect(){
			var directCount = document.getElementById('directCount');
			var rowID = parseInt(directCount.value);
			 
			var directTable = document.getElementById('directTable');
			//�����
			var newTR = directTable.insertRow(directTable.rows.length);
			newTR.id = "directItem" + rowID;
			
			//�����:�ļ��ϴ���
			var newFileTD=newTR.insertCell(0);
			newFileTD.innerHTML = "<input type='file' name='doc' cssClass='form_text edit requiredSel' />";
			
			//�����:ɾ����ť
			var newDeleteTD=newTR.insertCell(1);
			newDeleteTD.innerHTML = "<input type='button' value='ɾ��' onclick=\"deleteDirect('directItem" + rowID + "')\" />";
			
			//�����:�հ���
			//var newNullTD=newTR.insertCell(2);
			//newNullTD.innerHTML = "";
			
			//����+1
			directCount.value = rowID + 1;
		}
		
		//ɾ��ָ����
		function deleteDirect(rowid){
			var directTable = document.getElementById('directTable');
			var directItem = document.getElementById(rowid);
			
			//��ȡ��Ҫɾ�����е�Index
			var rowIndex = directItem.rowIndex;
			
			//ɾ��ָ��Index����
			directTable.deleteRow(rowIndex);
		}
		
		//����б�
		function clearAllDirect(){
			if(confirm('ȷ��Ҫ�����')){
				var directTable = document.getElementById('directTable');
				var rowscount = directTable.rows.length;
				
				//ѭ��ɾ����,�����һ����ǰɾ��
				for(i=rowscount - 1;i > 0; i--){
					directTable.deleteRow(i);
				}
				
				//��������к�Ϊ1
				document.getElementById('directCount').value = "1";
				
			}
		}

    	
    	
    </script>
</head>
<body class="list_body" onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<s:form action="/channel/waystoreinfo_picbatch.do" cssStyle="formItem" key="formItem" method="post" theme="simple" enctype ="multipart/form-data" >
	<div class="table_top">
		<div class="table_topleft"></div>
		<div class="table_toparea_w">
			<s:i18n name="public">
			<span class="table_toparea"><s:text name="currentPos"/> </span>
			<span class="table_toparea_xi">&gt;</span>
			<span class="table_toparea"><s:text name="channel"/> </span>
			<span class="table_toparea_xi">&gt;</span>
			</s:i18n>
			<span class="table_toparea_h">�ŵ�������Ϣ����</span>
		</div>
	</div>
	    <input type="hidden" name="filename" value='<s:property value="fileName"/>'>
    <input type="hidden" name="path" value='<s:property value="filepath"/>'>
    <input type="hidden" name="iCheckFormat" value="com.gmcc.pboss.web.channel.waystoreinfo.WaystoreinfoCheck">
    <aa:zone name="errorZone">
		<div class="error_text" >
			<table class="error_text">
				<s:actionerror /><s:actionmessage/>
			</table>
		</div>
    </aa:zone>
    <aa:zone name="listZone">
    <div class="table_div">
        <table class="table_normal">
            <tr>
            	<td align="right">ѡ���ļ�: 	</td>
            	<td align="left">
            	<table id="directTable">
					<tr>
						<input type="hidden" name="directCount" id="directCount" value="1">
						<td><s:file name="doc" id="doc" label="File" /></td>
						<td><input type="button" value="���" onclick="addDirect();"></td>
						<td><input type="button" value="���" onclick="clearAllDirect();"><font color=red>*</span>  </td>
					</tr>
				</table>
            	</td>
            </tr>
            <tr>
				<td align="right" height=25>�ļ�����:</td>
				<td align="left"><font color=red>.jpg�ļ�</font></br>
			</tr>
			<tr>
				<td align="right" height=25>�ļ�������ʽ:</td>
				<td align="left">
					��ͷ��Ƭ��</br>
					<font color=red>�ŵ����_��ͷ��Ƭ</font></br>
					ר����Ƭ��</br>
					<font color=red>�ŵ����_ר����Ƭ</font>
				</td>
			</tr>
			<tr>
				<td align="right" height=25>����˵��:</td>
				<td align="left">
					��ͷ��Ƭ��</br>
					GDMDBM1_��ͷ��Ƭ</br>
					ר����Ƭ��</br>
					GDMDBM1_��ͷ��Ƭ
				</td>
			</tr>
			<tr>
				<td align="right" height=25>����˵��:</td>
				<td align="left">
						 ͼƬֻ֧��JPG��ʽ�����ϴ�����ͷ��Ƭ��ʽ����Ϊ���ŵ����_��ͷ��Ƭ.jpg����ר����Ƭ��ʽ����Ϊ���ŵ����_��ͷ��Ƭ.jpg��</br>
					</br><font color=red>�ļ���С���ܳ���3M��</font>
				</td>
			</tr>
        </table>
    </div>
    </aa:zone>
    <div class="table_div">
		<table class="table_button_list">
			<tr> 
				<td>
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
						<tr>
	                    <td align=right>
	                    <s:i18n name="public">
	                        <input type="button" id="buttonProcess" name="buttonProcess" class="button_New" onmouseover="buttonover(this);"
	                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)" 
	                            onclick="doProcess()" value="����">
	                            
	                        <input type="button" id="btnReturn" name="btnReturn" class="button_Back" onmouseover="buttonover(this);" 
                    	   		onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                           		value="<s:text name="button_return"/>" onclick="doReturn()">
                        </s:i18n>
	                    </td>
	                    </tr>
					</table>
				</td>
			</tr>
		</table>
	</div>

</s:form>
</div>
</body>
</html>