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
    <title><bean:message bundle="chetadtrecord" key="titleUpdate"/></title>
    <script language="JavaScript">
        function ev_checkval() {
            addfield('seq', '<bean:message bundle="chetadtrecord" key="seq"/>', 'f', false, '14');
            addfield('srcseq', '<bean:message bundle="chetadtrecord" key="srcseq"/>', 'f', false, '14');
            addfield('oid', '<bean:message bundle="chetadtrecord" key="oid"/>', 'f', false, '14');
            addfield('opnid', '<bean:message bundle="chetadtrecord" key="opnid"/>', 'c', false, '18');
            addfield('calcopnid', '<bean:message bundle="chetadtrecord" key="calcopnid"/>', 'c', false, '18');
            addfield('calcmonth', '<bean:message bundle="chetadtrecord" key="calcmonth"/>', 'c', false, '6');
            addfield('wayid', '<bean:message bundle="chetadtrecord" key="wayid"/>', 'c', false, '32');
            addfield('oprcode', '<bean:message bundle="chetadtrecord" key="oprcode"/>', 'c', false, '16');
            addfield('oprtime', '<bean:message bundle="chetadtrecord" key="oprtime"/>', 't', false, '7');
            addfield('mobile', '<bean:message bundle="chetadtrecord" key="mobile"/>', 'c', false, '20');
            addfield('subsbrand', '<bean:message bundle="chetadtrecord" key="subsbrand"/>', 'c', false, '16');
            addfield('subsid', '<bean:message bundle="chetadtrecord" key="subsid"/>', 'f', false, '14');
            addfield('brand', '<bean:message bundle="chetadtrecord" key="brand"/>', 'c', false, '16');
            addfield('busivalue', '<bean:message bundle="chetadtrecord" key="busivalue"/>', 'f', false, '8');
            addfield('yxplanid', '<bean:message bundle="chetadtrecord" key="yxplanid"/>', 'f', false, '14');
            addfield('wrapfee', '<bean:message bundle="chetadtrecord" key="wrapfee"/>', 'f', false, '16');
            addfield('startdate', '<bean:message bundle="chetadtrecord" key="startdate"/>', 't', false, '7');
            addfield('ruleid', '<bean:message bundle="chetadtrecord" key="ruleid"/>', 'c', false, '32');
            addfield('ruleitemid', '<bean:message bundle="chetadtrecord" key="ruleitemid"/>', 'c', false, '32');
            addfield('rewardtype', '<bean:message bundle="chetadtrecord" key="rewardtype"/>', 'f', false, '2');
            addfield('rewardstd', '<bean:message bundle="chetadtrecord" key="rewardstd"/>', 'f', false, '16');
            addfield('noncyc', '<bean:message bundle="chetadtrecord" key="noncyc"/>', 'f', false, '2');
            addfield('batchno', '<bean:message bundle="chetadtrecord" key="batchno"/>', 'f', false, '14');
            addfield('adtcode', '<bean:message bundle="chetadtrecord" key="adtcode"/>', 'c', false, '256');
            addfield('adtremark', '<bean:message bundle="chetadtrecord" key="adtremark"/>', 'c', false, '256');
            addfield('dsrc', '<bean:message bundle="chetadtrecord" key="dsrc"/>', 'c', false, '32');
            addfield('bakinfo', '<bean:message bundle="chetadtrecord" key="bakinfo"/>', 'c', false, '64');
            addfield('bakinfo2', '<bean:message bundle="chetadtrecord" key="bakinfo2"/>', 'c', false, '64');
            addfield('bakinfo3', '<bean:message bundle="chetadtrecord" key="bakinfo3"/>', 'c', false, '64');
            addfield('adtflag', '<bean:message bundle="chetadtrecord" key="adtflag"/>', 'f', false, '2');
            addfield('createtime', '<bean:message bundle="chetadtrecord" key="createtime"/>', 't', false, '7');
            addfield('rewardid', '<bean:message bundle="chetadtrecord" key="rewardid"/>', 'f', false, '14');
            addfield('acctype', '<bean:message bundle="chetadtrecord" key="acctype"/>', 'f', false, '3');
            addfield('assegrade', '<bean:message bundle="chetadtrecord" key="assegrade"/>', 'f', false, '7');
            addfield('totalsum', '<bean:message bundle="chetadtrecord" key="totalsum"/>', 'f', false, '14');
            addfield('paysum', '<bean:message bundle="chetadtrecord" key="paysum"/>', 'f', false, '14');
            addfield('paymonth1', '<bean:message bundle="chetadtrecord" key="paymonth1"/>', 'c', false, '6');
            addfield('paymoney1', '<bean:message bundle="chetadtrecord" key="paymoney1"/>', 'f', false, '22');
            addfield('paymonth2', '<bean:message bundle="chetadtrecord" key="paymonth2"/>', 'c', false, '6');
            addfield('paymoney2', '<bean:message bundle="chetadtrecord" key="paymoney2"/>', 'f', false, '22');
            addfield('paymonth3', '<bean:message bundle="chetadtrecord" key="paymonth3"/>', 'c', false, '6');
            addfield('paymoney3', '<bean:message bundle="chetadtrecord" key="paymoney3"/>', 'f', false, '22');
            addfield('isbudget', '<bean:message bundle="chetadtrecord" key="isbudget"/>', 'f', false, '3');
            addfield('src', '<bean:message bundle="chetadtrecord" key="src"/>', 'c', false, '256');

            return checkval(window);
        }
    </script>
