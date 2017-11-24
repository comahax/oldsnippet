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
        function ev_checkval() {

           // addfield('slv', '<bean:message bundle="stdrewardbp" key="slv"/>', 'c', true, '40');
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
    <html:hidden property="rewardname"/> 
    <html:hidden property="rewardproj"/> 
    <html:hidden property="rewardtype"/> 
    <html:hidden property="startdate"/> 
    <html:hidden property="stopdate"/> 
    <html:hidden property="memo"/> 
    <c:set var="edtState" scope="request" value="${!empty param.CMD and (param.CMD eq 'EDIT')}"/>
    <c:set var="updateState" scope="request" value="${!empty param.CMD and (param.CMD eq 'EDIT')}"/>
	
	
	  <!--##################################添加标题内容##################################################-->
    <div class="table_div">
    <table class="top_table">
    	<tr>
    	
    		<td>
    		  <c:choose>
                    <c:when test="${edtState}"> 
                     <bean:message bundle="stdrewardbp" key="titleList3"/>
                    </c:when>
               	 <c:otherwise>
                     <bean:message bundle="stdrewardbp" key="titleList3"/>
           		 </c:otherwise>
              </c:choose>
    			
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
                           <c:out value="${requestScope['/cms/stdrewardbp/StdrewardbpForm'].rewardname}" /> 
                        </c:when>
                        <c:otherwise>
                            <c:out value="${requestScope['/cms/stdrewardbp/StdrewardbpForm'].rewardname}" /> 
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                 <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="stdreward" key="startdate"/>:</div></td>
                <td width="30%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                           <fmt:formatDate pattern="yyyy-MM-dd" value="${requestScope['/cms/stdrewardbp/StdrewardbpForm'].startdate}"/>
                        </c:when> 
                        <c:otherwise>
                            <fmt:formatDate pattern="yyyy-MM-dd" value="${requestScope['/cms/stdrewardbp/StdrewardbpForm'].startdate}"/>
                        </c:otherwise>
                    </c:choose>
                </td>
                 <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="stdreward" key="stopdate"/>:</div></td>
                <td width="30%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                           <fmt:formatDate pattern="yyyy-MM-dd" value="${requestScope['/cms/stdrewardbp/StdrewardbpForm'].stopdate}"/>
                        </c:when>
                        <c:otherwise>
                          <fmt:formatDate pattern="yyyy-MM-dd" value="${requestScope['/cms/stdrewardbp/StdrewardbpForm'].stopdate}"/>
                        </c:otherwise>
                    </c:choose>
                
           </tr>
           <tr>
                 <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="stdreward" key="memo"/>:</div></td>
                <td width="30%" align="left" class="form_table_left" colspan="4">
                     <c:choose>
                        <c:when test="${edtState}"> 
                           <c:out value="${requestScope['/cms/stdrewardbp/StdrewardbpForm'].memo}" /> 
                        </c:when>
                        <c:otherwise>
                          <c:out value="${requestScope['/cms/stdrewardbp/StdrewardbpForm'].memo}" /> 
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
												
													<html:multibox property="seleteSlv" disabled="true">
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
            	  <c:choose>
                    <c:when test="${edtState}"> 
                           <s:PurChk controlid="<%=ID_1%>">
                    <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
                           name="btnSave" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<bean:message bundle="public" key="button_save"/>" class="submit"
                           onclick="doSave('/cms/stdrewardbp.do?CMD=SAVESTAR&STR=content1')"/>
                  </s:PurChk>
                    </c:when>
              </c:choose>
                    <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
                           name="btnReturn" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<bean:message bundle="public" key="button_return"/>" class="close"
                           onclick="doReturn('/cms/stdrewardbp.do?CMD=LIST')">
                </td>
                <c:choose>
                    <c:when test="${edtState}"> 
                           <td>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</td>
                    </c:when>
               	 <c:otherwise>
                       	   <td>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</td>
           		 </c:otherwise>
              </c:choose>
               
            </tr>
        </table>
    </div>
</html:form>
</div>
</body>
</html>

