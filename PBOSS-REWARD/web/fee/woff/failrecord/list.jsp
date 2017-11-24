<%@ page language="java" contentType="text/html;charset=GBK"%>
<jsp:include page="/inc/acl.jsp">
  <jsp:param name="PID" value="4D1A1A" />
</jsp:include>
<%@ include file="/inc/listhead.inc" %>
<html>
<head> 
    <title><bean:message bundle="failrecord" key="title"/></title>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
			addfield('_se_code', '<bean:message bundle="failrecord" key="code"/>', 'c', true, 20);
            addfield('_dnl_datetime', '<bean:message bundle="failrecord" key="timestart"/>', 'dt', true, 20);
            addfield('_dnm_datetime', '<bean:message bundle="failrecord" key="timeend"/>', 'dt', true, 20);
            addfield('_se_errortype', '<bean:message bundle="failrecord" key="errortype"/>', 'c', true, 32);
            return checkval(window);
        }
    </script>
</head>
<body onload="loadforiframe();">
<div class="table_container">
<html:form action="/fee/woff/failrecord.do?CMD=LIST" styleId="formList" method="post" onsubmit="return ev_check();">
    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <input type="hidden" name="_rowcount" value="<c:out value='${requestScope.LIST.rowCount}' />">

	
	<div class="table_div">		
		<table class="top_table">
			<tr> 
				<td><bean:message bundle="failrecord" key="title"/></td>
				
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
                <td class="form_table_right"><bean:message bundle="failrecord" key="code"/>: </td>
                <td class="form_table_left"> 
                    <html:text styleClass="form_input_1x" property="_se_code"></html:text>
                </td>        
                <td class="form_table_right">
                <bean:message bundle="failrecord" key="errortype"/>:
                </td>
                <td class="form_table_left">
                <s:zoom definition="#ERRORTYPE" property="_se_errortype" styleClass="form_input_1x" ></s:zoom>
                </td>         
            </tr> 
            <tr>
                <td class="form_table_right">
								<bean:message bundle="failrecord" key="timestart" />
								>= :
							</td>
							<td class="form_table_left">
								<html:text styleClass="form_input_1x" property="_dnl_datetime" onclick="this.value=selectDatetime()"></html:text>
							</td>
							<td class="form_table_right">
								<bean:message bundle="failrecord" key="timeend" />
								<= :
							</td>
							<td class="form_table_left">
								<html:text styleClass="form_input_1x" property="_dnm_datetime" onclick="this.value=selectDatetime()"></html:text>
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
                    <a href="javascript:doOrderby('dataid')"><bean:message bundle="failrecord" key="dataid"/></a>
                    <s:OrderImg form="/fee/woff/failrecord/FailRecordForm" field="dataid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('code')"><bean:message bundle="failrecord" key="code"/></a>
                    <s:OrderImg form="/fee/woff/failrecord/FailRecordForm" field="code"/>
                </td>
                <td>
                     <a href="javascript:doOrderby('errortype')"><bean:message bundle="failrecord" key="errortype"/></a>
                    <s:OrderImg form="/fee/woff/failrecord/FailRecordForm" field="errortype"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('addamt')"><bean:message bundle="failrecord" key="addamt"/></a>
                    <s:OrderImg form="/fee/woff/failrecord/FailRecordForm" field="addamt"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('busiamt')"><bean:message bundle="failrecord" key="busiamt"/></a>
                    <s:OrderImg form="/fee/woff/failrecord/FailRecordForm" field="busiamt"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('redo')"><bean:message bundle="failrecord" key="redo"/></a>
                    <s:OrderImg form="/fee/woff/failrecord/FailRecordForm" field="redo"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('redoamt')"><bean:message bundle="failrecord" key="redoamt"/></a>
                    <s:OrderImg form="/fee/woff/failrecord/FailRecordForm" field="redoamt"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('undoamt')"><bean:message bundle="failrecord" key="undoamt"/></a>
                    <s:OrderImg form="/fee/woff/failrecord/FailRecordForm" field="undoamt"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('datetime')"><bean:message bundle="failrecord" key="datetime"/></a>
                    <s:OrderImg form="/fee/woff/failrecord/FailRecordForm" field="datetime"/>
                </td>
                
            </tr>
            <c:forEach var="item" items="${requestScope.LIST.datas}">
            <tr class="table_style_content" align="center">
                       <td><c:out value="${item.dataid}"/></td>
                       <td><c:out value="${item.code}"/></td>
                       <td><c:out value="${item.errortype}"/></td>
                       <td><fmt:formatNumber type="currency" value="${item.addamt}" /></td>
                       <td><fmt:formatNumber type="currency" value="${item.busiamt}" /></td>
                       <td><c:out value="${item.redo}"/></td>
                       <td><fmt:formatNumber type="currency" value="${item.redoamt}" /></td>
                       <td><fmt:formatNumber type="currency" value="${item.undoamt}" /></td>
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
