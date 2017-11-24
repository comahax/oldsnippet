<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc"%>
<%
%>
<html>
<head>
    <title><bean:message bundle="nasrwdtotal" key="titleList"/></title>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            addfield('_se_wayid', '<bean:message bundle="nasrwdtotal" key="wayid"/>', 'c', true, '18');
            addfield('_ne_totalid', '<bean:message bundle="nasrwdtotal" key="totalid"/>', 'i', true, '14');
            addfield('_se_rewardmonth', '<bean:message bundle="nasrwdtotal" key="rewardmonth"/>', 'c', true, '6');
            addfield('_ne_rewardtype', '<bean:message bundle="nasrwdtotal" key="rewardtype"/>', 'i', true, '6');
            return checkval(window);
        }
        
    function doExcel(){
     	var url="<%=contextPath%>/cms/nasrwdtotal.do?CMD=EXCEL";
     	formList.action=url;
    	formList.submit();
		formList.action="<%=contextPath%>/cms/nasrwdtotal.do?CMD=LIST";
		
	}
    </script>
    <script type="text/javascript"
			src="<%=contextPath%>/js/bus/waycommon.js"></script>
</head>

<body onload="if(window.loadforiframe) loadforiframe();">
 <div class="table_container">
<html:form action="/cms/nasrwdtotal.do?CMD=LIST" styleId="formList" method="post" onsubmit="return ev_check();">
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
    			<bean:message bundle="nasrwdtotal" key="titleList"/>
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
            	<td width="126" height="20" align="right" class="form_table_right" >
                <bean:message bundle="nasrwdtotal" key="wayid"/> :</td>
                <td class="form_table_left">
                <s:zoom definition="#BBCWAY" readonly="false" property="_se_wayid" styleClass="form_input_1x" />
                </td>
                <td width="126" height="20" align="right" class="form_table_right" >
                <bean:message bundle="nasrwdtotal" key="totalid"/> :</td>
                <td class="form_table_left">
                <html:text property="_ne_totalid" styleClass="form_input_1x" />
                </td>
            </tr>
            <tr>
             <td width="126" height="20" align="right" class="form_table_right" > <bean:message bundle="nasrwdtotal" key="rewardmonth"/> :</td> 
            	<td class="form_table_left">
            	  <html:text property="_se_rewardmonth" styleClass="form_input_1x" />
                </td>
                <td width="126" height="20" align="right" class="form_table_right" ><bean:message bundle="nasrwdtotal" key="rewardtype"/> :</td>
                <td class="form_table_left">
                <html:select property="_ne_rewardtype">
                	<option/>
                	<html:option value="9" >销售类基本酬金</html:option>
                	<html:option value="10" >销售类奖励酬金</html:option>
					<html:option value="11" >新增网站活跃客户基本酬金</html:option>
					<html:option value="12" >新增网站活跃客户奖励酬金</html:option>
                </html:select>
                </td>
            </tr>
        </table>
    </div>
	<div class="table_div">
		<table class="table_button_list">
			<tr> 
                <td align=right>
               			<input type="button" class="button_2" onmouseover="buttonover(this);" onclick="doExcel();" 
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="导出"/>
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
                <td><bean:message bundle="nasrwdtotal" key="totalid"/></td>
                <td><bean:message bundle="nasrwdtotal" key="wayid"/></td>
                <td>渠道名称</td>
                <td><bean:message bundle="nasrwdtotal" key="rewardtype"/></td>
                <td><bean:message bundle="nasrwdtotal" key="rewardmonth"/></td>
                <td><bean:message bundle="nasrwdtotal" key="paymoney"/></td>
            </tr>
            <c:forEach var="item" items="${requestScope.LIST.datas}">
                 <tr class="table_style_content" align="center">
                     <td>
                        <c:out value="${item.totalid}"/>
                     </td>
                     <td>
                      <c:out value="${item.wayid}"/>
                     </td>
					 <td>
					 	<s:Code2Name definition="#BBCWAY" code="${item.wayid}" />
					 </td>  
					 <td>
					 	 <s:Code2Name definition="$CH_BBCREWARDTYPE" code="${item.rewardtype}" />
					 </td>
					 <td>
					 	 <c:out value="${item.rewardmonth}"/>
					 </td>
					 <td>
					 	 <c:out value="${item.paymoney}"/>
					 </td>               
                 </tr>
             </c:forEach>
        </table>
   </div>
   <div class="table_div">
		<s:PageNav dpName="LIST"/>
   </div>
</html:form>
</body>
</html>
