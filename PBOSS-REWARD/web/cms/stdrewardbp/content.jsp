<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/contenthead.inc"%>
<%
    String ID_1 = "00010701";
    String ID_2 = "00010702";
    String ID_3 = "00010703";
    String ID_4 = "00010704";
%>
<html>
<head>
    <title><bean:message bundle="stdrewardbp" key="titleUpdate"/></title>
    <script language="JavaScript">
    	 function forcheck(ob){
		 var TO=true;
    	 if (ob != null) {
         if (ob.length != null) {
            for (var i = 0; i < ob.length; i++) {
                var e = ob[i];
                if (e.type == 'checkbox') {
                    if (e.checked)
                        TO = false;
                }
            }
        } else {
            var e = ob;
            if (e.type == 'checkbox') {
                if (e.checked)
                    TO = false;
            }
        }
 	   }
  	  if (TO) { 
        return false;
   	 }
  	  return true;
	}  
        function ev_checkval() {
       		var ob = formItem.all("seleteSlv"); 
        	if(!forcheck(ob)){
      	     errorMessageShow('<span class=\'errorkey\'><span style=\'color:#F00; font-weight:900;\'>[<bean:message bundle="stdrewardbs" key="slv"/>]</span><bean:message bundle="stdrewardbs" key="slv"/>不能为空</span>');     
             return false; 
           }
        	addfield('rewardname', '<bean:message bundle="stdreward" key="rewardname"/>', 'c', false, '40');
            addfield('rewardproj', '<bean:message bundle="stdreward" key="rewardproj"/>', 'i', true, '3');
            addfield('startdate', '<bean:message bundle="stdreward" key="startdate"/>', 't', false, '25');
            addfield('stopdate', '<bean:message bundle="stdreward" key="stopdate"/>', 't', true, '25');
            addfield('memo', '<bean:message bundle="stdreward" key="memo"/>', 'c', true, '512');
            addfield('rewardstd', '<bean:message bundle="stdrewardbp" key="rewardstd"/>', 'f', false, '14','2');
            return checkval(window); 
        }
         
        function doReturn(url){
    	window.parent.document.location=contextPath + url;
		}
    </script> 
