<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/head.inc"%>
<jsp:include page="/inc/acl.jsp">
  <jsp:param name="PID" value="2B7G1AD0BB" />
</jsp:include>


<html>
	<head>
		<title><bean:message bundle="busiwayrel" key="titleList" />
		</title>
		<script language="JavaScript" type="text/JavaScript">
function checkProcess(){
	var filename = formItem.filename.value;
	if(filename != null || filename != ""){
        formItem.buttonProcess.disabled=true;
    	window.location.href="<%=contextPath%>/cms/cityrewardad/upload.do?filename="+filename+"&beanname=com.sunrise.boss.ui.cms.cityrewardad.CityrewardadTaskBean";
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
			<html:form action="/cms/cityrewardad/upload.do?CMD=UPLOAD" enctype="multipart/form-data" styleId="formItem">
				<input type="hidden" name="filename" value="<c:out value='${requestScope.ITEM.inFile}'/>">
				<div class="table_div">
					<table class="top_table">
						<tr>
							<td >
								<bean:message bundle="cityrewardad" key="titleList" />
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
								<bean:message bundle="cityrewardad" key="cityrewardadformat" /></td>
						</tr>
						<tr class="table_style_content">
							<td align=right height=25>
								<bean:message bundle="upload" key="example" />
							</td>
							<td align=left>
							<bean:message bundle="cityrewardad" key="cityrewardadexample" /></td>
						</tr>
						<tr class="table_style_content">
							<td align=right height=25>
								<bean:message bundle="cityrewardad" key="societysay" />
							</td>
							<td align=left>
								<bean:message bundle="cityrewardad" key="cityrewardadasenote1" /><br>
								<bean:message bundle="cityrewardad" key="cityrewardadasenote2" /><br>
								<bean:message bundle="cityrewardad" key="cityrewardadasenote3" /><br>
								<bean:message bundle="cityrewardad" key="cityrewardadasenote4" />
							</td>
						</tr>
					</table>
				</div>
			<iframe src="<%=contextPath%>/commons/batch/commonStatus.jsp?beanname=com.sunrise.boss.ui.cms.cityrewardad.CityrewardadTaskBean"  frameborder="0" class="loadframe" id="loadframe"  scrolling="no"></iframe>
			<div class="table_div">
				<table class="table_button_list">
					<tr>
						<td>			
							<input type="submit" value="<bean:message bundle="upload" key="upload" />" class="button_2"
								onmouseover="buttonover(this)" onmouseout="buttonout(this)" onfocus="buttonover(this)" onblur="buttonout(this)"
								ID="buttonUpload" NAME="buttonUpload">
					
							<input type="button" value="<bean:message bundle="upload" key="process"/>" class="submit"
								onmouseover="buttonover(this)" onmouseout="buttonout(this)" onfocus="buttonover(this)" onblur="buttonout(this)"
								ID="buttonProcess" NAME="s" onClick="checkProcess()" />
								
							<input type="button" onmouseover="buttonover(this);"
								onmouseout="buttonout(this);" name="btnReturn"
								onfocus="buttonover(this)" onblur="buttonout(this)"
								value="<bean:message bundle="public" key="button_return"/>"
								class="close" onclick="doReturn('/cms/cityrewardad.do?CMD=LIST')">							
						</td>
					</tr>
				</table>
			</div>
			</html:form>
		</div>
	</body>
</html>
