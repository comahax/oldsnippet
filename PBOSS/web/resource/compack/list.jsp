<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc" %>
<html>
<head>
    <title><s:text name="titleList"/></title>
    <script type="text/javascript" src="<%=contextPath%>/js/bus/pwaycommon.js"></script>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            addfield('param._se_batchno', '<s:text name="batchno"/>', 'c', true, '30');
            addfield('param._se_boxnum', '<s:text name="boxnum"/>', 'c', true, '100');
            addfield('param._se_comcategory', '<s:text name="comcategory"/>', 'c', true, '20');
            addfield('param._se_resuse', '<s:text name="resuse"/>', 'c', true, '20');
            addfield('param._se_storarea', '<s:text name="storarea"/>', 'c', true, '10');
            addfield('param._se_nosect', '<s:text name="nosect"/>', 'c', true, '10');
            addfield('param._se_wayid', '<s:text name="wayid"/>', 'c', true, '18');
            addfield('param._se_discomcode', '<s:text name="discomcode"/>', 'c', true, '18');
            return checkval(window);
        }
                
        function doExportExcel(actionUrl){		    
		    if(document.getElementById("countyid").disabled){
         		formList.action = contextPath + actionUrl;
	        	document.getElementById("countyid").disabled=false;
	        	formList.submit();
	        	formList.action = contextPath + '/resource/compack_list.do';
	        	document.getElementById("countyid").disabled=true;
         	}
         	else{
         		formList.action = contextPath + actionUrl;
		    	formList.submit();
		    	formList.action = contextPath + '/resource/compack_list.do';
         	}
        }
    </script>
</head>

<body class="list_body" onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<s:form action="compack_list.do" key="formList" cssStyle="formList" theme="simple" onsubmit="return ev_check();">
	<%//下面的控件给Action提供数据，用来分页%>
    <aa:zone name="hiddenZone"><s:hidden name="param._orderby"/>
    <s:hidden name="param._desc"/>
    <s:hidden name="param._pageno"/>
    <s:hidden name="param._pagesize"/>
    <s:hidden name="param.queryAll"/>
   

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
                <td align="center"><s:text name="batchno"/>:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._se_batchno" />
                </td>
                <td align="center"><s:text name="boxnum"/>:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._se_boxnum" />
                </td>
                  <td align="center"><s:text name="nosect"/>:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._se_nosect" />
                </td>
             </tr>
             <tr>
                <td align="center"><s:text name="comcategory"/>:</td>
                <td align="left">
                    <j:selector name="param._se_comcategory" definition="$IM_FXCOMCATEGORY" mode="picker"/>
                </td>
                 <td align="center"><s:text name="storarea"/>:</td>
                <td align="left">
                    <j:selector name="param._se_storarea" definition="$IM_FXSTORAREA"/>
                </td>
                <td align="center"><s:text name="resuse"/>:</td>
                <td align="left">
                    <j:selector name="param._se_resuse" definition="$IM_FXRESUSE"/>
                </td>
              </tr>
              <tr>
                <td align="center"><s:text name="wayid"/>:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._se_wayid" readonly="true"/><input type="button" value="..." class="picker_button" onclick="pshowSelectWay3(this,'param._se_wayid');this.value='...';" />
                </td>
                <td align="center"><s:text name="discomcode"/>:</td>
                <td align="left">
                    <j:selector name="param._se_discomcode" definition="#WAYIDINFO"  condition="waytype:AG;waysubtype:LOGS;cityid:${USER.cityid}"/>
                </td>
                <td align="center"><s:text name="packstate"/>:</td>
                <td align="left">
                    <j:selector name="param._se_packstate" definition="$FX_PACKSTATE" />
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
                        value="<s:text name="button_search"/>" onClick="doQuery('/resource/compack_list.do');">
                	
                	<input type="button" id="btnNew" name="btnNew" class="button_4" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="导出EXCEL" onClick="doExportExcel('/resource/compack_exportExcel.do');">
                	
                	<!--
                    <input type="button" id="btnNew" name="btnNew" class="button_New" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="<s:text name="button_new"/>" onClick="doNew('/resource/compack_new.do')">
                    
                    <input type="button" id="btnDelete" name="btnDelete" class="button_Delete" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="<s:text name="button_delete"/>" onClick="doDelete('/resource/compack_delete.do')">
                     -->
                   </s:i18n>
				</td>
			</tr>
		</table>
	</div>

	<aa:zone name="listZone">
	 <input type="hidden" name="_rowcount" value="<s:property value="dp.rowCount" />"/></aa:zone>
    <div class="table_div">
    	<div class="table_LongTable">
        <table class="table_style">
            <tr class="table_style_head">
               	<s:i18n name="public">
               	<!-- 
                <td title="<s:text name="list_title_select"/>">
                    <input type="checkbox" name="allbox" onclick="checkAll();"/>
                </td>
                 -->
                </s:i18n>
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
                <td>
                    商品明细                
                </td>
            </tr>
            <s:iterator value="dp.datas">
                 <tr class="table_style_content" align="center" onMouseMove="this.bgColor='F0F5F9'" onMouseOut="this.bgColor='#ffffff'">
					 <%-- 复合主键用“|”间隔开 --%>
					 <!-- 
                     <td>
                         <input type="checkbox" name="param._selectitem" value="<s:property value="batchno + '|' + boxnum"/>" onclick="checkOne();">
                     </td>
                      -->
                     <td>
						<s:property value="batchno"/>
					 </td>
                     <td>
							<s:property value="boxnum"/>
                         
					 </td>
                     <td><s:property value="amount" /></td>
                     <td><j:code2Name definition="$IM_FXCOMCATEGORY" code="comcategory" /></td>
                     <td><j:code2Name definition="$FX_PACKSTATE" code="packstate" /></td>
                     <td><j:code2Name definition="$IM_FXRESUSE" code="resuse" /></td>
                     <td><j:code2Name definition="$IM_FXSTORAREA" code="storarea" /></td>
                     <td><s:property value="nosect" /></td>
                     <td><j:code2Name definition="#WAYIDINFO" code="wayid" /></td>
                     <td><j:code2Name definition="#WAYIDINFO" code="discomcode" /></td>
                     <td><s:date name="packtime" format="yyyy-MM-dd HH:mm:ss"/></td>
                     <td>
                     <a href='javascript:void(0);' onclick="showModalDialog('<%=basePath %>resource/comressmp_productDetail.do?param._se_batchno=<s:property value="batchno" />&param._se_boxnum=<s:property value="boxnum" />&param._ne_comstate=<s:property value="packstate" />')">
	                     	点击查看
	                     	</a>
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
