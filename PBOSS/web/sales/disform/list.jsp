<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc"%>
<%@ page import="com.sunrise.jop.ui.User"%>
<%@ page import="com.sunrise.jop.ui.struts2.WebConstant"%>
<%
			User user = (User) request.getSession().getAttribute(
			WebConstant.SESSION_ATTRIBUTE_USER);
	String cityid = com.sunrise.jop.infrastructure.db.CityMappingUtil
			.getCityNo(user.getCityid());
%>
<html>
	<head>
		<title><s:text name="titleList" /></title>
		<style id="style1">
		.table_div {
			width:100%;
			text-align:center;
			border:#000000 dashed 0px;
		}
		.table_print {
			width:98%;
			font-size:12px;
		}
		.table_print_title {
			width:98%;
			font-size:22px;
			text-align:center;
		}
		.table_print_style {
			width:98%;
			border:#CDCDCD solid 1px;
			border-collapse:collapse;
			margin-top:10px;
			padding-bottom:15px;
		}
		.table_style_print {
			
		}
		.table_style_print td {
			border-right:#FFFFFF inset 2px;
			border-bottom-width: 1px;
			border-bottom-style: solid;
			border-bottom-color: #D7D7D7;
			font-family: "宋体";
			font-size: 12px;
			font-weight: normal;
			height: 24px;
			vertical-align: middle;
			<!--text-align:center;-->
			padding:0px 2px 0px 2px;
		}
		.table_style_print_head {
			height:22px;
		}
		.table_style_print_head td {
			font-size: 12px;
			font-weight: normal;
			color: #2F3732;
			height: 22px;
			border:#000 solid 0px;
			text-align:center;
			border-right:#FFFFFF inset 2px;
			border-bottom:#CDCDCD solid 1px;
			padding:2px 10px 0px 10px;
			background:url(../images/image_peijian/index_main_xinxi_bj.GIF) repeat-x;
			font-family: Geneva, Arial, Helvetica, sans-serif;	
			word-break:break-all;
			white-space:nowrap;
			vertical-align:middle;
		}
		</style>
		<script language="javascript" src="<%=contextPath%>/js/LodopFuncs.js"></script> 
		<object id="LODOP_OB" classid="clsid:2105C259-1E0C-4534-8141-A753534CB4CA" width=0 height=0></object>
		<script language="JavaScript" type="text/JavaScript">
		
		var isPrint = '${isPrint}'==''?false:true;
		var timer1;
		var timer2;
		
        function ev_check() {
        	addfield('param._se_discomcode', '<s:text name="discomcode"/>', 'c', true, '18');
           	addfield('param._ne_recid', '<s:text name="recid"/>', 'i', true, '14');
           	addfield('param._se_orderid', '<s:text name="orderid"/>', 'c', true, '18');
           	addfield('param._se_disstate', '<s:text name="disstate"/>', 'c', true, '16');
           	return (checkval(window) && compareDate());
        }
        
        function doBatch(str){
    		formList.action="<%=contextPath%>/sales/disform/batch.jsp";
    		formList.submit();
    	}
        function compareDate(){
        	var dnmCreatetime = document.getElementById('param._dnm_createtime').value;
        	var dnlCreatetime = document.getElementById('param._dnl_createtime').value;
        	
        	if(dnmCreatetime != '' && dnlCreatetime != '' && dnlCreatetime > dnmCreatetime){
	        	var alertstr = '<span class=\'errorkey\'><span style=\'color:#F00; font-size:12px;\'>[<s:text name="_dnl_createtime"/> ]</span> 不能大于 <span style=\'color:#F00; font-size:12px;\'>[<s:text name="_dnm_createtime"/>]</span>';
				errorMessageShow(alertstr);
				return false;
        	}
        	return true;
        }
        
        function doShowRecord(recid, orderid, true1){
        	var url = contextPath + '/sales/disform_showrecord.do?form.recid=' + recid + "&form.orderid=" + orderid + "&entry=" + true1;
        	formList.action = url;
        	formList.submit();
        	//var hWnd = window.showModalDialog(url,new Array(),"dialogWidth:750px; dialogHeight:300px; status:no;resizable:no;");
        }
        
        function doExcel(){
        	document.getElementsByName("param._se_countyid")[0].disabled=false;
        	formList.action="<%=contextPath%>/sales/disform_excel.do";
        	formList.submit();
        	//document.getElementsByName("param._se_countyid")[0].disabled=true;
        	formList.action="<%=contextPath%>/sales/disform_list.do";
        }
        
        msgConfirmConsignment = "确认发货？";
        function doConsignment() {
    		var TO = true;
    		var sis = formList.all("param._selectitem");   
    		if (forincheck(TO,sis,msgConfirmConsignment)){    
    			formList.action="<%=contextPath%>/sales/disform_consignment.do";
    			formList.submit();
    		}  
		}
		
		msgConfirmStartdis = "确认启动配送？";
        function doStartdis() {
    		var TO = true;
    		var sis = formList.all("param._selectitem");   
    		if (forincheck(TO,sis,msgConfirmStartdis)){    
    			formList.action="<%=contextPath%>/sales/disform_startdis.do";
    			formList.submit();
    		}  
		}
		
		msgConfirmDisover = "确认完成配送？";
        function doDisover() {
    		var TO = true;
    		var sis = formList.all("param._selectitem");   
    		if (forincheck(TO,sis,msgConfirmDisover)){    
    			formList.action="<%=contextPath%>/sales/disform_disover.do";
    			formList.submit();
    		}  
		}
		
		msgConfirmSign = "是否修改所选配送单的签收状态？";
		function doComfirmSign(){
			var TO = true;
    		var sis = formList.all("param._selectitem");
    		if (forincheck(TO,sis,msgConfirmSign)){
    			formList.action="<%=contextPath%>/sales/disform_comfirmsign.do";
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
        		alert(msgNoSelected);
        		return false;
    		}

   	 		if (!confirm(msg)) {
        		return false;
    		}
    		return true;
		}
		
		function forincheck2(TO,sis){
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
        		alert(msgNoSelected);
        		return false;
    		}
    		return true;
    	}
		
		function printAll(){
			var TO = true;
    		var sis = formList.all("param._selectitem");
    		if (forincheck2(TO,sis)){
				isPrint = true;
				document.getElementsByName("param._se_countyid")[0].disabled=false;
				formList.action="<%=contextPath%>/sales/disform_batchprint.do";
    			formList.submit();
    			document.getElementsByName("param._se_countyid")[0].disabled=true;
				//ajaxAnywhere.submitByURL(
				//	"/sales/disform_batchprint.do");
				/*jQuery.ajax({
					type:"POST",
					url:"<%=contextPath %>/sales/disform_batchprint.do",
					async:false, //同步
					success:function(msg){
					}
				});*/
				//ajaxAnywhere.submitByURL(
					//"/sales/disform_batchprint.do");
			}
		}
		
		var LODOP = getLodop(document.getElementById('LODOP_OB'),document.getElementById('LODOP_EM'));
		function doPrint(){
			var divs = $("div[id*='printPage']");
			LODOP.PRINT_INIT("配送单批量打印");
			var strBodyStyle = "<style>" + document.getElementById("style1").innerHTML + "</style>";
			for(i=0; i<divs.length; i++) {
				if (i > 0) {
					LODOP.NewPageA();
				}
				LODOP.ADD_PRINT_HTM(20, 0, "100%", "96%", strBodyStyle + "<body>" + divs[i].innerHTML + "</body>");
			}
			LODOP.SET_SHOW_MODE("HIDE_PAPER_BOARD", true);//隐藏走纸板
			LODOP.PREVIEW();
		}
		
		function sendTheMessage(){
			ajaxAnywhere.submitByURL(
					"/sales/disform_batchprint.do");
		}
		
    </script>
	</head>

	<body class="list_body"
		onload="if(window.loadforiframe) loadforiframe();">
		<div class="table_container">
			<s:form action="disform_list.do" key="formList" cssStyle="formList"
				theme="simple" onsubmit="return ev_check();">
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
							<span class="table_toparea"><s:text name="currentPos" />
							</span>
							<span class="table_toparea_xi">></span>
							<span class="table_toparea"><s:text name="sales" /> </span>
							<span class="table_toparea_xi">></span>
						</s:i18n>
						<span class="table_toparea_h"><s:text name="titleList" />
						</span>
						<span class="button_Help"
							onclick="openword('<s:text name="helpTitle"/>','<s:text name="helpContent"/>')"><s:i18n
								name="public">
								<s:text name="help" />
							</s:i18n> </span>
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

				<div class="table_div">
					<table class="table_normal">
						<tr>
							<td align="center">
								<s:text name="discomcode" />
								:
							</td>
							<td align="left">
								<j:selector name="param._se_discomcode" definition="#WAYIDINFO"
									condition="waytype:AG;waysubtype:LOGS;cityid:${USER.cityid}" />
							</td>
							<td align="center">
								<s:text name="recid" />
								:
							</td>
							<td align="left">
								<s:textfield cssStyle="style_input" name="param._ne_recid" />
							</td>
							<td align="center">
								<s:text name="orderid" />
								:
							</td>
							<td align="left">
								<s:textfield cssStyle="style_input" name="param._se_orderid" />
							</td>
						</tr>
						<tr>
							<td align="center">
								<s:text name="disstate" />
								:
							</td>
							<td align="left">
								<j:selector name="param._se_disstate"
									definition="$FX_DISFORMSTATE" mode="selector" />
							</td>
							<td align="center">
								<s:text name="_dnl_createtime" />
								:
							</td>
							<td align="left">
								<s:textfield cssStyle="style_input" name="param._dnl_createtime"
									onclick="selectDatetime();" readonly="true" />
							</td>
							<td align="center">
								<s:text name="_dnm_createtime" />
								:
							</td>
							<td align="left">
								<s:textfield cssStyle="style_input" name="param._dnm_createtime"
									onclick="selectDatetime();" readonly="true" />
							</td>
						</tr>
						<tr>
							<td align="center">
								<s:text name="paytype" />
								:
							</td>
							<td align="left">
								<j:selector name="param._se_paytype" definition="$FX_PAYTYPE"
									mode="selector" />
							</td>
							<td align="center">
								<s:text name="countyid" />
								:
							</td>
							<td align="left">
								<j:purChk permid="FX_DISFORMMG_CITY">
								 	<j:selector definition="#CNTYCOMPANY"  condition="citycompid:${USER.cityid}" name="param._se_countyid" mode="selector"/>
								</j:purChk>
							</td>
							<td align="center">
								<s:text name="signstate" />
								:
							</td>
							<td>
								<j:selector definition="$FX_SIGNSTATE" name="param._se_signstate" mode="selector"/>
							</td>
						</tr>
					</table>
				</div>

				<div class="table_div">
					<table class="table_button_list">
						<tr>
							<td>
								<s:i18n name="public">
									<input type="button" id="btnQuery" name="btnQuery"
										class="button_Query" onmouseover="buttonover(this);"
										onmouseout="buttonout(this);" onfocus="buttonover(this)"
										onblur="buttonout(this)"
										value="<s:text name="button_search"/>"
										onClick="doQuery('/sales/disform_list.do');">
									<input type="button" id="btnExcel" name="btnExcel"
										class="button_4" onmouseover="buttonover(this);"
										onmouseout="buttonout(this);" onfocus="buttonover(this)"
										onblur="buttonout(this)" value="导出EXCEL" onClick="doExcel();">
									<j:purChk permid="FX_DISFORMMG_STORE">
										<input type="button" id="btnConsignment" name="btnConsignment"
											class="button_4" onmouseover="buttonover(this);"
											onmouseout="buttonout(this);" onfocus="buttonover(this)"
											onblur="buttonout(this)" value="仓管发货"
											onClick="doConsignment();">
									</j:purChk>
									<j:purChk permid="FX_DISFORMMG_BATCH">
										<input type="button" id="btnStartdis" name="btnStartdis"
											class="button_4" onmouseover="buttonover(this);"
											onmouseout="buttonout(this);" onfocus="buttonover(this)"
											onblur="buttonout(this)" value="启动配送" onClick="doStartdis();">
										<input type="button" id="btnDisover" name="btnDisover"
											class="button_4" onmouseover="buttonover(this);"
											onmouseout="buttonout(this);" onfocus="buttonover(this)"
											onblur="buttonout(this)" value="完成配送" onClick="doDisover();">
										<input type="button" id="btnConfirmSign" name="btnConfirmSign"
											class="button_4" onmouseover="buttonover(this);"
											onmouseout="buttonout(this);" onfocus="buttonover(this)"
											onblur="buttonout(this)" value="确认签收"
											onClick="doComfirmSign();">
										<input type="button" id="btnBatch" name="btnBatch"
											class="button_4" onmouseover="buttonover(this);"
											onmouseout="buttonout(this);" onfocus="buttonover(this)"
											onblur="buttonout(this)" value="批量处理" onClick="doBatch()">
									</j:purChk>
									<j:purChk permid="FX_DISFORMMG_STORE">
										<input type="button" id="btnPrint" name="btnPrint"
											class="button_4" onmouseover="buttonover(this);"
											onmouseout="buttonout(this);" onfocus="buttonover(this)"
											onblur="buttonout(this)" value="批量打印" onClick="printAll();">
									</j:purChk>
								</s:i18n>
							</td>
						</tr>
					</table>
				</div>

				<aa:zone name="listZone">
					<div class="table_div">
						<div class="table_LongTable">
							<table class="table_style">
								<tr class="table_style_head">
									<s:i18n name="public">
										<td title="<s:text name="list_title_select"/>">
											<input type="checkbox" name="allbox" onclick="checkAll();" />
										</td>
									</s:i18n>
									<td>
										<j:orderByImg href="javascript:doOrderby('recid')">
											<s:text name="recid" />
										</j:orderByImg>
									</td>
									<td>
										<j:orderByImg href="javascript:doOrderby('orderid')">
											<s:text name="orderid" />
										</j:orderByImg>
									</td>
										<td>
										<j:orderByImg href="javascript:doOrderby('logisticsno')">
											<s:text name="logisticsno" />
										</j:orderByImg>
									</td>
									<td>
										<j:orderByImg href="javascript:doOrderby('paytype')">
											<s:text name="paytype" />
										</j:orderByImg>
									</td>
									<td>
										<j:orderByImg href="javascript:doOrderby('discomcode')">
											<s:text name="discomcode" />
										</j:orderByImg>
									</td>
									<td>
										<j:orderByImg href="javascript:doOrderby('countyid')">
											<s:text name="countyid" />
										</j:orderByImg>
									</td>
									<td>
										<j:orderByImg href="javascript:doOrderby('recewayid')">
											<s:text name="recewayid" />
										</j:orderByImg>
									</td>
									<td>
										网点编码
									</td>
									<td>
										<j:orderByImg href="javascript:doOrderby('recename')">
											<s:text name="recename" />
										</j:orderByImg>
									</td>
									<td>
										<j:orderByImg href="javascript:doOrderby('recetel')">
											<s:text name="recetel" />
										</j:orderByImg>
									</td>
									<td>
										<j:orderByImg href="javascript:doOrderby('receadd')">
											<s:text name="receadd" />
										</j:orderByImg>
									</td>
									<td>
										<j:orderByImg href="javascript:doOrderby('createtime')">
											<s:text name="createtime" />
										</j:orderByImg>
									</td>
									<td>
										<j:orderByImg href="javascript:doOrderby('arrivetime')">
											<s:text name="arrivetime" />
										</j:orderByImg>
									</td>
									<td>
										<j:orderByImg href="javascript:doOrderby('disstate')">
											<s:text name="disstate" />
										</j:orderByImg>
									</td>
									<td>
										<j:orderByImg href="javascript:doOrderby('signstate')">
											<s:text name="signstate" />
										</j:orderByImg>
									</td>
									<td>
										订单信息
									</td>
									<td>
										金额
									</td>
									<td>
										配送完成时间
									</td>
									<td>
										是否入账
									</td>
								</tr>
								<s:iterator value="dp.datas">
									<s:if test="disstate=='CANCEL'">
										<tr class="table_style_content2" align="center" bgcolor="#666666">
									</s:if>
									<s:else>
										<tr class="table_style_content" align="center">
									</s:else>
										<td>
											<input type="checkbox" name="param._selectitem"
												value="<s:property value="recid"/>" onclick="checkOne();">
										</td>
										<td>
											<a
												href='<s:url action="disform_edit.do">
	                         					<s:param name="param._pk" value="recid"/>
	                     					</s:url>'>
												<s:property value="recid" /> </a>
										</td>
										<td>
											<s:property value="orderid" />
										</td>
										<td><s:property value="logisticsno" /></td>
										<td>
											<j:code2Name definition="$FX_PAYTYPE" code="paytype" />
										</td>
										<td>
											<j:code2Name definition="#WAYIDINFO" code="discomcode" />
										</td>
										<td>
											<j:code2Name definition="#CNTYCOMPANY" code="countyid" />
										</td>
										<td>
											<j:code2Name definition="#WAYIDINFO" code="recewayid" />
										</td>
										<td>
											<s:property value="recewayid" />
										</td>
										<td>
											<s:property value="recename" />
										</td>
										<td>
											<s:property value="recetel" />
										</td>
										<td>
											<span
												STYLE="overflow:hidden; text-overflow:ellipsis; white-space:nowrap;width:300px"
												title="<s:property value="receadd" />" /> <s:property
													value="receadd" /> </span>
										</td>
										<td>
											<s:date name="createtime" format="yyyy-MM-dd" />
										</td>
										<td>
											<s:date name="arrivetime" format="yyyy-MM-dd" />
										</td>
										
										<td>
											<j:code2Name definition="$FX_DISFORMSTATE" code="disstate" />
										</td>
										<td>
											<j:code2Name definition="$FX_SIGNSTATE" code="signstate" />
										</td>
										<td>
											<s:property value="orderinfo" />
										</td>
										<td>
											<s:property value="actamt" />
										</td>
										<td>
											<s:date name="disovertime" format="yyyy-MM-dd" />
										</td>
										<td>
											<s:property value="isrecord" />
										</td>
									</tr>
								</s:iterator>
							</table>
						</div>
					</div>
					<div class="table_div">
						<%@ include file="/common/pageNav.jsp"%>
					</div>
				</aa:zone>

			</s:form>
			
			<aa:zone name="zonePrint">
				<div id="ajax" style="display:none">
					<s:iterator value="#request.dp2.datas" id="print" status="state"
						var="data1">
						<div id="printPage<s:property value='#state.count'/>">
							<div class="table_div">
								<table class="table_print_title">
									<tr>
										<td>
											中国移动广东公司<j:code2Name code="<%=cityid%>" definition="$region" />分公司业务用品配送单
										</td>
									</tr>
								</table>
							</div>
								<br>
								<br>
								<div class="table_div">
									<s:iterator value="#data1.datas" var="data2" status="state">
									<s:if test="#state.index==0">
										<table class="table_print">
											<tr>
												<td align="right">
													<s:text name="orderid" />
													:&nbsp
												</td>
												<td align="left">
													<s:property value="#data2.orderid" />
												</td>
												<td align="right">
													<s:text name="logisticsno" />
													:&nbsp
												</td>
												<td align="left">
													<s:property value="#data2.logisticsno" />
												</td>
												<td align="right">
													<s:text name="recid" />
													:&nbsp
												</td>
												<td align="left">
													<s:property value="#data2.recid" />
												</td> 
											</tr>
											<tr>
											<td align="right">
													<s:text name="discomcode" />
													:&nbsp
												</td>
												<td align="left">
													<j:code2Name definition="#WAYIDINFO"
														code="#data2.discomcode" />
												</td>
												<td align="right">
													<s:text name="ordercreatetime" />
													:&nbsp
												</td>
												<td align="left">
													<s:date name="#data2.ordercreatetime" format="yyyy-MM-dd" />
												</td>
												<td align="right">
													<s:text name="discreatetime" />
													:&nbsp
												</td>
												<td align="left">
													<s:date name="#data2.discreatetime" format="yyyy-MM-dd" />
												</td> 
											</tr>
											<tr>
												<td align="right">
													<s:text name="arrivetime" />
													:&nbsp
												</td>
												<td align="left">
													<s:date name="#data2.arrivetime" format="yyyy-MM-dd" />
												</td>
												<td align="right">
													<s:text name="recewayid" />
													:&nbsp
												</td>
												<td align="left">
													<j:code2Name definition="#WAYIDINFO"
														code="#data2.recewayid" />
												</td>
												<td align="right">
													<s:text name="recename" />
													:&nbsp
												</td>
												<td align="left">
													<s:property value="#data2.recename" />
												</td>
												
											</tr>
											<tr>
											    <td align="right">
													<s:text name="recetel" />
													:&nbsp
												</td>
												<td align="left">
													<s:property value="#data2.recetel" />
												</td>
												<td align="right">
													<s:text name="receadd" />
													:&nbsp
												</td>
												<td align="left" colspan="3">
													<s:property value="#data2.receadd" />
												</td>
											</tr>
										</table>
										</s:if>
									</s:iterator>
								</div>
								<br>
								<div class="table_div">
									<table class="table_print_style">
										<tr class="table_style_print_head">
											<td width="19%">
												<s:text name="comname" />
											</td>
											<td width="3%">
												<s:text name="orderamt" />
											</td>
											<td width="3%">
												<s:text name="restype" />
											</td>
											<td width="15%">
												<s:text name="totalprice" />
											</td>
											<td width="45%">
												<s:text name="comnum" />
											</td>
											<td width="13%">
												<s:text name="memo" />
											</td>
										</tr>

										<s:iterator value="#data1.datas" var="data2">
											<tr class="table_style_print" align="center">
												<%-- 复合主键用“|”间隔开 --%>
												<td>
													<j:code2Name definition="$IM_FXCOMCATEGORY"
														code="#data2.comcategory" />
												</td>
												<td>
													<s:property value="#data2.orderamt" />
												</td>
												<td>
													<j:code2Name definition="COMUNIT" code="#data2.restype" />
												</td>
												<td>
													<s:i18n name="public">
														<s:text name="format.double">
															<s:param value="%{#data2.totalprice}" />
														</s:text>
													</s:i18n>
												</td>
												<td>
													<s:property value="#data2.comnum" escape="false"/>
												</td>
												<td>
													<j:code2Name definition="$FX_ORDERCOMTYPE"
														code="#data2.memo" />
												</td>
											</tr>
										</s:iterator>
										<tr class="table_style_print" align="center">
											<td>
												合计:
											</td>
											<td>
												<s:property value="#data2.totalorderamt" />
											</td>
											<td>
											</td>
											<td>
												<s:i18n name="public">
													<s:text name="format.double">
														<s:param value="%{#data2.allprice}" />
													</s:text>
												</s:i18n>
											</td>
											<td>
											</td>
											<td>
											</td>
										</tr>
									</table>
								</div>
								<br>
								<div class="table_div">
										<table class="table_print">
											<tr>
												<td align="right" width="16%">
													<s:text name="storesman" />
													:&nbsp
												</td>
												<td align="left" width="16%">
													<j:code2Name definition="#OPERATOR" code="#data2.storesman" />
												</td>
												<td align="right">
													<s:text name="outtime" />
													:&nbsp
												</td>
												<td align="left" width="16%" colspan="2">
													<s:date name="#data2.outtime" format="yyyy-MM-dd HH:mm:ss" />
												</td>
											</tr>
											<tr>
												<td>
													&nbsp;
												</td>
											</tr>
											<tr>
												<td align="right" width="15%">
													配送人 :&nbsp
												</td>
												<td align="left" width="15%">
												</td>
												<td align="right" width="15%">
													配送日期 :&nbsp
												</td>
												<td align="left" width="15%">
												</td>
												<td align="right" width="15%">
													证件号码 :&nbsp
												</td>
												<td align="left" width="25%">
												</td>
											</tr>
											<tr>
												<td>
													&nbsp;
												</td>
											</tr>
											<tr>
												<td align="right" width="15%">
													收货人 :&nbsp
												</td>
												<td align="left" width="15%">
												</td>
												<td align="right" width="15%">
													收货日期 :&nbsp
												</td>
												<td align="left" width="15%">
												</td>
												<td align="right" width="15%">
													证件号码 :&nbsp
												</td>
												<td align="left" width="25%">
												</td>
											</tr>
										</table>
								</div>
							</div>
					</s:iterator>
			<script type="text/javascript">
			
				if(isPrint){
					doPrint();
					isPrint=false;
				}
			</script>
			</div>
			</aa:zone>
		</div>
		<script language="javascript"> 
	ajaxAnywhere.getZonesToReload = function(url,submitButton) {
		if(isPrint){
			return "zonePrint";
		}else{
			return "errorZone,listZone,hiddenZone";  
		}
	}
	ajaxAnywhere.substituteFormSubmitFunction();ajaxAnywhere.formURL = formList.action;  
	ajaxAnywhere.substituteSubmitButtonsBehaviorByIDs(true,"btnQuery,btnDelete,btnConsignment,btnStartdis,btnDisover,btnConfirmSign");
</script>
	</body>

</html>
