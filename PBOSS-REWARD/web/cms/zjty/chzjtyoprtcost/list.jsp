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
    <title><bean:message bundle="chzjtyoprtcost" key="titleList"/></title>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            addfield('_ne_citylevel', '<bean:message bundle="chzjtyoprtcost" key="citylevel"/>', 'f', 'false', '3');
            addfield('_ne_ctype', '<bean:message bundle="chzjtyoprtcost" key="ctype"/>', 'f', 'false', '3');
            addfield('_nnl_cost', '<bean:message bundle="chzjtyoprtcost" key="cost"/>', 'f', 'false', '16');
            addfield('_nnm_cost', '<bean:message bundle="chzjtyoprtcost" key="cost"/>', 'f', 'false', '16');
            return checkval(window);
        }
    </script>
</head>

<body onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<html:form action="/cms/zjty/oprtcost.do?CMD=LIST" styleId="formList" method="post" onsubmit="return ev_check();">
    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <input type="hidden" name="_rowcount" value="<c:out value='${requestScope.LIST.rowCount}' />">
    <c:set var="form" scope="request" value="${requestScope['/cms/zjty/OprtcostForm']}"/>

    <!--##################################添加标题内容##################################################-->
    <div class="table_div">
    <table class="top_table">
    	<tr>
    		<td>
    			<bean:message bundle="chzjtyoprtcost" key="titleList"/>
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
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="chzjtyoprtcost" key="citylevel"/>:</td>
                <td width="30%" class="form_table_left">
                    <html:select property="_ne_citylevel">
                    <option/>
                    <s:Options definition="$CH_CITYCOMPTYPE" />
                    </html:select>
                </td>
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="chzjtyoprtcost" key="ctype"/>:</td>
                <td width="30%" class="form_table_left">
                    <html:select property="_ne_ctype">
                    <option/>
                    <s:Options definition="$CH_OPRCOST" />
                    </html:select>
                </td>
             </tr>
              <tr>
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="chzjtyoprtcost" key="cost"/>>=</td>
                <td width="30%" class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_nnl_cost"></html:text>
                </td>
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="chzjtyoprtcost" key="cost"/><=</td>
                <td width="30%" class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_nnm_cost"></html:text>
                </td>
            <tr>
    			<td width="20%" height="20" align="right" class="form_table_right" >
                	&nbsp;
            	</td>
            	<td width="30%" class="form_table_left">
               	 &nbsp;
            	</td>
    			<td width="20%" height="20" align="right" class="form_table_right" >
                	&nbsp;
            	</td>
            	<td width="30%" class="form_table_left">
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
                            value="<bean:message bundle="public" key="button_new"/>" onClick="doNew('/cms/zjty/oprtcost.do')">
                        </s:PurChk>
                        <s:PurChk controlid="<%=ID_2%>">
                            <input type="button" name="btnDelete" class="delete" onmouseover="buttonover(this);"
                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                            value="<bean:message bundle="public" key="button_delete"/>" onClick="doDelete('/cms/zjty/oprtcost.do')">
                        </s:PurChk>
                        <s:PurChk controlid="<%=ID_3%>">
                        <input type="button" class="query" onmouseover="buttonover(this);" onclick="doQuery();"
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
                    <a href="javascript:doOrderby('citylevel')"><bean:message bundle="chzjtyoprtcost" key="citylevel"/></a>
                    <s:OrderImg form="/cms/zjty/OprtcostForm" field="citylevel"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('ctype')"><bean:message bundle="chzjtyoprtcost" key="ctype"/></a>
                    <s:OrderImg form="/cms/zjty/OprtcostForm" field="ctype"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('cost')"><bean:message bundle="chzjtyoprtcost" key="cost"/></a>
                    <s:OrderImg form="/cms/zjty/OprtcostForm" field="cost"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('memo')"><bean:message bundle="chzjtyoprtcost" key="memo"/></a>
                    <s:OrderImg form="/cms/zjty/OprtcostForm" field="memo"/>
                </td>
            </tr>
            <c:forEach var="item" items="${requestScope.LIST.datas}">
                 <c:url value="/cms/zjty/oprtcost.do?CMD=EDIT" var="urlContent">
                     <%//this param name must "PK" %>
                     <c:param name="PK" value="${item.citylevel}|${item.ctype}"/>
                     <%-- <c:param name="PK" value="'${item.id}|${item.id2}'"/> --%>
                 </c:url>
                 <tr class="table_style_content" align="center">
                     <td>
                         <input type="checkbox" name="_selectitem" value="<c:out value='${item.citylevel}|${item.ctype}' />"
                                onclick="checkOne();" class="table_checkbox">
                     </td>
                     <td>
                     <a href='<c:out value="${urlContent}"/>'>
                    	 <s:Code2Name definition="$CH_CITYCOMPTYPE" code="${item.citylevel}"/>
                     </a>
                     <td>
                      <s:Code2Name definition="$CH_OPRCOST" code="${item.ctype}"/>
                     </td>
                     <td>
                     <fmt:formatNumber pattern="#0.00" value="${item.cost}" />
                     </td>
                     <td><c:out value="${item.memo}"/></td>
                 </tr>
             </c:forEach>
        </table>
   </div>
   <div class="table_div">
		<s:PageNav dpName="LIST"/>
   </div>
</html:form>
</div>
</body>
</html>
