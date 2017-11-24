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
    <title><bean:message bundle="rewardslvlimit" key="titleUpdate"/></title>
    <script language="JavaScript">
        function ev_checkval() {
            addfield('rewardid', '<bean:message bundle="rewardslvlimit" key="rewardid"/>', 'f', false, '14');
            addfield('region', '<bean:message bundle="rewardslvlimit" key="region"/>', 'c', false, '10');
            addfield('opnid', '<bean:message bundle="rewardslvlimit" key="opnid"/>', 'c', false, '18');
            addfield('slv', '<bean:message bundle="rewardslvlimit" key="slv"/>', 'f', false, '3');
            addfield('rewardlimit', '<bean:message bundle="rewardslvlimit" key="rewardlimit"/>', 'f', false, '10');

            return checkval(window);
        }
    </script>
</head>
<body>
<div class="table_container">
<html:form action="/cms/reward/rewardslvlimit.do?CMD=SAVE" styleId="formItem" method="post">
    <html:hidden property="cmdState"/>

    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <html:hidden property="_ne_rewardid"/>
    <html:hidden property="_se_region"/>
    <html:hidden property="_se_opnid"/>
    <html:hidden property="_ne_slv"/>
    <c:set var="edtState" scope="request" value="${!empty param.CMD and (param.CMD eq 'EDIT' or param.CMD eq 'NEW')}"/>
    <c:set var="updateState" scope="request" value="${!empty param.CMD and (param.CMD eq 'EDIT')}"/>
    <c:set var="form" scope="request" value="${requestScope['/cms/reward/rewardslvlimit/RewardslvlimitForm']}"/>

    <!--##################################添加标题内容##################################################-->
    <div class="table_div">
    <table class="top_table">
    	<tr>
    		<td>
    			<bean:message bundle="rewardslvlimit" key="titleList"/>
   			</td>
    	</tr>
    </table>
    </div>
    <div class="table_div">	
   		 <table width="100%" class="error_text">
    		<html:errors/><s:Msg />
    	</table>
    </div>

    <div class="table_div">
        <table class="form_table">
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="rewardslvlimit" key="rewardid"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                        <c:if test="${updateState}">
                            <html:text styleClass="form_input_1x" property="rewardid" readonly="true"/>
                        </c:if>
                        <c:if test="${!updateState}">
                            <html:text styleClass="form_input_1x" property="rewardid" />
                        </c:if>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="rewardid" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="rewardslvlimit" key="region"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                        <c:if test="${updateState}">
                            <html:text styleClass="form_input_1x" property="region" readonly="true"/>
                        </c:if>
                        <c:if test="${!updateState}">
                            <html:text styleClass="form_input_1x" property="region" />
                        </c:if>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="region" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="rewardslvlimit" key="opnid"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                        <c:if test="${updateState}">
                            <html:text styleClass="form_input_1x" property="opnid" readonly="true"/>
                        </c:if>
                        <c:if test="${!updateState}">
                            <html:text styleClass="form_input_1x" property="opnid" />
                        </c:if>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="opnid" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="rewardslvlimit" key="slv"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                        <c:if test="${updateState}">
                            <html:text styleClass="form_input_1x" property="slv" readonly="true"/>
                        </c:if>
                        <c:if test="${!updateState}">
                            <html:text styleClass="form_input_1x" property="slv" />
                        </c:if>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="slv" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="rewardslvlimit" key="rewardlimit"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="rewardlimit" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="rewardlimit" disabled="true"/>
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
                           onclick="doSave('/cms/reward/rewardslvlimit.do?CMD=SAVE')"/>
                    <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
                           name="btnPrint" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<bean:message bundle="public" key="button_print"/>" class="print" onclick="doPrint()">
                    <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
                           name="btnReturn" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<bean:message bundle="public" key="button_return"/>" class="close"
                           onclick="doReturn('/cms/reward/rewardslvlimit.do?CMD=LIST')">
                </td>
            </tr>
        </table>
    </div>
</html:form>
</div>
</body>
</html>
