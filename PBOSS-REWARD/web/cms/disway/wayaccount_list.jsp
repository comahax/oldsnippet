<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc" %>

<jsp:include page="/inc/acl.jsp">
  <jsp:param name="PID" value="2B1A3CBB80" />
</jsp:include>
<%
    String ID_1 = "CH_PW_SOTYWAY_ADD";
    String ID_2 = "CH_PW_SOTYWAY_DELETE";
    String ID_3 = "CH_PW_SOTYWAY_QUERY";
%>

<html>
<head>
    <title><bean:message bundle="wayaccount" key="distitleList"/></title>
    <script language="JavaScript" type="text/JavaScript">
        <%//查询条件的校检%>
        function ev_check() {
            addfield('_se_wayid', '<bean:message bundle="wayaccount" key="wayid"/>', 'c', true, 20);
            addfield('_ne_accid', '<bean:message bundle="wayaccount" key="accid"/>', 'i', true, 20);
            return checkval(window);
        }
        
        function doQueryByWayid(){
           var str = self.parent.location.toString();
           if (!ev_check()) return;
           if(str.indexOf("subindex.jsp")==-1){
              formList.action = "<%=contextPath%>/cms/diswayaccount.do?CMD=LIST";
              formList.submit();
           }else{
               var len1 = str.indexOf("subindex.jsp?wayid=");
               var len2 = str.length;
               var wayid = str.substring(len1+19,len2);
               formList.action = "<%=contextPath%>/cms/diswayaccount.do?CMD=LIST&WAYSUBTYPE=DIS&WAYID="+wayid;
               formList.submit();    
           }
        }
        
        function doNew(){
           var str = self.parent.location.toString();
           if (!ev_check()) return;
           if(str.indexOf("subindex.jsp")==-1){
              formList._se_wayid.value='';
           }else{
               var len1 = str.indexOf("subindex.jsp?wayid=");
               var len2 = str.length;
               var wayid = str.substring(len1+19,len2);
               formList._se_wayid.value=wayid;
           }
           formList.action = contextPath + '/cms/diswayaccount.do?CMD=NEW';
           formList.submit();
        }  
    </script>
</head>

<body onload="if(window.loadforiframe) loadforiframe();">

<div class="table_container">
<html:form action="/cms/diswayaccount.do?CMD=LIST" styleId="formList" method="post" onsubmit="return ev_check();">
	  <input type='hidden' name='subtype' value='DIS'/>
    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <input type="hidden" name="_rowcount" value="<c:out value='${requestScope.LIST.rowCount}' />">
	
	<div class="table_div">				
		<table class="top_table">
			<tr> 
				<td>
					<bean:message bundle="wayaccount" key="distitleList"/>
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
        <table class="form_table">        	 
            <tr>               
                <td width="80" height="20" align="right" class="form_table_right" nowrap>
                	<bean:message bundle="wayaccount" key="wayid"/>:
               	</td>
                <td class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_se_wayid" />
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
                 <s:PurChk2 controlid="<%=ID_1%>">
                     <input type="button" name="btnNew"  class="add" onmouseover="buttonover(this);"
                     onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                     value="<bean:message bundle="public" key="button_new"/>" onClick="doNew()">
                 </s:PurChk2>
                 <s:PurChk2 controlid="<%=ID_2%>">
                     <input type="button" name="btnDelete" class="delete" onmouseover="buttonover(this);"
                     onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                     value="<bean:message bundle="public" key="button_delete"/>" onClick="doDelete('/cms/diswayaccount.do')">
                 </s:PurChk2>
                  <s:PurChk2 controlid="<%=ID_3%>">
	                 <input type="button" class="query"onmouseover="buttonover(this);"
	                         onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
	                         value="<bean:message bundle="public" key="button_search"/>" onClick="doQueryByWayid();" />
                  </s:PurChk2>        
                         
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
                <td nowrap><bean:message bundle="wayaccount" key="acctno"/></td>
                <td nowrap><bean:message bundle="wayaccount" key="acctname"/></td>
                <td nowrap><bean:message bundle="wayaccount" key="bankname"/></td>
                <td nowrap><bean:message bundle="wayaccount" key="acctfid"/></td>
     
            </tr>
            <c:forEach var="item" items="${requestScope.LIST.datas}">
                 <c:url value="/cms/diswayaccount.do?CMD=EDIT" var="urlContent">
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
                     <td><c:out value="${item.acctno}"/></td>               
                     <td><c:out value="${item.acctname}"/></td>
                     <td><c:out value="${item.bankname}"/></td>
                     <td><c:out value="${item.acctfid}"/></td>                                                        
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
