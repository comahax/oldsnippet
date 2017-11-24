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
    <title><bean:message bundle="employeelogquery" key="titleList"/></title>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            addfield('_se_telephone', '<bean:message bundle="employeelogquery" key="telephone"/>', 'c', 'false', '15');
            return checkval(window);
        }
    </script>
</head>

<body onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<html:form action="/cms/employeelogquery.do?CMD=LIST" styleId="formList" method="post" onsubmit="return ev_check();">
    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <input type="hidden" name="_rowcount" value="<c:out value='${requestScope.LIST.rowCount}' />">
    <c:set var="form" scope="request" value="${requestScope['/cms/employeelogquery/EmployeelogqueryForm']}"/>

    <!--##################################添加标题内容##################################################-->
    <div class="table_div">
    <table class="top_table">
    	<tr>
    		<td>
    			<bean:message bundle="employeelogquery" key="titleList"/>
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
                <td width="8%" height="20" align="left" class="form_table_right" ><bean:message bundle="employeelogquery" key="telephone"/>:</td>
                <td width="92%" class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_se_telephone"></html:text>
                </td>
            
            </tr>
        </table>
    </div>
	<div class="table_div">
		<table class="table_button_list">
			<tr> 
                <td align=right>
                        
                        <s:PurChk controlid="<%=ID_3%>">
                        <input type="button" class="query" onmouseover="buttonover(this);" onclick="doQuery();"
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
                <td>
                    <a href="javascript:doOrderby('telephone')"><bean:message bundle="employeelogquery" key="telephone"/></a>
                    <s:OrderImg form="/cms/employeelogquery/EmployeelogqueryForm" field="telephone"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('cityid')"><bean:message bundle="employeelogquery" key="cityid"/></a>
                    <s:OrderImg form="/cms/employeelogquery/EmployeelogqueryForm" field="cityid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('wayid')"><bean:message bundle="employeelogquery" key="wayid"/></a>
                    <s:OrderImg form="/cms/employeelogquery/EmployeelogqueryForm" field="wayid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('empstatus')">状态</a>
                    <s:OrderImg form="/cms/employeelogquery/EmployeelogqueryForm" field="empstatus"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('regdate')"><bean:message bundle="employeelogquery" key="regdate"/></a>
                    <s:OrderImg form="/cms/employeelogquery/EmployeelogqueryForm" field="regdate"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('optime')"><bean:message bundle="employeelogquery" key="optime"/></a>
                    <s:OrderImg form="/cms/employeelogquery/EmployeelogqueryForm" field="optime"/>
                </td>
<%--                <td>--%>
<%--                    <a href="javascript:doOrderby('oprcode2')"><bean:message bundle="employeelogquery" key="oprcode2"/></a>--%>
<%--                    <s:OrderImg form="/cms/employeelogquery/EmployeelogqueryForm" field="oprcode2"/>--%>
<%--                </td>--%>
                <td>
                    <a href="javascript:doOrderby('oprcode')"><bean:message bundle="employeelogquery" key="oprcode"/></a>
                    <s:OrderImg form="/cms/employeelogquery/EmployeelogqueryForm" field="oprcode"/>
                </td>
            </tr>
            <c:forEach var="item" items="${requestScope.LIST.datas}">
                 <c:url value="/cms/employeelogquery.do?CMD=EDIT" var="urlContent">
                     <%//this param name must "PK" %>
                     <c:param name="PK" value="${item.logid}"/>
                     <%-- <c:param name="PK" value="'${item.id}|${item.id2}'"/> --%>
                 </c:url>
                 <tr class="table_style_content" align="center">
                     <td><c:out value="${item.telephone}"/></td>
                     <td>
                     <s:Code2Name code="${item.cityid}" definition="#CITYCOMPANY" />
                     </td>
                     <td><c:out value="${item.wayid}"/></td>
                     <td>
                     <s:Code2Name code="${item.empstatus}" definition="$CH_EMPSTATUS" />
                     </td>
                     <td>
                     	<fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${item.regdate}" />
                     </td>
                     <td>
                     	<fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${item.optime}" />
                     </td>
<%--                     <td><c:out value="${item.oprcode2}"/></td>--%>
                     <td><c:out value="${item.oprcode}"/></td>
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
