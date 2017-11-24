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
    <title><bean:message bundle="creditstd" key="titleList"/></title>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            addfield('_ne_slv', '<bean:message bundle="creditstd" key="slv"/>', 'f', 'false', '22');
            return checkval(window);
        }
    </script>
</head>

<body onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<html:form action="/cms/reward/creditstdpro.do?CMD=LIST" styleId="formList" method="post" onsubmit="return ev_check();">
    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <input type="hidden" name="_rowcount" value="<c:out value='${requestScope.LIST.rowCount}' />">
    <c:set var="form" scope="request" value="${requestScope['/cms/reward/creditstd/CreditstdForm']}"/>

    <!--##################################添加标题内容##################################################-->
    <div class="table_div">
    <table class="top_table">
    	<tr>
    		<td>
    			省公司酬金标准管理
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
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="creditstd" key="slv"/>:</td>
                <td width="30%" class="form_table_left">
                    <!-- <html:text styleClass="form_input_1x" property="_ne_slv"></html:text> -->
                    <html:select property="_ne_slv">
                    	<option />
                    	<s:Options definition="$CH_STARLEVEL" />
                    </html:select>
                </td>
            </tr>
        </table>
    </div>
	<div class="table_div">
		<table class="table_button_list">
			<tr> 
                <td align=right>
                        <s:PurChk controlid="<%=ID_3%>">
                        <input type="button" class="query" onmouseover="buttonover(this);" onclick="doQuery();"
                                onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                                value="<bean:message bundle="public" key="button_search"/>" />
                        </s:PurChk>
                        <s:PurChk controlid="<%=ID_1%>">
                            <input type="button" name="btnNew"  class="add" onmouseover="buttonover(this);"
                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                            value="<bean:message bundle="public" key="button_new"/>" onClick="doNew('/cms/reward/creditstdpro.do')">
                        </s:PurChk>
                        <!-- 
                        <s:PurChk controlid="<%=ID_2%>">
                            <input type="button" name="btnDelete" class="delete" onmouseover="buttonover(this);"
                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                            value="<bean:message bundle="public" key="button_delete"/>" onClick="doDelete('/cms/reward/creditstd.do')">
                        </s:PurChk> -->
                </td>
			</tr>
		</table>
	</div>

    <div class="table_div">
      <div class="table_LongTable">
        <table class="table_style" ID="Table2">
            <tr class="table_style_head">
                <!-- <td title="<bean:message bundle="public" key="list_title_select"/>">
                    <input type="checkbox" name="allbox" onclick="checkAll();" class="table_checkbox">
                </td> -->
                <td>
                    <a href="javascript:doOrderby('slv')"><bean:message bundle="creditstd" key="slv"/></a>
                    <s:OrderImg form="/cms/reward/creditstd/CreditstdForm" field="slv"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('creditstd')">销售积分标准下限</a>
                    <s:OrderImg form="/cms/reward/creditstd/CreditstdForm" field="creditstd"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('cardstd')">套卡标准下限</a>
                    <s:OrderImg form="/cms/reward/creditstd/CreditstdForm" field="cardstd"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('adtypecode')"><bean:message bundle="creditstd" key="adtypecode"/></a>
                    <s:OrderImg form="/cms/reward/creditstd/CreditstdForm" field="adtypecode"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('coreward')">长期激励标准上限</a>
                    <s:OrderImg form="/cms/reward/creditstd/CreditstdForm" field="coreward"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('rewardstd')">星级酬金标准上限</a>
                    <s:OrderImg form="/cms/reward/creditstd/CreditstdForm" field="rewardstd"/>
                </td>
                
            </tr>
            <c:forEach var="item" items="${requestScope.LIST.datas}">
                 <c:url value="/cms/reward/creditstdpro.do?CMD=EDIT" var="urlContent">
                     <%//this param name must "PK" %>
                     <c:param name="PK" value="${item.seq}"/>
                     <%-- <c:param name="PK" value="'${item.id}|${item.id2}'"/> --%>
                 </c:url>
                 <tr class="table_style_content" align="center">
                     <!-- <td>
                         <input type="checkbox" name="_selectitem" value="<c:out value='${item.seq}' />"
                                onclick="checkOne();" class="table_checkbox">
                        <a href='<c:out value="${urlContent}"/>'><c:out value="${item.cityid}"/></a>
                     </td> -->
                     <td>
                         <a href='<c:out value="${urlContent}"/>'><s:Code2Name code="${item.slv}" definition="$CH_STARLEVEL"/></a>
                     </td>
                     <!-- <td><c:out value="${item.cityid}"/></td> 
                     <td><s:Code2Name code="${item.slv}" definition="$CH_STARLEVEL"/></td> -->
                     <td><fmt:formatNumber pattern="0.00" value="${item.creditstd}" /></td>
                     <td><fmt:formatNumber pattern="0.00" value="${item.cardstd}" /></td>
                     <td><s:Code2Name code="${item.adtypecode}" definition="$CH_COUNTYCOMPTYPE"/></td>
                     <td><fmt:formatNumber pattern="0.00" value="${item.coreward}" /></td>
                     <td><fmt:formatNumber pattern="0.00" value="${item.rewardstd}" /></td>
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
