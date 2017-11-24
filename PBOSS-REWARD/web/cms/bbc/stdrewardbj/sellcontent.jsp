<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/contenthead.inc"%>
<%@ page import="com.sunrise.boss.ui.commons.WebConstant"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%
String ID_1 = "CH_B2M_REWARD||CH_B2M_REWARD_PROVINCIAL"; //省级酬金管理令牌
String ID_2 = "CH_B2M_REWARD||CH_B2M_REWARD_CIVIC"; //市级酬金管理令牌
String EDIT = (String) request.getAttribute(WebConstant.COMMAND_STRING_EDIT);
%>

<html>
	<head>
		<title><bean:message bundle="stdrewardbj" key="titleData" />
		</title>
<script type="text/javascript" src="<%=contextPath%>/js/pub/list.js"></script>
<script language="JavaScript">
function reloadforiframe() {
	if (parent.document.all("loadframe") != null) {
		parent.document.all("loadframe").style.posHeight = document.body.scrollHeight+200;
	}
	if (parent.document.all("IFRM_MAIN") != null) {
		parent.document.all("IFRM_MAIN").style.posHeight = document.body.scrollHeight+200;
	}
}
function ev_checkval() {
	if (formItem.basicflag.value != 'true' && formItem.encourageflag.value != 'true') {
		alert("业务对应酬金为空，要求至少选择一种酬金，请在对应选框中打勾");
		return;
	}
	if (formItem.basicflag.value == 'true') {
		addfield('rewardname_basic', '<bean:message bundle="bbcstdrewardbj" key="rewardname"/>', 'c', false, '40');
		addfield('startdate_basic', '<bean:message bundle="bbcstdrewardbj" key="startdate"/>', 't', false, '10');
		addfield('stopdate_basic', '<bean:message bundle="bbcstdrewardbj" key="stopdate"/>', 't', false, '10');
		addfield('ruleid_basic', '<bean:message bundle="bbcstdrewardbj" key="ruleid"/>', 'c', false, '18');
		addfield('rewardstd_basic', '<bean:message bundle="bbcstdrewardbj" key="rewardstd_scale"/>', 'd', false, '14','4');
		if(date_compare("startdate_basic","stopdate_basic",'<bean:message bundle="bbcstdrewardbj" key="timeCompare_basic"/>')) return;
	}
	return checkval(window);
}

function ev_checkvalEccourage() {
	addfield('rewardname_encourage', '<bean:message bundle="bbcstdrewardbj" key="rewardname"/>', 'c', false, '40');
	addfield('startdate_encourage', '<bean:message bundle="bbcstdrewardbj" key="startdate"/>', 't', false, '10');
	addfield('stopdate_encourage', '<bean:message bundle="bbcstdrewardbj" key="stopdate"/>', 't', false, '10');
	addfield('ruleid_encourage', '<bean:message bundle="bbcstdrewardbj" key="ruleid"/>', 'c', false, '18');
	addfield('intvmonth_encourage', '<bean:message bundle="bbcstdrewardbj" key="intvmonth"/>', 'i', false, '5');
	addfield('rewardstd_encourage', '<bean:message bundle="bbcstdrewardbj" key="rewardstd"/>', 'd', false, '14','4');
	if(date_compare("startdate_encourage","stopdate_encourage",'<bean:message bundle="bbcstdrewardbj" key="timeCompare_encourage"/>')) return;
	return checkval(window);
}

function changeBasic(obj) {
	reloadforiframe();
	if (obj.checked == true) {
		formItem.basicflag.value = true;
		document.getElementById("basicreward").style.display=""; //显示
	} else {
		formItem.basicflag.value = false;
		document.getElementById("basicreward").style.display="none"; //隐藏
	}
}

