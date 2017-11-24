<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc"%>
<%
	String ID_1 = "CH_PW_REWARDCONF";
	String ID_2 = "CH_B2M_REWARDCONF";
%>
<html>
	<head>
		<title><bean:message bundle="rewardconf" key="titleList" />
		</title>
		<script language="JavaScript" type="text/JavaScript">
        function ev_check() {
        	var form=document.forms[0];
        	var time1=form.all['_se_rewardmonth'].value;
        	if(time1.length>0){
	        	if(!isDateYYYYMM(time1)){
		        	errorMessageShow('<span class=\'errorkey\'><span style=\'color:#F00; font-weight:900;\'>[计酬周期标识]</span>请输入正确的日期格式:YYYYMM</span>');
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
		
		var msgNotSelected="<bean:message bundle="rewardconf" key="msgNotSelected"/>"
    	var msgAuditConfirm="<bean:message bundle="rewardconf" key="msgAuditConfirm"/>"
		function doAuditing(cmdAudit){
    		
    		var TO = true;
    		var sis = formList.all("_selectitem");
    		if (forincheck(TO,sis,msgAuditConfirm)){
    			formList.action = addParam(contextPath + cmdAudit, 'CMD', 'AUDIT');
    			formList.submit();
    			}  
		}
		function forincheck(TO,sis,msg){
    		if (sis != null) {
       			 if (sis.length != null) {
            		for (var i = 0; i < sis.length; i++) {
               		 	var e = sis[i];
               			if (e.type == 'checkbox') {
                  		 	if (e.checked)
                        		TO = false;
               		 	}
           			}		
       		 	 } else {
            		var e = sis;
            	 	if (e.type == 'checkbox') {
                		if (e.checked)
                    		TO = false;
            		}		
        		 }		
    		}
    		if (TO) {
        		alert(msgNotSelected);
        		return false;
    		}
	
			if(msg.length>0){
    			if (!confirm(msg)) {
        		return false;
    			}
    		}
    	return true;
	}
	
	function checkAll(FO,BO,CO) {
    	if (FO == null) {
       		FO = "document.formList";
    	}else{
    		FO = "document." + FO;
    	}
    	if (BO == null) {
        	BO = "_selectitem";
    	}
    	if (CO == null) {
    		CO = FO + ".allbox";
    	}else{
    		CO = FO + "." + CO;
    	}
    	var sis = eval(FO).all(BO);
    
    	if (sis != null) {
        	if (sis.length != null) {
            	for (var i = 0; i < sis.length; i++) {
                	var e = sis[i];
                	if (e.type == 'checkbox') {
                		if(!e.disabled){
                    	e.checked = eval(CO).checked;
                   		}
                	}
            	}
        	} else {
            	var e = sis;
            	if (e.type == 'checkbox') {
                	e.checked = eval(CO).checked;
            	}
        	}
    	}
	}
		
		
		
    </script>
		<script type="text/javascript"
			src="<%=contextPath%>/js/bus/waycommon.js"></script>
		<script type="text/javascript"
			src="<%=contextPath%>/js/bus/rescommon.js"></script>
	</head>

	<body onload="if(window.loadforiframe) loadforiframe();">
		<div class="table_container">
			<html:form action="/cms/reward/rewardconf.do?CMD=LIST"
				styleId="formList" method="post" onsubmit="return ev_check();">
				<html:hidden property="_orderby" />
				<html:hidden property="_desc" />
				<html:hidden property="_pageno" />
				<html:hidden property="_pagesize" value="21" />
				<html:hidden property="_se_rewardkind" />
				<html:hidden property="state" />


				<input type="hidden" name="_rowcount"
					value="<c:out value='${requestScope.LIST.rowCount}' />">

				<!--##################################添加标题内容##################################################-->
				<div class="table_div">
					<table class="top_table">
						<tr>
							<td>
								<c:choose>
									<c:when
										test="${requestScope.flagAG eq formList.rewardkind.value}">
										<bean:message bundle="rewardconf" key="titleList1" />
									</c:when>
									<c:otherwise>
										<bean:message bundle="rewardconf" key="titleList" />
									</c:otherwise>
								</c:choose>
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
							<td width="126" height="20" align="left" class="form_table_right">
								<bean:message bundle="rewardconf" key="rewardmonth" />
								:
							</td>
							<td class="form_table_left">
								<html:text styleClass="form_input_1x" property="_se_rewardmonth"
									onclick="this.value=selectDateYYYYMMDD();"></html:text>
							</td>
							<td width="126" height="20" align="right"
								class="form_table_right">
								<bean:message bundle="rewardconf" key="cityid" />
								:
							</td>
							<td class="form_table_left">
								<html:select property="_se_cityid">
									<html:option value=""></html:option>
									<s:Options definition="$region" />
								</html:select>
							</td>
						<tr>
							<td width="126" height="20" align="right"
								class="form_table_right">
								<bean:message bundle="rewardconf" key="state" />
								:
							</td>
							<td class="form_table_left">
								<html:select property="_se_state">
									<html:option value=""></html:option>
									<s:Options definition="$CH_RWDCONFSTATE" />
								</html:select>
							</td>
							<td width="126" height="20" align="right"
								class="form_table_right">
								<bean:message bundle="rewardconf" key="oprcode" />
								:
							</td>
							<td class="form_table_left">
								<html:text styleClass="form_input_1x" property="_se_oprcode"></html:text>
							</td>

						</tr>
						<tr>
						<c:choose>
							<c:when
								test="${requestScope.flagAG eq formList.rewardkind.value}">
								
									<td align="right">
										酬金类别:
									</td>
									<td class="form_table_left">
										<html:select property="rewardb2mkind">
											<html:option value=""></html:option>
											<s:Options definition="#B2MUNPB" />
										</html:select>
									</td>
									<td width="126" height="20" align="right"
								class="form_table_right">
								<bean:message bundle="rewardconf" key="batchno" />
								:
								<td>
								<html:text styleClass="form_input_1x" property="_se_batchno"></html:text>
								</td>
							</c:when>
							<c:otherwise>
									<td width="126" height="20" align="right"
								class="form_table_right">
								<bean:message bundle="rewardconf" key="batchno" />
								:
								<td>
								<html:text styleClass="form_input_1x" property="_se_batchno"></html:text>
								</td>
								<td colspan="2">
								</td>
							</c:otherwise>
						</c:choose>
						
						
						
					</tr>		
					</table>
				</div>
				<div class="table_div">
					<table class="table_button_list">
						<tr>
							<td align=right>

								<input type="button" name="btnAuditing" class="button_4"
									onmouseover="buttonover(this);" onmouseout="buttonout(this);"
									onfocus="buttonover(this)" onblur="buttonout(this)"
									value='<bean:message bundle="rewardconf" key="auditing"/>'
									onClick="doAuditing('/cms/reward/rewardconf.do');">

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
									<a href="javascript:doOrderby('rewardmonth')"><bean:message
											bundle="rewardconf" key="rewardmonth" /> </a>
									<s:OrderImg form="/cms/reward/rewardconf/RewardconfForm"
										field="rewardmonth" />
								</td>

								<td>
									<a href="javascript:doOrderby('cityid')"><bean:message
											bundle="rewardconf" key="cityid" /> </a>
									<s:OrderImg form="/cms/reward/rewardconf/RewardconfForm"
										field="cityid" />
								</td>
								<td>
									<a href="javascript:doOrderby('cityid')"><bean:message
											bundle="rewardconf" key="cityid1" /> </a>
									<s:OrderImg form="/cms/reward/rewardconf/RewardconfForm"
										field="cityid" />
								</td>
								<td>
									<a href="javascript:doOrderby('state')"><bean:message
											bundle="rewardconf" key="state" /> </a>
									<s:OrderImg form="/cms/reward/rewardconf/RewardconfForm"
										field="state" />
								</td>
								<td>
									<a href="javascript:doOrderby('oprcode')"><bean:message
											bundle="rewardconf" key="oprcode" /> </a>
									<s:OrderImg form="/cms/reward/rewardconf/RewardconfForm"
										field="oprcode" />
								</td>
								<td>
									<a href="javascript:doOrderby('oprtime')"><bean:message
											bundle="rewardconf" key="oprtime" /> </a>
									<s:OrderImg form="/cms/reward/rewardconf/RewardconfForm"
										field="oprtime" />
								</td>
								<td>
									<a href="javascript:doOrderby('rewardkind')"><bean:message
											bundle="rewardconf" key="rewardkind" /> </a>
									<s:OrderImg form="/cms/reward/rewardconf/RewardconfForm"
										field="rewardkind" />
								</td>
								<td>
									<a href="javascript:doOrderby('batchno')"><bean:message
											bundle="rewardconf" key="batchno" /> </a>
									<s:OrderImg form="/cms/reward/rewardconf/RewardconfForm"
										field="batchno" />
								</td>
								<td>
									批次号名称
								</td>

							</tr>
							<c:forEach var="item" items="${requestScope.LIST.datas}">
								<c:url value="/cms/reward/batchno.do?CMD=EDIT"
									var="urlContent">
									<%
									//this param name must "PK"
									%>
									<c:param name="PK"
										value="${item.batchno},${item.rewardkind}" />
									<%-- <c:param name="ISPASS" value="${item.ispass}" /> --%>
									<%-- <c:param name="PK" value="'${item.id}|${item.id2}'"/> --%>
								</c:url>
								<tr class="table_style_content" align="center">
									<td>
										<c:choose>
											<c:when
												test="${item.state ne '1' and (requestScope.flagAG eq 'AG' or requestScope.flagB2M eq 'B2M')}">

												<input type="checkbox" name="_selectitem"
													value="<c:out value='${item.rewardmonth}|${item.cityid}|${item.rewardkind}|${item.batchno}' />"
													onclick="checkOne();" class="table_checkbox">
											</c:when>
											<c:otherwise>
												<input type="checkbox" name="_selectitem"
													value="<c:out value='${item.rewardmonth}|${item.cityid}|${item.rewardkind}|${item.batchno}' />"
													onclick="checkOne();" class="table_checkbox"
													disabled="true">
											</c:otherwise>
										</c:choose>
									</td>
									<td>
										<c:out value="${item.rewardmonth}" />
									</td>
									<td>
										<c:out value="${item.cityid}" />
									</td>

									<td>
										<s:Code2Name code="${item.cityid}" definition="$region" />
									</td>
									<td>
										<s:Code2Name code="${item.state}"
											definition="$CH_RWDCONFSTATE" />
									</td>
									<td>
										<c:out value="${item.oprcode}" />
									</td>
									<td>
										<fmt:formatDate pattern="yyyy-MM-dd hh:mm:ss"
											value="${item.oprtime}" />
									</td>
									<td>
										<s:Code2Name code="${item.rewardkind}"
											definition="$CH_RWDREWARDKIND" />
									</td>
									<td>
										<a href='<c:out value="${urlContent}"/>'> <c:out
											value="${item.batchno}" /> </a>
									</td>
									<td>
										<s:Code2Name code="${item.batchno}|${item.rewardkind}" definition="Batchno2Name"/>
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
