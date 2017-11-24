<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc"%>
<html>
	<head>
		<title><bean:message bundle="rewardtotal" key="totaltitle" />
		</title>
		<script type="text/javascript"
			src="<%=contextPath%>/js/bus/waycommon.js"></script>
		<script language="JavaScript" type="text/JavaScript">
    	function selectDateYYYYMMDD() {
			var arg = new Object();
			strTime = "";
			valTime = event.srcElement.value;
			if (isDateYYYYMMDD(valTime) == false) {
				strTime = "";
			} else {
				//strTime = valTime.substring(0, 4) + "-" + valTime.substring(4, 6) + "-" + valTime.substring(6, 8);
				strTime = valTime.substring(0, 4) + "-" + valTime.substring(4, 6) + "-01";
			}
			arg.str_datetime = strTime;
			arg.time_comp = false;

			var rtn = window.showModalDialog("<%=contextPath%>/js/pub/calendar.html", arg, "dialogWidth=210px;dialogHeight=240px;status:no;scroll=no;");
			if (rtn != null) {
			rtn = rtn.split("-")[0] + rtn.split("-")[1];
			}
			return (rtn == null ? valTime : rtn);
		}
        function ev_check() {
            addfield('_se_wayid', '<bean:message bundle="rewardtotal" key="wayid"/>', 'c', true, '18');
            addfield('_ne_totalid', '<bean:message bundle="rewardtotal" key="totalid"/>', 'i', true, '14');
            addfield('_se_paymonth', '<bean:message bundle="rewardtotal" key="paymonth"/>', 'c', true, '6');
            addfield('_se_chagmonth', '<bean:message bundle="rewardtotal" key="chagmonth"/>', 'c', true, '6');
            if ((formList._se_paymonth.value != '') && (!checkDateByMask(formList._se_paymonth.value, 'yyyyMM'))) {
            	alert('<bean:message bundle="rewardtotal" key="paymonth"/>' + ' 格式要求为YYYYMM');
            	formList._se_paymonth.focus();
            	return false;
            }
            if ((formList._se_chagmonth.value != '') && (!checkDateByMask(formList._se_chagmonth.value, 'yyyyMM'))) {
            	alert('<bean:message bundle="rewardtotal" key="chagmonth"/>' + ' 格式要求为YYYYMM');
            	formList._se_paymonth.focus();
            	return false;
            }
            
            return checkval(window);
        }
		
		function doQuery(cmdQuery) {
			if (ev_check()) {
				formList.action = contextPath + cmdQuery;
				formList.submit();
			}
		}
		
		function doReset() {
			formList._se_wayid.value = "";
			formList._ne_totalid.value = "";
			formList._ne_slv.value = "";
			formList._ne_rewardtype.value = "";
			formList._se_paymonth.value = "";
			formList._ne_isbudget.value = "";
		}
		
		function upload(){
		var form=document.forms[0];
		form.action="<%=contextPath%>/cms/reward/rewardtotal/batchfile.jsp";
		form.submit();
		}
		function exports(){
		var form=document.forms[0];
		form.action="<%=contextPath%>/cms/reward/rewardtotal.do?CMD=TXT";
		form.submit();
		form.action="<%=contextPath%>/cms/reward/rewardtotal.do?CMD=LIST";
		}
    </script>
	</head>

	<body onload="document.formList._se_wayid.focus();">
		<div class="table_container">

			<html:form action="/cms/reward/rewardtotal.do?CMD=LIST"
				styleId="formList" method="post" onsubmit="return ev_check();">
				<html:hidden property="_orderby" />
				<html:hidden property="_desc" />
				<html:hidden property="_pageno" />
				<html:hidden property="_pagesize" />
				<input type="hidden" name="_rowcount"
					value="<c:out value='${requestScope.LIST.rowCount}' />">

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
							<td width="20%" height="20" align="right" class="form_table_right">
								<bean:message bundle="rewardtotal" key="wayid" />
								:
							</td>
							<td class="form_table_left">
								<html:text styleClass="form_input_1x" property="_se_wayid"
									onclick="showSelectWay(this,'_se_wayid')" />
							</td>
							<td width="20%" height="20" align="right" class="form_table_right">
								<bean:message bundle="rewardtotal" key="totalid" />
								:
							</td>
							<td class="form_table_left">
								<html:text styleClass="form_input_1x" property="_ne_totalid"
									maxlength="14" />
							</td>
						</tr>
						<tr>
							<td width="20%" height="20" align="right" class="form_table_right">
								<bean:message bundle="rewardtotal" key="slv" />
								:
							</td>
							<td class="form_table_left">
								<html:select property="_ne_slv">
									<option value=""></option>
									<s:Options definition="#CH_STARLEVEL" />
								</html:select>
							</td>
							<td width="20%" height="20" align="right" class="form_table_right">
								<bean:message bundle="rewardtotal" key="rewardtype" />
								:
							</td>
							<td class="form_table_left">
								<html:select property="_ne_rewardtype"
									styleClass="form_select_on">
									<option value=""></option>
									<s:Options definition="$CH_REWARDTYPE" />
								</html:select>
							</td>
						</tr>
						<tr>
							<td width="20%" height="20" align="right" class="form_table_right">
								<bean:message bundle="rewardtotal" key="paymonth" />
								:
							</td>
							<td class="form_table_left">
								<html:text styleClass="form_input_1x" property="_se_paymonth" maxlength="6" onclick="this.value=selectDateYYYYMMDD();"/>
							</td>
							<td width="20%" height="20" align="right" class="form_table_right">
								<bean:message bundle="rewardtotal" key="isbudget" />
								:
							</td>
							<td class="form_table_left">
								<html:select property="_ne_isbudget">
									<option value=""></option>
									<s:Options definition="#CH_ISBUDGET" />
								</html:select>
							</td>
						</tr>
						<tr>
							<td width="20%" height="20" align="right" class="form_table_right">
								<bean:message bundle="rewardtotal" key="chagmonth" />
								:
							</td>
							<td class="form_table_left">
								<html:text styleClass="form_input_1x" property="_se_chagmonth" maxlength="6" onclick="this.value=selectDateYYYYMMDD();"/>
							</td>
							<td width="20%" height="20" align="right" class="form_table_right">
							</td>
							<td class="form_table_left">
							</td>
						</tr>
					</table>
				</div>

				<div class="table_div">
					<table width="100%" class="table_button_list" border="0"
						cellspacing="0" cellpadding="0" ID="Table3">
						<tr>
							<td align=right>
								<input type="button" name="btnQuery" class="query"
									value="<bean:message bundle="public" key="button_search"/>"
									onclick="doQuery('/cms/reward/rewardtotal.do?CMD=LIST');" />
								<!-- 
								<input type="button" name="btnQuery" class="query" value="导入"
									onclick="upload();" />
								-->
								<input type="button" name="btnQuery" class="button_2" value="导出"
									onclick="exports();" />
							</td>
						</tr>
					</table>
				</div>

				<div class="table_div">
					<div class="table_LongTable">
						<table class="table_style" ID="Table2">
							<tr class="table_style_head">
								<td nowrap>
									<a href="javascript:doOrderby('totalid')"><bean:message
											bundle="rewardtotal" key="totalid" />
									</a>
									<s:OrderImg form="/cms/rewardtotal/RewardtotalForm"
										field="totalid" />
								</td>
								<td nowrap>
									<bean:message bundle="rewardtotal" key="isbudget" />
								</td>
								<td nowrap>
									<bean:message bundle="rewardtotal" key="wayid" />
								</td>
								<td nowrap>
									<bean:message bundle="rewardtotal" key="slv" />
								</td>
								<td nowrap>
									<bean:message bundle="rewardtotal" key="rewardtype" />
								</td>
								<td nowrap>
									<bean:message bundle="rewardtotal" key="chagmonth" />
								</td>
								<td nowrap>
									<bean:message bundle="rewardtotal" key="paymonth" />
								</td>
								<td nowrap>
									<bean:message bundle="rewardtotal" key="paymoney" />
								</td>
								<td nowrap>
									<bean:message bundle="rewardtotal" key="rewardmonth1" />
								</td>
								<td nowrap>
									<bean:message bundle="rewardtotal" key="rewardmoney1" />
								</td>
								<td nowrap>
									<bean:message bundle="rewardtotal" key="rewardmonth2" />
								</td>
								<td nowrap>
									<bean:message bundle="rewardtotal" key="rewardmoney2" />
								</td>
								<td nowrap>
									<bean:message bundle="rewardtotal" key="rewardmonth3" />
								</td>
								<td nowrap>
									<bean:message bundle="rewardtotal" key="rewardmoney3" />
								</td>
								<td nowrap>
									<bean:message bundle="rewardtotal" key="paystat" />
								</td>
							</tr>
							<c:forEach var="item" items="${requestScope.LIST.datas}">
								<tr class="table_style_content" align="center">
									<td>
										<c:out value="${item.totalid}" />
									</td>
									<td>
										<s:Code2Name code="${item.isbudget }"
											definition="#CH_ISBUDGET" />
									</td>
									<td>
										<c:out value="${item.wayid}" />
										-
										<s:Code2Name code="${item.wayid }" definition="#WAY" />
									</td>
									<td>
										<s:Code2Name definition="#CH_STARLEVEL" code="${item.slv}" />
									</td>
									<td>
										<s:Code2Name definition="$CH_REWARDTYPE"
											code="${item.rewardtype}" />
									</td>
									<td>
										<c:out value="${item.chagmonth}" />
									</td>
									<td>
										<c:out value="${item.paymonth}" />
									</td>
									<td>
										<fmt:formatNumber pattern="0.000000###" value="${item.paymoney}" />
									</td>
									<td>
										<c:out value="${item.rewardmonth1}" />
									</td>
									<td>
										<fmt:formatNumber pattern="0.000000000" value="${item.rewardmoney1}" />
									</td>
									<td>
										<c:out value="${item.rewardmonth2}" />
									</td>
									<td>
										<fmt:formatNumber pattern="0.000000000" value="${item.rewardmoney2}" />
									</td>
									<td>
										<c:out value="${item.rewardmonth3}" />
									</td>
									<td>
										<fmt:formatNumber pattern="0.000000000" value="${item.rewardmoney3}" />
									</td>
									<td>
										<s:Code2Name definition="#CH_PPAYSTATE" code="${item.paystat}" />
									</td>
								</tr>
							</c:forEach>
						</table>
					</div>
				</div>
				<div class="table_div">
					<s:PageNav dpName="LIST" />
				</div>
			</html:form>
		</div>
	</body>
</html>
