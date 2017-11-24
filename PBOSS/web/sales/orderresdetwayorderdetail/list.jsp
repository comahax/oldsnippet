<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ include file="/inc/listhead.inc" %>
<% 
Date date=new Date();
SimpleDateFormat sdf1=new SimpleDateFormat("yyyy-MM-dd");
String dateStr = sdf1.format(date) + " 00:00:00";
String dateStr1 = sdf1.format(date) + " 23:59:59";
%>
<html>
<head>
    <title><s:text name="titleList"/></title>
    <script type="text/javascript" src="<%=contextPath%>/js/bus/pwaycommon.js"></script>
    <script language="JavaScript" type="text/JavaScript">
	function ev_check() {
		addfield('param._se_countyid', '<s:text name="countyid"/>', 'c', true, '14');
		addfield('param._se_svccode', '<s:text name="svccode"/>', 'c', true, '14');
		addfield('param._se_mareacode', '<s:text name="mareacode"/>', 'c', true, '14');
		addfield('param._se_comcategory', '<s:text name="comcategory"/>', 'c', true, '20');
		addfield('param._dnm_recordtime', '<s:text name="recordtimem"/>', 'dt', false, '19');
		addfield('param._dnl_recordtime', '<s:text name="recordtimel"/>', 'dt', false, '19');
		addfield('param._se_wayid', '<s:text name="wayid"/>', 'c', true, '18');
		addfield('param._se_orderid', '<s:text name="orderid"/>', 'c', true, '18');
		return (checkval(window) && compareDate());
		<%-- 注意js写错了 return checkval((window) && compareDate());
		return (checkval(window));--%>
	}
	function compareDate(){
        var startTime = document.getElementById('param._dnl_recordtime').value;
        var endTime = document.getElementById('param._dnm_recordtime').value;
        if(startTime != '' && endTime != '' &&  startTime>endTime){
        var alertstr = '<span class=\'errorkey\'><span style=\'color:#F00; font-size:12px;\'>[创建时间>=]</span> 不能大于 <span style=\'color:#F00; font-size:12px;\'>[创建时间<=]</span>';
		errorMessageShow(alertstr);
        return false;
       }
    	return true;	
    }
	
	function openPicker(control,definition,condition) {
			<%--
			if(control.name.indexOf('param._se_countyid') > -1 ) {
                if(document.all('param._se_cityid').value == "") {
    	            // 选择“分公司”前要先指定“地市公司” 
    	            alert("请先输入"+'<s:text name="cityid"/>');
    	            return;
                }else {
                    // 查询指定“分公司”下的 “服务销售中心编码”
                	condition = 'citycompid:'+ document.all('param._se_cityid').value;
                }
            }
            --%>
            if(control.name.indexOf('param._se_svccode') > -1 ) {
                if(document.all('param._se_countyid').value == "") {
    	            // 选择“服务销售中心编码”前要先指定“分公司” 
    	            alert("请先输入"+'<s:text name="countyid"/>');
    	            return;
                }else {
                    // 查询指定“分公司”下的 “服务销售中心编码”
                	condition = '_se_countyid:'+ document.all('param._se_countyid').value;
                }
            }
            if(control.name.indexOf('param._se_mareacode') > -1 ) {
                if(document.all('param._se_svccode').value == "") {
                	// 选择“微区域编码”前要先指定 “服务销售中心编码”
                    alert("请先输入"+'<s:text name="svccode"/>');
                    return;
                }else {
                    // 查询指定 “服务销售中心编码”下的“微区域编码”
                    condition = '_se_svccode:' + document.all('param._se_svccode').value;
                }
                
            }
    	    if(definition == null || definition =="") {	  	    			
    	   		alert("definition is required!");
    	   		return ;
    	    }

    	    definition = window.encodeURIComponent(definition);	    
    	    var url = contextPath +"/common/picker_list.do?definition=" + definition;	

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
	
		function doExcel(cmd)
        {
		    var url = contextPath + cmd;
		    formList.action = url;  
		    formList.submit();
		    formList.action=contextPath+"/sales/orderresdetwayorderdetail_list.do";
        }
        
	</script>
</head>

<body class="list_body" onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<s:form action="orderresdetwayorderdetail_list.do" key="formList" cssStyle="formList" theme="simple" onsubmit="return ev_check();">
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
			<span class="table_toparea"><s:text name="分销管理"/></span>
			<span class="table_toparea_xi">></span>
			<span class="table_toparea"><s:text name="营收查询"/></span>
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
                <td align="center"><s:text name="countyid"/>:</td>
                <td align="left">
                    <!-- <s:textfield cssStyle="style_input" name="param._se_countyid" />  -->
                    <j:selector definition="#CNTYCOMPANY" name="param._se_countyid" mode="selector" 
                    condition="citycompid:${dBAccessUser.cityid }"   />
                </td>
                <td align="center"><s:text name="svccode"/>:</td>
                <td align="left">
                    <!-- <s:textfield cssStyle="style_input" name="param._se_svccode" />  -->
                    <j:selector definition="#SERVCENT" name="param._se_svccode" />
                </td>
                <td align="center">
					<s:text name="mareacode" />
					:
				</td>
				<td align="left">
					
					<j:selector definition="#MICROAREA" name="param._se_mareacode" />
				</td>
             </tr>
             <tr>
                <td align="center"><s:text name="wayid"/>:</td>
                <td align="left">
                    <!-- <s:textfield cssStyle="style_input" name="param._se_wayid" />  -->
                    <s:textfield name="param._se_wayid"/><input type="button" value="..." class="picker_button" 
                    onclick="pshowSelectWay3(this,'param._se_wayid','','','AG');this.value='...';" />
                   <%--  <s:textfield cssStyle="style_input" name="param._se_wayid" /><input type="button" value="..." class="picker_button"
					onclick="pshowSelectWay3(this,'param._se_wayid','','','AG');this.value='...';" />--%>
                </td>
                <td align="center"><s:text name="orderid"/>:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._se_orderid" />
                </td>
                <td align="center"><s:text name="comcategory"/>:</td>
                <td align="left">
                    <!-- <s:textfield cssStyle="style_input" name="param._se_comcategory" />  -->
                    <j:selector definition="$IM_FXCOMCATEGORY"
									name="param._se_comcategory" mode="picker" />
                </td>
              </tr>
              <tr>
                <td align="center"><s:text name="recordtimel"/>:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._dnl_recordtime"
                     onclick="selectDatetime()"  />
                    <font color=red>*</font>
                </td>
                <td align="center"><s:text name="recordtimem"/>:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._dnm_recordtime" 
                    onclick="selectDatetime()" />
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
                        value="统计" onClick="doQuery('/sales/orderresdetwayorderdetail_list.do');">
                    <input type="button" id="btnExcel" name="btnExcel" class="button_4" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="导出EXCEL" onClick="doExcel('/sales/orderresdetwayorderdetail_excel.do')">
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
                <td >
                   序号
                </td>
                </s:i18n>
                <td>
                    <j:orderByImg href="javascript:doOrderby('orderid')"><s:text name="orderid"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('countyid')"><s:text name="countyid"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('svccode')"><s:text name="svccode"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('mareacode')"><s:text name="mareacode"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('starlevel')"><s:text name="starlevel"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('wayid')">网点编码</j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('wayid')"><s:text name="wayname"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('comid')"><s:text name="comname"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('countvalue')"><s:text name="countvalue"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('comcamt')"><s:text name="comcamt"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('actamt')"><s:text name="actamt"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('orderrecordtime')">入账时间</j:orderByImg>                 
                </td>
                 <td>
                    <j:orderByImg href="javascript:doOrderby('oprcode')">入账工号</j:orderByImg>                 
                </td>
                
            </tr>
            <s:iterator value="dp.datas"  status="state">
                 <tr class="table_style_content" align="center" onMouseMove="this.bgColor='F0F5F9'" onMouseOut="this.bgColor='#ffffff'">
					 <%-- 复合主键用“|”间隔开 --%>
                     <td><s:property value="#state.count"/></td>
                     <td><s:property value="orderid" /></td>
                     <td>
                     <j:code2Name definition="#CNTYCOMPANY" code="countyid"/>
					 </td>
                     <td><s:property value="svccode" /></td>
                     <td><s:property value="mareacode" /></td>
                     <td><s:property value="starlevel" /></td>
                     <td><s:property value="wayid" /></td>
                     <td><j:code2Name definition="#WAYIDINFO" code="wayid" /></td>
                     <td><j:code2Name definition="#COMSYSTEM" code="comid" /></td>
                     <td><s:property value="countvalue" /></td>
                     <td><s:property value="comcamtFormat" /></td>
                     <td><s:property value="actamtFormat" /></td>
                     <td><s:property value="orderrecordtime" /></td>
                     <td><s:property value="oprcode" /></td>
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
