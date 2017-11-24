<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ page import="com.sunrise.boss.common.base.db.SessionFactoryRouter"%>
<%@ page import="com.sunrise.boss.ui.commons.User"%>
<%@ page import="com.sunrise.boss.ui.commons.WebConstant"%>
<jsp:include page="/inc/acl.jsp">
	<jsp:param name="PID" value="1A2B1AC0" />
</jsp:include>
<%
	String ID_1 = "1A2B1AC0BT1";
	String ID_2 = "1A2B1AC0BT2";
	String ID_3 = "1A2B1AC0BT3";
%>
<%@ include file="/inc/listhead.inc"%>

<%
    	User user = (User) request.getSession().getAttribute(WebConstant.SESSION_ATTRIBUTE_USER);
    	String cityid = SessionFactoryRouter.conversionCityid(user.getCityid());
    	request.getSession().setAttribute("cityid",cityid);
     %>
   
<html>
	<head>
		<title><bean:message bundle="testopr" key="titleList" />
		</title>
		<script language="JavaScript">
        function ev_check() {
            addfield('_se_oprcode', '<bean:message bundle="testopr" key="Oprcode"/>', 'c', true, 32);
            addfield('_ne_state', '<bean:message bundle="testopr" key="state"/>', 'i', true, 2);
            return checkval(window);
        }
    </script>
    </head>

	<body onload="loadforiframe()">
		<div class="table_container">
			<html:form action="/qsmanage/paramstest/testopr.do?CMD=LIST" styleId="formList" method="post" onsubmit="return ev_check();">
				<html:hidden property="_orderby"/>
				<html:hidden property="_desc" />
				<html:hidden property="_pageno" />
				<html:hidden property="_pagesize" />
				<input type="hidden" name="_rowcount" value="<c:out value='${requestScope.LIST.rowCount}' />">
				<div class="table_div">

					<table class="top_table">
						<tr>
							<td>
								<bean:message bundle="testopr" key="titleList" />
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
								<bean:message bundle="testopr" key="Oprcode" />
								:
							</td>
							<td width="30%" align="left" class="form_table_left" >
							<c:choose>
								<c:when test="${edtState}">
								
									<s:zoom definition="#OPERATORNAME" property="_se_oprcode"
										condition="orgid:${USER.wayid};_sne_operid:${USER.opercode};status:1"
										nameOnly="false" styleClass="form_input_1x" disabled="true" />
									
									
								</c:when>
								<c:otherwise>
								
									<s:zoom definition="#OPERATORNAME" property="_se_oprcode"
										condition="orgid:${USER.wayid};_sne_operid:${USER.opercode};status:1"
										nameOnly="false" styleClass="form_input_1x" />
									
									
								</c:otherwise>
							</c:choose>
						</td>
							<td width="126" height="20" align="right" class="form_table_right">
								<bean:message bundle="testopr" key="state" />
								:
							</td>
							<td class="form_table_left">
								<html:select property="_ne_state">
									<html:option value=""></html:option>
									<s:Options definition="$QSCS_TESTOPRNOSTATE" />
								</html:select>
							</td>
							
						</tr>
					</table>
				</div>
				<div class="table_div">
					<table class="table_button_list">
						<tr>
							<td>
							<s:PurChk controlid="<%=ID_1%>">
							<input type="button" name="btnNew" class="add" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
									onfocus="buttonover(this)" onblur="buttonout(this)" value="<bean:message bundle="public" key="button_new"/>"
									onClick="doNew('/qsmanage/paramstest/testopr.do')">
								</s:PurChk>
							<s:PurChk controlid="<%=ID_2%>">
								<input type="button" name="btnDelete" class="delete" onmouseover="buttonover(this);"
									onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
									value="<bean:message bundle="public" key="button_delete"/>" onClick="doDelete('/qsmanage/paramstest/testopr.do')">
							</s:PurChk>
							<s:PurChk controlid="<%=ID_3%>">
								<input type="button" class="query" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
									onfocus="buttonover(this)" onblur="buttonout(this)" value="<bean:message bundle="public" key="button_search"/>" onClick="doQuery();"/>
							</s:PurChk>
							</td>
						</tr>
					</table>
				</div>
				<div class="table_div">
					<div class="table_LongTable">
						<table class="table_style" ID="Table2">
							<tr class="table_style_head">
								<td title="<bean:message bundle="public" key="list_title_select"/>">
									<input type="checkbox" name="allbox" onclick="checkAll();" class="table_checkbox">
								</td>
								<td>
									<bean:message bundle="testopr" key="Oprcode" /> 
									<s:OrderImg form="/qsmanage/paramstest/testopr/TestoprForm" field="oprcode" />	
								</td>
								<td>
									<bean:message bundle="testopr" key="state" />
									<s:OrderImg form="/qsmanage/paramstest/testopr/TestoprForm" field="state" />
								</td>
								
							</tr>
							<c:forEach var="item" items="${requestScope.LIST.datas}">
							<c:url value="/qsmanage/paramstest/testopr.do?CMD=EDIT" var="urlContent">
										<c:param name="PK" value="${item.oprcode}" />
									</c:url>
									<tr class="table_style_content" align="center">
										<td>
											<input type="checkbox" name="_selectitem" value="<c:out value='${item.oprcode}'/>" onclick="checkOne();"
												class="table_checkbox">
										</td>
										<td>
											<a href='<c:out value="${urlContent}"/>'><c:out value="${item.oprcode}" /></a>
										</td>
										<td>
											<s:Code2Name code="${item.state}" definition="$QSCS_TESTOPRNOSTATE" />
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
