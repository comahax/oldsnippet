<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc"%>
<html>
<head>
	<title><bean:message bundle="employee" key="selectTel" />
	</title>
	<base target="_self">
	<script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            formList.action=contextPath+"/cms/employee.do?CMD=SELECTTEL";
            formList.submit();
        }
       window.returnValue = ""; 
       function doOK(value) {
	   		window.returnValue = value;
	   		window.close();
	   }
    </script>
</head>
<body>
	<div class="table_container">
		<html:form action="/cms/employee.do?CMD=SELECTTEL"
			styleId="formList" method="post" onsubmit="return ev_check();">
			<html:hidden property="_orderby" />
			<html:hidden property="_desc" />
			<html:hidden property="_pageno" />
			<html:hidden property="_pagesize" />
			<input type="hidden" name="_rowcount"
				value="<c:out value='${requestScope.LIST.rowCount}' />">


			<div class="table_div">
				<table class="top_table">
					<tr>
						<td>
							<bean:message bundle="employee" key="selectTel" />
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
						<td class="form_table_right">
							<bean:message bundle="employee" key="telephone2" />
							:
						</td>
						<td class="form_table_left">
							<html:text styleClass="form_input_1x" property="_se_telephone"></html:text>
						</td>
						<td class="form_table_right">
							<bean:message bundle="employee" key="employeename2" />
							:
						</td>
						<td class="form_table_left">
							<html:text styleClass="form_input_1x" property="_sk_employeename"></html:text>
						</td>
					</tr>
				</table>
			</div>

			<div class="table_div">

				<table class="table_button_list">
					<tr>
						<td>
							<input type="button" class="query"
								onmouseover="buttonover(this);" onmouseout="buttonout(this);"
								onfocus="buttonover(this)" onblur="buttonout(this)"
								value="<bean:message bundle="public" key="button_search"/>"
								onclick="ev_check();" />
						</td>
					</tr>
				</table>
			</div>

			<div class="table_div">
				<div class="table_LongTable">
					<table class="table_style" ID="Table2">
						<tr class="table_style_head">
							<td nowrap>
								<bean:message bundle="employee" key="telephone2" />
							</td>
							<td nowrap>
								<bean:message bundle="employee" key="employeename2" />
							</td>
						</tr>
						<c:forEach var="item" items="${requestScope.LIST.datas}">
							<tr style="cursor:hand" class="table_style_content"
								align="center"
								onclick="doOK('<c:out value="${item.telephone}"/>');">
								<td>
									<c:out value="${item.telephone}" />
								</td>
								<td>
									<c:out value="${item.employeename}" />
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
