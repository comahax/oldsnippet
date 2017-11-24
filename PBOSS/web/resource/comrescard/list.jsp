<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc" %>
<html>
<head>
    <title><s:text name="titleList"/></title>
    <script type="text/javascript" src="<%=contextPath%>/js/bus/pwaycommon.js"></script>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
             addfield('param._se_wayid', '<s:text name="wayid"/>', 'c', true, '18');
            addfield('param._nnl_comresid', '<s:text name="comresid"/>', 'l', true, 32);
            addfield('param._nnm_comresid', '<s:text name="comresid"/>', 'l', true, 32);
            addfield('param._ne_comid', '<s:text name="comid"/>', 'f', true, 18);
			addfield('param._se_batchno', '<s:text name="batchno"/>', 'c', true, 30);
			addfield('param._ne_comstate', '<s:text name="comstate"/>', 'f', true, 3);
           return (checkval(window) && compareComresid());
        }
         function compareComresid(){
        	var dnmcomresid = document.getElementById('param._nnm_comresid').value;
        	var dnlcomresid = document.getElementById('param._nnl_comresid').value;
        	
        	if(dnmcomresid != '' && dnlcomresid != '' && dnlcomresid>dnmcomresid){
	        	var alertstr = '<span class=\'errorkey\'><span style=\'color:#F00; font-size:12px;\'>[<s:text name="comresid"/>>=]</span> 不能大于 <span style=\'color:#F00; font-size:12px;\'>[<s:text name="comresid"/><=]</span>';
				errorMessageShow(alertstr);
				return false;
        	}
        	return true;
        }
        
        function doExcel(){
         	if(document.getElementById("countyid").disabled){
         		formList.action="<%=contextPath%>/resource/comrescard_excel.do";
	        	document.getElementById("countyid").disabled=false;
	        	formList.submit();
	        	formList.action="<%=contextPath%>/resource/comrescard_list.do";
	        	document.getElementById("countyid").disabled=true;
         	}
         	else{
         		formList.action="<%=contextPath%>/resource/comrescard_excel.do";
        		formList.submit();
        		formList.action="<%=contextPath%>/resource/comrescard_list.do";
         	}
        }
         function doTxt()
        {
        	if(document.getElementById("countyid").disabled){
         		formList.action="<%=contextPath%>/resource/comrescard_txt.do";
	        	document.getElementById("countyid").disabled=false;
	        	formList.submit();
	        	formList.action="<%=contextPath%>/resource/comrescard_list.do";
	        	document.getElementById("countyid").disabled=true;
         	}
         	else{
         		formList.action="<%=contextPath%>/resource/comrescard_txt.do";
        		formList.submit();
        		formList.action="<%=contextPath%>/resource/comrescard_list.do";
         	}
        }
    </script>
</head>

<body class="list_body" onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<s:form action="comrescard_list.do" key="formList" cssStyle="formList" theme="simple" onsubmit="return ev_check();">

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
			<span class="table_toparea"><s:text name="resource"/> </span>
			<span class="table_toparea_xi">></span>
			</s:i18n>
			<span class="table_toparea">资源查询 </span>
			<span class="table_toparea_xi">></span>
			<span class="table_toparea_h">充值卡资源查询</span>
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
                <td align="center"><s:text name="comid"/>:</td>
                <td align="left">
                   <j:Comidtree name="param._ne_comid" condition="comclassid:0;comclassid:4;" definition="#COMSYSTEM" nameOnly="true" readonly="true"/>
	            	 
 				</td>
                <td align="center"><s:text name="comresid"/>>=:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._nnl_comresid" />
                </td>
                <td align="center"><s:text name="comresid"/><=:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._nnm_comresid" />
                </td>
            </tr>
             <tr>
                <td align="center"><s:text name="wayid"/>:</td>
                <td align="left">
                     <s:textfield cssStyle="style_input" name="param._se_wayid" readonly="true"/><input type="button" value="..." class="picker_button" onclick="pshowSelectWay3(this,'param._se_wayid');this.value='...';" />
                </td>
                <td align="center"><s:text name="comstate"/>:</td>
                <td align="left">
               		 <j:selector definition="$FX_COMSTATE" name="param._ne_comstate"  cssStyle="style_input"/>
                </td>
                <td align="center"><s:text name="batchno"/>:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._se_batchno" />
                </td>
            </tr>
            <tr>
            	<td align="center"><s:text name="countyid"/>:</td>
                <td align="left">
                <j:purChk permid="IM_RESOURCE_COUNTY"> 
                   <j:selector definition="#CNTYCOMPANY" id="countyid" condition="citycompid:${USER.cityid}" name="param._se_countyid" mode="selector"/>
                </j:purChk>
                </td>
                <td align="center"></td>
                <td align="left">
                	
                </td>
                <td align="center"></td>
                <td align="left">
                	
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
                        value="<s:text name="button_search"/>" onClick="doQuery('/resource/comrescard_list.do');">
                	
                    <input type="button" id="btnExportexcel" name="btnExportexcel" class="button_4" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="<s:text name="button_exportexcel"/>" onClick="doExcel()">
                    
                    <input type="button" id="btnExporttxt" name="btnExporttxt" class="button_4" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
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
                    <s:text name="seqid"/>
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('comresid')"><s:text name="comresid"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('comid')"><s:text name="comid"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('comid')"><s:text name="comname"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('batchno')"><s:text name="batchno"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('comstate')"><s:text name="comstate"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('wayid')"><s:text name="wayid"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('price')"><s:text name="price"/>(元)</j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('comactive')"><s:text name="comactive"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('entertime')"><s:text name="entertime"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('saletime')"><s:text name="saletime"/></j:orderByImg>                 
                </td>
            </tr>
            <s:iterator value="dp.datas" status="state">
                 <tr class="table_style_content" align="center" onMouseMove="this.bgColor='F0F5F9'" onMouseOut="this.bgColor='#ffffff'">

                    <td><s:text name="#state.count"/></td>
                     <td>
							<s:property value="comresid"/>
					 </td>
                     <td>
							<s:property value="comid"/>
					 </td>
					 <td><j:code2Name definition="#COM" code="comid"/></td>
                     <td><s:property value="batchno" /></td>
                     <td><j:code2Name definition="$FX_COMSTATE" code="comstate"/></td>
                     <td><j:code2Name definition="#WAYIDINFO" code="wayid"/></td>
                     <td>
	                     <s:i18n name="public">
	                     <s:text name="format.double">
	                     <s:param value="%{price/100.0}"/>
	                     </s:text>
	                     </s:i18n>
					</td>
                     <td>
                     	<s:date name="comactive" format="yyyy-MM-dd  HH:mm:ss"/>
                     </td>
                     <td>
                     	<s:date name="entertime" format="yyyy-MM-dd HH:mm:ss"/>
                     </td>
                     <td>
                     	<s:date name="saletime" format="yyyy-MM-dd HH:mm:ss"/>
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
