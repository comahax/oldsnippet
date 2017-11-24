<%@ page language="java" contentType="text/html;charset=GBK"%>
<%//  contenthead.inc是content.jsp的文件头，声明了JS、CSS等的引用，所有content.jsp必须引用这个文件头%>
<%@ include file="/inc/contenthead.inc" %>

<jsp:include page="/inc/acl.jsp">
  <jsp:param name="PID" value="2B1A3CBB50" />
</jsp:include>
<%
	//业务控制点标识，暂时没用上，先保留  
    String PID = "2B1A3CBB50";
    String ID_1 = PID + "BT1";
    String ID_2 = PID + "BT2";    
%>

<html:html>
<head>
    <title><bean:message bundle="waycompact" key="titleUpdate"/></title>
    <script language="JavaScript">
        <%//录入数据的校检%>
        function ev_checkval() {
            addfield('compactno', '<bean:message bundle="waycompact" key="compactno"/>', 'c', false, 17);
            addfield('compactname', '<bean:message bundle="waycompact" key="compactname"/>', 'c', false, 255);
            addfield('begintime', '<bean:message bundle="waycompact" key="begintime"/>', 't', false, 20);
            addfield('endtime', '<bean:message bundle="waycompact" key="endtime"/>', 't', false, 20);
            addfield('signtime', '<bean:message bundle="waycompact" key="signtime"/>', 't', false, 20);
            
            addfield('coptype', '<bean:message bundle="waycompact" key="coptype"/>', 'i', true, 3);       
            addfield('copbound', '<bean:message bundle="waycompact" key="copbound"/>', 'c', true, 40);
            addfield('recomrule', '<bean:message bundle="waycompact" key="recomrule"/>', 'c', true, 255);
            
            if (date_compare('begintime','endtime','<bean:message bundle="waycompact" key="dataerr1"/>')) return;
            if (date_compare('signtime','endtime','<bean:message bundle="waycompact" key="dataerr2"/>')) return;
         
            return checkval(window);
        }
    </script>
</head>
<body onload="loadforiframe()">
<div class="table_container">
<html:form action="/cms/waycompact.do?CMD=SAVE" styleId="formItem" method="post">
    <html:hidden property="cmdState"/>
    <%//查询页面的参数，有了这些就能在增加，编辑时返回编辑前的正确页面%>
    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <html:hidden property="_sk_compactno"/>   
    <html:hidden property="_sk_compactname"/>  
    <html:hidden property="_se_wayid"/>  
    
    <c:set var="edtState" scope="request" value="${!empty param.CMD and (param.CMD eq 'EDIT' or param.CMD eq 'NEW' or param.CMD eq 'EDITNEW')}"/>
    
	 <div class="table_div">
		 <table class="top_table">
				<tr>
					<td>
						<bean:message bundle="waycompact" key="titleList"/>
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
                <td width="15%" align="right"><div class="field-require"><bean:message bundle="waycompact" key="wayid"/>:</div></td>
                <td width="75%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="wayid" readonly="true" maxlength="24"/><font color=red>&nbsp;<bean:message bundle="waycompact" key="readonly"/></font>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="wayid" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td  align="right"><div class="field-require"><bean:message bundle="waycompact" key="compactno"/>:</div></td>
                <td width="75%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="compactno" maxlength="24"/><font color=red>&nbsp;*</font>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="compactno" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td  align="right"><div class="field-require"><bean:message bundle="waycompact" key="compactname"/>:</div></td>
                <td width="75%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="compactname" maxlength="24"/><font color=red>&nbsp;*</font>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="compactname" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>             
            <tr>
                <td  align="right"><div class="field-require"><bean:message bundle="waycompact" key="begintime"/>:</div></td>
                <td width="75%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" onclick="this.value=selectDate()" property="begintime"/><font color=red>&nbsp;*</font>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="begintime" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td  align="right"><div class="field-require"><bean:message bundle="waycompact" key="endtime"/>:</div></td>
                <td width="75%" align="left" >
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="endtime" onclick="this.value=selectDate()"/><font color=red>&nbsp;*</font>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="endtime" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
             <tr>
                <td  align="right"><div class="field-require"><bean:message bundle="waycompact" key="signtime"/>:</div></td>
                <td width="75%" align="left" >
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="signtime" onclick="this.value=selectDate()"/> <font color=red>&nbsp;*</font>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="signtime" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>           
             <tr>
                <td  align="right"><div class="field-require"><bean:message bundle="waycompact" key="coptype"/>:</div></td>
                <td width="75%" align="left" >
                    <c:choose>
                        <c:when test="${edtState}">
                        	<html:select property="coptype">
                        		<option/>
                        		<s:Options definition="$CH_COPTYPE"></s:Options>
                        	</html:select>                            
                        </c:when>
                        <c:otherwise>
                            <html:select property="coptype" disabled="true">
                            	<option/>
                        		<s:Options definition="$CH_COPTYPE"></s:Options>
                        	</html:select>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>         
             <tr>
                <td  align="right"><div class="field-require"><bean:message bundle="waycompact" key="copbound"/>:</div></td>
                <td width="75%" align="left" >
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="copbound"/><font color=red></font>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="copbound" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>   
             <tr>
                <td  align="right"><div class="field-require"><bean:message bundle="waycompact" key="recomrule"/>:</div></td>
                <td width="75%" align="left" >
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="recomrule"/><font color=red></font>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="recomrule" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>    
            
             <tr>
                <td  align="right"><div class="field-require"><bean:message bundle="waycompact" key="compact"/>:</div></td>
                <td width="75%" align="left" >
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="compact"/><font color=red></font>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="compact" disabled="true"/>
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
		                    onclick="doSave('/cms/waycompact.do?CMD=SAVE')"/>
                    </s:PurChk>
                    
                    <s:PurChk controlid="<%=ID_2%>">
			           <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
			                  name="btnPrint" onfocus="buttonover(this)" onblur="buttonout(this)"
			                  value="<bean:message bundle="public" key="button_print"/>" class="print" onclick="doPrint()">
	                 </s:PurChk> 
					</td>
				</tr>
			</table>
		</div>

</html:form>
</div>
</body>
</html:html>
