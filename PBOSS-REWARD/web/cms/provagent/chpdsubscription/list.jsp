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
    <title><bean:message bundle="chpdsubscription" key="titleList"/></title>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            addfield('_se_provagentid', '<bean:message bundle="chpdsubscription" key="provagentid"/>', 'c', 'false', '15');
            addfield('_se_prodno', '<bean:message bundle="chpdsubscription" key="prodno"/>', 'c', 'false', '18');
            addfield('_se_prodid', '<bean:message bundle="chpdsubscription" key="prodid"/>', 'c', 'false', '15');
            addfield('_se_cityid', '<bean:message bundle="chpdsubscription" key="cityid"/>', 'c', false, '4');
            return checkval(window);
        }
        function doExcel(){ 
		    if( ev_check() ){
		    	formList.action = "<%=contextPath%>/cms/provagent/chpdsubscription.do?CMD=EXCEL";
	        	formList.submit();
	        	formList.action = "<%=contextPath%>/cms/provagent/chpdsubscription.do?CMD=LIST";
		    }			
		}
    </script>
</head>

<body onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<html:form action="/cms/provagent/chpdsubscription.do?CMD=LIST" styleId="formList" method="post" onsubmit="return ev_check();">
    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <input type="hidden" name="_rowcount" value="<c:out value='${requestScope.LIST.rowCount}' />">
    <c:set var="form" scope="request" value="${requestScope['/cms/provagent/chpdsubscription/ChPdSubscriptionForm']}"/>

    <!--##################################添加标题内容##################################################-->
    <div class="table_div">
    <table class="top_table">
    	<tr>
    		<td>
    			<bean:message bundle="chpdsubscription" key="titleList"/>
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
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="chpdsubscription" key="provagentid"/>:</td>
                <td width="30%" class="form_table_left">
<%--                    <html:text styleClass="form_input_1x" property="_se_provagentid"></html:text>--%>
					<html:select property="_se_provagentid" >
						<option />
						<s:Options definition="#CH_PD_AGENT"></s:Options>
					</html:select>
                </td>
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="chpdsubscription" key="prodid"/>:</td>
                <td width="30%" class="form_table_left">
<%--                    <html:text styleClass="form_input_1x" property="_se_prodid"></html:text>--%>
<%--                    <html:select property="_se_prodid" >--%>
<%--						<option />--%>
<%--						<s:Options definition="#CH_PD_ENTPRODUCT"></s:Options>--%>
<%--					</html:select>--%>
					<s:myzoom definition="#CH_PD_ENTPRODUCT" property="_se_prodid" styleClass="form_input_1x" readonly="false" />
                </td>
            </tr>
            <tr>
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="chpdsubscription" key="cityid"/>:</td>
                <td width="30%" class="form_table_left">
<%--                    <html:text styleClass="form_input_1x" property="_se_cityid"></html:text>--%>
					<html:select property="_se_cityid">
						<option/>
						<s:Options definition="#REGIONNAME" />
					</html:select>
					<font color=red>&nbsp;*</font>
                </td>
                <td width="20%" height="20" align="right" class="form_table_right" ></td>
                <td width="30%" class="form_table_left">
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
                            value="<bean:message bundle="public" key="button_new"/>" onClick="doNew('/cms/provagent/chpdsubscription.do')">
                        </s:PurChk>
