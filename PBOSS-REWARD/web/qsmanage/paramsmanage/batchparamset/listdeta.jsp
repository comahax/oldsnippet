<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc"%>

<html>
	<base target="_self">
	<head>
		<title><bean:message bundle="batchparamset" key="desctitle" />
		</title>
		<script language="JavaScript">
        function ev_check() {

            return checkval(window);   
        }
 
    </script>
	</head>

	<body onload="loadforiframe()">
		<html:form action="/qsmanage/paramsmanage/paramset.do?CMD=LISTDET"
			styleId="formList" method="post" onsubmit="return ev_check();">

			<div class="table_div">
				<table class="top_table">
					<tr>
						<td>
							<bean:message bundle="batchparamset" key="desctitle" />
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
				<div class="table_div">
					<table class="top_table">
						<tr>
							<td>
								<bean:message bundle="batchparamset" key="ruleinfo" />
							</td>

						</tr>
					</table>
				</div>
				<div class="table_LongTable">
					<table class="table_style" ID="Table2">
						<tr class="table_style_head">
							<td>
								<bean:message bundle="batchparamset" key="rulename" />
							</td>
							<td>
								<bean:message bundle="batchparamset" key="filehead" />
							</td>
							<td>
								<bean:message bundle="batchparamset" key="filetail" />
							</td>
							<td>
								<bean:message bundle="batchparamset" key="sepchar" />
							</td>
							<td>
								<bean:message bundle="batchparamset" key="fieldnum" />
							</td>
							<td>
								<bean:message bundle="batchparamset" key="filenum" />
							</td>
							<td>
								<bean:message bundle="batchparamset" key="memo" />
							</td>

						</tr>
						<tr class="table_style_content" align="center">
							<td>
								<c:out value="${requestScope.rulevo.rulename}" />
							</td>
							<td>
								<c:out value="${requestScope.rulevo.filehead}" />
							</td>
							<td>
								<c:out value="${requestScope.rulevo.filetail}" />
							</td>
							<td>
								<c:out value="${requestScope.rulevo.sepchar}" />
							</td>
							<td>
								<c:out value="${requestScope.rulevo.fieldnum}" />
							</td>
							<td>
								<c:out value="${requestScope.rulevo.filenum}" />
							</td>
							<td>
								<c:out value="${requestScope.rulevo.memo}" />
							</td>
						</tr>
						<tr class="table_style_content" align="left">
							<td colspan="7">
								<bean:message bundle="batchparamset" key="ps" />
							</td>
						</tr>
					</table>

				</div>
			</div>




			<div class="table_div">
				<div class="table_div">
					<table class="top_table">
						<tr>
							<td>
								<bean:message bundle="batchparamset" key="ruledeta" />
							</td>

						</tr>
					</table>
				</div>
				<div class="table_LongTable">
					<table class="table_style">
						<tr class="table_style_head">
							<td>
								<bean:message bundle="batchparamset" key="fieldindex" />
							</td>
							<td>
								<bean:message bundle="batchparamset" key="businame" />
							</td>
							<td>
								<bean:message bundle="batchparamset" key="fieldname" />
							</td>
							<td>
								<bean:message bundle="batchparamset" key="mainfield" />
							</td>
							<td>
								<bean:message bundle="batchparamset" key="default" />
							</td>
							<td>
								<bean:message bundle="batchparamset" key="memo" />
							</td>

						</tr>
						<c:forEach var="item" items="${requestScope.LIST.datas}">
							<tr class="table_style_content" align="center">
								<td>
									<c:out value="${item.fieldindex}" />
								</td>
								<td>
									<c:out value="${item.businame}" />
								</td>
								<td>
									<c:out value="${item.fieldname}" />
								</td>
								<td>
									<s:Code2Name code="${item.mainfield}"
										definition="#QS_MAINFIELD" />
								</td>
								<td>
									<c:out value="${item.defaultvalue}" />
								</td>
								<td>
									<c:out value="${item.memo}" />
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
									onfocus="buttonover(this)" onblur="buttonout(this)" value="¹Ø±Õ"
									onClick="window.close();" />
							</TD>
						</TR>
					</TBODY>
				</TABLE>
			</DIV>
		</html:form>
	</body>
</html>









