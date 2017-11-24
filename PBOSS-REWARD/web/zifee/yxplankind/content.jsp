<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/contenthead.inc" %>
<jsp:include page="/inc/acl.jsp">
  <jsp:param name="PID" value="3C2B4DBBAA" />
</jsp:include>
<%
    String ID_1 = "3C2B4DBBAABT1";
    String ID_2 = "3C2B4DBBAABT2";
%>
<html:html>
<head>
    <title><bean:message bundle="yxplankind" key="titleUpdate"/></title>
    <script language="JavaScript">
        function ev_checkval() {
            addfield('yxplankindname', '<bean:message bundle="yxplankind" key="yxplankindname"/>', 'c', false, 30);            
            return checkval(window); 
        }
    </script>
</head>
<body>
<div class="table_container">
<html:form action="/zifee/yxplankind.do?CMD=SAVE" styleId="formItem" method="post">
    
    <html:hidden property="cmdState"/>
    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <c:set var="edtState" scope="request" value="${!empty param.CMD and (param.CMD eq 'EDIT' or param.CMD eq 'NEW')}"/>

	<div class="table_div">
				<table class="top_table">
					<tr>
						<td>
							<bean:message bundle="yxplantype" key="titleplankind"/>
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
        	<c:if test="${param.CMD ne 'NEW'}">
        	<tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="yxplankind" key="yxplankindid"/>:</div></td>
                <td width="75%" align="left" class="form_table_left">                    
                    <html:text styleClass="form_input_1x" property="yxplankindid" disabled="true"/>                 
                </td>
            </tr> 
           </c:if>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="yxplankind" key="yxplankindname"/>:</div></td>
                <td width="75%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="yxplankindname" maxlength="30"/>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="yxplankindname" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
                       
        </table>
    </div>



    <div class="table_div">
        <table class="table_button_list">
            <tr>
                
                <td width="100%" class="form_table_right">
                	<s:PurChk controlid="<%=ID_1%>">
                    <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
                           name="btnSave" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<bean:message bundle="public" key="button_save"/>" class="submit"
                           onclick="doSave('/zifee/yxplankind.do?CMD=SAVE')"/>
                    </s:PurChk>
                    <s:PurChk controlid="<%=ID_2%>">
                    <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
                           name="btnPrint" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<bean:message bundle="public" key="button_print"/>" class="print" onclick="doPrint()">
                    </s:PurChk>
                    <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
                           name="btnReturn" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<bean:message bundle="public" key="button_return"/>" class="close"
                           onclick="doReturn('/zifee/yxplankind.do?CMD=LIST')">
                </td>
            </tr>
        </table>
    </div>
</html:form>
</div>
</body>
</html:html>
