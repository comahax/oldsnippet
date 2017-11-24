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
    <title><bean:message bundle="chzjtylocalzdsalereward" key="titleUpdate"/></title>
    <script language="JavaScript">
        function ev_checkval() {
            addfield('recid', '<bean:message bundle="chzjtylocalzdsalereward" key="recid"/>', 'f', false, '14');
            addfield('wayname', '<bean:message bundle="chzjtylocalzdsalereward" key="wayname"/>', 'c', false, '256');
            addfield('cityid', '<bean:message bundle="chzjtylocalzdsalereward" key="cityid"/>', 'c', false, '10');
            addfield('zjtyname', '<bean:message bundle="chzjtylocalzdsalereward" key="zjtyname"/>', 'c', false, '256');
            addfield('rewardreporttime', '<bean:message bundle="chzjtylocalzdsalereward" key="rewardreporttime"/>', 'c', false, '10');
            addfield('dzzdxlhyj', '<bean:message bundle="chzjtylocalzdsalereward" key="dzzdxlhyj"/>', 'f', false, '14');
            addfield('dzzdxllhy', '<bean:message bundle="chzjtylocalzdsalereward" key="dzzdxllhy"/>', 'f', false, '14');
            addfield('dzzdxllj', '<bean:message bundle="chzjtylocalzdsalereward" key="dzzdxllj"/>', 'f', false, '14');
            addfield('dzzdxlhj', '<bean:message bundle="chzjtylocalzdsalereward" key="dzzdxlhj"/>', 'f', false, '14');
            addfield('ysrgdzzdxlhyj', '<bean:message bundle="chzjtylocalzdsalereward" key="ysrgdzzdxlhyj"/>', 'f', false, '14');
            addfield('ysrgdzzdxllhy', '<bean:message bundle="chzjtylocalzdsalereward" key="ysrgdzzdxllhy"/>', 'f', false, '14');
            addfield('ysrgdzzdxllj', '<bean:message bundle="chzjtylocalzdsalereward" key="ysrgdzzdxllj"/>', 'f', false, '14');
            addfield('ysrgdzzdxlhj', '<bean:message bundle="chzjtylocalzdsalereward" key="ysrgdzzdxlhj"/>', 'f', false, '14');
            addfield('dzzdcjhyj', '<bean:message bundle="chzjtylocalzdsalereward" key="dzzdcjhyj"/>', 'f', false, '14');
            addfield('dzzdcjlhy', '<bean:message bundle="chzjtylocalzdsalereward" key="dzzdcjlhy"/>', 'f', false, '14');
            addfield('dzzdcjlj', '<bean:message bundle="chzjtylocalzdsalereward" key="dzzdcjlj"/>', 'f', false, '14');
            addfield('dzzdcjhj', '<bean:message bundle="chzjtylocalzdsalereward" key="dzzdcjhj"/>', 'f', false, '14');
            addfield('ysrgdzzdcjhyj', '<bean:message bundle="chzjtylocalzdsalereward" key="ysrgdzzdcjhyj"/>', 'f', false, '14');
            addfield('ysrgdzzdcjlhy', '<bean:message bundle="chzjtylocalzdsalereward" key="ysrgdzzdcjlhy"/>', 'f', false, '14');
            addfield('ysrgdzzdcjlj', '<bean:message bundle="chzjtylocalzdsalereward" key="ysrgdzzdcjlj"/>', 'f', false, '14');
            addfield('ysrgdzzdcjhj', '<bean:message bundle="chzjtylocalzdsalereward" key="ysrgdzzdcjhj"/>', 'f', false, '14');

            return checkval(window);
        }
    </script>
</head>
<body>
<div class="table_container">
<html:form action="/cms/zjty/chzjtylocalzdsalereward.do?CMD=SAVE" styleId="formItem" method="post">
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
    <c:set var="form" scope="request" value="${requestScope['/cms/zjty/chzjtylocalzdsalereward/ChzjtylocalzdsalerewardForm']}"/>

    <!--##################################添加标题内容##################################################-->
    <div class="table_div">
    <table class="top_table">
    	<tr>
    		<td>
    			<bean:message bundle="chzjtylocalzdsalereward" key="titleList"/>
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
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chzjtylocalzdsalereward" key="recid"/>:</div></td>
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
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chzjtylocalzdsalereward" key="wayname"/>:</div></td>
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
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chzjtylocalzdsalereward" key="cityid"/>:</div></td>
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
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chzjtylocalzdsalereward" key="zjtyname"/>:</div></td>
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
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chzjtylocalzdsalereward" key="rewardreporttime"/>:</div></td>
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
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chzjtylocalzdsalereward" key="dzzdxlhyj"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="dzzdxlhyj" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="dzzdxlhyj" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chzjtylocalzdsalereward" key="dzzdxllhy"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="dzzdxllhy" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="dzzdxllhy" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chzjtylocalzdsalereward" key="dzzdxllj"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="dzzdxllj" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="dzzdxllj" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chzjtylocalzdsalereward" key="dzzdxlhj"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="dzzdxlhj" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="dzzdxlhj" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chzjtylocalzdsalereward" key="ysrgdzzdxlhyj"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="ysrgdzzdxlhyj" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="ysrgdzzdxlhyj" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chzjtylocalzdsalereward" key="ysrgdzzdxllhy"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="ysrgdzzdxllhy" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="ysrgdzzdxllhy" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chzjtylocalzdsalereward" key="ysrgdzzdxllj"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="ysrgdzzdxllj" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="ysrgdzzdxllj" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chzjtylocalzdsalereward" key="ysrgdzzdxlhj"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="ysrgdzzdxlhj" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="ysrgdzzdxlhj" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chzjtylocalzdsalereward" key="dzzdcjhyj"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="dzzdcjhyj" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="dzzdcjhyj" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chzjtylocalzdsalereward" key="dzzdcjlhy"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="dzzdcjlhy" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="dzzdcjlhy" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chzjtylocalzdsalereward" key="dzzdcjlj"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="dzzdcjlj" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="dzzdcjlj" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chzjtylocalzdsalereward" key="dzzdcjhj"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="dzzdcjhj" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="dzzdcjhj" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chzjtylocalzdsalereward" key="ysrgdzzdcjhyj"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="ysrgdzzdcjhyj" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="ysrgdzzdcjhyj" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chzjtylocalzdsalereward" key="ysrgdzzdcjlhy"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="ysrgdzzdcjlhy" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="ysrgdzzdcjlhy" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chzjtylocalzdsalereward" key="ysrgdzzdcjlj"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="ysrgdzzdcjlj" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="ysrgdzzdcjlj" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chzjtylocalzdsalereward" key="ysrgdzzdcjhj"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="ysrgdzzdcjhj" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="ysrgdzzdcjhj" disabled="true"/>
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
                           onclick="doSave('/cms/zjty/chzjtylocalzdsalereward.do?CMD=SAVE')"/>
                    <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
                           name="btnPrint" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<bean:message bundle="public" key="button_print"/>" class="print" onclick="doPrint()">
                    <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
                           name="btnReturn" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<bean:message bundle="public" key="button_return"/>" class="close"
                           onclick="doReturn('/cms/zjty/chzjtylocalzdsalereward.do?CMD=LIST')">
                </td>
            </tr>
        </table>
    </div>
</html:form>
</div>
</body>
</html>
