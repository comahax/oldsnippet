<%@ page language="java" contentType="text/html;charset=GBK"%>
<jsp:include page="/inc/acl.jsp">
	<jsp:param name="PID" value="2B7G1A1ABB" />
</jsp:include>
<%@ include file="/inc/head.inc"%>
<html>
	<head>
		<title>��������
		</title>
		<script language="JavaScript" type="text/JavaScript">
function checkProcess(){
	var filename=formItem.filename.value;
	if(filename != null || filename != ""){
        formItem.buttonProcess.disabled=true;
    	window.location.href="<%=contextPath%>/cms/dcord/process.do?filename="+filename+"&beanname=com.sunrise.boss.ui.cms.dcord.BatchTaskBean";
    }
}

function doReturn(cmdReturn) {
    formItem.action = contextPath + cmdReturn;
    formItem.submit();
}
</script>
	</head>
	<body>
		<div class="table_container">
			<html:form action="/cms/dcord/upload.do" enctype="multipart/form-data" styleId="formItem">
				<input type="hidden" name="filename" value="<c:out value='${requestScope.ITEM.inFile}'/>">
				<div class="table_div">
					<table class="top_table">
						<tr>
							<td>
								��������
							</td>
						</tr>
					</table>
				</div>
				<div class="table_div">
					<table width="100%" class="error_text">
						<html:errors />
						<s:Msg />
					</table>
				</div>

				<div class="table_div">
					<table class="table_style" width="95%">
						<tr class="table_style_content_lyl">
							<td width=20% align=right height=25>
								<bean:message bundle="upload" key="choose" />
							</td>
							<td align=left>
								<input type="file" class="form_input_files" name="theFile" ID="File1" />
							</td>
						</tr>
						<c:choose>
							<c:when test="${!empty requestScope.ITEM.inFile}">
								<tr class="table_style_content_lyl">
									<td align=right height=25>
										<bean:message bundle="upload" key="existfile" />
									</td>
									<td align=left>
										<a href='<%=contextPath%>/commons/batch/download.jsp?filename=<c:out value="${requestScope.ITEM.inFile}" />'>
											<c:out value="${requestScope.ITEM.fileName}" /> 
										</a>
									</td>
								</tr>
							</c:when>
						</c:choose>
						<tr class="table_style_content_lyl">
							<td align=right height=25>
								<bean:message bundle="upload" key="filetype" />
							</td>
							<td align=left>
								<bean:message bundle="upload" key="typevalue" />
							</td>
						</tr>
						<tr class="table_style_content_lyl">
							<td align=right height=25>
								<bean:message bundle="upload" key="filestyle" />
							</td>
							<td align=left>
								��ʽһ��<font color='red'>��������|ҵ�����|�������|ҵ������(YYYYMM)|�����·�(YYYYMM)|����״̬|</font><br/>
								��ʽ����<font color='red'>���к�|����״̬|</font>
							</td>
						</tr>
						<tr class="table_style_content_lyl">
							<td align=right height=25>
								<bean:message bundle="upload" key="example" />
							</td>
							<td align=left>
								
								 	EDFS1070F|0702011000247|1|201207|201208|0|<br/>
									EDFS1070F|0702011000247|2|201208|201208|3|<br/>
									EDFS1070F|0702011000247|3|201208|201208|4|<br/>
									10005|0|<br/>
									10006|3|<br/>
									10007|4|<br/>
							</td>
						</tr>
						<tr class="table_style_content_lyl">
							<td width="20%" align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="adjustment" key="memo" />
									:
								</div>
							</td>
							<td width="75%" align="left" class="form_table_left">
								�ļ���ʽ���ú�ɫ��ǵ��ֶ�Ϊ������,�ļ������ޱ�����.���ָ�ʽ���ݿ��Ի����һ���ļ��ϴ�<br/>
								��������:������,�ұ����ǳ�������ϸ�����д��ڵ���������.<br/>
								ҵ����룺������,�ұ����ǳ�������ϸ�����д��ڵ�ҵ�����.<br/>
								���������������,�ϴ�����ͬ�������ϸ���ݵ�������ȡֵֻ����<font color=red>1��2��3</font>�е���ֵ.<br/>
								ҵ�����£�������,�ϴ�����ͬ�������ϸ���ݵ�ҵ����ʱ�侫ȷ���·ݣ�6λ��ֵ����201206.<br/>
								�����·�:������,�ϴ�����ͬ�������ϸ���ݵĽ����·�.<br/>
								����״̬��������,ȡֵֻ����<font color=red>��0�������㡿����3���ݹҡ�����4�����᡿</font>���ݹҺͶ���ĳ�𲻻����ڸ������㣬�����ڳ��˱�����Ӱ��.<br/>
								���кţ���ѯ�����������Ӧ�����к�.<br/>
								��ʾ:ÿ�β��������޸Ĳ���.<br/>
							</td>
						</tr>
					</table>
				</div>
				<div class="table_div">
					<table class="table_button_list">
						<tr>
							<td>
								<input type="submit" value="<bean:message bundle="upload" key="upload" />" class="button_4"
									onmouseover="buttonover(this)" onmouseout="buttonout(this)" onfocus="buttonover(this)" onblur="buttonout(this)"
									ID="buttonUpload" NAME="buttonUpload">
								<input type="button" value="<bean:message bundle="upload" key="process"/>" class="button_4"
									onmouseover="buttonover(this)" onmouseout="buttonout(this)" onfocus="buttonover(this)" onblur="buttonout(this)"
									ID="buttonProcess" NAME="buttonProcess" onClick="checkProcess()" />
								<input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);" name="btnReturn"
									onfocus="buttonover(this)" onblur="buttonout(this)" value="<bean:message bundle="public" key="button_return"/>"
									class="close" onclick="doReturn('/cms/dcord.do?CMD=SHOW')">
							</td>
						</tr>
					</table>
				</div>
			</html:form>
			<iframe scrolling="no"
				src="<%=contextPath%>/commons/batch/commonStatus.jsp?beanname=com.sunrise.boss.ui.cms.dcord.BatchTaskBean"
				frameborder="0" class="loadframe" id="loadframe">
			</iframe>
			   
		</div>
	</body>
</html>
