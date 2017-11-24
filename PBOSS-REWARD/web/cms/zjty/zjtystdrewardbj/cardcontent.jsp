<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/contenthead.inc"%>
<%
String ID_1 = "CH_ZJTY_REWARD||CH_ZJTY_PROVINCIAL"; //省级酬金管理令牌
String ID_2 = "CH_ZJTY_REWARD||CH_ZJTY_CIVIC"; //市级酬金管理令牌
%>
<html>
	<head>
		<title><bean:message bundle="zjtystdrewardbj" key="titleCard" />
		</title>
<script type="text/javascript" src="<%=contextPath%>/js/pub/list.js"></script>
<script type="text/javascript" src="<%= contextPath %>/js/bus/waycommon.js"></script>
<script type="text/javascript" src="<%= contextPath%>/js/bus/rescommon.js"></script>
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
	addfield('wayid', '<bean:message bundle="zjtystdrewardbj" key="wayid"/>', 'c', false, '32');
	if (formItem.fixedflag.value != 'true' && formItem.integralflag.value != 'true' && formItem.allowanceflag.value != 'true') {
		alert("业务对应酬金为空，要求至少选择一种酬金，请在对应选框中打勾");
		return;
	}
	if (formItem.fixedflag.value == 'true') {
		addfield('rewardname_fixed', '<bean:message bundle="zjtystdrewardbj" key="rewardname"/>', 'c', false, '80');
		addfield('startdate_fixed', '<bean:message bundle="zjtystdrewardbj" key="startdate"/>', 't', false, '10');
		addfield('stopdate_fixed', '<bean:message bundle="zjtystdrewardbj" key="stopdate"/>', 't', false, '10');
		addfield('ruleid_fixed', '<bean:message bundle="zjtystdrewardbj" key="ruleid"/>', 'c', false, '18');
		addfield('rewardstd_fixed', '<bean:message bundle="zjtystdrewardbj" key="rewardstd"/>', 'd', false, '12','2');
		addfield('intvmonth_fixed', '<bean:message bundle="zjtystdrewardbj" key="intvmonth"/>', 'i', false, '5','','','0');
		if(date_compare("startdate_fixed","stopdate_fixed","销售酬金停用日期不能早于启动日期"))return false;
	}
	if (formItem.integralflag.value == 'true') {
		addfield('rewardname_integral', '<bean:message bundle="zjtystdrewardbj" key="rewardname"/>', 'c', false, '80');
		addfield('startdate_integral', '<bean:message bundle="zjtystdrewardbj" key="startdate"/>', 't', false, '10');
		addfield('stopdate_integral', '<bean:message bundle="zjtystdrewardbj" key="stopdate"/>', 't', false, '10');
		addfield('ruleid_integral', '<bean:message bundle="zjtystdrewardbj" key="ruleid"/>', 'c', false, '18');
		addfield('rewardstd_integral', '<bean:message bundle="zjtystdrewardbj" key="rewardstd"/>', 'd', false, '12','2');
		addfield('intvmonth_integral', '<bean:message bundle="zjtystdrewardbj" key="intvmonth"/>', 'i', false, '5','','','0');
		if(date_compare("startdate_integral","stopdate_integral","激活酬金停用日期不能早于启动日期"))return false;
	}
	if (formItem.allowanceflag.value == 'true') {
		addfield('rewardname_allowance', '<bean:message bundle="zjtystdrewardbj" key="rewardname"/>', 'c', false, '80');
		addfield('startdate_allowance', '<bean:message bundle="zjtystdrewardbj" key="startdate"/>', 't', false, '10');
		addfield('stopdate_allowance', '<bean:message bundle="zjtystdrewardbj" key="stopdate"/>', 't', false, '10');
		addfield('ruleid_allowance', '<bean:message bundle="zjtystdrewardbj" key="ruleid"/>', 'c', false, '18');
		addfield('rewardstd_allowance', '<bean:message bundle="zjtystdrewardbj" key="rewardstd"/>', 'd', false, '12','2');
		addfield('intvmonth_allowance', '<bean:message bundle="zjtystdrewardbj" key="intvmonth"/>', 'i', false, '5','','','0');
		if(date_compare("startdate_allowance","stopdate_allowance","客户质量奖酬金停用日期不能早于启动日期"))return false;
	}
	return checkval(window);
}

