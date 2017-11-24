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
		<title><bean:message bundle="wayhznx" key="titleList" />
		</title>
		<script language="JavaScript" type="text/JavaScript">
        function ev_check() {    	
        	return checkval(window);
        }
		
		function upload(){
		var form=document.forms[0];
		form.action="<%=contextPath%>/cms/wayhznx/batch.jsp";
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
		function exports(){
			var form=document.forms[0];
			form.action="<%=contextPath%>/cms/wayhznx.do?CMD=TXT";
			form.submit();
			form.action="<%=contextPath%>/cms/wayhznx.do?CMD=LIST";
		}
    </script>
		<script type="text/javascript"
			src="<%=contextPath%>/js/bus/waycommon.js"></script>
		<script type="text/javascript"
			src="<%=contextPath%>/js/bus/rescommon.js"></script>
	</head>

	<body onload="if(window.loadforiframe) loadforiframe();">
		<div class="table_container">
			<html:form action="/cms/wayhznx.do?CMD=LIST" styleId="formList"
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
								<bean:message bundle="wayhznx" key="titleList" />
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
								<bean:message bundle="wayhznx" key="wayid" />
								:
							</td>
							<td class="form_table_left">
								<html:text styleClass="form_input_1x" property="_se_wayid" /><input type="button" value="..." class="clickbutton"
									onclick="showSelectWay3(this,'_se_wayid','','','AG');this.value='...';" />
							</td>
							<td width="126" height="20" align="right"
								class="form_table_right">
								<bean:message bundle="wayhznx" key="starlevel" />
								:
							</td>
							<td class="form_table_left">
                    			<html:select property="_ne_starlevel">
                    			<option />
                    				<s:Options definition="$CH_STARLEVEL" />
                    			</html:select>
                			</td>
						</tr>
						
					</table>
				</div>
				<div class="table_div">
					<table class="table_button_list">
						<tr>
							<td align=right>
							
								<input type="button" name="btnNew2" class="button_8"
									onmouseover="buttonover(this);" onmouseout="buttonout(this);"
									onfocus="buttonover(this)" onblur="buttonout(this)"
									value="关联套卡销量考核"
									onClick="goTo('/cms/waystarmonth.do?CMD=LIST&_orderby=oprtime&_desc=1')">
							
								<input type="button" name="btnNew2" class="button_8"
									onmouseover="buttonover(this);" onmouseout="buttonout(this);"
									onfocus="buttonover(this)" onblur="buttonout(this)"
									value="合作开始时间设置"
									onClick="goTo('/cms/wayhznx/batchupfile.jsp')">
							
								<!-- <input type="button" name="btnNew2" class="button_4"
									onmouseover="buttonover(this);" onmouseout="buttonout(this);"
									onfocus="buttonover(this)" onblur="buttonout(this)"
									value="<bean:message bundle="wayhznx" key="wayhznx_import"/>"
									onClick="goTo('/cms/wayhzwg.do?CMD=LIST')">
									 -->

								<input type="button" class="query"
									onmouseover="buttonover(this);" onclick="doQuery();"
									onmouseout="buttonout(this);" onfocus="buttonover(this)"
									onblur="buttonout(this)"
									value="<bean:message bundle="public" key="button_search"/>" />
									
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
								
							
								<td>
									<a href="javascript:doOrderby('wayid')"><bean:message
											bundle="wayhznx" key="wayid" /> </a>
									<s:OrderImg form="/cms/wayhznx/WayhznxForm"
										field="wayid" />
								</td>
								<td>
									<a href="javascript:doOrderby('wayname')"><bean:message
											bundle="wayhznx" key="wayname" /> </a>
									<s:OrderImg form="/cms/wayhznx/WayhznxForm"
										field="wayname" />
								</td>
								<td>
									<a href="javascript:doOrderby('starlevel')"><bean:message
											bundle="wayhznx" key="starlevel" /> </a>
									<s:OrderImg form="/cms/wayhznx/WayhznxForm"
										field="starlevel" />
								</td>
								<td>
									<bean:message bundle="wayhznx" key="laststarttime" />
								</td>
								<td>
									<bean:message bundle="wayhznx" key="years" />
								</td>
								<td>
									<bean:message bundle="wayhznx" key="yearstime" />
								</td>
								<td>
									<bean:message bundle="wayhznx" key="calcmonth" />
								</td>
								<td>
									<bean:message bundle="wayhznx" key="cleartime" />
								</td>
								<td>
									<bean:message bundle="wayhznx" key="oprcode" />
								</td>
								<td>
									<bean:message bundle="wayhznx" key="oprtime" />
								</td>
								<td>
									<bean:message bundle="wayhznx" key="remark" />
								</td>
							</tr>
							<c:forEach var="item" items="${requestScope.LIST.datas}">

								<tr class="table_style_content" align="center">
									
									<td>
										<c:out value="${item[0].wayid}" />
									</td>
									<td>
										<c:out value="${item[0].wayname}" />
									</td>
									<td>
										<s:Code2Name code="${item[0].starlevel}" definition="#CH_STARLEVEL" />
									</td>
									<td>
										<fmt:formatDate pattern="yyyy-MM-dd" value="${item[1].laststarttime}" />
									</td>
									<td>
										<c:out value="${item[1].years}" />
									</td>	
									<td>
										<fmt:formatDate pattern="yyyy-MM-dd" value="${item[1].yearstime}" />
									</td>
									<td>
										<c:out value="${item[1].calcmonth}" />
									</td>
									<td>
										<fmt:formatDate pattern="yyyy-MM-dd" value="${item[1].cleartime}" />
									</td>
									<td>
										<c:out value="${item[1].oprcode}" />
									</td>
									<td>
										<fmt:formatDate pattern="yyyy-MM-dd" value="${item[1].oprtime}" />
									</td>
									<td>
										<c:out value="${item[1].remark}" />
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
