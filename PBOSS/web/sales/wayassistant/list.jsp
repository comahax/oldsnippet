<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc" %>
<html>
<head>
    <title><s:text name="titleList"/></title>
    <script type="text/javascript" src="<%=contextPath%>/js/bus/pwaycommon.js"></script>
    <script language="JavaScript" type="text/JavaScript">
     function doBatch(){
        	formList.action="<%=contextPath%>/sales/wayassistant/wayassistant_import.jsp";
        	formList.submit();
        }
        function ev_check() {
            addfield('param._se_wayid', '<s:text name="wayid"/>', 'c', true, '18');
            addfield('param._ne_canorder', '<s:text name="canorder"/>', 'f', true, '3');
            addfield('param._ne_printinvoice', '<s:text name="printinvoice"/>', 'f', true, '3');
            addfield('param._se_paytype', '<s:text name="paytype"/>', 'c', true, '16');
            addfield('param._se_delitype', '<s:text name="delitype"/>', 'c', true, '16');
            addfield('param._ne_orderbetterno', '<s:text name="orderbetterno"/>', 'f', true, '3');
            return checkval(window);
        }
        
        function doExportTxt(cmd){
 			var actionUrl = formList.action;
			formList.action = contextPath + cmd;
      		formList.submit();
      		formList.action = actionUrl;
		} 
		
		function openPicker(control,definition,condition) {
			if(control.name.indexOf('param._se_countyid') > -1 ) {
                if(document.all('param._se_cityid').value == "") {
    	            // 选择“分公司”前要先指定“地市公司” 
    	            alert("请先输入"+'<s:text name="COUNTYID"/>');
    	            return;
                }else {
                    // 查询指定“分公司”下的 “服务销售中心编码”
                	condition = 'citycompid:'+ document.all('param._se_cityid').value;
                }
            }
            if(control.name.indexOf('param._se_svccode') > -1 ) {
                if(document.all('param._se_countyid').value == "") {
    	            // 选择“服务销售中心编码”前要先指定“分公司” 
    	            alert("请先输入"+'<s:text name="COUNTYID"/>');
    	            return;
                }else {
                    // 查询指定“分公司”下的 “服务销售中心编码”
                	condition = '_se_countyid:'+ document.all('param._se_countyid').value;
                }
            }
            if(control.name.indexOf('param._se_mareacode') > -1 ) {
                if(document.all('param._se_svccode').value == "") {
                	// 选择“微区域编码”前要先指定 “服务销售中心编码”
                    alert("请先输入"+'<s:text name="SVCCODE"/>');
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

<body class="list_body" onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<s:form action="wayassistant_list.do" key="formList" cssStyle="formList" theme="simple" onsubmit="return ev_check();">
	<%//下面的控件给Action提供数据，用来分页%>
    <aa:zone name="hiddenZone"><s:hidden name="param._orderby"/>
    <s:hidden name="param._desc"/>
    <s:hidden name="param._pageno"/>
    <s:hidden name="param._pagesize"/>
    <s:hidden name="param.queryAll"/>
    <input type="hidden" name="_rowcount" value="<s:property value="dp.rowCount" />"/></aa:zone>
    
	<div class="table_top">
		<div class="table_topleft"></div>
		<div class="table_toparea_w">
			<s:i18n name="public">
			<span class="table_toparea"><s:text name="currentPos"/> </span>
			<span class="table_toparea_xi">></span>
			<span class="table_toparea"><s:text name="sales"/> </span>
			<span class="table_toparea_xi">></span>
			</s:i18n>
			<span class="table_toparea_h"><s:text name="titleList"/></span>
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
                <td align="center"><s:text name="wayid"/>:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._se_wayid" /><input type="button" value="..." class="picker_button" onclick="pshowSelectWay3(this,'param._se_wayid','','','AG');this.value='...';" />
                </td>
                 <td align="center"><s:text name="COUNTYID"/>:</td>
                 <input type="hidden"  name="param._se_cityid" value="<s:property value='dBAccessUser.cityid'/>"/>
                <td align="left">
                    <j:selector definition="#CNTYCOMPANY" name="param._se_countyid"/>
                </td>
                 </tr>
                 
                   <tr>
                <td align="center"><s:text name="SVCCODE"/>:</td>
                <td align="left">
                     <j:selector name="param._se_svccode" definition="#SERVCENT" />
                </td>
                 <td align="center"><s:text name="MAREACODE"/>:</td>
                <td align="left">
                    <j:selector name="param._se_mareacode" definition="#MICROAREA" />
                </td>
                 </tr>
            <tr>
                  <td align="center"><s:text name="WAYSTATE"/>:</td>
                <td align="left">
                    <j:selector name="param._ne_waystate" definition="$CH_VALIDFLAG" />
                </td>
                <td align="center"><s:text name="canorder"/>:</td>
                <td align="left">
                    <j:selector name="param._ne_canorder" definition="$IM_YESNO10" />
                </td>
            </tr>
            <tr>
            
                <td align="center"><s:text name="printinvoice"/>:</td>
                <td align="left">
                    <j:selector name="param._ne_printinvoice" definition="$IM_YESNO10" />
                </td>
                <td align="center"><s:text name="paytype"/>:</td>
                <td align="left">
                    <j:selector name="param._se_paytype" definition="$FX_PAYTYPE" />
                </td>
             </tr>
             <tr>
                <td align="center"><s:text name="delitype"/>:</td>
                <td align="left">
                    <j:selector name="param._se_delitype" definition="$FX_DELITYPE" />
                </td>
                <td align="center"><s:text name="orderbetterno"/>:</td>
                <td align="left">
                    <j:selector name="param._ne_orderbetterno" definition="$IM_YESNO10" />
                </td>
            </tr>
        </table>
    </div>
    
    <div class="table_div">
		<table class="table_button_list">
			<tr>
				<td>
                	<s:i18n name="public">
                	<input type="button" id="btnQuery" name="btnQuery" class="button_Query" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="<s:text name="button_search"/>" onClick="doQuery('/sales/wayassistant_list.do');">
                	
                    <input type="button" id="btnNew" name="btnNew" class="button_New" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="<s:text name="button_new"/>" onClick="doNew('/sales/wayassistant_new.do')">
                    
                    <input type="button" id="btnDelete" name="btnDelete" class="button_Delete" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="<s:text name="button_delete"/>" onClick="doDelete('/sales/wayassistant_delete.do')">
                   
                    <input type="button" id="btnBatch" name="btnBatch" class="button_New" onmouseover="buttonover(this);"
	                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
	                            value="导入" onClick="doBatch();">
	                            
                     <input type="button" id="btnExporttxt" name="btnExporttxt"
							class="button_4" onmouseover="buttonover(this);"
							onmouseout="buttonout(this);" onfocus="buttonover(this)"
							onblur="buttonout(this)"
							value="<s:text name="button_exporttxt"/>" onClick="doExportTxt('/sales/wayassistant_wayassistantExportTxt.do');">
                
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
                    <input type="checkbox" name="allbox" onclick="checkAll();"/>
                </td>
                </s:i18n>
                <td>
                    <j:orderByImg href="javascript:doOrderby('wayid')"><s:text name="wayid"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('wayid')"><s:text name="way"/></j:orderByImg>                 
                </td>
                
                <!-- 分公司 -->
                <td>
                     <j:orderByImg href="javascript:doOrderby('wayid')"><s:text name="COUNTYID"/></j:orderByImg> 
                  <!--  <j:orderByImg href="javascript:doOrderby('wayid')">分公司</j:orderByImg>      -->           
                </td>
                
                <!-- 服务营销中心 -->
                <td>
                     <j:orderByImg href="javascript:doOrderby('wayid')"><s:text name="SVCCODE"/></j:orderByImg>
                    <!-- <j:orderByImg href="javascript:doOrderby('wayid')">服务营销中心</j:orderByImg>  -->       
                </td>
                
                <!-- 微区域 -->
                <td>
                     <j:orderByImg href="javascript:doOrderby('wayid')"><s:text name="MAREACODE"/></j:orderByImg>
                     <!--<j:orderByImg href="javascript:doOrderby('wayid')">微区域</j:orderByImg>  -->        
                </td>
                
                <!-- 网点状态 -->
                <td>
                     <j:orderByImg href="javascript:doOrderby('wayid')"><s:text name="WAYSTATE"/></j:orderByImg>
                  <!--  <j:orderByImg href="javascript:doOrderby('wayid')">网点状态</j:orderByImg>  -->                
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('canorder')"><s:text name="canorder"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('printinvoice')"><s:text name="printinvoice"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('paytype')"><s:text name="paytype"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('delitype')"><s:text name="delitype"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('orderbetterno')"><s:text name="orderbetterno"/></j:orderByImg>                 
                </td>
            </tr>
            <s:iterator value="dp.datas">
                 <tr class="table_style_content" align="center" onMouseMove="this.bgColor='F0F5F9'" onMouseOut="this.bgColor='#ffffff'">
					 <%-- 复合主键用“|”间隔开 --%>
                     <td>
                         <input type="checkbox" name="param._selectitem" value="<s:property value="wayid"/>" onclick="checkOne();">
                     </td>
                     <td><a href='<s:url action="wayassistant_edit.do">
	                         <s:param name="param._pk" value="wayid"/>
	                     	</s:url>'>
							<s:property value="wayid"/>
                         </a>
					 </td>
					 <td><j:code2Name definition="#WAY" code="wayid" /></td>
					 <!-- 分公司 -->
					 <td><j:code2Name definition="#CNTYCOMPANY" code="countyid" /></td>
					 <!-- 服务营销中心 -->
					 <td><j:code2Name definition="#SERVCENT" code="svccode" /></td>
					 <!-- 微区域 -->
					 <td><j:code2Name definition="#MICROAREA" code="mareacode" /></td>
					 <!-- 网点状态 -->
					 <td> <j:code2Name definition="$CH_VALIDFLAG" code="waystate" /></td>
					 
                     <td><j:code2Name definition="$IM_YESNO10" code="canorder" /></td>
                     <td><j:code2Name definition="$IM_YESNO10" code="printinvoice" /></td>
                     <td><j:code2Name definition="$FX_PAYTYPE" code="paytype" /></td>
                     <td><j:code2Name definition="$FX_DELITYPE" code="delitype" /></td>
                     <td><j:code2Name definition="$IM_YESNO10" code="orderbetterno" /></td>
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
