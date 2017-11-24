<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc" %>
<html>
<head>
    <title><s:text name="titleList"/></title>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            addfield('param._snm_coldate', '<s:text name="coldate2"/>', 'c', false, '8');
    		addfield('param._snl_coldate', '<s:text name="coldate1"/>', 'c', false, '8');
    		addfield('param._se_countyid', '<s:text name="countyid"/>', 'c', true, '14');
    		addfield('param._se_svccode', '<s:text name="svccode"/>', 'c', true, '14');
    		addfield('param._se_macode', '<s:text name="macode"/>', 'c', true, '14');
    		addfield('param._ne_starlevel', '<s:text name="starlevel"/>', 'f', true, '2');
    		addfield('param._se_alarmlevel', '<s:text name="alarmlevel"/>', 'c', true, '16');
    		addfield('param._se_brand', '<s:text name="brand"/>', 'c', true, '16');
    		return (checkval(window) && compareDate());
        }

        function compareDate(){
        	var _snm_coldate = document.getElementById('param._snm_coldate').value;
        	var _snl_coldate = document.getElementById('param._snl_coldate').value;
        	
        	if(_snm_coldate != '' && _snl_coldate != '' && _snl_coldate > _snm_coldate){
	        	var alertstr = '<span class=\'errorkey\'><span style=\'color:#F00; font-size:12px;\'>[<s:text name="coldate1"/> ]</span> 不能大于 <span style=\'color:#F00; font-size:12px;\'>[<s:text name="coldate2"/>]</span>';
				errorMessageShow(alertstr);
				return false;
        	}
        	return true;
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
            if(control.name.indexOf('param._se_macode') > -1 ) {
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
        
        function doExcel(){
        	formList.action="<%=contextPath%>/sales/alaordercol_excelalaordercol.do";
        	formList.submit();
        	formList.action="<%=contextPath%>/sales/alaordercol_list.do";
        }
    </script>
</head>

<body class="list_body">
<div class="table_container">
<s:form action="alaordercol_list.do" key="formList" cssStyle="formList" theme="simple" onsubmit="return ev_check();">
	<%//下面的控件给Action提供数据，用来分页%>
    <s:hidden name="param._orderby"/>
    <s:hidden name="param._desc"/>
    <s:hidden name="param._pageno"/>
    <s:hidden name="param._pagesize"/>
    <s:hidden name="param.queryAll"/>
    <input type="hidden" name="_rowcount" value="<s:property value="dp.rowCount" />"/>
    
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
                <td align="center"><s:text name="coldate1"/>:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._snl_coldate" onclick="selectDateYYYYMMDD()" readonly="true"/>
                    <font color="red">*</font>
                </td>
                <td align="center"><s:text name="coldate2"/>:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._snm_coldate" onclick="selectDateYYYYMMDD()" readonly="true"/>
                    <font color="red">*</font>
                </td>
                <td></td>
                <td></td>
            </tr>
            <tr>
                <td align="center"><s:text name="countyid"/>:</td>
                <td align="left">
                    <j:selector definition="#CNTYCOMPANY"  condition="citycompid:${USER.cityid}" name="param._se_countyid" mode="selector"/>
                </td>
                <td align="center"><s:text name="svccode"/>:</td>
                <td align="left">
                    <j:selector definition="#SERVCENT" name="param._se_svccode" />
                </td>
                <td align="center"><s:text name="macode"/>:</td>
                <td align="left">
                    <j:selector definition="#MICROAREA" name="param._se_macode" readonly="true"/>
                </td>
            </tr>
            <tr>
                <td align="center"><s:text name="starlevel"/>:</td>
                <td align="left">
                    <j:selector definition="$CH_STARLEVEL" name="param._ne_starlevel" />
                </td>
                <td align="center"><s:text name="alarmlevel"/>:</td>
                <td align="left">
                    <j:selector definition="$FX_STOCKALARMLEVEL" name="param._se_alarmlevel" />
                </td>
                <td align="center"><s:text name="brand"/>:</td>
                <td align="left">
                    <p:smpBrand name="param._se_brand" mode="def" cssStyle="style_input"/>
                </td>
            </tr>
        </table>
    </div>
    
    <div class="table_div">
		<table class="table_button_list">
			<tr>
				<td>
                	<s:i18n name="public">
                	<input type="button" id="btnQuery" name="btnQuery" class="button_2" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="<s:text name="统计"/>" onClick="doQuery('/sales/alaordercol_list.do');">
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
                <td><s:text name="number"/></td>
                <td><s:text name="countyid"/></td>
                <td><s:text name="svccode"/></td>
                <td><s:text name="macode"/></td>
                <td><s:text name="starlevel"/></td>
                <td><s:text name="alarmlevel"/></td>
                <td><s:text name="brand"/></td>
                <td><s:text name="amount"/></td>
                <td><s:text name="orderamt"/></td>
                <td><s:text name="cancelamt"/></td>
                <td><s:text name="overamt"/></td>
            </tr>
            <s:iterator value="dp.datas" status="state">
                 <tr class="table_style_content" align="center" onMouseMove="this.bgColor='F0F5F9'" onMouseOut="this.bgColor='#ffffff'">
					 <%-- 复合主键用“|”间隔开 --%>
					 <td><s:text name="#state.count"/></td>
                     <td><j:code2Name definition="#CNTYCOMPANY" code="countyid"/></td>
                     <td><j:code2Name code="svccode" definition="#SERVCENT" /></td>
                     <td><j:code2Name code="macode" definition="#MICROAREA" /></td>
                     <td><j:code2Name code="starlevel" definition="$CH_STARLEVEL" /></td>
                     <td><j:code2Name definition="$FX_STOCKALARMLEVEL" code="alarmlevel"/></td>
                     <td><j:code2Name definition="$FX_SMPBRAND" code="brand"/></td>
                     <td><s:property value="amount" /></td>
                     <td><s:property value="orderamt" /></td>
                     <td><s:property value="cancelamt" /></td>
                     <td><s:property value="overamt" /></td>
                 </tr>
             </s:iterator>
             <tr class="table_style_content" align="center">
             <td><s:text name="total"/></td>
             <td ></td>
             <td ></td>
             <td ></td>
             <td ></td>
             <td ></td>
             <td ></td>
             <td><s:property value="form.totalAmount"/></td>
             <td><s:property value="form.totalOrderamt"/></td>
             <td><s:property value="form.totalCancelamt"/></td>
             <td><s:property value="form.totalOveramt"/></td>
             </tr>
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
		return "errorZone,listZone";  
	}
	ajaxAnywhere.substituteFormSubmitFunction();  
	ajaxAnywhere.substituteSubmitButtonsBehaviorByIDs(true,"btnQuery");
</script> 
</body>
</html>
