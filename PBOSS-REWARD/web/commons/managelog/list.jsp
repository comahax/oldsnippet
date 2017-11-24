<%@ page language="java" contentType="text/html;charset=GBK"%>
<jsp:include page="/inc/acl.jsp">
	<jsp:param name="PID" value="4D7G2BB0" />
</jsp:include>
<%@ include file="/inc/listhead.inc"%>
<%String ID_1 = "4D7G2BB0BT1";
			String ID_2 = "4D7G2BB0BT2";
			String ID_3 = "00010703";
			String ID_4 = "00010704";

			%>
<html>
	<head>
		<title><bean:message bundle="managelog" key="title" /></title>
		<script language="JavaScript" type="text/JavaScript">
        function ev_check() {

            addfield('_dnl_oprtime', '<bean:message bundle="managelog" key="_dnl_oprtime"/>', 'dt', true, 20);
            addfield('_dnm_oprtime', '<bean:message bundle="managelog" key="actiontime"/>', 'dt', true, 20);
            addfield('_se_oprtype', '<bean:message bundle="managelog" key="oprtype"/>', 'c', true, 64);
            addfield('_se_opraction', '<bean:message bundle="managelog" key="opraction"/>', 'c', true, 64);
            addfield('_se_oprcode', '<bean:message bundle="managelog" key="oprcode"/>', 'c', true, 16);
           if(date_compare("_dnl_oprtime","_dnm_oprtime","<bean:message bundle="public" key="msgTimeRangeError"/>"))return;
            return checkval(window);
        }
       
    </script>
	</head>

	<body onload="loadforiframe();">
		<div class="table_container">

			<html:form action="/common/managelog.do?CMD=LIST" styleId="formList" method="post" onsubmit="return ev_check();">
				<html:hidden property="_orderby" />
				<html:hidden property="_desc" />
				<html:hidden property="_pageno" />
				<html:hidden property="_pagesize" />
	

				
				<input type="hidden" name="_rowcount" value="<c:out value='${requestScope.LIST.rowCount}' />">



				<div class="table_div">

					<table class="top_table">
						<tr>

							<td>
								<bean:message bundle="managelog" key="title" />
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
					<table class="form_table">
						<tr>
							<td class="form_table_right">
								<bean:message bundle="managelog" key="_dnl_oprtime" />
								:
							</td>
							<td class="form_table_left">
								<html:text styleClass="form_input_1x" property="_dnl_oprtime" onclick="this.value=selectDatetime()"></html:text>
							</td>
							<td class="form_table_right">
								<bean:message bundle="managelog" key="_dnm_oprtime" />
								:
							</td>
							<td class="form_table_left">
								<html:text styleClass="form_input_1x" property="_dnm_oprtime" onclick="this.value=selectDatetime()"></html:text>
							</td>
						</tr>
						<tr>
							<td class="form_table_right">
								<bean:message bundle="managelog" key="oprtype" />
								:
							</td>
							<td class="form_table_left">
								<html:text styleClass="form_input_1x" property="_se_oprtype"></html:text>
								<!--<html:select property="_se_oprtype">
									<html:option value=""></html:option>
									<s:Options definition="#M_OPRTYPE" nameOnly="false" />
								</html:select>
							--></td>

							<td class="form_table_right">
								<bean:message bundle="managelog" key="opraction" />
								:
							</td>
							<td class="form_table_left">
								<html:select property="_se_opraction">
									<html:option value=""></html:option>
									<s:Options definition="#M_OPRACTION" nameOnly="false" />
								</html:select>
							</td>
						</tr>
						<tr>
							<td class="form_table_right">
								<bean:message bundle="managelog" key="oprcode" />
								:
							</td>
							<td class="form_table_left" colspan=3>
							   <html:text styleClass="form_input_1x" property="_se_oprcode"></html:text>
							</td>
						</tr>
					</table>
				</div>

				<div class="table_div">
					<table class="table_button_list">
						<tr>
							<td>
								<table>
									<tr>
										<td align=right>
											<s:PurChk controlid="<%=ID_1%>">
												<input type="button" class="query" onmouseover="buttonover(this);" 
													onmouseout="buttonout(this);" onfocus="buttonover(this)" 
													onblur="buttonout(this)" value="<bean:message bundle="public" key="button_search"/>" 
													onClick="doQuery();" />
											</s:PurChk>
				
										</td>
									</tr>
								</table>
							</td>
						</tr>
					</table>
				</div>


				<div class="table_div">
					<div class="table_LongTable">
						<table class="table_style" ID="Table2">
							<tr class="table_style_head">

								<td >
									<a href="javascript:doOrderby('logid')"><bean:message bundle="managelog" key="logid" /></a>
									<s:OrderImg form="/common/managelog/manageLogForm" field="logid" />
								</td>
								<td >
									<a href="javascript:doOrderby('oprcode')"><bean:message bundle="managelog" key="oprcode" /></a>
									<s:OrderImg form="/common/managelog/manageLogForm" field="oprcode" />
								</td>
								<td >
									<a href="javascript:doOrderby('oprtype')"><bean:message bundle="managelog" key="oprtype" /></a>
									<s:OrderImg form="/common/managelog/manageLogForm" field="oprtype" />
								</td>
								<td >
									<a href="javascript:doOrderby('opraction')"><bean:message bundle="managelog" key="opraction" /></a>
									<s:OrderImg form="/common/managelog/manageLogForm" field="opraction" />
								</td>
								<td >
									<a href="javascript:doOrderby('oprtime')"><bean:message bundle="managelog" key="oprtime" /></a>
									<s:OrderImg form="/common/managelog/manageLogForm" field="oprtime" />
								</td>
								<td >
									<a href="javascript:doOrderby('oprstate')"><bean:message bundle="managelog" key="oprstate" /></a>
									<s:OrderImg form="/common/managelog/manageLogForm" field="oprstate" />
								</td>
								<td >
									<a href="javascript:doOrderby('oprcon1')"><bean:message bundle="managelog" key="oprcon1" /></a>
									<s:OrderImg form="/common/managelog/manageLogForm" field="oprcon1" />
								</td>
								<td >
									<a href="javascript:doOrderby('oprcon2')"><bean:message bundle="managelog" key="oprcon2" /></a>
									<s:OrderImg form="/common/managelog/manageLogForm" field="oprcon2" />
								</td>
								
							</tr>
							<c:forEach var="item" items="${requestScope.LIST.datas}">
								<tr class="table_style_content" align="center">

									<td>
										<c:out value="${item.logid}" />
									</td>
						
									<td>
										<c:out value="${item.oprcode}" />
									</td>
									<td>
										<c:out value="${item.oprtype}" />
										<!--<s:Code2Name code="${item.oprtype}" definition="#M_OPRTYPE" />
									--></td>
									<td>
										<s:Code2Name code="${item.opraction}" definition="#M_OPRACTION" />
									</td>
									<td>
										<fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${item.oprtime}" />
									</td>
									<td>
										<c:out value="${item.oprstate}" />
									</td>
									<td>
										<c:out value="${item.oprcon1}" />
									</td>
									<td>
										<c:out value="${item.oprcon2}" />
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
