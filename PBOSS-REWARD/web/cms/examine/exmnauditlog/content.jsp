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
    <title><bean:message bundle="exmnauditlog" key="titleUpdate"/></title>
    <script language="JavaScript">
        function ev_checkval() {
            addfield('logid', '<bean:message bundle="exmnauditlog" key="logid"/>', 'f', false, '14');
            addfield('操作日志', '<bean:message bundle="exmnauditlog" key="操作日志"/>', 't', false, '7');
            addfield('oprcode', '<bean:message bundle="exmnauditlog" key="oprcode"/>', 'c', false, '16');
            addfield('oprtype', '<bean:message bundle="exmnauditlog" key="oprtype"/>', 'c', false, '8');
            addfield('success', '<bean:message bundle="exmnauditlog" key="success"/>', 'c', false, '8');
            addfield('seqid', '<bean:message bundle="exmnauditlog" key="seqid"/>', 'f', false, '14');
            addfield('presenter', '<bean:message bundle="exmnauditlog" key="presenter"/>', 'c', false, '16');
            addfield('submissiontime', '<bean:message bundle="exmnauditlog" key="submissiontime"/>', 't', false, '7');
            addfield('auditor', '<bean:message bundle="exmnauditlog" key="auditor"/>', 'c', false, '16');
            addfield('auditopinion', '<bean:message bundle="exmnauditlog" key="auditopinion"/>', 'c', false, '512');
            addfield('itemgradedid', '<bean:message bundle="exmnauditlog" key="itemgradedid"/>', 'f', false, '14');
            addfield('state', '<bean:message bundle="exmnauditlog" key="state"/>', 'c', false, '32');

            return checkval(window);
        }
    </script>
</head>
<body>
<div class="table_container">
<html:form action="/cms/examine/exmnauditlog.do?CMD=SAVE" styleId="formItem" method="post">
    <html:hidden property="cmdState"/>

    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <c:set var="edtState" scope="request" value="${!empty param.CMD and (param.CMD eq 'EDIT' or param.CMD eq 'NEW')}"/>
    <c:set var="updateState" scope="request" value="${!empty param.CMD and (param.CMD eq 'EDIT')}"/>
    <c:set var="form" scope="request" value="${requestScope['/cms/examine/exmnauditlog/ExmnauditlogForm']}"/>

    <!--##################################添加标题内容##################################################-->
    <div class="table_div">
    <table class="top_table">
    	<tr>
    		<td>
    			<bean:message bundle="exmnauditlog" key="titleList"/>
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
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="exmnauditlog" key="logid"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                        <c:if test="${updateState}">
                            <html:text styleClass="form_input_1x" property="logid" readonly="true"/>
                        </c:if>
                        <c:if test="${!updateState}">
                            <html:text styleClass="form_input_1x" property="logid" />
                        </c:if>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="logid" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="exmnauditlog" key="操作日志"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="操作日志" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="操作日志" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="exmnauditlog" key="oprcode"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="oprcode" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="oprcode" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="exmnauditlog" key="oprtype"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="oprtype" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="oprtype" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="exmnauditlog" key="success"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="success" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="success" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="exmnauditlog" key="seqid"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="seqid" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="seqid" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="exmnauditlog" key="presenter"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="presenter" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="presenter" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="exmnauditlog" key="submissiontime"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="submissiontime" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="submissiontime" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="exmnauditlog" key="auditor"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="auditor" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="auditor" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="exmnauditlog" key="auditopinion"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="auditopinion" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="auditopinion" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="exmnauditlog" key="itemgradedid"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="itemgradedid" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="itemgradedid" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="exmnauditlog" key="state"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="state" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="state" disabled="true"/>
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
                           onclick="doSave('/cms/examine/exmnauditlog.do?CMD=SAVE')"/>
                    <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
                           name="btnPrint" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<bean:message bundle="public" key="button_print"/>" class="print" onclick="doPrint()">
                    <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
                           name="btnReturn" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<bean:message bundle="public" key="button_return"/>" class="close"
                           onclick="doReturn('/cms/examine/exmnauditlog.do?CMD=LIST')">
                </td>
            </tr>
        </table>
    </div>
</html:form>
</div>
</body>
</html>
