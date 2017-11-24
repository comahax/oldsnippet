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
    <title><bean:message bundle="chpdrewardadc" key="titleUpdate"/></title>
    <script language="JavaScript">
        function ev_checkval() {
            addfield('rewardid', '<bean:message bundle="chpdrewardadc" key="rewardid"/>', 'f', false, '14');
            addfield('cityid', '<bean:message bundle="chpdrewardadc" key="cityid"/>', 'c', false, '4');
            addfield('provagentid', '<bean:message bundle="chpdrewardadc" key="provagentid"/>', 'c', false, '15');
            addfield('prodid', '<bean:message bundle="chpdrewardadc" key="prodid"/>', 'c', false, '15');
            addfield('custid', '<bean:message bundle="chpdrewardadc" key="custid"/>', 'c', false, '15');
            addfield('custname', '<bean:message bundle="chpdrewardadc" key="custname"/>', 'c', false, '50');
            addfield('prodno', '<bean:message bundle="chpdrewardadc" key="prodno"/>', 'c', false, '18');
            addfield('rewardmoney', '<bean:message bundle="chpdrewardadc" key="rewardmoney"/>', 'f', false, '15');
            addfield('phase', '<bean:message bundle="chpdrewardadc" key="phase"/>', 'f', false, '3');
            addfield('supplemoney', '<bean:message bundle="chpdrewardadc" key="supplemoney"/>', 'f', false, '15');
            addfield('rpmoney', '<bean:message bundle="chpdrewardadc" key="rpmoney"/>', 'f', false, '15');
            addfield('inbossmonth', '<bean:message bundle="chpdrewardadc" key="inbossmonth"/>', 'c', false, '8');
            addfield('rewardmonth', '<bean:message bundle="chpdrewardadc" key="rewardmonth"/>', 'c', false, '8');
            addfield('reason', '<bean:message bundle="chpdrewardadc" key="reason"/>', 'c', false, '256');
            addfield('version', '<bean:message bundle="chpdrewardadc" key="version"/>', 'c', false, '10');
            addfield('ruledesc', '<bean:message bundle="chpdrewardadc" key="ruledesc"/>', 'c', false, '256');
            addfield('isreleaseadc', '<bean:message bundle="chpdrewardadc" key="isreleaseadc"/>', 'f', false, '1');

            return checkval(window);
        }
    </script>
</head>
<body>
<div class="table_container">
<html:form action="/cms/provagent/chpdrewardadc.do?CMD=SAVE" styleId="formItem" method="post">
    <html:hidden property="cmdState"/>

    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <html:hidden property="_se_cityid"/>
    <html:hidden property="_se_provagentid"/>
    <html:hidden property="_se_prodno"/>
    <html:hidden property="_se_rewardmonth"/>
    <html:hidden property="_ne_isreleaseadc"/>
    <c:set var="edtState" scope="request" value="${!empty param.CMD and (param.CMD eq 'EDIT' or param.CMD eq 'NEW')}"/>
    <c:set var="updateState" scope="request" value="${!empty param.CMD and (param.CMD eq 'EDIT')}"/>
    <c:set var="form" scope="request" value="${requestScope['/cms/provagent/chpdrewardadc/ChPdRewardadcForm']}"/>

    <!--##################################添加标题内容##################################################-->
    <div class="table_div">
    <table class="top_table">
    	<tr>
    		<td>
    			<bean:message bundle="chpdrewardadc" key="titleList"/>
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
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chpdrewardadc" key="rewardid"/>:</div></td>
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
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chpdrewardadc" key="cityid"/>:</div></td>
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
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chpdrewardadc" key="provagentid"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="provagentid" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="provagentid" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chpdrewardadc" key="prodid"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="prodid" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="prodid" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chpdrewardadc" key="custid"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="custid" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="custid" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chpdrewardadc" key="custname"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="custname" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="custname" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chpdrewardadc" key="prodno"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="prodno" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="prodno" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chpdrewardadc" key="rewardmoney"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="rewardmoney" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="rewardmoney" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chpdrewardadc" key="phase"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="phase" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="phase" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chpdrewardadc" key="supplemoney"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="supplemoney" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="supplemoney" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chpdrewardadc" key="rpmoney"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="rpmoney" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="rpmoney" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chpdrewardadc" key="inbossmonth"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="inbossmonth" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="inbossmonth" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chpdrewardadc" key="rewardmonth"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="rewardmonth" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="rewardmonth" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chpdrewardadc" key="reason"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="reason" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="reason" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chpdrewardadc" key="version"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="version" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="version" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chpdrewardadc" key="ruledesc"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="ruledesc" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="ruledesc" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chpdrewardadc" key="isreleaseadc"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="isreleaseadc" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="isreleaseadc" disabled="true"/>
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
                           onclick="doSave('/cms/provagent/chpdrewardadc.do?CMD=SAVE')"/>
                    <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
                           name="btnPrint" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<bean:message bundle="public" key="button_print"/>" class="print" onclick="doPrint()">
                    <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
                           name="btnReturn" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<bean:message bundle="public" key="button_return"/>" class="close"
                           onclick="doReturn('/cms/provagent/chpdrewardadc.do?CMD=LIST')">
                </td>
            </tr>
        </table>
    </div>
</html:form>
</div>
</body>
</html>
