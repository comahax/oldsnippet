<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc"%>
<%
	String ID_1 = "CH_ZJTY_REWARD||CH_ZJTY_PROVINCIAL";
	String ID_2 = "CH_ZJTY_REWARD||CH_ZJTY_PROVINCIAL||CH_ZJTY_CIVIC";
%>
<html>
	<head>
		<title><bean:message bundle="zjtyrewardcoef" key="titleList" />
		</title>
		<script language="JavaScript" type="text/JavaScript">
        function ev_check() {
        	var form=document.forms[0];
        	var time1=form.all['_se_effectiblemonth'].value;
        	if(time1.length>0){
	        	if(!isDateYYYYMM(time1)){
		        	errorMessageShow('<span class=\'errorkey\'><span style=\'color:#F00; font-weight:900;\'>[作用月]</span>请输入正确的日期格式:YYYYMM</span>');
		        	return false;
        		}
        	}
        	return checkval(window);
        }
        function doAuditing(){
			var strUrl ="<%=contextPath%>/cms/zjty/zjtyrewardcoef/select.jsp";
			var ispass = window.showModalDialog(strUrl,1,"dialogWidth:399px; dialogHeight:300px; status:no;resizable:yes;");
			if(ispass != ""){
        		var url = contextPath + '/cms/zjty/zjtyrewardcoef.do?CMD=AUDIT&ISPASS=' + ispass;
		    	formList.action = url;
		    	formList.submit();
		    	formList.action = "<%=contextPath%>/cms/zjty/zjtyrewardcoef/list.jsp";
		    }
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
		function doNew(){
			var isRight = false;
			
			<s:RewardPurChk controlid="<%=ID_1%>">isRight = true;</s:RewardPurChk>
		  	var url = contextPath + '/cms/zjty/zjtyrewardcoef.do?CMD=NEW&ISRIGHT=' + isRight;
		  	
		    formList.action = url;
		    formList.submit();
		}
		
		function goTo(cmdNew) {
		    var url = contextPath + cmdNew;
		    formList.action = url;
		    formList.submit();
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
		form.action="<%=contextPath%>/cms/zjty/zjtyrewardcoef/batchupfile.jsp";
		form.submit();
		}
    </script>
		<script type="text/javascript"
			src="<%=contextPath%>/js/bus/waycommon.js"></script>
		<script type="text/javascript"
			src="<%=contextPath%>/js/bus/rescommon.js"></script>
	</head>

	<body onload="if(window.loadforiframe) loadforiframe();">
		<div class="table_container">
			<html:form action="/cms/zjty/zjtyrewardcoef.do?CMD=LIST"
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
								<bean:message bundle="zjtyrewardcoef" key="titleList" />
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
								<bean:message bundle="zjtyrewardcoef" key="wayid" />
								:
							</td>
							<td class="form_table_left">
								<html:text styleClass="form_input_1x" property="_se_wayid"
									/><input type="button" value="..." class="clickbutton"
									onclick="showSelectWay3(this,'_se_wayid','','','AG','ZJTY','1');this.value='...';" />
							</td>
							<td width="126" height="20" align="right"
								class="form_table_right">
								<bean:message bundle="zjtyrewardcoef" key="cityid1" />
								:
							</td>
							<s:RewardPurChk controlid="<%=ID_1%>" disableChild="true">
								<td class="form_table_left">
									<html:select property="_se_cityid">
										<html:option value=""></html:option>
										<s:Options definition="$region" />
									</html:select>
								</td>
							</s:RewardPurChk>
						</tr>
						<tr>
							<td width="126" height="20" align="right"
								class="form_table_right">
								<bean:message bundle="zjtyrewardcoef" key="coefid" />
								:
							</td>
							<td class="form_table_left">
								<html:select property="_ne_coefid">
									<html:option value=""></html:option>
									<s:Options definition="#CH_ZJTY_EXAMINECOEF2" />
								</html:select>
							</td>
							<td width="126" height="20" align="right"
								class="form_table_right">
								<bean:message bundle="zjtyrewardcoef" key="effectiblemonth" />
								:
							</td>
							<td class="form_table_left">
								<html:text styleClass="form_input_1x"
									property="_se_effectiblemonth"
									onclick="this.value=selectDateYYYYMMDD();"></html:text>
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
									onClick="doNew()">
									<input type="button" name="btnNew2" class="button_4"
										onmouseover="buttonover(this);" onmouseout="buttonout(this);"
										onfocus="buttonover(this)" onblur="buttonout(this)"
										value="<bean:message bundle="zjtyrewardcoef" key="button_batch_new"/>"
										onClick="goTo('/cms/zjty/zjtyrewardcoef/upload.do')">
									<input type="button" name="btnDelete" class="delete"
										onmouseover="buttonover(this);" onmouseout="buttonout(this);"
										onfocus="buttonover(this)" onblur="buttonout(this)"
										value="<bean:message bundle="public" key="button_delete"/>"
										onClick="doDelete('/cms/zjty/zjtyrewardcoef.do')">
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
									<a href="javascript:doOrderby('effectiblemonth')"><bean:message
											bundle="zjtyrewardcoef" key="effectiblemonth" /> </a>
									<s:OrderImg form="/cms/zjty/zjtyrewardcoef/ZjtyRewardcoefForm"
										field="effectiblemonth" />
								</td>
								<td>
									<a href="javascript:doOrderby('coefid')"><bean:message
											bundle="zjtyrewardcoef" key="coefid" /> </a>
									<s:OrderImg form="/cms/zjty/zjtyrewardcoef/ZjtyRewardcoefForm"
										field="coefid" />
								</td>
								<td>
									<a href="javascript:doOrderby('wayid')"><bean:message
											bundle="zjtyrewardcoef" key="wayid" /> </a>
									<s:OrderImg form="/cms/zjty/zjtyrewardcoef/ZjtyRewardcoefForm"
										field="wayid" />
								</td>
								<td>
									<a href="javascript:doOrderby('wayid')"><bean:message
											bundle="zjtyrewardcoef" key="wayname" /> </a>
									<s:OrderImg form="/cms/zjty/zjtyrewardcoef/ZjtyRewardcoefForm"
										field="wayid" />
								</td>
								<td>
									<a href="javascript:doOrderby('cityid')"><bean:message
											bundle="zjtyrewardcoef" key="cityid" /> </a>
									<s:OrderImg form="/cms/zjty/zjtyrewardcoef/ZjtyRewardcoefForm"
										field="cityid" />
								</td>
								<td>
									<a href="javascript:doOrderby('providecoef')"><bean:message
											bundle="zjtyrewardcoef" key="providecoef" /> </a>
									<s:OrderImg form="/cms/zjty/zjtyrewardcoef/ZjtyRewardcoefForm"
										field="providecoef" />
								</td>
								<td>
									<a href="javascript:doOrderby('ispass')"><bean:message
											bundle="zjtyrewardcoef" key="ispass" /> </a>
									<s:OrderImg form="/cms/zjty/zjtyrewardcoef/ZjtyRewardcoefForm"
										field="ispass" />
								</td>
							</tr>
							<c:forEach var="item" items="${requestScope.LIST.datas}">
								<c:url value="/cms/zjty/zjtyrewardcoef.do?CMD=EDIT"
									var="urlContent">
									<%
									//this param name must "PK"
									%>
									<c:param name="PK"
										value="${item.coefid}|${item.wayid}|${item.effectiblemonth}" />
									<c:param name="ISPASS" value="${item.ispass}" />
									<%-- <c:param name="PK" value="'${item.id}|${item.id2}'"/> --%>
								</c:url>
								<tr class="table_style_content" align="center">
									<td>
										<input type="checkbox" name="_selectitem"
											value="<c:out value='${item.coefid}|${item.wayid}|${item.effectiblemonth}' />"
											onclick="checkOne();" class="table_checkbox">
									</td>
									<td>
										<c:out value="${item.effectiblemonth}" />
									</td>
									<td>
										<a href='<c:out value="${urlContent}"/>'><s:Code2Name
												code="${item.coefid}" definition="#CH_ZJTY_EXAMINECOEF" />
										</a>
									</td>
									<td>
										<c:out value="${item.wayid}" />
									</td>
									<td>
										<s:Code2Name code="${item.wayid}" definition="#WAY" />
									</td>
									<td>
										<s:Code2Name code="${item.cityid}"
											definition="#CITYIDNUM2NMAME" />
									</td>
									<td>
										<fmt:formatNumber pattern="0.00" value="${item.providecoef}" />
									</td>
									<td>
										<s:Code2Name code="${item.ispass}" definition="$CH_AUDIT" />
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
