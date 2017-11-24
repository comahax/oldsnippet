<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/contenthead.inc" %>

<jsp:include page="/inc/acl.jsp">
  <jsp:param name="PID" value="2B1A3CBB80AA" />
</jsp:include>
<%
    String ID_1 = "CH_PW_SOTYWAY_EDIT";
    String ID_2 = "CH_PW_SOTYWAY_QUERY";
%>

<html:html>
<head>
    <title><bean:message bundle="wayaccount" key="distitleList"/></title>
    <script language="JavaScript">
        function ev_checkval() {
            addfield('wayid', '<bean:message bundle="wayaccount" key="wayid"/>', 'c', false, 18);
            addfield('accid', '<bean:message bundle="wayaccount" key="accid"/>', 'i', false, 6);  
            addfield('bankname', '<bean:message bundle="wayaccount" key="bankname"/>', 'c', false, 128);  
            return checkval(window);
        }
        
        function doReturnIndex(){
           var str = self.parent.location.toString();
           if(str.indexOf("subindex.jsp")==-1){
              doReturn('/cms/diswayaccount.do?CMD=LIST&WAYSUBTYPE=DIS');  
           }else{
               var len1 = str.indexOf("subindex.jsp?wayid=");
               var len2 = str.length;
               var wayid = str.substring(len1+19,len2);
               doReturn('/cms/diswayaccount.do?CMD=LIST&WAYSUBTYPE=DIS&WAYID='+wayid);      
           }
        }
    </script>
</head>

<body onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<html:form action="/cms/diswayaccount.do?CMD=SAVE" styleId="formItem" method="post" >
    <html:hidden property="cmdState"/>
     <input type='hidden' name='subtype' value='DIS'/>
     <input type='hidden' name='chargetype' value='0'/>
     <input type='hidden' name='accttype' value='0'/>
    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <html:hidden property="_se_wayid"/>    
    <html:hidden property="_ne_accid"/>    
    <c:set var="edtState" scope="request" value="${!empty param.CMD and (param.CMD eq 'EDIT' or param.CMD eq 'NEW')}"/>	
    <c:set var="updateState" scope="request" value="${(!empty param.CMD and (param.CMD eq 'EDIT')) or (!empty param._se_wayid)}"/>
    <c:set var="updateState_2" scope="request" value="${!empty param.CMD and (param.CMD eq 'EDIT')}"/>
    <c:choose>
        <c:when test="${empty param._se_wayid}">
            <c:set var="wayid_value" scope="request"  value="${requestScope['/cms/wayaccount/WayaccountForm'].wayid}"/>
        </c:when>
        <c:otherwise>
            <c:set var="wayid_value" scope="request"  value="${param._se_wayid}"/>
        </c:otherwise>
    </c:choose>
    
	<div class="table_div">				
		<table class="top_table">
			<tr> 
				<td>
					<bean:message bundle="wayaccount" key="distitleList"/>
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
				<td align=left colspan="4">&nbsp;&nbsp;<bean:message bundle="public" key="msgRequired"/>
					&nbsp;
				</td>
			</tr>
            <tr >
                <td width="12%" align="right"><div class="field-require"><bean:message bundle="wayaccount" key="wayid"/>:</div></td>
                <td width="20%" align="left" class="form_table_left">       
                    <c:choose>
                        <c:when test="${edtState}">
                        <c:if test="${updateState}">
                        	  
                        	  <input type="text" name="wayid" maxlength="18" value="<c:out value='${wayid_value}'/>" readonly="readonly" class="form_input_1x">
                        
                        </c:if>
                        <c:if test="${!updateState}">
                            <html:text styleClass="form_input_1x" property="wayid" maxlength="18"/><font color=red>&nbsp;*</font>
                        </c:if>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="wayid" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
                <td  td width="12%" align="right"><div class="field-require"><bean:message bundle="wayaccount" key="accid"/>:</div></td>
                <td width="20%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                        <c:if test="${updateState_2}">
                        	  
                        	  <html:text styleClass="form_input_1x" property="accid" maxlength="18" readonly="true"/>
                        
                        </c:if>
                        <c:if test="${!updateState_2}">
                            <html:text styleClass="form_input_1x" property="accid" maxlength="18"/><font color=red>&nbsp;*</font>
                        </c:if>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="accid" disabled="true"/>
                        </c:otherwise>
                    </c:choose> 
                </td>
            </tr>

             <tr >   
                 <td  align="right"><div class="field-require"><bean:message bundle="wayaccount" key="acctno"/>:</div></td>
                <td width="20%" align="left" >
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="acctno"/>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="acctno" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
                
               <td  align="right"><div class="field-require"><bean:message bundle="wayaccount" key="acctname"/>:</div></td>
                <td width="20%" align="left" >
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="acctname"/>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="acctname" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
               </tr> 
               
              <tr >    
                <td  align="right"><div class="field-require"><bean:message bundle="wayaccount" key="bankname"/>:</div></td>
                <td width="20%" align="left" >
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="bankname"/><font color=red>&nbsp;*</font>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="bankname" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
                
                <td  align="right"><div class="field-require"><bean:message bundle="wayaccount" key="acctfid"/>:</div></td>
                <td width="20%" align="left" >
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="acctfid"/>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="acctfid" disabled="true"/>
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
						<s:PurChk2 controlid="<%=ID_1%>">
							 <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
	                    name="btnSave" onfocus="buttonover(this)" onblur="buttonout(this)"
	                    value="<bean:message bundle="public" key="button_save"/>" class="submit"
	                    onclick="doSave('/cms/diswayaccount.do?CMD=SAVE')"/>
            </s:PurChk2>   
                        
            <s:PurChk2 controlid="<%=ID_2%>">
		         <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
		                name="btnPrint" onfocus="buttonover(this)" onblur="buttonout(this)"
		                value="<bean:message bundle="public" key="button_print"/>" class="print" onclick="doPrint()">
	          </s:PurChk2>   

            <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
                   name="btnReturn" onfocus="buttonover(this)" onblur="buttonout(this)"
                   value="<bean:message bundle="public" key="button_return"/>" class="close"
                   onclick="doReturnIndex()">     	                                        
						</td>
         </tr>
		</table>
    </div>
</html:form>
</div>
</body>
</html:html>
