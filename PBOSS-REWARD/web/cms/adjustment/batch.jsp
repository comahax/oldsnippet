<%@ page language="java" contentType="text/html;charset=GBK"%>
<jsp:include page="/inc/acl.jsp">
	<jsp:param name="PID" value="2B7G1A1ABB" />
</jsp:include>
<%@ include file="/inc/head.inc"%>
<html>
	<head>
		<title><bean:message bundle="adjustment" key="titleBatch" />
		</title>
		<script language="JavaScript" type="text/JavaScript">
function checkProcess(){
	var filename=formItem.filename.value;
	if(filename != null || filename != ""){
        formItem.buttonProcess.disabled=true;
    	window.location.href="<%=contextPath%>/cms/adjustment/process.do?filename="+filename+"&beanname=com.sunrise.boss.ui.cms.adjustment.BatchTaskBean";
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
			<html:form action="/cms/adjustment/upload.do" enctype="multipart/form-data" styleId="formItem">
				<input type="hidden" name="filename" value="<c:out value='${requestScope.ITEM.inFile}'/>">
				<div class="table_div">
					<table class="top_table">
						<tr>
							<td>
								<bean:message bundle="adjustment" key="titleBatch" />
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
						<tr class="table_style_content_lyl">
							<td width=20% align=right height=25>
								<bean:message bundle="upload" key="choose" />
							</td>
							<td align=left>
								<input type="file" class="form_input_files" name="theFile" ID="File1" />
							</td>
						</tr>
						<c:choose>
							<c:when test="${!empty requestScope.ITEM.inFile}">
								<tr class="table_style_content_lyl">
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
						<tr class="table_style_content_lyl">
							<td align=right height=25>
								<bean:message bundle="upload" key="filetype" />
							</td>
							<td align=left>
								<bean:message bundle="upload" key="typevalue" />
							</td>
						</tr>
						<tr class="table_style_content_lyl">
							<td align=right height=25>
								<bean:message bundle="upload" key="filestyle" />
							</td>
							<td align=left>
								<font color='red'>渠道编码 |结算月份(YYYYMM)|<c:if test="${sessionScope._hasupperopnid==1}">业务大类编码|</c:if></font>税金|奖罚金额|<c:if test="${sessionScope._hasfees==1}">手续费|</c:if>备注|
							</td>
						</tr>
						<tr class="table_style_content_lyl">
							<td align=right height=25>
								<bean:message bundle="upload" key="example" />
							</td>
							<td align=left>
								<font color=red>EDFS1070F|201208|<c:if test="${sessionScope._hasupperopnid==1}">0100000000000|</c:if></font>888.8888|25.55|<c:if test="${sessionScope._hasfees==1}">10.00|</c:if>备注|<br/>
								<font color=red>EDFS1070F|201208|<c:if test="${sessionScope._hasupperopnid==1}">0200000000000|</c:if></font>888.8888|-200.50|<c:if test="${sessionScope._hasfees==1}">20.55|</c:if>备注|<br/>
								<font color=red>EDFS1071F|201208|<c:if test="${sessionScope._hasupperopnid==1}">0300000000000|</c:if></font>||<c:if test="${sessionScope._hasfees==1}">|</c:if>|
							</td>
						</tr>
						<tr class="table_style_content_lyl">
							<td width="20%" align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="adjustment" key="memo" />
									:
								</div>
							</td>
							<td width="75%" align="left" class="form_table_left">
								文件格式中用红色标记的字段为必填项,文件内容无标题行.<br/>
								渠道编码:必填项;且必须是已勾选保存后的渠道编码/合作商编码.<br/>
								<c:if test="${sessionScope._hasupperopnid==1}">
								业务大类编码：必填项;取值如下：<br/>
								0100000000000 用户入网手续费<br/>
								0200000000000 有价卡手续费<br/>
								0300000000000 话费服务费<br/>
								0600000000000 增值业务服务费<br/>
								0400000000000 终端服务费<br/>
								0700000000000 激励费用<br/>
								0500000000000 其他服务费<br/>
								0800000000000 集团业务服务费<br/>
								0900000000000 调整酬金.<br/>
								</c:if>
								税金:选填项,如果为空则表示该网点当月不由移动公司代扣税金,税金为0;整数部分最多支持6位，最多可精确到小数点后4位.<br/>
								奖罚金额:选填项,如果为空则表示为0;整数部分最多支持6位，最多可精确到小数点后4位;正数表示奖励,负数表示扣罚.<br/>
								 <c:if test="${sessionScope._hasfees==1}">
								手续费:选填项,如果为空，则表示不需要扣减手续费，手续费为0;整数部分最多支持6位，最多可精确到小数点后4位.<br/>
								 </c:if>
								提示:每次操作进行修改操作.<br/>
							</td>
						</tr>
					</table>
				</div>
				<div class="table_div">
					<table class="table_button_list">
						<tr>
							<td>
								<input type="submit" value="<bean:message bundle="upload" key="upload" />" class="button_4"
									onmouseover="buttonover(this)" onmouseout="buttonout(this)" onfocus="buttonover(this)" onblur="buttonout(this)"
									ID="buttonUpload" NAME="buttonUpload">
								<input type="button" value="<bean:message bundle="upload" key="process"/>" class="button_4"
									onmouseover="buttonover(this)" onmouseout="buttonout(this)" onfocus="buttonover(this)" onblur="buttonout(this)"
									ID="buttonProcess" NAME="buttonProcess" onClick="checkProcess()" />
								<input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);" name="btnReturn"
									onfocus="buttonover(this)" onblur="buttonout(this)" value="<bean:message bundle="public" key="button_return"/>"
									class="close" onclick="doReturn('/cms/adjustment.do?CMD=SHOW')">
							</td>
						</tr>
					</table>
				</div>
			</html:form>
			<iframe scrolling="no"
				src="<%=contextPath%>/commons/batch/commonStatus.jsp?beanname=com.sunrise.boss.ui.cms.adjustment.BatchTaskBean"
				frameborder="0" class="loadframe" id="loadframe">
			</iframe>
			   
		</div>
	</body>
</html>
