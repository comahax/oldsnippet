<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc" %> 

 
<html>
<head>
    <title><s:text name="titleList"/></title>
    <script type="text/javascript"
			src="<%=contextPath%>/js/bus/pwaycommon.js"></script>
	<script type="text/javascript" src="<%= contextPath %>/js/pub/list.js"></script>
</head>
<body  class="list_body" onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<s:form action="checkedapplystat_listdetail.do" cssStyle="formList" key="formList"
			method="post" theme="simple" >
			
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
			<span class="table_toparea"><s:text name="currentPos"/> </span>
			<span class="table_toparea_xi">></span>
			<span class="table_toparea"><s:text name="channel"/> </span>
			<span class="table_toparea_xi">></span>
			</s:i18n>
			<span class="table_toparea_h">查看已授权网点数据</span>
			<span class="button_Help" onclick="openword('<s:text name="helpTitle"/>','<s:text name="helpContent"/>')"><s:i18n name="public"><s:text name="help"/></s:i18n></span>
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
				<td align="center">渠道编码:</td>
				<td align="left">
					<s:textfield cssStyle="style_input" name="param._sk_wayid" />
					<input type="button" value="..." class="picker_button"
						onclick="pshowSelectWay3(this,'param._sk_wayid','','','AG');this.value='...';" />
				</td>
				<td align="center">渠道名称:</td>
				<td align="left">
					<s:textfield cssStyle="style_input" name="param._sk_wayname" />
				</td>
			</tr>
			<tr>
				<td align="center">查询范围:	</td>
				<td align="left">
					<s:select name="param.queryRange" theme="simple" listKey="key"
									listValue="value" cssStyle="select"
									list="#{'all':'全部', 'add':'新增'}"	/>
				</td>
				<td align="center">分公司:</td>
				<td align="left">
					<j:selector definition="#CNTYCOMPANY" condition="citycompid:${USER.cityid}" name="param._se_countyid" mode="selector"/>
				</td>
			</tr>
        </table>
    </div>

    <div class="table_div">
        <table class="table_button_list">
            <tr>
                <td width="100%" align="center">
                   	<s:i18n name="public">
                    <input type="button" id="btnQuery" name="btnQuery" class="button_Query" onmouseover="buttonover(this);"
	                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
	                        value="<s:text name="button_search"/>" onClick="doQueryData('/channel/checkedapplystat_listdetail.do');">
                    
                    <input type="button" id="btnExportexce6" name="btnExportexce6" class="button_4" onmouseover="buttonover(this);"
	                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
	                        value="导出EXCEL" onClick="doExportExcelWay()">
                    
                    <input type="button" id="btnReturn" name="btnReturn" class="button_Back" onmouseover="buttonover(this);" 
                    	   onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<s:text name="button_return"/>" onclick="doReturnList('/channel/checkedapplystat_list.do')">
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
										<s:text name="wayid" />
									</td>
									<td>
										<s:text name="wayname" />
									</td>
									
									<td>
										<s:text name="waysubtype" />
									</td>
									<td>
										<s:text name="upperwayid" />
									</td>
									<td>
										<s:text name="latitude" />
									</td>
									<td>
										<s:text name="longtitude" />
									</td>
									<td>
										<s:text name="starlevel" />
									</td>
									<td>
										<s:text name="pt" />
									</td>
									<td>
										<s:text name="isstraitprd" />
									</td>
									<td>
										<s:text name="catetype" />
									</td>
									<td>
										<s:text name="cityid" />

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
										<s:text name="adtypecode" />
									</td>
									<td>
										<s:text name="adacode" />
									</td>
									<td>
										<s:text name="formtype" />
									</td>
									<td>
										申请时间
									</td>
									<td>
										<s:text name="logiscode" />
									</td>
									<td>
										<s:text name="waymagcode" />
									</td>
									<td>
										<s:text name="bchlevel" />
									</td>
									<td>
										<s:text name="waystate" />
									</td>
									<td>
										<s:text name="address" />
									</td>
								</tr>
								<s:iterator value="dp.datas">
									<tr class="table_style_content" align="center"
										onMouseMove="this.bgColor='F0F5F9'"
										onMouseOut="this.bgColor='#ffffff'">
										
										<td>
											<s:property value="wayid" />
										</td>
										<td>
											<s:property value="wayname" />
										</td>
										<td>
											<j:code2Name definition="WAYSUBTYPE" code="waysubtype" />
										</td>
										<td>
											<j:code2Name code="upperwayid" definition="#WAY" />
										</td>
										<td>
											<s:property value="latitude" />
										</td>
										<td>
											<s:property value="longtitude" />
										</td>
										<td>
											<j:code2Name code="starlevel" definition="$CH_STARLEVEL" />
										</td>
										<td>
											<j:code2Name code="pt" definition="$CH_PT" />
										</td>
										<td>
											<j:code2Name code="isstraitprd" definition="$CH_STRAITPRD" />
										</td>
										<td>
											<j:code2Name code="catetype" definition="$CH_CATETYPE" />
										</td>
										<td>
											<j:code2Name code="cityid" definition="#CITYCOMPANY" />
										</td>
										<td>
											<j:code2Name code="countyid" definition="#CNTYCOMPANY" />
										</td>
										<td>
											<j:code2Name code="svccode" definition="#SERVCENT" />
										</td>
										<td>
											<j:code2Name code="mareacode" definition="#MICROAREA" />
										</td>
										<td>
											<j:code2Name code="adtypecode" definition="$CH_ADTYPE" />
										</td>
										<td>
											<j:code2Name code="adacode" definition="#ADIMAREA" />
										</td>
										<td>
											<j:code2Name code="formtype" definition="$CH_FORMTYPE" />
										</td>
										<td>
											<s:date name="starttime" format="yyyy-MM-dd" />
										</td>
										<td>
											<s:property value="logiscode" />
										</td>
										<td>
											<s:property value="waymagcode" />
										</td>
										<td>
											<j:code2Name code="bchlevel" definition="$CH_BCHLEVEL" />
										</td>
										<td>
											<j:code2Name code="waystate" definition="$CH_WAYSTATE" />
										</td>
										<td>
											<s:property value="address" />
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
</body>
</html>
<script language="JavaScript">
	function ev_checkval() {
		
		return checkval(window);
	}
	
	function doQueryData(cmd){
		
		formList.action = "<%=contextPath%>/channel/checkedapplystat_listdetail.do";
		formList.submit();
	}
	
	function doReturnList(cmd){
		
		formList.action = "<%=contextPath%>/channel/checkedapplystat_list.do";
		formList.submit();
	}
	
	function doExportExcelWay(){
    	formList.action="<%=contextPath%>/channel/checkedapplystat_exportExcelWay.do";
        formList.submit();
        formList.action="<%=contextPath%>/channel/checkedapplystat_list.do";
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