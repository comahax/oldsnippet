<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc"%>
<%
	String ID_1 = "CH_PW_REWARD||CH_PW_REWARD_PROVINCIAL";
	String ID_2 = "00010702";
	String ID_3 = "00010703";
	String ID_4 = "00010704";
%>
<html>
	<head>
		<title><bean:message bundle="cityrewardad" key="titleList" />
		</title>
		<script language="JavaScript" type="text/JavaScript">
        function ev_check() {    
        			
        	return checkval(window);
        }
      	var cityFlag;
      	
      	function selectCity(){
      		var flag = 0;
	      	<s:RewardPurChk controlid="<%=ID_1%>">flag = 1</s:RewardPurChk>
	      	if(flag == 0){
	      		formList._se_cityid.disabled = false;
	      		cityFlag = formList._se_cityid.value;
	      		formList._se_cityid.disabled = true;
      		}else{
      			formList._se_cityid.disabled = false;
	      		cityFlag = formList._se_cityid.value;
      		}
      	}
		
		function upload(){
		var form=document.forms[0];
		form.action="<%=contextPath%>/cms/cityrewardad/batch.jsp";
		form.submit();
		}
		
		function goTo(cmdNew) {
		    var url = contextPath + cmdNew;
		    formList.action = url;
		    formList.submit();
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
			var rtn = window.showModalDialog("<%=contextPath%>/js/pub/calendar.html", arg, "dialogWidth=210px;dialogHeight=240px;status:no;scroll=no;");
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
    </script>
		<script type="text/javascript"
			src="<%=contextPath%>/js/bus/waycommon.js"></script>
		<script type="text/javascript"
			src="<%=contextPath%>/js/bus/rescommon.js"></script>
	</head>

	<body onload="if(window.loadforiframe) loadforiframe();selectCity();">
		<div class="table_container">
			<html:form action="/cms/cityrewardad.do?CMD=LIST" styleId="formList"
				method="post" onsubmit="return ev_check();">
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
								<bean:message bundle="cityrewardad" key="titleList" />
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
								<bean:message bundle="cityrewardad" key="cityid" />
								:
							</td>
							<s:RewardPurChk controlid="<%=ID_1%>" disableChild="true" >
								<td class="form_table_left">
									<html:select property="_se_cityid" onchange="cityFlag=this.value;">
										<html:option value=""></html:option>
										<s:Options definition="$region" />
									</html:select>
								</td>
							</s:RewardPurChk>
							<td width="126" height="20" align="right"
								class="form_table_right">
								<bean:message bundle="cityrewardad" key="wayid" />
								:
							</td>
							<td class="form_table_left">
								<html:text styleClass="form_input_1x" property="_se_wayid" /><input type="button" value="..." class="clickbutton"
									onclick="showWayByCityid(this,'_se_wayid',cityFlag,'AG');this.value='...';"/>
							</td>
						</tr>
						<tr>
							<td width="126" height="20" align="right"
								class="form_table_right">
								<bean:message bundle="cityrewardad" key="rewardtype" />
								:
							</td>
							<td class="form_table_left">
								<html:select property="_se_rewardtype">
									<html:option value=""></html:option>
									<html:option value="3">数据业务基本酬金</html:option>
									<html:option value="4">数据业务奖励酬金</html:option>
								</html:select>
							</td>
							<td width="126" height="20" align="right"
								class="form_table_right">
								<bean:message bundle="cityrewardad" key="paymonth" />
								:
							</td>
							<td class="form_table_left">
								<html:text styleClass="form_input_1x" property="_se_paymonth"
									onclick="this.value=selectDateYYYYMMDD();"></html:text>
							</td>
						</tr>
					</table>
				</div>
				<div class="table_div">
					<table class="table_button_list">
						<tr>
							<td align=right>
								<input type="button" name="btnNew2" class="button_2"
									onmouseover="buttonover(this);" onmouseout="buttonout(this);"
									onfocus="buttonover(this)" onblur="buttonout(this)"
									value="<bean:message bundle="public" key="button_import"/>"
									onClick="goTo('/cms/cityrewardad/upload.do')">

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
								
								<td>
									<a href="javascript:doOrderby('cityid')"><bean:message
											bundle="cityrewardad" key="cityid" /> </a>
									<s:OrderImg form="/cms/cityrewardad/CityrewardadForm"
										field="cityid" />
								</td>
								<td>
									<a href="javascript:doOrderby('wayid')"><bean:message
											bundle="cityrewardad" key="wayid1" /> </a>
									<s:OrderImg form="/cms/cityrewardad/CityrewardadForm"
										field="wayid" />
								</td>
								<td>
									<a href="javascript:doOrderby('wayid')"><bean:message
											bundle="cityrewardad" key="wayname" /> </a>
									<s:OrderImg form="/cms/cityrewardad/CityrewardadForm"
										field="wayid" />
								</td>
								<td>
									<a href="javascript:doOrderby('rewardtype')"><bean:message
											bundle="cityrewardad" key="rewardtype" /> </a>
									<s:OrderImg form="/cms/cityrewardad/CityrewardadForm"
										field="rewardtype" />
								</td>
								<td>
									<a href="javascript:doOrderby('paymonth')"><bean:message
											bundle="cityrewardad" key="paymonth" /> </a>
									<s:OrderImg form="/cms/cityrewardad/CityrewardadForm"
										field="paymonth" />
								</td>
								<td>
									<a href="javascript:doOrderby('amt')"><bean:message
											bundle="cityrewardad" key="amt" /> </a>
									<s:OrderImg form="/cms/cityrewardad/CityrewardadForm"
										field="amt" />
								</td>
							</tr>
							<c:forEach var="item" items="${requestScope.LIST.datas}">

								<tr class="table_style_content" align="center">
									
									<td>
										<s:Code2Name code="${item.cityid}" definition="$region" />
									</td>
									<td>
										<c:out value="${item.wayid}" />
									</td>
									<td>
										<s:Code2Name code="${item.wayid}" definition="#WAY" />
									</td>
									<td>
										<s:Code2Name code="${item.rewardtype}"
											definition="#CH_REWARDTYPE" />
									</td>
									<td>
										<c:out value="${item.paymonth}" />
									</td>
									<td>
										<fmt:formatNumber pattern="0.00" value="${item.amt}" />
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
