<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc"%>
<%
    String ID_1 = "00010701";
    String ID_2 = "00010702";
    String ID_3 = "00010703";
    String ID_4 = "00010704";
%>
<html>
<head>
    <title><bean:message bundle="busiwayrellog" key="titleList"/></title>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            return checkval(window);
        }
    </script>
</head>

<body onload="document.formList._sk_companyname.focus()">
<html:form action="/cms.reward/busiwayrellog.do?CMD=LIST" styleId="formList" method="post" onsubmit="return ev_check();">
    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <input type="hidden" name="_rowcount" value="<c:out value='${requestScope.LIST.rowCount}' />">

    <table class="error_text" width="100%">
        <html:errors/><s:Msg />
    </table>

	<div class="table_div">
		<table class="top_table">
			<tr> 
				<td width="10" align="right" valign=top><img src="images/Ico_CircleBlue2.gif" width="20" height="20">&nbsp;</td>
				<td width="210" class="AreaName" align="left" valign=middle><bean:message bundle="busiwayrellog" key="list"/></td>
				<td>
				<table width="100%" border="0" cellspacing="0" cellpadding="0" ID="Table3">
					<tr>
                    <td align=right>
                        <s:PurChk controlid="<%=ID_1%>">
                            <input type="button" name="btnNew"  class="add" onmouseover="buttonover(this);"
                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                            value="<bean:message bundle="public" key="button_new"/>" onClick="doNew('/cms.reward/busiwayrellog.do')">
                        </s:PurChk>
                        <s:PurChk controlid="<%=ID_2%>">
                            <input type="button" name="btnDelete" class="delete" onmouseover="buttonover(this);"
                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                            value="<bean:message bundle="public" key="button_delete"/>" onClick="doDelete('/cms.reward/busiwayrellog.do')">
                        </s:PurChk>
                        <input type="button" class="query"onmouseover="buttonover(this);"
                                onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                                value="<bean:message bundle="public" key="button_search"/>" onClick="doQuery();"/>
                    </td>
                    </tr>
				</table></td>
			</tr>
		</table>
	</div>

	<div class="table_div">
        <table class="form_table">
            <tr>
            </tr>
        </table>
    </div>
    <div class="table_div">
        <table class="table_style" ID="Table2">
            <tr class="table_style_head">
                <td title="<bean:message bundle="public" key="list_title_select"/>">
                    <input type="checkbox" name="allbox" onclick="checkAll();" class="table_checkbox">
                </td>
                <td><bean:message bundle="public" key="column_operate"/></td>
            </tr>
            <c:forEach var="item" items="${requestScope.LIST.datas}">
                 <c:url value="/cms.reward/busiwayrellog.do?CMD=EDIT" var="urlContent">
                     <%//this param name must "PK" %>
                     <c:param name="PK" value="${}"/>
                     <%-- <c:param name="PK" value="'${item.id}|${item.id2}'"/> --%>
                 </c:url>
                 <tr class="table_style_content" align="center">
                     <td>
                         <input type="checkbox" name="_selectitem" value="<c:out value='${item.id}' />"
                                onclick="checkOne(this);" class="table_checkbox">
                     </td>
                     <td>
                         <a href='<c:out value="${urlContent}"/>'><c:out value="${item.Ãû³Æ}"/></a>
                     </td>
                     <td>
                         <a href="#"><bean:message bundle="public" key="button_print"/>|<bean:message bundle="public" key="button_enable"/></a>
                     </td>
                 </tr>
             </c:forEach>
        </table>
   </div>
   <div class="table_div">
		<s:PageNav dpName="LIST"/>
   </div>
</html:form>
</body>
</html>
