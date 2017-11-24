<%@ page language="java" contentType="text/html;charset=GBK"%>
<jsp:include page="/inc/acl.jsp">
  <jsp:param name="PID" value="4D1A1A" />
</jsp:include>
<%@ include file="/inc/listhead.inc" %>
<html>
<head>
    <title><bean:message bundle="cooperrater" key="title"/></title>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
			addfield('_se_code', '<bean:message bundle="cooperrater" key="code"/>', 'c', true, 20);
            addfield('_se_name', '<bean:message bundle="cooperrater" key="name"/>', 'c', true, 30);
            addfield('_se_linkman', '<bean:message bundle="cooperrater" key="linkman"/>', 'c', true, 15);
            addfield('_se_telcode', '<bean:message bundle="cooperrater" key="telcode"/>', 'c', true, 15);
            return checkval(window);
        } 
    </script>
</head>
<body onload="loadforiframe();">
<div class="table_container">
<html:form action="/fee/woff/cooperrater.do?CMD=LIST" styleId="formList" method="post" onsubmit="return ev_check();">
    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <input type="hidden" name="_rowcount" value="<c:out value='${requestScope.LIST.rowCount}' />">

	
	<div class="table_div">		
		<table class="top_table">
			<tr> 
				<td><bean:message bundle="cooperrater" key="title"/></td>
				
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
                <td class="form_table_right"><bean:message bundle="cooperrater" key="code"/>: </td>
                <td class="form_table_left"> 
                    <html:text styleClass="form_input_1x" property="_se_code"></html:text>
                </td>        
               
                       
                <td class="form_table_right"><bean:message bundle="cooperrater" key="name"/>: </td>
                <td class="form_table_left"> 
                    
                    <html:text styleClass="form_input_1x" property="_se_name"></html:text>
                </td>         
            </tr> 
            <tr>
                <td class="form_table_right"><bean:message bundle="cooperrater" key="linkman"/>: </td>
                <td class="form_table_left"> 
                    <html:text styleClass="form_input_1x" property="_se_linkman"></html:text>
                </td>        
               
                       
                <td class="form_table_right"><bean:message bundle="cooperrater" key="telcode"/>: </td>
                <td class="form_table_left"> 
                    
                    <html:text styleClass="form_input_1x" property="_se_telcode"></html:text>
                </td>         
            </tr>     
        </table>
    </div>	
	<div class="table_div">		
		<table class="table_button_list">
			<tr>
			   <td>
                        <input type="button" name="btnNew"  class="add" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="<bean:message bundle="public" key="button_new"/>" onClick="doNew('/fee/woff/cooperrater.do')">
                        <input type="button" name="btnDelete" class="delete" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="<bean:message bundle="public" key="button_delete"/>" onClick="doDelete('/fee/woff/cooperrater.do')">
                  <input type="button" class="query" onmouseover="buttonover(this);" 
                                onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                                value="<bean:message bundle="public" key="button_search"/>" onclick="doQuery()"/>
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
                    <a href="javascript:doOrderby('code')"><bean:message bundle="cooperrater" key="code"/></a>
                    <s:OrderImg form="/fee/woff/cooperrater/CooperraterForm" field="code"/>
                </td>
                <td>
                     <a href="javascript:doOrderby('name')"><bean:message bundle="cooperrater" key="name"/></a>
                    <s:OrderImg form="/fee/woff/cooperrater/CooperraterForm" field="name"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('linkman')"><bean:message bundle="cooperrater" key="linkman"/></a>
                    <s:OrderImg form="/fee/woff/cooperrater/CooperraterForm" field="linkman"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('telcode')"><bean:message bundle="cooperrater" key="telcode"/></a>
                    <s:OrderImg form="/fee/woff/cooperrater/CooperraterForm" field="telcode"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('masterid')"><bean:message bundle="cooperrater" key="masterid"/></a>
                    <s:OrderImg form="/fee/woff/cooperrater/CooperraterForm" field="masterid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('address')"><bean:message bundle="cooperrater" key="address"/></a>
                    <s:OrderImg form="/fee/woff/cooperrater/CooperraterForm" field="address"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('memo')"><bean:message bundle="cooperrater" key="memo"/></a>
                    <s:OrderImg form="/fee/woff/cooperrater/CooperraterForm" field="memo"/>
                </td>
            </tr>
            <c:forEach var="item" items="${requestScope.LIST.datas}">
                 <c:url value="/fee/woff/cooperrater.do?CMD=EDIT" var="urlContent">
                     <c:param name="PK" value="${item.code}"/>
                 </c:url>
                 <tr class="table_style_content" align="center">
                     <td>
                         <input type="checkbox" name="_selectitem" value="<c:out value='${item.code}' />"
                                onclick="checkOne();" class="table_checkbox">
                     </td>
                      <td>
                         <a href='<c:out value="${urlContent}"/>'><c:out value="${item.code}"/></a>
                     </td>
                     <td><c:out value="${item.name}"/></td>
                     <td><c:out value="${item.linkman}"/></td>
                     <td><c:out value="${item.telcode}"/></td>
                     <td><c:out value="${item.masterid}"/></td>
                     <td><c:out value="${item.address}"/></td>
                     <td><c:out value="${item.memo}"/></td>
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
