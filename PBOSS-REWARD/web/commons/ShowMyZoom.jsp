<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc" %>

<html:html>
	<head>
		<title><bean:message bundle="public" key="choosedata"/></title>
		<base target="_self">
	<script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            addfield('code', '<bean:message bundle="public" key="code"/>', 'c', true, 50);
            addfield('name', '<bean:message bundle="public" key="name"/>', 'c', true, 50);            
            return checkval(window);
        }
        
        function keyDown()
		{   
		    if (window.event.keyCode == 13)
		    {	
		    	formList.action = "<%=contextPath%>/myzoom.do?CMD=LIST";
		    	formList.submit();
		    }else{
		    	return;
		    }
		}
    </script>
	<body onload="loadforiframe()">		
		<html:form action="/myzoom.do?CMD=LIST" styleId="formList" method="post" onsubmit="return ev_check();">
		<html:hidden property="definition"/>
		<html:hidden property="condition"/>
		
		<div class="table_container">
		
		<div class="table_div">
			<table class="top_table">
		     <tr>
		      <td>
		       <bean:message bundle="public" key="choosedata"/>
		      </td>
		     </tr>
		    </table>
		</div>
         <c:if test="${PAGEFLAG}" >
	         <div class="table_div">  
				<table class="form_table">
					<tr>
						<td class="form_table_right"><bean:message bundle="public" key="code"/></td>
						<td class="form_table_left"><html:text property="code" styleClass="form_input_1x" onkeyup="keyDown()"/></td>
						
						<td class="form_table_right"><bean:message bundle="public" key="name"/></td>
						<td class="form_table_left"><html:text property="name" styleClass="form_input_1x" onkeyup="keyDown()"/></td>
					</tr>
				</table>
			</div>
			 <div class="table_div">
		        <table class="table_button_list">
		            <tr>
		                <td width="100%" class="form_table_right">
		                	<input type="button" value="<bean:message bundle="public" key="button_search"/>" onclick="doQuery();" class="comfir" onmouseover="buttonover(this)" onmouseout="buttonout(this)" onfocus="buttonover(this)" onblur="buttonout(this)" ID="Button1" NAME="Button6">
		                </td>
		            </tr>
		        </table>
		    </div>
	    </c:if>
		<div class="table_div">
		<html:hidden property="_orderby"/>
    	<html:hidden property="_desc"/>
    	<html:hidden property="_pageno"/>
    	<html:hidden property="_pagesize"/>
    	<input type="hidden" name="_rowcount" value="<c:out value='${requestScope.LIST.rowCount}' />">
			<table class="table_style">
				<THEAD>
					<tr class="table_style_head">
						<td><bean:message bundle="public" key="code"/></td>
						<td><bean:message bundle="public" key="name"/></td>			
					</tr>
				</THEAD>
				<TBODY>
				<tr class="table_style_content" align="center">
						<td><a href="javascript:selme(' ',' ')" ><bean:message bundle="public" key="empty"/></td>
						<td><bean:message bundle="public" key="empty"/></td>
					</tr>
				<c:forEach var="item" items="${requestScope.LIST.datas}">
					<tr class="table_style_content" align="center">
						<td><a href="javascript:selme('<c:out value="${item.code}"/>','<c:out value="${item.name}"/>')" ><c:out value="${item.code}"/></td>
						<td><c:out value="${item.name}"/></td>
					</tr>
				</c:forEach>
				</TBODY>			
			</table>
		</div>
		<c:if test="${PAGEFLAG}" >
		<div class="table_div" >
				<s:PageNav dpName="LIST"/>
		</div>
		</c:if>
	</div>
	</html:form>
</body>
</html:html>
<script language="JavaScript" type="text/JavaScript">
    function selme( code, name ) {
		self.returnValue = code + ";" + name ;
		self.close();
	}
</script>
