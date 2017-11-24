<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc" %>
<jsp:include page="/inc/acl.jsp">
  <jsp:param name="PID" value="2B1A2B20" />
</jsp:include>

<%
	  String ID_1 = "2B1A2B20" + "BT1"; 
    String ID_2 = "2B1A2B20" + "BT2";  
    String ID_3 = "2B1A2B20" + "BT3"; 
    
%>
<html>
<head>
    <title><bean:message bundle="custbchtype" key="titleList"/></title>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            addfield('_sk_bchtypecode', '<bean:message bundle="custbchtype" key="bchtypecode"/>', 'c', true, 3);
            addfield('_sk_bchtypename', '<bean:message bundle="custbchtype" key="bchtypename"/>', 'c', true, 64);
            return checkval(window);
        }
    </script>
</head>

<body onload="loadforiframe();" >
<div class="table_container">

<html:form action="/cms/custbchtype.do?CMD=LIST" styleId="formList" method="post" onsubmit="return ev_check();">
    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <input type="hidden" name="_rowcount" value="<c:out value='${requestScope.LIST.rowCount}' />">

	 <div class="table_div">
		 <table class="top_table">
				<tr>
					<td>
						<bean:message bundle="custbchtype" key="titleList"/>
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
                	<bean:message bundle="custbchtype" key="bchtypecode"/>:
                </td>
                <td class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_sk_bchtypecode"></html:text>
                </td>
                <td width="126" height="20" align="right" class="form_table_right">
                	<bean:message bundle="custbchtype" key="bchtypename"/>:
               	</td>
                <td class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_sk_bchtypename" ></html:text>
                </td>
                <td width="126" height="20" align="right" class="form_table_right">
                	&nbsp;
               	</td>
                <td class="form_table_left">
                    &nbsp;
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
                  value="<bean:message bundle="public" key="button_new"/>" onClick="doNew('/cms/custbchtype.do')">
              </s:PurChk>
              <s:PurChk controlid="<%=ID_2%>">
                  <input type="button" name="btnDelete" class="delete" onmouseover="buttonover(this);"
                  onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                  value="<bean:message bundle="public" key="button_delete"/>" onClick="doDelete('/cms/custbchtype.do')">
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
                    <a href="javascript:doOrderby('bchtypecode')"><bean:message bundle="custbchtype" key="bchtypecode"/></a>
                    <s:OrderImg form="/cms/custbchtype/AreacenterForm" field="bchtypecode"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('bchtypename')"><bean:message bundle="custbchtype" key="bchtypename"/></a>
                    <s:OrderImg form="/cms/custbchtype/AreacenterForm" field="bchtypename"/>
                </td>
                <td><bean:message bundle="custbchtype" key="citycompid"/></td>
                <td><bean:message bundle="custbchtype" key="notusebysub"/></td>
                <td><bean:message bundle="custbchtype" key="description"/></td>
            </tr>
            <c:forEach var="item" items="${requestScope.LIST.datas}">
                 <c:url value="/cms/custbchtype.do?CMD=EDIT" var="urlContent">
                     <c:param name="PK" value="${item.bchtypecode}"/>
                 </c:url>
                 <tr class="table_style_content" align="center">
                     <td>
                         <input type="checkbox" name="_selectitem" value="<c:out value='${item.bchtypecode}' />"
                                onclick="checkOne();" class="table_checkbox">
                     </td>
                     <td>
                         <a href='<c:out value="${urlContent}"/>'><c:out value="${item.bchtypecode}"/></a>
                     </td>
                     <td> <c:out value="${item.bchtypename}"/> </td>
                     <td><s:Code2Name code="${item.citycompid}"  definition="#CITYCOMPANY"/></td>
                     <td><s:Code2Name code="${item.notusebysub}"  definition="#NOTUSEBYSUB"/></td>
                     <td><c:out value="${item.description}"/></td>
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
