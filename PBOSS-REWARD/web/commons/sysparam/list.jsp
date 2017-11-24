<%@ page language="java" contentType="text/html;charset=GBK"%>
<jsp:include page="/inc/acl.jsp">
	<jsp:param name="PID" value="1A1A1A2B" />
</jsp:include>
<%@ include file="/inc/listhead.inc" %>
<%
    String ID_1 = "1A1A1A2BBT1";
    String ID_2 = "1A1A1A2BBT2";
    String ID_3 = "00010703";
    String ID_4 = "00010704";
%>
<html>
<head>
    <title><bean:message bundle="sysparam" key="titleList"/></title>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            addfield('_ne_systemid', '<bean:message bundle="sysparam" key="systemid"/>', 'i', true, 14);
            addfield('_sk_paramtype', '<bean:message bundle="sysparam" key="paramtype"/>', 'c', true, 16);
            addfield('_sk_paramname', '<bean:message bundle="sysparam" key="paramname"/>', 'c', true, 32);
            return checkval(window);
        }
    </script>
</head>

<body onload="document.formList._ne_systemid.focus()">
<div class="table_container">
<html:form action="/commons/sysparam.do?CMD=LIST" styleId="formList" method="post" onsubmit="return ev_check();">
    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <input type="hidden" name="_rowcount" value="<c:out value='${requestScope.LIST.rowCount}'/>"/>

    <div class="table_div"> 
        <table class="top_table">
            <tr>
				<td><bean:message bundle="sysparam" key="titleList"/></td>
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
                <td class="form_table_right"><bean:message bundle="sysparam" key="systemid"/>:</td>
                 <td class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_ne_systemid" maxlength="14"></html:text>
                </td>
                <td class="form_table_right"><bean:message bundle="sysparam" key="paramtype"/>:</td>
                 <td class="form_table_left">
 					 <html:select property="_sk_paramtype"> 
 					 	<html:option value=""></html:option>
 					 	<s:Options definition="$IB_PARAMTYPE"/> 
 					 </html:select>     
                </td>
                <td class="form_table_right"><bean:message bundle="sysparam" key="paramname"/>:</td>
                 <td class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_sk_paramname" maxlength="32"></html:text>
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
                        value="<bean:message bundle="public" key="button_new"/>" onClick="doNew('/commons/sysparam.do')"/>
                    </s:PurChk>
                    <s:PurChk controlid="<%=ID_2%>">
                        <input type="button" name="btnDelete" class="delete" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="<bean:message bundle="public" key="button_delete"/>" onClick="doDelete('/commons/sysparam.do')"/>
                    </s:PurChk>
                    <input type="button" class="query"onmouseover="buttonover(this);"
                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                            value="<bean:message bundle="public" key="button_search"/>" onClick="doQuery();"/>
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
                <td><bean:message bundle="sysparam" key="systemid"/></td>
                <td><bean:message bundle="sysparam" key="paramtype"/></td>                
                <td><bean:message bundle="sysparam" key="begintime"/></td>
                <td><bean:message bundle="sysparam" key="endtime"/></td>
                <td><bean:message bundle="sysparam" key="paramname"/></td>
                <td><bean:message bundle="sysparam" key="paramvalue"/></td>
                <td><bean:message bundle="sysparam" key="memo"/></td>                
            </tr>
            <c:forEach var="item" items="${requestScope.LIST.datas}">
                 <c:url value="/commons/sysparam.do?CMD=EDIT" var="urlContent">
                     <c:param name="PK" value="${item.systemid}|${item.paramtype}"/>
                 </c:url>
                 <tr class="table_style_content" align="center">
                     <td>
                         <input type="checkbox" class="table_checkbox" name="_selectitem" value="<c:out value='${item.systemid}|${item.paramtype}'/>"
                                onclick="checkOne();">
                     </td>
                     <td>
	                     <a href='<c:out value="${urlContent}"/>'><c:out value="${item.systemid}"/></a>
	                 </td>    

					 <td><s:Code2Name code="${item.paramtype}" definition="$IB_PARAMTYPE"/></td>
                     <td><c:out value="${item.strBegintime}"/></td>
                     <td><c:out value="${item.strEndtime}"/></td>
                     <td><c:out value="${item.paramname}"/></td>
          			 <td><c:out value="${item.paramvalue}"/></td>
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
