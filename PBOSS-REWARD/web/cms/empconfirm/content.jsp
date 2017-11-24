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
    <title><bean:message bundle="empconfirm" key="titleUpdate"/></title>
    <script language="JavaScript">
        function ev_checkval() {
            addfield('employeeid', '<bean:message bundle="empconfirm" key="employeeid"/>', 'c', false, '15');
            addfield('oprcode', '<bean:message bundle="empconfirm" key="oprcode"/>', 'c', false, '15');
            addfield('employeename', '<bean:message bundle="empconfirm" key="employeename"/>', 'c', false, '30');
            addfield('birthday', '<bean:message bundle="empconfirm" key="birthday"/>', 't', false, '7');
            addfield('sex', '<bean:message bundle="empconfirm" key="sex"/>', 'f', false, '3');
            addfield('edulevel', '<bean:message bundle="empconfirm" key="edulevel"/>', 'f', false, '3');
            addfield('nativehome', '<bean:message bundle="empconfirm" key="nativehome"/>', 'c', false, '20');
            addfield('polivisage', '<bean:message bundle="empconfirm" key="polivisage"/>', 'f', false, '3');
            addfield('department', '<bean:message bundle="empconfirm" key="department"/>', 'c', false, '18');
            addfield('servoffice', '<bean:message bundle="empconfirm" key="servoffice"/>', 'c', false, '18');
            addfield('station', '<bean:message bundle="empconfirm" key="station"/>', 'f', false, '14');
            addfield('joblevel', '<bean:message bundle="empconfirm" key="joblevel"/>', 'f', false, '3');
            addfield('intime', '<bean:message bundle="empconfirm" key="intime"/>', 't', false, '7');
            addfield('worktime', '<bean:message bundle="empconfirm" key="worktime"/>', 'f', false, '3');
            addfield('hereworktime', '<bean:message bundle="empconfirm" key="hereworktime"/>', 'f', false, '3');
            addfield('employtype', '<bean:message bundle="empconfirm" key="employtype"/>', 'f', false, '3');
            addfield('company', '<bean:message bundle="empconfirm" key="company"/>', 'c', false, '50');
            addfield('telephone', '<bean:message bundle="empconfirm" key="telephone"/>', 'c', false, '15');
            addfield('officetel', '<bean:message bundle="empconfirm" key="officetel"/>', 'c', false, '12');
            addfield('outtime', '<bean:message bundle="empconfirm" key="outtime"/>', 't', false, '7');
            addfield('outresult', '<bean:message bundle="empconfirm" key="outresult"/>', 'c', false, '255');
            addfield('homeaddr', '<bean:message bundle="empconfirm" key="homeaddr"/>', 'c', false, '255');
            addfield('cardid', '<bean:message bundle="empconfirm" key="cardid"/>', 'c', false, '18');
            addfield('wayid', '<bean:message bundle="empconfirm" key="wayid"/>', 'c', false, '18');
            addfield('waytype', '<bean:message bundle="empconfirm" key="waytype"/>', 'c', false, '4');
            addfield('pvtemail', '<bean:message bundle="empconfirm" key="pvtemail"/>', 'c', false, '128');
            addfield('ofcphone', '<bean:message bundle="empconfirm" key="ofcphone"/>', 'c', false, '64');
            addfield('ofcemail', '<bean:message bundle="empconfirm" key="ofcemail"/>', 'c', false, '128');
            addfield('speciality', '<bean:message bundle="empconfirm" key="speciality"/>', 'c', false, '16');
            addfield('cityid', '<bean:message bundle="empconfirm" key="cityid"/>', 'c', false, '14');
            addfield('countyid', '<bean:message bundle="empconfirm" key="countyid"/>', 'c', false, '14');
            addfield('svccode', '<bean:message bundle="empconfirm" key="svccode"/>', 'c', false, '14');
            addfield('posittype', '<bean:message bundle="empconfirm" key="posittype"/>', 'c', false, '16');
            addfield('contacttype', '<bean:message bundle="empconfirm" key="contacttype"/>', 'f', false, '2');
            addfield('empstatus', '<bean:message bundle="empconfirm" key="empstatus"/>', 'f', false, '2');
            addfield('actbank', '<bean:message bundle="empconfirm" key="actbank"/>', 'c', false, '64');
            addfield('actno', '<bean:message bundle="empconfirm" key="actno"/>', 'c', false, '32');
            addfield('actname', '<bean:message bundle="empconfirm" key="actname"/>', 'c', false, '32');
            addfield('actpid', '<bean:message bundle="empconfirm" key="actpid"/>', 'c', false, '20');
            addfield('bail', '<bean:message bundle="empconfirm" key="bail"/>', 'f', false, '12');
            addfield('gradschool', '<bean:message bundle="empconfirm" key="gradschool"/>', 'c', false, '40');
            addfield('gradtime', '<bean:message bundle="empconfirm" key="gradtime"/>', 't', false, '7');
            addfield('ismarried', '<bean:message bundle="empconfirm" key="ismarried"/>', 'f', false, '2');
            addfield('outreason', '<bean:message bundle="empconfirm" key="outreason"/>', 'f', false, '2');
            addfield('trainlevel', '<bean:message bundle="empconfirm" key="trainlevel"/>', 'c', false, '20');
            addfield('hobby', '<bean:message bundle="empconfirm" key="hobby"/>', 'c', false, '255');
            addfield('character', '<bean:message bundle="empconfirm" key="character"/>', 'c', false, '255');
            addfield('asses', '<bean:message bundle="empconfirm" key="asses"/>', 'c', false, '255');
            addfield('workhistry', '<bean:message bundle="empconfirm" key="workhistry"/>', 'c', false, '255');
            addfield('prizeorpunish', '<bean:message bundle="empconfirm" key="prizeorpunish"/>', 'c', false, '255');
            addfield('empass', '<bean:message bundle="empconfirm" key="empass"/>', 'c', false, '20');
            addfield('right', '<bean:message bundle="empconfirm" key="right"/>', 'f', false, '2');
            addfield('isnet', '<bean:message bundle="empconfirm" key="isnet"/>', 'f', false, '2');
            addfield('netpass', '<bean:message bundle="empconfirm" key="netpass"/>', 'c', false, '6');
            addfield('isopen', '<bean:message bundle="empconfirm" key="isopen"/>', 'f', false, '2');
            addfield('selectmobile', '<bean:message bundle="empconfirm" key="selectmobile"/>', 'c', false, '12');
            addfield('subname', '<bean:message bundle="empconfirm" key="subname"/>', 'c', false, '40');
            addfield('regdate', '<bean:message bundle="empconfirm" key="regdate"/>', 't', false, '7');
            addfield('empattr', '<bean:message bundle="empconfirm" key="empattr"/>', 'c', false, '50');
            addfield('empattrmemo', '<bean:message bundle="empconfirm" key="empattrmemo"/>', 'c', false, '512');
            addfield('confirmid', '<bean:message bundle="empconfirm" key="confirmid"/>', 'f', false, '14');
            addfield('smsstatus', '<bean:message bundle="empconfirm" key="smsstatus"/>', 'f', false, '3');
            addfield('smscreattime', '<bean:message bundle="empconfirm" key="smscreattime"/>', 't', false, '7');
            addfield('smsconfirmtime', '<bean:message bundle="empconfirm" key="smsconfirmtime"/>', 't', false, '7');

            return checkval(window);
        }
    </script>
