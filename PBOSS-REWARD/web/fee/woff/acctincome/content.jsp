<%@ page language="java" contentType="text/html;charset=GBK"%>
<jsp:include page="/inc/acl.jsp">
	<jsp:param name="PID" value="4D1A1AAA" />
</jsp:include>
<%@ include file="/inc/contenthead.inc"%>
<html:html>
<head>
	<title><bean:message bundle="acctincome" key="title1" />
	</title>
	<script language="JavaScript">
        function ev_checkval() {  
            addfield('acctid', '<bean:message bundle="acctincome" key="acctid"/>', 'l', false, 14);
            addfield('acctcode', '<bean:message bundle="acctincome" key="acctcode"/>', 'c', true, 32);
            addfield('acctcodename', '<bean:message bundle="acctincome" key="acctcodename"/>', 'c', true, 128);
            addfield('descri', '<bean:message bundle="acctincome" key="descri"/>', 'c', true, 512);
            addfield('type', '<bean:message bundle="acctincome" key="type"/>', 'l', true, 3);
            addfield('isresolution', '<bean:message bundle="acctincome" key="isresolution"/>', 'l', true, 3);
            
            return checkval(window);
        }
    </script>
</head>
<body onload="loadforiframe();">
	<div class="table_container">
		<html:form action="/fee/woff/acctincome.do?CMD=SAVE"
			styleId="formItem" method="post">

			<html:hidden property="cmdState" />

			<html:hidden property="_orderby" />
			<html:hidden property="_desc" />
			<html:hidden property="_pageno" />
			<html:hidden property="_pagesize" />
			<html:hidden property="_ne_acctid" />
			<html:hidden property="_se_acctcode" />
			<html:hidden property="_ne_type" />

			<input type="hidden" name="_rowcount" />



			<c:set var="edtState" scope="request"
				value="${!empty param.CMD and (param.CMD eq 'EDIT' or param.CMD eq 'NEW')}" />
			<c:set var="new" scope="request"
				value="${!empty param.CMD and param.CMD eq 'NEW'}" />

			<div class="table_div">
				<table class="top_table">
					<tr>
						<td>
							<bean:message bundle="acctincome" key="title1" />
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
								<bean:message bundle="acctincome" key="acctcode" />
								:
							</div>
						</td>
						<td class="form_table_left">
							<c:choose>
								<c:when test="${edtState}">
									<html:text styleClass="form_input_1x" property="acctcode" />
								</c:when>
								<c:otherwise>
									<html:text styleClass="form_input_1x" property="acctcode"
										disabled="true" />
								</c:otherwise>
							</c:choose>
						</td>
					</tr>

					<tr>

						<td class="form_table_right">
							<div class="field-require">
								<bean:message bundle="acctincome" key="acctcodename" />
								:
							</div>
						</td>
						<td class="form_table_left">
							<c:choose>
								<c:when test="${edtState}">
									<html:text styleClass="form_input_1x" property="acctcodename" />
								</c:when>
								<c:otherwise>
									<html:text styleClass="form_input_1x" property="acctcodename"
										disabled="true" />
								</c:otherwise>
							</c:choose>
						</td>
						<td class="form_table_right">
							<div class="field-require">
								<bean:message bundle="acctincome" key="type" />
								:
							</div>
						</td>
						<td class="form_table_left">
							<c:choose>
								<c:when test="${edtState}">
									<s:zoom definition="#ACCTTCODEYPE" property="type" styleClass="form_input_1x"/>
								</c:when>
								<c:otherwise>
									<s:zoom definition="#ACCTTCODEYPE" property="type" styleClass="form_input_1x" disabled="true" />
								</c:otherwise>
							</c:choose>
						</td>
					</tr>
					
					<tr>
						<td class="form_table_right">
							<div class="field-require">
								<bean:message bundle="acctincome" key="isresolution" />
								:
							</div>
						</td>
						<td class="form_table_left">
							<c:choose>
								<c:when test="${edtState}">
								<html:select property="isresolution">
								<html:option value=" "></html:option>
								<s:Options definition="$IB_YESNO10" />
							</html:select>
								</c:when>
								<c:otherwise>
									<html:select property="isresolution">
								<html:option value=" "></html:option>
								<s:Options definition="$IB_YESNO10" nameOnly="false"/>
							</html:select>
								</c:otherwise>
							</c:choose>
						</td>
						<td class="form_table_right" />
						<td class="form_table_left"/>
					</tr>
					

					<tr>
						<td class="form_table_right">
							<div class="field-require">
								<bean:message bundle="acctincome" key="descri" />
								:
							</div>
						</td>
						<td class="form_table_left" colspan="3">
							<c:choose>
								<c:when test="${edtState}">
									<html:textarea property="descri" styleClass="form_textarea_on" />
								</c:when>
								<c:otherwise>
									<html:textarea property="descri" styleClass="form_textarea_on"
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
							<input type="button" onmouseover="buttonover(this);"
								onmouseout="buttonout(this);" name="btnSave"
								onfocus="buttonover(this)" onblur="buttonout(this)"
								value="<bean:message bundle="public" key="button_submit"/>"
								class="submit"
								onclick="doSave('/fee/woff/acctincome.do?CMD=SAVE')" />
							<input type="button" onmouseover="buttonover(this);"
								onmouseout="buttonout(this);" name="btnReturn"
								onfocus="buttonover(this)" onblur="buttonout(this)"
								value="<bean:message bundle="public" key="button_return"/>"
								class="close"
								onclick="doReturn('/fee/woff/acctincome.do?CMD=LIST')">
						</td>
					</tr>
				</table>
			</div>
		</html:form>
	</div>
</body>
</html:html>
