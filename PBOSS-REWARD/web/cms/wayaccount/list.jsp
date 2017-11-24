<%@ page language="java" contentType="text/html;charset=GBK"%>
<%//    head.inc是List.jsp的文件头，声明了JS、CSS等的引用，所有list.jsp必须引用这个文件头%>
<%@ include file="/inc/listhead.inc" %>

<jsp:include page="/inc/acl.jsp">
  <jsp:param name="PID" value="2B1A3CBB80" />
</jsp:include>
<%
	//业务控制点标识，暂时没用上，先保留  
    String PID = "2B1A3CBB80";
    String ID_1 = PID + "BT1";
    String ID_2 = PID + "BT2";
    String ID_3 = PID + "BT3";    
%>
<html>
<head>
    <title><bean:message bundle="wayaccount" key="titleList"/></title>
    <script language="JavaScript" type="text/JavaScript">
        <%//查询条件的校检%>
        function ev_check() {
            addfield('_se_wayid', '<bean:message bundle="wayaccount" key="wayid"/>', 'c', true, 20);
            addfield('_ne_accid', '<bean:message bundle="wayaccount" key="accid"/>', 'c', true, 20);
            return checkval(window);
        }
    </script>
</head>

<body onload="document.formList._se_wayid.focus() loadforiframe()">

<div class="table_container">
<html:form action="/cms/wayaccount.do?CMD=LIST" styleId="formList" method="post" onsubmit="return ev_check();">
    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <html:hidden property="wayid"/>
    <input type="hidden" name="_rowcount" value="<c:out value='${requestScope.LIST.rowCount}' />">
	
	<div class="table_div">				
		<table class="top_table">
			<tr> 
				<td>
					<bean:message bundle="wayaccount" key="titleList"/>
				</td>
			</tr>
		</table>
	</div>
	
		<div class="table_div">
	     <table width="100%" class="error_text">
       	   <s:Msg />
       </table>	
		</div>	
    	

		
<div class="table_div">		
	
	<!--#################################添加标题内容，里面可以放置按钮###################################################-->
        <html:hidden styleClass="form_input_1x" property="_se_wayid"/>               
        <table class="form_table">        	 
            <tr>               
                <td width="80" height="20" align="right" class="form_table_right" nowrap>
                	<bean:message bundle="wayaccount" key="wayid"/>:
               	</td>
                <td class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_se_wayid" readonly="true"/>
                </td>
              	<td width="80" height="20" align="right" class="form_table_right" nowrap>
                	<bean:message bundle="wayaccount" key="accid"/>:
               	</td>
                <td class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_ne_accid" />
                </td>
            </tr>
        </table>
</div>   

	<!--##################################添加标题内容，里面可以放置按钮##################################################-->		
	<div class="table_div">
				<table class="table_button_list">
					<tr>
						<td>
						<c:choose>
							<c:when test="${requestScope['/cms/wayfacility/WayfacilityForm'].cmdState ne 'ERROR'}">
                 <s:PurChk controlid="<%=ID_1%>">
                     <input type="button" name="btnNew"  class="add" onmouseover="buttonover(this);"
                     onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                     value="<bean:message bundle="public" key="button_new"/>" onClick="doNew('/cms/wayaccount.do')">
                 </s:PurChk>
                 <s:PurChk controlid="<%=ID_2%>">
                     <input type="button" name="btnDelete" class="delete" onmouseover="buttonover(this);"
                     onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                     value="<bean:message bundle="public" key="button_delete"/>" onClick="doDelete('/cms/wayaccount.do')">
                 </s:PurChk>
                 
                  <s:PurChk controlid="<%=ID_3%>">
	                 <input type="button" class="query"onmouseover="buttonover(this);" onclick="doQuery();" 
	                         onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
	                         value="<bean:message bundle="public" key="button_search"/>" />
                  </s:PurChk>        
                         
							</c:when>
						</c:choose>
							
							

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
                <td nowrap>
                    <a href="javascript:doOrderby('wayid')"><bean:message bundle="wayaccount" key="wayid"/></a>
                    <s:OrderImg form="/cms/wayaccount/WayaccountForm" field="wayid"/>
                </td>
                <td nowrap>
                    <a href="javascript:doOrderby('accid')"><bean:message bundle="wayaccount" key="accid"/></a>
                    <s:OrderImg form="/cms/wayaccount/WayaccountForm" field="accid"/>
                </td>
                <td nowrap><bean:message bundle="wayaccount" key="chargetype"/></td>
                <td nowrap><bean:message bundle="wayaccount" key="accttype"/></td>
                <td nowrap><bean:message bundle="wayaccount" key="acctname"/></td>
                <td nowrap><bean:message bundle="wayaccount" key="bankname"/></td>
                <td nowrap><bean:message bundle="wayaccount" key="dsbank"/></td>
                <td nowrap><bean:message bundle="wayaccount" key="rectime"/></td>
                <td nowrap><bean:message bundle="wayaccount" key="starttime"/></td>           
            </tr>
            <c:forEach var="item" items="${requestScope.LIST.datas}">
                 <c:url value="/cms/wayaccount.do?CMD=EDIT" var="urlContent">
                     <%//这个param名称必须是“PK”%>
                     <c:param name="PK" value="${item.accid}|${item.wayid}"/>
                     <%//如果是复合主键，需要这样写”%>
                     <%--<c:param name="PK" value="'${item.id}|${item.id2}'"/>--%>
                 </c:url>
                 <tr class="table_style_content" align="center">
                     <td>
                         <input type="checkbox" name="_selectitem" value="<c:out value='${item.accid}|${item.wayid}' />"     
                                onclick="checkOne();" class="table_checkbox">
                     </td>
                     <td>
                         <a href='<c:out value="${urlContent}"/>'><c:out value="${item.wayid}"/></a>
                     </td>
                     <td>
                         <a href='<c:out value="${urlContent}"/>'><c:out value="${item.accid}"/></a>
                     </td>                    
                     <td> <s:Code2Name code="${item.chargetype}" definition="$CH_CHARGETYPE"/> </td>
                     <td> <s:Code2Name code="${item.accttype}" definition="$CH_ACCOUNTTYPE"/> </td>
                     <td><c:out value="${item.acctname}"/></td>
                     <td><c:out value="${item.bankname}"/></td>
                     <td><c:out value="${item.dsbank}"/></td>                     
                     <td><c:out value="${item.rectime}"/></td>
                     <td><c:out value="${item.starttime}"/></td>                                      
                 </tr>
             </c:forEach>
        </table>
    </div>
</div>

<div class="table_div">
	<s:PageNav dpName="LIST"/>			
</div>

    
</html:form>
</body>
</html>
