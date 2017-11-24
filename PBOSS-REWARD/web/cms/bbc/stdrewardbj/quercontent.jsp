<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/contenthead.inc"%>
<%
String ID_1 = "CH_B2M_REWARD||CH_B2M_REWARD_PROVINCIAL"; //省级酬金管理令牌
String ID_2 = "CH_B2M_REWARD||CH_B2M_REWARD_CIVIC"; //市级酬金管理令牌
%>
<html>
	<head>
		<title><bean:message bundle="stdrewardbj" key="titleCard" />
		</title>
<script language="JavaScript">
function reloadforiframe() {
	if (parent.document.all("loadframe") != null) {
		parent.document.all("loadframe").style.posHeight = document.body.scrollHeight+120;
	}
	if (parent.document.all("IFRM_MAIN") != null) {
		parent.document.all("IFRM_MAIN").style.posHeight = document.body.scrollHeight+120;
	}
}
function ev_checkval() {
	if (formItem.fixedflag.value != 'true' && formItem.integralflag.value != 'true' && formItem.allowanceflag.value != 'true') {
		alert("业务对应酬金为空，要求至少选择一种酬金，请在对应选框中打勾");
		return;
	}
	if (formItem.fixedflag.value == 'true') {
		addfield('rewardname_fixed', '<bean:message bundle="stdrewardbj" key="rewardname"/>', 'c', false, '40');
		addfield('startdate_fixed', '<bean:message bundle="stdrewardbj" key="startdate"/>', 't', false, '10');
		addfield('stopdate_fixed', '<bean:message bundle="stdrewardbj" key="stopdate"/>', 't', false, '10');
		addfield('ruleid_fixed', '<bean:message bundle="stdrewardbj" key="ruleid"/>', 'c', false, '18');
		addfield('rewardstd_fixed', '<bean:message bundle="stdrewardbj" key="rewardstd"/>', 'd', false, '14','4');
	}
	if (formItem.integralflag.value == 'true') {
		addfield('rewardname_integral', '<bean:message bundle="stdrewardbj" key="rewardname"/>', 'c', false, '40');
		addfield('startdate_integral', '<bean:message bundle="stdrewardbj" key="startdate"/>', 't', false, '10');
		addfield('stopdate_integral', '<bean:message bundle="stdrewardbj" key="stopdate"/>', 't', false, '10');
		addfield('ruleid_integral', '<bean:message bundle="stdrewardbj" key="ruleid"/>', 'c', false, '18');
		addfield('rewardstd_integral', '<bean:message bundle="stdrewardbj" key="rewardstd"/>', 'd', false, '14','4');
	}
	if (formItem.allowanceflag.value == 'true') {
		addfield('rewardname_allowance', '<bean:message bundle="stdrewardbj" key="rewardname"/>', 'c', false, '40');
		addfield('startdate_allowance', '<bean:message bundle="stdrewardbj" key="startdate"/>', 't', false, '10');
		addfield('stopdate_allowance', '<bean:message bundle="stdrewardbj" key="stopdate"/>', 't', false, '10');
		addfield('ruleid_allowance', '<bean:message bundle="stdrewardbj" key="ruleid"/>', 'c', false, '18');
		addfield('rewardstd_allowance', '<bean:message bundle="stdrewardbj" key="rewardstd"/>', 'd', false, '14','4');
	}
	return checkval(window);
}

function doSaveCard() {
	if (ev_checkval()) {
		var url = contextPath + '/cms/reward/stdrewardbj.do?CMD=SAVECARD';
		formItem.action = url;
		formItem.submit();
	}
}

function changeFixed(obj) {
	reloadforiframe();
	if (obj.checked == true) {
		formItem.fixedflag.value = true;
		document.getElementById("fixedreward").style.display=""; //显示
	} else {
		formItem.fixedflag.value = false;
		document.getElementById("fixedreward").style.display="none"; //隐藏
	}
}

function changeIntegral(obj) {
	reloadforiframe();
	if (obj.checked == true) {
		formItem.integralflag.value = true;
		document.getElementById("integralreward").style.display=""; //显示
	} else {
		formItem.integralflag.value = false;
		document.getElementById("integralreward").style.display="none"; //隐藏
	}
}

function changeAllowance(obj) {
	reloadforiframe();
	if (obj.checked == true) {
		formItem.allowanceflag.value = true;
		document.getElementById("allowancereward").style.display=""; //显示
	} else {
		formItem.allowanceflag.value = false;
		document.getElementById("allowancereward").style.display="none"; //隐藏
	}
}

