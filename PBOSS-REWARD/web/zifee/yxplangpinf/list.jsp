<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc" %>
<jsp:include page="/inc/acl.jsp">
  <jsp:param name="PID" value="3C2B1A10AA" />
</jsp:include>

<%
    String ID_1 = "3C2B1A10AABT1"; 
    String ID_2 = "3C2B1A10AABT2";
    String ID_3 = "3C2B1A10AABT3";
%>


<html:html>
<head>
    <title><bean:message bundle="yxplan" key="titleList"/></title>
    <script language="JavaScript" type="text/JavaScript">
      
        function ev_check() {
            addfield('_ne_groupid', '<bean:message bundle="yxplan" key="groupyxplanid"/>', 'l', true, 14);
            addfield('_sk_groupname', '<bean:message bundle="yxplan" key="groupyxplanname"/>', 'c', true, 64);
            return checkval(window);
        }
        
        function doSubmit(cmdStr) {
           formList.action = contextPath + cmdStr;
           formList.submit();    
        }

    </script>
</head>
<body>
<div class="table_container">
<html:form action="/zifee/yxplangpinf.do?CMD=LIST" styleId="formList" method="post" onsubmit="return ev_check();">
    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <input type="hidden" name="_rowcount" value="<c:out value='${requestScope.LIST.rowCount}' />">
    
  <div class="table_div">
		<table class="top_table">
			<tr>
				<td>
					<bean:message bundle="yxplangroup" key="manage"/>
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
       			    		<bean:message bundle="yxplan" key="groupyxplanid"/>:
       			    </td>
                
                <td class="form_table_left">
                	 <html:text styleClass="form_input_1x" property="_ne_groupid" ></html:text>
                </td>
                
                <td width="126" height="20" align="right" class="form_table_right">
                	<bean:message bundle="yxplan" key="groupyxplanname"/>:
                </td>
                
                <td class="form_table_left">
                	<html:text styleClass="form_input_1x" property="_sk_groupname"></html:text>
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
                     value="<bean:message bundle="public" key="button_new"/>" onClick="doSubmit('/zifee/yxplangpinf.do?CMD=NEW')">
              </s:PurChk> 
              <s:PurChk controlid="<%=ID_2%>">
                     <input type="button" name="btnDelete" class="delete" onmouseover="buttonover(this);"
                     onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                     value="<bean:message bundle="public" key="button_delete"/>" onClick="doSubmit('/zifee/yxplangpinf.do?CMD=DELETE')">
              </s:PurChk>
              <s:PurChk controlid="<%=ID_3%>">
                     <input type="submit" class="query"onmouseover="buttonover(this);"
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

                <td title="<bean:message bundle="public" key="list_title_select"/>">
                    <input type="checkbox" name="allbox" onclick="checkAll();" class="table_checkbox">
                </td>
                <td>
                    <a href="javascript:doOrderby('groupid')"><bean:message bundle="yxplan" key="groupyxplanid"/></a>
                    <s:OrderImg form="/zifee/yxplan/YxplangpinfForm" field="groupid"/>
                </td>
                
                <td nowrap><bean:message bundle="yxplan" key="groupyxplanname"/></td>
                <td nowrap><bean:message bundle="yxplan" key="areacode"/></td>
                <td nowrap><bean:message bundle="yxplan" key="remark"/></td>
                 
             </tr>
            <c:forEach var="item" items="${requestScope.LIST.datas}">            	 
                 <c:url value="/zifee/yxplangpinf.do?CMD=EDIT" var="urlContent">
                     <c:param name="PK" value="${item.groupid}"/>
                 </c:url>
                   
                 <tr class="table_style_content" align="center">
                     <td>
                         <input type="checkbox" name="_selectitem" value="<c:out value='${item.groupid}' />"
                                class="table_checkbox">
                     </td>
                     <td>
                         <a href='<c:out value="${urlContent}"/>'><c:out value="${item.groupid}"/></a>
                     </td>

                     <td><c:out value="${item.groupname}"/></td>
                     <td><c:out value="${item.areacode}"/></td>
                     <td><c:out value="${item.remark}"/></td>
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
</html:html>
