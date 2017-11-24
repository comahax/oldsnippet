<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc"%>

<html>
	<head>
		<title><bean:message bundle="orderdetailquery" key="orderdetailquerytitle" /></title>
		<script language="JavaScript" type="text/JavaScript">
        function checkProcess(){
			var filename = formItem.filename.value;
			if(filename != null || filename != ""){
        		formItem.buttonProcess.disabled=true;
    			window.location.href="<%=contextPath%>/cms/opendate/upload.do?CMD=BATCH&filename="+filename+"&beanname=com.sunrise.boss.ui.cms.zjty.chzjtyopendate.BatchTaskBean";
    		}
		}
		function doReturn()
		{
			formItem.action="<%=contextPath%>/cms/zjty/opendate.do?CMD=LIST";
			formItem.submit();
		}
		</script>
		<script type="text/javascript" src="<%= contextPath %>/js/bus/waycommon.js"></script>
	</head>

	<body  onload="if(window.loadforiframe) loadforiframe();">
		<div class="table_container">
			<html:form action="/cms/opendate/upload.do?CMD=UPLOAD" enctype="multipart/form-data" styleId="formItem">

				<input type="hidden" name="filename" value="<c:out value='${requestScope.ITEM.inFile}'/>">
				<div class="table_div">
					<table class="top_table">
						<tr>
							<td width="210" class="AreaName" align="left" valign=middle>
								��������
							</td>
						</tr>
					</table>
				</div>
				<div class="table_div">
					<table class="error_text" width="100%">
						<html:errors />
						<s:Msg />
					</table>
				</div>
				<div class="table_div">
					<table class="form_table">
						<tr>
							<td width="126" height="20" align="right" class="form_table_right">
								<bean:message bundle="batchimportorder" key="selectfile" />
								:
							</td>
							<td class="form_table_left">
								<input type="file" class="form_input_files" name="theFile" ID="File1" />
							</td>
						</tr>
						<c:choose>
							<c:when test="${!empty requestScope.ITEM.inFile}">
								<tr class="table_style_content">
									<td align=right height=25>
										<bean:message bundle="upload" key="existfile" />
									</td>
									<td align=left>
										<a href='<%=contextPath%>/commons/batch/download.jsp?filename=<c:out
						value="${requestScope.ITEM.inFile}" />'> <c:out value="${requestScope.ITEM.fileName}" /> </a>
									</td>
								</tr>
							</c:when>
						</c:choose>
						<tr class="table_style_content">
							<td align=right height=25>
								����:
							</td>
							<td align=left>
								<html:select property="operType">
									<option value=0>����</option>
									<option value=1>�޸�</option>
									<option value=2>ɾ��</option>
								</html:select>
							</td>
						</tr>
						<tr class="table_style_content">
							<td align=right height=25>
								<bean:message bundle="upload" key="filetype" />
							</td>
							<td align=left>
								<bean:message bundle="upload" key="typevalue" />
							</td>
						</tr>
						<tr class="table_style_content">
							<td align=right height=25>
								<bean:message bundle="upload" key="filestyle" />
							</td>
							<td align=left>
								����/�޸ģ�<font color="red">��������</font>|<font color="red">��������(��ʽ:YYYYMMDD)</font>|<font color="blue">˵��</font>|<br>  
								ɾ����<font color="red">��������</font>|<br>
								ע����ɫ��Ϊ�����ɫ��Ϊ��ѡ����ѡ��Ϊ��ʱ�����뱣�������߷ָ���
							</td>
						</tr>
						<tr class="table_style_content">
							<td align=right height=25>
								<bean:message bundle="upload" key="example" />:
							</td>
							<td align=left>
								����/�޸ģ�JFJMXXXXX|20080902|MEMO<br>
								ɾ����JFJMXXXXX|
							</td>
						</tr>
						<tr class="table_style_content">
							<td align=right height=25>
								<bean:message bundle="chzjtyopendate" key="model" />
							</td>
							<td align=left>
								<a href="<%=contextPath%>/cms/zjty/chzjtyopendate/chzjtyopendate.xls"><bean:message bundle="chzjtyopendate" key="modelname" /></a>
								<bean:message bundle="zjtyrewardcoef" key="hint" /></td>
						</tr>
					</table>
				</div>
				<div class="table_div">
					<table class="table_button_list">
						<tr>
							<td align=right>

							<input type="submit" value="<bean:message bundle="upload" key="upload" />" class="comfir"
								onmouseover="buttonover(this)" onmouseout="buttonout(this)" onfocus="buttonover(this)" onblur="buttonout(this)"
								ID="buttonUpload" NAME="buttonUpload">

							<input type="button" value="<bean:message bundle="upload" key="process"/>" class="button_4"
								onmouseover="buttonover(this)" onmouseout="buttonout(this)" onfocus="buttonover(this)" onblur="buttonout(this)"
								ID="buttonProcess" NAME="buttonProcess" onClick="checkProcess()" />
								
							<input type="button" value="����" class="button_4"
								onmouseover="buttonover(this)" onmouseout="buttonout(this)" onfocus="buttonover(this)" onblur="buttonout(this)"
								ID="buttonProcess" NAME="buttonProcess" onClick="doReturn()" />
							</td>
						</tr>
					</table>
				</div>
			</html:form>
			<iframe src="<%=contextPath%>/commons/batch/commonStatus.jsp?beanname=com.sunrise.boss.ui.cms.zjty.chzjtyopendate.BatchTaskBean" frameborder="0" class="loadframe" id="loadframe" scrolling="no">
			</iframe>
		</div>
	</body>
</html>
