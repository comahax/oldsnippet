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
    <title><bean:message bundle="salecredit" key="titleList"/></title>
    <script type="text/javascript" src="<%=contextPath%>/js/bus/waycommon.js"></script>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            addfield('_se_wayid', '<bean:message bundle="salecredit" key="wayid"/>', 'c', 'false', '20');
            addfield('_ne_busitype', '<bean:message bundle="salecredit" key="busitype"/>', 'f', 'false', '22');
            return checkval(window);
        }
    </script>
</head>

<body onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<html:form action="/cms/reward/salecredit.do?CMD=LIST" styleId="formList" method="post" onsubmit="return ev_check();">
    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <input type="hidden" name="_rowcount" value="<c:out value='${requestScope.LIST.rowCount}' />">
    <c:set var="form" scope="request" value="${requestScope['/cms/reward/salecredit/SalecreditForm']}"/>

    <!--##################################添加标题内容##################################################-->
    <div class="table_div">
    <table class="top_table">
    	<tr>
    		<td>
    			<bean:message bundle="salecredit" key="titleList"/>
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
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="salecredit" key="wayid"/>:</td>
                <td width="30%" class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_se_wayid"></html:text>
                    <input type="button" value="..." class="clickbutton" onclick="showSelectWay3(this,'_se_wayid','','','AG');this.value='...';" />
                </td>
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="salecredit" key="busitype"/>:</td>
                <td width="30%" class="form_table_left">
                    <html:select property="_ne_busitype">
                    	<option />
                    	<s:Options definition="$CH_CREDIT_ACCOUNT" />
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
                </td>
			</tr>
		</table>
	</div>

    <div class="table_div">
      <div class="table_LongTable">
        <table class="table_style" ID="Table2">
            <tr class="table_style_head">
                <td>
                    <a href="javascript:doOrderby('wayid')"><bean:message bundle="salecredit" key="wayid"/></a>
                    <s:OrderImg form="/cms/reward/salecredit/SalecreditForm" field="wayid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('busitype')"><bean:message bundle="salecredit" key="busitype"/></a>
                    <s:OrderImg form="/cms/reward/salecredit/SalecreditForm" field="busitype"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('busivalue')"><bean:message bundle="salecredit" key="busivalue"/></a>
                    <s:OrderImg form="/cms/reward/salecredit/SalecreditForm" field="busivalue"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('creditstd')"><bean:message bundle="salecredit" key="creditstd"/></a>
                    <s:OrderImg form="/cms/reward/salecredit/SalecreditForm" field="creditstd"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('creditaccount')"><bean:message bundle="salecredit" key="creditaccount"/></a>
                    <s:OrderImg form="/cms/reward/salecredit/SalecreditForm" field="creditaccount"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('calcmonth')"><bean:message bundle="salecredit" key="calcmonth"/></a>
                    <s:OrderImg form="/cms/reward/salecredit/SalecreditForm" field="calcmonth"/>
                </td>
            </tr>
            <c:forEach var="item" items="${requestScope.LIST.datas}">
                 <c:url value="/cms/reward/salecredit.do?CMD=EDIT" var="urlContent">
                     <%//this param name must "PK" %>
                     <c:param name="PK" value="${item.seq}"/>
                     <%-- <c:param name="PK" value="'${item.id}|${item.id2}'"/> --%>
                 </c:url>
                 <tr class="table_style_content" align="center">
                     <td><c:out value="${item.wayid}"/></td>
                     <td><s:Code2Name code="${item.busitype}" definition="$CH_CREDIT_ACCOUNT"/></td>
                     <td><fmt:formatNumber pattern="0.00" value="${item.busivalue}" /></td>
                     <td><fmt:formatNumber pattern="0.00" value="${item.creditstd}" /></td>
                     <td><fmt:formatNumber pattern="0.00" value="${item.creditaccount}" /></td>
                     <td><c:out value="${item.calcmonth}"/></td>
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
