<%@ page language="java" contentType="text/html;charset=GBK"%>
<jsp:include page="/inc/acl.jsp">
	<jsp:param name="PID" value="2B7G1A1ABB" />
</jsp:include>
<%@ include file="/inc/head.inc"%>
<html>
	<head>
		<title><bean:message bundle="personalbusi" key="batchAdd" />
		</title>
		<script language="JavaScript" type="text/JavaScript">
function checkProcess(){
	var filename=formItem.filename.value;
	if(filename != null || filename != ""){
        formItem.buttonProcess.disabled=true;
    	window.location.href="<%=contextPath%>/cms/personalbusi/process.do?filename="+filename+"&beanname=com.sunrise.boss.ui.cms.personalbusi.BatchTaskBean";
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
			<html:form action="/cms/personalbusi/upload.do" enctype="multipart/form-data" styleId="formItem">
				<input type="hidden" name="filename" value="<c:out value='${requestScope.ITEM.inFile}'/>">
				<div class="table_div">
					<table class="top_table">
						<tr>
							<td>
								<bean:message bundle="personalbusi" key="batchAdd" />
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
								号码|渠道编码|业务分类信息编码|品牌|办理时间|操作类型|
							</td>
						</tr>
						<tr class="table_style_content">
							<td align=right height=25>
								<bean:message bundle="upload" key="example" />
							</td>
							<td align=left>
								<font color=red> 13556119927|JFJM00000|0101010100001|2|2008-02-02 12:33:44|I| </font>
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
								<bean:message bundle="cardsalebusi" key="psinfo" />
								<br>操作类型:I:新增U:修改,D:删除或取消
							</td>
						</tr>
					</table>
				</div>
				<div class="table_div">
					<table class="table_button_list">
						<tr>
							<td>
								<input type="submit" value="<bean:message bundle="upload" key="upload" />" class="comfir"
									onmouseover="buttonover(this)" onmouseout="buttonout(this)" onfocus="buttonover(this)" onblur="buttonout(this)"
									ID="buttonUpload" NAME="buttonUpload">
								<input type="button" value="<bean:message bundle="upload" key="process"/>" class="cancel"
									onmouseover="buttonover(this)" onmouseout="buttonout(this)" onfocus="buttonover(this)" onblur="buttonout(this)"
									ID="buttonProcess" NAME="buttonProcess" onClick="checkProcess()" />
								<input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);" name="btnReturn"
									onfocus="buttonover(this)" onblur="buttonout(this)" value="<bean:message bundle="public" key="button_return"/>"
									class="close" onclick="doReturn('/cms/personalbusi.do?CMD=LIST')">
							</td>
						</tr>
					</table>
				</div>
			</html:form>
			<iframe scrolling="no"
				src="<%=contextPath%>/commons/batch/commonStatus.jsp?beanname=com.sunrise.boss.ui.cms.personalbusi.BatchTaskBean"
				frameborder="0" class="loadframe" id="loadframe">
			</iframe>
			   
		</div>
	</body>
</html>
