<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ page import="com.sunrise.boss.common.base.db.SessionFactoryRouter"%>
<%@ page import="com.sunrise.boss.ui.commons.User"%>
<%@ page import="com.sunrise.boss.ui.commons.WebConstant"%>
<jsp:include page="/inc/acl.jsp">
	<jsp:param name="PID" value="1A2B1AC0" />
</jsp:include>
<%@ include file="/inc/listhead.inc"%>
<html>
	<head>
		<title><bean:message bundle="chgreglog" key="titleList" />
		</title>
		<script language="JavaScript">
        function ev_check() {
            addfield('_ne_reqid', '<bean:message bundle="chgreglog" key="reqid"/>', 'l', true, 11);
            addfield('_dnl_chgtime', '<bean:message bundle="chgreglog" key="chgtime"/>', 't', true, 7);
            addfield('_dnm_chgtime', '<bean:message bundle="chgreglog" key="chgtime"/>', 't', true, 7);
            addfield('_se_tabname', '<bean:message bundle="chgreglog" key="tabname"/>', 'c', true, 32);
            addfield('_se_chgcode', '<bean:message bundle="chgreglog" key="chgcode"/>', 'c', true, 32);
            return checkval(window);
        }
    </script>
    </head>

	<body onload="loadforiframe()">
		<div class="table_container">
			<html:form action="/qsmanage/paramsmanage/chgreglog.do?CMD=LIST" styleId="formList" method="post" onsubmit="return ev_check();">
				<html:hidden property="_orderby"/>
				<html:hidden property="_desc" />
				<html:hidden property="_pageno" />
				<html:hidden property="_pagesize" />
				<input type="hidden" name="_rowcount" value="<c:out value='${requestScope.LIST.rowCount}' />">
				<div class="table_div">

					<table class="top_table">
						<tr>
							<td>
								<bean:message bundle="chgreglog" key="titleList" />
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
							<td width="126" height="20" align="right" class="form_table_right">
								<bean:message bundle="chgreglog" key="reqid" />
								:
							</td>
							<td class="form_table_left">
								<html:text styleClass="form_input_1x" property="_ne_reqid" />
							</td>
							<td width="126" height="20" align="right" class="form_table_right" >
								<bean:message bundle="chgreglog" key="chgcode" />
								:
							</td>
							<td width="30%" align="left" class="form_table_left" >
							<c:choose>
								<c:when test="${edtState}">
									<s:zoom definition="#OPERATORNAME" property="_se_chgcode"
										condition="orgid:${USER.wayid};_sne_operid:${USER.opercode};status:1"
										nameOnly="false" styleClass="form_input_1x" disabled="true" />
								</c:when>
								<c:otherwise>
								
									<s:zoom definition="#OPERATORNAME" property="_se_chgcode"
										condition="orgid:${USER.wayid};_sne_operid:${USER.opercode};status:1"
										nameOnly="false" styleClass="form_input_1x" />
									
									
								</c:otherwise>
							</c:choose>
						</td>
							<td width="126" height="20" align="right" class="form_table_right" >
								<bean:message bundle="chgreglog" key="tabname" />
								:
							</td>
							<td class="form_table_left" nowrap>
								<html:text styleClass="form_input_1x" property="_se_tabname" />
							</td>
							
						</tr>
						<tr>
							
							<td width="126" height="20" align="right" class="form_table_right" >
								<bean:message bundle="chgreglog" key="chgtimel" />
								:
							</td>
							<td >
								<html:text styleClass="form_input_1x" property="_dnl_chgtime" onclick="this.value = selectDate()" />
							</td>	
							
							<td width="126" height="20" align="right" class="form_table_right" >
								<bean:message bundle="chgreglog" key="chgtimem" />
								:
							</td>
							<td >
								<html:text styleClass="form_input_1x" property="_dnm_chgtime" onclick="this.value = selectDate()" />
							</td>
							
						</tr>
					</table>
				</div>
				<div class="table_div">
					<table class="table_button_list">
						<tr>
							<td>
								<input type="button" class="query" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
									onfocus="buttonover(this)" onblur="buttonout(this)" value="<bean:message bundle="public" key="button_search"/>" onClick="doQuery();"/>
							</td>
						</tr>
					</table>
				</div>
				<div class="table_div">
					<div class="table_LongTable">
						<table class="table_style" ID="Table2">
							<tr class="table_style_head">
								<td>
									<bean:message bundle="chgreglog" key="logid" /> 
									<s:OrderImg form="/qsmanage/paramsmanage/chgreglog/ChgReglogForm" field="logid" />	
								</td>
								<td>
									<bean:message bundle="chgreglog" key="chgtime" /> 
									<s:OrderImg form="/qsmanage/paramsmanage/chgreglog/ChgReglogForm" field="chgtime" />	
								</td>
								<td>
									<bean:message bundle="chgreglog" key="chgcode" /> 
									<s:OrderImg form="/qsmanage/paramsmanage/chgreglog/ChgReglogForm" field="chgcode" />	
								</td>
								
								<td>
									<bean:message bundle="chgreglog" key="reqid" /> 
									<s:OrderImg form="/qsmanage/paramsmanage/chgreglog/ChgReglogForm" field="reqid" />	
								</td>
								
								<td>
									<bean:message bundle="chgreglog" key="tabname" />
									<s:OrderImg form="/qsmanage/paramsmanage/chgreglog/ChgReglogForm" field="tabname" />
								</td>
								<td>
									<bean:message bundle="chgreglog" key="oldvalue" /> 
									<s:OrderImg form="/qsmanage/paramsmanage/chgreglog/ChgReglogForm" field="oldvalue" />	
								</td>
								<td>
									<bean:message bundle="chgreglog" key="newvalue" /> 
									<s:OrderImg form="/qsmanage/paramsmanage/chgreglog/ChgReglogForm" field="newvalue" />	
								</td>
								
							</tr>
							<c:forEach var="item" items="${requestScope.LIST.datas}">
									<tr class="table_style_content" align="center">
										<td>
											<c:out value="${item.logid}" />
										</td>
										<td>
											<fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${item.chgtime}" />
										</td>
									
										<td>
											<c:out value="${item.chgcode}" />
										</td>
										<td>
											<c:out value="${item.reqid}" />
										</td>
										<td>
											<c:out value="${item.tabname}" />
										</td>
										<td>
											<c:out value="${item.oldvalue}" />
										</td>
										<td>
											<c:out value="${item.newvalue}" />
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
