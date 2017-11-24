<%@page contentType="text/html; charset=GBK"%>
<%@page import="com.sunrise.jop.ui.struts2.WebConstant"%>
<%@page import="com.sunrise.jop.ui.User"%>
<%@ include file="/inc/listhead.inc" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<%
	String wayid = ((User)session.getAttribute(WebConstant.SESSION_ATTRIBUTE_USER)).getWayid();
%>
<html>
  <head>
  </head>
 <frameset cols="200,*" frameborder="NO" border="0" framespacing="0">
  <frame src="<%=contextPath%>/channel/way_showWayTree.do?nonsense=1&waytype=AG|ET&waysubtype=DIS|GMPT|G100" name="leftFrame" scrolling="yes" noresize>
  <frame src="<%=contextPath%>/channel/saleway_list.do" name="mainFrame" scrolling="yes" >
</frameset>
<noframes><body>
 frame is not supoorted by you browser.
</body></noframes>
</html>