<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc" %>
<html>
<head>
    <title><s:text name="titleList"/></title>
    <script type="text/javascript" src="<%=contextPath%>/js/bus/pwaycommon.js"></script>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
        	addfield('param.starttimeStr', '<s:text name="starttime"/>', 'c', false, 10);
			addfield('param.endtimeStr', '<s:text name="endtime"/>', 'c', false, 10);
            return checkval(window);
        }
        
        function doExcel(cmd)
        {
		    var url = contextPath + cmd;
		    formList.action = url;  
		    formList.submit();
		    formList.action=contextPath+"/sales/ressum_list.do";
        }
    </script>
</head>

<body class="list_body" onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<s:form action="ressum_list.do" key="formList" cssStyle="formList" theme="simple" onsubmit="return ev_check();">
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
                <td align="center"><s:text name="starttime"/>:</td>
                <td align="left">
                     <s:textfield cssStyle="style_input" name="param.starttimeStr" onclick="selectDate()"/>
                	 <font color=red>*</font>
                </td>
                <td align="center"><s:text name="endtime"/>:</td>
                <td align="left">
                     <s:textfield cssStyle="style_input" name="param.endtimeStr" onclick="selectDate()"/>
                	 <font color=red>*</font>
                </td>
            </tr>
            <tr>
                <td align="center"><s:text name="wayid"/>:</td>
                <td align="left">
                	<s:textfield name="param.wayid"/><input type="button" value="..." class="picker_button" onclick="pshowSelectWay3(this,'param.wayid','','','');this.value='...';" />
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
                        value="<s:text name="button_search"/>" onClick="doQuery('/sales/ressum_list.do');">
                   	<input type="button" id="btnExcel" name="btnExcel" class="button_4" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="<s:text name="button_exportexcel"/>" onClick="doExcel('/sales/ressum_excel.do')">
                   </s:i18n>
				</td>
			</tr>
		</table>
	</div>

	<aa:zone name="listZone">
    <div class="table_div">
    	<div class="table_LongTable">
        <table class="table_style" id="dataTable">
            <tr class="table_style_head">
                <td>
                    <j:orderByImg href="javascript:doOrderby('wayid')"><s:text name="wayid"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('wayid')"><s:text name="wayname"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('comid')"><s:text name="comname"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('comid')"><s:text name="comprice"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('comid')"><s:text name="relprice"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('amount')"><s:text name="amount"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('recamt')"><s:text name="recamt"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('actamt')"><s:text name="actamt"/></j:orderByImg>                 
                </td>
            </tr>
            <s:iterator value="dp.datas">
                 <tr class="table_style_content" align="center" onMouseMove="this.bgColor='F0F5F9'" onMouseOut="this.bgColor='#ffffff'">
                     <td><s:property value="wayid"/></td>
                     <td><s:property value="wayname"/></td>
                     <td><j:code2Name definition="#COMSYSTEM" code="comid" /></td>
                     <td><s:property value="compriceFormat" /></td>
                     <td><s:property value="relpriceFormat" /></td>
                     <td><s:property value="amount" /></td>
                     <td><s:property value="recamtFormat" /></td>
                     <td><s:property value="actamtFormat" /></td>
                 </tr>
             </s:iterator>
        </table>
        </div>
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
