<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/contenthead.inc"%>
<%@ page import="com.sunrise.boss.ui.commons.WebConstant,java.util.*"%>
<%
String ID_1 = "CH_PW_REWARD||CH_PW_REWARD_PROVINCIAL"; //ʡ������������
String ID_2 = "CH_PW_REWARD||CH_PW_REWARD_CIVIC"; //�м�����������
String EDIT = (String) request.getAttribute(WebConstant.COMMAND_STRING_EDIT);
int listSize = ((List) request.getSession().getAttribute("NEWLIST")).size();

%>
<html>
	<head>
		<title><bean:message bundle="stdrewardbj" key="titleCityCard" />
		</title>
<script type="text/javascript" src="<%=contextPath%>/js/pub/list.js"></script>
<script language="JavaScript">
function LoadValidation(){
	if(<%=listSize %> < 1){
		return true;
	}
	var intvmonth = formItem.intvmonth_encourage.value;
	var ruleid = formItem.ruleid_encourage.value;
	var table = document.getElementById("Table2");
	var lastIntvmonth = table.rows[table.rows.length-1].cells[5].childNodes[0].nodeValue;
	var lastRuleid = table.rows[table.rows.length-1].cells[6].childNodes[0].nodeValue.substr(0,3);
	if(parseInt(intvmonth) <= parseInt(lastIntvmonth)){
		alert('����·�['+intvmonth+']�������ڻ�������һ����¼�ļ���·�['+lastIntvmonth+']');
		return false;
	}
	if(ruleid <= lastRuleid){
		alert('����У�����['+ruleid+']�����������һ����¼��У�����['+lastRuleid+']����');
		return false;
	}
}
//ֻ��Edit֮���save�жϲ���
function SaveValidation(){
	//���Listʣ��һ�����ж�
	if(<%=listSize %> <= 1){
		return true;
	}
	var rowIndex = formItem.rowIndex.value;
	var table = document.getElementById("Table2");
	var intvmonth = formItem.intvmonth_encourage.value;
	var ruleid = formItem.ruleid_encourage.value;
	
	if(parseInt(rowIndex) + 1 == 1){//ѡ������
		var nextIntvmonth = table.rows[parseInt(rowIndex)+2].cells[5].childNodes[0].nodeValue;
		var nextRuleid = table.rows[parseInt(rowIndex)+2].cells[6].childNodes[0].nodeValue.substr(0,3);
		if(parseInt(intvmonth) >= parseInt(nextIntvmonth)){
			alert('����·�['+intvmonth+']���ܶ��ڻ������һ����¼�ļ���·�['+nextIntvmonth+']');
			return false;
		}else if(ruleid >= nextRuleid){
			alert('����У�����['+ruleid+']����������һ����¼��У�����['+nextRuleid+']����');
			return false;
		}
	}else if(parseInt(rowIndex) + 1 == <%=listSize %>){//ѡ�����
		var previousIntvmonth = table.rows[parseInt(rowIndex)].cells[5].childNodes[0].nodeValue;
		var previousRuleid = table.rows[parseInt(rowIndex)].cells[6].childNodes[0].nodeValue.substr(0,3);
		if(parseInt(intvmonth) <= parseInt(previousIntvmonth)){
			alert('����·�['+intvmonth+']�������ڻ������һ����¼�ļ���·�['+previousIntvmonth+']');
			return false;
		}else if(ruleid <= previousRuleid){
			alert('����У�����['+ruleid+']����������һ����¼��У�����['+previousRuleid+']����');
			return false;
		}
	}else if(rowIndex > <%=listSize %>){
		alert('ϵͳ����,�ò����Ѿ�������');
		return false;
	}else{
		var prevIntvmonth = table.rows[parseInt(rowIndex)].cells[5].childNodes[0].nodeValue;
		var prevRuleid = table.rows[parseInt(rowIndex)].cells[6].childNodes[0].nodeValue.substr(0,3);
		
		var nextIntvmonth = table.rows[parseInt(rowIndex)+2].cells[5].childNodes[0].nodeValue;
		var nextRuleid = table.rows[parseInt(rowIndex)+2].cells[6].childNodes[0].nodeValue.substr(0,3);
		
		if(parseInt(intvmonth) < parseInt(nextIntvmonth) && parseInt(intvmonth) > parseInt(prevIntvmonth)){
			
		}else{
			alert('����·�['+intvmonth+']�������ڻ������һ����¼�ļ���·�['+prevIntvmonth+']�Ҳ��ܶ��ڻ������һ����¼�ļ���·�['+nextIntvmonth+']');
			return false;
		}
		
		if(ruleid < nextRuleid && ruleid > prevRuleid){
			
		}else{
			alert('����У�����['+ruleid+']����������һ����¼��У�����['+prevRuleid+']�����Ҳ���������һ����¼��У�����['+nextRuleid+']����');
			return false;
		}
		
		return true;
	}
}


