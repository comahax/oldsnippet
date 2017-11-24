<%@page contentType="text/html;charset=gbk"%>
<%@ include file="/inc/listhead.inc" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gbk" />
<title><s:i18n name="public"><s:text name="coms"/></s:i18n></title>
</head>

<frameset rows="66,*,6" cols="75" frameborder="no" marginwidth="0"   framespacing="0" id="myframe01">
	<frame src="<%=contextPath%>/base/functionitem_TopMenu.do" name="topFrame" scrolling="No" noresize="noresize" id="topFrame" title="topFrame" />
	<frameset rows="*" cols="180,*" framespacing="4" frameborder="yes" border="4" bordercolor="#C0D2EC"  id="myframe02">
		<frame src="<%=contextPath%>/iframe/left.jsp" scrolling="no" name="leftFrame">
		<!--frameset rows="*" cols="*" framespacing="4" frameborder="yes" border="4" bordercolor="#C0D2EC" name="middlewin"-->
		    	<frame src="<%=contextPath%>/iframe/menu.jsp" frameborder="no" scrolling="no" name="mainmenu">
		        <!--frame src="<%=contextPath%>/communication/advinfo_list.do" frameborder="no" scrolling="auto" name="maintop"-->
		<!--/frameset-->
	</frameset>
	<frame src="iframe/bottom.html" name="bottomFrame" scrolling="No"  framespacing="0"noresize="noresize" id="bottomFrame" title="bottomFrame" />
</frameset>
<noframes><body>
</body>
</noframes></html>
