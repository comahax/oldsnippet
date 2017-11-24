<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc"%>
<%
	String ID_QUERY = "CH_PW_WAYMANAGER_QUERY";
	String ID_ADD = "CH_PW_WAYMANAGER_ADD";
	String ID_DELETE = "CH_PW_WAYMANAGER_DELETE";
	String ID_EDIT = "CH_PW_WAYMANAGER_EDIT";
	String ID_BATCHIMPORT = "CH_PW_WAYMANAGER_BATCHIMPORT";
	String ID_EXPORT = "CH_PW_WAYMANAGER_EXPORT";
%>
<html>
	<head>
		<title><bean:message bundle="employee" key="ditchmgrtitle" />
		</title>
		<script type="text/javascript"
			src="<%=contextPath%>/js/bus/waycommon.js"></script>
		<script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            addfield('_ne_employeeid', '<bean:message bundle="employee" key="employeeid"/>', 'c', true, '15');
            addfield('_sk_oprcode2', '<bean:message bundle="employee" key="oprcode"/>', 'c', true, '15');
            addfield('_sk_employeename', '<bean:message bundle="employee" key="employeename"/>', 'c', true, '30');
            addfield('_sk_wayid', '<bean:message bundle="employee" key="wayid2"/>', 'c', true, '18');
            addfield('_ne_station', '<bean:message bundle="employee" key="station"/>', 'f', true, '14');
            addfield('_dnl_intime', '<bean:message bundle="employee" key="intime"/>', 't', true, '25');
            addfield('_se_svccode', '<bean:message bundle="employee" key="svccode"/>', 'c', true, '14');
            return checkval(window);
        }

