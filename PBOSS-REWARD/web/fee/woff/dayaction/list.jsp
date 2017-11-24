<%@ page language="java" contentType="text/html;charset=GBK"%>
<jsp:include page="/inc/acl.jsp">
  <jsp:param name="PID" value="4D1A1A" />
</jsp:include>
<%@ include file="/inc/listhead.inc" %>
<html>
<head>
    <title><bean:message bundle="dayaction" key="title"/></title>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
			addfield('_se_code', '<bean:message bundle="dayaction" key="code"/>', 'c', true, 20);
            addfield('_dnl_datetime', '<bean:message bundle="dayaction" key="timestart"/>', 'dt', true, 20);
            addfield('_dnm_datetime', '<bean:message bundle="dayaction" key="timeend"/>', 'dt', true, 20);
            addfield('_nnl_diffamt', '<bean:message bundle="dayaction" key="mdiffamt"/>', 'l', true, 10);
            addfield('_nnm_diffamt', '<bean:message bundle="dayaction" key="ldiffamt"/>', 'l', true, 10);
            return checkval(window);
        }
    </script>
</head>
<body onload="loadforiframe();">
<div class="table_container">
<html:form action="/fee/woff/dayaction.do?CMD=LIST" styleId="formList" method="post" onsubmit="return ev_check();">
    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <input type="hidden" name="_rowcount" value="<c:out value='${requestScope.LIST.rowCount}' />">

	
	<div class="table_div">		
		<table class="top_table">
			<tr> 
				<td><bean:message bundle="dayaction" key="title"/></td>
				
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
                <td class="form_table_right"><bean:message bundle="dayaction" key="code"/>: </td>
                <td class="form_table_left"> 
                    <html:text styleClass="form_input_1x" property="_se_code"></html:text>
                </td>        
                <td class="form_table_right"></td>
                <td class="form_table_left"></td>         
            </tr> 
            <tr>
                <td class="form_table_right">
								<bean:message bundle="dayaction" key="timestart" />
								>= :
							</td>
							<td class="form_table_left">
								<html:text styleClass="form_input_1x" property="_dnl_datetime" onclick="this.value=selectDatetime()"></html:text>
							</td>
							<td class="form_table_right">
								<bean:message bundle="dayaction" key="timeend" />
								<= :
							</td>
							<td class="form_table_left">
								<html:text styleClass="form_input_1x" property="_dnm_datetime" onclick="this.value=selectDatetime()"></html:text>
							</td>
            </tr> 
             <tr>
                <td class="form_table_right"><bean:message bundle="dayaction" key="diffamt"/>>= : </td>
                <td class="form_table_left"> 
                    <html:text styleClass="form_input_1x" property="_nnl_diffamt"></html:text>
                </td>        
                <td class="form_table_right"><bean:message bundle="dayaction" key="diffamt"/><= : </td>
                <td class="form_table_left"> 
                <html:text styleClass="form_input_1x" property="_nnm_diffamt"></html:text>
                </td>         
            </tr> 
        </table>
    </div>	
	<div class="table_div">		
		<table class="table_button_list">
			<tr>
			   <td>
                  	
                  <input type="button" class="query" onmouseover="buttonover(this);" 
                                onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                                value="<bean:message bundle="public" key="button_search"/>" onclick="doQuery()"/>
               </td>	
			</tr>
		</table>
	</div>
    <div class="table_div">
    	<div class="table_LongTable">
        <table class="table_style" ID="Table2">
            <tr class="table_style_head">
            	<td>
                    <a href="javascript:doOrderby('dataid')"><bean:message bundle="dayaction" key="dataid"/></a>
                    <s:OrderImg form="/fee/woff/dayaction/DayActionForm" field="dataid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('code')"><bean:message bundle="dayaction" key="code"/></a>
                    <s:OrderImg form="/fee/woff/dayaction/DayActionForm" field="code"/>
                </td>
                <td>
                     <a href="javascript:doOrderby('intamt')"><bean:message bundle="dayaction" key="intamt"/></a>
                    <s:OrderImg form="/fee/woff/dayaction/DayActionForm" field="intamt"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('addamt')"><bean:message bundle="dayaction" key="addamt"/></a>
                    <s:OrderImg form="/fee/woff/dayaction/DayActionForm" field="addamt"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('rollamt')"><bean:message bundle="dayaction" key="rollamt"/></a>
                    <s:OrderImg form="/fee/woff/dayaction/DayActionForm" field="rollamt"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('chargeamt')"><bean:message bundle="dayaction" key="chargeamt"/></a>
                    <s:OrderImg form="/fee/woff/dayaction/DayActionForm" field="chargeamt"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('teramt')"><bean:message bundle="dayaction" key="teramt"/></a>
                    <s:OrderImg form="/fee/woff/dayaction/DayActionForm" field="teramt"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('diffamt')"><bean:message bundle="dayaction" key="diffamt"/></a>
                    <s:OrderImg form="/fee/woff/dayaction/DayActionForm" field="diffamt"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('datetime')"><bean:message bundle="dayaction" key="datetime"/></a>
                    <s:OrderImg form="/fee/woff/dayaction/DayActionForm" field="datetime"/>
                </td>
                
            </tr>
            <c:forEach var="item" items="${requestScope.LIST.datas}">
            <tr class="table_style_content" align="center">
            			<td><c:out value="${item.dataid}"/></td>
                       <td><c:out value="${item.code}"/></td>
                       <td><fmt:formatNumber type="currency" value="${item.intamt}" /></td>
                       <td><fmt:formatNumber type="currency" value="${item.addamt}" /></td>
                       <td><fmt:formatNumber type="currency" value="${item.rollamt}" /></td>
                       <td><fmt:formatNumber type="currency" value="${item.chargeamt}" /></td>
                       <td><fmt:formatNumber type="currency" value="${item.teramt}" /></td>
                       <td><fmt:formatNumber type="currency" value="${item.diffamt}" /></td>
                       <td><fmt:formatDate type="date" pattern="yyyy-MM-dd HH:mm:ss" value="${item.datetime}" /></td>
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
