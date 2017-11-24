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
            addfield('operid', '<bean:message bundle="airoper" key="operid"/>', 'c', false, 20);
            addfield('region', '<bean:message bundle="airoper" key="region"/>', 'i', false, 5);
            addfield('opername', '<bean:message bundle="airoper" key="opername"/>', 'c', false, 64);
            addfield('isrestrict', '<bean:message bundle="airoper" key="isrestrict"/>', 'i', false, 3);
            addfield('contactphon', '<bean:message bundle="airoper" key="contactphon"/>', 'c', false, 20);
            return checkval(window);
        }
    </script>
</head>
<body onload="loadforiframe();">
	<div class="table_container">
		<html:form action="/fee/woff/airoper.do?CMD=SAVE"
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
							<bean:message bundle="airoper" key="title1" />
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
							<bean:message bundle="airoper" key="operid" />
							:
							<div class="field-require"></div>
						</td>
						<td class="form_table_left">

							<c:choose>
								<c:when test="${edtState and new}">
								<html:text styleClass="form_input_1x" property="operid" />
									<bean:message bundle="fee" key="redStar" />
								</c:when>
								<c:otherwise>
								<html:text styleClass="form_input_1x" property="operid" disabled="true" />
									<bean:message bundle="fee" key="redStar" />
								</c:otherwise>
							</c:choose>
						</td>
						
						<td class="form_table_right">
							<div class="field-require">
								<bean:message bundle="airoper" key="region" />
								:
							</div>
						</td>
						<td class="form_table_left">
							<c:choose>
								<c:when test="${edtState}">
									<s:zoom definition="#CITYIDNUM2NMAME" property="region" styleClass="form_input_1x" nameOnly="false"/>
									<bean:message bundle="fee" key="redStar" />
								</c:when>
								<c:otherwise>
									<s:zoom definition="#CITYIDNUM2NMAME" property="region" styleClass="form_input_1x" nameOnly="false" disabled="true"/>
									<bean:message bundle="fee" key="redStar" />
								</c:otherwise>
							</c:choose>
						</td>
					</tr>

					<tr>

						<td class="form_table_right">
							<div class="field-require">
								<bean:message bundle="airoper" key="opername" />
								:
							</div>
						</td>
						<td class="form_table_left">
							<c:choose>
								<c:when test="${edtState}">
									<html:text styleClass="form_input_1x" property="opername" />
									<bean:message bundle="fee" key="redStar" />
								</c:when>
								<c:otherwise>
									<html:text styleClass="form_input_1x" property="opername"
										disabled="true" />
									<bean:message bundle="fee" key="redStar" />
								</c:otherwise>
							</c:choose>
						</td>
						<td class="form_table_right">
							<div class="field-require">
								<bean:message bundle="airoper" key="isrestrict" />
								:
							</div>
						</td>
						<td class="form_table_left">
							<c:choose>
								<c:when test="${edtState}">
								<html:select property="isrestrict">
								<option></option>
								<s:Options definition="#ISRESTRICT" />
							</html:select>
							<bean:message bundle="fee" key="redStar" />
								</c:when>
								<c:otherwise>
								<html:select property="isrestrict" disabled="true">
								<option></option>
								<s:Options definition="#ISRESTRICT" />
							</html:select>
									<bean:message bundle="fee" key="redStar" />
								</c:otherwise>
							</c:choose>
						</td>
					</tr>
					
					<tr>

						<td class="form_table_right">
							<div class="field-require">
								<bean:message bundle="airoper" key="contactphon" />
								:
							</div>
						</td>
						<td class="form_table_left">
							<c:choose>
								<c:when test="${edtState}">
									<html:text styleClass="form_input_1x" property="contactphon" />
									<bean:message bundle="fee" key="redStar" />
								</c:when>
								<c:otherwise>
									<html:text styleClass="form_input_1x" property="contactphon"
										disabled="true" />
									<bean:message bundle="fee" key="redStar" />
								</c:otherwise>
							</c:choose>
						</td>
						<td class="form_table_right">
						</td>
						<td class="form_table_left">
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
								onclick="doSave('/fee/woff/airoper.do?CMD=SAVE')" />
							<input type="button" onmouseover="buttonover(this);"
								onmouseout="buttonout(this);" name="btnReturn"
								onfocus="buttonover(this)" onblur="buttonout(this)"
								value="<bean:message bundle="public" key="button_return"/>"
								class="close"
								onclick="doReturn('/fee/woff/airoper.do?CMD=LIST')">
						</td>
					</tr>
				</table>
			</div>
		</html:form>
	</div>
</body>
</html:html>
