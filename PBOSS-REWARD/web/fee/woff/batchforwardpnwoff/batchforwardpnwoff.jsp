<%@ page language="java" contentType="text/html;charset=GBK"%>
<%--@page import="com.sunrise.business.resmanage.syscode.persistant.*"--%>
<%@ include file="/inc/listhead.inc"%>
<jsp:include page="/inc/acl.jsp">
  <jsp:param name="PID" value="4D6F1A4D" />
</jsp:include>
<%
    String ID_1 = "4D6F1A4DBT1";
    String ID_2 = "4D6F1A4DBT2";
%>
<html>
<head>
<title><bean:message bundle="batchforwardpnwoff" key="title" /></title>
<script language="JavaScript" type="text/JavaScript">
function checkProcess() {
	var filename = formItem.filename.value;
	if(filename != null || filename != "") {
    	formItem.Button7.disabled=true;
	    window.location.href="<%=contextPath%>/fee/woff/batchforwardpnwoff.do?filename="+filename+"&beanname=com.sunrise.boss.ui.fee.woff.batchforwardpnwoff.BatchforwardpnwoffTaskBean";
	}
}
</script>
</head>
<body onload="loadforiframe();">
<div class="table_container">
<html:form action="/fee/woff/batchforwardpnwoff/upload.do"
	enctype="multipart/form-data" styleId="formItem">
	<input type="hidden" name="filename"
		value="<c:out value='${requestScope.ITEM.inFile}'/>">
		
	<div class="table_div">
			<table class="top_table">
				<tr>
					<td><bean:message bundle="batchforwardpnwoff" key="subtitle" /></td>					
				</tr>
			</table>
	</div>	
	<div class="table_div">
			<table class="error_text">
				<html:errors />
				<s:Msg />
			</table>
	</div>
	
	<div class="table_div">		
		<table class="form_table">
			<tr>
				<td class="form_table_right">
						<div class="field-require">
							<bean:message bundle="upload" key="choose" />:
						</div>
				</td>
				<td class="form_table_left">
						<input type="file" class="form_input_files" value="<bean:message bundle="batchforwardpnwoff" key="choose" />" name="theFile" ID="File1" />
				</td>
			</tr>
			<tr>
				<td class="form_table_right">
					<bean:message bundle="upload" key="filetype" />
				</td>
				<td class="form_table_left"><bean:message bundle="upload" key="typevalue" /></td>
			</tr>
			<tr>
				<td class="form_table_right">
					<bean:message bundle="batchforwardpnwoff" key="filestyle_woff" />
				</td>
				<td class="form_table_left">
					<bean:message bundle="batchforwardpnwoff" key="stylevalue_woff" />
				</td>
			</tr>
			<tr>
				<td class="form_table_right">
					<bean:message bundle="upload" key="example" /></td>
				<td class="form_table_left">
					<font color=red><bean:message bundle="batchforwardpnwoff" key="exvalue_woff" /></font>
				</td>
			</tr>
			<tr>
				<td class="form_table_right">
					<bean:message bundle="batchforwardpnwoff" key="filestyle_nwoff" />
				</td>
				<td class="form_table_left">
					<bean:message bundle="batchforwardpnwoff" key="stylevalue_nwoff" />
				</td>
			</tr>
			<tr>
				<td class="form_table_right">
					<bean:message bundle="batchforwardpnwoff" key="ps" />
				</td>
				<td class="form_table_left">
					<font color=red><bean:message bundle="batchforwardpnwoff" key="psinfo" /></font>
				</td>
			</tr>
			<tr>
				<td class="form_table_right">
					<bean:message bundle="upload" key="example" /></td>
				<td class="form_table_left">
					<font color=red><bean:message bundle="batchforwardpnwoff" key="exvalue_nwoff" /></font>
				</td>
			</tr>
			<tr>
				<td class="form_table_right">
					<bean:message bundle="batchforwardpnwoff" key="oprtype" /></td>
				<c:choose>
					<c:when test="${empty requestScope.ITEM.inFile}">
						<td class="form_table_left">
							<html:select property="oprtype" styleClass="form_select_on">
								<html:option value="1">1&nbsp;<bean:message bundle="batchforwardpnwoff" key="xz" /></html:option>
								<html:option value="2">2&nbsp;<bean:message bundle="batchforwardpnwoff" key="fxz" /></html:option>
							</html:select>
						</td>
					</c:when>
				    <c:otherwise>
				    	<td class="form_table_left">
							<html:select property="oprtype" styleClass="form_select_on" disabled="true">
								<html:option value="1">1&nbsp;<bean:message bundle="batchforwardpnwoff" key="xz" /></html:option>
								<html:option value="2">2&nbsp;<bean:message bundle="batchforwardpnwoff" key="fxz" /></html:option>
							</html:select>
						</td>
				    </c:otherwise>
				 </c:choose>
			</tr>
			<c:choose>
				<c:when test="${!empty requestScope.ITEM.inFile}">
					<tr>
						<td class="form_table_right"><bean:message bundle="upload"	key="existfile" /></td>
						<td class="form_table_left">
							<a href='<%=request.getContextPath()%>/commons/batch/download.jsp?filename=<c:out value="${requestScope.ITEM.inFile}" />'><c:out value="${requestScope.ITEM.fileName}" /></a>
						</td>
					</tr>
				</c:when>
			</c:choose>
	</table>
	</div>
	<div class="table_div">
		<table class="table_button_list">
			<tr>
				<td>
					<s:PurChk controlid="<%=ID_1%>">
					<input type="submit" value="<bean:message bundle="upload" key="upload" />"
							class="comfir" ID="Button1" NAME="Button6">
					</s:PurChk>
					<s:PurChk controlid="<%=ID_2%>">
					<input type="button" value="<bean:message bundle="upload" key="process"/>"
							class="cancel" ID="Button2" NAME="Button7" onClick="checkProcess()" />
					</s:PurChk>
				</td>		
			</tr>
		</table>
	</div>

</html:form>

<iframe src="<%= contextPath%>/commons/batch/commonStatus.jsp?beanname=com.sunrise.boss.ui.fee.woff.batchforwardpnwoff.BatchforwardpnwoffTaskBean" frameborder="0" class="loadframe" id="loadframe" scrolling="no"/>
</div>
</body>
</html>
