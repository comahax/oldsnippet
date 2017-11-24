<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc"%>
<%
    String ID_1 = "00010701";
    String ID_2 = "00010702";
    String ID_3 = "00010703";
    String ID_4 = "00010704";
%>
<html>
<head>
    <title><bean:message bundle="chpdentproduct" key="titleList"/></title>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            addfield('_se_prodid', '<bean:message bundle="chpdentproduct" key="prodid"/>', 'c', 'false', '15');
            addfield('_sk_prodname', '<bean:message bundle="chpdentproduct" key="prodname"/>', 'c', 'false', '30');
            addfield('_se_category', '<bean:message bundle="chpdentproduct" key="category"/>', 'c', 'false', '16');
            addfield('_se_subcategory', '<bean:message bundle="chpdentproduct" key="subcategory"/>', 'c', 'false', '16');
            return checkval(window);
        }
        function doExcel(){ 
		    if( ev_check() ){
		    	formList.action = "<%=contextPath%>/cms/provagent/chpdentproduct.do?CMD=EXCEL";
	        	formList.submit();
	        	formList.action = "<%=contextPath%>/cms/provagent/chpdentproduct.do?CMD=LIST";
		    }			
		}
    </script>
</head>

<body onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<html:form action="/cms/provagent/chpdentproduct.do?CMD=LIST" styleId="formList" method="post" onsubmit="return ev_check();">
    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <input type="hidden" name="_rowcount" value="<c:out value='${requestScope.LIST.rowCount}' />">
    <c:set var="form" scope="request" value="${requestScope['/cms/provagent/chpdentproduct/ChPdEntproductForm']}"/>

    <!--##################################添加标题内容##################################################-->
    <div class="table_div">
    <table class="top_table">
    	<tr>
    		<td>
    			<bean:message bundle="chpdentproduct" key="titleList"/>
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
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="chpdentproduct" key="prodid"/>:</td>
                <td width="30%" class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_se_prodid"></html:text>
                </td>
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="chpdentproduct" key="prodname"/>:</td>
                <td width="30%" class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_sk_prodname"></html:text>
                </td>
            </tr>
            <tr>
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="chpdentproduct" key="category"/>:</td>
                <td width="30%" class="form_table_left">
<%--                    <html:text styleClass="form_input_1x" property="_se_category"></html:text>--%>
					<html:select property="_se_category">
						<option/>
						<s:Options definition="$PD_JTCPLX" />
					</html:select>
                </td>
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="chpdentproduct" key="subcategory"/>:</td>
                <td width="30%" class="form_table_left">
<%--                    <html:text styleClass="form_input_1x" property="_se_subcategory"></html:text>--%>
                    <html:select property="_se_subcategory">
                    	<option/>
						<s:Options definition="$PD_JTCPZLX" condition="subcategory:${param._se_subcategory}"/>
					</html:select>
                </td>
            </tr>
        </table>
    </div>
	<div class="table_div">
		<table class="table_button_list">
			<tr> 
                <td align=right>
                       <input type="button" class="query" onmouseover="buttonover(this);" onclick="doQuery();"
                                onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                                value="<bean:message bundle="public" key="button_search"/>" />
                       <input type="button" name="btnNew"  class="add" onmouseover="buttonover(this);"
                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                            value="<bean:message bundle="public" key="button_new"/>" onClick="doNew('/cms/provagent/chpdentproduct.do')">
<%--                        <s:PurChk controlid="<%=ID_2%>">--%>
<%--                            <input type="button" name="btnDelete" class="delete" onmouseover="buttonover(this);"--%>
<%--                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"--%>
<%--                            value="<bean:message bundle="public" key="button_delete"/>" onClick="doDelete('/cms/provagent/chpdentproduct.do')">--%>
<%--                        </s:PurChk>--%>
                        <input type="button" class="button_4" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
							onfocus="buttonover(this)" onblur="buttonout(this)" 
							value="导出EXCEL" onclick="doExcel()"/>
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
                    <a href="javascript:doOrderby('prodid')"><bean:message bundle="chpdentproduct" key="prodid"/></a>
                    <s:OrderImg form="/cms/provagent/chpdentproduct/ChpdentproductForm" field="prodid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('prodname')"><bean:message bundle="chpdentproduct" key="prodname"/></a>
                    <s:OrderImg form="/cms/provagent/chpdentproduct/ChpdentproductForm" field="prodname"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('category')"><bean:message bundle="chpdentproduct" key="category"/></a>
                    <s:OrderImg form="/cms/provagent/chpdentproduct/ChpdentproductForm" field="category"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('subcategory')"><bean:message bundle="chpdentproduct" key="subcategory"/></a>
                    <s:OrderImg form="/cms/provagent/chpdentproduct/ChpdentproductForm" field="subcategory"/>
                </td>
            </tr>
            <c:forEach var="item" items="${requestScope.LIST.datas}">
                 <c:url value="/cms/provagent/chpdentproduct.do?CMD=EDIT" var="urlContent">
                     <%//this param name must "PK" %>
                     <c:param name="PK" value="${item.prodid}"/>
                     <%-- <c:param name="PK" value="'${item.id}|${item.id2}'"/> --%>
                 </c:url>
                 <tr class="table_style_content" align="center">
                     <td>
                         <input type="checkbox" name="_selectitem" value="<c:out value='${item.prodid}' />"
                                onclick="checkOne();" class="table_checkbox">
                     </td>
                     <td>
                         <a href='<c:out value="${urlContent}"/>'><c:out value="${item.prodid}"/></a>
                     </td>
                     <td><c:out value="${item.prodname}"/></td>
                     <td><s:Code2Name code="${item.category}" definition="$PD_JTCPLX"/></td>
                     <td><s:Code2Name code="${item.subcategory}" definition="$PD_JTCPZLX"/></td>
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
