<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc"%>
<%
    String ID_1 = "00010701";
    String ID_2 = "00010702";
    String ID_3 = "00010703";
    String ID_4 = "00010704";
%>
<html>
<head>
    <title><bean:message bundle="cardsalebusi" key="titleList"/></title>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            addfield('_ne_itemid', '<bean:message bundle="cardsalebusi" key="itemid"/>', 'f', true, '14');
            return checkval(window);
        }
        
        function doImport(url){
			formList.action = contextPath + url + "?CMD=IMPORT";
         	formList.submit();
		}
    </script>
</head>

<body onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<html:form action="/cms/cardsalebusi.do?CMD=LIST" styleId="formList" method="post" onsubmit="return ev_check();">
    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <input type="hidden" name="_rowcount" value="<c:out value='${requestScope.LIST.rowCount}' />">

    <!--##################################添加标题内容##################################################-->
    <div class="table_div">
    <table class="top_table">
    	<tr>
    		<td>
    			<bean:message bundle="cardsalebusi" key="titleList"/>
   			</td>
    	</tr>
    </table>
    </div>
    <div class="table_div">	
   		 <table width="100%" class="error_text">
    		<html:errors/><s:Msg />
    	</table>
    </div>
	<div class="table_div">
        <table class="form_table">
            <tr>
                <td height="20" align="right" class="form_table_right" nowrap="true"><bean:message bundle="cardsalebusi" key="itemid"/>:</td>
                <td class="form_table_left" nowrap>
                    <html:text styleClass="form_input_1x" property="_ne_itemid"></html:text>
                </td>
    			<td height="20" align="right" class="form_table_right" nowrap><bean:message bundle="cardsalebusi" key="opntime"/>>=:</td>
                <td class="form_table_left" nowrap>
                    <html:text styleClass="form_input_1x" property="_dnl_opntime"></html:text>
                    <input type="button" name="button2" class="clickbutton" value="..." onclick="_dnl_opntime.value=selectDatetime()">
                </td>
            	<td height="20" align="right" class="form_table_right" nowrap><bean:message bundle="cardsalebusi" key="opntime"/><=:</td>
                <td class="form_table_left" nowrap>
                    <html:text styleClass="form_input_1x" property="_dnm_opntime"></html:text>
                    <input type="button" name="button2" class="clickbutton" value="..." onclick="_dnm_opntime.value=selectDatetime()">
                </td>
            </tr>
        </table>
    </div>
	<div class="table_div">
		<table class="table_button_list">
			<tr> 
                <td align=right>
                        <s:PurChk controlid="<%=ID_1%>">
                            <input type="button" name="btnNew"  class="add" onmouseover="buttonover(this);"
                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                            value="<bean:message bundle="public" key="button_new"/>" onClick="doNew('/cms/cardsalebusi.do')">
                        </s:PurChk>
                        <s:PurChk controlid="<%=ID_2%>">
                            <input type="button" name="btnDelete" class="delete" onmouseover="buttonover(this);"
                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                            value="<bean:message bundle="public" key="button_delete"/>" onClick="doDelete('/cms/cardsalebusi.do')">
                        </s:PurChk>
						<s:PurChk controlid="<%=ID_3%>">
							<input type="button" name="btnNew" class="query" onmouseover="buttonover(this);" 
							onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)" 
							value="<bean:message bundle="cardsalebusi" key="button_imp"/>"
							onClick="doImport('/cms/cardsalebusi.do')">
						</s:PurChk>
                        <s:PurChk controlid="<%=ID_4%>">
                        <input type="button" class="query"onmouseover="buttonover(this);" onclick="doQuery();" 
                                onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                                value="<bean:message bundle="public" key="button_search"/>" />
                        </s:PurChk>
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
                    <a href="javascript:doOrderby('itemid')"><bean:message bundle="cardsalebusi" key="itemid"/></a>
                    <s:OrderImg form="/cms/cardsalebusi/cardsalebusiForm" field="itemid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('opntime')"><bean:message bundle="cardsalebusi" key="opntime"/></a>
                    <s:OrderImg form="/cms/cardsalebusi/cardsalebusiForm" field="opntime"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('mobile')"><bean:message bundle="cardsalebusi" key="mobile"/></a>
                    <s:OrderImg form="/cms/cardsalebusi/cardsalebusiForm" field="mobile"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('brand')"><bean:message bundle="cardsalebusi" key="brand"/></a>
                    <s:OrderImg form="/cms/cardsalebusi/cardsalebusiForm" field="brand"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('opntype')"><bean:message bundle="cardsalebusi" key="opntype"/></a>
                    <s:OrderImg form="/cms/cardsalebusi/cardsalebusiForm" field="opntype"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('wayid')"><bean:message bundle="cardsalebusi" key="wayid"/></a>
                    <s:OrderImg form="/cms/cardsalebusi/cardsalebusiForm" field="wayid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('retailprice')"><bean:message bundle="cardsalebusi" key="retailprice"/></a>
                    <s:OrderImg form="/cms/cardsalebusi/cardsalebusiForm" field="retailprice"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('buyprice')"><bean:message bundle="cardsalebusi" key="buyprice"/></a>
                    <s:OrderImg form="/cms/cardsalebusi/cardsalebusiForm" field="buyprice"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('discount')"><bean:message bundle="cardsalebusi" key="discount"/></a>
                    <s:OrderImg form="/cms/cardsalebusi/cardsalebusiForm" field="discount"/>
                </td>
            </tr>
            <c:forEach var="item" items="${requestScope.LIST.datas}">
                 <c:url value="/cms/cardsalebusi.do?CMD=EDIT" var="urlContent">
                     <%//this param name must "PK" %>
                     <c:param name="PK" value="${item.itemid}"/>
                     <%-- <c:param name="PK" value="'${item.id}|${item.id2}'"/> --%>
                 </c:url>
                 <tr class="table_style_content" align="center">
                     <td>
                         <input type="checkbox" name="_selectitem" value="<c:out value='${item.itemid}' />"
                                onclick="checkOne(this);" class="table_checkbox">
                     </td>
                     <td>
                         <a href='<c:out value="${urlContent}"/>'><c:out value="${item.itemid}"/></a>
                     </td>
                     <td><fmt:formatDate value="${item.opntime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                     <td><c:out value="${item.mobile}"/></td>
                     <td><s:Code2Name code="${item.brand}" definition="#BUSI_BRAND"/></td>
                     <td><s:Code2Name code="${item.opntype}" definition="#OPERATION"/></td>
                     <td><s:Code2Name code="${item.wayid}" definition="#WAY"/></td>
                     <td><c:out value="${item.retailprice}"/></td>
                     <td><c:out value="${item.buyprice}"/></td>
                     <td><c:out value="${item.discount}"/></td>
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
