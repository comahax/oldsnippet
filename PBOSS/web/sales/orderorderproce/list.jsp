<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc" %>
<html>
<head>
    <title><s:text name="titleList"/></title>
    <script language="JavaScript" type="text/JavaScript">
	function ev_check() {
		addfield('param._dnm_createtime', '创建时间<=', 'dt', false, '19');
		addfield('param._dnl_createtime', '创建时间>=', 'dt', false, '19');
		addfield('param._se_paytype', '<s:text name="paytype"/>', 'c', true, '16');
		addfield('param._se_countyid', '<s:text name="countyid"/>', 'c', true, '14');
		return (checkval(window) && compareDate());
		<%--return (checkval(window));--%>
	}
	function compareDate(){
        var startTime = document.getElementById('param._dnl_createtime').value;
        var endTime = document.getElementById('param._dnm_createtime').value;
        if(startTime != '' && endTime != '' &&  startTime>endTime){
        var alertstr = '<span class=\'errorkey\'><span style=\'color:#F00; font-size:12px;\'>[创建时间>=]</span> 不能大于 <span style=\'color:#F00; font-size:12px;\'>[创建时间<=]</span>';
		errorMessageShow(alertstr);
        return false;
       }
    	return true;	
    }
	
	function doExcel(cmd)
        {
		    var url = contextPath + cmd;
		    formList.action = url;  
		    formList.submit();
		    formList.action=contextPath+"/sales/orderorderproce_list.do";
        }
</script>
</head>

<body class="list_body" onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<s:form action="orderorderproce_list.do" key="formList" cssStyle="formList" theme="simple" onsubmit="return ev_check();">
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
			<span class="table_toparea">分销管理 </span>
			<span class="table_toparea_xi">></span>
			<span class="table_toparea">订单管理 </span>
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
                    <j:selector definition="#CNTYCOMPANY" name="param._se_countyid" mode="selector" 
                    condition="citycompid:${dBAccessUser.cityid }"   />
                </td>
                <td align="center"><s:text name="paytype"/>:</td>
                <td align="left">
                    <j:selector definition="$FX_PAYTYPE" name="param._se_paytype"/>
                </td>
            </tr>
            <tr>
                <td align="center"><s:text name="createtimel"/>:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._dnl_createtime" 
                    onclick="selectDatetime()"  /><font color="red">*</font>
                </td>
                <td align="center"><s:text name="createtimem"/>:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._dnm_createtime" 
                    onclick="selectDatetime()"  /><font color="red">*</font>
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
                        value="统计" onClick="doQuery('/sales/orderorderproce_list.do');">
                	
                    <input type="button" id="btnExcel" name="btnExcel" class="button_4" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="导出明细" onClick="doExcel('/sales/orderorderproce_excel.do')">
                	
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
                <td>
                    序号
                </td>
                </s:i18n>
                
                <td>
                    <j:orderByImg href="javascript:doOrderby('countyid')"><s:text name="countyid"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('paytype')"><s:text name="paytype"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('countrecamt')"><s:text name="countrecamt"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('sumrecamtFormat')"><s:text name="sumrecamt"/></j:orderByImg>                 
                </td>
                
            </tr>
            <s:iterator value="dp.datas"  status="state">
                 <tr class="table_style_content" align="center" onMouseMove="this.bgColor='F0F5F9'" onMouseOut="this.bgColor='#ffffff'">
					 <%-- 复合主键用“|”间隔开 --%>
                     <td><s:property value="#state.count"/></td>
                     <td>
                     <!-- <s:property value="countyid"/>  -->
                     <j:code2Name definition="#CNTYCOMPANY" code="countyid"/>
                     </td>
                     <td>
                     <!-- <s:property value="paytype" /> -->
                     <j:code2Name definition="$FX_PAYTYPE" code="paytype"/>
                     </td>
                     <td><s:property value="countrecamt" /></td>
                     <td><s:property value="sumrecamtFormat" /></td>
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
