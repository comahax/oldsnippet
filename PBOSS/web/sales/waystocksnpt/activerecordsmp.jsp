<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc" %>
<html>
<head>
    <title><s:text name="titleList"/></title>
    <script type="text/javascript" src="<%=contextPath%>/js/bus/pwaycommon.js"></script>    
    <script language="JavaScript" type="text/JavaScript">
	function ev_check() {
		addfield('param._se_countyid', '<s:text name="countyid"/>', 'c', true, '14');
		addfield('param._se_svccode', '<s:text name="svccode"/>', 'c', true, '14');
		addfield('param._se_mareacode', '<s:text name="mareacode"/>', 'c', true, '14');
		addfield('param._se_wayid', '<s:text name="wayid"/>', 'c', true, '18');
		addfield('param._sk_wayname', '<s:text name="wayname"/>', 'c', true, '256');
		addfield('param._ne_starlevel', '<s:text name="starlevel"/>', 'f', true, '2');
		addfield('param._se_brand', '<s:text name="brand"/>', 'c', true, '16');
		addfield('param._se_comcategory', '<s:text name="comcategory"/>', 'c', true, '20');
		addfield('param._se_comresid', '<s:text name="comresid"/>', 'c', true, '32');
		var _se_comresid = document.getElementById("param._se_comresid").value;
    	if (_se_comresid == "") {
			addfield('param._dnm_acttime', '<s:text name="_dnm_acttime"/>', 'dt', false, '7');
			addfield('param._dnl_acttime', '<s:text name="_dnl_acttime"/>', 'dt', false, '7');
    	}
		return checkval(window);
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
    	
    	function doExport(){
    		formList.action="<%=contextPath%>/sales/waystocksnpt_exportactivesmprecord.do";
    		formList.submit();
    		formList.action="<%=contextPath%>/sales/waystocksnpt_activesmprecord.do";
    	}
    	
    	
       function doTxt()
        {
        	formList.action="<%=contextPath%>/sales/waystocksnpt_exportactivesmprecordTxt.do";
        	formList.submit();
        	formList.action="<%=contextPath%>/sales/waystocksnpt_activesmprecord.do";
        }
    	
</script>
</head>

<body class="list_body" onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<s:form action="waystocksnpt_activesmprecord.do" key="formList" cssStyle="formList" theme="simple" onsubmit="return ev_check();">
	<%//下面的控件给Action提供数据，用来分页%>
	<aa:zone name="hiddenZone">
    <s:hidden name="param._orderby"/>
    <s:hidden name="param._desc"/>
    <s:hidden name="param._pageno"/>
    <s:hidden name="param._pagesize"/>
    <s:hidden name="param.startindex" />
	<s:hidden name="param.endindex" />
    <s:hidden name="param.queryAll"/>
     <s:hidden name="isQuery" value="true"></s:hidden>
    <input type="hidden" name="_rowcount" value="<s:property value="dp.rowCount" />"/>
	</aa:zone>
    
	<div class="table_top">
		<div class="table_topleft"></div>
		<div class="table_toparea_w">
			<s:i18n name="public">
			<span class="table_toparea"><s:text name="currentPos"/> </span>
			<span class="table_toparea_xi">></span>
			<span class="table_toparea"><s:text name="resource"/> </span>
			<span class="table_toparea_xi">></span>
			</s:i18n>
			<span class="table_toparea_h"><s:text name="titleActiverecordsmp"/></span>
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
                <td align="right"><s:text name="countyid"/>:</td>
                <td align="left">
                    <j:selector definition="#CNTYCOMPANY"  condition="citycompid:${USER.cityid}" name="param._se_countyid" mode="selector"/>
                </td>
                <td align="right"><s:text name="mareacode"/>:</td>
                <td align="left">
                    <j:selector definition="#MICROAREA" name="param._se_mareacode" readonly="true"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="svccode"/>:</td>
                <td align="left">
                   <j:selector definition="#SERVCENT" name="param._se_svccode" />
                </td>
                
                <td align="right"><s:text name="wayid"/>:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._se_wayid" /><input type="button" value="..." class="picker_button"
									onclick="pshowSelectWay3(this,'param._se_wayid','','','AG');this.value='...';" />
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="wayname"/>:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._sk_wayname" />
                </td>
                <td align="right"><s:text name="starlevel"/>:</td>
                <td align="left">
                    <j:selector definition="$CH_STARLEVEL"
									name="param._ne_starlevel" />
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="brand"/>:</td>
                <td align="left">
                    <p:smpBrand name="param._se_brand" mode="def" cssStyle="style_input"/>
                </td>
                <td align="right"><s:text name="comcategory"/>:</td>
                <td align="left">
                    <j:selector name="param._se_comcategory" definition="$IM_FXCOMCATEGORY" mode="picker" />
                </td>
            <tr>
                <td align="right"><s:text name="_dnl_acttime"/>:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._dnl_acttime" onclick="selectDatetime()" readonly="true"/>
                </td>
                <td align="right"><s:text name="_dnm_acttime"/>:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._dnm_acttime" onclick="selectDatetime()" readonly="true"/>
                </td>
            </tr>
            <tr>
            	<td align="right"><s:text name="comresid"/>:</td>
            	<td align="left">
            		<s:textfield cssStyle="style_input" name="param._se_comresid" />
            	</td> 
            	<td align="right">
					<s:text name="upperwayid" />:
				</td>
				<td align="left">
					<s:textfield cssStyle="style_input" name="param._se_upperwayid"  /><input type="button" value="..." class="picker_button"
					onclick="pshowSelectWay3(this,'param._se_upperwayid','','','AG|ET','DIS|GMPT|G100');this.value='...';" />
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
                        value="<s:text name="button_search"/>" onClick="doQuery('/sales/waystocksnpt_activesmprecord.do');">
                  
                    <input type="button" id="btnExport" name="btnExport" class="button_4" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="导出Excel" onClick="setExcelOutPage('/sales/waystocksnpt_exportactivesmprecord.do');"> 
                        
                          <input type="button" id="btnExporttxt" name="btnExporttxt" class="button_4" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="<s:text name="button_exporttxt"/>" onClick="doTxt();">
                    <input type="button" id="btnExportbatch" name="btnExportbatch" class="button_4" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="批量导出" onClick="location.href='<%=contextPath%>/sales/waystocksnpt/activesmprecordbatchexport.jsp'">
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
                    <s:text name="comresid"/>                 
                </td>
                <td>
                    <s:text name="acttime"/>                 
                </td>            	
                <td>
                    <s:text name="countyid"/>                
                </td>
                <td>
                    <s:text name="svccode"/>                 
                </td>
                <td>
                    <s:text name="mareacode"/>                
                </td>
                <td>
                    <s:text name="orderid"/>                 
                </td>
                <td>
                    <s:text name="wayid"/>                
                </td>
                <td>
                    <s:text name="wayname"/>                 
                </td>
                <td>
                    <s:text name="starlevel"/>                 
                </td>
                <td>
                    <s:text name="brand"/>                 
                </td>
                <td>
                    <s:text name="comcategory"/>                 
                </td>
                 <td>
                    <s:text name="upperwayid"/>
                </td>
            </tr>
            <s:iterator value="dp.datas">
                 <tr class="table_style_content" align="center" onMouseMove="this.bgColor='F0F5F9'" onMouseOut="this.bgColor='#ffffff'">
					 <%-- 复合主键用“|”间隔开 --%>
					 <td><s:property value="comresid" /></td>
                     <td><s:date name="acttime" format="yyyy-MM-dd HH:mm:ss" /></td>
                     <td><j:code2Name definition="#CNTYCOMPANY" code="countyid"/></td>
                     <td><j:code2Name code="svccode" definition="#SERVCENT" /></td>
                     <td><j:code2Name code="mareacode" definition="#MICROAREA" /></td>
                     <td><s:property value="orderid" /></td>
                     <td><s:property value="wayid" /></td>
                     <td><s:property value="wayname" /></td>
                     <td><j:code2Name code="starlevel" definition="$CH_STARLEVEL" /></td>
                     <td><j:code2Name definition="$FX_SMPBRAND" code="brand"/></td>
                     <td><j:code2Name definition="$IM_FXCOMCATEGORY" code="comcategory" /></td>
                     <td><j:code2Name code="upperwayid" definition="#WAY" /></td>
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
