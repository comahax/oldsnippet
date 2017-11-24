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
    <title><bean:message bundle="zdrewardrecord" key="titleUpdate"/></title>
    <script language="JavaScript">
        function ev_checkval() {
            addfield('seq', '<bean:message bundle="zdrewardrecord" key="seq"/>', 'f', false, '14');
            addfield('calcmonth', '<bean:message bundle="zdrewardrecord" key="calcmonth"/>', 'c', false, '8');
            addfield('opnid', '<bean:message bundle="zdrewardrecord" key="opnid"/>', 'c', false, '18');
            addfield('name', '<bean:message bundle="zdrewardrecord" key="name"/>', 'c', false, '50');
            addfield('wayid', '<bean:message bundle="zdrewardrecord" key="wayid"/>', 'c', false, '18');
            addfield('wayname', '<bean:message bundle="zdrewardrecord" key="wayname"/>', 'c', false, '256');
            addfield('oprcode', '<bean:message bundle="zdrewardrecord" key="oprcode"/>', 'c', false, '15');
            addfield('mobile', '<bean:message bundle="zdrewardrecord" key="mobile"/>', 'c', false, '15');
            addfield('oprtime', '<bean:message bundle="zdrewardrecord" key="oprtime"/>', 't', false, '7');
            addfield('runtime', '<bean:message bundle="zdrewardrecord" key="runtime"/>', 't', false, '7');
            addfield('ruleid', '<bean:message bundle="zdrewardrecord" key="ruleid"/>', 'c', false, '18');
            addfield('resultflag', '<bean:message bundle="zdrewardrecord" key="resultflag"/>', 'c', false, '15');
            addfield('adtflag', '<bean:message bundle="zdrewardrecord" key="adtflag"/>', 'f', false, '2');
            addfield('adtcode', '<bean:message bundle="zdrewardrecord" key="adtcode"/>', 'c', false, '200');
            addfield('adtremark', '<bean:message bundle="zdrewardrecord" key="adtremark"/>', 'c', false, '800');
            addfield('rewardtype', '<bean:message bundle="zdrewardrecord" key="rewardtype"/>', 'c', false, '50');
            addfield('rewardflag', '<bean:message bundle="zdrewardrecord" key="rewardflag"/>', 'f', false, '3');
            addfield('repairmonth', '<bean:message bundle="zdrewardrecord" key="repairmonth"/>', 'c', false, '8');
            addfield('batchno', '<bean:message bundle="zdrewardrecord" key="batchno"/>', 'c', false, '18');
            addfield('bakinfo', '<bean:message bundle="zdrewardrecord" key="bakinfo"/>', 'c', false, '18');
            addfield('bakinfo2', '<bean:message bundle="zdrewardrecord" key="bakinfo2"/>', 'c', false, '40');
            addfield('bakinfo3', '<bean:message bundle="zdrewardrecord" key="bakinfo3"/>', 'f', false, '14');
            addfield('wrapfee', '<bean:message bundle="zdrewardrecord" key="wrapfee"/>', 'f', false, '10');
            addfield('noncyc', '<bean:message bundle="zdrewardrecord" key="noncyc"/>', 'f', false, '3');
            addfield('totalsum', '<bean:message bundle="zdrewardrecord" key="totalsum"/>', 'f', false, '22');
            addfield('paysum', '<bean:message bundle="zdrewardrecord" key="paysum"/>', 'f', false, '22');
            addfield('paymoney1', '<bean:message bundle="zdrewardrecord" key="paymoney1"/>', 'f', false, '22');

            return checkval(window);
        }
    </script>
