<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc"%>
<script type="text/javascript" src="<%=contextPath%>/js/pub/xmlhttp.js"></script>
<link href="<%=contextPath%>/css/css_1/xmlhttp.css" rel="stylesheet"
	type="text/css" media="all" />
<jsp:include page="/inc/acl.jsp">
	<jsp:param name="PID" value="4D6F1A4D" />
</jsp:include>
<%
	String ID_1 = "4D6F1A4DBT1";
	String ID_2 = "4D6F1A4DBT2";
%>
<html>
	<head>
		<title><bean:message bundle="batchparamset" key="title" />
		</title>
		<script language="JavaScript" type="text/JavaScript">
function checkProcess() {
	var filename = formItem.filename.value;
	if(filename != null || filename != "") {
    	formItem.Button7.disabled=true;
	    window.location.href="<%=contextPath%>/qsmanage/paramsmanage/batchparamset/process.do?filename="+filename+"&beanname=com.sunrise.boss.ui.qsmanage.paramsmanage.batchparamset.BatchParamSetTaskBean";
	}
}
function checkparam(){
	if(formItem.ruleid.value == null || formItem.ruleid.value == ""){
		alert("请选择参数规则！！");
		return false;
	}else{
		formItem.submit();
	}
}

 function doajax( url ){
 	var ruleid = formItem.ruleid.value;
 	if(ruleid == null || formItem.ruleid.value == ""){
 		return false;
 	}
 	url = contextPath + url + "&ruleid=" + ruleid;
    startAjax( url,"setDescribe()","text","get");
 }
 
 function setDescribe(){
 	var format = document.all("format");
 	var describe = document.all("describe");
 	var innerVal = unescape(mypoint);
 	var str = innerVal.split("+");
 	format.innerHTML="<font color='red'>" + str[0] + "</font>";
 	describe.innerHTML="<font color='red'>" + str[1] + "</font>"+"<br>详情参考‘规则说明’";
 	
 }
 
 function ruledesc(){
 	if(formItem.ruleid.value != null && formItem.ruleid.value != ""){
 		var ruleid = formItem.ruleid.value;
		var url = contextPath + '/qsmanage/paramsmanage/paramset.do?CMD=SHOWDETA' + "&ruleid=" + ruleid;
		var hWnd = window.showModalDialog(url,new Array(),"dialogWidth:700px; dialogHeight:400px; status:no;resizable:yes;");				
	}else{
		alert("请选择参数规则！！");
	}
 }
 
 
</script>
	</head>
	<body onload="doajax('/qsmanage/paramsmanage/paramset.do?CMD=VIEW');loadforiframe();">
		<div class="table_container">
			<html:form action="/qsmanage/paramsmanage/batchparamset/upload.do"
				enctype="multipart/form-data" styleId="formItem">
				<input type="hidden" name="filename"
					value="<c:out value='${requestScope.ITEM.inFile}'/>">

				<div class="table_div">
					<table class="top_table">
						<tr>
							<td>
								<bean:message bundle="batchparamset" key="subtitle" />
							</td>
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
								<bean:message bundle="batchparamset" key="ruleid" />
							</td>
							<td class="form_table_left">
								<html:select property="ruleid"
									onchange="doajax('/qsmanage/paramsmanage/paramset.do?CMD=VIEW');">
									<html:option value="" />
									<s:Options definition="#QS_RULEID" condition="status:1" />
								</html:select>
							</td>
						</tr>
						
						<tr>
						<td class="form_table_right">
							<bean:message bundle="chghis" key="chgreason" />
							:
						</td>
						<td class="form_table_left" colspan="3">
							<html:textarea property="chgreason"
									styleClass="form_textarea_on" />
							<font color=red>&nbsp;*</font>		
						</td>
					</tr>

						<tr>
							<td class="form_table_right">
								<div class="field-require">
									<bean:message bundle="upload" key="choose" />
								</div>
							</td>
							<td class="form_table_left">
								<input type="file" class="form_input_files"
									value="<bean:message bundle="batchforwardpnwoff" key="choose" />"
									name="theFile" ID="File1" />
							</td>
						</tr>

						<c:choose>
							<c:when test="${!empty requestScope.ITEM.inFile}">
								<tr>
									<td class="form_table_right">
										<bean:message bundle="upload" key="existfile" />
									</td>
									<td class="form_table_left">
										<a
											href='<%=request.getContextPath()%>/commons/batch/download.jsp?filename=<c:out value="${requestScope.ITEM.inFile}" />'><c:out
												value="${requestScope.ITEM.fileName}" />
										</a>
									</td>
								</tr>
							</c:when>
						</c:choose>

						<tr>
							<td class="form_table_right">
								<bean:message bundle="batchparamset" key="format" />
							</td>
							<td class="form_table_left" id="format">

							</td>
						</tr>

						<tr>
							<td class="form_table_right">
								<bean:message bundle="batchparamset" key="describe" />
							</td>
							<td class="form_table_left" id="describe">

							</td>
						</tr>
					</table>
				</div>

				<div class="table_div">
					<table class="table_button_list">
						<tr>
							<td>
								<input type="button"
									value="<bean:message bundle="batchparamset" key="ruledesc" />"
									class="button_4" NAME="Button6" onClick="ruledesc();">

								<input type="button"
									value="<bean:message bundle="upload" key="upload" />"
									class="comfir" ID="Button1" NAME="Button6"
									onClick="checkparam();">
								<s:PurChk2 controlid="QSCS_BATCH_SET">
								<input type="button"
									value="<bean:message bundle="upload" key="process"/>"
									class="cancel" ID="Button2" NAME="Button7"
									onClick="checkProcess();">
								</s:PurChk2>	
							</td>
						</tr>
					</table>
				</div>

			</html:form>

			<iframe
				src="<%=contextPath%>/commons/batch/commonStatus.jsp?beanname=com.sunrise.boss.ui.qsmanage.paramsmanage.batchparamset.BatchParamSetTaskBean"
				frameborder="0" class="loadframe" id="loadframe" scrolling="no" />
		</div>
	</body>
</html>
