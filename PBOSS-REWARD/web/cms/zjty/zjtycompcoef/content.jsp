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
    <title><bean:message bundle="zjtycompcoef" key="titleUpdate"/></title>
    <script language="JavaScript">
        function ev_checkval() {
            addfield('wayid', '<bean:message bundle="zjtycompcoef" key="wayid"/>', 'c', false, 32);
            addfield('compcoef', '<bean:message bundle="zjtycompcoef" key="compcoef"/>', 'f', false, 1,2);

            return checkval(window);
        }
    </script>
</head>
<body>
<div class="table_container">
<html:form action="/cms/zjty/zjtycompcoef.do?CMD=SAVE" styleId="formItem" method="post">
    <html:hidden property="cmdState"/>

    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <c:set var="edtState" scope="request" value="${!empty param.CMD and (param.CMD eq 'EDIT' or param.CMD eq 'NEW')}"/>
    <c:set var="updateState" scope="request" value="${!empty param.CMD and (param.CMD eq 'EDIT')}"/>
    <c:set var="form" scope="request" value="${requestScope['/cms/zjty/zjtycompcoef/ZjtycompcoefForm']}"/>

    <!--##################################添加标题内容##################################################-->
    <div class="table_div">
    <table class="top_table">
    	<tr>
    		<td>
    			<bean:message bundle="zjtycompcoef" key="titleList"/>
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
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="zjtycompcoef" key="wayid"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                        <c:if test="${updateState}">
                            <html:text styleClass="form_input_1x" property="wayid" readonly="true"/>
                        </c:if>
                        <c:if test="${!updateState}">
                            <s:zoom definition="#WAY" property="wayid"
											styleClass="form_input_1x" condition="waytype:${'AG'};waysubtype:${'DIS'};upperwayid:${'DIS-----'}"/>
							<font color="red">*</font>
                        </c:if>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="wayid" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="zjtycompcoef" key="compcoef"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="compcoef" />
                            <font color="red">*</font>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="compcoef" disabled="true"/>
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
                	<c:choose>
                        <c:when test="${edtState}">
                    			<input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
                           		name="btnSave" onfocus="buttonover(this)" onblur="buttonout(this)"
                           		value="<bean:message bundle="public" key="button_save"/>" class="submit"
                           		onclick="doSave('/cms/zjty/zjtycompcoef.do?CMD=SAVE')"/>
                        </c:when>
                        <c:otherwise>
                        	<input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
                           		name="btnSave" onfocus="buttonover(this)" onblur="buttonout(this)"
                           		value="<bean:message bundle="public" key="button_save"/>" class="submit"
                           		onclick="doSave('/cms/zjty/zjtycompcoef.do?CMD=SAVE')" disabled="true"/>
                           	</c:otherwise>
                     </c:choose>
                    		<input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
                           	name="btnReturn" onfocus="buttonover(this)" onblur="buttonout(this)"
                           	value="<bean:message bundle="public" key="button_return"/>" class="close"
                           	onclick="doReturn('/cms/zjty/zjtycompcoef.do?CMD=LIST')">
                </td>
            </tr>
        </table>
    </div>
</html:form>
</div>
</body>
</html>
