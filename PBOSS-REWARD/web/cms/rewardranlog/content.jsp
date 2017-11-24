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
    <title><bean:message bundle="rewardranlog" key="titleUpdate"/></title>
    <script language="JavaScript">
        function ev_checkval() {
            addfield('paccount', '<bean:message bundle="rewardranlog" key="paccount"/>', 'c', false, '25');
            addfield('raccount', '<bean:message bundle="rewardranlog" key="raccount"/>', 'c', false, '25');
            addfield('remark', '<bean:message bundle="rewardranlog" key="remark"/>', 'f', false, '8','2');
            addfield('ptime', '<bean:message bundle="rewardranlog" key="ptime"/>', 'dt', true, '7');
            addfield('calcmonth', '<bean:message bundle="rewardranlog" key="calcmonth"/>', 'c', false, '6');
            addfield('memo', '<bean:message bundle="rewardranlog" key="memo"/>', 'c', true, '200');

            return checkval(window);
        }
    </script>
</head>
<body>
<div class="table_container">
<html:form action="/cms/rewardranlog.do?CMD=SAVE" styleId="formItem" method="post">
    <html:hidden property="cmdState"/>

    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <html:hidden property="_se_wayid"/>
    <html:hidden property="_se_paccount"/>
    <html:hidden property="_se_raccount"/>
    <html:hidden property="_se_calcmonth"/>
    <html:hidden property="_se_opercode"/>
    <html:hidden property="_se_opertype"/>
    <html:hidden property="seq"/>
    <c:set var="edtState" scope="request" value="${!empty param.CMD and (param.CMD eq 'EDIT' or param.CMD eq 'NEW')}"/>
    <c:set var="updateState" scope="request" value="${!empty param.CMD and (param.CMD eq 'EDIT')}"/>
    <c:set var="form" scope="request" value="${requestScope['/cms/rewardranlog/RewardranlogForm']}"/>

    <!--##################################添加标题内容##################################################-->
    <div class="table_div">
    <table class="top_table">
    	<tr>
    		<td>
    			<bean:message bundle="rewardranlog" key="titleList"/>
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
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="rewardranlog" key="wayid"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="wayid" disabled="true"/>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="wayid" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="rewardranlog" key="paccount"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="paccount" disabled="true"/>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="paccount" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                    <font color='red'>&nbsp;*</font>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="rewardranlog" key="raccount"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="raccount" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="raccount" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                    <font color='red'>&nbsp;*</font>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="rewardranlog" key="remark"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <input type="text" class="form_input_1x" name="remark" value="<fmt:formatNumber pattern="0.00" value="${form.remark}" />" />
                        </c:when>
                        <c:otherwise>
                            <input type="text" class="form_input_1x" name="remark" value="<fmt:formatNumber pattern="0.00" value="${form.remark}" />" readonly="readonly" />
                        </c:otherwise>
                    </c:choose>
                    <font color='red'>&nbsp;*</font>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="rewardranlog" key="ptime"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <input type="text" class="form_input_1x" name="ptime" value="<fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${form.ptime }"/>"  onclick="this.value=selectDatetime()"/>
                        </c:when>
                        <c:otherwise>
                            <input type="text" class="form_input_1x" name="ptime" value="<fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${form.ptime }"/>" readonly="readonly" />
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="rewardranlog" key="calcmonth"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="calcmonth" onclick="this.value=selectDateYYYYMM(this.value);"></html:text>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="calcmonth" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                    <font color='red'>&nbsp;*</font>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="rewardranlog" key="memo"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="memo" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="memo" disabled="true"/>
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
                           onclick="doSave('/cms/rewardranlog.do?CMD=SAVE')"/>
                    <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
                           name="btnReturn" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<bean:message bundle="public" key="button_return"/>" class="close"
                           onclick="doReturn('/cms/rewardranlog.do?CMD=LIST')">
                </td>
            </tr>
        </table>
    </div>
</html:form>
</div>
</body>
</html>
