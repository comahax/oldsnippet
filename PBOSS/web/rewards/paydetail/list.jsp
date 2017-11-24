<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc"%>
<html>
<head>
<title><s:text name="titleList" /></title>

<script language="JavaScript" type="text/JavaScript">
	function getElementByTabId(tabName){
	    return document.getElementById(tabName);
	}
	
	function copyTabIdValue(src,dist){
		getElementByTabId(dist).value=getElementByTabId(src).value;
	}
	
	function compareValue(paramTab,hidTab){
		if(getElementByTabId(paramTab).value!=getElementByTabId(hidTab).value){
			return true;
		}
		return false;
	}

	function setBtnDisabled(tabId,state){
	    document.getElementById(tabId).disabled=state;
	}
	
	
	function doExport(url) {
		formList.action = contextPath + url;
		formList.submit();
		formList.action = contextPath + "/paydetail/paydetail_list.do";
	}

	function doImport() {
		formList.action = contextPath + "/rewards/paydetail/batch.jsp";
		formList.submit();
	}
	
	function setAjaxParams() {
		var dataStr = "";
		
		var wayid = getElementByTabId("param._se_wayid").value;
		if (wayid != "") {
			dataStr += "'wayid':'" + wayid + "',";
		}
		
		var calcmonth = getElementByTabId("param._se_calcmonth").value;
		if (calcmonth != "") {
			dataStr += "'calcmonth':'" + calcmonth + "',";
		}
		
		var opmonth = getElementByTabId("param._se_opmonth").value;
		if (opmonth != "") {
			dataStr += "'opmonth':'" + opmonth + "',"
		}
		
		var mobile = getElementByTabId("param._sk_mobile").value;
		if (mobile != "") {
			dataStr += "'mobile' : '" + mobile + "',"
		}
		
		if (dataStr != "") {
			dataStr = "{" + dataStr.substr(0, dataStr.length -1) + "}";
		} 
		
		return dataStr;
	}
	
	function checkQryParams() {
		var msg = "";
		if(getElementByTabId("param._se_wayid").value != getElementByTabId("hid_se_wayid").value){
			msg="【渠道编码】条件已改变，请重新点击【查询】获得结果";
		}
		if(getElementByTabId("param._se_calcmonth").value != getElementByTabId("hid_se_calcmonth").value){
			msg="【结算月】条件已改变，请重新点击【查询】获得结果";
		}
		if(getElementByTabId("param._se_opmonth").value != getElementByTabId("hid_se_opmonth").value){
			msg="【业务月】条件已改变，请重新点击【查询】获得结果";
		}
		if(getElementByTabId("param._sk_mobile").value != getElementByTabId("hid_sk_mobile").value){
			msg="【IMEI/号码】条件已改变，请重新点击【查询】获得结果";
		}
		
		return msg;
	}
	
	function doCheckDelete(url) {
		
		doDelete(url);
	}
	
	function doBatchDelete(cmdDelete) {
		
		
		var msg = checkQryParams();
		if(msg!=""){
			alert(msg);
			return;
		}
		
		var rowcount = getElementByTabId("_rowcount").value;
		if(rowcount == 0){
			alert("查询结果为空，请重新点击【查询】");
			return;
		}
		
		var wayid = getElementByTabId("param._se_wayid").value;
		
		var calcmonth = getElementByTabId("param._se_calcmonth").value;
		
		var opmonth = getElementByTabId("param._se_opmonth").value;
		
		var mobile = getElementByTabId("param._sk_mobile").value;
		
		
		if (wayid == "" && calcmonth == "" && opmonth == "" && mobile == "") {
			alert("查询条件不能都为空，请先选择查询条件做查询");
			return;
		}
		
		var send = new Object();
		send.wayid = wayid;
		send.mobile = mobile;
		send.opmonth = opmonth;
		send.calcmonth = calcmonth;
		send.rowcount = rowcount;
		var dirurl = "<%=contextPath%>/rewards/paydetail/batchDelDialog.jsp";
		var ret = window.showModalDialog(dirurl, send,
				"dialogHeight:250px;dialogWidth:550px;status:no;help:no");
		//alert("ret=" + ret );
		if (ret == "ok") {
			getElementByTabId("btnBatchDelete").disabled = true;
			formList.action = contextPath + cmdDelete;
			formList.submit();
		}
	}

	function doQueryList(url) {
		setBtnDisabled("btnBatchDelete", false);

		copyTabIdValue("param._se_wayid", "hid_se_wayid");
		copyTabIdValue("param._se_calcmonth", "hid_se_calcmonth");
		copyTabIdValue("param._se_opmonth", "hid_se_opmonth");
		copyTabIdValue("param._sk_mobile", "hid_sk_mobile");

		doQuery(url);
	}
