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
    <title><bean:message bundle="chadtclassplatformbrandinfo" key="titleUpdate"/></title>
    <script language="JavaScript">
        function ev_checkval() {
            //addfield('brandid', '<bean:message bundle="chadtclassplatformbrandinfo" key="brandid"/>', 'f', false, '14');
            addfield('brandname', '<bean:message bundle="chadtclassplatformbrandinfo" key="brandname"/>', 'c', false, '128');
            addfield('state', '<bean:message bundle="chadtclassplatformbrandinfo" key="state"/>', 'f', false, '2');
            addfield('adtremark', '<bean:message bundle="chadtclassplatformbrandinfo" key="adtremark"/>', 'c', true, '256');

            return checkval(window);
        }
    </script>
</head>
<body>
<div class="table_container">
<html:form action="/cms/chadtclassplatformbrandinfo.do?CMD=SAVE" styleId="formItem" method="post">
    <html:hidden property="cmdState"/>

    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <c:set var="edtState" scope="request" value="${!empty param.CMD and (param.CMD eq 'EDIT' or param.CMD eq 'NEW')}"/>
    <c:set var="updateState" scope="request" value="${!empty param.CMD and (param.CMD eq 'EDIT')}"/>
    <c:set var="form" scope="request" value="${requestScope['/cms/chadtclassplatformbrandinfo/ChadtclassplatformbrandinfoForm']}"/>

    <!--##################################添加标题内容##################################################-->
    <div class="table_div">
    <table class="top_table">
    	<tr>
    		<td>
    			<bean:message bundle="chadtclassplatformbrandinfo" key="titleList"/>
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
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chadtclassplatformbrandinfo" key="brandid"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                       <html:text styleClass="form_input_1x" property="brandid" readonly="true"/>&nbsp;自动生成
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chadtclassplatformbrandinfo" key="brandname"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="brandname" />
                            
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="brandname" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                    <font color=red>&nbsp;*</font>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chadtclassplatformbrandinfo" key="state"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                        <html:select property="state">
                        		<option />
                        		<s:Options  definition="#CLASSPLATFORMBRANDINFO_STATE"/>
                        	</html:select>
                        </c:when>
                        <c:otherwise>
                         <html:select property="state"  disabled="true">
                        		<option />
                        		<s:Options  definition="#CLASSPLATFORMBRANDINFO_STATE"/>
                        	</html:select>
                        </c:otherwise>
                    </c:choose>
                    <font color=red>&nbsp;*</font>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chadtclassplatformbrandinfo" key="adtremark"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="adtremark" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="adtremark" disabled="true"/>
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
                           onclick="doSave('/cms/chadtclassplatformbrandinfo.do?CMD=SAVE')"/>
                    <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
                           name="btnReturn" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<bean:message bundle="public" key="button_return"/>" class="close"
                           onclick="doReturn('/cms/chadtclassplatformbrandinfo.do?CMD=LIST')">
                </td>
            </tr>
        </table>
    </div>
</html:form>
</div>
</body>
</html>
