<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/head.inc" %>
<jsp:include page="/inc/acl.jsp">
  <jsp:param name="PID" value="3C2B1A" />
</jsp:include>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title></title>
</head>

<frameset rows="*" cols="180,*" framespacing="0" frameborder="NO" border="1">
  <frame name="left" src="<%=contextPath%>/zifee/yxplangpinf.do?CMD=TREE">
  <frame name="main" src="<%=contextPath%>/zifee/yxplangroup/tip.jsp">
</frameset>
<noframes><body>
 frame is not supoorted by you browser.
</body></noframes>
</html>