<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc"%>
<%
	if(request.getParameter("eftmonthtype1")!=null){
		String var = (String)request.getParameter("eftmonthtype1") ;
		request.setAttribute("eftmonthtype",var);
	}
	String eftmonthtype = (String) request.getAttribute("eftmonthtype");
 %>
<html>
	<head>
		<title></title>
		<script language="JavaScript" type="text/JavaScript">
        function checkProcess(str){
			var filename = formItem.filename.value;
			if(filename != null || filename != ""){
        		formItem.buttonProcess.disabled=true;
    			window.location.href="<%=contextPath%>/cms/waystarmonth/uploadstar.do?CMD=BATCH&eftmonthtype1=" + str + "&filename="+filename+"&beanname=com.sunrise.boss.ui.cms.waystarmonth.WaystarmonthstarTaskBean";
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
		
		function doUpload(str){
			formItem.action="<%=contextPath%>/cms/waystarmonth/uploadstar.do?CMD=UPLOAD&eftmonthtype1=" + str;
    		formItem.submit();
		}
		
		function Disabled(){
			var filename = formItem.filename.value;
			if(filename == null || filename == ""){
        		formItem.buttonProcess.disabled=true;
        	}else{
        		formItem.buttonProcess.disabled=false;
        		formItem.buttonUpload.disabled=true;
        	}
		}
    </script>
		<script type="text/javascript"
			src="<%=contextPath%>/js/bus/waycommon.js"></script>
	</head>

	<body onload="if(window.loadforiframe) loadforiframe();">

		<div class="table_container">
			<html:form action="/cms/waystarmonth/uploadstar.do?CMD=UPLOAD"
				enctype="multipart/form-data" styleId="formItem">
				<input type="hidden" name="filename"
					value="<c:out value='${requestScope.ITEM.inFile}'/>">
				<div class="table_div">
					<table class="top_table">
						<tr>
							<td width="210" class="AreaName" align="left" valign=middle>
								星级奖励酬金管理导入
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
								<bean:message bundle="waystarmonth" key="selectfile" />
								:
							</td>
							<td class="form_table_left">
								<input type="file" class="form_input_files" name="theFile"
									ID="File1" />
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
									<font color="red">渠道网点编码|生效月份(YYYYMM)|星级|</font>
								</p>
							</td>
						</tr>
						<tr class="table_style_content">
							<td align=right height=25>
								<bean:message bundle="upload" key="example" />
							</td>
							<td align=left>
								FJMTS60796|200901|3|
							</td>
						</tr>
						<tr class="table_style_content">
							<td align=right height=25>
								补充说明:
							</td>
							<c:choose>
								<c:when test="${requestScope.eftmonthtype eq '0'}">
								<td align=left id="0">
									【星级资料获取方式为获取渠道当前星级状态】，即导入生效月份表示当前星级状态，
									<br>
									请注意导入该星级快照数据资料只影响当次星级酬金的酬金结果，如需修改渠道当前的星级资料，请到【 渠道管理 > 社会网点信息管理】菜单下进行修改。
								</td>
								</c:when>
								<c:when test="${requestScope.eftmonthtype eq '1'}">
									<td align=left id="1">
										【星级资料获取方式为获取渠道计酬月星级状态】，即导入生效月份表示计酬月星级状态，
										<br>
										请注意导入该星级快照数据资料只影响当次星级酬金的酬金结果，如需修改渠道当前的星级资料，请到【 渠道管理 > 社会网点信息管理】菜单下进行修改。
									</td>
								</c:when>
								<c:otherwise>
									<td align=left id="2">
										【星级资料获取方式为获取渠道结算月星级状态】，即导入生效月份表示结算月星级状态，
										<br>
										请注意导入该星级快照数据资料只影响当次星级酬金的酬金结果，如需修改渠道当前的星级资料，请到【 渠道管理 > 社会网点信息管理】菜单下进行修改。
									</td>
								</c:otherwise>
								</c:choose>
						</tr>
					</table>
				</div>
				<div class="table_div">
					<table class="table_button_list">
						<tr>
							<td align=right>
								<input type="button"
									value="<bean:message bundle="upload" key="upload" />"
									class="button_4" onmouseover="buttonover(this)"
									onmouseout="buttonout(this)" onfocus="buttonover(this)"
									onblur="buttonout(this)" ID="buttonUpload" NAME="buttonUpload"
									onclick="doUpload(<%=eftmonthtype%>);" />
								<input type="button" value="返回" class="button_4"
									onmouseover="buttonover(this)" onmouseout="buttonout(this)"
									onfocus="buttonover(this)" onblur="buttonout(this)"
									ID="buttonReturn" NAME="buttonReturn"
									onClick="doReturn('/cms/waystarmonth.do?CMD=Starlist')" />
							</td>
						</tr>
					</table>
				</div>
			</html:form>
			<iframe
				src="<%=contextPath%>/commons/batch/commonStatus.jsp?beanname=com.sunrise.boss.ui.cms.waystarmonth.WaystarmonthstarTaskBean"
				frameborder="0" class="loadframe" id="loadframe" scrolling="no">
			</iframe>
		</div>
	</body>
</html>
