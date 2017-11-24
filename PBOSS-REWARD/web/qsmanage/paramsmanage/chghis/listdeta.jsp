<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc"%>

<html>
	<base target="_self">
	<head>
		<title><bean:message bundle="chghis" key="DetTitle" />
		</title>
		<script language="JavaScript">
        function ev_check() {

            return checkval(window);   
        }
 
    </script>
	</head>

	<body onload="loadforiframe()">
		<html:form
			action="/qsmanage/paramsmanage/chghis.do?CMD=LISTDET"
			styleId="formList" method="post" onsubmit="return ev_check();">

			<div class="table_div">
				<table class="top_table">
					<tr>
						<td>
							<s:Code2Name definition="#QS_TABLENAME" code="${requestScope.tabname}" />
						</td>

					</tr>
				</table>
			</div>
			<div class="table_div">
				<table class="error_text">
					<html:errors />
					<s:Msg />
				</table>
			</div>
			<div class="table_div">
				<div class="table_LongTable">
					<table class="table_style" ID="Table2">
						<tr class="table_style_head">
							<td>
								<bean:message bundle="chghis" key="paraname" />
							</td>
							<td>
								<bean:message bundle="chghis" key="newvalue" />
							</td>
							<td>
								<bean:message bundle="chghis" key="oldvalue" />
							</td>

						</tr>
						
						<c:forEach var="item" items="${requestScope.LIST}">
						<tr class="table_style_content" align="center">
							<td>
								<c:out value="${item.column}" />	
							</td>
							<td>
								<c:out value="${item.newvalue}" />
							</td>
							<td>
								<c:out value="${item.oldvalue}" />
							</td>
						</tr>
						</c:forEach>
					</table>
				</div>
			</div>
			<DIV class=table_div>
					<TABLE class=table_button_list>
						<TBODY>
							<TR>
								<TD>
									<input type="button" class="query"
										onmouseover="buttonover(this);" onmouseout="buttonout(this);"
										onfocus="buttonover(this)" onblur="buttonout(this)"
										value="¹Ø±Õ"
										onClick="window.close();" />
								</TD>
							</TR>
						</TBODY>
					</TABLE>
				</DIV>
		</html:form>
	</body>
</html>









