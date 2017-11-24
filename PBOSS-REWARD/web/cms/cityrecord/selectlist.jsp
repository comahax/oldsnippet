<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc"%>
<%
    String ID_1 = "CH_ADT_CITYRECORD_UPLOAD";
    String ID_2 = "00010702";
    String ID_3 = "00010703";
    String ID_4 = "00010704";
%>
<html>
<head>
    <title><bean:message bundle="cityrecord" key="titleList"/></title>
    <script type="text/javascript" src="<%=contextPath%>/js/bus/waycommon.js"></script>
	<script type="text/javascript" src="<%=contextPath%>/js/bus/rescommon.js"></script>
    <script language="JavaScript" type="text/JavaScript">
    	function ev_check(){
    		return checkval(window);
    	}
        function doReturn(){
            //拿回原页面
            document.getElementById("_pageno").value=document.getElementById("prePageno").value;
            document.getElementById("_se_wayid").value=document.getElementById("preWayid").value;
            document.getElementById("_se_opnid").value=document.getElementById("preOpnid").value;
            document.getElementById("_ne_rewardtype").value=document.getElementById("preRewardtype").value;
            document.getElementById("_se_rewardmonth").value=document.getElementById("preRewardmonth").value;
            //document.getElementById("_pageno").value=1;
            //alert(document.getElementById("_pageno").value);
			formList.action ="<%=contextPath%>/cms/cityrecord.do?CMD=LIST&flg=true";
			formList.submit();
		}
    </script>
</head>

<body onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<html:form action="/cms/cityrecord.do?CMD=SELECTLIST" styleId="formList" method="post" onsubmit="return ev_check();">
    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    
    <html:hidden property="_se_chainhead"/>
    <html:hidden property="sqlopnid"/>
    <html:hidden property="_se_wayid"/>
    <html:hidden property="_se_opnid"/>
    <html:hidden property="_ne_isflag"/>
    <html:hidden property="_ne_systemflag"/>
    <html:hidden property="_se_rewardmonth"/>
    <html:hidden property="_ne_rewardtype"/>
    <html:hidden property="_se_approveid"/>
    <html:hidden property="_ne_taskid"/>    
    <html:hidden property="_se_countyid"/> 
    
    <html:hidden property="prePageno"/>
    <html:hidden property="preWayid"/>
    <html:hidden property="preOpnid"/>
    <html:hidden property="preRewardtype"/>
    <html:hidden property="preRewardmonth"/>   
    <input type="hidden" name="_rowcount" value="<c:out value='${requestScope.LIST.rowCount}' />">
    <c:set var="form" scope="request" value="${requestScope['/cms/cityrecord/CityrecordForm']}"/>

    <!--##################################添加标题内容##################################################-->
    <div class="table_div">
    <table class="top_table">
    	<tr>
    		<td>
    			<bean:message bundle="cityrecord" key="titleList"/>
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
		<table class="table_button_list">
			<tr> 
				<td align=right>
                      <input type="button" id="btnReturn" name="btnReturn" class="button_4" onmouseover="buttonover(this);"
                      onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                      value="返回" onClick="doReturn()">
                </td>
			</tr>
		</table>
	</div>

    <div class="table_div">
      <div class="table_LongTable">
        <table class="table_style" ID="Table2">
            <tr class="table_style_head">
                <td>
                    <a href="javascript:doOrderby('isflag')"><bean:message bundle="cityrecord" key="isflag"/></a>
                    <s:OrderImg form="/cms/cityrecord/CityrecordForm" field="isflag"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('systemflag')"><bean:message bundle="cityrecord" key="systemflag"/></a>
                    <s:OrderImg form="/cms/cityrecord/CityrecordForm" field="systemflag"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('wayid')"><bean:message bundle="cityrecord" key="wayid"/></a>
                    <s:OrderImg form="/cms/cityrecord/CityrecordForm" field="wayid"/>
                </td>
                <td>
                	<bean:message bundle="cityrecord" key="wayname"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('opnid')"><bean:message bundle="cityrecord" key="opnid"/></a>
                    <s:OrderImg form="/cms/cityrecord/CityrecordForm" field="opnid"/>
                </td>
                <td>
                	<bean:message bundle="cityrecord" key="opnname"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('rewardtype')"><bean:message bundle="cityrecord" key="rewardtype"/></a>
                    <s:OrderImg form="/cms/cityrecord/CityrecordForm" field="rewardtype"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('mobile')"><bean:message bundle="cityrecord" key="mobile"/></a>
                    <s:OrderImg form="/cms/cityrecord/CityrecordForm" field="mobile"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('rewardmonth')"><bean:message bundle="cityrecord" key="rewardmonth"/></a>
                    <s:OrderImg form="/cms/cityrecord/CityrecordForm" field="rewardmonth"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('oprtime')"><bean:message bundle="cityrecord" key="oprtime"/></a>
                    <s:OrderImg form="/cms/cityrecord/CityrecordForm" field="oprtime"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('busivalue')"><bean:message bundle="cityrecord" key="busivalue"/></a>
                    <s:OrderImg form="/cms/cityrecord/CityrecordForm" field="busivalue"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('paysum')"><bean:message bundle="cityrecord" key="paysum"/></a>
                    <s:OrderImg form="/cms/cityrecord/CityrecordForm" field="paysum"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('paymoney')"><bean:message bundle="cityrecord" key="paymoney"/></a>
                    <s:OrderImg form="/cms/cityrecord/CityrecordForm" field="paymoney"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('approveid')"><bean:message bundle="cityrecord" key="approveid"/></a>
                    <s:OrderImg form="/cms/cityrecord/CityrecordForm" field="approveid"/>
                </td>
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
                      <fmt:formatDate type="date" 
                     			pattern="yyyy-MM-dd HH:mm:ss" value="${item.oprtime}" />
                     </td>
                     <td><c:out value="${item.busivalue}"/></td>
                     <td><c:out value="${item.paysum}"/></td>
                     <td><c:out value="${item.paymoney}"/></td>
                     <td><c:out value="${item.approveid}"/></td>
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
