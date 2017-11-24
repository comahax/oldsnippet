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
    <title><bean:message bundle="chzjtylocalrewardbusiness" key="titleUpdate"/></title>
    <script language="JavaScript">
        function ev_checkval() {
            addfield('recid', '<bean:message bundle="chzjtylocalrewardbusiness" key="recid"/>', 'f', false, '14');
            addfield('wayname', '<bean:message bundle="chzjtylocalrewardbusiness" key="wayname"/>', 'c', false, '256');
            addfield('companytype', '<bean:message bundle="chzjtylocalrewardbusiness" key="companytype"/>', 'c', false, '256');
            addfield('cityid', '<bean:message bundle="chzjtylocalrewardbusiness" key="cityid"/>', 'c', false, '10');
            addfield('zjtyname', '<bean:message bundle="chzjtylocalrewardbusiness" key="zjtyname"/>', 'c', false, '256');
            addfield('qqtxzfh', '<bean:message bundle="chzjtylocalrewardbusiness" key="qqtxzfh"/>', 'f', false, '14');
            addfield('yffzqqt', '<bean:message bundle="chzjtylocalrewardbusiness" key="yffzqqt"/>', 'f', false, '14');
            addfield('dgddtkxs', '<bean:message bundle="chzjtylocalrewardbusiness" key="dgddtkxs"/>', 'f', false, '14');
            addfield('szxtkxs', '<bean:message bundle="chzjtylocalrewardbusiness" key="szxtkxs"/>', 'f', false, '14');
            addfield('czyw', '<bean:message bundle="chzjtylocalrewardbusiness" key="czyw"/>', 'f', false, '14');
            addfield('dzzd', '<bean:message bundle="chzjtylocalrewardbusiness" key="dzzd"/>', 'f', false, '14');
            addfield('zhyw', '<bean:message bundle="chzjtylocalrewardbusiness" key="zhyw"/>', 'f', false, '14');
            addfield('zzyw', '<bean:message bundle="chzjtylocalrewardbusiness" key="zzyw"/>', 'f', false, '14');
            addfield('dgddwlk', '<bean:message bundle="chzjtylocalrewardbusiness" key="dgddwlk"/>', 'f', false, '14');
            addfield('jtkdkh', '<bean:message bundle="chzjtylocalrewardbusiness" key="jtkdkh"/>', 'f', false, '14');
            addfield('sjyw', '<bean:message bundle="chzjtylocalrewardbusiness" key="sjyw"/>', 'f', false, '14');
            addfield('jtyw', '<bean:message bundle="chzjtylocalrewardbusiness" key="jtyw"/>', 'f', false, '14');
            addfield('dsgsyxzdlyw', '<bean:message bundle="chzjtylocalrewardbusiness" key="dsgsyxzdlyw"/>', 'f', false, '14');
            addfield('total', '<bean:message bundle="chzjtylocalrewardbusiness" key="total"/>', 'f', false, '14');
            addfield('rewardreporttime', '<bean:message bundle="chzjtylocalrewardbusiness" key="rewardreporttime"/>', 'c', false, '10');

            return checkval(window);
        }
    </script>
</head>
<body>
<div class="table_container">
<html:form action="/cms/zjty/chzjtylocalrewardbusiness.do?CMD=SAVE" styleId="formItem" method="post">
    <html:hidden property="cmdState"/>

    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <html:hidden property="_ne_recid"/>
    <html:hidden property="_se_cityid"/>
    <html:hidden property="_se_rewardreporttime"/>
    <c:set var="edtState" scope="request" value="${!empty param.CMD and (param.CMD eq 'EDIT' or param.CMD eq 'NEW')}"/>
    <c:set var="updateState" scope="request" value="${!empty param.CMD and (param.CMD eq 'EDIT')}"/>
    <c:set var="form" scope="request" value="${requestScope['/cms/zjty/chzjtylocalrewardbusiness/ChzjtylocalrewardbusinessForm']}"/>

    <!--##################################添加标题内容##################################################-->
    <div class="table_div">
    <table class="top_table">
    	<tr>
    		<td>
    			<bean:message bundle="chzjtylocalrewardbusiness" key="titleList"/>
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
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chzjtylocalrewardbusiness" key="recid"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                        <c:if test="${updateState}">
                            <html:text styleClass="form_input_1x" property="recid" readonly="true"/>
                        </c:if>
                        <c:if test="${!updateState}">
                            <html:text styleClass="form_input_1x" property="recid" />
                        </c:if>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="recid" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chzjtylocalrewardbusiness" key="wayname"/>:</div></td>
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
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chzjtylocalrewardbusiness" key="companytype"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="companytype" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="companytype" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chzjtylocalrewardbusiness" key="cityid"/>:</div></td>
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
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chzjtylocalrewardbusiness" key="zjtyname"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="zjtyname" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="zjtyname" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chzjtylocalrewardbusiness" key="qqtxzfh"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="qqtxzfh" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="qqtxzfh" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chzjtylocalrewardbusiness" key="yffzqqt"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="yffzqqt" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="yffzqqt" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chzjtylocalrewardbusiness" key="dgddtkxs"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="dgddtkxs" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="dgddtkxs" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chzjtylocalrewardbusiness" key="szxtkxs"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="szxtkxs" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="szxtkxs" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chzjtylocalrewardbusiness" key="czyw"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="czyw" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="czyw" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chzjtylocalrewardbusiness" key="dzzd"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="dzzd" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="dzzd" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chzjtylocalrewardbusiness" key="zhyw"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="zhyw" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="zhyw" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chzjtylocalrewardbusiness" key="zzyw"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="zzyw" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="zzyw" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chzjtylocalrewardbusiness" key="dgddwlk"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="dgddwlk" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="dgddwlk" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chzjtylocalrewardbusiness" key="jtkdkh"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="jtkdkh" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="jtkdkh" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chzjtylocalrewardbusiness" key="sjyw"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="sjyw" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="sjyw" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chzjtylocalrewardbusiness" key="jtyw"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="jtyw" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="jtyw" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chzjtylocalrewardbusiness" key="dsgsyxzdlyw"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="dsgsyxzdlyw" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="dsgsyxzdlyw" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chzjtylocalrewardbusiness" key="total"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="total" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="total" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chzjtylocalrewardbusiness" key="rewardreporttime"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="rewardreporttime" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="rewardreporttime" disabled="true"/>
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
                           onclick="doSave('/cms/zjty/chzjtylocalrewardbusiness.do?CMD=SAVE')"/>
                    <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
                           name="btnPrint" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<bean:message bundle="public" key="button_print"/>" class="print" onclick="doPrint()">
                    <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
                           name="btnReturn" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<bean:message bundle="public" key="button_return"/>" class="close"
                           onclick="doReturn('/cms/zjty/chzjtylocalrewardbusiness.do?CMD=LIST')">
                </td>
            </tr>
        </table>
    </div>
</html:form>
</div>
</body>
</html>
