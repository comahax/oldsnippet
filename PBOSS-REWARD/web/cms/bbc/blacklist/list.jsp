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
    <title><bean:message bundle="blacklist" key="titleList"/></title>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            addfield('_se_mobile', '<bean:message bundle="blacklist" key="mobile"/>', 'c', 'false', '15');
            return checkval(window);
        }
        
        function doImport(){
			formList.action="<%=contextPath%>/cms/bbc/blacklist/batch.jsp";
			formList.submit();
		}
        
    </script>
</head>

<body onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<html:form action="/cms/bbc/blacklist.do?CMD=LIST" styleId="formList" method="post" onsubmit="return ev_check();">
    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <input type="hidden" name="_rowcount" value="<c:out value='${requestScope.LIST.rowCount}' />">
    <c:set var="form" scope="request" value="${requestScope['/cms/bbc/blacklist/BlacklistForm']}"/>

    <!--##################################添加标题内容##################################################-->
    <div class="table_div">
    <table class="top_table">
    	<tr>
    		<td>
    			<bean:message bundle="blacklist" key="titleList"/>
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
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="blacklist" key="mobile"/>:</td>
                <td width="30%" class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_se_mobile"></html:text>
                </td>
            </tr>
        </table>
    </div>
	<div class="table_div">
		<table class="table_button_list">
			<tr> 
                <td align=right>
                        <s:PurChk controlid="<%=ID_1%>">
                            <input type="button" name="btnNew"  class="add" onmouseover="buttonover(this);"
                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                            value="<bean:message bundle="public" key="button_new"/>" onClick="doNew('/cms/bbc/blacklist.do')">
                        </s:PurChk>
                        <s:PurChk controlid="<%=ID_2%>">
                            <input type="button" name="btnDelete" class="delete" onmouseover="buttonover(this);"
                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                            value="<bean:message bundle="public" key="button_delete"/>" onClick="doDelete('/cms/bbc/blacklist.do')">
                        </s:PurChk>
                        <s:PurChk controlid="<%=ID_3%>">
                        <input type="button" class="query" onmouseover="buttonover(this);" onclick="doQuery();"
                                onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                                value="<bean:message bundle="public" key="button_search"/>" />
                        </s:PurChk>
                        <input type="button" class="button_4" onmouseover="buttonover(this);" onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                              	value="批量导入" 
                                onclick="doImport()"/>
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
                    <a href="javascript:doOrderby('name')"><bean:message bundle="blacklist" key="name"/></a>
                    <s:OrderImg form="/cms/bbc/blacklist/BlacklistForm" field="name"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('mobile')"><bean:message bundle="blacklist" key="mobile"/></a>
                    <s:OrderImg form="/cms/bbc/blacklist/BlacklistForm" field="mobile"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('filtertype')"><bean:message bundle="blacklist" key="filtertype"/></a>
                    <s:OrderImg form="/cms/bbc/blacklist/BlacklistForm" field="filtertype"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('starttime')"><bean:message bundle="blacklist" key="starttime"/></a>
                    <s:OrderImg form="/cms/bbc/blacklist/BlacklistForm" field="starttime"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('endtime')"><bean:message bundle="blacklist" key="endtime"/></a>
                    <s:OrderImg form="/cms/bbc/blacklist/BlacklistForm" field="endtime"/>
                </td>
            </tr>
            <c:forEach var="item" items="${requestScope.LIST.datas}">
                 <c:url value="/cms/bbc/blacklist.do?CMD=EDIT" var="urlContent">
                     <%//this param name must "PK" %>
                     <c:param name="PK" value="${item.mobile}"/>
                     <%-- <c:param name="PK" value="'${item.id}|${item.id2}'"/> --%>
                 </c:url>
                 <tr class="table_style_content" align="center">
                     <td>
                         <input type="checkbox" name="_selectitem" value="<c:out value='${item.mobile}' />"
                                onclick="checkOne();" class="table_checkbox">
                     </td>
                     <td><c:out value="${item.name}"/></td>
                     <td>
                         <a href='<c:out value="${urlContent}"/>'><c:out value="${item.mobile}"/></a>
                     </td>
                     <td><c:out value="${item.filtertype}"/></td>
                     <td>
                     <fmt:formatDate pattern="yyyy-MM-dd" value="${item.starttime}" />
                     </td>
                     <td>
                     <fmt:formatDate pattern="yyyy-MM-dd" value="${item.endtime}" />
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
