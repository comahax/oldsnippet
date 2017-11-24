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
    <title><bean:message bundle="stdrewardbs" key="titleUpdate"/></title>
    <script language="JavaScript">
        function ev_checkval() {
        	var mpintvmonth = formItem.mpintvmonth.value;
        	var seintvmonth = formItem.seintvmonth.value;
        	if (mpintvmonth != null && mpintvmonth != '') {
        		if (parseInt(mpintvmonth) < 0) {
        			alert('专营酬金间隔月份不能为负数。');
            		return false;
        		}
        	}
        	if (seintvmonth != null && seintvmonth != '') {
        		if (parseInt(seintvmonth) < 0) {
        			alert('销售酬金间隔月份不能为负数。');
            		return false;
        		}
        	}
        	addfield('mpcitystd', '<bean:message bundle="stdrewardbs" key="mpcitystd1"/>', 'f', false, '14','4','','0',formItem.mpcitystd.value);
            addfield('mpcountrystd', '<bean:message bundle="stdrewardbs" key="mpcountrystd1"/>', 'f', false, '14','4','','0',formItem.mpcountrystd.value);
            addfield('mpintvmonth', '<bean:message bundle="stdrewardbs" key="mpintvmonth"/>', 'i', false, '5');
    	    addfield('secitystd', '<bean:message bundle="stdrewardbs" key="secitystd1"/>', 'f', false, '14','4','','0',formItem.secitystd.value);
           	addfield('secountrystd', '<bean:message bundle="stdrewardbs" key="secountrystd1"/>', 'f', false, '14','4','','0',formItem.secountrystd.value);
           	addfield('seintvmonth', '<bean:message bundle="stdrewardbs" key="seintvmonth"/>', 'i', false, '5');
            return checkval(window);
        }
        
        function doReturn(url){
    		window.parent.document.location=contextPath + url;
		}
		function doSave(cmdSave) {
		 var form=document.forms[0];
	   		  if (ev_checkval()) {
	   		  enable();
	      	  form.action = contextPath + cmdSave;
	       	  form.submit();
	  		  }else{
	 		   return false; 
	 		 }
		}
    </script>
</head>
<body onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<html:form action="/cms/stdrewardbs.do?CMD=SAVE" styleId="formItem" method="post">
    <html:hidden property="cmdState"/>

    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <html:hidden property="_ne_rewardid"/>
    <html:hidden property="_se_region"/>
    <html:hidden property="_se_slv"/>
	
    <html:hidden property="_sk_rewardname"/>
    <html:hidden property="_dnl_startdate"/>
    <html:hidden property="_dnm_stopdate"/>
    <html:hidden property="rewardid"/>
    <html:hidden property="rewardname"/> 
    <html:hidden property="rewardproj"/>  
    <html:hidden property="startdate"/> 
    <html:hidden property="stopdate"/> 
    <html:hidden property="memo"/> 
   	<html:hidden property="islimt"/> 
   	<html:hidden property="rewardtype"/> 
   	<html:hidden property="region"/> 
   	<html:hidden property="checkacctype"/> 
   	
   	<html:hidden property="citystd"/> 
   	<html:hidden property="countrystd"/> 
   	
    <c:set var="edtState" scope="request" value="${!empty param.CMD and (param.CMD eq 'EDIT')}"/>
    <c:set var="updateState" scope="request" value="${!empty param.CMD and (param.CMD eq 'EDIT')}"/>
	
	
	  <!--##################################添加标题内容##################################################-->
    <div class="table_div">
    <table class="top_table">
    	<tr>
    		<td>
    			<bean:message bundle="stdrewardbs" key="titleList5"/>
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
			</td></tr>
			 <tr>
                 <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="stdreward" key="rewardid"/>:</div></td>
                <td width="30%" colspan="4">
                    <c:choose>
                        <c:when test="${edtState}">
                            <c:out value="${requestScope['/cms/stdrewardbs/StdrewardbsForm'].rewardid}" /> 
                        </c:when>
                        <c:otherwise>
                           <c:out value="${requestScope['/cms/stdrewardbs/StdrewardbsForm'].rewardid}" /> 
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                 <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="stdreward" key="rewardname"/>:</div></td>
                <td width="30%" colspan="4">
                    <c:choose>
                        <c:when test="${edtState}">
                           <c:out value="${requestScope['/cms/stdrewardbs/StdrewardbsForm'].rewardname}" /> 
                        </c:when>
                        <c:otherwise>
                            <c:out value="${requestScope['/cms/stdrewardbs/StdrewardbsForm'].rewardname}" /> 
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                 <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="stdreward" key="startdate"/>:</div></td>
                <td width="30%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                           <fmt:formatDate pattern="yyyy-MM-dd" value="${requestScope['/cms/stdrewardbs/StdrewardbsForm'].startdate}"/>
                        </c:when> 
                        <c:otherwise>
                            <fmt:formatDate pattern="yyyy-MM-dd" value="${requestScope['/cms/stdrewardbs/StdrewardbsForm'].startdate}"/>
                        </c:otherwise>
                    </c:choose>
                </td>
                 <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="stdreward" key="stopdate"/>:</div></td>
                <td width="30%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                           <fmt:formatDate pattern="yyyy-MM-dd" value="${requestScope['/cms/stdrewardbs/StdrewardbsForm'].stopdate}"/>
                        </c:when>
                        <c:otherwise>
                          <fmt:formatDate pattern="yyyy-MM-dd" value="${requestScope['/cms/stdrewardbs/StdrewardbsForm'].stopdate}"/>
                        </c:otherwise>
                    </c:choose>              
           </tr>
           <tr>
                 <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="stdreward" key="memo"/>:</div></td>
                <td width="30%" align="left" class="form_table_left" colspan="4">
                     <c:choose>
                        <c:when test="${edtState}"> 
                           <c:out value="${requestScope['/cms/stdrewardbs/StdrewardbsForm'].memo}" /> 
                        </c:when>
                        <c:otherwise>
                          <c:out value="${requestScope['/cms/stdrewardbs/StdrewardbsForm'].memo}" /> 
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
        </table>
    </div>
