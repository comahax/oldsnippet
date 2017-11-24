<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ page import="java.util.List" %>
<%@ page import="com.sunrise.boss.common.base.db.DataPackage" %>
<%@ include file="/inc/listhead.inc" %>

<html>
<head>
<title>WayType</title>
<link rel="stylesheet" href="css/dtree.css"  type="text/css">
<script type="text/javascript" src="js/dtree.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=GBK" />
</head>

<body  onload="loadforiframe();">
<table cellpadding=0 cellspacing=0 border=0 width=100% height=100%>
  <tr>
    <td align='left' valign='top' width="30%" height="100%">
      <div class="dtree" style="overflow:auto;height:380px;width:240px;">  
        <script type="text/javascript">
        	contextPath = "<%=contextPath%>/";
          d = new dTree('d');
          d.add('-1A', '-1', '<bean:message bundle="waytype" key="waytypetree"/>', '');
          <%	
          	int size =((DataPackage)request.getAttribute("LIST")).getDatas().size();
          	if(size == 0 ) {          	
          %>
          	document.write( '<bean:message bundle="folder" key="nodata"/>');
          <% } //if end%>
          <c:forEach var="item" items="${requestScope.LIST.datas}" varStatus="status">
            <c:url value="/cms/waytype.do?CMD=VIEW" var="urlView">
              <c:param name="PK" value="${item.waytypecode}"/>
            </c:url>
            d.add('<c:out value="${item.waytypecode}" />A', '<c:out value="${item.uppercode}" />A', '<c:out value="${item.waytypename}"/>', '<c:out value="${urlView}"/>',  '<c:out value="${item.desp}"/>','mainContent');
          </c:forEach>
          document.write(d);
        </script>   
      </div>
    </td>
    <td align='middle' valign='top' width="70%" height="100%">
    	<iframe framespacing="0" frameborder="NO" Scrolling="auto" width="400" height="300" name="mainContent" id="IFRM_MAINCONTENT" src="<%=contextPath%>/cms/waytype.do?CMD=EDITNEW"></iframe>
    </td>
  </tr>
</table>
</body>
</html>

