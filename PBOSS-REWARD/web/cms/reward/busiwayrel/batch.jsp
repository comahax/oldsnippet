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
    	window.location.href="<%=contextPath%>/cms/reward/busiwayrel/upload.do?filename="+filename+"&beanname=com.sunrise.boss.ui.cms.reward.busiwayrel.BusiwayrelTaskBean";
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
			<html:form action="/cms/reward/busiwayrel/upload.do?CMD=UPLOAD" enctype="multipart/form-data" styleId="formItem">
				<input type="hidden" name="filename" value="<c:out value='${requestScope.ITEM.inFile}'/>">
				<div class="table_div">
					<table class="top_table">
						<tr>
							<td >
								<bean:message bundle="busiwayrel" key="batchtitle" />
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
								操作类型:
							</td>
							<td align=left>
								<html:select property="oprType">
									<html:option value="1">批量新增</html:option>
									<html:option value="3">批量删除</html:option>
								</html:select>
							</td>
						</tr>
						<tr class="table_style_content">
							<td align=right height=25>
								<bean:message bundle="upload" key="filestyle" />
							</td>
							<td align=left>
								<bean:message bundle="busiwayrel" key="busiwayrelformat" /></td>
						</tr>
						<tr class="table_style_content">
							<td align=right height=25>
								<bean:message bundle="upload" key="example" />
							</td>
							<td align=left>
							<bean:message bundle="busiwayrel" key="busiwayrelexample" /></td>
						</tr>
						<tr class="table_style_content">
							<td align=right height=25>
								<bean:message bundle="busiwayrel" key="societysay" />
							</td>
							<td align=left>
								批量新增:<br>
								<bean:message bundle="busiwayrel" key="busiwayrelasenote1" /><br>
								<bean:message bundle="busiwayrel" key="busiwayrelasenote2" />
								<br>3.业务编码可填业务层次编码，如果填业务层次编码，则默认该层次下的所有业务对需计酬渠道都计酬
								<br> 例如导入格式为：0403000000000|JFJM000987|
								<br>表示凡是从属于业务层0403000000000终端销售（按协议价分档）下的所有业务细项（5级业务分类的最底级业务），都可以给渠道JFJM000987计算酬金
								<br> 
								<br> 批量删除：
								<br> 1.业务编码可填业务层次编码，如果填业务层次编码，则默认该层次下的所有业务需计酬渠道设置都删除
							</td>
						</tr>
						<tr class="table_style_content">
							<td align=right height=25>
								<bean:message bundle="citydata" key="guide" />:
							</td>
							<td align=left>
								<a href="<%=contextPath%>/cms/common/importguide.htm"><bean:message bundle="citydata" key="guide" />
								</a>
							</td>
						</tr>
						<tr class="table_style_content" id="BUSIVALIDDATA3">
							<td align=right height=25>
								<bean:message bundle="citydata" key="model" />:
							</td>
							<td align=left>
								<a href="<%=contextPath%>/cms/reward/busiwayrel/busiwayrel.xls"><bean:message bundle="busiwayrel" key="batchtitle" />
								</a>
								<bean:message bundle="citydata" key="hint" />
							</td>
						</tr>
					</table>
				</div>
			<iframe src="<%=contextPath%>/commons/batch/commonStatus.jsp?beanname=com.sunrise.boss.ui.cms.reward.busiwayrel.BusiwayrelTaskBean"  frameborder="0" class="loadframe" id="loadframe"  scrolling="no"></iframe>
			<div class="table_div">
				<table class="table_button_list">
					<tr>
						<td>			
							<input type="submit" value="<bean:message bundle="upload" key="upload" />" class="button_2"
								onmouseover="buttonover(this)" onmouseout="buttonout(this)" onfocus="buttonover(this)" onblur="buttonout(this)"
								ID="buttonUpload" NAME="buttonUpload">
					
							<input type="button" value="<bean:message bundle="upload" key="process"/>" class="button_2"
								onmouseover="buttonover(this)" onmouseout="buttonout(this)" onfocus="buttonover(this)" onblur="buttonout(this)"
								ID="buttonProcess" NAME="s" onClick="checkProcess()" />
								
							<input type="button" onmouseover="buttonover(this);"
								onmouseout="buttonout(this);" name="btnReturn"
								onfocus="buttonover(this)" onblur="buttonout(this)"
								value="<bean:message bundle="public" key="button_return"/>"
								class="button_2" onclick="doReturn('/cms/reward/busiwayrel.do?CMD=LIST')">							
						</td>
					</tr>
				</table>
			</div>
			</html:form>
		</div>
	</body>
</html>
