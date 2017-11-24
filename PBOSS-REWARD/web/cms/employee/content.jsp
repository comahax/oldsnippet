<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/contenthead.inc" %>
<jsp:include page="/inc/acl.jsp">
  <jsp:param name="PID" value="2B1A5E20" />
</jsp:include>

<%
	  String ID_1 = "2B1A5E20BT1";
    String ID_2 = "2B1A5E20BT2";
    
%>


<html:html>
<head>
    <title><bean:message bundle="employee" key="titleUpdate"/></title>
    <script type="text/javascript" src="<%= contextPath %>/js/bus/waycommon.js"></script>
    <script language="JavaScript">
        function ev_checkval() {
            addfield('employeeid', '<bean:message bundle="employee" key="employeeid"/>', 'c', false, 14);
            addfield('wayid', '<bean:message bundle="employee" key="wayid"/>', 'c', false, 18);
            
            addfield('sex', '<bean:message bundle="employee" key="sex"/>', 'i', true, 3);
            addfield('edulevel', '<bean:message bundle="employee" key="edulevel"/>', 'i', true, 3);
            addfield('nativehome', '<bean:message bundle="employee" key="nativehome"/>', 'i', true, 3);
            addfield('polivisage', '<bean:message bundle="employee" key="polivisage"/>', 'i', true, 3);
            addfield('department', '<bean:message bundle="employee" key="department"/>', 'c', true, 18);
            addfield('servoffice', '<bean:message bundle="employee" key="servoffice"/>', 'c', true, 18);
            addfield('station', '<bean:message bundle="employee" key="station"/>', 'i', true, 14);
            addfield('joblevel', '<bean:message bundle="employee" key="joblevel"/>', 'i', true, 3);
            addfield('worktime', '<bean:message bundle="employee" key="worktime"/>', 'i', true, 3);
            addfield('hereworktime', '<bean:message bundle="employee" key="hereworktime"/>', 'i', true, 3);
            addfield('employtype', '<bean:message bundle="employee" key="employtype"/>', 'i', true, 3);
            addfield('company', '<bean:message bundle="employee" key="company"/>', 'c', true, 50);
            
            addfield('birthday', '<bean:message bundle="employee" key="birthday"/>', 't', true, 12);
            addfield('intime', '<bean:message bundle="employee" key="intime"/>', 't', true,12);
            addfield('outtime', '<bean:message bundle="employee" key="outtime"/>', 't', true, 12);
            
            addfield('employeename', '<bean:message bundle="employee" key="employeename"/>', 'c', false, 10);
            addfield('telephone', '<bean:message bundle="employee" key="telephone"/>', 'c', true, 12);
            addfield('officetel', '<bean:message bundle="employee" key="officetel"/>', 'c', true, 12);
            addfield('oprcode2', '<bean:message bundle="employee" key="oprcode2"/>', 'c', true, 15);
            
            return checkval(window);
        }
    </script>
