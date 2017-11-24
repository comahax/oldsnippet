<%@ page language="java" contentType="text/html;charset=GBK"%>
<jsp:include page="/inc/acl.jsp">
	<jsp:param name="PID" value="2B7G1A1ABB" />
</jsp:include>
<%@ include file="/inc/head.inc"%>
<html>
	<head>
		<title><bean:message bundle="adjustment" key="titleBatch" />
		</title>
		<script language="JavaScript" type="text/JavaScript">
function checkProcess(){
	var filename=formItem.filename.value;
	if(filename != null || filename != ""){
        formItem.buttonProcess.disabled=true;
    	window.location.href="<%=contextPath%>/cms/adjustment/process.do?filename="+filename+"&beanname=com.sunrise.boss.ui.cms.adjustment.BatchTaskBean";
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
			<html:form action="/cms/adjustment/upload.do" enctype="multipart/form-data" styleId="formItem">
				<input type="hidden" name="filename" value="<c:out value='${requestScope.ITEM.inFile}'/>">
				<div class="table_div">
					<table class="top_table">
						<tr>
							<td>
								<bean:message bundle="adjustment" key="titleBatch" />
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
								<font color='red'>�������� |�����·�(YYYYMM)|<c:if test="${sessionScope._hasupperopnid==1}">ҵ��������|</c:if></font>˰��|�������|<c:if test="${sessionScope._hasfees==1}">������|</c:if>��ע|
							</td>
						</tr>
						<tr class="table_style_content_lyl">
							<td align=right height=25>
								<bean:message bundle="upload" key="example" />
							</td>
							<td align=left>
								<font color=red>EDFS1070F|201208|<c:if test="${sessionScope._hasupperopnid==1}">0100000000000|</c:if></font>888.8888|25.55|<c:if test="${sessionScope._hasfees==1}">10.00|</c:if>��ע|<br/>
								<font color=red>EDFS1070F|201208|<c:if test="${sessionScope._hasupperopnid==1}">0200000000000|</c:if></font>888.8888|-200.50|<c:if test="${sessionScope._hasfees==1}">20.55|</c:if>��ע|<br/>
								<font color=red>EDFS1071F|201208|<c:if test="${sessionScope._hasupperopnid==1}">0300000000000|</c:if></font>||<c:if test="${sessionScope._hasfees==1}">|</c:if>|
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
								�ļ���ʽ���ú�ɫ��ǵ��ֶ�Ϊ������,�ļ������ޱ�����.<br/>
								��������:������;�ұ������ѹ�ѡ��������������/�����̱���.<br/>
								<c:if test="${sessionScope._hasupperopnid==1}">
								ҵ�������룺������;ȡֵ���£�<br/>
								0100000000000 �û�����������<br/>
								0200000000000 �мۿ�������<br/>
								0300000000000 ���ѷ����<br/>
								0600000000000 ��ֵҵ������<br/>
								0400000000000 �ն˷����<br/>
								0700000000000 ��������<br/>
								0500000000000 ���������<br/>
								0800000000000 ����ҵ������<br/>
								0900000000000 �������.<br/>
								</c:if>
								˰��:ѡ����,���Ϊ�����ʾ�����㵱�²����ƶ���˾����˰��,˰��Ϊ0;�����������֧��6λ�����ɾ�ȷ��С�����4λ.<br/>
								�������:ѡ����,���Ϊ�����ʾΪ0;�����������֧��6λ�����ɾ�ȷ��С�����4λ;������ʾ����,������ʾ�۷�.<br/>
								 <c:if test="${sessionScope._hasfees==1}">
								������:ѡ����,���Ϊ�գ����ʾ����Ҫ�ۼ������ѣ�������Ϊ0;�����������֧��6λ�����ɾ�ȷ��С�����4λ.<br/>
								 </c:if>
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
									class="close" onclick="doReturn('/cms/adjustment.do?CMD=SHOW')">
							</td>
						</tr>
					</table>
				</div>
			</html:form>
			<iframe scrolling="no"
				src="<%=contextPath%>/commons/batch/commonStatus.jsp?beanname=com.sunrise.boss.ui.cms.adjustment.BatchTaskBean"
				frameborder="0" class="loadframe" id="loadframe">
			</iframe>
			   
		</div>
	</body>
</html>
