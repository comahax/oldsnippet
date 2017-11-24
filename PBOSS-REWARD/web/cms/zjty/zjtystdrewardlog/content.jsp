<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/contenthead.inc"%>
<%
    String ID_1 = "00010701";
    String ID_2 = "00010702";
    String ID_3 = "00010703";
    String ID_4 = "00010704";
%>
<html>
<head>
    <title><bean:message bundle="zjtystdrewardlog" key="titleUpdate"/></title>
    <script language="JavaScript">
        function ev_checkval() {

            return checkval(window);
        }
    </script>
</head>
<body>
<html:form action="/cms.zjty/zjtystdrewardlog.do?CMD=SAVE" styleId="formItem" method="post">
    <html:hidden property="id"/>
    <html:hidden property="cmdState"/>

    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <c:set var="edtState" scope="request" value="${!empty param.CMD and (param.CMD eq 'EDIT' or param.CMD eq 'NEW')}"/>

    <table class="error_text" width="100%">
        <html:errors/><s:Msg />
    </table>

	<div class="table_div">	
		<table class="top_table" border=0>
			<tr> 
				<td width="10" align="right" valign=top><img src="images/Ico_CircleBlue2.gif" width="20" height="20">&nbsp;</td>
				<td width="210" class="AreaName" align="left" valign=middle><bean:message bundle="zjtystdrewardlog" key="content"/></td>
				<td>
				<table width="100%" border="0" cellspacing="0" cellpadding="0" ID="Table3">
					<tr>
						<td align=right>

						</td>
                    </tr>
				</table></td>
			</tr>
		</table>
	</div>
    <div class="table_div">
        <table class="form_table">
        </table>
    </div>

    <div class="table_div">
        <table class="table_button_list">
            <tr>
                <td width="100%" class="form_table_center">
                    <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
                           name="btnSave" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<bean:message bundle="public" key="button_save"/>" class="submit"
                           onclick="doSave('/cms.zjty/zjtystdrewardlog.do?CMD=SAVE')"/>
                    <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
                           name="btnPrint" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<bean:message bundle="public" key="button_print"/>" class="print" onclick="doPrint()">
                    <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
                           name="btnReturn" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<bean:message bundle="public" key="button_return"/>" class="close"
                           onclick="doReturn('/cms.zjty/zjtystdrewardlog.do?CMD=LIST')">
                </td>
            </tr>
        </table>
    </div>
</html:form>
</body>
</html>
