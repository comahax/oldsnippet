<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc" %>
<%
	String ID_1 = "CH_BUSICIRCLE_PRO";
%>
<html>
<head>
    <title><s:text name="titleList"/></title>
</head>

<body class="list_body" onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<s:form action="busicircle_list.do" key="formList" cssStyle="formList" theme="simple" onsubmit="return ev_check();">
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
                <td align="center"><s:text name="buscno"/>:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._se_buscno" />
                </td>
                
                <td align="center"><s:text name="buscname"/>:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._sk_buscname" />
                </td>
             </tr>
             <tr> 
                <td align="center"><s:text name="buscelevel"/>:</td>
                <td align="left">
                    <j:selector name="param._se_buscelevel" definition="$CH_BUSCLEVEL"/>
                </td> 
                 <td align="center"><s:text name="cityid"/>:</td>
                <td align="left">
                	<j:purChk permid="CH_BUSICIRCLE_PRO" disableChild="true">
                    	<j:selector definition="#CITYCOMPANY" name="param._se_cityid"
							mode="selector" condition="citycompid:${dBAccessUser.cityid }"
							value="${dBAccessUser.cityid }" />
					</j:purChk>
                </td>
               
             </tr>
             <tr>  
                
                <td align="center"><s:text name="countyid" />:</td>
				<td align="left">
					<j:selector definition="#CNTYCOMPANY" name="param._se_countyid" condition="citycompid:${dBAccessUser.cityid }"/>
				</td>
				 <td align="center"><s:text name="createtime"/>>=:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._dnl_createtime" onclick="selectDatetime();"/>
                </td>
            </tr>
            <tr>   
                <td align="center"><s:text name="createtime"/><=:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._dnm_createtime" onclick="selectDatetime();"/>
                </td>
                <td colspan="2">&nbsp;</td>
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
                        value="<s:text name="button_search"/>" onClick="doQuery('/channel/busicircle_list.do');">
                	
                    <input type="button" id="btnNew" name="btnNew" class="button_New" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="<s:text name="button_new"/>" onClick="doNew('/channel/busicircle_new.do')"
                        <s:if test="has_right != 'true'">disabled="true"</s:if>
                        >
                    
                    <input type="button" id="btnDelete" name="btnDelete" class="button_Delete" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="<s:text name="button_delete"/>" onClick="doDelete('/channel/busicircle_delete.do')"
                        <s:if test="has_right != 'true'">disabled="true"</s:if>
                        >
                        
                   <input type="button" id="btnbtnBatch" name="btnbtnBatch" class="button_4" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="批量导入" onClick="doImport();"
                        <s:if test="has_right != 'true'">disabled="true"</s:if>
                        >
                        
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
                    <j:orderByImg href="javascript:doOrderby('buscno')"><s:text name="buscno"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('buscname')"><s:text name="buscname"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('buscelevel')"><s:text name="buscelevel"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('countyid')"><s:text name="countyid"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('cityid')"><s:text name="cityid"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('buscaddr')"><s:text name="buscaddr"/></j:orderByImg>                 
                </td> 
                <td>
                    <j:orderByImg href="javascript:doOrderby('createtime')"><s:text name="createtime"/></j:orderByImg>                 
                </td>
            </tr>
            <s:iterator value="dp.datas">
                 <tr class="table_style_content" align="center" onMouseMove="this.bgColor='F0F5F9'" onMouseOut="this.bgColor='#ffffff'">
					 <%-- 复合主键用“|”间隔开 --%>
                     <td>
                         <input type="checkbox" name="param._selectitem" value="<s:property value="buscno"/>" onclick="checkOne();">
                     </td>
                     <td ><s:if test="has_right == 'true'">
                     		<a href='<s:url action="busicircle_edit.do">
		                         <s:param name="param._pk" value="buscno"/>
		                     	</s:url>'>
								<s:property value="buscno"/>
	                         </a>
                         </s:if>
                         <s:if test="has_right != 'true'">
                         	<s:property value="buscno" />
                         </s:if>
					 </td>
                     <td><s:property value="buscname" /></td>
                     <td><j:code2Name code="buscelevel" definition="$CH_BUSCLEVEL" /></td>
                     <td><j:code2Name code="countyid" definition="#CNTYCOMPANY" /></td>
                     <td><j:code2Name code="cityid" definition="#CITYCOMPANY" /></td>
                     <td><s:property value="buscaddr" /></td> 
                     <td><s:date name="createtime" format="yyyy-MM-dd HH:mm:ss "/></td>
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
		function doImport(){			
			formList.action = "<%=contextPath%>/channel/busicircle/batch.jsp";
      		formList.submit();
		}
</script>
