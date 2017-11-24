<%-- 
  File Name: historylist.jsp
     Author: liang.qichao 2010-08-18
     Modify: 
     Desc  : 网点资源信息统计(历史)
--%>
<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc"%>
<html>
	<head>
		<title><s:text name="titleList" />
		</title>
		<script type="text/javascript"
			src="<%=contextPath%>/js/bus/pwaycommon.js"></script>
		<script language="JavaScript" type="text/JavaScript">
        function ev_check() {
			addfield('param._dnl_statdate', '<s:text name="statdate" />&gt;=:', 'dt', false, '7');
			addfield('param._dnm_statdate', '<s:text name="statdate" />&lt;=:', 'dt', false, '7');
            return checkval(window);
        }
        function openPicker(control,definition,condition) {
        	if(control.name.indexOf('param._se_mareacode') > -1 ) {
                if(document.all('param._se_countyid').value == "") {
                	// 选择“微区域编码”前要先指定 “分公司”  这是一个跨级的查询
                    alert("请先输入"+'<s:text name="countyname"/>');
                    return;
                }else {
                    // 查询指定 “分公司”下的“微区域编码”
                    //condition = '_se_countyid:' + document.all('param._se_countyid').value;
                    condition = '';
                }
                
            }
            
            if(definition == null || definition =="") {	  	    			
    	   		alert("definition is required!");
    	   		return ;
    	    }
    	    
    	    definition = window.encodeURIComponent(definition);	    
    	    var url = contextPath +"/common/picker_list.do?definition=" + definition;
    	    
    	    // 对微区域查询时使用命名查询
    	    if (control.name.indexOf('param._se_mareacode') > -1) {
    	    
	    	    var sqlName = window.encodeURIComponent("boss.cms.microarea.queryBycountyid");
	    	    var url = url + "&sqlName=" + sqlName;
	    	    
	    	    // 查询参数使用分公司ID
	    	    var mapParam = window.encodeURIComponent("COUNTYID:" + document.all('param._se_countyid').value);
	    	    var url = url + "&mapParam=" + mapParam;
    	    }

    	    if(condition!=null) {
    	    	condition = window.encodeURIComponent(condition);
    	    	url = url +"&condition=" + condition;
    	    }
    	    
    	    url = url +"&" + new Date();

    		var rtn = window.showModalDialog(url, control, "dialogWidth:750px; dialogHeight:550px; status:no;resizable:no;");
    		
    		if( rtn == null) 
    			return false;
    			
    		var buttonID = control.name;		
    		if(buttonID == null || buttonID == "") {
    			alert("Must set the name property for this selector control!");
    			return false;
    		} 
    		
    		var selectorID = buttonID.substring(0, buttonID.indexOf("_button"));
    		var selectorTextID = selectorID + "_text";
    		
    		var codeCtrl = document.getElementById( selectorID );
    		var nameCtrl = document.getElementById( selectorTextID ); 
    		 
    		if(codeCtrl!=null) {
    			codeCtrl.value = rtn[0];
    			codeCtrl.focus();
    			}		
    		if(nameCtrl!=null) nameCtrl.value = rtn[1];
        }
        
        function doExcel() {
        	formList.action="<%=contextPath%>/resource/wayrcstat_exporthistoryxls.do";
        	if (ev_check()) {
        		formList.submit();
        	}
        	formList.action="<%=contextPath%>/resource/wayrcstat_historylist.do";
        }
        function doTxt() {
        	formList.action="<%=contextPath%>/resource/wayrcstat_exporthistorytxt.do";
        	if (ev_check()) {
        		formList.submit();
        	}
        	formList.action="<%=contextPath%>/resource/wayrcstat_historylist.do";
        }
    </script>
	</head>

	<body class="list_body"
		onload="if(window.loadforiframe) loadforiframe();">

		<div class="table_container">
			<s:form action="wayrcstat_historylist.do" key="formList"
				cssStyle="formList" theme="simple" onsubmit="return ev_check();">
				<%
					//下面的控件给Action提供数据，用来分页
				%>
				<aa:zone name="hiddenZone">
					<s:hidden name="param._orderby" />
					<s:hidden name="param._desc" />
					<s:hidden name="param._pageno" />
					<s:hidden name="param._pagesize" />
					<s:hidden name="param.queryAll" />
                    <s:hidden name="isQuery" value="true"></s:hidden>
					<input type="hidden" name="param.queryflag" value="Y" />
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
							<span class="table_toparea"><s:text name="resource" /> </span>
							<span class="table_toparea_xi">></span>
						</s:i18n>
						<span class="table_toparea">网点资源信息统计 </span>
						<span class="table_toparea_xi">></span>
						<span class="table_toparea_h">历史统计</span>
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
							<td align="right">
								<s:text name="countyname" />
								:
							</td>
							<td align="left">
								<j:selector definition="#CNTYCOMPANY" name="param._se_countyid"
									condition="citycompid:${dBAccessUser.cityid }"
									value="param._se_countyid" readonly="true"  mode="selector" />		
							</td>
							<td align="right">
								<s:text name="mareaname" />
								:
							</td>
							<td align="left">
								<j:selector definition="#MICROAREA" name="param._se_mareacode"
									readonly="true" />
							</td>
							<td width="100" height="20" align="right"
								class="form_table_right" nowrap>
								<s:text name="waymagcode" />
								:
							</td>
							<td class="form_table_left">
								<j:selector definition="#EMPLOYEE" name="param._se_waymagcode"
									condition='_ne_isnet:4;_ne_empstatus:0' mode="picker" />
							</td>
						</tr>
						<td align="right">
							<s:text name="distwayid" />
							:
						</td>
						<td align="left">
							<s:textfield cssStyle="style_input" name="param._se_wayid" />
							<input type="button" value="..." class="picker_button"
								onclick="pshowSelectWay3(this,'param._se_wayid','','','AG');this.value='...';" />
						</td>
						<td align="right">
							<s:text name="starlevel" />
							:
						</td>
						<td align="left">
							<j:selector definition="$CH_STARLEVEL" name="param._ne_starlevel" />
						</td>
						<td align="right">
							<s:text name="brand" />
							:
						</td>
						<td align="left">
							<p:smpBrand name="param._se_brand" mode="def"
								cssStyle="style_input" />
						</td>
						<tr>
						</tr>

						<td align="right">
							<s:text name="alarmlevel" />
							:
						</td>
						<td align="left">
							<j:selector definition="$FX_STOCKALARMLEVEL"
								name="param._se_alarmlevel" />
						</td>

						<td align="right">
							<s:text name="statdate" />
							&gt;=:
						</td>
						<td align="left">
							<s:textfield cssStyle="style_input" name="param._dnl_statdate"
								onclick="selectDatetime();" readonly="true" />
							<font color=red>*</font>
						</td>
						<td align="right">
							<s:text name="statdate" />
							&lt;=:
						</td>
						<td align="left">
							<s:textfield cssStyle="style_input" name="param._dnm_statdate"
								onclick="selectDatetime();" readonly="true" />
							<font color=red>*</font>
						</td>
						<tr>
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
										onClick="doQuery('/resource/wayrcstat_historylist.do');">

									<input type="button" id="btnExportexcel" name="btnExportexcel"
										class="button_4" onmouseover="buttonover(this);"
										onmouseout="buttonout(this);" onfocus="buttonover(this)"
										onblur="buttonout(this)"
										value="<s:text name="button_exportexcel"/>"
										onClick="doExcel()">

									<input type="button" id="btnExporttxt" name="btnExporttxt"
										class="button_4" onmouseover="buttonover(this);"
										onmouseout="buttonout(this);" onfocus="buttonover(this)"
										onblur="buttonout(this)"
										value="<s:text name="button_exporttxt"/>" onClick="doTxt();">
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
									<td title="<s:text name="list_title_select"/>">
										<s:text name="seqid" />
									</td>
									<td>
										<j:orderByImg href="javascript:doOrderby('statdate')">
											<s:text name="statdate" />
										</j:orderByImg>
									</td>
									<td>
										<j:orderByImg href="javascript:doOrderby('countyid')">
											<s:text name="countyname" />
										</j:orderByImg>
									</td>
									<td>
										<j:orderByImg href="javascript:doOrderby('mareacode')">
											<s:text name="mareaname" />
										</j:orderByImg>
									</td>
									<!-- 渠道经理 -->
									<td>
										<j:orderByImg href="javascript:doOrderby('waymagcode')">
											<s:text name="waymagcode" />
										</j:orderByImg>
									</td>

									<td>
										<j:orderByImg href="javascript:doOrderby('wayid')">
											<s:text name="wayid" />
										</j:orderByImg>
									</td>
									<td>
										<j:orderByImg href="javascript:doOrderby('wayname')">
											<s:text name="wayname" />
										</j:orderByImg>
									</td>
									<!-- 星级 -->
									<td>
										<j:orderByImg href="javascript:doOrderby('starlevel')">
											<s:text name="starlevel" />
										</j:orderByImg>
									</td>

									<td>
										<j:orderByImg href="javascript:doOrderby('brand')">
											<s:text name="brand" />
										</j:orderByImg>
									</td>

									<td>
										<j:orderByImg href="javascript:doOrderby('cnt3')">
											<s:text name="cnt3" />
										</j:orderByImg>
									</td>

									<td>
										<j:orderByImg href="javascript:doOrderby('cnt2')">
											<s:text name="cnt2" />
										</j:orderByImg>
									</td>
									<td>
										<j:orderByImg href="javascript:doOrderby('cnt1')">
											<s:text name="cnt1" />
										</j:orderByImg>
									</td>

									<td>
										<j:orderByImg href="javascript:doOrderby('maxstock')">
											<s:text name="maxstock" />
										</j:orderByImg>
									</td>
									<td>
										<j:orderByImg href="javascript:doOrderby('redvalue')">
											<s:text name="redvalue" />
										</j:orderByImg>
									</td>
									<td>
										<j:orderByImg href="javascript:doOrderby('yelvalue')">
											<s:text name="yelvalue" />
										</j:orderByImg>
									</td>
									<td>
										<j:orderByImg href="javascript:doOrderby('alarmlevel')">
											<s:text name="alarmlevel" />
										</j:orderByImg>
									</td>
								</tr>
								<s:iterator value="dp.datas" status="state">
									<s:if test="alarmlevel=='REDALARM'">
										<tr class="table_style_content8" align="center" bgcolor="red">
									</s:if>
									<s:elseif test="alarmlevel=='YELALARM'">
										<tr class="table_style_content" align="center"
											bgcolor="yellow"><font color="white">
									</s:elseif>
									<s:elseif test="alarmlevel=='BULEALARM'">
										<tr class="table_style_content8" align="center" bgcolor="blue">
									</s:elseif>
									<s:elseif test="alarmlevel=='GREENALARM'">
										<tr class="table_style_content8" align="center" bgcolor="green">
									</s:elseif>
									<s:else>
										<tr class="table_style_content" align="center"
											onMouseMove="this.bgColor='F0F5F9'"
											onMouseOut="this.bgColor='#ffffff'">
									</s:else>
									<td> 
										<s:text name="#state.count" /> 
									</td>
									<td>
									<s:date name="statdate" format="yyyy-MM-dd HH:mm:ss"/>
									</td>
									<td>
										<j:code2Name definition="#CNTYCOMPANY" code="countyid" />
									</td>
									<td>
										<j:code2Name definition="#MICROAREA" code="mareacode" />
									</td>
									<td>
										<s:property value="waymagcode" />
									</td>
									<td>
										<s:property value="wayid" />
									</td>
									<td>
										<s:property value="wayname" />
									</td>
									<td>
										<j:code2Name code="starlevel" definition="$CH_STARLEVEL" />
									</td>
									<td>
										<j:code2Name definition="$FX_SMPBRAND" code="brand" />
									</td>
									<td>
										<s:property value="cnt3" />
									</td>

									<td>
										<s:property value="cnt2" />
									</td>

									<td>
										<s:property value="cnt1" />
									</td>
									<td>
										<s:property value="maxstock" />
									</td>
									<td>
										<s:property value="redvalue" />
									</td>
									<td>
										<s:property value="yelvalue" />
									</td>
									<td>
										<j:code2Name definition="$FX_STOCKALARMLEVEL"
											code="alarmlevel" />
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
		</div>
		<script language="javascript"> 
	ajaxAnywhere.getZonesToReload = function(url,submitButton) {
		return "errorZone,listZone,hiddenZone";  
	}
	ajaxAnywhere.substituteFormSubmitFunction();ajaxAnywhere.formURL = formList.action;  
	ajaxAnywhere.substituteSubmitButtonsBehaviorByIDs(true,"btnQuery,btnDelete");
	function doExportexcel(url){
	}
	function doExporttxt(url){
	}
</script>
	</body>
</html>
