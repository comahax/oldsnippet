<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc"%>
<%
	String ID_1 = "CH_PW_REWARD || CH_PW_REWARD_EDIT";
    String ID_2 ="CH_PW_REWARD || CH_PW_REWARD_VIEW";

%>
<html>
	<head>
		<title><bean:message bundle="bbcoper" key="titleList" />
		</title>
		<script type="text/javascript"
			src="<%=contextPath%>/js/bus/waycommon.js"></script>
		<script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            addfield('_se_logid', '<bean:message bundle="bbcoper" key="logid"/>', 'c', true, '14');
            return checkval(window);
        }
    </script>
	</head>

	<body onload="if(window.loadforiframe) loadforiframe();">
		<div class="table_container">
			<html:form action="/cms/bbc/operationlog.do?CMD=LIST" styleId="formList"
				method="post" onsubmit="return ev_check();">
				<html:hidden property="_orderby" />
				<html:hidden property="_desc" />
				<html:hidden property="_pageno" />
				<html:hidden property="_pagesize" />
				
				<input type="hidden" name="_rowcount"
					value="<c:out value='${requestScope.LIST.rowCount}' />">

				<!--##################################添加标题内容##################################################-->
				<div class="table_div">
					<table class="top_table">
						<tr>
							<td>
								<bean:message bundle="bbcoper" key="titleList" />
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
					<table class="form_table">
						<tr>
							<td width="126" height="20" align="right"
								class="form_table_right">
								<bean:message bundle="bbcoper" key="_se_logid" />
								:
							</td>
							<td class="form_table_left">
							    <html:text  property="_se_opnid" styleClass="form_input_1x"/>
						</tr>
					</table>
				</div>
				<div class="table_div">
					<table class="table_button_list">
						<tr>
							<td align=right>
								<s:PurChk controlid="<%=ID_1%>">
									<input type="button" name="btnNew" class="add"
										onmouseover="buttonover(this);" onmouseout="buttonout(this);"
										onfocus="buttonover(this)" onblur="buttonout(this)"
										value="<bean:message bundle="public" key="button_new"/>"
										onClick="doNew('/cms/bbc/operation.do')">
								</s:PurChk>

								<s:PurChk controlid="<%=ID_2%>">
									<input type="button" class="query" onclick="doQuery();" 
										onmouseover="buttonover(this);" onmouseout="buttonout(this);"
										onfocus="buttonover(this)" onblur="buttonout(this)"
										value="<bean:message bundle="public" key="button_search"/>" />
								</s:PurChk>
							</td>
						</tr>
					</table>
				</div>

				<div class="table_div">
					<div class="table_LongTable">
						<table class="table_style" ID="Table2">
							<tr class="table_style_head">

								<td>
									<bean:message bundle="bbcoper" key="operate" />
								</td>
								<td>
									<a href="javascript:doOrderby('opnid')"><bean:message
											bundle="bbcoper" key="opnid" />
									</a>
									<s:OrderImg form="/cms/bbc/operationlog/operationlogForm" field="opnid" />
								</td>
								<td>
									<a href="javascript:doOrderby('name')"><bean:message
											bundle="bbcoper" key="name" />
									</a>
									<s:OrderImg form="/cms/bbc/operationlog/operationlogForm" field="name" />
								</td>
								<td>
									<bean:message bundle="bbcoper" key="startdate" />

								</td>
								<td>
									<bean:message bundle="bbcoper" key="enddate" />

								</td>

								<td>
									<bean:message bundle="bbcoper" key="busibelong" />

								</td>

								<td>
									<bean:message bundle="bbcoper" key="remark" />

								</td>
							</tr>
							<c:forEach var="item" items="${requestScope.LIST.datas}">
								<c:url value="/cms/bbc/operationlog.do?CMD=EDIT" var="urlContent">
								<c:param name="PK" value="${item.opnid}" />
								</c:url>
								<c:url value="/cms/bbc/operationlog/frame.jsp" var="urlContent2">
									<c:param name="PK" value="${item.opnid}" />
									<c:param name="_se_opnid" value="${item.opnid}" />
								</c:url>

								<tr class="table_style_content" align="center">

									<td>
										<a href='<c:out value="${urlContent2}"/>'><bean:message
												bundle="bbcoper" key="operation" />
										</a>
									</td>
									<td>
										<a href='<c:out value="${urlContent}"/>'><c:out
												value="${item.opnid}" />
										</a>
									</td>
									<td>
										<c:out value="${item.name}" />
									</td>
									<td>
									<fmt:formatDate value="${item.startdate}" pattern="yyyy-MM-dd HH:mm:ss"/>
									</td>
									<td>
									<fmt:formatDate value="${item.enddate}" pattern="yyyy-MM-dd HH:mm:ss"/>
									</td>
									<td>
									<s:Code2Name code="${item.busibelong}" definition="$CH_CBBUSIBELONG" />  
										
									</td>
									<td>
										<c:out value="${item.remark}" />
									</td>
								</tr>
							</c:forEach>
						</table>
					</div>
				</div>

				<div class="table_div">
					<s:PageNav dpName="LIST" />
				</div>
			</html:form>
		</div>
	</body>
</html>
