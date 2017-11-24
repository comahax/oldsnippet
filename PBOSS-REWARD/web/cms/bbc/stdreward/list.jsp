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
    <title><bean:message bundle="bbcstdreward" key="titleList"/></title>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            return checkval(window);
        }
    </script>
</head>

<body>
<html:form action="/cms/bbc/stdreward.do?CMD=LIST" styleId="formList" method="post" onsubmit="return ev_check();">
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
				<td width="210" class="AreaName" align="left" valign=middle><bean:message bundle="bbcstdreward" key="list"/></td>
				<td>
				<table width="100%" border="0" cellspacing="0" cellpadding="0" ID="Table3">
					<tr>
                    <td align=right>
                        <s:PurChk controlid="<%=ID_1%>">
                                               <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
                           name="btnSave" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<bean:message bundle="public" key="button_save"/>" class="submit"
                           onclick="doSave('/cms/bbc/stdreward.do?CMD=SAVE')"/>
                        </s:PurChk>
                        <s:PurChk controlid="<%=ID_2%>">
                            <input type="button" name="btnDelete" class="delete" onmouseover="buttonover(this);"
                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                            value="<bean:message bundle="public" key="button_delete"/>" onClick="doDelete('/cms/bbc/bbcstdreward.do')">
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
		<s:PageNav dpName="LIST"/>
   </div>
</html:form>
</body>
</html>
