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
    <title><bean:message bundle="bbcrewardtotal" key="titleList"/></title>
    <script type="text/javascript" src="<%=contextPath%>/js/bus/waycommon.js"></script>
    <script type="text/javascript" src="<%= contextPath%>/js/bus/rescommon.js"></script>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
        	addfield('_ne_totalid','<bean:message bundle="bbcrewardtotal" key="totalid"/>','i','true','14');   
			addfield('_se_rewardmonth','<bean:message bundle="bbcrewardtotal" key="rewardmonth"/>','c',false,'6');
			addfield('_se_batchno','<bean:message bundle="bbcrewardtotal" key="batchno"/>','i',true,'18');
            return checkval(window);
        }

		function exports(){
             var hasRight=0;
        	 <s:RewardPurChk controlid="<%=ID_1%>">hasRight=1;</s:RewardPurChk>
        	 if(　ev_check() == false ) {
        	 	return ;
        	 }
			var form=document.forms[0];
			form.action="<%=contextPath%>/cms/bbc/bbcrewardtotal.do?CMD=EXCEL";
			form.submit();
			form.action="<%=contextPath%>/cms/bbc/bbcrewardtotal.do?CMD=LIST";
		}
    </script>
</head>

<body onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<html:form action="/cms/bbc/bbcrewardtotal.do?CMD=LIST" styleId="formList" method="post" onsubmit="return ev_check();">
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
    			<bean:message bundle="bbcrewardtotal" key="titleList"/>
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
						<td width="80" height="20" align="right" class="form_table_right">
							<bean:message bundle="bbcrewardtotal" key="wayid"/>:
						</td>
						<td class="form_table_left">
							<html:text styleClass="form_input_1x" property="_se_wayid" />
						</td>
						<td width="80" height="20" align="right" class="form_table_right">
							<bean:message bundle="bbcrewardtotal" key="totalid"/>:
						</td>
						<td class="form_table_left">
							<html:text styleClass="form_input_1x" property="_ne_totalid"></html:text> 
						</td>
				</tr>
				<tr>
						<td width="80" height="20" align="right" class="form_table_right">
							<bean:message bundle="bbcrewardtotal" key="rewardmonth"/>:
						</td>
						<td class="form_table_left">
							<html:text styleClass="form_input_1x" property="_se_rewardmonth" onclick="this.value=selectDateYYYYMM(this.value);" readonly="true"></html:text>
						</td>
						<td width="80" height="20" align="right" class="form_table_right">
							<bean:message bundle="bbcrewardtotal" key="rewardtype"/>:
						</td>
						<td class="form_table_left">
							<html:select  property="_ne_rewardtype">
		                    	<option/>
		                    	<s:Options definition="$CH_BBCREWARDTYPE" />
                    		</html:select> 
						</td>
				</tr>
				<tr>
						<td width="80" height="20" align="right" class="form_table_right">
							<bean:message bundle="bbcrewardtotal" key="ossrc"/>:
						</td>
						<td class="form_table_left">
							<html:select  property="_se_ossrc">
		                    	<option/>
		                    	<s:Options definition="#CH_BBC_OSSRC" />
                    		</html:select> 
						</td>
						<td width="80" height="20" align="right" class="form_table_right">
							<bean:message bundle="bbcrewardtotal" key="batchno"/>:
						</td>
						<td class="form_table_left">
							<html:text styleClass="form_input_1x" property="_se_batchno"></html:text> 
						</td>
				</tr>
        </table>
    </div>
	<div class="table_div">
		<table class="table_button_list">
			<tr> 
                <td align=right>
                        <input type="button" class="button_2" onmouseover="buttonover(this);"
		                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
		                        value="<bean:message bundle="bbcrewardtotal" key="export"/>" onclick="exports();"/>
                        <input type="submit" class="query"onmouseover="buttonover(this);"
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
                    <a href="javascript:doOrderby('totalid')"><bean:message bundle="bbcrewardtotal" key="totalid"/></a>
                    <s:OrderImg form="/cms/bbc/bbcrewardtotalForm" field="totalid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('wayid')"><bean:message bundle="bbcrewardtotal" key="wayid"/></a>
                    <s:OrderImg form="/cms/bbc/bbcrewardtotalForm" field="wayid"/>
                </td>
                <td>
                    渠道名称
                </td>
                <td>
                    <a href="javascript:doOrderby('countycompname')"><bean:message bundle="bbcrewardtotal" key="countycompname"/></a>
                    <s:OrderImg form="/cms/bbq/bbcrewardtotalForm" field="countycompname"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('starlevel')"><bean:message bundle="bbcrewardtotal" key="starlevel"/></a>
                    <s:OrderImg form="/cms/bbq/bbcrewardtotalForm" field="starlevel"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('rewardtype')"><bean:message bundle="bbcrewardtotal" key="rewardtype"/></a>
                    <s:OrderImg form="/cms/bbc/bbcrewardtotalForm" field="rewardtype"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('rewardmonth')"><bean:message bundle="bbcrewardtotal" key="rewardmonth"/></a>
                    <s:OrderImg form="/cms/bbc/bbcrewardtotalForm" field="rewardmonth"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('paymoney')"><bean:message bundle="bbcrewardtotal" key="paymoney"/></a>
                    <s:OrderImg form="/cms/bbc/bbcrewardtotalForm" field="paymoney"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('ossrc')"><bean:message bundle="bbcrewardtotal" key="ossrc"/></a>
                    <s:OrderImg form="/cms/bbc/bbcrewardtotalForm" field="ossrc"/>
                </td>
                 <td>
                    <a href="javascript:doOrderby('batchno')"><bean:message bundle="bbcrewardtotal" key="batchno"/></a>
                    <s:OrderImg form="/cms/bbc/bbcrewardtotalForm" field="batchno"/>
                </td>
            </tr>
            <c:forEach var="item" items="${requestScope.LIST.datas}">
                 <c:url value="/cms/bbc/bbcrewardtotal.do?CMD=EDIT" var="urlContent">
                     <%//this param name must "PK" %>
                     <c:param name="PK" value="${item.totalid}"/>
                     <%-- <c:param name="PK" value="'${item.id}|${item.id2}'"/> --%>
                 </c:url>
                 <tr class="table_style_content" align="center">
                     
                     <td>
                         <c:out value="${item.totalid}"/>
                     </td>
                     <td><c:out value="${item.wayid}"/></td>
                     <td><c:out value="${item.wayname}"/></td>
                     <td><c:out value="${item.countycompname}"/></td>
                     <td><s:Code2Name code="${item.starlevel}" definition="#CH_STARLEVEL" /></td>
                     <td><s:Code2Name code="${item.rewardtype}" definition="$CH_BBCREWARDTYPE"/></td>
                     <td><c:out value="${item.rewardmonth}"/></td>
                     <td><c:out value="${item.paymoney}"/></td>
                     <td><s:Code2Name code="${item.ossrc}" definition="#CH_BBC_OSSRC" /></td>
                     <td><c:out value="${item.batchno}"/></td>
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
