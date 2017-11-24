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
    <title><bean:message bundle="chadtwaymod" key="titleUpdate"/></title>
    <script type="text/javascript" src="<%=contextPath%>/js/bus/waycommon.js"></script>
    <script language="JavaScript">
        function ev_checkval() {
            addfield('wayid', '<bean:message bundle="chadtwaymod" key="wayid"/>', 'c', false, '18');
            addfield('vi', '<bean:message bundle="chadtwaymod" key="vi"/>', 'f', true, '3', '2', '0', 0, 0.6);
            addfield('area', '<bean:message bundle="chadtwaymod" key="area"/>', 'f', true, '3', '2', '0', 0, 0.6);
            addfield('doorhead', '<bean:message bundle="chadtwaymod" key="doorhead"/>', 'f', true, '3', '2', '0', 0, 0.2);
            addfield('backboard', '<bean:message bundle="chadtwaymod" key="backboard"/>', 'f', true, '3', '2', '0', 0, 0.1);
            addfield('propaganda', '<bean:message bundle="chadtwaymod" key="propaganda"/>', 'f', true, '3', '2', '0', 0, 0.1);

            return checkval(window);
        }
    </script>
</head>
<body>
<div class="table_container">
<html:form action="/cms/chadtwaymod.do?CMD=SAVE" styleId="formItem" method="post">
    <html:hidden property="cmdState"/>

    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <html:hidden property="_se_wayid"/>
    <c:set var="edtState" scope="request" value="${!empty param.CMD and (param.CMD eq 'EDIT' or param.CMD eq 'NEW')}"/>
    <c:set var="updateState" scope="request" value="${!empty param.CMD and (param.CMD eq 'EDIT')}"/>
    <c:set var="form" scope="request" value="${requestScope['/cms/chadtwaymod/ChadtwaymodForm']}"/>

    <!--##################################添加标题内容##################################################-->
    <div class="table_div">
    <table class="top_table">
    	<tr>
    		<td>
    			<bean:message bundle="chadtwaymod" key="titleList"/>
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
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chadtwaymod" key="wayid"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                        <c:if test="${updateState}">
                            <html:text styleClass="form_input_1x" property="wayid" readonly="true"/>
                            <font color=red>&nbsp;*</font>
                        </c:if>
                        <c:if test="${!updateState}">
                            <html:text styleClass="form_input_1x" property="wayid" readonly="true"/><input type="button" value="..." 
                    			class="clickbutton" onclick="showSelectWay3(this,'wayid','','','AG');this.value='...';" />
                    			<font color=red>&nbsp;*</font>
                        </c:if>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="wayid" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chadtwaymod" key="vi"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="vi" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="vi" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chadtwaymod" key="area"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="area" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="area" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chadtwaymod" key="doorhead"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="doorhead" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="doorhead" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chadtwaymod" key="backboard"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="backboard" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="backboard" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chadtwaymod" key="propaganda"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="propaganda" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="propaganda" disabled="true"/>
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
	                           onclick="doSave('/cms/chadtwaymod.do?CMD=SAVE')"/>
                        </c:when>
                        <c:otherwise>
                            <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
	                           name="btnSave" onfocus="buttonover(this)" onblur="buttonout(this)"
	                           value="<bean:message bundle="public" key="button_save"/>" class="submit"
	                           onclick="doSave('/cms/chadtwaymod.do?CMD=SAVE')" disabled="disabled"/>
                        </c:otherwise>
                    </c:choose>
                    <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
                           name="btnReturn" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<bean:message bundle="public" key="button_return"/>" class="close"
                           onclick="doReturn('/cms/chadtwaymod.do?CMD=LIST')">
                </td>
            </tr>
        </table>
    </div>
</html:form>
</div>
</body>
</html>
