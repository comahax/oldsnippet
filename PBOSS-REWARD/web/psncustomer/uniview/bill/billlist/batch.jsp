<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/contenthead.inc"%>
<jsp:include page="/inc/acl.jsp">
  <jsp:param name="PID" value="7F1A1A" />
</jsp:include>

<html:html>
<head>
	<title><bean:message bundle="custinte" key="batchTransferList" /></title>
	<script language="JavaScript">
			function checkProcess(){
		  		var filename=formItem.filename.value;
				if(filename != null || filename != ""){
          			formItem.buttonProcess.disabled=true;
	      			window.location.href="<%= contextPath%>/psncustomer/uniview/bill/billlist/processfile/batch.do?filename="+filename+"&beanname=com.sunrise.boss.ui.psncustomer.uniview.bill.billlist.processfile.MonthPaymentTaskBean";                                                                                        
				}
			}
    </script>
    
</head>
<body  onload£½" loadforiframe()">
<div class="table_container">
	<html:form action="/psncustomer/uniview/bill/billlist/upload.do" styleId="formItem" method="post" enctype="multipart/form-data">
		<input type="hidden" name="filename" value="<c:out value='${requestScope.ITEM.inFile}'/>">
			<div class="table_div">
				<table class="top_table">
					<tr>
						<td>
							<bean:message bundle="billlist" key="title" />
						</td>
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
				<tr class="table_style_content">
					<td width="20%" align="right" class="form_table_right">
						<div class="field-require">
							<bean:message bundle="billlist" key="dataFile" />:
						</div>
					</td>
					<td width="75%" align="left" class="form_table_left">
						<html:file styleClass="form_input_files" property="theFile"/>
					</td>
				</tr>
				<tr class="table_style_content">
					<td width="20%" align="right" class="form_table_right">
						<div class="field-require">
							<bean:message bundle="billlist" key="inputitem" />:
						</div>
					</td>
					<td width="75%" align="left" class="form_table_left">
						<html:text styleClass="form_input_2x" property="inputitem"/>
					</td>
				</tr>
				<c:choose>
					<c:when test="${!empty requestScope.ITEM.inFile}">
						<tr class="table_style_content">
							<td align=right height=25>
								<bean:message bundle="upload" key="existfile" />:
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
					<td width="20%" align="right" class="form_table_right">
						<div class="field-require">
							<bean:message bundle="billlist" key="fielFmt" />
							:
						</div>
					</td>
					<td width="75%" align="left" class="form_table_left">
						<bean:message bundle="billlist" key="contentFmt" />
					</td>
				</tr>
				<tr class="table_style_content">
					<td width="20%" align="right" class="form_table_right">
						<div class="field-require">
							<bean:message bundle="billlist" key="example" />
							:
						</div>
					</td>
					<td width="75%" align="left" class="form_table_left">
						<font color="red"><bean:message bundle="billlist" key="contentExample" /></font>
					</td>
				</tr>
				<tr class="table_style_content">
					<td width="20%" align="right" class="form_table_right">
						<div class="field-require">
							<bean:message bundle="billlist" key="ps" />
							:
						</div>
					</td>
					<td width="75%" align="left" class="form_table_left">
						<bean:message bundle="billlist" key="psinfo" />
					</td>
				</tr>
			</table>
		</div>
		<iframe
				src="<%=contextPath%>/psncustomer/uniview/bill/billlist/commonStatus.jsp?beanname=com.sunrise.boss.ui.psncustomer.uniview.bill.billlist.processfile.MonthPaymentTaskBean"
				frameborder="0" class="loadframe" id="loadframe" scrolling="no">
		</iframe>
        <div class="table_div">
				<table class="table_button_list">
					<tr>
						<td>
							
							<input type="submit" value="<bean:message bundle="upload" key="upload" />" class="comfir"
								onmouseover="buttonover(this)" onmouseout="buttonout(this)" onfocus="buttonover(this)" onblur="buttonout(this)"
								ID="buttonUpload" NAME="buttonUpload" onClick="ev_checkval()"/>
						
							
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
