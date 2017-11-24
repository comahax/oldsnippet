<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/contenthead.inc"%>
<jsp:include page="/inc/acl.jsp">
	<jsp:param name="PID" value="4D6F1A6FAA" />
</jsp:include>
<%
	String ID_1 = "4D6F1A6FAABT1";
	String ID_2 = "4D6F1A6FAABT2";
%>
<html:html>
<head>
	<title><bean:message bundle="WoffRule" key="titleUpdate" />
	</title>
	<script language="JavaScript">
        function ev_checkval() {
            addfield('acctid', '<bean:message bundle="WoffRule" key="AcctID"/>', 'c', false, 20);
            addfield('eboxunitid', '<bean:message bundle="WoffRule" key="EBoxUnitID"/>', 'c', false, 20);
            addfield('type', '<bean:message bundle="WoffRule" key="Type"/>', 'c', false, 20);   
            addfield('pri', '<bean:message bundle="WoffRule" key="Pri"/>', 'c', false, 20);
            addfield('memo', '<bean:message bundle="WoffRule" key="Memo"/>', 'c', false, 20);
            addfield('strBegintime', '<bean:message bundle="fee" key="begintime"/>', 'dt', false, 20);    
            addfield('strEndtime', '<bean:message bundle="fee" key="endtime"/>', 'dt', false, 20);  
            if(date_compare("strBegintime","strEndtime",'<bean:message bundle="WoffRule" key="BeginTime" />'+'<bean:message bundle="fee" key="compare_gt" />'+'<bean:message bundle="WoffRule" key="EndTime" />')) return;
            return checkval(window);
        }
    </script>
