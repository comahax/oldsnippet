<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc" %>
<html>
<head>
    <title>套卡包装打印</title>
    <style id="style1">
		.table_packprint_style {
			width:98%;
			border-top:#CDCDCD solid 1px;
			border-left:#CDCDCD solid 1px;
			border-collapse:collapse;
			margin-top:1px;
			padding-bottom:1px;
		}
		.table_packprint_style th {
			width:98%;
			height:22px;
		  	font-size: 12px;
			font-weight: bold;
			color: #2F3732;
			border-right:#CDCDCD solid 1px;
			border-bottom:#CDCDCD solid 1px;
			text-align:center;
			padding:2px 5px 0px 5px;
			font-family: Geneva, Arial, Helvetica, sans-serif;	
			vertical-align:middle;
		}
		.table_packprint_style td {
			width:50%;
			text-align:center;
			font-size:10px;
			padding:2px 5px 0px 5px;
			border-right:#CDCDCD solid 1px;
			border-bottom:#CDCDCD solid 1px;
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
	<object id="LODOP_OB" classid="clsid:2105C259-1E0C-4534-8141-A753534CB4CA" width=0 height=0></object>
    <script language="javascript" src="<%=contextPath%>/js/LodopFuncs.js"></script>
    <script type="text/javascript" src="<%=contextPath%>/js/bus/pwaycommon.js"></script>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            addfield('param._se_batchno', '商品批次', 'c', false, '32');
            return checkval(window);
        }
        function doPreparedPrint(cmdQuery) {
        	
	        	if(cmdQuery != null && cmdQuery !="") {
	        		formList.action = contextPath + cmdQuery;
	        	}
	       		if(document.formList.onsubmit == null || document.formList.onsubmit())
	       			document.formList.submit();
        }
        var LODOP = getLodop(document.getElementById('LODOP_OB'),document.getElementById('LODOP_EM'));
		function doPrint(){
			var divs = $("div[id*='printPage']");
			LODOP.PRINT_INIT("包号打印");
			var strBodyStyle = "<style>" + document.getElementById("style1").innerHTML + "</style>";
			for(i=0; i<divs.length; i++) {
				if (i > 0) {
					LODOP.NewPageA();
				}
				LODOP.ADD_PRINT_HTM(20, 30, "100%", "96%", strBodyStyle + "<body>" + divs[i].innerHTML + "</body>");
			}
			LODOP.SET_SHOW_MODE("HIDE_PAPER_BOARD", true);//隐藏走纸板
			LODOP.PREVIEW();
		}
    </script>
</head>

<body class="list_body" onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<s:form action="compack_list.do" key="formList" cssStyle="formList" theme="simple" onsubmit="return ev_check();">

	<div class="table_top">
		<div class="table_topleft"></div>
		<div class="table_toparea_w">
			<s:i18n name="public">
			<span class="table_toparea"><s:text name="currentPos"/> </span>
			<span class="table_toparea_xi">></span>
			<span class="table_toparea"><s:text name="resource"/> </span>
			<span class="table_toparea_xi">></span>
			</s:i18n>
			<span class="table_toparea_h">套卡包装打印</span>
			<%--<span class="button_Help" onclick="openword('<s:text name="helpTitle"/>','<s:text name="helpContent"/>')"><s:i18n name="public"><s:text name="help"/></s:i18n></span>--%>
		</div>
	</div>
    
    <aa:zone name="errorZone">
		<div class="error_text" >
			<table class="error_text">
				<s:actionerror /><s:actionmessage/>
			</table>
		</div>
    </aa:zone>

	<div class="table_div">
        <table class="table_normal">
        	<tr>
        		<td align="right">商品批次:&nbsp</td>
                <td align="left" colspan="2">
					<s:textfield cssStyle="style_input" name="param._se_batchno" maxlength="32"/>
					<font color=red>*</font>
                </td>
        	</tr>
        	<tr>
        		<td align="right">商品标识:&nbsp;</td>
                <td align="left" colspan="2">
                    <j:Comidtree name="param._ne_comid" condition="comclassid:3;" definition="#COMSYSTEM" nameOnly="true" readonly="true"/>
                </td>
        	</tr>
        	<tr>
        		<td align="right">资源归属渠道:&nbsp;</td>
                <td align="left" colspan="2">
                    <s:textfield cssStyle="style_input" name="param._se_wayid" readonly="true"/><input type="button" value="..." class="picker_button" onclick="pshowSelectWay3(this,'param._se_wayid');this.value='...';" />
                </td>
        	</tr>
            <tr>
                <td align="right">箱号:&nbsp</td>
                <td width="30%" align="left">
					<s:textfield cssStyle="style_input" name="param._ssw_boxnum" maxlength="32"/>
                </td>
                <td align="left">
                    <input type="button" id="btnTrunkPrint" name="btnTrunkPrint" class="button_4" onmouseover="buttonover(this);" 
                           onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="箱号打印" onclick="doPreparedPrint('/resource/comressmp_printTrunkOrBox.do?mode=trunk')">
                    <input type="button" id="btnBoxPrint" name="btnBoxPrint" class="button_4" onmouseover="buttonover(this);" 
                    	   onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="盒号打印" onclick="doPreparedPrint('/resource/comressmp_printTrunkOrBox.do?mode=box')">
                    <input type="button" id="btnPackPrint" name="btnPackPrint" class="button_4" onmouseover="buttonover(this);" 
                    	   onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="包号打印" onclick="doPreparedPrint('/resource/comressmp_printPackage.do')">
                </td>
            </tr>
        </table>
    </div>
    
