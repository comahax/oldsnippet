<%@ page language="java" contentType="text/html;charset=utf-8"%>
<%@ page  import="com.sunrise.jop.ui.component.ThemeSelector"%>
<%
	String contextPath = request.getContextPath();
	String currentTheme = "default";
	currentTheme = ThemeSelector.getCurrentTheme(request);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<link href="<%= contextPath %>/css/<%=currentTheme%>/left.css" rel="stylesheet" type="text/css" />
</head>

<body leftmargin="0" topmargin="0" bottommargin="0" class="left_top_bj">
<div class="left_top"></div>
<div class="dtree_topimagebj">	
</div>
</body>
</html>