function doSaveCard() {
	if (ev_checkval()) {
		var url = contextPath + '/cms/zjty/stdrewardbj.do?CMD=SAVECARD';
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
	var urlForPrint = contextPath + '/cms/reward/rule2.do?CMD=SELECTZJTYRULE&PK=' + formItem.opnid.value;
	var returnValue = window.showModalDialog(urlForPrint, "", "dialogWidth=550px;dialogHeight=450px;status=no;resizable:yes;");
	returnValue = returnValue==null?"":returnValue;
	if (returnValue != "") {
		document.all(id).value = returnValue;
	}
}

function doShowResource() {
	if(formItem.wayid.value == '' || formItem.wayid.value == null){
		return false;
	}else{
		formItem.action = "<%=contextPath%>/cms/zjty/stdrewardbj.do?CMD=SHOW";
		formItem.submit();
	}
}
document.onkeydown = function() {   
	if(event.keyCode == '13'){
		doShowResource();
	}
}

</script>
	</head>
	<body onload="loadforiframe();">
		<div class="table_container">
			<html:form action="/cms/zjty/stdrewardbj.do?CMD=SAVE" styleId="formItem" method="post">
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
				
				<html:hidden property="intvmonth_fixed" value="0"/>
				
				<c:set var="edtState" scope="request" value="${!empty param.CMD and (param.CMD eq 'EDIT' or param.CMD eq 'NEW')}" />
				<c:set var="updateState" scope="request" value="${!empty param.CMD and (param.CMD eq 'EDIT')}" />

				<!--##################################添加标题内容##################################################-->
				<div class="table_div">
					<table class="top_table">
						<tr>
							<td>
								<bean:message bundle="zjtystdrewardbj" key="titleCard" />
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
									<font color=blue><bean:message bundle="zjtystdrewardbj" key="businessinfo" /></font>
								</div>
							</td>
						</tr>
						<tr>
							<td width="20%" align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="zjtystdrewardbj" key="opnid" />
									:
								</div>
							</td>
							<td width="30%" align="left" class="form_table_left">
								<c:out value="${requestScope['/cms/zjty/zjtystdrewardbj/ZjtyStdrewardbjForm'].opnid}" />
							</td>
							<td width="25%" align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="zjtystdrewardbj" key="opnname" />
									:
								</div>
							</td>
							<td width="25%" align="left" class="form_table_left">
								<c:out value="${requestScope['/cms/zjty/zjtystdrewardbj/ZjtyStdrewardbjForm'].opnname}" />
							</td>
						</tr>
						<tr>
							<td width="25%" align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="zjtystdrewardbj" key="busibelong" />
									:
								</div>
							</td>
							<td width="25%" align="left" class="form_table_left">
								<s:Code2Name code="${requestScope['/cms/zjty/zjtystdrewardbj/ZjtyStdrewardbjForm'].busibelong}" definition="#CH_ZJTY_BUSIBELONG" />
							</td>
							<td width="25%" align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="zjtystdrewardbj" key="state" />
									:
								</div>
							</td>
							<td width="25%" align="left" class="form_table_left">
								<s:Code2Name code="${requestScope['/cms/zjty/zjtystdrewardbj/ZjtyStdrewardbjForm'].opnstate}" definition="$CH_VALIDFLAG"/>
							</td>
						</tr>
						<tr>
							<td width="25%" align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="zjtystdrewardbj" key="wayid" />
									:
								</div>
							</td>
							<td width="25%" align="left" class="form_table_left">
								<html:text styleClass="form_input_1x" property="wayid" readonly="true"/><input type="button" value="..." class="clickbutton" onclick="showSelectWay3(this,'wayid','','','AG','ZJTY','1');this.value='...';doShowResource();">
								<font color="red">*</font>
							</td>
							<td width="25%" align="right" class="form_table_right">
							</td>
							<td width="25%" align="left" class="form_table_left">
							</td>
						</tr>
						<tr>
							<td width="25%" align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="zjtystdrewardbj" key="busireward" />
									:
								</div>
							</td>
							<td width="75%" colspan=3 class="form_table_left">
								<input type="checkbox" id="fixedbox" value="" onclick="changeFixed(this);" class="table_checkbox">
								<bean:message bundle="zjtystdrewardbj" key="fixedreward" />
								<input type="checkbox" id="integralbox" value="" onclick="changeIntegral(this);" class="table_checkbox">
								<bean:message bundle="zjtystdrewardbj" key="integralreward" />
								<input type="checkbox" id="allowancebox" value="" onclick="changeAllowance(this);" class="table_checkbox">
								<bean:message bundle="zjtystdrewardbj" key="allowance" />
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
									<font color=blue><bean:message bundle="zjtystdrewardbj" key="fixedreward" /></font>
									<bean:message bundle="zjtystdrewardbj" key="remind" />
								</div>
							</td>
						</tr>
						<tr>
							<td width="20%" align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="zjtystdrewardbj" key="rewardname" />
									:
								</div>
							</td>
							<td width="30%" class="form_table_left">
								<html:text styleClass="form_input_1x" property="rewardname_fixed" maxlength="40" />
								<font color=red>*</font>
							</td>
							<td width="20%" align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="zjtystdrewardbj" key="rewardtype" />
									:
								</div>
							</td>
							<td width="30%" class="form_table_left">
								<s:Code2Name code="${requestScope['/cms/zjty/zjtystdrewardbj/ZjtyStdrewardbjForm'].rewardtype_fixed}" definition="#CH_ZJTY_REWARDTYPE"/>
								<font color=red>*</font>
							</td>
						</tr>
						<tr>
							<td width="20%" align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="zjtystdrewardbj" key="startdate" />
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
									<bean:message bundle="zjtystdrewardbj" key="stopdate" />
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
									<bean:message bundle="zjtystdrewardbj" key="rewardstd" />
									:
								</div>
							</td>
							<td width="30%" class="form_table_left">
								<input type="text" Class="form_input_1x" name="rewardstd_fixed" value="<fmt:formatNumber pattern="0.00" value="${requestScope['/cms/zjty/zjtystdrewardbj/ZjtyStdrewardbjForm'].rewardstd_fixed}"/>"  />
								<font color=red>*</font>
							</td>
							<td width="20%" align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="zjtystdrewardbj" key="ruleid" />
									:
								</div>
							</td>
							<td width="30%" class="form_table_left">
								<html:text styleClass="form_input_1x" property="ruleid_fixed" readonly="true"/><input type="button" value="..." class="clickButton" onclick="doShowRule('ruleid_fixed')" >
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
									<font color=blue><bean:message bundle="zjtystdrewardbj" key="integralreward" /></font>
									<bean:message bundle="zjtystdrewardbj" key="remind" />
								</div>
							</td>
						</tr>
						<tr>
							<td width="20%" align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="zjtystdrewardbj" key="rewardname" />
									:
								</div>
							</td>
							<td width="30%" class="form_table_left">
								<html:text styleClass="form_input_1x" property="rewardname_integral" maxlength="40" />
								<font color=red>*</font>
							</td>
							<td width="20%" align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="zjtystdrewardbj" key="rewardtype" />
									:
								</div>
							</td>
							<td width="30%" class="form_table_left">
								<s:Code2Name code="${requestScope['/cms/zjty/zjtystdrewardbj/ZjtyStdrewardbjForm'].rewardtype_integral}" definition="#CH_ZJTY_REWARDTYPE"/>
								<font color=red>*</font>
							</td>
						</tr>
						<tr>
							<td width="20%" align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="zjtystdrewardbj" key="startdate" />
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
									<bean:message bundle="zjtystdrewardbj" key="stopdate" />
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
									<bean:message bundle="zjtystdrewardbj" key="rewardstd" />
									:
								</div>
							</td>
							<td width="30%" class="form_table_left">
								<input type="text" Class="form_input_1x" name="rewardstd_integral" value="<fmt:formatNumber pattern="0.00" value="${requestScope['/cms/zjty/zjtystdrewardbj/ZjtyStdrewardbjForm'].rewardstd_integral}"/>"  />
								<font color=red>*</font>
							</td>
							<td width="20%" align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="zjtystdrewardbj" key="ruleid" />
									:
								</div>
							</td>
							<td width="30%" class="form_table_left">
								<html:text styleClass="form_input_1x" property="ruleid_integral" readonly="true"/><input type="button" value="..." class="clickButton" onclick="doShowRule('ruleid_integral')" >
								<font color=red>*</font>
							</td>
						</tr>
						<tr>
							<td width="20%" align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="zjtystdrewardbj" key="intvmonth"/>
									:
								</div>
							</td>
							<td width="80%" colspan=3 class="form_table_left">
								<html:text styleClass="form_input_1x" property="intvmonth_integral" maxlength="5"  />
								<font color=red>*</font>
								<bean:message bundle="zjtystdrewardbj" key="intvexplain"/>
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
									<font color=blue><bean:message bundle="zjtystdrewardbj" key="allowance" /></font>
									<bean:message bundle="zjtystdrewardbj" key="remind" />
								</div>
							</td>
						</tr>
						<tr>
							<td width="20%" align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="zjtystdrewardbj" key="rewardname" />
									:
								</div>
							</td>
							<td width="30%" class="form_table_left">
								<html:text styleClass="form_input_1x" property="rewardname_allowance" maxlength="40" />
								<font color=red>*</font>
							</td>
							<td width="20%" align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="zjtystdrewardbj" key="rewardtype" />
									:
								</div>
							</td>
							<td width="30%" class="form_table_left">
								<s:Code2Name code="${requestScope['/cms/zjty/zjtystdrewardbj/ZjtyStdrewardbjForm'].rewardtype_allowance}" definition="#CH_ZJTY_REWARDTYPE"/>
								<font color=red>*</font>
							</td>
						</tr>
						<tr>
							<td width="20%" align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="zjtystdrewardbj" key="startdate" />
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
									<bean:message bundle="zjtystdrewardbj" key="stopdate" />
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
									<bean:message bundle="zjtystdrewardbj" key="rewardstd" />
									:
								</div>
							</td>
							<td width="30%" class="form_table_left">
								<input type="text" Class="form_input_1x" name="rewardstd_allowance" value="<fmt:formatNumber pattern="0.00" value="${requestScope['/cms/zjty/zjtystdrewardbj/ZjtyStdrewardbjForm'].rewardstd_allowance}"/>"  />
								<font color=red>*</font>
							</td>
							<td width="20%" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="zjtystdrewardbj" key="ruleid" />
									:
								</div>
							</td>
							<td width="30%" class="form_table_left">
								<html:text styleClass="form_input_1x" property="ruleid_allowance" readonly="true"/><input type="button" value="..." class="clickButton" onclick="doShowRule('ruleid_allowance')" >
								<font color=red>*</font>
							</td>
						</tr>
						<tr>
							<td width="20%" align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="zjtystdrewardbj" key="intvmonth"/>
									:
								</div>
							</td>
							<td width="80%" colspan=3 class="form_table_left">
								<html:text styleClass="form_input_1x" property="intvmonth_allowance" maxlength="5"  />
								<font color=red>*</font>
								<bean:message bundle="zjtystdrewardbj" key="intvexplain"/>
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
									class="close" onclick="doReturn('/cms/zjty/operation.do?CMD=LIST')">
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
