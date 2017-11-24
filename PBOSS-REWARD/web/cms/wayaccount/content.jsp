<%@ page language="java" contentType="text/html;charset=GBK"%>
<%//  contenthead.inc是content.jsp的文件头，声明了JS、CSS等的引用，所有content.jsp必须引用这个文件头%>
<%@ include file="/inc/contenthead.inc" %>

<jsp:include page="/inc/acl.jsp">
  <jsp:param name="PID" value="2B1A3CBB80AA" />
</jsp:include>
<%
	//业务控制点标识，暂时没用上，先保留  
    String PID = "2B1A3CBB80AA";
    String ID_1 = PID + "BT1";
    String ID_2 = PID + "BT2";
    String ID_3 = PID + "BT3";    
%>

<html:html>
<head>
    <title><bean:message bundle="wayaccount" key="titleUpdate"/></title>
    <script language="JavaScript">
        <%//录入数据的校检%>
        function ev_checkval() {
            addfield('wayid', '<bean:message bundle="wayaccount" key="wayid"/>', 'c', false, 18);
            addfield('accid', '<bean:message bundle="wayaccount" key="accid"/>', 'i', false, 6);  
            addfield('chargetype', '<bean:message bundle="wayaccount" key="chargetype"/>', 'i',false, 3);
            addfield('accttype', '<bean:message bundle="wayaccount" key="accttype"/>', 'i', false, 3);    
            addfield('bankname', '<bean:message bundle="wayaccount" key="bankname"/>', 'c', false, 128);
               
            if (date_compare('starttime','endtime','<bean:message bundle="waycompact" key="dataerr1"/>')) return;  
                    
            return checkval(window);
        }
    </script>
</head>
<body onload="loadforiframe()">
<div class="table_container">
<html:form action="/cms/wayaccount.do?CMD=SAVE" styleId="formItem" method="post" >
    <html:hidden property="cmdState"/>
    <%//查询页面的参数，有了这些就能在增加，编辑时返回编辑前的正确页面%>
    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <html:hidden property="_se_wayid"/>    
    <html:hidden property="_ne_accid"/>    
    <c:set var="edtState" scope="request" value="${!empty param.CMD and (param.CMD eq 'EDIT' or param.CMD eq 'NEW')}"/>	

	<div class="table_div">				
		<table class="top_table">
			<tr> 
				<td>
					<bean:message bundle="wayaccount" key="titleList"/>
				</td>
			</tr>
		</table>
	</div>
	
	 <div class="table_div">	
		<table width="100%" class="error_text">
		    <html:errors/><s:Msg />
	    </table>	
    </div>
    	
<!--#################################添加标题内容，里面可以放置按钮###################################################-->		
		
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
                            <html:text styleClass="form_input_1x" property="wayid" maxlength="14" readonly="true"/><font color=red>&nbsp;*</font>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="wayid" disabled="true"/>
                            <html:hidden property="wayid"/>
                        </c:otherwise>
                    </c:choose>
                </td>
                <td  td width="12%" align="right"><div class="field-require"><bean:message bundle="wayaccount" key="accid"/>:</div></td>
                <td width="20%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="accid" maxlength="24"/><font color=red>&nbsp;*</font>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="accid" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
                
           
            </tr>
            
            <tr >     
            	<td  width="12%" align="right"><div class="field-require"><bean:message bundle="wayaccount" key="chargetype"/>:</div></td>
                <td width="20%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
	                          <html:select property="chargetype">
	                          		<option/>
	                        		<s:Options definition="$CH_CHARGETYPE" />
	                        	</html:select><font color=red>&nbsp;*</font>
                        </c:when>
                        <c:otherwise>
	                          <html:select property="chargetype" disabled="true">
	                        		 <option/>
	                        		 <s:Options definition="$CH_CHARGETYPE" />
	                        	</html:select>
                        </c:otherwise>
                    </c:choose>
                </td>
                          
                <td  align="right"><div class="field-require"><bean:message bundle="wayaccount" key="accttype"/>:</div></td>
                <td width="20%" align="left" >
                    <c:choose>
                        <c:when test="${edtState}">
	                          <html:select property="accttype">
	                          		<option/>
	                        		<s:Options definition="$CH_ACCOUNTTYPE" />
	                        	</html:select><font color=red>&nbsp;*</font>
                        </c:when>
                        <c:otherwise>
	                          <html:select property="accttype" disabled="true">
	                        		 <option/>
	                        		 <s:Options definition="$CH_ACCOUNTTYPE" />
	                        	</html:select>
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
                
                <td  align="right"><div class="field-require"><bean:message bundle="wayaccount" key="dsbank"/>:</div></td>
                <td width="20%" align="left" >
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="dsbank"/>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="dsbank" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
                
                </tr>
                
               <tr >   
                 <td  align="right"><div class="field-require"><bean:message bundle="wayaccount" key="bankaddr"/>:</div></td>
                <td width="20%" align="left" >
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="bankaddr"/>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="bankaddr" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
                
                <td  align="right"><div class="field-require"><bean:message bundle="wayaccount" key="contact"/>:</div></td>
                <td width="20%" align="left" >
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="contact"/>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="contact" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
        
           
            <tr >               
                <td  align="right"><div class="field-require"><bean:message bundle="wayaccount" key="contel"/>:</div></td>
                <td width="20%" align="left" >
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="contel"/>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="contel" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
                 <td  align="right"><div class="field-require"><bean:message bundle="wayaccount" key="rectime"/>:</div></td>
             <td width="20%" align="left" >
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="rectime" readonly="true" onclick="this.value=selectDate();"/>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="rectime" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
           </tr>
           
           <tr >     
                <td  align="right"><div class="field-require"><bean:message bundle="wayaccount" key="starttime"/>:</div></td>
                <td width="20%" align="left" >
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="starttime"  readonly="true" onclick="this.value=selectDate();"/>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="starttime" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
                    
                <td  align="right"><div class="field-require"><bean:message bundle="wayaccount" key="endtime"/>:</div></td>
                <td width="20%" align="left" >
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="endtime"  readonly="true" onclick="this.value=selectDate();"/>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="endtime" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
             </tr>
             
             <tr >     
            	<td  align="right"><div class="field-require"><bean:message bundle="wayaccount" key="memo"/>:</div></td>
                <td  align="left" colspan="3">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_3x" property="memo"/>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_3x" property="memo" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            
               
             <tr >     
            	<td  align="right"><div class="field-require"><bean:message bundle="wayaccount" key="bossarea"/>:</div></td>
                <td  align="left" colspan="3">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="bossarea"/>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="bossarea" disabled="true"/>
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
	                           onclick="doSave('/cms/wayaccount.do?CMD=SAVE')"/>
                        </s:PurChk>   
                        
                        <s:PurChk controlid="<%=ID_2%>">
		                    <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
		                           name="btnPrint" onfocus="buttonover(this)" onblur="buttonout(this)"
		                           value="<bean:message bundle="public" key="button_print"/>" class="print" onclick="doPrint()">
	                    </s:PurChk>      
	                    	                    
	                    <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
		                           name="btnReturn" onfocus="buttonover(this)" onblur="buttonout(this)"
		                           value="<bean:message bundle="public" key="button_return"/>" class="close"
		                           onclick="doReturn('/cms/wayaccount.do?CMD=LIST&_se_wayid=<c:out value="${requestScope['/cms/wayaccount/WayaccountForm'].wayid}" />')">	                       
						</td>
                    </tr>
		</table>
    </div>
</html:form>
</div>
</body>
</html:html>
