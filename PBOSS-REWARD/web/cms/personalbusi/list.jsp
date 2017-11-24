<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc"%>
<html>
	<head>
		<title><bean:message bundle="personalbusi" key="titleList" /></title>
		<script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            addfield('_dnl_opntime', '<bean:message bundle="personalbusi" key="opntime"/>', 'dt', true, '25');
            addfield('_dnm_opntime', '<bean:message bundle="personalbusi" key="opntime"/>', 'dt', true, '25');            
            addfield('_ne_itemid', '<bean:message bundle="personalbusi" key="itemid"/>', 'l', true, '13');
            return checkval(window);
        }
        function goTo(cmd)
        {
        	var url=contextPath+cmd;
        	formList.action=url;
        	formList.submit();
        }
    </script>
	</head>

	<body onload="if(window.loadforiframe) loadforiframe();">
		<div class="table_container">
			<html:form action="/cms/personalbusi.do?CMD=LIST" styleId="formList" method="post" onsubmit="return ev_check();">
				<html:hidden property="_orderby" />
				<html:hidden property="_desc" />
				<html:hidden property="_pageno" />
				<html:hidden property="_pagesize" />
				<input type="hidden" name="_rowcount" value="<c:out value='${requestScope.LIST.rowCount}' />">

				<!--##################################添加标题内容##################################################-->
				<div class="table_div">
					<table class="top_table">
						<tr>
							<td>
								<bean:message bundle="personalbusi" key="titleList" />
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
							<td width="80" height="20" align="right" class="form_table_right">
								<bean:message bundle="personalbusi" key="opntime" /> &gt;=:
							</td>
							<td class="form_table_left">
								<html:text styleClass="form_input_1x" property="_dnl_opntime"  onclick="this.value=selectDatetime()"/>
							</td>
							<td width="80" height="20" align="right" class="form_table_right">
								<bean:message bundle="personalbusi" key="opntime" /> &lt;=:
							</td>
							<td class="form_table_left">
								<html:text styleClass="form_input_1x" property="_dnm_opntime"   onclick="this.value=selectDatetime()"/>
							</td>
						</tr>
						<tr>
							<td width="80" height="20" align="right" class="form_table_right">
								<bean:message bundle="personalbusi" key="itemid" />
							</td>
							<td class="form_table_left">
								<html:text styleClass="form_input_1x" property="_ne_itemid" />
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
								<input type="button" name="btnNew" class="button_4" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
									onfocus="buttonover(this)" onblur="buttonout(this)"
									value='<bean:message bundle="personalbusi" key="batchNew"/>' onclick="goTo('/cms/personalbusi/upload.do');" />
								<input type="button" name="btnNew" class="add" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
									onfocus="buttonover(this)" onblur="buttonout(this)" value="<bean:message bundle="public" key="button_new"/>"
									onClick="doNew('/cms/personalbusi.do')">
								<input type="button" name="btnDelete" class="delete" onmouseover="buttonover(this);"
									onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
									value="<bean:message bundle="public" key="button_delete"/>" onClick="doDelete('/cms/personalbusi.do')">
								<input type="button" class="query" onmouseover="buttonover(this);" onmouseout="buttonout(this);" onclick="doQuery();" 
									onfocus="buttonover(this)" onblur="buttonout(this)" value="<bean:message bundle="public" key="button_search"/>" />

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
									<a href="javascript:doOrderby('itemid')"><bean:message bundle="personalbusi" key="itemid" /> </a>
									<s:OrderImg form="/cms/personalbusi/personalbusiForm" field="itemid" />
								</td>
								<td>
									<a href="javascript:doOrderby('opntime')"><bean:message bundle="personalbusi" key="opntime" /> </a>
									<s:OrderImg form="/cms/personalbusi/personalbusiForm" field="opntime" />
								</td>
								<td>
									<a href="javascript:doOrderby('mobile')"><bean:message bundle="personalbusi" key="mobile" /> </a>
									<s:OrderImg form="/cms/personalbusi/personalbusiForm" field="mobile" />
								</td>
								<td>
									<a href="javascript:doOrderby('brand')"><bean:message bundle="personalbusi" key="brand" /> </a>
									<s:OrderImg form="/cms/personalbusi/personalbusiForm" field="brand" />
								</td>
								<td>
									<a href="javascript:doOrderby('opntype')"><bean:message bundle="personalbusi" key="opntype" /> </a>
									<s:OrderImg form="/cms/personalbusi/personalbusiForm" field="opntype" />
								</td>
								<td>
									<a href="javascript:doOrderby('wayid')"><bean:message bundle="personalbusi" key="wayid" /> </a>
									<s:OrderImg form="/cms/personalbusi/personalbusiForm" field="wayid" />
								</td>
								<td>
									<a href="javascript:doOrderby('oprtype')"><bean:message bundle="personalbusi" key="oprtype" /> </a>
									<s:OrderImg form="/cms/personalbusi/personalbusiForm" field="oprtype" />
								</td>
							</tr>
							<c:forEach var="item" items="${requestScope.LIST.datas}">
								<c:url value="/cms/personalbusi.do?CMD=EDIT" var="urlContent">
									<%
									//this param name must "PK"
									%>
									<c:param name="PK" value="${item.itemid}" />
									<%-- <c:param name="PK" value="'${item.id}|${item.id2}'"/> --%>
								</c:url>
								<tr class="table_style_content" align="center">
									<td>
										<input type="checkbox" name="_selectitem" value="<c:out value='${item.itemid}' />" onclick="checkOne();"
											class="table_checkbox">
									</td>
									<td>
										<a href='<c:out value="${urlContent}"/>'><c:out value="${item.itemid}" /> </a>
									</td>
									<td>
										<fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${item.opntime}" />
									</td>
									<td>
										<c:out value="${item.mobile}" />
									</td>
									<td>
										<s:Code2Name definition="#BUSI_BRAND" code="${item.brand}"></s:Code2Name>
									</td>
									<td>
										<s:Code2Name code="${item.opntype}" definition="#OPERATION" />
									</td>
									<td>
										<c:out value="${item.wayid}" />
									</td>
									<td>
										<s:Code2Name definition="#BUSI_OPRTYPE" code="${item.oprtype}"></s:Code2Name>
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
