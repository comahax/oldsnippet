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
    <title><bean:message bundle="chzjtylocaljjrewardtotal" key="titleUpdate"/></title>
    <script language="JavaScript">
        function ev_checkval() {
            addfield('recid', '<bean:message bundle="chzjtylocaljjrewardtotal" key="recid"/>', 'f', false, '14');
            addfield('cityid', '<bean:message bundle="chzjtylocaljjrewardtotal" key="cityid"/>', 'c', false, '10');
            addfield('wayname', '<bean:message bundle="chzjtylocaljjrewardtotal" key="wayname"/>', 'c', false, '256');
            addfield('qqtxzfhcj', '<bean:message bundle="chzjtylocaljjrewardtotal" key="qqtxzfhcj"/>', 'f', false, '14');
            addfield('yffzqqtcj', '<bean:message bundle="chzjtylocaljjrewardtotal" key="yffzqqtcj"/>', 'f', false, '14');
            addfield('dgddtkxscj', '<bean:message bundle="chzjtylocaljjrewardtotal" key="dgddtkxscj"/>', 'f', false, '14');
            addfield('szxtkxscj', '<bean:message bundle="chzjtylocaljjrewardtotal" key="szxtkxscj"/>', 'f', false, '14');
            addfield('czywcj', '<bean:message bundle="chzjtylocaljjrewardtotal" key="czywcj"/>', 'f', false, '14');
            addfield('dzzdcj', '<bean:message bundle="chzjtylocaljjrewardtotal" key="dzzdcj"/>', 'f', false, '14');
            addfield('zhywcj', '<bean:message bundle="chzjtylocaljjrewardtotal" key="zhywcj"/>', 'f', false, '14');
            addfield('zzywcj', '<bean:message bundle="chzjtylocaljjrewardtotal" key="zzywcj"/>', 'f', false, '14');
            addfield('dgddwlk', '<bean:message bundle="chzjtylocaljjrewardtotal" key="dgddwlk"/>', 'f', false, '14');
            addfield('jtkdkhcj', '<bean:message bundle="chzjtylocaljjrewardtotal" key="jtkdkhcj"/>', 'f', false, '14');
            addfield('sjywcj', '<bean:message bundle="chzjtylocaljjrewardtotal" key="sjywcj"/>', 'f', false, '14');
            addfield('jtywcj', '<bean:message bundle="chzjtylocaljjrewardtotal" key="jtywcj"/>', 'f', false, '14');
            addfield('dsgsyxzd', '<bean:message bundle="chzjtylocaljjrewardtotal" key="dsgsyxzd"/>', 'f', false, '14');
            addfield('qqtffcjkj', '<bean:message bundle="chzjtylocaljjrewardtotal" key="qqtffcjkj"/>', 'f', false, '14');
            addfield('total', '<bean:message bundle="chzjtylocaljjrewardtotal" key="total"/>', 'f', false, '14');
            addfield('rewardreporttime', '<bean:message bundle="chzjtylocaljjrewardtotal" key="rewardreporttime"/>', 'c', false, '10');

            return checkval(window);
        }
    </script>
</head>
<body>
<div class="table_container">
<html:form action="/cms/zjty/chzjtylocaljjrewardtotal.do?CMD=SAVE" styleId="formItem" method="post">
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
    <c:set var="form" scope="request" value="${requestScope['/cms/zjty/chzjtylocaljjrewardtotal/ChzjtylocaljjrewardtotalForm']}"/>

    <!--##################################添加标题内容##################################################-->
    <div class="table_div">
    <table class="top_table">
    	<tr>
    		<td>
    			<bean:message bundle="chzjtylocaljjrewardtotal" key="titleList"/>
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
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chzjtylocaljjrewardtotal" key="recid"/>:</div></td>
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
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chzjtylocaljjrewardtotal" key="cityid"/>:</div></td>
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
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chzjtylocaljjrewardtotal" key="wayname"/>:</div></td>
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
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chzjtylocaljjrewardtotal" key="qqtxzfhcj"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="qqtxzfhcj" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="qqtxzfhcj" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chzjtylocaljjrewardtotal" key="yffzqqtcj"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="yffzqqtcj" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="yffzqqtcj" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chzjtylocaljjrewardtotal" key="dgddtkxscj"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="dgddtkxscj" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="dgddtkxscj" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chzjtylocaljjrewardtotal" key="szxtkxscj"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="szxtkxscj" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="szxtkxscj" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chzjtylocaljjrewardtotal" key="czywcj"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="czywcj" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="czywcj" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chzjtylocaljjrewardtotal" key="dzzdcj"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="dzzdcj" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="dzzdcj" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chzjtylocaljjrewardtotal" key="zhywcj"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="zhywcj" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="zhywcj" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chzjtylocaljjrewardtotal" key="zzywcj"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="zzywcj" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="zzywcj" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chzjtylocaljjrewardtotal" key="dgddwlk"/>:</div></td>
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
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chzjtylocaljjrewardtotal" key="jtkdkhcj"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="jtkdkhcj" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="jtkdkhcj" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chzjtylocaljjrewardtotal" key="sjywcj"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="sjywcj" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="sjywcj" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chzjtylocaljjrewardtotal" key="jtywcj"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="jtywcj" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="jtywcj" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chzjtylocaljjrewardtotal" key="dsgsyxzd"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="dsgsyxzd" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="dsgsyxzd" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chzjtylocaljjrewardtotal" key="qqtffcjkj"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="qqtffcjkj" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="qqtffcjkj" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chzjtylocaljjrewardtotal" key="total"/>:</div></td>
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
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chzjtylocaljjrewardtotal" key="rewardreporttime"/>:</div></td>
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
                           onclick="doSave('/cms/zjty/chzjtylocaljjrewardtotal.do?CMD=SAVE')"/>
                    <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
                           name="btnPrint" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<bean:message bundle="public" key="button_print"/>" class="print" onclick="doPrint()">
                    <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
                           name="btnReturn" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<bean:message bundle="public" key="button_return"/>" class="close"
                           onclick="doReturn('/cms/zjty/chzjtylocaljjrewardtotal.do?CMD=LIST')">
                </td>
            </tr>
        </table>
    </div>
</html:form>
</div>
</body>
</html>
