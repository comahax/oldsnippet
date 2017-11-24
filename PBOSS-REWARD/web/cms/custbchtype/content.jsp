<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/contenthead.inc" %>
<jsp:include page="/inc/acl.jsp">
  <jsp:param name="PID" value="2B1A2B30" />
</jsp:include>

<%
	  String ID_1 = "2B1A2B30" + "BT1"; 
    String ID_2 = "2B1A2B30" + "BT2";  
    
%>

<html:html>
<head>
    <title><bean:message bundle="custbchtype" key="titleUpdate"/></title>
    <script language="JavaScript">
        function ev_checkval() {
            addfield('bchtypecode', '<bean:message bundle="custbchtype" key="bchtypecode"/>', 'c', false, 3);
            addfield('bchtypename', '<bean:message bundle="custbchtype" key="bchtypename"/>', 'c', false, 64);
            addfield('citycompid', '<bean:message bundle="custbchtype" key="citycompid"/>', 'c', false, 14);
            return checkval(window);
        }
    </script>
</head>
<body onload="loadforiframe();" >
<div class="table_container">
<html:form action="/cms/custbchtype.do?CMD=SAVE" styleId="formItem" method="post">
    <html:hidden property="cmdState"/>
    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <html:hidden property="_sk_bchtypecode"/>    
    <html:hidden property="_sk_bchtypename"/>    
    <c:set var="edtState" scope="request" value="${!empty param.CMD and (param.CMD eq 'EDIT' or param.CMD eq 'NEW')}"/>
    
	 <div class="table_div">
		 <table class="top_table">
				<tr>
					<td>
						<bean:message bundle="custbchtype" key="titleList"/>
					</td>
				</tr>
			</table>
		</div>	
		
		<div class="table_div">
	     <table width="100%" class="error_text">
       	   <s:Msg />
       </table>	
		</div>	

   <div class="table_div">
        <table class="form_table">
        	<tr>
				   <td align=left colspan=2>&nbsp;&nbsp;<bean:message bundle="public" key="msgRequired"/></td>
			    </tr>
            <tr>
                <td width="15%" align="right"><div class="field-require"><bean:message bundle="custbchtype" key="bchtypecode"/>:</div></td>
                <td width="75%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${param.CMD eq 'NEW'}">
                            <html:text styleClass="form_input_1x" property="bchtypecode" maxlength="24"/><font color=red>&nbsp;*</font>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="bchtypecode" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td  align="right"><div class="field-require"><bean:message bundle="custbchtype" key="bchtypename"/>:</div></td>
                <td width="75%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="bchtypename" maxlength="24"/><font color=red>&nbsp;*</font>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="bchtypename" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td  align="right"><div class="field-require"><bean:message bundle="custbchtype" key="citycompid"/>:</div></td>
                <td width="75%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                        	  <html:select property="citycompid">
                        		    <s:Options definition="#CITYCOMPANY"/>
                        	  </html:select><font color=red>&nbsp;*</font>
                        </c:when>
                        <c:otherwise>
                        	  <html:select property="citycompid" disabled="true">
                        		    <s:Options definition="#CITYCOMPANY"/>
                        	  </html:select>  
                        </c:otherwise>
                    </c:choose>  
                </td>
            </tr>
            <tr>
                <td  align="right"><div class="field-require"><bean:message bundle="custbchtype" key="notusebysub"/>:</div></td>
                <td width="75%" align="left" >
                    <c:choose>
                        <c:when test="${edtState}">
                        	  <html:select property="notusebysub">
                        		    <s:Options definition="#NOTUSEBYSUB"/>
                        	  </html:select>  
                        </c:when>
                        <c:otherwise>
                        	  <html:select property="notusebysub" disabled="true">
                        		    <s:Options definition="#NOTUSEBYSUB"/>
                        	  </html:select>  
                        </c:otherwise>
                    </c:choose> 
                </td>
            </tr>
             <tr>
                <td  align="right"><div class="field-require"><bean:message bundle="custbchtype" key="description"/>:</div></td>
                <td width="75%" align="left" >
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="description"/><font color=red></font>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="description" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
        </table>
    </div>

		<div class="table_div">
			<table class="table_button_list">
				<tr>
					<td>
						  <s:PurChk controlid="<%=ID_1%>">
						  <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
                     name="btnSave" onfocus="buttonover(this)" onblur="buttonout(this)"
                     value="<bean:message bundle="public" key="button_save"/>" class="submit"
                     onclick="doSave('/cms/custbchtype.do?CMD=SAVE')"/>
              </s:PurChk>
              <s:PurChk controlid="<%=ID_2%>">
	            <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
	                   name="btnPrint" onfocus="buttonover(this)" onblur="buttonout(this)"
	                   value="<bean:message bundle="public" key="button_print"/>" class="print" onclick="doPrint()">
	            </s:PurChk>
	            <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
	                   name="btnReturn" onfocus="buttonover(this)" onblur="buttonout(this)"
	                   value="<bean:message bundle="public" key="button_return"/>" class="close"
	                   onclick="doReturn('/cms/custbchtype.do?CMD=LIST')">
					</td>
				</tr>
			</table>
		</div>

</html:form>
</div>
</body>
</html:html>
