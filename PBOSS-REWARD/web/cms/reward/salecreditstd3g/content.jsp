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
    <title><bean:message bundle="salecreditstd3g" key="titleUpdate"/></title>
    <script language="JavaScript">
        function ev_checkval() {
            addfield('cityid', '<bean:message bundle="salecreditstd3g" key="cityid"/>', 'f', true, '3');
            addfield('busitype', '<bean:message bundle="salecreditstd3g" key="busitype"/>', 'f', false, '38');
            addfield('creditstd', '<bean:message bundle="salecreditstd3g" key="creditstd"/>', 'f', false, '8','2',null,'0');

            return checkval(window);
        }
    </script>
</head>
<body>
<div class="table_container">
<html:form action="/cms/reward/salecreditstd3g.do?CMD=SAVE" styleId="formItem" method="post">
    <html:hidden property="cmdState"/>

    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <html:hidden property="_ne_busitype"/>    
    <c:choose>
        <c:when test="${edtState}">
        <c:if test="${updateState}">
            <html:hidden property="cityid"/>
        </c:if>
        <c:if test="${!updateState}">            
            <input type="hidden" id="cityid" name="cityid" value="${sessionScope._USER.cityid}">
        </c:if>
        </c:when>
        <c:otherwise>
            <html:hidden property="cityid"/>                
        </c:otherwise>
    </c:choose>
    <c:set var="edtState" scope="request" value="${!empty param.CMD and (param.CMD eq 'EDIT' or param.CMD eq 'NEW')}"/>
    <c:set var="updateState" scope="request" value="${!empty param.CMD and (param.CMD eq 'EDIT')}"/>
    <c:set var="form" scope="request" value="${requestScope['/cms/reward/salecreditstd3g/Salecreditstd3gForm']}"/>

    <!--##################################添加标题内容##################################################-->
    <div class="table_div">
    <table class="top_table">
    	<tr>
    		<td>
    			<bean:message bundle="salecreditstd3g" key="titleList"/>
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
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="salecreditstd3g" key="busitype"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                        <c:if test="${updateState}">
                            <s:Code2Name code="${form.busitype}" definition="$CH_CREDIT_ACCOUNT" />
                            <html:hidden property="busitype"/>
                        </c:if>
                        <c:if test="${!updateState}">
                            <html:select property="busitype">
		                    	<option />
		                    	<s:Options definition="$CH_CREDIT_ACCOUNT" />
		                    </html:select>
                        </c:if>
                        </c:when>
                        <c:otherwise>
                            <html:select property="busitype" disabled="true">
		                    	<option />
		                    	<s:Options definition="$CH_CREDIT_ACCOUNT" />
		                    </html:select>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="salecreditstd3g" key="creditstd"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="creditstd" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="creditstd" disabled="true"/>
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
                           onclick="doSave('/cms/reward/salecreditstd3g.do?CMD=SAVE')"/>                    
                    <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
                           name="btnReturn" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<bean:message bundle="public" key="button_return"/>" class="close"
                           onclick="doReturn('/cms/reward/salecreditstd3g.do?CMD=LIST')">
                </td>
            </tr>
        </table>
    </div>
</html:form>
</div>
</body>
</html>
