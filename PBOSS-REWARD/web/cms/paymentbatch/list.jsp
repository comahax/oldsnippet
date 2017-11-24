<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc"%>
<%
    String ID_1 = "CH_ADT_MONITOR_VIEW";
    String ID_2 = "CH_ADT_PAYMENT_NEW||CH_ADT_ADJUST_COUNTY";
    String ID_3 = "00010703";
    String ID_4 = "00010704";
%>
<html>
<head>
    <title><bean:message bundle="paymentbatch" key="titleList"/></title>
    <script type="text/javascript" src="<%=contextPath%>/js/jquery/jquery-1.3.2.js"></script>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            addfield('_se_batchno', '<bean:message bundle="paymentbatch" key="batchno"/>', 'c', 'false', '18');
            addfield('_ne_cityid', '<bean:message bundle="paymentbatch" key="cityid"/>', 'f', 'false', '3');
            addfield('_dnm_paymentoprtime', '<bean:message bundle="paymentbatch" key="paymentoprtime"/>', 't', 'false', '7');
            addfield('_dnl_paymentoprtime', '<bean:message bundle="paymentbatch" key="paymentoprtime"/>', 't', 'false', '7');
            return (checkval(window) && compareDate());
        }        
        function compareDate(){
	        var startTime2 = document.getElementById('_dnl_paymentoprtime').value;
	        var endTime2 = document.getElementById('_dnm_paymentoprtime').value;      
	        if(startTime2 != '' && endTime2 != '' && startTime2>endTime2){
		        var alertstr = '<span class=\'errorkey\'><span style=\'color:#F00; font-size:12px;\'>[付款申请操作时间>=]</span> 不能大于 <span style=\'color:#F00; font-size:12px;\'>[付款申请操作时间<=]</span>';
				errorMessageShow(alertstr);
		        return false;
	       	}        
	   		return true;	
    	}
    	function doExcel(){ 
    		if(ev_check()){
				formList.action = "<%=contextPath%>/cms/paymentbatch.do?CMD=EXCEL";
	        	formList.submit();
	        	formList.action = "<%=contextPath%>/cms/paymentbatch.do?CMD=LIST";    		
    		}
		}
		
		function doPayment(batchno){
			//alert("付款批次号：" + batchno);
			var url = contextPath + '/cms/paymentbatch.do?CMD=PAYMENT';
			if(batchno!=null && batchno!=''){
				jQuery.post(url,
					{"batchno": batchno},
					function(data){
						if (data == "SUCCESS") {
							alert("【确认】操作成功");
							doQuery();
						} else {
							alert(data);
						}
					},
					"text"
				);
			}
		}
    </script>
</head>

