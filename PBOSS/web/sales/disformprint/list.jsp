<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc" %>
<html>
<head>
    <title><s:text name="titleList"/></title>
    <script type="text/javascript" src="<%=contextPath%>/js/bus/pwaycommon.js"></script>
    <script language="JavaScript" type="text/JavaScript">
	function ev_check() {
		addfield('param._dnm_createtime', '<s:text name="createtime"/>', 'dt', true, '7');
		addfield('param._dnl_createtime', '<s:text name="createtime"/>', 'dt', true, '7');
		addfield('param._se_recewayid', '<s:text name="recewayid"/>', 'c', true, '18');
		addfield('param._se_discomcode', '<s:text name="discomcode"/>', 'c', true, '18');
		addfield('param._se_disstate', '<s:text name="disstate"/>', 'c', true, '16');
		addfield('param._dnm_ordcreatetime', '<s:text name="ordcreatetime"/>', 'dt', true, '7');
		addfield('param._dnl_ordcreatetime', '<s:text name="ordcreatetime"/>', 'dt', true, '7');
		addfield('param._se_countyid', '<s:text name="countyid"/>', 'c', true, '14');
		return (checkval(window) && compareDate());
	}
	
	function compareDate(){
	    var endTime = document.getElementById('param._dnm_ordcreatetime').value;
	    var beginTime = document.getElementById('param._dnl_ordcreatetime').value;

	    if(endTime != '' && beginTime != '' &&  beginTime>endTime){
	        var alertstr1 = '<span class=\'errorkey\'><span style=\'color:#F00; font-size:12px;\'>[<s:text name="_dnl_ordcreatetime"/> ]</span> 不能大于 <span style=\'color:#F00; font-size:12px;\'>[<s:text name="_dnm_ordcreatetime"/>]</span>';
			errorMessageShow(alertstr1);
	        return false;
	    }
	    
	    endTime = document.getElementById('param._dnm_createtime').value;
	    beginTime = document.getElementById('param._dnl_createtime').value;
	    if(endTime != '' && beginTime != '' &&  beginTime>endTime){
	        var alertstr2 = '<span class=\'errorkey\'><span style=\'color:#F00; font-size:12px;\'>[<s:text name="_dnl_createtime"/> ]</span> 不能大于 <span style=\'color:#F00; font-size:12px;\'>[<s:text name="_dnm_createtime"/>]</span>';
			errorMessageShow(alertstr2);
	        return false;
	    }
	    
        return true;	
    }
    
    function doExport(actionUrl){
        formList.action="<%=contextPath%>"+actionUrl;
        formList.submit();
        formList.action="<%=contextPath%>/sales/disformprint_list.do";
    }
</script>
</head>

<body class="list_body" onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<s:form action="disformprint_list.do" key="formList" cssStyle="formList" theme="simple" onsubmit="return ev_check();">
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
			<span class="table_toparea"><s:text name="title_sales_disform" /></span>
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
                <td align="right"><s:text name="ordcreatetimeBegin"/>:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._dnl_ordcreatetime" onclick="selectDatetime();"/>
                </td>    
                <td align="right"><s:text name="ordcreatetimeEnd"/>:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._dnm_ordcreatetime" onclick="selectDatetime();"/>
                </td>            
            </tr>
            <tr>
                <td align="right"><s:text name="createtimeBegin"/>:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._dnl_createtime" onclick="selectDatetime();"/>
                </td>
                <td align="right"><s:text name="createtimeEnd"/>:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._dnm_createtime" onclick="selectDatetime();"/>
                </td>
            </tr>
            <tr>
            	<td align="right"><s:text name="countyid"/>:</td>
                <td align="left">
                    <j:selector definition="#CNTYCOMPANY"  condition="citycompid:${USER.cityid}" name="param._se_countyid" mode="selector"/>
                </td>
                <td align="right"><s:text name="recewayid"/>:</td>
                <td align="left">
                	<s:textfield cssStyle="style_input" name="param._se_recewayid"/><input type="button" value="..." class="picker_button" onclick="pshowSelectWay3(this,'param._se_recewayid',null,null,'AG');this.value='...';" />
                </td>
            </tr>
            <tr>
            	<td align="right"><s:text name="discomcode"/>:</td>
                <td align="left">
                    <!--s:textfield cssStyle="style_input" name="param._se_discomcode" /-->
                    <j:selector name="param._se_discomcode" definition="#WAYIDINFO"  condition="waytype:AG;waysubtype:LOGS;cityid:${USER.cityid}"/><!-- mode="selector" -->
                </td>
                <td align="right"><s:text name="disstate"/>:</td>
                <td align="left">
                    <j:selector definition="$FX_DISFORMSTATE" name="param._se_disstate"  cssStyle="style_input"/>
                </td>
            </tr>
        </table>
    </div>
    
    <div class="table_div">
		<table class="table_button_list">
			<tr>
				<td>
                	<s:i18n name="public"></s:i18n>
                	<input type="button" id="btnQuery" name="btnQuery" class="button_Query" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="<s:text name="btn_statatic"/>" onClick="doQuery('/sales/disformprint_list.do');">
                	
                    <input type="button" id="btnExport" name="btnExport" class="button_4" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="<s:text name="btn_export"/>" onClick="doExport('/sales/disformprint_exportExcel.do')">
   
				</td>
			</tr>
		</table>
	</div>

	<aa:zone name="listZone">
    <div class="table_div">
    	<div class="table_LongTable">
        <table class="table_style">
            <tr class="table_style_head">
               	<td><s:text name="seqid"/></td>
               	<td><s:text name="countyname"/></td>
            	<td><s:text name="comid"/></td>
            	<td><s:text name="comname"/></td>
            	<td><s:text name="ncount"/></td>
            </tr>
            <s:iterator value="dp.datas" status="state">
                 <tr class="table_style_content" align="center" onMouseMove="this.bgColor='F0F5F9'" onMouseOut="this.bgColor='#ffffff'">
					<td><s:text name="#state.count"/></td>
					<!--td><s:property value="countyid"/></td-->
					<td><j:code2Name definition="#CNTYCOMPANY" code="countyid" /></td>
                    <td><s:property value="comid" /></td>
                    <td><j:code2Name code="comid" definition="#COMSYSTEM"/></td>
                    <td cssClass="countclass"><s:property value="num" /></td>
                 </tr>
             </s:iterator>
             <tr class="table_style_content" align="right">
             	<td><s:text name="total"/></td>
             	<td id="allamountTd" colspan="5"><s:property value="form.allcount" /></td>
             </tr>
        </table>
        </div>
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
