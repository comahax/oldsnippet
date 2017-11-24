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
		<title><bean:message bundle="employee" key="serveralltitle" />
		</title>
		<script type="text/javascript"
			src="<%=contextPath%>/js/bus/waycommon.js">
		</script>

	</head>
	<body onload="if(window.loadforiframe) loadforiframe();">
		<div class="table_container">
			<html:form action="/cms/zjty/zjtyemployeedetail.do?CMD=EDIT"
				styleId="formItem" method="post">

				<!--##################################添加标题内容##################################################-->
				<html:hidden property="cmdState" />
				<html:hidden property="ditchFlag" />

				<html:hidden property="_orderby" />
				<html:hidden property="_desc" />
				<html:hidden property="_pageno" />
				<html:hidden property="_pagesize" />
				<html:hidden property="employeeid" />
				<html:hidden property="cityid" />
				<html:hidden property="wayid" />
				<div class="table_div">
					<table class="top_table">
						<tr>
							<td>
								<bean:message bundle="employee" key="societytitle" />
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
						<legend name="baseinfo">
							<bean:message bundle="employee" key="baseinfo" />
						</legend>
						<html:hidden property="waytype" value="AG" />
						<table class="form_table">
							<tr>
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
											<font color=red>&nbsp;*</font>
										</c:otherwise>
									</c:choose>
								</td>
							</tr>
							<tr>
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
											<font color=red>&nbsp;*</font>
										</c:when>
										<c:otherwise>
											<html:select property="sex" disabled="true">
												<s:Options definition="$CH_SEX" />
											</html:select>
											<font color=red>&nbsp;*</font>
										</c:otherwise>
									</c:choose>
								</td>
								<td width="20%" align="right" class="form_table_right">
									<div class="field-require">
										<bean:message bundle="employee" key="isnet" />
										:
									</div>
								</td>
								<td width="30%" align="left" class="form_table_left">
									<c:choose>
										<c:when test="${edtState}">
											<html:select property="isnet">
												<option />
													<html:option value="0">店员</html:option>
													<html:option value="1">店主</html:option>
											</html:select>
											<font color=red>&nbsp;*</font>
										</c:when>
										<c:otherwise>
											<html:select property="isnet" disabled="true">
												<option />
													<s:Options definition="$CH_ISNET" />
											</html:select>
											<font color=red>&nbsp;*</font>
										</c:otherwise>
									</c:choose>
								</td>
							</tr>
							<tr>
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
							</tr>
							<tr>
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
										<bean:message bundle="employee" key="officetel2" />
										:
									</div>
								</td>
								<td width="30%" align="left" class="form_table_left">
									<c:choose>
										<c:when test="${edtState}">
											<c:if test="${updateState}">
												<c:if test="${!istelnull}">
													<html:text styleClass="form_input_1x" property="officetel"
														maxlength="11" />
													<font color=red>&nbsp;*</font>
												</c:if>
												<c:if test="${istelnull}">
													<html:text styleClass="form_input_1x" property="officetel"
														maxlength="11" onblur="pullValue()" />
													<font color=red>&nbsp;*</font>
												</c:if>
											</c:if>
											<c:if test="${!updateState}">
												<html:text styleClass="form_input_1x" property="officetel"
													maxlength="11" onblur="pullValue()" />
												<font color=red>&nbsp;*</font>

											</c:if>
										</c:when>
										<c:otherwise>
											<html:text styleClass="form_input_1x" property="officetel"
												disabled="true" />
											<font color=red>&nbsp;*</font>
										</c:otherwise>
									</c:choose>
								</td>
								<td width="20%" align="right" class="form_table_right">
									<div class="field-require">
										<bean:message bundle="employee" key="selectmobile" />
										:
									</div>
								</td>
								<td width="30%" align="left" class="form_table_left">
									<c:choose>
										<c:when test="${edtState}">
											<html:text styleClass="form_input_1x" property="selectmobile"
												maxlength="12" />
										</c:when>
										<c:otherwise>
											<html:text styleClass="form_input_1x" property="selectmobile"
												disabled="true" />
										</c:otherwise>
									</c:choose>
								</td>
							</tr>
							<tr>
								<td width="20%" align="right" class="form_table_right">
									<div class="field-require">
										<bean:message bundle="employee" key="oprcode2" />
										:
									</div>
								</td>
								<td width="30%" align="left" class="form_table_left">
									<c:choose>
										<c:when test="${edtState}">
											<c:if test="${updateState}">
												<c:if test="${!istelnull}">
													<html:text styleClass="form_input_1x" property="oprcode2"
														maxlength="11" />
												</c:if>
												<c:if test="${istelnull}">
													<html:text styleClass="form_input_1x" property="oprcode2"
														maxlength="11" onblur="pullValue()" />
												</c:if>
											</c:if>
											<c:if test="${!updateState}">
												<html:text styleClass="form_input_1x" property="oprcode2"
													maxlength="11" onblur="pullValue()" />

											</c:if>
										</c:when>
										<c:otherwise>
											<html:text styleClass="form_input_1x" property="oprcode2"
												disabled="true" />
										</c:otherwise>
									</c:choose>
								</td>
								<td width="20%" align="right" class="form_table_right">
                	<bean:message bundle="employee" key="right"/>:
                </td>
                <td width="30%" align="left" class="form_table_left">
                	 <c:choose>
                        <c:when test="${edtState}">
                        	  <html:select property="right" disabled="true">
                        	  		<option/>
                        		    <s:Options definition="$CH_EMPLOYEETYPE"/>
                        	  </html:select>
                        </c:when>
                        <c:otherwise>
                        	  <html:select property="right" disabled="true" >
                        	  		<option/>
                        		    <s:Options definition="$CH_EMPLOYEETYPE"/>
                        	  </html:select>
                        </c:otherwise>
                    </c:choose>
                </td>
							</tr>
							<tr>
								<td colspan=4>
									<div align='center'>
										<font color=red>在岗人员采集平台捆绑手机号,空中选号手机号必须唯一</font>
									</div>
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
												value='<c:out value="${requestScope['/cms/zjty/ZjtyEmployeedetailForm'].cityid}"/> <s:Code2Name code="${requestScope['/cms/zjty/ZjtyEmployeedetailForm'].cityid}" definition="#CITYCOMPANY"/>'
												readonly="readonly" class="form_input_1x">
											<font color=red>&nbsp;*</font>
										</c:when>
										<c:otherwise>
											<html:hidden property="cityid" />
											<input type="text" name="citycompname"
												value='<c:out value="${requestScope['/cms/zjty/ZjtyEmployeedetailForm'].cityid}"/> <s:Code2Name code="${requestScope['/cms/zjty/ZjtyEmployeedetailForm'].cityid}" definition="#CITYCOMPANY"/>'
												disabled="TRUE" class="form_input_1x">
											<font color=red>&nbsp;*</font>
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
												value='<c:out value="${requestScope['/cms/zjty/ZjtyEmployeedetailForm'].countyid}"/> <s:Code2Name code="${requestScope['/cms/zjty/ZjtyEmployeedetailForm'].countyid}" definition="#CNTYCOMPANY"/>'
												readonly="readonly" class="form_input_1x">
											<font color=red>&nbsp;*</font>
										</c:when>
										<c:otherwise>
											<html:hidden property="countyid" />
											<input type="text" name="countycompname"
												value='<c:out value="${requestScope['/cms/zjty/ZjtyEmployeedetailForm'].countyid}"/> <s:Code2Name code="${requestScope['/cms/zjty/ZjtyEmployeedetailForm'].countyid}" definition="#CNTYCOMPANY"/>'
												disabled="true" class="form_input_1x">
											<font color=red>&nbsp;*</font>
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
									<div class="field-require">
										<bean:message bundle="employee" key="wayid3" />
										:
									</div>
								</td>
								<td width="30%" align="left" class="form_table_left">
									<c:choose>
										<c:when test="${edtState}">
											<c:if test="${updateState}">
												<html:hidden property="wayid" />
												<input type="text" name="way_name" id="way_name"
													value='<c:out value="${requestScope['/cms/employee/EmployeeForm'].wayid}"/> <s:Code2Name code="${requestScope['/cms/employee/EmployeeForm'].wayid}" definition="#WAY"/>'
													disabled="true" class="form_input_1x">
												<font color=red>&nbsp;*</font>
											</c:if>
											<c:if test="${!updateState}">
												<html:hidden property="wayid" />
												<input type="text" name="way_name" id="way_name"
													value='<c:out value="${requestScope['/cms/employee/EmployeeForm'].wayid}"/> <s:Code2Name code="${requestScope['/cms/employee/EmployeeForm'].wayid}" definition="#WAY"/>'
													onclick="changeWay()" readonly="readonly"
													class="form_input_1x">
												<font color=red>&nbsp;*</font>
											</c:if>
										</c:when>
										<c:otherwise>
											<html:text styleClass="form_input_1x" property="wayid"
												disabled="true" />
										</c:otherwise>
									</c:choose>
								</td>
							</tr>
						</table>
					</FIELDSET>

					<FIELDSET>
						<legend name="employinfo">
							<bean:message bundle="employee" key="employinfo" />
						</legend>
						<table class="form_table">
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
												maxlength="10" onclick="this.value=selectDate()" />
											<font color=red>&nbsp;*</font>
										</c:when>
										<c:otherwise>
											<html:text styleClass="form_input_1x" property="intime"
												disabled="true" />
											<font color=red>&nbsp;*</font>
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
											<font color=red>&nbsp;*</font>
										</c:when>
										<c:otherwise>
											<html:select property="contacttype" disabled="true">
												<option />
													<s:Options definition="$CH_CONTACTTYPE" />
											</html:select>
											<font color=red>&nbsp;*</font>
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
											<font color=red>&nbsp;*</font>
										</c:when>
										<c:otherwise>
											<html:select property="employtype" disabled="true">
												<option />
													<s:Options definition="$CH_EMPLOYTYPE" />
											</html:select>
											<font color=red>&nbsp;*</font>
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
											<font color=red>&nbsp;*</font>
										</c:when>
										<c:otherwise>
											<html:select property="empstatus" disabled="true">
												<option />
													<s:Options definition="$CH_EMPSTATUS" />
											</html:select>
											<font color=red>&nbsp;*</font>
										</c:otherwise>
									</c:choose>
								</td>
							</tr>
							<tr>
								<td width="20%" align="right" class="form_table_right">
									<div class="field-require">
										<bean:message bundle="employee" key="bail" />
										:
									</div>
								</td>
								<td width="30%" align="left" class="form_table_left">
									<c:choose>
										<c:when test="${edtState}">
											<html:text styleClass="form_input_1x" property="bail"
												maxlength="64" />
										</c:when>
										<c:otherwise>
											<html:text styleClass="form_input_1x" property="bail"
												disabled="true" />
										</c:otherwise>
									</c:choose>
								</td>
								<td width="20%" align="right" class="form_table_right"></td>
								<td width="30%" align="left" class="form_table_left">
								</td>
							</tr>
						</table>
					</FIELDSET>
					
					<FIELDSET>
        	<legend name="employinfo"><bean:message bundle="employee" key="workmode"/></legend>
        <table class="form_table">            
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="employee" key="isunpb"/>:</div></td>
                <td width="80%" align="left" colspan="3" class="form_table_left">
                	 <c:choose>
                        <c:when test="${edtState}">
                            <html:checkbox property="isunpb" />   
                        </c:when>
                        <c:otherwise>
                            <html:checkbox property="isunpb" disabled="true"/>   
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
								<input type="button" onmouseover="buttonover(this);"
									onmouseout="buttonout(this);" name="btnReturn"
									onfocus="buttonover(this)" onblur="buttonout(this)"
									value="<bean:message bundle="public" key="button_return"/>"
									class="close"
									onclick="doReturn('/cms/zjty/zjtyemployeedetail.do?CMD=LIST')">
							</td>
						</tr>
					</table>
				</div>
			</html:form>
		</div>
	</body>
</html>
