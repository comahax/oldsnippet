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
    <title><bean:message bundle="tax" key="titleUpdate"/></title>
    <script language="JavaScript">
        function ev_checkval() {
            //addfield('seq', '<bean:message bundle="tax" key="seq"/>', 'f', false, '14');
            //addfield('cityid', '<bean:message bundle="tax" key="cityid"/>', 'f', false, '3');
            addfield('taxtype', '<bean:message bundle="tax" key="taxtype"/>', 'f', false, '3');
            addfield('parameter', '<bean:message bundle="tax" key="parameter"/>', 'c', false, '30');
            addfield('value', '<bean:message bundle="tax" key="value"/>', 'f', false, '3');
            addfield('value2', '<bean:message bundle="tax" key="value"/>', 'i', false, '3');

            return checkval(window);
        }
    </script>
</head>
<body>
<div class="table_container">
<html:form action="/cms/reward/tax.do?CMD=SAVE" styleId="formItem" method="post">
    <html:hidden property="cmdState"/>

    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <html:hidden property="_ne_cityid"/>
    <html:hidden property="_ne_taxtype"/>
    <html:hidden property="_se_parameter"/>
    <html:hidden property="seq"/>
    <html:hidden property="cityid"/>
    <c:set var="edtState" scope="request" value="${!empty param.CMD and (param.CMD eq 'EDIT' or param.CMD eq 'NEW')}"/>
    <c:set var="updateState" scope="request" value="${!empty param.CMD and (param.CMD eq 'EDIT')}"/>
    <c:set var="form" scope="request" value="${requestScope['/cms/reward/tax/TaxForm']}"/>

    <!--##################################添加标题内容##################################################-->
    <div class="table_div">
    <table class="top_table">
    	<tr>
    		<td>
    			<bean:message bundle="tax" key="titleList"/>
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
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="tax" key="taxtype"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <!-- <html:text styleClass="form_input_1x" property="taxtype" /> -->
                            <html:select property="taxtype">
								<html:option value=""></html:option>
								<s:Options definition="$CH_ADT_TAX" />
							</html:select>
                        </c:when>
                        <c:otherwise>
                            <html:select property="taxtype" disabled="true">
								<html:option value=""></html:option>
								<s:Options definition="$CH_ADT_TAX" />
							</html:select>
                        </c:otherwise>
                    </c:choose>
                    <font color='red'>*</font>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="tax" key="parameter"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <!-- <html:text styleClass="form_input_1x" property="parameter" /> -->
                            <html:select property="parameter">
		                    	<option />
		                    	<s:Options definition="#CNTYCOMPANY" condition="citycompid:${requestScope.cityid}"/>
		                    </html:select>
                        </c:when>
                        <c:otherwise>
                            <html:select property="parameter" disabled="true">
		                    	<option />
		                    	<s:Options definition="#CNTYCOMPANY" condition="citycompid:${requestScope.cityid}"/>
		                    </html:select>
                        </c:otherwise>
                    </c:choose>
                    <font color='red'>*</font>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="tax" key="value"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="value2" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="value2" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                    %
                    <font color='red'>*</font>
                    (以100%格式添加)
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
                           onclick="doSave('/cms/reward/tax.do?CMD=SAVE')"/>
                    <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
                           name="btnReturn" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<bean:message bundle="public" key="button_return"/>" class="close"
                           onclick="doReturn('/cms/reward/tax.do?CMD=LIST')">
                </td>
            </tr>
        </table>
    </div>
</html:form>
</div>
</body>
</html>