function reloadforiframe() {
	if (parent.document.all("loadframe") != null) {
		parent.document.all("loadframe").style.posHeight = document.body.scrollHeight+120;
	}
	if (parent.document.all("IFRM_MAIN") != null) {
		parent.document.all("IFRM_MAIN").style.posHeight = document.body.scrollHeight+120;
	}
}

function ev_checkval() {
	if (formItem.fixedflag.value == 'true') {
		addfield('rewardname_fixed', '<bean:message bundle="stdrewardbj" key="rewardname"/>', 'c', false, '80');
		addfield('startdate_fixed', '<bean:message bundle="stdrewardbj" key="startdate"/>', 't', false, '10');
		addfield('stopdate_fixed', '<bean:message bundle="stdrewardbj" key="stopdate"/>', 't', false, '10');
		addfield('ruleid_fixed', '<bean:message bundle="stdrewardbj" key="ruleid"/>', 'c', false, '18');
		addfield('rewardstd_fixed', '<bean:message bundle="stdrewardbj" key="cityrewardstd"/>', 'd', false, '14','4');
		addfield('intvmonth_fixed', '<bean:message bundle="stdrewardbj" key="intvmonth"/>', 'i', false, '5','','','0');
		if(parseFloat(formItem.rewardstd_fixed_limited.value) < parseFloat(formItem.rewardstd_fixed.value)){
			alert('�û���������޲��ܴ���ʡ��˾���ޱ�׼['+formItem.rewardstd_fixed_limited.value+']������������');
			return false;
		}
	}
	if (formItem.allowanceflag.value == 'true') {
		addfield('rewardname_allowance', '<bean:message bundle="stdrewardbj" key="rewardname"/>', 'c', false, '80');
		addfield('startdate_allowance', '<bean:message bundle="stdrewardbj" key="startdate"/>', 't', false, '10');
		addfield('stopdate_allowance', '<bean:message bundle="stdrewardbj" key="stopdate"/>', 't', false, '10');
		addfield('ruleid_allowance', '<bean:message bundle="stdrewardbj" key="ruleid"/>', 'c', false, '18');
		addfield('rewardstd_allowance', '<bean:message bundle="stdrewardbj" key="cityrewardstd"/>', 'd', false, '14','4');
		addfield('intvmonth_allowance', '<bean:message bundle="stdrewardbj" key="intvmonth"/>', 'i', false, '5','','','0');
		if(parseFloat(formItem.rewardstd_allowance_limited.value) < parseFloat(formItem.rewardstd_allowance.value)){
			alert('�û���������޲��ܴ���ʡ��˾���ޱ�׼['+formItem.rewardstd_allowance_limited.value+']������������');
			return false;
		}
	}
	return checkval(window);
}


