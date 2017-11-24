<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/contenthead.inc"%>
<%
    String ID_1 = "CH_EMPLOYEE";
%>
<html>
<head>
    <title><bean:message bundle="emprole" key="titleUpdate"/></title>
    <script language="JavaScript">
        function ev_checkval() {
            addfield('employeeid', '<bean:message bundle="emprole" key="employeeid"/>', 'c', false, '15');
            addfield('ekey', '<bean:message bundle="emprole" key="ekey"/>', 'c', false, '64');

            return checkval(window);
        }
    </script>
</head>
<body>
<div class="table_container">
<html:form action="/cms/emprole.do?CMD=SAVE" styleId="formItem" method="post">
    <html:hidden property="cmdState"/>

    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <html:hidden property="_se_employeeid"/>
    <c:set var="edtState" scope="request" value="${!empty param.CMD and (param.CMD eq 'EDIT' or param.CMD eq 'NEW' or requestScope.cmdState eq 'EDIT')}"/>
    <c:set var="updateState" scope="request" value="${!empty param.CMD and (param.CMD eq 'EDIT')}"/>
    <c:set var="form" scope="request" value="${requestScope['/cms/emprole/EmproleForm']}"/>

    <!--##################################添加标题内容##################################################-->
    <div class="table_div">
    <table class="top_table">
    	<tr>
    		<td>
    			<bean:message bundle="emprole" key="titleList"/>
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
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="emprole" key="employeeid"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                        <c:if test="${updateState}">
                            <html:text styleClass="form_input_1x" property="employeeid" readonly="true"/>
                        </c:if>
                        <c:if test="${!updateState}">
                            <s:zoom definition="#CH_EMPLOYEE" property="employeeid" styleClass="form_input_1x" readonly="false" />
                        </c:if>
                        </c:when>
                        <c:otherwise>
                            <s:zoom definition="#CH_EMPLOYEE" property="employeeid" styleClass="form_input_1x" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="emprole" key="ekey"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                        <c:if test="${updateState}">
                              <html:select property="ekey" disabled="true">
		                    	<s:Options definition="$CH_EMPFLAG" />
		                   	 </html:select>
                        </c:if>
                        <c:if test="${!updateState}">
                            <html:select property="ekey">
		                    	<s:Options definition="$CH_EMPFLAG" />
		                   	 </html:select>
                        </c:if>
                        </c:when>
                        <c:otherwise>
                            <html:select property="ekey" disabled="true">
		                    	<s:Options definition="$CH_EMPFLAG" />
		                   	 </html:select>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <html:hidden property="evalue" />
        </table>
    </div>

    <div class="table_div">
        <table class="table_button_list">
            <tr>
                <td width="100%" class="form_table_center">
                    <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
                           name="btnSave" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<bean:message bundle="public" key="button_save"/>" class="submit"
                           onclick="doSave('/cms/emprole.do?CMD=SAVE')"/>
                    <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
                           name="btnReturn" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<bean:message bundle="public" key="button_return"/>" class="close"
                           onclick="doReturn('/cms/emprole.do?CMD=LIST')">
                </td>
            </tr>
        </table>
    </div>
</html:form>
</div>
</body>
</html>
