<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc" %>
<html>
<head>
    <title><s:text name="titleList"/></title>
    <script type="text/javascript" src="<%=contextPath%>/js/bus/pwaycommon.js"></script>
    <script language="JavaScript" type="text/JavaScript">
	function ev_check() {
		addfield('param._se_wayid', '<s:text name="wayid"/>', 'c', true, '18');
		addfield('param._se_mobile', '<s:text name="mobile"/>', 'c', true, '15');
		addfield('param._dnm_activetime', '<s:text name="activetime"/>', 'dt', true, '7');
		addfield('param._dnl_activetime', '<s:text name="activetime"/>', 'dt', true, '7');
		addfield('param._dnm_rechargetime', '<s:text name="rechargetime"/>', 'dt', true, '7');
		addfield('param._dnl_rechargetime', '<s:text name="rechargetime"/>', 'dt', true, '7');
		return checkval(window);
	}
	
	function doBatch(){
        	formList.action="<%=contextPath%>/rewards/batch.jsp";
        	formList.submit();
   }
	
</script>
</head>

<body class="list_body" onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<s:form action="cardrewdet_list.do" key="formList" cssStyle="formList" theme="simple" onsubmit="return ev_check();">
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
			<span class="table_toparea">酬金管理 </span>
			<span class="table_toparea_xi">></span>
			<span class="table_toparea">本地酬金管理 </span>
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
                    <s:textfield cssStyle="style_input" name="param._se_wayid" />
                    <input type="button" value="..." class="picker_button" 
                    onclick="pshowSelectWay3(this,'param._se_wayid');this.value='...';" />
                </td>
                <td align="center"><s:text name="mobile"/>:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._se_mobile" />
                </td>
             </tr>
             <tr>
                <td align="center">激活开始时间:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._dnl_activetime" 
                    onclick="selectDatetime()"/>
                </td>
                <td align="center">激活结束时间:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._dnm_activetime" 
                    onclick="selectDatetime()"/>
                </td>
             </tr>
             <tr>
                <td align="center">充值开始时间:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._dnl_rechargetime" 
                    onclick="selectDatetime()"/>
                </td>
                <td align="center">充值结束时间:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._dnm_rechargetime" 
                    onclick="selectDatetime()"/>
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
                        value="<s:text name="button_search"/>" onClick="doQuery('/cardrewdet/cardrewdet_list.do');">
                	
                    <input type="button" id="btnDelete" name="btnDelete" class="button_Delete" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="<s:text name="button_delete"/>" onClick="doDelete('/cardrewdet/cardrewdet_delete.do')">
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
                    <j:orderByImg href="javascript:doOrderby('wayid')"><s:text name="wayid"/></j:orderByImg>                 
                </td>
                 <td>
                    渠道名称                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('mobile')"><s:text name="mobile"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('activetime')"><s:text name="activetime"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('rechargenum')"><s:text name="rechargenum"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('rechargetime')"><s:text name="rechargetime"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('rewardnum')"><s:text name="rewardnum"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('cmonth')"><s:text name="cmonth"/></j:orderByImg>                 
                </td>
            </tr>
            <s:iterator value="dp.datas">
                 <tr class="table_style_content" align="center" onMouseMove="this.bgColor='F0F5F9'" onMouseOut="this.bgColor='#ffffff'">
					 <%-- 复合主键用“|”间隔开 --%>
                     <td>
                         <input type="checkbox" name="param._selectitem" value="<s:property value="seqid"/>" onclick="checkOne();">
                     </td>
                     
                     <td><s:property value="wayid" /></td>
                     <td><j:code2Name definition="#WAYIDINFO" code="wayid" /></td>
                     <td><s:property value="mobile" /></td>
                     <td>
                     <!-- <s:property value="activetime" />  -->
                     <s:date name="activetime" format="yyyy-MM-dd HH:mm:ss"/>
                     </td>
                     <td>
                     <s:property value="rechargenum" /> 
                     <!-- 
                     <fmt:formatNumber value="<s:property value="rechargenum" />" pattern="###,###.##"></fmt:formatNumber>
                      -->
                     </td>
                     <td>
                     <!-- <s:property value="rechargetime" />   -->
                     <s:date name="rechargetime" format="yyyy-MM-dd HH:mm:ss"/>
                     </td>
                     <td><s:property value="rewardnum" /></td>
                     <td><s:property value="cmonth" /></td>
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
