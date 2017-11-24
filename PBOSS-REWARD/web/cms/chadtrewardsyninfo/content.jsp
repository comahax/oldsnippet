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
    <title><bean:message bundle="chadtrewardsyninfo" key="titleUpdate"/></title>
    <script language="JavaScript">
        function ev_checkval() {
            addfield('taskid', '<bean:message bundle="chadtrewardsyninfo" key="taskid"/>', 'f', false, '14');
            addfield('rewardmonth', '<bean:message bundle="chadtrewardsyninfo" key="rewardmonth"/>', 'c', false, '6');
            addfield('systemflag', '<bean:message bundle="chadtrewardsyninfo" key="systemflag"/>', 'f', false, '3');
            addfield('countyid', '<bean:message bundle="chadtrewardsyninfo" key="countyid"/>', 'c', false, '14');
            addfield('wayid', '<bean:message bundle="chadtrewardsyninfo" key="wayid"/>', 'c', false, '18');
            addfield('chainhead', '<bean:message bundle="chadtrewardsyninfo" key="chainhead"/>', 'c', false, '18');
            addfield('mobile', '<bean:message bundle="chadtrewardsyninfo" key="mobile"/>', 'c', false, '32');
            addfield('opnids', '<bean:message bundle="chadtrewardsyninfo" key="opnids"/>', 'c', false, '300');
            addfield('taskstate', '<bean:message bundle="chadtrewardsyninfo" key="taskstate"/>', 'f', false, '1');
            addfield('operid', '<bean:message bundle="chadtrewardsyninfo" key="operid"/>', 'c', false, '16');
            addfield('optime', '<bean:message bundle="chadtrewardsyninfo" key="optime"/>', 't', false, '7');
            addfield('resultfile', '<bean:message bundle="chadtrewardsyninfo" key="resultfile"/>', 'c', false, '200');
            addfield('finishtime', '<bean:message bundle="chadtrewardsyninfo" key="finishtime"/>', 't', false, '7');
            addfield('totalcount', '<bean:message bundle="chadtrewardsyninfo" key="totalcount"/>', 'f', false, '7');
            addfield('successsum', '<bean:message bundle="chadtrewardsyninfo" key="successsum"/>', 'f', false, '16');

            return checkval(window);
        }
    </script>
</head>
<body>
<div class="table_container">
<html:form action="/cms/chadtrewardsyninfo.do?CMD=SAVE" styleId="formItem" method="post">
    <html:hidden property="cmdState"/>

    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <html:hidden property="_se_rewardmonth"/>
    <html:hidden property="_ne_systemflag"/>
    <html:hidden property="_ne_taskstate"/>
    <html:hidden property="_sk_operid"/>
    <html:hidden property="_dnm_optime"/>
    <html:hidden property="_dnl_optime"/>
    <c:set var="edtState" scope="request" value="${!empty param.CMD and (param.CMD eq 'EDIT' or param.CMD eq 'NEW')}"/>
    <c:set var="updateState" scope="request" value="${!empty param.CMD and (param.CMD eq 'EDIT')}"/>
    <c:set var="form" scope="request" value="${requestScope['/cms/chadtrewardsyninfo/ChadtrewardsyninfoForm']}"/>

    <!--##################################添加标题内容##################################################-->
    <div class="table_div">
    <table class="top_table">
    	<tr>
    		<td>
    			<bean:message bundle="chadtrewardsyninfo" key="titleList"/>
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
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chadtrewardsyninfo" key="taskid"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                        <c:if test="${updateState}">
                            <html:text styleClass="form_input_1x" property="taskid" readonly="true"/>
                        </c:if>
                        <c:if test="${!updateState}">
                            <html:text styleClass="form_input_1x" property="taskid" />
                        </c:if>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="taskid" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chadtrewardsyninfo" key="rewardmonth"/>:</div></td>
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
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chadtrewardsyninfo" key="systemflag"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="systemflag" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="systemflag" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chadtrewardsyninfo" key="countyid"/>:</div></td>
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
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chadtrewardsyninfo" key="wayid"/>:</div></td>
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
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chadtrewardsyninfo" key="chainhead"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="chainhead" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="chainhead" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chadtrewardsyninfo" key="mobile"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="mobile" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="mobile" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chadtrewardsyninfo" key="opnids"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="opnids" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="opnids" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chadtrewardsyninfo" key="taskstate"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="taskstate" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="taskstate" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chadtrewardsyninfo" key="operid"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="operid" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="operid" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chadtrewardsyninfo" key="optime"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="optime" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="optime" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chadtrewardsyninfo" key="resultfile"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="resultfile" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="resultfile" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chadtrewardsyninfo" key="finishtime"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="finishtime" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="finishtime" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chadtrewardsyninfo" key="totalcount"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="totalcount" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="totalcount" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chadtrewardsyninfo" key="successsum"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="successsum" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="successsum" disabled="true"/>
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
                           onclick="doSave('/cms/chadtrewardsyninfo.do?CMD=SAVE')"/>
                    <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
                           name="btnPrint" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<bean:message bundle="public" key="button_print"/>" class="print" onclick="doPrint()">
                    <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
                           name="btnReturn" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<bean:message bundle="public" key="button_return"/>" class="close"
                           onclick="doReturn('/cms/chadtrewardsyninfo.do?CMD=LIST')">
                </td>
            </tr>
        </table>
    </div>
</html:form>
</div>
</body>
</html>
