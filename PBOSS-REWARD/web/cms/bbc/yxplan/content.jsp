<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/contenthead.inc"%>
<%
	String ID_1 = "CH_B2M_REWARD||CH_B2M_REWARD_PROVINCIAL";
%>
<html>
<head>
    <title><bean:message bundle="yxplanbbc" key="titleUpdate"/></title>
    <script language="JavaScript">
        function ev_checkval() {
            addfield('opnid', '<bean:message bundle="yxplanbbc" key="opnid"/>', 'c', false, '18');
            addfield('yxplanid', '<bean:message bundle="yxplanbbc" key="yxplanid"/>', 'f', false, '14');
            addfield('wrapfee', '<bean:message bundle="yxplanbbc" key="wrapfee"/>', 'f', false, '10','2');
            return checkval(window);
        }
         function getOpnId() {
			var arg = new Array();
			var strUrl ="<%=contextPath%>/cms/bbc/operation.do?CMD=SELECT";
			return window.showModalDialog(strUrl,arg,"dialogWidth:600px; dialogHeight:390px; status:no;resizable:yes;");
		}
		 function selectYxplan(){
			var arg = new Array();
			var strUrl ="<%=contextPath%>/zifee/yxplan.do?CMD=SELECT";
			var returnValue= window.showModalDialog(strUrl,arg,"dialogWidth:600px; dialogHeight:390px; status:no;resizable:yes;");
			return returnValue;
		 }
    </script>
</head>
<body>
<div class="table_container">
<html:form action="/cms/bbc/yxplan.do?CMD=SAVE" styleId="formItem" method="post">
    <html:hidden property="cmdState"/>

    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <c:set var="edtState" scope="request" value="${!empty param.CMD and (param.CMD eq 'EDIT' or param.CMD eq 'NEW')}"/>
    <c:set var="updateState" scope="request" value="${!empty param.CMD and (param.CMD eq 'EDIT')}"/>
    <c:set var="form" scope="request" value="${requestScope['/cms/bbc/yxplanbbcForm']}"/>

    <!--##################################添加标题内容##################################################-->
    <div class="table_div">
    <table class="top_table">
    	<tr>
    		<td>
    			<bean:message bundle="yxplanbbc" key="titleList"/>
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
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="yxplanbbc" key="opnid"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
							<c:if test="${updateState}">
								 <html:text styleClass="form_input_1x" property="opnid" readonly="true" maxlength="18"/>
								 <font color=red>&nbsp;*</font>
							</c:if>
							<c:if test="${!updateState}">
								 <html:text styleClass="form_input_1x" property="opnid" readonly="true" maxlength="18"/>
								 <font color=red>&nbsp;*</font>
                            	 <input type="button" value="..." class="clickbutton" onclick="opnid.value=getOpnId();">
							</c:if>
						</c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="opnid" disabled="true"/>
                            <font color=red>&nbsp;*</font>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="yxplanbbc" key="yxplanid"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
							<c:if test="${updateState}">
								 <html:text styleClass="form_input_1x" property="yxplanid" readonly="true" maxlength="18"/>
								 <font color=red>&nbsp;*</font>
							</c:if>
							<c:if test="${!updateState}">
								 <html:text styleClass="form_input_1x" property="yxplanid" readonly="true"  maxlength="18"/>
								 <font color=red>&nbsp;*</font>
								 <input type="button" value="..." class="clickbutton"
								onclick="yxplanid.value=selectYxplan()">
							</c:if>
						</c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="yxplanid" disabled="true"/>
                            <font color=red>&nbsp;*</font>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="yxplanbbc" key="wrapfee"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                         <c:when test="${edtState}">
							<c:if test="${updateState}">
								 <html:text styleClass="form_input_1x" property="wrapfee" readonly="true" maxlength="18"/>
								 <font color=red>&nbsp;*</font>
							</c:if>
							<c:if test="${!updateState}">
								 <html:text styleClass="form_input_1x" property="wrapfee"  maxlength="18"/>
								 <font color=red>&nbsp;*</font>
							</c:if>
						</c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="wrapfee" disabled="true"/>
                            <font color=red>&nbsp;*</font>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <html:hidden  property="cityid"/>
        </table>
    </div>

    <div class="table_div">
        <table class="table_button_list">
            <tr>
                <td width="100%" class="form_table_center">
                	<s:RewardPurChk controlid="<%=ID_1%>" disableChild="true">
                    	   <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
                           name="btnSave" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<bean:message bundle="public" key="button_save"/>" class="submit"
                           onclick="doSave('/cms/bbc/yxplan.do?CMD=SAVE')"/>
                     </s:RewardPurChk>
                    <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
                           name="btnReturn" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<bean:message bundle="public" key="button_return"/>" class="close"
                           onclick="doReturn('/cms/bbc/yxplan.do?CMD=LIST')">
                </td>
            </tr>
        </table>
    </div>
</html:form>
</div>
</body>
</html>
