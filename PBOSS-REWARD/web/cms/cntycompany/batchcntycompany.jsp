<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/head.inc"%>

<html>
	<head>
		<title><bean:message bundle="cntycompany" key="titleList" />
		</title>
		<script language="JavaScript" type="text/JavaScript">
function checkProcess(){
	var filename = formItem.filename.value;
	if(filename != null || filename != ""){
        formItem.buttonProcess.disabled=true;
    	window.location.href="<%=contextPath%>/cms/cntycompany/process.do?filename="+filename+"&beanname=com.sunrise.boss.ui.cms.cntycompany.BatchTaskBean";
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
			<html:form action="/cms/cntycompany/process.do?CMD=UPLOAD" enctype="multipart/form-data" styleId="formItem">
				<input type="hidden" name="filename" value="<c:out value='${requestScope.ITEM.inFile}'/>">
				<div class="table_div">
					<table class="top_table">
						<tr>
							<td >
								<bean:message bundle="cntycompany" key="titleList" />
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
								�ع�˾��ʶ|�й�˾��ʶ|�ع�˾����|�ع�˾����|���˴���|�Ʒ�������������|������������|�칫�ص㾭��|�칫�ص�γ��|
							</td>
						</tr>
						<tr class="table_style_content">
							<td align=right height=25>
								<bean:message bundle="upload" key="example" />
							</td>
							<td align=left>
								JMC|JM|���ſ�ƽ|1|����|123|JM|88|77|
							</td>
						</tr>
						<tr class="table_style_content">
							<td align=right height=25>
								<font color=red>����˵��:</font>
							</td>
							<td align=left>
								�ع�˾���ͱ���:0-����,1-����,99-����<br>
							</td>
						</tr>
						<tr class="table_style_content">
							<td align=right height=25>
								��дָ��:
							</td>
							<td align=left >
								<a href="cms/common/importguide.htm">��дָ��</a>
							</td>
						</tr>
						<tr class="table_style_content">
							<td align=right height=25>
								Excel��дģ��:
							</td>
							<td align=left>
							<a href="cms/cntycompany/batch.xls">�ֹ�˾������������ģ��.xls</a>
							<font color="green">(ע����д���뽫����ת��Ϊtxt��ʽ��ȥ�������У����ϴ�)</font>
							</td>
						</tr>
					</table>
				</div>
			<iframe src="<%=contextPath%>/commons/batch/commonStatus.jsp?beanname=com.sunrise.boss.ui.cms.cntycompany.BatchTaskBean"  frameborder="0" class="loadframe" id="loadframe"  scrolling="no"></iframe>
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
								class="comfir" onclick="doReturn('/cms/cntycompany.do?CMD=LIST')">
						</td>
					</tr>
				</table>
			</div>
			</html:form>
		</div>
	</body>
</html>