function doDelete(cmdDelete) {
    var TO = true;
    var sis = formList.all("_selectitem");

    if (forincheck(TO,sis,msgConfirmDelete)){
    	formList.action = addParam(contextPath + cmdDelete, 'CMD', 'DITCHMGRDELETE');
    	formList.submit();
    	}  
}
 	function goTo(cmdNew) {
		    var url = contextPath + cmdNew;
		    formList.action = url;
		    formList.submit();
		}
	function excelout() {
      formList.action = contextPath + "/cms/ditchmgremployee.do?CMD=DITCHMGREXCEL";
      formList.submit();
      formList.action = contextPath+"/cms/ditchmgremployee.do?CMD=DITCHMGRLIST";
  }
  	 function doBatch(cmd)
  	 {
  	 	formList.action = contextPath + "/cms/ditchmgremployee.do?CMD=MGRWAYEXCEL&employyid="+cmd;
  	 	formList.submit();
  	 	formList.action = contextPath+"/cms/ditchmgremployee.do?CMD=DITCHMGRLIST";
  	 }
    </script>
	</head>

	<body onload="if(window.loadforiframe) loadforiframe();">
		<div class="table_container">
			<html:form action="/cms/ditchmgremployee.do?CMD=DITCHMGRLIST"
				styleId="formList" method="post" onsubmit="return ev_check();">
				<html:hidden property="_orderby" />
				<html:hidden property="_desc" />
				<html:hidden property="_pageno" />
				<html:hidden property="_pagesize" />
				<input type="hidden" name="_rowcount"
					value="<c:out value='${requestScope.LIST.rowCount}' />">

				<!--##################################添加标题内容##################################################-->
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
					<table class="form_table">
						<tr>
							<td width="126" height="20" align="right"
								class="form_table_right">
								<bean:message bundle="employee" key="employeeid" />
								:
							</td>
							<td class="form_table_left">
								<html:text styleClass="form_input_1x" property="_ne_employeeid"></html:text>
							</td>
							<td width="126" height="20" align="right"
								class="form_table_right">
								<bean:message bundle="employee" key="oprcode2" />
								:
							</td>
							<td class="form_table_left">
								<html:text styleClass="form_input_1x" property="_sk_oprcode2"></html:text>
							</td>
						</tr>
						<tr>
							<td width="126" height="20" align="right"
								class="form_table_right">
								<bean:message bundle="employee" key="employeename" />
								:
							</td>
							<td class="form_table_left">
								<html:text styleClass="form_input_1x"
									property="_sk_employeename"></html:text>
							</td>

							<td width="126" height="20" align="right"
								class="form_table_right">
								<bean:message bundle="employee" key="svccode" />
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
								<bean:message bundle="employee" key="wayid2" />
								:
							</td>
							<td class="form_table_left">
								<html:hidden property="_sk_wayid" />
								<input type="text" name="way_name"
									value='<c:out value="${requestScope['/cms/employee/EmployeeForm']._sk_wayid}"/> <s:Code2Name code="${requestScope['/cms/employee/EmployeeForm']._sk_wayid}" definition="#WAY"/>'
									onclick="showSelectWay(this,'_sk_wayid')" readonly="readonly" class="form_input_1x">

							</td>
							<td width="126" height="20" align="right"
								class="form_table_right">
								<bean:message bundle="employee" key="_ne_station" />
								:
							</td>
							<td class="form_table_left">
								<html:select property="_ne_station">
									<option />
										<s:Options definition="#CH_POSTINFO" />
								</html:select>
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
					</table>
				</div>
				<div class="table_div">
					<table class="table_button_list">
						<tr>
							<td align=right>
								<s:PurChk2 controlid="<%=ID_QUERY%>">
									<input type="button" class="query" onclick="doQuery();" 
										onmouseover="buttonover(this);" onmouseout="buttonout(this);"
										onfocus="buttonover(this)" onblur="buttonout(this)"
										value="<bean:message bundle="public" key="button_search"/>" />
								</s:PurChk2>
								<s:PurChk2 controlid="<%=ID_EXPORT%>">
									<input type="button" name="btnNew" class="button_4"
										onmouseover="buttonover(this);" onmouseout="buttonout(this);"
										onfocus="buttonover(this)" onblur="buttonout(this)"
										value="<bean:message bundle="employee" key="batchExport"/>"
										onClick="excelout()">

								</s:PurChk2>
								<s:PurChk2 controlid="<%=ID_ADD%>">
									<input type="button" name="btnNew" class="add"
										onmouseover="buttonover(this);" onmouseout="buttonout(this);"
										onfocus="buttonover(this)" onblur="buttonout(this)"
										value="<bean:message bundle="public" key="button_new"/>"
										onClick="doNew('/cms/ditchmgremployee.do')">
								</s:PurChk2>
								<s:PurChk2 controlid="<%=ID_BATCHIMPORT%>">
									<input type="button" name="btnNew" class="button_4"
										onmouseover="buttonover(this);" onmouseout="buttonout(this);"
										onfocus="buttonover(this)" onblur="buttonout(this)"
										value="<bean:message bundle="employee" key="import"/>"
										onClick="goTo('/cms/ditchmgremployee/batch.jsp')">
								</s:PurChk2>
								<s:PurChk2 controlid="<%=ID_DELETE%>">
									<input type="button" name="btnDelete" class="delete"
										onmouseover="buttonover(this);" onmouseout="buttonout(this);"
										onfocus="buttonover(this)" onblur="buttonout(this)"
										value="<bean:message bundle="public" key="button_delete"/>"
										onClick="doDelete('/cms/ditchmgremployee.do')">
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
									title="<bean:message bundle="public" key="list_title_select"/>">
									<input type="checkbox" name="allbox" onclick="checkAll();"
										class="table_checkbox">
								</td>
								
								<td>
									<a href="javascript:doOrderby('employeeid')"><bean:message
											bundle="employee" key="employeeid" />
									</a>
									<s:OrderImg form="/cms/employee/employeeForm"
										field="employeeid" />
								</td>
								
								<td>
									<a href="javascript:doOrderby('oprcode2')"><bean:message
											bundle="employee" key="oprcode2" />
									</a>
									<s:OrderImg form="/cms/employee/employeeForm" field="oprcode2" />
								</td>
								<td>
									<a href="javascript:doOrderby('employeename')"><bean:message
											bundle="employee" key="employeename" />
									</a>
									<s:OrderImg form="/cms/employee/employeeForm"
										field="employeename" />
								</td>

								<td>
									<a href="javascript:doOrderby('sex')"><bean:message
											bundle="employee" key="sex" />
									</a>
									<s:OrderImg form="/cms/employee/employeeForm" field="sex" />
								</td>
								<td>
									<a href="javascript:doOrderby('ofcphone')"><bean:message
											bundle="employee" key="telephone" />
									</a>
									<s:OrderImg form="/cms/employee/employeeForm" field="telephone" />
								</td>
								<td>
									<a href="javascript:doOrderby('cityid')"><bean:message
											bundle="employee" key="cityid" />
									</a>
									<s:OrderImg form="/cms/employee/employeeForm" field="cityid" />
								</td>
								<td>
									<a href="javascript:doOrderby('countyid')"><bean:message
											bundle="employee" key="countyid" />
									</a>
									<s:OrderImg form="/cms/employee/employeeForm" field="countyid" />
								</td>
								<td>
									<a href="javascript:doOrderby('svccode')"><bean:message
											bundle="employee" key="svccode" />
									</a>
									<s:OrderImg form="/cms/employee/employeeForm" field="svccode" />
								</td>

								<td>
									<a href="javascript:doOrderby('servoffice')"><bean:message
											bundle="employee" key="wayid2" />
									</a>
									<s:OrderImg form="/cms/employee/employeeForm" field="wayid" />
								</td>
								<td>
									<a href="javascript:doOrderby('station')"><bean:message
											bundle="employee" key="station" />
									</a>
									<s:OrderImg form="/cms/employee/employeeForm" field="station" />
								</td>

								<td>
									<a href="javascript:doOrderby('intime')"><bean:message
											bundle="employee" key="intime" />
									</a>
									<s:OrderImg form="/cms/employee/employeeForm" field="intime" />
								</td>

								<td>
									<a href="javascript:doOrderby('employtype')"><bean:message
											bundle="employee" key="employtype" />
									</a>
									<s:OrderImg form="/cms/employee/employeeForm"
										field="employtype" />
								</td>
								<td>
									管辖网点信息导出
								</td>
							</tr>
							<c:forEach var="item" items="${requestScope.LIST.datas}">
								<c:url value="/cms/ditchmgremployee.do?CMD=DITCHMGREDIT"
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
										<s:PurChk2 controlid="<%=ID_EDIT%>" disableChild="true">
											<a href='<c:out value="${urlContent}"/>'> <c:out
													value="${item.employeeid}" /> </a>
										</s:PurChk2>
									</td>
									<td>
										<c:out value="${item.oprcode2}" />
									</td>
									<td>
										<c:out value="${item.employeename}" />
									</td>
									<td>
										<s:Code2Name code="${item.sex}" definition="$CH_SEX" />
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
										<s:Code2Name code="${item.wayid}" definition="#WAY" />
									</td>

									<td>
										<s:Code2Name code="${item.station}" definition="#CH_POSTINFO" />
									</td>

									<td>
										<c:out value="${item.intime}" />
									</td>

									<td>
										<s:Code2Name code="${item.employtype}"
											definition="$CH_EMPLOYTYPE" />
									</td>
									<td>
										<input type="button" value="管辖网点信息导出" class="button_8" onclick="doBatch('<c:out value="${item.employeeid}" />')" />
									</td>
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
