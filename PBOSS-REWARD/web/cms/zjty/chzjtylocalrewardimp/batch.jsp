<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc"%>
<html:html>
<head>
	<title>�Խ���Ӫ��𱨱���</title>
	<script language="JavaScript">
		function checkProcess(){
			var filename=formItem.filename.value;
			if(filename != null || filename != ""){
          		formItem.buttonProcess.disabled=true;
	      		window.location.href="<%= contextPath%>/cms/zjty/zjtyrewardimpbatch.do?filename="+filename+"&beanname=com.sunrise.boss.ui.cms.zjty.chzjtylocalrewardimp.ChZjtyRewardImpTaskBean";
			}
		}
		
		function showDiv(select) {
			var rewardzjtyreport = select.value;
			document.getElementById("explain").style.display="none";
			document.getElementById("templet").style.display="none";
			document.getElementById("txttype").style.display="none";
			document.getElementById("xlstype").style.display="none";
			document.getElementById("gotonetemplet").style.display="none";
			document.getElementById("nogotonetemplet").style.display="none";
			
			document.getElementById("REWARDTOTAL").style.display="none";
			document.getElementById("REWARDTOTAL1").style.display="none";
			document.getElementById("GDREWARDTOTAL").style.display="none";
			document.getElementById("GDREWARDTOTAL1").style.display="none";
			document.getElementById("PERCONFIGTOTAL").style.display="none";
			document.getElementById("PERCONFIGTOTAL1").style.display="none";
			document.getElementById("PERCONFIGDETAIL").style.display="none";
			document.getElementById("PERCONFIGDETAIL1").style.display="none";
			document.getElementById("JJREWARDTOTAL").style.display="none";
			document.getElementById("JJREWARDTOTAL1").style.display="none";
			document.getElementById("REWARDBUSINESS").style.display="none";
			document.getElementById("REWARDBUSINESS1").style.display="none";
			document.getElementById("ZDSALEREWARD").style.display="none";
			document.getElementById("ZDSALEREWARD1").style.display="none";
			document.getElementById("GOTONEDETAIL").style.display="none";
			
			if(rewardzjtyreport=='GOTONEDETAIL'){
				document.getElementById("templet").style.display="block";
				document.getElementById("xlstype").style.display="block";
				document.getElementById("gotonetemplet").style.display="block";
				document.getElementById("GOTONEDETAIL").style.display="block";
			} else if (rewardzjtyreport=='NOGOTONEDETAIL') {
				document.getElementById("templet").style.display="block";
				document.getElementById("xlstype").style.display="block";
				document.getElementById("nogotonetemplet").style.display="block";
				document.getElementById("GOTONEDETAIL").style.display="block";
			} else {
				document.getElementById("explain").style.display="block";
				document.getElementById("txttype").style.display="block";
			}
			
			if (rewardzjtyreport=='REWARDTOTAL') {
				document.getElementById("REWARDTOTAL").style.display="block";
				document.getElementById("REWARDTOTAL1").style.display="block";
			} else if (rewardzjtyreport=='GDREWARDTOTAL') {
				document.getElementById("GDREWARDTOTAL").style.display="block";
				document.getElementById("GDREWARDTOTAL1").style.display="block";
			} else if (rewardzjtyreport=='PERCONFIGTOTAL') {
				document.getElementById("PERCONFIGTOTAL").style.display="block";
				document.getElementById("PERCONFIGTOTAL1").style.display="block";
			} else if (rewardzjtyreport=='PERCONFIGDETAIL') {
				document.getElementById("PERCONFIGDETAIL").style.display="block";
				document.getElementById("PERCONFIGDETAIL1").style.display="block";
			} else if (rewardzjtyreport=='JJREWARDTOTAL') {
				document.getElementById("JJREWARDTOTAL").style.display="block";
				document.getElementById("JJREWARDTOTAL1").style.display="block";
			} else if (rewardzjtyreport=='REWARDBUSINESS') {
				document.getElementById("REWARDBUSINESS").style.display="block";
				document.getElementById("REWARDBUSINESS1").style.display="block";
			} else if (rewardzjtyreport=='ZDSALEREWARD') {
				document.getElementById("ZDSALEREWARD").style.display="block";
				document.getElementById("ZDSALEREWARD1").style.display="block";
			}
		}
		
		function uploadSubmit(){
			var reporttime = formItem.rewardreporttime.value;
			if (reporttime == null || reporttime == "") {
				alert("�·ݲ���Ϊ�գ�������");
				formItem.rewardreporttime.focus();
				return false;
			}
			document.formItem.submit();
		}
    </script>
