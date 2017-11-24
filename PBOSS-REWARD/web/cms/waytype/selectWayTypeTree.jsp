<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%
	String contextPath = request.getContextPath();
%>

<html>
<head>
<base target="_self"/>
<title>WayTypeTree</title>
<link rel="stylesheet" href="<%=contextPath%>/css/dtree.css"  type="text/css">
<script type="text/javascript" src="<%=contextPath%>/js/dtree.js"></script>

</head>
<body>
<table cellpadding=0 cellspacing=0 border=0 width=100% height=100%>
  <tr>
    <td align='left' valign='top' width="20%" height="100%">
      <div class="dtree">  
        <script type="text/javascript">
        	var contextPath = '<%=contextPath%>' + "/";
          d = new dTree('d');
          <c:forEach var="item" items="${requestScope.LIST.datas}" varStatus="status">
            d.add('<c:out value="${item.waytypecode}" />', '<c:out value="${item.uppercode}" />', '<c:out value="${item.waytypename}"/>', 'javascript:returnval(\'<c:out value='${item.waytypecode}|${item.waytypename}' />\')',  '<c:out value="${item.desp}"/>','');
          </c:forEach>
          document.write(d);
        </script>   
      </div>
    </td>
  </tr>
</table>
</body>
<script type="text/javascript" >
	function returnval(idName) {
		 var idNameArray = idName.split('|'); // ²ð´® add by gongyuan 
		 window.returnValue = idNameArray;
		 window.close();
	}
</script>
</html>