<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc" %>

<html:html>
	<head>
		<title><bean:message bundle="public" key="choosedata"/></title>
		<base target="_self">
	</head>
	<body>		
		正在读取数据，请稍候...
		<form action="<%=contextPath%>/myzoom.do" name="formItem" method="POST" >
			<input type="hidden" name="definition" value="<%=request.getParameter("definition")%>"/>
			<input type="hidden" name="condition" value="<%=request.getParameter("condition")==null?"":request.getParameter("condition")%>"/>
			<input type="hidden" name="property" value="<%=request.getParameter("property")%>"/>
		</form>
	</body>
</html:html>
<script language="JavaScript" type="text/JavaScript">
	formItem.submit();
</script>
