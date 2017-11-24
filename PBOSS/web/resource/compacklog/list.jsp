<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc" %>
<html>
<head>
    <title><s:text name="titleList"/></title>
    <script type="text/javascript" src="<%=contextPath%>/js/bus/pwaycommon.js"></script>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            addfield('param._dnm_optime', '<s:text name="_dnm_optime"/>', 'dt', true, '7');
            addfield('param._dnl_optime', '<s:text name="_dnl_optime"/>', 'dt', true, '7');
            addfield('param._se_oprcode', '<s:text name="oprcode"/>', 'c', true, '16');
            addfield('param._se_oprtype', '<s:text name="oprtype"/>', 'c', true, '8');
            addfield('param._se_comcategory', '<s:text name="comcategory"/>', 'c', true, '20');
            addfield('param._se_resuse', '<s:text name="resuse"/>', 'c', true, '20');
            addfield('param._se_storarea', '<s:text name="storarea"/>', 'c', true, '10');
            addfield('param._se_nosect', '<s:text name="nosect"/>', 'c', true, '10');
            addfield('param._se_wayid', '<s:text name="wayid"/>', 'c', true, '18');
            addfield('param._se_discomcode', '<s:text name="discomcode"/>', 'c', true, '18');
            addfield('param._dnm_packtime', '<s:text name="_dnm_packtime"/>', 't', true, '7');
            addfield('param._dnl_packtime', '<s:text name="_dnl_packtime"/>', 't', true, '7');
            return (checkval(window) && compareDate());
        }
        
        function compareDate(){
        	var dnmOptime = document.getElementById('param._dnm_optime').value;
        	var dnlOptime = document.getElementById('param._dnl_optime').value;
        	var dnmPacktime = document.getElementById('param._dnm_packtime').value;
        	var dnlPacktime = document.getElementById('param._dnl_packtime').value;
        	
        	if(dnmOptime != '' && dnlOptime != '' && dnlOptime>dnmOptime){
	        	var alertstr = '<span class=\'errorkey\'><span style=\'color:#F00; font-size:12px;\'>[<s:text name="_dnl_optime"/> ]</span> 不能大于 <span style=\'color:#F00; font-size:12px;\'>[<s:text name="_dnm_optime"/>]</span>';
				errorMessageShow(alertstr);
				return false;
        	}
        	if(dnmPacktime != '' && dnlPacktime != '' && dnlPacktime>dnmPacktime){
        	var alertstr = '<span class=\'errorkey\'><span style=\'color:#F00; font-size:12px;\'>[<s:text name="_dnl_packtime"/> ]</span> 不能大于 <span style=\'color:#F00; font-size:12px;\'>[<s:text name="_dnm_packtime"/>]</span>';
				errorMessageShow(alertstr);
				return false;
        	}
        	return true;
        }
    </script>
</head>

