<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/head.inc" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title></title>
</head>

<frameset cols="180,*" framespacing="0" frameborder="NO" border="1">
  <frame name="left" src="<%=contextPath%>/cms/waytype.do?CMD=LIST">
  <frame name="mainContent" src="<%=contextPath%>/cms/waytype.do?CMD=EDITNEW">
</frameset>
<noframes><body>
 frame is not supoorted by you browser.
</body></noframes>
</html>