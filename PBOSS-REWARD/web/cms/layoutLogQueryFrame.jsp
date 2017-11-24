<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/commons" prefix="s"%>
<%@ include file="/inc/listhead.inc"%>
<%			
			pageContext.setAttribute("contextPath", contextPath);
			String ID_1 = "CH_PW_LAYOUT_LOGQUERY";
%>
<html>
	<head>
		<script type="text/javascript" language="javascript">
    var contextPath = "<%= contextPath %>";    
</script>
		<link href="<%=contextPath%>/css/css_1/iframemenu.css" rel="stylesheet" type="text/css" media="all" />
		<link href="<%=contextPath%>/css/css_1/button.css" rel="stylesheet" type="text/css" media="all" />
		<link href="<%=contextPath%>/css/css_1/form.css" rel="stylesheet" type="text/css" media="all" />
		<link href="<%=contextPath%>/css/css_1/table.css" rel="stylesheet" type="text/css" media="all" />
		<script type="text/javascript" src="<%=contextPath%>/js/baseframe.js"></script>
		<script type="text/javascript" src="<%=contextPath%>/js/pub/content.js"></script>

	</head>

	<body>
		<div class="table_container">
			<div class="table_div">
				<table class="top_table">
					<tr>
						<td>
							<bean:message bundle="layoutlogquery" key="layout" />
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

			<c:set var="defaultURL" value="${contextPath}/cms/layoutlog.do?CMD=LIST" />
			<div class="iframemenu">
				<script language="javascript">
		  
		  addmenuleft();
		  <s:PurChk2 controlid="<%=ID_1%>"> addmenu('<%=contextPath%>/cms/layoutlog.do?CMD=SHOW','<bean:message bundle="layoutlogquery" key="layoutlog"/>');</s:PurChk2>
		  addmenu('<%=contextPath%>/cms/buildplanlog.do?CMD=LIST','<bean:message bundle="buildplan" key="titleLog" />');
   		  addmenu('<%=contextPath%>/cms/buildwaylog.do?CMD=LIST','<bean:message bundle="buildway" key="titleLog" />'); 
   		  addmenu('<%=contextPath%>/cms/defineplanlog.do?CMD=LIST','<bean:message bundle="defineplan" key="titleLog" />'); 
   		  addmenu('<%=contextPath%>/cms/nexuslog.do?CMD=LIST','<bean:message bundle="nexus" key="titleLog" />');  
		  addmenuright();
		  addmenumore();
		</script>
			</div>

			<div class="iframewindow" id="message">
				
					<iframe framespacing="0" frameborder="NO" name="IFRM_MAIN" id="IFRM_MAIN" class="IFRM_MAIN_on" src="<c:out value='${defaultURL}'/>" height="100%"></iframe>
				
			</div>
		</div>
	</body>
</html>