</head>
<body>
	<div class="table_container">
		<html:form action="/fee/woff/woffrule.do?CMD=SAVE" styleId="formItem"
			method="post">
			<html:hidden property="cmdState" />
			<html:hidden property="_orderby" />
			<html:hidden property="_desc" />
			<html:hidden property="_pageno" />
			<html:hidden property="_pagesize" />
			<html:hidden property="_ne_eboxunitid" />
			<html:hidden property="_ne_acctid" />
			<c:set var="edtState" scope="request"
				value="${!empty param.CMD and (param.CMD eq 'EDIT' or param.CMD eq 'NEW')}" />

			<div class="table_div">
				<table class="top_table">
					<tr>
						<td>
							<bean:message bundle="WoffRule" key="title" />
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
					<TBODY>
						<TR>
							<TD class="form_table_left" colSpan=2>
								<bean:message bundle="fee" key="redStarExplain" />
							</TD>
						</TR>

						<TR>

							<td class="form_table_right">
								<div class="field-require">
									<bean:message bundle="WoffRule" key="AcctID" />
									:
								</div>
							</td>
							<td class="form_table_left">
								<c:choose>
									<c:when test="${edtState}">
										<s:zoom definition="#WOFF-ACCT" property="acctid"
											styleClass="form_input_1x" />
										<bean:message bundle="fee" key="redStar" />
									</c:when>
									<c:otherwise>
										<s:zoom definition="#WOFF-ACCT" property="acctid"
											styleClass="form_input_1x" showonly="true" />
										<bean:message bundle="fee" key="redStar" />
									</c:otherwise>
								</c:choose>
							</td>
						</tr>
						<TR>

							<td class="form_table_right">
								<div class="field-require">
									<bean:message bundle="WoffRule" key="EBoxUnitID" />
									:
								</div>
							</td>
							<td class="form_table_left">
								<c:choose>
									<c:when test="${edtState}">
										<s:zoom definition="#EBOXUNIT" property="eboxunitid"
											styleClass="form_input_1x" />
										<bean:message bundle="fee" key="redStar" />
									</c:when>
									<c:otherwise>
										<s:zoom definition="#EBOXUNIT" property="eboxunitid"
											styleClass="form_input_1x" showonly="true" />
										<bean:message bundle="fee" key="redStar" />
									</c:otherwise>
								</c:choose>
							</td>
						</tr>

						<TR>
							<td class="form_table_right">
								<div class="field-require">
									<bean:message bundle="WoffRule" key="Type" />
									:
								</div>
							</td>
							<td class="form_table_left">
								<c:choose>
									<c:when test="${edtState}">
										<html:select property="type">
											<s:Options definition="#WOFF_RUTLTYPE" />
										</html:select>
										<bean:message bundle="fee" key="redStar" />
									</c:when>
									<c:otherwise>
										<html:text styleClass="form_input_1x" property="type"
											disabled="true" />
									</c:otherwise>
								</c:choose>
							</td>
						</tr>
						<TR>
							<td class="form_table_right">
								<div class="field-require">
									<bean:message bundle="WoffRule" key="BeginTime" />
									:
								</div>
							</td>
							<td class="form_table_left">
								<c:choose>
									<c:when test="${edtState}">
										<html:text styleClass="form_input_1x" property="strBegintime"
											onclick="this.value=selectDatetime()" />
										<bean:message bundle="fee" key="redStar" />
									</c:when>
									<c:otherwise>
										<html:text styleClass="form_input_1x" property="strBegintime"
											disabled="true" />
									</c:otherwise>
								</c:choose>
							</td>
						</tr>

						<TR>
							<td class="form_table_right">
								<div class="field-require">
									<bean:message bundle="WoffRule" key="EndTime" />
									:
								</div>
							</td>
							<td class="form_table_left">
								<c:choose>
									<c:when test="${edtState}">
										<html:text styleClass="form_input_1x" property="strEndtime"
											onclick="this.value=selectDatetime()" />
										<bean:message bundle="fee" key="redStar" />
									</c:when>
									<c:otherwise>
										<html:text styleClass="form_input_1x" property="strEndtime"
											disabled="true" />
									</c:otherwise>
								</c:choose>
							</td>
						</tr>
						<TR>
							<td class="form_table_right">
								<div class="field-require">
									<bean:message bundle="WoffRule" key="Pri" />
									:
								</div>
							</td>
							<td class="form_table_left">
								<c:choose>
									<c:when test="${edtState}">
										<html:text styleClass="form_input_1x" property="pri" />
										<bean:message bundle="fee" key="redStar" />
									</c:when>
									<c:otherwise>
										<html:text styleClass="form_input_1x" property="pri"
											disabled="true" />
									</c:otherwise>
								</c:choose>
							</td>
						</tr>
						<TR>
							<td class="form_table_right">
								<div class="field-require">
									<bean:message bundle="WoffRule" key="Memo" />
									:
								</div>
							</td>
							<td class="form_table_left">
								<c:choose>
									<c:when test="${edtState}">
										<html:text styleClass="form_input_1x" property="memo" />
										<bean:message bundle="fee" key="redStar" />
									</c:when>
									<c:otherwise>
										<html:text styleClass="form_input_1x" property="memo"
											disabled="true" />
									</c:otherwise>
								</c:choose>
							</td>
						</tr>
					</TBODY>
				</table>
			</div>

			<div class="table_div">
				<table class="table_button_list">
					<tr>
						<td>
							<c:choose>
								<c:when test="${edtState}">
								<s:PurChk controlid="<%=ID_1%>">
									<input type="button" onmouseover="buttonover(this);"
										onmouseout="buttonout(this);" name="btnSave"
										onfocus="buttonover(this)" onblur="buttonout(this)"
										value="<bean:message bundle="public" key="button_submit"/>"
										class="submit"
										onclick="doSave('/fee/woff/woffrule.do?CMD=SAVE')" />
								</s:PurChk>
								</c:when>
								<c:otherwise>

								</c:otherwise>
							</c:choose>
							<s:PurChk controlid="<%=ID_2%>">
							<input type="button" onmouseover="buttonover(this);"
								onmouseout="buttonout(this);" name="btnPrint"
								onfocus="buttonover(this)" onblur="buttonout(this)"
								value="<bean:message bundle="public" key="button_print"/>"
								class="print" onclick="doPrint()">
							</s:PurChk>
							<input type="button" onmouseover="buttonover(this);"
								onmouseout="buttonout(this);" name="btnReturn"
								onfocus="buttonover(this)" onblur="buttonout(this)"
								value="<bean:message bundle="public" key="button_return"/>"
								class="close"
								onclick="doReturn('/fee/woff/woffrule.do?CMD=LIST')">
						</td>
					</tr>
				</table>
			</div>
		</html:form>
	</div>
</body>
</html:html>
