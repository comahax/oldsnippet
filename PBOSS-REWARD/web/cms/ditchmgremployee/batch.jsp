<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/head.inc"%>
<jsp:include page="/inc/acl.jsp">
  <jsp:param name="PID" value="2B7G1AD0BB" />
</jsp:include>


<html>
	<head>
		<title><bean:message bundle="employee" key="ditchmgrtitle" />
		</title>
		<script language="JavaScript" type="text/JavaScript">
function checkProcess(){
	var filename = formItem.filename.value;
	if(filename != null || filename != ""){
        formItem.buttonProcess.disabled=true;
    	window.location.href="<%=contextPath%>/cms/batchditchmgremployee/process.do?filename="+filename+"&beanname=com.sunrise.boss.ui.cms.batchditchmgremployee.BatchTaskBean";
    }
}
function doReturn(cmdReturn) {
    formItem.action = contextPath + cmdReturn;
    formItem.submit();
}
</script>
	</head>
	<body onload="if(window.loadforiframe) loadforiframe();">
		<div class="table_container">
			<html:form action="/cms/batchditchmgremployee/process.do?CMD=UPLOAD" enctype="multipart/form-data" styleId="formItem">
				<input type="hidden" name="filename" value="<c:out value='${requestScope.ITEM.inFile}'/>">
				<div class="table_div">
					<table class="top_table">
						<tr>
							<td >
								<bean:message bundle="employee" key="ditchmgrtitle" />
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
							<td width=10% align=right height=25>
								<bean:message bundle="upload" key="choose" />
							</td>
							<td align=left>
								<html:file styleClass="form_input_files" property="theFile" styleId="theFile"/>
							</td>
						</tr>
						<c:choose>
							<c:when test="${!empty requestScope.ITEM.inFile}">
								<tr class="table_style_content">
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
								<bean:message bundle="employee" key="ditchmgremployeeformat" /></td>
						
						</tr>
						<tr class="table_style_content">
							<td align=right height=25>
								<bean:message bundle="upload" key="example" />
							</td>
							<td align=left>
							<bean:message bundle="employee" key="ditchmgremployeexample" /></td>
						</tr>
						<tr class="table_style_content">
							<td align=right height=25>
								<bean:message bundle="employee" key="societysay" />
							</td>
							<td align=left>
								<bean:message bundle="employee" key="ditchmgremployeenote" /></td>
						</tr>
						<tr class="table_style_content">
							<td align=right height=25>
								<bean:message bundle="employee" key="guide" />
							</td>
							<td align=left>
								<a href="<%=contextPath%>/cms/common/importguide.htm"><bean:message bundle="employee" key="guide" /></a></td>
						</tr>
						<tr class="table_style_content">
							<td align=right height=25>
								<bean:message bundle="employee" key="model" />
							</td>
							<td align=left>
								<a href="<%=contextPath%>/cms/ditchmgremployee/ditchmgrimport.xls"><bean:message bundle="employee" key="ditchmgrmodelname" /></a>
								<bean:message bundle="employee" key="hint" /></td>
						</tr>
					
					</table>
				</div>
			<iframe src="<%=contextPath%>/commons/batch/commonStatus.jsp?beanname=com.sunrise.boss.ui.cms.batchditchmgremployee.BatchTaskBean"  frameborder="0" class="loadframe" id="loadframe"  scrolling="no"></iframe>
			<div class="table_div">
				<table class="table_button_list">
					<tr>
						<td>
						
							<input type="submit" value="<bean:message bundle="upload" key="upload" />" class="comfir"
								onmouseover="buttonover(this)" onmouseout="buttonout(this)" onfocus="buttonover(this)" onblur="buttonout(this)"
								ID="buttonUpload" NAME="buttonUpload">
					
							<input type="button" value="<bean:message bundle="upload" key="process"/>" class="button_4"
								onmouseover="buttonover(this)" onmouseout="buttonout(this)" onfocus="buttonover(this)" onblur="buttonout(this)"
								ID="buttonProcess" NAME="buttonProcess" onClick="checkProcess()" />
					
				
							<input type="button" onmouseover="buttonover(this);"
								onmouseout="buttonout(this);" name="btnReturn"
								onfocus="buttonover(this)" onblur="buttonout(this)"
								value="<bean:message bundle="public" key="button_return"/>"
								class="comfir" onclick="doReturn('/cms/ditchmgremployee.do?CMD=DITCHMGRLIST')">	
						
						</td>
					</tr>
				</table>
			</div>
			</html:form>
		</div>
	</body>
</html>
