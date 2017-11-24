<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc" %>
<html>
<head>
    <title><s:text name="titleList"/></title>
</head>

<body class="list_body" onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<s:form action="simrealtimeamt_list.do" key="formList" cssStyle="formList" theme="simple" onsubmit="return ev_check();">
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
			<span class="table_toparea"><s:text name="base"/> </span>
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
                    <s:textfield cssStyle="style_input" name="param._sl_wayid" />
                </td>
                <td align="center"><s:text name="wayid"/>:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._snm_wayid" />
                </td>
                <td align="center"><s:text name="wayid"/>:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._se_wayid" />
                </td>
                <td align="center"><s:text name="wayid"/>:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._snl_wayid" />
                </td>
                <td align="center"><s:text name="wayid"/>:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._sm_wayid" />
                </td>
                <td align="center"><s:text name="wayid"/>:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._sin_wayid" />
                </td>
                <td align="center"><s:text name="wayid"/>:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._snin_wayid" />
                </td>
                <td align="center"><s:text name="wayid"/>:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._sk_wayid" />
                </td>
                <td align="center"><s:text name="wayid"/>:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._snk_wayid" />
                </td>
                <td align="center"><s:text name="uptime"/>:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._dl_uptime" />
                </td>
                <td align="center"><s:text name="uptime"/>:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._dnm_uptime" />
                </td>
                <td align="center"><s:text name="uptime"/>:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._de_uptime" />
                </td>
                <td align="center"><s:text name="uptime"/>:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._dnl_uptime" />
                </td>
                <td align="center"><s:text name="uptime"/>:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._dm_uptime" />
                </td>
                <td align="center"><s:text name="uptime"/>:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._din_uptime" />
                </td>
                <td align="center"><s:text name="uptime"/>:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._dnin_uptime" />
                </td>
                <td align="center"><s:text name="uptime"/>:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._dk_uptime" />
                </td>
                <td align="center"><s:text name="uptime"/>:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._dnk_uptime" />
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
                        value="<s:text name="button_search"/>" onClick="doQuery('/sales/simrealtimeamt_list.do');">
                	
                    <input type="button" id="btnNew" name="btnNew" class="button_New" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="<s:text name="button_new"/>" onClick="doNew('/sales/simrealtimeamt_new.do')">
                    
                    <input type="button" id="btnDelete" name="btnDelete" class="button_Delete" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="<s:text name="button_delete"/>" onClick="doDelete('/sales/simrealtimeamt_delete.do')">
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
                    <j:orderByImg href="javascript:doOrderby('monordered')"><s:text name="monordered"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('dayordered')"><s:text name="dayordered"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('nowstock')"><s:text name="nowstock"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('uptime')"><s:text name="uptime"/></j:orderByImg>                 
                </td>
            </tr>
            <s:iterator value="dp.datas">
                 <tr class="table_style_content" align="center" onMouseMove="this.bgColor='F0F5F9'" onMouseOut="this.bgColor='#ffffff'">
					 <%-- 复合主键用“|”间隔开 --%>
                     <td>
                         <input type="checkbox" name="param._selectitem" value="<s:property value="wayid"/>" onclick="checkOne();">
                     </td>
                     <td><a href='<s:url action="simrealtimeamt_edit.do">
	                         <s:param name="param._pk" value="wayid"/>
	                     	</s:url>'>
							<s:property value="wayid"/>
                         </a>
					 </td>
                     <td><s:property value="monordered" /></td>
                     <td><s:property value="dayordered" /></td>
                     <td><s:property value="nowstock" /></td>
                     <td><s:property value="uptime" /></td>
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
<script language="JavaScript" type="text/JavaScript">
	function ev_check() {
		addfield('param._sl_wayid', '<s:text name="wayid"/>', 'c', true, '18');
		addfield('param._snm_wayid', '<s:text name="wayid"/>', 'c', true, '18');
		addfield('param._se_wayid', '<s:text name="wayid"/>', 'c', true, '18');
		addfield('param._snl_wayid', '<s:text name="wayid"/>', 'c', true, '18');
		addfield('param._sm_wayid', '<s:text name="wayid"/>', 'c', true, '18');
		addfield('param._sin_wayid', '<s:text name="wayid"/>', 'c', true, '18');
		addfield('param._snin_wayid', '<s:text name="wayid"/>', 'c', true, '18');
		addfield('param._sk_wayid', '<s:text name="wayid"/>', 'c', true, '18');
		addfield('param._snk_wayid', '<s:text name="wayid"/>', 'c', true, '18');
		addfield('param._dl_uptime', '<s:text name="uptime"/>', 't', true, '7');
		addfield('param._dnm_uptime', '<s:text name="uptime"/>', 't', true, '7');
		addfield('param._de_uptime', '<s:text name="uptime"/>', 't', true, '7');
		addfield('param._dnl_uptime', '<s:text name="uptime"/>', 't', true, '7');
		addfield('param._dm_uptime', '<s:text name="uptime"/>', 't', true, '7');
		addfield('param._din_uptime', '<s:text name="uptime"/>', 't', true, '7');
		addfield('param._dnin_uptime', '<s:text name="uptime"/>', 't', true, '7');
		addfield('param._dk_uptime', '<s:text name="uptime"/>', 't', true, '7');
		addfield('param._dnk_uptime', '<s:text name="uptime"/>', 't', true, '7');
		return checkval(window);
	}
</script>
