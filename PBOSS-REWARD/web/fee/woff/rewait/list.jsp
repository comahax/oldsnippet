<%@ page language="java" contentType="text/html;charset=GBK"%>
<jsp:include page="/inc/acl.jsp">
	<jsp:param name="PID" value="4D1A1A" />
</jsp:include>
<%@ include file="/inc/listhead.inc"%>
<html>
	<head>
		<title><bean:message bundle="rewait" key="title" /></title>
		<script language="JavaScript" type="text/JavaScript">
        function ev_check() {
			addfield('_se_reqstream', '<bean:message bundle="rewait" key="reqstream"/>', 'c', true, 50);
            addfield('_se_areacode', '<bean:message bundle="rewait" key="areacode"/>', 'c', true, 10);
            addfield('_dnl_reqtime', '<bean:message bundle="rewait" key="dnlreqtime"/>', 'dt', true, 20);
            addfield('_dnm_reqtime', '<bean:message bundle="rewait" key="dnmreqtime"/>', 'dt', true, 20);
            addfield('_dnl_dealtime', '<bean:message bundle="rewait" key="dnldealtime"/>', 'dt', true, 20);
            addfield('_dnm_dealtime', '<bean:message bundle="rewait" key="dnmdealtime"/>', 'dt', true, 20);
            addfield('_ne_dealstate', '<bean:message bundle="rewait" key="dealstate"/>', 'i', true, 3);
            addfield('_ne_trastate', '<bean:message bundle="rewait" key="trastate"/>', 'i', true, 3);
            addfield('_dnl_tradate', '<bean:message bundle="rewait" key="dnltradate"/>', 'dt', true, 20);
            addfield('_dnm_tradate', '<bean:message bundle="rewait" key="dnmtradate"/>', 'dt', true, 20);
            return checkval(window);
        }
        function doReq(url){
        	formList.action="<%=contextPath%>/fee/woff/rewait.do?CMD=REQ";
        	formList.submit();
        }
        function doSanction(url){ 
    		formList.action = "<%=contextPath%>/fee/woff/rewait.do?CMD=SANCTION";
    		formList.submit();
        }
    </script> 
	</head>
	<body onload="loadforiframe();">
		<div class="table_container">
			<html:form action="/fee/woff/rewait.do?CMD=LIST" styleId="formList"
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
								<bean:message bundle="rewait" key="title" />
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
								<bean:message bundle="rewait" key="reqstream" />
								:
							</td>
							<td class="form_table_left">
								<html:text styleClass="form_input_1x" property="_se_reqstream"></html:text>
							</td>


							<td class="form_table_right">
								<bean:message bundle="rewait" key="areacode" />
								:
							</td>
							<td class="form_table_left">

								<s:zoom definition="#CITYIDNUM2NMAME" property="_se_areacode"
									styleClass="form_input_1x" nameOnly="false" />
							</td>
						</tr>

						<tr>
							<td class="form_table_right">
								<bean:message bundle="rewait" key="dnlreqtime" />
								>= :
							</td>
							<td class="form_table_left">
								<html:text styleClass="form_input_1x" property="_dnl_reqtime"
									onclick="this.value=selectDatetime()"></html:text>
							</td>


							<td class="form_table_right">
								<bean:message bundle="rewait" key="dnmreqtime" />
								<= :
							</td>
							<td class="form_table_left">
								<html:text styleClass="form_input_1x" property="_dnm_reqtime"
									onclick="this.value=selectDatetime()"></html:text>
							</td>
						</tr>

						<tr>
							<td class="form_table_right">
								<bean:message bundle="rewait" key="dnldealtime" />
								>= :
							</td>
							<td class="form_table_left">
								<html:text styleClass="form_input_1x" property="_dnl_dealtime"
									onclick="this.value=selectDatetime()"></html:text>
							</td>


							<td class="form_table_right">
								<bean:message bundle="rewait" key="dnmdealtime" />
								<= :
							</td>
							<td class="form_table_left">
								<html:text styleClass="form_input_1x" property="_dnm_dealtime"
									onclick="this.value=selectDatetime()"></html:text>
							</td>
						</tr>

						<tr>
							<td class="form_table_right">
								<bean:message bundle="rewait" key="dealstate" />
								:
							</td>
							<td class="form_table_left">
								<html:select property="_ne_dealstate">
									<option></option>
									<s:Options definition="#DEALSTATE" />
								</html:select>
							</td>


							<td class="form_table_right">
								<bean:message bundle="rewait" key="trastate" />
								:
							</td>
							<td class="form_table_left">
								<html:select property="_ne_trastate">
									<option></option>
									<s:Options definition="#TRASTATE" />
								</html:select>
							</td>
						</tr>

						<tr>
							<td class="form_table_right">
								<bean:message bundle="rewait" key="dnltradate" />
								>= :
							</td>
							<td class="form_table_left">
								<html:text styleClass="form_input_1x" property="_dnl_tradate"
									onclick="this.value=selectDatetime()"></html:text>
							</td>


							<td class="form_table_right">
								<bean:message bundle="rewait" key="dnmtradate" />
								<= :
							</td>
							<td class="form_table_left">
								<html:text styleClass="form_input_1x" property="_dnm_tradate"
									onclick="this.value=selectDatetime()"></html:text>
							</td>
						</tr>

					</table>
				</div>
				<div class="table_div">
					<table class="table_button_list">
						<tr>
							<td>
							<s:PurChk2 controlid="REWAITL_PAS || REWAITL_REQ" disableChild="true">
								<input type="button" name="btnNew" class="add"
									onmouseover="buttonover(this);" onmouseout="buttonout(this);"
									onfocus="buttonover(this)" onblur="buttonout(this)"
									value="<bean:message bundle="rewait" key="button_req"/>"
									onClick="doReq('/fee/woff/rewait.do')">
							</s:PurChk2>
							<s:PurChk2 controlid="REWAITL_PAS || REWAITL_DET" disableChild="true">
								<input type="button" name="btnDelete" class="delete"
									onmouseover="buttonover(this);" onmouseout="buttonout(this);"
									onfocus="buttonover(this)" onblur="buttonout(this)"
									value="<bean:message bundle="public" key="button_delete"/>"
									onClick="doDelete('/fee/woff/rewait.do')">
							</s:PurChk2>
							<s:PurChk2 controlid="REWAITL_PAS" disableChild="true">
								<input type="button" name="btnSanction" class="add"
									onmouseover="buttonover(this);" onmouseout="buttonout(this);"
									onfocus="buttonover(this)" onblur="buttonout(this)"
									value="<bean:message bundle="rewait" key="button_sanction"/>"
									onClick="doSanction('/fee/woff/rewait.do')">
							</s:PurChk2>
								<input type="button" class="query"
									onmouseover="buttonover(this);" onmouseout="buttonout(this);"
									onfocus="buttonover(this)" onblur="buttonout(this)"
									value="<bean:message bundle="public" key="button_search"/>"
									onclick="doQuery()" />
							</td>
						</tr>
					</table>
				</div>
				<div class="table_div">
					<div class="table_LongTable">
						<table class="table_style" ID="Table2">
							<tr class="table_style_head">
								<td
									title="<bean:message bundle="public" key="list_title_select"/>">
									<input type="checkbox" name="allbox" onclick="checkAll();"
										class="table_checkbox">
								</td>
								<td>
									<a href="javascript:doOrderby('reqstream')"><bean:message
											bundle="rewait" key="reqstream" /> </a>
									<s:OrderImg form="/fee/woff/rewait/ReWaitForm"
										field="reqstream" />
								</td>
								<td>
									<a href="javascript:doOrderby('areacode')"><bean:message
											bundle="rewait" key="areacode" /> </a>
									<s:OrderImg form="/fee/woff/rewait/ReWaitForm" field="areacode" />
								</td>
								<td>
									<a href="javascript:doOrderby('masterid')"><bean:message
											bundle="rewait" key="masterid" /> </a>
									<s:OrderImg form="/fee/woff/rewait/ReWaitForm" field="masterid" />
								</td>
								<td>
									<a href="javascript:doOrderby('reqtime')"><bean:message
											bundle="rewait" key="reqtime" /> </a>
									<s:OrderImg form="/fee/woff/rewait/ReWaitForm" field="reqtime" />
								</td>
								<td>
									<a href="javascript:doOrderby('dealtime')"><bean:message
											bundle="rewait" key="dealtime" /> </a>
									<s:OrderImg form="/fee/woff/rewait/ReWaitForm" field="dealtime" />
								</td>
								<td>
									<a href="javascript:doOrderby('amt')"><bean:message
											bundle="rewait" key="amt" /> </a>
									<s:OrderImg form="/fee/woff/rewait/ReWaitForm" field="amt" />
								</td>
								<td>
									<a href="javascript:doOrderby('belongto')"><bean:message
											bundle="rewait" key="belongto" /> </a>
									<s:OrderImg form="/fee/woff/rewait/ReWaitForm" field="belongto" />
								</td>
								<td>
									<a href="javascript:doOrderby('dealstate')"><bean:message
											bundle="rewait" key="dealstate" /> </a>
									<s:OrderImg form="/fee/woff/rewait/ReWaitForm"
										field="dealstate" />
								</td>
								<td>
									<a href="javascript:doOrderby('tradate')"><bean:message
											bundle="rewait" key="tradate" /> </a>
									<s:OrderImg form="/fee/woff/rewait/ReWaitForm" field="tradate" />
								</td>
								<td>
									<a href="javascript:doOrderby('trastate')"><bean:message
											bundle="rewait" key="trastate" /> </a>
									<s:OrderImg form="/fee/woff/rewait/ReWaitForm" field="trastate" />
								</td>
								<td>
									<a href="javascript:doOrderby('memo')"><bean:message
											bundle="rewait" key="memo" /> </a>
									<s:OrderImg form="/fee/woff/rewait/ReWaitForm" field="memo" />
								</td>

							</tr>
							<c:forEach var="item" items="${requestScope.LIST.datas}">
								<c:url value="/fee/woff/rewait.do?CMD=EDIT" var="urlContent">
									<c:param name="PK" value="${item.reqstream}" />
								</c:url>
								<tr class="table_style_content" align="center">
									<td>
										<input type="checkbox" name="_selectitem"
											value="<c:out value='${item.reqstream}' />"
											onclick="checkOne();" class="table_checkbox">
									</td>
									<td>
									<s:PurChk2 controlid="REWAITL_PAS || REWAITL_REQ" disableChild="true">
										<a href='<c:out value="${urlContent}"/>'><c:out
												value="${item.reqstream}" /> </a>
									</s:PurChk2>
									</td>
									<td>
										<s:Code2Name code="${item.areacode}"
											definition="#CITYIDNUM2NMAME" />
									</td>
									<td>
										<c:out value="${item.masterid}" />
									</td>

									<td>
										<fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss"
											value="${item.reqtime}" />
									</td>
									<td>
										<fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss"
											value="${item.dealtime}" />
									</td>
									<td><fmt:formatNumber type="currency" value="${item.amt}" /></td>
									<td>
										<c:out value="${item.belongto}" />
									</td>
									<td>
										<s:Code2Name code="${item.dealstate}" definition="#DEALSTATE" />
									</td>
									<td>
										<fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss"
											value="${item.tradate}" />
									</td>
									<td>
										<s:Code2Name code="${item.trastate}" definition="#TRASTATE" />
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
