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
    <title><bean:message bundle="rewardpoolyw" key="titleList"/></title>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            addfield('_ne_rewardtype', '<bean:message bundle="rewardpoolyw" key="rewardtype"/>', 'f', true, '5');
            addfield('_se_region', '<bean:message bundle="rewardpoolyw" key="region"/>', 'c', true, '10');
            addfield('_se_opnid', '<bean:message bundle="rewardpoolyw" key="opnid"/>', 'c', true, '18');
            return checkval(window);
        }
    </script>
</head>

<body onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<html:form action="/cms/reward/rewardpoolyw.do?CMD=LIST" styleId="formList" method="post" onsubmit="return ev_check();">
    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <input type="hidden" name="_rowcount" value="<c:out value='${requestScope.LIST.rowCount}' />">

    <!--##################################添加标题内容##################################################-->
    <div class="table_div">
    <table class="top_table">
    	<tr>
    		<td>
    			<bean:message bundle="rewardpoolyw" key="titleList"/>
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
                <td width="126" height="20" align="right" class="form_table_right" ><bean:message bundle="rewardpoolyw" key="rewardtype"/>:</td>
                <td class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_ne_rewardtype"></html:text>
                </td>
                <td width="126" height="20" align="right" class="form_table_right" ><bean:message bundle="rewardpoolyw" key="region"/>:</td>
                <td class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_se_region"></html:text>
                </td>
                <td width="126" height="20" align="right" class="form_table_right" ><bean:message bundle="rewardpoolyw" key="opnid"/>:</td>
                <td class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_se_opnid"></html:text>
                </td>
            </tr>
        </table>
    </div>
	<div class="table_div">
		<table class="table_button_list">
			<tr> 
                <td align=right>
                        <s:PurChk controlid="<%=ID_1%>">
                            <input type="button" name="btnNew"  class="add" onmouseover="buttonover(this);"
                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                            value="<bean:message bundle="public" key="button_new"/>" onClick="doNew('/cms/reward/rewardpoolyw.do')">
                        </s:PurChk>
                        <s:PurChk controlid="<%=ID_2%>">
                            <input type="button" name="btnDelete" class="delete" onmouseover="buttonover(this);"
                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                            value="<bean:message bundle="public" key="button_delete"/>" onClick="doDelete('/cms/reward/rewardpoolyw.do')">
                        </s:PurChk>
                        <s:PurChk controlid="<%=ID_3%>">
                        <input type="submit" class="query"onmouseover="buttonover(this);"
                                onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                                value="<bean:message bundle="public" key="button_search"/>" />
                        </s:PurChk>
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
                    <a href="javascript:doOrderby('rewardtype')"><bean:message bundle="rewardpoolyw" key="rewardtype"/></a>
                    <s:OrderImg form="/cms/reward/rewardpoolyw/rewardpoolywForm" field="rewardtype"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('region')"><bean:message bundle="rewardpoolyw" key="region"/></a>
                    <s:OrderImg form="/cms/reward/rewardpoolyw/rewardpoolywForm" field="region"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('opnid')"><bean:message bundle="rewardpoolyw" key="opnid"/></a>
                    <s:OrderImg form="/cms/reward/rewardpoolyw/rewardpoolywForm" field="opnid"/>
                </td>
            </tr>
            <c:forEach var="item" items="${requestScope.LIST.datas}">
                 <c:url value="/cms/reward/rewardpoolyw.do?CMD=EDIT" var="urlContent">
                     <%//this param name must "PK" %>
                     <c:param name="PK" value="${item.opnid}${item.region}|${item.rewardtype}"/>
                     <%-- <c:param name="PK" value="'${item.id}|${item.id2}'"/> --%>
                 </c:url>
                 <tr class="table_style_content" align="center">
                     <td>
                         <input type="checkbox" name="_selectitem" value="<c:out value='${item.opnid}${item.region}|${item.rewardtype}' />"
                                onclick="checkOne(this);" class="table_checkbox">
                     </td>
                     <td>
                         <a href='<c:out value="${urlContent}"/>'><c:out value="${item.opnid}"/></a>
                     </td>
                     <td>
                         <a href='<c:out value="${urlContent}"/>'><c:out value="${item.region}"/></a>
                     </td>
                     <td>
                         <a href='<c:out value="${urlContent}"/>'><c:out value="${item.rewardtype}"/></a>
                     </td>
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
