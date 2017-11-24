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
    <title><bean:message bundle="creditstd3g" key="titleList"/></title>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            addfield('_ne_cityid', '<bean:message bundle="creditstd3g" key="cityid"/>', 'f', 'false', '3');
            addfield('_se_wayattr', '<bean:message bundle="creditstd3g" key="wayattr"/>', 'c', 'false', '3');
            return checkval(window);
        }
    </script>
</head>

<body onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<html:form action="/cms/reward/creditstd3g.do?CMD=LIST" styleId="formList" method="post" onsubmit="return ev_check();">
    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <input type="hidden" name="_rowcount" value="<c:out value='${requestScope.LIST.rowCount}' />">
    <c:set var="form" scope="request" value="${requestScope['/cms/reward/creditstd3g/Creditstd3gForm']}"/>

    <!--##################################添加标题内容##################################################-->
    <div class="table_div">
    <table class="top_table">
    	<tr>
    		<td>
    			<bean:message bundle="creditstd3g" key="titleList"/>
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
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="creditstd3g" key="cityid"/>:</td>
                <td width="30%" class="form_table_left">
                    <html:select property="_ne_cityid">
                    	<option />
                    	<s:Options definition="$CH_CITYCOMPTYPE" />
                    </html:select>
                </td>
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="creditstd3g" key="wayattr"/>:</td>
                <td width="30%" class="form_table_left">                    
                    <html:select property="_se_wayattr">
                    	<option />
                    	<s:Options definition="$CH_WAYATTR" />
                    </html:select>
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
                </td>
			</tr>
		</table>
	</div>

    <div class="table_div">
      <div class="table_LongTable">
        <table class="table_style" ID="Table2">
            <tr class="table_style_head">
                <td>
                    <a href="javascript:doOrderby('cityid')"><bean:message bundle="creditstd3g" key="cityid"/></a>
                    <s:OrderImg form="/cms/reward/creditstd3g/Creditstd3gForm" field="cityid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('wayattr')"><bean:message bundle="creditstd3g" key="wayattr"/></a>
                    <s:OrderImg form="/cms/reward/creditstd3g/Creditstd3gForm" field="wayattr"/>
                </td>
                <td>
                   <bean:message bundle="creditstd3g" key="rewardstdup"/>
                </td>
            </tr>
            <c:forEach var="item" items="${requestScope.LIST.datas}">
                 <c:url value="/cms/reward/creditstd3g.do?CMD=EDIT" var="urlContent">
                     <%//this param name must "PK" %>
                     <c:param name="PK" value="${item.cityid}|${item.wayattr}"/>
                     <%-- <c:param name="PK" value="'${item.id}|${item.id2}'"/> --%>
                 </c:url>
                 <tr class="table_style_content" align="center">                     
                     <td>
                         <a href='<c:out value="${urlContent}"/>'>                         
                         <s:Code2Name code="${item.cityid}" definition="$CH_CITYCOMPTYPE" />
                         </a>
                     </td>
                     <td>
                         <a href='<c:out value="${urlContent}"/>'>
                         <s:Code2Name code="${item.wayattr}" definition="$CH_WAYATTR" />
                         </a>
                     </td>
                     <td><fmt:formatNumber pattern="0.00" value="${item.rewardstd}" /></td>
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
