<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc"%>
<%
    String ID_1 = "00010701";
    String ID_3 = "00010703";
%>
<html>
<head>
    <title><bean:message bundle="rewardreport" key="titleList"/></title>
    <script type="text/javascript" src="<%=contextPath%>/js/bus/waycommon.js"></script>
    <script type="text/javascript" src="<%=contextPath%>/js/aa.js"></script>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            addfield('_se_wayid', '<bean:message bundle="rewardreport" key="wayid"/>', 'c', 'false', '20');
            addfield('_se_calcmonth', '<bean:message bundle="rewardreport" key="calcmonth"/>', 'c', 'false', '8');
            addfield('_de_sendtime', '<bean:message bundle="rewardreport" key="sendtime"/>', 'dt', 'false', '7');
            return checkval(window);
        }
		function doQuery(){
			resetPage();
			var form=document.forms[0];
			form.action="<%=contextPath%>/cms/rewardreport.do?CMD=LIST";
			form.submit();
		}
    </script>
</head>

<body onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<html:form action="/cms/rewardreport.do?CMD=LIST" styleId="formList" method="post" onsubmit="return ev_check();">
    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize" value="20"/>
    <input type="hidden" name="_rowcount" value="<c:out value='${requestScope.LIST.rowCount}' />">
    <c:set var="form" scope="request" value="${requestScope['/cms/rewardreport/RewardreportForm']}"/>
    <c:set var="btn" scope="request" value="${!empty requestScope.btn and (requestScope.btn eq 'disable')}"/>
    <c:set var="type" scope="request" value="${!empty requestScope.type and (requestScope.type eq '0')}"/>

    <!--##################################添加标题内容##################################################-->
    <div class="table_div">
    <table class="top_table">
    	<tr>
    		<td>
    			<bean:message bundle="rewardreport" key="titleList"/>
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
    			<td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="rewardreport" key="_se_countyid"/>:</td>
            	<td width="30%" class="form_table_left">
               	 	<html:select property="_se_countyid">
                    	<option />
                    	<s:Options definition="#CNTYCOMPANY" condition="citycompid:${requestScope.cityid}"/>
                    </html:select>
            	</td>
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="rewardreport" key="wayid"/>:</td>
                <td width="30%" class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_se_wayid"></html:text>
                    <input type="button" value="..." class="clickbutton" onclick="showSelectWay3(this,'_se_wayid','','','AG');this.value='...';" />
                </td>
            </tr>
            <tr>
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="rewardreport" key="calcmonth"/>:</td>
                <td width="30%" class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_se_calcmonth" onclick="this.value=selectDateYYYYMM(this.value);"></html:text>
                </td>
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="rewardreport" key="audittype"/>:</td>
                <td width="30%" class="form_table_left">
                    <html:select property="audittype" >
                    	<s:Options definition="$CH_AUDITTYPE" />
			        </html:select>
                </td>
            </tr>
        </table>
    </div>
	<div class="table_div">
		<table class="table_button_list">
			<tr> 
                <td align=right>
                        <s:PurChk controlid="<%=ID_3%>">
                        <input type="button" class="query" onmouseover="buttonover(this);" onclick="doQuery();"
                                onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                                value="<bean:message bundle="public" key="button_search"/>" />
                        </s:PurChk>
                </td>
			</tr>
		</table>
	</div>
	  
    <div class="table_div">
      <div class="table_LongTable">
        <table class="table_style" ID="Table2">
            <tr class="table_style_head">
                <td>
                    <a href="javascript:doOrderby('wayid')"><bean:message bundle="rewardreport" key="wayid"/></a>
                    <s:OrderImg form="/cms/rewardreport/RewardreportForm" field="wayid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('name')"><bean:message bundle="rewardreport" key="name"/></a>
                    <s:OrderImg form="/cms/rewardreport/RewardreportForm" field="name"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('piece')"><bean:message bundle="rewardreport" key="piece"/></a>
                    <s:OrderImg form="/cms/rewardreport/RewardreportForm" field="piece"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('star')"><bean:message bundle="rewardreport" key="star"/></a>
                    <s:OrderImg form="/cms/rewardreport/RewardreportForm" field="star"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('terminal')"><bean:message bundle="rewardreport" key="terminal"/></a>
                    <s:OrderImg form="/cms/rewardreport/RewardreportForm" field="terminal"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('cooperate')"><bean:message bundle="rewardreport" key="cooperate"/></a>
                    <s:OrderImg form="/cms/rewardreport/RewardreportForm" field="cooperate"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('calcmonth')">
                    <c:if test="${type}">
                    	<bean:message bundle="rewardreport" key="calcmonth"/>
                    </c:if>
                    <c:if test="${!type}">
                    	<bean:message bundle="rewardreport" key="calcmonth2"/>
                    </c:if>
                    </a>
                    <s:OrderImg form="/cms/rewardreport/RewardreportForm" field="calcmonth"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('adjmoney')"><bean:message bundle="rewardreport" key="adjmoney"/></a>
                    <s:OrderImg form="/cms/rewardreport/RewardreportForm" field="adjmoney"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('sum')"><bean:message bundle="rewardreport" key="sum"/></a>
                    <s:OrderImg form="/cms/rewardreport/RewardreportForm" field="sum"/>
                </td>
                <td>支付金额</td>
                <td>
                	<c:if test="${type}">
                    	计酬月份未发放金额
                    </c:if>
                    <c:if test="${!type}">
                    	自然月份未发放金额
                    </c:if>
                </td>
            </tr>
            <c:forEach var="item" items="${requestScope.LIST.datas}">
                 <c:url value="/cms/rewardreport.do?CMD=EDIT" var="urlContent">
                     <%//this param name must "PK" %>
                     <c:param name="PK" value="${item.seq}"/>
                     <%-- <c:param name="PK" value="'${item.id}|${item.id2}'"/> --%>
                 </c:url>
                 <tr class="table_style_content" align="center">
                     <!-- <td>
                         <input type="checkbox" name="_selectitem" value="<c:out value='${item.seq}' />"
                                onclick="checkOne();" class="table_checkbox">
                     </td> -->
                     <td><c:out value="${item.wayid}"/></td>
                     <td><c:out value="${item.name}"/></td>
                     <td><fmt:formatNumber pattern="0.00" value="${item.piece}" /></td>
                     <td><fmt:formatNumber pattern="0.00" value="${item.star}" /></td>
                     <td><fmt:formatNumber pattern="0.00" value="${item.terminal}" /></td>
                     <td><fmt:formatNumber pattern="0.00" value="${item.cooperate}" /></td>
                     <!-- <td><fmt:formatNumber pattern="0.00" value="${item.paymoney}" /></td> -->
                     <td><c:out value="${item.calcmonth}"/></td>
                     <td><fmt:formatNumber pattern="0.00" value="${item.adjmoney}" /></td>
                     <td><fmt:formatNumber pattern="0.00" value="${item.sum}" /></td>
                     <td><fmt:formatNumber pattern="0.00" value="${item.remark}" /></td>
                     <td><fmt:formatNumber pattern="0.00" value="${item.sum-item.remark}" /></td>
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
