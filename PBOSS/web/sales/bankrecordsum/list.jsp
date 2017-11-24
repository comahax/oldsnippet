<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc" %>
<html>
<head>
    <title><s:text name="titleList"/></title>
</head>

<body class="list_body" onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<s:form action="bankrecordsum_list.do" key="formList" cssStyle="formList" theme="simple" onsubmit="return ev_check();">
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
			<span class="table_toparea">银行划扣</span>
			<span class="table_toparea_xi">></span>
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
                
                <td align="center"><s:text name="recordate"/>>=:</td>
                <td align="left">
                	<input type="text" cssStyle="style_input" name="param._dnl_recordate" onclick="selectDate();" 
                	value="<s:date name="param._dnl_recordate" format="yyyy-MM-dd"/>"/>
                </td>
                
                <td align="center"><s:text name="recordate"/><=:</td>
                <td align="left">
                	<input type="text" cssStyle="style_input" name="param._dnm_recordate" onclick="selectDate();" 
                	value="<s:date name="param._dnm_recordate" format="yyyy-MM-dd"/>"/>
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
                        value="<s:text name="button_search"/>" onClick="doQuery('/sales/bankrecordsum_list.do');">
                	
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
                    <j:orderByImg href="javascript:doOrderby('seqid')"><s:text name="seqid"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('successcount')"><s:text name="successcount"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('failurecount')"><s:text name="failurecount"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('amterrcount')"><s:text name="amterrcount"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('localamt')"><s:text name="localamt"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('bankamt')"><s:text name="bankamt"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('recordate')"><s:text name="recordate"/></j:orderByImg>                 
                </td>
            </tr>
            <s:iterator value="dp.datas">
                 <tr class="table_style_content" align="center" onMouseMove="this.bgColor='F0F5F9'" onMouseOut="this.bgColor='#ffffff'">
					 <%-- 复合主键用“|”间隔开 --%>
                     <td><s:property value="seqid" /></td>
                     <td><s:property value="successcount" /></td>
                     <td><s:property value="failurecount" /></td>
                     <td><s:property value="amterrcount" /></td>
                     <td><s:property value="localamt" /></td>
                     <td><s:property value="bankamt" /></td>
                     <td><s:date name="recordate" format="yyyy-MM-dd"/></td>
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
<script language="JavaScript" type="text/JavaScript">
	function ev_check() {
		addfield('param._dl_recordate', '<s:text name="recordate"/>', 't', true, '7');
		addfield('param._dnm_recordate', '<s:text name="recordate"/>', 't', true, '7');
		addfield('param._de_recordate', '<s:text name="recordate"/>', 't', true, '7');
		addfield('param._dnl_recordate', '<s:text name="recordate"/>', 't', true, '7');
		addfield('param._dm_recordate', '<s:text name="recordate"/>', 't', true, '7');
		addfield('param._dl_creatdate', '<s:text name="creatdate"/>', 't', true, '7');
		addfield('param._dnm_creatdate', '<s:text name="creatdate"/>', 't', true, '7');
		addfield('param._de_creatdate', '<s:text name="creatdate"/>', 't', true, '7');
		addfield('param._dnl_creatdate', '<s:text name="creatdate"/>', 't', true, '7');
		addfield('param._dm_creatdate', '<s:text name="creatdate"/>', 't', true, '7');
		return checkval(window);
	}
</script>
