<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc" %>
<%
	String ID_1 = "FX_ORDERMG_SENDBOSS";
%>
<html>
<head>
    <title><s:text name="titleList"/></title>
    <script type="text/javascript" src="<%=contextPath%>/js/bus/pwaycommon.js"></script>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            addfield('param._se_orderid', '<s:text name="orderid"/>', 'c', true, '18');
            addfield('param._se_wayid', '<s:text name="wayid"/>', 'c', true, '18');
            addfield('param._se_orderave', '<s:text name="orderave"/>', 'c', true, '16');
            addfield('param._dnm_createtime', '<s:text name="_dnm_createtime"/>', 'dt', true, '7');
            addfield('param._dnl_createtime', '<s:text name="_dnl_createtime"/>', 'dt', true, '7');
 
            return (checkval(window) && compareDate());
        }
        
        function compareDate(){
	        var startTime = document.getElementById('param._dnl_createtime').value;
	        var endTime = document.getElementById('param._dnm_createtime').value;

	        if(startTime != '' && endTime != '' &&  startTime>endTime){
	        var alertstr = '<span class=\'errorkey\'><span style=\'color:#F00; font-size:12px;\'>[<s:text name="_dnl_createtime"/> ]</span> 不能大于 <span style=\'color:#F00; font-size:12px;\'>[<s:text name="_dnm_createtime"/>]</span>';
			errorMessageShow(alertstr);
	        return false;
	       }
        	return true;	
        }
 
 		function doSupplyRecoreded(actionUrl){

 			var TO = true;
		    var sis = formList.all("param._selectitem");   
		    if (forincheck(TO,sis,'确定补送BOSS？')){    
		    	formList.action = contextPath + actionUrl;
		    	$("#btnExportexcel").attr("disabled",true);
		    	//formList.submit();
    		}  
 		}
 		
 		function openPicker(control,definition,condition) {
        	if(control.name.indexOf('param._se_mareacode') > -1 ) {
                if(document.all('param._se_countyid').value == "") {
                	// 选择“微区域编码”前要先指定 “分公司”  这是一个跨级的查询
                    alert("请先输入分公司");
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
        
        
        msgDelete = "删除后将不能执行补送BOSS入账操作，确认要删除么?";
		function doDelete(){
			var TO = true;
    		var sis = formList.all("param._selectitem");
    		if (forincheck(TO,sis,msgDelete)){
    			formList.action="<%=contextPath%>/sales/order_deletebosssupply.do";
    			formList.submit();
    		}   
		}
		
        function forincheck(TO,sis,msg){
   			if (sis != null) {
        		if (sis.length != null) {
            		for (var i = 0; i < sis.length; i++) {
                		var e = sis[i];
                		if (e.type == 'checkbox') {
                    		if (e.checked)
                        		TO = false;
                		}
            		}
        		} else {
            		var e = sis;
            		if (e.type == 'checkbox') {
                		if (e.checked)
                    		TO = false;
           			}
        		}
    		}

    		if (TO) {
        		alert(msgNoSelected);
        		return false;
    		}

   	 		if (!confirm(msg)) {
        		return false;
    		}
    		return true;
		}
		
		function doExportboss(){
        	formList.action = "<%=contextPath%>/sales/order_exportboss.do";
        	formList.submit();
        	formList.action = "<%=contextPath%>/sales/order_bossSupplyList.do";
        }
    </script>
</head>

<body class="list_body" onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<s:form action="order_bossSupplyList.do" key="formList" cssStyle="formList" theme="simple" onsubmit="return ev_check();">
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
			<span class="table_toparea"><s:text name="sales"/> </span>
			
			</s:i18n>
			<span class="table_toparea_xi">></span>
			<span class="table_toparea"><s:text name="titleList"/> </span>
			<span class="table_toparea_xi">></span>
			<span class="table_toparea_h"><s:text name="bossSupplyList"/></span>
			<span class="button_Help" onclick="openword('<s:text name="helpTitle"/>','<s:text name="boss_supply_help"/>')"><s:i18n name="public"><s:text name="help"/></s:i18n></span>
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
                <td align="center"><s:text name="orderid"/>:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._se_orderid" />
                </td>
                <td align="center"><s:text name="wayid"/>:</td>
                <td align="left">
                	  <s:textfield cssStyle="style_input" name="param._se_wayid" /><input type="button" value="..." class="picker_button" onclick="pshowSelectWay3(this,'param._se_wayid',null,null,'AG');this.value='...';" />
                </td>
                <td align="center"><s:text name="orderave"/>:</td>
                <td align="left">
                    <j:selector definition="$FX_ORDERAVE" name="param._se_orderave"/>
                </td>
              </tr>
              <tr>  
              	<td align="center"><s:text name="paytype"/>:</td>
                <td align="left">
                    <j:selector definition="$FX_PAYTYPE" name="param._se_paytype"/>
                </td>
                <td align="center"><s:text name="_dnl_createtime"/>:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._dnl_createtime" onclick="selectDatetime();"/>
                </td>
                <td align="center"><s:text name="_dnm_createtime"/>:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._dnm_createtime" onclick="selectDatetime();"/>
                </td>
            </tr>
            <tr>  
              	 <td align="center"><s:text name="countyid"/></td>
                <td align="left">
                
                 <j:purChk permid="FX_ORDERMG_CITY"> 
                   <j:selector definition="#CNTYCOMPANY"  condition="citycompid:${USER.cityid}" name="param._se_countyid" mode="selector"/>
                   </j:purChk>
                </td>
                <td align="center">微区域:</td>
                <td align="left">
                    <j:selector definition="#MICROAREA" name="param._se_mareacode" readonly="true"/>
                </td>
                <td align="center">&nbsp;</td>
                <td align="left">
                    &nbsp;
                </td>
            </tr>
            
        </table>
    </div>
    
    

	<aa:zone name="listZone">
	
	<div class="table_div">
    
		<table class="table_button_list">
			<tr>
				<td>
                	<s:i18n name="public">
                	<input type="button" id="btnQuery" name="btnQuery" class="button_Query" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="<s:text name="button_search"/>" onClick="doQuery('/sales/order_bossSupplyList.do');">
                    <input type="button" id="btnExportboss" name="btnExportboss" class="button_4" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="<s:text name="button_exportexcel"/>" onClick="doExportboss()">
                	</s:i18n>
                	<j:purChk permid="<%=ID_1%>" disableChild="true">
                	<input type="button" id="btnExportexcel" name="btnExportexcel" class="button_2" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="<s:text name="supply"/>" onClick="doSupplyRecoreded('/sales/order_supplyRecorded.do')">
                    <input type="button" id="btnDelete" name="btnDelete" class="button_delete" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="删除" onClick="doDelete()">
                    </j:purChk>
				</td>
			</tr>
		</table>
	</div>
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
                    <j:orderByImg href="javascript:doOrderby('orderid')"><s:text name="orderid"/></j:orderByImg>                 
                </td>
 				<td>
                    <j:orderByImg href="javascript:doOrderby('wayid')"><s:text name="wayid"/></j:orderByImg>               
                </td>
                <td>
                    	合作商名称               
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('countyid')"><s:text name="countyid"/></j:orderByImg>               
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('mareacode')"><s:text name="mareacode"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('orderave')"><s:text name="orderave"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('createtime')"><s:text name="createtime"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('orderstate')"><s:text name="orderstate"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('paytype')"><s:text name="paytype"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('memo')"><s:text name="memo"/></j:orderByImg>                 
                </td>

            </tr>
            <s:iterator value="dp.datas">
                 <tr class="table_style_content" align="center" onMouseMove="this.bgColor='F0F5F9'" onMouseOut="this.bgColor='#ffffff'">
					 <%-- 复合主键用“|”间隔开 --%>
                     <td>
                         <input type="checkbox" name="param._selectitem" value="<s:property value="orderid"/>" onclick="checkOne();">
                     </td>
                     <td><s:property value="orderid"/></td>
                     <td><s:property value="wayid"/></td>
                     <td><j:code2Name definition="#WAYIDINFO" code="wayid"/></td>
                     <td><j:code2Name definition="#CNTYCOMPANY" code="countyid"/></td>
                     <td><j:code2Name definition="#MICROAREA" code="mareacode"/></td>
                     <td><j:code2Name definition="$FX_ORDERAVE" code="orderave"/></td>
                     <td><s:date name="createtime" format="yyyy-MM-dd HH:mm:ss"/></td>
                     <td><j:code2Name definition="$FX_ORDERFSTATE" code="orderstate"/></td>
                     <td><j:code2Name definition="$FX_PAYTYPE" code="paytype"/></td>
                     <td><s:property value="memo" /></td>
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
	ajaxAnywhere.substituteSubmitButtonsBehaviorByIDs(true,"btnQuery,btnExportexcel,btnDelete");
</script> 
</body>
</html>
