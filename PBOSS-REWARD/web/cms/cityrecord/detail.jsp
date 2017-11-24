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
    <title>明细页面</title>
</head>

<body>
<div class="table_container">
<html:form action="/cms/cityrecord.do?CMD=LISTDETAIL" styleId="formList" method="post" >
    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <!-- 分页保存的参数 -->
    <html:hidden property="opnid2"/>
    <html:hidden property="rewardtype"/>
    <html:hidden property="oprmonth"/>
    <html:hidden property="isflag"/>
    <html:hidden property="_se_wayid"/>
    <html:hidden property="_se_rewardmonth"/>
    <html:hidden property="_ne_systemflag"/>
    <html:hidden property="_sin_opnid"/>
    <html:hidden property="_ne_taskid"/>
    <html:hidden property="_se_paymonth"/>
    <html:hidden property="_se_countyid"/>
    <input type="hidden" name="_rowcount" value="<c:out value='${requestScope.LIST.rowCount}' />">
    <c:set var="form" scope="request" value="${requestScope['/cms/cityrecord/CityrecordForm']}"/>

    <!--##################################添加标题内容##################################################-->
    
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
                    <bean:message bundle="cityrecord" key="isflag"/>
                    <s:OrderImg form="/cms/cityrecord/CityrecordForm" field="isflag"/>
                </td>
                <td>
                    <bean:message bundle="cityrecord" key="systemflag"/>
                    <s:OrderImg form="/cms/cityrecord/CityrecordForm" field="systemflag"/>
                </td>
                <td>
                    <bean:message bundle="cityrecord" key="wayid"/>
                    <s:OrderImg form="/cms/cityrecord/CityrecordForm" field="wayid"/>
                </td>
                <td>
                	<bean:message bundle="cityrecord" key="wayname"/>
                </td>
                <td>
                    <bean:message bundle="cityrecord" key="opnid"/>
                    <s:OrderImg form="/cms/cityrecord/CityrecordForm" field="opnid"/>
                </td>
                <td>
                	<bean:message bundle="cityrecord" key="opnname"/>
                </td>
                <td>
                    <bean:message bundle="cityrecord" key="rewardtype"/>
                    <s:OrderImg form="/cms/cityrecord/CityrecordForm" field="rewardtype"/>
                </td>
                <td>
                    <bean:message bundle="cityrecord" key="mobile"/>
                    <s:OrderImg form="/cms/cityrecord/CityrecordForm" field="mobile"/>
                </td>
                <td>
                    <bean:message bundle="cityrecord" key="rewardmonth"/>
                    <s:OrderImg form="/cms/cityrecord/CityrecordForm" field="rewardmonth"/>
                </td>
                <td>
                    <bean:message bundle="cityrecord" key="oprtime"/>
                    <s:OrderImg form="/cms/cityrecord/CityrecordForm" field="oprtime"/>
                </td>
                <td>
                    <bean:message bundle="cityrecord" key="busivalue"/>
                    <s:OrderImg form="/cms/cityrecord/CityrecordForm" field="busivalue"/>
                </td>
                <td>
                    <bean:message bundle="cityrecord" key="paymoney"/>
                    <s:OrderImg form="/cms/cityrecord/CityrecordForm" field="paymoney"/>
                </td>
                <td>
                    <bean:message bundle="cityrecord" key="paysum"/>
                    <s:OrderImg form="/cms/cityrecord/CityrecordForm" field="paysum"/>
                </td>
                <!-- 
                <td>
                    <a href="javascript:doOrderby('paymoney')"><bean:message bundle="cityrecord" key="paymoney"/></a>
                    <s:OrderImg form="/cms/cityrecord/CityrecordForm" field="paymoney"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('approveid')"><bean:message bundle="cityrecord" key="approveid"/></a>
                    <s:OrderImg form="/cms/cityrecord/CityrecordForm" field="approveid"/>
                </td>
                 -->
            </tr>
            <c:forEach var="item" items="${requestScope.LIST.datas}">
                 <tr class="table_style_content" align="center">
                     <td><s:Code2Name code="${item.isflag}" definition="#ISFLAG"/></td>
                     <td><s:Code2Name code="${item.systemflag}" definition="#SYSTEMFLAG"/></td>
                     <td><c:out value="${item.wayid}"/></td>
                     <td><s:Code2Name code="${item.wayid}" definition="#WAY"/></td>
                     <td><c:out value="${item.opnid}"/></td>
                     <td><s:Code2Name code="${item.opnid}" definition="#OPERATION"/></td>
                     <td><c:out value="${item.rewardtypename}"/></td>
                     <td><c:out value="${item.mobile}"/></td>
                     <td><c:out value="${item.rewardmonth}"/></td>
                     <td>
                      <fmt:formatDate type="date"  pattern="yyyy-MM-dd HH:mm:ss" value="${item.oprtime}" />
                     </td>
                     <td><c:out value="${item.busivalue}"/></td>
                     <td><c:out value="${item.paymoney}"/></td>
                     <td><c:out value="${item.paysum}"/></td>
                     <!-- 
                     <td><c:out value="${item.paymoney}"/></td>
                     <td><c:out value="${item.approveid}"/></td>
                      -->
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
