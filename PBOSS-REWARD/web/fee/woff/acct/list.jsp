<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc" %>
<jsp:include page="/inc/acl.jsp">
  <jsp:param name="PID" value="4D6F1A1A" />
</jsp:include>
<%
	String ID_1 = "4D6F1A1ABT1";
    String ID_2 = "4D6F1A1ABT2";
    String ID_3 = "4D6F1A1ABT3";
    String ID_4 = "4D6F1A1ABT4";
%>
<html>
<head>
    <title><bean:message bundle="acct" key="titleList"/></title>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
        	addfield('_ne_acctid', '<bean:message bundle="acct" key="acctid"/>', 'l', true, 14);
            addfield('_sk_acctname', '<bean:message bundle="acct" key="acctname"/>', 'c', true, 128);
            addfield('_ne_accttype', '<bean:message bundle="acct" key="accttype"/>', 'i', true, 3);
            addfield('_ne_acctstate', '<bean:message bundle="acct" key="acctstate"/>', 'i', true, 3);
            addfield('_ne_acctlevel', '<bean:message bundle="acct" key="acctlevel"/>', 'i', true, 3);
            return checkval(window);
        }
    </script>
</head>

<body onload="loadforiframe();">
<div class="table_container">
<html:form action="/fee/woff/acct.do?CMD=LIST" styleId="formList" method="post" onsubmit="return ev_check();">
    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <html:hidden property="startindex"/>
    <html:hidden property="endindex"/>
    <input type="hidden" name="_rowcount" value="<c:out value='${requestScope.LIST.rowCount}' />">

	<div class="table_div">	
		<table class="top_table">
			<tr> 
				<td><bean:message bundle="acct" key="custMsg"/></td>				 
            	
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
            	<td class="form_table_right"><bean:message bundle="acct" key="acctid"/>:</td>
                <td class="form_table_left">
                	<html:text styleClass="form_input_1x" property="_ne_acctid"  maxlength="14"></html:text>
                </td>
                <td class="form_table_right"><bean:message bundle="acct" key="acctname"/>:</td>
                <td class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_sk_acctname"  maxlength="128"></html:text>
                </td>
            </tr>
            <tr>
                <td class="form_table_right"><bean:message bundle="acct" key="accttype"/>:</td>
                <td class="form_table_left">
                    <html:select property="_ne_accttype">
                    	<html:option value=""></html:option>
                    	<s:Options definition="$IB_FEETYPE" nameOnly="false"/>
                    </html:select>
                </td>
                <td class="form_table_right"><bean:message bundle="acct" key="acctlevel"/>:</td>
                <td class="form_table_left">
                    <html:select property="_ne_acctlevel">
                    	<html:option value=""></html:option>
                    	<s:Options definition="$IB_FEELEVEL" nameOnly="false"/>
                    </html:select>
                </td>
            </tr>
        </table>
    </div>


    
	<div class="table_div">
		
		<table class="table_button_list">
			<tr>
			   <td>  
			  		<s:PurChk controlid="<%=ID_1%>">
			  		<c:choose>
                        <c:when test="${created}">
                            <input type="button" name="btnNew"  class="add" onmouseover="buttonover(this);" 
                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                            value="<bean:message bundle="public" key="button_new"/>" onClick="doNew('/fee/woff/acct.do')"/>
                        </c:when>
                        <c:otherwise>
                            <input type="button" name="btnNew"  class="add" onmouseover="buttonover(this);" 
                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                            value="<bean:message bundle="public" key="button_new"/>" 
                            onClick="doNew('/fee/woff/acct.do')" disabled="disabled"/>
                        </c:otherwise>
                    </c:choose>			   		
                    </s:PurChk>
                    <s:PurChk controlid="<%=ID_2%>">
                    <c:choose>
                        <c:when test="${destroy}">
                            <input type="button" name="btnDelete" class="delete" onmouseover="buttonover(this);" 
                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                            value="<bean:message bundle="public" key="button_delete"/>" onClick="doDelete('/fee/woff/acct.do')"/>
                        </c:when>
                        <c:otherwise>
                           <input type="button" name="btnDelete" class="delete" onmouseover="buttonover(this);"                             
                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                            value="<bean:message bundle="public" key="button_delete"/>" 
                            onClick="doDelete('/fee/woff/acct.do')" disabled="disabled" />
                        </c:otherwise>
                    </c:choose>	
                    </s:PurChk>
                 	<s:PurChk controlid="<%=ID_3%>">
                 	<input type="button" class="query" onmouseover="buttonover(this);" 
                                onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                                value="<bean:message bundle="public" key="button_search"/>" onclick="doQuery()"/>
                 	</s:PurChk>
                 	<s:PurChk controlid="<%=ID_4%>">
                 	<input type="button" class="query" onmouseover="buttonover(this);" 
                                onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                                value="<bean:message bundle="public" key="button_export"/>" onclick="doExcelOut('/fee/woff/acct.do?CMD=EXCELOUT')"/>
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
                    <a href="javascript:doOrderby('acctid')"><bean:message bundle="acct" key="acctid"/></a>
                    <s:OrderImg form="/fee/woff/acct/AcctForm" field="acctid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('acctname')"><bean:message bundle="acct" key="acctname"/></a>
                    <s:OrderImg form="/fee/woff/acct/AcctForm" field="acctname"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('accttype')"><bean:message bundle="acct" key="accttype"/></a>
                    <s:OrderImg form="/fee/woff/acct/AcctForm" field="accttype"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('acctstate')"><bean:message bundle="acct" key="acctstate"/></a>
                    <s:OrderImg form="/fee/woff/acct/AcctForm" field="acctstate"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('starttime')"><bean:message bundle="acct" key="starttime"/></a>
                    <s:OrderImg form="/fee/woff/acct/AcctForm" field="starttime"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('stoptime')"><bean:message bundle="acct" key="stoptime"/></a>
                    <s:OrderImg form="/fee/woff/acct/AcctForm" field="stoptime"/>
                </td>  
                <td>
                    <a href="javascript:doOrderby('acctlevel')"><bean:message bundle="acct" key="acctlevel"/></a>
                    <s:OrderImg form="/fee/woff/acct/AcctForm" field="acctlevel"/>
                </td>
               	<td>
                    <a href="javascript:doOrderby('limitflag')"><bean:message bundle="acct" key="limitflag"/></a>
                    <s:OrderImg form="/fee/woff/acct/AcctForm" field="limitflag"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('woffpri')"><bean:message bundle="acct" key="woffpri"/></a>
                    <s:OrderImg form="/fee/woff/acct/AcctForm" field="woffpri"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('acctcode')"><bean:message bundle="acct" key="acctcode"/></a>
                    <s:OrderImg form="/fee/woff/acct/AcctForm" field="acctcode"/>
                </td>  
                <td>
                    <a href="javascript:doOrderby('printname')"><bean:message bundle="acct" key="printname"/></a>
                    <s:OrderImg form="/fee/woff/acct/AcctForm" field="printname"/>
                </td>
                
            </tr>
            
            <c:forEach var="item" items="${requestScope.LIST.datas}">
                 <c:url value="/fee/woff/acct.do?CMD=${update}" var="urlContent">
                     <c:param name="PK" value="${item.acctid}"/>
                 </c:url>
                 <tr class="table_style_content">
                     <td>
                         <input type="checkbox" name="_selectitem" value="<c:out value='${item.acctid}' />"
                                onclick="checkOne();" class="table_checkbox">
                     </td>
                     <td>
                         <a href='<c:out value="${urlContent}"/>'><c:out value="${item.acctid}"/></a>
                     </td>
                     <td>
                         <a href='<c:out value="${urlContent}"/>'><c:out value="${item.acctname}"/></a>
                     </td>
                     <td><c:out value="${item.accttype}"/>&nbsp;<s:Code2Name code="${item.accttype}" definition="$IB_FEETYPE"/></td>
                     <td><c:out value="${item.acctstate}"/>&nbsp;<s:Code2Name code="${item.acctstate}" definition="$IB_ACCTSTATE"/></td>
                     <td><c:out value="${item.starttime}"/></td>
                     <td><c:out value="${item.stoptime}"/></td>
                     <td><c:out value="${item.acctlevel}"/>&nbsp;<s:Code2Name code="${item.acctlevel}" definition="$IB_FEELEVEL"/></td>
                     <td><c:out value="${item.limitflag}"/></td>
                     <td><c:out value="${item.woffpri}"/></td>
                     <td><c:out value="${item.acctcode}"/></td>
                     <td><c:out value="${item.printname}"/></td>
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
