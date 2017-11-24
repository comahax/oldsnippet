<%@ page language="java" contentType="text/html;charset=GBK"%>
<jsp:include page="/inc/acl.jsp">
	<jsp:param name="PID" value="4D1A1AAA" />
</jsp:include>
<%@ include file="/inc/contenthead.inc"%>
<html:html>
<head>
	<title><bean:message bundle="cooperrater" key="title1" />
	</title>
	<script language="JavaScript">
        function ev_checkval() {  
            addfield('code', '<bean:message bundle="cooperrater" key="code"/>', 'c', false, 20);
            addfield('name', '<bean:message bundle="cooperrater" key="name"/>', 'c', false, 30);
            addfield('linkman', '<bean:message bundle="cooperrater" key="linkman"/>', 'c', false, 15);
            addfield('telcode', '<bean:message bundle="cooperrater" key="telcode"/>', 'c', false, 15);
            addfield('address', '<bean:message bundle="cooperrater" key="address"/>', 'c', false, 50);
            addfield('masterid', '<bean:message bundle="cooperrater" key="masterid"/>', 'c', false, 10);
            addfield('memo', '<bean:message bundle="cooperrater" key="memo"/>', 'c', true, 20);
            return checkval(window);
        }
    </script>
</head>
<body onload="loadforiframe();">
	<div class="table_container">
		<html:form action="/fee/woff/cooperrater.do?CMD=SAVE"
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
							<bean:message bundle="cooperrater" key="title1" />
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
							<bean:message bundle="cooperrater" key="code" />
							:
							<div class="field-require"></div>
						</td>
						<td class="form_table_left">

							<c:choose>
								<c:when test="${edtState and new}">
								<html:text styleClass="form_input_1x" property="code" />
									<bean:message bundle="fee" key="redStar" />
								</c:when>
								<c:otherwise>
								<html:text styleClass="form_input_1x" property="code" disabled="true" />
									<bean:message bundle="fee" key="redStar" />
								</c:otherwise>
							</c:choose>
						</td>
						
						<td class="form_table_right">
							<div class="field-require">
								<bean:message bundle="cooperrater" key="name" />
								:
							</div>
						</td>
						<td class="form_table_left">
							<c:choose>
								<c:when test="${edtState}">
									<html:text styleClass="form_input_1x" property="name" />
									<bean:message bundle="fee" key="redStar" />
								</c:when>
								<c:otherwise>
									<html:text styleClass="form_input_1x" property="name"
										disabled="true" />
									<bean:message bundle="fee" key="redStar" />
								</c:otherwise>
							</c:choose>
						</td>
					</tr>

					<tr>

						<td class="form_table_right">
							<div class="field-require">
								<bean:message bundle="cooperrater" key="linkman" />
								:
							</div>
						</td>
						<td class="form_table_left">
							<c:choose>
								<c:when test="${edtState}">
									<html:text styleClass="form_input_1x" property="linkman" />
									<bean:message bundle="fee" key="redStar" />
								</c:when>
								<c:otherwise>
									<html:text styleClass="form_input_1x" property="linkman"
										disabled="true" />
									<bean:message bundle="fee" key="redStar" />
								</c:otherwise>
							</c:choose>
						</td>
						<td class="form_table_right">
							<div class="field-require">
								<bean:message bundle="cooperrater" key="telcode" />
								:
							</div>
						</td>
						<td class="form_table_left">
							<c:choose>
								<c:when test="${edtState}">
									<html:text styleClass="form_input_1x" property="telcode" />
									<bean:message bundle="fee" key="redStar" />
								</c:when>
								<c:otherwise>
									<html:text styleClass="form_input_1x" property="telcode"
										disabled="true" />
									<bean:message bundle="fee" key="redStar" />
								</c:otherwise>
							</c:choose>
						</td>
					</tr>
					
					<tr>
						
						<td class="form_table_right">
							<div class="field-require">
								<bean:message bundle="cooperrater" key="masterid" />
								:
							</div>
						</td>
						<td class="form_table_left">
							<c:choose>
								<c:when test="${edtState}">
									<html:text styleClass="form_input_1x" property="masterid" />
									<bean:message bundle="fee" key="redStar" />
								</c:when>
								<c:otherwise>
									<html:text styleClass="form_input_1x" property="masterid"
										disabled="true" />
									<bean:message bundle="fee" key="redStar" />
								</c:otherwise>
							</c:choose>
						</td>
						
						<td class="form_table_right">
							<div class="field-require">
								<bean:message bundle="cooperrater" key="address" />
								:
							</div>
						</td>
						<td class="form_table_left">
							<c:choose>
								<c:when test="${edtState}">
									<html:text styleClass="form_input_1x" property="address" />
									<bean:message bundle="fee" key="redStar" />
								</c:when>
								<c:otherwise>
									<html:text styleClass="form_input_1x" property="address"
										disabled="true" />
									<bean:message bundle="fee" key="redStar" />
								</c:otherwise>
							</c:choose>
						</td>
					</tr>

					<tr>
						<td class="form_table_right">
							<div class="field-require">
								<bean:message bundle="cooperrater" key="memo" />
								:
							</div>
						</td>
						<td class="form_table_left" colspan="3">
							<c:choose>
								<c:when test="${edtState}">
									<html:textarea property="memo" styleClass="form_textarea_on" />
								</c:when>
								<c:otherwise>
									<html:textarea property="memo" styleClass="form_textarea_on"
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
								onclick="doSave('/fee/woff/cooperrater.do?CMD=SAVE')" />
							<input type="button" onmouseover="buttonover(this);"
								onmouseout="buttonout(this);" name="btnReturn"
								onfocus="buttonover(this)" onblur="buttonout(this)"
								value="<bean:message bundle="public" key="button_return"/>"
								class="close"
								onclick="doReturn('/fee/woff/cooperrater.do?CMD=LIST')">
						</td>
					</tr>
				</table>
			</div>
		</html:form>
	</div>
</body>
</html:html>
