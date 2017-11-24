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
    <title><bean:message bundle="chpdauditdispute" key="titleList"/></title>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            addfield('_se_cityid', '<bean:message bundle="chpdauditdispute" key="_cityid"/>', 'c', false, '4');
            return checkval(window);
        }
        
        function doExport(url){
			if (ev_check()) {
				formList.action = contextPath + url + "?CMD=EXCEL";
	  			formList.submit();
	  			formList.action="<%=contextPath%>/cms/provagent/chpdauditdispute.do?CMD=LIST";
			}
		}
    </script>
</head>

<body onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<html:form action="/cms/provagent/chpdauditdispute.do?CMD=LIST" styleId="formList" method="post" onsubmit="return ev_check();">
    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <html:hidden property="query" value="true"/>
    <input type="hidden" name="_rowcount" value="<c:out value='${requestScope.LIST.rowCount}' />">
    <c:set var="form" scope="request" value="${requestScope['/cms/provagent/chpdauditdispute/ChpdauditdisputeForm']}"/>

    <!--##################################添加标题内容##################################################-->
    <div class="table_div">
    <table class="top_table">
    	<tr>
    		<td>
    			<bean:message bundle="chpdauditdispute" key="titleList"/>
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
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="chpdauditdispute" key="_se_cityid"/>:</td>
                <td width="30%" class="form_table_left">
                    <html:select styleClass="form_input_1x" property="_se_cityid">
						<option/>
						<s:Options definition="#REGIONNAME"/>
					</html:select>
					<font color='red'>*</font>
                </td>
    			<td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="chpdauditdispute" key="_se_provagentid"/>:</td>
                <td width="30%" class="form_table_left">
                    <html:select styleClass="form_input_1x" property="_se_provagentid">
                    	<option></option>
						<s:Options definition="#CH_PD_AGENT"/>
					</html:select>
                </td>
            </tr>
            <tr>
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="chpdauditdispute" key="_se_prodid"/>:</td>
                <td width="30%" class="form_table_left">
                    <s:myzoom definition="#CH_PD_ENTPRODUCT" property="_se_prodid" styleClass="form_input_1x" readonly="false" />
                </td>
    			<td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="chpdauditdispute" key="_se_rewardmonth"/>:</td>
                <td width="30%" class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_se_rewardmonth" onclick="this.value=selectDateYYYYMM();"></html:text>
                </td>
            </tr>
        </table>
    </div>
	<div class="table_div">
		<table class="table_button_list">
			<tr> 
                <td align=right>
                    <!-- 
                    <input type="button" name="btnNew"  class="add" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="<bean:message bundle="public" key="button_new"/>" onClick="doNew('/cms/provagent/chpdauditdispute.do')">
                    <input type="button" name="btnDelete" class="delete" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="<bean:message bundle="public" key="button_delete"/>" onClick="doDelete('/cms/provagent/chpdauditdispute.do')">
                     -->
                    <input type="button" class="query" onmouseover="buttonover(this);" onclick="doQuery();"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="<bean:message bundle="public" key="button_search"/>" />
                    <input type="button" class="button_4" onmouseover="buttonover(this);" 
            			onclick="doExport('/cms/provagent/chpdauditdispute.do')" 
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="<bean:message bundle="public" key="button_export_excel"/>" />
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
                <td><bean:message bundle="chpdauditdispute" key="disputeid"/></td>
				<td><bean:message bundle="chpdauditdispute" key="_cityid"/></td>
				<td><bean:message bundle="chpdauditdispute" key="rewardid"/></td>
				<td><bean:message bundle="chpdauditdispute" key="provagentid"/></td>
				<td><bean:message bundle="chpdauditdispute" key="provagentname"/></td>
				<td><bean:message bundle="chpdauditdispute" key="prodno"/></td>
				<td><bean:message bundle="chpdauditdispute" key="prodid"/></td>
				<td><bean:message bundle="chpdauditdispute" key="prodname"/></td>
				<td><bean:message bundle="chpdauditdispute" key="custid"/></td>
				<td><bean:message bundle="chpdauditdispute" key="custname"/></td>
				<td><bean:message bundle="chpdauditdispute" key="phase"/></td>
				<td><bean:message bundle="chpdauditdispute" key="rewardmonth"/></td>
				<td><bean:message bundle="chpdauditdispute" key="rewardmoney"/></td>
				<td><bean:message bundle="chpdauditdispute" key="auditrole"/></td>
				<td><bean:message bundle="chpdauditdispute" key="content"/></td>
				<td><bean:message bundle="chpdauditdispute" key="auditeename"/></td>
				<td><bean:message bundle="chpdauditdispute" key="telephone"/></td>
				<td><bean:message bundle="chpdauditdispute" key="isaccepted"/></td>
				<td><bean:message bundle="chpdauditdispute" key="isdealed"/></td>
				<td><bean:message bundle="chpdauditdispute" key="dealtype"/></td>
				<td><bean:message bundle="chpdauditdispute" key="suppleseq"/></td>
				<td><bean:message bundle="chpdauditdispute" key="incomstime"/></td>
            </tr>
            <c:forEach var="item" items="${requestScope.LIST.datas}">
                 <c:url value="/cms/provagent/chpdauditdispute.do?CMD=EDIT" var="urlContent">
                     <%//this param name must "PK" %>
                     <c:param name="PK" value="${item.disputeid}"/>
                     <%-- <c:param name="PK" value="'${item.id}|${item.id2}'"/> --%>
                 </c:url>
                 <tr class="table_style_content" align="center">
                    <td>
                        <input type="checkbox" name="_selectitem" value="<c:out value='${item.disputeid}' />"
                               onclick="checkOne();" class="table_checkbox">
                    </td>
                    <td>
                    	<c:choose>
	                        <c:when test="${item.isdealed == 0}">
	                            <a href='<c:out value="${urlContent}"/>'><c:out value="${item.disputeid}"/></a>
	                        </c:when>
	                        <c:otherwise>
	                            <c:out value="${item.disputeid}"/>
	                        </c:otherwise>
	                    </c:choose>
                    </td>
					<td><s:Code2Name code="${item.cityid}" definition="#REGIONNAME"/></td>
					<td><c:out value="${item.rewardid}"/></td>
					<td><c:out value="${item.provagentid}"/></td>
					<td><s:Code2Name code="${item.provagentid}" definition="#CH_PD_AGENT"/></td>
					<td><c:out value="${item.prodno}"/></td>
					<td><c:out value="${item.prodid}"/></td>
					<td><c:out value="${item.prodname}"/></td>
					<td><c:out value="${item.custid}"/></td>
					<td><c:out value="${item.custname}"/></td>
					<td><c:out value="${item.phase}"/></td>
					<td><c:out value="${item.rewardmonth}"/></td>
					<td><c:out value="${item.rewardmoney}"/></td>
					<td><s:Code2Name code="${item.auditrole}" definition="$PD_AUDITROLE"/></td>
					<td><c:out value="${item.content}"/></td>
					<td><c:out value="${item.auditeename}"/></td>
					<td><c:out value="${item.telephone}"/></td>
					<td><s:Code2Name code="${item.isaccepted}" definition="#PD_YESORNO"/></td>
					<td><s:Code2Name code="${item.isdealed}" definition="#PD_YESORNO"/></td>
					<td><s:Code2Name code="${item.dealtype}" definition="$PD_DEALTYPE"/></td>
					<td><c:out value="${item.suppleseq}"/></td>
					<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${item.incomstime}" /></td>
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
