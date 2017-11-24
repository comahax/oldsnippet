<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc"%>
<%
	String ID_1 = "00010701";
	String ID_2 = "00010702";
	String ID_3 = "00010703";
	String ID_4 = "00010704";
%>
<html>
	<head>
		<title><bean:message bundle="zjtyrewarddetail" key="titleList" />
		</title>
		<script language="JavaScript" type="text/JavaScript">
        function ev_check() {
        
 		if(date_compare("_snl_rewardmont","_snm_rewardmont",'<bean:message bundle="zjtyrewarddetail" key="timeCompare_1"/>')) return;
        var form=document.forms[0];
        	var time1=form.all['_snl_rewardmont'].value;
        	var time2=form.all['_snm_rewardmont'].value;
        	if(time1.length>0){
	        	if(!isDateYYYYMM(time1)){
		        	errorMessageShow('<span class=\'errorkey\'><span style=\'color:#F00; font-weight:900;\'>[作用月]</span>请输入正确的日期格式:YYYYMM</span>');
		        	return false;
        		}
        	}
        	if(time2.length>0){
	        	if(!isDateYYYYMM(time2)){
		        	errorMessageShow('<span class=\'errorkey\'><span style=\'color:#F00; font-weight:900;\'>[作用月]</span>请输入正确的日期格式:YYYYMM</span>');
		        	return false;
        		}
        	}
            return checkval(window);
        }
        function selectDateYYYYMMDD() {
			var arg = new Object();
			strTime = "";
			valTime = event.srcElement.value;
			if (isDateYYYYMMDD(valTime) == false) {
			strTime = "";
			} else {
			strTime = valTime.substring(0, 4) + "-" + valTime.substring(4, 6) + "-01";
			}
			arg.str_datetime = strTime;
			arg.time_comp = false;
			var rtn = window.showModalDialog("../../js/pub/calendar.html", arg, "dialogWidth=210px;dialogHeight=240px;status:no;scroll=no;");
			if (rtn != null) {
			rtn = rtn.split("-")[0] + rtn.split("-")[1];
			}
			return (rtn == null ? valTime : rtn);
		}
		
		function isDateYYYYMM(str) {
			var reg = /^(\d{1,4})(\d{1,2})/;
			var r = str.match(reg);
			if (r == null) {
				return false;
			} else {
				var d = new Date(r[1], r[2] - 1);
				if (d.getFullYear() == r[1] && (d.getMonth() + 1) == r[2]) {
					return true;
				} else {
					return false;
				}
			}
		}
		function upload(){
		var form=document.forms[0];
		form.action="<%=contextPath%>/cms/zjty/zjtyrewarddetail/batchupfile.jsp";
		form.submit();
		}
		function goTo(cmdNew) {
		    var url = contextPath + cmdNew;
		    formList.action = url;
		    formList.submit();
		}
      
    </script>
		<script type="text/javascript"
			src="<%=contextPath%>/js/bus/waycommon.js"></script>
		<script type="text/javascript"
			src="<%=contextPath%>/js/bus/rescommon.js"></script>
	</head>

	<body onload="if(window.loadforiframe) loadforiframe();">
		<div class="table_container">
			<html:form action="/cms/zjty/zjtyrewarddetail.do?CMD=LIST"
				styleId="formList" method="post" onsubmit="return ev_check();">
				<html:hidden property="_orderby" />
				<html:hidden property="_desc" />
				<html:hidden property="_pageno" />
				<html:hidden property="_pagesize" />
				<input type="hidden" name="_rowcount"
					value="<c:out value='${requestScope.LIST.rowCount}' />">

				<!--##################################添加标题内容##################################################-->
				<div class="table_div">
					<table class="top_table">
						<tr>
							<td>
								<bean:message bundle="zjtyrewarddetail" key="titleList" />
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
							<td width="126" height="20" align="right"
								class="form_table_right">
								<bean:message bundle="zjtyrewarddetail" key="opnid" />
								:
							</td>
							<td class="form_table_left">
								<html:text styleClass="form_input_1x" property="_se_opnid"
									/><input type="button" value="..." class="clickButton"
									onclick="showZjtyOpnTree(this, '_se_opnid','busi')">
							</td>
							<td width="126" height="20" align="right"
								class="form_table_right">
								<bean:message bundle="zjtyrewarddetail" key="wayid" />
								:
							</td>
							<td class="form_table_left">
								<html:text styleClass="form_input_1x" property="_se_wayid"
									/><input type="button" value="..." class="clickbutton"
									onclick="showSelectWay3(this,'_se_wayid','','','AG','ZJTY','1');this.value='...';" />
							</td>
						</tr>
						<tr>
							<td width="126" height="20" align="right"
								class="form_table_right">
								<bean:message bundle="zjtyrewarddetail" key="rewardtype" />
								:
							</td>
							<td class="form_table_left">
								<html:select property="_se_rewardtype">
									<html:option value=""></html:option>
									<s:Options definition="#CH_ZJTY_REWARDTYPE" />
								</html:select>
							</td>
							<td width="126" height="20" align="right"
								class="form_table_right">
								<bean:message bundle="zjtyrewarddetail" key="acctype1" />
								:
							</td>
							<td class="form_table_left">
								<html:select property="_se_acctype">
									<html:option value=""></html:option>
									<s:Options definition="#CH_ACCTYPE" />
								</html:select>
							</td>
						</tr>
						<tr>
							<td width="126" height="20" align="right"
								class="form_table_right">
								<bean:message bundle="zjtyrewarddetail" key="rewardmont1" />
								>=:
							</td>
							<td class="form_table_left">
								<html:text styleClass="form_input_1x" property="_snl_rewardmont"
									onclick="this.value=selectDateYYYYMMDD();" readonly="true" />
							</td>
							<td width="126" height="20" align="right"
								class="form_table_right">
								<bean:message bundle="zjtyrewarddetail" key="rewardmont2" />
								<=:
							</td>
							<td class="form_table_left">
								<html:text styleClass="form_input_1x" property="_snm_rewardmont"
									onclick="this.value=selectDateYYYYMMDD();" readonly="true" />
							</td>
						</tr>
					</table>
				</div>
				<div class="table_div">
					<table class="table_button_list">
						<tr>
							<td align=right>
								<input type="button" class="query"
									onmouseover="buttonover(this);" onclick="doQuery();"
									onmouseout="buttonout(this);" onfocus="buttonover(this)"
									onblur="buttonout(this)"
									value="<bean:message bundle="public" key="button_search"/>" />
							</td>
						</tr>
					</table>
				</div>
				<div class="table_div">
					<div class="table_LongTable">
						<table class="table_style" ID="Table2">
							<tr class="table_style_head">
								<td
									title="<bean:message bundle="public" key="list_title_select"/>">
									<input type="checkbox" name="allbox" onclick="checkAll();"
										class="table_checkbox">
								</td>
								<td>
									<a href="javascript:doOrderby('rewardlistid')"><bean:message
											bundle="zjtyrewarddetail" key="rewardlistid" /> </a>
									<s:OrderImg
										form="/cms/zjty/zjtyrewarddetail/ZjtyRewarddetailForm"
										field="rewardlistid" />
								</td>
								<td>
									<a href="javascript:doOrderby('operseq')"><bean:message
											bundle="zjtyrewarddetail" key="operseq" /> </a>
									<s:OrderImg
										form="/cms/zjty/zjtyrewarddetail/ZjtyRewarddetailForm"
										field="operseq" />
								</td>
								<td>
									<a href="javascript:doOrderby('opnid')"><bean:message
											bundle="zjtyrewarddetail" key="opnid" /> </a>
									<s:OrderImg
										form="/cms/zjty/zjtyrewarddetail/ZjtyRewarddetailForm"
										field="opnid" />
								</td>
								<td>
									<a href="javascript:doOrderby('wayid')"><bean:message
											bundle="zjtyrewarddetail" key="wayid" /> </a>
									<s:OrderImg
										form="/cms/zjty/zjtyrewarddetail/ZjtyRewarddetailForm"
										field="wayid" />
								</td>
								<td>
									<a href="javascript:doOrderby('wayopercode')"><bean:message
											bundle="zjtyrewarddetail" key="wayopercode" /> </a>
									<s:OrderImg
										form="/cms/zjty/zjtyrewarddetail/ZjtyRewarddetailForm"
										field="wayopercode" />
								</td>
								<td>
									<a href="javascript:doOrderby('rewardid')"><bean:message
											bundle="zjtyrewarddetail" key="rewardid" /> </a>
									<s:OrderImg
										form="/cms/zjty/zjtyrewarddetail/ZjtyRewarddetailForm"
										field="rewardid" />
								</td>
								<td>
									<a href="javascript:doOrderby('rewardtype')"><bean:message
											bundle="zjtyrewarddetail" key="rewardtype" /> </a>
									<s:OrderImg
										form="/cms/zjty/zjtyrewarddetail/ZjtyRewarddetailForm"
										field="rewardtype" />
								</td>
								<td>
									<a href="javascript:doOrderby('rewardstd')"><bean:message
											bundle="zjtyrewarddetail" key="rewardstd" /> </a>
									<s:OrderImg
										form="/cms/zjty/zjtyrewarddetail/ZjtyRewarddetailForm"
										field="rewardstd" />
								</td>
								<td>
									<a href="javascript:doOrderby('acctype')"><bean:message
											bundle="zjtyrewarddetail" key="acctype" /> </a>
									<s:OrderImg
										form="/cms/zjty/zjtyrewarddetail/ZjtyRewarddetailForm"
										field="acctype" />
								</td>
								<td>
									<a href="javascript:doOrderby('coef1')"><bean:message
											bundle="zjtyrewarddetail" key="coef1" /> </a>
									<s:OrderImg
										form="/cms/zjty/zjtyrewarddetail/ZjtyRewarddetailForm"
										field="coef1" />
								</td>
								<td>
									<a href="javascript:doOrderby('coef2')"><bean:message
											bundle="zjtyrewarddetail" key="coef2" /> </a>
									<s:OrderImg
										form="/cms/zjty/zjtyrewarddetail/ZjtyRewarddetailForm"
										field="coef2" />
								</td>
								<td>
									<a href="javascript:doOrderby('coef3')"><bean:message
											bundle="zjtyrewarddetail" key="coef3" /> </a>
									<s:OrderImg
										form="/cms/zjty/zjtyrewarddetail/ZjtyRewarddetailForm"
										field="coef3" />
								</td>
								<td>
									<a href="javascript:doOrderby('coef4')"><bean:message
											bundle="zjtyrewarddetail" key="coef4" /> </a>
									<s:OrderImg
										form="/cms/zjty/zjtyrewarddetail/ZjtyRewarddetailForm"
										field="coef4" />
								</td>
								<td>
									<a href="javascript:doOrderby('rewardmont')"><bean:message
											bundle="zjtyrewarddetail" key="rewardmont" /> </a>
									<s:OrderImg
										form="/cms/zjty/zjtyrewarddetail/ZjtyRewarddetailForm"
										field="rewardmont" />
								</td>
								<td>
									<a href="javascript:doOrderby('totalsum')"><bean:message
											bundle="zjtyrewarddetail" key="totalsum" /> </a>
									<s:OrderImg
										form="/cms/zjty/zjtyrewarddetail/ZjtyRewarddetailForm"
										field="totalsum" />
								</td>
								<td>
									<a href="javascript:doOrderby('paysum')"><bean:message
											bundle="zjtyrewarddetail" key="paysum" /> </a>
									<s:OrderImg
										form="/cms/zjty/zjtyrewarddetail/ZjtyRewarddetailForm"
										field="paysum" />
								</td>
								<td>
									<a href="javascript:doOrderby('batchnum')"><bean:message
											bundle="zjtyrewarddetail" key="batchnum" /> </a>
									<s:OrderImg
										form="/cms/zjty/zjtyrewarddetail/ZjtyRewarddetailForm"
										field="batchnum" />
								</td>
							</tr>
							<c:forEach var="item" items="${requestScope.LIST.datas}">
								<c:url value="/cms/zjty/zjtyrewarddetail.do?CMD=EDIT"
									var="urlContent">
									<%
									//this param name must "PK"
									%>
									<c:param name="PK" value="${item.rewardlistid}" />
									<%-- <c:param name="PK" value="'${item.id}|${item.id2}'"/> --%>
								</c:url>
								<tr class="table_style_content" align="center">
									<td>
										<input type="checkbox" name="_selectitem"
											value="<c:out value='${item.rewardlistid}' />"
											onclick="checkOne();" class="table_checkbox">
									</td>
									<td>
										<c:out value="${item.rewardlistid}" />
									</td>
									<td>
										<c:out value="${item.operseq}" />
									</td>
									<td>
										<s:Code2Name code="${item.opnid}" definition="#OPERATION" />
									</td>
									<td>
										<s:Code2Name code="${item.wayid}" definition="#WAY" />
									</td>
									<td>
										<c:out value="${item.wayopercode}" />
									</td>
									<td>
										<c:out value="${item.rewardid}" />
									</td>
									<td>
										<s:Code2Name code="${item.rewardtype}"
											definition="#CH_ZJTY_REWARDTYPE" />
									</td>
									<td>
										<fmt:formatNumber pattern="0.00" value="${item.rewardstd}" />
									</td>
									<td>
										<s:Code2Name code="${item.acctype}" definition="#CH_ACCTYPE" />
									</td>
									<td>
										<c:out value="${item.coef1}" />
									</td>
									<td>
										<c:out value="${item.coef2}" />
									</td>
									<td>
										<c:out value="${item.coef3}" />
									</td>
									<td>
										<c:out value="${item.coef4}" />
									</td>
									<td>
										<c:out value="${item.rewardmont}" />
									</td>
									<td>
										<fmt:formatNumber pattern="0.00" value="${item.totalsum}" />
									</td>
									<td>
										<fmt:formatNumber pattern="0.00" value="${item.paysum}" />
									</td>
									<td>
										<c:out value="${item.batchnum}" />
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

