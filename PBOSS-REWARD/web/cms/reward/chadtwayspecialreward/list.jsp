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
    <title><bean:message bundle="chadtwayspecialreward" key="titleList"/></title>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            addfield('_se_wayid', '<bean:message bundle="chadtwayspecialreward" key="wayid"/>', 'c', 'false', '18');
            addfield('_se_wayspetype', '<bean:message bundle="chadtwayspecialreward" key="wayspetype"/>', 'c', 'false', '8');
            addfield('_se_cityid', '<bean:message bundle="chadtwayspecialreward" key="cityid"/>', 'c', 'false', '3');
            addfield('_dnm_createdate', '<bean:message bundle="chadtwayspecialreward" key="createdate"/>', 't', 'false', '7');
            addfield('_dnl_createdate', '<bean:message bundle="chadtwayspecialreward" key="createdate"/>', 't', 'false', '7');
            return checkval(window);
        }
        function doExcel(){ 
		    if( ev_check() ){
		    	formList.action = "<%=contextPath%>/cms/reward/chadtwayspecialreward.do?CMD=EXCEL";
	        	formList.submit();
	        	formList.action = "<%=contextPath%>/cms/reward/chadtwayspecialreward.do?CMD=LIST";
		    }			
		}
    </script>
</head>

<body onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<html:form action="/cms/reward/chadtwayspecialreward.do?CMD=LIST" styleId="formList" method="post" onsubmit="return ev_check();">
    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <input type="hidden" name="_rowcount" value="<c:out value='${requestScope.LIST.rowCount}' />">
    <c:set var="form" scope="request" value="${requestScope['/cms/reward/chadtwayspecialreward/ChAdtWayspecialrewardForm']}"/>

    <!--##################################添加标题内容##################################################-->
    <div class="table_div">
    <table class="top_table">
    	<tr>
    		<td>
    			<bean:message bundle="chadtwayspecialreward" key="titleList"/>
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
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="chadtwayspecialreward" key="_se_wayid"/>:</td>
                <td width="30%" class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_se_wayid"></html:text>
                </td>
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="chadtwayspecialreward" key="_se_wayspetype"/>:</td>
                <td width="30%" class="form_table_left">
<%--                    <html:text styleClass="form_input_1x" property="_se_wayspetype"></html:text>--%>
                    <html:select property="_se_wayspetype">
						<option/>
						<s:Options definition="$CH_WAYSPETYPE" />
					</html:select>
                </td>
            </tr>
            <tr>
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="chadtwayspecialreward" key="_dnl_createdate"/>:</td>
                <td width="30%" class="form_table_left">
<%--                    <html:text styleClass="form_input_1x" property="_dnl_createdate"></html:text>--%>
                    <html:text styleClass="form_input_1x" property="_dnl_createdate" onclick="this.value=selectDate();"></html:text>
                </td>
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="chadtwayspecialreward" key="_dnm_createdate"/>:</td>
                <td width="30%" class="form_table_left">
<%--                    <html:text styleClass="form_input_1x" property="_dnm_createdate"></html:text>--%>
                    <html:text styleClass="form_input_1x" property="_dnm_createdate" onclick="this.value=selectDate();"></html:text>
                </td>
        </table>
    </div>
	<div class="table_div">
		<table class="table_button_list">
			<tr> 
                <td align=right>
                        <s:PurChk controlid="<%=ID_1%>">
                            <input type="button" name="btnNew"  class="add" onmouseover="buttonover(this);"
                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                            value="<bean:message bundle="public" key="button_new"/>" onClick="doNew('/cms/reward/chadtwayspecialreward.do')">
                        </s:PurChk>
                        <s:PurChk controlid="<%=ID_2%>">
                            <input type="button" name="btnDelete" class="delete" onmouseover="buttonover(this);"
                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                            value="<bean:message bundle="public" key="button_delete"/>" onClick="doDelete('/cms/reward/chadtwayspecialreward.do')">
                        </s:PurChk>
                        <s:PurChk controlid="<%=ID_3%>">
                        <input type="button" class="query" onmouseover="buttonover(this);" onclick="doQuery();"
                                onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                                value="<bean:message bundle="public" key="button_search"/>" />
                        </s:PurChk>
                        <input type="button" class="button_4" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
							onfocus="buttonover(this)" onblur="buttonout(this)" 
							value="导出EXCEL" onclick="doExcel()"/>
						<input type="button" class="button_4" onmouseover="buttonover(this);" onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                              	value="<bean:message bundle="costcard" key="buttonBatch"/>" 
                                onclick="doOther('/cms/reward/chadtwayspecialreward.do?CMD=IMPORT')"/>
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
                    <a href="javascript:doOrderby('wayid')"><bean:message bundle="chadtwayspecialreward" key="wayid"/></a>
                    <s:OrderImg form="/cms/reward/chadtwayspecialreward/ChadtwayspecialrewardForm" field="wayid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('wayspetype')"><bean:message bundle="chadtwayspecialreward" key="wayspetype"/></a>
                    <s:OrderImg form="/cms/reward/chadtwayspecialreward/ChadtwayspecialrewardForm" field="wayspetype"/>
                </td>
<%--                <td>--%>
<%--                    <a href="javascript:doOrderby('cityid')"><bean:message bundle="chadtwayspecialreward" key="cityid"/></a>--%>
<%--                    <s:OrderImg form="/cms/reward/chadtwayspecialreward/ChadtwayspecialrewardForm" field="cityid"/>--%>
<%--                </td>--%>
                <td>
                    <a href="javascript:doOrderby('createdate')"><bean:message bundle="chadtwayspecialreward" key="createdate"/></a>
                    <s:OrderImg form="/cms/reward/chadtwayspecialreward/ChadtwayspecialrewardForm" field="createdate"/>
                </td>
            </tr>
            <c:forEach var="item" items="${requestScope.LIST.datas}">
                 <c:url value="/cms/reward/chadtwayspecialreward.do?CMD=EDIT" var="urlContent">
                     <%//this param name must "PK" %>
                     <c:param name="PK" value="${item.wayid}"/>
                     <%-- <c:param name="PK" value="'${item.id}|${item.id2}'"/> --%>
                 </c:url>
                 <tr class="table_style_content" align="center">
                     <td>
                         <input type="checkbox" name="_selectitem" value="<c:out value='${item.wayid}' />"
                                onclick="checkOne();" class="table_checkbox">
                     </td>
                     <td>
                         <a href='<c:out value="${urlContent}"/>'><c:out value="${item.wayid}"/></a>
                     </td>
<%--                     <td><c:out value="${item.wayspetype}"/></td>--%>
                     <td><s:Code2Name code="${item.wayspetype}" definition="$CH_WAYSPETYPE"/></td>
<%--                     <td><c:out value="${item.cityid}"/></td>--%>
<%--                     <td><c:out value="${item.createdate}"/></td>--%>
                     <td><fmt:formatDate value="${item.createdate}" pattern="yyyy-MM-dd"/></td>
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
