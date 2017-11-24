<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc"%>
<html>
<head>
    <title><bean:message bundle="custsassign" key="titleList"/></title>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
        	addfield('_ne_custid', '<bean:message bundle="custsassign" key="custid"/>', 'f', true, '14');
            return checkval(window);
        }
    </script>
</head>

<body onload="if(window.loadforiframe) loadforiframe();">
<html:form action="/cms/custsassign.do?CMD=LIST" styleId="formList" method="post" onsubmit="return ev_check();">
    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <input type="hidden" name="_rowcount" value="<c:out value='${requestScope.LIST.rowCount}' />">

    <div class="table_div">
		<table class="top_table">
			<tr>
				<td width="210" class="AreaName" align="left" valign=middle>
					<bean:message bundle="custsassign" key="titleList" />
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
                <td width="126" height="20" align="right" class="form_table_right"><bean:message bundle="custsassign" key="operid"/>:</td>
                <td class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_se_operid"></html:text>
                </td>
                <td width="126" height="20" align="right" class="form_table_right"><bean:message bundle="custsassign" key="custid"/>:</td>
                <td class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_ne_custid"></html:text>
                </td>
            </tr>
            <tr>
                <td width="126" height="20" align="right" class="form_table_right"><bean:message bundle="custsassign" key="custname"/>:</td>
                <td class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_sk_custname"></html:text>
                </td>
                <td width="126" height="20" align="right" class="form_table_right"><bean:message bundle="custsassign" key="custtype"/>:</td>
                <td class="form_table_left">
                    <html:select property="_ne_custtype">
						<option value=""></option>
						<s:Options definition="$CH_DOMCUSTTYPE"></s:Options>
					</html:select>
                </td>
            </tr>
        </table>
    </div>
    <div class="table_div">
		<table class="table_button_list">
			<tr>
				<td>
					<input type="button" name="btnNew"  class="add" onmouseover="buttonover(this);"
                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                            value="<bean:message bundle="public" key="button_new"/>" onClick="doNew('/cms/custsassign.do')">
                   <input type="button" name="btnDelete" class="delete" onmouseover="buttonover(this);"
                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                            value="<bean:message bundle="public" key="button_delete"/>" onClick="doDelete('/cms/custsassign.do')">
                   <input type="button" class="query"onmouseover="buttonover(this);"
                                onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                                value="<bean:message bundle="public" key="button_search"/>" onClick="doQuery();"/>
                   <input type="button" class="query"onmouseover="buttonover(this);"
                                onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                                value="<bean:message bundle="custsassign" key="tans_bt"/>" onClick="window.location=contextPath + '/cms/custsassign/trans.jsp'"/>
                   <input type="button" class="query"onmouseover="buttonover(this);"
                                onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                                value="<bean:message bundle="custsassign" key="rec_bt"/>" onClick="window.location=contextPath + '/cms/custsassign/rec.jsp'"/>
				</td>
			</tr>
		</table>
	</div>
    <div class="table_div">
    <div class="table_LongTable">
        <table class="table_style" ID="Table2">
            <tr class="table_style_head">
                <td title="<bean:message bundle="public" key="list_title_select"/>">
                    <input type="checkbox" name="allbox" onclick="checkAll();" class="table_checkbox">
                </td>
                <td>
                    <a href="javascript:doOrderby('operid')"><bean:message bundle="custsassign" key="operid"/></a>
                    <s:OrderImg form="/cms/custsassign/custsassignForm" field="operid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('custid')"><bean:message bundle="custsassign" key="custid"/></a>
                    <s:OrderImg form="/cms/custsassign/custsassignForm" field="custid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('custname')"><bean:message bundle="custsassign" key="custname"/></a>
                    <s:OrderImg form="/cms/custsassign/custsassignForm" field="custname"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('custtype')"><bean:message bundle="custsassign" key="custtype"/></a>
                    <s:OrderImg form="/cms/custsassign/custsassignForm" field="custtype"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('memo')"><bean:message bundle="custsassign" key="memo"/></a>
                    <s:OrderImg form="/cms/custsassign/custsassignForm" field="memo"/>
                </td>
            </tr>
            <c:forEach var="item" items="${requestScope.LIST.datas}">
                 <c:url value="/cms/custsassign.do?CMD=EDIT" var="urlContent">
                     <%//this param name must "PK" %>
                     <c:param name="PK" value="${item.custid}|${item.operid}"/>
                     <%-- <c:param name="PK" value="'${item.id}|${item.id2}'"/> --%>
                 </c:url>
                 <tr class="table_style_content" align="center">
                     <td>
                         <input type="checkbox" name="_selectitem" value="<c:out value='${item.custid}|${item.operid}' />"
                                onclick="checkOne(this);" class="table_checkbox">
                     </td>
                     <td>
                         <a href='<c:out value="${urlContent}"/>'><c:out value="${item.operid}"/></a>
                     </td>
                     <td><c:out value="${item.custid}"/></td>
                     <td><c:out value="${item.custname}"/></td>
                     <td><s:Code2Name code="${item.custtype}" definition="$CH_DOMCUSTTYPE" /></td>
                     <td><c:out value="${item.memo}"/></td>
                 </tr>
             </c:forEach>
        </table>
   </div>
   </div>
   <div class="table_div">
		<s:PageNav dpName="LIST"/>
   </div>
</html:form>
</body>
</html>
