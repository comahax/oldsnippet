<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ page import="com.sunrise.boss.delegate.admin.acl.ACLDelegate" %>
<%@ page import="com.sunrise.boss.ui.commons.WebConstant"%>
<%@ page import="com.sunrise.boss.ui.commons.User"%>
<%@ include file="/inc/listhead.inc" %>
<jsp:include page="/inc/acl.jsp">
  <jsp:param name="PID" value="2B6F1A" />
</jsp:include>
<%
    //Ò³Ãæ¿ØÖÆµã?
    String ID_1 = "2B6F1ABT1";
    String ID_2 = "2B6F1ABT2";
    String ID_3 = "2B6F1ABT3";
    String xxx = "2B1A7G_JHQUERYRGT_D";
%>
<html>
<head>
    <title><bean:message bundle="role" key="subtitle"/></title>
    <script type="text/javascript" src="<%= contextPath %>/js/bus/waycommon.js"></script>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            addfield('_se_orgid', '<bean:message bundle="role" key="wayid"/>', 'c', false, 18);
            return checkval(window);
        }
		
		function doQuery(cmdQuery) {
			formList.action = contextPath + cmdQuery;
    		formList.submit();
		}
		
		function doReset() {
			formList._se_orgid.value = "";
		}
    </script>
</head>
<%
	ACLDelegate delegate = new ACLDelegate();
	User user = (User) request.getSession().getAttribute(
				WebConstant.SESSION_ATTRIBUTE_USER);
	boolean hasright = delegate.checkPermission(user.getOpercode(),xxx);
%>
<body onload="try{document.formList._se_orgid.focus();}catch(e){}">
<div class="table_container">

<html:form action="/role.do?CMD=LIST" styleId="formList" method="post" onsubmit="return ev_check();">
    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>   
    <input type="hidden" name="_rowcount" value="<c:out value='${requestScope.LIST.rowCount}' />">
    
	<div class="table_div">
		<table class="top_table">
			<tr> 
				<td>
					<bean:message bundle="role" key="subtitle"/>
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
                <td width="126" height="20" align="right" class="form_table_right">
                	<bean:message bundle="role" key="wayid"/>:
                </td>
                <td class="form_table_left">
                   <% if(hasright) { %>                  
                    <html:text styleClass="form_in_1x" property="_se_orgid" onclick="showSelectWay(this)" value="<%=user.getWayid()%>"></html:text>
                   <% } else  { %>
                   <html:text styleClass="form_in_1x" property="_se_orgid" readonly="true" value="<%=user.getWayid()%>"></html:text>
                   <% } %> 
                </td>
            </tr>
        </table>
    </div>
	
	<div class="table_div">
		<table width="100%" class="table_button_list" border="0" cellspacing="0" cellpadding="0" ID="Table3">
			<tr>
            	<td align=right>
                	<s:PurChk controlid="<%=ID_1%>">
                        <input type="submit" name="btnQuery" class="query" value="<bean:message bundle="public" key="button_search"/>"/>
                    </s:PurChk>
               </td>
            </tr>
		</table>
	</div>

    <div class="table_div">
      <div class="table_LongTable">
        <table class="table_style" ID="Table2">
            <tr class="table_style_head">
                <td nowrap>
                    <%--<a href="javascript:doOrderby('orgid')"><bean:message bundle="role" key="wayid"/></a>
                    --%>
                    <bean:message bundle="role" key="wayid"/>
                    <s:OrderImg form="/RoleForm" field="orgid"/>
                </td>
                <td nowrap>
                    <!--<a href="javascript:doOrderby('orgid')"><bean:message bundle="role" key="wayname"/></a>-->
                    <bean:message bundle="role" key="wayname"/>
                    <s:OrderImg form="/RoleForm" field="orgid"/>
                </td>
                <td nowrap>
                    <!--<a href="javascript:doOrderby('roleid')"><bean:message bundle="role" key="roleid"/></a>-->
                    <bean:message bundle="role" key="roleid"/>
                    <s:OrderImg form="/RoleForm" field="roleid"/>
                </td>
                <td nowrap>
                    <!--<a href="javascript:doOrderby('rolename')"><bean:message bundle="role" key="rolename"/></a>-->
                    <bean:message bundle="role" key="rolename"/>
                    <s:OrderImg form="/RoleForm" field="rolename"/>
                </td>
            </tr>
            <c:forEach var="item" items="${requestScope.LIST.datas}">
                 <tr class="table_style_content" align="center">
                     <td><c:out value="${item.orgid}"/></td>
                     <td><s:Code2Name definition="WAY" code="${item.orgid}"></s:Code2Name></td>
                     <td><c:out value="${item.roleid}"/></td>
                     <td><c:out value="${item.rolename}"/></td>
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
