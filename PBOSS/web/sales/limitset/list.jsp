<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc" %>
<html>
<head>
    <title><s:text name="titleList"/></title>
</head>

<body class="list_body" onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<s:form action="limitset_list.do" key="formList" cssStyle="formList" theme="simple" onsubmit="return ev_check();">
	<%//����Ŀؼ���Action�ṩ���ݣ�������ҳ%>
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
                <td align="center"><s:text name="cityname"/>:</td>
                <td align="left">
                	<j:selector definition="#CITYCOMPANY" mode="selector" name="param._se_cityid" condition="citycompid:${form.cityid}" value="${form.cityid}" disabled="true"/>
                </td>
                <td align="center"><s:text name="countyname"/>:</td>
                <td align="left">
                	<j:selector definition="#CNTYCOMPANY" mode="picker" name="param._se_countyid" condition="citycompid:${form.cityid}" readonly="true"/>
                </td>
            </tr>
            <tr>
                <td align="center"><s:text name="starlevel"/>:</td>
                <td align="left">
                	<j:selector definition="$CH_STARLEVEL" mode="selector" name="param._ne_starlevel"/>
                </td>
                <td align="center"><s:text name="comcategory"/>:</td>
                <td align="left">
                	<j:selector definition="$IM_FXCOMCATEGORY" name="param._se_comcategory" mode="picker"/>
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
                        value="<s:text name="button_search"/>" onClick="doQuery('/sales/limitset_list.do');">
                	
                    <input type="button" id="btnNew" name="btnNew" class="button_New" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="<s:text name="button_new"/>" onClick="doNew('/sales/limitset_new.do')">
                    
                    <input type="button" id="btnDelete" name="btnDelete" class="button_Delete" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="<s:text name="button_delete"/>" onClick="doDelete('/sales/limitset_delete.do')">
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
                    <j:orderByImg href="javascript:doOrderby('recid')"><s:text name="recid"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('cityid')"><s:text name="cityname"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('countyid')"><s:text name="countyname"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('starlevel')"><s:text name="starlevel"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('comcategory')"><s:text name="comcategory"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('stockscale')"><s:text name="stockscale"/></j:orderByImg>                 
                </td>
            </tr>
            <s:iterator value="dp.datas">
                 <tr class="table_style_content" align="center" onMouseMove="this.bgColor='F0F5F9'" onMouseOut="this.bgColor='#ffffff'">
					 <%-- ���������á�|������� --%>
                     <td>
                         <input type="checkbox" name="param._selectitem" value="<s:property value="recid"/>" onclick="checkOne();">
                     </td>
                     <td><a href='<s:url action="limitset_edit.do">
	                         <s:param name="param._pk" value="recid"/>
	                     	</s:url>'>
							<s:property value="recid"/>
                         </a>
					 </td>
                     <td><j:code2Name definition="#CITYCOMPANY" code="cityid"/></td>
                     <td><j:code2Name definition="#CNTYCOMPANY" code="countyid"/></td>
                     <td><j:code2Name definition="$CH_STARLEVEL" code="starlevel"/></td>
                     <td><j:code2Name definition="$IM_FXCOMCATEGORY" code="comcategory"/></td>
                     <td><s:property value="stockscale" /></td>
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
		return checkval(window);
	}
</script>
