<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc" %>
<html>
<head>
    <title><s:text name="titleList"/></title>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            addfield('param._ne_detid', '<s:text name="detid"/>', 'f', true, '14');
            addfield('param._se_orderid', '<s:text name="orderid"/>', 'c', true, '18');
            addfield('param._se_ordercomtype', '<s:text name="ordercomtype"/>', 'c', true, '16');
            addfield('param._se_comcategory', '<s:text name="comcategory"/>', 'c', true, '20');
            addfield('param._se_restype', '<s:text name="restype"/>', 'c', true, '32');
            addfield('param._ne_comid', '<s:text name="comid"/>', 'f', true, '18');
            addfield('param._se_boxnum', '<s:text name="boxnum"/>', 'c', true, '100');
            addfield('param._se_comresid', '<s:text name="comresid"/>', 'c', true, '20');
            addfield('param._se_brand', '<s:text name="brand"/>', 'c', true, '16');
            return checkval(window);
        }

    </script>
</head>

<body class="list_body" onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<s:form action="orderresdet_list.do" key="formList" cssStyle="formList" theme="simple" >
	<%//下面的控件给Action提供数据，用来分页%>
    <aa:zone name="hiddenZone"><s:hidden name="param._orderby"/>
    <s:hidden name="param._desc"/>
    <s:hidden name="param._pageno"/>
    <s:hidden name="param._pagesize"/>
    <s:hidden name="param.queryAll"/>
    <input type="hidden" name="_rowcount" value="<s:property value="dp.rowCount" />"/></aa:zone>
    <s:hidden name="param._se_ordercomtype"/>
    <s:hidden name="param._se_orderid"/>
    
	<div class="table_top">
		<div class="table_topleft"></div>
		<div class="table_toparea_w">
			<s:i18n name="public">
			<span class="table_toparea"><s:text name="currentPos"/> </span>
			<span class="table_toparea_xi">></span>
			<span class="table_toparea"><s:text name="sales"/> </span>
			<span class="table_toparea_xi">></span>
			</s:i18n>
			<span class="table_toparea_h"  >
			<script type="text/javascript">
				var type = '<s:text name="param._se_ordercomtype"/>';
				var title;
				if('CUSTORDER' == type)
					title = "资源明细信息";
				else if('SYSTIEIN' == type)
					title = "搭售资源明细信息";
				else if('SYSGIFT' == type)	
					title = "赠送资源明细信息";
				document.write(title);
			</script>
			</span>
		</div>
	</div>
    <div class="table_div">
		<table class="table_button_list">
			<tr>
				<td>
                	<s:i18n name="public">
                	<input type="button" id="btnQuery" name="btnQuery" class="button_4" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="导出EXCEL" onClick="doQuery('/sales/orderresdet_exportExcel.do');">
                        
                    <input type="button" id="btnBack" name="btnBack" class="button_back" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="<s:text name="button_return"/>" onClick="doReturnInFrame('/sales/order_list.do?backFlag=true');">
                   </s:i18n>
				</td>
			</tr>
		</table>
	</div>
    <aa:zone name="errorZone">
		<div class="error_text" >
			<table class="error_text">
				<s:actionerror /><s:actionmessage/>
			</table>
		</div>
    </aa:zone>

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
                    <j:orderByImg href="javascript:doOrderby('detid')"><s:text name="detid"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('comid')"><s:text name="comname"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('comcategory')"><s:text name="comcategory"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('comid')"><s:text name="comid"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('batchno')"><s:text name="batchno"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('boxnum')"><s:text name="boxnum"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('comresid')"><s:text name="comresid"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('emptyno')"><s:text name="emptyno"/></j:orderByImg>                 
                </td>
            </tr>
            <s:iterator value="dp.datas" status="state">
                 <tr class="table_style_content" align="center" onMouseMove="this.bgColor='F0F5F9'" onMouseOut="this.bgColor='#ffffff'">
					 <%-- 复合主键用“|”间隔开 --%>
                     <td><s:text name="#state.count"/></td>
                     <td><s:property value="detid"/></td>
                     
                     <td>
                     <!-- 
                     <j:code2Name definition="$FX_ORDERCOMTYPE" code="ordercomtype"/>
                     -->
                      <j:code2Name definition="#COM" code="comid"/>
                     </td>
                      
                     <td><j:code2Name definition="$IM_FXCOMCATEGORY" code="comcategory"/></td>
                     <td><s:property value="comid" /></td>
                     <td><s:property value="batchno" /></td>
                     <td><s:property value="boxnum" /></td>
                     <td><s:property value="comresid" /></td>
                     <td><s:property value="emptyno" /></td>
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
	ajaxAnywhere.substituteSubmitButtonsBehaviorByIDs(true,"btnDelete");
	
</script> 
</body>
</html>
