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
    <title><bean:message bundle="ruleitemlog" key="titleList"/></title>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            addfield('_ne_logid', '<bean:message bundle="ruleitemlog" key="logid"/>', 'f', true, '14');
            addfield('_se_oprcode', '<bean:message bundle="ruleitemlog" key="oprcode"/>', 'c', true, '16');
            addfield('_se_oprtype', '<bean:message bundle="ruleitemlog" key="oprtype"/>', 'c', true, '8');
            addfield('_se_contype', '<bean:message bundle="ruleitemlog" key="contype"/>', 'c', true, '10');
            return checkval(window);
        }
    </script>
</head>

<body onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<html:form action="/cms/reward/ruleitemlog.do?CMD=LIST" styleId="formList" method="post" onsubmit="return ev_check();">
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
    			<bean:message bundle="ruleitemlog" key="titleList"/>
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
                <td width="126" height="20" align="right" class="form_table_right" ><bean:message bundle="ruleitemlog" key="logid"/>:</td>
                <td class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_ne_logid"></html:text>
                </td>
                <td width="126" height="20" align="right" class="form_table_right" ><bean:message bundle="ruleitemlog" key="oprcode"/>:</td>
                <td class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_se_oprcode"></html:text>
                </td>
                <td width="126" height="20" align="right" class="form_table_right" ><bean:message bundle="ruleitemlog" key="oprtype"/>:</td>
                <td class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_se_oprtype"></html:text>
                </td>
            </tr>
            <tr>
                <td width="126" height="20" align="right" class="form_table_right" ><bean:message bundle="ruleitemlog" key="contype"/>:</td>
                <td class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_se_contype"></html:text>
                </td>
    			<td width="80" height="20" align="right" class="form_table_right" >
                	&nbsp;
            	</td>
            	<td class="form_table_left">
               	 &nbsp;
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
                            value="<bean:message bundle="public" key="button_new"/>" onClick="doNew('/cms/reward/ruleitemlog.do')">
                        </s:PurChk>
                        <s:PurChk controlid="<%=ID_2%>">
                            <input type="button" name="btnDelete" class="delete" onmouseover="buttonover(this);"
                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                            value="<bean:message bundle="public" key="button_delete"/>" onClick="doDelete('/cms/reward/ruleitemlog.do')">
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
                    <a href="javascript:doOrderby('logid')"><bean:message bundle="ruleitemlog" key="logid"/></a>
                    <s:OrderImg form="/cms/reward/ruleitemlog/ruleitemlogForm" field="logid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('optime')"><bean:message bundle="ruleitemlog" key="optime"/></a>
                    <s:OrderImg form="/cms/reward/ruleitemlog/ruleitemlogForm" field="optime"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('oprcode')"><bean:message bundle="ruleitemlog" key="oprcode"/></a>
                    <s:OrderImg form="/cms/reward/ruleitemlog/ruleitemlogForm" field="oprcode"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('oprtype')"><bean:message bundle="ruleitemlog" key="oprtype"/></a>
                    <s:OrderImg form="/cms/reward/ruleitemlog/ruleitemlogForm" field="oprtype"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('success')"><bean:message bundle="ruleitemlog" key="success"/></a>
                    <s:OrderImg form="/cms/reward/ruleitemlog/ruleitemlogForm" field="success"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('ruleitemid')"><bean:message bundle="ruleitemlog" key="ruleitemid"/></a>
                    <s:OrderImg form="/cms/reward/ruleitemlog/ruleitemlogForm" field="ruleitemid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('ruleitemname')"><bean:message bundle="ruleitemlog" key="ruleitemname"/></a>
                    <s:OrderImg form="/cms/reward/ruleitemlog/ruleitemlogForm" field="ruleitemname"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('backruleitemid')"><bean:message bundle="ruleitemlog" key="backruleitemid"/></a>
                    <s:OrderImg form="/cms/reward/ruleitemlog/ruleitemlogForm" field="backruleitemid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('contype')"><bean:message bundle="ruleitemlog" key="contype"/></a>
                    <s:OrderImg form="/cms/reward/ruleitemlog/ruleitemlogForm" field="contype"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('specflag')"><bean:message bundle="ruleitemlog" key="specflag"/></a>
                    <s:OrderImg form="/cms/reward/ruleitemlog/ruleitemlogForm" field="specflag"/>
                </td>
            </tr>
            <c:forEach var="item" items="${requestScope.LIST.datas}">
                 <c:url value="/cms/reward/ruleitemlog.do?CMD=EDIT" var="urlContent">
                     <%//this param name must "PK" %>
                     <c:param name="PK" value="${item.logid}"/>
                     <%-- <c:param name="PK" value="'${item.id}|${item.id2}'"/> --%>
                 </c:url>
                 <tr class="table_style_content" align="center">
                     <td>
                         <input type="checkbox" name="_selectitem" value="<c:out value='${item.logid}' />"
                                onclick="checkOne(this);" class="table_checkbox">
                     </td>
                     <td>
                         <a href='<c:out value="${urlContent}"/>'><c:out value="${item.logid}"/></a>
                     </td>
                     <td><c:out value="${item.optime}"/></td>
                     <td><c:out value="${item.oprcode}"/></td>
                     <td><c:out value="${item.oprtype}"/></td>
                     <td><c:out value="${item.success}"/></td>
                     <td><c:out value="${item.ruleitemid}"/></td>
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
