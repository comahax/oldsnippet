<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/contenthead.inc" %>
<html:html>
<head>
    <title><bean:message bundle="operator" key="titleUpdate"/></title>
    <script language="JavaScript">
        function ev_checkval() {
            addfield('operid', '<bean:message bundle="operator" key="operid"/>', 'c', false, 15);
            addfield('region', '<bean:message bundle="operator" key="region"/>', 'i', true, 5);
            addfield('opername', '<bean:message bundle="operator" key="opername"/>', 'c', false, 64);
            addfield('password', '<bean:message bundle="operator" key="password"/>', 'c', true, 30);
            addfield('passchgdate', '<bean:message bundle="operator" key="passchgdate"/>', 't', false);
            addfield('opergroup', '<bean:message bundle="operator" key="opergroup"/>', 'c', true, 16);
            addfield('opertype', '<bean:message bundle="operator" key="opertype"/>', 'c', false, 16);
            addfield('operlevel', '<bean:message bundle="operator" key="operlevel"/>', 'c', true, 16);
            addfield('ismanager', '<bean:message bundle="operator" key="ismanager"/>', 'i', false, 1);
            addfield('contactphone', '<bean:message bundle="operator" key="contactphone"/>', 'c', true, 20);
            addfield('orgid', '<bean:message bundle="operator" key="orgid"/>', 'c', false, 32);
            addfield('isrestrict', '<bean:message bundle="operator" key="isrestrict"/>', 'i', false, 1);
            addfield('starttime', '<bean:message bundle="operator" key="starttime"/>', 'i', false, 2);
            addfield('endtime', '<bean:message bundle="operator" key="endtime"/>', 'i', false, 2);
            addfield('enablegprs', '<bean:message bundle="operator" key="enablegprs"/>', 'c', false, 1);
            addfield('gprsstarttime', '<bean:message bundle="operator" key="gprsstarttime"/>', 'i', false, 2);
            addfield('gprsendtime', '<bean:message bundle="operator" key="gprsendtime"/>', 'i', false, 2);
            addfield('ischkmac', '<bean:message bundle="operator" key="ischkmac"/>', 'i', false, 1);
            addfield('mac', '<bean:message bundle="operator" key="mac"/>', 'c', true, 32);
            addfield('notes', '<bean:message bundle="operator" key="notes"/>', 'c', true, 256);
            addfield('createdate2', '<bean:message bundle="operator" key="createdate"/>', 'c', false, 20);
            addfield('status', '<bean:message bundle="operator" key="status"/>', 'i', false, 1);
            addfield('statusdate2', '<bean:message bundle="operator" key="statusdate"/>', 'c', false, 20);
            
            return checkval(window); 
        }
    </script>
</head>
<body  onload="loadforiframe();">
<div class="table_container">
<html:form action="/operator.do?CMD=SAVE" styleId="formItem" method="post">
    
    <html:hidden property="cmdState"/>
    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <c:set var="edtState" scope="request" value="${!empty param.CMD and (param.CMD eq 'EDIT' or param.CMD eq 'NEW')}"/>
 	<div class="table_div">
		<table class="top_table">
			<tr>
				<td>
					<bean:message bundle="operator" key="titleUpdate"/>
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
        	<tr class="table_style_content">
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="operator" key="operid"/>:</div></td>
                <td width="75%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${param.CMD eq 'NEW'}">
                            <html:text styleClass="form_input_1x" property="operid"  maxlength="24"/>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="operid" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr class="table_style_content">
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="operator" key="region"/>:</div></td>
                <td width="75%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="region" maxlength="24"/>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="region" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="operator" key="opername"/>:</div></td>
                <td width="75%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="opername" maxlength="24"/>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="opername" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr class="table_style_content">
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="operator" key="password"/>:</div></td>
                <td width="75%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="password" maxlength="24"/>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="password" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="operator" key="passchgdate"/>:</div></td>
                <td width="75%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="passchgdate" onclick="this.value=selectDate();" value="2008-12-31"/>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="passchgdate" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr class="table_style_content">
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="operator" key="opergroup"/>:</div></td>
                <td width="75%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="opergroup" maxlength="24"/>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="opergroup" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="operator" key="opertype"/>:</div></td>
                <td width="75%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="opertype" maxlength="24"/>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="opertype" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr class="table_style_content">
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="operator" key="operlevel"/>:</div></td>
                <td width="75%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="operlevel" maxlength="24"/>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="operlevel" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="operator" key="ismanager"/>:</div></td>
                <td width="75%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="ismanager" maxlength="24"/>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="ismanager" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr class="table_style_content">
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="operator" key="contactphone"/>:</div></td>
                <td width="75%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="contactphone" maxlength="24"/>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="contactphone" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="operator" key="orgid"/>:</div></td>
                <td width="75%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="orgid" maxlength="24"/>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="orgid" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr class="table_style_content">
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="operator" key="isrestrict"/>:</div></td>
                <td width="75%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="isrestrict" maxlength="24"/>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="isrestrict" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="operator" key="starttime"/>:</div></td>
                <td width="75%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="starttime" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="starttime" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr class="table_style_content">
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="operator" key="endtime"/>:</div></td>
                <td width="75%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="endtime"/>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="endtime" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="operator" key="enablegprs"/>:</div></td>
                <td width="75%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="enablegprs" maxlength="24"/>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="enablegprs" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr class="table_style_content">
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="operator" key="gprsstarttime"/>:</div></td>
                <td width="75%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="gprsstarttime" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="gprsstarttime" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="operator" key="gprsendtime"/>:</div></td>
                <td width="75%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="gprsendtime" maxlength="24" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="gprsendtime" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr class="table_style_content">
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="operator" key="ischkmac"/>:</div></td>
                <td width="75%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="ischkmac" maxlength="24"/>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="ischkmac" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="operator" key="mac"/>:</div></td>
                <td width="75%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="mac" maxlength="24"/>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="mac" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr class="table_style_content">
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="operator" key="notes"/>:</div></td>
                <td width="75%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="notes" maxlength="24"/>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="notes" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="operator" key="createdate" />:</div></td>
                <td width="75%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="createdate2" maxlength="24" onclick="this.value=selectDate();" value="2008-12-31"/>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="createdate2" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr class="table_style_content">
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="operator" key="status"/>:</div></td>
                <td width="75%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="status" maxlength="24"/>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="status" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="operator" key="statusdate"/>:</div></td>
                <td width="75%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="statusdate2" maxlength="24" onclick="this.value=selectDate();" value="2008-12-31"/>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="statusdate2" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            
        </table>
    </div>
    <div class="table_div">
        <table class="table_button_list">
            <tr>                
                <td width="100%" class="form_table_right">
                    <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
                           name="btnSave" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<bean:message bundle="public" key="button_save"/>" class="submit"
                           onclick="doSave('/operator.do?CMD=SAVE')"/>
                    <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
                           name="btnPrint" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<bean:message bundle="public" key="button_print"/>" class="print" onclick="doPrint()">
                    <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
                           name="btnReturn" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<bean:message bundle="public" key="button_return"/>" class="close"
                           onclick="doReturn('/operator.do?CMD=LIST')">
                </td>
            </tr>
        </table>
    </div>
</html:form>
</div>
</body>
</html:html>
