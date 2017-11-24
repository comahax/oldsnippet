<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc" %>
<jsp:include page="/inc/acl.jsp">
  <jsp:param name="PID" value="3C2B1A10BB" />
</jsp:include>

<%
    String ID_1 = "3C2B1A10BBBT1"; 
    String ID_2 = "3C2B1A10BBBT2";
    String ID_3 = "3C2B1A10BBBT3";
    String ID_4 = "3C2B1A10BBBT4";
%>
<html:html>
<head>
    <title><bean:message bundle="yxplangroup" key="titleList"/></title>
    <script language="JavaScript" type="text/JavaScript">
      
        function ev_check() {
            addfield('_ne_memyxplan', '<bean:message bundle="yxplangroup" key="_ne_memyxplan"/>', 'i', true, 14);
            return checkval(window);
        }
    function selectYxplan(){
			var arg = new Array();
			var strUrl ="<%=contextPath%>/zifee/yxplan.do?CMD=SELECT";
			var returnValue= window.showModalDialog(strUrl,arg,"dialogWidth:600px; dialogHeight:390px; status:no;resizable:yes;");
			return returnValue;
		 }
	function doBatch(cmdStr) {
            formList.action = contextPath + cmdStr;
            formList.submit();
        }
    </script>
</head>
<body>
<div class="table_container">
<html:form action="/zifee/yxplangroup.do?CMD=LIST" styleId="formList" method="post" onsubmit="return ev_check();">
    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <html:hidden property="groupyxplan"/>
    <input type="hidden" name="_rowcount" value="<c:out value='${requestScope.LIST.rowCount}' />">
    
  <div class="table_div">
		<table class="top_table">
			<tr>
				<td>
					<bean:message bundle="yxplangroup" key="titleList"/>
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
       					<bean:message bundle="yxplangroup" key="_ne_memyxplan"/>:</td>
                <td class="form_table_left">
                	<html:text styleClass="form_input_1x" property="_ne_memyxplan"></html:text>
                	<input type="button"  value="..."  onclick="_ne_memyxplan.value=selectYxplan()">
                </td>
            </tr>
        </table>
    </div>
    
    
    <div class="table_div">
		<table class="table_button_list">
			<tr>
				<td>
					<c:choose>
						<c:when test="${!empty requestScope['/zifee/yxplangroup/YxPlanGroupForm'].groupyxplan and requestScope['/zifee/yxplangroup/YxPlanGroupForm'].groupyxplan!=0}">
				     	   <s:PurChk controlid="<%=ID_1%>">
                     <input type="button" name="btnNew"  class="add" onmouseover="buttonover(this);"
                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                            value="<bean:message bundle="public" key="button_new"/>" onClick="doNew('/zifee/yxplangroup.do')"/>
                 </s:PurChk> 
                 <s:PurChk controlid="<%=ID_2%>">
                      <input type="submit" class="query"onmouseover="buttonover(this);"
                             onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                             value="<bean:message bundle="public" key="button_search"/>" />
                  </s:PurChk> 
                  <s:PurChk controlid="<%=ID_3%>">
                     <input type="button" class="button_4" onmouseover="buttonover(this);"
                     onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                     value="<bean:message bundle='yxplan' key='batch'/>" onClick="doBatch('/zifee/yxplangroup.do?CMD=BATCH');"/>
              		</s:PurChk> 
                  <s:PurChk controlid="<%=ID_4%>">
                      <input type="button" name="btnDelete" class="delete" onmouseover="buttonover(this);"
                      onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                      value="<bean:message bundle="public" key="button_delete"/>" onClick="doDelete('/zifee/yxplangroup.do')"/>
                  </s:PurChk>
						</c:when>
					</c:choose>
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
                <td nowrap><bean:message bundle="yxplangroup" key="yxplanid"/></td>
                <td nowrap><bean:message bundle="yxplangroup" key="yxplanname"/></td>
             </tr>
            <c:forEach var="item" items="${requestScope.LIST.datas}">            	 
                 <tr class="table_style_content" align="center">
                     <td>
                         <input type="checkbox" name="_selectitem" value="<c:out value='${item.yxplanid}'/>|<c:out value='${requestScope["/zifee/yxplangroup/YxPlanGroupForm"].groupyxplan}'/>"
                                 class="table_checkbox">
                     </td>
                     <td><c:out value="${item.yxplanid}"/></td>
                     <td><c:out value="${item.yxplanname}"/></td>
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
