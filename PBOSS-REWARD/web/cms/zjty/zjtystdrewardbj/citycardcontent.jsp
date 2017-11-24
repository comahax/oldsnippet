<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/contenthead.inc"%>
<%
String ID_1 = "CH_ZJTY_REWARD||CH_ZJTY_PROVINCIAL"; //ʡ������������
String ID_2 = "CH_ZJTY_REWARD||CH_ZJTY_CIVIC"; //�м�����������
%>
<html>
	<head>
		<title><bean:message bundle="zjtystdrewardbj" key="titleCityCard" />
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
	if (formItem.fixedflag.value == 'true') {
		addfield('rewardname_fixed', '<bean:message bundle="zjtystdrewardbj" key="rewardname"/>', 'c', false, '80');
		addfield('startdate_fixed', '<bean:message bundle="zjtystdrewardbj" key="startdate"/>', 't', false, '10');
		addfield('stopdate_fixed', '<bean:message bundle="zjtystdrewardbj" key="stopdate"/>', 't', false, '10');
		//addfield('ruleid_fixed', '<bean:message bundle="zjtystdrewardbj" key="ruleid"/>', 'c', false, '18');
		addfield('rewardstd_fixed', '<bean:message bundle="zjtystdrewardbj" key="rewardstd"/>', 'd', false, '12','2','','0',formItem.rewardstd_fixed_limited.value);
		addfield('intvmonth_fixed', '<bean:message bundle="zjtystdrewardbj" key="intvmonth"/>', 'i', false, '5','','','0');
		if(date_compare("startdate_fixed","stopdate_fixed","���۳��ͣ�����ڲ���������������"))return false;
	}
	if (formItem.integralflag.value == 'true') {
		addfield('rewardname_integral', '<bean:message bundle="zjtystdrewardbj" key="rewardname"/>', 'c', false, '80');
		addfield('startdate_integral', '<bean:message bundle="zjtystdrewardbj" key="startdate"/>', 't', false, '10');
		addfield('stopdate_integral', '<bean:message bundle="zjtystdrewardbj" key="stopdate"/>', 't', false, '10');
		//addfield('ruleid_integral', '<bean:message bundle="zjtystdrewardbj" key="ruleid"/>', 'c', false, '18');
		addfield('rewardstd_integral', '<bean:message bundle="zjtystdrewardbj" key="rewardstd"/>', 'd', false, '12','2','','0',formItem.rewardstd_integral_limited.value);
		addfield('intvmonth_integral', '<bean:message bundle="zjtystdrewardbj" key="intvmonth"/>', 'i', false, '5','','','0');
		if(date_compare("startdate_integral","stopdate_integral","������ͣ�����ڲ���������������"))return false;
	}
	if (formItem.allowanceflag.value == 'true') {
		addfield('rewardname_allowance', '<bean:message bundle="zjtystdrewardbj" key="rewardname"/>', 'c', false, '80');
		addfield('startdate_allowance', '<bean:message bundle="zjtystdrewardbj" key="startdate"/>', 't', false, '10');
		addfield('stopdate_allowance', '<bean:message bundle="zjtystdrewardbj" key="stopdate"/>', 't', false, '10');
	//	addfield('ruleid_allowance', '<bean:message bundle="zjtystdrewardbj" key="ruleid"/>', 'c', false, '18');
		addfield('rewardstd_allowance', '<bean:message bundle="zjtystdrewardbj" key="rewardstd"/>', 'd', false, '12','2','','0',formItem.rewardstd_allowance_limited.value);
		addfield('intvmonth_allowance', '<bean:message bundle="zjtystdrewardbj" key="intvmonth"/>', 'i', false, '5','','','0');
		if(date_compare("startdate_allowance","stopdate_allowance","�ͻ����������ͣ�����ڲ���������������"))return false;
	}
	return checkval(window);
}

function doSaveCityCard() {
	if (ev_checkval()) {
		var url = contextPath + '/cms/zjty/stdrewardbj.do?CMD=SAVECITYCARD';
		formItem.action = url;
		formItem.submit();
	}
}

