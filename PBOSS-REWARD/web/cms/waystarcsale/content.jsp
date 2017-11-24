<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@page import="com.sunrise.boss.ui.commons.User"%>
<%@page import="com.sunrise.boss.ui.commons.WebConstant"%>
<%@ include file="/inc/contenthead.inc"%>
<%
    User user = (User) session.getAttribute(WebConstant.SESSION_ATTRIBUTE_USER);
%>
<html>
<head>
    <title><bean:message bundle="waystarcsale" key="titleUpdate"/></title>
    <script language="JavaScript">
        function ev_checkval() {
            addfield('slv', '<bean:message bundle="waystarcsale" key="slv"/>', 'f', false, '3');
            addfield('busivalue', '<bean:message bundle="waystarcsale" key="busivalue"/>', 'i', false, '14','','','0');
            return checkval(window);
        }
    </script>
</head>
<body>
<div class="table_container">
<html:form action="/cms/waystarcsale.do?CMD=SAVE" styleId="formItem" method="post">
    <html:hidden property="cmdState"/>

    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    
    <html:hidden property="cityid" value="<%=user.getCityid()%>" />
    <html:hidden property="busitype" value="CARDSALE"/>
    
    <c:set var="edtState" scope="request" value="${!empty param.CMD and (param.CMD eq 'EDIT' or param.CMD eq 'NEW')}"/>
    <c:set var="updateState" scope="request" value="${!empty param.CMD and (param.CMD eq 'EDIT')}"/>
    <c:set var="form" scope="request" value="${requestScope['/cms/waystarcsale/WaystarcsaleForm']}"/>

    <!--##################################添加标题内容##################################################-->
    <div class="table_div">
    <table class="top_table">
    	<tr>
    		<td>
    			<bean:message bundle="waystarcsale" key="titleList"/>
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
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="waystarcsale" key="slv"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                        <c:if test="${updateState}">
							<html:select property="slv" disabled="true">
		           			<option />
		           				<s:Options definition="$CH_STARLEVEL" />
		           			</html:select>                        
                        </c:if>
                        <c:if test="${!updateState}">
                        	<html:select property="slv" >
		           			<option />
		           				<s:Options definition="$CH_STARLEVEL" />
		           			</html:select>             
                        </c:if>
                        </c:when>
                        <c:otherwise>
                        	<html:select property="slv" disabled="true">
		           			<option />
		           				<s:Options definition="$CH_STARLEVEL" />
		           			</html:select>               
                        </c:otherwise>
                    </c:choose>
                    <font color="red">*</font>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="waystarcsale" key="busivalue"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="busivalue" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="busivalue" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                    <font color="red">*</font>
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
                           onclick="doSave('/cms/waystarcsale.do?CMD=SAVE')"/>
                    <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
                           name="btnReturn" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<bean:message bundle="public" key="button_return"/>" class="close"
                           onclick="doReturn('/cms/waystarcsale.do?CMD=LIST')">
                </td>
            </tr>
        </table>
    </div>
</html:form>
</div>
</body>
</html>
