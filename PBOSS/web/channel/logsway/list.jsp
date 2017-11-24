<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc"%>
<html>
	<head>
		<title><s:text name="logistitleList" />
		</title>
		<script type="text/javascript" src="<%=contextPath%>/js/bus/pwaycommon.js"></script>
		<script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            addfield('param._se_wayid', '<s:text name="wayid"/>', 'c', true, 20);
            addfield('param._se_upperwayid', '<s:text name="upperwayid"/>', 'c', true, 20);
            addfield('param._sk_wayname', '<s:text name="wayname"/>', 'c', true, 256);
            return checkval(window);
        }
        function doBatch(){
        	formList.action="<%=contextPath%>/channel/logsway/import.jsp";
        	formList.submit();
        }
        function doTxt(){
        	formList.action="<%=contextPath%>/channel/way_logstxt.do";
        	formList.submit();
        	formList.action="<%=contextPath%>/channel/way_logslist.do";
        }
        function openPicker(control,definition,condition) {
            if(control.name.indexOf('param._se_svccode') > -1 ) {
                if(document.all('param._se_countyid').value == "") {
    	            // 选择“服务销售中心编码”前要先指定“分公司” 
    	            alert("请先输入"+'<s:text name="countyid"/>');
    	            return;
                }else {
                    // 查询指定“分公司”下的 “服务销售中心编码”
                	condition = '_se_countyid:'+ document.all('param._se_countyid').value;
                }
            }
            if(control.name.indexOf('param._se_mareacode') > -1 ) {
                if(document.all('param._se_svccode').value == "") {
                	// 选择“微区域编码”前要先指定 “服务销售中心编码”
                    alert("请先输入"+'<s:text name="svccode"/>');
                    return;
                }else {
                    // 查询指定 “服务销售中心编码”下的“微区域编码”
                    condition = '_se_svccode:' + document.all('param._se_svccode').value;
                }
                
            }
    	    if(definition == null || definition =="") {	  	    			
    	   		alert("definition is required!");
    	   		return ;
    	    }

    	    definition = window.encodeURIComponent(definition);	    
    	    var url = contextPath +"/common/picker_list.do?definition=" + definition;	

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
    </script>
	</head>

	<body class="list_body"
		onload="if(window.loadforiframe) loadforiframe();">
		<div class="table_container">
			<s:form action="way_logslist.do" key="formList" cssStyle="formList"
				theme="simple" onsubmit="return ev_check();">

				<aa:zone name="hiddenZone"><s:hidden name="param._orderby"/>
				<s:hidden name="param._desc" />
				<s:hidden name="param._pageno" />
				<s:hidden name="param._pagesize" />
				<s:hidden name="param.queryAll" />
				<input type="hidden" name="_rowcount" value="<s:property value="dp.rowCount" />"/></aa:zone>
				<input type="hidden" name="_se_waysubtype" value="LOGS" />

				<div class="table_top">
					<div class="table_topleft"></div>
					<div class="table_toparea_w">
						<s:i18n name="public">
							<span class="table_toparea"><s:text name="currentPos" />
							</span>
							<span class="table_toparea_xi">></span>
							<span class="table_toparea"><s:text name="channel" /> </span>
							<span class="table_toparea_xi">></span>
						</s:i18n>
						<span class="table_toparea_h"><s:text name="logistitleList" />
						</span>
						<span class="button_Help"
							onclick="openword('<s:text name="logistitleList"/>','<s:text name="helpListLOGS"/>')"><s:i18n
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
								<s:text name="wayid" />
								:
							</td>
							<td align="left">
								<s:textfield cssStyle="style_input" name="param._sk_wayid" /><input type="button" value="..." class="picker_button" onclick="pshowSelectWay3(this,'param._sk_wayid','','','AG');this.value='...';" />
							</td>
							<td align="center">
								<s:text name="wayname" />
								:
							</td>
							<td align="left">
								<s:textfield cssStyle="style_input" name="param._sk_wayname" />
							</td>
						</tr>
						<tr>
							<td align="center">
								<s:text name="upperwayid" />
								:
							</td>
							<td align="left">
								<s:textfield cssStyle="style_input" name="param._se_upperwayid" /><input type="button" value="..." class="picker_button" onclick="pshowSelectWay3(this,'param._se_upperwayid','','','');this.value='...';" />
							</td>
							<td align="center">
								<s:text name="cooperator" />
								:
							</td>
							<td align="left">
								<j:selector name="param._ne_cooperator"
									definition="$CH_COOPERATOR" />
							</td>
						</tr>
						<tr>
							<td align="center">
								<s:text name="cityid2" />
								:
							</td>
							<td align="left">
								<j:selector definition="#CITYCOMPANY" mode="selector" name="param._se_cityid" condition="citycompid:${dBAccessUser.cityid }" value="%{dBAccessUser.cityid}"  disabled="true"/>
							</td>
							<td align="center">
								<s:text name="subcomp" />
								:
							</td>
							<td align="left">
								<j:selector definition="#CNTYCOMPANY" name="param._se_countyid" condition="countycompid:${dBAccessUser.cityid }" readonly="true"/>
							</td>
						</tr>
						<tr>
							<td align="center">
								<s:text name="svcname" />
								:
							</td>
							<td align="left">
								<j:selector definition="#SERVCENT" name="param._se_svccode" readonly="true"/>
							</td>
							<td align="center">
								<s:text name="mareaname" />
								:
							</td>
							<td align="left">
								<j:selector definition="#MICROAREA" name="param._se_mareacode" readonly="true"/>
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
										onClick="doQuery('/channel/way_logslist.do');">

									<input type="button" id="btnNew" name="btnNew"
										class="button_New" onmouseover="buttonover(this);"
										onmouseout="buttonout(this);" onfocus="buttonover(this)"
										onblur="buttonout(this)" value="<s:text name="button_new"/>"
										onClick="doNew('/channel/way_logsnew.do')">

									<input type="button" id="btnBatch" name="btnBatch"
										class="button_2" onmouseover="buttonover(this);"
										onmouseout="buttonout(this);" onfocus="buttonover(this)"
										onblur="buttonout(this)" value="导入" onClick="doBatch();">

									<input type="button" id="btnExporttxt" name="btnExporttxt"
										class="button_4" onmouseover="buttonover(this);"
										onmouseout="buttonout(this);" onfocus="buttonover(this)"
										onblur="buttonout(this)"
										value="<s:text name="button_exporttxt"/>" onClick="doTxt();">

									<input type="button" id="btnDelete" name="btnDelete"
										class="button_Delete" onmouseover="buttonover(this);"
										onmouseout="buttonout(this);" onfocus="buttonover(this)"
										onblur="buttonout(this)"
										value="<s:text name="button_delete"/>"
										onClick="doDelete('/channel/way_logsdelete.do')">
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
									<%--<s:i18n name="public">
										<!--  <td>
											<s:text name="column_operate" />
										</td>-->
										<td>
											<s:text name="column_operate" />
										</td>
									</s:i18n>
									--%><td title="<s:text name="list_title_select"/>">
										<input type="checkbox" name="allbox" onclick="checkAll();" />
									</td>
									<td>
										<j:orderByImg href="javascript:doOrderby('wayid')">
											<s:text name="WAYID" />
										</j:orderByImg>
									</td>
									<td>
										<j:orderByImg href="javascript:doOrderby('wayname')">
											<s:text name="WAYNAME" />
										</j:orderByImg>
									</td>
									<td>
										<s:text name="upperwayid" />
									</td>
									<td>
										<s:text name="cooperator1" />
									</td>
									<td>
										<s:text name="cityid"/>
									</td>
									<td>
										<s:text name="countyid1"/>
									</td>
									<td>
										<s:text name="svccode" />
									</td>
									<td>
										<s:text name="mareacode" />
									</td>
									<td>
										<s:text name="adacode" />
									</td>
									<td>
										<s:text name="officetel2" />
									</td>
								</tr>
								<s:iterator value="dp.datas">
									<tr class="table_style_content" align="center"
										onMouseMove="this.bgColor='F0F5F9'"
										onMouseOut="this.bgColor='#ffffff'">
										<%-- 复合主键用“|”间隔开 --%>
										<!-- <td>
											<s:text name="wayinfo" />
										</td> -->
										<%--<td>
											<a
												href='<s:url action="way_ListByLink.do">
	                         					<s:param name="param._se_logiscode" value="wayid"/>
	                     						</s:url>'>
											<s:text name="salelist" /></a>
										</td>
										--%><td>
											<input type="checkbox" name="param._selectitem"
												value="<s:property value="wayid"/>" onclick="checkOne();">
										</td>
										<td>
											<a
												href='<s:url action="way_logsedit.do">
	                         					<s:param name="param._pk" value="wayid"/>
	                     						</s:url>'>
												<s:property value="wayid" /></a>
											
										</td>
										<td>
											<s:property value="wayname" />
										</td>
										<td>
											<s:property value="upperwayid" />
										</td>
										<td>
											<j:code2Name code="cooperator" definition="$CH_COOPERATOR" />
										</td>
										<td><j:code2Name definition="#CITYCOMPANY" code="cityid"/></td>
                     					<td><j:code2Name definition="#CNTYCOMPANY" code="countyid"/></td>
                     					<td><j:code2Name definition="#SERVCENT" code="svccode"/></td>
										<td>
											<j:code2Name definition="#MICROAREA" code="mareacode"/>
										</td>
										<td>
											<j:code2Name definition="#ADIMAREA" code="adacode"/>
										</td>
										<td>
											<s:property value="officetel" />
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
</script>
	</body>
</html>
