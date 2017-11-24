<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ page import="java.util.List" %>
<%@ page import="com.sunrise.boss.common.base.db.DataPackage" %>
<%@ include file="/inc/listhead.inc" %>
<jsp:include page="/inc/acl.jsp">
  <jsp:param name="PID" value="3C2B1A10" />
</jsp:include>
<%
	String ID_1 = "3C2B1A10BT1";
%>
<html>
<head>
<title>Group</title>
<link rel="stylesheet" href="css/dtree.css"  type="text/css">
<script type="text/javascript" src="js/dtree.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=GBK" />
</head>

<body >
	<div class="table_div">
				<table class="table_button_list">
					<tr>
						<td align="right">
						<s:PurChk controlid="<%=ID_1%>">
						 <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
                           name="btnSave" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<bean:message bundle="public" key="button_refresh"/>" style="float:left;" class="submit"
                           onclick="window.location.reload();">
						 </s:PurChk>
					</td>
				</tr>
			</table>
	</div>
	
<table cellpadding=0 cellspacing=0 border=0 width=100% height=100%>
  <tr>
    <td align='left' valign='top' width="20%" height="100%">
      <div class="dtree">  
        <script type="text/javascript">
        	contextPath = "<%=contextPath%>/";
          d = new dTree('d');
          <%	
          	int size =((DataPackage)request.getAttribute("LIST")).getDatas().size();
          	if(size == 0 ) {          	
          %>
          	document.write( '<bean:message bundle="yxplangroup" key="nodata"/>');
          <% } //if end%>
          d.add('00000', '-1', '<bean:message bundle="yxplangroup" key="manage"/>', contextPath+'zifee/yxplangpinf.do?CMD=LIST','00000','main');
          
          <c:forEach var="item" items="${requestScope.LIST.datas}" varStatus="status">
            <c:url value="/zifee/yxplangroup.do?CMD=LIST" var="urlView">
              <c:param name="PK" value="${item.groupid}"/>
            </c:url>
            d.add('<c:out value="${item.groupid}" />', '00000', '<c:out value="${item.groupname}"/>', '<c:out value="${urlView}"/>',  '<c:out value="${item.groupid}"/>','main');
          </c:forEach>
          document.write(d);
        </script>   
      </div>
    </td>
  </tr>
</table>
</body>
</html>

