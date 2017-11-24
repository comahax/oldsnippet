<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/contenthead.inc"%>
<%
    String ID_1 = "00010701";
    String ID_2 = "00010702";
    String ID_3 = "00010703";
    String ID_4 = "00010704";
    String cityid = request.getParameter("cityid");
%>
<html>
<head>
    <title><bean:message bundle="zjtybusyxplan" key="titleUpdate"/></title>
    <script language="JavaScript">
        function ev_checkval() {
            addfield('prodid', '<bean:message bundle="zjtybusyxplan" key="prodid"/>', 'c', false, '32');
            addfield('opnid', '<bean:message bundle="zjtybusyxplan" key="opnid"/>', 'c', false, '18');
            addfield('planbusitype', '<bean:message bundle="zjtybusyxplan" key="planbusitype"/>', 'c', false, '32');
            addfield('wrapfee', '<bean:message bundle="zjtybusyxplan" key="wrapfee"/>', 'f', true, 10, 2);
            return checkval(window);
        }
    </script>
</head>
<body>
<div class="table_container">
<html:form action="/cms/zjty/zjtybusyxplan.do?CMD=SAVE" styleId="formItem" method="post">
    <html:hidden property="cmdState"/>

    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <c:set var="edtState" scope="request" value="${!empty param.CMD and (param.CMD eq 'EDIT' or param.CMD eq 'NEW')}"/>
    <c:set var="updateState" scope="request" value="${!empty param.CMD and (param.CMD eq 'EDIT')}"/>
    <c:set var="form" scope="request" value="${requestScope['/cms/zjty/zjtybusyxplan/ZjtybusyxplanForm']}"/>

    <!--##################################添加标题内容##################################################-->
    <div class="table_div">
    <table class="top_table">
    	<tr>
    		<td>
    			<bean:message bundle="zjtybusyxplan" key="titleList"/>
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
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="zjtybusyxplan" key="prodid"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                        <c:if test="${updateState}">
                            <html:text styleClass="form_input_1x" property="prodid" readonly="true"/>
                        </c:if>
                        <c:if test="${!updateState}">
                        	<html:text styleClass="form_input_1x" property="prodid"/>
                        </c:if>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="prodid" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                    <font color="red">*</font>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="zjtybusyxplan" key="opnid"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                        <c:if test="${updateState}">
                            <html:text styleClass="form_input_1x" property="opnid" readonly="true"/>
                        </c:if>
                        <c:if test="${!updateState}">
                        	<s:myzoom definition="#ZJTY_OPERATION" property="opnid" condition="opnid:6501010300001*,6501010300003*;isbusi:1;" styleClass="form_input_1x"/>
                        </c:if>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="opnid" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                    <font color="red">*</font>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="zjtybusyxplan" key="planbusitype"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                        <c:if test="${updateState}">
                        	<html:select property="planbusitype">
										<html:option value=""></html:option>
										<s:Options definition="$ZJTY_BUSYXPLANTYPE" />
							</html:select>
<!--                            <html:text styleClass="form_input_1x" property="planbusitype" readonly="true"/>-->
                        </c:if>
                        <c:if test="${!updateState}">
                        	<html:select property="planbusitype">
										<html:option value=""></html:option>
										<s:Options definition="$ZJTY_BUSYXPLANTYPE" />
							</html:select>
<!--                        	<s:myzoom definition="$ZJTY_BUSYXPLANTYPE" property="planbusitype" styleClass="form_input_1x"/>-->
                        </c:if>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="planbusitype" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                    <font color="red">*</font>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="zjtybusyxplan" key="wrapfee"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="wrapfee"/>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="wrapfee" disabled="true"/>
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
                           onclick="doSave('/cms/zjty/zjtybusyxplan.do?CMD=SAVE')"/>
                    <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
                           name="btnReturn" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<bean:message bundle="public" key="button_return"/>" class="close"
                           onclick="doReturn('/cms/zjty/zjtybusyxplan.do?CMD=LIST')">
                </td>
            </tr>
        </table>
    </div>
</html:form>
</div>
</body>
</html>
