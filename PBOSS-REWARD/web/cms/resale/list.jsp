<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc"%>
<%
    String ID_1 = "CH_PW_RESALE_ADD";
    String ID_2 = "CH_PW_RESALE_DELETE";
    String ID_3 = "CH_PW_RESALE_QUERY";
    String ID_4 = "CH_PW_RESALE_BATCHIMPORT";
%>
<html>
<head>
    <title><bean:message bundle="resale" key="titleList"/></title>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            addfield('_se_wayid', '<bean:message bundle="resale" key="wayid"/>', 'c', true, '18');
            addfield('_se_mobile', '<bean:message bundle="resale" key="mobile"/>', 'c', true, '12');
            addfield('_dnl_daytime', '<bean:message bundle="resale" key="daytime"/>', 't', true, '25');
            addfield('_dnm_daytime', '<bean:message bundle="resale" key="daytime"/>', 't', true, '25');
            return checkval(window);
        }
        
    function upload(){
		formList.action="<%=contextPath%>/cms/resale/batchupfile.jsp";
		formList.submit();
	}
	function upload1(){
		formList.action="<%=contextPath%>/cms/resale/batchupfile2.jsp";
		formList.submit();
	}
	
	function del() {
		formList.wayvl.value= ""; 
	}
    </script>
    <script type="text/javascript"
			src="<%=contextPath%>/js/bus/waycommon.js"></script>
</head>

<body onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<html:form action="/cms/resale.do?CMD=LIST" styleId="formList" method="post" onsubmit="return ev_check();">
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
    			<bean:message bundle="resale" key="titleList"/>
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
                <td width="126" height="20" align="right" class="form_table_right" ><bean:message bundle="resale" key="wayid"/>:</td>
                <td class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_se_wayid" ></html:text>
								<input type="button" value="..." class="clickbutton" name="wayvl" onclick="showSelectWay(this,'_se_wayid');del();" />
                </td>
                <td width="126" height="20" align="right" class="form_table_right" ><bean:message bundle="resale" key="mobile"/>:</td>
                <td class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_se_mobile"></html:text>
                </td>
                </tr>
            <tr>
             <td width="126" height="20" align="right" class="form_table_right" ><bean:message bundle="resale" key="daytime"/>>=:</td>
                <td class="form_table_left">
               	<html:text styleClass="form_input_1x" property="_dnl_daytime"
									onclick="this.value=selectDate();" ></html:text>
                </td>
           
                <td width="126" height="20" align="right" class="form_table_right" ><bean:message bundle="resale" key="daytime"/><=:</td>
                <td class="form_table_left">
               	<html:text styleClass="form_input_1x" property="_dnm_daytime"
									onclick="this.value=selectDate();" ></html:text>
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
                        <c:choose>
                        	<c:when test="${requestScope.SHOW=='TRUE'}" >
                        		 <input type="button" value="<bean:message bundle="resale" key="import"/>" 
								class="button_2" onclick="upload();" onmouseover="buttonover(this)"
								onmouseout="buttonout(this)" onfocus="buttonover(this)" onblur="buttonout(this)">
                        	</c:when>
                        	<c:otherwise>
                        		 <input type="button" value="<bean:message bundle="resale" key="import"/>" 
								class="button_2" disabled="true" onmouseover="buttonover(this)"
								onmouseout="buttonout(this)" onfocus="buttonover(this)" onblur="buttonout(this)">
                        	</c:otherwise>
                        </c:choose>
                        <input type="button" name="btnDelete" class="delete" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="<bean:message bundle="public" key="button_delete"/>" onClick="doDelete('/cms/resale.do')">
                        <c:choose>
                        	<c:when test="${requestScope.SHOW=='TRUE'}" >
                        		 <input type="button" value="批量删除" 
								class="button_4" onclick="upload1();" onmouseover="buttonover(this)"
								onmouseout="buttonout(this)" onfocus="buttonover(this)" onblur="buttonout(this)">
                        	</c:when>
                        	<c:otherwise>
                        		 <input type="button" value="批量删除" class="button_4"
								onmouseover="buttonover(this)"
								onmouseout="buttonout(this)" onfocus="buttonover(this)" onblur="buttonout(this)" disabled="true" >
                        	</c:otherwise>
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
                <td>
                   <bean:message bundle="resale" key="mobile"/>
                    
                </td>
                <td>
                   <bean:message bundle="resale" key="wayid"/>
                    
                </td>
                <td>
                   <bean:message bundle="resale" key="countyid"/>
                    
                </td>
                <td>
                    <bean:message bundle="resale" key="brand"/>
                    
                </td>
                <td>
					<bean:message bundle="resale" key="daytime"/>
                    
                </td>
            </tr>
            <c:forEach var="item" items="${requestScope.LIST.datas}">
                 <c:url value="/cms/resale.do?CMD=EDIT" var="urlContent">
                     <%//this param name must "PK" %>
                     <c:param name="PK" value="${item.mobile}"/>
                     <%-- <c:param name="PK" value="'${item.id}|${item.id2}'"/> --%>
                 </c:url>
                 <tr class="table_style_content" align="center">
                     <td>
                         <input type="checkbox" name="_selectitem" value="<c:out value='${item.mobile}' />"
                                onclick="checkOne();" class="table_checkbox">
                     </td>
                     <td>
                         <a href='<c:out value="${urlContent}"/>'><c:out value="${item.mobile}"/></a>
                     </td>
                     <td><c:out value="${item.wayid}"/></td>
                     <td>  <s:Code2Name definition="#CNTYCOMPANY" code="${item.countyid }"/></td>
                     <td>
                     <s:Code2Name code="${item.brand}" definition="#BUSI_BRAND" />  
                     </td>
                     <td>
                     	<fmt:formatDate value="${item.daytime}" pattern="yyyy-MM-dd"/>
                     </td>
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
