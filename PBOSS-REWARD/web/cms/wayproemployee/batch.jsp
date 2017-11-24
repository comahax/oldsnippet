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
	      		window.location.href="<%= contextPath%>/cms/wayproemployee/batch.do?filename="+filename+"&beanname=com.sunrise.boss.ui.cms.wayproemployee.WayproemployeeTaskBean";                                                                                        
			}
		}
		function doReturnList(){
    		window.location.href="<%=contextPath%>/cms/wayproemployee.do?CMD=LIST";
    	}	
    </script>
</head>
<body  onload£½" loadforiframe()">
<div class="table_container">
	<html:form action="/cms/wayproemployee/batch.do?CMD=UPLOAD" styleId="formItem" method="post" enctype="multipart/form-data">
		<input type="hidden" name="filename" value="<c:out value='${requestScope.ITEM.inFile}'/>">		
			<div class="table_div">
				<table class="top_table">
					<tr>
						<td>
							<bean:message bundle="Wayproemployee" key="titleList" />
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
							<bean:message bundle="Wayproemployee" key="dataFile" />:
						</div>
					</td>
					<td width="75%" align="left" class="form_table_left">
						<html:file styleClass="form_input_files" property="theFile"/>
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
					<td width="20%" align="right" class="form_table_right">
						<div class="field-require">
							<bean:message bundle="Wayproemployee" key="fielFmt" />
							:
						</div>
					</td>
					<td width="75%" align="left" class="form_table_left" nowrap="false">
						<bean:message bundle="Wayproemployee" key="contentFmt" />
					</td>
				</tr>
				<tr class="table_style_content">
					<td width="20%" align="right" class="form_table_right">
						<div class="field-require">
							<bean:message bundle="Wayproemployee" key="example" />
							:
						</div>
					</td>
					<td width="75%" align="left" class="form_table_left" nowrap="false">
						<bean:message bundle="Wayproemployee" key="contentExample" />
					</td>
				</tr>
				<tr class="table_style_content">
					<td width="20%" align="right" class="form_table_right">
						<div class="field-require">
							<bean:message bundle="Wayproemployee" key="ps" />
							:
						</div>
					</td>
					<td width="75%" align="left" class="form_table_left">
						<bean:message bundle="Wayproemployee" key="psinfo" />
					</td>
				</tr>
				<tr class="table_style_content">
					<td align=right height=25>
						<bean:message bundle="Wayproemployee" key="guide" />
					</td>
					<td align=left>
						<a href="<%=contextPath%>/cms/common/importguide.htm"><bean:message bundle="Wayproemployee" key="guide" /></a></td>
				</tr>
				<tr class="table_style_content">
					<td align=right height=25>
						<bean:message bundle="Wayproemployee" key="model" />
					</td>
					<td align=left>
						<a href="<%=contextPath%>/cms/wayproemployee/wayproemployeeimport.xls"><bean:message bundle="Wayproemployee" key="modelname" /></a>
						<bean:message bundle="Wayproemployee" key="hint" /></td>
				</tr>
			</table>
		</div>
		<iframe
				src="<%=contextPath%>/commons/batch/commonStatus.jsp?beanname=com.sunrise.boss.ui.cms.wayproemployee.WayproemployeeTaskBean"
				frameborder="0" class="loadframe" id="loadframe" scrolling="no">
		</iframe>
        <div class="table_div">
				<table class="table_button_list">
					<tr>
						<td>
							
							<input type="submit" value="<bean:message bundle="upload" key="upload" />" class="button_4"
								onmouseover="buttonover(this)" onmouseout="buttonout(this)" onfocus="buttonover(this)" onblur="buttonout(this)"
								ID="buttonUpload" NAME="buttonUpload"/>
							<input type="button" value="<bean:message bundle="upload" key="process"/>" class="button_4"
								onmouseover="buttonover(this)" onmouseout="buttonout(this)" onfocus="buttonover(this)" onblur="buttonout(this)"
								ID="buttonProcess" NAME="buttonProcess" onClick="checkProcess()" />
								
							<input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
                           		name="btnReturn" onfocus="buttonover(this)" onblur="buttonout(this)"
                           		value="<bean:message bundle="public" key="button_return"/>" class="button_4"
                           		onclick="doReturnList()">
						</td>
					</tr>
				</table>
			</div>
	</html:form> 
	<br>
	</div>
</body>
</html:html>
