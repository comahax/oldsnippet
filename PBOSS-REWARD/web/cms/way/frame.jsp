<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/head.inc" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>渠道</title>
</head>

<frameset rows="*" cols="150,*" framespacing="0" frameborder="NO" border="1">
  <frame src="<%=contextPath%>/cms/way.do?CMD=TREE" name="left">
  <frame src="<%=contextPath%>/cms/way.do?CMD=LIST" name="mainContent">
</frameset>
<noframes><body>
 frame is not supoorted by you browser.
</body></noframes>
</html>
