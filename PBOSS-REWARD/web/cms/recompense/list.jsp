<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc"%>
<jsp:include page="/inc/acl.jsp">
  <jsp:param name="PID" value="2B3C1A" />
</jsp:include>
<%
	String ID_1 = "2B3C1ABT1";
	String ID_2 = "2B3C1ABT2";
	String ID_3 = "2B3C1ABT3";
%>
<html>
	<head>
		<title><bean:message bundle="recompense" key="title" /></title>
		<script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            addfield('_ne_recid', '<bean:message bundle="recompense" key="recid"/>', 'l', true, 8);
            addfield('_ne_target', '<bean:message bundle="recompense" key="target"/>', 'l', true, 12);
            addfield('_ne_quotiety', '<bean:message bundle="recompense" key="quotiety"/>', 'd', true, 14,2);
            addfield('_ne_standard', '<bean:message bundle="recompense" key="standard"/>', 'd', true, 14,2);
            addfield('_sk_balanceterm', '<bean:message bundle="recompense" key="balanceterm"/>', 'c', true, 128);
            addfield('_se_comtype', '<bean:message bundle="recompense" key="comtype"/>', 'c', true, 4);
            addfield('_se_bchlevel', '<bean:message bundle="recompense" key="bchlevel"/>', 'c', true, 4);           
            return checkval(window);
        }        
    </script>
    <script type="text/javascript" src="<%=contextPath%>/js/bus/waycommon.js"></script>
	</head>

	<body onload="loadforiframe();">
		<div class="table_container">

			<html:form action="/cms/recompense.do?CMD=LIST" styleId="formList" method="post" onsubmit="return ev_check();">
				<html:hidden property="_orderby" />
				<html:hidden property="_desc" />
				<html:hidden property="_pageno" />
				<html:hidden property="_pagesize" />
				<input type="hidden" name="_rowcount" value="<c:out value='${requestScope.LIST.rowCount}' />">
				
				<div class="table_div">

					<table class="top_table">
						<tr>

							<td>
								<bean:message bundle="recompense" key="title" />
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
								<bean:message bundle="recompense" key="recid" />
								:
							</td>
							<td class="form_table_left">
								<html:text styleClass="form_input_1x" property="_ne_recid"></html:text>
							</td>

							<td class="form_table_right">
								<bean:message bundle="recompense" key="target" />
								:
							</td>
							<td class="form_table_left">
								<html:text styleClass="form_input_1x" property="_ne_target"></html:text>
							</td>
						</tr>
						<tr>
							<td class="form_table_right">
								<bean:message bundle="recompense" key="quotiety" />
								:
							</td>
							<td class="form_table_left">
								<html:text styleClass="form_input_1x" property="_ne_quotiety"></html:text>
							</td>



							<td class="form_table_right">
								<bean:message bundle="recompense" key="standard" />
								:
							</td>
							<td class="form_table_left">
								<html:text styleClass="form_input_1x" property="_ne_standard"></html:text>
							</td>


						</tr>
						<tr>
							<td class="form_table_right">
								<bean:message bundle="recompense" key="balanceterm" />
								:
							</td>
							<td class="form_table_left">
								<html:text styleClass="form_input_1x" property="_sk_balanceterm"></html:text>
							</td>
							<td class="form_table_right">
								<bean:message bundle="recompense" key="comtype" />
								:
							</td>
							<td class="form_table_left">
                                   <html:text styleClass="form_input_1x" property="_se_comtype" readonly="true" onclick="this.value=showSelectWayType()"></html:text>
							</td>
						</tr>
						<tr>
							<td class="form_table_right">
								<bean:message bundle="recompense" key="bchlevel" />
								:
							</td>
							<td class="form_table_left" colspan=3>
								<html:select property="_se_bchlevel">
									<html:option value=""></html:option>
									<s:Options definition="$CH_BCHLEVEL" />
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
									<input type="button" class="query" onmouseover="buttonover(this);" onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)" value="<bean:message bundle="public" key="button_search"/>" onClick="doQuery();" />
								</s:PurChk>
								<s:PurChk controlid="<%=ID_2%>">
									<input type="button" name="btnNew" class="add" onmouseover="buttonover(this);" onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)" value="<bean:message bundle="public" key="button_new"/>"
											onClick="doNew('/cms/recompense.do')">
								</s:PurChk>
								<s:PurChk controlid="<%=ID_3%>">
									<input type="button" name="btnDelete" class="delete" onmouseover="buttonover(this);" onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)" value="<bean:message bundle="public" key="button_delete"/>"
											onClick="doDelete('/cms/recompense.do')">
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
									<bean:message bundle="recompense" key="recid" />
								</td>
								<td>
									<bean:message bundle="recompense" key="target" />
								</td>

								<td>
									<bean:message bundle="recompense" key="quotiety" />
								</td>
								<td>
									<bean:message bundle="recompense" key="balanceterm" />
								</td>
								<td>
									<bean:message bundle="recompense" key="standard" />
								</td>
								<td>
									<bean:message bundle="recompense" key="comtype" />
								</td>
								<td>
									<bean:message bundle="recompense" key="bchlevel" />
								</td>

								<td>
									<bean:message bundle="recompense" key="integral" />
								</td>
								<td>
									<bean:message bundle="recompense" key="businesstype" />
								</td>

								<td>
									<bean:message bundle="recompense" key="prodid" />
								</td>
								<td>
									<bean:message bundle="recompense" key="prosalecode" />
								</td>
								<td>
									<bean:message bundle="recompense" key="salseprodid" />
								</td>
								<td>
									<bean:message bundle="recompense" key="inyxplanid" />
								</td>
								<td>
									<bean:message bundle="recompense" key="intime" />
								</td>
								<td>
									<bean:message bundle="recompense" key="custstate" />
								</td>
								<td>
									<bean:message bundle="recompense" key="chargetype" />
								</td>

								<td>
									<bean:message bundle="recompense" key="moment" />
								</td>
								<td>
									<bean:message bundle="recompense" key="fitstation" />
								</td>
								<td>
									<bean:message bundle="recompense" key="fitopr" />
								</td>
								<td>
									<bean:message bundle="recompense" key="calculatemode" />
								</td>
								<td>
									<bean:message bundle="recompense" key="bossarea" />
								</td>
							</tr>
							<c:forEach var="item" items="${requestScope.LIST.datas}">
								<c:url value="/cms/recompense.do?CMD=EDIT" var="urlContent">
									<c:param name="PK" value="${item.recid}" />
								</c:url>
								<tr class="table_style_content" align="center">
									<td>
										<input type="checkbox" name="_selectitem" value="<c:out value='${item.recid}' />" onclick="checkOne();" class="table_checkbox">
									</td>
									<td>
										<a href='<c:out value="${urlContent}"/>'><c:out value="${item.recid}" /></a>
									</td>
									<td>
										<c:out value="${item.target}" />
									</td>
									<td>

										<fmt:formatNumber pattern="0.00" value="${item.quotiety}" />
									</td>
									<td>
										<c:out value="${item.balanceterm}" />
									</td>
									<td>

										<fmt:formatNumber pattern="0.00" value="${item.standard}" />
									</td>
									<td>

										<s:Code2Name definition="#WAYTYPE" code="${item.comtype}"></s:Code2Name>
									</td>
									<td>

										<s:Code2Name definition="$CH_BCHLEVEL" code="${item.bchlevel}"></s:Code2Name>
									</td>
									<td>

										<fmt:formatNumber pattern="0.00" value="${item.integral}" />
									</td>
									<td>
										<c:out value="${item.businesstype}" />
									</td>
									<td>
										<c:out value="${item.prodid}" />
									</td>
									<td>
										<c:out value="${item.prosalecode}" />

									</td>
									<td>
										<c:out value="${item.salseprodid}" />
									</td>
									<td>
										<c:out value="${item.inyxplanid}" />
									</td>
									<td>
										<!-- c:out value="${item.startdt}" /-->
										<fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${item.intime}" />
									</td>
									<td>
										<c:out value="${item.custstate}" />

									</td>
									<td>

										<s:Code2Name definition="$CH_CHARGETYPE" code="${item.chargetype}"></s:Code2Name>
									</td>
									<td>
										<c:out value="${item.moment}" />
									</td>
									<td>

										<s:Code2Name definition="#CH_PARENTPOST" code="${item.fitstation}"></s:Code2Name>
									</td>
									<td>
										<c:out value="${item.fitopr}" />
									</td>
									<td>
										<c:out value="${item.calculatemode}" />
									</td>
									<td>
										<c:out value="${item.bossarea}" />

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
