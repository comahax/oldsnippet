<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ page import="com.sunrise.boss.ui.commons.WebConstant"%>
<%@ page import="com.sunrise.boss.ui.commons.User"%>

<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/commons" prefix="s"%>
<%@ include file="/inc/listhead.inc"%>
<html>
	<head>
		<%
			String ID_1 = "CH_PW_REWARD||CH_PW_REWARD_PROVINCIAL";//省级酬金管理令牌
			String ID_2 = "CH_PW_REWARD||CH_PW_REWARD_CIVIC";//市级酬金管理令牌
		%>

		<%
				//	User user = (User) request.getSession().getAttribute(
				//	WebConstant.SESSION_ATTRIBUTE_USER);
			String urlParams = null;
		//	String attractid = request.getParameter("attractid");
		//	urlParams = "&_se_attractid="+attractid;
		//	pageContext.setAttribute("_se_attractid", attractid);
		//	pageContext.setAttribute("urlParams", urlParams);
		%>
		<link href="<%=contextPath%>/css/css_1/iframemenu.css" rel="stylesheet" type="text/css" media="all" />
	</head>
	<body>
		<c:set var="cmds" value="${requestScope.cmdState}"></c:set>
		<c:set var="framerewardid" value="${requestScope.rewardid}" />
		<div class="table_container">
			<div class="table_div">
				<table class="top_table">
					<tr>
						<td>
							星级酬金参数管理 
						</td>
					</tr>
				</table>
			</div>

			<div class="table_div">
				<table width="100%" class="error_text">
					<html:errors />
					<s:Msg />
				</table>
			</div>

			<div class="iframemenu">
				<script language="javascript">
		  addmenuleft();
		 	
		
		<s:RewardPurChk controlid="<%=ID_1%>">  addmenu('<%=contextPath%>/cms/stdrewardbs.do?CMD=<c:out value="${cmds}"/>&str=content&PK=<c:out value="${framerewardid}"/>','星级酬金上限设置');</s:RewardPurChk>
		<s:RewardPurChk controlid="<%=ID_2%>">  addmenu('<%=contextPath%>/cms/stdrewardbs.do?CMD=<c:out value="${cmds}"/>&str=content1&PK=<c:out value="${framerewardid}"/>','市公司星级酬金标准设置') </s:RewardPurChk>
		<s:RewardPurChk controlid="<%=ID_2%>">  addmenu('<%=contextPath%>/cms/stdrewardbs.do?CMD=<c:out value="${cmds}"/>&str=content2&PK=<c:out value="${framerewardid}"/>','市公司星级专营销售酬金标准设置') </s:RewardPurChk>
		<s:RewardPurChk controlid="<%=ID_2%>">  addmenu('<%=contextPath%>/cms/reward/creditstd/list.jsp','市公司积分星级酬金设置管理')</s:RewardPurChk>
		  addmenuright();
		  addmenumore();
		</script>
			</div>

			<div class="iframewindow" id="message">
    	 <iframe framespacing="0" frameborder="NO"  name="IFRM_MAIN" id="IFRM_MAIN" class="IFRM_MAIN_on" height="100%"></iframe>
	</div>
		</div>
	</body>
</html>  
