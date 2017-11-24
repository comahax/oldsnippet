<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc" %>
<html>
<head>
    <title><s:text name="titleList"/></title>
    <script language="JavaScript" type="text/JavaScript">
	function ev_check() {
		addfield('param._ne_sumid', '<s:text name="sumid"/>', 'f', true, '14');
		addfield('param._se_discomcode', '<s:text name="discomcode"/>', 'c', true, '18');
		addfield('param._se_state', '<s:text name="state"/>', 'c', true, '16');
		addfield('param._se_submitcode', '<s:text name="submitcode"/>', 'c', true, '16');
		addfield('param._dnm_submittime', '<s:text name="submittime"/>', 'dt', true, '7');
		addfield('param._dnl_submittime', '<s:text name="submittime"/>', 'dt', true, '7');
		addfield('param._se_confirmcode', '<s:text name="confirmcode"/>', 'c', true, '16');
		return checkval(window);
	}
	//返回指定名称下的多选框,选中的数量
    function chooseCount(anObjectName){
    	var count = 0;
        var objArray= document.getElementsByName(anObjectName);
        for(var i = 0;i<objArray.length;i++){
	        var e = objArray[i];
                if (e.type == 'checkbox') {
                    if (e.checked)
                        count++;
                }
        }
        return count;
    }
    function doConfirm(actionUrl){
    	<%-- var count = chooseCount('param._selectitem');
        	if(count < 1){
	        	var alertstr = '<span class=\'errorkey\'><span style=\'color:#F00; font-size:12px;\'>[请选择一个或多个选项]';
				errorMessageShow(alertstr);
				return false;
        	}
        	
        	var objArray= document.getElementsByName('param._selectitem');
	        for(var i = 0;i<objArray.length;i++){
		        var e = objArray[i];
	                if (e.type == 'checkbox') {
	                    if (e.checked){
		                    var valueArray = e.value.split('|');
		                    	if('WAITCONFIRM' != valueArray[1]){//判断是否为待确认状态
		                    		var alertstr = '<span class=\'errorkey\'><span style=\'color:#F00; font-size:12px;\'>[汇总单['+ valueArray[0] +']状态不正确，待确认状态才允许执行确认操作。]';
									errorMessageShow(alertstr);
									return false;
		                    	}
	                    }     
	                }
	        }--%>
        	
        formList.action=contextPath + actionUrl;
        formList.submit();
     }
     
     function doPay(actionUrl){
     	formList.action=contextPath + actionUrl;
        formList.submit();
     }

 
    function showWindow(){
    	var count = chooseCount('param._selectitem');
        if(count < 1){
        	var alertstr = '<span class=\'errorkey\'><span style=\'color:#F00; font-size:12px;\'>[请选择一个选项]';
			errorMessageShow(alertstr);
			return false;
    	}
        if(count > 1){
        	var alertstr = '<span class=\'errorkey\'><span style=\'color:#F00; font-size:12px;\'>[只能选择一个选项]';
			errorMessageShow(alertstr);
			return false;
    	}

        var objArray= document.getElementsByName('param._selectitem');
        var  sumid = null;
        for(var i = 0;i<objArray.length;i++){
	        var e = objArray[i];
                if (e.type == 'checkbox') {
                    if (e.checked){
	                    var valueArray = e.value.split('|');
	        			sumid = valueArray[0];	
                    }
                }
        }
  		var url=contextPath + '/sales/adpaysum_detail.do?sumid='+ sumid;
		var rtn=window.showModalDialog(url , self , "dialogWidth:800px; dialogHeight:500px; status:no; resizable:no;");
		return (rtn == null ? "" : rtn);
	} 
	function showWindow2(url){
		var rtn=window.showModalDialog(url , self , "dialogWidth:800px; dialogHeight:500px; status:no; resizable:no;");
	} 
</script>
</head>

