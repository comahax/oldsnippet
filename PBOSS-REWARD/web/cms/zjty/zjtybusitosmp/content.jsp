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
    <title><bean:message bundle="zjtybusitosmp" key="titleUpdate"/></title>
    <script type="text/javascript" src="<%=contextPath%>/js/bus/rescommon.js"></script>
    <script language="JavaScript">
        function ev_checkval() {
            addfield('opnid', '<bean:message bundle="zjtybusitosmp" key="opnid"/>', 'c', false, '18');
            addfield('comid', '<bean:message bundle="zjtybusitosmp" key="comid"/>', 'f', false, '18');
            addfield('sort', '<bean:message bundle="zjtybusitosmp" key="sort"/>', 'c', false, '16');
            return checkval(window);
        }
    </script>
</head>
<body>
<div class="table_container">
<html:form action="/cms/zjty/zjtybusitosmp.do?CMD=SAVE" styleId="formItem" method="post">
    <html:hidden property="cmdState"/>

    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <c:set var="edtState" scope="request" value="${!empty param.CMD and (param.CMD eq 'EDIT' or param.CMD eq 'NEW')}"/>
    <c:set var="updateState" scope="request" value="${!empty param.CMD and (param.CMD eq 'EDIT')}"/>
    <c:set var="form" scope="request" value="${requestScope['/cms/zjty/zjtybusitosmp/ZjtyBusitosmpForm']}"/>

    <!--##################################添加标题内容##################################################-->
    <div class="table_div">
    <table class="top_table">
    	<tr>
    		<td>
    			<bean:message bundle="zjtybusitosmp" key="titleList"/>
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
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="zjtybusitosmp" key="opnid"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                        <c:if test="${updateState}">
                            <html:text styleClass="form_input_1x" property="opnid" readonly="true"/>
                        </c:if>
                        <c:if test="${!updateState}">
           					<s:myzoom definition="#ZJTY_OPERATION" property="opnid" condition="opnid:65*,;isbusi:1;" styleClass="form_input_1x" readonly="ture"/>
           					<font color="red">*</font>
                        </c:if>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="opnid" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="zjtybusitosmp" key="comid"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                        <c:if test="${updateState}">
                            <html:text styleClass="form_input_1x" property="comid" readonly="true"/>
                        </c:if>
                        <c:if test="${!updateState}">
           					<s:myzoom definition="#COMSYSTEM" property="comid" condition="cityid:${cityid},GD;" styleClass="form_input_1x" readonly="ture"/>
           					<font color="red">*</font>
                        </c:if>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="comid" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="zjtybusitosmp" key="sort"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                        <c:if test="${updateState}">
                        	<html:select property="sort">
										<html:option value=""></html:option>
										<s:Options definition="$ZJTY_BUSITOSMPTYPE" />
							</html:select>
<!--                            <html:text styleClass="form_input_1x" property="sort" readonly="true"/>-->
                        </c:if>
                        <c:if test="${!updateState}">
                        	<html:select property="sort">
										<html:option value=""></html:option>
										<s:Options definition="$ZJTY_BUSITOSMPTYPE" />
							</html:select>
<!--           					<s:myzoom definition="$ZJTY_BUSITOSMPTYPE" property="sort" styleClass="form_input_1x" readonly="ture"/>-->
           					<font color="red">*</font>
                        </c:if>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="sort" disabled="true"/>
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
                           onclick="doSave('/cms/zjty/zjtybusitosmp.do?CMD=SAVE')"/>
                    <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
                           name="btnReturn" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<bean:message bundle="public" key="button_return"/>" class="close"
                           onclick="doReturn('/cms/zjty/zjtybusitosmp.do?CMD=LIST')">
                </td>
            </tr>
        </table>
    </div>
    
</html:form>
</div>
</body>
</html>
