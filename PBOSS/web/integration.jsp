<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>
<%@ page import="com.sunrise.jop.ui.User"%>
<%@ page import="com.sunrise.jop.ui.struts2.WebConstant"%>
<%
	User user = (User)request.getSession().getAttribute(WebConstant.SESSION_ATTRIBUTE_USER);
	String opercode = user.getOprcode();
	String opername = user.getOpername();
	String cityid = com.sunrise.jop.infrastructure.db.CityMappingUtil.getCityNo(user.getCityid());
	String wayid = user.getWayid();
	String secretString = "PBOSS-REWARD";
	String url = request.getParameter("targetUrl");
%>
<html>
<head>
<base target="_self"/>
<title>PBOSS</title>
<sj:head jqueryui="true" jquerytheme="cupertino" />
</head>
<body>
<form name="form1" method="POST" action="">
	<input type="hidden" name="opercode" value="<%=opercode%>">
	<input type="hidden" name="opername" value="<%=opername%>">
	<input type="hidden" name="cityid" value="<%=cityid%>">
	<input type="hidden" name="wayid" value="<%=wayid%>">
	<input type="hidden" name="secretString" value="<%=secretString%>">
	<div id="mydialog" align="center">
	</div>
</form>
</body>
</html>
<script language="javascript">
	$(document).ready(function () {
		$("#mydialog").dialog({
				height: 0,
				width: 300,
				title: '<img src="<%=contextPath%>/images/indicator.gif"/>  <font size="2">Loading...</font>',
				autoOpen: true,
				modal: true
			});
		document.form1.action="<%=url%>";
    	document.form1.submit();
	});
</script>
