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
		<title><bean:message bundle="zjtyrewarddetail" key="XXXXXX" />
		</title>
		<script language="JavaScript" type="text/JavaScript">
        function ev_check() {
        
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
			var reg = /^(\d{1,4})(\d{1,2})$/;
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
			<html:form action="/cms/zjty/zjtyrewarddetail.do?CMD=Zzlist"
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
								<bean:message bundle="zjtyrewarddetail" key="zztitleList" />
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
								<s:myzoom definition="#ZJTY_OPERATION" property="_se_opnid" condition="opnid:6401*,;isbusi:1;" styleClass="form_input_1x" readonly="false"/>
							</td>
							<td width="126" height="20" align="right"
								class="form_table_right">
								<bean:message bundle="zjtyrewarddetail" key="wayid" />
								:
							</td>
							<td class="form_table_left">
								<html:text styleClass="form_input_1x" property="_se_wayid" /><input type="button" value="..." class="clickbutton"
									onclick="showSelectWay3(this,'_se_wayid','','','AG','ZJTY','1');this.value='...';" />
							</td>
						</tr>
						<tr>
							<td width="126" height="20" align="right"
								class="form_table_right">
								<bean:message bundle="zjtyrewarddetail" key="acctype" />
							</td>
							<td class="form_table_left">
								<html:select property="_se_acctype">
									<html:option value=""></html:option>
									<s:Options definition="$CH_ACCTYPE" />
								</html:select>
							</td>
							<td width="126" height="20" align="right"
								class="form_table_right">
								<bean:message bundle="zjtyrewarddetail" key="rewardmont" />
							</td>
							<td class="form_table_left">
								<html:text styleClass="form_input_1x" property="_se_rewardmont"
									onclick="this.value=selectDateYYYYMMDD();" readonly="true" />
							</td>
						</tr>
					</table>
				</div>
				<div class="table_div">
					<table class="table_button_list">
						<tr>
							<td align=right>
								<input type="button" name="btnNew" class="add"
									onmouseover="buttonover(this);" onmouseout="buttonout(this);"
									onfocus="buttonover(this)" onblur="buttonout(this)"
									value="<bean:message bundle="public" key="button_new"/>"
									onClick="doNew('/cms/zjty/zjtyrewarddetail.do?CMD=Zznew')">
								<input type="button" name="btnNew2" class="button_4"
									onmouseover="buttonover(this);" onmouseout="buttonout(this);"
									onfocus="buttonover(this)" onblur="buttonout(this)"
									value="<bean:message bundle="zjtyrewardcoef" key="button_batch_new"/>"
									onClick="goTo('/cms/zjty/zjtyrewarddetail/zzupload.do')">
								<input type="button" name="btnDelete" class="delete"
									onmouseover="buttonover(this);" onmouseout="buttonout(this);"
									onfocus="buttonover(this)" onblur="buttonout(this)"
									value="<bean:message bundle="public" key="button_delete"/>"
									onClick="doDelete('/cms/zjty/zjtyrewarddetail.do?CMD=Zzdelete')">
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
									<a href="javascript:doOrderby('rewardlistid')"><bean:message
											bundle="zjtyrewarddetail" key="opnid" /> </a>
									<s:OrderImg
										form="/cms/zjty/zjtyrewarddetail/ZjtyRewarddetailForm"
										field="rewardlistid" />
								</td>
								<td>
									<a href="javascript:doOrderby('rewardlistid')"><bean:message
											bundle="zjtyrewarddetail" key="opname" /> </a>
									<s:OrderImg
										form="/cms/zjty/zjtyrewarddetail/ZjtyRewarddetailForm"
										field="rewardlistid" />
								</td>

								<td>
									<a href="javascript:doOrderby('wayid')"><bean:message
											bundle="zjtyrewarddetail" key="wayid" /> </a>
									<s:OrderImg
										form="/cms/zjty/zjtyrewarddetail/ZjtyRewarddetailForm"
										field="wayid" />
								</td>
								<td>
									<a href="javascript:doOrderby('wayid')"><bean:message
											bundle="zjtyrewarddetail" key="wayname" /> </a>
									<s:OrderImg
										form="/cms/zjty/zjtyrewarddetail/ZjtyRewarddetailForm"
										field="wayid" />
								</td>

								<td>
									<a href="javascript:doOrderby('acctype')"><bean:message
											bundle="zjtyrewarddetail" key="acctype" /> </a>
									<s:OrderImg
										form="/cms/zjty/zjtyrewarddetail/ZjtyRewarddetailForm"
										field="acctype" />
								</td>
								<td>
									<a href="javascript:doOrderby('rewardmont')"><bean:message
											bundle="zjtyrewarddetail" key="rewardmont" /> </a>
									<s:OrderImg
										form="/cms/zjty/zjtyrewarddetail/ZjtyRewarddetailForm"
										field="rewardmont" />
								</td>
								<td>
									<a href="javascript:doOrderby('paysum')"><bean:message
											bundle="zjtyrewarddetail" key="paysum" /> </a>
									<s:OrderImg
										form="/cms/zjty/zjtyrewarddetail/ZjtyRewarddetailForm"
										field="paysum" />
								</td>
							</tr>
							<c:forEach var="item" items="${requestScope.LIST.datas}">
								<c:url value="/cms/zjty/zjtyrewarddetail.do?CMD=Zzedit"
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
										<a href='<c:out value="${urlContent}"/>'> <c:out
												value="${item.rewardlistid}" /> </a>
									</td>
									<td>
										<c:out value="${item.opnid}" />
									</td>
									<td>
										<s:Code2Name code="${item.opnid}" definition="#ZJTY_OPERATION" />
									</td>
									<td>
										<c:out value="${item.wayid}" />
									</td>
									<td>
										<s:Code2Name code="${item.wayid}" definition="#WAY" />
									</td>
									<td>
										<s:Code2Name code="${item.acctype}"
											definition="$CH_ACCTYPE" />
									</td>
									<td>
										<c:out value="${item.rewardmont}" />
									</td>
									<td>
										<fmt:formatNumber pattern="0.00" value="${item.paysum}" />
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

