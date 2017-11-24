<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/contenthead.inc"%>
<%@ page import="com.sunrise.boss.ui.commons.WebConstant"%>
<html>
	<head>
		<title><bean:message bundle="ruleonbusi" key="titleUpdate" />
		</title>
		<script type="text/javascript" src="<%=contextPath%>/js/bus/waycommon.js"></script>
		<script language="JavaScript">
        function ev_checkval() {
            addfield('ruleid', '<bean:message bundle="ruleonbusi" key="ruleid"/>', 'c', false, '18');
            addfield('opnid', '<bean:message bundle="ruleonbusi" key="opnid"/>', 'c', false, '18');
            return checkval(window);
        }
        
        function doReturn() {
        	var url = contextPath + '/cms/reward/ruleonbusi.do?CMD=SHOW';
        	formItem.action = url;
        	formItem._se_ruleid.value = formItem.ruleid.value;
        	formItem.submit();
        }
    </script>
	</head>
	<body>
		<div class="table_container">
			<html:form action="/cms/reward/ruleonbusi.do?CMD=SAVE" styleId="formItem" method="post">
				<html:hidden property="cmdState" />
				<html:hidden property="_orderby" />
				<html:hidden property="_desc" />
				<html:hidden property="_pageno" />
				<html:hidden property="_pagesize" />
				<html:hidden property="_se_ruleid" />
				<c:set var="edtState" scope="request"
					value="${!empty param.CMD and (param.CMD eq 'EDIT' or param.CMD eq 'NEW' or requestScope['cmdState'] eq 'EDIT')}" />
				<c:set var="updateState" scope="request" value="${!empty param.CMD and (param.CMD eq 'EDIT')}" />

				<!--##################################添加标题内容##################################################-->
				<div class="table_div">
					<table class="top_table">
						<tr>
							<td>
								<bean:message bundle="ruleonbusi" key="titleList" />
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
							<td colspan="2"><bean:message bundle="ruleonbusi" key="remind" /></td>
						</tr>
						<tr>
							<td width="20%" align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="ruleonbusi" key="ruleid" />
									:
								</div>
							</td>
							<td width="75%" align="left" class="form_table_left">
								<c:choose>
									<c:when test="${edtState}">
										<c:if test="${updateState}">
											<html:text styleClass="form_input_1x" property="ruleid" maxlength="18" readonly="true" />
											<font color=red>&nbsp;*</font>
										</c:if>
										<c:if test="${!updateState}">
											<html:text styleClass="form_input_1x" property="ruleid" maxlength="18" readonly="true" />
											<font color=red>&nbsp;*</font>
										</c:if>
									</c:when>
									<c:otherwise>
										<html:text styleClass="form_input_1x" property="ruleid" disabled="true" />
									</c:otherwise>
								</c:choose>
							</td>
						</tr>
						<tr>
							<td width="20%" align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="ruleonbusi" key="opnid" />
									:
								</div>
							</td>
							<td width="75%" align="left" class="form_table_left">
								<c:choose>
									<c:when test="${edtState}">
										<c:if test="${updateState}">
											<html:text styleClass="form_input_1x" property="opnid" maxlength="18" readonly="true" />
											<font color=red>&nbsp;*</font>
											<input type="button" value="..." class="clickbutton" onclick="showOpnTree2(this, 'opnid' , 'busi' )">
										</c:if>
										<c:if test="${!updateState}">
											<html:text styleClass="form_input_1x" property="opnid" maxlength="18" />
											<font color=red>&nbsp;*</font>
											<input type="button" value="..." class="clickbutton" onclick="showOpnTree2(this, 'opnid' , 'busi' )">
										</c:if>
									</c:when>
									<c:otherwise>
										<html:text styleClass="form_input_1x" property="opnid" disabled="true" />
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
								<input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);" name="btnSave"
									onfocus="buttonover(this)" onblur="buttonout(this)" value="<bean:message bundle="public" key="button_save"/>"
									class="submit" onclick="doSave('/cms/reward/ruleonbusi.do?CMD=SAVE')" />
								<input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);" name="btnReturn"
									onfocus="buttonover(this)" onblur="buttonout(this)" value="<bean:message bundle="public" key="button_return"/>"
									class="close" onclick="doReturn()">
							</td>
						</tr>
					</table>
				</div>
			</html:form>
		</div>
	</body>
</html>
