<%@page contentType="text/html;charset=gbk"%>
<%@ include file="/inc/listhead.inc" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gbk" />
<title><s:i18n name="public"><s:text name="coms"/></s:i18n></title>
</head>

<frameset rows="*,1,*" frameborder="no" framespacing="0" id="contentframe">
	<frame src="<%=contextPath%>/communication/advinfo_list.do" scrolling="auto" noresize="noresize" id="contenttopFrame" title="topFrame" />
	<frame src="<%=contextPath%>/iframe/split.jsp" scrolling="no" noresize="noresize" id="contenttopFrame" title="topFrame" />
	<frame src="<%=contextPath%>/communication/chpwcomsadvinfo_cityList.do" scrolling="auto" noresize="noresize" id="contentbottomFrame" title="bottomFrame" />
</frameset>
<noframes>
<body>
</body>
</noframes>
</html>
