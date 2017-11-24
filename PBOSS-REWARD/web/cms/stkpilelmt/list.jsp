<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc" %>
<jsp:include page="/inc/acl.jsp">
  <jsp:param name="PID" value="2B6F1A" />
</jsp:include>
<%
    //Ò³Ãæ¿ØÖÆµã?
    String ID_1 = "2B6F1ABT1";
    String ID_2 = "2B6F1ABT2";
    String ID_3 = "2B6F1ABT3";
%>
<html>
<head>
    <title><bean:message bundle="stkpilelmt" key="title"/></title>
    <script type="text/javascript" src="<%= contextPath %>/js/bus/waycommon.js"></script>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            addfield('_sk_wayid', '<bean:message bundle="stkpilelmt" key="_sk_wayid"/>', 'c', true, 18);
            addfield('_ne_lesatlimit', '<bean:message bundle="stkpilelmt" key="_ne_lesatlimit"/>', 'i', true, 8);
            addfield('_ne_mostlimit', '<bean:message bundle="stkpilelmt" key="_ne_mostlimit"/>', 'i', true, 8);
            return checkval(window);
        }
		
		function doQuery(cmdQuery) {
			if (ev_check()) {
				formList.action = contextPath + cmdQuery;
    			formList.submit();
    		}
    		return false;
		}
		
		function doReset() {
			formList._sk_wayid.value = "";
			formList._ne_resourcetype.value = "";
		}
    </script>
</head>

<body onload="document.formList._sk_wayid.focus();">
<div class="table_container">

<html:form action="/cms/stkpilelmt.do?CMD=LIST" styleId="formList" method="post" onsubmit="return ev_check();">
    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>   
    <input type="hidden" name="_rowcount" value="<c:out value='${requestScope.LIST.rowCount}' />">
    
	<div class="table_div">
		<table class="top_table">
			<tr> 
				<td>
					<bean:message bundle="stkpilelmt" key="subtitle"/>
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
                <td width="126" height="20" align="right" class="form_table_right">
                	<bean:message bundle="stkpilelmt" key="_sk_wayid"/>:
                </td>
                <td class="form_table_left">
                    <html:text styleClass="form_in_1x" property="_sk_wayid" onclick="showSelectWay(this)" readonly="true"></html:text>
                </td>
                <td width="126" height="20" align="right" class="form_table_right">
                	<bean:message bundle="stkpilelmt" key="_ne_resourcetype"/>:
               	</td>
                <td class="form_table_left">
                    <html:select property="_ne_resourcetype" styleClass="form_select_on">
						<option value=""></option>
                    	<s:Options definition="$IM_RESOURCETYPE"/>
                    </html:select>
                </td>
            </tr>
            <tr>
                <td width="126" height="20" align="right" class="form_table_right">
                	<bean:message bundle="stkpilelmt" key="_ne_lesatlimit"/>:
                </td>
                <td class="form_table_left">
                    <html:text styleClass="form_in_1x" property="_ne_lesatlimit"></html:text>
                </td>
                <td width="126" height="20" align="right" class="form_table_right">
                	<bean:message bundle="stkpilelmt" key="_ne_mostlimit"/>:
               	</td>
                <td class="form_table_left">
                    <html:text styleClass="form_in_1x" property="_ne_mostlimit"></html:text>
                </td>
             </tr>
        </table>
    </div>
	
	<div class="table_div">
		<table width="100%" class="table_button_list" border="0" cellspacing="0" cellpadding="0" ID="Table3">
			<tr>
            	<td align=right>
                	<s:PurChk controlid="<%=ID_1%>">
                        <input type="button" name="btnQuery" class="query" value="<bean:message bundle="public" key="button_search"/>" onclick="doQuery('/cms/stkpilelmt.do?CMD=LIST');" />
                    </s:PurChk>
                    <s:PurChk controlid="<%=ID_2%>">
                           	<input type="button" name="btnNew" class="add" value="<bean:message bundle="public" key="button_new"/>" onClick="doNew('/cms/stkpilelmt.do');">
                       	</s:PurChk>
                    <s:PurChk controlid="<%=ID_3%>">
                        <input type="button" name="btnDelete" class="delete" value="<bean:message bundle="public" key="button_delete"/>" onclick="doDelete('/cms/stkpilelmt.do');" />
                    </s:PurChk>
               </td>
            </tr>
		</table>
	</div>

    <div class="table_div">
      <div class="table_LongTable">
        <table class="table_style" ID="Table2">
            <tr class="table_style_head">
            	<td nowrap title="<bean:message bundle="public" key="list_title_select"/>">
                    <input type="checkbox" name="allbox" onclick="checkAll();" class="table_checkbox">
                </td>
                <td nowrap>
                    <a href="javascript:doOrderby('id')"><bean:message bundle="stkpilelmt" key="id"/></a>
                    <s:OrderImg form="/cms/stkpilelmt/StkpilelmtForm" field="id"/>
                </td>
                <td nowrap>
                    <a href="javascript:doOrderby('wayid')"><bean:message bundle="stkpilelmt" key="wayid"/></a>
                    <s:OrderImg form="/cms/stkpilelmt/StkpilelmtForm" field="wayid"/>
                </td>
                <td nowrap><bean:message bundle="stkpilelmt" key="resourcetype"/></td>
                <td nowrap><bean:message bundle="stkpilelmt" key="lesatlimit"/></td>
                <td nowrap><bean:message bundle="stkpilelmt" key="mostlimit"/></td>
            </tr>
            <c:forEach var="item" items="${requestScope.LIST.datas}">
                 <c:url value="/cms/stkpilelmt.do?CMD=EDIT" var="urlContent">
                     <c:param name="PK" value="${item.id}"/>
                 </c:url>
                 <tr class="table_style_content" align="center">
                 	 <td>
                         <input type="checkbox" name="_selectitem" value="<c:out value='${item.id}' />"
                                onclick="checkOne();" class="table_checkbox">
                     </td>
                     <td>
                         <a href='<c:out value="${urlContent}"/>'><c:out value="${item.id}"/></a>
                     </td>
                     <td><c:out value="${item.wayid}"/></td>
                     <td><s:Code2Name code="${item.resourcetype}" definition="$IM_RESOURCETYPE"/></td>                    
                     <td><c:out value="${item.lesatlimit}"/></td>
                     <td><c:out value="${item.mostlimit}"/></td>
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
