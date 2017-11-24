<%@ page language="java" contentType="text/html;charset=GBK"%>
<jsp:include page="/inc/acl.jsp">
	<jsp:param name="PID" value="2B7G1A1ABB" />
</jsp:include>
<%@ include file="/inc/head.inc"%>
<html>
	<head>
		<title>批量调整
		</title>
		<script language="JavaScript" type="text/JavaScript">
function checkProcess(){
	var filename=formItem.filename.value;
	if(filename != null || filename != ""){
        formItem.buttonProcess.disabled=true;
    	window.location.href="<%=contextPath%>/cms/dcord/process.do?filename="+filename+"&beanname=com.sunrise.boss.ui.cms.dcord.BatchTaskBean";
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
			<html:form action="/cms/dcord/upload.do" enctype="multipart/form-data" styleId="formItem">
				<input type="hidden" name="filename" value="<c:out value='${requestScope.ITEM.inFile}'/>">
				<div class="table_div">
					<table class="top_table">
						<tr>
							<td>
								批量调整
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
								格式一：<font color='red'>渠道编码|业务编码|酬金期数|业务发生月(YYYYMM)|结算月份(YYYYMM)|结算状态|</font><br/>
								格式二：<font color='red'>序列号|结算状态|</font>
							</td>
						</tr>
						<tr class="table_style_content_lyl">
							<td align=right height=25>
								<bean:message bundle="upload" key="example" />
							</td>
							<td align=left>
								
								 	EDFS1070F|0702011000247|1|201207|201208|0|<br/>
									EDFS1070F|0702011000247|2|201208|201208|3|<br/>
									EDFS1070F|0702011000247|3|201208|201208|4|<br/>
									10005|0|<br/>
									10006|3|<br/>
									10007|4|<br/>
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
								文件格式中用红色标记的字段为必填项,文件内容无标题行.两种格式数据可以混合在一个文件上传<br/>
								渠道编码:必填项,且必须是酬金出账明细数据中存在的渠道编码.<br/>
								业务编码：必填项,且必须是酬金出账明细数据中存在的业务编码.<br/>
								酬金期数：必填项,上传或者同步酬金明细数据的期数，取值只能是<font color=red>1、2、3</font>中的数值.<br/>
								业务发生月：必填项,上传或者同步酬金明细数据的业务发生时间精确到月份，6位数值，如201206.<br/>
								结算月份:必填项,上传或者同步酬金明细数据的结算月份.<br/>
								结算状态：必填项,取值只能是<font color=red>【0：待结算】、【3：暂挂】、【4：冻结】</font>，暂挂和冻结的酬金不会用于付款报表核算，但对于出账报表无影响.<br/>
								序列号：查询、导出界面对应的序列号.<br/>
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
									class="close" onclick="doReturn('/cms/dcord.do?CMD=SHOW')">
							</td>
						</tr>
					</table>
				</div>
			</html:form>
			<iframe scrolling="no"
				src="<%=contextPath%>/commons/batch/commonStatus.jsp?beanname=com.sunrise.boss.ui.cms.dcord.BatchTaskBean"
				frameborder="0" class="loadframe" id="loadframe">
			</iframe>
			   
		</div>
	</body>
</html>
