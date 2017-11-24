<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc" %>
<% String ID_ADD = "CH_PW_SYSTEMROLE"; %>
<html>
<head>
    <title><s:text name="titleList"/></title>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            return checkval(window);
        }
        function doTxt(){
        	formList.action="<%=contextPath%>/base/functionitem_txt.do";
        	formList.submit();
        	formList.action="<%=contextPath%>/base/functionitem_doListByParent.do";
        }
        function doExcel(){
        	formList.action="<%=contextPath%>/base/functionitem_excel.do";
        	formList.submit();
        	formList.action="<%=contextPath%>/base/functionitem_doListByParent.do";
        }
    </script>
</head>

<body class="list_body" onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<s:form action="functionitem_doListByParent.do" key="formList" cssStyle="formList" theme="simple" onsubmit="return ev_check();">
	<%//????????????Action?á????????????·???%>
    <aa:zone name="hiddenZone"><s:hidden name="param._orderby"/>
    <s:hidden name="param._desc"/>
    <s:hidden name="param._pageno"/>
    <s:hidden name="param._pagesize"/>
    <s:hidden name="param.queryAll"/>
    <s:hidden name="param._se_parentid"/>
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
            </tr>
        </table>
    </div>
    
    <div class="table_div">
		<table class="table_button_list">
			<tr>
                <td align=right>
                	<s:i18n name="public">
                	<%--<input type="button" id="btnQuery" name="btnQuery" class="button_Query" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="<s:text name="button_search"/>" onClick="doQuery('/base/functionitem_list.do');">
                	--%>
                	<j:purChk permid="<%=ID_ADD%>">
                    <input type="button" id="btnNew" name="btnNew" class="button_New" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="<s:text name="button_new"/>" onClick="doNew('/base/functionitem_new.do?')"  />
                        
                    <input type="button" id="btnExporttxt" name="btnExporttxt" class="button_4" onmouseover="buttonover(this);"
                        		onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        		value="<s:text name="button_exporttxt"/>" onClick="doTxt();">
                        		
                    <input type="button" id="btnExportexcel" name="btnExportexcel" class="button_4" onmouseover="buttonover(this);"
                        		onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        		value="<s:text name="button_exportexcel"/>" onClick="doExcel()">
                    <!-- 改由是否可见控制 -->
                    <!-- 
                    <input type="button" id="btnDelete" name="btnDelete" class="button_Delete" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="<s:text name="button_delete"/>" onClick="doDelete('/base/functionitem_delete.do')"> -->
                    </j:purChk>
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
                    <j:orderByImg href="javascript:doOrderby('funcid')"><s:text name="funcid"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('funcname')"><s:text name="funcname"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('parentid')"><s:text name="parentid"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('guiobject')"><s:text name="guiobject"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('status')"><s:text name="status"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('sortorder')"><s:text name="sortorder"/></j:orderByImg>                 
                </td>
                
            </tr>
            <s:iterator value="dp.datas">
            	<!-- 根节点不应该出现 -->
            	<s:if test="funcid != param._se_parentid">
                 <tr class="table_style_content" align="center" onMouseMove="this.bgColor='F0F5F9'" onMouseOut="this.bgColor='#ffffff'">
                 	<td>
                         <input type="checkbox" name="param._selectitem" value="<s:property value="funcid"/>" onclick="checkOne();">
                     </td>
                     <td><a href='<s:url action="functionitem_edit.do">
	                         <s:param name="param._pk" value="funcid"/>
	                     	</s:url>'>
							<s:property value="funcid"/>
                         </a>
					 </td>
                     <td><s:property value="funcname" /></td>
                     <td><s:property value="parentid" /></td>
                     <td>
                     <span STYLE="overflow:hidden; text-overflow:ellipsis; white-space:nowrap;width:300px" title="<s:property value="guiobject" />"/>
                     	<s:property value="guiobject" />
                     </span></td>
                     <td><j:code2Name definition="$YesOrNo" code="status" /></td>
                     <td><s:property value="sortorder" /></td>
                 </tr>
                 </s:if>
             </s:iterator>
        </table>
    </div></div>
    <div class="table_div">
		<%@ include file="/common/pageNav.jsp"%>
   	</div>
    </aa:zone>
</div>
</s:form>
<script language="javascript"> 
	ajaxAnywhere.getZonesToReload = function(url,submitButton) {
		  return "errorZone,listZone,hiddenZone";
	}
	ajaxAnywhere.substituteFormSubmitFunction();ajaxAnywhere.formURL = formList.action;  
	ajaxAnywhere.substituteSubmitButtonsBehaviorByIDs(true,"btnQuery,btnDelete");
	
	AjaxAnywhere.prototype.temp = ajaxAnywhere.callback;
	AjaxAnywhere.prototype.callback = function(){
	this.temp();
	if (ajaxAnywhere.req.readyState == 4) {
        if (ajaxAnywhere.req.status == 200) {
        parent.leftFrame.location.reload()
        	}
        }
	}

</script>
</body>
</html>
