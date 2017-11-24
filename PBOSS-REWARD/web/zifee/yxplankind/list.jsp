<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc" %>
<jsp:include page="/inc/acl.jsp">
  <jsp:param name="PID" value="3C2B4DBB" />
</jsp:include>
<%
    String ID_1 = "3C2B4DBBBT1";
    String ID_2 = "3C2B4DBBBT2";
    String ID_3 = "3C2B4DBBBT3";
%>
<html>
<head>
    <title><bean:message bundle="yxplankind" key="titleList"/></title>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            addfield('_sk_yxplankindname', '<bean:message bundle="yxplankind" key="yxplankindname"/>', 'c', true, 20);            
            return checkval(window);
        }
        
        function doReturn(cmdReturn) {
		    formList.action = contextPath + cmdReturn;
		    formList.submit();
		}
    </script>
</head>

<body onload="document.formList._sk_yxplankindname.focus()">
<div class="table_container">
<html:form action="/zifee/yxplankind.do?CMD=LIST" styleId="formList" method="post" onsubmit="return ev_check();">
    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <input type="hidden" name="_rowcount" value="<c:out value='${requestScope.LIST.rowCount}' />">
	<div class="table_div">
				<table class="top_table">
					<tr>
						<td>
							<bean:message bundle="yxplantype" key="titleplankind"/>
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
                <td width="126" height="20" align="right" class="form_table_right"><bean:message bundle="yxplankind" key="yxplankindname"/>:</td>
                <td class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_sk_yxplankindname"></html:text>
                </td>                
            </tr>
        </table>
    </div>
	<div class="table_div">
				<table class="table_button_list">
					<tr>
						<td>
                        <s:PurChk controlid="<%=ID_1%>">
                            <input type="button" name="btnNew"  class="add" onmouseover="buttonover(this);"
                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                            value="<bean:message bundle="public" key="button_new" />" onClick="doNew('/zifee/yxplankind.do')">
                        </s:PurChk>
                        <s:PurChk controlid="<%=ID_2%>">
                            <input type="button" name="btnDelete" class="delete" onmouseover="buttonover(this);"
                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                            value="<bean:message bundle="public" key="button_delete"/>" onClick="doDelete('/zifee/yxplankind.do')">
                        </s:PurChk>
                        <s:PurChk controlid="<%=ID_3%>">
                        <input type="button" class="query"onmouseover="buttonover(this);"
                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                            value="<bean:message bundle="public" key="button_search"/>" onClick="doQuery();"/> 
                        <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
                           name="btnReturn" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<bean:message bundle="public" key="button_return"/>" class="close"
                           onclick="doReturn('/zifee/yxplantype.do?CMD=LIST')">
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
                    <a href="javascript:doOrderby('yxplankindid')"><bean:message bundle="yxplankind" key="yxplankindid"/></a>
                    <s:OrderImg form="/zifee/yxplankind/YxPlanKindForm" field="yxplankindid"/>
                </td>
                <td>
                    <bean:message bundle="yxplankind" key="yxplankindname"/>                    
                </td>                              
            </tr>
            <c:forEach var="item" items="${requestScope.LIST.datas}">
                 <c:url value="/zifee/yxplankind.do?CMD=EDIT" var="urlContent">                              
                    
                     <c:param name="PK" value="${item.yxplankindid}"/>
                 </c:url>
                 <tr class="table_style_content" align="center">
                     <td>
                         <input type="checkbox" name="_selectitem" value="<c:out value='${item.yxplankindid}' />"
                                onclick="checkOne();" class="table_checkbox">
                     </td>
                     <td>
                         <a href='<c:out value="${urlContent}"/>'><c:out value="${item.yxplankindid}"/></a>
                     </td>
                     <td>
                         <c:out value="${item.yxplankindname}"/>
                     </td>                     
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
