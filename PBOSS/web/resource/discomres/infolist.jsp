<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc" %>
<html>
<head>
    <title><s:text name="titleList"/></title>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            addfield('param._se_disid', '<s:text name="disid"/>', 'c', true, '20');
            addfield('param._se_discomcode', '<s:text name="discomcode"/>', 'c', true, '18');
            addfield('param._snl_comresid', '<s:text name="comresid"/>', 'l', true, 32);
            addfield('param._snm_comresid', '<s:text name="comresid"/>', 'l', true, 32);
            addfield('param._dnl_issutime', '<s:text name="issutime"/>', 't', true, '10');
            addfield('param._dnm_issutime', '<s:text name="issutime"/>', 't', true, '10');
             return (checkval(window) && compareDate() && compareComresid());
        }
         function compareDate(){
        	var dnmIssutime = document.getElementById('param._dnm_issutime').value;
        	var dnlIssutime = document.getElementById('param._dnl_issutime').value;
        	
        	if(dnmIssutime != '' && dnlIssutime != '' && dnlIssutime>dnmIssutime){
	        	var alertstr = '<span class=\'errorkey\'><span style=\'color:#F00; font-size:12px;\'>[<s:text name="_dnl_issutime"/> ]</span> 不能大于 <span style=\'color:#F00; font-size:12px;\'>[<s:text name="_dnm_issutime"/>]</span>';
				errorMessageShow(alertstr);
				return false;
        	}
        	return true;
        }
        function compareComresid(){
        	var dnmcomresid = document.getElementById('param._snm_comresid').value;
        	var dnlcomresid = document.getElementById('param._snl_comresid').value;
        	
        	if(dnmcomresid != '' && dnlcomresid != '' && dnlcomresid>dnmcomresid){
	        	var alertstr = '<span class=\'errorkey\'><span style=\'color:#F00; font-size:12px;\'>[<s:text name="_snl_comresid"/>]</span> 不能大于 <span style=\'color:#F00; font-size:12px;\'>[<s:text name="_snm_comresid"/>]</span>';
				errorMessageShow(alertstr);
				return false;
        	}
        	return true;
        }
         function doExcel(){
        	formList.action="<%=contextPath%>/resource/discomres_excel.do";
        	formList.submit();
        	formList.action="<%=contextPath%>/resource/discomres_infolist.do";
        }
         function doTxt()
        {
        	formList.action="<%=contextPath%>/resource/discomres_txt.do";
        	formList.submit();
        	formList.action="<%=contextPath%>/resource/discomres_infolist.do";
        }
    </script>
</head>

<body class="list_body" onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<s:form action="discomres_infolist.do" key="formList" cssStyle="formList" theme="simple" onsubmit="return ev_check();">
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
			<span class="table_toparea"><s:text name="resource"/> </span>
			<span class="table_toparea_xi">></span>
			</s:i18n>
			<span class="table_toparea">配送商资源管理 </span>
			<span class="table_toparea_xi">></span>
			<span class="table_toparea_h">套卡资源查询</span>
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
                <td align="center"><s:text name="discomcode"/>:</td>
                <td align="left">
                    <j:selector name="param._se_discomcode" definition="#WAYIDINFO"  condition="waytype:AG;waysubtype:LOGS;cityid:${USER.cityid}"/>
                </td>
                <td align="center"><s:text name="comresid"/>>=:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._snl_comresid" />
                </td>
                <td align="center"><s:text name="comresid"/><=:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._snm_comresid" />
                </td>
            </tr>
              <tr>
                <td align="center"><s:text name="disid"/>:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._se_disid" />
                </td>
                <td align="center"><s:text name="issutime"/>>=:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._dnl_issutime" onclick="selectDate();"/>
                </td>
                <td align="center"><s:text name="issutime"/><=:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._dnm_issutime" onclick="selectDate();"/>
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
                        value="<s:text name="button_search"/>" onClick="doQuery('/resource/discomres_infolist.do');">
                	
                    <input type="button" id="btnExportexcel" name="btnExportexcel" class="button_4" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="<s:text name="button_exportexcel"/>" onClick="doExcel();">
                    
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
                <td>
                    <a href="javascript:doOrderby('recid')"><s:text name="recid"/></a>                 
                </td>
                <td>
                    <a href="javascript:doOrderby('disid')"><s:text name="disid"/></a>                 
                </td>
                <td>
                    <a href="javascript:doOrderby('discomcode')"><s:text name="discomcode"/></a>                 
                </td>
                <td>
                    <a href="javascript:doOrderby('batchno')"><s:text name="batchno"/></a>                 
                </td>
                <td>
                    <a href="javascript:doOrderby('boxnum')"><s:text name="boxnum"/></a>                 
                </td>
                 <td>
                    <a href="javascript:doOrderby('comid')"><s:text name="comid"/></a>                 
                </td>
                 <td>
                    <a href="javascript:doOrderby('comresid')"><s:text name="comresid"/></a>                 
                </td>
                 <td>
                    <a href="javascript:doOrderby('comstate')"><s:text name="comstate"/></a>                 
                </td>
                 <td>
                    <a href="javascript:doOrderby('issutime')"><s:text name="issutime"/></a>                 
                </td>
            </tr>
            <s:iterator value="dp.datas">
                 <tr class="table_style_content" align="center" onMouseMove="this.bgColor='F0F5F9'" onMouseOut="this.bgColor='#ffffff'">
					 <%-- 复合主键用“|”间隔开 --%>
                     <td>
							<s:property value="recid"/>
					 </td>
                     <td><s:property value="disid" /></td>
                     <td><j:code2Name definition="#WAYIDINFO" code="discomcode"/></td>
                     <td><s:property value="batchno" /></td>
                     <td><s:property value="boxnum" /></td>
                     <td><s:property value="comid" /></td>
                     <td><s:property value="comresid" /></td>
                     <td><j:code2Name definition="$FX_COMSTATE" code="comstate"/></td>
                     <td><s:date name="issutime" format="yyyy-MM-dd"/></td>
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
