<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc"%>
<jsp:include page="/inc/acl.jsp">
	<jsp:param name="PID" value="" />
</jsp:include>
<%
	String ID_query = "CH_PW_SOTYEMPLOYEE_QUERY";
	String ID_export = "CH_PW_SOTYEMPLOYEE_EXPORT";
	String ID_add = "CH_PW_SOTYEMPLOYEE_ADD";
	String ID_delete = "CH_PW_SOTYEMPLOYEE_DELETE";
	String ID_edit = "CH_PW_SOTYEMPLOYEE_EDIT";
	String ID_import = "CH_PW_SOTYEMPLOYEE_BATCHIMPORT";
	String ID_CANCEL = "CH_PW_SOTYEMPLOYEE_CANCELSRV";
%>
<html>
	<head>
		<title><bean:message bundle="employee" key="societytitle" />
		</title>
		<script type="text/javascript"
			src="<%=contextPath%>/js/bus/waycommon.js"></script>
		<script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            addfield('_ne_employeeid', '<bean:message bundle="employee" key="_ne_employeeid"/>', 'c', true, '15');
            addfield('_sk_employeename', '<bean:message bundle="employee" key="_sk_employeename"/>', 'c', true, '30');
            addfield('_dnl_intime', '<bean:message bundle="employee" key="_dnl_intime"/>', 't', true, '25');
            addfield('_dnm_intime', '<bean:message bundle="employee" key="_dnm_intime"/>', 't', true, '25');
            addfield('_sk_wayid', '<bean:message bundle="employee" key="_sk_wayid"/>', 'c', true, '18');
            addfield('_se_svccode', '<bean:message bundle="employee" key="_se_svccode"/>', 'c', true, '14');
            return checkval(window);
        }
        
        function societydelete() {
        	var TO = true;
		    var sis = formList.all("_selectitem");

    		if (forincheck(TO,sis,msgConfirmDelete)){
    			formList.action = addParam(contextPath + "/cms/employee.do", 'CMD', 'SOCIETYDELETE');
    			formList.submit();
    		}
    	}
    	function doBatch(cmdStr) {
            formList.action = contextPath + cmdStr;
            formList.submit();
        }
        
    	
    	function doExport(){
        	formList.action = contextPath + "/cms/employee.do?CMD=SOCIETYEXCEL";
      		formList.submit();
      		formList.action = contextPath+"/cms/employee.do?CMD=SOCIETYLIST";
        }
        function doNewSociety() {
    	var url = contextPath + "/cms/employee.do?CMD=ADD&wayid="+document.getElementById("_sk_wayid").value;   	
    	formList.action = url;
    	formList.submit();
		}
		function cancelService(employeeID,mobile,button)
		{
			var url=contextPath + "/cms/employee.do?CMD=cancelService&employeeID="+employeeID+"&mobile="+mobile;
			formList.action=url;
			button.disabled=true;
			formList.submit();
		}
    </script>
	</head>

	<body onload="if(window.loadforiframe) loadforiframe();">
		<div class="table_container">
			<html:form action="/cms/employee.do?CMD=SOCIETYLIST"
				styleId="formList" method="post" onsubmit="return ev_check();">
				<html:hidden property="_orderby" />
				<html:hidden property="_desc" />
				<html:hidden property="_pageno" />
				<html:hidden property="_pagesize" />
				<html:hidden property="KIND" />
				<input type="hidden" name="_rowcount"
					value="<c:out value='${requestScope.LIST.rowCount}' />">
				<!--##################################添加标题内容##################################################-->
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
							<td width="126" height="20" align="right"
								class="form_table_right">
								<bean:message bundle="employee" key="_ne_employeeid" />
								:
							</td>
							<td class="form_table_left">
								<html:text styleClass="form_input_1x" property="_ne_employeeid"></html:text>
							</td>
							<td width="126" height="20" align="right"
								class="form_table_right">
								<bean:message bundle="employee" key="_sk_employeename" />
								:
							</td>
							<td class="form_table_left">
								<html:text styleClass="form_input_1x"
									property="_sk_employeename"></html:text>
							</td>
						</tr>
						<tr>
							<td width="126" height="20" align="right"
								class="form_table_right">
								<bean:message bundle="employee" key="_dnl_intime" />
								:
							</td>
							<td class="form_table_left">
								<html:text styleClass="form_input_1x" property="_dnl_intime"
									onclick="this.value=selectDate()"></html:text>
							</td>
							<td width="126" height="20" align="right"
								class="form_table_right">
								<bean:message bundle="employee" key="_dnm_intime" />
								:
							</td>
							<td class="form_table_left">
								<html:text styleClass="form_input_1x" property="_dnm_intime"
									onclick="this.value=selectDate()"></html:text>
							</td>
						</tr>
						<tr>
							<td width="126" height="20" align="right"
								class="form_table_right">
								<bean:message bundle="employee" key="wayid3" />
								:
							</td>
							<td class="form_table_left">
								<s:WayPicker property="_sk_wayid" waytype="AG" />
							</td>
							<td width="126" height="20" align="right"
								class="form_table_right">
								<bean:message bundle="employee" key="_se_svccode" />
								:
							</td>
							<td class="form_table_left">
								<html:text property="_se_svccode" styleClass="form_input_1x"></html:text>
								<input type="button" name="button1" value="..."
									onclick="showOrgTree(this,'_se_svccode','Svc');">
							</td>
						</tr>
						<tr>
							<td width="126" height="20" align="right"
								class="form_table_right">
								<bean:message bundle="employee" key="officetel2" />
								:
							</td>
							<td class="form_table_left">
								<html:text property="_se_officetel" styleClass="form_input_1x"></html:text>
							</td>
							<td width="126" height="20" align="right"
								class="form_table_right">
								<bean:message bundle="employee" key="isnet" />
								:
							</td>
							<td class="form_table_left">
								<html:select property="_ne_isnet">
									<option />
										<s:Options definition="$CH_ISNET" />
								</html:select>
							</td>
						</tr>
						<tr>
							<td width="126" height="20" align="right"
								class="form_table_right">
								<bean:message bundle="employee" key="isopen" />
								:
							</td>
							<td class="form_table_left">
								<html:select property="_ne_isopen">
									<option />
										<s:Options definition="$CH_ISOPEN" />
								</html:select>
							</td>
							<td width="126" height="20" align="right"
								class="form_table_right">
								<bean:message bundle="employee" key="empstatus" />
								:
							</td>
							<td class="form_table_left">
								<html:select property="_ne_empstatus">
									<option />
										<s:Options definition="$CH_EMPSTATUS" />
								</html:select>
							</td>
						</tr>
			<tr>
                <td width="126" height="20" align="right" class="form_table_right">
                	<bean:message bundle="employee" key="selectmobile"/>:
                </td>
                <td class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_se_selectmobile"></html:text>
                </td>
                <td width="126" height="20" align="right" class="form_table_right">
                	&nbsp;
               	</td>
                <td class="form_table_left">
                    &nbsp;
                </td>
            </tr>
					</table>
				</div>
				<div class="table_div">
					<table class="table_button_list">
						<tr>
							<td align=right>
								<s:PurChk2 controlid="<%=ID_query%>">
									<input type="button" class="query" onclick="doQuery();" 
										onmouseover="buttonover(this);" onmouseout="buttonout(this);"
										onfocus="buttonover(this)" onblur="buttonout(this)"
										value="<bean:message bundle='public' key='button_search'/>" />
								</s:PurChk2>
								<s:PurChk2 controlid="<%=ID_export%>">
									<input type="button" class="button_4"
										onmouseover="buttonover(this);" onmouseout="buttonout(this);"
										onfocus="buttonover(this)" onblur="buttonout(this)"
										value="<bean:message bundle="employee" key="batchExport"/>"
										onclick="doExport()" />
								</s:PurChk2>
								<s:PurChk2 controlid="<%=ID_add%>">
									<input type="button" name="btnNew" class="add"
										onmouseover="buttonover(this);" onmouseout="buttonout(this);"
										onfocus="buttonover(this)" onblur="buttonout(this)"
										value="<bean:message bundle="public" key="button_new"/>"
										onClick="doNewSociety()">
								</s:PurChk2>
								<s:PurChk2 controlid="<%=ID_import%>">
									<input type="button" class="add"
										onmouseover="buttonover(this);" onmouseout="buttonout(this);"
										onfocus="buttonover(this)" onblur="buttonout(this)"
										value="<bean:message bundle="employee" key="import"/>"
										onClick="doBatch('/cms/societyemployee.do?CMD=SOCIETYBATCH');" />
								</s:PurChk2>
								<s:PurChk2 controlid="<%=ID_delete%>">
									<input type="button" name="btnDelete" class="delete"
										onmouseover="buttonover(this);" onmouseout="buttonout(this);"
										onfocus="buttonover(this)" onblur="buttonout(this)"
										value="<bean:message bundle="public" key="button_delete"/>"
										onClick="societydelete();">
								</s:PurChk2>
							</td>
						</tr>
					</table>
				</div>

				<div class="table_div">
					<div class="table_LongTable">
						<table class="table_style" ID="Table2">
							<tr class="table_style_head">
								<td
									title="<bean:message bundle='public' key='list_title_select'/>">
									<input type="checkbox" name="allbox" onclick="checkAll();"
										class="table_checkbox">
								</td>
								<td>
									<a href="javascript:doOrderby('employeeid')"><bean:message
											bundle="employee" key="employeeid" /> </a>
									<s:OrderImg form="/cms/employee/employeeForm"
										field="employeeid" />
								</td>
								<td>
									<a href="javascript:doOrderby('employeename')"><bean:message
											bundle="employee" key="employeename" /> </a>
									<s:OrderImg form="/cms/employee/employeeForm"
										field="employeename" />
								</td>
								<td>
									<a href="javascript:doOrderby('birthday')"><bean:message
											bundle="employee" key="birthday" /> </a>
									<s:OrderImg form="/cms/employee/employeeForm" field="birthday" />
								</td>
								<td>
									<a href="javascript:doOrderby('sex')"><bean:message
											bundle="employee" key="sex" /> </a>
									<s:OrderImg form="/cms/employee/employeeForm" field="sex" />
								</td>
								<td>
									<a href="javascript:doOrderby('empstatus')"><bean:message
											bundle="employee" key="empstatus" /> </a>
									<s:OrderImg form="/cms/employee/employeeForm" field="empstatus" />
								</td>
								<td>
									<a href="javascript:doOrderby('cardid')"><bean:message
											bundle="employee" key="cardid" /> </a>
									<s:OrderImg form="/cms/employee/employeeForm" field="cardid" />
								</td>
								<td>
									<a href="javascript:doOrderby('telephone')"><bean:message
											bundle="employee" key="telephone" /> </a>
									<s:OrderImg form="/cms/employee/employeeForm" field="telephone" />
								</td>
								<td>
									<a href="javascript:doOrderby('cityid')"><bean:message
											bundle="employee" key="cityid" /> </a>
									<s:OrderImg form="/cms/employee/employeeForm" field="cityid" />
								</td>
								<td>
									<a href="javascript:doOrderby('countyid')"><bean:message
											bundle="employee" key="countyid" /> </a>
									<s:OrderImg form="/cms/employee/employeeForm" field="countyid" />
								</td>
								<td>
									<a href="javascript:doOrderby('svccode')"><bean:message
											bundle="employee" key="svccode" /> </a>
									<s:OrderImg form="/cms/employee/employeeForm" field="svccode" />
								</td>
								<td>
									<a href="javascript:doOrderby('wayid')">渠道编码</a>
									<s:OrderImg form="/cms/employee/employeeForm" field="wayid" />
								</td>
								<td>
									<a href="javascript:doOrderby('wayid')"> 渠道名称</a>
									<s:OrderImg form="/cms/employee/employeeForm" field="wayid" />
								</td>
								<td>
									<a href="javascript:doOrderby('intime')"><bean:message
											bundle="employee" key="intime" /> </a>
									<s:OrderImg form="/cms/employee/employeeForm" field="intime" />
								</td>


								<td>
									<a href="javascript:doOrderby('employtype')"><bean:message
											bundle="employee" key="employtype" /> </a>
									<s:OrderImg form="/cms/employee/employeeForm"
										field="employtype" />
								</td>

								<td>
									<a href="javascript:doOrderby('employtype')"><bean:message
											bundle="employee" key="bail" /> </a>
									<s:OrderImg form="/cms/employee/employeeForm" field="bail" />
								</td>
								<td>
									<a href="javascript:doOrderby('officetel')"><bean:message
											bundle="employee" key="officetel2" /> </a>
									<s:OrderImg form="/cms/employee/employeeForm" field="officetel" />
								</td>
								<td>
									退订服务
								</td>
								<td>
									<a href="javascript:doOrderby('isnet')"><bean:message
											bundle="employee" key="isnet" /> </a>
									<s:OrderImg form="/cms/employee/employeeForm" field="isnet" />
								</td>
								<td>
									<a href="javascript:doOrderby('isopen')"><bean:message
											bundle="employee" key="isopen" /> </a>
									<s:OrderImg form="/cms/employee/employeeForm" field="isopen" />
								</td>
								<td>
									<a href="javascript:doOrderby('netpass')"><bean:message
											bundle="employee" key="netpass" /> </a>
									<s:OrderImg form="/cms/employee/employeeForm" field="netpass" />
								</td>
								<td>
									<a href="javascript:doOrderby('netpass')"><bean:message
											bundle="employee" key="selectmobile" /> </a>
									<s:OrderImg form="/cms/employee/employeeForm" field="selectmobile" />
								</td>
							</tr>
							<c:forEach var="item" items="${requestScope.LIST.datas}">
								<c:url value="/cms/employee.do?CMD=SOCIETYEDIT&KIND=G"
									var="urlContent">
									<%
									//this param name must "PK"
									%>
									<c:param name="PK" value="${item.employeeid}" />
									<%-- <c:param name="PK" value="'${item.id}|${item.id2}'"/> --%>
								</c:url>
								<tr class="table_style_content" align="center">
									<td>
										<input type="checkbox" name="_selectitem"
											value="<c:out value='${item.employeeid}' />"
											onclick="checkOne();" class="table_checkbox">
									</td>
									<td>
										<s:PurChk2 controlid="<%=ID_edit%>" disableChild="true">
											<a href='<c:out value="${urlContent}"/>'> <c:out
													value="${item.employeeid}" /> </a>
										</s:PurChk2>
									</td>
									<td>
										<c:out value="${item.employeename}" />
									</td>
									<td>
										<c:out value="${item.birthday}" />
									</td>
									<td>
										<s:Code2Name code="${item.sex}" definition="$CH_SEX" />
									</td>
									<td>
										<s:Code2Name code="${item.empstatus}"
											definition="$CH_EMPSTATUS" />
									</td>
									<td>
										<c:out value="${item.cardid}" />
									</td>
									<td>
										<c:out value="${item.telephone}" />
									</td>
									<td>
										<s:Code2Name code="${item.cityid}" definition="#CITYCOMPANY" />
									</td>
									<td>
										<s:Code2Name code="${item.countyid}" definition="#CNTYCOMPANY" />
									</td>
									<td>
										<s:Code2Name code="${item.svccode}" definition="#CH_SERVCENT" />
									</td>
									<td>
										<c:out value="${item.wayid}" />
									</td>
									<td>
										<s:Code2Name code="${item.wayid}" definition="#WAY" />
									</td>
									<td>
										<c:out value="${item.intime}" />
									</td>
									<td>
										<s:Code2Name code="${item.employtype}"
											definition="$CH_EMPLOYTYPE" />
									</td>
									<td>
										<c:out value="${item.bail}" />
									</td>
									<td>
										<c:out value="${item.officetel}" />
									</td>
									<td>
											<s:PurChk2 controlid="<%=ID_CANCEL%>" disableChild="true">
													<c:if test="${(item.isopen eq 1) and (item.empstatus eq 1) and (item.isnet eq 1 or item.isnet eq 0) and (empty item.cancelFlag)}">
															<input type="button" class="button_4"
															onmouseover="buttonover(this);"
															onmouseout="buttonout(this);" onfocus="buttonover(this)"
															onblur="buttonout(this)" value="取消服务"
															onclick="cancelService('<c:out value='${item.employeeid}' />','<c:out value='${item.officetel}' />',this)" />
													</c:if>
													<c:if test="${(item.isopen eq 1) and (item.empstatus eq 1) and (item.isnet eq 1 or item.isnet eq 0) and (item.cancelFlag eq '1')}">
															<input type="button" class="button_4"
															onmouseover="buttonover(this);"
															onmouseout="buttonout(this);" onfocus="buttonover(this)"
															onblur="buttonout(this)" value="取消服务"
															 disabled="true"/>
													</c:if>
											</s:PurChk2>
									</td>
									<td>
										<s:Code2Name code="${item.isnet}" definition="$CH_ISNET" />
									</td>
									<td>
										<s:Code2Name code="${item.isopen}" definition="$CH_ISOPEN" />
									</td>
									<td>
										<c:out value="${item.netpass}" />
									</td>
								    <td> <c:out value="${item.selectmobile}"/> </td>
								</tr>
							</c:forEach>
						</table>
					</div>
				</div>

				<div class="table_div">
					<s:PageNav dpName="LIST" />
				</div>
			</html:form>
		</div>
	</body>
</html>
