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
    <title><bean:message bundle="ruleitem" key="titleList"/></title>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            addfield('_se_ruleitemid', '<bean:message bundle="ruleitem" key="ruleitemid"/>', 'c', true, '18');
            addfield('_se_ruleitemname', '<bean:message bundle="ruleitem" key="ruleitemname"/>', 'c', true, '250');
            return checkval(window);
        }
    </script>
</head>

<body onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<html:form action="/cms/reward/ruleitem.do?CMD=LIST" styleId="formList" method="post" onsubmit="return ev_check();">
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
    			<bean:message bundle="ruleitem" key="titleList"/>
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
                <td width="126" height="20" align="right" class="form_table_right" ><bean:message bundle="ruleitem" key="ruleitemid"/>:</td>
                <td class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_se_ruleitemid"></html:text>
                </td>
                <td width="126" height="20" align="right" class="form_table_right" ><bean:message bundle="ruleitem" key="ruleitemname"/>:</td>
                <td class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_se_ruleitemname"></html:text>
                </td>
    			<td width="80" height="20" align="right" class="form_table_right" >
                	&nbsp;
            	</td>
            	<td class="form_table_left">
               	 &nbsp;
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
                            value="<bean:message bundle="public" key="button_new"/>" onClick="doNew('/cms/reward/ruleitem.do')">
                        </s:PurChk>
                        <s:PurChk controlid="<%=ID_2%>">
                            <input type="button" name="btnDelete" class="delete" onmouseover="buttonover(this);"
                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                            value="<bean:message bundle="public" key="button_delete"/>" onClick="doDelete('/cms/reward/ruleitem.do')">
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
                    <a href="javascript:doOrderby('ruleitemid')"><bean:message bundle="ruleitem" key="ruleitemid"/></a>
                    <s:OrderImg form="/cms/reward/ruleitem/ruleitemForm" field="ruleitemid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('ruleitemname')"><bean:message bundle="ruleitem" key="ruleitemname"/></a>
                    <s:OrderImg form="/cms/reward/ruleitem/ruleitemForm" field="ruleitemname"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('backruleitemid')"><bean:message bundle="ruleitem" key="backruleitemid"/></a>
                    <s:OrderImg form="/cms/reward/ruleitem/ruleitemForm" field="backruleitemid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('contype')"><bean:message bundle="ruleitem" key="contype"/></a>
                    <s:OrderImg form="/cms/reward/ruleitem/ruleitemForm" field="contype"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('specflag')"><bean:message bundle="ruleitem" key="specflag"/></a>
                    <s:OrderImg form="/cms/reward/ruleitem/ruleitemForm" field="specflag"/>
                </td>
            </tr>
            <c:forEach var="item" items="${requestScope.LIST.datas}">
                 <c:url value="/cms/reward/ruleitem.do?CMD=EDIT" var="urlContent">
                     <%//this param name must "PK" %>
                     <c:param name="PK" value="${item.ruleitemid}"/>
                     <%-- <c:param name="PK" value="'${item.id}|${item.id2}'"/> --%>
                 </c:url>
                 <tr class="table_style_content" align="center">
                     <td>
                         <input type="checkbox" name="_selectitem" value="<c:out value='${item.ruleitemid}' />"
                                onclick="checkOne(this);" class="table_checkbox">
                     </td>
                     <td>
                         <a href='<c:out value="${urlContent}"/>'><c:out value="${item.ruleitemid}"/></a>
                     </td>
                     <td><c:out value="${item.ruleitemname}"/></td>
                     <td><c:out value="${item.backruleitemid}"/></td>
                     <td><c:out value="${item.contype}"/></td>
                     <td><c:out value="${item.specflag}"/></td>
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
