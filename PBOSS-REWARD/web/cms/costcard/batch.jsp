<%@ page language="java" contentType="text/html;charset=GBK"%>
<jsp:include page="/inc/acl.jsp">
	<jsp:param name="PID" value="2B7G1A1ABB" />
</jsp:include>
<%@ include file="/inc/head.inc"%>
<html>
	<head>
		<title><bean:message bundle="costcard" key="titleBatch" />
		</title>
		<script language="JavaScript" type="text/JavaScript">
function checkProcess(){
	var filename=formItem.filename.value;
	if(filename != null || filename != ""){
        formItem.buttonProcess.disabled=true;
    	window.location.href="<%=contextPath%>/cms/costcard/process.do?filename="+filename+"&beanname=com.sunrise.boss.ui.cms.costcard.BatchTaskBean";
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
			<html:form action="/cms/costcard/upload.do" enctype="multipart/form-data" styleId="formItem">
				<input type="hidden" name="filename" value="<c:out value='${requestScope.ITEM.inFile}'/>">
				<div class="table_div">
					<table class="top_table">
						<tr>
							<td>
								<bean:message bundle="costcard" key="titleBatch" />
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
						<tr class="table_style_content">
							<td width=20% align=right height=25>
								<bean:message bundle="upload" key="choose" />
							</td>
							<td align=left>
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
										<a href='<%=contextPath%>/commons/batch/download.jsp?filename=<c:out value="${requestScope.ITEM.inFile}" />'>
											<c:out value="${requestScope.ITEM.fileName}" /> 
										</a>
									</td>
								</tr>
							</c:when>
						</c:choose>
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
								渠道编码|结算月份（YYYYMM）|业务长码|销售数量(张)|
							</td>
						</tr>
						<tr class="table_style_content">
							<td align=right height=25>
								<bean:message bundle="upload" key="example" />
							</td>
							<td align=left>
								<font color=red> JFJM00000|200812|0101010100001|2|</font>
							</td>
						</tr>
						<tr class="table_style_content">
							<td width="20%" align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="cardsalebusi" key="ps" />
									:
								</div>
							</td>
							<td width="75%" align="left" class="form_table_left">
								 结算月份格式为YYYYMM:如:198212
							</td>
						</tr>
					</table>
				</div>
				<div class="table_div">
					<table class="table_button_list">
						<tr>
							<td>
								<input type="submit" value="<bean:message bundle="upload" key="upload" />" class="button_2"
									onmouseover="buttonover(this)" onmouseout="buttonout(this)" onfocus="buttonover(this)" onblur="buttonout(this)"
									ID="buttonUpload" NAME="buttonUpload">
								<%--屏蔽处理按钮<input type="button" value="<bean:message bundle="upload" key="process"/>" class="cancel"
									onmouseover="buttonover(this)" onmouseout="buttonout(this)" onfocus="buttonover(this)" onblur="buttonout(this)"
									ID="buttonProcess" NAME="buttonProcess" onClick="checkProcess()" />
								 --%>
								<input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);" name="btnReturn"
									onfocus="buttonover(this)" onblur="buttonout(this)" value="<bean:message bundle="public" key="button_return"/>"
									class="close" onclick="doReturn('/cms/costcard.do?CMD=LIST')">
							</td>
						</tr>
					</table>
				</div>
			</html:form>
			<iframe scrolling="no"
				src="<%=contextPath%>/commons/batch/commonStatus.jsp?beanname=com.sunrise.boss.ui.cms.costcard.BatchTaskBean"
				frameborder="0" class="loadframe" id="loadframe">
			</iframe>
			   
		</div>
	</body>
</html>
