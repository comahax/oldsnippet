<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc" %>
<html>
<head>
    <title><s:text name="titleList"/></title>
    <script language="JavaScript" type="text/JavaScript">
	function ev_check() {
		addfield('param._se_countyid', '<s:text name="countyid"/>', 'c', true, '14');
		addfield('param._se_svccode', '<s:text name="svccode"/>', 'c', true, '14');
		addfield('param._se_mareacode', '<s:text name="mareacode"/>', 'c', true, '14');
		addfield('param._ne_starlevel', '<s:text name="starlevel"/>', 'f', true, '2');
		addfield('param._se_orderave', '<s:text name="orderave"/>', 'c', true, '16');
		addfield('param._se_alarmlevel', '<s:text name="alarmlevel"/>', 'c', true, '16');
		addfield('param._se_orderstate', '<s:text name="orderstate"/>', 'c', true, '16');
		addfield('param._se_brand', '<s:text name="brand"/>', 'c', true, '16');
		addfield('param._se_comcategory', '<s:text name="comcategory"/>', 'c', true, '20');
		addfield('param._dnm_createtime', '<s:text name="_dnm_createtime"/>', 'dt', false, '7');
		addfield('param._dnl_createtime', '<s:text name="_dnl_createtime"/>', 'dt', false, '7');
		return (checkval(window) && compareDate());
	}
	function compareDate(){
        var startTime = document.getElementById('param._dnl_createtime').value;
        var endTime = document.getElementById('param._dnm_createtime').value;

        if(startTime != '' && endTime != '' &&  startTime>endTime){
        var alertstr = '<span class=\'errorkey\'><span style=\'color:#F00; font-size:12px;\'>[<s:text name="_dnl_createtime"/> ]</span> 不能大于 <span style=\'color:#F00; font-size:12px;\'>[<s:text name="_dnm_createtime"/>]</span>';
		errorMessageShow(alertstr);
        return false;
       }
   		return true;	
    }
    function doExcel(){
    	formList.action="<%=contextPath%>/sales/orderstate_excel.do";
    	formList.submit();
    	formList.action="<%=contextPath%>/sales/orderstate_list.do";
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

<body class="list_body" onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<s:form action="orderstate_list.do" key="formList" cssStyle="formList" theme="simple" onsubmit="return ev_check();">
	<%//下面的控件给Action提供数据，用来分页%>
	<aa:zone name="hiddenZone">
    <s:hidden name="param._orderby"/>
    <s:hidden name="param._desc"/>
    <s:hidden name="param._pageno"/>
    <s:hidden name="param._pagesize"/>
    <s:hidden name="param.queryAll"/>
    <input type="hidden" name="_rowcount" value="<s:property value="dp.rowCount" />"/>
	</aa:zone>
    
	<div class="table_top">
		<div class="table_topleft"></div>
		<div class="table_toparea_w">
			<s:i18n name="public">
			<span class="table_toparea"><s:text name="currentPos"/> </span>
			<span class="table_toparea_xi">></span>
			<span class="table_toparea"><s:text name="sales"/> </span>
			<span class="table_toparea_xi">></span>
			</s:i18n>
			<span class="table_toparea">订单管理</span>
			<span class="table_toparea_xi">></span>
			<span class="table_toparea">订单状态统计</span>
			<span class="table_toparea_xi">></span>
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
        		<td align="center"><s:text name="_dnl_createtime"/>:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._dnl_createtime" onclick="selectDatetime();"/>
                    <font color=red>*</font>
                </td>
        		<td align="center"><s:text name="_dnm_createtime"/>:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._dnm_createtime" onclick="selectDatetime();"/>
                    <font color=red>*</font>
                </td>
                <td align="center"><s:text name="orderstate"/>:</td>
                <td align="left">
                    <j:selector definition="$FX_ORDERFSTATE" name="param._se_orderstate"/>
                </td>
        	</tr>
            <tr>
            	<td align="center"><s:text name="countyid"/>:</td>
                <td align="left">
                	<j:purChk permid="FX_ORDERMG_CITY"> 
                   		<j:selector definition="#CNTYCOMPANY"  condition="citycompid:${USER.cityid}" name="param._se_countyid" mode="selector"/>
                    </j:purChk>
                </td>
                <td align="center"><s:text name="_se_svccode"/>:</td>
                <td align="left">
                    <j:selector definition="#SERVCENT" name="param._se_svccode" />
                </td>
                <td align="center"><s:text name="mareacode"/>:</td>
                <td align="left">
                    <j:selector definition="#MICROAREA" name="param._se_mareacode" />
                </td>
             </tr>
             <tr> 
             	<td align="center"><s:text name="starlevel"/>:</td>
                <td align="left">
                    <j:selector definition="$CH_STARLEVEL" name="param._ne_starlevel"/>
                </td>
                <td align="center"><s:text name="orderave"/>:</td>
                <td align="left">
                    <j:selector definition="$FX_ORDERAVE" name="param._se_orderave"/>
                </td>
                <td align="center"><s:text name="alarmlevel"/>:</td>
                <td align="left">
                    <j:selector definition="$FX_STOCKALARMLEVEL" name="param._se_alarmlevel"/>
                </td>
             </tr>
             <tr>               
                <td align="center"><s:text name="_se_brand"/>:</td>
                <td align="left">
                    <p:smpBrand name="param._se_brand" mode="def" cssStyle="style_input" />
                </td>
                <td align="center"><s:text name="comcategory"/>:</td>
                <td align="left">
                    <j:selector definition="$IM_FXCOMCATEGORY" name="param._se_comcategory" condition="_snk_dictid:%CZ" mode="picker"/>
                </td>
                <td align="center"></td>
                <td align="left"></td>
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
                        value="统计" onClick="doQuery('/sales/orderstate_list.do');">
                	<input type="button" id="btnExportexcel" name="btnExportexcel" class="button_4" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="<s:text name="button_exportexcel"/>" onClick="doExcel()">
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
            	<td >序号</td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('countyid')"><s:text name="countyid"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('svccode')"><s:text name="svccode"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('mareacode')"><s:text name="mareacode"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('starlevel')"><s:text name="starlevel"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('orderave')"><s:text name="orderave"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('alarmlevel')"><s:text name="alarmlevel"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('orderstate')"><s:text name="orderstate"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('ordercount')"><s:text name="ordercount"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('brand')"><s:text name="brand"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('comcategory')"><s:text name="comcategory"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('orderamt')"><s:text name="orderamt"/></j:orderByImg>                 
                </td>
            </tr>
            <s:iterator value="dp.datas" status="state">
                 <tr class="table_style_content" align="center" onMouseMove="this.bgColor='F0F5F9'" onMouseOut="this.bgColor='#ffffff'">
					 <%-- 复合主键用“|”间隔开 --%>
					 <td><s:text name="#state.count"/></td>
                     <td><j:code2Name definition="#CNTYCOMPANY" code="countyid"/></td>
                     <td><j:code2Name definition="#SERVCENT" code="svccode"/></td>
                     <td><j:code2Name definition="#MICROAREA" code="mareacode"/></td>
                     <td><j:code2Name definition="$CH_STARLEVEL" code="starlevel"/></td>
                     <td><j:code2Name definition="$FX_ORDERAVE" code="orderave"/></td>
                     <td><j:code2Name definition="$FX_STOCKALARMLEVEL" code="alarmlevel"/></td>
                     <td><j:code2Name definition="$FX_ORDERFSTATE" code="orderstate"/></td>
                     <td><s:property value="ordercount" /></td>
                     <td><j:code2Name definition="$FX_SMPBRAND" code="brand"/></td>
                     <td><j:code2Name definition="$IM_FXCOMCATEGORY" code="comcategory"/></td>
                     <td><s:property value="orderamt" /></td>
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
<script language="javascript"> 
	ajaxAnywhere.getZonesToReload = function(url,submitButton) {
		return "errorZone,listZone,hiddenZone";  
	}
	ajaxAnywhere.substituteFormSubmitFunction();  
	ajaxAnywhere.formURL = formList.action;
	ajaxAnywhere.substituteSubmitButtonsBehaviorByIDs(true,"btnQuery,btnDelete");
</script> 
