<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc" %>
<html>
<head>
    <title><s:text name="titleList"/></title>
</head>

<body class="list_body" onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<s:form action="emodconfirm_list.do" key="formList" cssStyle="formList" theme="simple" onsubmit="return ev_check();">
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
			<span class="table_toparea"><s:text name="base"/> </span>
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
                <td align="center"><s:text name="confirmid"/>:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._ne_confirmid" />
                </td>
                <td align="center"><s:text name="empmodelid"/>:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._ne_empmodelid" />
                </td>
                <td align="center"><s:text name="employeeid"/>:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._se_employeeid" />
                </td>
                <td align="center"><s:text name="model"/>:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._se_model" />
                </td>
                <td align="center"><s:text name="state"/>:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._ne_state" />
                </td>
                <td align="center"><s:text name="smsstatus"/>:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._ne_smsstatus" />
                </td>
                <td align="center"><s:text name="smscreattime"/>:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._dnm_smscreattime" />
                </td>
                <td align="center"><s:text name="smscreattime"/>:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._dnl_smscreattime" />
                </td>
                <td align="center"><s:text name="smsconfirmtime"/>:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._dnm_smsconfirmtime" />
                </td>
                <td align="center"><s:text name="smsconfirmtime"/>:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._dnl_smsconfirmtime" />
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
                        value="<s:text name="button_search"/>" onClick="doQuery('/channel/emodconfirm_list.do');">
                	
                    <input type="button" id="btnNew" name="btnNew" class="button_New" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="<s:text name="button_new"/>" onClick="doNew('/channel/emodconfirm_new.do')">
                    
                    <input type="button" id="btnDelete" name="btnDelete" class="button_Delete" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="<s:text name="button_delete"/>" onClick="doDelete('/channel/emodconfirm_delete.do')">
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
                    <j:orderByImg href="javascript:doOrderby('confirmid')"><s:text name="confirmid"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('empmodelid')"><s:text name="empmodelid"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('employeeid')"><s:text name="employeeid"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('model')"><s:text name="model"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('state')"><s:text name="state"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('smsstatus')"><s:text name="smsstatus"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('smscreattime')"><s:text name="smscreattime"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('smsconfirmtime')"><s:text name="smsconfirmtime"/></j:orderByImg>                 
                </td>
            </tr>
            <s:iterator value="dp.datas">
                 <tr class="table_style_content" align="center" onMouseMove="this.bgColor='F0F5F9'" onMouseOut="this.bgColor='#ffffff'">
					 <%-- 复合主键用“|”间隔开 --%>
                     <td>
                         <input type="checkbox" name="param._selectitem" value="<s:property value="confirmid"/>" onclick="checkOne();">
                     </td>
                     <td><a href='<s:url action="emodconfirm_edit.do">
	                         <s:param name="param._pk" value="confirmid"/>
	                     	</s:url>'>
							<s:property value="confirmid"/>
                         </a>
					 </td>
                     <td><s:property value="empmodelid" /></td>
                     <td><s:property value="employeeid" /></td>
                     <td><s:property value="model" /></td>
                     <td><s:property value="state" /></td>
                     <td><s:property value="smsstatus" /></td>
                     <td><s:property value="smscreattime" /></td>
                     <td><s:property value="smsconfirmtime" /></td>
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
		addfield('param._ne_confirmid', '<s:text name="confirmid"/>', 'f', true, '14');
		addfield('param._ne_empmodelid', '<s:text name="empmodelid"/>', 'f', true, '14');
		addfield('param._se_employeeid', '<s:text name="employeeid"/>', 'c', true, '18');
		addfield('param._se_model', '<s:text name="model"/>', 'c', true, '12');
		addfield('param._ne_state', '<s:text name="state"/>', 'f', true, '3');
		addfield('param._ne_smsstatus', '<s:text name="smsstatus"/>', 'f', true, '3');
		addfield('param._dnm_smscreattime', '<s:text name="smscreattime"/>', 't', true, '7');
		addfield('param._dnl_smscreattime', '<s:text name="smscreattime"/>', 't', true, '7');
		addfield('param._dnm_smsconfirmtime', '<s:text name="smsconfirmtime"/>', 't', true, '7');
		addfield('param._dnl_smsconfirmtime', '<s:text name="smsconfirmtime"/>', 't', true, '7');
		return checkval(window);
	}
</script>
