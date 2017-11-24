<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc" %>
<html>
<head>
    <title><s:text name="titleList"/></title>
    <script type="text/javascript" src="<%=contextPath%>/js/bus/pwaycommon.js"></script>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            addfield('param._dnm_optime', '<s:text name="optime"/>', 'dt', true, '7');
            addfield('param._dnl_optime', '<s:text name="optime"/>', 'dt', true, '7');
            addfield('param._se_oprcode2', '<s:text name="oprcode2"/>', 'c', true, '16');
            addfield('param._se_oprtype', '<s:text name="oprtype"/>', 'c', true, '8');
            addfield('param._snm_emptyno', '<s:text name="emptyno"/>', 'c', true, '21');
            addfield('param._snl_emptyno', '<s:text name="emptyno"/>', 'c', true, '21');
            addfield('param._se_wayid', '<s:text name="wayid"/>', 'c', true, '18');
            addfield('param._ne_simtype', '<s:text name="simtype"/>', 'f', true, '6');
            addfield('param._ne_usestate', '<s:text name="usestate"/>', 'f', true, '3');
            addfield('param._ne_comid', '<s:text name="comid"/>', 'f', true, 18);
            return (checkval(window) && compareDate() && compareEmptyno());
        }
         function compareDate(){
        	var dnmOptime = document.getElementById('param._dnm_optime').value;
        	var dnlOptime = document.getElementById('param._dnl_optime').value;
        	
        	if(dnmOptime != '' && dnlOptime != '' && dnlOptime>dnmOptime){
	        	var alertstr = '<span class=\'errorkey\'><span style=\'color:#F00; font-size:12px;\'>[<s:text name="_dnl_optime"/> ]</span> 不能大于 <span style=\'color:#F00; font-size:12px;\'>[<s:text name="_dnm_optime"/>]</span>';
				errorMessageShow(alertstr);
				return false;
        	}
        	return true;
        }
        function compareEmptyno(){
        	var dnmemptyno= document.getElementById('param._snm_emptyno').value;
        	var dnlemptyno = document.getElementById('param._snl_emptyno').value;
        	
        	if(dnmemptyno != '' && dnlemptyno != '' && dnlemptyno>dnmemptyno){
	        	var alertstr = '<span class=\'errorkey\'><span style=\'color:#F00; font-size:12px;\'>[<s:text name="_snl_emptyno"/>]</span> 不能大于 <span style=\'color:#F00; font-size:12px;\'>[<s:text name="_snm_emptyno"/>]</span>';
				errorMessageShow(alertstr);
				return false;
        	}
        	return true;
        }
    </script>
</head>

<body class="list_body" onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<s:form action="emptysimlog_list.do" key="formList" cssStyle="formList" theme="simple" onsubmit="return ev_check();">
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
			<span class="table_toparea">资源管理日志 </span>
			<span class="table_toparea_xi">></span>
			<span class="table_toparea_h"><s:text name="titleList"/></span>
			
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
                   <j:Comidtree name="param._ne_comid" condition="comclassid:7;comclassid:8;" definition="#COMSYSTEM" nameOnly="true" readonly="true"/>
	            	 
 				</td>
            	 <td align="center"><s:text name="oprcode2"/>:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._se_oprcode2" />
                </td>
            	<td align="center"><s:text name="optime"/>>=:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._dnl_optime" onclick="selectDatetime();"/>
                </td>
            </tr>
            <tr>
                <td align="center"><s:text name="optime"/><=:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._dnm_optime" onclick="selectDatetime();"/>
                </td>
            
                <td align="center"><s:text name="oprtype"/>:</td>
                <td align="left">
                	<j:selector definition="$OPRTYPE" name="param._se_oprtype"  cssStyle="style_input"/>
                </td>
                <td align="center"><s:text name="emptyno"/>>=:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._snl_emptyno" />
                </td>
                
            </tr>
            <tr>
                <td align="center"><s:text name="emptyno"/><=:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._snm_emptyno" />
                </td>
          
                <td align="center"><s:text name="simtype"/>:</td>
                <td align="left">
                    <j:selector definition="$IM_SIMTYPE" name="param._ne_simtype" readonly="true" mode="picker"/>
                </td>
                <td align="center"><s:text name="wayid"/>:</td>
                <td align="left">
                     <s:textfield cssStyle="style_input" name="param._se_wayid" readonly="true"/><input type="button" value="..." class="picker_button" onclick="pshowSelectWay3(this,'param._se_wayid');this.value='...';" />
                </td>
                
            </tr>
            <tr>
            
                <td align="center"><s:text name="usestate"/>:</td>
                <td align="left">
                    <j:selector definition="$FX_COMSTATE" name="param._ne_usestate"  cssStyle="style_input"/>
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
                        value="<s:text name="button_search"/>" onClick="doQuery('/resource/emptysimlog_list.do');">
                	
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
                    <j:orderByImg href="javascript:doOrderby('logid')"><s:text name="logid"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('optime')"><s:text name="optime"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('oprcode2')"><s:text name="oprcode2"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('oprtype')"><s:text name="oprtype"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('success')"><s:text name="success"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('emptyno')"><s:text name="emptyno"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('comid')"><s:text name="comid"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('comid')"><s:text name="comname"/></j:orderByImg>                 
                </td>
                  <td>
                   <j:orderByImg href="javascript:doOrderby('cardmill')"><s:text name="cardmill"/></j:orderByImg>             
                </td> 
                <td>
                    <j:orderByImg href="javascript:doOrderby('iccid')"><s:text name="iccid"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('pukno')"><s:text name="pukno"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('wayid')"><s:text name="wayid"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('simtype')"><s:text name="simtype"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('usestate')"><s:text name="usestate"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('entertime')"><s:text name="entertime"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('applytime')"><s:text name="applytime"/></j:orderByImg>                 
                </td>
                 <td>
                    <j:orderByImg href="javascript:doOrderby('bosssaletime')"><s:text name="bosssaletime"/></j:orderByImg>                 
                </td>
            </tr>
            <s:iterator value="dp.datas">
                 <tr class="table_style_content" align="center" onMouseMove="this.bgColor='F0F5F9'" onMouseOut="this.bgColor='#ffffff'">
                     <td>
							<s:property value="logid"/>
					 </td>
                     <td><s:date name="optime" format="yyyy-MM-dd HH:mm:ss"/></td>
                     <td><s:property value="oprcode2" /></td>
                     <td><j:code2Name definition="$OPRTYPE" code="oprtype"/></td>
                     <td><j:code2Name definition="SUCCESS" code="success"/></td>
                     <td><s:property value="emptyno" /></td>
                     <td><s:property value="comid" /></td>
					 <td><j:code2Name definition="#COM" code="comid"/></td>
                      <td><s:property value="cardmill" /></td>
                     <td><s:property value="iccid" /></td>
                     <td><s:property value="pukno" /></td>
                     <td><j:code2Name definition="#WAYIDINFO" code="wayid"/></td>
                     <td><j:code2Name definition="$IM_SIMTYPE" code="simtype"/></td>
                     <td><j:code2Name definition="$FX_COMSTATE" code="usestate"/></td>
                     <td><s:date name="entertime" format="yyyy-MM-dd HH:mm:ss"/></td>
                     <td><s:date name="applytime" format="yyyy-MM-dd HH:mm:ss"/></td>
                     <td><s:date name="bosssaletime" format="yyyy-MM-dd HH:mm:ss"/></td>
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
