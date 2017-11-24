<%@ page language="java" contentType="text/html;charset=utf-8"%>
<%@ page  import="com.sunrise.jop.ui.component.ThemeSelector"%>
<%
	String contextPath = request.getContextPath();
	String currentTheme = "default";
	currentTheme = ThemeSelector.getCurrentTheme(request);
%>
<html>
<head>
<title>boss</title>
<script type="text/javascript" src="../js/menu.js"></script>
<link href="<%= contextPath %>/css/<%=currentTheme%>/<%=currentTheme%>/iframemenu.css" rel="stylesheet" type="text/css">
</head>
<body>
		
		
		
		<!--标签页区域开始-->
    		<div class="iframemenu">
			<script language="javascript">
			    addmenu("step/zxsj_2.jsp","实现设计");
			    addmenu("step/zxsj_3.jsp","目标客户群","");
			    addmenu("step/zxsj_4.jsp","方案渠道设计");
			    addmenu("step/zxsj_5.jsp","接触设置","");
			    addmenu("step/zxsj_6.jsp","营销指南");
			</script>
		</div>
		    <!--标签页区域结束-->
</body>
</html>