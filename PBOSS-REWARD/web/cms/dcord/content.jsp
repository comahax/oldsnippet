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
    <title><bean:message bundle="dcord" key="titleUpdate"/></title>
    <script language="JavaScript">
        function ev_checkval() {
            addfield('id', '<bean:message bundle="dcord" key="id"/>', 'f', false, '14');
            addfield('countyid', '<bean:message bundle="dcord" key="countyid"/>', 'c', false, '14');
            addfield('wayid', '<bean:message bundle="dcord" key="wayid"/>', 'c', false, '18');
            addfield('opnid', '<bean:message bundle="dcord" key="opnid"/>', 'c', false, '18');
            addfield('upperopnid', '<bean:message bundle="dcord" key="upperopnid"/>', 'c', false, '18');
            addfield('subopnid', '<bean:message bundle="dcord" key="subopnid"/>', 'c', false, '18');
            addfield('oprmonth', '<bean:message bundle="dcord" key="oprmonth"/>', 'c', false, '6');
            addfield('rewardtype', '<bean:message bundle="dcord" key="rewardtype"/>', 'f', false, '3');
            addfield('rewardmonth', '<bean:message bundle="dcord" key="rewardmonth"/>', 'c', false, '6');
            addfield('gotonebusivalue', '<bean:message bundle="dcord" key="gotonebusivalue"/>', 'f', false, '10');
            addfield('gotonemoney', '<bean:message bundle="dcord" key="gotonemoney"/>', 'f', false, '16');
            addfield('szxbusivalue', '<bean:message bundle="dcord" key="szxbusivalue"/>', 'f', false, '10');
            addfield('szxmoney', '<bean:message bundle="dcord" key="szxmoney"/>', 'f', false, '16');
            addfield('mzonebusivalue', '<bean:message bundle="dcord" key="mzonebusivalue"/>', 'f', false, '10');
            addfield('mzonemoney', '<bean:message bundle="dcord" key="mzonemoney"/>', 'f', false, '16');
            addfield('tdbusivalue', '<bean:message bundle="dcord" key="tdbusivalue"/>', 'f', false, '10');
            addfield('tdmoney', '<bean:message bundle="dcord" key="tdmoney"/>', 'f', false, '16');
            addfield('otherbusivalue', '<bean:message bundle="dcord" key="otherbusivalue"/>', 'f', false, '10');
            addfield('othermoney', '<bean:message bundle="dcord" key="othermoney"/>', 'f', false, '16');
            addfield('busivaluesum', '<bean:message bundle="dcord" key="busivaluesum"/>', 'f', false, '10');
            addfield('moneysum', '<bean:message bundle="dcord" key="moneysum"/>', 'f', false, '16');
            addfield('isflag', '<bean:message bundle="dcord" key="isflag"/>', 'f', false, '3');
            addfield('adjustoprcode', '<bean:message bundle="dcord" key="adjustoprcode"/>', 'c', false, '15');
            addfield('adjustoptime', '<bean:message bundle="dcord" key="adjustoptime"/>', 't', false, '7');
            addfield('paymentoprcode', '<bean:message bundle="dcord" key="paymentoprcode"/>', 'c', false, '15');
            addfield('paymentoptime', '<bean:message bundle="dcord" key="paymentoptime"/>', 't', false, '7');
            addfield('batchno', '<bean:message bundle="dcord" key="batchno"/>', 'c', false, '18');

            return checkval(window);
        }
    </script>
</head>
<body>
<div class="table_container">
<html:form action="/cms/dcord.do?CMD=SAVE" styleId="formItem" method="post">
    <html:hidden property="cmdState"/>

    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <html:hidden property="_se_countyid"/>
    <html:hidden property="_se_wayid"/>
    <html:hidden property="_sin_opnid"/>
    <html:hidden property="_se_upperopnid"/>
    <html:hidden property="_se_subopnid"/>
    <html:hidden property="_se_oprmonth"/>
    <html:hidden property="_ne_rewardtype"/>
    <html:hidden property="_se_rewardmonth"/>
    <c:set var="edtState" scope="request" value="${!empty param.CMD and (param.CMD eq 'EDIT' or param.CMD eq 'NEW')}"/>
    <c:set var="updateState" scope="request" value="${!empty param.CMD and (param.CMD eq 'EDIT')}"/>
    <c:set var="form" scope="request" value="${requestScope['/cms/dcord/DcordForm']}"/>

    <!--##################################添加标题内容##################################################-->
    <div class="table_div">
    <table class="top_table">
    	<tr>
    		<td>
    			<bean:message bundle="dcord" key="titleList"/>
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
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="dcord" key="id"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                        <c:if test="${updateState}">
                            <html:text styleClass="form_input_1x" property="id" readonly="true"/>
                        </c:if>
                        <c:if test="${!updateState}">
                            <html:text styleClass="form_input_1x" property="id" />
                        </c:if>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="id" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="dcord" key="countyid"/>:</div></td>
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
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="dcord" key="wayid"/>:</div></td>
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
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="dcord" key="opnid"/>:</div></td>
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
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="dcord" key="upperopnid"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="upperopnid" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="upperopnid" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="dcord" key="subopnid"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="subopnid" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="subopnid" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="dcord" key="oprmonth"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="oprmonth" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="oprmonth" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="dcord" key="rewardtype"/>:</div></td>
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
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="dcord" key="rewardmonth"/>:</div></td>
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
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="dcord" key="gotonebusivalue"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="gotonebusivalue" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="gotonebusivalue" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="dcord" key="gotonemoney"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="gotonemoney" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="gotonemoney" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="dcord" key="szxbusivalue"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="szxbusivalue" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="szxbusivalue" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="dcord" key="szxmoney"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="szxmoney" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="szxmoney" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="dcord" key="mzonebusivalue"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="mzonebusivalue" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="mzonebusivalue" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="dcord" key="mzonemoney"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="mzonemoney" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="mzonemoney" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="dcord" key="tdbusivalue"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="tdbusivalue" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="tdbusivalue" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="dcord" key="tdmoney"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="tdmoney" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="tdmoney" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="dcord" key="otherbusivalue"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="otherbusivalue" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="otherbusivalue" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="dcord" key="othermoney"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="othermoney" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="othermoney" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="dcord" key="busivaluesum"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="busivaluesum" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="busivaluesum" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="dcord" key="moneysum"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="moneysum" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="moneysum" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="dcord" key="isflag"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="isflag" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="isflag" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="dcord" key="adjustoprcode"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="adjustoprcode" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="adjustoprcode" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="dcord" key="adjustoptime"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="adjustoptime" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="adjustoptime" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="dcord" key="paymentoprcode"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="paymentoprcode" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="paymentoprcode" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="dcord" key="paymentoptime"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="paymentoptime" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="paymentoptime" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="dcord" key="batchno"/>:</div></td>
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
        </table>
    </div>

    <div class="table_div">
        <table class="table_button_list">
            <tr>
                <td width="100%" class="form_table_center">
                    <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
                           name="btnSave" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<bean:message bundle="public" key="button_save"/>" class="submit"
                           onclick="doSave('/cms/dcord.do?CMD=SAVE')"/>
                    <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
                           name="btnPrint" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<bean:message bundle="public" key="button_print"/>" class="print" onclick="doPrint()">
                    <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
                           name="btnReturn" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<bean:message bundle="public" key="button_return"/>" class="close"
                           onclick="doReturn('/cms/dcord.do?CMD=LIST')">
                </td>
            </tr>
        </table>
    </div>
</html:form>
</div>
</body>
</html>
