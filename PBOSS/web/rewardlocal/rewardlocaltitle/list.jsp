<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc" %>
<html>
<head>
    <title><s:text name="titleList"/></title>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            addfield('param._se_rpttype', '<s:text name="rpttype"/>', 'c', true, '32');
            addfield('param._ne_seq', '<s:text name="seq"/>', 'f', true, '8');
            addfield('param._ne_titleno', '<s:text name="titleno"/>', 'f', true, '8');
            addfield('param._sk_titlename', '<s:text name="titlename"/>', 'c', true, '256');
            return checkval(window);
        }
    </script>
</head>

<body class="list_body">
<div class="table_container">
<s:form action="rewardlocaltitle_list.do" key="formList" cssStyle="formList" theme="simple" onsubmit="return ev_check();">
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
                <td align="center"><s:text name="rpttype"/>:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._se_rpttype" />
                </td>
                <td align="center"><s:text name="seq"/>:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._ne_seq" />
                </td>
                <td align="center"><s:text name="titleno"/>:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._ne_titleno" />
                </td>
                <td align="center"><s:text name="titlename"/>:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._sk_titlename" />
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
                        value="<s:text name="button_search"/>" onClick="doQuery('/reward/rewardlocaltitle_list.do');">
                	
                    <input type="button" id="btnNew" name="btnNew" class="button_New" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="<s:text name="button_new"/>" onClick="doNew('/reward/rewardlocaltitle_new.do')">
                    
                    <input type="button" id="btnDelete" name="btnDelete" class="button_Delete" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="<s:text name="button_delete"/>" onClick="doDelete('/reward/rewardlocaltitle_delete.do')">
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
                    <a href="javascript:doOrderby('rewardmonth')"><s:text name="rewardmonth"/></a>                 
                </td>
                <td>
                    <a href="javascript:doOrderby('rpttype')"><s:text name="rpttype"/></a>                 
                </td>
                <td>
                    <a href="javascript:doOrderby('seq')"><s:text name="seq"/></a>                 
                </td>
                <td>
                    <a href="javascript:doOrderby('titleno')"><s:text name="titleno"/></a>                 
                </td>
                <td>
                    <a href="javascript:doOrderby('subno')"><s:text name="subno"/></a>                 
                </td>
                <td>
                    <a href="javascript:doOrderby('titlename')"><s:text name="titlename"/></a>                 
                </td>
                <td>
                    <a href="javascript:doOrderby('subtitlename')"><s:text name="subtitlename"/></a>                 
                </td>
            </tr>
            <s:iterator value="dp.datas">
                 <tr class="table_style_content" align="center" onMouseMove="this.bgColor='F0F5F9'" onMouseOut="this.bgColor='#ffffff'">
					 <%-- 复合主键用“|”间隔开 --%>
                     <td>
                         <input type="checkbox" name="param._selectitem" value="<s:property value="rewardmonth + '|' + rpttype"/>" onclick="checkOne();">
                     </td>
                     <td><a href='<s:url action="rewardlocaltitle_edit.do">
	                         <s:param name="param._pk" value="rewardmonth + '|' + rpttype"/>
	                     	</s:url>'>
							<s:property value="rewardmonth"/>
                         </a>
					 </td>
                     <td><a href='<s:url action="rewardlocaltitle_edit.do">
	                         <s:param name="param._pk" value="rewardmonth + '|' + rpttype"/>
	                     	</s:url>'>
							<s:property value="rpttype"/>
                         </a>
					 </td>
                     <td><s:property value="seq" /></td>
                     <td><s:property value="titleno" /></td>
                     <td><s:property value="subno" /></td>
                     <td><s:property value="titlename" /></td>
                     <td><s:property value="subtitlename" /></td>
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
