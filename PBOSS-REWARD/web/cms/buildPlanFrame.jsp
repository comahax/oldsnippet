<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ page import="org.apache.commons.lang.StringUtils"%>
<%@ page import="com.sunrise.boss.ui.commons.WebConstant"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/commons" prefix="s"%>
<%@ include file="/inc/listhead.inc"%>
<jsp:include page="/inc/acl.jsp">
	<jsp:param name="PID" value="2B1A6F" />
</jsp:include>
<%
	String ID_1 = "";
	String ID_2 = "";
	String ID_3 = "";
	pageContext.setAttribute("contextPath", contextPath);
	String parameter = request
			.getParameter(WebConstant.REQUEST_ATTRIBUTE_PK);
	String str_ne_planid = request.getParameter("_ne_planid") == null ? ""
			: request.getParameter("_ne_planid");
	String str_se_layoutid = request.getParameter("_se_layoutid") == null ? ""
			: request.getParameter("_se_layoutid");
	String strPara = "&_ne_planid=" + str_ne_planid + "&_se_layoutid="
			+ str_se_layoutid;
	String strPK = str_se_layoutid + "|" + str_ne_planid;
%>

<html>
	<head>
		<script type="text/javascript" language="javascript">
    var contextPath = "<%=contextPath%>";    
</script>
		<link href="<%=contextPath%>/css/css_1/iframemenu.css"
			rel="stylesheet" type="text/css" media="all" />
		<link href="<%=contextPath%>/css/css_1/button.css" rel="stylesheet"
			type="text/css" media="all" />
		<link href="<%=contextPath%>/css/css_1/form.css" rel="stylesheet"
			type="text/css" media="all" />
		<link href="<%=contextPath%>/css/css_1/table.css" rel="stylesheet"
			type="text/css" media="all" />
		<script type="text/javascript" src="<%=contextPath%>/js/baseframe.js"></script>
		<script type="text/javascript"
			src="<%=contextPath%>/js/pub/content.js"></script>

	</head>

	<body>
		<div class="table_container">
			<div class="table_div">
				<table class="top_table">
					<tr>
						<td>
							<bean:message bundle="buildplan" key="titleList" />
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

			<c:set var="defaultURL"
				value="${contextPath}/cms/buildway.do?CMD=LIST" />
			<div class="iframemenu">
				<script language="javascript">
		  
		  addmenuleft();
		  <s:PurChk controlid="<%=ID_1%>"> addmenu('<%=contextPath%>/cms/buildway.do?CMD=LIST<%=strPara%>','<bean:message bundle="buildway" key="titleList"/>'); </s:PurChk>
		  <s:PurChk controlid="<%=ID_1%>"> addmenu('<%=contextPath%>/cms/defineplan.do?CMD=LIST<%=strPara%>','<bean:message bundle="buildplan" key="titleList"/>'); </s:PurChk>
		  <s:PurChk controlid="<%=ID_1%>"> addmenu('<%=contextPath%>/cms/buildplan.do?CMD=EDIT&PK=<%=strPK%>&AUDIT=true','<bean:message bundle="buildplan" key="auditTitle" />'); </s:PurChk>
		  addmenuright();
		  addmenumore();
		</script>
			</div>

			<div class="iframewindow" id="message">
				<s:PurChk controlid="<%=ID_1%>">
					<iframe framespacing="0" frameborder="NO" name="IFRM_MAIN"
						id="IFRM_MAIN" class="IFRM_MAIN_on"
						src="<c:out value='${defaultURL}'/>" height="100%"></iframe>
				</s:PurChk>
			</div>
		</div>
	</body>
</html>
