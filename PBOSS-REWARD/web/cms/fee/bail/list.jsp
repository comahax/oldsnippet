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
    <title><bean:message bundle="bail" key="titleList"/></title>
    <script type="text/javascript" src="<%= contextPath %>/js/bus/waycommon.js"></script>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            return checkval(window);
        }
        function doBatch(cmdStr) {
            formList.action = contextPath + cmdStr;
            formList.submit();
        }
    </script>
</head>

<body onload="document.formList._sk_wayid.focus()">
<div class="table_container">
<html:form action="/cms/fee/bail.do?CMD=LIST" styleId="formList" method="post" onsubmit="return ev_check();">
    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <input type="hidden" name="_rowcount" value="<c:out value='${requestScope.LIST.rowCount}' />">

	<div class="table_div">
				<table class="top_table">
					<tr>
						<td>
							<bean:message bundle="bail" key="titleList"/>
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
                <td width="126" height="20" align="right" class="form_table_right"><bean:message bundle="bail" key="wayid"/>:</td>
                <td class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_sk_wayid"  onclick="showSelectWay(this )" ></html:text>                    
                </td>
                <td width="126" height="20" align="right" class="form_table_right"><bean:message bundle="bail" key="bailtype"/>:</td>
                <td class="form_table_left">
                    <html:select property="_se_bailtype">
            			<option value=""  ></option>		                		
            			<s:Options  definition="$CH_GUARTYPE"/>
		        	</html:select>
                </td>
                <td width="126" height="20" align="right" class="form_table_right"><bean:message bundle="bail" key="opertype"/>:</td>
                <td class="form_table_left">
                    <html:select property="_se_opertype">
            			<option value=""  ></option>		                		
            			<s:Options  definition="$CH_BAILOPERTYPE"/>
		        	</html:select>
                </td>
             </tr>
             <tr>
                <td width="126" height="20" align="right" class="form_table_right"><bean:message bundle="bail" key="recvoprcode"/>:</td>
                <td class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_se_recvoprcode"></html:text>                    
                </td>
                <td width="126" height="20" align="right" class="form_table_right"><bean:message bundle="bail" key="recvtime"/>>=</td>
                <td class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_dnl_recvtime" onclick="this.value=selectDate()"></html:text>
                </td>
                <td width="126" height="20" align="right" class="form_table_right"><bean:message bundle="bail" key="recvtime"/><=</td>
                <td class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_dnm_recvtime" onclick="this.value=selectDate()"></html:text>
                </td>
             </tr>
        </table>
      </div>
      
	<div class="table_div">
        <table class="table_button_list">            
			<tr>
	            <td align=right>
	            	<input type="button" class="query"onmouseover="buttonover(this);" onclick="doQuery();" 
	                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
	                        value="<bean:message bundle="public" key="button_search"/>" />
	                <s:PurChk controlid="<%=ID_1%>">
	                    <input type="button" name="btnNew"  class="add" onmouseover="buttonover(this);"
	                    onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
	                    value="<bean:message bundle="public" key="button_new"/>" onClick="doNew('/cms/fee/bail.do')">
	                </s:PurChk>
	                <s:PurChk controlid="<%=ID_2%>">
	                    <input type="button" name="btnDelete" class="delete" onmouseover="buttonover(this);"
	                    onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
	                    value="<bean:message bundle="public" key="button_delete"/>" onClick="doDelete('/cms/fee/bail.do')">
	                </s:PurChk>	 
	                <s:PurChk controlid="<%=ID_3%>">
                     <input type="button" class="button_4" onmouseover="buttonover(this);"
                     onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                     value="<bean:message bundle='bail' key='batchadd'/>" onClick="doBatch('/cms/fee/bail/batch.do');"/>
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
				<td nowrap><bean:message bundle="bail" key="seq"/></td>
                <td nowrap><bean:message bundle="bail" key="wayid"/></td>
                <td nowrap><bean:message bundle="bail" key="bailtype"/></td>
                <td nowrap><bean:message bundle="bail" key="money"/></td>
                <td nowrap><bean:message bundle="bail" key="givetime"/></td>
                <td nowrap><bean:message bundle="bail" key="opertype"/></td>
                <td nowrap><bean:message bundle="bail" key="recvoprcode"/></td>
                <td nowrap><bean:message bundle="bail" key="recvtime"/></td>
                <td nowrap><bean:message bundle="bail" key="memo"/></td>	
            </tr>
            <c:forEach var="item" items="${requestScope.LIST.datas}">
                 <c:url value="/cms/fee/bail.do?CMD=EDIT" var="urlContent">
                     <%//this param name must "PK" %>
                     <c:param name="PK" value="${item.seq}"/>
                 </c:url>
                 <tr class="table_style_content" align="center">
                     <td>
                         <input type="checkbox" name="_selectitem" value="<c:out value='${item.seq}' />"
                                onclick="checkOne(this);" class="table_checkbox">
                     </td>
                     <td>
                         <a href='<c:out value="${urlContent}"/>'><c:out value="${item.seq}"/></a>
                     </td>
					<td><c:out value="${item.wayid}"/> - <s:Code2Name code="${item.wayid}" definition="#WAY"/></td>
					<td><s:Code2Name code="${item.bailtype}" definition="$CH_GUARTYPE"/></td>
					<td><fmt:formatNumber pattern="0.00" value="${item.money}"/></td>
					<td><fmt:formatDate pattern="yyyy-MM-dd" value="${item.givetime}"/></td>
					<td><s:Code2Name code="${item.opertype}" definition="$CH_BAILOPERTYPE"/></td>
					<td><c:out value="${item.recvoprcode}"/></td>
					<td><fmt:formatDate pattern="yyyy-MM-dd" value="${item.recvtime}"/></td>
					<td><c:out value="${item.memo}"/></td>
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
