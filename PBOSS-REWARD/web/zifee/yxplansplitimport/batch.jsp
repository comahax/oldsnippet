<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/contenthead.inc"%>
<jsp:include page="/inc/acl.jsp">
  <jsp:param name="PID" value="3C3C2B" />
</jsp:include>
<%
    String ID_1 = "3C3C2BBT1";
    String ID_2 = "3C3C2BBT2";
    String ID_3 = "3C3C2BBT3";
    String ID_4 = "3C3C2BBT4";
%>
<html:html>
<head>
	<title><bean:message bundle="custinte" key="batchTransferList" /></title>
	<script language="JavaScript">
			function checkProcess(){
		  		var filename=formItem.filename.value;
				if(filename != null || filename != ""){
          			formItem.buttonProcess.disabled=true;
	      			window.location.href="<%= contextPath%>/zifee/yxplansplitbatch/batch.do?filename="+filename+"&beanname=com.sunrise.boss.ui.zifee.yxplansplitbatch.YxPlanSplitBatch";
				}
			}
    </script>
</head>
<body  onload£½" loadforiframe()">
<div class="table_container">
	<html:form action="/zifee/yxplansplitbatch/upload.do" styleId="formItem" method="post" enctype="multipart/form-data">
		<input type="hidden" name="filename" value="<c:out value='${requestScope.ITEM.inFile}'/>">		
			<div class="table_div">
				<table class="top_table">
					<tr>
						<td>
							<bean:message bundle="yxplansplitvalue" key="title" />
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
							<bean:message bundle="yxplansplitvalue" key="dataFile" />:
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
							<td align="right" height=25>
								<bean:message bundle="batchtest" key="oprtype" />:
							</td>
							<td align="left">
								<html:select property="oprtype">
									<html:option value="0">
										<bean:message bundle="batchtest" key="add" />
									</html:option>
									<html:option value="3">
										<bean:message bundle="batchtest" key="delete" />
									</html:option>
								</html:select>
							</td>
						</tr>
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
							<bean:message bundle="yxplansplitvalue" key="fielFmt" />
							:
						</div>
					</td>
					<td width="75%" align="left" class="form_table_left">
						<bean:message bundle="yxplansplitvalue" key="contentFmt" />
					</td>
				</tr>
				<tr class="table_style_content">
					<td width="20%" align="right" class="form_table_right">
						<div class="field-require">
							<bean:message bundle="yxplansplitvalue" key="example" />
							:
						</div>
					</td>
					<td width="75%" align="left" class="form_table_left">
						<font color="red"><bean:message bundle="yxplansplitvalue" key="contentExample" /></font>
					</td>
				</tr>
				<tr class="table_style_content">
					<td width="20%" align="right" class="form_table_right">
						<div class="field-require">
							<bean:message bundle="yxplansplitvalue" key="ps" />
							:
						</div>
					</td>
					<td width="75%" align="left" class="form_table_left">
						<bean:message bundle="yxplansplitvalue" key="psinfo" />
					</td>
				</tr>
			</table>
		</div>
		<iframe
				src="<%=contextPath%>/commons/batch/commonStatus.jsp?beanname=com.sunrise.boss.ui.zifee.yxplansplitbatch.YxPlanSplitBatch"
				frameborder="0" class="loadframe" id="loadframe" scrolling="no">
		</iframe>
        <div class="table_div">
				<table class="table_button_list">
					<tr>
						<td>
							<s:PurChk controlid="<%=ID_1%>">
							<input type="submit" value="<bean:message bundle="upload" key="upload" />" class="comfir"
								onmouseover="buttonover(this)" onmouseout="buttonout(this)" onfocus="buttonover(this)" onblur="buttonout(this)"
								ID="buttonUpload" NAME="buttonUpload" onClick="ev_checkval()">
							</s:PurChk>
							<s:PurChk controlid="<%=ID_2%>">
							<input type="button" value="<bean:message bundle="upload" key="process"/>" class="button_4"
								onmouseover="buttonover(this)" onmouseout="buttonout(this)" onfocus="buttonover(this)" onblur="buttonout(this)"
								ID="buttonProcess" NAME="buttonProcess" onClick="checkProcess()" />
							</s:PurChk>
						</td>
					</tr>
				</table>
			</div>
	</html:form> 
	<br>
	</div>
</body>
</html:html>