function changeEncourage(obj) {
	reloadforiframe();
	if (obj.checked == true) {
		formItem.encourageflag.value = true;
		document.getElementById("encouragereward").style.display=""; //显示
	} else {
		formItem.encourageflag.value = false;
		document.getElementById("encouragereward").style.display="none"; //隐藏
	}
}

function doNewEncourage() {
	if (ev_checkvalEccourage()) {
		var url = contextPath + '/cms/bbc/stdrewardbj.do?CMD=NEWENCOURAGE';
		formItem.action = url;
		formItem.submit();
	}
}

function doSaveEncourage() {
	if (ev_checkvalEccourage()) {
		var url = contextPath + '/cms/bbc/stdrewardbj.do?CMD=SAVEENCOURAGE';
		formItem.action = url;
		formItem.submit();
	}
}

var msgNoSelected= "<bean:message bundle="public" key="msgNoSelected"/>";
var msgConfirmDelete= "<bean:message bundle="public" key="msgConfirmDelete"/>";
function doDelEncourage() {
	if (ev_checkval()) {
		var TO = true;
		var sis = formItem.all("_selectitem");
		if (forincheck(TO,sis,msgConfirmDelete)) {
			var url = contextPath + '/cms/bbc/stdrewardbj.do?CMD=DELENCOURAGE';
			formItem.action = url;
			formItem.submit();
		}
	}
}

function doSaveData() {
	if (ev_checkval()) {
		var url = contextPath + '/cms/bbc/stdrewardbj.do?CMD=SAVEDATA';
		formItem.action = url;
		formItem.submit();
	}
}

function doEditEncourage(url) {
	formItem.action = url;
	formItem.submit();
}

function doReturn(url) {
	window.parent.document.location = contextPath + url;
}

