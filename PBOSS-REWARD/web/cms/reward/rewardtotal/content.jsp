<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/contenthead.inc"%>
<%@ page import="com.sunrise.boss.ui.commons.WebConstant"%>
<%@ page import="com.sunrise.boss.ui.commons.User"%>
<%
	//User user = (User) request.getSession().getAttribute(
	//WebConstant.SESSION_ATTRIBUTE_USER);
	//String wayid = user.getWayid();
	//request.setAttribute("wayid",wayid);

	//String ID_SAVE= "CH_PW_REQFACI_EDIT";
%>
<html>
	<head>
		<title><bean:message bundle="rewardtotal" key="totaltitle" />
		</title>
		<script type="text/javascript"
			src="<%=contextPath%>/js/bus/waycommon.js"></script>
		<script type="text/javascript" src="<%=contextPath%>/js/aa.js"></script>
		<script language="JavaScript">
        function ev_checkval() {
            //addfield('reqfaciid', '<bean:message bundle="reqfaci" key="reqfaciid"/>', 'i', true, '14');
            //addfield('wayid', '<bean:message bundle="reqfaci" key="wayid"/>', 'c', false, '18');
            //addfield('audittime', '<bean:message bundle="reqfaci" key="audittime"/>', 'dt', true, '25');
           // addfield('requesttime', '<bean:message bundle="reqfaci" key="requesttime"/>', 'dt', true, '25');
           // addfield('recid', '<bean:message bundle="reqfaci" key="recid"/>', 'i', false, '14');
           // addfield('reqcode', '<bean:message bundle="reqfaci" key="reqcode"/>', 'c', true, '18');
            //addfield('auditcode', '<bean:message bundle="reqfaci" key="auditcode"/>', 'c', true, '18');
            //addfield('drawtime', '<bean:message bundle="reqfaci" key="drawtime"/>', 'dt', true, '25');
            //addfield('drawnumber', '<bean:message bundle="reqfaci" key="drawnumber"/>', 'd', false, '8','2');
            //addfield('drawcode', '<bean:message bundle="reqfaci" key="drawcode"/>', 'c', true, '18');
            //addfield('auditidea', '<bean:message bundle="reqfaci" key="auditidea"/>', 'c', true, '512');
            //addfield('auditstate', '<bean:message bundle="reqfaci" key="auditstate"/>', 'i', false, '1');

            return checkval(window);
        }
            function doReturn(cmdReturn) {
            	enable();
			    formItem.action = contextPath + cmdReturn;
			    formItem.submit();
			}
    </script>
		<style>
    	.gray{color="gray"}
    </style>
	</head>
	<body>
		<div class="table_container">
			<html:form action="/cms/reward/rewardtotal.do?CMD=VIEW"
				styleId="formItem" method="post">
				<html:hidden property="cmdState" />

				<html:hidden property="_orderby" />
				<html:hidden property="_desc" />
				<html:hidden property="_pageno" />
				<html:hidden property="_pagesize" />
				<c:set var="edtState" scope="request"
					value="${!empty param.CMD and (param.CMD eq 'VIEW')}" />
				<!--##################################添加标题内容##################################################-->
				<div class="table_div">
					<table class="top_table">
						<tr>
							<td>
								<bean:message bundle="rewardtotal" key="totaltitle" />
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
									<bean:message bundle="rewardtotal" key="totalid" />
									:
								</div>
							</td>
							<td width="30%" align="left" class="form_table_left">
								<html:text styleClass="form_input_1x" property="totalid"
									disabled="true" />
							</td>
							<td width="20%" align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="rewardtotal" key="wayid" />
									:
								</div>
							</td>
							<td width="30%" align="left" class="form_table_left">
								<html:text styleClass="form_input_1x" property="wayid"
									disabled="true" />
							</td>
						</tr>
						<tr>
							<td width="20%" align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="rewardtotal" key="isbudget" />
									:
								</div>
							</td>
							<td width="30%" align="left" class="form_table_left">
								<html:text styleClass="form_input_1x" property="isbudget"
									disabled="true" />
							</td>
							<td width="20%" align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="rewardtotal" key="slv" />
									:
								</div>
							</td>
							<td width="30%" align="left" class="form_table_left">
								<html:text styleClass="form_input_1x" property="slv"
									disabled="true" />
							</td>
						</tr>
						<tr>
							<td width="20%" align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="rewardtotal" key="rewardtype" />
									:
								</div>
							</td>
							<td width="30%" align="left" class="form_table_left">
								<html:text styleClass="form_input_1x" property="rewardtype"
									disabled="true" />
							</td>
							<td width="20%" align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="rewardtotal" key="chagmonth" />
									:
								</div>
							</td>
							<td width="30%" align="left" class="form_table_left">
								<html:text styleClass="form_input_1x" property="chagmonth"
									disabled="true" />
							</td>
						</tr>
						<tr>
							<td width="20%" align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="rewardtotal" key="paymonth" />
									:
								</div>
							</td>
							<td width="30%" align="left" class="form_table_left">
								<html:text styleClass="form_input_1x" property="paymonth"
									disabled="true" />
							</td>
							<td width="20%" align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="rewardtotal" key="paymoney" />
									:
								</div>
							</td>
							<td width="30%" align="left" class="form_table_left">
								<html:text styleClass="form_input_1x" property="paymoney"
									disabled="true" />
							</td>
						</tr>
						<tr>
							<td width="20%" align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="rewardtotal" key="rewardmonth1" />
									:
								</div>
							</td>
							<td width="30%" align="left" class="form_table_left">
								<html:text styleClass="form_input_1x" property="rewardmonth1"
									disabled="true" />
							</td>
							<td width="20%" align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="rewardtotal" key="rewardmoney1" />
									:
								</div>
							</td>
							<td width="30%" align="left" class="form_table_left">
								<html:text styleClass="form_input_1x" property="rewardmoney1"
									disabled="true" />
							</td>
						</tr>
						<tr>
							<td width="20%" align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="rewardtotal" key="rewardmonth2" />
									:
								</div>
							</td>
							<td width="30%" align="left" class="form_table_left">
								<html:text styleClass="form_input_1x" property="rewardmonth2"
									disabled="true" />
							</td>
							<td width="20%" align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="rewardtotal" key="rewardmoney2" />
									:
								</div>
							</td>
							<td width="30%" align="left" class="form_table_left">
								<html:text styleClass="form_input_1x" property="rewardmoney2"
									disabled="true" />
							</td>
						</tr>
						<tr>
							<td width="20%" align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="rewardtotal" key="rewardmonth3" />
									:
								</div>
							</td>
							<td width="30%" align="left" class="form_table_left">
								<html:text styleClass="form_input_1x" property="rewardmonth3"
									disabled="true" />
							</td>
							<td width="20%" align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="rewardtotal" key="rewardmoney3" />
									:
								</div>
							</td>
							<td width="30%" align="left" class="form_table_left">
								<html:text styleClass="form_input_1x" property="rewardmoney3"
									disabled="true" />
							</td>
						</tr>
						<tr>
							<td width="20%" align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="rewardtotal" key="paystat" />
									:
								</div>
							</td>
							<td width="30%" align="left" class="form_table_left">
								<html:text styleClass="form_input_1x" property="paystat"
									disabled="true" />
							</td>
							<td width="20%" align="right" class="form_table_right">
								<div class="field-require">
									
								</div>
							</td>
							<td width="30%" align="left" class="form_table_left">
								
							</td>
						</tr>
					</table>
				</div>

				<div class="table_div">
					<table class="table_button_list">
						<tr>
							<td>
								<input type="button" onmouseover="buttonover(this);"
									onmouseout="buttonout(this);" name="btnReturn"
									onfocus="buttonover(this)" onblur="buttonout(this)"
									value="<bean:message bundle="public" key="button_return"/>"
									class="close"
									onclick="doReturn('/cms/reward/rewardtotal.do?CMD=LIST')">
							</td>
						</tr>
					</table>
				</div>
			</html:form>
		</div>
	</body>
</html>
