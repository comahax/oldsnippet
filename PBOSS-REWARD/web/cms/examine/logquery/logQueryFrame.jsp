<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/commons" prefix="s"%>
<%@ include file="/inc/listhead.inc"%>
<jsp:include page="/inc/acl.jsp">
	<jsp:param name="PID" value="2B1A6F" />
</jsp:include>
<%
			pageContext.setAttribute("contextPath", contextPath);
%>

<html>
	<head>
		<script type="text/javascript" language="javascript">
    var contextPath = "<%= contextPath %>";    
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
							<bean:message bundle="examine" key="logquery" />
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
				value="${contextPath}/cms/examine/examinelog.do?CMD=LIST" />
			<div class="iframemenu">
				<script language="javascript">
		  
		 	addmenuleft();
		  	  	addmenu('<%=contextPath%>/cms/examine/examinelog.do?CMD=LIST','<bean:message bundle="examinelog" key="titleList"/>');
		  	  	addmenu('<%=contextPath%>/cms/examine/coefrevisionlog.do?CMD=LIST','<bean:message bundle="coefrevisionlog" key="titleList"/>');
		  		addmenu('<%=contextPath%>/cms/examine/examinestdlog.do?CMD=LIST','<bean:message bundle="examinestdlog" key="titleList"/>'); 
		  		addmenu('<%=contextPath%>/cms/examine/exmnauditlog.do?CMD=LIST','<bean:message bundle="exmnauditlog" key="titleList"/>'); 
		  		addmenu('<%=contextPath%>/cms/examine/exmnitemlog.do?CMD=LIST','<bean:message bundle="exmnitemlog" key="titleList"/>'); 
		  		addmenu('<%=contextPath%>/cms/examine/exmnitemdtllog.do?CMD=LIST','<bean:message bundle="exmnitemdtllog" key="titleList"/>');
		 		addmenu('<%=contextPath%>/cms/examine/exmnperiodlog.do?CMD=LIST','<bean:message bundle="exmnperiodlog" key="titleList"/>');
		  		addmenu('<%=contextPath%>/cms/examine/itemgradedlog.do?CMD=LIST','<bean:message bundle="itemgradedlog" key="titleList"/>'); 
		  		addmenu('<%=contextPath%>/cms/examine/mappinglog.do?CMD=LIST','<bean:message bundle="mappinglog" key="titleList"/>'); 
		 		addmenu('<%=contextPath%>/cms/examine/oprnwayidlog.do?CMD=LIST','<bean:message bundle="oprnwayidlog" key="titleList"/>'); 
		  addmenuright();
		  addmenumore();
		</script>
			</div>

			<div class="iframewindow" id="message">
			
					<iframe framespacing="0" frameborder="NO" name="IFRM_MAIN"
						id="IFRM_MAIN" class="IFRM_MAIN_on"
						src="<c:out value='${defaultURL}'/>" height="100%"></iframe>
			</div>
		</div>
	</body>
</html>
