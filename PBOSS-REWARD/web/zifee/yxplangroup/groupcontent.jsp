<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/contenthead.inc" %>
<jsp:include page="/inc/acl.jsp">
  <jsp:param name="PID" value="3C2B1A10AAAA" />
</jsp:include>
<%
    String ID_1 = "3C2B1A10AAAABT1";
    String ID_2 = "3C2B1A10AAAABT2";
%>


<html:html>
<head>
    <title><bean:message bundle="yxplan" key="titleList"/></title>
    <script language="JavaScript">

         function ev_checkval() {
             <c:if test="${!empty param.CMD and param.CMD eq 'NEWGROUP'}">
                 addfield('yxplanid', '<bean:message bundle="yxplan" key="groupyxplanid"/>', 'i', false, 14);
             </c:if>
             addfield('yxplanname', '<bean:message bundle="yxplan" key="groupyxplanname"/>', 'c', false, 128);
             addfield('remark', '<bean:message bundle="yxplan" key="remark"/>', 'c', true, 255);
             return checkval(window);
			  }  
			  
        function doSubmit(cmdStr) {
          if (ev_checkval()) {
              enable();
              formItem.action = contextPath + cmdStr;
              formItem.submit();
          }
          return false;
        } 
        
        function doReturn(cmdStr) {
            formItem.action = contextPath + cmdStr;
            formItem.submit();
        } 
        

    </script>
</head>
<body>
<div class="table_container">
<html:form action="/zifee/yxplan.do?CMD=SAVE" styleId="formItem" method="post">
    
    <html:hidden property="cmdState"/>
    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <html:hidden property="_ne_yxplanid"/> 
    <c:set var="edtState" scope="request" value="${!empty param.CMD and (param.CMD eq 'EDITGROUP' or param.CMD eq 'NEWGROUP')}"/>

	<div class="table_div">

		<table class="top_table" border=0>
			<tr> 
				<td>
					<bean:message bundle="yxplan" key="managenew"/>
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
      		<tr >
				<td align=left colspan="4">
					&nbsp;&nbsp;<bean:message bundle="public" key="msgRequired"/>												
				</td>			
			</tr>
      		<tr>
           		<td  align="right"><div class="field-require"><bean:message bundle="yxplan" key="groupyxplanid"/>:</div></td>
                <td  align="left" colspan="3">
                    <c:choose>
                        <c:when test="${!empty param.CMD and param.CMD eq 'NEWGROUP'}">
                            <html:text styleClass="form_input_1x" property="yxplanid" /><font color=red>&nbsp;*</font>
                        </c:when>
                        <c:otherwise>
                        	  <html:hidden property ="yxplanid" />
                            <html:text styleClass="form_input_1x" property="yxplanid" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
             </tr>
             
            <tr>	
            <td  align="right"><div class="field-require"><bean:message bundle="yxplan" key="groupyxplanname"/>:</div></td>
                <td  align="left" colspan="2">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_3x" property="yxplanname" /><font color=red>&nbsp;*</font>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_3x" property="yxplanname" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
             </tr>

          <tr>
              <td  align="right"><div class="field-require"><bean:message bundle="yxplan" key="remark"/>:</div></td>
               <td  align="left" colspan="5">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:textarea styleClass="form_textarea_on_4" property="remark"/>
                        </c:when>
                        <c:otherwise>
                            <html:textarea styleClass="form_textarea_on_4" property="remark" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
               </tr>
       </table>
    </div>
 <div class="table_div">
        <table class="table_button_list">
            <tr>
                 <td >
                 	<s:PurChk controlid="<%=ID_1%>">
                    <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
                           name="btnSave" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<bean:message bundle="public" key="button_save"/>" class="submit"
                           onclick="doSubmit('/zifee/yxplan.do?CMD=SAVEGROUP')"/>
                      </s:PurChk>
                    <s:PurChk controlid="<%=ID_2%>">
                    <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
                           name="btnPrint" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<bean:message bundle="public" key="button_print"/>" class="print" onclick="doPrint()">
                     </s:PurChk>
                    <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
                           name="btnReturn" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<bean:message bundle="public" key="button_return"/>" class="close"
                           onclick="doReturn('/zifee/yxplan.do?CMD=GROUPLIST')">
                </td>
            </tr>
        </table>
    </div>
</html:form>
</div>`
</body>
</html:html>
