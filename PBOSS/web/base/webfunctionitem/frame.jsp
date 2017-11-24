<%@page contentType="text/html; charset=GBK"%>
<%@ include file="/inc/listhead.inc" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>功能点管理</title>
  </head>
  
 <frameset cols="200,*" frameborder="NO" border="0" framespacing="0">
  <frame src="<%=contextPath%>/base/webfunctionitem_MenuTree.do?CMD=manageTree" name="leftFrame" scrolling="yes" noresize>
  <frame src="<%=contextPath%>/base/webfunctionitem_doListByParent.do?param._se_parentid=0" name="mainFrame" scrolling="yes" >
</frameset>
<noframes><body>
</body>
</html>