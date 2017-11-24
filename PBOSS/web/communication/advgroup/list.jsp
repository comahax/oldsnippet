<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc" %>
<html>
<head>
    <title><s:text name="titleList"/></title>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            addfield('param._ne_groupid', '<s:text name="groupid"/>', 'f', true, '14');
            addfield('param._se_groupname', '<s:text name="groupname"/>', 'c', true, '40');
            return checkval(window);
        }
    </script>
</head>

<body class="list_body" onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<s:form action="advgroup_list.do" key="formList" cssStyle="formList" theme="simple" onsubmit="return ev_check();">
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
			<span class="table_toparea"><s:text name="communication"/> </span>
			<span class="table_toparea_xi">></span>
			</s:i18n>
			<span class="table_toparea_h"><s:text name="titleList"/></span>
			<span class="button_Help" onclick="openword('<s:text name="helpTitle"/>','<s:text name="helpContent2"/>')"><s:i18n name="public"><s:text name="help"/></s:i18n></span>
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
                <td align="center"><s:text name="groupid"/>:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._ne_groupid" />
                </td>
                <td align="center"><s:text name="groupname"/>:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._sk_groupname" />
                </td>
                <td align="center"><s:text name="groupoid"/>:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param.groupoid" />
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
                        value="<s:text name="button_search"/>" onClick="doQuery('/communication/advgroup_list.do');">
                	
                    <input type="button" id="btnNew" name="btnNew" class="button_New" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="<s:text name="button_new"/>" onClick="doNew('/communication/advgroup_new.do')">
                   </s:i18n>
                   
                   <input type="button" id="btnDelete" name="btnDelete1" class="button_4" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="<s:text name="deleteGroup"/>" onClick="doDelete('/communication/advgroup_deleteGroup.do')">
                        
                   <input type="button" id="btnDelete2" name="btnDelete2" class="button_6" onmouseover="buttonover(this);"
                   		onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                   		value="<s:text name="deleteGroupobj"/>" onClick="doDelete('/communication/advgroup_deleteGroupobj.do')">
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
                    <j:orderByImg href="javascript:doOrderby('groupid')"><s:text name="groupid"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('groupname')"><s:text name="groupname"/></j:orderByImg>                 
                </td>
            	<td>
                    <s:text name="groupobjinfo"/>   
                </td>
            </tr>
            <s:iterator value="dp.datas">
                 <tr class="table_style_content" align="center" onMouseMove="this.bgColor='F0F5F9'" onMouseOut="this.bgColor='#ffffff'">
					 <%-- 复合主键用“|”间隔开 --%>
                     <td>
                         <input type="checkbox" name="param._selectitem" value="<s:property value="groupid"/>;<s:property value="oid"/>" onclick="checkOne();">
                     </td>
                     <td><a href='<s:url action="advgroup_edit.do">
	                         <s:param name="param._pk" value="groupid"/>
	                     	</s:url>'>
							<s:property value="groupid"/>
                         </a>
					 </td>
                     <td><s:property value="groupname" /></td>
                     <td>
                     	<s:property value="oid" />&nbsp;
                     	<s:property value="oname" />
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
<script language="javascript"> 
	ajaxAnywhere.getZonesToReload = function(url,submitButton) {
		return "errorZone,listZone,hiddenZone";  
	}
	ajaxAnywhere.substituteFormSubmitFunction();ajaxAnywhere.formURL = formList.action;  
	ajaxAnywhere.substituteSubmitButtonsBehaviorByIDs(true,"btnQuery,btnDelete,btnDelete2");
</script> 
</body>
</html>