<body class="list_body" onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<s:form action="compacklog_list.do" key="formList" cssStyle="formList" theme="simple" onsubmit="return ev_check();">
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
			<span class="table_toparea"><s:text name="resource"/> </span>
			<span class="table_toparea_xi">></span>
			</s:i18n>
			<span class="table_toparea">商品包管理 </span>
			<span class="table_toparea_xi">></span>
			<span class="table_toparea_h">商品包日志查询</span>
			
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
            	<td align="center"><s:text name="oprcode"/>:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._se_oprcode" />
                </td>
                <td align="center"><s:text name="_dnl_optime"/>:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._dnl_optime" onclick="selectDatetime();" readonly="true"/>
                </td>
                <td align="center"><s:text name="_dnm_optime"/>:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._dnm_optime" onclick="selectDatetime();" readonly="true"/>
                </td>
             </tr>
             <tr>   
                <td align="center"><s:text name="oprtype"/>:</td>
                <td align="left">
                    <j:selector name="param._se_oprtype" definition="$OPRTYPE"/>
                </td>
                <td align="center"><s:text name="_dnl_packtime"/>:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._dnl_packtime" onclick="selectDate();" readonly="true"/>
                </td>
                 <td align="center"><s:text name="_dnm_packtime"/>:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._dnm_packtime" onclick="selectDate();" readonly="true"/>
                </td>
              </tr>
              <tr>  
                <td align="center"><s:text name="storarea"/>:</td>
                <td align="left">
                    <j:selector name="param._se_storarea" definition="$IM_FXSTORAREA"/>
                </td>
                <td align="center"><s:text name="comcategory"/>:</td>
                <td align="left">
                    <j:selector name="param._se_comcategory" definition="$IM_FXCOMCATEGORY" mode="picker"/>
                </td>
                <td align="center"><s:text name="resuse"/>:</td>
                <td align="left">
                    <j:selector name="param._se_resuse" definition="$IM_FXRESUSE"/>
                </td>
              </tr>
              <tr>   
                <td align="center"><s:text name="nosect"/>:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._se_nosect" />
                </td>
                <td align="center"><s:text name="wayid"/>:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._se_wayid" readonly="true"/><input type="button" value="..." class="picker_button" onclick="pshowSelectWay3(this,'param._se_wayid');this.value='...';" />
                </td>
                <td align="center"><s:text name="discomcode"/>:</td>
                <td align="left">
                    <j:selector name="param._se_discomcode" definition="#WAYIDINFO"  condition="waytype:AG;waysubtype:LOGS;cityid:${USER.cityid}"/>
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
                        value="<s:text name="button_search"/>" onClick="doQuery('/resource/compacklog_list.do');">
                	<!-- 
                    <input type="button" id="btnNew" name="btnNew" class="button_New" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="<s:text name="button_new"/>" onClick="doNew('/resource/compacklog_new.do')">
                    
                    <input type="button" id="btnDelete" name="btnDelete" class="button_Delete" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="<s:text name="button_delete"/>" onClick="doDelete('/resource/compacklog_delete.do')">
                      -->   
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
            <!-- 
               	<s:i18n name="public">
                <td title="<s:text name="list_title_select"/>">
                    <input type="checkbox" name="allbox" onclick="checkAll();"/>
                </td>
                </s:i18n>
              -->   
                <td>
                    <j:orderByImg href="javascript:doOrderby('logid')"><s:text name="logid"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('optime')"><s:text name="optime"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('oprcode')"><s:text name="oprcode"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('oprtype')"><s:text name="oprtype"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('success')"><s:text name="success"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('batchno')"><s:text name="batchno"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('boxnum')"><s:text name="boxnum"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('amount')"><s:text name="amount"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('comcategory')"><s:text name="comcategory"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('packstate')"><s:text name="packstate"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('resuse')"><s:text name="resuse"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('storarea')"><s:text name="storarea"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('nosect')"><s:text name="nosect"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('wayid')"><s:text name="wayid"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('discomcode')"><s:text name="discomcode"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('packtime')"><s:text name="packtime"/></j:orderByImg>                 
                </td>
            </tr>
            <s:iterator value="dp.datas">
                 <tr class="table_style_content" align="center" onMouseMove="this.bgColor='F0F5F9'" onMouseOut="this.bgColor='#ffffff'">
					 <%-- 复合主键用“|”间隔开 --%>
					 <!-- 
                     <td>
                         <input type="checkbox" name="param._selectitem" value="<s:property value="logid"/>" onclick="checkOne();">
                     </td>
                      -->
                     <td>
							<s:property value="logid"/>
					 </td>
                     <td><s:date name="optime" format="yyyy-MM-dd HH:mm:ss"/></td>
                     <td><s:property value="oprcode" /></td>
                     <td><j:code2Name code="oprtype" definition="$OPRTYPE"/></td>
                     <td><j:code2Name definition="SUCCESS" code="success"/></td>
                     <td><s:property value="batchno" /></td>
                     <td><s:property value="boxnum" /></td>
                     <td><s:property value="amount" /></td>
                     <td><j:code2Name code="comcategory" definition="$IM_FXCOMCATEGORY"/></td>
                     <td><j:code2Name definition="$IM_FXSTORAREA" code="storarea" /></td>
                     <td><j:code2Name definition="$IM_FXRESUSE" code="resuse" /></td>
                     <td><j:code2Name definition="$IM_FXSTORAREA" code="storarea" /></td>
                     <td><s:property value="nosect" /></td>
                     <td><j:code2Name definition="#WAYIDINFO" code="wayid" /></td>
                     <td><j:code2Name definition="#WAYIDINFO" code="discomcode" /></td>
                     <td><s:date name="packtime" format="yyyy-MM-dd HH:mm:ss"/></td>
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