function changeFixed(obj) {
	reloadforiframe();
	if (obj.checked == true) {
		formItem.fixedflag.value = true;
		document.getElementById("fixedreward").style.display=""; //��ʾ
	} else {
		formItem.fixedflag.value = false;
		document.getElementById("fixedreward").style.display="none"; //����
	}
}

function changeIntegral(obj) {
	reloadforiframe();
	if (obj.checked == true) {
		formItem.integralflag.value = true;
		document.getElementById("integralreward").style.display=""; //��ʾ
	} else {
		formItem.integralflag.value = false;
		document.getElementById("integralreward").style.display="none"; //����
	}
}

function changeAllowance(obj) {
	reloadforiframe();
	if (obj.checked == true) {
		formItem.allowanceflag.value = true;
		document.getElementById("allowancereward").style.display=""; //��ʾ
	} else {
		formItem.allowanceflag.value = false;
		document.getElementById("allowancereward").style.display="none"; //����
	}
}

function doReturn(url) {
	window.parent.document.location = contextPath + url;
}

function doShowCityResource() {
	if(formItem.wayid.value == '' || formItem.wayid.value == null){
		return false;
	}else{
		formItem.action = "<%=contextPath%>/cms/zjty/stdrewardbj.do?CMD=SHOWCITY";
		formItem.submit();
	}
}
document.onkeydown = function() {   
	if(event.keyCode == '13'){
		doShowCityResource();
	}
}
</script>
	</head>
