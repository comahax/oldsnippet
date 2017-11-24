<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc"%>

<html>
<head>
    <title><bean:message bundle="custsassignlog" key="titleList"/></title>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            addfield('_dnm_optime', '<bean:message bundle="custsassignlog" key="optime"/>', 'dt', 'false', '7');
            addfield('_dnl_optime', '<bean:message bundle="custsassignlog" key="optime"/>', 'dt', 'false', '7');
            addfield('_se_oprcode', '<bean:message bundle="custsassignlog" key="oprcode"/>', 'c', 'false', '16');
            addfield('_se_oprtype', '<bean:message bundle="custsassignlog" key="oprtype"/>', 'c', 'false', '8');
            addfield('_se_operid', '<bean:message bundle="custsassignlog" key="operid"/>', 'c', 'false', '18');
            addfield('_ne_custid', '<bean:message bundle="custsassignlog" key="custid"/>', 'f', 'false', '14');
            addfield('_se_custname', '<bean:message bundle="custsassignlog" key="custname"/>', 'c', 'false', '128');
            addfield('_ne_custtype', '<bean:message bundle="custsassignlog" key="custtype"/>', 'f', 'false', '3');
            return checkval(window);
        }
    </script>
</head>

<body onload="if(window.loadforiframe) loadforiframe();">
<html:form action="/cms/custsassignlog.do?CMD=LIST" styleId="formList" method="post" onsubmit="return ev_check();">
    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <input type="hidden" name="_rowcount" value="<c:out value='${requestScope.LIST.rowCount}' />">

   <div class="table_div">
		<table class="top_table">
			<tr>
				<td width="210" class="AreaName" align="left" valign=middle>
					<bean:message bundle="custsassignlog" key="titleList" />
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
                <td width="126" height="20" align="right" class="form_table_right"><bean:message bundle="custsassignlog" key="_dnl_optime"/>:</td>
                <td class="form_table_left">
                	<html:text styleClass="form_input_1x" property="_dnl_optime" onclick="this.value=selectDatetime()"/>
                </td>
                <td width="126" height="20" align="right" class="form_table_right"><bean:message bundle="custsassignlog" key="_dnm_optime"/>:</td>
                <td class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_dnm_optime" onclick="this.value=selectDatetime()"/>
                </td>
                <td width="126" height="20" align="right" class="form_table_right"><bean:message bundle="custsassignlog" key="oprcode"/>:</td>
                <td class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_se_oprcode"></html:text>
                </td>
               </tr>
               <tr>
                <td width="126" height="20" align="right" class="form_table_right"><bean:message bundle="custsassignlog" key="oprtype"/>:</td>
                <td class="form_table_left">
                    <html:select property="_se_oprtype">
						<option value=""></option>
						<s:Options definition="$CH_CUSTASSOPRTYPE"></s:Options>
					</html:select>
                </td>
                <td width="126" height="20" align="right" class="form_table_right"><bean:message bundle="custsassignlog" key="operid"/>:</td>
                <td class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_se_operid"></html:text>
                </td>
                <td width="126" height="20" align="right" class="form_table_right"><bean:message bundle="custsassignlog" key="custid"/>:</td>
                <td class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_ne_custid"></html:text>
                </td>
               </tr>
               <tr>
                <td width="126" height="20" align="right" class="form_table_right"><bean:message bundle="custsassignlog" key="custname"/>:</td>
                <td class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_se_custname"></html:text>
                </td>
                <td width="126" height="20" align="right" class="form_table_right"><bean:message bundle="custsassignlog" key="custtype"/>:</td>
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
					<input type="button" class="query" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
						onfocus="buttonover(this)" onblur="buttonout(this)"
						value="<bean:message bundle="public" key="button_search"/>" onClick="doQuery();" />
				</td>
			</tr>
		</table>
	</div>
    <div class="table_div">
    <div class="table_LongTable">
        <table class="table_style" ID="Table2">
            <tr class="table_style_head">
                <td>
                    <a href="javascript:doOrderby('logid')"><bean:message bundle="custsassignlog" key="logid"/></a>
                    <s:OrderImg form="/cms/custsassignlog/custsassignlogForm" field="logid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('optime')"><bean:message bundle="custsassignlog" key="optime"/></a>
                    <s:OrderImg form="/cms/custsassignlog/custsassignlogForm" field="optime"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('oprcode')"><bean:message bundle="custsassignlog" key="oprcode"/></a>
                    <s:OrderImg form="/cms/custsassignlog/custsassignlogForm" field="oprcode"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('oprtype')"><bean:message bundle="custsassignlog" key="oprtype"/></a>
                    <s:OrderImg form="/cms/custsassignlog/custsassignlogForm" field="oprtype"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('success')"><bean:message bundle="custsassignlog" key="success"/></a>
                    <s:OrderImg form="/cms/custsassignlog/custsassignlogForm" field="success"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('operid')"><bean:message bundle="custsassignlog" key="operid"/></a>
                    <s:OrderImg form="/cms/custsassignlog/custsassignlogForm" field="operid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('custid')"><bean:message bundle="custsassignlog" key="custid"/></a>
                    <s:OrderImg form="/cms/custsassignlog/custsassignlogForm" field="custid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('custname')"><bean:message bundle="custsassignlog" key="custname"/></a>
                    <s:OrderImg form="/cms/custsassignlog/custsassignlogForm" field="custname"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('custtype')"><bean:message bundle="custsassignlog" key="custtype"/></a>
                    <s:OrderImg form="/cms/custsassignlog/custsassignlogForm" field="custtype"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('memo')"><bean:message bundle="custsassignlog" key="memo"/></a>
                    <s:OrderImg form="/cms/custsassignlog/custsassignlogForm" field="memo"/>
                </td>
            </tr>
            <c:forEach var="item" items="${requestScope.LIST.datas}">
                 <tr class="table_style_content" align="center">
                     <td><c:out value="${item.logid}"/></td>
                     <td><c:out value="${item.optime}"/></td>
                     <td><c:out value="${item.oprcode}"/></td>
                     <td><s:Code2Name code="${item.oprtype}" definition="$CH_CUSTASSOPRTYPE" /></td>
                     <td><s:Code2Name code="${item.success}" definition="$OPRRESULT" /></td>
                     <td><c:out value="${item.operid}"/></td>
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
