<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc" %>
<% String ID_ADD = "FX_RU_STOCKALARM"; %>
<html>
<head>
    <title><s:text name="titleList"/></title>
    <script type="text/javascript" src="<%=contextPath%>/js/bus/pwaycommon.js"></script>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            return checkval(window);
        }
        
        function doBatch(){
        	formList.action="<%=contextPath%>/sales/stockalarm_import.do";
        	formList.submit();
        }

        function doExcel(){
        	formList.action="<%=contextPath%>/sales/stockalarm_excel.do";
        	formList.submit();
        	formList.action="<%=contextPath%>/sales/stockalarm_list.do";
        }
    </script>
</head>

<body class="list_body" onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<s:form action="stockalarm_list.do" key="formList" cssStyle="formList" theme="simple" onsubmit="return ev_check();">
	<%//下面的控件给Action提供数据，用来分页%>
    <s:hidden name="param._orderby"/>
    <s:hidden name="param._desc"/>
    <s:hidden name="param._pageno"/>
    <s:hidden name="param._pagesize"/>
    <s:hidden name="param.queryAll"/>
    <input type="hidden" name="_rowcount" value="<s:property value="dp.rowCount" />"/>
    
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
			<!-- 
			<span class="button_Help" onclick="openword('<s:text name="helpTitle"/>','<s:text name="helpContent"/>')"><s:i18n name="public"><s:text name="help"/></s:i18n></span>
			 -->
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
            	<td align="center"><s:text name="countyid"/>:</td>
            	<td align="left">
                	<j:selector definition="#CNTYCOMPANY"  condition="citycompid:${USER.cityid}" name="param._se_countyid" mode="selector"/>
                </td>
                <td align="center"><s:text name="starlevel"/>:</td>
                <td align="left">
                    <j:selector name="param._ne_starlevel" definition="$CH_STARLEVEL" />
                </td>
            </tr>
            <tr>
                <td align="center"><s:text name="wayid"/>:</td>
                <td align="left">
                     <s:textfield cssStyle="style_input" name="param._se_wayid" /><input type="button" value="..." class="picker_button" onclick="pshowSelectWay3(this,'param._se_wayid',null,null,'AG');this.value='...';" />
                </td>
                <td align="center"><s:text name="waystate"/>:</td>
                <td align="left">
                	<j:selector name="param._ne_waystate" definition="$CH_VALIDFLAG" />
                </td>
            </tr>
            <tr>
                <td align="center"><s:text name="brand"/>:</td>
                <td align="left">
                    <p:smpBrand name="param._sk_brand" mode="def" cssStyle="style_input" />
                </td>
                <td align="center"><s:text name="updatechannel"/>:</td>
                <td align="left">
                    <j:selector definition="$FX_UPDATECHANNEL" name="param._se_updatechannel" mode="selector"/>
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
                        value="<s:text name="button_search"/>" onClick="doQuery('/sales/stockalarm_list.do');">
                        
                    <input type="button" id="btnExcel" name="btnExcel" class="button_4" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="<s:text name="button_exportexcel"/>" onClick="doExcel('/sales/stockalarm_excel.do')">
                	
                	<j:purChk permid="<%=ID_ADD%>">
                    <input type="button" id="btnNew" name="btnNew" class="button_New" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="<s:text name="button_new"/>" onClick="doNew('/sales/stockalarm_new.do')">
                    
                    <input type="button" id="btnBatch" name="btnBatch" class="button_4" onmouseover="buttonover(this);"
	                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
	                            value="批量导入" onClick="doBatch();">
	                            
                    <input type="button" id="btnDelete" name="btnDelete" class="button_Delete" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="<s:text name="button_delete"/>" onClick="doDelete('/sales/stockalarm_delete.do')">
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
                	<a href="javascript:doOrderby('countyid')"><s:text name="countyid"/></a> 
                </td>
                <td>
                    <a href="javascript:doOrderby('wayid')"><s:text name="wayid"/></a>                 
                </td>
                <td>
                    <a href="javascript:doOrderby('wayid')"><s:text name="wayname"/></a>                 
                </td>
                <td>
                    <a href="javascript:doOrderby('starlevel')"><s:text name="starlevel"/></a>               
                </td>
                <td>
                    <a href="javascript:doOrderby('waystate')"><s:text name="waystate"/></a>                 
                </td>
                <td>
                    <a href="javascript:doOrderby('brand')"><s:text name="brand"/></a>                 
                </td>
                <td>
                    <a href="javascript:doOrderby('stdvalue')"><s:text name="stdvalue"/></a>                 
                </td>
                <td>
                    <a href="javascript:doOrderby('quotiety')"><s:text name="quotiety"/></a>                 
                </td>
                <td>
                    <a href="javascript:doOrderby('maxstock')"><s:text name="maxstock"/></a>                 
                </td>
                <td>
                    <a href="javascript:doOrderby('alarmvalue')"><s:text name="alarmvalue"/></a>                 
                </td>
                <td>
                    <a href="javascript:doOrderby('updatechannel')"><s:text name="updatechannel"/></a>                 
                </td>
                <td>
                    <a href="javascript:doOrderby('chgtime')"><s:text name="chgtime"/></a>                 
                </td>
                <td>
                    <a href="javascript:doOrderby('aveactnum')"><s:text name="aveactnum"/></a>                 
                </td>
                <td>
                    <a href="javascript:doOrderby('memo')"><s:text name="memo"/></a>
                </td>
            </tr>
            <s:iterator value="dp.datas">
                 <tr class="table_style_content" align="center" onMouseMove="this.bgColor='F0F5F9'" onMouseOut="this.bgColor='#ffffff'">
					 <%-- 复合主键用“|”间隔开 --%>
                     <td>
                         <input type="checkbox" name="param._selectitem" value="<s:property value="brand + '|' + wayid"/>" onclick="checkOne();">
                     </td>
                     <td><j:code2Name definition="#CNTYCOMPANY" code="countyid" /></td>
                     <td><a href='<s:url action="stockalarm_edit.do">
	                         <s:param name="param._pk" value="brand + '|' + wayid"/>
	                     	</s:url>'>
	                     	<s:property value="wayid" />
                         </a>
					 </td>
					 <td><j:code2Name definition="#WAYIDINFO" code="wayid" /></td>
					 <td><j:code2Name code="starlevel" definition="$CH_STARLEVEL" /></td>
					 <td><j:code2Name code="waystate" definition="$CH_VALIDFLAG" /></td>
                     <td><a href='<s:url action="stockalarm_edit.do">
	                         <s:param name="param._pk" value="brand + '|' + wayid"/>
	                     	</s:url>'>
							<s:property value="sbrand" />
                         </a>
					 </td>
					 <td><s:property value="stdvalue" /></td>
					 <td><s:property value="quotiety" /></td>
					 <td><s:property value="maxstock" /></td>
                     <td><s:property value="extendAlarmValue" /></td>
                     <td><j:code2Name definition="$FX_UPDATECHANNEL" code="updatechannel" /></td>
                     <td><s:date name="chgtime" format="yyyy-MM-dd HH:mm:ss"/></td>
                     <td><s:property value="aveactnum" /></td>
                     <td><s:property value="memo" /></td>
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
		return "errorZone,listZone";  
	}
	ajaxAnywhere.substituteFormSubmitFunction();ajaxAnywhere.formURL = formList.action;
	ajaxAnywhere.substituteSubmitButtonsBehaviorByIDs(true,"btnQuery,btnDelete");
</script> 
</body>
</html>
