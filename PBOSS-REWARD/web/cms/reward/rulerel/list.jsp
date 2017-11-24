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
    <title><bean:message bundle="rulerel" key="titleList"/></title>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            //addfield('_se_ruleitemid', '<bean:message bundle="rulerel" key="ruleitemid"/>', 'c', true, '18');
            //addfield('_se_ruleid', '<bean:message bundle="rulerel" key="ruleid"/>', 'c', true, '18');
           // addfield('_se_cityid', '<bean:message bundle="rulerel" key="cityid"/>', 'c', true, '4');
          //  addfield('_ne_state', '<bean:message bundle="rulerel" key="state"/>', 'f', false, '2');
            return checkval(window);
        }
        function doReturn(){
	        formList._orderby.value='';
        	formList.action = contextPath + '/cms/reward/rule.do?CMD=LIST';
        	formList.submit();
        }
    </script>
</head>

<body onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<html:form action="/cms/reward/rulerel.do?CMD=LIST" styleId="formList" method="post" onsubmit="return ev_check();">
    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <html:hidden property="_se_cityid"/>
    <html:hidden property="_se_ruleid"/>
    <input type="hidden" name="_rowcount" value="<c:out value='${requestScope.LIST.rowCount}' />">
    <c:set var="formvalue" scope="request" value="${requestScope['/cms/reward/rulerel/RulerelForm']}"/>

    <!--##################################添加标题内容##################################################-->
    <div class="table_div">
    <table class="top_table">
    	<tr>
    		<td>
    			<bean:message bundle="rulerel" key="titleList"/>
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
      <tr >
      	<td width="15%">
      		<bean:message bundle="rulerel" key="ruleid"/>
      	</td>
      	<td width="90%">
      		<c:out value="${formvalue._se_ruleid}"/>
      	</td>
      </tr>
      <tr >
      	<td width="15%">
      		<bean:message bundle="rulerel" key="rulename"/>
      	</td>
      	<td width="90%">
	      	<s:Code2Name code="${formvalue._se_ruleid}" definition="#CH_ADT_RULE"/>
      	</td>
      </tr>
      <tr >
      	<td width="15%">
      		<bean:message bundle="rulerel" key="ruleitem"/>
      	</td>
      	<td width="90%">
      	 <div class="table_div">
      	 
        <table class="table_style" ID="Table3">
            <tr class="table_style_head">          
                <td>
                    <a href="javascript:doOrderby('ruleitemid')"><bean:message bundle="rulerel" key="ruleitemid"/></a>
                    <s:OrderImg form="/cms/reward/rulerel/rulerelForm" field="ruleitemid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('ruleitemname')"><bean:message bundle="rulerel" key="ruleitemname"/></a>
                    <s:OrderImg form="/cms/reward/rulerel/rulerelForm" field="ruleitemname"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('state')"><bean:message bundle="rulerel" key="state"/></a>
                    <s:OrderImg form="/cms/reward/rulerel/rulerelForm" field="state"/>
                </td>
            </tr>
            <c:forEach var="item" items="${requestScope.LIST.datas}">
                 <c:url value="/cms/reward/rulerel.do?CMD=EDIT" var="urlContent">
                     <%//this param name must "PK" %>
                     <c:param name="PK" value="${formvalue._se_cityid}|${formvalue._se_ruleid}|${item[1].ruleitemid}|${item[0].rulemodeid}"/>
                     <%--<c:param name="PK" value="'${item.id}|${item.id2}'"/> --%>
                 </c:url>
                 <tr class="table_style_content" align="center">
                    
                     <td>
                         <a href='<c:out value="${urlContent}"/>'><c:out value="${item[1].ruleitemid}"/></a>
                     </td>
                     <td>
                         <a href='<c:out value="${urlContent}"/>'><c:out value="${item[1].ruleitemname}"/></a>
                     </td>
                     <td>
                     	<c:choose>
								<c:when test="${item[0].state=='0'}">
									<font color=red><bean:message bundle="rulerel" key="invalid"/></font>
								</c:when>
								<c:otherwise>
									<bean:message bundle="rulerel" key="valid"/>
								</c:otherwise>
							</c:choose>
                     
                     </td>
                 </tr>
             </c:forEach>
        </table>
        </div>

        </td>
         </tr>
        </table>
     
   </div>
   
   	<div class="table_div">
		<table class="table_button_list">
			<tr> 
                <td align=right>
                        <input type="button" class="back" onmouseover="buttonover(this);"
                                onmouseout="buttonout(this);" onfocus="buttonover(this)" 
                                onblur="buttonout(this)" onclick="doReturn();"
                                value="<bean:message bundle="public" key="button_return"/>" />
                     
                </td>
			</tr>
		</table>
	</div>
   

   <div class="table_div">
		<s:PageNav dpName="LIST"/>
   </div>
</html:form>
</div>
</body>
</html>
