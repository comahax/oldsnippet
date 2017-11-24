<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc"%>
<html>
	<head>
		<title><bean:message bundle="public" key="choosedata" /></title>
			<base target="_self">
		<script language="JavaScript" type="text/JavaScript">
        function ev_check() {
        	addfield('_ne_nodeid', '<bean:message bundle="eboxacct" key="nodeid"/>', 'l', true, 14);
            addfield('_sk_nodename', '<bean:message bundle="eboxacct" key="nodename"/>', 'c', true, 128);
            return checkval(window);
        }
        function selme( code, name ) {
            	self.returnValue = code + ";" + name ;
		        self.close();
	    }

    </script>
	</head>

	<body onload="document.formList._ne_nodeid.focus()">
		<div class="table_container">
			<html:form action="/fee/commons/eboxacct.do?CMD=LIST" styleId="formList" method="post" onsubmit="return ev_check();">
				<html:hidden property="_orderby" />
				<html:hidden property="_desc" />
				<html:hidden property="_pageno" />
				<html:hidden property="_pagesize" />
				<html:hidden property="type" />
				<html:hidden property="condition" />
				<input type="hidden" name="_rowcount" value="<c:out value='${requestScope.LIST.rowCount}' />">

				<div class="table_div">
					<table class="top_table">
						<tr>
							<td>
								<title><bean:message bundle="public" key="choosedata" /></title>
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
								<bean:message bundle="eboxacct" key="nodeid" />
								:
							</td>
							<td class="form_table_left">
								<html:text styleClass="form_input_1x" property="_ne_nodeid" maxlength="14"></html:text>
							</td>
							<td class="form_table_right">
								<bean:message bundle="eboxacct" key="nodename" />
								:
							</td>
							<td class="form_table_left">
								<html:text styleClass="form_input_1x" property="_sk_nodename" maxlength="128"></html:text>
							</td>
						</tr>
					</table>
				</div>

				<div class="table_div">

					<table class="table_button_list">
						<tr>
							<td>

								<input type="button" class="query" onmouseover="buttonover(this);" onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)" value="<bean:message bundle="public" key="button_search"/>" onclick="doQuery();" />
								<%--c:choose>
	                    <c:when test="${!empty requestScope.LIST.datas}">
								<input type="button" name="btnDelete" class="delete" onmouseover="buttonover(this);" onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)" value="<bean:message bundle="public" key="button_submit"/>"
									onClick="frmSubmit();">
								</c:when>
	                    <c:otherwise--%>
								<input type="button" name="btnDelete" class="delete" onmouseover="buttonover(this);" onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)" value="<bean:message bundle="public" key="button_close"/>"
									onClick="window.close();">
								<%--/c:otherwise>
                    </c:choose--%>

							</td>
						</tr>
					</table>
				</div>

				<div class="table_div">
					<div class="table_LongTable">
						<table class="table_style" ID="Table2">
							<tr class="table_style_head">
								<td>
									<a href="javascript:doOrderby('nodeid')"><bean:message bundle="eboxacct" key="nodeid" /></a>
									<s:OrderImg form="/fee/commons/eboxacct/EboxAcctForm" field="nodeid" />
								</td>
								<td>
									<a href="javascript:doOrderby('nodename')"><bean:message bundle="eboxacct" key="nodename" /></a>
									<s:OrderImg form="/fee/commons/eboxacct/EboxAcctForm" field="nodename" />
								</td>
								<td>
								<a href="javascript:doOrderby('nodestate')">
									<bean:message bundle="eboxacct" key="nodestate" />
									</a>
									<s:OrderImg form="/fee/commons/eboxacct/EboxAcctForm" field="nodestate" />
								</td>
							</tr>
                          <tr class="table_style_content" align="center">
						      <td><a href="javascript:selme(' ',' ')" ><bean:message bundle="public" key="empty"/></td>
						       <td><bean:message bundle="public" key="empty"/></td>
						         <td><bean:message bundle="public" key="empty"/></td>
					       </tr>
							<c:forEach var="item" items="${requestScope.LIST.datas}">
								<tr class="table_style_content" align="center">
									<c:choose>
										<c:when test="${requestScope.type}">
											<td>
												<a href="javascript:selme('<c:out value="${item.eboxunitid}"/>','<c:out value="${item.eboxunitname}"/>')"><c:out value="${item.eboxunitid}" /></a>
											</td>
											<td>
												<c:out value="${item.eboxunitname}" />
											</td>
											 <td><s:Code2Name code="${item.eboxunitstate}" definition="$IB_USABLEFLAG"/></td>

										</c:when>
										<c:otherwise>
											<td>
												<a href="javascript:selme('<c:out value="${item.acctid}"/>','<c:out value="${item.acctname}"/>')"><c:out value="${item.acctid}" /></a>
											</td>
											<td>
											      <c:out value="${item.acctname}" />
											</td>
											<td><s:Code2Name code="${item.acctstate}" definition="$IB_ACCTSTATE"/></td>

										</c:otherwise>
									</c:choose>
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
