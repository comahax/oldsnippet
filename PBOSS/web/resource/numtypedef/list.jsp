<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc" %>
<html>
<head>
    <title><s:text name="titleList"/></title>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            addfield('param._ne_typeid', '<s:text name="typeid"/>', 'f', true, '14');
            addfield('param._se_typecode', '<s:text name="typecode"/>', 'c', true, '10');
            addfield('param._ne_prilevel', '<s:text name="prilevel"/>', 'f', true, '3');
            addfield('param._ne_effective', '<s:text name="effective"/>', 'f', true, '3');
            addfield('param._ne_isdefault', '<s:text name="isdefault"/>', 'f', true, '3');
            return checkval(window);
        }
    </script>
</head>

<body class="list_body" onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<s:form action="numtypedef_list.do" key="formList" cssStyle="formList" theme="simple" onsubmit="return ev_check();">
	<%//����Ŀؼ���Action�ṩ���ݣ�������ҳ%>
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
			<span class="table_toparea"><s:text name="resource"/> </span>
			<span class="table_toparea_xi">></span>
			</s:i18n>
			<span class="table_toparea"><s:text name="titleList"/> </span>
			<span class="table_toparea_xi">></span>
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
                <td align="center"><s:text name="typeid"/>:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._ne_typeid" />
                </td>
                <td align="center"><s:text name="typecode"/>:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._se_typecode" />
                </td>
                <td align="center"><s:text name="prilevel"/>:</td>
                <td align="left">
                     <j:selector definition="$IM_NUMTYPEPRI" name="param._ne_prilevel"  cssStyle="style_input"/>
                </td>
             </tr>
             <tr>
                <td align="center"><s:text name="effective"/>:</td>
                <td align="left">
                     <j:selector definition="$CH_VALIDFLAG" condition="dictid:0,1" name="param._ne_effective"  cssStyle="style_input"/>
                </td>
                <td align="center"><s:text name="isdefault"/>:</td>
                <td align="left">
                     <j:selector definition="$IM_YESNO10" name="param._ne_isdefault"  cssStyle="style_input"/>
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
                        value="<s:text name="button_search"/>" onClick="doQuery('/resource/numtypedef_list.do');">
                	
                    <input type="button" id="btnNew" name="btnNew" class="button_New" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="<s:text name="button_new"/>" onClick="doNew('/resource/numtypedef_edit.do')">
                    
                    <input type="button" id="btnDelete" name="btnDelete" class="button_Delete" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="<s:text name="button_delete"/>" onClick="doDelete('/resource/numtypedef_delete.do')">
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
                    <j:orderByImg href="javascript:doOrderby('typeid')"><s:text name="typeid"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('typecode')"><s:text name="typecode"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('typename')"><s:text name="typename"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('typedesc')"><s:text name="typedesc"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('prilevel')"><s:text name="prilevel"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('effective')"><s:text name="effective"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('isdefault')"><s:text name="isdefault"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('typeid')"><s:text name="typerule"/></j:orderByImg>                 
                </td>
            </tr>
            <s:iterator value="dp.datas">
                 <tr class="table_style_content" align="center" onMouseMove="this.bgColor='F0F5F9'" onMouseOut="this.bgColor='#ffffff'">
					 <%-- ���������á�|������� --%>
                     <td>
                         <input type="checkbox" name="param._selectitem" value="<s:property value="typeid"/>" onclick="checkOne();">
                     </td>
                     <td><a href='<s:url action="numtypedef_edit.do">
	                         <s:param name="param._pk" value="typeid"/>
	                     	</s:url>'>
							<s:property value="typeid"/>
                         </a>
					 </td>
                     <td><s:property value="typecode" /></td>
                     <td><s:property value="typename" /></td>
                     <td><s:property value="typedesc" /></td>
                     <td><j:code2Name definition="$IM_NUMTYPEPRI" code="prilevel"/></td>
                     <td><j:code2Name definition="$CH_VALIDFLAG" code="effective"/></td>
                     <td><j:code2Name definition="$IM_YESNO10" code="isdefault"/></td>
                     <td>
                     	<a href='javascript:void();' onclick="window.open('numsortrule_listByType.do?param._ne_typeid=<s:property value="typeid"/>')">
                      		<s:text name="chicksee"/>
                      	</a>
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
	ajaxAnywhere.substituteSubmitButtonsBehaviorByIDs(true,"btnQuery,btnDelete");
</script> 
</body>
</html>
