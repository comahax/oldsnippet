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
		<title><bean:message bundle="employee" key="ditchmgrtitle" />
		</title>
		<script type="text/javascript"
			src="<%=contextPath%>/js/bus/waycommon.js"></script>
		<script language="JavaScript">
        function ev_checkval() {
         if(!isEmpty(document.all("officetel").value))
			{
				if(document.all("officetel").value.length!=11)
				{
					alert('手机号码长度必须为11位');return false;
				}
			}
            addfield('oprcode2', '<bean:message bundle="employee" key="oprcode2"/>', 'c', true, '15');
          	addfield('nativehome', '<bean:message bundle="employee" key="nativehome"/>', 'c', true, '20');
 			addfield('polivisage', '<bean:message bundle="employee" key="polivisage"/>', 'i', true, '3');
            addfield('department', '<bean:message bundle="employee" key="department"/>', 'c', true, '18');
            addfield('joblevel', '<bean:message bundle="employee" key="joblevel"/>', 'i', true, '3');
            addfield('worktime', '<bean:message bundle="employee" key="worktime"/>', 'i', true, '3');
            addfield('hereworktime', '<bean:message bundle="employee" key="hereworktime"/>', 'i', true, '3');
            addfield('employtype', '<bean:message bundle="employee" key="employtype"/>', 'i', true, '3');
            addfield('company', '<bean:message bundle="employee" key="company"/>', 'c', true, '50');
			 addfield('homeaddr', '<bean:message bundle="employee" key="homeaddr"/>', 'c', true, '255');     
            addfield('waytype', '<bean:message bundle="employee" key="waytype"/>', 'c', true, '4');
            addfield('ofcphone', '<bean:message bundle="employee" key="ofcphone"/>', 'c', true, '64');
			addfield('speciality', '<bean:message bundle="employee" key="speciality"/>', 'c', true, '16');
			addfield('officetel', '<bean:message bundle="employee" key="officetel2"/>', 'i', true,'11');
			
            addfield('posittype', '<bean:message bundle="employee" key="posittype"/>', 'c', true, '16');
  
            addfield('employeeid', '<bean:message bundle="employee" key="employeeid"/>', 'c', false, '15');
            addfield('employeename', '<bean:message bundle="employee" key="employeename"/>', 'c', false, '30');
            addfield('birthday', '<bean:message bundle="employee" key="birthday"/>', 't', true, '25');
            addfield('sex', '<bean:message bundle="employee" key="sex"/>', 'i', true, '3');
            addfield('edulevel', '<bean:message bundle="employee" key="edulevel"/>', 'i', true, '3');
            addfield('intime', '<bean:message bundle="employee" key="intime"/>', 't', true, '25');       
            addfield('telephone', '<bean:message bundle="employee" key="telephone"/>', 'c', true, '15');
            addfield('cardid', '<bean:message bundle="employee" key="cardid"/>', 'c', true, '18');
            addfield('wayid', '<bean:message bundle="employee" key="wayid"/>', 'c', false, '18');
            addfield('pvtemail', '<bean:message bundle="employee" key="pvtemail"/>', 'c', true, '128');
            addfield('cityid', '<bean:message bundle="employee" key="cityid"/>', 'c', true, '14');
            addfield('countyid', '<bean:message bundle="employee" key="countyid"/>', 'c', true, '14');
            addfield('svccode', '<bean:message bundle="employee" key="svccode"/>', 'c', true, '14');
            addfield('contacttype', '<bean:message bundle="employee" key="contacttype"/>', 'i', true, '2');
            addfield('empstatus', '<bean:message bundle="employee" key="empstatus"/>', 'i', true, '2');
        
            addfield('gradtime', '<bean:message bundle="employee" key="gradtime"/>', 't', true, '25'); 
            addfield('gradschool', '<bean:message bundle="employee" key="gradschool"/>', 'c', true, '128');
            addfield('ismarried', '<bean:message bundle="employee" key="ismarried"/>', 'i', true, '2');
   
             
             
           
            
			if (date_compare('birthday','intime','<bean:message bundle="employee" key="dateerr1"/>')) return;	
			
			            addfield('pvtemail', '<bean:message bundle="employee" key="pvtemail"/>', 'c', true, '128');
            
            
			if(document.all('pvtemail').value !="" && ismail(document.all('pvtemail').value,128) != 1){
				alert("'个人电子邮箱'格式不正确！");
			return;
			}
			//if(document.all('station').value != '60' && document.all('station').value != '64' && document.all('station').value != '65' ){
			//	alert("岗位必须是'渠道经理/战略层渠道经理/紧密层渠道经理'!");
			//	return;
			//}
			
            return checkval(window);
        }

   		 function changeWay(){
        	var control = document.getElementById("wayid");
    		showSelectWay4(control,"wayid",'ET','','');

    		if(document.getElementById("wayid").value == ""){
    		if(document.getElementById("ditchFlag").value=="ditchEdit"){
    			formItem.action="<%=contextPath%>/cms/ditchmgremployee.do?CMD=DITCHMGREDIT&PK="+document.getElementById("employeeid").value;
	        	formItem.submit();
        		}else{
        		formItem.action="<%=contextPath%>/cms/ditchmgremployee.do?CMD=NEW";
        		formItem.submit();
        		}
        	
        	}else{
    				formItem.action="<%=contextPath%>/cms/ditchmgremployee.do?CMD=DITCHADD";
        			formItem.submit();
        	}
        }
    </script>
	</head>
	<body onload="if(window.loadforiframe) loadforiframe();">
		<div class="table_container">
			<html:form action="/cms/ditchmgremployee.do?CMD=DITCHSAVE"
				styleId="formItem" method="post">

				<!--##################################添加标题内容##################################################-->
				<html:hidden property="cmdState" />

				<!-- html:hidden property="state" /-->

				<html:hidden property="ditchFlag" />

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
				<input type="hidden" name="waytype" value="ET">

				<c:set var="edtState" scope="request"
					value="${!empty param.CMD and (param.CMD eq 'DITCHMGREDIT' or param.CMD eq 'NEW' or param.CMD eq 'DITCHADD')}" />
				<c:set var="updateState" scope="request"
					value="${!empty param.CMD and (param.CMD eq 'DITCHMGREDIT')}" />
				<div class="table_div">

					<table class="top_table">
						<tr>
							<td>
								<bean:message bundle="employee" key="ditchmgrtitle" />
							</td>
						</tr>
					</table>
				</div>
				<div class="table_div">
					<table width="100%" class="error_text">
						<html:errors />
						<s:Msg />
					</table>
				</div>

				<div class="table_div">
					<FIELDSET>
						<legend name="baseinfo">
							<bean:message bundle="employee" key="baseinfo" />
						</legend>
						<table class="form_table">
							<tr>
								<td width="20%" align="right" class="form_table_right">
									<div class="field-require">
										<bean:message bundle="employee" key="employeeid" />
										:
									</div>
								</td>
								<td width="30%" align="left" class="form_table_left">
									<c:choose>
										<c:when test="${edtState}">
											<c:if test="${updateState}">
												<html:text styleClass="form_input_1x" property="employeeid"
													maxlength="15" readonly="true" />
											</c:if>
											<c:if test="${!updateState}">
												<html:text styleClass="form_input_1x" property="employeeid"
													maxlength="15" />
												<font color=red>&nbsp;*</font>

											</c:if>
										</c:when>
										<c:otherwise>
											<html:text styleClass="form_input_1x" property="employeeid"
												disabled="true" />
										</c:otherwise>
									</c:choose>
								</td>
								<td width="20%" align="right" class="form_table_right">
									<div class="field-require">
										<bean:message bundle="employee" key="oprcode2" />
										:
									</div>
								</td>
								<td width="30%" align="left" class="form_table_left">
									<c:choose>
										<c:when test="${edtState}">
											<html:text styleClass="form_input_1x" property="oprcode2"
												maxlength="15" />
										</c:when>
										<c:otherwise>
											<html:text styleClass="form_input_1x" property="oprcode2"
												disabled="true" />
										</c:otherwise>
									</c:choose>
								</td>
							</tr>
							<tr>
								<td width="20%" align="right" class="form_table_right">
									<div class="field-require">
										<bean:message bundle="employee" key="wayid2" />
										:
									</div>
								</td>
								<td width="30%" align="left" class="form_table_left">
									<c:choose>
										<c:when test="${edtState}">
											<html:hidden property="wayid" />
											<input type="text" name="way_name" id="way_name"
												value='<c:out value="${requestScope['/cms/employee/EmployeeForm'].wayid}"/>&nbsp<s:Code2Name code="${requestScope['/cms/employee/EmployeeForm'].wayid}" definition="#WAY"/>'
												onclick="changeWay()" readonly="readonly"
												class="form_input_1x">
											<font color=red>&nbsp;*</font>

										</c:when>
										<c:otherwise>
											<html:hidden property="wayid" />
											<input type="text" name="way_name" id="way_name"
												value='<c:out value="${requestScope['/cms/employee/EmployeeForm'].wayid}"/>&nbsp<s:Code2Name code="${requestScope['/cms/employee/EmployeeForm'].wayid}" definition="#WAY"/>'
												disabled="true" class="form_input_1x">
											<font color=red>&nbsp;*</font>
										</c:otherwise>
									</c:choose>
								</td>


								<td width="20%" align="right" class="form_table_right">
									<div class="field-require">
										<bean:message bundle="employee" key="employeename" />
										:
									</div>
								</td>
								<td width="30%" align="left" class="form_table_left">
									<c:choose>
										<c:when test="${edtState}">
											<html:text styleClass="form_input_1x" property="employeename"
												maxlength="30" />
											<font color=red>&nbsp;*</font>
										</c:when>
										<c:otherwise>
											<html:text styleClass="form_input_1x" property="employeename"
												disabled="true" />
											<font color=red>&nbsp;*</font>
										</c:otherwise>
									</c:choose>
								</td>
							</tr>
							<tr>
								<td width="20%" align="right" class="form_table_right">
									<div class="field-require">
										<bean:message bundle="employee" key="birthday" />
										:
									</div>
								</td>
								<td width="30%" align="left" class="form_table_left">
									<c:choose>
										<c:when test="${edtState}">
											<html:text styleClass="form_input_1x" property="birthday"
												maxlength="25" onclick="this.value=selectDate()" />
										</c:when>
										<c:otherwise>
											<html:text styleClass="form_input_1x" property="birthday"
												disabled="true" />
										</c:otherwise>
									</c:choose>
								</td>

								<td width="20%" align="right" class="form_table_right">
									<div class="field-require">
										<bean:message bundle="employee" key="sex" />
										:
									</div>
								</td>
								<td width="30%" align="left" class="form_table_left">
									<c:choose>
										<c:when test="${edtState}">
											<html:select property="sex">

												<option />
													<s:Options definition="$CH_SEX" />
											</html:select>
										</c:when>
										<c:otherwise>
											<html:select property="sex" disabled="true">
												<option />
													<s:Options definition="$CH_SEX" />
											</html:select>
										</c:otherwise>
									</c:choose>
								</td>
							</tr>
							<tr>
								<td width="20%" align="right" class="form_table_right">
									<div class="field-require">
										<bean:message bundle="employee" key="nativehome" />
										:
									</div>
								</td>
								<td width="30%" align="left" class="form_table_left">
									<c:choose>
										<c:when test="${edtState}">
											<html:select property="nativehome">
												<option />
													<s:Options definition="$CH_NATIVE" />
											</html:select>
										</c:when>
										<c:otherwise>
											<html:select property="nativehome" disabled="true">
												<option />
													<s:Options definition="$CH_NATIVE" />
											</html:select>
										</c:otherwise>
									</c:choose>
								</td>

								<td width="20%" align="right" class="form_table_right">
									<div class="field-require">
										<bean:message bundle="employee" key="polivisage" />
										:
									</div>
								</td>
								<td width="30%" align="left" class="form_table_left">
									<c:choose>
										<c:when test="${edtState}">
											<html:select property="polivisage">
												<option />
													<s:Options definition="$CH_POLIVISAGE" />
											</html:select>
										</c:when>
										<c:otherwise>
											<html:select property="polivisage" disabled="true">
												<option />
													<s:Options definition="$CH_POLIVISAGE" />
											</html:select>
										</c:otherwise>
									</c:choose>
								</td>
							</tr>
							<tr>
								<td width="20%" align="right" class="form_table_right">
									<div class="field-require">
										<bean:message bundle="employee" key="homeaddr" />
										:
									</div>
								</td>
								<td width="30%" align="left" class="form_table_left">
									<c:choose>
										<c:when test="${edtState}">
											<html:text styleClass="form_input_1x" property="homeaddr"
												maxlength="255" />
										</c:when>
										<c:otherwise>
											<html:text styleClass="form_input_1x" property="homeaddr"
												disabled="true" />
										</c:otherwise>
									</c:choose>
								</td>

								<td width="20%" align="right" class="form_table_right">
									<div class="field-require">
										<bean:message bundle="employee" key="cardid" />
										:
									</div>
								</td>
								<td width="30%" align="left" class="form_table_left">
									<c:choose>
										<c:when test="${edtState}">
											<html:text styleClass="form_input_1x" property="cardid"
												maxlength="18" />
										</c:when>
										<c:otherwise>
											<html:text styleClass="form_input_1x" property="cardid"
												disabled="true" />
										</c:otherwise>
									</c:choose>
								</td>
							</tr>
							<tr>
								<td width="20%" align="right" class="form_table_right">
									<div class="field-require">
										<bean:message bundle="employee" key="telephone" />
										:
									</div>
								</td>
								<td width="30%" align="left" class="form_table_left">
									<c:choose>
										<c:when test="${edtState}">
											<html:text styleClass="form_input_1x" property="telephone"
												maxlength="15" />
										</c:when>
										<c:otherwise>
											<html:text styleClass="form_input_1x" property="telephone"
												disabled="true" />
										</c:otherwise>
									</c:choose>
								</td>


								<td width="20%" align="right" class="form_table_right">
									<div class="field-require">
										<bean:message bundle="employee" key="pvtemail" />
										:
									</div>
								</td>
								<td width="30%" align="left" class="form_table_left">
									<c:choose>
										<c:when test="${edtState}">
											<html:text styleClass="form_input_1x" property="pvtemail"
												maxlength="128" />
										</c:when>
										<c:otherwise>
											<html:text styleClass="form_input_1x" property="pvtemail"
												disabled="true" />
										</c:otherwise>
									</c:choose>
								</td>
							</tr>
							<tr>
								<td width="20%" align="right" class="form_table_right">
									<div class="field-require">
										<bean:message bundle="employee" key="ofcphone" />
										:
									</div>
								</td>
								<td width="30%" align="left" class="form_table_left">
									<c:choose>
										<c:when test="${edtState}">
											<html:text styleClass="form_input_1x" property="ofcphone"
												maxlength="64" />
										</c:when>
										<c:otherwise>
											<html:text styleClass="form_input_1x" property="ofcphone"
												disabled="true" />
										</c:otherwise>
									</c:choose>
								</td>

								
							
								<td width="20%" align="right" class="form_table_right">
									<div class="field-require">
										<bean:message bundle="employee" key="edulevel" />
										:
									</div>
								</td>
								<td width="30%" align="left" class="form_table_left">
									<c:choose>
										<c:when test="${edtState}">
											<html:select property="edulevel">
												<option />
													<s:Options definition="$CH_EDULEVEL" />
											</html:select>
										</c:when>
										<c:otherwise>
											<html:select property="edulevel" disabled="true">
												<option />
													<s:Options definition="$CH_EDULEVEL" />
											</html:select>
										</c:otherwise>
									</c:choose>
								</td>
