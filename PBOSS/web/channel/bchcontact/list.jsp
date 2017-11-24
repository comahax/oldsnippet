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
<s:form action="bchcontact_list.do" key="formList" cssStyle="formList" theme="simple" onsubmit="return ev_check();">
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
	                            value="<s:text name="button_search"/>" onClick="doQuery('/channel/bchcontact_list.do');">
	                    	
	                        <input type="button" id="btnNew" name="btnNew" class="button_New" onmouseover="buttonover(this);"
	                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
	                            value="<s:text name="button_new"/>" onClick="doNew('/channel/bchcontact_new.do')">
	                        
	                        <input type="button" id="btnDelete" name="btnDelete" class="button_Delete" onmouseover="buttonover(this);"
	                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
	                            value="<s:text name="button_delete"/>" onClick="doDelete('/channel/bchcontact_delete.do')">
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
                    <j:orderByImg href="javascript:doOrderby('principal')"><s:text name="principal"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('principaltel')"><s:text name="principaltel"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('principalemail')"><s:text name="principalemail"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('principalphone')"><s:text name="principalphone"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('linkman')"><s:text name="linkman"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('linkmantel')"><s:text name="linkmantel"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('linkmanemail')"><s:text name="linkmanemail"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('hotline')"><s:text name="hotline"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('fax')"><s:text name="fax"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('address')"><s:text name="address"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('zipcode')"><s:text name="zipcode"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('bailtype')"><s:text name="bailtype"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('servbound')"><s:text name="servbound"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('coplevel')"><s:text name="coplevel"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('busnum')"><s:text name="busnum"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('certitype')"><s:text name="certitype"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('certinum')"><s:text name="certinum"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('regadress')"><s:text name="regadress"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('regcapital')"><s:text name="regcapital"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('company')"><s:text name="company"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('provcode')"><s:text name="provcode"/></j:orderByImg>                 
                </td>
            </tr>
            <s:iterator value="dp.datas">
                 <tr class="table_style_content" align="center" onMouseMove="this.bgColor='F0F5F9'" onMouseOut="this.bgColor='#ffffff'">
					 <%-- ?????¡Â?¨¹???¡ã|?¡À?????? --%>
                     <td>
                         <input type="checkbox" name="param._selectitem" value="<s:property value="wayid"/>" onclick="checkOne();">
                     </td>
                     <td><a href='<s:url action="bchcontact_edit.do">
	                         <s:param name="param._pk" value="wayid"/>
	                     	</s:url>'>
							<s:property value="wayid"/>
                         </a>
					 </td>
                     <td><s:property value="principal" /></td>
                     <td><s:property value="principaltel" /></td>
                     <td><s:property value="principalemail" /></td>
                     <td><s:property value="principalphone" /></td>
                     <td><s:property value="linkman" /></td>
                     <td><s:property value="linkmantel" /></td>
                     <td><s:property value="linkmanemail" /></td>
                     <td><s:property value="hotline" /></td>
                     <td><s:property value="fax" /></td>
                     <td>
                     	<span STYLE="overflow:hidden; text-overflow:ellipsis; white-space:nowrap;width:300px" title="<s:property value="address" />"/>
                     		<s:property value="address" />
                     	</span>
                     </td>
                     <td><s:property value="zipcode" /></td>
                     <td><s:property value="bailtype" /></td>
                     <td><s:property value="servbound" /></td>
                     <td><s:property value="coplevel" /></td>
                     <td><s:property value="busnum" /></td>
                     <td><s:property value="certitype" /></td>
                     <td><s:property value="certinum" /></td>
                     <td><span STYLE="overflow:hidden; text-overflow:ellipsis; white-space:nowrap;width:300px" title="<s:property value="regadress" />"/>
                     		<s:property value="regadress" />
                     	</span></td>
                     <td><s:property value="regcapital" /></td>
                     <td><s:property value="company" /></td>
                     <td><s:property value="provcode" /></td>
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
