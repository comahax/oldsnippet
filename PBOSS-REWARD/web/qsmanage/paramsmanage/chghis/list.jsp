<%@ page language="java" contentType="text/html;charset=GBK"%>

<%@ include file="/inc/listhead.inc"%>
<link href="<%=contextPath%>/css/css_1/iframemenu.css" rel="stylesheet"
	type="text/css" media="all" />
<jsp:include page="/inc/acl.jsp">
	<jsp:param name="PID" value="1A2BA0G0" />
</jsp:include>
<%
	int i = 1;
%>
<html>
	<head>
		<title><bean:message bundle="chghis" key="titleList" /></title>
		<script language="JavaScript" type="text/JavaScript"
			src="<%=contextPath%>/js/bus/waycommon.js"></script>
		<script type="text/javascript"
			src="<%=contextPath%>/js/bus/rescommon.js"></script>
		<script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            addfield('_ne_tabtype', '<bean:message bundle="chghis" key="tabtype"/>', 'l', true, 11);
            addfield('_se_tabname', '<bean:message bundle="chghis" key="tabname"/>', 'c', true, 40);
            addfield('_se_oprtype', '<bean:message bundle="chghis" key="oprtype"/>', 'c', true, 18);
            addfield('_se_oprcode', '<bean:message bundle="chghis" key="oprcode"/>', 'c', true, 15);
            addfield('_dnl_oprtime', '<bean:message bundle="chghis" key="oprtime"/>', 'dt', true, 7);
            addfield('_dnm_oprtime', '<bean:message bundle="chghis" key="oprtime"/>', 'dt', true, 7);
            addfield('_ne_chgtype', '<bean:message bundle="chghis" key="chgtype"/>', 'i', true, 3);
            addfield('_ne_matchid', '<bean:message bundle="chghis" key="matchid"/>', 'l', true, 14);
            //开始日期不能大于结束日期,有一方为空则不比较
			//date_compare('开始时间input名字','开始时间input名字','中文出错信息');
            if(date_compare('_dnl_oprtime','_dnm_oprtime','<bean:message bundle="res" key="timecompare1"/>')) return;
            return checkval(window);
        }
        
         //去掉字符串中空格
        function ignorecresourcelogpaces(string) {
			var temp = "";
			string = '' + string;
			splitstring = string.split(" "); //双引号之间是个空格；
			for(i = 0; i < splitstring.length; i++)
			temp += splitstring[i];
			return temp;
		}
		
		function doExcelOut(fileType) {
        	setResExcelOutPageNew(fileType,'com.sunrise.boss.business.resmanage.qscschghis.persistent.QscsChgHisVO');	        	
        }
        
         function showDeta(conditionStr) {				
			if(conditionStr != null && conditionStr != ""){
				var url = contextPath + '/qsmanage/paramsmanage/chghis.do?CMD=SHOWDETA' + "&" + conditionStr;
				var hWnd = window.showModalDialog(url,new Array(),"dialogWidth:620px; dialogHeight:250px; status:no;resizable:yes;");				
			}
		}
    </script>
	</head>

	<body onload="loadforiframe();">
		<div class="table_container">
			<html:form action="/qsmanage/paramsmanage/chghis.do?CMD=LIST"
				styleId="formList" method="post" onsubmit="return ev_check();">
				<html:hidden property="_orderby" />
				<html:hidden property="_desc" />
				<html:hidden property="_pageno" />
				<html:hidden property="_displaycount" value="no" />
				<html:hidden property="_pagesize" />
				<html:hidden property="startindex" />
				<html:hidden property="endindex" />
				<input type="hidden" name="_rowcount"
					value="<c:out value='${requestScope.LIST.rowCount}' />">

				<input type="hidden" name="menuTokenId" id="menuTokenId"
					value="1A2BA0S0" />

				<table width="100%">
					<html:errors />
				</table>

				<DIV class=table_div>
					<TABLE class=top_table>
						<TBODY>
							<TR>
								<TD>
									<bean:message bundle="chghis" key="titleList" />
								</TD>
							</TR>
						</TBODY>
					</TABLE>
				</DIV>


				<div class="table_div">
					<table class="form_table">


						<tr>
							<td width="126" height="20" align="right"
								class="form_table_right">
								<bean:message bundle="chghis" key="tabname" />
								:
							</td>
							<td class="form_table_left">
								<html:select property="_se_tabname">
								<html:option value=""/>
								<s:Options definition="#QS_TABLENAME"></s:Options>
							</html:select>
							</td>
							<td width="126" height="20" align="right"
								class="form_table_right">
								<bean:message bundle="chghis" key="tabtype" />
								:
							</td>
							<td class="form_table_left">
								<html:select property="_ne_tabtype">
								<html:option value=""/>
								<s:Options definition="$QSCS_TABTYPE"></s:Options>
							</html:select>
							</td>
							<td width="126" height="20" align="right"
								class="form_table_right">
								<bean:message bundle="chghis" key="oprtype" />
								:
							</td>
							<td class="form_table_left">
							<html:select property="_se_oprtype">
								<html:option value="">
								</html:option>
								<s:Options definition="$QSCS_OPRTYPE"></s:Options>
							</html:select>
							</td>
						</tr>
						<tr>
							<td width="126" height="20" align="right"
								class="form_table_right">
								<bean:message bundle="chghis" key="oprtime" />
								>= :
							</td>
							<td class="form_table_left">
								<html:text styleClass="form_input_1x" property="_dnl_oprtime"
									onclick="formList._dnl_oprtime.value=selectDatetime(formList._dnl_oprtime.value)" />
							</td>
							<td width="126" height="20" align="right"
								class="form_table_right">
								<bean:message bundle="chghis" key="oprtime" />
								&lt;= :
							</td>
							<td class="form_table_left">
								<html:text styleClass="form_input_1x" property="_dnm_oprtime"
									onclick="formList._dnm_oprtime.value=selectDatetime(formList._dnl_oprtime.value)" />
							</td>
							<td width="126" height="20" align="right"
								class="form_table_right">
								<bean:message bundle="chghis" key="oprcode" />
								:
							</td>
							<td class="form_table_left">
								<html:text styleClass="form_input_1x" property="_se_oprcode"
									onkeyup="importLN(this);"
									onblur="unimportLN();this.value=ignorecresourcelogpaces(this.value);"></html:text>
							</td>
						</tr>

						<tr>
							<td width="126" height="20" align="right"
								class="form_table_right">
								<bean:message bundle="chghis" key="chgtype" />
							:
							</td>
							<td class="form_table_left">
								<html:select property="_ne_chgtype">
									<html:option value="">
									</html:option>
									<s:Options definition="#QSCHGTYPE" nameOnly="false" />
								</html:select>
							</td>
							<td width="126" height="20" align="right"
								class="form_table_right">
								<bean:message bundle="chghis" key="matchid" />
								:
							</td>
							<td class="form_table_left">
								<html:text styleClass="form_input_1x" property="_ne_matchid" />
							</td>
							<td width="126" height="20" align="right"
								class="form_table_right">
							</td>
							<td class="form_table_left">
							</td>
						</tr>
					</table>
				</div>

				<DIV class=table_div>
					<TABLE class=table_button_list>
						<TBODY>
							<TR>
								<TD>
									<input type="button" class="query"
										onmouseover="buttonover(this);" onmouseout="buttonout(this);"
										onfocus="buttonover(this)" onblur="buttonout(this)"
										value="<bean:message bundle="public" key="button_search"/>"
										onClick="doQuery();" />
								</TD>
							</TR>
						</TBODY>
					</TABLE>
				</DIV>

				<div class="table_div">
					<div class="table_LongTable">
						<table class="table_style" ID="Table2">
							<tr class="table_style_head">
								<td nowrap>
									<a href="javascript:doOrderby('reqid')"><bean:message
											bundle="chghis" key="reqid" /> </a>
									<s:OrderImg form="/qsmanage/paramsmanage/ChgHisForm"
										field="reqid" />
								</td>

								<td nowrap>
									<a href="javascript:doOrderby('matchid')"><bean:message
											bundle="chghis" key="matchid" /> </a>
									<s:OrderImg form="/qsmanage/paramsmanage/ChgHisForm"
										field="matchid" />
								</td>

								<td nowrap>
									<a href="javascript:doOrderby('tabname')"><bean:message
											bundle="chghis" key="tabname" /> </a>
									<s:OrderImg form="/qsmanage/paramsmanage/ChgHisForm"
										field="tabname" />
								</td>
								<td nowrap>
									<a href="javascript:doOrderby('tabtype')"><bean:message
											bundle="chghis" key="tabtype" /> </a>
									<s:OrderImg form="/qsmanage/paramsmanage/ChgHisForm"
										field="tabtype" />
								</td>
								<td nowrap>
									<a href="javascript:doOrderby('oprtype')"><bean:message
											bundle="chghis" key="oprtype" /> </a>
									<s:OrderImg form="/qsmanage/paramsmanage/ChgHisForm"
										field="oprtype" />
								</td>
								<td nowrap>
									<bean:message bundle="chgreq" key="mainkeyname" /> 
								</td>
								<td nowrap>
									<a href="javascript:doOrderby('mainkey')"><bean:message
											bundle="chghis" key="mainkey" /> </a>
									<s:OrderImg form="/qsmanage/paramsmanage/ChgHisForm"
										field="mainkey" /> 
								</td>



								<td nowrap>
									<a href="javascript:doOrderby('mainvalue')"><bean:message
											bundle="chghis" key="mainvalue" /> </a>
									<s:OrderImg form="/qsmanage/paramsmanage/ChgHisForm"
										field="mainvalue" />
								</td>

								<td nowrap>
									<a href="javascript:doOrderby('oprtime')"><bean:message
											bundle="chghis" key="oprtime" /> </a>
									<s:OrderImg form="/qsmanage/paramsmanage/ChgHisForm"
										field="oprtime" />
								</td>

								<td nowrap>
									<a href="javascript:doOrderby('oprcode')"><bean:message
											bundle="chghis" key="oprcode" /> </a>
									<s:OrderImg form="/qsmanage/paramsmanage/ChgHisForm"
										field="oprcode" />
								</td>
								<td nowrap>
									<a href="javascript:doOrderby('oprstate')"><bean:message
											bundle="chghis" key="oprstate" /> </a>
									<s:OrderImg form="/qsmanage/paramsmanage/ChgHisForm"
										field="oprstate" />
								</td>

								<td nowrap>
									<a href="javascript:doOrderby('chgtype')"><bean:message
											bundle="chghis" key="chgtype" /> </a>
									<s:OrderImg form="/qsmanage/paramsmanage/ChgHisForm"
										field="chgtype" />
								</td>
								<td nowrap>
									<a href="javascript:doOrderby('chgreason')"><bean:message
											bundle="chghis" key="chgreason" /> </a>
									<s:OrderImg form="/qsmanage/paramsmanage/ChgHisForm"
										field="chgreason" />
								</td>
								<td nowrap>
									<a href="javascript:doOrderby('chkinfo')"><bean:message
											bundle="chghis" key="chkinfo" /> </a>
									<s:OrderImg form="/qsmanage/paramsmanage/ChgHisForm"
										field="chkinfo" />
								</td>

							</tr>
							<c:forEach var="item" items="${requestScope.LIST.datas}">
								<tr class="table_style_content" align="center"
									onclick="showDeta(this.id)"
									id="<c:out value="logid=${item.logid}" />"
									style="cursor:hand;">
									<td>
										<c:out value="${item.reqid}" />
									</td>

									<td>
										<c:out value="${item.matchid}" />
									</td>

									<td nowrap>
										<s:Code2Name definition="#QS_TABLENAME" code="${item.tabname}" />
									</td>
									<td nowrap>
										<s:Code2Name definition="$QSCS_TABTYPE" code="${item.tabtype}" />
									</td>

									<td nowrap>
										<s:Code2Name definition="$QSCS_OPRTYPE" code="${item.oprtype}" />
									</td>
									<td>
									<s:Code2Name definition="#QS_MAINKEYSTR" code="${item.tabname}" />
									</td>
									<td nowrap>
										<c:out value="${item.mainkey}" />
									</td>
									<td nowrap>
										<c:out value="${item.mainvalue}" />
									</td>
									<td nowrap>
										<fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss"
											value="${item.oprtime}" />
									</td>
									<td nowrap>
										<c:out value="${item.oprcode}" />
									</td>
									<td nowrap>
										<s:Code2Name code="${item.oprstate}" definition="$QSCS_OPRSTATE" />
									</td>
									<td nowrap>
										<s:Code2Name code="${item.chgtype}" definition="#QSCHGTYPE" />
									</td>
									<td nowrap>
										<c:out value="${item.chgreason}" />
									</td>
									<td nowrap>
										<c:out value="${item.chkinfo}" />
									</td>
								</tr>
							</c:forEach>
						</table>
					</div>
				</div>
				<div class="table_div">

					<s:PageDisplay dpName="LIST" />

				</div>
			</html:form>
		</div>
	</body>
</html>