</head>
<body onload="loadforiframe();" >
<div class="table_container">
<html:form action="/cms/employee.do?CMD=SAVE" styleId="formItem" method="post">
    <html:hidden property="cmdState"/>
    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <html:hidden property="_ne_employeeid"/>   
    <html:hidden property="_sk_employeename"/>  
    
    <c:set var="edtState" scope="request" value="${!empty param.CMD and (param.CMD eq 'EDIT' or param.CMD eq 'NEW')}"/>
    
	 <div class="table_div">
		 <table class="top_table">
				<tr>
					<td>
						<bean:message bundle="employee" key="titleList"/>
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
				     <td align=left colspan=4>&nbsp;&nbsp;<bean:message bundle="public" key="msgRequired"/></td>
			    </tr>

            <tr>     
            	<td  td width="20%" align="right"><div class="field-require"><bean:message bundle="employee" key="employeeid"/>:</div></td>
                <td width="20%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${param.CMD eq 'NEW'}">
                            <html:text styleClass="form_input_1x" property="employeeid"/><font color=red>&nbsp;*</font>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="employeeid" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
                          
                <td align="right"><div class="field-require"><bean:message bundle="employee" key="oprcode2"/>:</div></td>
                <td width="20%" align="left" >
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="oprcode2"/><font color=red></font>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="oprcode2" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>     
            	<td  td width="20%" align="right"><div class="field-require"><bean:message bundle="employee" key="employeename"/>:</div></td>
                <td width="20%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="employeename"/><font color=red>&nbsp;*</font>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="employeename" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
                          
                <td  align="right"><div class="field-require"><bean:message bundle="employee" key="birthday"/>:</div></td>
                <td width="20%" align="left" >
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="birthday" onclick="this.value=selectDate()"/><font color=red></font>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="birthday" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>     
            	<td  td width="20%" align="right"><div class="field-require"><bean:message bundle="employee" key="sex"/>:</div></td>
                <td width="20%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                        	  <html:select property="sex">
                        		    <s:Options definition="$CH_SEX"/>
                        	  </html:select>  
                        </c:when>
                        <c:otherwise>
                        	  <html:select property="sex" disabled="true">
                        		    <s:Options definition="$CH_SEX"/>
                        	  </html:select>  
                        </c:otherwise>
                    </c:choose> 
                </td>
                          
                <td  align="right"><div class="field-require"><bean:message bundle="employee" key="edulevel"/>:</div></td>
                <td width="20%" align="left" >
                    <c:choose>
                        <c:when test="${edtState}">
                        	  <html:select property="edulevel">
                        		    <s:Options definition="$CH_EDULEVEL"/>
                        	  </html:select>  
                        </c:when>
                        <c:otherwise>
                        	  <html:select property="edulevel" disabled="true">
                        		    <s:Options definition="$CH_EDULEVEL"/>
                        	  </html:select>  
                        </c:otherwise>
                    </c:choose>  
                </td>
            </tr>       
            <tr>     
            	<td  td width="20%" align="right"><div class="field-require"><bean:message bundle="employee" key="nativehome"/>:</div></td>
                <td width="20%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                        	  <html:select property="nativehome">
                        		    <s:Options definition="$CH_NATIVE"/>
                        	  </html:select>  
                        </c:when>
                        <c:otherwise>
                        	  <html:select property="nativehome" disabled="true">
                        		    <s:Options definition="$CH_NATIVE"/>
                        	  </html:select>  
                        </c:otherwise>
                    </c:choose>
                </td>
                          
                <td  align="right"><div class="field-require"><bean:message bundle="employee" key="polivisage"/>:</div></td>
                <td width="20%" align="left" >
                    <c:choose>
                        <c:when test="${edtState}">
                        	  <html:select property="polivisage">
                        		    <s:Options definition="$CH_POLIVISAGE"/>
                        	  </html:select>  
                        </c:when>
                        <c:otherwise>
                        	  <html:select property="polivisage" disabled="true">
                        		    <s:Options definition="$CH_POLIVISAGE"/>
                        	  </html:select>  
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>        
            <tr>     
            	<td  td width="20%" align="right"><div class="field-require"><bean:message bundle="employee" key="department"/>:</div></td>
                <td width="20%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="department"/><font color=red></font>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="department" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
                          
                <td  align="right"><div class="field-require"><bean:message bundle="employee" key="servoffice"/>:</div></td>
                <td width="20%" align="left" >
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="servoffice"/><font color=red></font>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="servoffice" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>    
            <tr>     
            	<td  td width="20%" align="right"><div class="field-require"><bean:message bundle="employee" key="station"/>:</div></td>
                <td width="20%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                        	  <html:select property="station">
                        		    <s:Options definition="#CH_POSTINFO"/>
                        	  </html:select>  
                        </c:when>
                        <c:otherwise>
                        	  <html:select property="station" disabled="true">
                        		    <s:Options definition="#CH_POSTINFO"/>
                        	  </html:select>  
                        </c:otherwise>
                    </c:choose>
                </td>
                          
                <td  align="right"><div class="field-require"><bean:message bundle="employee" key="joblevel"/>:</div></td>
                <td width="20%" align="left" >
                    <c:choose>
                        <c:when test="${edtState}">
                        	  <html:select property="joblevel">
                        		    <s:Options definition="$CH_JOBLEVEL"/>
                        	  </html:select>  
                        </c:when>
                        <c:otherwise>
                        	  <html:select property="joblevel" disabled="true">
                        		    <s:Options definition="$CH_JOBLEVEL"/>
                        	  </html:select>  
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>          
            <tr>     
            	<td  td width="20%" align="right"><div class="field-require"><bean:message bundle="employee" key="intime"/>:</div></td>
                <td width="20%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="intime" onclick="this.value=selectDate()"/><font color=red></font>        
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="intime" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
                          
                <td  align="right"><div class="field-require"><bean:message bundle="employee" key="worktime"/>:</div></td>
                <td width="20%" align="left" >
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="worktime"/><font color=red></font>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="worktime" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>      
            <tr>     
            	<td  td width="20%" align="right"><div class="field-require"><bean:message bundle="employee" key="hereworktime"/>:</div></td>
                <td width="20%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="hereworktime"/><font color=red></font>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="hereworktime" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
                          
                <td  align="right"><div class="field-require"><bean:message bundle="employee" key="employtype"/>:</div></td>
                <td width="20%" align="left" >
                    <c:choose>
                        <c:when test="${edtState}">
                        	  <html:select property="employtype">
                        		    <s:Options definition="$CH_EMPLOYTYPE"/>
                        	  </html:select>  
                        </c:when>
                        <c:otherwise>
                        	  <html:select property="employtype" disabled="true">
                        		    <s:Options definition="$CH_EMPLOYTYPE"/>
                        	  </html:select>  
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>              
            <tr>     
            	<td  td width="20%" align="right"><div class="field-require"><bean:message bundle="employee" key="company"/>:</div></td>
                <td width="20%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="company"/><font color=red></font>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="company" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
                          
                <td  align="right"><div class="field-require"><bean:message bundle="employee" key="telephone"/>:</div></td>
                <td width="20%" align="left" >
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="telephone"/><font color=red></font>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="telephone" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>  
            <tr>     
            	<td  td width="20%" align="right"><div class="field-require"><bean:message bundle="employee" key="outtime"/>:</div></td>
                <td width="20%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="outtime" onclick="this.value=selectDate()"/><font color=red></font>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="outtime" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
                          
                <td  align="right"><div class="field-require"><bean:message bundle="employee" key="officetel"/>:</div></td>
                <td width="20%" align="left" >
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="officetel"/><font color=red></font>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="officetel" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr> 
            <tr>     
            	<td  td width="20%" align="right"><div class="field-require"><bean:message bundle="employee" key="outresult"/>:</div></td>
                <td width="20%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="outresult"/><font color=red></font>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="outresult" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
                          
                <td  align="right"><div class="field-require"><bean:message bundle="employee" key="homeaddr"/>:</div></td>
                <td width="20%" align="left" >
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="homeaddr"/><font color=red></font>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="homeaddr" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
                   
            <tr>     
            	<td  td width="20%" align="right"><div class="field-require"><bean:message bundle="employee" key="cardid"/>:</div></td>
                <td width="20%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="cardid"/><font color=red></font>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="cardid" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
                          
                <td  align="right"><div class="field-require"><bean:message bundle="employee" key="wayid"/>:</div></td>
                <td width="20%" align="left" >
                    <c:choose>
                        <c:when test="${edtState}">
                	          <html:hidden property="wayid"/>
                	          <input type="text" name="way_name" value='<c:out value="${requestScope['/cms/employee/EmployeeForm'].wayid}"/>&nbsp<s:Code2Name code="${requestScope['/cms/employee/EmployeeForm'].wayid}" definition="#WAY"/>'  onclick="showSelectWay(this,'wayid')" readonly="readonly" class="form_input_1x">
                        </c:when>
                        <c:otherwise>
                	          <input type="text" name="way_name" value='<c:out value="${requestScope['/cms/employee/EmployeeForm'].wayid}"/>&nbsp<s:Code2Name code="${requestScope['/cms/employee/EmployeeForm'].wayid}" definition="#WAY"/>'  disabled="true" class="form_input_1x">
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
						 <input  type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
                     name="btnSave" onfocus="buttonover(this)" onblur="buttonout(this)"
                     value="<bean:message bundle="public" key="button_save"/>" class="submit"
                     onclick="doSave('/cms/employee.do?CMD=SAVE')"/>
	            </s:PurChk>
	            <s:PurChk controlid="<%=ID_2%>">
	            <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
	                   name="btnPrint" onfocus="buttonover(this)" onblur="buttonout(this)"
	                   value="<bean:message bundle="public" key="button_print"/>" class="print" onclick="doPrint()">
	            </s:PurChk>       
	            <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
	                   name="btnReturn" onfocus="buttonover(this)" onblur="buttonout(this)"
	                   value="<bean:message bundle="public" key="button_return"/>" class="close"
	                   onclick="doReturn('/cms/employee.do?CMD=LIST')">
					</td>
				</tr>
			</table>
		</div>

</html:form>
</div>
</body>
</html:html>
