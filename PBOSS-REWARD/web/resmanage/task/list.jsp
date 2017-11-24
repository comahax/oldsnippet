<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc"%>
<%
	String ID_EXCEL = "1A2BA0T0BT1";
	String ID_TXT = "1A2BA0T0BT2";
%>
<script type="text/javascript"
	src="<%=contextPath%>/js/bus/waycommon.js"></script>
<html>
	<head>
		<title><bean:message bundle="task" key="titleList" />
		</title>
		<script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            return checkval(window);
        }
        function doExport(cmd)
        {
        	var url="<%=contextPath%>/resmanage/task.do?CMD="+cmd;
        	formList.action=url;
        	formList.submit();
        	formList.action="<%=contextPath%>/resmanage/task.do?CMD=LIST";
        }
    </script>
	</head>
	<body onload="if(window.loadforiframe) loadforiframe();">
		<div class="table_container">
			<html:form action="/resmanage/task.do?CMD=LIST" styleId="formList"
				method="post" onsubmit="return ev_check();">
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
								<bean:message bundle="task" key="titleList" />
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
								<bean:message bundle="task" key="taskid" />
								:
							</td>
							<td class="form_table_left">
								<html:text styleClass="form_input_1x" property="_se_taskid"></html:text>
							</td>
							<td width="126" height="20" align="right"
								class="form_table_right">
								<bean:message bundle="task" key="oprcode" />
								:
							</td>
							<td class="form_table_left">
								<html:text styleClass="form_input_1x" property="_se_oprcode"></html:text>
							</td>
							<td width="126" height="20" align="right"
								class="form_table_right">
								<bean:message bundle="task" key="wayid" />
								:
							</td>
							<td class="form_table_left">
								<html:text styleClass="form_input_1x" property="_se_wayid"
									onclick="showSelectWay(this);" readonly="false" />
							</td>
						</tr>
						<tr>
							<td width="126" height="20" align="right"
								class="form_table_right">
								<bean:message bundle="task" key="filecode" />
								:
							</td>
							<td class="form_table_left">
								<s:zoom definition="#FILEDEF" property="_se_filecode"
									styleClass="form_input_1x" />
							</td>
							<td width="126" height="20" align="right"
								class="form_table_right">
								<bean:message bundle="task" key="createtime" />
								>=:
							</td>
							<td class="form_table_left">
								<html:text styleClass="form_input_1x" property="_dnl_createtime"
									onclick="this.value=selectDatetime();" readonly="false" />
							</td>
							<td width="126" height="20" align="right"
								class="form_table_right">
								<bean:message bundle="task" key="createtime" />
								<=:
							</td>
							<td class="form_table_left">
								<html:text styleClass="form_input_1x" property="_dnm_createtime"
									onclick="this.value=selectDatetime();" readonly="false" />
							</td>
						</tr>
						<tr>
							<td width="126" height="20" align="right"
								class="form_table_right">
								<bean:message bundle="task" key="taskstate" />
								:
							</td>
							<td class="form_table_left">
								<html:select property="_ne_taskstate">
									<option value=""></option>
									<s:Options definition="$IM_TASKSTATE"></s:Options>
								</html:select>
							</td>
							<td width="126" height="20" align="right"
								class="form_table_right">
								<bean:message bundle="task" key="exectime" />
								>=:
							</td>
							<td class="form_table_left">
								<html:text styleClass="form_input_1x" property="_dnl_exectime"
									onclick="this.value=selectDatetime();" readonly="false" />
							</td>
							<td width="126" height="20" align="right"
								class="form_table_right">
								<bean:message bundle="task" key="exectime" />
								<=:
							</td>
							<td class="form_table_left">
								<html:text styleClass="form_input_1x" property="_dnm_exectime"
									onclick="this.value=selectDatetime();" readonly="false" />
							</td>
						</tr>
						<tr>
							<td width="126" height="20" align="right"
								class="form_table_right">
								<bean:message bundle="task" key="endtime" />
								>=:
							</td>
							<td class="form_table_left">
								<html:text styleClass="form_input_1x" property="_dnl_endtime"
									onclick="this.value=selectDatetime();" readonly="false" />
							</td>
							<td width="126" height="20" align="right"
								class="form_table_right">
								<bean:message bundle="task" key="endtime" />
								<=:
							</td>
							<td class="form_table_left">
								<html:text styleClass="form_input_1x" property="_dnm_endtime"
									onclick="this.value=selectDatetime();" readonly="false" />
							</td>
							<td width="126" height="20" align="right"
								class="form_table_right">
								&nbsp;
							</td>
							<td class="form_table_left">
								&nbsp;
							</td>
						</tr>
					</table>
				</div>
				<div class="table_div">
					<table class="table_button_list">
						<tr>
							<td>
								<input type="button" class="query"
									onmouseover="buttonover(this);" onmouseout="buttonout(this);"
									onfocus="buttonover(this)" onblur="buttonout(this)"
									value="<bean:message bundle="public" key="button_search"/>"
									onClick="doQuery();">
								<s:PurChk2 controlid="<%=ID_EXCEL%>">
									<input type="button" class="button_5"
										onmouseover="buttonover(this);" onmouseout="buttonout(this);"
										onfocus="buttonover(this)" onblur="buttonout(this)"
										value="<bean:message bundle="public" key="button_export_excel"/>"
										onClick="doExport('EXCEL');">
								</s:PurChk2>
								<s:PurChk2 controlid="<%=ID_TXT%>">
									<input type="button" class="button_5"
										onmouseover="buttonover(this);" onmouseout="buttonout(this);"
										onfocus="buttonover(this)" onblur="buttonout(this)"
										value="<bean:message bundle="public" key="button_export_txt"/>"
										onClick="doExport('TXT');">
								</s:PurChk2>
							</td>
						</tr>
					</table>
				</div>
				<div class="table_div">
					<div class="table_LongTable">
						<table class="table_style" ID="Table2">
							<tr class="table_style_head">
								<td>
									<a href="javascript:doOrderby('taskid')"><bean:message
											bundle="task" key="taskid" /> </a>
									<s:OrderImg form="/resmanage/task/taskForm" field="taskid" />
								</td>
								<td>
									<a href="javascript:doOrderby('filecode')"><bean:message
											bundle="task" key="filecode" /> </a>
									<s:OrderImg form="/resmanage/task/taskForm" field="filecode" />
								</td>
								<td>
									<a href="javascript:doOrderby('subsystem')"><bean:message
											bundle="task" key="subsystem" /> </a>
									<s:OrderImg form="/resmanage/task/taskForm" field="subsystem" />
								</td>
								<td>
									<a href="javascript:doOrderby('taskstate')"><bean:message
											bundle="task" key="taskstate" /> </a>
									<s:OrderImg form="/resmanage/task/taskForm" field="taskstate" />
								</td>
								<td>
									<a href="javascript:doOrderby('createtime')"><bean:message
											bundle="task" key="createtime" /> </a>
									<s:OrderImg form="/resmanage/task/taskForm" field="createtime" />
								</td>
								<td>
									<a href="javascript:doOrderby('exectime')"><bean:message
											bundle="task" key="exectime" /> </a>
									<s:OrderImg form="/resmanage/task/taskForm" field="exectime" />
								</td>
								<td>
									<a href="javascript:doOrderby('endtime')"><bean:message
											bundle="task" key="endtime" /> </a>
									<s:OrderImg form="/resmanage/task/taskForm" field="endtime" />
								</td>
								<td>
									<a href="javascript:doOrderby('oprcode')"><bean:message
											bundle="task" key="oprcode" /> </a>
									<s:OrderImg form="/resmanage/task/taskForm" field="oprcode" />
								</td>
								<td>
									<a href="javascript:doOrderby('wayid')"><bean:message
											bundle="task" key="wayid" /> </a>
									<s:OrderImg form="/resmanage/task/taskForm" field="wayid" />
								</td>
								<td>
									<bean:message bundle="task" key="taskfilecount" />
								</td>
								<td>
									<bean:message bundle="task" key="totalcount" />
								</td>
								<td>
									<bean:message bundle="task" key="currentcount" />
								</td>
								<td>
									<bean:message bundle="task" key="successcount" />
								</td>
								<td>
									<bean:message bundle="task" key="resultfile" />
								</td>
								<td>
									<bean:message bundle="task" key="logfile" />
								</td>
								<td>
									<bean:message bundle="task" key="memo" />
								</td>
							</tr>
							<c:forEach var="item" items="${requestScope.LIST.datas}">
								<tr class="table_style_content" align="center">
									<td>
										<c:out value="${item.taskid}" />
									</td>
									<td>
										<s:Code2Name definition="#FILEDEF" code="${item.filecode}" />
									</td>
									<td>
										<s:Code2Name definition="#SUBSYSTEM" code="${item.subsystem}" />
									</td>
									<td>
										<s:Code2Name definition="$IM_TASKSTATE"
											code="${item.taskstate}" />
									</td>
									<td>
										<fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss"
											value="${item.createtime}" />
									</td>
									<td>
										<fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss"
											value="${item.exectime}" />
									</td>
									<td>
										<fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss"
											value="${item.endtime}" />
									</td>
									<td>
										<c:out value="${item.oprcode}" />
									</td>
									<td>
										<s:Code2Name definition="#WAY" code="${item.wayid}" />
									</td>
									<td>
										<c:out value="${item.taskfilecount}" />
									</td>
									<td>
										<c:out value="${item.totalcount}" />
									</td>
									<td>
										<c:out value="${item.currentcount}" />
									</td>
									<td>
										<c:out value="${item.successcount}" />
									</td>
									<td>
										<c:if test="${!empty item.resultfile}">
											<a
												href='<%=contextPath%>/resmanage/task.do?CMD=DOWNLOAD&down=<c:out value="${item.resultfile}"/>'>
												<img height=10 src="<%=contextPath%>/images/file.png"
													width=10 border=0> </a>
										</c:if>
									</td>
									<td>
										<c:if test="${!empty item.logfile}">
											<a
												href='<%=contextPath%>/resmanage/task.do?CMD=DOWNLOAD&down=<c:out value="${item.logfile}"/>'>
												<img height=10 src="<%=contextPath%>/images/file.png"
													width=10 border=0> </a>
										</c:if>
									</td>
									<td>
										<c:out value="${item.memo}" />
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