<body onload="loadforiframe();">
		<div class="table_container">
			<html:form action="/cms/zjty/stdrewardbj.do?CMD=SAVECITYCARD" styleId="formItem" method="post">
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
				<html:hidden property="rewardname_fixed" />
				<html:hidden property="rewardtype_fixed" />
				<html:hidden property="startdate_fixed" />
				<html:hidden property="stopdate_fixed" />
				<html:hidden property="ruleid_fixed" />
				<html:hidden property="rewardname_integral" />
				<html:hidden property="rewardtype_integral" />
				<html:hidden property="startdate_integral" />
				<html:hidden property="stopdate_integral" />
				<html:hidden property="ruleid_integral" />
				<html:hidden property="rewardname_allowance" />
				<html:hidden property="rewardtype_allowance" />
				<html:hidden property="startdate_allowance" />
				<html:hidden property="stopdate_allowance" />
				<html:hidden property="ruleid_allowance" />
				<html:hidden property="rewardtype_fixed" />
				<html:hidden property="rewardtype_integral" />
				<html:hidden property="rewardtype_allowance" />
				<html:hidden property="rewardname_encourage_temp" />
				
				<html:hidden property="rewardstd_fixed_limited" />
				<html:hidden property="rewardstd_integral_limited" />
				<html:hidden property="rewardstd_allowance_limited" />
				
				<html:hidden property="intvmonth_fixed" value="0"/>
				
				<c:set var="edtState" scope="request" value="${!empty param.CMD and (param.CMD eq 'EDIT' or param.CMD eq 'NEW')}" />
				<c:set var="updateState" scope="request" value="${!empty param.CMD and (param.CMD eq 'EDIT')}" />

				<!--##################################��ӱ�������##################################################-->
				<div class="table_div">
					<table class="top_table">
						<tr>
							<td>
								<bean:message bundle="zjtystdrewardbj" key="titleCityCard" />
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
								<html:text styleClass="form_input_1x" property="wayid" readonly="true"/><input type="button" value="..." class="clickbutton" onclick="showSelectWay3(this,'wayid','','','AG','ZJTY','1');this.value='...';doShowCityResource();">
								<font color="red">*</font>
							</td>
							<td width="25%" align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="zjtystdrewardbj" key="wayname" />
									:
								</div>
							</td>
							<td width="25%" align="left" class="form_table_left">
								<s:Code2Name code="${requestScope['/cms/zjty/zjtystdrewardbj/ZjtyStdrewardbjForm'].wayid}" definition="#WAY"/>
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
								<input type="checkbox" id="fixedbox" value="" onclick="changeFixed(this);" disabled="disabled" class="table_checkbox">
								<bean:message bundle="zjtystdrewardbj" key="fixedreward" />
								<input type="checkbox" id="integralbox" value="" onclick="changeIntegral(this);" disabled="disabled" class="table_checkbox">
								<bean:message bundle="zjtystdrewardbj" key="integralreward" />
								<input type="checkbox" id="allowancebox" value="" onclick="changeAllowance(this);" disabled="disabled" class="table_checkbox">
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
								<c:out value="${requestScope['/cms/zjty/zjtystdrewardbj/ZjtyStdrewardbjForm'].rewardname_fixed}" />
							</td>
							<td width="20%" align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="zjtystdrewardbj" key="rewardtype" />
									:
								</div>
							</td>
							<td width="30%" class="form_table_left">
								<s:Code2Name code="${requestScope['/cms/zjty/zjtystdrewardbj/ZjtyStdrewardbjForm'].rewardtype_fixed}" definition="#CH_ZJTY_REWARDTYPE"/>
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
								<c:out value="${requestScope['/cms/zjty/zjtystdrewardbj/ZjtyStdrewardbjForm'].startdate_fixed}" />
							</td>
							<td width="20%" align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="zjtystdrewardbj" key="stopdate" />
									:
								</div>
							</td>
							<td width="30%" class="form_table_left">
								<c:out value="${requestScope['/cms/zjty/zjtystdrewardbj/ZjtyStdrewardbjForm'].stopdate_fixed}" />
							</td>
						</tr>
						<tr>
							<td width="20%" align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="zjtystdrewardbj" key="rewardstd" />
									:
								</div>
							</td>
							<td width="30%" colspan="3" class="form_table_left">
								<input type="text" Class="form_input_1x" name="rewardstd_fixed" value="<fmt:formatNumber pattern="0.00" value="${requestScope['/cms/zjty/zjtystdrewardbj/ZjtyStdrewardbjForm'].rewardstd_fixed}"/>"  />
								<font color=red>*</font>
								(ʡ��˾�������:<font color="red"><fmt:formatNumber pattern="0.00" value="${requestScope['/cms/zjty/zjtystdrewardbj/ZjtyStdrewardbjForm'].rewardstd_fixed_limited}" /></font>Ԫ/�ٷֱ�)
							</td>
						</tr>
						<tr>
							<td width="20%" align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="zjtystdrewardbj" key="ruleid" />
									:
								</div>
							</td>
							<td width="30%" colspan="3" class="form_table_left">
								<c:out value="${requestScope['/cms/zjty/zjtystdrewardbj/ZjtyStdrewardbjForm'].ruleid_fixed}" />&nbsp;
								<s:Code2Name code="${requestScope['/cms/zjty/zjtystdrewardbj/ZjtyStdrewardbjForm'].ruleid_fixed}" definition="#CH_ADT_RULE"/>
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
								<c:out value="${requestScope['/cms/zjty/zjtystdrewardbj/ZjtyStdrewardbjForm'].rewardname_integral}" />
							</td>
							<td width="20%" align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="zjtystdrewardbj" key="rewardtype" />
									:
								</div>
							</td>
							<td width="30%" class="form_table_left">
								<s:Code2Name code="${requestScope['/cms/zjty/zjtystdrewardbj/ZjtyStdrewardbjForm'].rewardtype_integral}" definition="#CH_ZJTY_REWARDTYPE"/>
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
								<c:out value="${requestScope['/cms/zjty/zjtystdrewardbj/ZjtyStdrewardbjForm'].startdate_integral}" />
							</td>
							<td width="20%" align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="zjtystdrewardbj" key="stopdate" />
									:
								</div>
							</td>
							<td width="30%" class="form_table_left">
								<c:out value="${requestScope['/cms/zjty/zjtystdrewardbj/ZjtyStdrewardbjForm'].stopdate_integral}" />
							</td>
						</tr>
						<tr>
							<td width="20%" align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="zjtystdrewardbj" key="rewardstd" />
									:
								</div>
							</td>
							<td width="30%" colspan="3" class="form_table_left">
								<input type="text" Class="form_input_1x" name="rewardstd_integral" value="<fmt:formatNumber pattern="0.00" value="${requestScope['/cms/zjty/zjtystdrewardbj/ZjtyStdrewardbjForm'].rewardstd_integral}"/>"  />
								<font color=red>*</font>
								(ʡ��˾�������:<font color="red"><fmt:formatNumber pattern="0.00" value="${requestScope['/cms/zjty/zjtystdrewardbj/ZjtyStdrewardbjForm'].rewardstd_integral_limited}" /></font>Ԫ/�ٷֱ�)
							</td>
						</tr>
						<tr>
							<td width="20%" align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="zjtystdrewardbj" key="ruleid" />
									:
								</div>
							</td>
							<td width="30%" colspan="3" class="form_table_left">
								<c:out value="${requestScope['/cms/zjty/zjtystdrewardbj/ZjtyStdrewardbjForm'].ruleid_integral}" />&nbsp;
								<s:Code2Name code="${requestScope['/cms/zjty/zjtystdrewardbj/ZjtyStdrewardbjForm'].ruleid_integral}" definition="#CH_ADT_RULE"/>
							</td>
						</tr>
						<tr>
							<td width="20%" align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="zjtystdrewardbj" key="intvmonth" />
									:
								</div>
							</td>
							<td width="80%" colspan=3 class="form_table_left">
								<html:text styleClass="form_input_1x" property="intvmonth_integral" maxlength="5" />
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
								<c:out value="${requestScope['/cms/zjty/zjtystdrewardbj/ZjtyStdrewardbjForm'].rewardname_allowance}" />
							</td>
							<td width="20%" align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="zjtystdrewardbj" key="rewardtype" />
									:
								</div>
							</td>
							<td width="30%" class="form_table_left">
								<s:Code2Name code="${requestScope['/cms/zjty/zjtystdrewardbj/ZjtyStdrewardbjForm'].rewardtype_allowance}" definition="#CH_ZJTY_REWARDTYPE"/>
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
								<c:out value="${requestScope['/cms/zjty/zjtystdrewardbj/ZjtyStdrewardbjForm'].startdate_allowance}" />
							</td>
							<td width="20%" align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="zjtystdrewardbj" key="stopdate" />
									:
								</div>
							</td>
							<td width="30%" class="form_table_left">
								<c:out value="${requestScope['/cms/zjty/zjtystdrewardbj/ZjtyStdrewardbjForm'].stopdate_allowance}" />
							</td>
						</tr>
						<tr>
							<td width="20%" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="zjtystdrewardbj" key="rewardstd" />
									:
								</div>
							</td>
							<td width="30%" colspan="3" class="form_table_left">
								<input type="text" Class="form_input_1x" name="rewardstd_allowance" value="<fmt:formatNumber pattern="0.00" value="${requestScope['/cms/zjty/zjtystdrewardbj/ZjtyStdrewardbjForm'].rewardstd_allowance}"/>"  />
								<font color=red>*</font>
								(ʡ��˾�������:<font color="red"><fmt:formatNumber pattern="0.00" value="${requestScope['/cms/zjty/zjtystdrewardbj/ZjtyStdrewardbjForm'].rewardstd_allowance_limited}" /></font>Ԫ/�ٷֱ�)
							</td>
						</tr>
						<tr>
							<td width="20%" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="zjtystdrewardbj" key="ruleid" />
									:
								</div>
							</td>
							<td width="30%" colspan="3" class="form_table_left">
								<c:out value="${requestScope['/cms/zjty/zjtystdrewardbj/ZjtyStdrewardbjForm'].ruleid_allowance}" />&nbsp;
								<s:Code2Name code="${requestScope['/cms/zjty/zjtystdrewardbj/ZjtyStdrewardbjForm'].ruleid_allowance}" definition="#CH_ADT_RULE"/>
							</td>
						</tr>
						<tr>
							<td width="20%" align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="zjtystdrewardbj" key="intvmonth" />
									:
								</div>
							</td>
							<td width="80%" colspan=3 class="form_table_left">
								<html:text styleClass="form_input_1x" property="intvmonth_allowance" maxlength="5" />
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
								<s:RewardPurChk controlid="<%=ID_2%>" disableChild="true">
								<input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);" name="btnSave"
									onfocus="buttonover(this)" onblur="buttonout(this)" value="<bean:message bundle="public" key="button_save"/>"
									class="submit" onclick="doSaveCityCard()" />							
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
