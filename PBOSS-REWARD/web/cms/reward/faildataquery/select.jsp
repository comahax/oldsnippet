<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc"%>
<html>
<head>
	<title><bean:message bundle="faildataquery" key="adtremarkTitle" />
	</title>
	<base target="_self">
	<script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            formList.action=contextPath+"/cms/reward/faildataquery.do?CMD=SELECT";
            addfield('_sk_adtcode', '<bean:message bundle="faildataquery" key="adtcode"/>', 'c', false, '32');
            addfield('_sk_adtremark', '<bean:message bundle="faildataquery" key="adtremark"/>', 'c', false, '255');
            formList.submit();
        }
       window.returnValue = ""; 
       function doOK(value) {
	   		window.returnValue = value;
	   		window.close();
	   }
    </script>
</head>
<%
	String adttype = (String)request.getParameter("adttype")==null?"":request.getParameter("adttype").toString(); 
%>
<body>
	<div class="table_container">
		<html:form action="/cms/reward/faildataquery.do?CMD=SELECT"
			styleId="formList" method="post" onsubmit="return ev_check();">
			<html:hidden property="_orderby" />
			<html:hidden property="_desc" />
			<html:hidden property="_pageno" />
			<html:hidden property="_pagesize" />
			<input type="hidden" name="adttype" value="<%=adttype%>">
			<input type="hidden" name="_rowcount"
				value="<c:out value='${requestScope.LIST.rowCount}' />">


			<div class="table_div">
				<table class="top_table">
					<tr>
						<td>
							<bean:message bundle="faildataquery" key="adtremarkquery" />
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
							<bean:message bundle="faildataquery" key="adtcode" />
							:
						</td>
						<td class="form_table_left">
							<html:text styleClass="form_input_1x" property="_sk_adtcode"></html:text>
						</td>
						<td class="form_table_right">
							<bean:message bundle="faildataquery" key="adtremark" />
							:
						</td>
						<td class="form_table_left">
							<html:text styleClass="form_input_1x" property="_sk_adtremark"></html:text>
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
								<bean:message bundle="faildataquery" key="adtcode" />
							</td>
							<td nowrap>
								<bean:message bundle="faildataquery" key="adtremark" />
							</td>
						</tr>
						<c:forEach var="item" items="${requestScope.LIST.datas}">
							<tr style="cursor:hand" class="table_style_content"
								align="center"
								onclick="doOK('<c:out value="${item.adtremark}"/>');">
								<td>
									<c:out value="${item.adtcode}" />
								</td>
								<td>
									<c:out value="${item.adtremark}" />
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
