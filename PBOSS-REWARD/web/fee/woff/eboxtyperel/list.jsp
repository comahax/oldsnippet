<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc"%>
<%
	String ID_1 = "EBOXTYPEPEL_NEW";
	String ID_2 = "EBOXTYPEPEL_DET";
	String ID_3 = "EBOXTYPEPEL_EDIT";
%>
<html>
	<head>
		<title><bean:message bundle="eboxunit" key="eboxtypetitle" /></title>
		<script language="JavaScript" type="text/JavaScript">
        function ev_check() {
        	addfield('_ne_eboxunitid', '<bean:message bundle="eboxunit" key="eboxunitid"/>', 'l', true, 14);
            addfield('_ne_eboxtype', '<bean:message bundle="eboxunit" key="eboxtype"/>', 'i', true, 3);
           return checkval(window);
        }
    </script>
	</head>

	<body onload="loadforiframe();">
		<div class="table_container">
			<html:form action="/fee/woff/eboxtyperel.do?CMD=LIST" styleId="formList" method="post" onsubmit="return ev_check();">
				<html:hidden property="_orderby" />
				<html:hidden property="_desc" />
				<html:hidden property="_pageno" />
				<html:hidden property="_pagesize" />
				<input type="hidden" name="_rowcount" value="<c:out value='${requestScope.LIST.rowCount}' />">

				<div class="table_div">
					<table class="top_table">
						<tr>
							<td>
								<bean:message bundle="eboxunit" key="eboxtypetitle" />
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
					<table class="form_table">
						<tr>
							<td class="form_table_right">
								<bean:message bundle="eboxunit" key="eboxunitid" />
								:
							</td>
							<td class="form_table_left">
								<s:zoom definition="#EBOXUNIT" property="_ne_eboxunitid" styleClass="form_input_1x"/>
							</td>
							<td class="form_table_right">
								<bean:message bundle="eboxunit" key="eboxtype" />
								:
							</td>
							<td class="form_table_left">
								<html:select property="_ne_eboxtype" >
                    			<html:option value=" "></html:option>
                    			<s:Options definition="$IB_EBOXTYPEREL" nameOnly="false"/>
                    		</html:select>
							</td>
						</tr>
					</table>
				</div>

				<div class="table_div">
					<table class="table_button_list">
						<tr>
							<td>
							<s:PurChk2 controlid="<%=ID_1%>" disableChild="true">
								<input type="button" name="btnNew" class="add" onmouseover="buttonover(this);" onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)" value="<bean:message bundle="public" key="button_new"/>"
									onClick="doNew('/fee/woff/eboxtyperel.do')">
							</s:PurChk2>		
							<s:PurChk2 controlid="<%=ID_2%>" disableChild="true">
								<input type="button" name="btnDelete" class="delete" onmouseover="buttonover(this);" onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)" value="<bean:message bundle="public" key="button_delete"/>"
									onClick="doDelete('/fee/woff/eboxtyperel.do')">
							</s:PurChk2>
							<s:PurChk controlid="<%=ID_3%>">		
								<input type="button" class="query" onmouseover="buttonover(this);" onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)" value="<bean:message bundle="public" key="button_search"/>" onclick="doQuery()" />
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
									<a href="javascript:doOrderby('eboxunitid')"><bean:message bundle="eboxunit" key="eboxunitid" /></a>
									<s:OrderImg form="/fee/woff/eboxtyperel/EboxtypeRelForm" field="eboxunitid" />
								</td>
								<td>
									<bean:message bundle="eboxunit" key="eboxunitname" />
								</td>
								<td>
									<a href="javascript:doOrderby('eboxtype')"><bean:message bundle="eboxunit" key="eboxtype" /></a>
									<s:OrderImg form="/fee/woff/eboxtyperel/EboxtypeRelForm" field="eboxtype" />
								</td>

							</tr>
							<c:forEach var="item" items="${requestScope.LIST.datas}">
								<c:url value="/fee/woff/eboxtyperel.do?CMD=EDIT" var="urlContent">
									<c:param name="PK" value="${item.eboxunitid}" />
								</c:url>
								<tr class="table_style_content" align="center">
									<td>
										<input type="checkbox" name="_selectitem" value="<c:out value='${item.eboxunitid}' />" onclick="checkOne();" class="table_checkbox">
									</td>
									<td>
									<s:PurChk2 controlid="<%=ID_3%>" disableChild="true">
										<a href='<c:out value="${urlContent}"/>'><c:out value="${item.eboxunitid}" /></a>
									</s:PurChk2>
									</td>
									<td>
										<s:Code2Name code="${item.eboxunitid}" definition="#EBOXUNIT" />
									</td>
									<td>
										<s:Code2Name code="${item.eboxtype}" definition="$IB_EBOXTYPEREL" />
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
