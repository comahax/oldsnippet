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
        	formList.action="<%=contextPath%>/base/operfunction_txt.do";
        	formList.submit();
        	formList.action="<%=contextPath%>/base/operfunction_list.do";
        }
        function doExcel(){
        	formList.action="<%=contextPath%>/base/operfunction_excel.do";
        	formList.submit();
        	formList.action="<%=contextPath%>/base/operfunction_list.do";
        }
        function doBatchSave(){
			formList.action = '<%=contextPath%>/base/operfunction_batchlist.do';
			formList.submit();
        }
    </script>
</head>

<body class="list_body" onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<s:form action="operfunction_list.do" key="formList" cssStyle="formList" theme="simple" onsubmit="return ev_check();">
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
                <td align="center"><s:text name="operid"/>:</td>
                <td align="left">
                    <j:selector definition="#OPERATOR" name="param._se_operid" condition='region:${dBAccessUser.hwcityid };status:1'/>
                </td>
                <td align="center"><s:text name="functionid"/>:</td>
                <td align="left">
                    <j:selector definition="#FUNCTIONITEM" name="param._se_functionid" condition="_snn_guiobject:notnull"/>
                </td>
            </tr>
            <tr>
            	<td align="center"><s:text name="statusdate"/>&gt;=:</td>
            	<td align="left">
            		<s:textfield cssStyle="style_input" name="param._dnl_statusdate" onclick="selectDate();"/>
            	</td>
            	<td align="center"><s:text name="statusdate"/>&lt;=:</td>
            	<td align="left">
            		<s:textfield cssStyle="style_input" name="param._dnm_statusdate" onclick="selectDate();"/>
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
                        value="<s:text name="button_search"/>" onClick="doQuery('/base/operfunction_list.do');">
                    
                    <j:purChk permid="<%=ID_ADD%>">    
                    <input type="button" id="btnExporttxt" name="btnExporttxt" class="button_4" onmouseover="buttonover(this);"
                        		onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        		value="<s:text name="button_exporttxt"/>" onClick="doTxt();">
                        		
                    <input type="button" id="btnExportexcel" name="btnExportexcel" class="button_4" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="<s:text name="button_exportexcel"/>" onClick="doExcel()">
                	
                    <input type="button" id="btnNew" name="btnNew" class="button_New" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="<s:text name="button_new"/>" onClick="doNew('/base/operfunction_new.do')">
                        
                    <input type="button" id="btnNew" name="btnNew" class="button_4" onmouseover="buttonover(this);"
	                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
	                            value="批量授权" onClick="doBatchSave()">
                    
                    <input type="button" id="btnDelete" name="btnDelete" class="button_Delete" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="<s:text name="button_delete"/>" onClick="doDelete('/base/operfunction_delete.do')">
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
                    <j:orderByImg href="javascript:doOrderby('operid')"><s:text name="operid"/></j:orderByImg>                 
                </td>
                <td>姓名</td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('functionid')"><s:text name="functionid"/></j:orderByImg>                 
                </td>
                <td>菜单名称</td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('createdate')"><s:text name="createdate"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('status')"><s:text name="status"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('statusdate')"><s:text name="statusdate"/></j:orderByImg>                 
                </td>
            </tr>
            <s:iterator value="dp.datas">
                 <tr class="table_style_content" align="center" onMouseMove="this.bgColor='F0F5F9'" onMouseOut="this.bgColor='#ffffff'">
					 <%-- 复合主键用“|”间隔开 --%>
                     <td>
                         <input type="checkbox" name="param._selectitem" value="<s:property value="functionid + '|' + operid"/>" onclick="checkOne();">
                     </td>
                     <td><a href='<s:url action="operfunction_edit.do">
	                         <s:param name="param._pk" value="functionid + '|' + operid"/>
	                     	</s:url>'>
							<s:property value="operid"/>
                         </a>
					 </td>
					 <td><j:code2Name definition="#OPERATOR" code="operid" /></td>
                     <td><a href='<s:url action="operfunction_edit.do">
	                         <s:param name="param._pk" value="functionid + '|' + operid"/>
	                     	</s:url>'>
							<s:property value="functionid"/>
                         </a>
					 </td>
					 <td><j:code2Name definition="#FUNCTIONITEM" code="functionid" /></td>
                     <td><s:date name="createdate" format="yyyy-MM-dd"/></td>
                     <td><j:code2Name definition="$CH_OPRSTATUS" code="status" /></td>
                     <td><s:date name="statusdate" format="yyyy-MM-dd"/></td>
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