</s:form>

	<aa:zone name="zonePrint">
		<div id="ajax" style="display:none">
			<s:if test="dp != null">
			<%
				if(request.getAttribute("rowCount") != null) {
					double rowCount = ((Integer)request.getAttribute("rowCount")).doubleValue();
					// 打印总页数
					int printTotalPage = new Double(Math.ceil(rowCount/12)).intValue();
					request.setAttribute("printTotalPage",printTotalPage);
				}
			%>     
			  
			<s:bean name="org.apache.struts2.util.Counter" id="counter"> 
				 <s:param name="first" value="1"/>
				 <s:param name="last" value="#request.printTotalPage"/> 
				 <s:iterator status="pageno">
				 	<s:if test="(#pageno.index+1)*12 > #request.rowCount">
				 		<s:set name="endRecord" value="#request.rowCount-1" scope="request"/>
				 	</s:if>
				 	<s:else>
				 		<s:set name="endRecord" value="(#pageno.index+1)*12-1" scope="request"/>
				 	</s:else>
				 	<div id="printPage<s:property value='#pageno.index+1'/>">
						<s:iterator value="dp.datas" var="data" status="stat" begin="(#pageno.index*12)" end="#request.endRecord">
							<s:if test = "%{(#stat.count)%3 == 1 || #stat.count-1 == 0}">
								<table style="margin-left:20px;width:98%" cellspacing="10px">
									<tr>
									</s:if>
										<td style="width:30%;vertical-align:top;">
								
												<table class="table_packprint_style" >
													<tr>
														<th colspan="2">
															包号:&nbsp;
															<s:property value="param._se_batchno"/>-
															<s:property value="#data.pack_number"/>
														</th>
													</tr>
													<s:iterator value="#data.mobileno" var="mobilenoList" status="state">
														<s:if test="%{#state.count % 2 == 1}">
															<tr class="table_style_print_head">	
																<td>
																	<s:property value="#data.mobileno.get(#state.count-1)"/>
																</td>
																<td>
																	<s:property value="#data.mobileno.get(#state.count)"/>
																</td>
															</tr>
														</s:if>
														</s:iterator>
												</table>
										</td>
							<s:if test = "%{(#stat.count)%3 == 0 || #stat.last == true}">
								<td>
								</td>
								</tr>
								</table>
							</s:if>
							</s:iterator>
				 	</div>
				 </s:iterator>
				<script language="javascript" type="text/javascript">
					doPrint();
				</script>
			</s:bean>
			</s:if>
		</div>
	</aa:zone>
</div>
<%--<script language="javascript"> 
	ajaxAnywhere.getZonesToReload = function(url,submitButton) {
		return "errorZone,zonePrint";  
	}
	ajaxAnywhere.substituteFormSubmitFunction();ajaxAnywhere.formURL = formList.action;  
	ajaxAnywhere.substituteSubmitButtonsBehaviorByIDs(true,"btnTrunkPrint,btnBoxPrint");
	
</script> 

--%></body>
</html>
