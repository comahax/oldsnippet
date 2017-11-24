<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc"%>

<html>
	<head>
		<title><bean:message bundle="orderdetailquery"
				key="orderdetailquerytitle" />
		</title>
		<script language="JavaScript" type="text/JavaScript">
        function checkProcess(){
			var filename = formItem.filename.value;
			if(filename != null || filename != ""){
        		formItem.buttonProcess.disabled=true;
    			window.location.href="<%=contextPath%>/cms/zjty/zjtyrewardcoef/upload.do?CMD=BATCH&filename="+filename+"&beanname=com.sunrise.boss.ui.cms.zjty.zjtyrewardcoef.ZjtyRewardcoefTaskBean";
    		}
		}
        function getpath(){
    		var url = formList.file.value;
    		document.getElementById("savePath").value = url.substr(0,url.lastIndexOf("\\")+1);
    	}
    	function doReturn(cmdReturn) {
    	formItem.action = contextPath + cmdReturn;
    	formItem.submit();
		}
    </script>
		<script type="text/javascript"
			src="<%=contextPath%>/js/bus/waycommon.js"></script>
	</head>

	<body onload="if(window.loadforiframe) loadforiframe();">
		<div class="table_container">
			<html:form action="/cms/zjty/zjtyrewardcoef/upload.do?CMD=UPLOAD"
				enctype="multipart/form-data" styleId="formItem">

				<input type="hidden" name="filename"
					value="<c:out value='${requestScope.ITEM.inFile}'/>">
				<div class="table_div">
					<table class="top_table">
						<tr>
							<td width="210" class="AreaName" align="left" valign=middle>
								自建他营酬金酬金系数批量导入
							</td>
						</tr>
					</table>
				</div>
				<div class="table_div">
					<table class="error_text" width="100%">
						<html:errors />
						<s:Msg />
					</table>
				</div>
				<div class="table_div">
					<table class="form_table">
						<tr>
							<td width="20%" align="right" class="form_table_right">
								<bean:message bundle="zjtyrewardcoef" key="selectfile" />
							</td>
							<td class="form_table_left">
								<input type="file" class="form_input_files" name="theFile"
									ID="File1" />
							</td>
						</tr>
						<tr>
							<td width="20%" align="right" class="form_table_right">
								<bean:message bundle="zjtyrewardcoef" key="oprtype" />
							</td>
							<td width="75%" align="left" class="form_table_left">
								<html:select property="oprtype">
									<html:option value="0">
										<bean:message bundle="zjtyrewardcoef" key="add" />
									</html:option>
									<html:option value="1">
										<bean:message bundle="zjtyrewardcoef" key="update" />
									</html:option>
									<html:option value="2">
										<bean:message bundle="zjtyrewardcoef" key="del" />
									</html:option>
								</html:select>
							</td>
						</tr>
						<c:choose>
							<c:when test="${!empty requestScope.ITEM.inFile}">
								<tr class="table_style_content">
									<td align=right height=25>
										<bean:message bundle="upload" key="existfile" />
									</td>
									<td align=left>
										<a
											href='<%=contextPath%>/commons/batch/download.jsp?filename=<c:out
						value="${requestScope.ITEM.inFile}" />'>
											<c:out value="${requestScope.ITEM.fileName}" /> </a>
									</td>
								</tr>
							</c:when>
						</c:choose>
						<tr class="table_style_content">
							<td align="right" >
								<bean:message bundle="upload" key="filetype" />
							</td>
							<td align="left">
								<bean:message bundle="upload" key="typevalue" />
							</td>
						</tr>
						<tr class="table_style_content">
							<td align=right height=25>
								<bean:message bundle="upload" key="filestyle" />
							</td>
							<td align=left>
								<p>
									新增/修改:<font color="red">作用月</font>|<font color="red">系数类型</font>|<font color="red">渠道代码</font>|<font color="red">系数值</font>|<font color="blue">说明</font>|
								</p>
								<p>
									删除:<font color="red">作用月</font>|<font color="red">系数类型</font>|<font color="red">渠道代码</font>|
								</p>
								<p>
									注:红色列代表必填，蓝色列为可选，可选列为空时，需保留其竖线分隔符<br>
									“作用月”列格式为：yyyymm， 例如2009年1月，则200901<br>
									“系数类型”列使用值代替，0代表“考核管理”，1代表“综合排名”，2代表“否决”
								</p>
							</td>
						</tr>
						<tr class="table_style_content">
							<td align=right height=25>
								<bean:message bundle="upload" key="example" />
							</td>
							<td align=left>
								新增/修改:200901|0|JFJM00000|0.45|2009年1月酬金系数数据| <br>
								删除:200901|0|JFJM00000|
							</td>
						</tr>
						<tr class="table_style_content">
							<td align=right height=25>
								<bean:message bundle="zjtyrewardcoef" key="model" />
							</td>
							<td align=left>
								<a href="<%=contextPath%>/cms/zjty/zjtyrewardcoef/zjtyrewardcoef.xls"><bean:message bundle="zjtyrewardcoef" key="modelname" /></a>
								<bean:message bundle="zjtyrewardcoef" key="hint" /></td>
						</tr>
					</table>
				</div>
				<div class="table_div">
					<table class="table_button_list">
						<tr>
							<td align=right>

								<input type="submit"
									value="<bean:message bundle="upload" key="upload" />"
									class="comfir" onmouseover="buttonover(this)"
									onmouseout="buttonout(this)" onfocus="buttonover(this)"
									onblur="buttonout(this)" ID="buttonUpload" NAME="buttonUpload">

								<input type="button"
									value="<bean:message bundle="upload" key="process"/>"
									class="button_4" onmouseover="buttonover(this)"
									onmouseout="buttonout(this)" onfocus="buttonover(this)"
									onblur="buttonout(this)" ID="buttonProcess"
									NAME="buttonProcess" onClick="checkProcess()" />

								<input type="button" value="返回" class="button_4"
									onmouseover="buttonover(this)" onmouseout="buttonout(this)"
									onfocus="buttonover(this)" onblur="buttonout(this)"
									ID="buttonProcess" NAME="buttonProcess"
									onClick="doReturn('/cms/zjty/zjtyrewardcoef.do?CMD=LIST')" />
							</td>
						</tr>
					</table>
				</div>
			</html:form>
			<iframe
				src="<%=contextPath%>/commons/batch/commonStatus.jsp?beanname=com.sunrise.boss.ui.cms.zjty.zjtyrewardcoef.ZjtyRewardcoefTaskBean"
				frameborder="0" class="loadframe" id="loadframe" scrolling="no">
			</iframe>
		</div>
	</body>
</html>
