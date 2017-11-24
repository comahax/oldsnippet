<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/contenthead.inc"%>
<html:html>
<head>
	<title><bean:message bundle="mobchargebak" key="title" /></title>
	<script language="JavaScript">
        function ev_checkval() {
            addfield('srequesttime', '<bean:message bundle="mobchargebak" key="requesttime"/>', 'dt', false, 20);
            addfield('eboxdeta', '<bean:message bundle="mobchargebak" key="eboxdeta"/>', 'c', false, 256);
            addfield('status', '<bean:message bundle="mobchargebak" key="status"/>', 'i', false, 3);
            return checkval(window);
        }
    </script>
</head>
<body onload="loadforiframe();">
	<div class="table_container">
		<html:form action="/fee/woff/mobchargebak.do?CMD=SAVE" styleId="formItem" method="post">
			<html:hidden property="cmdState" />
			<html:hidden property="_orderby" />
			<html:hidden property="_desc" />
			<html:hidden property="_pageno" />
			<html:hidden property="_pagesize" />
			<html:hidden property="_ne_eboxid" />
			<html:hidden property="_ne_recid" />
			<html:hidden property="recid" />
			<input type="hidden" name="_rowcount" />
			<c:set var="edtState" scope="request" value="${!empty param.CMD and (param.CMD eq 'EDIT' or param.CMD eq 'NEW')}" />

			<div class="table_div">
				<table class="top_table">
					<tr>
						<td>
							<bean:message bundle="mobchargebak" key="title" />
						</td>
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
						<td align=left colspan=6>
							<bean:message bundle="fee" key="redStarExplain" />
						</td>
					</tr>					
					<tr>
						<td class="form_table_right">
							<div class="field-require">
								<bean:message bundle="mobchargebak" key="requesttime" />
								:
							</div>
						</td>
						<td class="form_table_left">
							<c:choose>
								<c:when test="${edtState}">
									<html:text styleClass="form_input_1x" property="srequesttime" maxlength="24" onclick="this.value=selectDatetime()"/>
								</c:when>
								<c:otherwise>
									<html:text styleClass="form_input_1x" property="srequesttime" disabled="true" />
								</c:otherwise>
							</c:choose>
							<font color=red>&nbsp;*</font>
						</td>
					</tr>
					<tr>
						<td class="form_table_right">
							<div class="field-require">
								<bean:message bundle="mobchargebak" key="eboxdeta" />
								:
							</div>
						</td>
						<td class="form_table_left">
							<c:choose>
								<c:when test="${edtState}">
									<html:textarea  property="eboxdeta"  />
								</c:when>
								<c:otherwise>
									<html:textarea  property="eboxdeta" disabled="true" />
								</c:otherwise>
							</c:choose>
							<font color=red>&nbsp;*</font>
						</td>
					</tr>
					<tr>
						<td class="form_table_right">
							<div class="field-require">
								<bean:message bundle="mobchargebak" key="status" />
								:
							</div>
						</td>
						<td class="form_table_left">
							<c:choose>
								<c:when test="${edtState}">
									<html:select property="status">
										<html:option value=""></html:option>
										<s:Options definition="#CHRSTATUS" nameOnly="false" />
									</html:select>
								</c:when>
								<c:otherwise>
									<html:select property="status" disabled="true">
										<html:option value=""></html:option>
										<s:Options definition="#CHRSTATUS" nameOnly="false" />
									</html:select>
								</c:otherwise>
							</c:choose>
							<font color=red>&nbsp;*</font>
						</td>
					</tr>
				</table>
			</div>

			<div class="table_div">
				<table class="table_button_list">
					<tr>
						<td width="100%" class="form_table_center">
							<input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);" name="btnSave" onfocus="buttonover(this)" onblur="buttonout(this)" value="<bean:message bundle="public" key="button_save"/>" class="submit"
								onclick="doSave('/fee/woff/mobchargebak.do?CMD=SAVE')" />
							<input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);" name="btnPrint" onfocus="buttonover(this)" onblur="buttonout(this)" value="<bean:message bundle="public" key="button_print"/>" class="print" onclick="doPrint()">

							<input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);" name="btnReturn" onfocus="buttonover(this)" onblur="buttonout(this)" value="<bean:message bundle="public" key="button_return"/>" class="close"
								onclick="doReturn('/fee/woff/mobchargebak.do?CMD=LIST')">
						</td>
					</tr>
				</table>
			</div>
		</html:form>
	</div>
</body>
</html:html>
