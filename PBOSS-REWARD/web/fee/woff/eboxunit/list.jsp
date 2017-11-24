<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc" %>
<%
    String ID_1 = "EBOXUNIT_CREATED";  //add
    String ID_2 = "EBOXUNIT_UPDATE";   //update 
    String ID_3 = "EBOXUNIT_DESTROY";       //delete
%>
<html>
<head>
    <title><bean:message bundle="eboxunit" key="titleList"/></title>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
        	addfield('_ne_eboxunitid', '<bean:message bundle="eboxunit" key="eboxunitid"/>', 'l', true, 14);
            addfield('_sk_eboxunitname', '<bean:message bundle="eboxunit" key="eboxunitname"/>', 'c', true, 256);
            addfield('_sk_eboxunittype', '<bean:message bundle="eboxunit" key="eboxunittype"/>', 'i', true, 3);
            addfield('_sk_eboxunitstate', '<bean:message bundle="eboxunit" key="eboxunitstate"/>', 'i', true, 1);
            return checkval(window);
        }
    </script>
</head>

<body onload="document.formList._sk_eboxunitname.focus();loadforiframe();">
<div class="table_container">
<html:form action="/fee/woff/eboxunit.do?CMD=LIST" styleId="formList" method="post" onsubmit="return ev_check();">
    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <html:hidden property="startindex"/>
    <html:hidden property="endindex"/>
    <input type="hidden" name="_rowcount" value="<c:out value='${requestScope.LIST.rowCount}' />">
	
	<div class="table_div">	
		<table class="top_table">
			<tr> 
				<td><bean:message bundle="eboxunit" key="custMsg"/></td>
            </tr>
        </table>
    </div>   
    <div class="table_div">
		<table class="error_text">
			<html:errors />
			<s:Msg />
		</table>
	</div>
	
	<div class="table_div">
        <table class="form_table">
            <tr>
                <td class="form_table_right"><bean:message bundle="eboxunit" key="eboxunitid"/>:</td>
                <td class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_ne_eboxunitid" maxlength="14"></html:text>
                </td>
                <td class="form_table_right"><bean:message bundle="eboxunit" key="eboxunitname"/>:</td>
                <td class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_sk_eboxunitname" maxlength="256"></html:text>
                </td>
            </tr>
            <tr>
            	<td class="form_table_right"><bean:message bundle="eboxunit" key="eboxunitstate"/>:</td>
                <td class="form_table_left">
                    <html:select property="_sk_eboxunitstate">
                    	<html:option value=""></html:option>
                    	<s:Options definition="$IB_USABLEFLAG" nameOnly="false"/>
                    </html:select>
                </td>	
                <td class="form_table_right"><bean:message bundle="eboxunit" key="eboxunittype"/>:</td>
                <td class="form_table_left">
                    <html:select property="_sk_eboxunittype">
                    	<html:option value=""></html:option>
                    	<s:Options definition="$IB_EBOXUNITTYPE" nameOnly="false"/>
                    </html:select>
                </td>
            </tr>
        </table>
    </div>

	<div class="table_div">
		<table class="table_button_list">
			<tr>
			   <td>  
                 	<s:PurChk2 controlid="<%=ID_1%>"  >
                            <input type="button" name="btnNew"  class="add" onmouseover="buttonover(this);"
                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                            value="<bean:message bundle="public" key="button_new"/>" onClick="doNew('/fee/woff/eboxunit.do')">
                  </s:PurChk2>
                    <s:PurChk2 controlid="<%=ID_3%>" >
                            <input type="button" name="btnDelete" class="delete" onmouseover="buttonover(this);"
                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                            value="<bean:message bundle="public" key="button_delete"/>" onClick="doDelete('/fee/woff/eboxunit.do')">
                    </s:PurChk2>
                 	<input type="button" class="query" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="<bean:message bundle="public" key="button_search"/>" onclick="doQuery()"/>
                 	
                 	<input type="button" class="query" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="<bean:message bundle="public" key="button_export"/>" onclick="doExcelOut('/fee/woff/eboxunit.do?CMD=EXCELOUT')"/>
  
                 </td> 	
			</tr>
		</table>
	</div>
	
    <div class="table_div">
    <div class="table_LongTable">
        <table class="table_style" ID="Table2">
            <tr class="table_style_head">
                <td title="<bean:message bundle="public" key="list_title_select"/>">
                    <input type="checkbox" name="allbox" onclick="checkAll();" class="table_checkbox">
                </td>
                <td>
                    <a href="javascript:doOrderby('eboxunitid')"><bean:message bundle="eboxunit" key="eboxunitid"/></a>
                    <s:OrderImg form="/fee/woff/eboxunit/EBoxUnitForm" field="eboxunitid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('eboxunitname')"><bean:message bundle="eboxunit" key="eboxunitname"/></a>
                    <s:OrderImg form="/fee/woff/eboxunit/EBoxUnitForm" field="eboxunitname"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('eboxunittype')"><bean:message bundle="eboxunit" key="eboxunittype"/></a>
                    <s:OrderImg form="/fee/woff/eboxunit/EBoxUnitForm" field="eboxunittype"/>
                </td>
                <td><bean:message bundle="eboxunit" key="eboxunitstate"/></td>
                <td><bean:message bundle="eboxunit" key="canwithd"/></td>
                <td><bean:message bundle="eboxunit" key="canprintinv"/></td>
                
                <td><bean:message bundle="eboxunit" key="isneedpayway"/></td>
                <td><bean:message bundle="eboxunit" key="canjiezhuan"/></td>
                <td><bean:message bundle="eboxunit" key="iscommon"/></td>     
                <td><bean:message bundle="eboxunit" key="canwoff"/></td>
                <td><bean:message bundle="eboxunit" key="woffpri"/></td>
                <td><bean:message bundle="eboxunit" key="canpaybehalf"/></td>
                 <td><bean:message bundle="eboxunit" key="brand"/></td>
            </tr>
            <c:forEach var="item" items="${requestScope.LIST.datas}">
                 <c:url value="/fee/woff/eboxunit.do?CMD=EDIT" var="urlContent">
                     <c:param name="PK" value="${item.eboxunitid}"/>
                 </c:url>
                 <tr class="table_style_content" align="center">
                     <td>
                         <input type="checkbox" name="_selectitem" value="<c:out value='${item.eboxunitid}' />"
                                onclick="checkOne();" class="table_checkbox">
                     </td>
                     <td>
                     <s:PurChk2 controlid="<%=ID_2%>" disableChild="true">
                         <a href='<c:out value="${urlContent}"/>'><c:out value="${item.eboxunitid}"/></a>
                      </s:PurChk2>
                     </td>
                     <td>
                     <s:PurChk2 controlid="<%=ID_2%>" disableChild="true">
                         <a href='<c:out value="${urlContent}"/>'><c:out value="${item.eboxunitname}"/></a>
                      </s:PurChk2>
                     </td>
                     <td><c:out value="${item.eboxunittype}"/>&nbsp;<s:Code2Name code="${item.eboxunittype}" definition="$IB_EBOXUNITTYPE"/></td>
					 <td><c:out value="${item.eboxunitstate}"/>&nbsp;<s:Code2Name code="${item.eboxunitstate}" definition="$IB_USABLEFLAG"/></td>
                     <td><c:out value="${item.canwithd}"/>&nbsp;<s:Code2Name code="${item.canwithd}" definition="$IM_YESNO10"/></td>
                     <td><c:out value="${item.canprintinv}"/>&nbsp;<s:Code2Name code="${item.canprintinv}" definition="$IM_YESNO10"/></td>

                     <td><c:out value="${item.isneedpayway}"/>&nbsp;<s:Code2Name code="${item.isneedpayway}" definition="$IM_YESNO10"/></td>
    			     <td><c:out value="${item.canjiezhuan}"/>&nbsp;<s:Code2Name code="${item.canjiezhuan}" definition="$IM_YESNO10"/></td>
					 <td><c:out value="${item.iscommon}"/>&nbsp;<s:Code2Name code="${item.iscommon}" definition="$IB_ISCOMMON"/></td>
    				 <td><c:out value="${item.canwoff}"/>&nbsp;<s:Code2Name code="${item.canwoff}" definition="$IM_YESNO10"/></td>
    				 <td><c:out value="${item.woffpri}"/></td>
    				 <td><c:out value="${item.canpaybehalf}"/>&nbsp;<s:Code2Name code="${item.canpaybehalf}" definition="$IM_YESNO10"/></td>
    				  <td><s:Code2Name code="${item.brand}" definition="$ProductBrand"/></td>
                 </tr>
             </c:forEach>
        </table>
    </div>
    </div>
    
   <div class="table_div">
		<s:PageNav dpName="LIST"/>
   </div>
   
</html:form>
</div>
</body>
</html>
