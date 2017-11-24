<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/contenthead.inc"%>
<%
%>
<html>
<head>
    <title><bean:message bundle="custsassign" key="titleList"/></title>
    <script language="JavaScript">
        function ev_checkval() {
            addfield('operid', '<bean:message bundle="custsassign" key="operid"/>', 'c', false, '18');
            addfield('custid', '<bean:message bundle="custsassign" key="custid"/>', 'f', false, '14');
            addfield('custname', '<bean:message bundle="custsassign" key="custname"/>', 'c', false, '128');
            addfield('custtype', '<bean:message bundle="custsassign" key="custtype"/>', 'f', false, '3');

            return checkval(window);
        }
    </script>
</head>
<body>
<html:form action="/cms/custsassign.do?CMD=SAVE" styleId="formItem" method="post">
    <html:hidden property="cmdState"/>
    <c:set var="edtState" scope="request" value="${!empty param.CMD and (param.CMD eq 'EDIT' or param.CMD eq 'NEW')}"/>
    <c:set var="edtState2" scope="request" value="${!empty param.CMD and (param.CMD eq 'NEW')}"/>
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
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="custsassign" key="operid"/>:</div></td>
                <td width="75%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState and edtState2}">
                            <html:text styleClass="form_input_1x" property="operid" maxlength="24"/>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="operid" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                    <font color=red>*</font>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="custsassign" key="custid"/>:</div></td>
                <td width="75%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState  and edtState2}">
                            <html:text styleClass="form_input_1x" property="custid" maxlength="24"/>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="custid" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                    <font color=red>*</font>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="custsassign" key="custname"/>:</div></td>
                <td width="75%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="custname" maxlength="24"/>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="custname" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                    <font color=red>*</font>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="custsassign" key="custtype"/>:</div></td>
                <td width="75%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:select property="custtype">
								<option value=""></option>
								<s:Options definition="$CH_DOMCUSTTYPE"></s:Options>
							</html:select>
                        </c:when>
                        <c:otherwise>
                            <html:select property="custtype" disabled="true">
								<option value=""></option>
								<s:Options definition="$CH_DOMCUSTTYPE"></s:Options>
							</html:select>
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
                            <html:textarea cols="70" rows="4" property="memo" style="overflow:auto" />
                        </c:when>
                        <c:otherwise>
                            <html:textarea cols="70" rows="4" property="memo" style="overflow:auto" disabled="true"/>
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
                           value="<bean:message bundle="public" key="button_save"/>" class="submit"
                           onclick="doSave('/cms/custsassign.do?CMD=SAVE')"/>
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
