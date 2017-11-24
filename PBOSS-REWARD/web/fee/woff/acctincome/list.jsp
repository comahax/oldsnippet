<%@ page language="java" contentType="text/html;charset=GBK"%>
<jsp:include page="/inc/acl.jsp">
  <jsp:param name="PID" value="4D1A1A" />
</jsp:include>
<%@ include file="/inc/listhead.inc" %>
<html>
<head>
    <title><bean:message bundle="acctincome" key="title"/></title>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
			addfield('_ne_acctid', '<bean:message bundle="acctincome" key="acctid"/>', 'l', true, 14);
            addfield('_se_acctcode', '<bean:message bundle="acctincome" key="acctcode"/>', 'c', true, 32);
            addfield('_ne_type', '<bean:message bundle="acctincome" key="type"/>', 'l', true, 3);
            return checkval(window);
        }
    </script>
</head>

<body onload="loadforiframe();">
<div class="table_container">
<html:form action="/fee/woff/acctincome.do?CMD=LIST" styleId="formList" method="post" onsubmit="return ev_check();">
    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <html:hidden property="startindex" />
	<html:hidden property="endindex" />
    <input type="hidden" name="_rowcount" value="<c:out value='${requestScope.LIST.rowCount}' />">

	
	<div class="table_div">		
		<table class="top_table">
			<tr> 
				<td><bean:message bundle="acctincome" key="title"/></td>
				
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
                <td class="form_table_right"><bean:message bundle="acctincome" key="acctid"/>: </td>
                <td class="form_table_left"> 
                    <s:zoom definition="#WOFF-ACCT" property="_ne_acctid" styleClass="form_input_1x"/>
                </td>        
               
                       
                <td class="form_table_right"><bean:message bundle="acctincome" key="acctcode"/>: </td>
                <td class="form_table_left"> 
                    
                    <html:text styleClass="form_input_1x" property="_se_acctcode"></html:text>
                </td>         
            </tr> 
             <tr>
                <td class="form_table_right"><bean:message bundle="acctincome" key="type"/>: </td>
                <td class="form_table_left"> 
                <s:zoom definition="#ACCTTCODEYPE" property="_ne_type" styleClass="form_input_1x"/>
                </td>        
                       
                <td class="form_table_right"> </td>
                <td class="form_table_left"></td>         
            </tr>   
        </table>
    </div>	
	<div class="table_div">		
		<table class="table_button_list">
			<tr>
			   <td>
                       <s:PurChk2 controlid="ACCTINCOME_NEW" disableChild="true"> 
                        <input type="button" name="btnNew"  class="add" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="<bean:message bundle="public" key="button_new"/>" onClick="doNew('/fee/woff/acctincome.do')">
                       </s:PurChk2>
                        <s:PurChk2 controlid="ACCTINCOME_DET" disableChild="true">
                        <input type="button" name="btnDelete" class="delete" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="<bean:message bundle="public" key="button_delete"/>" onClick="doDelete('/fee/woff/acctincome.do')">
                  		</s:PurChk2>
                  <input type="button" class="query" onmouseover="buttonover(this);" 
                                onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                                value="<bean:message bundle="public" key="button_search"/>" onclick="doQuery()"/>
                    <s:PurChk2 controlid="ACCTINCOME_XLS" disableChild="true">
                    <input type="button" class="query" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="<bean:message bundle="public" key="button_export"/>" onclick="doExcelOut('/fee/woff/acctincome.do?CMD=EXCELOUT')"/>
               		</s:PurChk2>
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
                    <a href="javascript:doOrderby('acctid')"><bean:message bundle="acctincome" key="acctid"/></a>
                    <s:OrderImg form="/fee/woff/acctincome/AcctIncomeForm" field="acctid"/>
                </td>
                <td>
                     <a href="javascript:doOrderby('acctid')"><bean:message bundle="acctincome" key="acctname"/></a>
                    <s:OrderImg form="/fee/woff/acctincome/AcctIncomeForm" field="acctid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('acctcode')"><bean:message bundle="acctincome" key="acctcode"/></a>
                    <s:OrderImg form="/fee/woff/acctincome/AcctIncomeForm" field="acctcode"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('acctcodename')"><bean:message bundle="acctincome" key="acctcodename"/></a>
                    <s:OrderImg form="/fee/woff/acctincome/AcctIncomeForm" field="acctcodename"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('type')"><bean:message bundle="acctincome" key="type"/></a>
                    <s:OrderImg form="/fee/woff/acctincome/AcctIncomeForm" field="type"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('isresolution')"><bean:message bundle="acctincome" key="isresolution"/></a>
                    <s:OrderImg form="/fee/woff/acctincome/AcctIncomeForm" field="isresolution"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('descri')"><bean:message bundle="acctincome" key="descri"/></a>
                    <s:OrderImg form="/fee/woff/acctincome/AcctIncomeForm" field="descri"/>
                </td>
            </tr>
            <c:forEach var="item" items="${requestScope.LIST.datas}">
                 <c:url value="/fee/woff/acctincome.do?CMD=EDIT" var="urlContent">
                     <c:param name="PK" value="${item.acctid}"/>
                 </c:url>
                 <tr class="table_style_content" align="center">
                     <td>
                         <input type="checkbox" name="_selectitem" value="<c:out value='${item.acctid}' />"
                                onclick="checkOne();" class="table_checkbox">
                     </td>
                      <td>
                      <s:PurChk2 controlid="ACCTINCOME_EDIT" disableChild="true">
                         <a href='<c:out value="${urlContent}"/>'><c:out value="${item.acctid}"/></a>
                         </s:PurChk2>
                     </td>
                       <td><s:Code2Name definition="#WOFF-ACCT" code="${item.acctid}"></s:Code2Name>
                     </td>
                     
                     
                     <td><c:out value="${item.acctcode}"/></td>
                     <td><c:out value="${item.acctcodename}"/></td>
                     <td><s:Code2Name definition="#ACCTTCODEYPE" code="${item.type}"></s:Code2Name></td>
                     <td><s:Code2Name definition="$IB_YESNO10" code="${item.isresolution}"></s:Code2Name></td>
                     <td><c:out value="${item.descri}"/></td>
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