</head>
<body>
<div class="table_container">
<html:form action="/cms/empconfirm.do?CMD=SAVE" styleId="formItem" method="post">
    <html:hidden property="cmdState"/>

    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <c:set var="edtState" scope="request" value="${!empty param.CMD and (param.CMD eq 'EDIT' or param.CMD eq 'NEW')}"/>
    <c:set var="updateState" scope="request" value="${!empty param.CMD and (param.CMD eq 'EDIT')}"/>
    <c:set var="form" scope="request" value="${requestScope['/cms/empconfirm/EmpconfirmForm']}"/>

    <!--##################################添加标题内容##################################################-->
    <div class="table_div">
    <table class="top_table">
    	<tr>
    		<td>
    			<bean:message bundle="empconfirm" key="titleList"/>
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
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="empconfirm" key="employeeid"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="employeeid" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="employeeid" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="empconfirm" key="oprcode"/>:</div></td>
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
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="empconfirm" key="employeename"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="employeename" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="employeename" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="empconfirm" key="birthday"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="birthday" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="birthday" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="empconfirm" key="sex"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="sex" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="sex" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="empconfirm" key="edulevel"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="edulevel" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="edulevel" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="empconfirm" key="nativehome"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="nativehome" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="nativehome" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="empconfirm" key="polivisage"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="polivisage" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="polivisage" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="empconfirm" key="department"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="department" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="department" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="empconfirm" key="servoffice"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="servoffice" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="servoffice" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="empconfirm" key="station"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="station" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="station" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="empconfirm" key="joblevel"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="joblevel" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="joblevel" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="empconfirm" key="intime"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="intime" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="intime" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="empconfirm" key="worktime"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="worktime" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="worktime" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="empconfirm" key="hereworktime"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="hereworktime" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="hereworktime" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="empconfirm" key="employtype"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="employtype" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="employtype" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="empconfirm" key="company"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="company" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="company" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="empconfirm" key="telephone"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="telephone" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="telephone" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="empconfirm" key="officetel"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="officetel" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="officetel" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="empconfirm" key="outtime"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="outtime" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="outtime" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="empconfirm" key="outresult"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="outresult" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="outresult" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="empconfirm" key="homeaddr"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="homeaddr" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="homeaddr" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="empconfirm" key="cardid"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="cardid" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="cardid" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="empconfirm" key="wayid"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="wayid" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="wayid" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="empconfirm" key="waytype"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="waytype" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="waytype" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="empconfirm" key="pvtemail"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="pvtemail" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="pvtemail" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="empconfirm" key="ofcphone"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="ofcphone" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="ofcphone" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="empconfirm" key="ofcemail"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="ofcemail" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="ofcemail" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="empconfirm" key="speciality"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="speciality" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="speciality" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="empconfirm" key="cityid"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="cityid" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="cityid" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="empconfirm" key="countyid"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="countyid" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="countyid" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="empconfirm" key="svccode"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="svccode" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="svccode" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="empconfirm" key="posittype"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="posittype" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="posittype" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="empconfirm" key="contacttype"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="contacttype" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="contacttype" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="empconfirm" key="empstatus"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="empstatus" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="empstatus" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="empconfirm" key="actbank"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="actbank" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="actbank" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="empconfirm" key="actno"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="actno" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="actno" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="empconfirm" key="actname"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="actname" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="actname" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="empconfirm" key="actpid"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="actpid" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="actpid" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="empconfirm" key="bail"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="bail" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="bail" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="empconfirm" key="gradschool"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="gradschool" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="gradschool" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="empconfirm" key="gradtime"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="gradtime" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="gradtime" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="empconfirm" key="ismarried"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="ismarried" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="ismarried" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="empconfirm" key="outreason"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="outreason" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="outreason" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="empconfirm" key="trainlevel"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="trainlevel" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="trainlevel" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="empconfirm" key="hobby"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="hobby" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="hobby" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="empconfirm" key="character"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="character" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="character" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="empconfirm" key="asses"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="asses" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="asses" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="empconfirm" key="workhistry"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="workhistry" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="workhistry" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="empconfirm" key="prizeorpunish"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="prizeorpunish" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="prizeorpunish" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="empconfirm" key="empass"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="empass" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="empass" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="empconfirm" key="right"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="right" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="right" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="empconfirm" key="isnet"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="isnet" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="isnet" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="empconfirm" key="netpass"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="netpass" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="netpass" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="empconfirm" key="isopen"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="isopen" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="isopen" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="empconfirm" key="selectmobile"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="selectmobile" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="selectmobile" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="empconfirm" key="subname"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="subname" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="subname" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="empconfirm" key="regdate"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="regdate" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="regdate" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="empconfirm" key="empattr"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="empattr" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="empattr" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="empconfirm" key="empattrmemo"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="empattrmemo" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="empattrmemo" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="empconfirm" key="confirmid"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                        <c:if test="${updateState}">
                            <html:text styleClass="form_input_1x" property="confirmid" readonly="true"/>
                        </c:if>
                        <c:if test="${!updateState}">
                            <html:text styleClass="form_input_1x" property="confirmid" />
                        </c:if>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="confirmid" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="empconfirm" key="smsstatus"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="smsstatus" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="smsstatus" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="empconfirm" key="smscreattime"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="smscreattime" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="smscreattime" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="empconfirm" key="smsconfirmtime"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="smsconfirmtime" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="smsconfirmtime" disabled="true"/>
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
                           onclick="doSave('/cms/empconfirm.do?CMD=SAVE')"/>
                    <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
                           name="btnPrint" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<bean:message bundle="public" key="button_print"/>" class="print" onclick="doPrint()">
                    <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
                           name="btnReturn" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<bean:message bundle="public" key="button_return"/>" class="close"
                           onclick="doReturn('/cms/empconfirm.do?CMD=LIST')">
                </td>
            </tr>
        </table>
    </div>
</html:form>
</div>
</body>
</html>
