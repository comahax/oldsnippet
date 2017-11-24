<%@ page language="java" contentType="text/html;charset=GBK"%>
<jsp:include page="/inc/acl.jsp">
	<jsp:param name="PID" value="4D1A1AAA" />
</jsp:include>
<%@ include file="/inc/contenthead.inc"%>
<html:html>
<head>
	<title><bean:message bundle="rewait" key="title1" />
	</title>
	<script language="JavaScript">
        function ev_checkval() {  
            addfield('reqstream', '<bean:message bundle="rewait" key="reqstream"/>', 'c', false, 50);
            addfield('areacode', '<bean:message bundle="rewait" key="areacode"/>', 'c', false, 10);
            addfield('masterid', '<bean:message bundle="rewait" key="masterid"/>', 'c', false, 10);
            addfield('amt', '<bean:message bundle="rewait" key="amt"/>', 'l', false, 15);
            addfield('belongto', '<bean:message bundle="rewait" key="belongto"/>', 'c', false, 10);
            addfield('dealstate', '<bean:message bundle="rewait" key="dealstate"/>', 'i', true, 20);
            addfield('memo', '<bean:message bundle="rewait" key="memo"/>', 'c', true, 20);
            return checkval(window);
        }
    </script>
</head>
<body onload="loadforiframe();">
	<div class="table_container">
		<html:form action="/fee/woff/rewait.do?CMD=SAVE"
			styleId="formItem" method="post">

			<html:hidden property="cmdState" />

			<html:hidden property="_orderby" />
			<html:hidden property="_desc" />
			<html:hidden property="_pageno" />
			<html:hidden property="_pagesize" />
			<html:hidden property="reqdate" />

			<input type="hidden" name="_rowcount" />



			<c:set var="edtState" scope="request"
				value="${!empty param.CMD and param.CMD eq 'EDIT'}" />
			<c:set var="isreq" scope="request"
				value="${!empty param.CMD and param.CMD eq 'REQ'}" />
			<c:set var="ischeck" scope="request"
				value="${!empty check and check eq 'SANCTION'}" />	

			<div class="table_div">
				<table class="top_table">
					<tr>
						<td>
							<bean:message bundle="rewait" key="title1" />
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
							<bean:message bundle="rewait" key="reqstream" />
							:
							<div class="field-require"></div>
						</td>
						<td class="form_table_left">

							<c:choose>
								<c:when test="${isreq}">
								<html:text styleClass="form_input_1x" property="reqstream" />
									<bean:message bundle="fee" key="redStar" />
								</c:when>
								<c:otherwise>
								<html:text styleClass="form_input_1x" property="reqstream" disabled="true" />
									<bean:message bundle="fee" key="redStar" />
								</c:otherwise>
							</c:choose>
						</td>
						
						<td class="form_table_right">
							<div class="field-require">
								<bean:message bundle="rewait" key="areacode" />
								:
							</div>
						</td>
						<td class="form_table_left">
							<c:choose>
								<c:when test="${edtState or isreq}">
									<s:zoom definition="#CITYIDNUM2NMAME" property="areacode" styleClass="form_input_1x" nameOnly="false"/>
									<bean:message bundle="fee" key="redStar" />
								</c:when>
								<c:when test="${ischeck}">
									<s:zoom definition="#CITYIDNUM2NMAME" property="areacode" styleClass="form_input_1x" nameOnly="false" disabled="true"/>
								</c:when>
								<c:otherwise>
									<s:zoom definition="#CITYIDNUM2NMAME" property="areacode" styleClass="form_input_1x" nameOnly="false" disabled="true"/>
									<bean:message bundle="fee" key="redStar" />
								</c:otherwise>
							</c:choose>
						</td>
					</tr>

					<tr>

						<td class="form_table_right">
							<div class="field-require">
								<bean:message bundle="rewait" key="masterid" />
								:
							</div>
						</td>
						<td class="form_table_left">
							<c:choose>
								<c:when test="${edtState or isreq}">
									<s:zoom definition="#MASTERID" property="masterid" styleClass="form_input_1x" nameOnly="false"/>
									<bean:message bundle="fee" key="redStar" />
								</c:when>
								<c:when test="${ischeck}">
									<s:zoom definition="#MASTERID" property="masterid" styleClass="form_input_1x" nameOnly="false" disabled="true"/>
								</c:when>
								<c:otherwise>
									<s:zoom definition="#MASTERID" property="masterid" styleClass="form_input_1x"  nameOnly="false" disabled="true"/>	
									<bean:message bundle="fee" key="redStar" />
								</c:otherwise>
							</c:choose>
						</td>
						<td class="form_table_right">
						<div class="field-require">
								<bean:message bundle="rewait" key="amt" />
								:
							</div>
						</td>
						<td class="form_table_left">
						<c:choose>
								<c:when test="${edtState or isreq}">
									<html:text styleClass="form_input_1x" property="amt" />
									<bean:message bundle="fee" key="redStar" />
								</c:when>
								<c:when test="${ischeck}">
									<html:text styleClass="form_input_1x" property="amt"
										disabled="true" />
								</c:when>
								<c:otherwise>
									<html:text styleClass="form_input_1x" property="amt"
										disabled="true" />
									<bean:message bundle="fee" key="redStar" />
								</c:otherwise>
							</c:choose>
						</td>
					</tr>
					
					
					<tr>

						<td class="form_table_right">
							<div class="field-require">
								<bean:message bundle="rewait" key="belongto" />
								:
							</div>
						</td>
						<td class="form_table_left">
							<c:choose>
								<c:when test="${edtState or isreq}">
									<html:text styleClass="form_input_1x" property="belongto" />
									<bean:message bundle="fee" key="redStar" />
								</c:when>
								<c:when test="${ischeck}">
									<html:text styleClass="form_input_1x" property="belongto"
										disabled="true" />
								</c:when>
								<c:otherwise>
									<html:text styleClass="form_input_1x" property="belongto"
										disabled="true" />
									<bean:message bundle="fee" key="redStar" />
								</c:otherwise>
							</c:choose>
						</td>
						<td class="form_table_right">
							<div class="field-require">
								<bean:message bundle="rewait" key="dealstate" />
								:
							</div>
						</td>
						<td class="form_table_left">
						<c:choose>
								<c:when test="${ischeck}">
								<html:select property="dealstate">
								<option></option>
								<s:Options definition="#DEALSTATE2" />
							</html:select>
							<bean:message bundle="fee" key="redStar" />
								</c:when>
								<c:otherwise>
								<html:select property="dealstate" disabled="true">
								<option></option>
								<s:Options definition="#DEALSTATE" />
							</html:select>
									<bean:message bundle="fee" key="redStar" />
								</c:otherwise>
							</c:choose>
						</td>
					</tr>
					
					
					
					<tr>
						<td class="form_table_right">
							<div class="field-require">
								<bean:message bundle="rewait" key="memo" />
								:
							</div>
						</td>
						<td class="form_table_left" colspan="3">
							<c:choose>
								<c:when test="${edtState or isreq}">
									<html:textarea property="memo" styleClass="form_textarea_on" />
								</c:when>
								<c:when test="${ischeck}">
									<html:textarea property="memo" styleClass="form_textarea_on" disabled="true" />
								</c:when>
								<c:otherwise>
									<html:textarea property="memo" styleClass="form_textarea_on" disabled="true" />
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
								onclick="doSave('/fee/woff/rewait.do?CMD=SAVE')" />
							<input type="button" onmouseover="buttonover(this);"
								onmouseout="buttonout(this);" name="btnReturn"
								onfocus="buttonover(this)" onblur="buttonout(this)"
								value="<bean:message bundle="public" key="button_return"/>"
								class="close"
								onclick="doReturn('/fee/woff/rewait.do?CMD=LIST')">
						</td>
					</tr>
				</table>
			</div>
		</html:form>
	</div>
</body>
</html:html>
