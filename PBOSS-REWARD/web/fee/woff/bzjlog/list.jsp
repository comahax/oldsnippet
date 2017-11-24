<%@ page language="java" contentType="text/html;charset=GBK"%>
<jsp:include page="/inc/acl.jsp">
  <jsp:param name="PID" value="4D1A1A" />
</jsp:include>
<%@ include file="/inc/listhead.inc" %>
<html>
<head>
    <title><bean:message bundle="bzjlog" key="title"/></title>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
			addfield('_se_code', '<bean:message bundle="bzjlog" key="code"/>', 'c', true, 20);
            addfield('_dnl_chgtime', '<bean:message bundle="bzjlog" key="timestart"/>', 'dt', true, 20);
            addfield('_dnm_chgtime', '<bean:message bundle="bzjlog" key="timeend"/>', 'dt', true, 20);
            addfield('_se_chgtype', '<bean:message bundle="bzjlog" key="chgtype"/>', 'c', true, 32);
            return checkval(window);
        } 
    </script>
</head>
<body onload="loadforiframe();">
<div class="table_container">
<html:form action="/fee/woff/bzjlog.do?CMD=LIST" styleId="formList" method="post" onsubmit="return ev_check();">
    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <input type="hidden" name="_rowcount" value="<c:out value='${requestScope.LIST.rowCount}' />">

	
	<div class="table_div">		
		<table class="top_table">
			<tr> 
				<td><bean:message bundle="bzjlog" key="title"/></td>
				
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
                <td class="form_table_right"><bean:message bundle="bzjlog" key="code"/>: </td>
                <td class="form_table_left"> 
                    <html:text styleClass="form_input_1x" property="_se_code"></html:text>
                </td>        
                <td class="form_table_right">
                <bean:message bundle="bzjlog" key="chgtype"/>:
                </td>
                <td class="form_table_left">
                <s:zoom definition="#AIRCHGTYPE" property="_se_chgtype" styleClass="form_input_1x" ></s:zoom>
                </td>         
            </tr> 
            <tr>
                <td class="form_table_right">
								<bean:message bundle="bzjlog" key="timestart" />
								>= :
							</td>
							<td class="form_table_left">
								<html:text styleClass="form_input_1x" property="_dnl_chgtime" onclick="this.value=selectDatetime()"></html:text>
							</td>
							<td class="form_table_right">
								<bean:message bundle="bzjlog" key="timeend" />
								<= :
							</td>
							<td class="form_table_left">
								<html:text styleClass="form_input_1x" property="_dnm_chgtime" onclick="this.value=selectDatetime()"></html:text>
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
                    <a href="javascript:doOrderby('dataid')"><bean:message bundle="bzjlog" key="dataid"/></a>
                    <s:OrderImg form="/fee/woff/bzjlog/BzjLogForm" field="dataid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('code')"><bean:message bundle="bzjlog" key="code"/></a>
                    <s:OrderImg form="/fee/woff/bzjlog/BzjLogForm" field="code"/>
                </td>
                <td>
                     <a href="javascript:doOrderby('chgamt')"><bean:message bundle="bzjlog" key="chgamt"/></a>
                    <s:OrderImg form="/fee/woff/bzjlog/BzjLogForm" field="chgamt"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('beforeamt')"><bean:message bundle="bzjlog" key="beforeamt"/></a>
                    <s:OrderImg form="/fee/woff/bzjlog/BzjLogForm" field="beforeamt"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('afteramt')"><bean:message bundle="bzjlog" key="afteramt"/></a>
                    <s:OrderImg form="/fee/woff/bzjlog/BzjLogForm" field="afteramt"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('chgtype')"><bean:message bundle="bzjlog" key="chgtype"/></a>
                    <s:OrderImg form="/fee/woff/bzjlog/BzjLogForm" field="chgtype"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('chgtime')"><bean:message bundle="bzjlog" key="chgtime"/></a>
                    <s:OrderImg form="/fee/woff/bzjlog/BzjLogForm" field="chgtime"/>
                </td>
                
            </tr>
            <c:forEach var="item" items="${requestScope.LIST.datas}">
            <tr class="table_style_content" align="center">
            			<td><c:out value="${item.dataid}"/></td>
                       <td><c:out value="${item.code}"/></td>
                       <td><fmt:formatNumber type="currency" value="${item.chgamt}" /></td>
                       <td><fmt:formatNumber type="currency" value="${item.beforeamt}" /></td>
                       <td><fmt:formatNumber type="currency" value="${item.afteramt}" /></td>
                       <td><c:out value="${item.chgtype}"/></td>
                       <td><fmt:formatDate type="date" pattern="yyyy-MM-dd HH:mm:ss" value="${item.chgtime}" /></td>
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
