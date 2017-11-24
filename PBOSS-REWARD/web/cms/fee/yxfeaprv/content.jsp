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
    <title><bean:message bundle="yxfeaprv" key="titleUpdate"/></title>
    <script language="JavaScript">
        function ev_checkval() {
            addfield('wayid', '<bean:message bundle="yxfeaprv" key="wayid"/>', 'c', false, 18);
            addfield('appoprcode', '<bean:message bundle="yxfeaprv" key="appoprcode"/>', 'c', false, 15);
            addfield('state', '<bean:message bundle="yxfeaprv" key="state"/>', 'c', false, 18);
            addfield('appfee', '<bean:message bundle="yxfeaprv" key="appfee"/>', 'd', false, 16,2,'0.00',0.00,999999999999.99);
            addfield('yxfeeuse', '<bean:message bundle="yxfeaprv" key="yxfeeuse"/>', 'c', false, 255);
            return checkval(window); 
        }
    </script>
</head>
<body>
<div class="table_container">
<html:form action="/cms/fee/yxfeaprv.do?CMD=SAVE" styleId="formItem" method="post">
    
    <html:hidden property="cmdState"/>
    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <c:set var="edtState" scope="request" value="${empty param.CMD or (!empty param.CMD and (param.CMD eq 'EDIT' or param.CMD eq 'NEW' or requestScope['cmdState'] eq 'EDIT'))}"/>
    
    <html:hidden property="apptime"/>
    <html:hidden property="appoprcode"/>
    <html:hidden property="state"/>
	<div class="table_div">
				<table class="top_table">
					<tr>
						<td>
							<bean:message bundle="yxfeaprv" key="titleList"/>
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
	                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="yxfeaprv" key="seq"/>:</div></td>
	                <td width="75%" align="left" class="form_table_left">
	                            <html:text styleClass="form_input_1x" property="seq" disabled="true"/>
	                </td>
	            </tr>
            </c:if>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="yxfeaprv" key="wayid"/>:</div></td>
                <td width="75%" align="left" class="form_table_left">
                     <html:text styleClass="form_input_1x" property="wayid"  disabled="true"/>       
                </td>
            </tr>
        	<tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="yxfeaprv" key="appoprcode"/>:</div></td>
                <td width="75%" align="left" class="form_table_left">
                     <html:text styleClass="form_input_1x" property="appoprcode"  disabled="true"/>       
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="yxfeaprv" key="state"/>:</div></td>
                <td width="75%" align="left" class="form_table_left">
                     <html:select property="state" disabled="true">                		
            			<s:Options  definition="$CH_YXFEESTATE"/>
		        	</html:select>
                </td>
            </tr>            
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="yxfeaprv" key="appfee"/>:</div></td>
                <td width="75%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${param.CMD eq 'NEW' or ( param.CMD eq 'EDIT' and requestScope['/cms/fee/yxfeaprv/YxfeaprvForm'].state eq '0')}">
                            <html:text styleClass="form_input_1x" property="appfee"/>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="appfee" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>            
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="yxfeaprv" key="yxfeeuse"/>:</div></td>
                <td width="75%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${param.CMD eq 'NEW'}">
                        	<html:textarea styleClass="form_textarea_on" property="yxfeeuse"/>
                        </c:when>
                        <c:otherwise>
                            <html:textarea styleClass="form_textarea_on" property="yxfeeuse" disabled="true"/>
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
                           onclick="doSave('/cms/fee/yxfeaprv.do?CMD=SAVE')"/>
                    </s:PurChk>
                    <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
                           name="btnReturn" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<bean:message bundle="public" key="button_return"/>" class="close"
                           onclick="doReturn('/cms/fee/yxfeaprv.do?CMD=LIST')">
                </td>
            </tr>
        </table>
    </div>
</html:form>
</div>
</body>
</html:html>
