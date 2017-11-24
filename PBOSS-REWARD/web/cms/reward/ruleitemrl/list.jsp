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
    <title><bean:message bundle="ruleitemrl" key="titleList"/></title>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            addfield('_se_ruleid', '<bean:message bundle="ruleitemrl" key="ruleid"/>', 'c', true, '18');
            addfield('_ne_groupid', '<bean:message bundle="ruleitemrl" key="groupid"/>', 'f', true, '3');
            addfield('_se_ruleitemid', '<bean:message bundle="ruleitemrl" key="ruleitemid"/>', 'c', true, '18');
            return checkval(window);
        }
    </script>
</head>

<body onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<html:form action="/cms/reward/ruleitemrl.do?CMD=LIST" styleId="formList" method="post" onsubmit="return ev_check();">
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
    			<bean:message bundle="ruleitemrl" key="titleList"/>
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
                <td width="126" height="20" align="right" class="form_table_right" ><bean:message bundle="ruleitemrl" key="ruleid"/>:</td>
                <td class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_se_ruleid"></html:text>
                </td>
                <td width="126" height="20" align="right" class="form_table_right" ><bean:message bundle="ruleitemrl" key="groupid"/>:</td>
                <td class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_ne_groupid"></html:text>
                </td>
                <td width="126" height="20" align="right" class="form_table_right" ><bean:message bundle="ruleitemrl" key="ruleitemid"/>:</td>
                <td class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_se_ruleitemid"></html:text>
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
                            value="<bean:message bundle="public" key="button_new"/>" onClick="doNew('/cms/reward/ruleitemrl.do')">
                        </s:PurChk>
                        <s:PurChk controlid="<%=ID_2%>">
                            <input type="button" name="btnDelete" class="delete" onmouseover="buttonover(this);"
                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                            value="<bean:message bundle="public" key="button_delete"/>" onClick="doDelete('/cms/reward/ruleitemrl.do')">
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
                    <a href="javascript:doOrderby('ruleid')"><bean:message bundle="ruleitemrl" key="ruleid"/></a>
                    <s:OrderImg form="/cms/reward/ruleitemrl/ruleitemrlForm" field="ruleid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('groupid')"><bean:message bundle="ruleitemrl" key="groupid"/></a>
                    <s:OrderImg form="/cms/reward/ruleitemrl/ruleitemrlForm" field="groupid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('rltype')"><bean:message bundle="ruleitemrl" key="rltype"/></a>
                    <s:OrderImg form="/cms/reward/ruleitemrl/ruleitemrlForm" field="rltype"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('ruleitemid')"><bean:message bundle="ruleitemrl" key="ruleitemid"/></a>
                    <s:OrderImg form="/cms/reward/ruleitemrl/ruleitemrlForm" field="ruleitemid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('isleader')"><bean:message bundle="ruleitemrl" key="isleader"/></a>
                    <s:OrderImg form="/cms/reward/ruleitemrl/ruleitemrlForm" field="isleader"/>
                </td>
            </tr>
            <c:forEach var="item" items="${requestScope.LIST.datas}">
                 <c:url value="/cms/reward/ruleitemrl.do?CMD=EDIT" var="urlContent">
                     <%//this param name must "PK" %>
                     <c:param name="PK" value="${item.groupid}${item.ruleid}"/>
                     <%-- <c:param name="PK" value="'${item.id}|${item.id2}'"/> --%>
                 </c:url>
                 <tr class="table_style_content" align="center">
                     <td>
                         <input type="checkbox" name="_selectitem" value="<c:out value='${item.groupid}${item.ruleid}' />"
                                onclick="checkOne(this);" class="table_checkbox">
                     </td>
                     <td>
                         <a href='<c:out value="${urlContent}"/>'><c:out value="${item.groupid}"/></a>
                     </td>
                     <td>
                         <a href='<c:out value="${urlContent}"/>'><c:out value="${item.ruleid}"/></a>
                     </td>
                     <td><c:out value="${item.rltype}"/></td>
                     <td><c:out value="${item.ruleitemid}"/></td>
                     <td><c:out value="${item.isleader}"/></td>
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