</head>
<body onload="loadforiframe();showDiv(document.getElementById('rewardzjtyreport'))">
<div class="table_container">
	<html:form action="/cms/zjty/zjtyrewardimpbatch.do?CMD=UPLOAD" styleId="formItem" method="post" enctype="multipart/form-data">
		<input type="hidden" name="filename" value="<c:out value='${requestScope.ITEM.inFile}'/>">		
			<div class="table_div">
				<table class="top_table">
					<tr>
						<td>�Խ���Ӫ��𱨱���</td>
					</tr>
				</table>
		    </div>
			<div class="table_div">
			<table width="100%" class="error_text">
	        	<s:Msg />
	   		</table>
	   		</div>
	   		<div class="table_div">
			<table class="form_table">	
				<tr>
					<td width="20%" align="right" class="form_table_right">
						<div class="field-require">�����·�:</div>
					</td>
					<td width="75%" align="left" class="form_table_left">
						<html:text styleClass="form_input_1x" property="rewardreporttime" styleId="rewardreporttime" onclick="WdatePicker({dateFmt:'yyyyMM', maxDate:'%y {%M}'})" readonly="true"></html:text>
						<font color="red">*</font>
					</td>
				</tr>
				<tr>
					<td width="20%" align="right" class="form_table_right">
						<div class="field-require">��������:</div>
					</td>
					<td width="75%" align="left" class="form_table_left">
						<html:select property="rewardzjtyreport" onchange="showDiv(this);">
							<s:Options definition="$REWARD_ZJTYREPORT"/>
						</html:select>
						<font color="red">*</font>
					</td>
				</tr>
				<tr>
					<td width="20%" align="right" class="form_table_right">
						<div class="field-require">ѡ���ϴ��ļ�:</div>
					</td>
					<td width="75%" align="left" class="form_table_left">
						<html:file styleClass="form_input_files" property="theFile"/>
					</td>
				</tr>
				<c:choose>
					<c:when test="${!empty requestScope.ITEM.inFile}">
						<tr>
							<td align=right height=25>
								<bean:message bundle="upload" key="existfile" />
							</td>
							<td align=left>
								<a href='<%=contextPath%>/commons/batch/download.jsp?filename=
								<c:out value="${requestScope.ITEM.inFile}" />'>
								<c:out value="${requestScope.ITEM.fileName}" /> </a>
							</td>
						</tr>
					</c:when>
				</c:choose>
				<tr>
					<td align=right height=25>
						<bean:message bundle="upload" key="filetype" />
					</td>
					<td align=left>
						<div id="txttype" style="display: none" class="field-require"><bean:message bundle="upload" key="typevalue" /></div>
						<div id="xlstype" style="display: none" class="field-require">.xls�ļ�&nbsp;<font color="red">(ע����֧��Excel 97-2003��xls�ĵ�)</font></div>
					</td>
				</tr>
				<tr>
					<td width="20%" align="right" class="form_table_right">
						<div class="field-require">
							�ļ���ʽ :
						</div>
					</td>
					<td width="75%" align="left" class="form_table_left" nowrap="false">
						<div id="REWARDTOTAL" style="display: none" class="field-require">������|��˾���|�й�˾|�Խ���Ӫ������|BOSS��������|�̶�����ܶ�|�Ƽ�����ܶ�|������ۼ�|ҵ��ۼ�|����ܼ�</div>
						<div id="GDREWARDTOTAL" style="display: none" class="field-require">������|��˾���|�й�˾|�Խ���Ӫ������|��������|������Ա�ܼ�|�̶������|��Ӫ������ÿ۳�|С��</div>
						<div id="PERCONFIGTOTAL" style="display: none" class="field-require">������|��˾���|�й�˾|�Խ���Ӫ��|��������|������Ա�ܼ�</div>
						<div id="PERCONFIGDETAIL" style="display: none" class="field-require">����������|�й�˾|�ֹ�˾|��������|��������|����|ְλ|BOSS����|���ſ�ͨʱ��|��֤���|��ϵ�绰</div>
						<div id="JJREWARDTOTAL" style="display: none" class="field-require">
							������|��˾���|�й�˾|�Խ���Ӫ������|ȫ��ͨ�����źų��|Ԥ����תȫ��ͨ���|���еش��׿����۳��|<br>
							�������׿����۳��|��ֵҵ����|�����ն˳��|�ۺ�ҵ����|����ҵ����|���еش����Ŀ�����Ϣ���׿����������߳��|<br>
							��ͥ����������|����ҵ����|����ҵ����|���й�˾Ӫ���ص���ҵ����|ȫ��ͨ�źų��ۼ�|�ϼ�</div>
						<div id="REWARDBUSINESS" style="display: none" class="field-require">
							������|��˾���|�й�˾|�Խ���Ӫ������|ȫ��ͨ�����źų��|Ԥ����תȫ��ͨ|���еش��׿����۳��|�������׿����۳��|<br>
							��ֵҵ����|�����ն˳��|�ۺ�ҵ����|����ҵ����|���еش����Ŀ�����Ϣ���׿����������߳��|��ͥ����������|<br>
							����ҵ����|����ҵ����|���й�˾Ӫ���ص���ҵ����|�ϼ�</div>
						<div id="ZDSALEREWARD" style="display: none" class="field-require">
							������|����|Ӫҵ������|�����ն�������Լ��|�����ն��������Լ|�����ն��������|�����ն������ϼ�|<br>
							����������ն�������Լ��|����������ն��������Լ|����������ն��������|����������ն������ϼ�|<br>
							�����ն˳���Լ��|�����ն˳�����Լ|�����ն˳�����|�����ն˳��ϼ�|����������ն˳���Լ��|<br>
							����������ն˳�����Լ|����������ն˳�����|����������ն˳��ϼ�</div>
						<div id="GOTONEDETAIL" style="display: none" class="field-require">
							<font color="red">�ļ��ﲻҪ�����У��ұ�ͷ��������Ҫɾ����ͷ</font>
						</div>
					</td>
				</tr>
				<tr style="display: none" id="explain">
					<td width="20%" align="right" class="form_table_right">
						<div class="field-require">
							����˵��:
						</div>
					</td>
					<td width="75%" align="left" class="form_table_left" nowrap="false">
						<div id="REWARDTOTAL1" style="display: none" class="field-require">�㶫����|���๫˾|����|�ĻὭ�ȷ�Ӫ��|ZQ_HAZQ31003|0|0|0|0|0</div>
						<div id="GDREWARDTOTAL1" style="display: none" class="field-require">�㶫����|���๫˾|����|�ĻὭ�ȷ�Ӫ��|2008-12-9|4|1000|0|4000</div>
						<div id="PERCONFIGTOTAL1" style="display: none" class="field-require">�㶫����|���๫˾|����|�ĻὭ�ȷ�Ӫ��|2008-12-9|4</div>
						<div id="PERCONFIGDETAIL1" style="display: none" class="field-require">�㶫����|����|��Ҫ|HAZQ25113|��ҪС���Ӫ��|����|���澭��|HZQ2AC0007|2009-6-30|�߼�|13800000000</div>
						<div id="JJREWARDTOTAL1" style="display: none" class="field-require">�㶫����|���๫˾|����|�ĻὭ�ȷ�Ӫ��|0|0|0|0|0|0|0|0|0|0|0|0|0|0|0</div>
						<div id="REWARDBUSINESS1" style="display: none" class="field-require">�㶫����|���๫˾|����|�ĻὭ�ȷ�Ӫ��|1|1|1|1|1|1|1|1|1|1|1|1|1|1</div>
						<div id="ZDSALEREWARD1" style="display: none" class="field-require">�㶫����|����|�ĻὭ�ȷ�Ӫ��|1|1|1|1|1|1|1|1|1|1|1|1|1|1|1|1</div>
					</td>
				</tr>
				<tr style="display: none" id="templet">
					<td width="20%" align="right" class="form_table_right">
						<div class="field-require">
							Excel��дģ��:
						</div>
					</td>
					<td width="75%" align="left" class="form_table_left" nowrap="false">
						<div id="gotonetemplet" style="display: none" class="field-require"><a href="<%=contextPath%>/cms/zjty/chzjtylocalrewardimp/gotonedetail.xls">ȫ��ͨ���������ϸ.xls</a></div>
						<div id="nogotonetemplet" style="display: none" class="field-require"><a href="<%=contextPath%>/cms/zjty/chzjtylocalrewardimp/nogotonedetail.xls">��ȫ��ͨ���������ϸ.xls</a></div>
					</td>
				</tr>
			</table>
		</div>
		<iframe src="<%=contextPath%>/commons/batch/commonStatus.jsp?beanname=com.sunrise.boss.ui.cms.zjty.chzjtylocalrewardimp.ChZjtyRewardImpTaskBean"
				frameborder="0" class="loadframe" id="loadframe" scrolling="no">
		</iframe>
        <div class="table_div">
				<table class="table_button_list">
					<tr>
						<td>
							<input type="button" value="<bean:message bundle="upload" key="upload" />" class="button_4"
								onmouseover="buttonover(this)" onmouseout="buttonout(this)" onfocus="buttonover(this)" onblur="buttonout(this)"
								ID="buttonUpload" NAME="buttonUpload" onclick="uploadSubmit();"/>
							<input type="button" value="<bean:message bundle="upload" key="process"/>" class="button_4"
								onmouseover="buttonover(this)" onmouseout="buttonout(this)" onfocus="buttonover(this)" onblur="buttonout(this)"
								ID="buttonProcess" NAME="buttonProcess" onClick="checkProcess()" />
						</td>
					</tr>
				</table>
			</div>
	</html:form> 
	<br>
	</div>
</body>
</html:html>
