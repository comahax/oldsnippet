<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/contenthead.inc"%>
<%
    String ID_add = "CH_PW_SOTYEMPLOYEE_ADD";
    String ID_edit = "CH_PW_SOTYEMPLOYEE_EDIT";
%>
<html>
<head>
    <title><bean:message bundle="employee" key="societytitle"/></title>
    <script type="text/javascript" src="<%= contextPath %>/js/bus/waycommon.js"></script>
    <script language="JavaScript">
        function ev_checkval() {
        	var form=document.forms[0];
        	var regNum=/^[0-9]{11}$/; //电话正则表达式
        	var wayid=form.wayid.value;
        	if(wayid=="" || wayid==null)
        	{
			errorMessageShow('<span class=\'errorkey\'><span style=\'color:#F00; font-weight:900;\'>[<bean:message bundle="employee" key="wayid"/>]</span>不能为空</span>');  
        	return false;
  			} 
        	var officetel=trim(form.officetel.value);
        	var selectmobile=trim(form.selectmobile.value);
        	if(officetel=="" && form.zjty.value!="true")
        	{
			errorMessageShow('<span class=\'errorkey\'><span style=\'color:#F00; font-weight:900;\'>[<bean:message bundle="employee" key="officetel2"/>]</span>不能为空</span>');  
        	return false;
  			} 
  			if(officetel!="" &&  !regNum.test(officetel) ){
			errorMessageShow('<span class=\'errorkey\'><span style=\'color:#F00; font-weight:900;\'>[<bean:message bundle="employee" key="officetel2"/>]</span>应为11位数字</span>');  
        	return false;
  			}
  			if(selectmobile!="" && !regNum.test(selectmobile) ){
			errorMessageShow('<span class=\'errorkey\'><span style=\'color:#F00; font-weight:900;\'>[<bean:message bundle="employee" key="selectmobile"/>]</span>应为11位数字</span>');  
        	return false;
  			}
            addfield('employeename', '<bean:message bundle="employee" key="employeename"/>', 'c', false, '30');
            addfield('birthday', '<bean:message bundle="employee" key="birthday"/>', 't', true, '25');
            addfield('sex', '<bean:message bundle="employee" key="sex"/>', 'i', false, '3');
            addfield('isnet', '<bean:message bundle="employee" key="isnet"/>', 'i', false, '2');
            addfield('edulevel', '<bean:message bundle="employee" key="edulevel"/>', 'i', true, '3');
            
            addfield('intime', '<bean:message bundle="employee" key="intime"/>', 't', false, '25');
            
            addfield('telephone', '<bean:message bundle="employee" key="telephone"/>', 'c', true, '15');
            
            addfield('cardid', '<bean:message bundle="employee" key="cardid"/>', 'c', true, '18');

            addfield('pvtemail', '<bean:message bundle="employee" key="pvtemail"/>', 'm', true, '128');
            addfield('cityid', '<bean:message bundle="employee" key="cityid"/>', 'c', true, '14');
            addfield('countyid', '<bean:message bundle="employee" key="countyid"/>', 'c', true, '14');
            addfield('svccode', '<bean:message bundle="employee" key="svccode"/>', 'c', true, '14');

            addfield('contacttype', '<bean:message bundle="employee" key="contacttype"/>', 'i', false, '2');
            addfield('empstatus', '<bean:message bundle="employee" key="empstatus"/>', 'i', false, '2');
            addfield('bail', '<bean:message bundle="employee" key="bail"/>', 'd', true, '12');
            addfield('employtype', '<bean:message bundle="employee" key="employtype"/>', 'i', false, '2'); 
            addfield('selectmobile', '<bean:message bundle="employee" key="selectmobile"/>', 'i', true, '11');           
            return checkval(window);
        }
        function changeWay(waytype){
        	var control = document.getElementById("way_name");
    		var idCtlId = "wayid";
    		if('AG'==waytype){
    		showSelectWay4(control,idCtlId,'AG');
    		}else if('ET'==waytype)
    		{
    			showSelectWay3(control,'wayid','','','ET','G100','1');
    		}
			if(document.getElementById("societyFlag").value=="societyEdit"){
				formItem.action="<%=contextPath%>/cms/employee.do?CMD=SOCIETYEDIT&PK="+document.getElementById("employeeid").value;
        		if(document.getElelementById("").value!=document.getElementById("").value){
        			
        		}
        		formItem.submit();
			}else{
    			formItem.action="<%=contextPath%>/cms/employee.do?CMD=ADD";
        		formItem.submit();
        	}
        }
        function goback(){
        	formItem.action="<%=contextPath%>/cms/employee.do?CMD=SOCIETYLIST";
        	formItem.submit();
        }
        function pullValue()
        {
         	var form=document.forms[0];
         	form.selectmobile.value=form.officetel.value;
         	form.selectmobile.focus();
        }
    </script>
