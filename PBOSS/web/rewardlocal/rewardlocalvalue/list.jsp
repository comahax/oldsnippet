<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc" %>
<html>
<head>
    <title><s:text name="titleList"/></title>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            addfield('param._ne_mstid', '<s:text name="mstid"/>', 'f', true, '14');
            addfield('param._ne_seq', '<s:text name="seq"/>', 'f', true, '8');
            return checkval(window);
        }
    </script>
</head>

<body class="list_body">
<div class="table_container">
<s:form action="rewardlocalvalue_list.do" key="formList" cssStyle="formList" theme="simple" onsubmit="return ev_check();">
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
			<span class="table_toparea"><s:text name="base"/> </span>
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
                <td align="center"><s:text name="mstid"/>:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._ne_mstid" />
                </td>
                <td align="center"><s:text name="seq"/>:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._ne_seq" />
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
                        value="<s:text name="button_search"/>" onClick="doQuery('/reward/rewardlocalvalue_list.do');">
                	
                    <input type="button" id="btnNew" name="btnNew" class="button_New" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="<s:text name="button_new"/>" onClick="doNew('/reward/rewardlocalvalue_new.do')">
                    
                    <input type="button" id="btnDelete" name="btnDelete" class="button_Delete" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="<s:text name="button_delete"/>" onClick="doDelete('/reward/rewardlocalvalue_delete.do')">
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
                    <a href="javascript:doOrderby('mstid')"><s:text name="mstid"/></a>                 
                </td>
                <td>
                    <a href="javascript:doOrderby('seq')"><s:text name="seq"/></a>                 
                </td>
                <td>
                    <a href="javascript:doOrderby('values')"><s:text name="values"/></a>                 
                </td>
            </tr>
            <s:iterator value="dp.datas">
                 <tr class="table_style_content" align="center" onMouseMove="this.bgColor='F0F5F9'" onMouseOut="this.bgColor='#ffffff'">
					 <%-- ���������á�|������� --%>
                     <td>
                         <input type="checkbox" name="param._selectitem" value="<s:property value="mstid + '|' + seq"/>" onclick="checkOne();">
                     </td>
                     <td><a href='<s:url action="rewardlocalvalue_edit.do">
	                         <s:param name="param._pk" value="mstid + '|' + seq"/>
	                     	</s:url>'>
							<s:property value="mstid"/>
                         </a>
					 </td>
                     <td><a href='<s:url action="rewardlocalvalue_edit.do">
	                         <s:param name="param._pk" value="mstid + '|' + seq"/>
	                     	</s:url>'>
							<s:property value="seq"/>
                         </a>
					 </td>
                     <td><s:property value="values" /></td>
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
		return "errorZone,hiddenZone,listZone";  
	}
	ajaxAnywhere.substituteFormSubmitFunction();  
	ajaxAnywhere.formURL = formList.action;
	ajaxAnywhere.substituteSubmitButtonsBehaviorByIDs(true,"btnQuery,btnDelete");
</script> 
</body>
</html>
