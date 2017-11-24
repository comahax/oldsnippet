<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc" %>
<html>
<head>
    <title><s:text name="titleList"/></title>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            addfield('param._ne_replyid', '<s:text name="replyid"/>', 'f', true, '14');
            addfield('param._ne_advinfoid', '<s:text name="advinfoid"/>', 'f', true, '14');
            addfield('param._dnm_replytime', '<s:text name="replytime"/>', 't', true, '7');
            addfield('param._de_replytime', '<s:text name="replytime"/>', 't', true, '7');
            addfield('param._dnl_replytime', '<s:text name="replytime"/>', 't', true, '7');
            addfield('param._se_affix', '<s:text name="affix"/>', 'c', true, '40');
            addfield('param._se_oid', '<s:text name="oid"/>', 'c', true, '18');
            return checkval(window);
        }
    </script>
</head>

<body class="list_body" onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<s:form action="reply_list.do" key="formList" cssStyle="formList" theme="simple" onsubmit="return ev_check();">
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
                <td align="center"><s:text name="replyid"/>:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._ne_replyid" />
                </td>
                <td align="center"><s:text name="advinfoid"/>:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._ne_advinfoid" />
                </td>
                <td align="center"><s:text name="replytime"/>:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._dnm_replytime" />
                </td>
                <td align="center"><s:text name="replytime"/>:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._de_replytime" />
                </td>
                <td align="center"><s:text name="replytime"/>:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._dnl_replytime" />
                </td>
                <td align="center"><s:text name="affix"/>:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._se_affix" />
                </td>
                <td align="center"><s:text name="oid"/>:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._se_oid" />
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
                        value="<s:text name="button_search"/>" onClick="doQuery('/communication/reply_list.do');">
                	
                    <input type="button" id="btnNew" name="btnNew" class="button_New" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="<s:text name="button_new"/>" onClick="doNew('/communication/reply_new.do')">
                    
                    <input type="button" id="btnDelete" name="btnDelete" class="button_Delete" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="<s:text name="button_delete"/>" onClick="doDelete('/communication/reply_delete.do')">
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
                    <j:orderByImg href="javascript:doOrderby('replyid')"><s:text name="replyid"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('advinfoid')"><s:text name="advinfoid"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('replytime')"><s:text name="replytime"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('replycontent')"><s:text name="replycontent"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('affix')"><s:text name="affix"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('oid')"><s:text name="oid"/></j:orderByImg>                 
                </td>
            </tr>
            <s:iterator value="dp.datas">
                 <tr class="table_style_content" align="center" onMouseMove="this.bgColor='F0F5F9'" onMouseOut="this.bgColor='#ffffff'">
					 <%-- 复合主键用“|”间隔开 --%>
                     <td>
                         <input type="checkbox" name="param._selectitem" value="<s:property value="replyid"/>" onclick="checkOne();">
                     </td>
                     <td><a href='<s:url action="reply_edit.do">
	                         <s:param name="param._pk" value="replyid"/>
	                     	</s:url>'>
							<s:property value="replyid"/>
                         </a>
					 </td>
                     <td><s:property value="advinfoid" /></td>
                     <td><s:property value="replytime" /></td>
                     <td><s:property value="replycontent" /></td>
                     <td><s:property value="affix" /></td>
                     <td><s:property value="oid" /></td>
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