<body class="list_body" onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<s:form action="adpaysum_list.do" key="formList" cssStyle="formList" theme="simple" onsubmit="return ev_check();">
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
                <td align="center"><s:text name="sumid"/>:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._ne_sumid" />
                </td>
                <td align="center"><s:text name="discomcode"/>:</td>
                <td align="left">
                    <j:selector name="param._se_discomcode" definition="#WAYIDINFO"  condition="waytype:AG;waysubtype:LOGS;cityid:${USER.cityid}"/>
                </td>
            </tr>
            <tr>
                <td align="center"><s:text name="state"/>:</td>
                <td align="left">
                    <j:selector name="param._se_state" definition="$FX_SUMSTATE"/>
                </td>
                <td align="center"><s:text name="submitcode"/>:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._se_submitcode" />
                </td>
            </tr>
            <tr>
                <td align="center"><s:text name="submittime"/>>=:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._dnl_submittime" onclick="selectDatetime();" readonly="true"/>
                </td>
                <td align="center"><s:text name="submittime"/><=:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._dnm_submittime" onclick="selectDatetime();" readonly="true"/>
                </td>
            </tr>
            <tr>
                <td align="center"><s:text name="confirmcode"/>:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._se_confirmcode" />
                </td>
                <td></td><td></td>
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
                        value="<s:text name="button_search"/>" onClick="doQuery('/sales/adpaysum_list.do');">
                	
                	<!-- 
                	<input type="button" id="btnDelete2" name="btnNew" class="button_2" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="<s:text name="button_confirm"/>" onClick="doConfirm('/sales/adpaysum_confirm.do')">
                    
                    <input type="button" id="btnDelete2" name="btnDelete2" class="button_4" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="<s:text name="button_lookinfo"/>" onClick="showWindow()">
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
                <td>
                    <j:orderByImg href="javascript:doOrderby('sumid')"><s:text name="sumid"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('discomcode')"><s:text name="discomcode"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('begintime')"><s:text name="begintime"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('endtime')"><s:text name="endtime"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('orderamt')"><s:text name="orderamt"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('cancelamt')"><s:text name="cancelamt"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('recamt')"><s:text name="recamt"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('submitcode')"><s:text name="submitcode"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('submittime')"><s:text name="submittime"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('confirmcode')"><s:text name="confirmcode"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('confirmtime')"><s:text name="confirmtime"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('createtime')"><s:text name="createtime"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('state')"><s:text name="state"/></j:orderByImg>                 
                </td>
                <td>
                    <s:text name="operate"/>
                </td>
            </tr>
            <s:iterator value="dp.datas">
                 <tr class="table_style_content" align="center" onMouseMove="this.bgColor='F0F5F9'" onMouseOut="this.bgColor='#ffffff'">
					 <%-- 复合主键用“|”间隔开 --%>
					 <!-- 
					 <td>
                         <input type="checkbox" name="param._selectitem" value="<s:property value="sumid + '|' + state"/>" onclick="checkOne();">
                     </td>
					  -->
					  <s:url value="/sales/adpaysum_detail.do" var='urlContent'>
	                         <s:param name="param._pk" value="sumid"/>
	                   </s:url>
	                   <s:url value="/sales/adpaysum_confirm.do" var='urlContent2'>
	                         <s:param name="param._pk" value="sumid"/>
	                   </s:url>
	                   <s:url value="/sales/adpaysum_pay.do" var='urlContent3'>
	                         <s:param name="param._pk" value="sumid"/>
	                   </s:url>
                     <td>
                         <a href="javascript:showWindow2('<s:property value="urlContent"/>')"><s:property value="sumid"/></a>
                     </td>
                     <td><j:code2Name code="discomcode" definition="#WAYIDINFO"/></td>
                     <td><s:date format="yyyy-MM-dd HH:mm:ss" name="begintime"/></td>
                     <td><s:date format="yyyy-MM-dd HH:mm:ss" name="endtime"/></td>
                     <td><s:property value="orderamt" /></td>
                     <td><s:property value="cancelamt" /></td>
                     <td><s:property value="recamt" /></td>
                     <td><j:code2Name code="submitcode" definition="#EMPLOYEE"/></td>
                     <td><s:date format="yyyy-MM-dd HH:mm:ss" name="submittime"/></td>
                     <td><j:code2Name code="confirmcode" definition="#OPERATOR"/></td>
                     <td><s:date format="yyyy-MM-dd HH:mm:ss" name="confirmtime"/></td>
                     <td><s:date format="yyyy-MM-dd HH:mm:ss" name="createtime"/></td>
                     <td><j:code2Name code="state" definition="$FX_SUMSTATE"/></td>
                     <td>
                     	<s:if test="state eq 'WAITCONFIRM'">
                     	<input type="button" id="btnDelete2" name="btnNew" class="button_2" onmouseover="buttonover(this);"
                        	onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        	value="<s:text name="button_confirm"/>" onClick="doConfirm('<s:property value="urlContent2"/>')">
                        </s:if>
                        <s:if test="state eq 'CONFIRMED'">
                        <input type="button" id="btnpay" name="btnNew" class="button_2" onmouseover="buttonover(this);"
                        	onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        	value="<s:text name="button_pay"/>" onClick="doPay('<s:property value="urlContent3"/>')">
                        </s:if>
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
</body>
</html>
<script language="javascript"> 
	ajaxAnywhere.getZonesToReload = function(url,submitButton) {
		return "errorZone,listZone,hiddenZone";  
	}
	ajaxAnywhere.substituteFormSubmitFunction();ajaxAnywhere.formURL = formList.action;
	ajaxAnywhere.substituteSubmitButtonsBehaviorByIDs(true,"btnQuery,btnDelete");
</script> 

