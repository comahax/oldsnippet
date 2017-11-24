<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc" %>

<html>
<head>
    <title><bean:message bundle="employee" key="titleList"/></title>
    <base target="_self">

    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            addfield('_ne_employeeid', '<bean:message bundle="employee" key="employeeid"/>', 'i', true, 14);
            addfield('_sk_employeename', '<bean:message bundle="employee" key="employeename"/>', 'c', true, 20);
            return checkval(window);
        }
        
       window.returnValue = "";
       function doOK(code) {
	   		window.returnValue = code;
	   		window.close();
	   }

    </script>
</head>

<body onload="loadforiframe();" onclose="javascript:window.returnValue = ''">
<div class="table_container">
<html:form action="/cms/employee.do?CMD=SHOWEMP" styleId="formList" method="post" onsubmit="return ev_check();">
    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <html:hidden property="_se_wayid"/>
    <html:hidden property="_ne_isnet"/>
    <html:hidden property="_ne_empstatus"/>
    <input type="hidden" name="_rowcount" value="<c:out value='${requestScope.LIST.rowCount}' />">

	<div class="table_div">
		<table class="top_table">
			<tr>
				<td><bean:message bundle="employee" key="titleList" /></td>
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
    			<td width="80" height="20" align="right" class="form_table_right" >
                	<bean:message bundle="employee" key="employeeid"/>:
            	</td>
            	<td class="form_table_left">
               		<html:text styleClass="form_input_1x" property="_ne_employeeid" ></html:text>
            	</td>
                <td width="126" height="20" align="right" class="form_table_right">
                	<bean:message bundle="employee" key="employeename"/>:
               	</td>
                <td class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_sk_employeename" ></html:text>
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
                    <a href="javascript:doOrderby('employeeid')"><bean:message bundle="employee" key="employeeid"/></a>
                    <s:OrderImg form="/cms/employee/EmployeeForm" field="employeeid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('employeename')"><bean:message bundle="employee" key="employeename"/></a>
                    <s:OrderImg form="/cms/employee/EmployeeForm" field="employeename"/>
                </td>           
            </tr>
            <c:forEach var="item" items="${requestScope.LIST.datas}">
                 <tr style="cursor:hand" class="table_style_content" align="center" onclick="doOK('<c:out value="${item.employeeid}"/>');">
                     <td>
                         <c:out value="${item.employeeid}"/>
                     </td>
                     <td>
                         <c:out value="${item.employeename}"/>
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
