<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc" %>
<html>
<head>
    <title><s:text name="titleList"/></title>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            addfield('param._se_wayid', '<s:text name="wayid"/>', 'c', true, '18');
            addfield('param._de_runtime', '<s:text name="runtime"/>', 't', true, '7');
            addfield('param._se_waytype', '<s:text name="waytype"/>', 'c', true, '4');
            return checkval(window);
        }
    </script>
</head>

<body class="list_body" onload="if(window.loadforiframe) loadforiframe();">
<s:form action="svwaycnstr_list.do" key="formList" cssStyle="formList" theme="simple" onsubmit="return ev_check();">
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
                <td align="center"><s:text name="runtime"/>:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._de_runtime" />
                </td>
                <td align="center"><s:text name="waytype"/>:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._se_waytype" />
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
	                            value="<s:text name="button_search"/>" onClick="doQuery('/channel/svwaycnstr_list.do');">
	                    	
	                        <input type="button" id="btnNew" name="btnNew" class="button_New" onmouseover="buttonover(this);"
	                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
	                            value="<s:text name="button_new"/>" onClick="doNew('/channel/svwaycnstr_new.do')">
	                        
	                        <input type="button" id="btnDelete" name="btnDelete" class="button_Delete" onmouseover="buttonover(this);"
	                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
	                            value="<s:text name="button_delete"/>" onClick="doDelete('/channel/svwaycnstr_delete.do')">
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
                    <j:orderByImg href="javascript:doOrderby('cntstarttime')"><s:text name="cntstarttime"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('runstatus')"><s:text name="runstatus"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('completetime')"><s:text name="completetime"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('runtime')"><s:text name="runtime"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('closestarttime')"><s:text name="closestarttime"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('closestoptime')"><s:text name="closestoptime"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('closetime')"><s:text name="closetime"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('staffstd')"><s:text name="staffstd"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('cntarea')"><s:text name="cntarea"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('bizarea')"><s:text name="bizarea"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('doorarea')"><s:text name="doorarea"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('windowarea')"><s:text name="windowarea"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('seatnum')"><s:text name="seatnum"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('actseatnum')"><s:text name="actseatnum"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('flexseatnum')"><s:text name="flexseatnum"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('cntcontractpath')"><s:text name="cntcontractpath"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('datatablepath')"><s:text name="datatablepath"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('dataarea')"><s:text name="dataarea"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('datanum')"><s:text name="datanum"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('datacost')"><s:text name="datacost"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('signcost')"><s:text name="signcost"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('signarea')"><s:text name="signarea"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('backarea')"><s:text name="backarea"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('backcost')"><s:text name="backcost"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('lampcost')"><s:text name="lampcost"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('vicost')"><s:text name="vicost"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('waytype')"><s:text name="waytype"/></j:orderByImg>                 
                </td>
            </tr>
            <s:iterator value="dp.datas">
                 <tr class="table_style_content" align="center" onMouseMove="this.bgColor='F0F5F9'" onMouseOut="this.bgColor='#ffffff'">
					 <%-- ?????¡Â?¨¹???¡ã|?¡À?????? --%>
                     <td>
                         <input type="checkbox" name="param._selectitem" value="<s:property value="wayid"/>" onclick="checkOne();">
                     </td>
                     <td><a href='<s:url action="svwaycnstr_edit.do">
	                         <s:param name="param._pk" value="wayid"/>
	                     	</s:url>'>
							<s:property value="wayid"/>
                         </a>
					 </td>
                     <td><s:property value="cntstarttime" /></td>
                     <td><s:property value="runstatus" /></td>
                     <td><s:property value="completetime" /></td>
                     <td><s:property value="runtime" /></td>
                     <td><s:property value="closestarttime" /></td>
                     <td><s:property value="closestoptime" /></td>
                     <td><s:property value="closetime" /></td>
                     <td><s:property value="staffstd" /></td>
                     <td><s:property value="cntarea" /></td>
                     <td><s:property value="bizarea" /></td>
                     <td><s:property value="doorarea" /></td>
                     <td><s:property value="windowarea" /></td>
                     <td><s:property value="seatnum" /></td>
                     <td><s:property value="actseatnum" /></td>
                     <td><s:property value="flexseatnum" /></td>
                     <td><s:property value="cntcontractpath" /></td>
                     <td><s:property value="datatablepath" /></td>
                     <td><s:property value="dataarea" /></td>
                     <td><s:property value="datanum" /></td>
                     <td><s:property value="datacost" /></td>
                     <td><s:property value="signcost" /></td>
                     <td><s:property value="signarea" /></td>
                     <td><s:property value="backarea" /></td>
                     <td><s:property value="backcost" /></td>
                     <td><s:property value="lampcost" /></td>
                     <td><s:property value="vicost" /></td>
                     <td><s:property value="waytype" /></td>
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
