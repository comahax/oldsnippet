<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc"%>
<%
    String ID_1 = "CH_PW_SOTYWAY_ADD";
    String ID_2 = "CH_PW_SOTYWAY_DELETE";
    String ID_3 = "CH_PW_SOTYWAY_QUERY";
%>

<html>
<head>
    <title><bean:message bundle="bchcontact" key="distitleList"/></title>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            addfield('_se_wayid', '<bean:message bundle="bchcontact" key="wayid"/>', 'c', true, '18');
            addfield('_sk_principal', '<bean:message bundle="bchcontact" key="principal"/>', 'c', true, '64');
            addfield('_sk_principaltel', '<bean:message bundle="bchcontact" key="principaltel"/>', 'c', true, '20');
            addfield('_sk_principalemail', '<bean:message bundle="bchcontact" key="principalemail"/>', 'c', true, '128');
            return checkval(window);
        }
        
        function doNew(){
           var str = self.parent.location.toString();
           if (!ev_check()) return;
           if(str.indexOf("subindex.jsp")==-1){
              formList._se_wayid.value='';
           }
           formList.action = contextPath + '/cms/disbchcontact.do?CMD=NEW';
           formList.submit();
        }  
    </script>
</head>

<body onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<html:form action="/cms/disbchcontact.do?CMD=LIST" styleId="formList" method="post" onsubmit="return ev_check();">
	  <input type="hidden" name="subtype" value="DIS" />
    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <input type="hidden" name="_rowcount" value="<c:out value='${requestScope.LIST.rowCount}' />">

    <!--##################################添加标题内容##################################################-->
    <div class="table_div">
    <table class="top_table">
    	<tr>
    		<td>
    			<bean:message bundle="bchcontact" key="distitleList"/>
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
                <td width="126" height="20" align="right" class="form_table_right" ><bean:message bundle="bchcontact" key="wayid"/>:</td>
                <td class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_se_wayid"></html:text>
                </td>
                <td width="126" height="20" align="right" class="form_table_right" ><bean:message bundle="bchcontact" key="principal"/>:</td>
                <td class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_sk_principal"></html:text>
                </td>
                <td width="126" height="20" align="right" class="form_table_right" ><bean:message bundle="bchcontact" key="principaltel"/>:</td>
                <td class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_sk_principaltel"></html:text>
                </td>
            </tr>
        </table>
    </div>
	<div class="table_div">
		<table class="table_button_list">
			<tr> 
                <td align=right>
                        <s:PurChk2 controlid="<%=ID_1%>">
                            <input type="button" name="btnNew"  class="add" onmouseover="buttonover(this);"
                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                            value="<bean:message bundle="public" key="button_new"/>" onClick="doNew()">
                        </s:PurChk2>
                        <s:PurChk2 controlid="<%=ID_2%>">
                            <input type="button" name="btnDelete" class="delete" onmouseover="buttonover(this);"
                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                            value="<bean:message bundle="public" key="button_delete"/>" onClick="doDelete('/cms/disbchcontact.do')">
                        </s:PurChk2>
                        <s:PurChk2 controlid="<%=ID_3%>">
                        <input type="button" class="query"onmouseover="buttonover(this);" onclick="doQuery();" 
                                onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                                value="<bean:message bundle="public" key="button_search"/>" />
                        </s:PurChk2>
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
                    <a href="javascript:doOrderby('wayid')"><bean:message bundle="bchcontact" key="wayid"/></a>
                    <s:OrderImg form="/cms/bchcontact/BchcontactForm" field="wayid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('principal')"><bean:message bundle="bchcontact" key="principal"/></a>
                    <s:OrderImg form="/cms/bchcontact/BchcontactForm" field="principal"/>
                </td>
                
                <td><bean:message bundle="bchcontact" key="principaltel"/></td>
                <td><bean:message bundle="bchcontact" key="linkman"/></td>
                <td><bean:message bundle="bchcontact" key="linkmantel"/></td>
                <td><bean:message bundle="bchcontact" key="principalemail"/></td>
                <td><bean:message bundle="bchcontact" key="linkmanemail"/></td>
            </tr>
            <c:forEach var="item" items="${requestScope.LIST.datas}">
                 <c:url value="/cms/disbchcontact.do?CMD=EDIT" var="urlContent">
                     <%//this param name must "PK" %>
                     <c:param name="PK" value="${item.wayid}"/>
                     <%-- <c:param name="PK" value="'${item.id}|${item.id2}'"/> --%>
                 </c:url>
                 <tr class="table_style_content" align="center">
                     <td>
                         <input type="checkbox" name="_selectitem" value="<c:out value='${item.wayid}' />"
                                onclick="checkOne(this);" class="table_checkbox">
                     </td>
                     <td>
                         <a href='<c:out value="${urlContent}"/>'><c:out value="${item.wayid}"/></a>
                     </td>
                     <td><c:out value="${item.principal}"/></td>
                     <td><c:out value="${item.principaltel}"/></td>
                     <td><c:out value="${item.linkman}"/></td>
                     <td><c:out value="${item.linkmantel}"/></td>
                     <td><c:out value="${item.principalemail}"/></td>
                     <td><c:out value="${item.linkmanemail}"/></td>
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
