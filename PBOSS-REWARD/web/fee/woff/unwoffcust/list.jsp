<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc" %>
<%
    String ID_1 = "00010701";
    String ID_2 = "00010702";
    String ID_3 = "00010703";
    String ID_4 = "00010704";
%>
<html>
<head>
    <title><bean:message bundle="eboxunit" key="titleList"/></title>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            addfield('_sk_eboxid', '<bean:message bundle="unwoffcust" key="eboxid"/>', 'l', true, 14);
            addfield('_sk_validbillcyc', '<bean:message bundle="unwoffcust" key="validbillcyc"/>', 'i', true, 8);
            addfield('_sk_state', '<bean:message bundle="unwoffcust" key="feestatus"/>', 'i', true, 3);
            return checkval(window);
        }
    </script>
</head>

<body onload="document.formList._sk_eboxid.focus();loadforiframe();">
<div class="table_container">
<html:form action="/fee/woff/unwoffcust.do?CMD=LIST" styleId="formList" method="post" onsubmit="return ev_check();">
    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <input type="hidden" name="_rowcount" value="<c:out value='${requestScope.LIST.rowCount}' />">
	
	<div class="table_div">	
		<table class="top_table">
			<tr> 
				<td><bean:message bundle="unwoffcust" key="custMsg"/></td>				 
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
                <td class="form_table_right"><bean:message bundle="unwoffcust" key="eboxid"/>:</td>
                <td class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_sk_eboxid" maxlength="14"></html:text>
                </td>
                <td class="form_table_right"><bean:message bundle="unwoffcust" key="validbillcyc"/>:</td>
                <td class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_sk_validbillcyc" maxlength="8"></html:text>
                </td>
                <td class="form_table_right"><bean:message bundle="unwoffcust" key="feestatus"/>:</td>
                <td class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_sk_state" maxlength="3"></html:text>
                </td>
            </tr>
        </table>
    </div>
    
    <div class="table_div">
		<table class="table_button_list">
			<tr>
			   <td>  
                 	<input type="button" class="query" onmouseover="buttonover(this);"
                      onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                       value="<bean:message bundle="public" key="button_search"/>" onclick="doQuery()"/>
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
                    <a href="javascript:doOrderby('eboxid')"><bean:message bundle="unwoffcust" key="eboxid"/></a>
                    <s:OrderImg form="/fee/woff/unwoffcust/UnWoffCustForm" field="eboxid"/>
                </td>
                <td><bean:message bundle="unwoffcust" key="subsid"/></td>
                <td><bean:message bundle="unwoffcust" key="acctid"/></td>
                <td><bean:message bundle="unwoffcust" key="validbillcyc"/></td>
                <td>
                    <a href="javascript:doOrderby('recamt')"><bean:message bundle="unwoffcust" key="recamt"/></a>
                    <s:OrderImg form="/fee/woff/unwoffcust/UnWoffCustForm" field="recamt"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('paiclupamt')"><bean:message bundle="unwoffcust" key="paiclupamt"/></a>
                    <s:OrderImg form="/fee/woff/unwoffcust/UnWoffCustForm" field="paiclupamt"/>
                </td>
                <td><bean:message bundle="unwoffcust" key="feestatus"/></td>
            </tr>
            <c:forEach var="item" items="${requestScope.LIST.datas}">
                 <c:url value="/fee/woff/unwoffcust.do?CMD=LIST" var="urlContent">
                    <c:param name="PK" value="${item.eboxid}|${item.subsid}|${item.acctid}|${item.validbillcyc}"/>
                 </c:url>
                 <tr class="table_style_content" align="center">
                     <td>
                         <input type="checkbox" name="_selectitem" value="<c:out value='${item.eboxid}|${item.subsid}|${item.acctid}|${item.validbillcyc}' />"
                                onclick="checkOne();" class="table_checkbox">
                     </td>
                     <td>
                         <a href='<c:out value="${urlContent}"/>'><c:out value="${item.eboxid}"/></a>
                     </td>
                     <td><c:out value="${item.subsid}"/></td>
                     <td><c:out value="${item.acctid}"/></td>
                     <td><c:out value="${item.validbillcyc}"/></td>
                     <td><c:out value="${item.recamt}"/></td>
                     <td><c:out value="${item.paiclupamt}"/></td>
                     <td><c:out value="${item.state}"/></td>
                </tr>
             </c:forEach>
        </table>
    </div>
    </div>
    
   <div class="table_div">
		<s:PageNav dpName="LIST"/>
   </div>
   
</html:form>
</div>
</body>
</html>
