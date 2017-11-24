<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/head.inc" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title><bean:message bundle="saleway" key="titleList" /></title>
</head>

<frameset rows="*" cols="150,*" framespacing="0" frameborder="NO" border="1">
  <frame src="<%=contextPath%>/cms/saleway/leftFrame.jsp" name="left">
  <frame src="<%=contextPath%>/cms/saleway/saleway.do" name="mainContent">
</frameset>
<noframes><body>
 frame is not supoorted by you browser.
</body></noframes>
</html>
