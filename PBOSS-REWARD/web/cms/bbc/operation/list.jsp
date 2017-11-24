<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc"%>
<%
	String ID_1 = "CH_B2M_REWARD||CH_B2M_REWARD_PROVINCIAL"; 
    String ID_2 = "CH_B2M_REWARD||CH_B2M_REWARD_CIVIC";

%>
<html>
	<head>
		<title><bean:message bundle="bbcoper" key="titleList" />
		</title>
		<script type="text/javascript"
			src="<%=contextPath%>/js/bus/waycommon.js"></script>
		<script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            addfield('_se_opnid', '<bean:message bundle="bbcoper" key="opnid"/>', 'c', true, '18');
            addfield('_sk_name', '<bean:message bundle="bbcoper" key="name"/>', 'c', true, '50');
            addfield('_dnl_startdate', '<bean:message bundle="bbcoper" key="startdate"/>', 't', true, '25');
            addfield('_dnm_startdate', '<bean:message bundle="bbcoper" key="startdate"/>', 't', true, '25');
            addfield('_dnl_enddate', '<bean:message bundle="bbcoper" key="enddate"/>', 't', true, '25');
            addfield('_dnm_enddate', '<bean:message bundle="bbcoper" key="enddate"/>', 't', true, '25');
            addfield('_se_busibelong', '<bean:message bundle="bbcoper" key="busibelong"/>', 'c', true, '32');
            if(date_compare("_dnl_startdate","_dnm_startdate",'<bean:message bundle="bbcoper" key="startCompare"/>')) return;
            if(date_compare("_dnl_enddate","_dnm_enddate",'<bean:message bundle="bbcoper" key="endCompare"/>')) return;
            return checkval(window);
        }
        function getOpnId() {
			var arg = new Array();
			var strUrl ="<%=contextPath%>/cms/bbc/operation.do?CMD=SELECT";
			return window.showModalDialog(strUrl,arg,"dialogWidth:600px; dialogHeight:390px; status:no;resizable:yes;");
		}
    </script>
	</head>

	<body onload="loadforiframe();">
		<div class="table_container">
			<html:form action="/cms/bbc/operation.do?CMD=LIST" styleId="formList"
				method="post" onsubmit="return ev_check();">
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
								<bean:message bundle="bbcoper" key="titleList" />
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
								<bean:message bundle="bbcoper" key="_se_opnid" />
								:
							</td>
							<td class="form_table_left">
							    <html:text  property="_se_opnid" styleClass="form_input_1x"/>
							    <input type="button" value="..." class="clickbutton"
										onclick="_se_opnid.value=getOpnId();">
                		    </td>
							<td width="126" height="20" align="right"
								class="form_table_right">
								<bean:message bundle="bbcoper" key="_sk_name" />
								:
							</td>
							<td class="form_table_left">
								<html:text styleClass="form_input_1x" property="_sk_name"></html:text>
							</td>
						</tr>
						<tr>
							<td width="126" height="20" align="right"
								class="form_table_right">
								<bean:message bundle="bbcoper" key="_dnl_startdate" />
								:
							</td>
							<td class="form_table_left">
								<html:text styleClass="form_input_1x" property="_dnl_startdate"
									onclick="this.value=selectDate();"></html:text>
							</td>

							<td width="126" height="20" align="right"
								class="form_table_right">
								<bean:message bundle="bbcoper" key="_dnm_startdate" />
								:
							</td>
							<td class="form_table_left">
								<html:text styleClass="form_input_1x" property="_dnm_startdate"
									onclick="this.value=selectDate();"></html:text>

							</td>
						</tr>
						<tr>
							<td width="126" height="20" align="right"
								class="form_table_right">
								<bean:message bundle="bbcoper" key="_dnl_enddate" />
								:
							</td>
							<td class="form_table_left">
								<html:text styleClass="form_input_1x" property="_dnl_enddate"
									onclick="this.value=selectDate();"></html:text>

							</td>
							<td width="126" height="20" align="right"
								class="form_table_right">
								<bean:message bundle="bbcoper" key="_dnm_enddate" />
								:
							</td>
							<td class="form_table_left">
								<html:text styleClass="form_input_1x" property="_dnm_enddate"
									onclick="this.value=selectDate();"></html:text>
							</td>
						</tr>
						<tr>
							<td width="126" height="20" align="right"
								class="form_table_right">
								<bean:message bundle="bbcoper" key="_se_busibelong" />
								:
							</td>
							<td class="form_table_left">
								<html:select property="_se_busibelong">
									<option />
										<s:Options definition="#CH_BBCCBBUSIBELONG" />
								</html:select>
							</td>
							<td width="80" height="20" align="right" class="form_table_right">
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
								<s:RewardPurChk controlid="<%=ID_1%>" disableChild="true">
									<input type="button" name="btnNew" class="add"
										onmouseover="buttonover(this);" onmouseout="buttonout(this);"
										onfocus="buttonover(this)" onblur="buttonout(this)"
										value="<bean:message bundle="public" key="button_new"/>"
										onClick="doNew('/cms/bbc/operation.do')">
								</s:RewardPurChk>
									<input type="button" class="query" onclick="doQuery();" 
										onmouseover="buttonover(this);" onmouseout="buttonout(this);"
										onfocus="buttonover(this)" onblur="buttonout(this)"
										value="<bean:message bundle="public" key="button_search"/>" />
							</td>
						</tr>
					</table>
				</div>

				<div class="table_div">
					<div class="table_LongTable">
						<table class="table_style" ID="Table2">
							<tr class="table_style_head">

								<td>
									<bean:message bundle="bbcoper" key="operate" />
								</td>
								<td>
									<a href="javascript:doOrderby('opnid')"><bean:message
											bundle="bbcoper" key="opnid" />
									</a>
									<s:OrderImg form="/cms/bbc/operation/operationForm" field="opnid" />
								</td>
								<td>
									<a href="javascript:doOrderby('name')"><bean:message
											bundle="bbcoper" key="name" />
									</a>
									<s:OrderImg form="/cms/bbc/operation/operationForm" field="name" />
								</td>
								<td>
									<bean:message bundle="bbcoper" key="startdate" />

								</td>
								<td>
									<bean:message bundle="bbcoper" key="enddate" />

								</td>

								<td>
									<bean:message bundle="bbcoper" key="busibelong" />

								</td>

								<td>
									<bean:message bundle="bbcoper" key="remark" />

								</td>
							</tr>
							<c:forEach var="item" items="${requestScope.LIST.datas}">
								<c:url value="/cms/bbc/operation.do?CMD=EDIT" var="urlContent">
								<c:param name="PK" value="${item.opnid}" />
								</c:url>
								<c:url value="/cms/bbc/vstdreward.do?CMD=LIST" var="urlContent2">
									<c:param name="PK" value="${item.opnid}" />
									<c:param name="_se_opnid" value="${item.opnid}" />
									<c:param name="busibelong" value="${item.busibelong}" />
								</c:url>
								<c:url value="/cms/bbc/operation/frame.jsp" var="urlContent3">
									<c:param name="PK" value="${item.opnid}" />
									<c:param name="_se_opnid" value="${item.opnid}" />
									<c:param name="busibelong" value="${item.busibelong}" />
								</c:url>
								
								<tr class="table_style_content" align="center">

									<td>
										<a href='<c:out value="${urlContent2}"/>'><bean:message
												bundle="vstdreward" key="title" />
										</a>
									</td>
									<td>
										<a href='<c:out value="${urlContent}"/>'><c:out
												value="${item.opnid}" />
										</a>
									</td>
									<td>
										<c:out value="${item.name}" />
									</td>
									<td>
									<fmt:formatDate value="${item.startdate}" pattern="yyyy-MM-dd HH:mm:ss"/>
									</td>
									<td>
									<fmt:formatDate value="${item.enddate}" pattern="yyyy-MM-dd HH:mm:ss"/>
									</td>
									<td>
									<s:Code2Name code="${item.busibelong}" definition="#CH_BBCCBBUSIBELONG" />  
										
									</td>
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
