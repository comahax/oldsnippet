<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc" %>
<html>
<head>
    <title><s:text name="titleList"/></title>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            addfield('param._se_disid', '<s:text name="disid"/>', 'c', true, '20');
            addfield('param._se_discomcode', '<s:text name="discomcode"/>', 'c', true, '18');
            addfield('param._se_storarea', '<s:text name="storarea"/>', 'c', true, '16');
            addfield('param._dnm_distime', '<s:text name="distime"/>', 't', true, '10');
            addfield('param._dnl_distime', '<s:text name="distime"/>', 't', true, '10');
            addfield('param._se_disformstate', '<s:text name="disformstate"/>', 'c', true, '16');
           return (checkval(window) && compareDate());
        }
        function compareDate(){
        	var dnmdistime = document.getElementById('param._dnm_distime').value;
        	var dnldistime = document.getElementById('param._dnl_distime').value;
        	
        	if(dnmdistime != '' && dnldistime != '' && dnldistime>dnmdistime){
	        	var alertstr = '<span class=\'errorkey\'><span style=\'color:#F00; font-size:12px;\'>[<s:text name="_dnl_distime"/> ]</span> 不能大于 <span style=\'color:#F00; font-size:12px;\'>[<s:text name="_dnm_distime"/>]</span>';
				errorMessageShow(alertstr);
				return false;
        	}
        	return true;
        }
    </script>
</head>

<body class="list_body" onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<s:form action="resdisform_signlist.do" key="formList" cssStyle="formList" theme="simple" onsubmit="return ev_check();">
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
			<span class="table_toparea"><s:text name="resource"/> </span>
			<span class="table_toparea_xi">></span>
			</s:i18n>
			<span class="table_toparea">配送商资源管理 </span>
			<span class="table_toparea_xi">></span>
			<span class="table_toparea_h">套卡资源签收</span>
			<span class="button_Help" onclick="openword('<s:text name="helpTitle_sign"/>','<s:text name="helpContent_sign"/>')"><s:i18n name="public"><s:text name="help"/></s:i18n></span>
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
                <td align="center"><s:text name="distime"/>>=:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._dnl_distime" onclick="selectDate();"/>
                </td>
                <td align="center"><s:text name="distime"/><=:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._dnm_distime" onclick="selectDate();"/>
                </td>
             </tr>
             <tr>   
                <td align="center"><s:text name="discomcode"/>:</td>
                <td align="left">
                    <j:selector name="param._se_discomcode" definition="#WAYIDINFO"  condition="waytype:AG;waysubtype:LOGS;cityid:${USER.cityid}"/>
                </td>
                <td align="center"><s:text name="storarea"/>:</td>
                <td align="left">
                    <j:selector definition="$IM_FXSTORAREA" name="param._se_storarea"  cssStyle="style_input"/>
                </td>
                
                <td align="center"><s:text name="disformstate"/>:</td>
                <td align="left">
                    <j:selector definition="$FX_DISFSTATE" name="param._se_disformstate"  cssStyle="style_input"/>
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
                        value="<s:text name="button_search"/>" onClick="doQuery('/resource/resdisform_signlist.do');">
                	
                    <input type="button" id="btnSign" name="btnSign" class="button_Query" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="<s:text name="button_sign"/>" onClick="doSign('/resource/resdisform_sign.do')">
                    
                    <input type="button" id="btnLookinfo" name="btnLookinfo" class="button_4" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="<s:text name="button_lookinfo"/>" onClick="doDetail('/resource/resdisform_productDetail.do')">
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
                    <a href="javascript:doOrderby('disid')"><s:text name="disid"/></a>                 
                </td>
                <td>
                    <a href="javascript:doOrderby('discomcode')"><s:text name="discomcode"/></a>                 
                </td>
                 <td>
                    <a href="javascript:doOrderby('storarea')"><s:text name="storarea"/></a>                 
                </td>
                <td>
                    <a href="javascript:doOrderby('resamt')"><s:text name="resamt"/></a>                 
                </td>
               
                <td>
                    <a href="javascript:doOrderby('discode')"><s:text name="discode"/></a>                 
                </td>
                <td>
                    <a href="javascript:doOrderby('distime')"><s:text name="distime"/></a>                 
                </td>
                <td>
                    <a href="javascript:doOrderby('signcode')"><s:text name="signcode"/></a>                 
                </td>
                <td>
                    <a href="javascript:doOrderby('signtime')"><s:text name="signtime"/></a>                 
                </td>
               
                
                <td>
                    <a href="javascript:doOrderby('disformstate')"><s:text name="disformstate"/></a>                 
                </td>
                <td>
                    <a href="javascript:doOrderby('statinfo')"><s:text name="statinfo"/></a>                 
                </td>
            </tr>
            <s:iterator value="dp.datas">
                 <tr class="table_style_content" align="center" onMouseMove="this.bgColor='F0F5F9'" onMouseOut="this.bgColor='#ffffff'">
					 <%-- 复合主键用“|”间隔开 --%>
                     <td>
                         <input type="checkbox" name="param._selectitem" state="<s:property value="disformstate" />" value="<s:property value="discomcode + '|' + disid"/>" onclick="checkOne();">
                     </td>
                     <td>
							<s:property value="disid"/>
					 </td>
                     <td>
							<j:code2Name definition="#WAYIDINFO" code="discomcode"/>
					 </td>
					 <td><j:code2Name definition="$IM_FXSTORAREA" code="storarea"/></td>
                     <td><s:property value="resamt" /></td>
                     
                     <td><s:property value="discode" /></td>
                     <td><s:date name="distime" format="yyyy-MM-dd HH:mm:ss"/></td>
                     <td><s:property value="signcode" /></td>
                     <td><s:date name="signtime" format="yyyy-MM-dd HH:mm:ss"/></td>
                    
                     <td><j:code2Name definition="$FX_DISFSTATE" code="disformstate"/></td>
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
	
	function doSign(url){
		var checkedBoxs=$(":checkbox[name='param._selectitem']:checked");
		if(checkedBoxs.length==0){
			alert("请选择记录！");
			return;
		}
		var submitState=true;
		checkedBoxs.each(function(i) {
			if(jQuery(this).attr("state")!='WAITSIGN'){
				jQuery(this).attr("checked",false);
				if(submitState)
					submitState=false;
			}
		});
		if(!submitState){
			alert("分配单状态不正确，必须为待签收状态才可进行签收操作。");
			return;
		}
		formList.action = contextPath + url;
    	formList.submit();
		
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
        	window.location.href=contextPath + actionUrl+'?actionUrl=/resource/resdisform_signlist.do'+selectValue;
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
</body>
</html>
