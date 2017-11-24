<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc" %>
<html>
<head>
    <title><s:text name="titleList"/></title>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            addfield('param._se_success', '<s:text name="success"/>', 'c', true, '8');
            addfield('param._se_cityid', '<s:text name="cityid"/>', 'c', true, '10');
            addfield('param._se_countyid', '<s:text name="countyid"/>', 'c', true, '14');
            addfield('param._se_comcategory', '<s:text name="comcategory"/>', 'c', true, '20');
            addfield('param._nnm_upactrate', '<s:text name="upactrate"/>', 'f', true, '16');
            addfield('param._nnl_upactrate', '<s:text name="upactrate"/>', 'f', true, '16');
            addfield('param._se_handlercode', '<s:text name="handlercode"/>', 'c', true, '16');
            return checkval(window);
        }
    </script>
</head>

<body class="list_body" onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<s:form action="resalarmrulelog_list.do" key="formList" cssStyle="formList" theme="simple" onsubmit="return ev_check();">
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

	<div class="table_div">
        <table class="table_normal">
            <tr>
                <td align="center"><s:text name="success"/>:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._se_success" />
                </td>
                <td align="center"><s:text name="cityid"/>:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._se_cityid" />
                </td>
                <td align="center"><s:text name="countyid"/>:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._se_countyid" />
                </td>
                <td align="center"><s:text name="comcategory"/>:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._se_comcategory" />
                </td>
                <td align="center"><s:text name="upactrate"/>:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._nnm_upactrate" />
                </td>
                <td align="center"><s:text name="upactrate"/>:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._nnl_upactrate" />
                </td>
                <td align="center"><s:text name="handlercode"/>:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._se_handlercode" />
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
                        value="<s:text name="button_search"/>" onClick="doQuery('/sales/resalarmrulelog_list.do');">
                	
                    <input type="button" id="btnNew" name="btnNew" class="button_New" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="<s:text name="button_new"/>" onClick="doNew('/sales/resalarmrulelog_new.do')">
                    
                    <input type="button" id="btnDelete" name="btnDelete" class="button_Delete" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="<s:text name="button_delete"/>" onClick="doDelete('/sales/resalarmrulelog_delete.do')">
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
                    <a href="javascript:doOrderby('logid')"><s:text name="logid"/></a>                 
                </td>
                <td>
                    <a href="javascript:doOrderby('optime')"><s:text name="optime"/></a>                 
                </td>
                <td>
                    <a href="javascript:doOrderby('oprcode2')"><s:text name="oprcode2"/></a>                 
                </td>
                <td>
                    <a href="javascript:doOrderby('oprtype')"><s:text name="oprtype"/></a>                 
                </td>
                <td>
                    <a href="javascript:doOrderby('success')"><s:text name="success"/></a>                 
                </td>
                <td>
                    <a href="javascript:doOrderby('recid')"><s:text name="recid"/></a>                 
                </td>
                <td>
                    <a href="javascript:doOrderby('cityid')"><s:text name="cityid"/></a>                 
                </td>
                <td>
                    <a href="javascript:doOrderby('countyid')"><s:text name="countyid"/></a>                 
                </td>
                <td>
                    <a href="javascript:doOrderby('comcategory')"><s:text name="comcategory"/></a>                 
                </td>
                <td>
                    <a href="javascript:doOrderby('lowstock')"><s:text name="lowstock"/></a>                 
                </td>
                <td>
                    <a href="javascript:doOrderby('upactrate')"><s:text name="upactrate"/></a>                 
                </td>
                <td>
                    <a href="javascript:doOrderby('handlercode')"><s:text name="handlercode"/></a>                 
                </td>
            </tr>
            <s:iterator value="dp.datas">
                 <tr class="table_style_content" align="center" onMouseMove="this.bgColor='F0F5F9'" onMouseOut="this.bgColor='#ffffff'">
					 <%-- 复合主键用“|”间隔开 --%>
                     <td>
                         <input type="checkbox" name="param._selectitem" value="<s:property value="logid"/>" onclick="checkOne();">
                     </td>
                     <td><a href='<s:url action="resalarmrulelog_edit.do">
	                         <s:param name="param._pk" value="logid"/>
	                     	</s:url>'>
							<s:property value="logid"/>
                         </a>
					 </td>
                     <td><s:property value="optime" /></td>
                     <td><s:property value="oprcode2" /></td>
                     <td><s:property value="oprtype" /></td>
                     <td><s:property value="success" /></td>
                     <td><s:property value="recid" /></td>
                     <td><s:property value="cityid" /></td>
                     <td><s:property value="countyid" /></td>
                     <td><s:property value="comcategory" /></td>
                     <td><s:property value="lowstock" /></td>
                     <td><s:property value="upactrate" /></td>
                     <td><s:property value="handlercode" /></td>
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
	ajaxAnywhere.substituteFormSubmitFunction();  
	ajaxAnywhere.substituteSubmitButtonsBehaviorByIDs(true,"btnQuery,btnDelete");
</script> 
</body>
</html>