</head>
<body>
<div class="table_container">
<html:form action="/cms/reward/zdrewardrecord.do?CMD=SAVE" styleId="formItem" method="post">
    <html:hidden property="cmdState"/>

    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <html:hidden property="_se_calcmonth"/>
    <html:hidden property="_se_wayid"/>
    <html:hidden property="_se_oprcode"/>
    <html:hidden property="_se_mobile"/>
    <html:hidden property="_dnm_oprtime"/>
    <html:hidden property="_dnl_oprtime"/>
    <html:hidden property="_se_batchno"/>
    <html:hidden property="_se_bakinfo"/>
    <html:hidden property="_ne_noncyc"/>
    <c:set var="edtState" scope="request" value="${!empty param.CMD and (param.CMD eq 'EDIT' or param.CMD eq 'NEW')}"/>
    <c:set var="updateState" scope="request" value="${!empty param.CMD and (param.CMD eq 'EDIT')}"/>
    <c:set var="form" scope="request" value="${requestScope['/cms/reward/zdrewardrecord/ZdrewardrecordForm']}"/>

    <!--##################################添加标题内容##################################################-->
    <div class="table_div">
    <table class="top_table">
    	<tr>
    		<td>
    			<bean:message bundle="zdrewardrecord" key="titleList"/>
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
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="zdrewardrecord" key="seq"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                        <c:if test="${updateState}">
                            <html:text styleClass="form_input_1x" property="seq" readonly="true"/>
                        </c:if>
                        <c:if test="${!updateState}">
                            <html:text styleClass="form_input_1x" property="seq" />
                        </c:if>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="seq" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="zdrewardrecord" key="calcmonth"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="calcmonth" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="calcmonth" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="zdrewardrecord" key="opnid"/>:</div></td>
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
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="zdrewardrecord" key="name"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="name" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="name" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="zdrewardrecord" key="wayid"/>:</div></td>
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
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="zdrewardrecord" key="wayname"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="wayname" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="wayname" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="zdrewardrecord" key="oprcode"/>:</div></td>
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
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="zdrewardrecord" key="mobile"/>:</div></td>
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
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="zdrewardrecord" key="oprtime"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="oprtime" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="oprtime" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="zdrewardrecord" key="runtime"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="runtime" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="runtime" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="zdrewardrecord" key="ruleid"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="ruleid" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="ruleid" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="zdrewardrecord" key="resultflag"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="resultflag" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="resultflag" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="zdrewardrecord" key="adtflag"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="adtflag" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="adtflag" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="zdrewardrecord" key="adtcode"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="adtcode" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="adtcode" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="zdrewardrecord" key="adtremark"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="adtremark" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="adtremark" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="zdrewardrecord" key="rewardtype"/>:</div></td>
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
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="zdrewardrecord" key="rewardflag"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="rewardflag" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="rewardflag" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="zdrewardrecord" key="repairmonth"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="repairmonth" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="repairmonth" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="zdrewardrecord" key="batchno"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="batchno" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="batchno" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="zdrewardrecord" key="bakinfo"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="bakinfo" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="bakinfo" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="zdrewardrecord" key="bakinfo2"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="bakinfo2" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="bakinfo2" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="zdrewardrecord" key="bakinfo3"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="bakinfo3" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="bakinfo3" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="zdrewardrecord" key="wrapfee"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="wrapfee" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="wrapfee" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="zdrewardrecord" key="noncyc"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="noncyc" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="noncyc" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="zdrewardrecord" key="totalsum"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="totalsum" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="totalsum" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="zdrewardrecord" key="paysum"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="paysum" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="paysum" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="zdrewardrecord" key="paymoney1"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="paymoney1" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="paymoney1" disabled="true"/>
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
                           onclick="doSave('/cms/reward/zdrewardrecord.do?CMD=SAVE')"/>
                    <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
                           name="btnPrint" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<bean:message bundle="public" key="button_print"/>" class="print" onclick="doPrint()">
                    <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
                           name="btnReturn" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<bean:message bundle="public" key="button_return"/>" class="close"
                           onclick="doReturn('/cms/reward/zdrewardrecord.do?CMD=LIST')">
                </td>
            </tr>
        </table>
    </div>
</html:form>
</div>
</body>
</html>
