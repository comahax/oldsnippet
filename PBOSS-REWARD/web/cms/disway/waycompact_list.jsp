<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc"%>
<%
    String ID_1 = "CH_PW_SOTYWAY_ADD";
    String ID_2 = "CH_PW_SOTYWAY_DELETE";
    String ID_3 = "CH_PW_SOTYWAY_QUERY";
%>

<html>
<head>
    <title><bean:message bundle="waycompact" key="distitleList"/></title>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            return checkval(window);
        }
        
        function doNew(){
           var str = self.parent.location.toString();
           if (!ev_check()) return;
           if(str.indexOf("subindex.jsp")==-1){
              formList._se_wayid.value='';
           }
           formList.action = contextPath + '/cms/diswaycompact.do?CMD=NEW';
           formList.submit();
        }  
    </script>
</head>

<body onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<html:form action="/cms/diswaycompact.do?CMD=LIST" styleId="formList" method="post" onsubmit="return ev_check();">
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
    			<bean:message bundle="waycompact" key="distitleList"/>
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
                <td width="126" height="20" align="right" class="form_table_right" ><bean:message bundle="waycompact" key="wayid"/>:</td>
                <td class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_se_wayid"></html:text>
                </td>
                <td width="126" height="20" align="right" class="form_table_right" ><bean:message bundle="waycompact" key="compactno"/>:</td>
                <td class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_sk_compactno"></html:text>
                </td>
                <td width="126" height="20" align="right" class="form_table_right" ><bean:message bundle="waycompact" key="compactname"/>:</td>
                <td class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_sk_compactname"></html:text>
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
                            value="<bean:message bundle="public" key="button_delete"/>" onClick="doDelete('/cms/diswaycompact.do')">
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
                    <a href="javascript:doOrderby('wayid')"><bean:message bundle="waycompact" key="wayid"/></a>
                    <s:OrderImg form="/cms/waycompact/WaycompactForm" field="wayid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('compactno')"><bean:message bundle="waycompact" key="compactno"/></a>
                    <s:OrderImg form="/cms/waycompact/WaycompactForm" field="compactno"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('compactname')"><bean:message bundle="waycompact" key="compactname"/></a>
                    <s:OrderImg form="/cms/waycompact/WaycompactForm" field="compactname"/>
                </td>
                <td><bean:message bundle="waycompact" key="signtime"/></td>
                <td><bean:message bundle="waycompact" key="endtime"/></td>
                <td><bean:message bundle="waycompact" key="copbound"/></td>
                <td><bean:message bundle="waycompact" key="runareatype"/></td>
                <td><bean:message bundle="waycompact" key="principal"/></td>
            </tr>
            <c:forEach var="item" items="${requestScope.LIST.datas}">
                 <c:url value="/cms/diswaycompact.do?CMD=EDIT" var="urlContent">
                     <c:param name="PK" value="${item.wayid}"/>
                 </c:url>
                 <tr class="table_style_content" align="center">
                     <td>
                         <input type="checkbox" name="_selectitem" value="<c:out value='${item.wayid}' />"
                                onclick="checkOne(this);" class="table_checkbox">
                     </td>
                     <td>
                         <a href='<c:out value="${urlContent}"/>'><c:out value="${item.wayid}"/></a>
                     </td>
                     <td><c:out value="${item.compactno}"/></td>
                     <td><c:out value="${item.compactname}"/></td>
                     <td><fmt:formatDate value="${item.signtime}" pattern="yy-MM-dd" /></td>
                     <td><fmt:formatDate value="${item.endtime}" pattern="yy-MM-dd" /></td>
                     <td><c:out value="${item.copbound}"/></td>
                     <td>  <s:Code2Name code="${item.runareatype}"  definition="$CH_ORGTYPE"/> </td>
                     <td><c:out value="${item.principal}"/></td>
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
