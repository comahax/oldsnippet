<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc" %>
<html>
<head>
    <title><s:text name="titleList"/></title>
    <script language="JavaScript" type="text/JavaScript">
    var checkFlag = true;//是否进行提交的检查标识,TRUE时检查,否则不检查
   
        function ev_check() {
        if(checkFlag){
            addfield('param._se_disid', '<s:text name="disid"/>', 'c', true, '20');
            addfield('param._se_discomcode', '<s:text name="discomcode"/>', 'c', true, '18');
            addfield('param._se_storarea', '<s:text name="storarea"/>', 'c', true, '16');
            addfield('param._dnm_distime', '<s:text name="distime"/>', 'dt', true, '7');
            addfield('param._dnl_distime', '<s:text name="distime"/>', 'dt', true, '7');
            addfield('param._se_disformstate', '<s:text name="disformstate"/>', 'c', true, '16');
            return (checkval(window) && compareDate());
            }
            checkFlag = true;
            return true;
        }
        
        function compareDate(){
	        var endTime = document.getElementById('param._dnm_distime').value;
	        var beginTime = document.getElementById('param._dnl_distime').value;

	        if(endTime != '' && beginTime != '' &&  beginTime>endTime){
	        var alertstr = '<span class=\'errorkey\'><span style=\'color:#F00; font-size:12px;\'>[<s:text name="_dnl_distime"/> ]</span> 不能大于 <span style=\'color:#F00; font-size:12px;\'>[<s:text name="_dnm_distime"/>]</span>';
			errorMessageShow(alertstr);
	        return false;
	       }
        	return true;	
        }
        
        function doDetail(actionUrl){
        	checkFlag = false;
        	var count = chooseCount('param._selectitem');
        	if(count != 1){
	        	var alertstr = '<span class=\'errorkey\'><span style=\'color:#F00; font-size:12px;\'>[必需/只能 选择其中一个选项 ]';
				errorMessageShow(alertstr);
				return false;
        	}
        	var selectValue = chooseValue('param._selectitem');
        	window.location.href=contextPath + actionUrl+'?actionUrl=/resource/resdisform_list.do'+selectValue;
        }
        
        
        function doDeploy(actionUrl){
        var count = chooseCount('param._selectitem');
        	if(count < 1){
	        	var alertstr = '<span class=\'errorkey\'><span style=\'color:#F00; font-size:12px;\'>[请选择 一个或多个选项 ]';
				errorMessageShow(alertstr);
				return false;
        	}
        	
        	var objArray= document.getElementsByName('param._selectitem');
	        for(var i = 0;i<objArray.length;i++){
		        var e = objArray[i];
	                if (e.type == 'checkbox') {
	                    if (e.checked){
		                    var valueArray = e.value.split('|');
		                    	if('SIGNED' != valueArray[2]){//判断是否为已签收状态
		                    		var alertstr = '<span class=\'errorkey\'><span style=\'color:#F00; font-size:12px;\'>[分配单状态不正确，必须为已签收状态才可进行发布操作 ]';
									errorMessageShow(alertstr);
									return false;
		                    	}
	                    }     
	                }
	        }
        	
        	var selectValue = chooseValue('param._selectitem');
        	formList.action=contextPath + actionUrl;
        	formList.submit();
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
        
        //返回选中项的值并且多个之间形式为 &属性名=值1&属性名=值2
        function chooseValue(anObjectName){
        var result = "";
        var objArray= document.getElementsByName(anObjectName);
	        for(var i = 0;i<objArray.length;i++){
		        var e = objArray[i];
	                if (e.type == 'checkbox') {
	                    if (e.checked)
	                        result += '&'+anObjectName+'='+objArray[i].value;
	                }
	        }
	        return result;
        }
    </script>
</head>

<body class="list_body" onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<s:form action="resdisform_list.do" key="formList" cssStyle="formList" theme="simple" onsubmit="return ev_check();">
	<%//下面的控件给Action提供数据，用来分页%>
    <aa:zone name="hiddenZone"><s:hidden name="param._orderby"/>
    <s:hidden name="param._desc"/>
    <s:hidden name="param._pageno"/>
    <s:hidden name="param._pagesize"/>
    <s:hidden name="param.queryAll"/>
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
                <td align="center"><s:text name="disid"/>:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._se_disid" />
                </td>
                <td align="center"><s:text name="_dnl_distime"/>:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._dnl_distime" onclick="selectDatetime();" readonly="true"/>
                </td>
                <td align="center"><s:text name="_dnm_distime"/>:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._dnm_distime" onclick="selectDatetime();" readonly="true"/>
                </td>
                
              </tr>
              <tr>  
                <td align="center"><s:text name="discomcode"/>:</td>
                <td align="left">
                    <j:selector name="param._se_discomcode" definition="#WAYIDINFO"  condition="waytype:AG;waysubtype:LOGS;cityid:${USER.cityid}"/>
                </td>
                <td align="center"><s:text name="storarea"/>:</td>
                <td align="left">
                    <j:selector name="param._se_storarea" definition="$IM_FXSTORAREA"/>
                </td>
                <td align="center"><s:text name="disformstate"/>:</td>
                <td align="left">
                 <j:selector name="param._se_disformstate" definition="$FX_DISFSTATE"/>
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
                        value="<s:text name="button_search"/>" onClick="doQuery('/resource/resdisform_list.do');">
                	
                    <input type="button" id="btnBatch" name="btnBatch" class="button_4" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="批量分配" onClick="window.open('resdisform/import.jsp')">
                    
                    <input type="button" id="btnDeplay" name="btnDeplay" class="button_4" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="资源发布" onClick="doDeploy('/resource/resdisform_goDeploy.do')">
                        
                    <input type="button" id="btnDetail" name="btnDetail" class="button_4" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="查看明细" onClick="doDetail('/resource/resdisform_productDetail.do')">
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
                    <j:orderByImg href="javascript:doOrderby('disid')"><s:text name="disid"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('discomcode')"><s:text name="discomcode"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('resamt')"><s:text name="resamt"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('storarea')"><s:text name="storarea"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('discode')"><s:text name="discode"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('distime')"><s:text name="distime"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('signcode')"><s:text name="signcode"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('signtime')"><s:text name="signtime"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('issuecode')"><s:text name="issuecode"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('issutime')"><s:text name="issutime"/></j:orderByImg>                 
                </td>
                <!-- 
                <td>
                    <j:orderByImg href="javascript:doOrderby('issendsms')"><s:text name="issendsms"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('smscontent')"><s:text name="smscontent"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('issmsover')"><s:text name="issmsover"/></j:orderByImg>                 
                </td>
                 -->
                <td>
                    <j:orderByImg href="javascript:doOrderby('disformstate')"><s:text name="disformstate"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('statinfo')"><s:text name="statinfo"/></j:orderByImg>                 
                </td>
            </tr>
            <s:iterator value="dp.datas">
                 <tr class="table_style_content" align="center" onMouseMove="this.bgColor='F0F5F9'" onMouseOut="this.bgColor='#ffffff'">
					 <%-- 复合主键用“|”间隔开 --%>
                     <td>
                         <input type="checkbox" name="param._selectitem" value="<s:property value="discomcode + '|' + disid + '|' + disformstate + '|' + issutime"/>" onclick="checkOne();">
                     </td>
                     <td><s:property value="disid"/></td>
                     <td><j:code2Name code="discomcode" definition="#WAYIDINFO"/></td>
                     <td><s:property value="resamt" /></td>
                     <td><j:code2Name code="storarea" definition="$IM_FXSTORAREA"/></td>
                     <td><s:property value="discode" /></td>
                     <td><s:date format="yyyy-MM-dd HH:mm:ss" name="distime"/></td>
                     <td><s:property value="signcode" /></td>
                     <td><s:date format="yyyy-MM-dd HH:mm:ss" name="signtime"/></td>
                     <td><s:property value="issuecode" /></td>
                     <td><s:date format="yyyy-MM-dd HH:mm:ss" name="issutime"/></td>
                     <!-- 
                     <td><s:property value="issendsms" /></td>
                     <td><s:property value="smscontent" /></td>
                     <td><s:property value="issmsover" /></td>
                      -->
                     <td><j:code2Name code="disformstate" definition="$FX_DISFSTATE"/></td>
                     <td><s:property value="statinfo" /></td>
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
