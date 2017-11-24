<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc" %>
<html>
<head>
    <title><s:text name="titleList4"/></title>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            addfield('param._se_cityid', '<s:text name="cityid"/>', 'c', true, '10');
            addfield('param._se_countyid', '<s:text name="countyid"/>', 'c', true, '14');
            addfield('param._se_cooptype', '<s:text name="cooptype"/>', 'c', true, '18');
            addfield('param._ne_starlevel', '<s:text name="starlevel"/>', 'f', true, '2');
            addfield('param._se_comcategory', '<s:text name="comcategory"/>', 'c', true, '20');
            return checkval(window);
        }
        
        $(document).ready(function(){
       		getCooptypeVal();
		}); 
			
		//回调处理,获取参数列表
        ajaxAnywhere.onAfterResponseProcessing = nativeCallBack;
        function nativeCallBack()
        {
        		getCooptypeVal();
        }
        
		//双主键jop标签特殊处理，将代码转为值
		function getCooptypeVal()
		{
			var str;
       		$(".cooptype").each(function(i){
       			str = mapSelect("cust",this.value);
       			$(this).after(str);
			});
		}
		//从选择框的值获取选择的显示内容
		function mapSelect(objid,val)
		{
			var str = "";
			$("#"+objid).children().each(function(i){
				if(this.value == val)
				{
					str = this.innerText;
				}
			});
			return str;
		}
		function doExcel(){
        	formList.action="<%=contextPath%>/sales/orderuplimit_excel.do";
        	formList.submit();
        	formList.action="<%=contextPath%>/sales/orderuplimit_listforemptysim.do";
        }

		function doBatch(){
        	formList.action="<%=contextPath%>/sales/orderuplimit_import.do";
        	formList.submit();
        }
        
		function doDeleCheck() {
			doDelete('/sales/orderuplimit_delete.do?forwhat=emptysim');
        	formList.action="<%=contextPath%>/sales/orderuplimit_listforemptysim.do";
        }
    </script>
</head>

<body class="list_body" onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<s:form action="orderuplimit_listforemptysim.do" key="formList" cssStyle="formList" theme="simple" onsubmit="return ev_check();">
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
			<span class="table_toparea_xi">></span>
			</s:i18n>
			<span class="table_toparea_h"><s:text name="titleList4"/></span>
<%--			<span class="button_Help" onclick="openword('<s:text name="helpTitle3"/>','<s:text name="helpContent3"/>')"><s:i18n name="public"><s:text name="help"/></s:i18n></span>--%>
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
                <td align="center"><s:text name="countyid"/>:</td>
                <td align="left">
                    <j:selector definition="#CNTYCOMPANY"  condition="citycompid:${USER.cityid}" name="param._se_countyid" mode="selector"/>
                </td>
            </tr>
            <tr>
                <td align="center"><s:text name="starlevel"/>:</td>
                <td align="left">
                    <j:selector name="param._ne_starlevel" definition="$CH_STARLEVEL" />
                </td>
                <td align="center"><s:text name="comcategory"/></td>
                <td align="left">
                    <j:selector name="param._se_comcategory" definition="$IM_FXCOMCATEGORY" mode="picker"/>
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
                        value="<s:text name="button_search"/>" onClick="doQuery('/sales/orderuplimit_listforemptysim.do');">
                	
                    <input type="button" id="btnNew" name="btnNew" class="button_New" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="<s:text name="button_new"/>" onClick="doNew('/sales/orderuplimit_newforemptysim.do')">
                    
                    <input type="button" id="doDele" name="doDele" class="button_Delete" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="<s:text name="button_delete"/>" onClick="doDeleCheck()">
                    <input type="button" id="btnExcel" name="btnExcel" class="button_4" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="<s:text name="button_exportexcel"/>" onClick="doExcel('/sales/orderuplimit_excel.do')">
                    <input type="button" id="btnBatch" name="btnBatch" class="button_4" onmouseover="buttonover(this);"
	                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
	                            value="批量导入" onClick="doBatch();">
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
                    <j:orderByImg href="javascript:doOrderby('starlevel')"><s:text name="starlevel"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('comcategory')"><s:text name="comcategory"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('maxstock')"><s:text name="maxstock"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('daylimit')"><s:text name="alarmvalue"/></j:orderByImg>                 
                </td>
            </tr>
            <s:iterator value="dp.datas">
                 <tr class="table_style_content" align="center" onMouseMove="this.bgColor='F0F5F9'" onMouseOut="this.bgColor='#ffffff'">
					 <%-- 复合主键用“|”间隔开 --%>
                     <td>
                         <input type="checkbox" name="param._selectitem" value="<s:property value="recid"/>" onclick="checkOne();">
                     </td>
                     <td><a href='<s:url action="orderuplimit_editforemptysim.do">
	                        <s:param name="param._pk" value="recid"/>
	                     	</s:url>'>
							<s:property value="recid"/>
                         </a>
					 </td>
                     <td><j:code2Name definition="#CITYCOMPANY" code="cityid" /></td>
                     <td><j:code2Name definition="#CNTYCOMPANY" code="countyid" /></td>
                     <td><j:code2Name definition="$CH_STARLEVEL" code="starlevel" /></td>
                     <td><j:code2Name definition="$IM_FXCOMCATEGORY" code="comcategory" /></td>
                     <td><s:property value="maxstock" /></td>
                     <td><s:property value="extendAlarmValue" /></td>
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
