<%@page language="java" contentType="text/html; charset=utf-8"%>
<%@page import="com.sunrise.jop.ui.User"%>
<%@page import="com.sunrise.jop.ui.struts2.WebConstant"%>
<%@page import="com.sunrise.boss.web.common.login.LoginUtils"%>
<%@page import="java.net.*"%>
<%
User user = (User) session.getAttribute(WebConstant.SESSION_ATTRIBUTE_USER);
if(user == null) {
	response.sendRedirect("/common/returnsys.html");
}
String targetUrl = request.getParameter("targetUrl");
targetUrl = URLDecoder.decode(targetUrl);
String system = "UAP";
String logid = LoginUtils.getLoginLogid(user).toString();
String oprcode = user.getOprcode();
String region = user.getCityid();
//请求地址：url?system=UAP&token=40012|CZPT&region=755
String param = "system=" +system+ "&token=" +logid+ "|" +oprcode+ "&region=" + region;
//节点、集团旧的集成方式：url?secretString=GMCC&staffNo=fsng&staffName=fsng&cityID=757 
String param_old ="secretString=GMCC&staffNo="+oprcode+"&staffName="+oprcode+"&cityID="+region+"&orgID=JFJM00000&sourceURL=&rootTicket=";
//暂时兼容新旧集成方式，等联调通过后删掉
param = param + "&" + param_old;
if(!targetUrl.endsWith("?")){
	if(targetUrl.indexOf("?")<0){
		targetUrl = targetUrl + "?";
	}else {
		targetUrl = targetUrl + "&";
	}
}

response.sendRedirect(targetUrl + param);
%>

