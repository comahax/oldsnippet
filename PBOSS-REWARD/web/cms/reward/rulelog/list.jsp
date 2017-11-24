<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc"%>
<%
	String ID_1 = "00010701";
	String ID_2 = "00010702";
	String ID_3 = "00010703";
	String ID_4 = "00010704";
%>
<html>
	<head>
		<title><bean:message bundle="rulelog" key="titleList" />
		</title>
		<script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            return checkval(window);
        }
    </script>
	</head>

	<body onload="if(window.loadforiframe) loadforiframe();">
		<div class="table_container">
			<html:form action="/cms/reward/rulelog.do?CMD=LIST"
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
								<bean:message bundle="rulelog" key="titleList" />
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
								<bean:message bundle="rulelog" key="_dnl_optime" />
								:
							</td>
							<td class="form_table_left">
								<html:text styleClass="form_input_1x" property="_dnl_optime"
									onclick="this.value=selectDatetime();"/>
							</td>
							<td width="126" height="20" align="right"
								class="form_table_right">
								<bean:message bundle="rulelog" key="_dnm_optime" />
								:
							</td>
							<td class="form_table_left">
								<html:text styleClass="form_input_1x" property="_dnm_optime"
									onclick="this.value=selectDatetime();" />
							</td>
							<td width="126" height="20" align="right"
								class="form_table_right">
								<bean:message bundle="rulelog" key="ruleid" />
								:
							</td>
							<td class="form_table_left">
								<html:text styleClass="form_input_1x" property="_se_ruleid"></html:text>
							</td>
						</tr>
						<tr>
							<td width="126" height="20" align="right"
								class="form_table_right">
								<bean:message bundle="rulelog" key="oprtype" />
								:
							</td>
							<td class="form_table_left">
								<html:select property="_se_oprtype">
									<option></option>
									<s:Options definition="$OPRTYPE" />
								</html:select>
							</td>
							<td width="126" height="20" align="right"
								class="form_table_right">
								<bean:message bundle="rulelog" key="success" />
								:
							</td>
							<td class="form_table_left">
								<html:select property="_se_success">
									<option></option>
									<s:Options definition="$OPRRESULT" />
								</html:select>
							</td>
							<td width="80" height="20" align="right" class="form_table_right">
								<bean:message bundle="rulelog" key="oprcode" />
								:
							</td>
							<td class="form_table_left">
								<html:text styleClass="form_input_1x" property="_sk_oprcode"></html:text>
							</td>
						</tr>
					</table>
				</div>
				<div class="table_div">
					<table class="table_button_list">
						<tr>
							<td align=right>
								
								<s:PurChk controlid="<%=ID_3%>">
									<input type="button" class="query" onclick="doQuery();" 
										onmouseover="buttonover(this);" onmouseout="buttonout(this);"
										onfocus="buttonover(this)" onblur="buttonout(this)"
										value="<bean:message bundle="public" key="button_search"/>" />
								</s:PurChk>
							</td>
						</tr>
					</table>
				</div>

				<div class="table_div">
					<div class="table_LongTable">
						<table class="table_style" ID="Table2">
							<tr class="table_style_head">
								
								<td>
									<a href="javascript:doOrderby('logid')"><bean:message
											bundle="rulelog" key="logid" />
									</a>
									<s:OrderImg form="/cms/reward/rulelog/rulelogForm"
										field="logid" />
								</td>
								<td>
									<a href="javascript:doOrderby('optime')"><bean:message
											bundle="rulelog" key="optime" />
									</a>
									<s:OrderImg form="/cms/reward/rulelog/rulelogForm"
										field="optime" />
								</td>
								<td>
									<a href="javascript:doOrderby('oprcode')"><bean:message
											bundle="rulelog" key="oprcode" />
									</a>
									<s:OrderImg form="/cms/reward/rulelog/rulelogForm"
										field="oprcode" />
								</td>
								<td>
									<a href="javascript:doOrderby('oprtype')"><bean:message
											bundle="rulelog" key="oprtype" />
									</a>
									<s:OrderImg form="/cms/reward/rulelog/rulelogForm"
										field="oprtype" />
								</td>
								<td>
									<a href="javascript:doOrderby('success')"><bean:message
											bundle="rulelog" key="success" />
									</a>
									<s:OrderImg form="/cms/reward/rulelog/rulelogForm"
										field="success" />
								</td>
								<td>
									<a href="javascript:doOrderby('ruleid')"><bean:message
											bundle="rulelog" key="ruleid" />
									</a>
									<s:OrderImg form="/cms/reward/rulelog/rulelogForm"
										field="ruleid" />
								</td>
								<td>
									<a href="javascript:doOrderby('rulename')"><bean:message
											bundle="rulelog" key="rulename" />
									</a>
									<s:OrderImg form="/cms/reward/rulelog/rulelogForm"
										field="rulename" />
								</td>
								<td>
									<a href="javascript:doOrderby('startdate')"><bean:message
											bundle="rulelog" key="startdate" />
									</a>
									<s:OrderImg form="/cms/reward/rulelog/rulelogForm"
										field="startdate" />
								</td>
								<td>
									<a href="javascript:doOrderby('enddate')"><bean:message
											bundle="rulelog" key="enddate" />
									</a>
									<s:OrderImg form="/cms/reward/rulelog/rulelogForm"
										field="enddate" />
								</td>
								<td>
									<a href="javascript:doOrderby('remark')"><bean:message
											bundle="rulelog" key="remark" />
									</a>
									<s:OrderImg form="/cms/reward/rulelog/rulelogForm"
										field="remark" />
								</td>
							</tr>
							<c:forEach var="item" items="${requestScope.LIST.datas}">
								<tr class="table_style_content" align="center">
									<td>
										<c:out value="${item.logid}" />
									</td>
									<td>
										<fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss"
											value="${item.optime}" />
									</td>
									<td>
										<c:out value="${item.oprcode}" />
									</td>
									<td><s:Code2Name code="${item.oprtype}" definition="$OPRTYPE" /></td>
                     <td><s:Code2Name code="${item.success}" definition="$OPRRESULT" /></td>
									<td>
										<c:out value="${item.ruleid}" />
									</td>
									<td>
										<c:out value="${item.rulename}" />
									</td>
									<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${item.startdate}"/></td>
                     <td><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${item.enddate}"/></td>
									<td>
										<c:out value="${item.remark}" />
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
