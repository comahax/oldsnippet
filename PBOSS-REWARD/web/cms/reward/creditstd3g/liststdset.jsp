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
    <title><bean:message bundle="creditstd3g" key="titleListstdset"/></title>
    <script language="JavaScript" type="text/JavaScript">
    </script>
</head>

<body onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<html:form action="/cms/reward/creditstd3g.do?CMD=LISTSTDSET" styleId="formList" method="post">
    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <input type="hidden" name="_rowcount" value="<c:out value='${requestScope.LIST.rowCount}' />">
    <c:set var="form" scope="request" value="${requestScope['/cms/reward/creditstd3g/Creditstd3gForm']}"/>

    <!--##################################��ӱ�������##################################################-->
    <div class="table_div">
    <table class="top_table">
    	<tr>
    		<td>
    			<bean:message bundle="creditstd3g" key="titleListstdset"/>
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
      <div class="table_LongTable">
        <table class="table_style" ID="Table2">
            <tr class="table_style_head">
                <td>
                    <a href="javascript:doOrderby('wayattr')"><bean:message bundle="creditstd3g" key="wayattr"/></a>
                    <s:OrderImg form="/cms/reward/creditstd3g/Creditstd3gForm" field="wayattr"/>
                </td>
                <td>
                   <bean:message bundle="creditstd3g" key="rewardstd"/>
                </td>
                <td>
                   <bean:message bundle="creditstd3g" key="rewardstdup"/>
                </td>
                <td>
                    <bean:message bundle="creditstd3g" key="creditstd"/>
                </td>
                <td>
                    <bean:message bundle="creditstd3g" key="terminalstd"/>
                </td>
                <td>
                    <bean:message bundle="creditstd3g" key="zcterminalstd"/>
                </td>
                 <td>
                   ȫ��ͨ��������Ҫ��
                </td>
                <td>
                    <bean:message bundle="creditstd3g" key="intvmonth"/>
                </td>
            </tr>
            <c:forEach var="item" items="${requestScope.LIST.datas}">
                 <c:url value="/cms/reward/creditstd3g.do?CMD=EDITSTDSET" var="urlContent">
                     <%//this param name must "PK" %>
                     <c:param name="PK" value="${item.cityid}|${item.wayattr}"/>
                     <%-- <c:param name="PK" value="'${item.id}|${item.id2}'"/> --%>
                 </c:url>
                 <tr class="table_style_content" align="center">                     
                     <td>
                     	 <a href='<c:out value="${urlContent}"/>'>
                         <s:Code2Name code="${item.wayattr}" definition="$CH_WAYATTR" />  
                         </a>                       
                     </td>
                     <td><fmt:formatNumber pattern="0.00" value="${item.rewardstd}" /></td>
                     <td><fmt:formatNumber pattern="0.00" value="${item.rewardstdup}" /></td>
                     <td><fmt:formatNumber pattern="0.00" value="${item.creditstd}" /></td>
                     <td><fmt:formatNumber pattern="0.00" value="${item.terminalstd}" /></td>
                     <td><fmt:formatNumber pattern="0.00" value="${item.zcterminalstd}" /></td>
                     <td><fmt:formatNumber pattern="0.00" value="${item.gtnstd}" /></td>
                     <td><c:out value="${item.intvmonth}"/></td>
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