</script>
</head>

<body class="list_body"
	onload="if(window.loadforiframe) loadforiframe();">
	<div class="table_container">
		<s:form action="paydetail_list.do" key="formList" cssStyle="formList"
			theme="simple">
			<%
				//下面的控件给Action提供数据，用来分页
			%>
			<aa:zone name="hiddenZone">
				<s:hidden name="param._orderby" />
				<s:hidden name="param._desc" />
				<s:hidden name="param._pageno" />
				<s:hidden name="param._pagesize" />
				<s:hidden name="param.queryAll" />
				<input type="hidden" name="_rowcount"
					value="<s:property value="dp.rowCount" />" />
			</aa:zone>

			<div class="table_top">
				<div class="table_topleft"></div>
				<div class="table_toparea_w">
					<s:i18n name="public">
						<span class="table_toparea"><s:text name="currentPos" /> </span>
						<span class="table_toparea_xi">></span>
						<span class="table_toparea"><s:text name="酬金管理" /> </span>
						<span class="table_toparea_xi">></span>
					</s:i18n>
					<span class="table_toparea_h"><s:text name="titleList" /></span> <span
						class="button_Help"
						onclick="openword('<s:text name="helpTitle"/>','<s:text name="helpContent"/>')"><s:i18n
							name="public">
							<s:text name="help" />
						</s:i18n></span>
				</div>
			</div>

			<aa:zone name="errorZone">
				<div class="error_text">
					<table class="error_text">
						<s:actionerror />
						<s:actionmessage />
					</table>
				</div>
			</aa:zone>

			<!-- Condition -->
			<div class="table_div">
				<table class="table_normal">
					<tr>
						<td align="center"><s:text name="wayid" />:</td>
						<td align="left"><j:selector definition="#WAYIDINFO" name="param._se_wayid"/>
						<input type="hidden" name="hid_se_wayid" /></td>

						<td align="center"><s:text name="mobile" /></td>
						<td align="left"><input type="text" id="param._sk_mobile"
							name="param._sk_mobile" /><input type="hidden"
							name="hid_sk_mobile" /></td>
					</tr>

					<tr>
						<td align="center"><s:text name="opmonth" /></td>
						<td align="left"><input type="text" id="param._se_opmonth"
							name="param._se_opmonth"
							value="<s:property value="param._se_opmonth!=null?getText('format.date',{param._se_opmonth}):''"/>"
							onclick="selectDateYYYYMM();" /> <input type="hidden" name="hid_se_opmonth" /></td>

						<td align="center"><s:text name="calcmonth" />:</td>
						<td align="left"><input type="text" id="param._se_calcmonth"
							name="param._se_calcmonth"
							value="<s:property value="param._se_calcmonth!=null?getText('format.date',{param._se_calcmonth}):''"/>"
							onclick="selectDateYYYYMM();" /> <input type="hidden" name="hid_se_calcmonth" /></td>
					</tr>
				</table>
			</div>

			<div class="table_div">
				<table class="table_button_list">
					<tr>
						<td><s:i18n name="public">
								<input type="button" id="btnQuery" name="btnQuery"
									class="button_Query" onmouseover="buttonover(this);"
									onmouseout="buttonout(this);" onfocus="buttonover(this)"
									onblur="buttonout(this)" value="<s:text name="button_search"/>"
									onClick="doQueryList('/paydetail/paydetail_list.do');">

								<input type="button" id="btnNew" name="btnNew"
									class="button_New" onmouseover="buttonover(this);"
									onmouseout="buttonout(this);" onfocus="buttonover(this)"
									onblur="buttonout(this)" value="<s:text name="button_new"/>"
									onClick="doNew('/paydetail/paydetail_new.do')">

								<input type="button" id="btnDelete" name="btnDelete"
									class="button_Delete" onmouseover="buttonover(this);"
									onmouseout="buttonout(this);" onfocus="buttonover(this)"
									onblur="buttonout(this)" value="<s:text name="button_delete"/>"
									onClick="doCheckDelete('/paydetail/paydetail_delete.do')">

								<input type="button" id="btnBatchDelete" name="btnBatchDelete"
									class="button_2" onmouseover="buttonover(this);"
									onmouseout="buttonout(this);" onfocus="buttonover(this)"
									onblur="buttonout(this)"
									value="<s:text name="button_batchdelete"/>"
									onClick="doBatchDelete('/paydetail/paydetail_batchDelete.do')">

								<input type="button" id="btntxt" name="btntxt" class="button_4"
									onmouseover="buttonover(this);" onmouseout="buttonout(this);"
									onfocus="buttonover(this)" onblur="buttonout(this)"
									value="<s:text name="button_exporttxt"/>"
									onClick="doExport('/paydetail/paydetail_txt.do')">

								<input type="button" id="btnBatch" name="btnBatch"
									class="button_2" onmouseover="buttonover(this);"
									onmouseout="buttonout(this);" onfocus="buttonover(this)"
									onblur="buttonout(this)" value="<s:text name="button_batchimport"/>" onClick="doImport();">

							</s:i18n></td>
					</tr>
				</table>
			</div>

			<aa:zone name="listZone">
				<div class="table_LongTable">
					<table class="table_style">
						<tr class="table_style_head" align="left">
							<s:i18n name="public">
								<td title="<s:text name="list_title_select"/>"><input
									type="checkbox" name="allbox" onclick="checkAll();" /></td>
							</s:i18n>

							<td><j:orderByImg href="javascript:doOrderby('wayid')">
									<s:text name="wayid" />
								</j:orderByImg></td>
							<td><s:text name="wayname"/></td>
							<td><j:orderByImg href="javascript:doOrderby('mobile')">
									<s:text name="mobile" />
								</j:orderByImg></td>
							<td><j:orderByImg href="javascript:doOrderby('opmonth')">
									<s:text name="opmonth" />
								</j:orderByImg></td>
							<td><j:orderByImg href="javascript:doOrderby('calcmonth')">
									<s:text name="calcmonth" />
								</j:orderByImg></td>
						</tr>

						<s:iterator value="dp.datas">
							<tr class="table_style_content" align="center"
								onMouseMove="this.bgColor='F0F5F9'"
								onMouseOut="this.bgColor='#ffffff'">
								<td><input type="checkbox" name="param._selectitem"
									value="<s:property value="seq"/>" onclick="checkOne();">
								</td>
								<td><a
									href='<s:url action="paydetail_edit.do"><s:param name="param._pk" value="seq"/></s:url>'>
										<s:property value="wayid" />
								</a></td>
								<td><j:code2Name definition="#WAYIDINFO" code="wayid" /></td>
								<td><s:property value="mobile" /></td>
								<td><s:property value="opmonth" /></td>
								<td><s:property value="calcmonth" /></td>
							</tr>
						</s:iterator>
					</table>
				</div>

				<div class="table_div">
					<%@ include file="/common/pageNav.jsp"%>
				</div>
			</aa:zone>
		</s:form>
	</div>
	<script language="javascript">
		ajaxAnywhere.getZonesToReload = function(url, submitButton) {
			return "errorZone,listZone,hiddenZone";
		}
		ajaxAnywhere.substituteFormSubmitFunction();
		ajaxAnywhere.formURL = formList.action;
		ajaxAnywhere.substituteSubmitButtonsBehaviorByIDs(true,
				"btnQuery,btnDelete,btnBatchDelete");
	</script>
</body>
</html>