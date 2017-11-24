<%@ page language="java" contentType="text/html;charset=GBK"%>
<jsp:include page="/inc/acl.jsp">
  <jsp:param name="PID" value="4D1A1A" />
</jsp:include>
<%@ include file="/inc/listhead.inc" %>
<% 
    String ID_1 = "4D1A1ABT1";
    String ID_2 = "4D1A1ABT2";

%>
<html>
<head>
    <title><bean:message bundle="airczycrule" key="title"/></title>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
			addfield('_ne_chargeamt', '<bean:message bundle="airczycrule" key="chargeamt"/>', 'l', true, 8);
            addfield('_sk_prodid', '<bean:message bundle="airczycrule" key="prodid"/>', 'c', true, 32);
            return checkval(window);
        }
    </script>
</head>

<body onload="loadforiframe();">
<div class="table_container">
<html:form action="/fee/woff/airczycrule.do?CMD=LIST" styleId="formList" method="post" onsubmit="return ev_check();">
    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <input type="hidden" name="_rowcount" value="<c:out value='${requestScope.LIST.rowCount}' />">

	
	<div class="table_div">		
		<table class="top_table">
			<tr> 
				<td><bean:message bundle="airczycrule" key="title"/></td>
				
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
                <td class="form_table_right"><bean:message bundle="airczycrule" key="chargeamt"/>: </td>
                <td class="form_table_left"> 
                    <html:text styleClass="form_input_1x" property="_ne_chargeamt"></html:text>
                </td>        
               
                       
                <td class="form_table_right"><bean:message bundle="airczycrule" key="prodid"/>: </td>
                <td class="form_table_left"> 
                    
                    <s:MoreCheck definition="#PRODID" property="_sk_prodid" styleClass="form_input_1x"/>
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
                        value="<bean:message bundle="public" key="button_new"/>" onClick="doNew('/fee/woff/airczycrule.do')">
                  </s:PurChk>
                  <s:PurChk controlid="<%=ID_2%>">
                        <input type="button" name="btnDelete" class="delete" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="<bean:message bundle="public" key="button_delete"/>" onClick="doDelete('/fee/woff/airczycrule.do')">
                  </s:PurChk>
                  <s:PurChk controlid="<%=ID_2%>">
                  <input type="button" class="query" onmouseover="buttonover(this);" 
                                onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                                value="<bean:message bundle="public" key="button_search"/>" onclick="doQuery()"/>
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
                    <a href="javascript:doOrderby('ruleid')"><bean:message bundle="airczycrule" key="ruleid"/></a>
                    <s:OrderImg form="/fee/woff/airczycrule/AirczycRuleForm" field="ruleid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('chargeamt')"><bean:message bundle="airczycrule" key="chargeamt"/></a>
                    <s:OrderImg form="/fee/woff/airczycrule/AirczycRuleForm" field="chargeamt"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('starttime')"><bean:message bundle="airczycrule" key="starttime"/></a>
                    <s:OrderImg form="/fee/woff/airczycrule/AirczycRuleForm" field="starttime"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('presentmonths')"><bean:message bundle="airczycrule" key="presentmonths"/></a>
                    <s:OrderImg form="/fee/woff/airczycrule/AirczycRuleForm" field="presentmonths"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('pri')"><bean:message bundle="airczycrule" key="pri"/></a>
                    <s:OrderImg form="/fee/woff/airczycrule/AirczycRuleForm" field="pri"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('presentamt')"><bean:message bundle="airczycrule" key="presentamt"/></a>
                    <s:OrderImg form="/fee/woff/airczycrule/AirczycRuleForm" field="presentamt"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('presentacctid')"><bean:message bundle="airczycrule" key="presentacctid"/></a>
                    <s:OrderImg form="/fee/woff/airczycrule/AirczycRuleForm" field="presentacctid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('zsdate')"><bean:message bundle="airczycrule" key="zsdate"/></a>
                    <s:OrderImg form="/fee/woff/airczycrule/AirczycRuleForm" field="zsdate"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('zsmonths')"><bean:message bundle="airczycrule" key="zsmonths"/></a>
                    <s:OrderImg form="/fee/woff/airczycrule/AirczycRuleForm" field="zsmonths"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('prodid')"><bean:message bundle="airczycrule" key="prodid"/></a>
                    <s:OrderImg form="/fee/woff/airczycrule/AirczycRuleForm" field="prodid"/>
                </td>
                
                <td>
                    <a href="javascript:doOrderby('memo')"><bean:message bundle="airczycrule" key="memo"/></a>
                    <s:OrderImg form="/fee/woff/airczycrule/AirczycRuleForm" field="memo"/>
                </td>
                
            </tr>
            <c:forEach var="item" items="${requestScope.LIST.datas}">
                 <c:url value="/fee/woff/airczycrule.do?CMD=EDIT" var="urlContent">
                     <c:param name="PK" value="${item.ruleid}"/>
                 </c:url>
                 <tr class="table_style_content" align="center">
                     <td>
                         <input type="checkbox" name="_selectitem" value="<c:out value='${item.ruleid}' />"
                                onclick="checkOne();" class="table_checkbox">
                     </td>
                      <td>
                         <a href='<c:out value="${urlContent}"/>'><c:out value="${item.ruleid}"/></a>
                     </td>
                     <td><c:out value="${item.chargeamt}"/></td>
                     <td><fmt:formatDate type="date" 
                     			pattern="yyyy-MM-dd HH:mm:ss" value="${item.starttime}" /></td>
                     <td><c:out value="${item.presentmonths}"/></td>
                      <td><c:out value="${item.pri}"/></td>			
                     <td><c:out value="${item.presentamt}"/></td>
                     <td><s:Code2Name definition="#PRESENTACCTID" code="${item.presentacctid}"></s:Code2Name>
                     </td>
                     <td><fmt:formatDate type="date" 
                     			pattern="yyyy-MM-dd" value="${item.zsdate}" /></td>
                     <td><c:out value="${item.zsmonths}"/></td>	
                     <td>
                     <s:MoreCode2Name code="${item.prodid}" definition="#PRODID" />
                     </td>
                    
                     <td><c:out value="${item.memo}"/></td>
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
