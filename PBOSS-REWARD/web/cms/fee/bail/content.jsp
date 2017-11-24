<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/contenthead.inc" %>
<jsp:include page="/inc/acl.jsp">
  <jsp:param name="PID" value="3C4D3CAA" />
</jsp:include>
<%
    String ID_1 = "3C4D3CAABT1";
    String ID_2 = "3C4D3CAABT2";
    String ID_3 = "3C4D3CAABT3";
    String ID_4 = "3C4D3CAABT4";
%>
<html:html>
<head>
    <title><bean:message bundle="bail" key="titleUpdate"/></title>
    <script type="text/javascript" src="<%= contextPath %>/js/bus/waycommon.js"></script>
    <script language="JavaScript">
        function ev_checkval() {
            addfield('wayid', '<bean:message bundle="bail" key="wayid"/>', 'c', false, 18);
            addfield('money', '<bean:message bundle="bail" key="money"/>', 'd', false, 16,2,'0.00',0.00,999999999999.99);
            addfield('givetimestr', '<bean:message bundle="bail" key="givetime"/>', 'c', true, 10);
            addfield('recvtimestr', '<bean:message bundle="bail" key="recvtime"/>', 'c', false, 10);
            addfield('recvoprcode', '<bean:message bundle="bail" key="recvoprcode"/>', 'c', false, 15);
            addfield('memo', '<bean:message bundle="bail" key="memo"/>', 'c', true, 100);
            return checkval(window); 
        }
    </script>
</head>
<body>
<div class="table_container">
<html:form action="/cms/fee/bail.do?CMD=SAVE" styleId="formItem" method="post">
    
    <html:hidden property="cmdState"/>
    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <c:set var="edtState" scope="request" value="${empty param.CMD or (!empty param.CMD and (param.CMD eq 'EDIT' or param.CMD eq 'NEW' or requestScope['cmdState'] eq 'EDIT'))}"/>
    
	<div class="table_div">
				<table class="top_table">
					<tr>
						<td>
							<bean:message bundle="bail" key="titleList"/>
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
	                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="bail" key="seq"/>:</div></td>
	                <td width="75%" align="left" class="form_table_left">
	                            <html:text styleClass="form_input_1x" property="seq" disabled="true"/>
	                </td>
	            </tr>
            </c:if>
        	<tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="bail" key="wayid"/>:</div></td>
                <td width="75%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${(param.CMD eq 'NEW'||(requestScope['cmdState'] eq 'EDIT'))&&!(param.CMD eq 'EDIT')}">
                            <html:text styleClass="form_input_1x" property="wayid" maxlength="24"  onclick="showSelectWay(this )" readonly="true"/>
                        </c:when>
                        <c:otherwise>
                             <html:text styleClass="form_input_1x" property="wayid"  disabled="true"/> 
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>		    
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="bail" key="bailtype"/>:</div></td>
                <td width="75%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:select property="bailtype">                		
		            			<s:Options  definition="$CH_GUARTYPE"/>
				        	</html:select>
                        </c:when>
                        <c:otherwise>
                        	<html:select property="bailtype" disabled="true">
		            			<s:Options  definition="$CH_GUARTYPE"/>
				        	</html:select>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="bail" key="money"/>:</div></td>
                <td width="75%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="money"/>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="money" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="bail" key="givetime"/>:</div></td>
                <td width="75%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="givetimestr"  onclick="this.value=selectDate()"/>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="givetimestr" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="bail" key="opertype"/>:</div></td>
                <td width="75%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:select property="opertype">
                        		<s:Options  definition="$CH_BAILOPERTYPE"/>
                        	</html:select>
                        </c:when>
                        <c:otherwise>
                        	<html:select property="opertype" disabled="true">
                        		<s:Options  definition="$CH_BAILOPERTYPE"/>
                        	</html:select>                            
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="bail" key="recvoprcode"/>:</div></td>
                <td width="75%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="recvoprcode"/>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="recvoprcode" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="bail" key="recvtime"/>:</div></td>
                <td width="75%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="recvtimestr"  onclick="this.value=selectDate()"/>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="recvtimestr" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="bail" key="memo"/>:</div></td>
                <td width="75%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                        	<html:textarea styleClass="form_textarea_on" property="memo"/>
                        </c:when>
                        <c:otherwise>
                            <html:textarea styleClass="form_textarea_on" property="memo" disabled="true"/>
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
                           onclick="doSave('/cms/fee/bail.do?CMD=SAVE')"/>
                    </s:PurChk>
                    <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
                           name="btnReturn" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<bean:message bundle="public" key="button_return"/>" class="close"
                           onclick="doReturn('/cms/fee/bail.do?CMD=LIST')">
                </td>
            </tr>
        </table>
    </div>
</html:form>
</div>
</body>
</html:html>
