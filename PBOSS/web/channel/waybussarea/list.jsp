<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc" %>
<html>
<head>
    <title><s:text name="titleList"/></title>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            addfield('param._se_wayid', '<s:text name="wayid"/>', 'c', true, '18');
            return checkval(window);
        }
    </script>
</head>

<body class="list_body" onload="if(window.loadforiframe) loadforiframe();">
<s:form action="waybussarea_list.do" key="formList" cssStyle="formList" theme="simple" onsubmit="return ev_check();">
	<%//????????????Action?¨¢????????????¡¤???%>
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
			<span class="table_toparea"><s:text name="base"/> </span>
			<span class="table_toparea_xi">></span>
			</s:i18n>
			<span class="table_toparea_h"><s:text name="titleList"/></span>
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
                <td align="center"><s:text name="wayid"/>:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._se_wayid" />
                </td>
            </tr>
        </table>
    </div>
    
    <div class="table_div">
		<table class="table_normal">
			<tr> 
				<td>
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
						<tr>
	                    <td align=right>
	                    	<s:i18n name="public">
	                    	<input type="button" id="btnQuery" name="btnQuery" class="button_Query" onmouseover="buttonover(this);"
	                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
	                            value="<s:text name="button_search"/>" onClick="doQuery('/channel/waybussarea_list.do');">
	                    	
	                        <input type="button" id="btnNew" name="btnNew" class="button_New" onmouseover="buttonover(this);"
	                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
	                            value="<s:text name="button_new"/>" onClick="doNew('/channel/waybussarea_new.do')">
	                        
	                        <input type="button" id="btnDelete" name="btnDelete" class="button_Delete" onmouseover="buttonover(this);"
	                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
	                            value="<s:text name="button_delete"/>" onClick="doDelete('/channel/waybussarea_delete.do')">
	                       </s:i18n>
	                    </td>
	                    </tr>
					</table>
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
                    <j:orderByImg href="javascript:doOrderby('wayid')"><s:text name="wayid"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('totalarea')"><s:text name="totalarea"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('consultarea')"><s:text name="consultarea"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('busarea')"><s:text name="busarea"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('newbusarea')"><s:text name="newbusarea"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('termarea')"><s:text name="termarea"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('selfservarea')"><s:text name="selfservarea"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('custarea')"><s:text name="custarea"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('viparea')"><s:text name="viparea"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('bgdarea')"><s:text name="bgdarea"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('bossarea')"><s:text name="bossarea"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('publisharea')"><s:text name="publisharea"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('shopwinarea')"><s:text name="shopwinarea"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('doorheight')"><s:text name="doorheight"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('doorlength')"><s:text name="doorlength"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('backheight')"><s:text name="backheight"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('backlength')"><s:text name="backlength"/></j:orderByImg>                 
                </td>
            </tr>
            <s:iterator value="dp.datas">
                 <tr class="table_style_content" align="center" onMouseMove="this.bgColor='F0F5F9'" onMouseOut="this.bgColor='#ffffff'">
					 <%-- ?????¡Â?¨¹???¡ã|?¡À?????? --%>
                     <td>
                         <input type="checkbox" name="param._selectitem" value="<s:property value="wayid"/>" onclick="checkOne();">
                     </td>
                     <td><a href='<s:url action="waybussarea_edit.do">
	                         <s:param name="param._pk" value="wayid"/>
	                     	</s:url>'>
							<s:property value="wayid"/>
                         </a>
					 </td>
                     <td><s:property value="totalarea" /></td>
                     <td><s:property value="consultarea" /></td>
                     <td><s:property value="busarea" /></td>
                     <td><s:property value="newbusarea" /></td>
                     <td><s:property value="termarea" /></td>
                     <td><s:property value="selfservarea" /></td>
                     <td><s:property value="custarea" /></td>
                     <td><s:property value="viparea" /></td>
                     <td><s:property value="bgdarea" /></td>
                     <td><s:property value="bossarea" /></td>
                     <td><s:property value="publisharea" /></td>
                     <td><s:property value="shopwinarea" /></td>
                     <td><s:property value="doorheight" /></td>
                     <td><s:property value="doorlength" /></td>
                     <td><s:property value="backheight" /></td>
                     <td><s:property value="backlength" /></td>
                     <td>
                     </td>
                 </tr>
             </s:iterator>
        </table>
    </div></div>
    <div class="table_div">
		<%@ include file="/common/pageNav.jsp"%>
   	</div>
    </aa:zone>
</s:form>
<script language="javascript"> 
	ajaxAnywhere.getZonesToReload = function(url,submitButton) {
		return "errorZone,listZone,hiddenZone";  
	}
	ajaxAnywhere.substituteFormSubmitFunction();ajaxAnywhere.formURL = formList.action;  
	ajaxAnywhere.substituteSubmitButtonsBehaviorByIDs(true,"btnQuery,btnDelete");
</script> 
</body>
</html>
