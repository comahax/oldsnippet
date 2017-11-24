<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/contenthead.inc"%>
<%
	String ID_1 = "00010701";
	String ID_2 = "00010702";
	String ID_3 = "00010703";
	String ID_4 = "00010704";
%>
<html>
	<head>
		<title><bean:message bundle="rewardconf" key="titleUpdate" />
		</title>
		<script language="JavaScript">
        function ev_checkval() {
        	addfield('name', '<bean:message bundle="batchno" key="name"/>', 'c', false, 128);
        	addfield('remark', '<bean:message bundle="batchno" key="remark"/>', 'c', false, 1024);
            return checkval(window);
        }
    </script>
	</head>
	<body>
		<div class="table_container">
			<html:form action="/cms/reward/batchno.do?CMD=SAVE"
				styleId="formItem" method="post">
				<html:hidden property="cmdState" />
				
				<html:hidden property="_orderby" />
				<html:hidden property="_desc" />
				<html:hidden property="_pageno" />
				<html:hidden property="_pagesize" />
				<c:set var="edtState" scope="request"
					value="${!empty param.CMD and (param.CMD eq 'EDIT' or param.CMD eq 'NEW')}" />
				<c:set var="updateState" scope="request"
					value="${!empty param.CMD and (param.CMD eq 'EDIT')}" />
				<c:set var="form" scope="request"
					value="${requestScope['/cms/reward/batchno/BatchnoForm']}" />

				<!--##################################添加标题内容##################################################-->
				<div class="table_div">
					<table class="top_table">
						<tr>
							<td>
								<bean:message bundle="batchno" key="titleList" />
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
						<tr>
							<td width="20%" align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="batchno" key="batchno" />
									:
								</div>
							</td>
							<td width="80%" align="left" class="form_table_left">
								<c:choose>
									<c:when test="${edtState}">
										<c:if test="${updateState}">
											<html:text styleClass="form_input_1x" property="batchno"
												readonly="true" />
										</c:if>
										<c:if test="${!updateState}">
											<html:text styleClass="form_input_1x" property="batchno"
												readonly="true" />
										</c:if>
									</c:when>
									<c:otherwise>
										<html:text styleClass="form_input_1x" property="batchno"
											disabled="true" />
									</c:otherwise>
								</c:choose>
							</td>
						</tr>
						<tr>
							<td width="20%" align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="batchno" key="batchtype" />
									:
								</div>
							</td>
							<td width="80%" align="left" class="form_table_left">
								<c:choose>
									<c:when test="${edtState}">
										<c:if test="${updateState}">
											<html:text styleClass="form_input_1x" property="batchtype"
												readonly="true" />
										</c:if>
										<c:if test="${!updateState}">
											<html:text styleClass="form_input_1x" property="batchtype"
												readonly="true" />
										</c:if>
									</c:when>
									<c:otherwise>
										<html:text styleClass="form_input_1x" property="batchtype"
											disabled="true" />
									</c:otherwise>
								</c:choose>
							</td>
						</tr>
						<tr>
							<td width="20%" align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="batchno" key="name" />
									:
								</div>
							</td>
							<td width="80%" align="left" class="form_table_left">
								<c:choose>
									<c:when test="${edtState}">
										<c:if test="${updateState}">
											<html:text styleClass="form_input_1x" property="name" />
										</c:if>
										<c:if test="${!updateState}">
											<html:text styleClass="form_input_1x" property="name" />
										</c:if>
									</c:when>
									<c:otherwise>
										<html:text styleClass="form_input_1x" property="name"
											disabled="true" />
									</c:otherwise>
								</c:choose>
							</td>
						</tr>
						<tr>
							<td width="20%" align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="batchno" key="remark" />
									:
								</div>
							</td>
							<td width="80%" align="left" class="form_table_left">
								<c:choose>
									<c:when test="${edtState}">
										<html:text styleClass="form_input_1x" property="remark" />
									</c:when>
									<c:otherwise>
										<html:text styleClass="form_input_1x" property="remark"
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
							<td width="100%" class="form_table_center">
								<c:choose>
									<c:when test="${edtState}">
										<input type="button" onmouseover="buttonover(this);"
											onmouseout="buttonout(this);" name="btnSave"
											onfocus="buttonover(this)" onblur="buttonout(this)"
											value="<bean:message bundle="public" key="button_save"/>"
											class="submit"
											onclick="doSave('/cms/reward/batchno.do?CMD=SAVE')" />
									</c:when>
									<c:otherwise>
										<input type="button" onmouseover="buttonover(this);"
											onmouseout="buttonout(this);" name="btnSave"
											onfocus="buttonover(this)" onblur="buttonout(this)"
											value="<bean:message bundle="public" key="button_save"/>"
											class="submit"
											onclick="doSave('/cms/reward/batchno.do?CMD=SAVE')"
											disabled="true" />
									</c:otherwise>
								</c:choose>
								<c:choose>
									<c:when test="${form.batchtype=='社会渠道酬金'}">
										<input type="button" onmouseover="buttonover(this);"
											onmouseout="buttonout(this);" name="btnReturn"
											onfocus="buttonover(this)" onblur="buttonout(this)"
											value="<bean:message bundle="public" key="button_return"/>"
											class="close"
											onclick="doReturn('/cms/reward/rewardconf.do?CMD=Aglist')">
									</c:when>
									<c:otherwise>
										<input type="button" onmouseover="buttonover(this);"
											onmouseout="buttonout(this);" name="btnReturn"
											onfocus="buttonover(this)" onblur="buttonout(this)"
											value="<bean:message bundle="public" key="button_return"/>"
											class="close"
											onclick="doReturn('/cms/reward/rewardconf.do?CMD=B2mlist')">
									</c:otherwise>
								</c:choose>
							</td>
						</tr>
					</table>
				</div>
			</html:form>
		</div>
	</body>
</html>
