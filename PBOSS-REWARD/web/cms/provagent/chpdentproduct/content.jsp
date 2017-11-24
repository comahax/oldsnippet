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
    <title><bean:message bundle="chpdentproduct" key="titleUpdate"/></title>
    <script language="JavaScript">
        function ev_checkval() {
            addfield('prodid', '<bean:message bundle="chpdentproduct" key="prodid"/>', 'c', false, '15');
            addfield('prodname', '<bean:message bundle="chpdentproduct" key="prodname"/>', 'c', false, '30');
            addfield('category', '<bean:message bundle="chpdentproduct" key="category"/>', 'c', false, '16');
            addfield('subcategory', '<bean:message bundle="chpdentproduct" key="subcategory"/>', 'c', false, '16');

            return checkval(window);
        }
    </script>
</head>
<body>
<div class="table_container">
<html:form action="/cms/provagent/chpdentproduct.do?CMD=SAVE" styleId="formItem" method="post">
    <html:hidden property="cmdState"/>

    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <html:hidden property="_se_prodid"/>
    <html:hidden property="_sk_prodname"/>
    <html:hidden property="_se_category"/>
    <html:hidden property="_se_subcategory"/>
    <c:set var="edtState" scope="request" value="${!empty param.CMD and (param.CMD eq 'EDIT' or param.CMD eq 'NEW')}"/>
    <c:set var="updateState" scope="request" value="${!empty param.CMD and (param.CMD eq 'EDIT')}"/>
    <c:set var="form" scope="request" value="${requestScope['/cms/provagent/chpdentproduct/ChPdEntproductForm']}"/>

    <!--##################################添加标题内容##################################################-->
    <div class="table_div">
    <table class="top_table">
    	<tr>
    		<td>
    			<bean:message bundle="chpdentproduct" key="titleList"/>
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
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chpdentproduct" key="prodid"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                        <c:if test="${updateState}">
                            <html:text styleClass="form_input_1x" property="prodid" readonly="true"/>
                        </c:if>
                        <c:if test="${!updateState}">
                            <html:text styleClass="form_input_1x" property="prodid" />
                        </c:if>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="prodid" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                    <font color=red>&nbsp;*</font>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chpdentproduct" key="prodname"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="prodname" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="prodname" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                    <font color=red>&nbsp;*</font>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chpdentproduct" key="category"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
<%--                            <html:text styleClass="form_input_1x" property="category" />--%>
                            <html:select property="category">
                            	<option />
                        		<s:Options definition="$PD_JTCPLX"/>
                    		</html:select>
                        </c:when>
                        <c:otherwise>
<%--                            <html:text styleClass="form_input_1x" property="category" disabled="true"/>--%>
                            <html:select property="category" disabled="true">
                            	<option />
                        		<s:Options definition="$PD_JTCPLX"/>
                    		</html:select>
                        </c:otherwise>
                    </c:choose>
                    <font color=red>&nbsp;*</font>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chpdentproduct" key="subcategory"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
<%--                            <html:text styleClass="form_input_1x" property="subcategory" />--%>
                            <html:select property="subcategory">
                            	<option />
                        		<s:Options definition="$PD_JTCPZLX"/>
                    		</html:select>
                        </c:when>
                        <c:otherwise>
<%--                            <html:text styleClass="form_input_1x" property="subcategory" disabled="true"/>--%>
                            <html:select property="subcategory" disabled="true">
                            	<option />
                        		<s:Options definition="$PD_JTCPZLX"/>
                    		</html:select>
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
                           onclick="doSave('/cms/provagent/chpdentproduct.do?CMD=SAVE')"/>
                    <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
                           name="btnPrint" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<bean:message bundle="public" key="button_print"/>" class="print" onclick="doPrint()">
                    <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
                           name="btnReturn" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<bean:message bundle="public" key="button_return"/>" class="close"
                           onclick="doReturn('/cms/provagent/chpdentproduct.do?CMD=LIST')">
                </td>
            </tr>
        </table>
    </div>
</html:form>
</div>
</body>
</html>
