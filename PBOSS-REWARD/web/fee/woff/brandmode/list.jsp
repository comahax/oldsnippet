<%@ page language="java" contentType="text/html;charset=GBK"%>
<jsp:include page="/inc/acl.jsp">
  <jsp:param name="PID" value="4D1A1A" />
</jsp:include>
<%@ include file="/inc/listhead.inc" %>
<html>
<head>
    <title><bean:message bundle="brandmode" key="title"/></title>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
			addfield('_se_brand', '<bean:message bundle="brandmode" key="brand"/>', 'c', true, 16);
            addfield('_se_prodid', '<bean:message bundle="brandmode" key="prodid"/>', 'c', true, 32);
            addfield('_se_segid', '<bean:message bundle="brandmode" key="brand"/>', 'c', true, 32);
            addfield('_se_mode', '<bean:message bundle="brandmode" key="mode"/>', 'c', true, 16);
            return checkval(window);
        }
    </script>
</head>

<body onload="loadforiframe();">
<div class="table_container">
<html:form action="/fee/woff/brandmode.do?CMD=LIST" styleId="formList" method="post" onsubmit="return ev_check();">
    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <input type="hidden" name="_rowcount" value="<c:out value='${requestScope.LIST.rowCount}' />">

	
	<div class="table_div">		
		<table class="top_table">
			<tr> 
				<td><bean:message bundle="brandmode" key="title"/></td>
				
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
                <td class="form_table_right"><bean:message bundle="brandmode" key="brand"/>: </td>
                <td class="form_table_left"> 
                    <s:zoom definition="$ProductBrand" property="_se_brand" styleClass="form_input_1x"/>
                </td>        
               
                       
                <td class="form_table_right"><bean:message bundle="brandmode" key="prodid"/>: </td>
                <td class="form_table_left"> 
                <s:zoom definition="#PRODUCT" property="_se_prodid" styleClass="form_input_1x" condition="mainprod:${1};"/>
                </td>         
            </tr> 
            <tr>
                <td class="form_table_right"><bean:message bundle="brandmode" key="segid"/>: </td>
                <td class="form_table_left"> 
                <html:text styleClass="form_input_1x" property="_se_segid"></html:text>
                </td>        
               
                       
                <td class="form_table_right"><bean:message bundle="brandmode" key="mode"/>: </td>
                <td class="form_table_left"> 
                <html:select property="_se_mode">
								<html:option value=" "></html:option>
								<s:Options definition="#BRANDMODE" />
				</html:select>
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
                        value="<bean:message bundle="public" key="button_new"/>" onClick="doNew('/fee/woff/brandmode.do')">
                        
                        <input type="button" name="btnDelete" class="delete" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="<bean:message bundle="public" key="button_delete"/>" onClick="doDelete('/fee/woff/brandmode.do')">
                  	
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
                    <a href="javascript:doOrderby('brand')"><bean:message bundle="brandmode" key="brand"/></a>
                    <s:OrderImg form="/fee/woff/brandmode/BrandModeForm" field="brand"/>
                </td>
                <td>
                     <a href="javascript:doOrderby('prodid')"><bean:message bundle="brandmode" key="prodid"/></a>
                    <s:OrderImg form="/fee/woff/brandmode/BrandModeForm" field="prodid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('segid')"><bean:message bundle="brandmode" key="segid"/></a>
                    <s:OrderImg form="/fee/woff/brandmode/BrandModeForm" field="segid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('mode')"><bean:message bundle="brandmode" key="mode"/></a>
                    <s:OrderImg form="/fee/woff/brandmode/BrandModeForm" field="mode"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('memo')"><bean:message bundle="brandmode" key="memo"/></a>
                    <s:OrderImg form="/fee/woff/brandmode/BrandModeForm" field="memo"/>
                </td>
            </tr>
            <c:forEach var="item" items="${requestScope.LIST.datas}">
                 <c:url value="/fee/woff/brandmode.do?CMD=EDIT" var="urlContent">
                     <c:param name="PK" value="${item.brand}|${item.prodid}|${item.segid}"/>
                 </c:url>
                 <tr class="table_style_content" align="center">
                     <td>
                         <input type="checkbox" name="_selectitem" value="<c:out value='${item.brand}|${item.prodid}|${item.segid}' />"
                                onclick="checkOne();" class="table_checkbox">
                     </td>
                      <td>
                         <a href='<c:out value="${urlContent}"/>'><s:Code2Name definition="$ProductBrand" code="${item.brand}"/></a>
                     </td>
                       <td><s:Code2Name definition="#PRODUCT" code="${item.prodid}"></s:Code2Name>
                     </td>
                     <td><c:out value="${item.segid}"/></td>
                       <td><s:Code2Name definition="#BRANDMODE" code="${item.mode}"></s:Code2Name>
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
