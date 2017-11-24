<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>功能点管理</title>
  </head>
  
 <frameset cols="250,*" frameborder="NO" border="0" framespacing="0">
  <frame src="<%=contextPath%>/cms/cityrecord.do?CMD=Selectopntree3" name="leftFrame" scrolling="yes" noresize>
  <frame src="<%=contextPath%>/cms/cityrecord.do?CMD=Listwithtree" name="mainFrame" scrolling="yes" >
</frameset>
<body>
</body>
</html>