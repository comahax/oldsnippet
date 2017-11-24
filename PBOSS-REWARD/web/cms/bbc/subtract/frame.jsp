<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/head.inc"%>
<%@ page import="com.sunrise.boss.ui.commons.WebConstant"%>
<%@ page import="com.sunrise.boss.ui.commons.User"%>
<%@ page import="com.sunrise.boss.common.base.db.SessionFactoryRouter"%>
<%
	User user = (User)request.getSession().getAttribute( WebConstant.SESSION_ATTRIBUTE_USER);
	String cityid = SessionFactoryRouter.conversionCityid(user.getCityid());
	boolean RIGHT=false;
	if ("JM".equals(cityid)) RIGHT=true;
	
%>
<html>
	<head>
		<link href="<%=contextPath%>/css/css_1/iframemenu.css" rel="stylesheet" type="text/css" media="all" />
	</head>

	<body onload="loadforiframe();">
	<div class="table_container">
		
		<div class="iframemenu">
			<script language="javascript">
			<%if (RIGHT) {%>
			    addmenu('<%=contextPath%>/cms/bbc/subtract.do?CMD=LIST', '一次性支付酬金业务设置');
			    addmenu('<%=contextPath%>/cms/bbc/subtracti.do?CMD=LIST', '分月支付酬金业务设置');
			    addmenu('<%=contextPath%>/cms/bbc/subtracte.do?CMD=LIST', '内部员工号码设置');
			    addmenu('<%=contextPath%>/cms/bbc/subtractb.do?CMD=LIST', '黑名单号码设置');
			<%} else {%>
			    addmenu('<%=contextPath%>/cms/bbc/subtract/error.jsp', '没有操作权限');
			<%}%>
			</script>
		</div>
		
		
		
		 <div class="table_div">
        	<table class="table_style">
            <tr class="table_style_head">
       		
			<div class="iframewindow" id="message">
			<iframe framespacing="0" frameborder="NO" name="IFRM_MAIN" id="IFRM_MAIN" class="IFRM_MAIN_on" height="100%">
				
			</div>
			</tr>
			</table>
		
			</div>
		
		
	</div>
	<body>
</html>
