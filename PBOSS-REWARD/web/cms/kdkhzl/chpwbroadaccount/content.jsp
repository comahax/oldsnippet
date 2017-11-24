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
    <title><bean:message bundle="chpwbroadaccount" key="titleUpdate"/></title>
    <script language="JavaScript">
        function ev_checkval() {
            //addfield('broadid', '<bean:message bundle="chpwbroadaccount" key="broadid"/>', 'f', false, '14');
            //addfield('account', '<bean:message bundle="chpwbroadaccount" key="account"/>', 'c', false, '12');

            return checkval(window);
        }
    </script>
</head>
<body>
<div class="table_container">
<html:form action="/cms/kdkhzl/chpwbroadaccount.do?CMD=SAVE" styleId="formItem" method="post">
    <html:hidden property="cmdState"/>

    
    <c:set var="edtState" scope="request" value="${!empty param.CMD and (param.CMD eq 'EDIT' or param.CMD eq 'NEW')}"/>
    <c:set var="updateState" scope="request" value="${!empty param.CMD and (param.CMD eq 'EDIT')}"/>
    <c:set var="form" scope="request" value="${requestScope['/cms/kdkhzl/chpwregisterbroad/ChpwregisterbroadForm']}"/>

    <!--##################################添加标题内容##################################################-->
    <div class="table_div">
    <table class="top_table">
    	<tr>
    		<td>
    			<bean:message bundle="chpwbroadaccount" key="titleList"/>
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
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chpwbroadaccount" key="broadid"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <html:text styleClass="form_input_1x" property="broadid" disabled="true"/>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chpwbroadaccount" key="telephone"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <html:text styleClass="form_input_1x" property="telephone" disabled="true"/>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chpwbroadaccount" key="account"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <html:text styleClass="form_input_1x" property="account" />
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
                           onclick="doSave('/cms/kdkhzl/chpwbroadaccount.do?CMD=SAVE')"/>
                   
                    <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
                           name="btnReturn" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<bean:message bundle="public" key="button_return"/>" class="close"
                           onclick="doReturn('/cms/kdkhzl/chpwbroadaccount.do?CMD=LIST')">
                </td>
            </tr>
        </table>
    </div>
</html:form>
</div>
</body>
</html>
