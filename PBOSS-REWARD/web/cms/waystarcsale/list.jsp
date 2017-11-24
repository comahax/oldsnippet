<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc"%>
<html>
<head>
    <title><bean:message bundle="waystarcsale" key="titleList"/></title>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            return checkval(window);
        }
        function goTo(cmdNew) {
		    var url = contextPath + cmdNew;
		    formList.action = url;
		    formList.submit();
		}
    </script>
</head>

<body onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<html:form action="/cms/waystarcsale.do?CMD=LIST" styleId="formList" method="post" onsubmit="return ev_check();">
    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <input type="hidden" name="_rowcount" value="<c:out value='${requestScope.LIST.rowCount}' />">
    <c:set var="form" scope="request" value="${requestScope['/cms/waystarcsale/WaystarcsaleForm']}"/>

    <!--##################################添加标题内容##################################################-->
    <div class="table_div">
    <table class="top_table">
    	<tr>
    		<td>
    			<bean:message bundle="waystarcsale" key="titleList"/>
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
    			<td width="20%" height="20" align="right" class="form_table_right" >
                	<bean:message bundle="waystarmonth" key="slv" />:
            	</td>
            	<td width="30%" class="form_table_left">
               	 	<html:select property="_ne_slv">
           			<option />
           				<s:Options definition="$CH_STARLEVEL" />
           			</html:select>
            	</td>
            	<td width="20%" height="20" align="right" class="form_table_right" >
            	</td>
            	<td width="30%" class="form_table_left">
            	</td>
            </tr>
        </table>
    </div>
	<div class="table_div">
		<table class="table_button_list">
			<tr> 
                <td align=right>
                        <input type="button" name="btnNew"  class="add" onmouseover="buttonover(this);"
                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                            value="<bean:message bundle="public" key="button_new"/>" onClick="doNew('/cms/waystarcsale.do')">
                        <input type="button" name="btnDelete" class="delete" onmouseover="buttonover(this);"
                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                            value="<bean:message bundle="public" key="button_delete"/>" onClick="doDelete('/cms/waystarcsale.do')">
                        <input type="button" class="query" onmouseover="buttonover(this);" onclick="doQuery();"
                                onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                                value="<bean:message bundle="public" key="button_search"/>" />
                        <input type="button" name="btnQuery" class="query" value="返回" onclick="goTo('/cms/waystarmonth.do?CMD=LIST');" />
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
                    <a href="javascript:doOrderby('slv')"><bean:message bundle="waystarcsale" key="slv"/></a>
                    <s:OrderImg form="/cms/waystarcsale/WaystarcsaleForm" field="slv"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('busivalue')"><bean:message bundle="waystarcsale" key="busivalue"/></a>
                    <s:OrderImg form="/cms/waystarcsale/WaystarcsaleForm" field="busivalue"/>
                </td>
            </tr>
            <c:forEach var="item" items="${requestScope.LIST.datas}">
            	 <c:if test="${item.cityid eq sessionScope._USER.cityid}">
	                 <c:url value="/cms/waystarcsale.do?CMD=EDIT" var="urlContent">
	                     <%//this param name must "PK" %>
	                     <c:param name="PK" value="${item.cityid}|${item.slv}"/>
	                     <%-- <c:param name="PK" value="'${item.id}|${item.id2}'"/> --%>
	                 </c:url>
	                 <tr class="table_style_content" align="center">
	                     <td>
	                         <input type="checkbox" name="_selectitem" value="<c:out value='${item.cityid}|${item.slv}' />"
	                                onclick="checkOne();" class="table_checkbox">
	                     </td>
	                     <td>
	                         <a href='<c:out value="${urlContent}"/>'><s:Code2Name code="${item.slv}" definition="$CH_STARLEVEL" /></a>
	                     </td>
	                     <td><c:out value="${item.busivalue}"/></td>
	                 </tr>
	             </c:if>
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
