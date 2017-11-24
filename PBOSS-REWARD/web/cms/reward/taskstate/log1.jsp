<%@ page language="java" contentType="text/html;charset=GBK"%>
<jsp:include page="/inc/acl.jsp">
	<jsp:param name="PID" value="4D3C2B2B" />
</jsp:include>
<%@ include file="/inc/listhead.inc"%>
<%
	String ID_1 = "4D3C2B2BBT1";
	String ID_2 = "4D3C2B2BBT2";
	String ID_3 = "4D3C2B2BBT3";
%>
<html>
	<head>
		<title><s:Code2Name code="${_STEPNAME}"
				definition="#SUBTASKNAME" /></title>
		<script language="JavaScript" type="text/JavaScript">
		</script>
	</head>

	<body onload="loadforiframe();">
		<div class="table_container">
			<html:form action="/cms/reward/taskstate.do?CMD=SHOWLOG"
				styleId="formList" method="post" onsubmit="return ev_check();">
				<html:hidden property="_orderby" />
				<html:hidden property="_desc" />
				<html:hidden property="_pageno" />
				<html:hidden property="_pagesize" />

				<input type="hidden" name="_rowcount"
					value="<c:out value='${requestScope.LIST.rowCount}' />">


				<div class="table_div">
					<table class="top_table">
						<tr>
							<td>
								<s:Code2Name code="${_STEPNAME}" definition="#SUBTASKNAME" />
							</td>

						</tr>
					</table>
				</div>
				<div class="table_div">
					<table class="error_text">
						<html:errors />
						<s:Msg />
					</table>
				</div>
				<div class="table_div">
					<table class="table_button_list">
						<tr>
							<td>
								<input type="button" class="query"
									onmouseover="buttonover(this);" onmouseout="buttonout(this);"
									onfocus="buttonover(this)" onblur="buttonout(this)" value="¹Ø±Õ"
									onClick="window.close();" />
							</td>
						</tr>
					</table>
				</div>
				<div class="table_div">
					<div class="table_LongTable">
						<table class="table_style" ID="Table2">

							<tr class="table_style_head">
								<td><bean:message bundle="taskstate" key="taskid" /></td>
								<td><bean:message bundle="taskstate" key="taskname" /></td>
								<td><bean:message bundle="taskstate" key="taskdata" /></td>
								<td><bean:message bundle="taskstate" key="taskfile" /></td>
								<td><bean:message bundle="taskstate" key="taskcombine" /></td>
								<td><bean:message bundle="taskstate" key="taskformat" /></td>
								<td><bean:message bundle="taskstate" key="taskcommon" /></td>
								<td><bean:message bundle="taskstate" key="tasknormal" /></td>
								<td><bean:message bundle="taskstate" key="starttime" /></td>
								<td><bean:message bundle="taskstate" key="endtime" /></td>
							</tr>
							<c:forEach var="item" items="${requestScope.LIST.datas}">
								<tr class="table_style_content" align="center">
									<td><c:out value="${item.taskid}" /></td>
									<td><c:out value="${item.taskname}" /></td>
									<c:if test="${item.procstat eq 100}">
										<td><s:Code2Name code="100" definition="#PROCSTAT" /></td>
										<td><s:Code2Name code="100" definition="#PROCSTAT" /></td>
										<td><s:Code2Name code="100" definition="#PROCSTAT" /></td>
										<td><s:Code2Name code="100" definition="#PROCSTAT" /></td>
										<td><s:Code2Name code="100" definition="#PROCSTAT" /></td>
										<td><s:Code2Name code="100" definition="#PROCSTAT" /></td>
									</c:if>
									<c:if test="${item.procstat eq 1}">
										<td><s:Code2Name code="1" definition="#PROCSTAT" /></td>
										<td><s:Code2Name code="0" definition="#PROCSTAT" /></td>
										<td><s:Code2Name code="0" definition="#PROCSTAT" /></td>
										<td><s:Code2Name code="0" definition="#PROCSTAT" /></td>
										<td><s:Code2Name code="0" definition="#PROCSTAT" /></td>
										<td><s:Code2Name code="0" definition="#PROCSTAT" /></td>
									</c:if>
									<c:if test="${item.procstat eq 2}">
										<td><s:Code2Name code="100" definition="#PROCSTAT" /></td>
										<td><s:Code2Name code="1" definition="#PROCSTAT" /></td>
										<td><s:Code2Name code="0" definition="#PROCSTAT" /></td>
										<td><s:Code2Name code="0" definition="#PROCSTAT" /></td>
										<td><s:Code2Name code="0" definition="#PROCSTAT" /></td>
										<td><s:Code2Name code="0" definition="#PROCSTAT" /></td>
									</c:if>
									<c:if test="${item.procstat eq 3}">
										<td><s:Code2Name code="100" definition="#PROCSTAT" /></td>
										<td><s:Code2Name code="100" definition="#PROCSTAT" /></td>
										<td><s:Code2Name code="1" definition="#PROCSTAT" /></td>
										<td><s:Code2Name code="0" definition="#PROCSTAT" /></td>
										<td><s:Code2Name code="0" definition="#PROCSTAT" /></td>
										<td><s:Code2Name code="0" definition="#PROCSTAT" /></td>
									</c:if>
									<c:if test="${item.procstat eq 4}">
										<td><s:Code2Name code="100" definition="#PROCSTAT" /></td>
										<td><s:Code2Name code="100" definition="#PROCSTAT" /></td>
										<td><s:Code2Name code="100" definition="#PROCSTAT" /></td>
										<td><s:Code2Name code="1" definition="#PROCSTAT" /></td>
										<td><s:Code2Name code="0" definition="#PROCSTAT" /></td>
										<td><s:Code2Name code="0" definition="#PROCSTAT" /></td>
									</c:if>
									<c:if test="${item.procstat eq 5}">
										<td><s:Code2Name code="100" definition="#PROCSTAT" /></td>
										<td><s:Code2Name code="100" definition="#PROCSTAT" /></td>
										<td><s:Code2Name code="100" definition="#PROCSTAT" /></td>
										<td><s:Code2Name code="100" definition="#PROCSTAT" /></td>
										<td><s:Code2Name code="1" definition="#PROCSTAT" /></td>
										<td><s:Code2Name code="0" definition="#PROCSTAT" /></td>
									</c:if>
									<c:if test="${item.procstat eq 6}">
										<td><s:Code2Name code="100" definition="#PROCSTAT" /></td>
										<td><s:Code2Name code="100" definition="#PROCSTAT" /></td>
										<td><s:Code2Name code="100" definition="#PROCSTAT" /></td>
										<td><s:Code2Name code="100" definition="#PROCSTAT" /></td>
										<td><s:Code2Name code="100" definition="#PROCSTAT" /></td>
										<td><s:Code2Name code="1" definition="#PROCSTAT" /></td>
									</c:if>
									<c:if test="${item.procstat eq -2}">
										<td><s:Code2Name code="-1" definition="#PROCSTAT" /></td>
										<td><s:Code2Name code="0" definition="#PROCSTAT" /></td>
										<td><s:Code2Name code="0" definition="#PROCSTAT" /></td>
										<td><s:Code2Name code="0" definition="#PROCSTAT" /></td>
										<td><s:Code2Name code="0" definition="#PROCSTAT" /></td>
										<td><s:Code2Name code="0" definition="#PROCSTAT" /></td>
									</c:if>
									<c:if test="${item.procstat eq -3}">
										<td><s:Code2Name code="100" definition="#PROCSTAT" /></td>
										<td><s:Code2Name code="-1" definition="#PROCSTAT" /></td>
										<td><s:Code2Name code="0" definition="#PROCSTAT" /></td>
										<td><s:Code2Name code="0" definition="#PROCSTAT" /></td>
										<td><s:Code2Name code="0" definition="#PROCSTAT" /></td>
										<td><s:Code2Name code="0" definition="#PROCSTAT" /></td>
									</c:if>
									<c:if test="${item.procstat eq -4}">
										<td><s:Code2Name code="100" definition="#PROCSTAT" /></td>
										<td><s:Code2Name code="100" definition="#PROCSTAT" /></td>
										<td><s:Code2Name code="-1" definition="#PROCSTAT" /></td>
										<td><s:Code2Name code="0" definition="#PROCSTAT" /></td>
										<td><s:Code2Name code="0" definition="#PROCSTAT" /></td>
										<td><s:Code2Name code="0" definition="#PROCSTAT" /></td>
									</c:if>
									<c:if test="${item.procstat eq -5}">
										<td><s:Code2Name code="100" definition="#PROCSTAT" /></td>
										<td><s:Code2Name code="100" definition="#PROCSTAT" /></td>
										<td><s:Code2Name code="100" definition="#PROCSTAT" /></td>
										<td><s:Code2Name code="-1" definition="#PROCSTAT" /></td>
										<td><s:Code2Name code="0" definition="#PROCSTAT" /></td>
										<td><s:Code2Name code="0" definition="#PROCSTAT" /></td>
									</c:if>
									<c:if test="${item.procstat eq -6}">
										<td><s:Code2Name code="100" definition="#PROCSTAT" /></td>
										<td><s:Code2Name code="100" definition="#PROCSTAT" /></td>
										<td><s:Code2Name code="100" definition="#PROCSTAT" /></td>
										<td><s:Code2Name code="100" definition="#PROCSTAT" /></td>
										<td><s:Code2Name code="-1" definition="#PROCSTAT" /></td>
										<td><s:Code2Name code="0" definition="#PROCSTAT" /></td>
									</c:if>
									<c:if test="${item.procstat eq -7}">
										<td><s:Code2Name code="100" definition="#PROCSTAT" /></td>
										<td><s:Code2Name code="100" definition="#PROCSTAT" /></td>
										<td><s:Code2Name code="100" definition="#PROCSTAT" /></td>
										<td><s:Code2Name code="100" definition="#PROCSTAT" /></td>
										<td><s:Code2Name code="100" definition="#PROCSTAT" /></td>
										<td><s:Code2Name code="-1" definition="#PROCSTAT" /></td>
									</c:if>
									<td><c:out value="${item.starttime2}" /></td>
									<td><c:out value="${item.endtime2}" /></td>
								</tr>
							</c:forEach>
						</table>
					</div>
					<div class="table_div">
						<s:PageNav dpName="LIST" />
					</div>
			</html:form>
		</div>
	</body>
</html>
