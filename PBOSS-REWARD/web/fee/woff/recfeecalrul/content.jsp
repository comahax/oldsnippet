<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/contenthead.inc"%>
<jsp:include page="/inc/acl.jsp">
	<jsp:param name="PID" value="4D6F1A5EAA" />
</jsp:include>
<%
	String ID_1 = "4D6F1A5EAABT1";
	String ID_2 = "4D6F1A5EAABT2";
%>
<html:html>
<head>
	<title><bean:message bundle="RecfeeCalRul" key="titleUpdate" />
	</title>
	<script language="JavaScript">

        function ev_checkval() {
            addfield('rulepri', '<bean:message bundle="RecfeeCalRul" key="rulepri"/>', 'i', false, 14);
            addfield('paymodetype', '<bean:message bundle="RecfeeCalRul" key="paymodetype"/>', 'c', false, 1);
            addfield('paytype', '<bean:message bundle="RecfeeCalRul" key="paytype"/>', 'i', false, 1);
            addfield('rulecondition', '<bean:message bundle="RecfeeCalRul" key="rulecondition"/>', 'c', false, 255);
            addfield('rulecontent', '<bean:message bundle="RecfeeCalRul" key="rulecontent"/>', 'c', false, 255);
            addfield('strBegintime', '<bean:message bundle="fee" key="begintime"/>', 'dt', false, 20);    
            addfield('strEndtime', '<bean:message bundle="fee" key="endtime"/>', 'dt', false, 20);  
            if(date_compare("strBegintime","strEndtime",'<bean:message bundle="WoffRule" key="BeginTime" />'+'<bean:message bundle="fee" key="compare_gt" />'+'<bean:message bundle="WoffRule" key="EndTime" />')) return;
            return checkval(window);
        }
    </script>
</head>
<body>
	<DIV class=table_container>
		<html:form action="/fee/woff/recfeecalrule.do?CMD=SAVE"
			styleId="formItem" method="post">

			<html:hidden property="cmdState" />

			<html:hidden property="_orderby" />
			<html:hidden property="_desc" />
			<html:hidden property="_pageno" />
			<html:hidden property="_pagesize" />
			<html:hidden property="_sk_rulecondition" />
			<html:hidden property="_sk_rulecontent" />
			<c:set var="edtState" scope="request"
				value="${!empty param.CMD and (param.CMD eq 'EDIT' or param.CMD eq 'NEW')}" />

			<div class="table_div">
				<table class="top_table">
					<tr>
						<td>
							<bean:message bundle="RecfeeCalRul" key="title" />
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
				<TABLE class=form_table>
					<TR>
						<TD class="form_table_left" colSpan=2>
							<bean:message bundle="fee" key="redStarExplain" />
						</TD>
					</TR>
					<c:if test="${param.CMD ne 'NEW'}">
						<TR>
							<td class="form_table_right">
								<div class="field-require">
									<bean:message bundle="RecfeeCalRul" key="ruleid" />
									:
								</div>
							</td>
							<td class="form_table_left">
								<html:text styleClass="form_input_1x" property="ruleid"
									disabled="true" />
							</td>
						</tr>
					</c:if>
					<TR>
						<td class="form_table_right">
							<div class="field-require">
								<bean:message bundle="RecfeeCalRul" key="rulepri" />
								:
							</div>
						</td>
						<td class="form_table_left">
							<c:choose>
								<c:when test="${edtState}">
									<html:text styleClass="form_input_1x" property="rulepri"
										maxlength="24" />
									<bean:message bundle="fee" key="redStar" />
								</c:when>
								<c:otherwise>
									<html:text styleClass="form_input_1x" property="rulepri"
										disabled="true" />
								</c:otherwise>
							</c:choose>
						</td>
					</tr>
					<TR>
						<td class="form_table_right">
							<div class="field-require">
								<bean:message bundle="RecfeeCalRul" key="begintime" />
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
								<bean:message bundle="RecfeeCalRul" key="endtime" />
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
								<bean:message bundle="RecfeeCalRul" key="paymodetype" />
								:
							</div>
						</td>
						<td class="form_table_left">
							<c:choose>
								<c:when test="${edtState}">
									<html:select property="paymodetype">
										<s:Options definition="$IB_PAYMODETYPE" />
									</html:select>
									<bean:message bundle="fee" key="redStar" />
								</c:when>
								<c:otherwise>
									<html:text styleClass="form_input_1x" property="paymodetype"
										disabled="true" />
								</c:otherwise>
							</c:choose>
						</td>
					</tr>
					<TR>
						<td class="form_table_right">
							<div class="field-require">
								<bean:message bundle="RecfeeCalRul" key="paytype" />
								:
							</div>
						</td>
						<td class="form_table_left">
							<c:choose>
								<c:when test="${edtState}">
									<html:select property="paytype">
										<s:Options definition="#RECFEECALRUL_PATYPE" />
									</html:select>
									<bean:message bundle="fee" key="redStar" />
								</c:when>
								<c:otherwise>
									<html:text styleClass="form_input_1x" property="paytype"
										disabled="true" />
								</c:otherwise>
							</c:choose>
						</td>
					</tr>
					<TR>
						<td class="form_table_right">
							<div class="field-require">
								<bean:message bundle="RecfeeCalRul" key="rulecondition" />
								:
							</div>
						</td>
						<td class="form_table_left">
							<c:choose>
								<c:when test="${edtState}">
									<html:text styleClass="form_input_1x" property="rulecondition" />
									<bean:message bundle="fee" key="redStar" />
								</c:when>
								<c:otherwise>
									<html:text styleClass="form_input_1x" property="rulecondition"
										disabled="true" />
								</c:otherwise>
							</c:choose>
						</td>
					</tr>
					<TR>
						<td class="form_table_right">
							<div class="field-require">
								<bean:message bundle="RecfeeCalRul" key="rulecontent" />
								:
							</div>
						</td>
						<td class="form_table_left">
							<c:choose>
								<c:when test="${edtState}">
									<html:text styleClass="form_input_1x" property="rulecontent" />
									<bean:message bundle="fee" key="redStar" />
								</c:when>
								<c:otherwise>
									<html:text styleClass="form_input_1x" property="rulecontent"
										disabled="true" />
								</c:otherwise>
							</c:choose>
						</td>
					</tr>
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
										onclick="doSave('/fee/woff/recfeecalrule.do?CMD=SAVE')" />
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
								onclick="doReturn('/fee/woff/recfeecalrule.do?CMD=LIST')">
						</td>
					</tr>
				</table>
			</div>
		</html:form>
	</DIV>
</body>
</html:html>