<%--                        <s:PurChk controlid="<%=ID_2%>">--%>
<%--                            <input type="button" name="btnDelete" class="delete" onmouseover="buttonover(this);"--%>
<%--                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"--%>
<%--                            value="<bean:message bundle="public" key="button_delete"/>" onClick="doDelete('/cms/provagent/chpdsubscription.do')">--%>
<%--                        </s:PurChk>--%>
                        <s:PurChk controlid="<%=ID_3%>">
                        <input type="button" class="query" onmouseover="buttonover(this);" onclick="doQuery();"
                                onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                                value="<bean:message bundle="public" key="button_search"/>" />
                        </s:PurChk>
                        <input type="button" class="button_4" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
							onfocus="buttonover(this)" onblur="buttonout(this)" 
							value="导出EXCEL" onclick="doExcel()"/>
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
                    <a href="javascript:doOrderby('prodno')"><bean:message bundle="chpdsubscription" key="prodno"/></a>
                    <s:OrderImg form="/cms/provagent/chpdsubscription/ChpdsubscriptionForm" field="prodno"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('provagentid')"><bean:message bundle="chpdsubscription" key="provagentid"/></a>
                    <s:OrderImg form="/cms/provagent/chpdsubscription/ChpdsubscriptionForm" field="provagentid"/>
                </td>
                <td>
					代理商名称
                </td>
                <td>
                    <a href="javascript:doOrderby('custid')"><bean:message bundle="chpdsubscription" key="custid"/></a>
                    <s:OrderImg form="/cms/provagent/chpdsubscription/ChpdsubscriptionForm" field="custid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('custname')"><bean:message bundle="chpdsubscription" key="custname"/></a>
                    <s:OrderImg form="/cms/provagent/chpdsubscription/ChpdsubscriptionForm" field="custname"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('prodid')"><bean:message bundle="chpdsubscription" key="prodid"/></a>
                    <s:OrderImg form="/cms/provagent/chpdsubscription/ChpdsubscriptionForm" field="prodid"/>
                </td>
                <td>
					集团产品名称
                </td>
                <td>
                    <a href="javascript:doOrderby('inbosstime')"><bean:message bundle="chpdsubscription" key="inbosstime"/></a>
                    <s:OrderImg form="/cms/provagent/chpdsubscription/ChpdsubscriptionForm" field="inbosstime"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('cityid')"><bean:message bundle="chpdsubscription" key="cityid"/></a>
                    <s:OrderImg form="/cms/provagent/chpdsubscription/ChpdsubscriptionForm" field="cityid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('salesi')"><bean:message bundle="chpdsubscription" key="salesi"/></a>
                    <s:OrderImg form="/cms/provagent/chpdsubscription/ChpdsubscriptionForm" field="salesi"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('servsi')"><bean:message bundle="chpdsubscription" key="servsi"/></a>
                    <s:OrderImg form="/cms/provagent/chpdsubscription/ChpdsubscriptionForm" field="servsi"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('agenteeid')"><bean:message bundle="chpdsubscription" key="agenteeid"/></a>
                    <s:OrderImg form="/cms/provagent/chpdsubscription/ChpdsubscriptionForm" field="agenteeid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('coopertype')"><bean:message bundle="chpdsubscription" key="coopertype"/></a>
                    <s:OrderImg form="/cms/provagent/chpdsubscription/ChpdsubscriptionForm" field="coopertype"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('incomstime')"><bean:message bundle="chpdsubscription" key="incomstime"/></a>
                    <s:OrderImg form="/cms/provagent/chpdsubscription/ChpdsubscriptionForm" field="incomstime"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('validation')"><bean:message bundle="chpdsubscription" key="validation"/></a>
                    <s:OrderImg form="/cms/provagent/chpdsubscription/ChpdsubscriptionForm" field="validation"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('origin')"><bean:message bundle="chpdsubscription" key="origin"/></a>
                    <s:OrderImg form="/cms/provagent/chpdsubscription/ChpdsubscriptionForm" field="origin"/>
                </td>
            </tr>
            <c:forEach var="item" items="${requestScope.LIST.datas}">
                 <c:url value="/cms/provagent/chpdsubscription.do?CMD=EDIT" var="urlContent">
                     <%//this param name must "PK" %>
                     <c:param name="PK" value="${item.prodno}"/>
                     <%-- <c:param name="PK" value="'${item.id}|${item.id2}'"/> --%>
                 </c:url>
                 <tr class="table_style_content" align="center">
                     <td>
                         <input type="checkbox" name="_selectitem" value="<c:out value='${item.prodno}' />"
                                onclick="checkOne();" class="table_checkbox">
                     </td>
                     <td>
                         <a href='<c:out value="${urlContent}"/>'><c:out value="${item.prodno}"/></a>
                     </td>
                     <td><c:out value="${item.provagentid}"/></td>
                     <td><s:Code2Name code="${item.provagentid}" definition="#CH_PD_AGENT"/></td>
                     <td><c:out value="${item.custid}"/></td>
                     <td><c:out value="${item.custname}"/></td>
                     <td><c:out value="${item.prodid}"/></td>
                     <td><s:Code2Name code="${item.prodid}" definition="#CH_PD_ENTPRODUCT"/></td>
                     <td><fmt:formatDate value="${item.inbosstime}" pattern="yyyy-MM-dd"/></td>
                     <td><s:Code2Name code="${item.cityid}" definition="#REGIONNAME"/></td>
                     <td><c:out value="${item.salesi}"/></td>
                     <td><c:out value="${item.servsi}"/></td>
                     <td><c:out value="${item.agenteeid}"/></td>
                     <td><s:Code2Name code="${item.coopertype}" definition="$PD_HZLX"/></td>
                     <td><fmt:formatDate value="${item.incomstime}" pattern="yyyy-MM-dd"/></td>
                     <td><s:Code2Name code="${item.validation}" definition="#PD_YESORNO"/></td>
                     <td><s:Code2Name code="${item.origin}" definition="$PD_ORIGINTYPE"/></td>
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
