<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/contenthead.inc" %>
<jsp:include page="/inc/acl.jsp">
  <jsp:param name="PID" value="2B1A2B10" />
</jsp:include>

<%
	  String ID_1 = "2B1A2B10" + "BT1";  //new&&star
    String ID_2 = "2B1A2B10" + "BT2";  //modify
    String ID_3 = "2B1A2B10" + "BT3";  //delete
    String ID_4 = "2B1A2B10" + "BT4";  //save
    String ID_5 = "2B1A2B10" + "BT5";  //print
    
%>

<html:html>
<head>
    <title><bean:message bundle="waytype" key="titleUpdate"/></title>
    <script language="JavaScript">
        function ev_checkval() {
            addfield('waytypecode', '<bean:message bundle="waytype" key="waytypecode"/>', 'c', false, 4);
            addfield('waytypename', '<bean:message bundle="waytype" key="waytypename"/>', 'c', false, 32);
            addfield('uppercode', '<bean:message bundle="waytype" key="uppercode"/>', 'c', false, 4);
            return checkval(window);
        }
        
        function doNew(cmdNew) {
            var url = addParam(contextPath + cmdNew, 'CMD', 'NEW');
            formItem.action = url;
            formItem.submit();
        }
        
        function doStar(cmdStr) {
           formItem.action = contextPath + cmdStr;
           formItem.submit();
        }      
      
        function doModify(cmdModify) {
           formItem.action = contextPath + cmdModify;
           formItem.submit();
        }
        
        function doDelete(cmdDelete) {
            formItem.action = contextPath + cmdDelete;
            formItem.submit();
        }

    </script>
</head>
<body onload="loadforiframe();"> 
<div class="table_container">
<html:form action="/cms/waytype.do?CMD=SAVE" styleId="formItem" method="post">
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
						<bean:message bundle="waytype" key="titleList"/>
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
                <td  align="right"><div class="field-require"><bean:message bundle="waytype" key="waytypecode"/>:</div></td>
                <td width="75%" align="left" >
                    <c:choose>
                        <c:when test="${edtState}">
                            <c:choose>
                            	 <c:when test="${requestScope['/cms/waytype/WaytypeForm'].cmdState eq 'NEW'}">
                            	    <html:text styleClass="form_input_1x" property="waytypecode"/><font color=red>&nbsp;*</font>
                            	</c:when>
                            	<c:otherwise>
                                  <html:text styleClass="form_input_1x" property="waytypecode" readonly="true"/>
                            	</c:otherwise>
                            </c:choose> 
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="waytypecode" disabled="true"/>
                            <html:hidden property="waytypecode"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            
            <tr>
                <td  align="right"><div class="field-require"><bean:message bundle="waytype" key="waytypename"/>:</div></td>
                <td width="75%" align="left" >
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="waytypename"/><font color=red>&nbsp;*</font>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="waytypename" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            
            <tr>
                <td  align="right"><div class="field-require"><bean:message bundle="waytype" key="uppercode"/>:</div></td>
                <td width="75%" align="left" >
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="uppercode" readonly="true"/><font color=red><bean:message bundle="waytype" key="readonly"/></font>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="uppercode" disabled="true"/>
                            <html:hidden property="uppercode"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr> 
            
            <tr>
                <td  align="right"><div class="field-require"><bean:message bundle="waytype" key="desp"/>:</div></td>
                <td width="75%" align="left" >
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="desp"/><font color=red></font>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="desp" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr> 
        </table>
    </div>
    
    <%--
		<div class="table_div">
			<table class="table_button_list">
				<tr>
					<td>
              <c:choose>
                  <c:when test="${edtState}">  
						          <s:PurChk controlid="<%=ID_4%>">
						          <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
                             name="btnSave" onfocus="buttonover(this)" onblur="buttonout(this)"
                             value="<bean:message bundle="public" key="button_save"/>" class="submit"
                             onclick="doSave('/cms/waytype.do?CMD=SAVE')"/>
                      </s:PurChk>   
                      <s:PurChk controlid="<%=ID_5%>">    
	                    <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
	                           name="btnPrint" onfocus="buttonover(this)" onblur="buttonout(this)"
	                           value="<bean:message bundle="public" key="button_print"/>" class="print" onclick="doPrint()">
	                    </s:PurChk>
                      <c:choose>
                        <c:when test="${requestScope['/cms/waytype/WaytypeForm'].cmdState eq 'EDIT'}">
	                           <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
	                                  name="btnReturn" onfocus="buttonover(this)" onblur="buttonout(this)"
	                                  value="<bean:message bundle="public" key="button_return"/>" class="close"
	                                  onclick="doReturn('/cms/waytype.do?CMD=VIEW&PK=<c:out value="${requestScope['/cms/waytype/WaytypeForm'].waytypecode}"/>')">   
                        </c:when>
                        <c:otherwise>
                        	<c:choose>
                             <c:when test="${requestScope['/cms/waytype/WaytypeForm'].uppercode eq '-1'}">
	                                <s:PurChk controlid="<%=ID_1%>">    
	                                <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
	                                       name="btnReturn" onfocus="buttonover(this)" onblur="buttonout(this)"
	                                       value="<bean:message bundle="public" key="button_return"/>" class="close"
	                                       onclick="doStar('/cms/waytype.do?CMD=EDITNEW')">   
	                                </s:PurChk>
			                       </c:when>
                             <c:otherwise>
	                                <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
	                                       name="btnReturn" onfocus="buttonover(this)" onblur="buttonout(this)"
	                                       value="<bean:message bundle="public" key="button_return"/>" class="close"
	                                       onclick="doReturn('/cms/waytype.do?CMD=VIEW&PK=<c:out value="${requestScope['/cms/waytype/WaytypeForm'].uppercode}"/>')">   
			                       </c:otherwise>
			                    </c:choose>
			                </c:otherwise>
			                </c:choose>
	                    

                  </c:when>
                  <c:otherwise>
                        <s:PurChk controlid="<%=ID_1%>">
                            <input type="button" name="btnNew"  class="add" onmouseover="buttonover(this);"
                                   onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                                   value="<bean:message bundle="public" key="button_new"/>" onClick="doNew('/cms/waytype.do')">
                        </s:PurChk> 
                        
                        <c:choose>
                        	<c:when test="${!empty requestScope['/cms/waytype/WaytypeForm'].waytypecode}">
                                <s:PurChk controlid="<%=ID_2%>">
                                    <input type="button" name="btnModify"  class="modify" onmouseover="buttonover(this);"
                                           onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                                           value="<bean:message bundle="public" key="button_modify"/>" onClick="doModify('/cms/waytype.do?CMD=EDIT&PK=<c:out value="${requestScope['/cms/waytype/WaytypeForm'].waytypecode}"/>')">
                                </s:PurChk>  
                                <s:PurChk controlid="<%=ID_3%>">
                                    <input type="button" name="btnDelete" class="delete" onmouseover="buttonover(this);"
                                           onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                                           value="<bean:message bundle="public" key="button_delete"/>" onClick="doDelete('/cms/waytype.do?CMD=DELETE')">
                                </s:PurChk> 
                        	</c:when>
                        </c:choose>
                  </c:otherwise>
              </c:choose>				
					</td>
				</tr>
			</table>
		</div>
		--%>

</html:form>
</div>
</body>
</html:html>
