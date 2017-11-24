<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/contenthead.inc"%>
<%
    String ID_1 = "CH_PW_SOTYWAY_EDIT";
    String ID_2 = "CH_PW_SOTYWAY_QUERY";
%>

<html>
<head>
    <title><bean:message bundle="waycompact" key="distitleList"/></title>
    <script language="JavaScript">
        function ev_checkval() {
            addfield('wayid', '<bean:message bundle="waycompact" key="wayid"/>', 'c', false, '18');
            addfield('compactno', '<bean:message bundle="waycompact" key="compactno"/>', 'c', false, '17');
            addfield('compactname', '<bean:message bundle="waycompact" key="compactname"/>', 'c', false, '255');
            addfield('endtime', '<bean:message bundle="waycompact" key="endtime"/>', 't', false, '25');
            addfield('signtime', '<bean:message bundle="waycompact" key="signtime"/>', 't', false, '25');
            addfield('copbound', '<bean:message bundle="waycompact" key="copbound"/>', 'c', true, '40');
            addfield('licenceno', '<bean:message bundle="waycompact" key="licenceno"/>', 'c', true, '64');
            addfield('compactpath', '<bean:message bundle="waycompact" key="compactpath"/>', 'c', true, '128');
            addfield('licencepath', '<bean:message bundle="waycompact" key="licencepath"/>', 'c', true, '128');
            addfield('runareatype', '<bean:message bundle="waycompact" key="runareatype"/>', 'i', true, '2');
            addfield('principal', '<bean:message bundle="waycompact" key="principal"/>', 'c', true, '64');
            if (date_compare('signtime','endtime','<bean:message bundle="waycompact" key="dataerr"/>')) return;
            return checkval(window);
        }
        
        function doReturnIndex(){
           var str = self.parent.location.toString();
           if(str.indexOf("subindex.jsp")==-1){
               doReturn('/cms/diswaycompact.do?CMD=LIST&WAYSUBTYPE=DIS');
           }else{
               self.parent.location='<%=contextPath%>/cms/disway/frame.jsp';
           }
        }
    </script>
</head>

<body onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<html:form action="/cms/diswaycompact.do?CMD=SAVE" styleId="formItem" method="post" enctype="multipart/form-data">
    <html:hidden property="cmdState"/>
    <input type='hidden' name='subtype' value='DIS'/>
    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <html:hidden property="_se_wayid"/>
    <html:hidden property="_sk_compactno"/>
    <html:hidden property="_sk_compactname"/>
    <c:set var="edtState" scope="request" value="${!empty param.CMD and (param.CMD eq 'EDIT' or param.CMD eq 'NEW')}"/>
    <c:set var="updateState" scope="request" value="${(!empty param.CMD and (param.CMD eq 'EDIT')) or (!empty param._se_wayid)}"/>
    <c:choose>
        <c:when test="${empty param._se_wayid}">
            <c:set var="wayid_value" scope="request"  value="${requestScope['/cms/waycompact/WaycompactForm'].wayid}"/>
        </c:when>
        <c:otherwise>
            <c:set var="wayid_value" scope="request"  value="${param._se_wayid}"/>
        </c:otherwise>
    </c:choose>

    <div class="table_div">
    <table class="top_table">
    	<tr>
    		<td>
    			<bean:message bundle="waycompact" key="distitleList"/>
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
                 <td align="right" class="form_table_right"><div class="field-require"><bean:message bundle="waycompact" key="wayid"/>:</div></td>
                <td colspan="3" align="left" class="form_table_left">
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
            </tr>   
           

            <tr>
                 <td width="12%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="waycompact" key="compactname"/>:</div></td>
                <td width="20%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="compactname" maxlength="255"/><font color=red>&nbsp;*</font>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="compactname" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
                 <td width="15%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="waycompact" key="licenceno"/>:</div></td>
                <td width="20%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="licenceno" maxlength="64"/>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="licenceno" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            
            <tr>
                 <td width="12%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="waycompact" key="compactno"/>:</div></td>
                <td width="20%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="compactno" maxlength="255"/><font color=red>&nbsp;*</font>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="compactno" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
                 <td width="15%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="waycompact" key="principal"/>:</div></td>
                <td width="20%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="principal" maxlength="64"/>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="principal" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>

            <tr>
                 <td width="12%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="waycompact" key="signtime"/>:</div></td>
                <td width="20%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="signtime" onclick="this.value=selectDate()" maxlength="25"/><font color=red>&nbsp;*</font>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="signtime" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
                 <td width="15%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="waycompact" key="endtime"/>:</div></td>
                <td width="20%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="endtime" onclick="this.value=selectDate()" maxlength="25"/><font color=red>&nbsp;*</font>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="endtime" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            
            <tr>
                 <td width="12%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="waycompact" key="copbound"/>:</div></td>
                <td width="20%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="copbound" maxlength="40"/>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="copbound" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
                 <td width="15%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="waycompact" key="runareatype"/>:</div></td>
                <td width="20%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                        	<html:select property="runareatype">
                        		<option/>
                        		<s:Options definition="$CH_ORGTYPE"></s:Options>
                        	</html:select>                            
                        </c:when>
                        <c:otherwise>
                            <html:select property="runareatype" disabled="true">
                            	<option/>
                        		<s:Options definition="$CH_ORGTYPE"></s:Options>
                        	</html:select>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            
            <tr>
                <td  align="right" width="14%"><div class="field-require"><bean:message bundle="waycompact" key="compactpath"/>:</div></td>
                <td colspan="3" align="left" class="form_table_left">
                    <html:file property="compactfile" styleClass="form_input_files"></html:file>
                </td>
            </tr>
            <tr>
                <td  align="right" width="14%"><div class="field-require"></div></td>
                <td colspan="3" align="left" class="form_table_left">
					          <c:out value="${requestScope['/cms/waycompact/WaycompactForm'].compactpath}" />
					          <html:hidden property="compactpath" />
                </td>
            </tr>    
            
            <tr>
                <td  align="right" width="14%"><div class="field-require"><bean:message bundle="waycompact" key="licencepath"/>:</div></td>
                <td colspan="3" align="left" class="form_table_left">
                    <html:file property="licencefile" styleClass="form_input_files"></html:file>
                </td>
            </tr>
            <tr>
                <td  align="right" width="14%"><div class="field-require"></div></td>
                <td colspan="3" align="left" class="form_table_left">
					          <c:out value="${requestScope['/cms/waycompact/WaycompactForm'].licencepath}" />
					          <html:hidden property="licencepath" />
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
                           onclick="doSave('/cms/diswaycompact.do?CMD=SAVE')"/>
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
</html>
