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
    <title><bean:message bundle="exmnperiod" key="titleList"/></title>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            return checkval(window);
        }
        function doReturn(cmdReturn) {
        	document.getElementsByName("_ne_exmnid")[0].value="";
		    formList.action = contextPath + cmdReturn;
		    formList.submit();
		}
    </script>
</head>

<body onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<html:form action="/cms/examine/exmnperiod.do?CMD=LIST" styleId="formList" method="post" onsubmit="return ev_check();">
    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <html:hidden property="_ne_exmnid"/>
    <input type="hidden" name="_rowcount" value="<c:out value='${requestScope.LIST.rowCount}' />">
    <c:set var="form" scope="request" value="${requestScope['/cms/examine/exmnperiod/ExmnperiodForm']}"/>
	<input type="hidden" id="provincialright" name="provincialright" value="<c:out value="${provincialright}"/>">
	 <input type="hidden" id="exmncityid" name="exmncityid" value="<c:out value="${exmncityid}"/>">
    <!--##################################添加标题内容##################################################-->
    <div class="table_div">
    <table class="top_table">
    	<tr>
    		<td>
    			<bean:message bundle="exmnperiod" key="titleList"/>
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
		<table class="table_button_list">
			<tr> 
                <td align=right>
                		<c:if test="${(provincialright=='YES' and exmncityid=='GD') or (provincialright!='YES' and exmncityid!='GD') }">
                            <input type="button" name="btnNew"  class="add" onmouseover="buttonover(this);"
                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                            value="<bean:message bundle="public" key="button_new"/>" onClick="doNew('/cms/examine/exmnperiod.do')">
                            <input type="button" name="btnDelete" class="delete" onmouseover="buttonover(this);"
                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                            value="<bean:message bundle="public" key="button_delete"/>" onClick="doDelete('/cms/examine/exmnperiod.do')">
                       	</c:if>
                       		 <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
                            name="btnReturn" onfocus="buttonover(this)" onblur="buttonout(this)"
                            value="<bean:message bundle="public" key="button_return"/>" class="close"
                            onclick="doReturn('/cms/examine/examine.do?CMD=LIST')">
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
                    <a href="javascript:doOrderby('seqid')"><bean:message bundle="exmnperiod" key="seqid"/></a>
                    <s:OrderImg form="/cms/examine/exmnperiod/ExmnperiodForm" field="seqid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('beginmonth')"><bean:message bundle="exmnperiod" key="beginmonth"/></a>
                    <s:OrderImg form="/cms/examine/exmnperiod/ExmnperiodForm" field="beginmonth"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('endmonth')"><bean:message bundle="exmnperiod" key="endmonth"/></a>
                    <s:OrderImg form="/cms/examine/exmnperiod/ExmnperiodForm" field="endmonth"/>
                </td>
            </tr>
            <c:forEach var="item" items="${requestScope.LIST.datas}">
                 <c:url value="/cms/examine/exmnperiod.do?CMD=EDIT" var="urlContent">
                     <%//this param name must "PK" %>
                     <c:param name="PK" value="${item.seqid}"/>
                     <c:param name="_ne_exmnid" value="${item.exmnid}"/>
                     <%-- <c:param name="PK" value="'${item.id}|${item.id2}'"/> --%>
                 </c:url>
                 <tr class="table_style_content" align="center">
                     <td>
                         <input type="checkbox" name="_selectitem" value="<c:out value='${item.seqid}' />"
                                onclick="checkOne();" class="table_checkbox">
                     </td>
                     <td>
                         <a href='<c:out value="${urlContent}"/>'><c:out value="${item.seqid}"/></a>
                     </td>
                     <td><c:out value="${item.beginmonth}"/><bean:message bundle="exmnperiod" key="month"/></td>
                     <td><c:out value="${item.endmonth}"/><bean:message bundle="exmnperiod" key="month"/></td>
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
