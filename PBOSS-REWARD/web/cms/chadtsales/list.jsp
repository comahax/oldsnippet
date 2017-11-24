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
    <title><bean:message bundle="chadtsales" key="titleList"/></title>
    <script type="text/javascript" src="<%=contextPath%>/js/bus/waycommon.js"></script>
	<script type="text/javascript" src="<%=contextPath%>/js/bus/rescommon.js"></script>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            addfield('_se_opnid', '<bean:message bundle="chadtsales" key="opnid"/>', 'c', 'false', '18');
            addfield('_se_wayattr', '<bean:message bundle="chadtsales" key="wayattr"/>', 'c', 'false', '2');
            return checkval(window);
        }
        
        function doTxt(){ 
		      if(ev_check()){ 
			    formList.action = "<%=contextPath%>/cms/chadtsales.do?CMD=TXT";
        	    formList.submit();
        	    formList.action = "<%=contextPath%>/cms/chadtsales.do?CMD=LIST";
        	}
		} 
		
		 function doImp(){
	    	location.href = "<%=contextPath%>/cms/chadtsales/batch.jsp";
	    }
    </script>
</head>

<body onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<html:form action="/cms/chadtsales.do?CMD=LIST" styleId="formList" method="post" onsubmit="return ev_check();">
    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <input type="hidden" name="_rowcount" value="<c:out value='${requestScope.LIST.rowCount}' />">
    <c:set var="form" scope="request" value="${requestScope['/cms/chadtsales/ChAdtSalesForm']}"/>

    <!--##################################添加标题内容##################################################-->
    <div class="table_div">
    <table class="top_table">
    	<tr>
    		<td>
    			<bean:message bundle="chadtsales" key="titleList"/>
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
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="chadtsales" key="opnid"/>:</td>
                <td width="30%" class="form_table_left">
                <html:text styleClass="form_input_1x" property="_se_opnid" />
                    <input type="button" value="..." class="clickbutton" onclick="showOpnTree2(this, '_se_opnid' , 'busi' )">
                </td>
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="chadtsales" key="wayattr"/>:</td>
                <td width="30%" class="form_table_left">
                    <html:select property="_se_wayattr">
                    	<option />
                    	<s:Options definition="$CH_WAYATTR" />
                    </html:select>
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
                            value="<bean:message bundle="public" key="button_new"/>" onClick="doNew('/cms/chadtsales.do')">
                      <input type="button" name="btnDelete" class="delete" onmouseover="buttonover(this);"
                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                            value="<bean:message bundle="public" key="button_delete"/>" onClick="doDelete('/cms/chadtsales.do')">
                      <input type="button" class="query" onmouseover="buttonover(this);" onclick="doQuery();"
                             onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                             value="<bean:message bundle="public" key="button_search"/>" />
                      <input type="button" class="button_2" onmouseover="buttonover(this);" onclick="doImp();"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="<bean:message bundle="public" key="button_import"/>" />
					<input type="button" class="button_2" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
							onfocus="buttonover(this)" onblur="buttonout(this)" value="导出" onclick="doTxt()"/> 
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
                    <a href="javascript:doOrderby('opnid')"><bean:message bundle="chadtsales" key="opnid"/></a>
                    <s:OrderImg form="/cms/chadtsales/ChadtsalesForm" field="opnid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('wayattr')"><bean:message bundle="chadtsales" key="wayattr"/></a>
                    <s:OrderImg form="/cms/chadtsales/ChadtsalesForm" field="wayattr"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('sales')"><bean:message bundle="chadtsales" key="sales"/></a>
                    <s:OrderImg form="/cms/chadtsales/ChadtsalesForm" field="sales"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('rewardstd')"><bean:message bundle="chadtsales" key="rewardstd"/></a>
                    <s:OrderImg form="/cms/chadtsales/ChadtsalesForm" field="rewardstd"/>
                </td>
            </tr>
            <c:forEach var="item" items="${requestScope.LIST.datas}">
                 <c:url value="/cms/chadtsales.do?CMD=EDIT" var="urlContent">
                     <%//this param name must "PK" %>
                     <c:param name="PK" value="${item.cityid}|${item.opnid}|${item.wayattr}|${item.sales}"/>
                     <%-- <c:param name="PK" value="'${item.id}|${item.id2}'"/> --%>
                 </c:url>
                 <tr class="table_style_content" align="center">
                     <td>
                         <input type="checkbox" name="_selectitem" value="<c:out value='${item.cityid}|${item.opnid}|${item.wayattr}|${item.sales}' />"
                                onclick="checkOne();" class="table_checkbox">
                     </td>
                     <td>
                     <a href='<c:out value="${urlContent}"/>'><c:out value="${item.opnid}"/></a>                     
                     </td>
                     <td> <s:Code2Name code="${item.wayattr}" definition="$CH_WAYATTR"/></td>
                     <td><c:out value="${item.sales}"/></td>
                     <td><c:out value="${item.rewardstd}"/></td>
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
