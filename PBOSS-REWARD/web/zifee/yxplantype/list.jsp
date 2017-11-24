<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc" %>
<jsp:include page="/inc/acl.jsp">
  <jsp:param name="PID" value="3C2B4D" />
</jsp:include>
<%
    String ID_1 = "3C2B4DBT1";
    String ID_2 = "3C2B4DBT2";
    String ID_3 = "3C2B4DBT3";
    String ID_4 = "3C2B4DBT4";
%>
<html>
<head>
    <title><bean:message bundle="yxplantype" key="titleList"/></title>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            addfield('_ne_yxplankindid', '<bean:message bundle="yxplantype" key="yxplankindid"/>', 'c', true, 20);            
            return checkval(window);
        }
        
        function doReturn(cmdReturn) {
		    formList.action = contextPath + cmdReturn;
		    formList.submit();
		}
    </script>
</head>

<body onload="document.formList._ne_yxplankindid.focus()">
<div class="table_container">
<html:form action="/zifee/yxplantype.do?CMD=LIST" styleId="formList" method="post" onsubmit="return ev_check();">
    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <input type="hidden" name="_rowcount" value="<c:out value='${requestScope.LIST.rowCount}' />">
	<div class="table_div">
				<table class="top_table">
					<tr>
						<td>
							<bean:message bundle="yxplantype" key="titleList"/>
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
                <td width="126" height="20" align="right" class="form_table_right"><bean:message bundle="yxplantype" key="yxplankindid"/>:</td>
                <td class="form_table_left">
                	<html:select property="_ne_yxplankindid">
	            		<option value=""  ></option>		                		
	            		<s:Options  definition="#ZIFEE-YXPLANKIND"/>
			        </html:select>
                   
                </td> 
                <td width="126" height="20" align="right" class="form_table_right"><bean:message bundle="yxplantype" key="yxplantypename"/>:</td>
                <td class="form_table_left">
                	<html:text styleClass="form_input_1x" property="_sk_yxplantypename"></html:text>
                </td>               
            </tr>
        </table>
    </div>

	<div class="table_div">
				<table class="table_button_list">
					<tr>
						<td>
						<s:PurChk controlid="<%=ID_1%>">
                            <input type="button" name="button_5"  class="button_5" onmouseover="buttonover(this);"
                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                            value="<bean:message bundle="yxplantype" key="newyxplankind"/>" onClick="doReturn('/zifee/yxplankind.do')">
                        </s:PurChk>
                        <s:PurChk controlid="<%=ID_2%>">
                            <input type="button" name="btnNew"  class="add" onmouseover="buttonover(this);"
                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                            value="<bean:message bundle="public" key="button_new" />" onClick="doNew('/zifee/yxplantype.do')">
                        </s:PurChk>
                        <s:PurChk controlid="<%=ID_3%>">
                            <input type="button" name="btnDelete" class="delete" onmouseover="buttonover(this);"
                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                            value="<bean:message bundle="public" key="button_delete"/>" onClick="doDelete('/zifee/yxplantype.do')">
                        </s:PurChk>
                        <s:PurChk controlid="<%=ID_4%>">
                        	<input type="button" class="query" onmouseover="buttonover(this);"
                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                            value="<bean:message bundle="public" key="button_search"/>" onClick="doQuery();">
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
                    <a href="javascript:doOrderby('yxplankindid')"><bean:message bundle="yxplantype" key="yxplankindname"/></a>
                    <s:OrderImg form="/zifee/yxplantype/YxPlanTypeForm" field="yxplankindid"/>
                </td>
                <td>
                    <bean:message bundle="yxplantype" key="yxplantypename"/>                    
                </td>                              
            </tr>
            <c:forEach var="item" items="${requestScope.LIST.datas}">
                 <c:url value="/zifee/yxplantype.do?CMD=EDIT" var="urlContent">                              
                    
                     <c:param name="PK" value="${item.yxplantypeid}"/>
                 </c:url>
                 <tr class="table_style_content" align="center">
                     <td>
                         <input type="checkbox" name="_selectitem" value="<c:out value='${item.yxplantypeid}' />"
                                onclick="checkOne();" class="table_checkbox">
                     </td>
                     <td>
                         <a href='<c:out value="${urlContent}"/>'><c:out value="${item.yxplankindid}"/> - <s:Code2Name code="${item.yxplankindid}" definition="#ZIFEE-YXPLANKIND"/></a>
                     </td>
                     <td>
                         <c:out value="${item.yxplantypeid}"/> - <s:Code2Name code="${item.yxplantypeid}" definition="#ZIFEE-YXPLANTYPE"/>
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
