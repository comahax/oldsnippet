<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc" %>
<html>
<head>
    <title><s:text name="titleList"/></title>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            addfield('param._ne_ruleid', '<s:text name="ruleid"/>', 'f', true, '14');
            addfield('param._ne_typeid', '<s:text name="typeid"/>', 'f', true, '14');
            return checkval(window);
        }
    </script>
    
    <style type="text/css"> 
	.table_style {
	width:98%;
	border:#CDCDCD solid 1px;
	border-collapse:collapse;
	}
</style>
</head>

<body class="list_body" onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<s:form action="numsortrule_listByType.do" key="formList" cssStyle="formList" theme="simple" >
	<%//下面的控件给Action提供数据，用来分页%>
	<aa:zone name="hiddenZone">
    <s:hidden name="param._orderby"/>
    <s:hidden name="param._desc"/>
    <s:hidden name="param._pageno"/>
    <s:hidden name="param._pagesize"/>
    <s:hidden name="param.queryAll"/>
    <input type="hidden" name="_rowcount" value="<s:property value="dp.rowCount" />"/>
    </aa:zone>
    <s:hidden name="param._ne_typeid"/>
    
	<div class="table_top">
		<div class="table_topleft"></div>
		<div class="table_toparea_w">
			<s:i18n name="public">
			<span class="table_toparea"><s:text name="currentPos"/> </span>
			<span class="table_toparea_xi">></span>
			<span class="table_toparea"><s:text name="resource"/> </span>
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

	<aa:zone name="listZone">
	
	
	<div class="table_div">
        <table class="table_style">
            <tr class="table_style_head">
               	<td colspan="4"><s:text name="typebaseinfo"/></td>
            </tr>
            <tr class="table_style_content" align="center" onMouseMove="this.bgColor='F0F5F9'" onMouseOut="this.bgColor='#ffffff'">	
                <td><s:text name="typeid"/>:<s:property value="numtypedef.typeid"/></td>
              	<td><s:text name="typecode"/>:<s:property value="numtypedef.typecode"/></td>
                <td><s:text name="typename"/>:<s:property value="numtypedef.typename"/></td>
                <td><s:text name="typedesc"/>:<s:property value="numtypedef.typedesc"/></td>
            </tr>
                  <tr class="table_style_content" align="center" onMouseMove="this.bgColor='F0F5F9'" onMouseOut="this.bgColor='#ffffff'">	
                     <td><s:text name="prilevel"/>:<j:code2Name code="numtypedef.prilevel" definition="$IM_NUMTYPEPRI"/></td>
                     <td><s:text name="effective"/>:<j:code2Name code="numtypedef.effective" definition="$CH_VALIDFLAG"/></td>
                     <td><s:text name="isdefault"/>:<j:code2Name code="numtypedef.isdefault" definition="$IM_YESNO10"/></td>
                     <td></td>
                 </tr>
        </table>
    </div>
    
	<br>
	<br>
	
	
    <div class="table_div">
    	
        <table class="table_style">
            <tr class="table_style_head">
                <td>
                    <s:text name="number"/>                
                </td>
                <td>
                    <s:text name="ruleexp"/>             
                </td>
                <td>
                    <s:text name="number"/>                
                </td>
                <td>
                    <s:text name="ruleexp"/>                
                </td>
            </tr>
            <s:property value="#dp.datas.size" />
          
            <s:iterator id="t" value="dp.datas" status="status" >
          <s:if test="#status.index<(dp.datas.size+1)/2">
                 <tr class="table_style_content" align="center" onMouseMove="this.bgColor='F0F5F9'" onMouseOut="this.bgColor='#ffffff'">
                     <td><s:property value="#status.count" /> </td>
                     <td><s:property value="ruleexp" /></td>
                     <td><s:property value="%{#status.count+(dp.datas.size+1)/2}" /> </td>
                     <td><s:property value="dp.datas[#status.index+(dp.datas.size+1)/2].ruleexp" /></td>                     
                 </tr>
          </s:if>       
                 
             </s:iterator> 
        </table>
     
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
