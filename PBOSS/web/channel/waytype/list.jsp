<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc" %>
<html>
<head>
    <title><s:text name="titleList"/></title>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            addfield('param._se_waytypecode', '<s:text name="waytypecode"/>', 'c', true, '4');
            return checkval(window);
        }
        function doBatch(){
        	formList.action="<%=contextPath%>/channel/waytype/batchwaytype.jsp";
        	formList.submit();
        }
        function doExcel(){
        	formList.action="<%=contextPath%>/channel/waytype_excel.do";
        	formList.submit();
        	formList.action="<%=contextPath%>/channel/waytype_list.do";
        }
        function doExcel2(){
        	formList.action="<%=contextPath%>/channel/waytype_excel2.do";
        	formList.submit();
        	formList.action="<%=contextPath%>/channel/waytype_list.do";
        }
        function doTxt()
        {
        	formList.action="<%=contextPath%>/channel/waytype_txt.do";
        	formList.submit();
        	formList.action="<%=contextPath%>/channel/waytype_list.do";
        }
    </script>
</head>

<body class="list_body" onload="if(window.loadforiframe) loadforiframe();">
<s:form action="waytype_list.do" key="formList" cssStyle="formList" theme="simple" onsubmit="return ev_check();">
	<%//????????????Action?á????????????·???%>
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
                <td align="center"><s:text name="waytypecode"/>:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._se_waytypecode" />
                </td>
            </tr>
        </table>
    </div>
    
    <div class="table_div">
		<table class="table_normal">
			<tr> 
				<td>
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
						<tr>
	                    <td align=right>
	                    	<s:i18n name="public">
	                    	<input type="button" id="btnQuery" name="btnQuery" class="button_Query" onmouseover="buttonover(this);"
	                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
	                            value="<s:text name="button_search"/>" onClick="doQuery('/channel/waytype_list.do');">
	                    	
	                        <input type="button" id="btnNew" name="btnNew" class="button_New" onmouseover="buttonover(this);"
	                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
	                            value="<s:text name="button_new"/>" onClick="doNew('/channel/waytype_new.do')">
	                        
	                        <input type="button" id="btnDelete" name="btnDelete" class="button_Delete" onmouseover="buttonover(this);"
	                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
	                            value="<s:text name="button_delete"/>" onClick="doDelete('/channel/waytype_delete.do')">
	                        <input type="button" id="btnBatch" name="btnBatch" class="button_New" onmouseover="buttonover(this);"
	                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
	                            value="导入" onClick="doBatch();">    
	                        <input type="button" id="btnExcel" name="btnExcel" class="button_New" onmouseover="buttonover(this);"
	                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
	                            value="导出" onClick="doExcel();">
	                        <input type="button" id="btnExcel2" name="btnExcel2"  class="button_2" onmouseover="buttonover(this);"
	                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
	                            value="导出2" onClick="doExcel2();">
	                         <input type="button" id="btntxt" name="btntxt" class="button_2" onmouseover="buttonover(this);"
	                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
	                            value="导出txt" onClick="doTxt();">              
	                       </s:i18n>
	                    </td>
	                    </tr>
					</table>
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
                    <j:orderByImg href="javascript:doOrderby('waytypecode')"><s:text name="waytypecode"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('waytypename')"><s:text name="waytypename"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('uppercode')"><s:text name="uppercode"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('desp')"><s:text name="desp"/></j:orderByImg>                 
                </td>
            </tr>
            <s:iterator value="dp.datas">
                 <tr class="table_style_content" align="center" onMouseMove="this.bgColor='F0F5F9'" onMouseOut="this.bgColor='#ffffff'">
					 <%-- ?????÷?ü???°|?±?????? --%>
                     <td>
                         <input type="checkbox" name="param._selectitem" value="<s:property value="waytypecode"/>" onclick="checkOne();">
                     </td>
                     <td><a href='<s:url action="waytype_edit.do">
	                         <s:param name="param._pk" value="waytypecode"/>
	                     	</s:url>'>
							<s:property value="waytypecode"/>
                         </a>
					 </td>
                     <td><s:property value="waytypename" /></td>
                     <td><s:property value="uppercode" /></td>
                     <td><s:property value="desp" /><-->
                     <j:code2Name definition="$test" code="desp" />
                     </td>
                     <td>
                     </td>
                 </tr>
             </s:iterator>
        </table>
    </div></div>
    <div class="table_div">
		<%@ include file="/common/pageNav.jsp"%>
   	</div>
    </aa:zone>
</s:form>
<script language="javascript"> 
	ajaxAnywhere.getZonesToReload = function(url,submitButton) {
		return "errorZone,listZone,hiddenZone";  
	}
	ajaxAnywhere.substituteFormSubmitFunction();ajaxAnywhere.formURL = formList.action;  
	ajaxAnywhere.substituteSubmitButtonsBehaviorByIDs(true,"btnQuery,btnDelete");
</script> 
</body>
</html>
