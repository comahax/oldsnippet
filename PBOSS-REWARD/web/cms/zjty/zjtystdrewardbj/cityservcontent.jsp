<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/contenthead.inc"%>
<%@ page import="com.sunrise.boss.ui.commons.WebConstant"%>

<%
String ID_1 = "CH_ZJTY_REWARD||CH_ZJTY_PROVINCIAL"; //省级酬金管理令牌
String ID_2 = "CH_ZJTY_REWARD||CH_ZJTY_CIVIC"; //市级酬金管理令牌
String EDIT = (String) request.getAttribute(WebConstant.COMMAND_STRING_EDIT);
%>

<html>
	<head>
		<title><bean:message bundle="zjtystdrewardbj" key="titleCityServ" /></title>
<script type="text/javascript" src="<%=contextPath%>/js/pub/list.js"></script>
<script type="text/javascript" src="<%= contextPath %>/js/bus/waycommon.js"></script>
<script type="text/javascript" src="<%= contextPath%>/js/bus/rescommon.js"></script>
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
	addfield('wayid', '<bean:message bundle="zjtystdrewardbj" key="wayid"/>', 'c', false, '32');
	if (formItem.basicflag.value == 'true') {
		addfield('rewardname_basic', '<bean:message bundle="zjtystdrewardbj" key="rewardname"/>', 'c', false, '80');
		addfield('startdate_basic', '<bean:message bundle="zjtystdrewardbj" key="startdate"/>', 't', false, '10');
		addfield('stopdate_basic', '<bean:message bundle="zjtystdrewardbj" key="stopdate"/>', 't', false, '10');
		addfield('ruleid_basic', '<bean:message bundle="zjtystdrewardbj" key="ruleid"/>', 'c', false, '18');
		addfield('rewardstd_basic', '<bean:message bundle="zjtystdrewardbj" key="rewardstd"/>', 'd', false, '12','2','','0',formItem.rewardstd_basic_limited.value);
		addfield('intvmonth_basic', '<bean:message bundle="zjtystdrewardbj" key="intvmonth"/>', 'i', false, '5','','','0');
	}
	return checkval(window);
}

function ev_checkvalEccourage() {
	addfield('rewardname_encourage', '<bean:message bundle="zjtystdrewardbj" key="rewardname"/>', 'c', false, '80');
	addfield('startdate_encourage', '<bean:message bundle="zjtystdrewardbj" key="startdate"/>', 't', false, '10');
	addfield('stopdate_encourage', '<bean:message bundle="zjtystdrewardbj" key="stopdate"/>', 't', false, '10');
	addfield('ruleid_encourage', '<bean:message bundle="zjtystdrewardbj" key="ruleid"/>', 'c', false, '18');
	addfield('intvmonth_encourage', '<bean:message bundle="zjtystdrewardbj" key="intvmonth"/>', 'i', false, '5','','','0');
	addfield('rewardstd_encourage', '<bean:message bundle="zjtystdrewardbj" key="rewardstd"/>', 'd', false, '12','2','','0',formItem.rewardstd_encourage_limited.value);
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
	loadforiframe();
	if (obj.checked == true) {
		formItem.encourageflag.value = true;
		document.getElementById("encouragereward").style.display=""; //显示
	} else {
		formItem.encourageflag.value = false;
		document.getElementById("encouragereward").style.display="none"; //隐藏
	}
}

function doSaveCityEncourage() {
	if (ev_checkvalEccourage()) {
		var url = contextPath + '/cms/zjty/stdrewardbj.do?CMD=SAVECITYENCOURAGE';
		formItem.action = url;
		formItem.submit();
	}
}

function doSaveCityData() {
	if (ev_checkval()) {
		enable();
		var url = contextPath + '/cms/zjty/stdrewardbj.do?CMD=SAVECITYDATA';
		formItem.action = url;
		formItem.submit();
	}
}

