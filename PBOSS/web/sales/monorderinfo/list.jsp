<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc" %>
<%@ taglib prefix="j" uri="/jop-tags" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title><s:text name="titleList"/></title>
    <script type="text/javascript" src="<%=contextPath%>/js/bus/pwaycommon.js"></script>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            return checkval(window);
        }
    </script>
</head>

<body class="list_body" onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<s:form action="monorderinfo_list.do" key="formList" cssStyle="formList" theme="simple" onsubmit="return ev_check();">
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
                <td align="center"><s:text name="wayid"/>:</td>
                <td align="left">
                	<s:textfield name="param._se_wayid"/><input type="button" value="..." class="picker_button" onclick="pshowSelectWay3(this,'param._se_wayid','','','AG');this.value='...';" />
                </td>
                <td align="center"><s:text name="month"/>:</td>
                <td align="left">
                	<s:textfield cssStyle="style_input" name="param._se_month" onclick="selectDateYYYYMM()"/>
                </td>
                <td align="center"><s:text name="brand"/>:</td>
                <td align="left">
                	<p:smpBrand name="param._se_brand" mode="of" cssStyle="style_input" />
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
                        value="<s:text name="button_search"/>" onClick="doQuery('/sales/monorderinfo_list.do');">
                	
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
                <td width="10%">
                    <j:orderByImg href="javascript:doOrderby('wayid')"><s:text name="wayid"/></j:orderByImg>                 
                </td>
                <td width="10%">
                    <j:orderByImg href="javascript:doOrderby('wayid')"><s:text name="way"/></j:orderByImg>                 
                </td>
                <td width="10%">
                    <j:orderByImg href="javascript:doOrderby('month')"><s:text name="month"/></j:orderByImg>                 
                </td>
                <td width="10%">
                    <j:orderByImg href="javascript:doOrderby('brand')"><s:text name="brand"/></j:orderByImg>                 
                </td>
                <td width="15%">
                    <j:orderByImg href="javascript:doOrderby('topamt')"><s:text name="topamt"/></j:orderByImg>                 
                </td>
                <td width="15%">
                    <j:orderByImg href="javascript:doOrderby('actualamt')"><s:text name="actualamt"/></j:orderByImg>                 
                </td>
                <td width="10%">
                    <j:orderByImg href="javascript:doOrderby('actamt')"><s:text name="actamt"/></j:orderByImg>                 
                </td>
                <td width="10%">
                    <j:orderByImg href="javascript:doOrderby('updatetime')"><s:text name="updatetime"/></j:orderByImg>                 
                </td>
            </tr>
            <s:iterator value="monorderinfoList">
                 <tr class="table_style_content" align="center" onMouseMove="this.bgColor='F0F5F9'" onMouseOut="this.bgColor='#ffffff'">
					 <td><s:property value="wayid" /></td>
                     <td><s:property value="wayname" /></td>
                     <td><s:property value="month" /></td>
                     <td><j:code2Name definition="$FX_SMPBRAND" code="brand"/></td>
                     <td><s:property value="topamt" /></td>
                     <td><s:property value="actualamt" /></td>
                     <td><s:property value="actamt" /></td>
                     <td><s:date name="updatetime" format="yyyy-MM-dd"/></td>
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