</tr>
							<tr>
								<td width="20%" align="right" class="form_table_right">
									<div class="field-require">
										<bean:message bundle="employee" key="speciality" />
										:
									</div>
								</td>
								<td width="30%" align="left" class="form_table_left">
									<c:choose>
										<c:when test="${edtState}">
											<html:text styleClass="form_input_1x" property="speciality"
												maxlength="16" />
										</c:when>
										<c:otherwise>
											<html:text styleClass="form_input_1x" property="speciality"
												disabled="true" />
										</c:otherwise>
									</c:choose>
								</td>
							
								
								<td width="20%" align="right" class="form_table_right">
									<bean:message bundle="employee" key="officetel2" />
									:
								</td>
								<td width="30%" align="left" class="form_table_left">
									<c:choose>
										<c:when test="${edtState}">
											<html:text styleClass="form_input_1x" property="officetel"
												maxlength="11" />
										</c:when>
										<c:otherwise>
											<html:text styleClass="form_input_1x" property="officetel"
												disabled="true" />
										</c:otherwise>
									</c:choose>
								</td>
							</tr>
						</table>
					</FIELDSET>
					<FIELDSET>
						<legend name="organizeinfo">
							<bean:message bundle="employee" key="organizeinfo" />
						</legend>
						<table class="form_table">
							<tr>
								<td width="20%" align="right" class="form_table_right">
									<div class="field-require">
										<bean:message bundle="employee" key="cityid" />
										:
									</div>
								</td>
								<td width="30%" align="left" class="form_table_left">
									<c:choose>
										<c:when test="${edtState}">
											<html:hidden property="cityid" />
											<input type="text" name="citycompname"
												value='<s:Code2Name code="${requestScope['/cms/employee/EmployeeForm'].cityid}" definition="#CITYCOMPANY"/>'
												readonly="readonly" class="form_input_1x">
										</c:when>
										<c:otherwise>
											<html:hidden property="cityid" />
											<input type="text" name="citycompname"
												value='<s:Code2Name code="${requestScope['/cms/employee/EmployeeForm'].cityid}" definition="#CITYCOMPANY"/>'
												disabled="TRUE" class="form_input_1x">
										</c:otherwise>
									</c:choose>
								</td>
								<td width="20%" align="right" class="form_table_right">
									<div class="field-require">
										<bean:message bundle="employee" key="countyid" />
										:
									</div>
								</td>
								<td width="30%" align="left" class="form_table_left">
									<c:choose>
										<c:when test="${edtState}">
											<html:hidden property="countyid" />
											<input type="text" name="countycompname"
												value='<s:Code2Name code="${requestScope['/cms/employee/EmployeeForm'].countyid}" definition="#CNTYCOMPANY"/>'
												readonly="readonly" class="form_input_1x">
										</c:when>
										<c:otherwise>
											<html:hidden property="countyid" />
											<input type="text" name="countycompname"
												value='<s:Code2Name code="${requestScope['/cms/employee/EmployeeForm'].countyid}" definition="#CNTYCOMPANY"/>'
												disabled="true" class="form_input_1x">
										</c:otherwise>
									</c:choose>
								</td>
							</tr>
							<tr>
								<td width="20%" align="right" class="form_table_right">
									<div class="field-require">
										<bean:message bundle="employee" key="svccode" />
										:
									</div>
								</td>
								<td width="30%" align="left" class="form_table_left">
									<c:choose>
										<c:when test="${edtState}">
											<html:select property="svccode">
												<option />
													<s:Options definition="#CH_SERVCENT"
														condition="countyid:${requestScope['/cms/employee/EmployeeForm'].countyid}" />
											</html:select>
										</c:when>
										<c:otherwise>
											<html:select property="svccode" disabled="true">
												<option />
													<s:Options definition="#CH_SERVCENT"
														condition="countyid:${requestScope['/cms/employee/EmployeeForm'].countyid}" />
											</html:select>
										</c:otherwise>
									</c:choose>
								</td>
								<td width="20%" align="right" class="form_table_right">
									&nbsp;
								</td>
								<td width="30%" align="left" class="form_table_left">
									&nbsp;
								</td>
							</tr>
						</table>
					</FIELDSET>
					<FIELDSET>
						<legend name="organizeinfo">
							<bean:message bundle="employee" key="employinfo" />
						</legend>
						<table class="form_table">
							<tr>
								<td width="20%" align="right" class="form_table_right">
									<div class="field-require">
										<bean:message bundle="employee" key="gradtime" />
										:
									</div>
								</td>
								<td width="30%" align="left" class="form_table_left">
									<c:choose>
										<c:when test="${edtState}">
											<html:text styleClass="form_input_1x" property="gradtime"
												maxlength="25" onclick="this.value=selectDate()" />
										</c:when>
										<c:otherwise>
											<html:text styleClass="form_input_1x" property="gradtime"
												disabled="true" />
										</c:otherwise>
									</c:choose>
								</td>
								<td width="20%" align="right" class="form_table_right">
									<div class="field-require">
										<bean:message bundle="employee" key="gradschool" />
										:
									</div>
								</td>
								<td width="30%" align="left" class="form_table_left">
									<c:choose>
										<c:when test="${edtState}">
											<html:text styleClass="form_input_1x" property="gradschool"
												maxlength="255" />
										</c:when>
										<c:otherwise>
											<html:text styleClass="form_input_1x" property="gradschool"
												disabled="true" />
										</c:otherwise>
									</c:choose>
								</td>
							</tr>
							<tr>
								<td width="20%" align="right" class="form_table_right">
									<div class="field-require">
										<bean:message bundle="employee" key="intime" />
										:
									</div>
								</td>
								<td width="30%" align="left" class="form_table_left">
									<c:choose>
										<c:when test="${edtState}">
											<html:text styleClass="form_input_1x" property="intime"
												maxlength="2" onclick="this.value=selectDate()" />
										</c:when>
										<c:otherwise>
											<html:text styleClass="form_input_1x" property="intime"
												disabled="true" />
										</c:otherwise>
									</c:choose>
								</td>
								<td width="20%" align="right" class="form_table_right">
									<div class="field-require">
										<bean:message bundle="employee" key="contacttype" />
										:
									</div>
								</td>
								<td width="30%" align="left" class="form_table_left">
									<c:choose>
										<c:when test="${edtState}">
											<html:select property="contacttype">
												<option />
													<s:Options definition="$CH_CONTACTTYPE" />
											</html:select>
										</c:when>
										<c:otherwise>
											<html:select property="contacttype" disabled="true">
												<option />
													<s:Options definition="$CH_CONTACTTYPE" />
											</html:select>
										</c:otherwise>
									</c:choose>
								</td>
							</tr>
							<tr>
								<td width="20%" align="right" class="form_table_right">
									<div class="field-require">
										<bean:message bundle="employee" key="employtype" />
										:
									</div>
								</td>
								<td width="30%" align="left" class="form_table_left">
									<c:choose>
										<c:when test="${edtState}">
											<html:select property="employtype">
												<option />
													<s:Options definition="$CH_EMPLOYTYPE" />
											</html:select>
										</c:when>
										<c:otherwise>
											<html:select property="employtype" disabled="true">
												<option />
													<s:Options definition="$CH_EMPLOYTYPE" />
											</html:select>
										</c:otherwise>
									</c:choose>
								</td>
								<td width="20%" align="right" class="form_table_right">
									<div class="field-require">
										<bean:message bundle="employee" key="empstatus" />
										:
									</div>
								</td>
								<td width="30%" align="left" class="form_table_left">
									<c:choose>
										<c:when test="${edtState}">
											<html:select property="empstatus">
												<option />
													<s:Options definition="$CH_EMPSTATUS" />
											</html:select>
										</c:when>
										<c:otherwise>
											<html:select property="empstatus" disabled="true">
												<option />
													<s:Options definition="$CH_EMPSTATUS" />
											</html:select>
										</c:otherwise>
									</c:choose>
								</td>
							</tr>

							<tr>
								<td width="20%" align="right" class="form_table_right">
									<div class="field-require">
										<bean:message bundle="employee" key="station" />
										:
									</div>
								</td>
								<td width="30%" align="left" class="form_table_left">
									<c:choose>
										<c:when test="${edtState}">
											<html:select property="station">
												<option />
													<s:Options definition="#CH_POSTINFO"
														condition="postkind:${'1'}" />
											</html:select>
										</c:when>
										<c:otherwise>
											<html:select property="station">
												<option />
													<s:Options definition="#CH_POSTINFO"
														condition="postkind:${'1'}" />
											</html:select>
										</c:otherwise>
									</c:choose>
								</td>

								<td width="20%" align="right" class="form_table_right">
									<div class="field-require">
										<bean:message bundle="employee" key="posittype" />
										:
									</div>
								</td>
								<td width="30%" align="left" class="form_table_left">
									<c:choose>
										<c:when test="${edtState}">
											<html:select property="posittype">

												<html:option value="1">经理</html:option>
											</html:select>
										</c:when>
										<c:otherwise>
											<html:select property="posittype" disabled="true">
												<html:option value="1">经理</html:option>
											</html:select>
										</c:otherwise>
									</c:choose>
								</td>
							</tr>

							<tr>
								<td width="20%" align="right" class="form_table_right">
									<div class="field-require">
										<bean:message bundle="employee" key="joblevel" />
										:
									</div>
								</td>
								<td width="30%" align="left" class="form_table_left">
									<c:choose>
										<c:when test="${edtState}">
											<html:select property="joblevel">
												<option />
													<s:Options definition="$CH_JOBLEVEL" />
											</html:select>
										</c:when>
										<c:otherwise>
											<html:select property="joblevel" disabled="true">
												<option />
													<s:Options definition="$CH_JOBLEVEL" />
											</html:select>
										</c:otherwise>
									</c:choose>
								</td>

								<td width="20%" align="right" class="form_table_right">
									<div class="field-require">
										<bean:message bundle="employee" key="department" />
										:
									</div>
								</td>
								<td width="30%" align="left" class="form_table_left">
									<c:choose>
										<c:when test="${edtState}">
											<html:text styleClass="form_input_1x" property="department" />
											<font color=red></font>
										</c:when>
										<c:otherwise>
											<html:text styleClass="form_input_1x" property="department"
												disabled="true" />
										</c:otherwise>
									</c:choose>
								</td>
							</tr>

							<tr>
								<td width="20%" align="right" class="form_table_right">
									<div class="field-require">
										<bean:message bundle="employee" key="company" />
										:
									</div>
								</td>
								<td width="30%" align="left" class="form_table_left">
									<c:choose>
										<c:when test="${edtState}">
											<html:text styleClass="form_input_1x" property="company"
												maxlength="50" />
										</c:when>
										<c:otherwise>
											<html:text styleClass="form_input_1x" property="company"
												disabled="true" />
										</c:otherwise>
									</c:choose>
								</td>

								<td width="20%" align="right" class="form_table_right">
									<div class="field-require">
										<bean:message bundle="employee" key="worktime" />
										:
									</div>
								</td>
								<td width="30%" align="left" class="form_table_left">
									<c:choose>
										<c:when test="${edtState}">
											<html:text styleClass="form_input_1x" property="worktime"
												maxlength="3" />
										</c:when>
										<c:otherwise>
											<html:text styleClass="form_input_1x" property="worktime"
												disabled="true" />
										</c:otherwise>
									</c:choose>
								</td>
							</tr>

							<tr>
								<td width="20%" align="right" class="form_table_right">
									<div class="field-require">
										<bean:message bundle="employee" key="hereworktime" />
										:
									</div>
								</td>
								<td width="30%" align="left" class="form_table_left">
									<c:choose>
										<c:when test="${edtState}">
											<html:text styleClass="form_input_1x" property="hereworktime"
												maxlength="3" />
										</c:when>
										<c:otherwise>
											<html:text styleClass="form_input_1x" property="hereworktime"
												disabled="true" />
										</c:otherwise>
									</c:choose>
								</td>

								
							

								<td align="right">
									<div class="field-require">
										<bean:message bundle="employee" key="ismarried" />
										:
									</div>
								</td>
								<td align="left" colspan="3">

									<c:choose>
										<c:when test="${edtState}">
											<html:select property="ismarried">
												<option />
													<s:Options definition="$CH_ISMARRIED" />
											</html:select>
										</c:when>
										<c:otherwise>
											<html:select property="ismarried" disabled="true">
												<option />
													<s:Options definition="$CH_ISMARRIED" />
											</html:select>
										</c:otherwise>
									</c:choose>
								</td>


							</tr>

						</table>
					</FIELDSET>
					
				</div>

				<div class="table_div">
					<table class="table_button_list">
						<tr>
							<td>
								<s:PurChk controlid="<%=ID_1%>">
									<input type="button" onmouseover="buttonover(this);"
										onmouseout="buttonout(this);" name="btnSave"
										onfocus="buttonover(this)" onblur="buttonout(this)"
										value="<bean:message bundle="public" key="button_save"/>"
										class="submit"
										onclick="doSave('/cms/ditchmgremployee.do?CMD=DITCHSAVE')" />
								</s:PurChk>
								<s:PurChk controlid="<%=ID_2%>">
									<input type="button" onmouseover="buttonover(this);"
										onmouseout="buttonout(this);" name="btnPrint"
										onfocus="buttonover(this)" onblur="buttonout(this)"
										value="<bean:message bundle="public" key="button_print"/>"
										class="print" onclick="doPrint()">
								</s:PurChk>
								<input type="button" onmouseover="buttonover(this);"
									onmouseout="buttonout(this);" name="btnReturn"
									onfocus="buttonover(this)" onblur="buttonout(this)"
									value="<bean:message bundle="public" key="button_return"/>"
									class="close"
									onclick="doReturn('/cms/ditchmgremployee.do?CMD=DITCHMGRLIST')">
							</td>
						</tr>
					</table>
				</div>

			</html:form>



		</div>
	</body>
</html>
