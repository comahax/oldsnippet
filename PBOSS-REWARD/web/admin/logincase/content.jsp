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
    <title><bean:message bundle="logincase" key="titleUpdate"/></title>
    <script language="JavaScript">
        function ev_checkval() {
            addfield('module', '<bean:message bundle="logincase" key="module"/>', 'c', false, '6');
            addfield('operid', '<bean:message bundle="logincase" key="operid"/>', 'c', false, '18');
            addfield('wayid', '<bean:message bundle="logincase" key="wayid"/>', 'c', false, '18');
            addfield('cityid', '<bean:message bundle="logincase" key="cityid"/>', 'c', false, '14');
            addfield('createtime', '<bean:message bundle="logincase" key="createtime"/>', 't', true, '25');
            addfield('roleid', '<bean:message bundle="logincase" key="roleid"/>', 'c', true, '18');

            return checkval(window);
        }
    </script>
</head>
<body>
<div class="table_container">
<html:form action="/admin/logincase.do?CMD=SAVE" styleId="formItem" method="post">
    <html:hidden property="cmdState"/>

    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <html:hidden property="_se_module"/>
    <html:hidden property="_sk_operid"/>
    <html:hidden property="_sk_wayid"/>
    <html:hidden property="_se_cityid"/>
    <html:hidden property="_se_roleid"/>
    <c:set var="edtState" scope="request" value="${!empty param.CMD and (param.CMD eq 'EDIT' or param.CMD eq 'NEW')}"/>
    <c:set var="updateState" scope="request" value="${!empty param.CMD and (param.CMD eq 'EDIT')}"/>

    <!--##################################添加标题内容##################################################-->
    <div class="table_div">
    <table class="top_table">
    	<tr>
    		<td>
    			<bean:message bundle="logincase" key="titleList"/>
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
                 <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="logincase" key="module"/>:</div></td>
                <td width="75%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                        <c:if test="${updateState}">
                            <html:text styleClass="form_input_1x" property="module" maxlength="6" readonly="true"/>
                        </c:if>
                        <c:if test="${!updateState}">
                            <html:text styleClass="form_input_1x" property="module" maxlength="6"/>
                        </c:if>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="module" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                 <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="logincase" key="operid"/>:</div></td>
                <td width="75%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                        <c:if test="${updateState}">
                            <html:text styleClass="form_input_1x" property="operid" maxlength="18" readonly="true"/>
                        </c:if>
                        <c:if test="${!updateState}">
                            <html:text styleClass="form_input_1x" property="operid" maxlength="18"/>
                        </c:if>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="operid" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                 <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="logincase" key="wayid"/>:</div></td>
                <td width="75%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                        <c:if test="${updateState}">
                            <html:text styleClass="form_input_1x" property="wayid" maxlength="18" readonly="true"/>
                        </c:if>
                        <c:if test="${!updateState}">
                            <html:text styleClass="form_input_1x" property="wayid" maxlength="18"/>
                        </c:if>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="wayid" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                 <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="logincase" key="cityid"/>:</div></td>
                <td width="75%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                        <c:if test="${updateState}">
                            <html:text styleClass="form_input_1x" property="cityid" maxlength="14" readonly="true"/>
                        </c:if>
                        <c:if test="${!updateState}">
                            <html:text styleClass="form_input_1x" property="cityid" maxlength="14"/>
                        </c:if>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="cityid" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                 <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="logincase" key="createtime"/>:</div></td>
                <td width="75%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="createtime" maxlength="25"/>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="createtime" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                 <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="logincase" key="roleid"/>:</div></td>
                <td width="75%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="roleid" maxlength="18"/>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="roleid" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
        </table>
    </div>

    <div class="table_div">
        <table class="table_button_list">
            <tr>
                <td>
            	  <s:PurChk controlid="<%=ID_1%>">
                    <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
                           name="btnSave" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<bean:message bundle="public" key="button_save"/>" class="submit"
                           onclick="doSave('/admin/logincase.do?CMD=SAVE')"/>
                  </s:PurChk>
                 <s:PurChk controlid="<%=ID_2%>">
                    <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
                           name="btnPrint" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<bean:message bundle="public" key="button_print"/>" class="print" onclick="doPrint()">
                 </s:PurChk>
                    <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
                           name="btnReturn" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<bean:message bundle="public" key="button_return"/>" class="close"
                           onclick="doReturn('/admin/logincase.do?CMD=LIST')">
                </td>
            </tr>
        </table>
    </div>
</html:form>
</div>
</body>
</html>
