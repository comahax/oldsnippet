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
    <title><bean:message bundle="chadtbusitoapprove" key="titleUpdate"/></title>
    <script language="JavaScript">
        function ev_checkval() {
            addfield('approveid', '<bean:message bundle="chadtbusitoapprove" key="approveid"/>', 'f', false, '28');
            addfield('batchid', '<bean:message bundle="chadtbusitoapprove" key="batchid"/>', 'c', false, '16');
            addfield('opnid', '<bean:message bundle="chadtbusitoapprove" key="opnid"/>', 'c', false, '18');
            addfield('opnname', '<bean:message bundle="chadtbusitoapprove" key="opnname"/>', 'c', false, '50');
            addfield('rewardtype', '<bean:message bundle="chadtbusitoapprove" key="rewardtype"/>', 'c', false, '5');
            addfield('region', '<bean:message bundle="chadtbusitoapprove" key="region"/>', 'c', false, '10');
            addfield('isslv', '<bean:message bundle="chadtbusitoapprove" key="isslv"/>', 'c', false, '3');
            addfield('slv', '<bean:message bundle="chadtbusitoapprove" key="slv"/>', 'c', false, '3');
            addfield('startdate', '<bean:message bundle="chadtbusitoapprove" key="startdate"/>', 't', false, '7');
            addfield('enddate', '<bean:message bundle="chadtbusitoapprove" key="enddate"/>', 't', false, '7');
            addfield('acctype', '<bean:message bundle="chadtbusitoapprove" key="acctype"/>', 'c', false, '2');
            addfield('rewardstd', '<bean:message bundle="chadtbusitoapprove" key="rewardstd"/>', 'f', false, '16');
            addfield('intvmonth', '<bean:message bundle="chadtbusitoapprove" key="intvmonth"/>', 'f', false, '5');
            addfield('isprov', '<bean:message bundle="chadtbusitoapprove" key="isprov"/>', 'c', false, '2');
            addfield('ruleinfo', '<bean:message bundle="chadtbusitoapprove" key="ruleinfo"/>', 'c', false, '1000');
            addfield('ruledesc', '<bean:message bundle="chadtbusitoapprove" key="ruledesc"/>', 'c', false, '2000');
            addfield('isslvlev', '<bean:message bundle="chadtbusitoapprove" key="isslvlev"/>', 'f', false, '3');
            addfield('slvlev', '<bean:message bundle="chadtbusitoapprove" key="slvlev"/>', 'f', false, '3');
            addfield('citystd', '<bean:message bundle="chadtbusitoapprove" key="citystd"/>', 'f', false, '10');
            addfield('countrystd', '<bean:message bundle="chadtbusitoapprove" key="countrystd"/>', 'f', false, '10');
            addfield('cityaccountlimit', '<bean:message bundle="chadtbusitoapprove" key="cityaccountlimit"/>', 'f', false, '10');
            addfield('countyaccountlimit', '<bean:message bundle="chadtbusitoapprove" key="countyaccountlimit"/>', 'f', false, '10');
            addfield('citycorelimit', '<bean:message bundle="chadtbusitoapprove" key="citycorelimit"/>', 'f', false, '10');
            addfield('countycorelimit', '<bean:message bundle="chadtbusitoapprove" key="countycorelimit"/>', 'f', false, '10');
            addfield('percentage', '<bean:message bundle="chadtbusitoapprove" key="percentage"/>', 'f', false, '3');
            addfield('years', '<bean:message bundle="chadtbusitoapprove" key="years"/>', 'f', false, '4');
            addfield('apptime', '<bean:message bundle="chadtbusitoapprove" key="apptime"/>', 't', false, '7');
            addfield('systemdate', '<bean:message bundle="chadtbusitoapprove" key="systemdate"/>', 't', false, '7');
            addfield('addopntime', '<bean:message bundle="chadtbusitoapprove" key="addopntime"/>', 't', false, '7');

            return checkval(window);
        }
    </script>
