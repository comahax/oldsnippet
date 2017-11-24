<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc" %>
<html>
<head>
    <title><s:text name="titleList"/></title>
</head>

<body class="list_body" onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<s:form action="smsloghis_list.do" key="formList" cssStyle="formList" theme="simple" onsubmit="return ev_check();">
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
                <td align="center"><s:text name="seqid"/>:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._ne_seqid" />
                </td>
                <td align="center"><s:text name="mobile"/>:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._se_mobile" />
                </td>
                <td align="center"><s:text name="cityid"/>:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._se_cityid" />
                </td>
                <td align="center"><s:text name="smsno"/>:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._se_smsno" />
                </td>
                <td align="center"><s:text name="commandid"/>:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._se_commandid" />
                </td>
                <td align="center"><s:text name="smsseq"/>:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._se_smsseq" />
                </td>
                <td align="center"><s:text name="scontent"/>:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._se_scontent" />
                </td>
                <td align="center"><s:text name="oprtime"/>:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._dnm_oprtime" />
                </td>
                <td align="center"><s:text name="oprtime"/>:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._dnl_oprtime" />
                </td>
                <td align="center"><s:text name="sstate"/>:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._ne_sstate" />
                </td>
                <td align="center"><s:text name="remark"/>:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._se_remark" />
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
                        value="<s:text name="button_search"/>" onClick="doQuery('/channel/smsloghis_list.do');">
                	
                    <input type="button" id="btnNew" name="btnNew" class="button_New" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="<s:text name="button_new"/>" onClick="doNew('/channel/smsloghis_new.do')">
                    
                    <input type="button" id="btnDelete" name="btnDelete" class="button_Delete" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="<s:text name="button_delete"/>" onClick="doDelete('/channel/smsloghis_delete.do')">
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
                    <j:orderByImg href="javascript:doOrderby('seqid')"><s:text name="seqid"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('mobile')"><s:text name="mobile"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('cityid')"><s:text name="cityid"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('smsno')"><s:text name="smsno"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('commandid')"><s:text name="commandid"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('smsseq')"><s:text name="smsseq"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('scontent')"><s:text name="scontent"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('oprtime')"><s:text name="oprtime"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('sstate')"><s:text name="sstate"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('remark')"><s:text name="remark"/></j:orderByImg>                 
                </td>
            </tr>
            <s:iterator value="dp.datas">
                 <tr class="table_style_content" align="center" onMouseMove="this.bgColor='F0F5F9'" onMouseOut="this.bgColor='#ffffff'">
					 <%-- 复合主键用“|”间隔开 --%>
                     <td>
                         <input type="checkbox" name="param._selectitem" value="<s:property value="seqid"/>" onclick="checkOne();">
                     </td>
                     <td><a href='<s:url action="smsloghis_edit.do">
	                         <s:param name="param._pk" value="seqid"/>
	                     	</s:url>'>
							<s:property value="seqid"/>
                         </a>
					 </td>
                     <td><s:property value="mobile" /></td>
                     <td><s:property value="cityid" /></td>
                     <td><s:property value="smsno" /></td>
                     <td><s:property value="commandid" /></td>
                     <td><s:property value="smsseq" /></td>
                     <td><s:property value="scontent" /></td>
                     <td><s:property value="oprtime" /></td>
                     <td><s:property value="sstate" /></td>
                     <td><s:property value="remark" /></td>
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
		addfield('param._ne_seqid', '<s:text name="seqid"/>', 'f', true, '14');
		addfield('param._se_mobile', '<s:text name="mobile"/>', 'c', true, '15');
		addfield('param._se_cityid', '<s:text name="cityid"/>', 'c', true, '3');
		addfield('param._se_smsno', '<s:text name="smsno"/>', 'c', true, '15');
		addfield('param._se_commandid', '<s:text name="commandid"/>', 'c', true, '10');
		addfield('param._se_smsseq', '<s:text name="smsseq"/>', 'c', true, '15');
		addfield('param._se_scontent', '<s:text name="scontent"/>', 'c', true, '500');
		addfield('param._dnm_oprtime', '<s:text name="oprtime"/>', 't', true, '7');
		addfield('param._dnl_oprtime', '<s:text name="oprtime"/>', 't', true, '7');
		addfield('param._ne_sstate', '<s:text name="sstate"/>', 'f', true, '3');
		addfield('param._se_remark', '<s:text name="remark"/>', 'c', true, '500');
		return checkval(window);
	}
</script>
