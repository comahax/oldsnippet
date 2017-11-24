<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc" %>
<html>
<head>
    <title><s:text name="titleList2"/></title>
    <script type="text/javascript" src="<%=contextPath%>/js/bus/pwaycommon.js"></script>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            addfield('param._dnm_alarmdate', '<s:text name="alarmdate"/>', 'dt', true, '7');
            addfield('param._dnl_alarmdate', '<s:text name="alarmdate"/>', 'dt', true, '7');
            addfield('param._se_countyid', '<s:text name="countyid"/>', 'c', true, '14');
            addfield('param._se_mareacode', '<s:text name="mareacode"/>', 'c', true, '14');
            return checkval(window);
        }
        function doExcel(){
        	formList.action="<%=contextPath%>/resource/stkalarmstat_excelstat.do";
        	formList.submit();
        	formList.action="<%=contextPath%>/resource/stkalarmstat_liststat.do";
        }
        function doTxt()
        {
        	formList.action="<%=contextPath%>/resource/stkalarmstat_txtstat.do";
        	formList.submit();
        	formList.action="<%=contextPath%>/resource/stkalarmstat_liststat.do";
        }
        function openPicker(control,definition,condition) {
        	if(control.name.indexOf('param._se_mareacode') > -1 ) {
                if(document.all('param._se_countyid').value == "") {
                	// 选择“微区域编码”前要先指定 “分公司”  这是一个跨级的查询
                    alert("请先输入"+'<s:text name="countyid"/>');
                    return;
                }else {
                    // 查询指定 “分公司”下的“微区域编码”
                    //condition = '_se_countyid:' + document.all('param._se_countyid').value;
                    condition = '';
                }
                
            }
            
            if(definition == null || definition =="") {	  	    			
    	   		alert("definition is required!");
    	   		return ;
    	    }
    	    
    	    definition = window.encodeURIComponent(definition);	    
    	    var url = contextPath +"/common/picker_list.do?definition=" + definition;
    	    
    	    // 对微区域查询时使用命名查询
    	    if (control.name.indexOf('param._se_mareacode') > -1) {
    	    
	    	    var sqlName = window.encodeURIComponent("boss.cms.microarea.queryBycountyid");
	    	    var url = url + "&sqlName=" + sqlName;
	    	    
	    	    // 查询参数使用分公司ID
	    	    var mapParam = window.encodeURIComponent("COUNTYID:" + document.all('param._se_countyid').value);
	    	    var url = url + "&mapParam=" + mapParam;
    	    }

    	    if(condition!=null) {
    	    	condition = window.encodeURIComponent(condition);
    	    	url = url +"&condition=" + condition;
    	    }
    	    
    	    url = url +"&" + new Date();

    		var rtn = window.showModalDialog(url, control, "dialogWidth:750px; dialogHeight:550px; status:no;resizable:no;");
    		
    		if( rtn == null) 
    			return false;
    			
    		var buttonID = control.name;		
    		if(buttonID == null || buttonID == "") {
    			alert("Must set the name property for this selector control!");
    			return false;
    		} 
    			
    		var selectorID = buttonID.substring(0, buttonID.indexOf("_button"));
    		var selectorTextID = selectorID + "_text";
    		
    		var codeCtrl = document.getElementById( selectorID );
    		var nameCtrl = document.getElementById( selectorTextID ); 
    		 
    		if(codeCtrl!=null) {
    			codeCtrl.value = rtn[0];
    			codeCtrl.focus();
    			}		
    		if(nameCtrl!=null) nameCtrl.value = rtn[1];
        }
    </script>
</head>

<body class="list_body" onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<s:form action="stkalarmstat_liststat.do" key="formList" cssStyle="formList" theme="simple" onsubmit="return ev_check();">
	<%//下面的控件给Action提供数据，用来分页%>
	<aa:zone name="hiddenZone">
    <s:hidden name="param._orderby"/>
    <s:hidden name="param._desc"/>
    <s:hidden name="param._pageno"/>
    <s:hidden name="param._pagesize"/>
    <s:hidden name="param.queryAll"/>
    <s:hidden name="form.totalred" id="totalred"/>
    <s:hidden name="form.totalyellow" id="totalyellow"/>
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
			<span class="table_toparea_h"><s:text name="titleList2"/></span>
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
                <td align="center"><s:text name="countyid"/>:</td>
                <td align="left">
                    <j:selector definition="#CNTYCOMPANY" name="param._se_countyid" condition="citycompid:${dBAccessUser.cityid }"  value="param._se_countyid" readonly="true"/>
                </td>
                <td align="center"><s:text name="mareacode"/>:</td>
                <td align="left">
                    <j:selector definition="#MICROAREA" name="param._se_mareacode" readonly="true"/>
                </td>
            </tr>
            <tr>
                <td align="center"><s:text name="alarmdate"/>&gt;=:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._dnl_alarmdate" onclick="selectDatetime();"/>
                </td>
                <td align="center"><s:text name="alarmdate"/>&lt;=:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._dnm_alarmdate" onclick="selectDatetime();"/>
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
                        value="<s:text name="button_search"/>" onClick="doQuery('/resource/stkalarmstat_liststat.do');">
                	
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
                <td><s:text name="seqid"/></td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('countyid')"><s:text name="countyid"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('mareacode')"><s:text name="mareacode"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('redalarm')"><s:text name="redalarm"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('yelalarm')"><s:text name="yelalarm"/></j:orderByImg>                 
                </td>
            </tr>
            <s:iterator value="dp.datas" status="state">
                 <tr class="table_style_content" align="center" onMouseMove="this.bgColor='F0F5F9'" onMouseOut="this.bgColor='#ffffff'">
                     <td><s:text name="#state.count"/></td>
                     <td><j:code2Name code="countyid" definition="#CNTYCOMPANY" /></td>
                     <td><j:code2Name code="mareacode" definition="#MICROAREA" /></td>
                     <td><s:property value="redalarm" /></td>
                     <td><s:property value="yelalarm" /></td>
                 </tr>
             </s:iterator>
             <tr class="table_style_content" align="center">
             	<td><s:text name="total"/></td>
             	<td >&nbsp;</td>
             	<td >&nbsp;</td>
             	<td><s:property value="form.totalred" /></td>
             	<td><s:property value="form.totalyellow" /></td>
             </tr>
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
	ajaxAnywhere.substituteFormSubmitFunction();  
	ajaxAnywhere.formURL = formList.action;
	ajaxAnywhere.substituteSubmitButtonsBehaviorByIDs(true,"btnQuery");
</script> 
</body>
</html>
