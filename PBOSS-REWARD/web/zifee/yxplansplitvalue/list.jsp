<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc" %>
<jsp:include page="/inc/acl.jsp">
  <jsp:param name="PID" value="3C3C3C" />
</jsp:include>
<%
    String ID_1 = "3C3C3CBT1";
    String ID_2 = "3C3C3CBT2";
    String ID_3 = "3C3C3CBT3";
    String ID_4 = "3C3C3CBT4";
%>
<html>
<head>
    <title><bean:message bundle="yxplansplitvalue" key="titleList"/></title>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            addfield('_ne_billcycle', '<bean:message bundle="yxplansplitvalue" key="billcycle"/>', 'l', true, 8);
            addfield('_se_brandid', '<bean:message bundle="yxplansplitvalue" key="brandid"/>', 'c', true, 32);
            addfield('_sk_itemid', '<bean:message bundle="yxplansplitvalue" key="itemid"/>', 'c', true, 32);
            return checkval(window);
        }
    </script>
</head>

<body>
<div class="table_container">
<html:form action="/zifee/yxplansplitvalue.do?CMD=LIST" styleId="formList" method="post" onsubmit="return ev_check();">
    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <input type="hidden" name="_rowcount" value="<c:out value='${requestScope.LIST.rowCount}' />">
	<div class="table_div">
				<table class="top_table">
					<tr>
						<td>
							<bean:message bundle="yxplansplitvalue" key="titleList"/>
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
                <td width="126" height="20" align="right" class="form_table_right"><bean:message bundle="yxplansplitvalue" key="billcycle"/>:</td>
                <td class="form_table_left">
               		<html:text styleClass="form_input_1x" property="_ne_billcycle"></html:text>
                </td>
                <td width="126" height="20" align="right" class="form_table_right"><bean:message bundle="yxplansplitvalue" key="brandid"/>:</td>
                <td class="form_table_left">
                	<html:select property="_se_brandid">
            			<option value=""  ></option>		                		
            			<s:Options  definition="$ProductBrand"/>
		        	</html:select>                	
                </td>
            </tr>
            <tr>
                <td width="126" height="20" align="right" class="form_table_right"><bean:message bundle="yxplansplitvalue" key="itemid"/>:</td>
                <td class="form_table_left">
                	<html:select property="_se_itemid">
            			<option value=""  ></option>		                		
            			<s:Options  definition="$PC_YXCHAIFENITEM"/>
		        	</html:select>               		
                </td>
            </tr>
        </table>
    </div>

	<div class="table_div">
				<table class="table_button_list">
					<tr>
						<td>
						<s:PurChk controlid="<%=ID_1%>">
                       		<input type="button" class="query" onmouseover="buttonover(this);"
                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                            value="<bean:message bundle="public" key="button_search"/>" onClick="doQuery();">
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
                    <a href="javascript:doOrderby('billcycle')"><bean:message bundle="yxplansplitvalue" key="billcycle"/></a>
                    <s:OrderImg form="/zifee/yxplansplitvalue/YxPlanSplitValueForm" field="billcycle"/>
                </td>
                <td>
                	<a href="javascript:doOrderby('brandid')"><bean:message bundle="yxplansplitvalue" key="brandid"/></a>
                    <s:OrderImg form="/zifee/yxplansplitvalue/YxPlanSplitValueForm" field="brandid"/>
                </td>
                <td>
                	<a href="javascript:doOrderby('itemid')"><bean:message bundle="yxplansplitvalue" key="itemid"/></a>
                    <s:OrderImg form="/zifee/yxplansplitvalue/YxPlanSplitValueForm" field="itemid"/>
                </td>
                <td>
                	<a href="javascript:doOrderby('splitfee')"><bean:message bundle="yxplansplitvalue" key="splitfee"/></a>
                    <s:OrderImg form="/zifee/yxplansplitvalue/YxPlanSplitValueForm" field="splitfee"/>
                </td>
            </tr>
            <c:forEach var="item" items="${requestScope.LIST.datas}">
                 
                 <tr class="table_style_content" align="center">
                     
                     <td>
                         <c:out value="${item.billcycle}"/>
                     </td>
                     <td>
                         <c:out value="${item.brandid}"/> - <s:Code2Name code="${item.brandid}" definition="$ProductBrand"/>
                     </td>
                     <td><c:out value="${item.itemid}"/> - <s:Code2Name code="${item.itemid}" definition="$PC_YXCHAIFENITEM"/></td>
                     <td><fmt:formatNumber pattern="0.00" value="${item.splitfee}"/></td>
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