</head>
<body  onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<html:form action="/cms/employee.do?CMD=SAVE" styleId="formItem" method="post">

    <!--##################################添加标题内容##################################################-->
    <html:hidden property="cmdState" />
    <html:hidden property="societyFlag" />
    <html:hidden property="KIND"/>

    <html:hidden property="_orderby" />
    <html:hidden property="_desc" />
    <html:hidden property="_pageno" />
    <html:hidden property="_pagesize" />
    <html:hidden property="_ne_employeeid" />
    <html:hidden property="_sk_employeename" />
    <html:hidden property="_dnl_intime" />
    <html:hidden property="_dnm_intime" />
    <html:hidden property="_sk_wayid" />
    <html:hidden property="_se_svccode" />
     <html:hidden property="employeeid" />
     <html:hidden property="netpass"/> 
     <html:hidden property="isopen"/>
     <html:hidden property="zjty" />
    <c:set var="edtState" scope="request" value="${!empty param.CMD and (param.CMD eq 'SOCIETYEDIT' or param.CMD eq 'NEW' or param.CMD eq 'ADD' or requestScope.REEDIT eq 'TRUE')}" />
    <c:set var="updateState" scope="request" value="${!empty param.CMD and (param.CMD eq 'SOCIETYEDIT')}" />
    <c:set var="istelnull" scope="request" value="${empty requestScope['/cms/employee/EmployeeForm'].officetel}" /><div class="table_div">
       
    <table class="top_table">
    	<tr>
    		<td>
    			<bean:message bundle="employee" key="societytitle"/>
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
				<td align=left colspan=2>
					&nbsp;&nbsp;
					<bean:message bundle="public" key="msgRequired" />
				</td>
			</tr>
		</table>
    </div>

    <div class="table_div">
    	<FIELDSET>
	    	<legend name="baseinfo"><bean:message bundle="employee" key="baseinfo"/></legend>
		<html:hidden property="waytype" value="AG"/>
        <table class="form_table">
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="employee" key="employeename"/>:</div></td>
                <td width="30%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="employeename" maxlength="30"/><font color=red>&nbsp;*</font>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="employeename" disabled="true"/><font color=red>&nbsp;*</font>
                        </c:otherwise>
                    </c:choose>
                </td>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="employee" key="birthday"/>:</div></td>
                <td width="30%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="birthday" maxlength="25" onclick="this.value=selectDate()"/>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="birthday" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                 
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="employee" key="sex"/>:</div></td>
                <td width="30%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                        	  <html:select property="sex">
                        	  		<option/>
                        		    <s:Options definition="$CH_SEX"/>
                        	  </html:select><font color=red>&nbsp;*</font>
                        </c:when>
                        <c:otherwise>
                        	  <html:select property="sex" disabled="true">
                        		    <s:Options definition="$CH_SEX"/>
                        	  </html:select><font color=red>&nbsp;*</font>
                        </c:otherwise>
                    </c:choose>
                </td>
                 <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="employee" key="isnet"/>:</div></td>
                <td width="30%" align="left" class="form_table_left">
                   <c:choose>
                        <c:when test="${edtState}">
                        	  <html:select property="isnet" >
                        	  	<option/>
                        	  	<html:option value="0">店员</html:option>
								<html:option value="1">店主</html:option>
                        	  </html:select><font color=red>&nbsp;*</font>
                        </c:when>
                        <c:otherwise>
                        	  <html:select property="isnet" disabled="true">
                        	  		<option/>
                        		    <s:Options definition="$CH_ISNET"/>
                        	  </html:select><font color=red>&nbsp;*</font>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                 <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="employee" key="edulevel"/>:</div></td>
                <td width="30%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                        	  <html:select property="edulevel">
                        	  		<option/>
                        		    <s:Options definition="$CH_EDULEVEL"/>
                        	  </html:select>
                        </c:when>
                        <c:otherwise>
                        	  <html:select property="edulevel" disabled="true">
                        	  		<option/>
                        		    <s:Options definition="$CH_EDULEVEL"/>
                        	  </html:select>
                        </c:otherwise>
                    </c:choose>
                </td>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="employee" key="telephone"/>:</div></td>
                <td width="30%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="telephone" maxlength="15"/>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="telephone" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                 <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="employee" key="cardid"/>:</div></td>
                <td width="30%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="cardid" maxlength="18"/>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="cardid" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="employee" key="pvtemail"/>:</div></td>
                <td width="30%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="pvtemail" maxlength="128"/>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="pvtemail" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            
             <tr>           		
                 
               <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="employee" key="officetel2"/>:</div></td>
                <td width="30%" align="left" class="form_table_left">
                <c:choose>
					<c:when test="${edtState}">
						<c:if test="${updateState}">
						<c:if test="${!istelnull}">
							    <html:text styleClass="form_input_1x" property="officetel" maxlength="11"/><div id="tel"><font color=red>&nbsp;*</font></div>
                                         </c:if>
                                         <c:if test="${istelnull}">
							    <html:text styleClass="form_input_1x" property="officetel" maxlength="11" onblur="pullValue()"/><div id="tel"><font color=red>&nbsp;*</font></div>
                                         </c:if>
						</c:if>
						<c:if test="${!updateState}">
							     <html:text styleClass="form_input_1x" property="officetel" maxlength="11" onblur="pullValue()"/><div id="tel"><font color=red>&nbsp;*</font></div>

						</c:if>
					</c:when>
					<c:otherwise>
						    <html:text styleClass="form_input_1x" property="officetel" disabled="true"/><div id="tel"><font color=red>&nbsp;*</font></div>
					</c:otherwise>
				</c:choose>
                </td> 
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="employee" key="selectmobile"/>:</div></td>
                <td width="30%" align="left" class="form_table_left">
                  <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="selectmobile" maxlength="12"/>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="selectmobile" disabled="true"/>
                        </c:otherwise>
                   </c:choose>	
                 </td>
            </tr>
            <tr>           		
                 
               <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="employee" key="oprcode2"/>:</div></td>
                <td width="30%" align="left" class="form_table_left">
                <c:choose>
					<c:when test="${edtState}">
						<c:if test="${updateState}">
						<c:if test="${!istelnull}">
							    <html:text styleClass="form_input_1x" property="oprcode2" maxlength="11"/> 
                                         </c:if>
                                         <c:if test="${istelnull}">
							    <html:text styleClass="form_input_1x" property="oprcode2" maxlength="11" onblur="pullValue()"/> 
                                         </c:if>
						</c:if>
						<c:if test="${!updateState}">
							     <html:text styleClass="form_input_1x" property="oprcode2" maxlength="11" onblur="pullValue()"/> 

						</c:if>
					</c:when>
					<c:otherwise>
						    <html:text styleClass="form_input_1x" property="oprcode2" disabled="true"/>
					</c:otherwise>
				</c:choose>
                </td> 
                <td colspan=2>
                	&nbsp;
                </td>
             </tr>
            <tr>
            	<td colspan=4><div align='center'><font color=red>在岗人员采集平台捆绑手机号,空中选号手机号必须唯一</font></div></td>
            </tr>
           
        </table>
        </FIELDSET>
        <FIELDSET>
        	<legend name="organizeinfo"><bean:message bundle="employee" key="organizeinfo"/></legend>
        <table class="form_table">
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="employee" key="cityid"/>:</div></td>
                <td width="30%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                        	<html:hidden property="cityid"/>
                            <input type="text" name="citycompname" value='<c:out value="${requestScope['/cms/employee/EmployeeForm'].cityid}"/> <s:Code2Name code="${requestScope['/cms/employee/EmployeeForm'].cityid}" definition="#CITYCOMPANY"/>'  readonly="readonly" class="form_input_1x"><font color=red>&nbsp;*</font>
                        </c:when>
                        <c:otherwise>
                        	<html:hidden property="cityid"/>
                            <input type="text" name="citycompname" value='<c:out value="${requestScope['/cms/employee/EmployeeForm'].cityid}"/> <s:Code2Name code="${requestScope['/cms/employee/EmployeeForm'].cityid}" definition="#CITYCOMPANY"/>'  disabled="TRUE" class="form_input_1x"><font color=red>&nbsp;*</font>
                        </c:otherwise>
                    </c:choose>
                </td>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="employee" key="countyid"/>:</div></td>
                <td width="30%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                        	<html:hidden property="countyid"/>
                            <input type="text" name="countycompname" value='<c:out value="${requestScope['/cms/employee/EmployeeForm'].countyid}"/> <s:Code2Name code="${requestScope['/cms/employee/EmployeeForm'].countyid}" definition="#CNTYCOMPANY"/>'  readonly="readonly" class="form_input_1x"><font color=red>&nbsp;*</font>
                        </c:when>
                        <c:otherwise>
                        	<html:hidden property="countyid"/>
                            <input type="text" name="countycompname" value='<c:out value="${requestScope['/cms/employee/EmployeeForm'].countyid}"/> <s:Code2Name code="${requestScope['/cms/employee/EmployeeForm'].countyid}" definition="#CNTYCOMPANY"/>'  disabled="true" class="form_input_1x"><font color=red>&nbsp;*</font>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="employee" key="svccode"/>:</div></td>
                <td width="30%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:select property="svccode">
                           		<option/>
                            	<s:Options definition="#CH_SERVCENT" condition="countyid:${requestScope['/cms/employee/EmployeeForm'].countyid}"/>
                            </html:select>
                        </c:when>
                        <c:otherwise>
                            <html:select property="svccode" disabled="true">
                            	<option/>
                            	<s:Options definition="#CH_SERVCENT" condition="countyid:${requestScope['/cms/employee/EmployeeForm'].countyid}"/>
                            </html:select>
                        </c:otherwise>
                    </c:choose>
                </td>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="employee" key="wayid3"/>:</div></td>
                <td width="30%" align="left" class="form_table_left">
                <c:choose>
										<c:when test="${edtState}">
											<c:if test="${updateState}">
												     <html:hidden property="wayid"/>
                			<input type="text" name="way_name" id="way_name" value='<c:out value="${requestScope['/cms/employee/EmployeeForm'].wayid}"/> <s:Code2Name code="${requestScope['/cms/employee/EmployeeForm'].wayid}" definition="#WAY"/>'  disabled="true" class="form_input_1x"><font color=red>&nbsp;*</font>
											</c:if>
											<c:if test="${!updateState}">
												     <html:hidden property="wayid"/>
                			<input type="text" name="way_name" id="way_name" value='<c:out value="${requestScope['/cms/employee/EmployeeForm'].wayid}"/> <s:Code2Name code="${requestScope['/cms/employee/EmployeeForm'].wayid}" definition="#WAY"/>' onclick="changeWay('AG')" readonly="readonly" class="form_input_1x"><font color=red>&nbsp;*</font>      	
                			<input type="button" name="waybutton" id="waybutton" value="社会渠道"  onclick="changeWay('AG')" readonly="readonly" class="button_4">  	
                			<input type="button" value="自建他营" class="button_4"
								onclick="changeWay('ET');this.value='自建他营';" />									
											</c:if>
										</c:when>
										<c:otherwise>
											<html:text styleClass="form_input_1x" property="wayid"
												disabled="true" />
											<font color=red>&nbsp;*</font> 
										</c:otherwise>
									</c:choose>	
                </td>
            </tr>
		</table>
        </FIELDSET>
        
        <FIELDSET>
        	<legend name="employinfo"><bean:message bundle="employee" key="employinfo"/></legend>
        <table class="form_table">            
            <tr>
                 <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="employee" key="intime"/>:</div></td>
                <td width="30%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="intime" maxlength="10" onclick="this.value=selectDate()"/><font color=red>&nbsp;*</font>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="intime" disabled="true"/><font color=red>&nbsp;*</font>
                        </c:otherwise>
                    </c:choose>
                </td>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="employee" key="contacttype"/>:</div></td>
                <td width="30%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                        	  <html:select property="contacttype">
                        	  		<option/>
                        		    <s:Options definition="$CH_CONTACTTYPE"/>
                        	  </html:select><font color=red>&nbsp;*</font>
                        </c:when>
                        <c:otherwise>
                        	  <html:select property="contacttype" disabled="true">
                        	  		<option/>
                        		    <s:Options definition="$CH_CONTACTTYPE"/>
                        	  </html:select><font color=red>&nbsp;*</font>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="employee" key="employtype"/>:</div></td>
                <td width="30%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                        	  <html:select property="employtype">
                        	  		<option/>
                        		    <s:Options definition="$CH_EMPLOYTYPE"/>
                        	  </html:select><font color=red>&nbsp;*</font>
                        </c:when>
                        <c:otherwise>
                        	  <html:select property="employtype" disabled="true">
                        	  		<option/>
                        		    <s:Options definition="$CH_EMPLOYTYPE"/>
                        	  </html:select><font color=red>&nbsp;*</font>
                        </c:otherwise>
                    </c:choose>
                </td>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="employee" key="empstatus"/>:</div></td>
                <td width="30%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                        	  <html:select property="empstatus">
                        	  		<option/>
                        		    <s:Options definition="$CH_EMPSTATUS"/>
                        	  </html:select><font color=red>&nbsp;*</font>
                        </c:when>
                        <c:otherwise>
                        	  <html:select property="empstatus" disabled="true">
                        	  		<option/>
                        		    <s:Options definition="$CH_EMPSTATUS"/>
                        	  </html:select><font color=red>&nbsp;*</font>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="employee" key="bail"/>:</div></td>
                <td width="30%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="bail" maxlength="64"/>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="bail" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
               <td width="20%" align="right" class="form_table_right"></td>
                <td width="30%" align="left" class="form_table_left">
                    
                </td>
            </tr>
		</table>
        </FIELDSET>
        
        
    </div>

    <div class="table_div">
        <table class="table_button_list">
            <tr>
                <td>
                        <c:if test="${edtState && !updateState}">
            	  <s:PurChk2 controlid="<%=ID_add%>">
                    <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
                           name="btnSave" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<bean:message bundle="public" key="button_save"/>" class="submit"
                           onclick="doSave('/cms/employee.do?CMD=SOCIETYSAVE')"/>
                    <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
                           name="btnPrint" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<bean:message bundle="public" key="button_print"/>" class="print" onclick="doPrint()">
                 </s:PurChk2>
                 		</c:if>
                 		<c:if test="${updateState}">
            	  <s:PurChk2 controlid="<%=ID_edit%>">
                    <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
                           name="btnSave" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<bean:message bundle="public" key="button_save"/>" class="submit"
                           onclick="doSave('/cms/employee.do?CMD=SOCIETYSAVE')"/>
                    <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
                           name="btnPrint" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<bean:message bundle="public" key="button_print"/>" class="print" onclick="doPrint()">
                 </s:PurChk2>
                 		</c:if>

                    <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
                           name="btnReturn" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<bean:message bundle="public" key="button_return"/>" class="close"
                           onclick="goback()">
                </td>
            </tr>
        </table>
    </div>
    
