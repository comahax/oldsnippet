<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc" %>
<html>
<head>
    <title><s:text name="titleList"/></title>
</head>

<body class="list_body" onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<s:form action="sellnotice_wayMagList.do" key="formList" cssStyle="formList" theme="simple" onsubmit="return ev_check();">
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
			<span class="table_toparea"><s:text name="sales"/> </span>
			<span class="table_toparea_xi">></span>
			</s:i18n>
			<span class="table_toparea">销售进度查询</span>
			<span class="table_toparea_xi">></span>
			<span class="table_toparea_h"><s:text name="titleListWayMag"/></span>
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
            	<td align="center"><s:text name="countyid"/></td>
                <td align="left">
                	<j:selector definition="#CNTYCOMPANY"  condition="citycompid:${USER.cityid}" name="param._se_countyid" mode="selector" onchange="putCountyID(this.value);"/>
                </td>
                <td align="right"><s:text name="waymagcode"/>:&nbsp</td>
                <td align="left">
					<j:selector definition="#EMPLOYEE" name="param._se_waymagcode" condition='_ne_isnet:4;_ne_empstatus:0' mode="picker"/>
                </td>
            </tr>
            <tr>
            	<td align="center"><s:text name="startselltime"/>&gt;=:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._snl_selltime" onclick="selectDateForFmt('yyyy-MM');"/>
                </td>
                <td align="center"><s:text name="endselltime"/>&lt;=:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._snm_selltime" onclick="selectDateForFmt('yyyy-MM');"/>
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
                        value="<s:text name="button_search"/>" onClick="doQuery('/sales/sellnotice_wayMagList.do');">
                	<input type="button" class="button_4" onmouseover="buttonover(this);"
			            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
			            value="导出EXCEL" onClick="doExport();"/>
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
                    <j:orderByImg href="javascript:doOrderby('countyid')"><s:text name="countyid"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('waymagcode')"><s:text name="waymagcode"/></j:orderByImg>                 
                </td>                
                <td>
                    <j:orderByImg href="javascript:doOrderby('sellcount')"><s:text name="sellcount"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('salesstd')"><s:text name="salesstd"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('comrate')"><s:text name="comrate"/></j:orderByImg>                 
                </td>
            </tr>
            <s:iterator value="dp.datas">
                 <tr class="table_style_content" align="center" onMouseMove="this.bgColor='F0F5F9'" onMouseOut="this.bgColor='#ffffff'">
					 <%-- 复合主键用“|”间隔开 --%>
                     
                     <td><j:code2Name code="countyid" definition="#CNTYCOMPANY" /></td>
                     <td><j:code2Name code="waymagcode" definition="#EMPLOYEE" /></td>                     
                     <td><s:property value="sellcount" /></td>
                     <td><s:property value="salesstd" /></td>
                     <td><s:property value="comrate" />%</td>
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
	function doExport(){
		formList.action="<%=contextPath%>/sales/sellnotice_wayMagExcel.do";
    	formList.submit();
    	formList.action="<%=contextPath%>/sales/sellnotice_wayMagList.do";
	}
	function ev_check() {
		
		return checkval(window);
	}
</script>
