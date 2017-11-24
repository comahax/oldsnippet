<%@ page language="java" contentType="text/html;charset=gbk"%>
<%@ include file="/inc/listhead.inc" %>
<html>
<frameset rows="28,*" cols="*" framespacing="0" frameborder="no" border="0" id="mywin">
  <frame src="<%=contextPath %>/iframe/left_top.html" name="lefttopFrame" scrolling="no" noresize="noresize" id="lefttopFrame" title="topFrame" />
  <frame src="<%=contextPath %>/iframe/blank.jsp" name="leftmainFrame" scrolling="yes" id="leftmainFrame" title="mainFrame" />
</frameset>
<noframes>
</noframes>
</html>