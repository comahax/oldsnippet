<%@ page language="java" contentType="text/html;charset=GBK"%>
<jsp:include page="/inc/acl.jsp">
  <jsp:param name="PID" value="4D1A1A" />
</jsp:include>
<%@ include file="/inc/listhead.inc" %>
<html>
<head>
    <title><bean:message bundle="airoper" key="title"/></title>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
			addfield('_se_operid', '<bean:message bundle="airoper" key="operid"/>', 'c', true, 20);
            addfield('_ne_region', '<bean:message bundle="airoper" key="region"/>', 'i', true, 5);
            addfield('_ne_isrestrict', '<bean:message bundle="airoper" key="isrestrict"/>', 'i', true, 3);
            return checkval(window);
        }
    </script> 
</head>
<body onload="loadforiframe();">
<div class="table_container">
<html:form action="/fee/woff/airoper.do?CMD=LIST" styleId="formList" method="post" onsubmit="return ev_check();">
    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <input type="hidden" name="_rowcount" value="<c:out value='${requestScope.LIST.rowCount}' />">

	
	<div class="table_div">		
		<table class="top_table">
			<tr> 
				<td><bean:message bundle="airoper" key="title"/></td>
				
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
                <td class="form_table_right"><bean:message bundle="airoper" key="operid"/>: </td>
                <td class="form_table_left"> 
                    <html:text styleClass="form_input_1x" property="_se_operid"></html:text>
                </td>        
               
                       
                <td class="form_table_right"><bean:message bundle="airoper" key="region"/>: </td>
                <td class="form_table_left"> 
                    <s:zoom definition="#CITYIDNUM2NMAME" property="_ne_region" styleClass="form_input_1x" nameOnly="false"/>
                </td>         
            </tr> 
            <tr>
                <td class="form_table_right"><bean:message bundle="airoper" key="isrestrict"/>: </td>
                <td class="form_table_left"> 
                    <html:select property="_ne_isrestrict">
								<option></option>
								<s:Options definition="#ISRESTRICT" />
							</html:select>
                </td>        
               
                       
                <td class="form_table_right"> </td>
                <td class="form_table_left"> 
                </td>         
            </tr>     
        </table>
    </div>	
	<div class="table_div">		
		<table class="table_button_list">
			<tr>
			   <td>
                        <input type="button" name="btnNew"  class="add" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="<bean:message bundle="public" key="button_new"/>" onClick="doNew('/fee/woff/airoper.do')">
                        <input type="button" name="btnDelete" class="delete" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="<bean:message bundle="public" key="button_delete"/>" onClick="doDelete('/fee/woff/airoper.do')">
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
                <td title="<bean:message bundle="public" key="list_title_select"/>">
                    <input type="checkbox" name="allbox" onclick="checkAll();" class="table_checkbox">
                </td>
                <td>
                    <a href="javascript:doOrderby('operid')"><bean:message bundle="airoper" key="operid"/></a>
                    <s:OrderImg form="/fee/woff/airoper/AirOperForm" field="operid"/>
                </td>
                <td>
                     <a href="javascript:doOrderby('region')"><bean:message bundle="airoper" key="region"/></a>
                    <s:OrderImg form="/fee/woff/airoper/AirOperForm" field="region"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('opername')"><bean:message bundle="airoper" key="opername"/></a>
                    <s:OrderImg form="/fee/woff/airoper/AirOperForm" field="opername"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('isrestrict')"><bean:message bundle="airoper" key="isrestrict"/></a>
                    <s:OrderImg form="/fee/woff/airoper/AirOperForm" field="isrestrict"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('contactphon')"><bean:message bundle="airoper" key="contactphon"/></a>
                    <s:OrderImg form="/fee/woff/airoper/AirOperForm" field="contactphon"/>
                </td>
            </tr>
            <c:forEach var="item" items="${requestScope.LIST.datas}">
                 <c:url value="/fee/woff/airoper.do?CMD=EDIT" var="urlContent">
                     <c:param name="PK" value="${item.operid}"/>
                 </c:url>
                 <tr class="table_style_content" align="center">
                     <td>
                         <input type="checkbox" name="_selectitem" value="<c:out value='${item.operid}' />"
                                onclick="checkOne();" class="table_checkbox">
                     </td>
                      <td>
                         <a href='<c:out value="${urlContent}"/>'><c:out value="${item.operid}"/></a>
                     </td>
                     <td>
                     <s:Code2Name code="${item.region}" definition="#CITYIDNUM2NMAME"/>
                     </td>
                     <td><c:out value="${item.opername}"/></td>
                     <td>
                     <s:Code2Name code="${item.isrestrict}" definition="#ISRESTRICT"/>
                     </td>
                     <td><c:out value="${item.contactphon}"/></td>
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
