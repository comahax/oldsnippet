<%@ page language="java" contentType="text/html;charset=GBK"%>
<jsp:include page="/inc/acl.jsp">
	<jsp:param name="PID" value="4D1A1AAA" />
</jsp:include>
<%@ include file="/inc/contenthead.inc"%>
<html:html>
<head>
	<title><bean:message bundle="acctincome" key="title3" />
	</title>
	<script language="JavaScript">
        function ev_checkval() {  
            addfield('acctid', '<bean:message bundle="acctincome" key="acctid"/>', 'l', false, 14);
            addfield('accttype', '<bean:message bundle="acctincome" key="accttype"/>', 'l', true, 3);
            return checkval(window);
        }
    </script>
</head>
<body onload="loadforiframe();">
	<div class="table_container">
		<html:form action="/fee/woff/accttyperel.do?CMD=SAVE"
			styleId="formItem" method="post">

			<html:hidden property="cmdState" />

			<html:hidden property="_orderby" />
			<html:hidden property="_desc" />
			<html:hidden property="_pageno" />
			<html:hidden property="_pagesize" />

			<input type="hidden" name="_rowcount" />



			<c:set var="edtState" scope="request"
				value="${!empty param.CMD and (param.CMD eq 'EDIT' or param.CMD eq 'NEW')}" />
			<c:set var="new" scope="request"
				value="${!empty param.CMD and param.CMD eq 'NEW'}" />

			<div class="table_div">
				<table class="top_table">
					<tr>
						<td>
							<bean:message bundle="acctincome" key="title3" />
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
						<td colspan="4">
							<bean:message bundle="fee" key="redStarExplain" />
						</td>
					</tr>
					<tr>
						<td class="form_table_right">
							<bean:message bundle="acctincome" key="acctid" />
							:
							<div class="field-require"></div>
						</td>
						<td class="form_table_left">

							<c:choose>
								<c:when test="${edtState and new}">
									<s:zoom definition="#WOFF-ACCT" property="acctid"
										styleClass="form_input_1x"/>
									<bean:message bundle="fee" key="redStar" />
								</c:when>
								<c:otherwise>
									<s:zoom definition="#WOFF-ACCT" property="acctid"
										styleClass="form_input_1x" showonly="true" disabled="true" />
									<bean:message bundle="fee" key="redStar" />
								</c:otherwise>
							</c:choose>


						</td>
						<td class="form_table_right">
							<div class="field-require">
								<bean:message bundle="acctincome" key="accttype" />
								:
							</div>
						</td>
						<td class="form_table_left">
							<c:choose>
								<c:when test="${edtState}">
								<html:select property="accttype">
								<html:option value=" "></html:option>
								<s:Options definition="$IB_ACCTTYPEREL" />
							</html:select>
								</c:when>
								<c:otherwise>
									<html:select property="accttype">
								<html:option value=" "></html:option>
								<s:Options definition="$IB_ACCTTYPEREL" nameOnly="false"/>
							</html:select>
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
							<input type="button" onmouseover="buttonover(this);"
								onmouseout="buttonout(this);" name="btnSave"
								onfocus="buttonover(this)" onblur="buttonout(this)"
								value="<bean:message bundle="public" key="button_submit"/>"
								class="submit"
								onclick="doSave('/fee/woff/accttyperel.do?CMD=SAVE')" />
							<input type="button" onmouseover="buttonover(this);"
								onmouseout="buttonout(this);" name="btnReturn"
								onfocus="buttonover(this)" onblur="buttonout(this)"
								value="<bean:message bundle="public" key="button_return"/>"
								class="close"
								onclick="doReturn('/fee/woff/accttyperel.do?CMD=LIST')">
						</td>
					</tr>
				</table>
			</div>
		</html:form>
	</div>
</body>
</html:html>
