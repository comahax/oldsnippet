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
    <title><bean:message bundle="wayacctlog" key="titleUpdate"/></title>
    <script language="JavaScript">
        function ev_checkval() {
            addfield('logid', '<bean:message bundle="wayacctlog" key="logid"/>', 'i', true, '14');
            addfield('optime', '<bean:message bundle="wayacctlog" key="optime"/>', 't', true, '25');
            addfield('oprcode', '<bean:message bundle="wayacctlog" key="oprcode"/>', 'c', true, '10');
            addfield('oprtype', '<bean:message bundle="wayacctlog" key="oprtype"/>', 'c', true, '8');
            addfield('success', '<bean:message bundle="wayacctlog" key="success"/>', 'c', false, '8');
            addfield('accid', '<bean:message bundle="wayacctlog" key="accid"/>', 'i', false, '6');
            addfield('wayid', '<bean:message bundle="wayacctlog" key="wayid"/>', 'c', false, '18');
            addfield('chargetype', '<bean:message bundle="wayacctlog" key="chargetype"/>', 'i', false, '3');
            addfield('accttype', '<bean:message bundle="wayacctlog" key="accttype"/>', 'i', false, '3');
            addfield('acctno', '<bean:message bundle="wayacctlog" key="acctno"/>', 'c', false, '50');
            addfield('acctname', '<bean:message bundle="wayacctlog" key="acctname"/>', 'c', false, '128');
            addfield('bankname', '<bean:message bundle="wayacctlog" key="bankname"/>', 'c', false, '128');
            addfield('dsbank', '<bean:message bundle="wayacctlog" key="dsbank"/>', 'c', false, '128');
            addfield('bankaddr', '<bean:message bundle="wayacctlog" key="bankaddr"/>', 'c', false, '255');
            addfield('contact', '<bean:message bundle="wayacctlog" key="contact"/>', 'c', false, '128');
            addfield('contel', '<bean:message bundle="wayacctlog" key="contel"/>', 'c', false, '30');
            addfield('rectime', '<bean:message bundle="wayacctlog" key="rectime"/>', 't', false, '25');
            addfield('starttime', '<bean:message bundle="wayacctlog" key="starttime"/>', 't', false, '25');
            addfield('endtime', '<bean:message bundle="wayacctlog" key="endtime"/>', 't', false, '25');
            addfield('memo', '<bean:message bundle="wayacctlog" key="memo"/>', 'c', false, '255');
            addfield('bossarea', '<bean:message bundle="wayacctlog" key="bossarea"/>', 'c', false, '14');

            return checkval(window);
        }
    </script>
</head>
<body>
<div class="table_container">
<html:form action="/cms/wayacctlog.do?CMD=SAVE" styleId="formItem" method="post">
    <html:hidden property="cmdState"/>

    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <html:hidden property="_dnl_optime"/>
    <html:hidden property="_dnm_optime"/>
    <html:hidden property="_sk_oprcode"/>
    <html:hidden property="_se_oprtype"/>
    <html:hidden property="_se_success"/>
    <c:set var="edtState" scope="request" value="${!empty param.CMD and (param.CMD eq 'EDIT' or param.CMD eq 'NEW')}"/>
    <c:set var="updateState" scope="request" value="${!empty param.CMD and (param.CMD eq 'EDIT')}"/>

    <!--##################################添加标题内容##################################################-->
    <div class="table_div">
    <table class="top_table">
    	<tr>
    		<td>
    			<bean:message bundle="wayacctlog" key="titleList"/>
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
                 <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="wayacctlog" key="logid"/>:</div></td>
                <td width="75%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                        <c:if test="${updateState}">
                            <html:text styleClass="form_input_1x" property="logid" maxlength="14" readonly="true"/>
                        </c:if>
                        <c:if test="${!updateState}">
                            <html:text styleClass="form_input_1x" property="logid" maxlength="14"/>
                        </c:if>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="logid" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                 <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="wayacctlog" key="optime"/>:</div></td>
                <td width="75%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="optime" maxlength="25"/>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="optime" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                 <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="wayacctlog" key="oprcode"/>:</div></td>
                <td width="75%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="oprcode" maxlength="10"/>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="oprcode" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                 <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="wayacctlog" key="oprtype"/>:</div></td>
                <td width="75%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="oprtype" maxlength="8"/>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="oprtype" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                 <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="wayacctlog" key="success"/>:</div></td>
                <td width="75%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="success" maxlength="8"/>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="success" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                 <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="wayacctlog" key="accid"/>:</div></td>
                <td width="75%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="accid" maxlength="6"/>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="accid" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                 <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="wayacctlog" key="wayid"/>:</div></td>
                <td width="75%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="wayid" maxlength="18"/>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="wayid" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                 <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="wayacctlog" key="chargetype"/>:</div></td>
                <td width="75%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="chargetype" maxlength="3"/>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="chargetype" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                 <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="wayacctlog" key="accttype"/>:</div></td>
                <td width="75%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="accttype" maxlength="3"/>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="accttype" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                 <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="wayacctlog" key="acctno"/>:</div></td>
                <td width="75%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="acctno" maxlength="50"/>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="acctno" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                 <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="wayacctlog" key="acctname"/>:</div></td>
                <td width="75%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="acctname" maxlength="128"/>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="acctname" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                 <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="wayacctlog" key="bankname"/>:</div></td>
                <td width="75%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="bankname" maxlength="128"/>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="bankname" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                 <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="wayacctlog" key="dsbank"/>:</div></td>
                <td width="75%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="dsbank" maxlength="128"/>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="dsbank" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                 <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="wayacctlog" key="bankaddr"/>:</div></td>
                <td width="75%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="bankaddr" maxlength="255"/>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="bankaddr" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                 <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="wayacctlog" key="contact"/>:</div></td>
                <td width="75%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="contact" maxlength="128"/>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="contact" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                 <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="wayacctlog" key="contel"/>:</div></td>
                <td width="75%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="contel" maxlength="30"/>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="contel" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                 <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="wayacctlog" key="rectime"/>:</div></td>
                <td width="75%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="rectime" maxlength="25"/>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="rectime" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                 <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="wayacctlog" key="starttime"/>:</div></td>
                <td width="75%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="starttime" maxlength="25"/>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="starttime" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                 <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="wayacctlog" key="endtime"/>:</div></td>
                <td width="75%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="endtime" maxlength="25"/>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="endtime" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                 <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="wayacctlog" key="memo"/>:</div></td>
                <td width="75%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="memo" maxlength="255"/>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="memo" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                 <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="wayacctlog" key="bossarea"/>:</div></td>
                <td width="75%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="bossarea" maxlength="14"/>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="bossarea" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
        </table>
    </div>

    <div class="table_div">
        <table class="table_button_list">
            <tr>
                <td>
            	  <s:PurChk controlid="<%=ID_1%>">
                    <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
                           name="btnSave" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<bean:message bundle="public" key="button_save"/>" class="submit"
                           onclick="doSave('/cms/wayacctlog.do?CMD=SAVE')"/>
                  </s:PurChk>
                 <s:PurChk controlid="<%=ID_2%>">
                    <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
                           name="btnPrint" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<bean:message bundle="public" key="button_print"/>" class="print" onclick="doPrint()">
                 </s:PurChk>
                    <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
                           name="btnReturn" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<bean:message bundle="public" key="button_return"/>" class="close"
                           onclick="doReturn('/cms/wayacctlog.do?CMD=LIST')">
                </td>
            </tr>
        </table>
    </div>
</html:form>
</div>
</body>
</html>