function doShowRule(id) {
	var urlForPrint = contextPath + '/cms/reward/rule2.do?CMD=SELECTBBCRULE&PK=' + formItem.opnid.value;
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
			<html:form action="/cms/bbc/stdrewardbj.do?CMD=SAVE" styleId="formItem" method="post">
				<html:hidden property="cmdState" />
				<html:hidden property="_orderby" />
				<html:hidden property="_desc" />
				<html:hidden property="_pageno" />
				<html:hidden property="_pagesize" />
				<html:hidden property="opnid" />
				<html:hidden property="opnname" />
				<html:hidden property="busibelong" />
				<html:hidden property="opnstate" />
				<html:hidden property="rewardid_basic" />
				<html:hidden property="rewardid_encourage" />
				<html:hidden property="basicflag" />
				<html:hidden property="encourageflag" />
				<html:hidden property="rewardtype_encourage" />
				<html:hidden property="rewardtype_basic" />
				<html:hidden property="rewardproj" value="1" />
				<html:hidden property="rewardname_encourage_temp" />
				<html:hidden property="ossrc" />
				
				<c:set var="edtState" scope="request" value="${!empty param.CMD and (param.CMD eq 'EDIT' or param.CMD eq 'NEW')}" />
				<c:set var="updateState" scope="request" value="${!empty param.CMD and (param.CMD eq 'EDIT')}" />
				<c:set var="form" scope="request" value="${requestScope['/cms/bbc/stdrewardbj/BBCstdrewardbjForm']}" />	
				<!--##################################添加标题内容##################################################-->
				<div class="table_div">
					<table class="top_table">
						<tr>
							<td>
								<bean:message bundle="bbcstdrewardbj" key="titleData" />
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
									<font color=blue><bean:message bundle="bbcstdrewardbj" key="businessinfo" /> </font>
								</div>
							</td>
						</tr>
						<tr>
							<td width="25%" align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="bbcstdrewardbj" key="opnid" />
									:
								</div>
							</td>
							<td width="25%" align="left" class="form_table_left">
								<c:out value="${form.opnid}" />
							</td>
							<td width="25%" align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="bbcstdrewardbj" key="opnname" />
									:
								</div>
							</td>
							<td width="25%" align="left" class="form_table_left">
								<c:out value="${form.opnname}" />
							</td>
						</tr>
						<tr>
							<td width="25%" align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="bbcstdrewardbj" key="busibelong" />
									:
								</div>
							</td>
							<td width="25%" align="left" class="form_table_left">
								<s:Code2Name code="${form.busibelong}" definition="#CH_BBCCBBUSIBELONG" />
							</td>
							<td width="25%" align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="bbcstdrewardbj" key="state" />
									:
								</div>
							</td>
							<td width="25%" align="left" class="form_table_left">
								<s:Code2Name code="${form.opnstate}" definition="$CH_VALIDFLAG"/>
							</td>
						</tr>
						<tr>
							<td width="25%" align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="bbcstdrewardbj" key="busireward" />
									:
								</div>
							</td>
							<td width="75%" colspan=3 class="form_table_left">
								<input type="checkbox" id="basicbox" value="" onclick="changeBasic(this);" class="table_checkbox">
								<bean:message bundle="bbcstdrewardbj" key="basicreward" />
								<input type="checkbox" id="encouragebox" value="" onclick="changeEncourage(this);" class="table_checkbox">
								<bean:message bundle="bbcstdrewardbj" key="encouragereward" />
							</td>
						</tr>
					</table>
				</div>

				<!-- basic reward -->
				<div class="table_div" id="basicreward">
					<table class="form_table">
						<tr>
							<td width="100%" colspan=4 class="form_table_left">
								<div class="field-require">
									<font color=blue><bean:message bundle="bbcstdrewardbj" key="basicreward" /> </font>
									<bean:message bundle="bbcstdrewardbj" key="remind" />
								</div>
							</td>
						</tr>
						<tr>
							<td width="20%" align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="bbcstdrewardbj" key="rewardname" />
									:
								</div>
							</td>
							<td width="30%" class="form_table_left">
								<html:text styleClass="form_input_1x" property="rewardname_basic" maxlength="40" />
								<font color=red>*</font>
							</td>
							<td width="20%" align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="bbcstdrewardbj" key="rewardtype" />
									:
								</div>
							</td>
							<td width="30%" class="form_table_left">
								<s:Code2Name code="${form.rewardtype_basic}" definition="$CH_BBCREWARDTYPE"/>
								<font color=red>*</font>
							</td>
						</tr>
						<tr>
							<td width="20%" align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="bbcstdrewardbj" key="startdate" />
									:
								</div>
							</td>
							<td width="30%" class="form_table_left">
								<html:text styleClass="form_input_1x" property="startdate_basic" readonly="true"
									onclick="this.value=selectDate();" />
								<font color=red>*</font>
							</td>
							<td width="20%" align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="bbcstdrewardbj" key="stopdate" />
									:
								</div>
							</td>
							<td width="30%" class="form_table_left">
								<html:text styleClass="form_input_1x" property="stopdate_basic" readonly="true"
									onclick="this.value=selectDate();" />
								<font color=red>*</font>
							</td>
						</tr>
						<tr>
							<td width="20%" align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="bbcstdrewardbj" key="acctype" />
									:
								</div>
							</td>
							<td width="30%" class="form_table_left">
								<html:radio property="acctype_basic" value="1"></html:radio>
								<bean:message bundle="bbcstdrewardbj" key="acctype_num" />
								<html:radio property="acctype_basic" value="2"></html:radio>
								<bean:message bundle="bbcstdrewardbj" key="acctype_scale" />
								<font color=red>&nbsp;*</font>
							</td>
							<td width="20%" align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="bbcstdrewardbj" key="rewardstd_scale" />
									:
								</div>
							</td>
							<td width="30%" class="form_table_left">
								<html:text styleClass="form_input_1x" property="rewardstd_basic" maxlength="14" />
								<font color=red>*</font>
							</td>
						</tr>
						<tr>
							<td width="20%" class="form_table_right">
								备注
								:
							</td>
							<td width="80%" colspan=3 class="form_table_left">
								如果选择计酬方式为<font color="blue">按笔数计算</font>,举例填酬金上限<font color="blue">22元</font>则应该填<font color="blue">22</font><br>
								如果选择计酬方式为<font color="blue">按比例计算</font>,举例填酬金上限<font color="blue">22%</font>则应该填<font color="blue">0.22</font>
							</td>
						</tr>
						<tr>
							<td width="20%" align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="bbcstdrewardbj" key="ruleid" />
									:
								</div>
							</td>
							<td width="30%" class="form_table_left">
								<html:text styleClass="form_input_1x" property="ruleid_basic" readonly="true"/>
								<input type="button" value="..." class="clickButton" onclick="doShowRule('ruleid_basic')" >
								<font color=red>*</font>
							</td>
							<td width="20%" align="right" class="form_table_right">
							</td>
							<td width="30%" class="form_table_left">
							</td>
						</tr>
					</table>
				</div>

				<!-- encourage reward -->
				<div class="table_div" id="encouragereward">
					<table class="form_table">
						<tr>
							<td width="100%" colspan=4 class="form_table_left">
								<div class="field-require">
									<font color=blue><bean:message bundle="bbcstdrewardbj" key="encouragereward" /> </font>
									<bean:message bundle="bbcstdrewardbj" key="remind" />
								</div>
							</td>
						</tr>
						<tr>
							<td width="20%" align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="bbcstdrewardbj" key="rewardname" />
									:
								</div>
							</td>
							<td width="30%" class="form_table_left">
								<html:text styleClass="form_input_1x" property="rewardname_encourage" maxlength="40" />
								<font color=red>*</font>
							</td>
							<td width="20%" align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="bbcstdrewardbj" key="rewardtype" />
									:
								</div>
							</td>
							<td width="30%" class="form_table_left">
								<s:Code2Name code="${form.rewardtype_encourage}" definition="$CH_BBCREWARDTYPE"/>
								<font color=red>*</font>
							</td>
						</tr>
						<tr>
							<td width="20%" align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="bbcstdrewardbj" key="startdate" />
									:
								</div>
							</td>
							<td width="30%" class="form_table_left">
								<html:text styleClass="form_input_1x" property="startdate_encourage" readonly="true"
									onclick="this.value=selectDate();" />
								<font color=red>*</font>
							</td>
							<td width="20%" align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="bbcstdrewardbj" key="stopdate" />
									:
								</div>
							</td>
							<td width="30%" class="form_table_left">
								<html:text styleClass="form_input_1x" property="stopdate_encourage" readonly="true"
									onclick="this.value=selectDate();" />
								<font color=red>*</font>
							</td>
						</tr>
						<tr>
							<td width="20%" align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="bbcstdrewardbj" key="rewardstd" />
									:
								</div>
							</td>
							<td width="30%" class="form_table_left">
								<html:text styleClass="form_input_1x" property="rewardstd_encourage" maxlength="14" />
								<font color=red>*</font>
							</td>
							<td width="20%" align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="bbcstdrewardbj" key="intvmonth" />
									:
								</div>
							</td>
							<td width="30%" class="form_table_left">
								<html:text styleClass="form_input_1x" property="intvmonth_encourage" />
								<font color=red>*</font>
							</td>
						</tr>

						<tr>
							<td width="20%" align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="bbcstdrewardbj" key="ruleid" />
									:
								</div>
							</td>
							<td width="30%" class="form_table_left">
								<html:text styleClass="form_input_1x" property="ruleid_encourage" readonly="true"/>
								<input type="button" value="..." class="clickButton" onclick="doShowRule('ruleid_encourage')" >
								<font color=red>*</font>
							</td>
							<td width="20%" align="right" class="form_table_right"></td>
							<td width="30%" class="form_table_left"></td>
						</tr>
					</table>

					<!-- button list, NEW and SAVE and DELETE -->
					<table class="table_button_list">
						<tr>
							<td>
							<s:RewardPurChk controlid="<%=ID_1%>" disableChild="true">
								<input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);" name="btnNewOne"
									onfocus="buttonover(this)" onblur="buttonout(this)" value="<bean:message bundle="public" key="button_new"/>"
									class="submit" onclick="doNewEncourage()" />
								<input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);" name="btnSaveOne"
									onfocus="buttonover(this)" onblur="buttonout(this)" value="<bean:message bundle="public" key="button_save"/>"
									class="submit" onclick="doSaveEncourage()" disabled="disabled" />
								<input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);" name="btnDeleteOne"
									onfocus="buttonover(this)" onblur="buttonout(this)" value="<bean:message bundle="public" key="button_delete"/>"
									class="submit" onclick="doDelEncourage()" />
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
								<bean:message bundle="bbcstdrewardbj" key="rewardname" />
							</td>
							<td>
								<bean:message bundle="bbcstdrewardbj" key="startdate" />
							</td>
							<td>
								<bean:message bundle="bbcstdrewardbj" key="stopdate" />
							</td>
							<td>
								<bean:message bundle="bbcstdrewardbj" key="encouragestd" />
							</td>
							<td>
								<bean:message bundle="bbcstdrewardbj" key="intvmonth" />
							</td>
							<td>
								<bean:message bundle="bbcstdrewardbj" key="ruleid" />
							</td>
							<s:RewardPurChk controlid="<%=ID_1%>">
							<td>
								<bean:message bundle="bbcstdrewardbj" key="operate" />
							</td>
							</s:RewardPurChk>
						</tr>
						<c:forEach var="item" items="${requestScope.LIST}">
							<c:url value="/cms/bbc/stdrewardbj.do?CMD=EDITENCOURAGE" var="urlContent">
								<c:param name="PK" value="${item.rewardid}|${item.temprewardid}" />
							</c:url>
							<tr class="table_style_content" align="center">
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
									<s:Code2Name code="${item.ruleid}" definition="#CH_ADT_RULE"/>
								</td>
								<s:RewardPurChk controlid="<%=ID_1%>">
								<td>
									<a href='#' onclick="doEditEncourage('<c:out value="${urlContent}"/>');return false;" target="_self"><bean:message bundle="bbcstdrewardbj" key="edit" /></a>
								</td>
								</s:RewardPurChk>
							</tr>
						</c:forEach>
					</table>
				</div>

				<!-- button list, SAVE and BACK  -->
				<div class="table_div">
					<table>
						<tr>
							<td>
							<s:RewardPurChk controlid="<%=ID_1%>" disableChild="true">
								<input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);" name="btnSave"
									onfocus="buttonover(this)" onblur="buttonout(this)" value="<bean:message bundle="public" key="button_save"/>"
									class="submit" onclick="doSaveData()" />
							</s:RewardPurChk>
								<input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);" name="btnReturn"
									onfocus="buttonover(this)" onblur="buttonout(this)" value="<bean:message bundle="public" key="button_return"/>"
									class="close" onclick="doReturn('/cms/bbc/operation.do?CMD=LIST')">
							</td>
						</tr>
					</table>
				</div>
			</html:form>
		</div>
		<script language="JavaScript">
if (formItem.basicflag.value == 'true') {
	document.getElementById("basicbox").checked = true;
	document.getElementById("basicreward").style.display = "";
} else {
	document.getElementById("basicbox").checked = false;
	document.getElementById("basicreward").style.display = "none";
}

if (formItem.encourageflag.value == 'true') {
	document.getElementById("encouragebox").checked = true;
	document.getElementById("encouragereward").style.display = "";
} else {
	document.getElementById("encouragebox").checked = false;
	document.getElementById("encouragereward").style.display = "none";
}
if ('<%= EDIT %>' == 'TRUE') {
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
