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
    <title><bean:message bundle="chbbcmarketact" key="titleList"/></title>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            addfield('_se_rewardmonth', '<bean:message bundle="chbbcmarketact" key="rewardmonth"/>', 'c', false, '6');
            return checkval(window);
        }
        function New() {
        	if (ev_check()) {
        		doNew('/cms/chbbcmarketact.do');
        	}
        }
        function doBatch() {
        	if (ev_check()) {
        		formList.action = contextPath + "/cms/chbbcmarketact.do?CMD=BATCHNEW";
        		document.formList.submit();
        		formList.action = contextPath + "/cms/chbbcmarketact.do?CMD=LIST";
        	}
        }
    </script>
</head>

<body onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<html:form action="/cms/chbbcmarketact.do?CMD=LIST" styleId="formList" method="post" onsubmit="return ev_check();">
    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <input type="hidden" name="_rowcount" value="<c:out value='${requestScope.LIST.rowCount}' />">
    <c:set var="form" scope="request" value="${requestScope['/cms/chbbcmarketact/ChbbcmarketactForm']}"/>

    <!--##################################添加标题内容##################################################-->
    <div class="table_div">
    <table class="top_table">
    	<tr>
    		<td>
    			<bean:message bundle="chbbcmarketact" key="titleList"/>
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
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="chbbcmarketact" key="rewardmonth"/>:</td>
                <td width="30%" class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_se_rewardmonth" onclick="selectDateYYYYMM()"></html:text>
                    <font color=red>*</font>
                </td>
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="chbbcmarketact" key="cityid"/>:</td>
                <td width="30%" class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_se_cityid" readonly="true"></html:text>
                </td>
            </tr>
        </table>
    </div>
	<div class="table_div">
		<table class="table_button_list">
			<tr> 
                <td align=right>
                    <input type="button" class="query" onmouseover="buttonover(this);" onclick="doQuery();"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="<bean:message bundle="public" key="button_search"/>" />
                    <input type="button" name="btnNew" class="add" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="<bean:message bundle="public" key="button_new"/>" onClick="New()">
                    <input type="button" name="btnDelete" class="delete" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="<bean:message bundle="public" key="button_delete"/>" onClick="doDelete('/cms/chbbcmarketact.do')">
                    <input type="button" name="btnBatch" class="button_4" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="批量设置" onClick="doBatch()">
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
                <td><bean:message bundle="public" key="column_id"/></td>
                <td>
                    <a href="javascript:doOrderby('opnid')"><bean:message bundle="chbbcmarketact" key="opnid"/></a>
                    <s:OrderImg form="/cms/chbbcmarketact/ChbbcmarketactForm" field="opnid"/>
                </td>
                <td><bean:message bundle="chbbcmarketact" key="opnname"/></td>
                <td>
                    <a href="javascript:doOrderby('acttype')"><bean:message bundle="chbbcmarketact" key="acttype"/></a>
                    <s:OrderImg form="/cms/chbbcmarketact/ChbbcmarketactForm" field="acttype"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('actprofile')"><bean:message bundle="chbbcmarketact" key="actprofile"/></a>
                    <s:OrderImg form="/cms/chbbcmarketact/ChbbcmarketactForm" field="actprofile"/>
                </td>
            </tr>
            <c:forEach var="item" items="${requestScope.LIST.datas}" varStatus="status">
                 <c:url value="/cms/chbbcmarketact.do?CMD=EDIT" var="urlContent">
                     <%//this param name must "PK" %>
                     <c:param name="PK" value="${item.cityid}|${item.opnid}|${item.rewardmonth}"/>
                     <%-- <c:param name="PK" value="'${item.id}|${item.id2}'"/> --%>
                 </c:url>
                 <tr class="table_style_content" align="center">
                     <td>
                         <input type="checkbox" name="_selectitem" value="<c:out value='${item.cityid}|${item.opnid}|${item.rewardmonth}' />"
                                onclick="checkOne();" class="table_checkbox">
                     </td>
                     <td><c:out value="${status.index+1}"/></td>
                     <td>
                         <a href='<c:out value="${urlContent}"/>'><c:out value="${item.opnid}"/></a>
                     </td>
                     <td><s:Code2Name code="${item.opnid}" definition="#BBC_OPERATION"/></td>
                     <td><s:Code2Name code="${item.acttype}" definition="$BBC_MARKETACT"/></td>
                     <td><c:out value="${item.actprofile}"/></td>
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
