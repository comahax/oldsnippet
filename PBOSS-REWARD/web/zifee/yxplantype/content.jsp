<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/contenthead.inc" %>
<jsp:include page="/inc/acl.jsp">
  <jsp:param name="PID" value="3C2B4DAA" />
</jsp:include>
<%
    String ID_1 = "3C2B4DAABT1";
    String ID_2 = "3C2B4DAABT2";
    String ID_3 = "3C2B4DAABT3";
    String ID_4 = "3C2B4DAABT4";
%>
<html:html>
<head>
    <title><bean:message bundle="yxplantype" key="titleUpdate"/></title>
    <script language="JavaScript">
        function ev_checkval() {
            addfield('yxplankindid', '<bean:message bundle="yxplantype" key="yxplankindid"/>', 'c', false, 20);
            //addfield('yxplantypeid', '<bean:message bundle="yxplantype" key="yxplantypeid"/>', 'l', false, 20);
            addfield('yxplantypename', '<bean:message bundle="yxplantype" key="yxplantypename"/>', 'c', false, 20);            
            return checkval(window); 
            
        }
    </script>
</head>
<body>
<div class="table_container">
<html:form action="/zifee/yxplantype.do?CMD=SAVE" styleId="formItem" method="post">
    
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
							<bean:message bundle="yxplantype" key="titleList"/>
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
	                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="yxplantype" key="yxplantypeid"/>:</div></td>
	                <td width="75%" align="left" class="form_table_left">
	                            <html:text styleClass="form_input_1x" property="yxplantypeid" disabled="true"/>
	                </td>
	            </tr>
            </c:if> 
        	<tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="yxplantype" key="yxplankindid"/>:</div></td>
                <td width="75%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                        	<html:select property="yxplankindid" >
		                		<s:Options  definition="#ZIFEE-YXPLANKIND"/>
		                	</html:select>
                            <!-- html:text styleClass="form_input_1x" property="yxplankindid" maxlength="24"/-->
                        </c:when>
                        <c:otherwise>
                        	<html:select property="yxplankindid" disabled="true">               		
		                		<s:Options  definition="#ZIFEE-YXPLANKIND"/>
		                	</html:select>
                            <!-- html:text styleClass="form_input_1x" property="yxplankindid" disabled="true"/-->
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>            
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="yxplantype" key="yxplantypename"/>:</div></td>
                <td width="75%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="yxplantypename"/>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="yxplantypename" disabled="true"/>
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
                           onclick="doSave('/zifee/yxplantype.do?CMD=SAVE')"/>
                    </s:PurChk>
                    <s:PurChk controlid="<%=ID_2%>">
                    <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
                           name="btnPrint" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<bean:message bundle="public" key="button_print"/>" class="print" onclick="doPrint()">
                    </s:PurChk>
                    <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
                           name="btnReturn" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<bean:message bundle="public" key="button_return"/>" class="close"
                           onclick="doReturn('/zifee/yxplantype.do?CMD=LIST')">
                </td>
            </tr>
        </table>
    </div>
</html:form>
</body>
</html:html>
