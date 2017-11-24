<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc"%>
<jsp:include page="/inc/acl.jsp">
	<jsp:param name="PID" value="2B1A1A50" />
</jsp:include>
<%
	String ID_QUERY = "CH_PW_COUNTYCOM_QUERY";
	String ID_ADD = "CH_PW_COUNTYCOM_ADD";
	String ID_DELETE = "CH_PW_COUNTYCOM_DELETE";
	String ID_EDIT = "CH_PW_COUNTYCOM_EDIT";
	String ID_IMPORT = "CH_PW_COUNTYCOM_BATCHIMPORT";
%>
<html>
	<head>
		<title><bean:message bundle="cntycompany" key="titleList" />
		</title>
		<script type="text/javascript"
			src="<%=contextPath%>/js/bus/waycommon.js"></script>
		<script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            addfield('_sk_countycompid', '<bean:message bundle="cntycompany" key="countycompid"/>', 'c', true, 14);
            addfield('_sk_countycompname', '<bean:message bundle="cntycompany" key="countycompname"/>', 'c', true, 64);
            addfield('_se_citycompid', '<bean:message bundle="cntycompany" key="citycompid"/>', 'c', true, 14);
            addfield('_ne_countycomptype', '<bean:message bundle="cntycompany" key="countycomptype"/>', 'i', true, 3);
            return checkval(window);
        }
        function goTo(cmdNew) {
		    var url = contextPath + cmdNew;
		    formList.action = url;
		    formList.submit();
		}
    </script>
	</head>

	<body onload="loadforiframe();">
		<div class="table_container">

			<html:form action="/cms/cntycompany.do?CMD=LIST" styleId="formList"
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
								<bean:message bundle="cntycompany" key="titleList" />
							</td>
						</tr>
					</table>
				</div>

				<div class="table_div">
					<table width="100%" class="error_text">
						<s:Msg />
					</table>
				</div>

				<div class="table_div">
					<table class="form_table">
						<tr>
							<td width="126" height="20" align="right"
								class="form_table_right">
								<bean:message bundle="cntycompany" key="countycompid" />
								:
							</td>
							<td class="form_table_left">
								<html:text styleClass="form_input_1x"
									property="_sk_countycompid" readonly="true"
									onclick="showOrgTree(this,'_sk_countycompid','Cntycom')" />
							</td>
							<td width="126" height="20" align="right"
								class="form_table_right">
								<bean:message bundle="cntycompany" key="countycompname" />
								:
							</td>
							<td class="form_table_left">
								<html:text styleClass="form_input_1x"
									property="_sk_countycompname"></html:text>
							</td>
						</tr>
						<tr>
							<td width="126" height="20" align="right"
								class="form_table_right">
								<bean:message bundle="cntycompany" key="countycomptype" />
								:
							</td>
							<td class="form_table_left">
								<html:select property="_ne_countycomptype">
									<option />
										<s:Options definition="$CH_COUNTYCOMPTYPE" />
								</html:select>
							</td>
							<td width="126" height="20" align="right"
								class="form_table_right">
								<bean:message bundle="cntycompany" key="citycompid" />
								:
							</td>
							<td class="form_table_left">
								<html:text styleClass="form_input_1x" property="_se_citycompid"
									readonly="true"
									onclick="showOrgTree(this,'_se_citycompid','Citycom')" />
							</td>
						</tr>
					</table>
				</div>

				<div class="table_div">
					<table class="table_button_list">
						<tr>
							<td>
								<s:PurChk2 controlid="<%=ID_QUERY%>">
									<input type="button" class="query" onclick="doQuery();" 
										onmouseover="buttonover(this);" onmouseout="buttonout(this);"
										onfocus="buttonover(this)" onblur="buttonout(this)"
										value="<bean:message bundle="public" key="button_search"/>" />
								</s:PurChk2>
								<s:PurChk2 controlid="<%=ID_ADD%>">
									<input type="button" name="btnNew" class="add"
										onmouseover="buttonover(this);" onmouseout="buttonout(this);"
										onfocus="buttonover(this)" onblur="buttonout(this)"
										value="<bean:message bundle="public" key="button_new"/>"
										onClick="doNew('/cms/cntycompany.do')">
								</s:PurChk2>
								<s:PurChk2 controlid="<%=ID_IMPORT%>">
									<input type="button" class="button_2"
										onmouseover="buttonover(this);" onmouseout="buttonout(this);"
										onfocus="buttonover(this)" onblur="buttonout(this)"
										onClick="goTo('/cms/cntycompany/process.do')"
										value="<bean:message bundle="cntycompany" key="import"/>" />
								</s:PurChk2>
								<s:PurChk2 controlid="<%=ID_DELETE%>">
									<input type="button" name="btnDelete" class="delete"
										onmouseover="buttonover(this);" onmouseout="buttonout(this);"
										onfocus="buttonover(this)" onblur="buttonout(this)"
										value="<bean:message bundle="public" key="button_delete"/>"
										onClick="doDelete('/cms/cntycompany.do')">
								</s:PurChk2>

							</td>
						</tr>
					</table>
				</div>

				<div class="table_div">
					<table class="table_style" ID="Table2">
						<tr class="table_style_head">
							<td
								title="<bean:message bundle="public" key="list_title_select"/>">
								<input type="checkbox" name="allbox" onclick="checkAll();"
									class="table_checkbox">
							</td>
							<td>
								<a href="javascript:doOrderby('countycompid')"><bean:message
										bundle="cntycompany" key="countycompid" /> </a>
								<s:OrderImg form="/cms/cntycompany/AreacenterForm"
									field="countycompid" />
							</td>
							<td>
								<a href="javascript:doOrderby('countycompname')"><bean:message
										bundle="cntycompany" key="countycompname" /> </a>
								<s:OrderImg form="/cms/cntycompany/AreacenterForm"
									field="countycompname" />
							</td>
							<td>
								<bean:message bundle="cntycompany" key="countycomptype" />
							</td>
							<td>
								<bean:message bundle="cntycompany" key="citycompid" />
							</td>
							<td>
								<bean:message bundle="cntycompany" key="agent" />
							</td>
							<td>
								<bean:message bundle="cntycompany" key="billingcode" />
							</td>
						</tr>
						<c:forEach var="item" items="${requestScope.LIST.datas}">
							<c:url value="/cms/cntycompany.do?CMD=EDIT" var="urlContent">
								<c:param name="PK" value="${item.countycompid}" />
							</c:url>
							<tr class="table_style_content" align="center">
								<td>
									<input type="checkbox" name="_selectitem"
										value="<c:out value='${item.countycompid}' />"
										onclick="checkOne();" class="table_checkbox">
								</td>
								<td>
									<s:PurChk2 controlid="<%=ID_EDIT%>" disableChild="true">
										<a href='<c:out value="${urlContent}"/>'><c:out
												value="${item.countycompid}" /> </a>
									</s:PurChk2>
								</td>
								<td>
									<c:out value="${item.countycompname}" />
								</td>
								<td>
									<s:Code2Name code="${item.countycomptype}"
										definition="$CH_COUNTYCOMPTYPE" />
								</td>
								<td>
									<s:Code2Name code="${item.citycompid}"
										definition="#CITYCOMPANY" />
								</td>
								<td>
									<c:out value="${item.agent}" />
								</td>
								<td>
									<c:out value="${item.billingcode}" />
								</td>
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
