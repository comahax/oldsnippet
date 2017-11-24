<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ page import="com.sunrise.boss.ui.commons.User"%>
<%@ page import="com.sunrise.boss.ui.commons.WebConstant"%>
<%@ include file="/inc/listhead.inc" %>
<jsp:include page="/inc/acl.jsp">
  <jsp:param name="PID" value="3C3C1A" />
</jsp:include>
<%
   
    String ID_1 = "3C3C1ABT1";
    String AREACODE_A = "AREACODE_A";
	String AREACODE_B = "AREACODE_B";
	String AREACODE_C = "AREACODE_C";
%>
<html:html>
<head>
    <title><bean:message bundle="yxplan" key="titleList"/></title>
    <base target="_self">
    <script language="JavaScript" type="text/JavaScript">
       function doOK(value) {
	   		window.returnValue = value;
	   		window.close();
	   }
    </script>
</head>

<body onload="document.formList._ne_yxplanid.focus()">
<div class="table_container">
<html:form action="/zifee/yxplan.do?CMD=SELECTYXPLANID" styleId="formList" method="post">
    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <input type="hidden" name="_rowcount" value="<c:out value='${requestScope.LIST.rowCount}' />">
    
    
    <div class="table_div">
		<table class="top_table">
			<tr>
				<td>
					<bean:message bundle="yxplan" key="titleList"/>
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
       			<td width="126" height="20" align="right" class="form_table_right">
       					<bean:message bundle="yxplan" key="yxplanid"/>:</td>
                <td class="form_table_left">
                	<html:text styleClass="form_input_1x" property="_ne_yxplanid"></html:text>
                </td>
                <td width="126" height="20" align="right" class="form_table_right">
                	<bean:message bundle="yxplan" key="yxplanname"/>:</td>
                <td class="form_table_left">
                	<html:text styleClass="form_input_1x" property="_sk_yxplanname"></html:text>
                </td>
            </tr>
        </table>
    </div>
    <div class="table_div">
		<table class="table_button_list">
			<tr>
				<td>
				<s:PurChk controlid="<%=ID_1%>">
                   <input type="submit" class="query"onmouseover="buttonover(this);"
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
                <td nowrap>
                    <a href="javascript:doOrderby('yxplanid')"><bean:message bundle="yxplan" key="yxplanid"/></a>
                    <s:OrderImg form="/zifee/yxplan/YxPlanActionForm" field="yxplanid"/>
                </td>
                <td nowrap>
                    <a href="javascript:doOrderby('yxplanname')"><bean:message bundle="yxplan" key="yxplanname"/></a>
                    <s:OrderImg form="/zifee/yxplan/YxPlanActionForm" field="yxplanname"/>
                </td>
             </tr>
            <c:forEach var="item" items="${requestScope.LIST.datas}">
                 <tr style="cursor:hand" class="table_style_content" align="center" onclick="doOK('<c:out value="${item.yxplanid}"/>');">
                     <td >
                        <c:out value="${item.yxplanid}"/>
                     </td>
                     <td >
                     	<c:out value="${item.yxplanname}"/>
                     </td>
                 </tr>
             </c:forEach>
        </table>
    </div>
   <div class="table_div">
		<s:PageNav dpName="LIST"/>
  </div>
</html:form>
</div>
</body>
</html:html>