<body onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<html:form action="/cms/paymentbatch.do?CMD=LIST" styleId="formList" method="post" onsubmit="return ev_check();">
    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <html:hidden property="provpermited"/>
    <html:hidden property="supportPaymonth"/>
    <input type="hidden" name="_rowcount" value="<c:out value='${requestScope.LIST.rowCount}' />">
    <c:set var="form" scope="request" value="${requestScope['/cms/paymentbatch/PaymentbatchForm']}"/>

    <!--##################################添加标题内容##################################################-->
    <div class="table_div">
    <table class="top_table">
    	<tr>
    		<td>
    			<bean:message bundle="paymentbatch" key="titleList"/>
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
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="paymentbatch" key="cityid"/>:</td>
                <td width="30%" class="form_table_left">
                	<html:select property="_ne_cityid" styleId="_ne_cityid" >                	
                	<c:choose>
                	   <c:when test="${form.provpermited==1}">                	   
						<option />
						<s:Options definition="#CITYCOMPANY_AREA"/>
                	   </c:when>
                	   <c:otherwise>
                	   <s:Options definition="#CITYCOMPANY_AREA" condition="areacode:${sessionScope._USER.cityid}"/>
                	   </c:otherwise>
                	</c:choose>		
                	</html:select>	
                </td>
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="paymentbatch" key="batchno"/>:</td>
                <td width="30%" class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_se_batchno"></html:text>
                </td>
            </tr>
            <tr>
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="paymentbatch" key="paymentoprtime"/>&gt;=:</td>
                <td width="30%" class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_dnl_paymentoprtime" onclick="this.value=selectDate();"></html:text>
                </td>
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="paymentbatch" key="paymentoprtime"/>&lt;=:</td>
                <td width="30%" class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_dnm_paymentoprtime" onclick="this.value=selectDate();"></html:text>
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
                        <input type="button" class="button_2" onmouseover="buttonover(this);"
                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                            value="<bean:message bundle="public" key="button_export"/>" onClick="doExcel()">    
                </td>
			</tr>
		</table>
	</div>

    <div class="table_div">
      <div class="table_LongTable">
        <table class="table_style" ID="Table2">
            <tr class="table_style_head">
                <td>
                    <a href="javascript:doOrderby('batchno')"><bean:message bundle="paymentbatch" key="batchno"/></a>
                    <s:OrderImg form="/cms/paymentbatch/PaymentbatchForm" field="batchno"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('cityid')"><bean:message bundle="paymentbatch" key="cityid"/></a>
                    <s:OrderImg form="/cms/paymentbatch/PaymentbatchForm" field="cityid"/>
                </td>
                <td>
                    <bean:message bundle="paymentbatch" key="paymentflag"/>
                </td>
                <td>
                    <bean:message bundle="paymentbatch" key="paymentoprcode"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('paymentoprtime')"><bean:message bundle="paymentbatch" key="paymentoprtime"/></a>
                    <s:OrderImg form="/cms/paymentbatch/PaymentbatchForm" field="paymentoprtime"/>
                </td>
                <td>
                    <bean:message bundle="paymentbatch" key="listflag"/>
                </td>
                <td>
                    <bean:message bundle="paymentbatch" key="endflag"/>
                </td>
                <c:if test="${form.supportPaymonth}">
                <td>
                    <bean:message bundle="paymentbatch" key="paymonth"/>
                </td>
                </c:if>
                <td><bean:message bundle="paymentbatch" key="endoprcode"/></td>
                <td><bean:message bundle="paymentbatch" key="endtime"/></td>
            </tr>
            <c:forEach var="item" items="${requestScope.LIST.datas}">
                 <tr class="table_style_content" align="center" onMouseMove="this.bgColor='#99FFCC'" onMouseOut="this.bgColor='#ffffff'">
                     <td><c:out value="${item.batchno}"/></td>
                     <td><s:Code2Name code="${item.cityid}" definition="#CITYCOMPANY_AREA"/></td>
                     <td><s:Code2Name code="${item.paymentflag}" definition="#ADT_PAYMENTFLAG"/></td>
                     <td><c:out value="${item.paymentoprcode}"/></td>
                     <td><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${item.paymentoprtime}" /></td>
                     <td><s:Code2Name code="${item.listflag}" definition="#ADT_LISTFLAG"/></td>
                     <td>
                     	<c:choose>
                          <c:when test="${item.endflag==0}">
                          	<s:RewardPurChk controlid="<%=ID_2%>" disableChild="true">
                          	<input type="button" value="确认" onclick="doPayment('<c:out value="${item.batchno}"/>');" class="button_4" title="确认前请核对报表数据">
                            </s:RewardPurChk>
                          </c:when>
                          <c:when test="${item.endflag==1}">已确认</c:when>
                          <c:when test="${item.endflag==2}">明细数据更新中</c:when>
                          <c:otherwise>
                          	<s:Code2Name code="${item.endflag}" definition="#ADT_ENDFLAG"/>
                          </c:otherwise>
                     	</c:choose>
                     </td>
                     <c:if test="${form.supportPaymonth}"><td><c:out value="${item.paymonth}"/></td></c:if>
                     <td><c:out value="${item.endoprcode}"/></td>
                     <td><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${item.endtime}" /></td>
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
