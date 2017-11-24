<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ include file="/inc/listhead.inc" %>
<%@ page import="com.sunrise.jop.ui.User"%>
<%@ page import="com.sunrise.jop.ui.struts2.WebConstant"%>
<%
	User user = (User)request.getSession().getAttribute(WebConstant.SESSION_ATTRIBUTE_USER);
	String opercode = user.getOprcode();
	String opername = user.getOpername();
	String cityid = com.sunrise.jop.infrastructure.db.CityMappingUtil.getCityNo(user.getCityid());
	String wayid = user.getWayid();
	String secretString = "GMCC";
	String url = request.getParameter("targetUrl");
%>
<html>
<head>
<base target="_self"/>
<title>PBOSS</title>
</head>
<body>

<% //类似下面的地址 http://10.200.4.255:9081/jmbboss/Hand_Login2.jsp%>

<form name="form1" method="POST" action=""  target="_blank">
	<!-- 跳转到报表系统 -->
	<s:if test='%{#session["LOGIN_TYPE"] == "NOTBOSS"}'>
		<input type="hidden" name="staffNo" value='${sessionScope["PROV_REPORT_OPERCODE"]}'>
	</s:if>
	<s:else>
		<input type="hidden" name="staffNo" value="<%=opercode%>">
	</s:else>
	<input type="hidden" name="staffName" value="<%=opername%>">
	<input type="hidden" name="cityID" value="<%=cityid%>">
	<input type="hidden" name="orgID" value="<%=wayid%>">
	<input type="hidden" name="secretString" value="<%=secretString%>">
</form>
</body>
</html>
<script language="javascript" type="text/javascript">
	document.form1.action="<%=url%>";
	document.form1.submit();
</script>
