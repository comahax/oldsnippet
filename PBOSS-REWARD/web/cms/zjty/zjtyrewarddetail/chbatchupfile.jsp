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
    			window.location.href="<%=contextPath%>/cms/zjty/zjtyrewarddetail/chupload.do?CMD=BATCH&filename="+filename+"&beanname=com.sunrise.boss.ui.cms.zjty.zjtyrewarddetail.ZjtyRewarddetailCityTaskBean";
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
			<html:form action="/cms/zjty/zjtyrewarddetail/chupload.do?CMD=UPLOAD"
				enctype="multipart/form-data" styleId="formItem">

				<input type="hidden" name="filename"
					value="<c:out value='${requestScope.ITEM.inFile}'/>">
				<div class="table_div">
					<table class="top_table">
						<tr>
							<td width="210" class="AreaName" align="left" valign=middle>
								地市酬金管理批量导入
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
							<td width="126" height="20" align="right"
								class="form_table_right">
								<bean:message bundle="zjtyrewarddetail" key="selectfile" />
								:
							</td>
							<td class="form_table_left">
								<input type="file" class="form_input_files" name="theFile"
									ID="File1" />
							</td>
						</tr>
						<tr>
							<td width="20%" align="right" class="form_table_right">
								<bean:message bundle="zjtyrewarddetail" key="oprtype" />
								:
							</td>
							<td width="75%" align="left" class="form_table_left">
								<html:select property="oprtype">
									<html:option value="0">
										<bean:message bundle="zjtyrewarddetail" key="add" />
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
								<p>
									<font color=red>酬金类型</font>|<font color=red>渠道代码</font>|<font color=red>结算月</font>|<font color=red>应发金额</font>|
								</p>
								<p>
									酬金类型:(85:数据业务基本酬金;86:数据业务奖励酬金;91:集团业务酬金;92:营销重点类酬金)
								</p>
							</td>
						</tr>
						<tr class="table_style_content">
							<td width="20%" align=right height=25>
								<bean:message bundle="upload" key="example" />
							</td>
							<td width="75%" align=left>
								85|JFJMDAT10|200907|2000.00|
							</td>
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
									onClick="doReturn('/cms/zjty/zjtyrewarddetail.do?CMD=Chlist')" />
							</td>
						</tr>
					</table>
				</div>
			</html:form>
			<iframe
				src="<%=contextPath%>/commons/batch/commonStatus.jsp?beanname=com.sunrise.boss.ui.cms.zjty.zjtyrewarddetail.ZjtyRewarddetailCityTaskBean"
				frameborder="0" class="loadframe" id="loadframe" scrolling="no">
			</iframe>
		</div>
	</body>
</html>
