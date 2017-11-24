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
	addfield('param._dnl_changetime', '<s:text name="_dnl_changetime"/>', 't', false, '7');
	addfield('param._dnm_changetime', '<s:text name="_dnm_changetime"/>', 't', false, '7');
	return checkval(window);
}

function doExport() {
	doQuery("<%=contextPath%>/sales/waystocksnpt_exportusedstatistic.do");
	formList.action="<%=contextPath%>/sales/waystocksnpt_usedstatistic.do";
}

function doTxt() {
	doQuery("<%=contextPath%>/sales/waystocksnpt_exportusedstatisticTxt.do");
	formList.action="<%=contextPath%>/sales/waystocksnpt_usedstatistic.do";
}
</script>
</head>

<body class="list_body" onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<s:form action="waystocksnpt_usedstatistic.do" key="formList" cssStyle="formList" theme="simple" onsubmit="return ev_check();">
  <%//����Ŀؼ���Action�ṩ���ݣ�������ҳ%>
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
			<span class="table_toparea_h"><s:text name="titleUsedstatistic"/></span>
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
                    <j:selector definition="$CH_STARLEVEL" name="param._ne_starlevel" />
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="upperwayid" />:</td>
				<td align="left">
					<s:textfield cssStyle="style_input" name="param._se_upperwayid" /><input type="button" value="..." class="picker_button"
						onclick="pshowSelectWay3(this,'param._se_upperwayid','','','AG|ET','DIS|GMPT|G100');this.value='...';" />
				</td>
                <td align="right"><s:text name="comcategory"/>:</td>
                <td align="left">
                    <j:selector name="param._se_comcategory" definition="$IM_FXCOMCATEGORY" mode="picker" />
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="_dnl_changetime"/>:</td>
                <td align="left">
                    <input type="text" name="param._dnl_changetime" id="_dnl_changetime" 
                    	value="<s:property value="param._dnl_changetime"/>"  readonly="readonly"
                    	onclick="WdatePicker({maxDate:'#F{$dp.$D(\'_dnm_changetime\')}'})">
                    <font color=red>*</font>
                </td>
                <td align="right"><s:text name="_dnm_changetime"/>:</td>
                <td align="left">
                    <input type="text" name="param._dnm_changetime" id="_dnm_changetime" 
                    	value="<s:property value="param._dnm_changetime"/>"  readonly="readonly"
                    	onclick="WdatePicker({minDate:'#F{$dp.$D(\'_dnl_changetime\')}'})"/>
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
                        value="<s:text name="button_search"/>" onClick="doQuery('/sales/waystocksnpt_usedstatistic.do');">
					<input type="button" id="btnExport" name="btnExport" class="button_4" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="����Excel" onClick="doExport();">
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
                <td><s:text name="countyid"/></td>
                <td><s:text name="svccode"/></td>
                <td><s:text name="mareacode"/></td>
                <td><s:text name="orderid"/></td>
                <td><s:text name="wayid"/></td>
                <td><s:text name="wayname"/></td>
                <td><s:text name="starlevel"/></td>
                <td><s:text name="comcategory"/></td>
                <td><s:text name="salenum"/></td>
                <td><s:text name="upperwayid"/></td>
            </tr>
            <s:iterator value="dp.datas">
                 <tr class="table_style_content" align="center" onMouseMove="this.bgColor='F0F5F9'" onMouseOut="this.bgColor='#ffffff'">
					 <%-- ���������á�|������� --%>
                     <td><j:code2Name code="countyid" definition="#CNTYCOMPANY"/></td>
                     <td><j:code2Name code="svccode" definition="#SERVCENT"/></td>
                     <td><j:code2Name code="mareacode" definition="#MICROAREA"/></td>
                     <td><s:property value="orderid"/></td>
                     <td><s:property value="wayid"/></td>
                     <td><s:property value="wayname"/></td>
                     <td><j:code2Name code="starlevel" definition="$CH_STARLEVEL"/></td>
                     <td><j:code2Name code="comcategory" definition="$IM_FXCOMCATEGORY"/></td>
                     <td><s:property value="stocknum"/></td>
                     <td><j:code2Name code="upperwayid" definition="#WAY"/></td>
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