<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<title><s:text name="titleList"/></title>
<script language="JavaScript" type="text/JavaScript">
function ev_check() {
	addfield('param._sk_title', '<s:text name="title"/>', 'c', true, '256');
	addfield('param._dnm_releasetime', '<s:text name="releasetime"/>', 't', true, '7');
	addfield('param._dnl_releasetime', '<s:text name="releasetime"/>', 't', true, '7');
	addfield('param._ne_state', '<s:text name="state"/>', 'f', true, '3');
	return checkval(window);
}

function doRelease(advinfoid) {
	$("#_pk").val(advinfoid);
	formList.action = "<%= contextPath %>/communication/chpwcomsadvinfo_release.do";
    formList.submit();
    formList.action = "<%= contextPath %>/communication/chpwcomsadvinfo_list.do";
}

function doStatistics(advinfoid) {
	var url = "<%=contextPath%>/communication/chpwcomsrcvobj_statistics.do?param._ne_advinfoid=" + advinfoid + "&rand=" + Math.random();
	window.showModalDialog(url, window, "dialogHeight:500px;dialogWidth:800px;status:no;resizable:yes;");
}
</script>
</head>

<body class="list_body" onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<s:form action="chpwcomsadvinfo_list.do" key="formList" cssStyle="formList" theme="simple" onsubmit="return ev_check();">
	<%//下面的控件给Action提供数据，用来分页%>
	<aa:zone name="hiddenZone">
    <s:hidden name="param._orderby"/>
    <s:hidden name="param._desc"/>
    <s:hidden name="param._pageno"/>
    <s:hidden name="param._pagesize"/>
    <s:hidden name="param.queryAll"/>
    <s:hidden name="param._pk" id="_pk"/>
    <input type="hidden" name="_rowcount" value="<s:property value="dp.rowCount" />"/>
	</aa:zone>
    
	<div class="table_top">
		<div class="table_topleft"></div>
		<div class="table_toparea_w">
			<s:i18n name="public">
			<span class="table_toparea"><s:text name="currentPos"/> </span>
			<span class="table_toparea_xi">></span>
			<span class="table_toparea"><s:text name="communication"/> </span>
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
                <td align="center"><s:text name="title"/>:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._sk_title" />
                </td>
                <td align="center"><s:text name="state"/>:</td>
                <td align="left">
                    <j:selector name="param._ne_state" definition="COMSADVINFO_STATE" cssStyle="select" />
                </td>
            </tr>
            <tr>
                <td align="center"><s:text name="_dnl_releasetime"/>:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._dnl_releasetime" onclick="selectDate();" />
                </td>
                <td align="center"><s:text name="_dnm_releasetime"/>:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._dnm_releasetime" onclick="selectDate();" />
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
                        value="<s:text name="button_search"/>" onClick="doQuery('/communication/chpwcomsadvinfo_list.do');">
                	
                    <input type="button" id="btnNew" name="btnNew" class="button_New" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="<s:text name="button_new"/>" onClick="doNew('/communication/chpwcomsadvinfo_new.do')">
                    
                    <input type="button" id="btnDelete" name="btnDelete" class="button_Delete" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="<s:text name="button_delete"/>" onClick="doDelete('/communication/chpwcomsadvinfo_delete.do')">
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
                    <j:orderByImg href="javascript:doOrderby('title')"><s:text name="title"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('releasetime')"><s:text name="releasetime"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('rcvobjtype')"><s:text name="rcvobjtype"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('smsnotify')"><s:text name="smsnotify"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('releasecode')"><s:text name="releasecode"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('state')"><s:text name="state"/></j:orderByImg>                 
                </td>
                <td>操作</td>
            </tr>
            <s:iterator value="dp.datas">
                 <tr class="table_style_content" align="center" onMouseMove="this.bgColor='F0F5F9'" onMouseOut="this.bgColor='#ffffff'">
					 <%-- 复合主键用“|”间隔开 --%>
                     <td>
                         <input type="checkbox" name="param._selectitem" value="<s:property value="advinfoid"/>" onclick="checkOne();">
                     </td>
                     <td><a href='<s:url action="chpwcomsadvinfo_edit.do">
	                         <s:param name="param._pk" value="advinfoid"/>
	                     	</s:url>'>
							<s:property value="title" />
                         </a>
					 </td>
                     <td><s:date name="releasetime" format="yyyy-MM-dd HH:mm:ss"/></td>
                     <td><j:code2Name definition="COMSRCVOBJ_RCVOBJTYPE" code="rcvobjtype" /></td>
                     <td><j:code2Name definition="SMSNOTIFY" code="smsnotify" /></td>
                     <td><j:code2Name definition="#OPERATOR" code="releasecode" /></td>
                     <td><j:code2Name definition="COMSADVINFO_STATE" code="state" /></td>
                     <td>
                     	<s:if test="state == 1">
                     		<input type="button" id="btnNew" name="btnNew" class="button_New" onmouseover="buttonover(this);"
		                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
		                        value="发布" onClick="doRelease('<s:property value="advinfoid" />');">
                     	</s:if>
                     	<s:if test="state == 2">
                     		<input type="button" id="btnQuery" name="btnQuery" class="button_Query" onmouseover="buttonover(this);"
		                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
		                        value="统计" onClick="doStatistics('<s:property value="advinfoid" />');">
                     	</s:if>
                     </td>
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
