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
    <title><bean:message bundle="employeelog" key="titleUpdate"/></title>
    <script language="JavaScript">
        function ev_checkval() {
            addfield('logid', '<bean:message bundle="employeelog" key="logid"/>', 'i', true, '14');
            addfield('optime', '<bean:message bundle="employeelog" key="optime"/>', 't', true, '25');
            addfield('oprcode', '<bean:message bundle="employeelog" key="oprcode"/>', 'c', true, '10');
            addfield('oprtype', '<bean:message bundle="employeelog" key="oprtype"/>', 'c', true, '8');
            addfield('success', '<bean:message bundle="employeelog" key="success"/>', 'c', false, '8');
            addfield('employeeid', '<bean:message bundle="employeelog" key="employeeid"/>', 'c', true, '15');
            addfield('oprcode2', '<bean:message bundle="employeelog" key="oprcode2"/>', 'c', false, '15');
            addfield('employeename', '<bean:message bundle="employeelog" key="employeename"/>', 'c', false, '30');
            addfield('birthday', '<bean:message bundle="employeelog" key="birthday"/>', 't', false, '25');
            addfield('sex', '<bean:message bundle="employeelog" key="sex"/>', 'i', false, '3');
            addfield('edulevel', '<bean:message bundle="employeelog" key="edulevel"/>', 'i', false, '3');
            addfield('nativehome', '<bean:message bundle="employeelog" key="nativehome"/>', 'c', false, '20');
            addfield('polivisage', '<bean:message bundle="employeelog" key="polivisage"/>', 'i', false, '3');
            addfield('department', '<bean:message bundle="employeelog" key="department"/>', 'c', false, '18');
            addfield('servoffice', '<bean:message bundle="employeelog" key="servoffice"/>', 'c', false, '18');
            addfield('station', '<bean:message bundle="employeelog" key="station"/>', 'i', false, '3');
            addfield('joblevel', '<bean:message bundle="employeelog" key="joblevel"/>', 'i', false, '3');
            addfield('intime', '<bean:message bundle="employeelog" key="intime"/>', 't', false, '25');
            addfield('worktime', '<bean:message bundle="employeelog" key="worktime"/>', 'i', false, '3');
            addfield('hereworktime', '<bean:message bundle="employeelog" key="hereworktime"/>', 'i', false, '3');
            addfield('employtype', '<bean:message bundle="employeelog" key="employtype"/>', 'i', false, '3');
            addfield('company', '<bean:message bundle="employeelog" key="company"/>', 'c', false, '50');
            addfield('telephone', '<bean:message bundle="employeelog" key="telephone"/>', 'c', false, '15');
            addfield('officetel', '<bean:message bundle="employeelog" key="officetel"/>', 'c', false, '12');
            addfield('outtime', '<bean:message bundle="employeelog" key="outtime"/>', 't', false, '25');
            addfield('outresult', '<bean:message bundle="employeelog" key="outresult"/>', 'c', false, '255');
            addfield('homeaddr', '<bean:message bundle="employeelog" key="homeaddr"/>', 'c', false, '255');
            addfield('cardid', '<bean:message bundle="employeelog" key="cardid"/>', 'c', false, '18');
            addfield('wayid', '<bean:message bundle="employeelog" key="wayid"/>', 'c', true, '18');

            return checkval(window);
        }
    </script>
</head>
<body>
<div class="table_container">
<html:form action="/cms/employeelog.do?CMD=SAVE" styleId="formItem" method="post">
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
    			<bean:message bundle="employeelog" key="titleList"/>
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
                 <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="employeelog" key="logid"/>:</div></td>
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
                 <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="employeelog" key="optime"/>:</div></td>
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
                 <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="employeelog" key="oprcode"/>:</div></td>
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
                 <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="employeelog" key="oprtype"/>:</div></td>
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
                 <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="employeelog" key="success"/>:</div></td>
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
                 <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="employeelog" key="employeeid"/>:</div></td>
                <td width="75%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="employeeid" maxlength="15"/>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="employeeid" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                 <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="employeelog" key="oprcode2"/>:</div></td>
                <td width="75%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="oprcode2" maxlength="15"/>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="oprcode2" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                 <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="employeelog" key="employeename"/>:</div></td>
                <td width="75%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="employeename" maxlength="30"/>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="employeename" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                 <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="employeelog" key="birthday"/>:</div></td>
                <td width="75%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="birthday" maxlength="25"/>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="birthday" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                 <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="employeelog" key="sex"/>:</div></td>
                <td width="75%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="sex" maxlength="3"/>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="sex" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                 <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="employeelog" key="edulevel"/>:</div></td>
                <td width="75%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="edulevel" maxlength="3"/>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="edulevel" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                 <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="employeelog" key="nativehome"/>:</div></td>
                <td width="75%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="nativehome" maxlength="20"/>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="nativehome" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                 <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="employeelog" key="polivisage"/>:</div></td>
                <td width="75%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="polivisage" maxlength="3"/>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="polivisage" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                 <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="employeelog" key="department"/>:</div></td>
                <td width="75%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="department" maxlength="18"/>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="department" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                 <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="employeelog" key="servoffice"/>:</div></td>
                <td width="75%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="servoffice" maxlength="18"/>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="servoffice" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                 <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="employeelog" key="station"/>:</div></td>
                <td width="75%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="station" maxlength="3"/>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="station" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                 <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="employeelog" key="joblevel"/>:</div></td>
                <td width="75%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="joblevel" maxlength="3"/>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="joblevel" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                 <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="employeelog" key="intime"/>:</div></td>
                <td width="75%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="intime" maxlength="25"/>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="intime" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                 <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="employeelog" key="worktime"/>:</div></td>
                <td width="75%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="worktime" maxlength="3"/>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="worktime" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                 <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="employeelog" key="hereworktime"/>:</div></td>
                <td width="75%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="hereworktime" maxlength="3"/>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="hereworktime" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                 <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="employeelog" key="employtype"/>:</div></td>
                <td width="75%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="employtype" maxlength="3"/>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="employtype" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                 <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="employeelog" key="company"/>:</div></td>
                <td width="75%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="company" maxlength="50"/>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="company" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                 <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="employeelog" key="telephone"/>:</div></td>
                <td width="75%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="telephone" maxlength="15"/>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="telephone" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                 <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="employeelog" key="officetel"/>:</div></td>
                <td width="75%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="officetel" maxlength="12"/>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="officetel" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                 <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="employeelog" key="outtime"/>:</div></td>
                <td width="75%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="outtime" maxlength="25"/>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="outtime" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                 <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="employeelog" key="outresult"/>:</div></td>
                <td width="75%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="outresult" maxlength="255"/>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="outresult" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                 <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="employeelog" key="homeaddr"/>:</div></td>
                <td width="75%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="homeaddr" maxlength="255"/>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="homeaddr" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                 <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="employeelog" key="cardid"/>:</div></td>
                <td width="75%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="cardid" maxlength="18"/>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="cardid" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                 <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="employeelog" key="wayid"/>:</div></td>
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
                           onclick="doSave('/cms/employeelog.do?CMD=SAVE')"/>
                  </s:PurChk>
                 <s:PurChk controlid="<%=ID_2%>">
                    <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
                           name="btnPrint" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<bean:message bundle="public" key="button_print"/>" class="print" onclick="doPrint()">
                 </s:PurChk>
                    <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
                           name="btnReturn" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<bean:message bundle="public" key="button_return"/>" class="close"
                           onclick="doReturn('/cms/employeelog.do?CMD=LIST')">
                </td>
            </tr>
        </table>
    </div>
</html:form>
</div>
</body>
</html>