</head>
<body onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<html:form action="/cms/stdrewardbp.do?CMD=SAVE" styleId="formItem" method="post">
    <html:hidden property="cmdState"/>

    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <html:hidden property="_ne_rewardid"/>
    <html:hidden property="_se_region"/>
    <html:hidden property="_se_slv"/>
    <html:hidden property="_ne_rewardstd"/> 
    <html:hidden property="region"/>
	
    <html:hidden property="_sk_rewardname"/>
    <html:hidden property="_dnl_startdate"/>
    <html:hidden property="_dnm_stopdate"/>
    <html:hidden property="rewardid"/>
    <html:hidden property="rewardtype"/> 
    <html:hidden property="rewardproj"/> 
    
    <c:set var="edtState" scope="request" value="${!empty param.CMD and (param.CMD eq 'EDIT' or param.CMD eq 'NEW')}"/>
    <c:set var="updateState" scope="request" value="${!empty param.CMD and (param.CMD eq 'EDIT')}"/>
	
	
	  <!--##################################添加标题内容#######s###########################################-->
    <div class="table_div">
    <table class="top_table">
    	<tr>
    		<td>
    			<bean:message bundle="stdrewardbp" key="titleList1"/>
   			</td>
    	</tr>
    </table>
    </div>
    <div class="table_div">	
   		 <table width="100%" class="error_text">
    		<html:errors/><s:Msg />
    	</table>
    </div>
	<FIELDSET>
		<legend name="organizeinfo"><bean:message bundle="stdreward" key="titleList1"/></legend>
    <div class="table_div">
        <table class="form_table">
            <tr><td colspan="4">
				<bean:message bundle="stdrewardbp" key="tishi" />
			</td></tr>
			 <tr>
                 <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="stdreward" key="rewardid"/>:</div></td>
                <td width="30%" colspan="4">
                    <c:choose>
                        <c:when test="${edtState}">
                            <c:out value="${requestScope['/cms/stdrewardbp/StdrewardbpForm'].rewardid}" /> 
                        </c:when>
                        <c:otherwise>
                           <c:out value="${requestScope['/cms/stdrewardbp/StdrewardbpForm'].rewardid}" /> 
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                 <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="stdreward" key="rewardname"/>:</div></td>
               <td width="30%" colspan="4"> 
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="rewardname" maxlength="40" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="rewardname" disabled="true"/>
                        </c:otherwise>
                    </c:choose><font color=red>&nbsp;*</font>
                </td>
            </tr>
            <tr>
                 <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="stdreward" key="startdate"/>:</div></td>
                <td width="30%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                           
                            <input class="form_input_1x" type="text" name="startdate"
											value="<fmt:formatDate value="${requestScope['/cms/stdrewardbp/StdrewardbpForm'].startdate}"
											pattern="yyyy-MM-dd" />"
											onclick="this.value=selectDate();" readonly="true"/>
                        </c:when> 
                        <c:otherwise>
                            <input class="form_input_1x" type="text" name="startdate"
											value="<fmt:formatDate value="${requestScope['/cms/stdrewardbp/StdrewardbpForm'].startdate}"
											pattern="yyyy-MM-dd" />"
											onclick="this.value=selectDate();" disabled="true" />
                        </c:otherwise>
                    </c:choose><font color=red>&nbsp;*</font>
                </td>
                 <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="stdreward" key="stopdate"/>:</div></td>
                <td width="30%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                             <input class="form_input_1x" type="text" name="stopdate"
											value="<fmt:formatDate value="${requestScope['/cms/stdrewardbp/StdrewardbpForm'].stopdate}"
											pattern="yyyy-MM-dd" />"
											onclick="this.value=selectDate();" readonly="true"/>
                        </c:when>
                        <c:otherwise>
                           
                            <input class="form_input_1x" type="text" name="stopdate"
											value="<fmt:formatDate value="${requestScope['/cms/stdrewardbp/StdrewardbpForm'].stopdate}"
											pattern="yyyy-MM-dd" />"
											onclick="this.value=selectDate();" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                
           </tr>
           <tr>
                 <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="stdreward" key="memo"/>:</div></td>
                <td width="30%" align="left" class="form_table_left" colspan="4">
                    <c:choose>
                        <c:when test="${edtState}">
                        
                            <html:textarea property="memo" rows="3" cols="70" />
                        </c:when>
                        <c:otherwise>
                          <html:textarea property="memo" rows="3" cols="70"
											readonly="true" />
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
        </table>
    </div>
	</FIELDSET> 
    <!--##################################添加标题内容##################################################-->
	<FIELDSET>
		<legend name="organizeinfo"><bean:message bundle="stdrewardbp" key="titleList2"/></legend>
    <div class="table_div">
        <table class="form_table">
             <tr><td colspan="4">
				<bean:message bundle="stdrewardbp" key="tishi" />
			</td></tr>
            <tr>
                 <td width="8%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="stdrewardbp" key="slv"/>:</div></td>
                <td width="42%" align="left" class="form_table_left">
                      <c:choose>
								<c:when test="${edtState}">
									<table class="form_table">
										<tr><td>
											<c:forEach var="item" items="${requestScope['/cms/stdrewardbp/StdrewardbpForm'].star}"
												varStatus="vars">
												
													<html:multibox property="seleteSlv">
														<c:out value="${item}" />
													</html:multibox>

													<c:out value="${item}" />
												
												
											</c:forEach><font color=red>&nbsp;*</font></td>
										</tr>
									</table>
								</c:when>
								<c:otherwise>
									<table class="form_table" > 
										<tr><td>
											<c:forEach var="item" items="${requestScope['/cms/stdrewardbp/StdrewardbpForm'].star}" 
												varStatus="vars">
												
													<html:multibox property="seleteSlv" disabled="true">
														<c:out value="${item}" />
													</html:multibox>

													<c:out value="${item}" />
												
												
											</c:forEach>
											<font color=red>&nbsp;*</font>
											</td>
										</tr>
									</table>
								</c:otherwise>
							</c:choose>
                </td>
            
                 <td width="18%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="stdrewardbp" key="rewardstd"/>:</div></td>
                <td width="32%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="rewardstd" maxlength="16"/>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="rewardstd" disabled="true"/>
                        </c:otherwise>
                    </c:choose><font color=red>&nbsp;*</font>
                </td>
            </tr>
        </table>
    </div>
</FIELDSET>
    <div class="table_div">
        <table class="table_button_list">
            <tr>
                <td>
            	  <s:PurChk controlid="<%=ID_1%>">
                    <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
                           name="btnSave" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<bean:message bundle="public" key="button_save"/>" class="submit"
                           onclick="doSave('/cms/stdrewardbp.do?CMD=SAVE&STR=content')"/>
                  </s:PurChk>
                
                    <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
                           name="btnReturn" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<bean:message bundle="public" key="button_return"/>" class="close"
                           onclick="doReturn('/cms/stdrewardbp.do?CMD=LIST')">
                </td>
                <td>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</td>
            </tr>
        </table>
    </div>
</html:form>
</div>
</body>
</html>