</head>
<body>
<div class="table_container">
<html:form action="/cms/chadtbusitoapprove.do?CMD=SAVE" styleId="formItem" method="post">
    <html:hidden property="cmdState"/>

    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <html:hidden property="_se_approveid"/>
    <html:hidden property="_se_batchid"/>
    <html:hidden property="_se_opnid"/>
    <html:hidden property="_se_rewardtype"/>
    <html:hidden property="_se_region"/>
    <html:hidden property="_dnm_apptime"/>
    <html:hidden property="_dnl_apptime"/>
    <c:set var="edtState" scope="request" value="${!empty param.CMD and (param.CMD eq 'EDIT' or param.CMD eq 'NEW')}"/>
    <c:set var="updateState" scope="request" value="${!empty param.CMD and (param.CMD eq 'EDIT')}"/>
    <c:set var="form" scope="request" value="${requestScope['/cms/chadtbusitoapprove/ChadtbusitoapproveForm']}"/>

    <!--##################################添加标题内容##################################################-->
    <div class="table_div">
    <table class="top_table">
    	<tr>
    		<td>
    			<bean:message bundle="chadtbusitoapprove" key="titleList"/>
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
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chadtbusitoapprove" key="approveid"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                        <c:if test="${updateState}">
                            <html:text styleClass="form_input_1x" property="approveid" readonly="true"/>
                        </c:if>
                        <c:if test="${!updateState}">
                            <html:text styleClass="form_input_1x" property="approveid" />
                        </c:if>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="approveid" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chadtbusitoapprove" key="batchid"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="batchid" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="batchid" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chadtbusitoapprove" key="opnid"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="opnid" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="opnid" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chadtbusitoapprove" key="opnname"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="opnname" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="opnname" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chadtbusitoapprove" key="rewardtype"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="rewardtype" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="rewardtype" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chadtbusitoapprove" key="region"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="region" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="region" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chadtbusitoapprove" key="isslv"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="isslv" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="isslv" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chadtbusitoapprove" key="slv"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="slv" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="slv" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chadtbusitoapprove" key="startdate"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="startdate" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="startdate" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chadtbusitoapprove" key="enddate"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="enddate" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="enddate" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chadtbusitoapprove" key="acctype"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="acctype" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="acctype" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chadtbusitoapprove" key="rewardstd"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="rewardstd" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="rewardstd" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chadtbusitoapprove" key="intvmonth"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="intvmonth" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="intvmonth" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chadtbusitoapprove" key="isprov"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="isprov" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="isprov" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chadtbusitoapprove" key="ruleinfo"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="ruleinfo" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="ruleinfo" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chadtbusitoapprove" key="ruledesc"/>:</div></td>
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
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chadtbusitoapprove" key="isslvlev"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="isslvlev" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="isslvlev" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chadtbusitoapprove" key="slvlev"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="slvlev" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="slvlev" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chadtbusitoapprove" key="citystd"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="citystd" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="citystd" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chadtbusitoapprove" key="countrystd"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="countrystd" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="countrystd" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chadtbusitoapprove" key="cityaccountlimit"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="cityaccountlimit" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="cityaccountlimit" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chadtbusitoapprove" key="countyaccountlimit"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="countyaccountlimit" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="countyaccountlimit" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chadtbusitoapprove" key="citycorelimit"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="citycorelimit" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="citycorelimit" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chadtbusitoapprove" key="countycorelimit"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="countycorelimit" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="countycorelimit" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chadtbusitoapprove" key="percentage"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="percentage" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="percentage" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chadtbusitoapprove" key="years"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="years" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="years" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chadtbusitoapprove" key="apptime"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="apptime" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="apptime" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chadtbusitoapprove" key="systemdate"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="systemdate" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="systemdate" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chadtbusitoapprove" key="addopntime"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="addopntime" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="addopntime" disabled="true"/>
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
                           onclick="doSave('/cms/chadtbusitoapprove.do?CMD=SAVE')"/>
                    <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
                           name="btnPrint" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<bean:message bundle="public" key="button_print"/>" class="print" onclick="doPrint()">
                    <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
                           name="btnReturn" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<bean:message bundle="public" key="button_return"/>" class="close"
                           onclick="doReturn('/cms/chadtbusitoapprove.do?CMD=LIST')">
                </td>
            </tr>
        </table>
    </div>
</html:form>
</div>
</body>
</html>