function doReturn(url) {
	window.parent.document.location = contextPath + url;
}

function doShowRule(id) {
	var urlForPrint = contextPath + '/cms/reward/rule2.do?CMD=SELECTRULE&PK=' + formItem.opnid.value;
	var returnValue = window.showModalDialog(urlForPrint, "", "dialogWidth=550px;dialogHeight=450px;status=no;resizable:yes;");
	returnValue = returnValue==null?"":returnValue;
	if (returnValue != "") {
		document.all(id).value = returnValue;
	}
}
</script>
	</head>
	<body onload="loadforiframe();">
		<div class="table_container">
			<html:form action="/cms/reward/stdrewardbj.do?CMD=SAVE" styleId="formItem" method="post">
				<html:hidden property="cmdState" />
				<html:hidden property="_orderby" />
				<html:hidden property="_desc" />
				<html:hidden property="_pageno" />
				<html:hidden property="_pagesize" />
				<html:hidden property="opnid" />
				<html:hidden property="opnname" />
				<html:hidden property="busibelong" />
				<html:hidden property="opnstate" />
				<html:hidden property="rewardid_fixed" />
				<html:hidden property="rewardid_integral" />
				<html:hidden property="rewardid_allowance" />
				<html:hidden property="fixedflag" />
				<html:hidden property="integralflag" />
				<html:hidden property="allowanceflag" />
				<html:hidden property="rewardtype_fixed" />
				<html:hidden property="rewardtype_integral" />
				<html:hidden property="rewardtype_allowance" />
				<html:hidden property="rewardname_encourage_temp" />
				<html:hidden property="ossrc" />
				
				<c:set var="edtState" scope="request" value="${!empty param.CMD and (param.CMD eq 'EDIT' or param.CMD eq 'NEW')}" />
				<c:set var="updateState" scope="request" value="${!empty param.CMD and (param.CMD eq 'EDIT')}" />

				<!--##################################添加标题内容##################################################-->
				<div class="table_div">
					<table class="top_table">
						<tr>
							<td>
								<bean:message bundle="stdrewardbj" key="titleCard" />
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

				<!-- businessinfo -->
				<div class="table_div" id="businessinfo">
					<table class="form_table">
						<tr>
							<td width="100%" colspan=4 class="form_table_left">
								<div class="field-require">
									<font color=blue><bean:message bundle="stdrewardbj" key="businessinfo" /></font>
								</div>
							</td>
						</tr>
						<tr>
							<td width="25%" align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="stdrewardbj" key="opnid" />
									:
								</div>
							</td>
							<td width="25%" align="left" class="form_table_left">
								<c:out value="${requestScope['/cms/reward/stdrewardbj/StdrewardbjForm'].opnid}" />
							</td>
							<td width="25%" align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="stdrewardbj" key="opnname" />
									:
								</div>
							</td>
							<td width="25%" align="left" class="form_table_left">
								<c:out value="${requestScope['/cms/reward/stdrewardbj/StdrewardbjForm'].opnname}" />
							</td>
						</tr>
						<tr>
							<td width="25%" align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="stdrewardbj" key="busibelong" />
									:
								</div>
							</td>
							<td width="25%" align="left" class="form_table_left">
								<s:Code2Name code="${requestScope['/cms/reward/stdrewardbj/StdrewardbjForm'].busibelong}" definition="$CH_CBBUSIBELONG" />
							</td>
							<td width="25%" align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="stdrewardbj" key="state" />
									:
								</div>
							</td>
							<td width="25%" align="left" class="form_table_left">
								<s:Code2Name code="${requestScope['/cms/reward/stdrewardbj/StdrewardbjForm'].opnstate}" definition="$CH_VALIDFLAG"/>
							</td>
						</tr>
						<tr>
							<td width="25%" align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="stdrewardbj" key="busireward" />
									:
								</div>
							</td>
							<td width="75%" colspan=3 class="form_table_left">
								<input type="checkbox" id="fixedbox" value="" onclick="changeFixed(this);" class="table_checkbox">
								<bean:message bundle="stdrewardbj" key="fixedreward" />
								<input type="checkbox" id="integralbox" value="" onclick="changeIntegral(this);" class="table_checkbox">
								<bean:message bundle="stdrewardbj" key="integralreward" />
								<input type="checkbox" id="allowancebox" value="" onclick="changeAllowance(this);" class="table_checkbox">
								<bean:message bundle="stdrewardbj" key="allowance" />
							</td>
						</tr>
					</table>
				</div>

				<!-- fixedreward -->
				<div class="table_div" id="fixedreward">
					<table class="form_table">
						<tr>
							<td width="100%" colspan=4 class="form_table_left">
								<div class="field-require">
									<font color=blue><bean:message bundle="stdrewardbj" key="fixedreward" /></font>
									<bean:message bundle="stdrewardbj" key="remind" />
								</div>
							</td>
						</tr>
						<tr>
							<td width="20%" align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="stdrewardbj" key="rewardname" />
									:
								</div>
							</td>
							<td width="30%" class="form_table_left">
								<html:text styleClass="form_input_1x" property="rewardname_fixed" maxlength="40" />
								<font color=red>*</font>
							</td>
							<td width="20%" align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="stdrewardbj" key="rewardtype" />
									:
								</div>
							</td>
							<td width="30%" class="form_table_left">
								<s:Code2Name code="${requestScope['/cms/reward/stdrewardbj/StdrewardbjForm'].rewardtype_fixed}" definition="$CH_REWARDTYPE"/>
								<font color=red>*</font>
							</td>
						</tr>
						<tr>
							<td width="20%" align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="stdrewardbj" key="startdate" />
									:
								</div>
							</td>
							<td width="30%" class="form_table_left">
								<html:text styleClass="form_input_1x" property="startdate_fixed" readonly="true"
									onclick="this.value=selectDate();" />
								<font color=red>*</font>
							</td>
							<td width="20%" align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="stdrewardbj" key="stopdate" />
									:
								</div>
							</td>
							<td width="30%" class="form_table_left">
								<html:text styleClass="form_input_1x" property="stopdate_fixed" readonly="true"
									onclick="this.value=selectDate();" />
								<font color=red>*</font>
							</td>
						</tr>
						<tr>
							<td width="20%" align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="stdrewardbj" key="rewardstd" />
									:
								</div>
							</td>
							<td width="30%" class="form_table_left">
								<html:text styleClass="form_input_1x" property="rewardstd_fixed" maxlength="14" />
								<font color=red>*</font>
							</td>
							<td width="20%" align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="stdrewardbj" key="ruleid" />
									:
								</div>
							</td>
							<td width="30%" class="form_table_left">
								<html:text styleClass="form_input_1x" property="ruleid_fixed"/>
								<input type="button" value="..." class="clickButton" onclick="doShowRule('ruleid_fixed')" >
								<font color=red>*</font>
							</td>
						</tr>
					</table>
				</div>

				<!-- integralreward -->
				<div class="table_div" id="integralreward">
					<table class="form_table">
						<tr>
							<td width="100%" colspan=4 class="form_table_left">
								<div class="field-require">
									<font color=blue><bean:message bundle="stdrewardbj" key="integralreward" /></font>
									<bean:message bundle="stdrewardbj" key="remind" />
								</div>
							</td>
						</tr>
						<tr>
							<td width="20%" align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="stdrewardbj" key="rewardname" />
									:
								</div>
							</td>
							<td width="30%" class="form_table_left">
								<html:text styleClass="form_input_1x" property="rewardname_integral" maxlength="40" />
								<font color=red>*</font>
							</td>
							<td width="20%" align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="stdrewardbj" key="rewardtype" />
									:
								</div>
							</td>
							<td width="30%" class="form_table_left">
								<s:Code2Name code="${requestScope['/cms/reward/stdrewardbj/StdrewardbjForm'].rewardtype_integral}" definition="$CH_REWARDTYPE"/>
								<font color=red>*</font>
							</td>
						</tr>
						<tr>
							<td width="20%" align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="stdrewardbj" key="startdate" />
									:
								</div>
							</td>
							<td width="30%" class="form_table_left">
								<html:text styleClass="form_input_1x" property="startdate_integral" readonly="true"
									onclick="this.value=selectDate();" />
								<font color=red>*</font>
							</td>
							<td width="20%" align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="stdrewardbj" key="stopdate" />
									:
								</div>
							</td>
							<td width="30%" class="form_table_left">
								<html:text styleClass="form_input_1x" property="stopdate_integral" readonly="true"
									onclick="this.value=selectDate();" />
								<font color=red>*</font>
							</td>
						</tr>
						<tr>
							<td width="20%" align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="stdrewardbj" key="rewardstd" />
									:
								</div>
							</td>
							<td width="30%" class="form_table_left">
								<html:text styleClass="form_input_1x" property="rewardstd_integral" maxlength="14" />
								<font color=red>*</font>
							</td>
							<td width="20%" align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="stdrewardbj" key="ruleid" />
									:
								</div>
							</td>
							<td width="30%" class="form_table_left">
								<html:text styleClass="form_input_1x" property="ruleid_integral" />
								<input type="button" value="..." class="clickButton" onclick="doShowRule('ruleid_integral')" >
								<font color=red>*</font>
							</td>
						</tr>
					</table>
				</div>

				<!-- allowancereward -->
				<div class="table_div" id="allowancereward">
					<table class="form_table">
						<tr>
							<td width="100%" colspan=4 class="form_table_left">
								<div class="field-require">
									<font color=blue><bean:message bundle="stdrewardbj" key="allowance" /></font>
									<bean:message bundle="stdrewardbj" key="remind" />
								</div>
							</td>
						</tr>
						<tr>
							<td width="20%" align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="stdrewardbj" key="rewardname" />
									:
								</div>
							</td>
							<td width="30%" class="form_table_left">
								<html:text styleClass="form_input_1x" property="rewardname_allowance" maxlength="40" />
								<font color=red>*</font>
							</td>
							<td width="20%" align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="stdrewardbj" key="rewardtype" />
									:
								</div>
							</td>
							<td width="30%" class="form_table_left">
								<s:Code2Name code="${requestScope['/cms/reward/stdrewardbj/StdrewardbjForm'].rewardtype_allowance}" definition="$CH_REWARDTYPE"/>
								<font color=red>*</font>
							</td>
						</tr>
						<tr>
							<td width="20%" align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="stdrewardbj" key="startdate" />
									:
								</div>
							</td>
							<td width="30%" class="form_table_left">
								<html:text styleClass="form_input_1x" property="startdate_allowance" readonly="true"
									onclick="this.value=selectDate();" />
								<font color=red>*</font>
							</td>
							<td width="20%" align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="stdrewardbj" key="stopdate" />
									:
								</div>
							</td>
							<td width="30%" class="form_table_left">
								<html:text styleClass="form_input_1x" property="stopdate_allowance" readonly="true"
									onclick="this.value=selectDate();" />
								<font color=red>*</font>
							</td>
						</tr>
						<tr>
							<td width="20%" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="stdrewardbj" key="rewardstd" />
									:
								</div>
							</td>
							<td width="30%" class="form_table_left">
								<html:text styleClass="form_input_1x" property="rewardstd_allowance" maxlength="14" />
								<font color=red>*</font>
							</td>
							<td width="20%" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="stdrewardbj" key="ruleid" />
									:
								</div>
							</td>
							<td width="30%" class="form_table_left">
								<html:text styleClass="form_input_1x" property="ruleid_allowance" />
								<input type="button" value="..." class="clickButton" onclick="doShowRule('ruleid_allowance')" >
								<font color=red>*</font>
							</td>
						</tr>
					</table>
				</div>

				<div class="table_div">
					<table>
						<tr>
							<td>
								<s:RewardPurChk controlid="<%=ID_1%>" disableChild="true">
								<input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);" name="btnSave"
									onfocus="buttonover(this)" onblur="buttonout(this)" value="<bean:message bundle="public" key="button_save"/>"
									class="submit" onclick="doSaveCard()" />							
								</s:RewardPurChk>
								<input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);" name="btnReturn"
									onfocus="buttonover(this)" onblur="buttonout(this)" value="<bean:message bundle="public" key="button_return"/>"
									class="close" onclick="doReturn('/cms/operation.do?CMD=LIST')">
							</td>
						</tr>
					</table>
				</div>
			</html:form>
		</div>

<script language="JavaScript">
if (formItem.fixedflag.value == 'true') {
	document.getElementById("fixedbox").checked = true;
	document.getElementById("fixedreward").style.display = "";
} else {
	document.getElementById("fixedbox").checked = false;
	document.getElementById("fixedreward").style.display = "none";
}

if (formItem.integralflag.value == 'true') {
	document.getElementById("integralbox").checked = true;
	document.getElementById("integralreward").style.display = "";
} else {
	document.getElementById("integralbox").checked = false;
	document.getElementById("integralreward").style.display = "none";
}

if (formItem.allowanceflag.value == 'true') {
	document.getElementById("allowancebox").checked = true;
	document.getElementById("allowancereward").style.display = "";
} else {
	document.getElementById("allowancebox").checked = false;
	document.getElementById("allowancereward").style.display = "none";
}
</script>
	</body>
</html>