</html:form>

<c:set var="wid" scope="request" value="${requestScope['/cms/employee/EmployeeForm'].wayid}" /><%--
    <c:if test="${wid eq null || wid eq ''}">
    	<script>
    		var control = document.getElementById("way_name");
    		var idCtlId = "wayid";
    		showSelectWay4(control,idCtlId,'AG');

    		if(document.getElementById(idCtlId).value == ""){
    			formItem.action="<%=contextPath%>/cms/employee.do?CMD=societylist";
        		formItem.submit();
        	}else{
        		if(document.getElementById("societyFlag").value=="societyEdit"){
					formItem.action="<%=contextPath%>/cms/employee.do?CMD=SOCIETYEDIT&PK="+document.getElementById("employeeid").value;
	        		formItem.submit();
				}else{
    				formItem.action="<%=contextPath%>/cms/employee.do?CMD=ADD";
        			formItem.submit();
	        	}
        	}
    	</script>
    </c:if>
--%></div>
</body>
<script>
	function isdisplay(){
	var zjty=document.all("zjty").value;
	var tel=document.getElementById("tel");
      if(zjty=="false" || zjty=="")
      {
       	tel.style.display="";
      }
      else if(zjty=='true')
      {
      	tel.style.display="none";
      }
   }
   isdisplay();
</script>
</html>
