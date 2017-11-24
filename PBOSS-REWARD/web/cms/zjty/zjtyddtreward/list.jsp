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
		<title><bean:message bundle="zjtyddtreward" key="titleList" />
		</title>
		<script language="JavaScript" type="text/JavaScript">
        function ev_check() {
           if(date_compare("_snl_rewardmont","_snm_rewardmont",'<bean:message bundle="zjtyrewarddetail" key="timeCompare_1"/>')) return;
        var form=document.forms[0];
        	var time1=form.all['_snl_rewardmont'].value;
        	var time2=form.all['_snm_rewardmont'].value;
        	if(time1.length>0){
	        	if(!isDateYYYYMM(time1)){
		        	errorMessageShow('<span class=\'errorkey\'><span style=\'color:#F00; font-weight:900;\'>[�����·�]</span>��������ȷ�����ڸ�ʽ:YYYYMM</span>');
		        	return false;
        		}
        	}
        	if(time2.length>0){
	        	if(!isDateYYYYMM(time2)){
		        	errorMessageShow('<span class=\'errorkey\'><span style=\'color:#F00; font-weight:900;\'>[�����·�]</span>��������ȷ�����ڸ�ʽ:YYYYMM</span>');
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
		form.action="<%=contextPath%>/cms/zjty/zjtyddtreward/batchupfile.jsp";
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
			<html:form action="/cms/zjty/zjtyddtreward.do?CMD=LIST"
				styleId="formList" method="post" onsubmit="return ev_check();">
				<html:hidden property="_orderby" />
				<html:hidden property="_desc" />
				<html:hidden property="_pageno" />
				<html:hidden property="_pagesize" />
				<input type="hidden" name="_rowcount"
					value="<c:out value='${requestScope.LIST.rowCount}' />">
				<c:set var="form" scope="request"
					value="${requestScope['/cms/zjty/zjtyddtreward/ZjtyddtrewardForm']}" />

				<!--##################################��ӱ�������##################################################-->
				<div class="table_div">
					<table class="top_table">
						<tr>
							<td>
								<bean:message bundle="zjtyddtreward" key="titleList" />
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
								<bean:message bundle="zjtyddtreward" key="wayid" />
								:
							</td>
							<td class="form_table_left">
								<html:text styleClass="form_input_1x" property="_se_wayid" /><input type="button" value="..." class="clickbutton"
									onclick="showSelectWay3(this,'_se_wayid','','','AG','ZJTY','1');this.value='...';" />
							</td>
							<td width="126" height="20" align="right"
								class="form_table_right">
								<bean:message bundle="zjtyddtreward" key="ddttype" />
								:
							</td>
							<td class="form_table_left">
								<html:select property="_se_ddttype">
									<html:option value=""></html:option>
									<html:option value="1">ȫ��ͨ�ۼ�</html:option>
								</html:select>
							</td>
						</tr>
						<tr>
							<td width="126" height="20" align="right"
								class="form_table_right">
								<bean:message bundle="zjtyddtreward" key="rewardmont" />
								>=:
							</td>
							<td class="form_table_left">
								<html:text styleClass="form_input_1x" property="_snl_rewardmont"
									onclick="this.value=selectDateYYYYMMDD();" readonly="true"/>
							</td>
							<td width="126" height="20" align="right"
								class="form_table_right">
								<bean:message bundle="zjtyddtreward" key="rewardmont" />
								<=:
							</td>
							<td class="form_table_left">
								<html:text styleClass="form_input_1x" property="_snm_rewardmont"
									onclick="this.value=selectDateYYYYMMDD();" readonly="true"/>
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
									onClick="doNew('/cms/zjty/zjtyddtreward.do')">
								<input type="button" name="btnNew2" class="button_4"
									onmouseover="buttonover(this);" onmouseout="buttonout(this);"
									onfocus="buttonover(this)" onblur="buttonout(this)"
									value="<bean:message bundle="zjtyrewardcoef" key="button_batch_new"/>"
									onClick="goTo('/cms/zjty/zjtyddtreward/upload.do')">
								<input type="button" name="btnDelete" class="delete"
									onmouseover="buttonover(this);" onmouseout="buttonout(this);"
									onfocus="buttonover(this)" onblur="buttonout(this)"
									value="<bean:message bundle="public" key="button_delete"/>"
									onClick="doDelete('/cms/zjty/zjtyddtreward.do')">
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
									<a href="javascript:doOrderby('seqid')"><bean:message
											bundle="zjtyddtreward" key="seqid" /> </a>
									<s:OrderImg form="/cms/zjty/zjtyddtreward/ZjtyddtrewardForm"
										field="seqid" />
								</td>
								<td>
									<a href="javascript:doOrderby('ddttype')"><bean:message
											bundle="zjtyddtreward" key="ddttype" /> </a>
									<s:OrderImg form="/cms/zjty/zjtyddtreward/ZjtyddtrewardForm"
										field="ddttype" />
								</td>
								<td>
									<a href="javascript:doOrderby('wayid')"><bean:message
											bundle="zjtyddtreward" key="wayid" /> </a>
									<s:OrderImg form="/cms/zjty/zjtyddtreward/ZjtyddtrewardForm"
										field="wayid" />
								</td>
								<td>
									<a href="javascript:doOrderby('rewardmont')"><bean:message
											bundle="zjtyddtreward" key="rewardmont" /> </a>
									<s:OrderImg form="/cms/zjty/zjtyddtreward/ZjtyddtrewardForm"
										field="rewardmont" />
								</td>
								<td>
									<a href="javascript:doOrderby('amount')"><bean:message
											bundle="zjtyddtreward" key="amount" /> </a>
									<s:OrderImg form="/cms/zjty/zjtyddtreward/ZjtyddtrewardForm"
										field="amount" />
								</td>
								<td>
									<a href="javascript:doOrderby('remark')"><bean:message
											bundle="zjtyddtreward" key="remark" /> </a>
									<s:OrderImg form="/cms/zjty/zjtyddtreward/ZjtyddtrewardForm"
										field="remark" />
								</td>
							</tr>
							<c:forEach var="item" items="${requestScope.LIST.datas}">
								<c:url value="/cms/zjty/zjtyddtreward.do?CMD=EDIT"
									var="urlContent">
									<%
									//this param name must "PK"
									%>
									<c:param name="PK" value="${item.seqid}" />
									<%-- <c:param name="PK" value="'${item.id}|${item.id2}'"/> --%>
								</c:url>
								<tr class="table_style_content" align="center">
									<td>
										<input type="checkbox" name="_selectitem"
											value="<c:out value='${item.seqid}' />" onclick="checkOne();"
											class="table_checkbox">
									</td>
									<td>
										<a href='<c:out value="${urlContent}"/>'><c:out
												value="${item.seqid}" /> </a>
									</td>
									<td>
										<c:out value="ȫ��ͨ�ۼ�" />
									</td>
									<td>
										<s:Code2Name code="${item.wayid}" definition="#WAY" />
									</td>
									<td>
										<c:out value="${item.rewardmont}" />
									</td>
									<td>
										<fmt:formatNumber pattern="0.00" value="${item.amount}" />
									</td>
									<td>
										<c:out value="${item.remark}" />
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
