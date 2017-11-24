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
		<title><s:text name="titleList" />
		</title>
		<script language="JavaScript" type="text/JavaScript">
        function ev_check() {
        	addfield('param._se_discomcode', '<s:text name="discomcode"/>', 'c', true, '18');
           	addfield('param._ne_recid', '<s:text name="recid"/>', 'c', true, '14');
           	addfield('param._se_orderid', '<s:text name="orderid"/>', 'c', true, '18');
           	addfield('param._se_disstate', '<s:text name="disstate"/>', 'c', true, '16');
           	addfield('param._dnl_createtime', '<s:text name="_dnl_createtime"/>', 'dt', false, '8');
           	addfield('param._dnm_createtime', '<s:text name="_dnm_createtime"/>', 'dt', false, '8');
           	return (checkval(window) && compareDate());
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
        
        function doExcel(){
        	document.getElementsByName("param._se_countyid")[0].disabled=false;
        	formList.action="<%=contextPath%>/sales/disform_exceldisstate.do";
        	formList.submit();
        	//document.getElementsByName("param._se_countyid")[0].disabled=true;
        	formList.action="<%=contextPath%>/sales/disform_disstatelist.do";
        }
        
        function openPicker(control,definition,condition) {
			if(control.name.indexOf('param._se_countyid') > -1 ) {
                if(document.all('param._se_cityid').value == "") {
    	            // 选择“分公司”前要先指定“地市公司” 
    	            alert("请先输入"+'<s:text name="cityid"/>');
    	            return;
                }else {
                    // 查询指定“分公司”下的 “服务销售中心编码”
                	condition = 'citycompid:'+ document.all('param._se_cityid').value;
                }
            }
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
			<s:form action="disform_disstatelist.do" key="formList" cssStyle="formList"
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
							<span class="table_toparea">配送单管理</span>
							<span class="table_toparea_xi">></span>
						</s:i18n>
						<span class="table_toparea_h"><s:text name="titleStateList" />
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
                			<td align="right"><s:text name="countyid"/>:</td>
                			<td align="left">
                   				<j:selector definition="#CNTYCOMPANY"  condition="citycompid:${USER.cityid}" name="param._se_countyid" mode="selector"/>
                			</td>
                			<td align="right"><s:text name="svccode"/>:</td>
                			<td align="left">
                   				<j:selector definition="#SERVCENT" name="param._se_svccode" />
               				</td>
                			<td align="right"><s:text name="mareacode"/>:</td>
                			<td align="left">
                    			<j:selector definition="#MICROAREA" name="param._se_mareacode" readonly="true"/>
               				</td>
           				</tr>
						<tr>
							<td align="right">
								<s:text name="_dnl_createtime" />:
							</td>
							<td align="left">
								<s:textfield cssStyle="style_input" name="param._dnl_createtime"
									onclick="selectDatetime();" readonly="true" />
									<font color="red">*</font>
							</td>
							<td align="right">
								<s:text name="_dnm_createtime" />:
							</td>
							<td align="left">
								<s:textfield cssStyle="style_input" name="param._dnm_createtime"
									onclick="selectDatetime();" readonly="true" />
									<font color="red">*</font>
							</td>
							<td align="right">
								<s:text name="disstate" />:
							</td>
							<td align="left">
								<j:selector name="param._se_disstate"
									definition="$FX_DISFORMSTATE" mode="selector" />
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
										onClick="doQuery('/sales/disform_disstatelist.do');">
									<input type="button" id="btnExcel" name="btnExcel"
										class="button_4" onmouseover="buttonover(this);"
										onmouseout="buttonout(this);" onfocus="buttonover(this)"
										onblur="buttonout(this)" value="导出EXCEL" onClick="doExcel();">
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
									<td>
										序号
									</td>
									<td>
										<s:text name="countyid" />
									</td>
									<td>
										<s:text name="svccode" />
									</td>
									<td>
										<s:text name="mareacode" />
									</td>
									<td>
										<s:text name="disstate" />
									</td>
									<td>
										<s:text name="num" />
									</td>
									<td>
										<s:text name="signnum" />
									</td>
									<td>
										<s:text name="unsignnum" />
									</td>
								</tr>
								<s:iterator value="dp.datas" status="state">
										<tr class="table_style_content" align="center">
										<td>
					 			 			<s:text name="#state.count"/>
					 					</td>
										<td>
											<j:code2Name definition="#CNTYCOMPANY" code="countyid" />
										</td>
										<td>
											<j:code2Name code="svccode" definition="#SERVCENT" />
										</td>
										<td>
											<j:code2Name code="mareacode" definition="#MICROAREA" />
										</td>
										<td>
											<j:code2Name definition="$FX_DISFORMSTATE" code="disstate" />
										</td>										
										<td>
											<s:property value="num" />
										</td>
										<td>
											<s:property value="signnum" />
										</td>
										<td>
											<s:property value="unsignnum" />
										</td>
									</tr>
								</s:iterator>
								<tr class="table_style_content" align="center">
									<td>
										合计
									</td>
									<td>
									</td>
									<td>
									</td>
									<td>
									</td>
									<td>
									</td>
									<td>
										<s:property value="form.totaldisformnum" />
									</td>
									<td>
										<s:property value="form.totalsignnum" />
									</td>
									<td>
										<s:property value="form.totalunsignnum" />
									</td>
								</tr>
							</table>
						</div>
					</div>
				</aa:zone>
			</s:form>
		</div>
		<script language="javascript"> 
	ajaxAnywhere.getZonesToReload = function(url,submitButton) {
		return "errorZone,listZone,hiddenZone";  
	}
	ajaxAnywhere.substituteFormSubmitFunction();ajaxAnywhere.formURL = formList.action;  
	ajaxAnywhere.substituteSubmitButtonsBehaviorByIDs(true,"btnQuery");
</script>
	</body>

</html>
