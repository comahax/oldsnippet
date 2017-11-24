<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc" %>

<html>
<head>
    <title><bean:message bundle="bbcoper" key="titleList"/></title>
    <base target="_self">

    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            addfield('_se_opnid', '<bean:message bundle="bbcoper" key="opnid"/>', 'c', true, '18');
            addfield('_sk_name', '<bean:message bundle="bbcoper" key="name"/>', 'c', true, '50');
            return checkval(window);
        }
        
       window.returnValue = "";
       function doOK(value) {
	   		window.returnValue = value;
	   		window.close();
	   }

    </script>
</head>

<body onload="loadforiframe();" onclose="javascript:window.returnValue = ''">
<div class="table_container">
<html:form action="/cms/bbc/operation.do?CMD=SELECT" styleId="formList" method="post" onsubmit="return ev_check();">
    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <html:hidden property="_se_busibelong"/>
    <html:hidden property="_ne_state"/>
    <html:hidden property="_ne_isbusi"/>
    <input type="hidden" name="_rowcount" value="<c:out value='${requestScope.LIST.rowCount}' />">

	<div class="table_div">
		<table class="top_table">
			<tr>
				<td><bean:message bundle="bbcoper" key="titleList" /></td>
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
            	<td class="form_table_right"><bean:message bundle="bbcoper" key="opnid"/>:</td>
                <td class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_se_opnid"  maxlength="18"></html:text>
                </td>
                <td class="form_table_right"><bean:message bundle="bbcoper" key="name"/>:</td>
                <td class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_sk_name"  maxlength="50"></html:text>
                </td>
            </tr>
        </table>
    </div>
	<div class="table_div">
		<table class="table_button_list">
			<tr>
			   <td>
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
            <tr class="table_style_head"  >
                <td>
                    <a href="javascript:doOrderby('opnid')"><bean:message bundle="bbcoper" key="opnid"/></a>
                    <s:OrderImg form="/cms/bbc/operation/BBCoperationForm" field="opnid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('name')"><bean:message bundle="bbcoper" key="name"/></a>
                    <s:OrderImg form="/cms/bbc/operation/BBCoperationForm" field="name"/>
                </td>           
            </tr>
            <c:forEach var="item" items="${requestScope.LIST.datas}">
                 <tr style="cursor:hand" class="table_style_content" align="center" onclick="doOK('<c:out value="${item.opnid}"/>');">
                     <td>
                         <c:out value="${item.opnid}"/>
                     </td>
                     <td>
                         <c:out value="${item.name}"/>
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