</head>
<body>
<div class="table_container">
<html:form action="/cms/et/chetadtrecord.do?CMD=SAVE" styleId="formItem" method="post">
    <html:hidden property="cmdState"/>

    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <html:hidden property="_se_opnid"/>
    <html:hidden property="_se_calcmonth"/>
    <html:hidden property="_se_wayid"/>
    <html:hidden property="_se_mobile"/>
    <html:hidden property="_ne_rewardtype"/>
    <html:hidden property="_ne_batchno"/>
    <html:hidden property="_ne_rewardid"/>
    <c:set var="edtState" scope="request" value="${!empty param.CMD and (param.CMD eq 'EDIT' or param.CMD eq 'NEW')}"/>
    <c:set var="updateState" scope="request" value="${!empty param.CMD and (param.CMD eq 'EDIT')}"/>
    <c:set var="form" scope="request" value="${requestScope['/cms/et/chetadtrecord/ChetadtrecordForm']}"/>

    <!--##################################添加标题内容##################################################-->
    <div class="table_div">
    <table class="top_table">
    	<tr>
    		<td>
    			<bean:message bundle="chetadtrecord" key="titleList"/>
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
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chetadtrecord" key="seq"/>:</div></td>
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
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chetadtrecord" key="srcseq"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                        <c:if test="${updateState}">
                            <html:text styleClass="form_input_1x" property="srcseq" readonly="true"/>
                        </c:if>
                        <c:if test="${!updateState}">
                            <html:text styleClass="form_input_1x" property="srcseq" />
                        </c:if>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="srcseq" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chetadtrecord" key="oid"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="oid" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="oid" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chetadtrecord" key="opnid"/>:</div></td>
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
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chetadtrecord" key="calcopnid"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="calcopnid" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="calcopnid" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chetadtrecord" key="calcmonth"/>:</div></td>
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
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chetadtrecord" key="wayid"/>:</div></td>
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
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chetadtrecord" key="oprcode"/>:</div></td>
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
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chetadtrecord" key="oprtime"/>:</div></td>
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
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chetadtrecord" key="mobile"/>:</div></td>
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
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chetadtrecord" key="subsbrand"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="subsbrand" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="subsbrand" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chetadtrecord" key="subsid"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="subsid" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="subsid" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chetadtrecord" key="brand"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="brand" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="brand" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chetadtrecord" key="busivalue"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="busivalue" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="busivalue" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chetadtrecord" key="yxplanid"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="yxplanid" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="yxplanid" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chetadtrecord" key="wrapfee"/>:</div></td>
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
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chetadtrecord" key="startdate"/>:</div></td>
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
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chetadtrecord" key="ruleid"/>:</div></td>
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
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chetadtrecord" key="ruleitemid"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="ruleitemid" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="ruleitemid" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chetadtrecord" key="rewardtype"/>:</div></td>
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
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chetadtrecord" key="rewardstd"/>:</div></td>
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
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chetadtrecord" key="noncyc"/>:</div></td>
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
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chetadtrecord" key="batchno"/>:</div></td>
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
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chetadtrecord" key="adtcode"/>:</div></td>
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
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chetadtrecord" key="adtremark"/>:</div></td>
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
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chetadtrecord" key="dsrc"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="dsrc" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="dsrc" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chetadtrecord" key="bakinfo"/>:</div></td>
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
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chetadtrecord" key="bakinfo2"/>:</div></td>
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
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chetadtrecord" key="bakinfo3"/>:</div></td>
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
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chetadtrecord" key="adtflag"/>:</div></td>
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
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chetadtrecord" key="createtime"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="createtime" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="createtime" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chetadtrecord" key="rewardid"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="rewardid" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="rewardid" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chetadtrecord" key="acctype"/>:</div></td>
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
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chetadtrecord" key="assegrade"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="assegrade" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="assegrade" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chetadtrecord" key="totalsum"/>:</div></td>
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
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chetadtrecord" key="paysum"/>:</div></td>
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
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chetadtrecord" key="paymonth1"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="paymonth1" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="paymonth1" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chetadtrecord" key="paymoney1"/>:</div></td>
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
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chetadtrecord" key="paymonth2"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="paymonth2" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="paymonth2" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chetadtrecord" key="paymoney2"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="paymoney2" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="paymoney2" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chetadtrecord" key="paymonth3"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="paymonth3" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="paymonth3" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chetadtrecord" key="paymoney3"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="paymoney3" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="paymoney3" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chetadtrecord" key="isbudget"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="isbudget" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="isbudget" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chetadtrecord" key="src"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="src" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="src" disabled="true"/>
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
                           onclick="doSave('/cms/et/chetadtrecord.do?CMD=SAVE')"/>
                    <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
                           name="btnPrint" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<bean:message bundle="public" key="button_print"/>" class="print" onclick="doPrint()">
                    <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
                           name="btnReturn" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<bean:message bundle="public" key="button_return"/>" class="close"
                           onclick="doReturn('/cms/et/chetadtrecord.do?CMD=LIST')">
                </td>
            </tr>
        </table>
    </div>
</html:form>
</div>
</body>
</html>
