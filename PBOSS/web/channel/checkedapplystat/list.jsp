<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc" %>
<html>
<head>
    <title><s:text name="titleList"/></title>
</head>

<body class="list_body" onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<s:form action="checkedapplystat_list.do" key="formList" cssStyle="formList" theme="simple" onsubmit="return ev_check();">
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
			<span class="table_toparea"><s:text name="channel"/> </span>
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
            	<td align="center">
					<s:text name="starttime" />
				</td>
				<td align="left">
					<s:textfield cssStyle="style_input" name="param._dnl_aptime" onclick="selectDatetime();"/>
				</td>
				<td align="center">
					<s:text name="endtime" />
				</td>
				<td align="left">
					<s:textfield cssStyle="style_input" name="param._dnm_aptime" onclick="selectDatetime();"/>
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
	                        value="<s:text name="button_search"/>" onClick="doQuery('/channel/checkedapplystat_list.do');">
	                	
	                	<input type="button" id="btnExportexcel" name="btnExportexcel" class="button_4" onmouseover="buttonover(this);"
	                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
	                        value="<s:text name="button_exportexcel"/>" onClick="doExcel()">
	                    
	                    <input type="button" id="btnExportexce6" name="btnExportexce6" class="button_6" onmouseover="buttonover(this);"
	                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
	                        value="导出EXCEL明细" onClick="doExcelDetail()">
                        
                        <input type="button" id="btnExportexce8" name="btnExportexce8" class="button_8" onmouseover="buttonover(this);"
	                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
	                        value="查看已授权网点数据" onClick="doToList()">
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
                
                <td>
                    <s:text name="cityid"/>              
                </td>
                <td>
                    <s:text name="applytype"/>                
                </td>
                <td>
                    <s:text name="status"/>               
                </td>
                <td>
                    <s:text name="nettype"/>              
                </td>
                <td>
                    <s:text name="nettype1"/>                
                </td>
                <td>
                    <s:text name="istop"/>               
                </td>
                <td>
                    <s:text name="stat"/>              
                </td>
            </tr>
            <s:iterator value="dp.datas">
                 <tr class="table_style_content" align="center" onMouseMove="this.bgColor='F0F5F9'" onMouseOut="this.bgColor='#ffffff'">
					 <%-- 复合主键用“|”间隔开 --%>
                     <td><j:code2Name code="cityid" definition="#CITYCOMPANY" /></td>
                     <td><j:code2Name code="applytype" definition="$CH_CHECKTYPE" /></td>
                     <td>
                        <s:if test="param.APPSTATUS_MULTI">
		                  <j:code2Name definition="$CH_APPSTATUS_GZ" code="status" /> 
	                    </s:if>
	                    <s:else>
	                      <j:code2Name definition="$CH_APPSTATUS" code="status"/>	                      
	                    </s:else>                     
                     </td>
                     <td><s:property value="istopstat" /></td>
                     <td><s:property value="nettypestat" /></td>
                     <td><s:property value="nettype1stat" /></td>
                     <td><s:property value="statstat" /></td>
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
	
	function doExcel(){
    	formList.action="<%=contextPath%>/channel/checkedapplystat_exportExcel.do";
        formList.submit();
        formList.action="<%=contextPath%>/channel/checkedapplystat_list.do";
    }
    
    function doExcelDetail(){
    	formList.action="<%=contextPath%>/channel/checkedapplystat_exportExcelDetail.do";
        formList.submit();
        formList.action="<%=contextPath%>/channel/checkedapplystat_list.do";
    }
    
    function doToList(){
        formList.action="<%=contextPath%>/channel/checkedapplystat_new.do";
        formList.submit();
    }
</script>
