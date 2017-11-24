<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc" %>
<jsp:include page="/inc/acl.jsp">
  <jsp:param name="PID" value="2B1A5E20" />
</jsp:include>

<%
	  String ID_1 = "2B1A5E20BT1";
    String ID_2 = "2B1A5E20BT2";
    String ID_3 = "2B1A5E20BT3";
    
%>

<html>
<head>
    <title><bean:message bundle="employee" key="titleList"/></title>
    <script type="text/javascript" src="<%= contextPath %>/js/bus/waycommon.js"></script>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            addfield('_ne_employeeid', '<bean:message bundle="employee" key="employeeid"/>', 'i', true, 14);
            addfield('_ne_employeename', '<bean:message bundle="employee" key="employeename"/>', 'c', true, 20);
            return checkval(window);
        }
    </script>
</head>

<body onload="loadforiframe();" >
<div class="table_container">

<html:form action="/cms/employee.do?CMD=LIST" styleId="formList" method="post" onsubmit="return ev_check();">
    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <input type="hidden" name="_rowcount" value="<c:out value='${requestScope.LIST.rowCount}' />">

	 <div class="table_div">
		 <table class="top_table">
				<tr>
					<td>
						<bean:message bundle="employee" key="titleList"/>
					</td>
				</tr>
			</table>
		</div>	
		
		<div class="table_div">
	     <table width="100%" class="error_text">
       	   <s:Msg />
       </table>	
		</div>	
		
		
    <div class="table_div">
        <table class="form_table">
            <tr>
                <td width="126" height="20" align="right" class="form_table_right">
                	<bean:message bundle="employee" key="employeeid"/>:
                </td>
                <td class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_ne_employeeid"></html:text>
                </td>
                <td width="126" height="20" align="right" class="form_table_right">
                	<bean:message bundle="employee" key="employeename"/>:
               	</td>
                <td class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_sk_employeename" ></html:text>
                </td>
            </tr>
            
            <tr>
                <td width="126" height="20" align="right" class="form_table_right">
                	<bean:message bundle="employee" key="oprcode2"/>:
                </td>
                <td class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_sk_oprcode2"></html:text>
                </td>
                <td width="126" height="20" align="right" class="form_table_right">
                	<bean:message bundle="employee" key="wayid"/>:
               	</td>
                <td class="form_table_left">
                    <html:hidden property="_sk_wayid"/>
                    <input type="text" name="way_name" value='<c:out value="${requestScope['/cms/employee/EmployeeForm']._sk_wayid}"/>&nbsp<s:Code2Name code="${requestScope['/cms/employee/EmployeeForm']._sk_wayid}" definition="#WAY"/>'  onclick="showSelectWay(this,'_sk_wayid')" class="form_input_1x">
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
                 value="<bean:message bundle="public" key="button_new"/>" onClick="doNew('/cms/employee.do')">
             </s:PurChk>
             <s:PurChk controlid="<%=ID_2%>">
                 <input type="button" name="btnDelete" class="delete" onmouseover="buttonover(this);"
                 onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                 value="<bean:message bundle="public" key="button_delete"/>" onClick="doDelete('/cms/employee.do')">
             </s:PurChk>
             <s:PurChk controlid="<%=ID_3%>">
             <input type="button" class="query"onmouseover="buttonover(this);" onclick="doQuery();" 
                     onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                     value="<bean:message bundle="public" key="button_search"/>" />
             </s:PurChk>  
					</td>
				</tr>
			</table>
		</div>

    <div class="table_div">
        <table class="table_style" ID="Table2">
            <tr class="table_style_head">
                <td title="<bean:message bundle="public" key="list_title_select"/>">
                    <input type="checkbox" name="allbox" onclick="checkAll();" class="table_checkbox">
                </td>
                <td>
                    <a href="javascript:doOrderby('employeeid')"><bean:message bundle="employee" key="employeeid"/></a>
                    <s:OrderImg form="/cms/employee/AreacenterForm" field="employeeid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('oprcode2')"><bean:message bundle="employee" key="oprcode2"/></a>
                    <s:OrderImg form="/cms/employee/AreacenterForm" field="oprcode2"/>
                </td>
                
                <td><bean:message bundle="employee" key="employeename"/></td>
                <td><bean:message bundle="employee" key="station"/></td>
                <td><bean:message bundle="employee" key="sex"/></td>
                <td><bean:message bundle="employee" key="way"/></td>
                <td><bean:message bundle="employee" key="nativehome"/></td>
                <td><bean:message bundle="employee" key="polivisage"/></td>
                <td><bean:message bundle="employee" key="department"/></td>
            </tr>
            <c:forEach var="item" items="${requestScope.LIST.datas}">
                 <c:url value="/cms/employee.do?CMD=EDIT" var="urlContent">
                     <c:param name="PK" value="${item.employeeid}"/>
                 </c:url>
                 <tr class="table_style_content" align="center">
                     <td>
                         <input type="checkbox" name="_selectitem" value="<c:out value='${item.employeeid}' />"
                                onclick="checkOne();" class="table_checkbox">
                     </td>
                     <td>
                         <a href='<c:out value="${urlContent}"/>'><c:out value="${item.employeeid}"/></a>
                     </td>
                     <td> <c:out value="${item.oprcode2}"/> </td>
                     <td><c:out value="${item.employeename}"/></td>
                     <td><s:Code2Name code="${item.station}"  definition="#CH_POSTINFO"/></td>
                     <td><s:Code2Name code="${item.sex}"  definition="$CH_SEX"/></td>
                     <td><s:Code2Name code="${item.wayid}"  definition="#WAY"/></td>
                     <td><s:Code2Name code="${item.nativehome}"  definition="$CH_NATIVE"/></td>
                     <td><s:Code2Name code="${item.polivisage}"  definition="$CH_POLIVISAGE"/></td>
                     <td> <c:out value="${item.department}"/> </td>
                 </tr>
             </c:forEach>
        </table>
    </div>
   <div class="table_div">
       <s:PageNav dpName="LIST"/>
   </div>

</html:form>
</div>
</body>
</html>
