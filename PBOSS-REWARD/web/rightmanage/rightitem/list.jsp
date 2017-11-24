<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc"%>
<link href="<%=contextPath%>/css/css_1/xmlhttp.css" rel="stylesheet"
	type="text/css" media="all" />
<%
	String ID_1 = "00010701";
	String ID_2 = "00010702";
	String ID_3 = "00010703";
	String ID_4 = "00010704";
	int i = 1;
%>
<html>
<head>
<title><bean:message bundle="rightitem" key="titleList" /></title>
<script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            return checkval(window);
        }
    </script>
</head>

<body onload="loadforiframe()">
<div class="table_container"><html:form action="/rightitem.do?CMD=LIST"
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
			<td><bean:message bundle="rightitem" key="rightitemmanage" /></td>
		</tr>
	</table>
	</div>
	<table class="table_div" width="100%">
		<html:errors />
		<s:Msg />
	</table>

	<div class="table_div">
	<table class="form_table">
		<tr>
			<td width="200" height="20" align="right" class="form_table_right">
			<bean:message bundle="rightitem" key="rightid" /> :</td>
			<td class="form_table_left"><html:text
				styleClass="form_input_1x" property="_se_rightid"></html:text></td>
			<td width="126" height="20" align="right" class="form_table_right">
			<bean:message bundle="rightitem" key="rightname" /> :</td>
			<td class="form_table_left"><html:text
				styleClass="form_input_1x" property="_se_rightname"></html:text></td>
			<td width="126" height="20" align="right" class="form_table_right">
			<bean:message bundle="rightitem" key="region" /> :</td>
			<td class="form_table_left"><html:text
				styleClass="form_input_1x" property="_ne_region"></html:text></td>
		</tr>
		<tr>
			<td width="126" height="20" align="right" class="form_table_right">
			<bean:message bundle="rightitem" key="operid" /> :</td>
			<td class="form_table_left"><html:text
				styleClass="form_input_1x" property="_se_operid"></html:text></td>
			<td width="126" height="20" align="right" class="form_table_right">
			<bean:message bundle="rightitem" key="orgid" /> :</td>
			<td class="form_table_left"><html:text
				styleClass="form_input_1x" property="_se_orgid"></html:text></td>
			<td width="126" height="20" align="right" class="form_table_right">
			<bean:message bundle="rightitem" key="status" /> :</td>
			<td class="form_table_left"><html:text
				styleClass="form_input_1x" property="_ne_status">
			</html:text></td>
		</tr>
		<tr>
			<td width="126" height="20" align="right" class="form_table_right">
			<bean:message bundle="rightitem" key="_dnl_createdate" /> :</td>
			<td class="form_table_left"><html:text
				styleClass="form_input_1x" property="_dnl_createdate"
				onclick="this.value=selectDate();"></html:text></td>
			<td width="126" height="20" align="right" class="form_table_right">
			<bean:message bundle="rightitem" key="_dnm_createdate" /> :</td>
			<td class="form_table_left" colspan=4><html:text
				styleClass="form_input_1x" property="_dnm_createdate"
				onclick="this.value=selectDate();"></html:text></td>
		</tr>
	</table>
	</div>
	<div class="table_div">
	<table class="table_button_list">
		<tr>
			<td align=right><s:PurChk controlid="<%=ID_1%>">
				<input type="button" name="btnNew" class="add"
					onmouseover="buttonover(this);" onmouseout="buttonout(this);"
					onfocus="buttonover(this)" onblur="buttonout(this)"
					value="<bean:message bundle="rightitem" key="add"/>"
					onClick="doNew('/rightitem.do')">
			</s:PurChk> <s:PurChk controlid="<%=ID_2%>">
				<input type="button" name="btnDelete" class="delete"
					onmouseover="buttonover(this);" onmouseout="buttonout(this);"
					onfocus="buttonover(this)" onblur="buttonout(this)"
					value="<bean:message bundle="rightitem" key="delete"/>"
					onClick="doDelete('/rightitem.do')">
			</s:PurChk> <s:PurChk controlid="<%=ID_3%>">
				<input type="button" name="btnDelete" class="delete"
					onmouseover="buttonover(this);" onmouseout="buttonout(this);"
					onfocus="buttonover(this)" onblur="buttonout(this)"
					value="<bean:message bundle="rightitem" key="list"/>"
					onClick="doQuery();">
			</s:PurChk> </td>
		</tr>
	</table>
	</div>
	<div class="table_div">
	<div class="table_LongTable">
	<table class="table_style" ID="Table2">
		<tr class="table_style_head">
			<td title="<bean:message bundle="public" key="list_title_select"/>"
				nowrap><input type="checkbox" name="allbox"
				onclick="checkAll();" class="table_checkbox"></td>
			<td nowrap><bean:message bundle="rightitem" key="rightid" /></td>
			<td nowrap><bean:message bundle="rightitem" key="rightname" /></td>
			<td nowrap><bean:message bundle="rightitem" key="region" /></td>
			<td nowrap><bean:message bundle="rightitem" key="rightgroup" /></td>
			<td nowrap><bean:message bundle="rightitem" key="operid" /></td>
			<td nowrap><bean:message bundle="rightitem" key="orgid" /></td>
			<td nowrap><bean:message bundle="rightitem" key="notes" /></td>
			<td nowrap><bean:message bundle="rightitem" key="ispublic" /></td>
			<td nowrap><bean:message bundle="rightitem" key="createdate" /></td>
			<td nowrap><bean:message bundle="rightitem" key="status" /></td>
			<td nowrap><bean:message bundle="rightitem" key="statusdate" /></td>
		</tr>
		<c:forEach var="item" items="${requestScope.LIST.datas}">
			<c:url value="/rightitem.do?CMD=EDIT" var="urlContent">
				<%
				//this param name must "PK"
				%>
				<%--  <c:param name="PK" value="${}"/>--%>
				<c:param name="PK" value="${item.rightid}" />
			</c:url>
			<tr class="table_style_content" align="center">
				<td nowrap><input type="checkbox" name="_selectitem"
					value="<c:out value='${item.rightid}' />" onclick="checkOne(this);"
					class="table_checkbox"></td>
				<td nowrap><a href='<c:out value="${urlContent}"/>'> <c:out
					value="${item.rightid}" /> </a></td>
				<td nowrap><a href='<c:out value="${urlContent}"/>'><c:out
					value="${item.rightname }" /></a></td>
				<td nowrap><c:out value="${item.region }" /></td>
				<td nowrap><c:out value="${item.rightgroup }" /></td>
				<td nowrap><c:out value="${item.operid }" /></td>
				<td nowrap><c:out value="${item.orgid }" /></td>				
				<td nowrap><c:out value="${item.notes }" /></td>
				<td nowrap><c:out value="${item.ispublic}" /></td>
				<td nowrap><c:out value="${item.createdate }" /></td>
				<td nowrap><c:out value="${item.status }" /></td>
				<td nowrap><c:out value="${item.statusdate }" /></td>
			</tr>
		</c:forEach>
	</table>
	</div>
	</div>
	<div class="table_div"><s:PageNav dpName="LIST" /></div>
</html:form></div>
</body>
</html>
