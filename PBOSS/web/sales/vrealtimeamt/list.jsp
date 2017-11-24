<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc" %>
<html>
<head>
    <title><s:text name="titleList"/></title>
    <script type="text/javascript"
			src="<%=contextPath%>/js/bus/pwaycommon.js"></script>
    <script>
    	function openPicker(control,definition,condition) {
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
    	  function doExcel(url){
        	formList.action=contextPath+url;
        	formList.submit();
        	formList.action=contextPath+"/sales/vrealtimeamt_excel.do";
        }
    </script>
</head>

<body class="list_body" onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<s:form action="vrealtimeamt_list.do" key="formList" cssStyle="formList" theme="simple" onsubmit="return ev_check();">
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
				<td align="center"><s:text name="wayid"/>:</td>
                <td align="left">
                	<s:textfield cssStyle="style_input" name="param._se_wayid" /><input type="button" value="..." class="picker_button"
									onclick="pshowSelectWay3(this,'param._se_wayid','','','AG');this.value='...';" />
                </td>
                <td align="center"><s:text name="starlevel"/>:</td>
                <td align="left">
                    <j:selector definition="$CH_STARLEVEL" name="param._ne_starlevel" />
                </td>
               
                <td align="center"><s:text name="brand"/>:</td>
                <td align="left">
                   <%--  <p:smpBrand name="param._se_brand" mode="of" cssStyle="style_input" />--%>
                    <p:smpBrand name="param._se_brand" mode="def" cssStyle="style_input" />
                </td>
            </tr>
              <tr>
				<input type="hidden"  name="param._se_cityid" value="<s:property value='dBAccessUser.cityid'/>"/>
				<td align="center">
					<s:text name="countyid" />
					:
				</td>
				<td align="left">
					<!-- 可能改为树形式,但尚未有很BOSS移值过来
					<s:textfield cssStyle="style_input" name="param._se_countyid" /><input type="button" name="button2" class="picker_button"value="..."
					onclick="showOrgTree(this,'_se_countyid','Cntycom');">
				-->
					<j:selector definition="#CNTYCOMPANY" name="param._se_countyid" />
				</td>
				<td align="center">
					<s:text name="_se_svccode" />
					:
				</td>
				<td align="left">
					<!-- 可能改为树形式,但尚未有很BOSS移值过来
					<s:textfield cssStyle="style_input" name="param._se_svccode" /><input type="button" name="button1" class="picker_button"
						value="..." onclick="showOrgTree(this,'_se_svccode','Svc');">
				 -->
					<j:selector definition="#SERVCENT" name="param._se_svccode" />
				</td>
				<td align="center">
					<s:text name="_se_mareacode" />
					:
				</td>
				<td align="left">
					<!-- 可能改为树形式,但尚未有很BOSS移值过来
					<s:textfield cssStyle="style_input" name="param._se_mareacode" /><input type="button" name="button" class="picker_button"
						value="..." onclick="showOrgTree(this,'_se_mareacode','Ma');">
				-->
					<j:selector definition="#MICROAREA" name="param._se_mareacode" />
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
                        value="<s:text name="button_search"/>" onClick="doQuery('/sales/vrealtimeamt_list.do');">
                    <input type="button" id="btnExcel" name="btnExcel" class="button_4" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="<s:text name="button_exportexcel"/>" onClick="doExcel('/sales/vrealtimeamt_excel.do')">
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
                    <s:text name="total"/>
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
                    <j:orderByImg href="javascript:doOrderby('wayid')"><s:text name="wayid"/></j:orderByImg>                 
                </td>
                <td>
                    <s:text name="wayname"/>    
                </td>
                   <td>
                    <j:orderByImg href="javascript:doOrderby('starlevel')"><s:text name="starlevel"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('brand')"><s:text name="brand"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('comcategory')"><s:text name="comcategory"/></j:orderByImg>                 
                </td>
                <td>
                     <s:text name="monordered"/> 
                </td>
                <td>
                     <s:text name="dayordered"/>              
                </td>
                <td>
                    <s:text name="nowstock"/>          
                </td>
                <td>
                     <s:text name="orderdstock"/>                 
                </td>
            </tr>
            <s:iterator value="dp.datas" status="status">
                 <tr class="table_style_content" align="center" onMouseMove="this.bgColor='F0F5F9'" onMouseOut="this.bgColor='#ffffff'">
					 <%-- 复合主键用“|”间隔开 --%>
					 <td>
						<s:property value="#status.count" />
					 </td>
                     <td>
						<j:code2Name code="countyid" definition="#CNTYCOMPANY" />
					 </td>
					 <td>
						<j:code2Name code="svccode" definition="#SERVCENT" />
					 </td>
					 <td>
						<j:code2Name code="mareacode" definition="#MICROAREA" />
					 </td>
                     <td>
						<s:property value="wayid"/>
					 </td>
					 <td>
						<j:code2Name code="wayid" definition="#WAY" />
					 </td>
					 <td>
                     	<j:code2Name code="starlevel" definition="$CH_STARLEVEL" />
					</td>
                     <td>
						<j:code2Name code="brand" definition="$FX_SMPBRAND" />
					 </td>
					 <td>
						<j:code2Name code="comcategory" definition="$IM_FXCOMCATEGORY" />
					 </td>
                     <td>
                     	<s:i18n name="public">
                     	<s:property value="monordered!=null?getText('format.long',{monordered}):''"/>
                     	</s:i18n>
                     </td>
                     <td>
                     	<s:i18n name="public">
                     	<s:property value="dayordered!=null?getText('format.long',{dayordered}):''"/>
                     	</s:i18n>
                     </td>
                     <td>
                    	<s:i18n name="public">
                     		<s:property value="nowstock!=null?getText('format.long',{nowstock}):''"/>
                     	</s:i18n>
					</td>
                    <td>
                     	<s:i18n name="public">
                     		<s:property value="orderdstock!=null?getText('format.long',{orderdstock}):''"/>
                     	</s:i18n>
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
<script language="JavaScript" type="text/JavaScript">
	function ev_check() {
		addfield('param._se_countyid', '<s:text name="countyid"/>', 'c', true, '14');
		addfield('param._se_svccode', '<s:text name="svccode"/>', 'c', true, '14');
		addfield('param._se_mareacode', '<s:text name="mareacode"/>', 'c', true, '14');
		addfield('param._ne_starlevel', '<s:text name="starlevel"/>', 'f', true, '2');
		addfield('param._se_wayid', '<s:text name="wayid"/>', 'c', true, '18');
		addfield('param._se_brand', '<s:text name="brand"/>', 'c', true, '16');
		return checkval(window);
	}
</script>
