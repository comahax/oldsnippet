<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc" %>
<jsp:include page="/inc/acl.jsp">
  <jsp:param name="PID" value="4D6F1A3C" />
</jsp:include>
<%
    String ID_1 = "4D6F1A3CBT1";
    String ID_2 = "4D6F1A3CBT2";
    String ID_3 = "4D6F1A3CBT3";
    String ID_4 = "ACCTSET_NEW";
	String ID_5 = "ACCTSET_DET";
%>
<html>
<head>
    <title><bean:message bundle="acctset" key="theList"/></title>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            addfield('_ne_acctsetid', '<bean:message bundle="acctset" key="acctsetid"/>', 'l', true, 14);
            addfield('_ne_acctid', '<bean:message bundle="acctset" key="acctid"/>', 'l', true, 14);
            return checkval(window);
        }
    </script>
</head>

<body onload="loadforiframe();">
<div class="table_container">
<html:form action="/fee/woff/acctset.do?CMD=LIST" styleId="formList" method="post" onsubmit="return ev_check();">
    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <input type="hidden" name="_rowcount" value="<c:out value='${requestScope.LIST.rowCount}' />">

	<div class="table_div">	
		<table class="top_table">
			<tr> 
				<td><bean:message bundle="acctset" key="custMsg"/></td>				 
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
                <td class="form_table_right"><bean:message bundle="acctset" key="acctsetid"/>:</td>
                <td class="form_table_left">
					<s:zoom definition="#WOFF-ACCT" property="_ne_acctsetid" styleClass="form_input_1x" condition="acctlevel:${0}"/>
                </td>
                <td class="form_table_right"><bean:message bundle="acctset" key="acctid"/>:</td>
                <td class="form_table_left">
					<s:zoom definition="#WOFF-ACCT" property="_ne_acctid" styleClass="form_input_1x" condition="_nne_acctlevel:${0}"/>
                </td>
            </tr>
        </table>
    </div>
	
	<div class="table_div">
		<table class="table_button_list">
			<tr>
			   <td>  
			   		<s:PurChk2 controlid="<%=ID_4%>"  disableChild="true">
                       <input type="button" name="btnNew"  class="add" onmouseover="buttonover(this);"
                       onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                       value="<bean:message bundle="public" key="button_new"/>" onClick="doNew('/fee/woff/acctset.do')">
                    </s:PurChk2>
                    <s:PurChk2 controlid="<%=ID_5%>"  disableChild="true">
                    	<input type="button" name="btnDelete" class="delete" onmouseover="buttonover(this);"
                    	onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                    	value="<bean:message bundle="public" key="button_delete"/>" onClick="doDelete('/fee/woff/acctset.do')">
                    </s:PurChk2>
                 	<s:PurChk controlid="<%=ID_3%>">
                 	<input type="button" class="query" onmouseover="buttonover(this);"
                       onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                       value="<bean:message bundle="public" key="button_search"/>" onclick="doQuery()"/>
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
                    <a href="javascript:doOrderby('acctsetid')"><bean:message bundle="acctset" key="acctsetid"/></a>
                    <s:OrderImg form="/fee/woff/acctset/AcctSetForm" field="acctsetid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('acctid')"><bean:message bundle="acctset" key="acctid"/></a>
                    <s:OrderImg form="/fee/woff/acctset/AcctSetForm" field="acctid"/>
                </td>
            </tr>
            <c:forEach var="item" items="${requestScope.LIST.datas}">
                 <c:url value="/fee/woff/acctset.do?CMD=EDIT" var="urlContent">
                     <c:param name="PK" value="${item.acctsetid}|${item.acctid}"/>
                 </c:url>
                 <tr class="table_style_content" align="center">
                     <td>
                         <input type="checkbox" name="_selectitem" value="<c:out value='${item.acctsetid}|${item.acctid}' />"
                                onclick="checkOne();" class="table_checkbox">
                     </td>
                     <td><s:Code2Name code="${item.acctsetid}" definition="#WOFF-ACCT"/></td>
                     <td><s:Code2Name code="${item.acctid}" definition="#WOFF-ACCT"/></td>
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