function ev_checkvalEccourage() {
	addfield('rewardname_encourage', '<bean:message bundle="stdrewardbj" key="rewardname"/>', 'c', false, '80');
	addfield('startdate_encourage', '<bean:message bundle="stdrewardbj" key="startdate"/>', 't', false, '10');
	addfield('stopdate_encourage', '<bean:message bundle="stdrewardbj" key="stopdate"/>', 't', false, '10');
	addfield('ruleid_encourage', '<bean:message bundle="stdrewardbj" key="ruleid"/>', 'c', false, '18');
	addfield('intvmonth_encourage', '<bean:message bundle="stdrewardbj" key="intvmonth"/>', 'i', false, '5','','','0');
	addfield('rewardstd_encourage', '<bean:message bundle="stdrewardbj" key="cityrewardstd"/>', 'd', false, '14','4');
	if(parseFloat(formItem.rewardstd_encourage_limited.value) < parseFloat(formItem.rewardstd_encourage.value)){
		alert('�ý���������޲��ܴ���ʡ��˾���ޱ�׼['+formItem.rewardstd_encourage_limited.value+']������������');
		return false;
	}
	return checkval(window);
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

function changeEncourage(obj) {
	reloadforiframe();
	if (obj.checked == true) {
		formItem.encourageflag.value = true;
		document.getElementById("encouragereward").style.display=""; //��ʾ
	} else {
		formItem.encourageflag.value = false;
		document.getElementById("encouragereward").style.display="none"; //����
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

function doLoadCityEncourage() {
	var url = contextPath + '/cms/reward/stdrewardbj.do?CMD=LOADCITYENCOURAGE';
	formItem.action = url;
	formItem.submit();
}

function doSaveCityEncourage() {
	if (ev_checkvalEccourage()) {
		if('<%= EDIT %>' == 'TRUE'){
			if(SaveValidation() == false){
				return false;
			}
		}
		if('<%= EDIT %>' == 'LOAD'){
			if(LoadValidation() == false){
				return false;
			}
		}
		var url = contextPath + '/cms/reward/stdrewardbj.do?CMD=SAVECITYENCOURAGE2';
		formItem.action = url;
		formItem.submit();
	}
}

function doSaveCityCard() {
	if(formItem.btnSaveOne.disabled == true){
		if (ev_checkval()) {
			var url = contextPath + '/cms/reward/stdrewardbj.do?CMD=SAVECITYCARD';
			formItem.action = url;
			formItem.submit();
		}
	}else{
		alert('�����û��ֳ���ҵ���䱣�水ť����ܽ��иò���!');
	}
}
var msgNoSelected= "<bean:message bundle="public" key="msgNoSelected"/>";
var msgConfirmDelete= "<bean:message bundle="public" key="msgConfirmDelete"/>";
function doDelCityEncourage() {
	if(formItem.btnSaveOne.disabled == true){
		var TO = true;
		var sis = formItem.all("_selectitem");
		if (forincheck(TO,sis,msgConfirmDelete)) {
			if (sis != null) {
		        if (sis.length != null) {
		            for (var i = sis.length; i > 1; i--) {
		                var prev = sis[i-1];
		                var next = sis[i-2];
		                if (next.checked && !prev.checked){
							alert('������һ����¼ɾ����ߴ����һ����¼����ɾ��');
		        			return false;                
		                }
		            }
		        }
	   		}
			var url = contextPath + '/cms/reward/stdrewardbj.do?CMD=DELENCOURAGE2';
			formItem.action = url;
			formItem.submit();
		}
	}else{
		alert('�����û��ֳ���ҵ���䱣�水ť����ܽ��иò���!');
	}
}

function doEditCityEncourage(url) {
	if(formItem.btnSaveOne.disabled == true){
		formItem.action = url;
		formItem.submit();
	}else{
		alert('�����û��ֳ���ҵ���䱣�水ť����ܽ��иò���!');
	}
}


function doReturn(url) {
	window.parent.document.location = contextPath + url;
}

function doSaveCityStarFix(){
	var url ='<%=contextPath%>/cms/reward/stdrewardbj.do?CMD=SHOWCITYSTAR';
	url += '&s_opnid='+formItem.opnid.value;
	url += '&s_rewardid='+formItem.rewardid_fixed.value;
	url += '&s_acctype=1';
	url += '&s_ruleid='+formItem.ruleid_fixed.value;
	url += '&s_rewardstd='+formItem.rewardstd_fixed_limited.value;
	url += '&s_cityrewardstd='+formItem.rewardstd_fixed.value;
	var rtn=window.showModalDialog(url , 1 , "dialogWidth=900px;dialogHeight=400px;status:no;scroll=yes;");
	if(typeof(rtn) != 'undefined'){
		formItem.rewardstd_fixed.value = rtn;
	}
}
function doSaveCityStarEncourage(){
	var url ='<%=contextPath%>/cms/reward/stdrewardbj.do?CMD=SHOWCITYSTAR';
	url += '&s_opnid='+formItem.opnid.value;
	url += '&s_rewardid='+formItem.rewardid_encourage.value;
	//�������Ĭ��acctypeΪ1
	url += '&s_acctype=1'; 
	url += '&s_ruleid='+formItem.ruleid_encourage.value;
	url += '&s_rewardstd='+formItem.rewardstd_encourage_limited.value;
	url += '&s_cityrewardstd='+formItem.rewardstd_encourage.value;
	var rtn=window.showModalDialog(url , 1 , "dialogWidth=900px;dialogHeight=400px;status:no;scroll=yes;");
	if(typeof(rtn) != 'undefined'){
		formItem.rewardstd_encourage.value = rtn;
	}
}
function doSaveCityStarAllowance(){
	var url ='<%=contextPath%>/cms/reward/stdrewardbj.do?CMD=SHOWCITYSTAR';
	url += '&s_opnid='+formItem.opnid.value;
	url += '&s_rewardid='+formItem.rewardid_allowance.value;
	url += '&s_acctype=1';
	url += '&s_ruleid='+formItem.ruleid_allowance.value;
	url += '&s_rewardstd='+formItem.rewardstd_allowance_limited.value;
	url += '&s_cityrewardstd='+formItem.rewardstd_allowance.value;
	var rtn=window.showModalDialog(url , 1 , "dialogWidth=900px;dialogHeight=400px;status:no;scroll=yes;");
	if(typeof(rtn) != 'undefined'){
		formItem.rewardstd_allowance.value = rtn;
	}
}

function doSaveCityWayFix(){
	var url ='<%=contextPath%>/cms/reward/stdrewardbj.do?CMD=SHOWCITYWAY';
	url += '&s_opnid='+formItem.opnid.value;
	url += '&s_rewardid='+formItem.rewardid_fixed.value;
	url += '&s_acctype=1';
	url += '&s_ruleid='+formItem.ruleid_fixed.value;
	url += '&s_rewardstd='+formItem.rewardstd_fixed_limited.value;
	var rtn=window.showModalDialog(url , 1 , "dialogWidth=900px;dialogHeight=400px;status:no;scroll=yes;");
}
function doSaveCityWayEncourage(){
	var url ='<%=contextPath%>/cms/reward/stdrewardbj.do?CMD=SHOWCITYWAY';
	url += '&s_opnid='+formItem.opnid.value;
	url += '&s_rewardid='+formItem.rewardid_encourage.value;
	//�������Ĭ��acctypeΪ1
	url += '&s_acctype=1'; 
	url += '&s_ruleid='+formItem.ruleid_encourage.value;
	url += '&s_rewardstd='+formItem.rewardstd_encourage_limited.value;
	var rtn=window.showModalDialog(url , 1 , "dialogWidth=900px;dialogHeight=400px;status:no;scroll=yes;");
}
function doSaveCityWayAllowance(){
	var url ='<%=contextPath%>/cms/reward/stdrewardbj.do?CMD=SHOWCITYWAY';
	url += '&s_opnid='+formItem.opnid.value;
	url += '&s_rewardid='+formItem.rewardid_allowance.value;
	url += '&s_acctype=1';
	url += '&s_ruleid='+formItem.ruleid_allowance.value;
	url += '&s_rewardstd='+formItem.rewardstd_allowance_limited.value;
	var rtn=window.showModalDialog(url , 1 , "dialogWidth=900px;dialogHeight=400px;status:no;scroll=yes;");
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
			<html:form action="/cms/reward/stdrewardbj.do?CMD=SAVECITYCARD" styleId="formItem" method="post">
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
				<html:hidden property="rewardid_encourage" />
				<html:hidden property="rewardid_allowance" />
				<html:hidden property="fixedflag" />
				<html:hidden property="encourageflag" />
				<html:hidden property="allowanceflag" />
				<html:hidden property="rewardname_fixed" />
				<html:hidden property="rewardtype_fixed" />
				<html:hidden property="startdate_fixed" />
				<html:hidden property="stopdate_fixed" />
				<html:hidden property="ruleid_fixed" />
				<html:hidden property="rewardname_encourage" />
				<html:hidden property="rewardtype_encourage" />
				<html:hidden property="startdate_encourage" />
				<html:hidden property="stopdate_encourage" />
				<html:hidden property="ruleid_encourage" />
				<html:hidden property="rewardname_allowance" />
				<html:hidden property="rewardtype_allowance" />
				<html:hidden property="startdate_allowance" />
				<html:hidden property="stopdate_allowance" />
				<html:hidden property="ruleid_allowance" />
				<html:hidden property="rewardtype_fixed" />
				<html:hidden property="rewardtype_encourage" />
				<html:hidden property="rewardtype_allowance" />
				
				<html:hidden property="rewardstd_fixed_limited" />
				<html:hidden property="intvmonth_fixed_limited" />
				<html:hidden property="rewardstd_encourage_limited" />
				<html:hidden property="intvmonth_encourage_limited" />
				<html:hidden property="rewardstd_allowance_limited" />
				<html:hidden property="intvmonth_allowance_limited" />
				
				<html:hidden property="rowIndex" />
				
				<c:set var="edtState" scope="request" value="${!empty param.CMD and (param.CMD eq 'EDIT' or param.CMD eq 'NEW')}" />
				<c:set var="updateState" scope="request" value="${!empty param.CMD and (param.CMD eq 'EDIT')}" />

				<!--##################################��ӱ�������##################################################-->
				<div class="table_div">
					<table class="top_table">
						<tr>
							<td>
								<bean:message bundle="stdrewardbj" key="titleCityCard" />
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
								<input type="checkbox" id="fixedbox" value="" onclick="changeFixed(this);" disabled="disabled" class="table_checkbox">
								<bean:message bundle="stdrewardbj" key="fixedreward" />
								<input type="checkbox" id="encouragebox" value="" onclick="changeEncourage(this);" disabled="disabled" class="table_checkbox">
								<bean:message bundle="stdrewardbj" key="integralreward" />
								<input type="checkbox" id="allowancebox" value="" onclick="changeAllowance(this);" disabled="disabled" class="table_checkbox">
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
								<c:out value="${requestScope['/cms/reward/stdrewardbj/StdrewardbjForm'].rewardname_fixed}" />
							</td>
							<td width="20%" align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="stdrewardbj" key="rewardtype" />
									:
								</div>
							</td>
							<td width="30%" class="form_table_left">
								<s:Code2Name code="${requestScope['/cms/reward/stdrewardbj/StdrewardbjForm'].rewardtype_fixed}" definition="$CH_REWARDTYPE"/>
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
								<c:out value="${requestScope['/cms/reward/stdrewardbj/StdrewardbjForm'].startdate_fixed}" />
							</td>
							<td width="20%" align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="stdrewardbj" key="stopdate" />
									:
								</div>
							</td>
							<td width="30%" class="form_table_left">
								<c:out value="${requestScope['/cms/reward/stdrewardbj/StdrewardbjForm'].stopdate_fixed}" />
							</td>
						</tr>
						<tr>
							<td width="20%" align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="stdrewardbj" key="cityrewardstd" />
									:
								</div>
							</td>
							<td width="80%" colspan=3 class="form_table_left">
								<html:text styleClass="form_input_1x" property="rewardstd_fixed" maxlength="14" readonly="true"/>
								<font color=red>*</font>
								���"����׼����"��������
								<br/>
								<input type="button" class="button_8" value="����׼����" onclick="doSaveCityStarFix()"/>
								<input type="button" class="button_8" value="��׼������������" onclick="doSaveCityWayFix()"/>
							</td>
						</tr>
						<tr>
							<td width="20%" align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="stdrewardbj" key="intvmonth" />
									:
								</div>
							</td>
							<td width="80%" colspan=3 class="form_table_left">
								<html:text styleClass="form_input_1x" property="intvmonth_fixed" maxlength="5" />
								<font color=red>*</font>
								<bean:message bundle="stdrewardbj" key="intvexplain"/>
								(ʡ��˾����·�:<font color="red"><c:out value="${requestScope['/cms/reward/stdrewardbj/StdrewardbjForm'].intvmonth_fixed_limited}" /></font>)
							</td>
						</tr>
						<tr>
							<td width="20%" align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="stdrewardbj" key="ruleid" />
									:
								</div>
							</td>
							<td width="80%" colspan=3 class="form_table_left">
								<!--  <c:out value="${requestScope['/cms/reward/stdrewardbj/StdrewardbjForm'].ruleid_fixed}" />&nbsp;
								<s:Code2Name code="${requestScope['/cms/reward/stdrewardbj/StdrewardbjForm'].ruleid_fixed}" definition="#CH_ADT_RULE"/>  
								-->
								<html:text styleClass="form_input_1x" property="ruleid_fixed" readonly="true"/>
								<input type="button" value="..." class="clickButton" onclick="doShowRule('ruleid_fixed')" >
								<font color=red>*</font>
							</td>
						</tr>
					</table>
				</div>

				<!-- integralreward -->
				<div class="table_div" id="encouragereward">
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
								<c:if test="${requestScope.EDIT eq 'LOAD' or requestScope.EDIT eq 'TRUE' }">
									<c:out value="${requestScope['/cms/reward/stdrewardbj/StdrewardbjForm'].rewardname_encourage}" />
								</c:if>
							</td>
							<td width="20%" align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="stdrewardbj" key="rewardtype" />
									:
								</div>
							</td>
							<td width="30%" class="form_table_left">
								<c:if test="${requestScope.EDIT eq 'LOAD' or requestScope.EDIT eq 'TRUE' }">
									<s:Code2Name code="${requestScope['/cms/reward/stdrewardbj/StdrewardbjForm'].rewardtype_encourage}" definition="$CH_REWARDTYPE"/>
								</c:if>
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
								<c:if test="${requestScope.EDIT eq 'LOAD' or requestScope.EDIT eq 'TRUE' }">
									<c:out value="${requestScope['/cms/reward/stdrewardbj/StdrewardbjForm'].startdate_encourage}" />
								</c:if>
							</td>
							<td width="20%" align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="stdrewardbj" key="stopdate" />
									:
								</div>
							</td>
							<td width="30%" class="form_table_left">
								<c:if test="${requestScope.EDIT eq 'LOAD' or requestScope.EDIT eq 'TRUE' }">
									<c:out value="${requestScope['/cms/reward/stdrewardbj/StdrewardbjForm'].stopdate_encourage}" />
								</c:if>
							</td>
						</tr>
						<tr>
							<td width="20%" align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="stdrewardbj" key="cityrewardstd" />
									:
								</div>
							</td>
							<td width="80%" colspan=3 class="form_table_left">
								<c:if test="${requestScope.EDIT eq 'LOAD' or requestScope.EDIT eq 'TRUE' }">
									<html:text styleClass="form_input_1x" property="rewardstd_encourage" maxlength="14" readonly="true"/>
									<font color=red>*</font>
									���"����׼����"��������
									<br/>
									<input type="button" class="button_8" value="����׼����" onclick="doSaveCityStarEncourage()"/>
									<input type="button" class="button_8" value="��׼������������" onclick="doSaveCityWayEncourage()"/>
								</c:if>
							</td>
						</tr>
						<tr>
							<td width="20%" align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="stdrewardbj" key="intvmonth" />
									:
								</div>
							</td>
							<td width="80%" colspan=3 class="form_table_left">
								<c:if test="${requestScope.EDIT eq 'LOAD' or requestScope.EDIT eq 'TRUE' }">
									<html:text styleClass="form_input_1x" property="intvmonth_encourage" maxlength="5" />
									<font color=red>*</font>
									<bean:message bundle="stdrewardbj" key="intvexplain"/>
									(ʡ��˾����·�:<font color="red"><c:out value="${requestScope['/cms/reward/stdrewardbj/StdrewardbjForm'].intvmonth_encourage_limited}" /></font>)
								</c:if>
							</td>
						</tr>
						<tr>
							<td width="20%" align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="stdrewardbj" key="ruleid" />
									:
								</div>
							</td>
							<td width="80%" colspan=3 class="form_table_left">
								<c:if test="${requestScope.EDIT eq 'LOAD' or requestScope.EDIT eq 'TRUE' }">
									<c:out value="${requestScope['/cms/reward/stdrewardbj/StdrewardbjForm'].ruleid_encourage}" />&nbsp;
									<s:Code2Name code="${requestScope['/cms/reward/stdrewardbj/StdrewardbjForm'].ruleid_encourage}" definition="#CH_ADT_RULE"/>
								</c:if>
							</td>
						</tr>
					</table>
					
					<!-- button list, NEW and SAVE and DELETE -->
					<table class="table_button_list">
						<tr>
							<td>
							<s:RewardPurChk controlid="<%=ID_2%>">
								<input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);" name="btnNewOne"
									onfocus="buttonover(this)" onblur="buttonout(this)" value="<bean:message bundle="stdrewardbj" key="load"/>"
									class="submit" onclick="doLoadCityEncourage()" />
							</s:RewardPurChk>
							<s:RewardPurChk controlid="<%=ID_2%>">
								<input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);" name="btnSaveOne"
									onfocus="buttonover(this)" onblur="buttonout(this)" value="<bean:message bundle="public" key="button_save"/>"
									class="submit" onclick="doSaveCityEncourage()" disabled="disabled" />
							</s:RewardPurChk>
							<s:RewardPurChk controlid="<%=ID_2%>">
								<input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);" name="btnDeleteOne"
									onfocus="buttonover(this)" onblur="buttonout(this)" value="<bean:message bundle="public" key="button_delete"/>"
									class="submit" onclick="doDelCityEncourage()" />
							</s:RewardPurChk>
							</td>
						</tr>
					</table>
					
					<!-- encourage reward list -->
					<table class="table_style" ID="Table2">
						<tr class="table_style_head">
							<td title="<bean:message bundle="public" key="list_title_select"/>">
								<input type="checkbox" name="allbox" onclick="checkAll('formItem');" class="table_checkbox">
							</td>
							<td>
								<bean:message bundle="stdrewardbj" key="rewardname" />
							</td>
							<td>
								<bean:message bundle="stdrewardbj" key="startdate" />
							</td>
							<td>
								<bean:message bundle="stdrewardbj" key="stopdate" />
							</td>
							<td>
								<bean:message bundle="stdrewardbj" key="encouragestd" />
							</td>
							<td>
								<bean:message bundle="stdrewardbj" key="intvmonth" />
							</td>
							<td>
								<bean:message bundle="stdrewardbj" key="ruleid" />
							</td>
							<s:PurChk2 controlid="<%=ID_2%>">
							<td>
								<bean:message bundle="stdrewardbj" key="operate" />
							</td>
							</s:PurChk2>
						</tr>
						<c:forEach var="item" items="${requestScope.LIST}" varStatus="rowid">
							<c:url value="/cms/reward/stdrewardbj.do?CMD=EDITCITYENCOURAGE" var="urlContent">
								<c:param name="PK" value="${item.rewardid}|${item.temprewardid}" />
								<c:param name="ROWINDEX" value="${rowid.index}" />
							</c:url>
							<tr class="table_style_content" align="center" onclick="selectLine = this.rowIndex;">
								<td>
									<input type="checkbox" name="_selectitem" value="<c:out value='${item.rewardid}|${item.temprewardid}' />" onclick="checkOne('formItem');"
										class="table_checkbox">
								</td>
								<td>
									<c:out value="${item.rewardname}" />
								</td>
								<td>
									<fmt:formatDate pattern="yyyy-MM-dd" value="${item.startdate}" />
								</td>
								<td>
									<fmt:formatDate pattern="yyyy-MM-dd" value="${item.stopdate}" />
								</td>
								<td>
									<c:out value="${item.rewardstd}" />
								</td>
								<td>
									<c:out value="${item.intvmonth}" />
								</td>
								<td>
									<c:out value="${item.ruleid}" />&nbsp;
									<s:Code2Name code="${item.ruleid}" definition="#CH_ADT_RULE"/>
								</td>
								<s:PurChk2 controlid="<%=ID_2%>">
								<td>
									<a href='#' onclick="doEditCityEncourage('<c:out value="${urlContent}"/>');return false;" target="_self"><bean:message bundle="stdrewardbj" key="edit" /></a>
								</td>
								</s:PurChk2>
							</tr>
						</c:forEach>
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
								<c:out value="${requestScope['/cms/reward/stdrewardbj/StdrewardbjForm'].rewardname_allowance}" />
							</td>
							<td width="20%" align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="stdrewardbj" key="rewardtype" />
									:
								</div>
							</td>
							<td width="30%" class="form_table_left">
								<s:Code2Name code="${requestScope['/cms/reward/stdrewardbj/StdrewardbjForm'].rewardtype_allowance}" definition="$CH_REWARDTYPE"/>
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
								<c:out value="${requestScope['/cms/reward/stdrewardbj/StdrewardbjForm'].startdate_allowance}" />
							</td>
							<td width="20%" align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="stdrewardbj" key="stopdate" />
									:
								</div>
							</td>
							<td width="30%" class="form_table_left">
								<c:out value="${requestScope['/cms/reward/stdrewardbj/StdrewardbjForm'].stopdate_allowance}" />
							</td>
						</tr>
						<tr>
							<td width="20%" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="stdrewardbj" key="cityrewardstd" />
									:
								</div>
							</td>
							<td width="80%" colspan=3 class="form_table_left">
								<html:text styleClass="form_input_1x" property="rewardstd_allowance" maxlength="14" readonly="true"/>
								<font color=red>*</font>
								���"����׼����"��������
								<br/>
								<input type="button" class="button_8" value="����׼����" onclick="doSaveCityStarAllowance()"/>
								<input type="button" class="button_8" value="��׼������������" onclick="doSaveCityWayAllowance()"/>
							</td>
						</tr>
						<tr>
							<td width="20%" align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="stdrewardbj" key="intvmonth" />
									:
								</div>
							</td>
							<td width="80%" colspan=3 class="form_table_left">
								<html:text styleClass="form_input_1x" property="intvmonth_allowance" maxlength="5" />
								<font color=red>*</font>
								<bean:message bundle="stdrewardbj" key="intvexplain"/>
								(ʡ��˾����·�:<font color="red"><c:out value="${requestScope['/cms/reward/stdrewardbj/StdrewardbjForm'].intvmonth_allowance_limited}" /></font>)
							</td>
						</tr>
						<tr>
							<td width="20%" align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="stdrewardbj" key="ruleid" />
									:
								</div>
							</td>
							<td width="80%" colspan=3 class="form_table_left">
								<c:out value="${requestScope['/cms/reward/stdrewardbj/StdrewardbjForm'].ruleid_allowance}" />&nbsp;
								<s:Code2Name code="${requestScope['/cms/reward/stdrewardbj/StdrewardbjForm'].ruleid_allowance}" definition="#CH_ADT_RULE"/>
							</td>
						</tr>
					</table>
				</div>

				<div class="table_div">
					<table>
						<tr>
							<td>
								<s:PurChk2 controlid="<%=ID_2%>">
								<input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);" name="btnSave"
									onfocus="buttonover(this)" onblur="buttonout(this)" value="<bean:message bundle="public" key="button_save"/>"
									class="submit" onclick="doSaveCityCard()" />							
								</s:PurChk2>
								
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

if (formItem.encourageflag.value == 'true') {
	document.getElementById("encouragebox").checked = true;
	document.getElementById("encouragereward").style.display = "";
} else {
	document.getElementById("encouragebox").checked = false;
	document.getElementById("encouragereward").style.display = "none";
}

if (formItem.allowanceflag.value == 'true') {
	document.getElementById("allowancebox").checked = true;
	document.getElementById("allowancereward").style.display = "";
} else {
	document.getElementById("allowancebox").checked = false;
	document.getElementById("allowancereward").style.display = "none";
}
if ('<%= EDIT %>' == 'TRUE' || '<%= EDIT %>' == 'LOAD') {
	if (typeof formItem.btnSaveOne == 'object') {
		formItem.btnSaveOne.disabled = "";
	}
	if (typeof formItem.btnNewOne == 'object') {
		formItem.btnNewOne.disabled = "disabled";
	}
}
</script>
	</body>
</html>
