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
    <title><bean:message bundle="chadtwayspecialreward" key="titleUpdate"/></title>
    <script language="JavaScript">
        function ev_checkval() {
            addfield('wayid', '<bean:message bundle="chadtwayspecialreward" key="wayid"/>', 'c', false, '18');
            addfield('wayspetype', '<bean:message bundle="chadtwayspecialreward" key="wayspetype"/>', 'c', false, '8');
            addfield('cityid', '<bean:message bundle="chadtwayspecialreward" key="cityid"/>', 'c', false, '3');
            addfield('createdate', '<bean:message bundle="chadtwayspecialreward" key="createdate"/>', 't', false, '7');

            return checkval(window);
        }
    </script>
</head>
<body>
<div class="table_container">
<html:form action="/cms/reward/chadtwayspecialreward.do?CMD=SAVE" styleId="formItem" method="post">
    <html:hidden property="cmdState"/>

    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <html:hidden property="_se_wayid"/>
    <html:hidden property="_se_wayspetype"/>
    <html:hidden property="_se_cityid"/>
    <html:hidden property="_dnm_createdate"/>
    <html:hidden property="_dnl_createdate"/>
    <c:set var="edtState" scope="request" value="${!empty param.CMD and (param.CMD eq 'EDIT' or param.CMD eq 'NEW')}"/>
    <c:set var="updateState" scope="request" value="${!empty param.CMD and (param.CMD eq 'EDIT')}"/>
	<c:set var="form" scope="request" value="${requestScope['/cms/reward/chadtwayspecialreward/ChAdtWayspecialrewardForm']}"/>

    

    <!--##################################添加标题内容##################################################-->
    <div class="table_div">
    <table class="top_table">
    	<tr>
    		<td>
    			<bean:message bundle="chadtwayspecialreward" key="titleList"/>
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
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chadtwayspecialreward" key="wayid"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                        <c:if test="${updateState}">
                            <html:text styleClass="form_input_1x" property="wayid" readonly="true"/>
                        </c:if>
                        <c:if test="${!updateState}">
                            <html:text styleClass="form_input_1x" property="wayid" />
                        </c:if>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="wayid" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                    <font color=red>&nbsp;*</font>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chadtwayspecialreward" key="wayspetype"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
<%--                            <html:text styleClass="form_input_1x" property="wayspetype" />--%>
                            <html:select property="wayspetype" >
								<option />
								<s:Options definition="$CH_WAYSPETYPE"></s:Options>
							</html:select>
                        </c:when>
                        <c:otherwise>
<%--                            <html:text styleClass="form_input_1x" property="wayspetype" disabled="true"/>--%>
                            <html:select property="wayspetype" disabled="true">
								<option />
								<s:Options definition="$CH_WAYSPETYPE"></s:Options>
							</html:select>
                        </c:otherwise>
                    </c:choose>
                    <font color=red>&nbsp;*</font>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chadtwayspecialreward" key="cityid"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
<%--                            <html:text styleClass="form_input_1x" property="cityid" disabled="true"/>--%>
                            <html:select property="cityid"  disabled="true">
								<option />
								<s:Options definition="#CITYNAME"></s:Options>
							</html:select>
                        </c:when>
                        <c:otherwise>
<%--                            <html:text styleClass="form_input_1x" property="cityid" disabled="true"/>--%>
                            <html:select property="cityid"  disabled="true">
								<option />
								<s:Options definition="#CITYNAME"></s:Options>
							</html:select>
                        </c:otherwise>
                    </c:choose>
                    <font color=red>&nbsp;*</font>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chadtwayspecialreward" key="createdate"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
<%--                            <html:text styleClass="form_input_1x" property="createdate" disabled="true"/>--%>
                            <input class="form_input_1x" name="createdate"	value="<fmt:formatDate value="${form.createdate}" pattern="yyyy-MM-dd"/>" disabled/>
                        </c:when>
                        <c:otherwise>
<%--                            <html:text styleClass="form_input_1x" property="createdate" disabled="true"/>--%>
                            <input class="form_input_1x" name="createdate"	value="<fmt:formatDate value="${form.createdate}" pattern="yyyy-MM-dd"/>" disabled/>
                        </c:otherwise>
                    </c:choose>
                    <font color=red>&nbsp;*</font>
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
                           onclick="doSave('/cms/reward/chadtwayspecialreward.do?CMD=SAVE')"/>
<%--                    <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"--%>
<%--                           name="btnPrint" onfocus="buttonover(this)" onblur="buttonout(this)"--%>
<%--                           value="<bean:message bundle="public" key="button_print"/>" class="print" onclick="doPrint()">--%>
                    <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
                           name="btnReturn" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<bean:message bundle="public" key="button_return"/>" class="close"
                           onclick="doReturn('/cms/reward/chadtwayspecialreward.do?CMD=LIST')">
                </td>
            </tr>
        </table>
    </div>
</html:form>
</div>
</body>
</html>
