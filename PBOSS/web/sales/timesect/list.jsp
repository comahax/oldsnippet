<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc" %>
<html>
<head>
    <title><s:text name="titleList"/></title>
    <script language="JavaScript" type="text/JavaScript">
	function ev_check() {
		addfield('param._se_cityid', '<s:text name="cityid"/>', 'c', true, '10');
		addfield('param._se_countyid', '<s:text name="countyid"/>', 'c', true, '14');
		addfield('param._se_mareacode', '<s:text name="mareacode"/>', 'c', true, '14');
		addfield('param._se_datetype', '<s:text name="datetype"/>', 'c', true, '16');
		return checkval(window);
	}
	function opendMareacode(aObj,formWhere){
	     var countyid = document.getElementById('countyid').value;
	     if(countyid == ''){
		     openPicker(aObj,formWhere);
	     }else{
		     openPicker(aObj,formWhere,null,'boss.cms.microarea.queryBycountyid','COUNTYID:'+countyid);
	    }
    }
	function putCountyID(countyid){
	     document.getElementById('countyid').value=countyid;
	}
</script>
<style>
.table_style_content {
	
}
.table_style_content td {
	border-right:#FFFFFF inset 2px;
	border-bottom-width: 1px;
	border-bottom-style: solid;
	border-bottom-color: #D7D7D7;
	font-family: "宋体";
	font-size: 12px;
	font-weight: normal;
	font-color: #666666;
	height: auto !important;
	vertical-align: middle;
	<!--text-align:center;-->
	padding:0px 8px 0px 8px;
	word-break:break-all;
	white-space:nowrap;
}
</style>
</head>

<body class="list_body" onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<s:form action="timesect_list.do" key="formList" cssStyle="formList" theme="simple" onsubmit="return ev_check();">
	<%//下面的控件给Action提供数据，用来分页%>
	<aa:zone name="hiddenZone">
    <s:hidden name="param._orderby"/>
    <s:hidden name="param._desc"/>
    <s:hidden name="param._pageno"/>
    <s:hidden name="param._pagesize"/>
    <s:hidden name="param.queryAll"/>
    <input type="hidden" name="_rowcount" value="<s:property value="dp.rowCount" />"/>
    <input type="hidden" id ="countyid" value='<s:property value="param._se_countyid"/>'/></aa:zone>
    
	<div class="table_top">
		<div class="table_topleft"></div>
		<div class="table_toparea_w">
			<s:i18n name="public">
			<span class="table_toparea"><s:text name="currentPos"/> </span>
			<span class="table_toparea_xi">></span>
			<span class="table_toparea"><s:text name="sales"/> </span>
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
                <td align="center"><s:text name="cityid"/>:</td>
                <td align="left">
                    <j:selector definition="#CITYCOMPANY" name="param._se_cityid" mode="selector" condition="citycompid:${dBAccessUser.cityid }" value="%{dBAccessUser.cityid}" disabled="true"/>
                </td>
                <td align="center"><s:text name="datetype"/>:</td>
                <td align="left">
                    <j:selector name="param._se_datetype" definition="$FX_DATETYPE" />
                </td>
            </tr>
            <tr>
                <td align="center"><s:text name="countyid"/>:</td>
                <td align="left">
                    <j:selector definition="#CNTYCOMPANY" name="param._se_countyid" mode="selector" condition="citycompid:${dBAccessUser.cityid }"  onchange="putCountyID(this.value);" />
                </td>
                <td align="center"><s:text name="mareacode"/>:</td>
                <td align="left">
                    <s:textfield name="param._se_mareacode"/><input class="picker_button" onclick="javascript:opendMareacode(this,'#MICROAREA');"  type="button" value="..." name="param._se_mareacode_button"/>
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
                        value="<s:text name="button_search"/>" onClick="doQuery('/sales/timesect_list.do');">
                	
                    <input type="button" id="btnNew" name="btnNew" class="button_New" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="<s:text name="button_new"/>" onClick="doNew('/sales/timesect_new.do')">
                    
                    <input type="button" id="btnDelete" name="btnDelete" class="button_Delete" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="<s:text name="button_delete"/>" onClick="doDelete('/sales/timesect_delete.do')">
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
                    <j:orderByImg href="javascript:doOrderby('recid')"><s:text name="recid"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('cityid')"><s:text name="cityid"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('countyid')"><s:text name="countyid"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('mareacode')"><s:text name="mareacode"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('datetype')"><s:text name="datetype"/></j:orderByImg>                
                </td>
                <td>
                	<s:text name="orderdatetimesect"/>
                </td>
            </tr>
            <s:iterator value="timesectList">
                 <tr class="table_style_content" align="center" onMouseMove="this.bgColor='F0F5F9'" onMouseOut="this.bgColor='#ffffff'">
					 <%-- 复合主键用“|”间隔开 --%>
                     <td>
                         <input type="checkbox" name="param._selectitem" value="<s:property value="recid"/>" onclick="checkOne();">
                     </td>
                     <td><a href='<s:url action="timesect_edit.do">
	                         <s:param name="param._pk" value="recid"/>
	                     	</s:url>'>
							<s:property value="recid"/>
                         </a>
					 </td>
                     <td><j:code2Name definition="#CITYCOMPANY" code="cityid"/></td>
                     <td><j:code2Name definition="#CNTYCOMPANY" code="countyid"/></td>
                     <td><j:code2Name definition="#MICROAREA" code="mareacode"/></td>
                     <td><j:code2Name definition="$FX_DATETYPE" code="datetype"/></td>
                     <td><s:property escape = "false" value="orderdatetimesect" /></td>
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

