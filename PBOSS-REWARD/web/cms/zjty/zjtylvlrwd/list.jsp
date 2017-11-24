<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc"%>
<%
String ID_1 = "CH_ZJTY_REWARD||CH_ZJTY_PROVINCIAL";
%>
<html>
	<head>
		<title><bean:message bundle="zjtylvlrwd" key="titleList" />
		</title>
		<script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            return checkval(window);
        }
    </script>
		<script type="text/javascript"
			src="<%=contextPath%>/js/bus/waycommon.js"></script>
		<script type="text/javascript"
			src="<%=contextPath%>/js/bus/rescommon.js"></script>
	</head>

	<body onload="if(window.loadforiframe) loadforiframe();">
		<div class="table_container">
			<html:form action="/cms/zjty/zjtylvlrwd.do?CMD=LIST"
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
								<bean:message bundle="zjtylvlrwd" key="titleList" />
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
					<table class="table_button_list">
						<tr>
							<td align=right>

								<input type="button" name="btnNew" class="add"
									onmouseover="buttonover(this);" onmouseout="buttonout(this);"
									onfocus="buttonover(this)" onblur="buttonout(this)"
									value="<bean:message bundle="public" key="button_new"/>"
									onClick="doNew('/cms/zjty/zjtylvlrwd.do')">
								<s:RewardPurChk controlid="<%=ID_1%>" disableChild="true">
									<input type="button" name="btnDelete" class="delete"
										onmouseover="buttonover(this);" onmouseout="buttonout(this);"
										onfocus="buttonover(this)" onblur="buttonout(this)"
										value="<bean:message bundle="public" key="button_delete"/>"
										onClick="doDelete('/cms/zjty/zjtylvlrwd.do')">
								</s:RewardPurChk>
								<input type="button" class="query"
									onmouseover="buttonover(this);" onclick="doQuery();"
									onmouseout="buttonout(this);" onfocus="buttonover(this)"
									onblur="buttonout(this)"
									value="<bean:message bundle="public" key="button_search"/>" />

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
									<a href="javascript:doOrderby('citylevel')"><bean:message
											bundle="zjtylvlrwd" key="citylevel" />
									</a>
									<s:OrderImg form="/cms/zjty/zjtylvlrwd/ZjtyLvlrwdForm"
										field="citylevel" />
								</td>
								<td>
									<a href="javascript:doOrderby('checkcoef')"><bean:message
											bundle="zjtylvlrwd" key="checkcoef" />
									</a>
									<s:OrderImg form="/cms/zjty/zjtylvlrwd/ZjtyLvlrwdForm"
										field="checkcoef" />
								</td>
								<td>
									<a href="javascript:doOrderby('fixedrwd')"><bean:message
											bundle="zjtylvlrwd" key="fixedrwd" />
									</a>
									<s:OrderImg form="/cms/zjty/zjtylvlrwd/ZjtyLvlrwdForm"
										field="fixedrwd" />
								</td>
								<td>
									<a href="javascript:doOrderby('prize')"><bean:message
											bundle="zjtylvlrwd" key="prize" />
									</a>
									<s:OrderImg form="/cms/zjty/zjtylvlrwd/ZjtyLvlrwdForm"
										field="prize" />
								</td>
							</tr>
							<c:forEach var="item" items="${requestScope.LIST.datas}">
								<c:url value="/cms/zjty/zjtylvlrwd.do?CMD=EDIT" var="urlContent">
									<%
									//this param name must "PK"
									%>
									<c:param name="PK" value="${item.citylevel}" />
									<%-- <c:param name="PK" value="'${item.id}|${item.id2}'"/> --%>
								</c:url>
								<tr class="table_style_content" align="center">
									<td>
										<input type="checkbox" name="_selectitem"
											value="<c:out value='${item.citylevel}' />"
											onclick="checkOne();" class="table_checkbox">
									</td>
									<td>
										<a href='<c:out value="${urlContent}"/>'><s:Code2Name
												code="${item.citylevel}" definition="#CH_ZJTY_CITYLEVEL" />
										</a>
									</td>
									<td>
										<c:out value="${item.checkcoef}" />
									</td>
									<td>
										<fmt:formatNumber pattern="0.00" value="${item.fixedrwd}" /></td>
									
									<td>
										<fmt:formatNumber pattern="0.00" value="${item.prize}" />
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
