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
    <title><bean:message bundle="custsassign" key="titleList"/></title>
    <script language="JavaScript">
        function ev_checkval() {
            addfield('recoprcode', '<bean:message bundle="custsassign" key="recoprcode"/>', 'c', false, '18');

            return checkval(window);
        }
    </script>
</head>
<body>
<html:form action="/cms/custsassign.do?CMD=REC" styleId="formItem" method="post">
    <html:hidden property="cmdState"/>
    <c:set var="edtState" scope="request" value="${!empty param.CMD and param.CMD eq 'REC'}"/>
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
				<td colspan=6>
					<bean:message bundle="fee" key="redStarExplain" />
				</td>
			</tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="custsassign" key="recoprcode"/>:</div></td>
                <td width="75%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                        	<html:text styleClass="form_input_1x" property="recoprcode" disabled="true"/>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="recoprcode" maxlength="24"/>
                        </c:otherwise>
                    </c:choose>
                    <font color=red>*</font>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="custsassign" key="memo"/>:</div></td>
                <td width="75%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                        	<html:textarea cols="70" rows="4" property="memo" style="overflow:auto" disabled="true"/>

                        </c:when>
                        <c:otherwise>
                            <html:textarea cols="70" rows="4" property="memo" style="overflow:auto" />
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
        </table>
    </div>

    <div class="table_div">
        <table class="table_button_list">
            <tr>
                <td width="100%" class="form_table_center">
                    <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
                           name="btnSave" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<bean:message bundle="custsassign" key="rec_bt"/>" class="submit"
                           onclick="doSave('/cms/custsassign.do?CMD=REC')"/>
                    
                    <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
                           name="btnReturn" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<bean:message bundle="public" key="button_return"/>" class="close"
                           onclick="doReturn('/cms/custsassign.do?CMD=LIST')">
                </td>
            </tr>
        </table>
    </div>
</html:form>
</body>
</html>