</FIELDSET>
 <div class="table_div">
	    <table class="form_table">
	    	 <tr>
                 <td width="18%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="stdrewardbs" key="slv"/>:</div></td>
                <td width="42%" align="left" class="form_table_left">
                      <c:choose>
								<c:when test="${edtState}">
									<table class="form_table">
										<tr><td>
											<c:forEach var="item" items="${requestScope['/cms/stdrewardbs/StdrewardbsForm'].star}"
												varStatus="vars">												
													<html:multibox property="seleteSlv" disabled="true">
														<c:out value="${item}" />
													</html:multibox>
													<c:out value="${item}" />
											</c:forEach></td>
										</tr>
									</table>
								</c:when>
								<c:otherwise>
									<table class="form_table" > 
										<tr><td>
											<c:forEach var="item" items="${requestScope['/cms/stdrewardbs/StdrewardbsForm'].star}" 
												varStatus="vars">												
													<html:multibox property="seleteSlv" disabled="true">
														<c:out value="${item}" />
													</html:multibox>
													<c:out value="${item}" />												
											</c:forEach>
											
											</td>
										</tr>
									</table>
								</c:otherwise>
							</c:choose>
                </td>
                 <td width="13%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="stdrewardbs" key="region"/>:</div></td>
                <td width="27%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                        <s:Code2Name code="${requestScope['/cms/stdrewardbs/StdrewardbsForm'].region}" definition="#CITYIDNUM2NMAME"/>
                        </c:when>
                        <c:otherwise>
                        <s:Code2Name code="${requestScope['/cms/stdrewardbs/StdrewardbsForm'].region}" definition="#CITYIDNUM2NMAME"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
	    </table>
 </div>
    <!--##################################添加标题内容##################################################-->
<FIELDSET>
	<legend name="organizeinfo"><bean:message bundle="stdrewardbs" key="titleList3"/></legend>
    <div class="table_div">
        <table class="form_table">
             <tr><td colspan="6">
				<bean:message bundle="stdrewardbs" key="tishi" />
			</td></tr>
            <tr>
            	<td width="24%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="stdrewardbs" key="mpcitystd1"/>:</div></td>
                <td width="26%" colspan="2" align="left" class="form_table_left">
                	<c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="mpcitystd" />
                            <font color=red>&nbsp;*</font>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="mpcitystd" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
                <td width="24%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="stdrewardbs" key="mpcountrystd1"/>:</div></td>
                <td width="26%" colspan="2" align="left" class="form_table_left">
                	<c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="mpcountrystd" />
                            <font color=red>&nbsp;*</font>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="mpcountrystd" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
            	<td width="24%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="stdrewardbs" key="mpintvmonth"/>:</div></td>
                <td width="42%" colspan="6" align="left" class="form_table_left">
                	<c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="mpintvmonth" />
                            <font color=red>&nbsp;*</font>
                            (为0表示下月校验, 为1表示下下月校验)
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="mpintvmonth" disabled="true"/>
                            (为0表示下月校验, 为1表示下下月校验)
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
       </table>
    </div>
</FIELDSET>
<FIELDSET>
	<legend name="organizeinfo"><bean:message bundle="stdrewardbs" key="titleList4"/></legend>
	<div class="table_div">
        <table class="form_table">
             <tr><td colspan="6">
				<bean:message bundle="stdrewardbs" key="tishi" />
			</td></tr>
            <tr>
            	<td width="24%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="stdrewardbs" key="secitystd1"/>:</div></td>
                <td width="26%" colspan="2" align="left" class="form_table_left">
                	<c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="secitystd" />
                            <font color=red>&nbsp;*</font>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="secitystd" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
                <td width="24%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="stdrewardbs" key="secountrystd1"/>:</div></td>
                <td width="26%" colspan="2" align="left" class="form_table_left">
                	<c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="secountrystd" />
                            <font color=red>&nbsp;*</font>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="secountrystd" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
            	<td width="24%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="stdrewardbs" key="seintvmonth"/>:</div></td>
                <td width="42%" colspan="6" align="left" class="form_table_left">
                	<c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="seintvmonth" />
                            <font color=red>&nbsp;*</font>
                            (为0表示下月校验, 为1表示下下月校验)
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="seintvmonth" disabled="true"/>
                            (为0表示下月校验, 为1表示下下月校验)
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
             	<td width="100%" align="left" colspan="6" class="form_table_left">
             		<div class="field-require">
             			市公司酬金标准设置要求：合作专营酬金市区上限+销售达标酬金市区上限&lt=省公司'市区上限'<font color="red"><c:out value="${requestScope['/cms/stdrewardbs/StdrewardbsForm'].citystd}" /></font>元,合作专营酬金市郊上限+销售达标酬金市郊上限&lt=省公司'市郊上限'<font color="red"><c:out value="${requestScope['/cms/stdrewardbs/StdrewardbsForm'].countrystd}" /></font>元;
             		</div>
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
                           onclick="doSave('/cms/stdrewardbs.do?CMD=SAVESTS&STR=content2')"/>
                  </s:PurChk>
                    </c:when>
              </c:choose>
                    <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
                           name="btnReturn" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<bean:message bundle="public" key="button_return"/>" class="close"
                          onclick="doReturn('/cms/stdrewardbs.do?CMD=LIST')">
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