function doEditCityEncourage(url) {
	formItem.action = url;
	formItem.submit();
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
			<html:form action="/cms/zjty/stdrewardbj.do?CMD=SAVECITYDATA" styleId="formItem" method="post">
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
				<html:hidden property="rewardname_basic" />
				<html:hidden property="rewardtype_basic" />
				<html:hidden property="startdate_basic" />
				<html:hidden property="stopdate_basic" />
				<html:hidden property="ruleid_basic" />
				<html:hidden property="rewardname_encourage" />
				<html:hidden property="rewardtype_encourage" />
				<html:hidden property="startdate_encourage" />
				<html:hidden property="stopdate_encourage" />
				<html:hidden property="ruleid_encourage" />
				<html:hidden property="rewardtype_basic" />
				<html:hidden property="rewardtype_encourage" />
				<html:hidden property="rewardname_encourage_temp" />
				
				<html:hidden property="rewardstd_encourage_limited" />
				<html:hidden property="rewardstd_basic_limited" />
				
				<c:set var="edtState" scope="request" value="${!empty param.CMD and (param.CMD eq 'EDIT' or param.CMD eq 'NEW')}" />
				<c:set var="updateState" scope="request" value="${!empty param.CMD and (param.CMD eq 'EDIT')}" />

				<!--##################################添加标题内容##################################################-->
				<div class="table_div">
					<table class="top_table">
						<tr>
							<td>
								<bean:message bundle="zjtystdrewardbj" key="titleCityServ" />
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
									<font color=blue><bean:message bundle="zjtystdrewardbj" key="businessinfo" /> </font>
								</div>
							</td>
						</tr>
						<tr>
							<td width="20%" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="zjtystdrewardbj" key="opnid" />
									:
								</div>
							</td>
							<td width="30%" align="left" class="form_table_left">
								<c:out value="${requestScope['/cms/zjty/zjtystdrewardbj/ZjtyStdrewardbjForm'].opnid}" />
							</td>
							<td width="25%" class="form_table_right">
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
							<td width="20%" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="zjtystdrewardbj" key="busibelong" />
									:
								</div>
							</td>
							<td width="30%" align="left" class="form_table_left">
								<s:Code2Name code="${requestScope['/cms/zjty/zjtystdrewardbj/ZjtyStdrewardbjForm'].busibelong}" definition="#CH_ZJTY_BUSIBELONG" />
							</td>
							<td width="25%" class="form_table_right">
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
							<td width="20%" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="zjtystdrewardbj" key="busireward" />
									:
								</div>
							</td>
							<td width="80%" colspan=3 class="form_table_left">
								<input type="checkbox" id="basicbox" value="" onclick="changeBasic(this);"  disabled="disabled" class="table_checkbox">
								<bean:message bundle="zjtystdrewardbj" key="basicreward" />
								<input type="checkbox" id="encouragebox" value="" onclick="changeEncourage(this);"  disabled="disabled" class="table_checkbox">
								<bean:message bundle="zjtystdrewardbj" key="encouragereward" />
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
									<font color=blue><bean:message bundle="zjtystdrewardbj" key="basicreward" /> </font>
									<bean:message bundle="zjtystdrewardbj" key="remind" />
								</div>
							</td>
						</tr>
						<tr>
							<td width="20%" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="zjtystdrewardbj" key="rewardname" />
									:
								</div>
							</td>
							<td width="30%" class="form_table_left">
								<c:out value="${requestScope['/cms/zjty/zjtystdrewardbj/ZjtyStdrewardbjForm'].rewardname_basic}" />
							</td>
							<td width="25%" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="zjtystdrewardbj" key="rewardtype" />
									:
								</div>
							</td>
							<td width="25%" class="form_table_left">
								<s:Code2Name code="${requestScope['/cms/zjty/zjtystdrewardbj/ZjtyStdrewardbjForm'].rewardtype_basic}" definition="#CH_ZJTY_REWARDTYPE"/>
							</td>
						</tr>
						<tr>
							<td width="20%" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="zjtystdrewardbj" key="startdate" />
									:
								</div>
							</td>
							<td width="30%" class="form_table_left">
								<c:out value="${requestScope['/cms/zjty/zjtystdrewardbj/ZjtyStdrewardbjForm'].startdate_basic}" />
							</td>
							<td width="25%" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="zjtystdrewardbj" key="stopdate" />
									:
								</div>
							</td>
							<td width="25%" class="form_table_left">
								<c:out value="${requestScope['/cms/zjty/zjtystdrewardbj/ZjtyStdrewardbjForm'].stopdate_basic}" />
							</td>
						</tr>
						<tr>
							<td width="20%" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="zjtystdrewardbj" key="acctype" />
									:
								</div>
							</td>
							<td width="30%" class="form_table_left">
								<html:radio property="acctype_basic" value="1" disabled="true"></html:radio>
								<bean:message bundle="bbcstdrewardbj" key="acctype_num" />
								<html:radio property="acctype_basic" value="2" disabled="true"></html:radio>
								<bean:message bundle="bbcstdrewardbj" key="acctype_scale" />
								<font color=red>&nbsp;*</font>
							</td>
							<td width="25%" class="form_table_right">
							</td>
							<td width="25%" class="form_table_left">
							</td>
						</tr>
						<tr>
							<td width="20%" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="zjtystdrewardbj" key="rewardstd_scale" />
									:
								</div>
							</td>
							<td width="30%" colspan="3" class="form_table_left">
								<input type="text" Class="form_input_1x" name="rewardstd_basic" value="<fmt:formatNumber pattern="0.00" value="${requestScope['/cms/zjty/zjtystdrewardbj/ZjtyStdrewardbjForm'].rewardstd_basic}"/>"  />
								<font color=red>*</font>
								(省公司酬金上限:<font color="red"><fmt:formatNumber pattern="0.00" value="${requestScope['/cms/zjty/zjtystdrewardbj/ZjtyStdrewardbjForm'].rewardstd_basic_limited}" /></font>元/百分比)
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
							<td width="20%" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="zjtystdrewardbj" key="ruleid" />
									:
								</div>
							</td>
							<td width="30%" colspan="3" class="form_table_left">
								<c:out value="${requestScope['/cms/zjty/zjtystdrewardbj/ZjtyStdrewardbjForm'].ruleid_basic}" />&nbsp;
								<s:Code2Name code="${requestScope['/cms/zjty/zjtystdrewardbj/ZjtyStdrewardbjForm'].ruleid_basic}" definition="#CH_ADT_RULE"/>
							</td>
						</tr>
						<tr>
							<td width="20%" align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="stdrewardbj" key="intvmonth"/>
									:
								</div>
							</td>
							<td width="80%" colspan=3 class="form_table_left">
								<html:text styleClass="form_input_1x" property="intvmonth_basic" maxlength="5" />
								<font color=red>*</font>
								<bean:message bundle="stdrewardbj" key="intvexplain"/>
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
									<font color=blue><bean:message bundle="zjtystdrewardbj" key="encouragereward" /> </font>
									<bean:message bundle="zjtystdrewardbj" key="remind" />
								</div>
							</td>
						</tr>
						<tr>
							<td width="20%" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="zjtystdrewardbj" key="rewardname" />
									:
								</div>
							</td>
							<td width="30%" class="form_table_left">
								<c:if test="${requestScope.EDIT eq 'TRUE'}">
									<c:out value="${requestScope['/cms/zjty/zjtystdrewardbj/ZjtyStdrewardbjForm'].rewardname_encourage}" />
								</c:if>
							</td>
							<td width="20%" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="zjtystdrewardbj" key="rewardtype" />
									:
								</div>
							</td>
							<td width="30%" class="form_table_left">
								<c:if test="${requestScope.EDIT eq 'TRUE'}">
								<s:Code2Name code="${requestScope['/cms/zjty/zjtystdrewardbj/ZjtyStdrewardbjForm'].rewardtype_encourage}" definition="#CH_ZJTY_REWARDTYPE"/>
								</c:if>
							</td>
						</tr>
						<tr>
							<td width="20%" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="zjtystdrewardbj" key="startdate" />
									:
								</div>
							</td>
							<td width="30%" class="form_table_left">
								<c:if test="${requestScope.EDIT eq 'TRUE'}">
									<c:out value="${requestScope['/cms/zjty/zjtystdrewardbj/ZjtyStdrewardbjForm'].startdate_encourage}" />
								</c:if>
							</td>
							<td width="20%" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="zjtystdrewardbj" key="stopdate" />
									:
								</div>
							</td>
							<td width="30%" class="form_table_left">
								<c:if test="${requestScope.EDIT eq 'TRUE'}">
									<c:out value="${requestScope['/cms/zjty/zjtystdrewardbj/ZjtyStdrewardbjForm'].stopdate_encourage}" />
								</c:if>
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
								<c:if test="${requestScope.EDIT eq 'TRUE'}">
									<input type="text" Class="form_input_1x" name="rewardstd_encourage" value="<fmt:formatNumber pattern="0.00" value="${requestScope['/cms/zjty/zjtystdrewardbj/ZjtyStdrewardbjForm'].rewardstd_encourage}"/>"  />
									<font color=red>*</font>
									(省公司酬金上限:<font color="red"><fmt:formatNumber pattern="0.00" value="${requestScope['/cms/zjty/zjtystdrewardbj/ZjtyStdrewardbjForm'].rewardstd_encourage_limited}" /></font>元/百分比)
								</c:if>
							</td>
						</tr>
						<tr>
							<td width="20%" align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="zjtystdrewardbj" key="intvmonth" />
									:
								</div>
							</td>
							<td width="30%" colspan="3" class="form_table_left">
								<c:if test="${requestScope.EDIT eq 'TRUE'}">
									<html:text styleClass="form_input_1x" property="intvmonth_encourage" maxlength="5" />	
								</c:if>
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
								<c:if test="${requestScope.EDIT eq 'TRUE'}">
									<c:out value="${requestScope['/cms/zjty/zjtystdrewardbj/ZjtyStdrewardbjForm'].ruleid_encourage}" />&nbsp;
									<s:Code2Name code="${requestScope['/cms/zjty/zjtystdrewardbj/ZjtyStdrewardbjForm'].ruleid_encourage}" definition="#CH_ADT_RULE"/>
								</c:if>
							</td>
						</tr>
					</table>

					<!-- button list, NEW and SAVE and DELETE -->
					<table class="table_button_list">
						<tr>
							<td>
							<s:RewardPurChk controlid="<%=ID_2%>" disableChild="true">
								<input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);" name="btnSaveOne"
									onfocus="buttonover(this)" onblur="buttonout(this)" value="<bean:message bundle="public" key="button_save"/>"
									class="submit" onclick="doSaveCityEncourage()" disabled="disabled" />
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
								<bean:message bundle="zjtystdrewardbj" key="rewardname" />
							</td>
							<td>
								<bean:message bundle="zjtystdrewardbj" key="startdate" />
							</td>
							<td>
								<bean:message bundle="zjtystdrewardbj" key="stopdate" />
							</td>
							<td>
								<bean:message bundle="zjtystdrewardbj" key="encouragestd" />
							</td>
							<td>
								<bean:message bundle="zjtystdrewardbj" key="intvmonth" />
							</td>
							<td>
								<bean:message bundle="zjtystdrewardbj" key="ruleid" />
							</td>
							<s:RewardPurChk controlid="<%=ID_2%>">
							<td>
								<bean:message bundle="zjtystdrewardbj" key="operate" />
							</td>
							</s:RewardPurChk>
						</tr>
						<c:forEach var="item" items="${requestScope.LIST}">
							<c:url value="/cms/zjty/stdrewardbj.do?CMD=EDITCITYENCOURAGE" var="urlContent">
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
									<fmt:formatNumber pattern="0.00" value="${item.rewardstd}" />
								</td>
								<td>
									<c:out value="${item.intvmonth}" />
								</td>
								<td title="<s:Code2Name code="${item.ruleid}" definition="#CH_ADT_RULE"/>">
									<c:out value="${item.ruleid}" />&nbsp;
								</td>
								<s:RewardPurChk controlid="<%=ID_2%>" >
								<td>
									<a href='#' onclick="doEditCityEncourage('<c:out value="${urlContent}"/>');return false;" target="_self"><bean:message bundle="zjtystdrewardbj" key="edit" /></a>
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
							<s:RewardPurChk controlid="<%=ID_2%>" disableChild="true">
								<input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);" name="btnSave"
									onfocus="buttonover(this)" onblur="buttonout(this)" value="<bean:message bundle="public" key="button_save"/>"
									class="submit" onclick="doSaveCityData()" />
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

if ('<%= EDIT %>' == 'TRUE' && (typeof formItem.btnSaveOne == 'object')) {
	formItem.btnSaveOne.disabled = "";
}
</script>
	</body>
</html>
