<%@ page language="java" pageEncoding="GBK"%>
<%@ include file="/inc/listhead.inc" %>
<html>
<head>
<title><s:text name="titleList"/></title>
<script type="text/javascript" src="<%=contextPath%>/js/bus/pwaycommon.js"></script>
<script type="text/javascript">
function ev_check() {
	addfield('param._se_countyid', '<s:text name="countyid"/>', 'c', true, '14');
	addfield('param._se_svccode', '<s:text name="svccode"/>', 'c', true, '14');
	addfield('param._se_mareacode', '<s:text name="mareacode"/>', 'c', true, '14');
	addfield('param._se_wayid', '<s:text name="wayid"/>', 'c', true, '18');
	addfield('param._sk_wayname', '<s:text name="wayname"/>', 'c', true, '256');
	addfield('param._ne_starlevel', '<s:text name="starlevel"/>', 'f', true, '2');
	addfield('param._se_comcategory', '<s:text name="comcategory"/>', 'c', true, '20');
	addfield('param._se_emptyno', '<s:text name="emptyno"/>', 'c', true, '21');
	var _se_emptyno = document.getElementById("param._se_emptyno").value;
   	if (_se_emptyno == "") {
		addfield('param._dnl_stocktime', '<s:text name="_dnl_createtime"/>', 't', false, '7');
		addfield('param._dnm_stocktime', '<s:text name="_dnm_createtime"/>', 't', false, '7');
   	}
	return checkval(window);
}

function doExport() {
	doQuery("<%=contextPath%>/sales/waystocksnpt_exportsalerecord.do");
	formList.action="<%=contextPath%>/sales/waystocksnpt_salerecord.do";
}

function doTxt() {
	doQuery("<%=contextPath%>/sales/waystocksnpt_exportsalerecordTxt.do");
	formList.action="<%=contextPath%>/sales/waystocksnpt_salerecord.do";
}
</script>
</head>

<body class="list_body" onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<s:form action="waystocksnpt_salerecord.do" key="formList" cssStyle="formList" theme="simple" onsubmit="return ev_check();">
  <%//下面的控件给Action提供数据，用来分页%>
	<aa:zone name="hiddenZone">
	<s:hidden name="param._orderby"/>
	<s:hidden name="param._desc"/>
	<s:hidden name="param._pageno"/>
	<s:hidden name="param._pagesize"/>
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
			<span class="table_toparea_h"><s:text name="titleSalerecord"/></span>
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
                <td align="right"><s:text name="upperwayid" />:</td>
				<td align="left">
					<s:textfield cssStyle="style_input" name="param._se_upperwayid" /><input type="button" value="..." class="picker_button"
						onclick="pshowSelectWay3(this,'param._se_upperwayid','','','AG|ET','DIS|GMPT|G100');this.value='...';" />
				</td>
			</tr>
			<tr>
			    <td align="right"><s:text name="waymagcode" />:</td>
				<td class="form_table_left">
					<j:selector definition="#EMPLOYEE" name="param._se_waymagcode"
						condition='_ne_isnet:4;_ne_empstatus:0' mode="picker" />
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
                    <j:selector definition="$CH_STARLEVEL" name="param._ne_starlevel" />
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="emptyno"/>:</td>
                <td align="left"><s:textfield cssStyle="style_input" name="param._se_emptyno" /></td>
                <td align="right"><s:text name="comcategory"/>:</td>
                <td align="left">
                    <j:selector name="param._se_comcategory" definition="$IM_FXCOMCATEGORY" mode="picker" />
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="_dnl_createtime"/>:</td>
                <td align="left">
                    <input type="text" name="param._dnl_stocktime" id="_dnl_stocktime" 
                    	value="<s:property value="param._dnl_stocktime"/>" readonly="readonly"
                    	onclick="WdatePicker({maxDate:'#F{$dp.$D(\'_dnm_stocktime\')}'})">
                    <font color=red>*</font>
                </td>
                <td align="right"><s:text name="_dnm_createtime"/>:</td>
                <td align="left">
                    <input type="text" name="param._dnm_stocktime" id="_dnm_stocktime" 
                    	value="<s:property value="param._dnm_stocktime"/>"  readonly="readonly"
                    	onclick="WdatePicker({minDate:'#F{$dp.$D(\'_dnl_stocktime\')}'})"/>
                    <font color=red>*</font>
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
                        value="<s:text name="button_search"/>" onClick="doQuery('/sales/waystocksnpt_salerecord.do');">
					<input type="button" id="btnExport" name="btnExport" class="button_4" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="导出Excel" onClick="doExport();">
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
                <td><s:text name="emptyno"/></td>
                <td><s:text name="createtime"/></td>
                <td><s:text name="countyid"/></td>
                <td><s:text name="svccode"/></td>
                <td><s:text name="mareacode"/></td>
                <td><s:text name="orderid"/></td>
                <td><s:text name="wayid"/></td>
                <td><s:text name="wayname"/></td>
                <td><s:text name="starlevel"/></td>
                <td><s:text name="comcategory"/></td>
                <td><s:text name="upperwayid"/></td>
                <td><s:text name="waymagcode"/></td>
            </tr>
            <s:iterator value="dp.datas">
                 <tr class="table_style_content" align="center" onMouseMove="this.bgColor='F0F5F9'" onMouseOut="this.bgColor='#ffffff'">
					 <%-- 复合主键用“|”间隔开 --%>
					 <td><s:property value="emptyno"/></td>
					 <td><s:date name="stocktime" format="yyyy-MM-dd"/></td>
                     <td><j:code2Name code="countyid" definition="#CNTYCOMPANY"/></td>
                     <td><j:code2Name code="svccode" definition="#SERVCENT"/></td>
                     <td><j:code2Name code="mareacode" definition="#MICROAREA"/></td>
                     <td><s:property value="orderid"/></td>
                     <td><s:property value="wayid"/></td>
                     <td><s:property value="wayname"/></td>
                     <td><j:code2Name code="starlevel" definition="$CH_STARLEVEL"/></td>
                     <td><j:code2Name code="comcategory" definition="$IM_FXCOMCATEGORY"/></td>
                     <td><j:code2Name code="upperwayid" definition="#WAY"/></td>
                     <td><s:property value="waymagcode"/></td>
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