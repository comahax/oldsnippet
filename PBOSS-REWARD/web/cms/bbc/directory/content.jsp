<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/contenthead.inc"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<html>
<head>
    <title><bean:message bundle="directory" key="titleUpdate"/></title>
    <script language="JavaScript">
        function ev_checkval() {
            addfield('opnid', '<bean:message bundle="directory" key="opnid"/>', 'c', false, '16');
            addfield('firstlevel', '<bean:message bundle="directory" key="firstlevel"/>', 'c', false, '32');
            addfield('secondlevel', '<bean:message bundle="directory" key="secondlevel"/>', 'c', false, '32');
            addfield('thirdlevel', '<bean:message bundle="directory" key="thirdlevel"/>', 'c', false, '32');
            addfield('name', '<bean:message bundle="directory" key="name"/>', 'c', false, '64');
            addfield('servicecode', '<bean:message bundle="directory" key="servicecode"/>', 'c', false, '3');
            addfield('reward', '<bean:message bundle="directory" key="reward"/>', 'c', false, '32');
            addfield('rewardstd', '<bean:message bundle="directory" key="rewardstd"/>', 'f', false, '3', '2');
            addfield('rule', '<bean:message bundle="directory" key="rule"/>', 'c', false, '1024');

            return checkval(window);
        }
        
        function getOpnId() {
			var arg = new Array();
			var strUrl ="<%=contextPath%>/cms/bbc/operation.do?CMD=SELECT";
			return window.showModalDialog(strUrl, arg, "dialogWidth:600px; dialogHeight:390px; status:no;resizable:yes;");
		}
    </script>
</head>
<body>
<div class="table_container">
<html:form action="/cms/bbc/directory.do?CMD=SAVE" styleId="formItem" method="post">
    <html:hidden property="cmdState"/>

    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <html:hidden property="_se_opnid"/>
    <html:hidden property="_se_firstlevel"/>
    <html:hidden property="_se_secondlevel"/>
    <html:hidden property="_se_thirdlevel"/>
    <c:set var="edtState" scope="request" value="${!empty param.CMD and (param.CMD eq 'EDIT' or param.CMD eq 'NEW')}"/>
    <c:set var="updateState" scope="request" value="${!empty param.CMD and (param.CMD eq 'EDIT')}"/>
    <c:set var="form" scope="request" value="${requestScope['/cms/bbc/directory/DirectoryForm']}"/>

    <!--##################################添加标题内容##################################################-->
    <div class="table_div">
    <table class="top_table">
    	<tr>
    		<td>
    			<bean:message bundle="directory" key="titleList"/>
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
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="directory" key="opnid"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                        <c:if test="${updateState}">
                            <html:text styleClass="form_input_1x" property="opnid" readonly="true"/>
                            <font color="red">*</font>
                        </c:if>
                        <c:if test="${!updateState}">
                        	<html:text property="opnid" styleClass="form_input_1x"/>
                    		<input type="button" value="..." class="clickbutton" onclick="opnid.value=getOpnId();">
                            <font color="red">*</font>
                        </c:if>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="opnid" disabled="true"/>
                            <font color="red">*</font>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="directory" key="firstlevel"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="firstlevel" />
                            <font color="red">*</font>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="firstlevel" disabled="true"/>
                            <font color="red">*</font>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="directory" key="secondlevel"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="secondlevel" />
                            <font color="red">*</font>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="secondlevel" disabled="true"/>
                            <font color="red">*</font>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="directory" key="thirdlevel"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="thirdlevel" />
                            <font color="red">*</font>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="thirdlevel" disabled="true"/>
                            <font color="red">*</font>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="directory" key="servicecode"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="servicecode" />
                            <font color="red">*</font>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="servicecode" disabled="true"/>
                            <font color="red">*</font>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="directory" key="reward"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="reward" />
                            <font color="red">*</font>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="reward" disabled="true"/>
                            <font color="red">*</font>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="directory" key="rewardstd"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="rewardstd" />
                            <font color="red">*</font>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="rewardstd" disabled="true"/>
                            <font color="red">*</font>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="directory" key="rule"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:textarea property="rule" rows="5" cols="50"></html:textarea>
                            <font color="red">*</font>
                        </c:when>
                        <c:otherwise>
                            <html:textarea property="rule" rows="5" cols="50" disabled="true"></html:textarea>
                            <font color="red">*</font>
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
						onclick="doSave('/cms/bbc/directory.do?CMD=SAVE')"
						<c:choose><c:when test="${!edtState}"> disabled="disabled" </c:when></c:choose>/>
                    <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
						name="btnReturn" onfocus="buttonover(this)" onblur="buttonout(this)"
						value="<bean:message bundle="public" key="button_return"/>" class="close"
						onclick="doReturn('/cms/bbc/directory.do?CMD=LIST')">
                </td>
            </tr>
        </table>
    </div>
</html:form>
</div>
</body>
</html>
