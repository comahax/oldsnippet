<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/head.inc" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>县公司管理</title>
</head>

<frameset rows="*" cols="150,*" framespacing="0" frameborder="NO" border="1">
  <frame src="<%=contextPath%>/cms/cntycompany/leftFrame.jsp" name="left" scrolling="auto">
  <frame src="<%=contextPath%>/cms/cntycompany.do?CMD=LIST" name="mainContent">
</frameset>
<noframes><body>
 frame is not supoorted by you browser.
</body></noframes>
</html>
